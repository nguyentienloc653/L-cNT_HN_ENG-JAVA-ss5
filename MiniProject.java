import java.util.Arrays;
import java.util.Scanner;

public class MiniProject {
    public static void twoSum(Scanner sc) {
        System.out.print("Nhap so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap phan tu thu %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Nhap K: ");
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == k - arr[i]) {
                    System.out.printf("Cap so can tim la: %d, %d\n", arr[i], arr[j]);
                    return;
                }
            }
        }
        System.out.println("Khong co cap so can tim");
    }

    public static void moveZeroes(Scanner sc) {
        System.out.print("Nhap so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap phan tu thu %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
                pos++;
            }
        }
        System.out.printf("Mang sau khi di chuyen: %s\n", Arrays.toString(arr));
    }

    public static void validPalindrome(Scanner sc) {
        String str;
        System.out.print("Nhap chuoi muon kiem tra: ");
        str = sc.nextLine();
        str = str.toLowerCase().trim().replaceAll("[^a-z ]", "");
        StringBuilder strReverse = new StringBuilder(str).reverse();
        if (strReverse.toString().equals(str)) {
            System.out.println("Day la chuoi doi xung");
        } else {
            System.out.println("Day khong la chuoi doi xung");
        }
    }

    public static void reverseWords(Scanner sc) {
        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();
        // Loại bỏ khoảng trắng thừa
        str = str.trim().replaceAll("\\s+", " ");
        String[] words = str.split(" ");
        int start = 0;
        int end = words.length - 1;
        while (start <= end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        System.out.println(String.join(" ", words));
    }

    public static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

    public static void happyNumber(Scanner sc) {
        System.out.print("Nhap so can kiem tra: ");
        int n = Integer.parseInt(sc.nextLine());
        int first = n;
        int second = n;
        do {
            first = next(first);
            second = next(next(second));
        } while (first != second);
        if (second == 1) {
            System.out.println("Day la so hanh phuc");
        } else {
            System.out.println("Day khong phai so hanh phuc");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1: Tim cap so co tong bang K");
            System.out.println("2. Don so 0 ve cuoi");
            System.out.println("3: Kiem tra chuoi doi xung");
            System.out.println("4: Dao tu trong cau");
            System.out.println("5: So hanh phuc");
            System.out.println("6: Thoat");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    twoSum(sc);
                    break;
                case 2:
                    moveZeroes(sc);
                    break;
                case 3:
                    validPalindrome(sc);
                    break;
                case 4:
                    reverseWords(sc);
                    break;
                case 5:
                    happyNumber(sc);
                    break;
                case 6:
                    System.out.println("Thoat thanh cong");
                    break;
                default:
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}
