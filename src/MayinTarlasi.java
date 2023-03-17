import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class MayinTarlasi {
    int satir;
    int sutun;
    int mayinSayisi;

    boolean isBomb;

    int [][] bombalar ;

    MayinTarlasi(int satir,int sutun){

        this.satir=satir;
        this.sutun=sutun;
        this.mayinSayisi=(int) (satir*sutun) /4;
        this.isBomb=false;
       this.bombalar=new int [satir][sutun];
                   }

            void run(){

                mayinOlustur();
                tablaBas();
               while (!isBomb){
                   Scanner scanner = new Scanner(System.in);

                   System.out.print("Satir ve Sutun Giriniz :  ");
                   String deger = scanner.nextLine();
                   String[] strArr = deger.split(",");
                   int[] intArr = new int[strArr.length];

                   for (int i = 0; i < strArr.length; i++) {
                       intArr[i] = Integer.parseInt(strArr[i].trim());
                   }

                   if(intArr[0]>this.satir || intArr[0]<0){
                       System.out.println("Gecerli bir satir degeri giriniz.");
                       continue;
                   }

                   if(intArr[1]>this.sutun || intArr[1]<0){
                       System.out.println("Gecerli bir sutun degeri giriniz.");
                       continue;
                   }

                   if(bombalar[intArr[0]][intArr[1]]==-1){
                       System.out.println("Camlak Comlek Patladi");
                       bombaliTablaBas();
                       isBomb=true;
                   }else {
                       bombalar[intArr[0]][intArr[1]]=1;
                       System.out.println("Survived!");
                       tablaBas();
                   }



               }

            }

    void mayinOlustur(){
        int boardMayin=0;
        Random rand=new Random();
        while (boardMayin<this.mayinSayisi){


           int mSatir=rand.nextInt(0,satir);
           int mSutun=rand.nextInt(0,sutun);

           bombalar[mSatir][mSutun]=-1;

            boardMayin++;

        }
    }

    void tablaBas(){
        for (int [] sutun:bombalar) {
            for(int i: sutun){
                 if(i==1){
                    System.out.print("s ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }



    void bombaliTablaBas(){
        for (int [] sutun:bombalar) {
            for(int i: sutun){
                if(i==-1){
                    System.out.print("* ");
                }else if(i==1){
                    System.out.print("s ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

}