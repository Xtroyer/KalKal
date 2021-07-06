package com.example.kalkal;

public class BmrCalc {
    private int berat, tinggi, age; //Berat KG||Tinggi CM
    private String hasil;

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
    public double rumusSatuMan(){//Mifflin-St Jeor Equation
        return 10*berat+6.25*tinggi-5*age+5;
    }
    public double rumusSatuWoman(){//Mifflin-St Jeor Equation
        return 10*berat+6.25*tinggi-5*age-161;
    }
    public double rumusDuaMan(){//Revised Harris-Benedict Equation
        return 13.397*berat + 4.799*tinggi - 5.677*age + 88.362;
    }
    public double rumusDuaWoman(){//Revised Harris-Benedict Equation
        return 9.247*berat + 3.098*tinggi - 4.330*age + 447.593;
    }
}
