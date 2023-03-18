
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int satir;
    int sutun;
    int mayinSayisi;

    boolean isWin;
    boolean isBomb;

    int[][] bombalar;

    int[][] basili;

    MayinTarlasi(int satir, int sutun) {

        this.satir = satir;
        this.sutun = sutun;
        this.mayinSayisi = (int) (satir * sutun) / 4;
        this.isBomb = false;
        this.bombalar = new int[satir][sutun];

        this.basili = new int[satir][sutun];
        this.isWin=false;

    }

    void run() {
        for (int[] sutuns : bombalar) {
            Arrays.fill(sutuns, 0);
        }
        for (int[] sutunz : basili) {
            Arrays.fill(sutunz, 0);
        }
        System.out.println("Mayin Tarlasi Oyununa Hos geldiniz");


        mayinOlustur();
        bastir();
        while (!isBomb && !isWin) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Satir ve Sutun Giriniz :  ");

            String deger = scanner.nextLine();
            String[] strArr = deger.split(",");
            int[] intArr = new int[strArr.length];
            int gSatir;
            int gSutun;
            try {
                for (int i = 0; i < strArr.length; i++) {
                    intArr[i] = Integer.parseInt(strArr[i].trim());
                }
                gSatir = intArr[0];
                gSutun = intArr[1];
            } catch (Exception e) {
                System.out.println("Sayi giriniz");
                continue;

            }

            if(isWinner()){
                System.out.println("KAZANDİNİZZ!!!");
              this.isWin=true;
              continue;
            }
            if (gSatir > this.satir || gSatir < 0) {
                System.out.println("Gecerli bir satir degeri giriniz.");
                continue;
            }

            if (gSutun > this.sutun || gSutun < 0) {
                System.out.println("Gecerli bir sutun degeri giriniz.");
                continue;
            }

            if (basili[gSatir][gSutun] == 1) {
                System.out.println("Bu noktayi daha once actiniz.");
                continue;
            }

                        if (bombalar[gSatir][gSutun] == -1) {
                System.out.println("Camlak Comlek Patladi");
                bastirMayinli();
                isBomb = true;
            } else {
                bombIhtimal(gSatir, gSutun, bombalar);
                basili[gSatir][gSutun] = 1;
                System.out.println("Survived!");
                bastir();
            }}
        }




    void bombIhtimal(int gSatir, int gSutun, int[][] bombalar) {
        if (gSatir == 0) {
            if (gSutun == 0) {
                if (bombalar[gSatir + 1][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            } else if (gSutun == bombalar[0].length - 1) {
                if (bombalar[gSatir ][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir+1 ][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir+1][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            } else {
                if (bombalar[gSatir][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            }
        } else if (gSutun == 0) {
            if (gSatir == bombalar.length - 1) {
                if (bombalar[gSatir - 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            } else {
                if (bombalar[gSatir][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun + 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            }
        } else if (gSutun == bombalar[0].length - 1) {
            if (gSatir == bombalar.length - 1) {
                if (bombalar[gSatir][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            } else {
                if (bombalar[gSatir][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir - 1][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
                if (bombalar[gSatir + 1][gSutun - 1] == -1) {
                    bombalar[gSatir][gSutun]++;
                }
            }
        } else if (gSatir == bombalar.length - 1) {
            if (bombalar[gSatir][gSutun + 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir][gSutun - 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun - 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun + 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }

        } else {
            if (bombalar[gSatir + 1][gSutun + 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun - 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir + 1][gSutun - 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun + 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir][gSutun + 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir][gSutun - 1] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir - 1][gSutun] == -1) {
                bombalar[gSatir][gSutun]++;
            }
            if (bombalar[gSatir + 1][gSutun] == -1) {
                bombalar[gSatir][gSutun]++;
            }
        }
    }

    boolean isWinner() {
        for (int[] i:basili  ) {
            for (int j:i  ) {
                if(j!=1){
                    return false;
                }
            }

    }
    return true;}

    void mayinOlustur() {
        int boardMayin = 0;
        Random rand = new Random();
        while (boardMayin < this.mayinSayisi) {


            int mSatir = rand.nextInt(0, satir);
            int mSutun = rand.nextInt(0, sutun);

            bombalar[mSatir][mSutun] = -1;

            boardMayin++;

        }
    }

    void bastir() {
        for (int i = 0; i < bombalar.length; i++) {
            for (int j = 0; j < bombalar[0].length; j++) {
                if (basili[i][j] == 1) {
                    System.out.print(bombalar[i][j] + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    void bastirMayinli() {
        for (int[] sunum : bombalar) {
            for (int i : sunum) {
                if (i == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

}
