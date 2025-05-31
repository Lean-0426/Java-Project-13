package com.Team13.accountingsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * AccountMenu 클래스는 accountName을 기준으로 계좌를 선택할 수 있는 콘솔 메뉴를 제공합니다.
 */
public class AccountMenu {

    /**
     * accountName 기준으로 그룹화된 계좌 중 하나를 선택하도록 콘솔 메뉴를 보여줍니다.
     *
     * @param records 전체 Record 목록
     * @return 선택된 계좌의 Record 리스트 (잘못된 선택 시 빈 리스트 반환)
     */
    public static List<Record> selectAccountByName(List<Record> records) {
        Scanner scanner = new Scanner(System.in);

        // 1. accountName 기준으로 그룹화
        Map<String, List<Record>> accountMap = records.stream()
                .collect(Collectors.groupingBy(Record::getAccountName));

        // 2. 정렬된 accountName 목록 출력
        List<String> accountNames = new ArrayList<>(accountMap.keySet());
        Collections.sort(accountNames);

        System.out.println("계좌를 선택하세요:");
        for (int i = 0; i < accountNames.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, accountNames.get(i));
        }

        // 3. 사용자 선택 입력 받기
        System.out.print("번호를 입력하세요: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return Collections.emptyList();
        }

        if (choice < 1 || choice > accountNames.size()) {
            System.out.println("선택한 번호가 유효하지 않습니다.");
            return Collections.emptyList();
        }

        String selectedAccount = accountNames.get(choice - 1);
        System.out.println("선택한 계좌: " + selectedAccount);

        return accountMap.get(selectedAccount);
    }
}
