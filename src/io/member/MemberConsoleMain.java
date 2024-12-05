package io.member;

import io.member.impl.MemoryMemberRepository;

import java.util.Scanner;

public class MemberConsoleMain {

    private static final MemberRepository repository = new MemoryMemberRepository();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.회원등록 | 2.회원 목록 조회 | 3.종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> registerMember(sc);
                case 2 -> displayMembers();
                case 3 -> {
                    System.out.println("프로그램 종료");
                    return;
                }
                default -> System.out.println("잘못된 선택입니다. 다시 입력하세요");
            }
        }
    }

    private static void registerMember(Scanner sc) {
        System.out.print("ID 입력: ");
        String id = sc.nextLine();
        System.out.print("Name 입력: ");
        String name = sc.nextLine();
        System.out.print("Age 입력: ");
        int age = sc.nextInt();
        sc.nextLine();

        Member member = new Member(id, name, age);
        repository.add(member);
        System.out.println("회원이 성공적으로 등록되었습니다.");
    }

    private static void displayMembers() {
        repository.findAll().forEach(member -> System.out.printf("[ID: %s, Name: %s, Age: %d]\n]", member.getId(), member.getName(), member.getAge()));
    }
}
