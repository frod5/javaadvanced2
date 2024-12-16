package webservice;

import io.member.Member;
import io.member.MemberRepository;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

import static util.MyLogger.log;

public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse response) {
        String str = "<html><body>" +
                "<h1>Member Manager</h1>" +
                "<ul>" +
                "<li><a href='/members'>Member List</a></li>" +
                "<li><a href='/add-member-form'>Add New Member</a></li>" +
                "</ul>";
        response.writeBody(str);
    }

    @Mapping("/members")
    public void members(HttpResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<h1>Member Manager</h1>");
        sb.append("<ul>");
        memberRepository.findAll().forEach(member -> {
            sb.append("<li>");
            sb.append("ID : " + member.getId());
            sb.append(", Name : " + member.getName());
            sb.append(", Age : " + member.getAge());
            sb.append("</li>");
        });
        sb.append("</ul>");
        sb.append("<a href='/'>Back to Home</a>");
        sb.append("</body></html>");
        response.writeBody(sb.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse response) {
        String body = "<html><body>" +
                "<h1>Add New Member</h1>" +
                "<form method='POST' action='/add-member'>" +
                "ID: <input type='text' name='id'/><br>" +
                "Name: <input type='text' name='name'/><br>" +
                "Age: <input type='text' name='age'/><br>" +
                "<input type='submit' value='Add'>" +
                "</form>" +
                "<a href='/'>Back to Home</a>" +
                "</body></html>";
        response.writeBody(body);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request, HttpResponse response) {
        log("MemberController.addMember");
        log("request: " + request);
        Member member = new Member(request.getParameter("id"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")));
        memberRepository.add(member);

        response.writeBody("<h1>save ok</h1>");
        response.writeBody("<a href='/'>Back to Home</a>");
    }
}
