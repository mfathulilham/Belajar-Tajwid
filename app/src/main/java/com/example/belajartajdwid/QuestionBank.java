package com.example.belajartajdwid;


public class QuestionBank {
    private String[] textQuestion = {
            //Level 1
            "Ada Berapa Jumlah Huruf Hijaiyah ?",
            "Ada Berapa Hukum Bacaan Nun Sukun dan Tanwin ?",
            "Ada Berapa Jenis Qalqalah ?",
            "Apa Yang Dimaksud Dengan Qalqalah ?",
            "Ada Berapa Hukum Bacaan Mim Sukun dan Tanwin ?",
            //Level 2
            "Yang Tidak Termasuk Hukum Bacaaan Nun Sukun ?",
            "Cara Membaca Hukum Bacaan Idzhar ?",
            "Yang Tidak Termasuk Hukum Bacaaan Mim Sukun?",
            "Cara Membaca Hukum Bacaan Idgam Mimi ?",
            "Huruf Qalqalah Yang Berada Di Tengah Bacaan Termasuk Qalqalah ?",
            //Level 3
            "Apabila Nun Sukun Bertemu Dengan Huruf Ta Maka Hukum Bacaannya ?",
            "Apabila Nun Sukun Bertemu Dengan Huruf Ba Maka Hukum Bacaannya ?",
            "Apabila Mim Sukun Bertemu Dengan Huruf Ta Maka Hukum Bacaannya ?",
            "Apabila Mim Sukun Bertemu Dengan Huruf Ba Maka Hukum Bacaannya ?",
            "Apabila Nun Sukun Bertemu Dengan Huruf Lam Maka Hukum Bacaannya ?",

    };
    private String[][] multiChoice = {
            //Level 1
            {"26", "27", "28", "29"},
            {"3", "4", "5", "6"},
            {"1", "2", "3", "4"},
            {"Memantul", "Mendengung", "Ringan", "Mengganti"},
            {"2", "3", "4", "5"},
            //Level 2
            {"Ikhfa", "Idgam", "Idzhar Syafawi", "Iqlab"},
            {"Mendengung", "Memantul", "Samar-Samar", "Jelas"},
            {"Ikhfa Syafawi", "Idgam Mimi", "Idzhar Syafawi", "Iqlab Khalqi"},
            {"Mendengung", "Memantul", "Ringan", "Mengganti"},
            {"Sugra", "Subra", "Kubra", "Kugra"},
            //Level 3
            {"Ikhfa", "Idzhar", "Ikhfa Syafawi", "Idzhar Syafawi"},
            {"Ikhfa", "Idgam", "Idzhar Syafawi", "Iqlab"},
            {"Ikhfa Syafawi", "Idgam Mimi", "Idzhar Syafawi", "Iqlab Khalqi"},
            {"Ikhfa Syafawi", "Idgam Mimi", "Idzhar Syafawi", "Iqlab Khalqi"},
            {"Idzhar", "Idgam Mimi", "Idgam Bigunnah", "Idgam Bilagunnah"}
    };
    private String[] mCorrectAnswer = {
            //Level 1
            "28", "4", "2", "Memantul", "3",
            //Level2
            "Idzhar Syafawi", "Jelas", "Iqlab Khalqi", "Mendengung", "Sugra",
            //Level3
            "Ikhfa", "Iqlab", "Idzhar Syafawi", "Ikhfa Syafawi", "Idgam Bilagunnah"
    };
    // pewarisan
    public String getQuestion(int a) {
        String question = textQuestion[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multiChoice[index][num];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswer[a];
        return answer;
    }

}
