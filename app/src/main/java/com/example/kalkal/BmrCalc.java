package com.example.kalkal;

public class BmrCalc {
    private int berat, tinggi, age; //Berat KG||Tinggi CM
    private double hasil;

    public void setAge(int age) {
        this.age = age;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    //Rumus
    public String rumusSatuMan(){//Mifflin-St Jeor Equation
        this.hasil = 10*berat+6.25*tinggi-5*age+5;
        return String.format("%.2f",this.hasil);
    }
    public String rumusSatuWoman(){//Mifflin-St Jeor Equation
        this.hasil = 10*berat+6.25*tinggi-5*age-161;
        return String.format("%.2f",this.hasil);
    }
    public String rumusDuaMan(){//Revised Harris-Benedict Equation
        this.hasil = 13.397*berat + 4.799*tinggi - 5.677*age + 88.362;
        return String.format("%.2f",this.hasil);
    }
    public String rumusDuaWoman(){//Revised Harris-Benedict Equation
        this.hasil = 9.247*berat + 3.098*tinggi - 4.330*age + 447.593;
        return String.format("%.2f",this.hasil);
    }
}
