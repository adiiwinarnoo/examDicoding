package com.example.sharingyuk.model;

import com.example.sharingyuk.R;

import java.util.ArrayList;

public class DataMentor {

    private static String [] nama = {
        "Adi Winarno",
        "Edi Winarno",
        "Yazid Daulay",
        "Fitri Lestari",
        "Arief Aly",
        "Artyas Dwi",
        "Nadila Pilar Kencana",
        "Muhammad Chalik",
        "Deva Alfian",
        "Muhammad Rama"
    };

    private static String[] bidang = {
            "Android Developer",
            "Android Developer",
            "Laravel Fundamental",
            "Fullstack Web Developer",
            "Backend Android Developer",
            "UI Design",
            "JavaScript",
            "UX Design",
            "Backend Web Developer",
            "Senior Web Developer",
            "Frontend Web Developer"
    };
    private static String[] alamat = {
            "Perum Rajawali City No.26",
            "Perum Rajawali City NO.27",
            "Perum 4 Jaya Katwang",
            "Perum Rajeg Sukatani",
            "Pinang Jaya",
            "Perum Taman Buah 2",
            "Balaraja No.26",
            "Perum BSD City",
            "Perum Mustika Tigaraksa",
            "Cikande"
    };

    private static int [] photo = {
            R.drawable.adi,
            R.drawable.profile,
            R.drawable.tiga,
            R.drawable.lima,
            R.drawable.dua,
            R.drawable.empat,
            R.drawable.satu,
            R.drawable.enam,
            R.drawable.tujuh,
            R.drawable.delapan,

          };

    public static ArrayList<Mentor> getlist(){
        ArrayList<Mentor> list = new ArrayList<>();
        for (int position = 0; position<nama.length;position++){
            Mentor mentor = new Mentor();
            mentor.setNama(nama[position]);
            mentor.setBidang(bidang[position]);
            mentor.setAlamat(alamat[position]);
            mentor.setPhoto(photo[position]);
            list.add(mentor);
        }
        return list;
    }
}
