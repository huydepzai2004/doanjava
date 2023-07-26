package pxu.edu.vn.doan;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DoAn {
	static String[] tenmathang;
	static String[] donvi;
	static double[] soluong;
	static double[] giaban;
	static double[] thanhtien;
	static int n = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char key;
		do {
			inMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print(" ==> Xin Hãy Chọn Chức Năng Thực Hiện: ");
			key = sc.next().charAt(0);

			switch (key) {
			case '1':
				n = nhapSLMH();
				tenmathang = new String[n];
				donvi = new String[n];
				soluong = new double[n];
				giaban = new double[n];
				thanhtien = new double[n];
				System.out.print(n);
				nhapTVSL(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '2':
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '3':
				tinhthanhtien(soluong, giaban);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '4':
				sapxepTD(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '5':
				sapxepGD(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '6':
				timkiemMH(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '7':
				timkiemsoluong(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case 'x':
				n = 5;
				tenmathang = new String[n];
				donvi = new String[n];
				soluong = new double[n];
				giaban = new double[n];
				thanhtien = new double[n];
				System.out.print(n);
				nhapFile(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case 'z':
				
				xuatFile(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;

			case 'Q':
				System.out.println("||Bạn đã chọn kết thúc chương trình||");
				System.exit(0);
				break;
			case 'q':
				System.out.println("||Bạn đã chọn kết thúc chương trình||");
				System.exit(0);
				break;
			}
		} while (key != 'Q' || key != 'q');
	}

	public static void inMenu() {
		System.out.println("||||***************************=+=************************||");
		System.out.println("|| 1 : Nhập Dữ Liệu Mặt Hàng                              ||");
		System.out.println("|| 2 : In Danh Sách Mặt Hàng                              ||");
		System.out.println("|| 3 : Thành Tiền                                         ||");
		System.out.println("|| 4 : Sắp Xếp Mặt Hàng Theo Chiều Tăng Dần Của Giá Bán   ||");
		System.out.println("|| 5 : Sắp Xếp Mặt Hàng Theo Chiều Giảm Dần Của Thành Tiền||");
		System.out.println("|| 6 : Tìm Kiếm Mặt Hàng                                  ||");
		System.out.println("|| 7 : Tìm kiếm số lượng                                  ||");
		System.out.println("|| x : xuất  file                              		  ||");
		System.out.println("|| z : nhập file                             		  ||");
		System.out.println("|| Q/q : Thoát Chương Trình                	          ||");
		System.out.println("||********************************************************||");
	}

	public static int nhapSLMH() {
		try {

			int n;
			Scanner sc = new Scanner(System.in);

			do {
				System.out.println("Nhập Số Lượng Hàng Hoá ");
				n = sc.nextInt();

			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Trong Quá Trình Nhập!");
			return -1;
		}

	}

	public static void nhapTVSL(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		System.out.println("|==================================|");
		try {
			for (int i = 0; i < tenmathang.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhập Dữ Liệu Hàng Hoá:  " + (i + 1));
				System.out.print("Tên Mặt Hàng: ");
				tenmathang[i] = sc.nextLine();
				System.out.print("Đơn Vị: ");
				donvi[i] = sc.nextLine();
				System.out.print("Số Lượng: ");
				soluong[i] = sc.nextDouble();
				System.out.print("Giá Bán: ");
				giaban[i] = sc.nextDouble();
			}

		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Trong Quá Trình Nhập!");
		}
		System.out.println("|==================================|");
	}

	public static void inDSMH(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		System.out.println(
				"||_________________________________________________________________________________________________________________________||");
		System.out.println(
				"||------------------------------------------Danh Sách Mặt Hàng-------------------------------------------------------------||");
		for (int i = 0; i < tenmathang.length; i++) {
			System.out.println("||Tên Mặt Hàng: " + tenmathang[i] + "; Đơn Vị: " + donvi[i] + "; Số Lượng: "
					+ soluong[i] + "; Giá Bán: " + giaban[i] + "; Thành Tiền: " + thanhtien[i] + "    ||");
		}
		System.out.println(
				"||_________________________________________________________________________________________________________________________||");
	}

	public static double[] tinhthanhtien(double[] soluong, double[] giaban) {
		System.out.println("||			Thành Tiền		||");
		for (int i = 0; i < thanhtien.length; i++) {

			thanhtien[i] = (soluong[i] * giaban[i]);
		}
		return thanhtien;

	}

	public static void sapxepTD(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < giaban.length - 1; i++) {
			for (int j = i + 1; j < giaban.length; j++) {
				if (giaban[i] > giaban[j]) {
					// hoan vi DTB
					double tam = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam;
					// hoan vi Toan
					tam = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam;
					// hoan vi Van
					tam = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam;
					// hoan vi Anh
					String tam2 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam2;
					// hoan vi hoten
					String tam3 = tenmathang[i];
					tenmathang[i] = tenmathang[j];
					tenmathang[j] = tam3;
				}
			}
		}
	}

	public static void sapxepGD(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < thanhtien.length - 1; i++) {
			for (int j = i; j < thanhtien.length; j++) {
				if (thanhtien[i] < thanhtien[j]) {
					// hoán vị Số Lượng
					double tam = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam;
					// hoan vi Giá Bán
					tam = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam;
					// hoan vi thành tiền
					tam = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam;
					// hoan vi đơn vị
					String tam2 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam2;
					// hoan vi tên mặt hàng
					String tam3 = tenmathang[i];
					tenmathang[i] = tenmathang[j];
					tenmathang[j] = tam3;
				}
			}
		}
	}

	public static void timkiemMH(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String x;
		try {
			// do {
			System.out.print("tên mặt hàng cần tìm: ");
			x = sc.nextLine();
			// }while();

			for (int i = 0; i < tenmathang.length; i++) {
				if (tenmathang[i].equals(x)) {
					System.out.println(donvi[i] + " - đơn vị: " + tenmathang[i] + " - tên mặt hàng: " + soluong[i]
							+ " - so luong: " + giaban[i] + " - giá ban: " + thanhtien[i] + " - thành tiền: ");

					count = count + 1;
				}
			}
			if (count == 0) {
				System.out.println("KHONG TIM THAY");
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
	}

	public static void timkiemsoluong(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String x;
		try {
			// do {
			System.out.print("đơn vị cần tìm: ");
			x = sc.nextLine();
			// }while();

			for (int i = 0; i < donvi.length; i++) {
				if (donvi[i].equals(x)) {
					System.out.println(tenmathang[i] + " - tên mặt hàng: " + donvi[i] + " - đơn vị: " + soluong[i]
							+ " - so luong: " + giaban[i] + " - giá ban: " + thanhtien[i] + " - thành tiền: ");

					count = count + 1;
				}
			}
			if (count == 0) {
				System.out.println("KHONG TIM THAY");
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
	}

	public static void xuatFile(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập tên tập tin: ");
			String fileName = sc.nextLine();
			FileWriter writer = new FileWriter(fileName);
			for (int i = 0; i < tenmathang.length; i++) {
				writer.write(tenmathang[i] + "," + donvi[i] + "," + soluong[i] + "," + giaban[i] + "," + thanhtien[i]
						+ "\n");
			}
			writer.close();
			System.out.println("Đã nhập file thành công!");
		} catch (IOException e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập file!");
			e.printStackTrace();
		}
	}

	public static void nhapFile(String[] tenmathang, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập tên tập tin: ");
			String fileName = sc.nextLine();
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);
			int i = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");
				tenmathang[i] = data[0];
				donvi[i] = data[1];
				soluong[i] = Double.parseDouble(data[2]);
				giaban[i] = Double.parseDouble(data[3]);
				thanhtien[i] = Double.parseDouble(data[4]);
				i++;
			}
			fileScanner.close();
			System.out.println("Đã xuất file thành công!");
		} catch (FileNotFoundException e) {
			System.out.println("Đã sảy ra lỗi trong quá trình nhập file!");
			e.printStackTrace();
		}
	}
}
