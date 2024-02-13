package ornek3;

import java.util.Scanner;

public class basit_sikistirma {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("Sıkıştırma yapmak için 1, çözme yapmak için 2 girin.");
        int secim = scanner.nextInt();
        scanner.nextLine();

        if (secim == 1) {
            System.out.println("Sıkıştırılacak metni girin:");
            String metin = scanner.nextLine();
            String sikistirilmisMetin = sikistir(metin);
            System.out.println("Sıkıştırılmış metin:\n" + sikistirilmisMetin);
            System.out.println(metin.length() + " karakter " + sikistirilmisMetin.length() + " karaktere sıkıştırılmıştır.");
        } else if (secim == 2) {
            System.out.println("Çözülecek metni girin:");
            String sikistirilmisMetin = scanner.nextLine();
            String cozulmusMetin = metniCoz(sikistirilmisMetin);
            System.out.println("Çözülmüş metin:\n" + cozulmusMetin);
            System.out.println(sikistirilmisMetin.length() + " karakter çözülerek " + cozulmusMetin.length() + " karakter elde edilmiştir.");
        } else {
            System.out.println("Geçersiz seçim. Lütfen 1 veya 2 girin.");
        }

        scanner.close();
    }

    public static String sikistir(String metin) {
        StringBuilder sikistirilmisMetin = new StringBuilder();
        int uzunluk = metin.length();
        int sayac = 1;

        for (int i = 0; i < uzunluk - 1; i++) {
            if (metin.charAt(i) == metin.charAt(i + 1)) {
                sayac++;
            } else {
                sikistirilmisMetin.append(metin.charAt(i)).append(sayac);
                sayac = 1;
            }
        }

        sikistirilmisMetin.append(metin.charAt(uzunluk - 1)).append(sayac);

        return sikistirilmisMetin.toString();
    }

    public static String metniCoz(String sikistirilmisMetin) {
        StringBuilder cozulmusMetin = new StringBuilder();
        int uzunluk = sikistirilmisMetin.length();
        
        for (int i = 0; i < uzunluk; i++) {
            char karakter = sikistirilmisMetin.charAt(i);
            
            if (Character.isLetter(karakter)) {
                int tekrarSayisi = 1;
                
                if (i + 1 < uzunluk && Character.isDigit(sikistirilmisMetin.charAt(i + 1))) {
                    tekrarSayisi = 0;
                    while (i + 1 < uzunluk && Character.isDigit(sikistirilmisMetin.charAt(i + 1))) {
                        tekrarSayisi = tekrarSayisi * 10 + Character.getNumericValue(sikistirilmisMetin.charAt(i + 1));
                        i++;
                    }
                }
                
                for (int j = 0; j < tekrarSayisi; j++) {
                    cozulmusMetin.append(karakter);
                }
            } else {
                i++;
            }
        }

        return cozulmusMetin.toString();
    }
}
