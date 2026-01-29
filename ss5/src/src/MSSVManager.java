import java.util.Scanner;

public class MSSVManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] mssv = new String[100];
        mssv[0] = "B1234567";
        mssv[1] = "B2345678";
        mssv[2] = "B3456789";
        int n = 3;
        String regex = "^B\\d{7}$";
        int choice;
        do {
            System.out.println("\n=== MENU MSSV ===");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.println("sinh vien thu " + (i + 1) + ": " + mssv[i]);
                    }
                    break;

                case 2:
                    if (n >= 100) break;
                    String newMSSV;
                    boolean exists;
                    do {
                        System.out.print("Nhập MSSV: ");
                        newMSSV = sc.nextLine();
                        exists = false;
                        for (int i = 0; i < n; i++) {
                            if (mssv[i].equalsIgnoreCase(newMSSV)) {
                                System.out.println("MSSV đã tồn tại, nhập lại!");
                                exists = true;
                                break;
                            }
                        }
                    } while (!newMSSV.matches(regex) || exists);

                    mssv[n++] = newMSSV;
                    System.out.print("Thêm sinh viên thành công");
                    break;

                case 3:
                    int idx = -1;
                    while (true) {
                        System.out.print("Nhập số thứ tự sinh viên cần sửa: ");
                        try {
                            idx = Integer.parseInt(sc.nextLine()) - 1;
                            if (idx >= 0 && idx < n) break;
                            else System.out.println("Số thứ tự không hợp lệ, thử lại!");
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập một số hợp lệ!");
                        }
                    }

                    do {
                        System.out.print("Nhập MSSV mới: ");
                        newMSSV = sc.nextLine();
                        exists = false;
                        if (!newMSSV.matches(regex)) {
                            System.out.println("MSSV không hợp lệ, nhập lại!");
                            exists = true;
                        } else {
                            for (int i = 0; i < n; i++) {
                                if (i != idx && mssv[i].equalsIgnoreCase(newMSSV)) {
                                    System.out.println("MSSV đã tồn tại, nhập lại!");
                                    exists = true;
                                    break;
                                }
                            }
                        }
                    } while (exists);

                    mssv[idx] = newMSSV;
                    System.out.println("Cập nhật sinh viên thành công!\n");
                    break;


                case 4: // XÓA
                    if(n == 0){
                        System.out.println("Danh sách trống, không thể xóa");
                        break;
                    }
                    System.out.print("Nhập số thứ tự sinh viên cần xóa: ");
                    idx = Integer.parseInt(sc.nextLine()) - 1;
                    if (idx >= 0 && idx < n) {
                        for (int i = idx; i < n - 1; i++) {
                            mssv[i] = mssv[i + 1];
                        }
                        mssv[n - 1] = null;
                        n--;
                        System.out.println("Xóa sinh viên thành công");
                    } else {
                        System.out.println("ID không hợp lệ");
                    }
                    break;

                case 5: // tìm kiếm
                    if(n == 0){
                        System.out.println("Danh sách trống, không thể tìm");
                        break;
                    }
                    System.out.print("Nhập MSSV cần tìm: ");
                    String find = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (mssv[i].equalsIgnoreCase(find)) {
                            System.out.println("Tìm thấy MSSV tại vị trí: " + (i + 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy MSSV");
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }
}
