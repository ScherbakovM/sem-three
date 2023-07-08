package classes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ParcerData {

    private Long phone;

    private String fullName;
    private Date date = null;

    private String gender;

    private String surname;



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void parse(List<String> list) {
        for (String elem : list) {
            boolean equals = elem.toLowerCase().equals(elem.toUpperCase());
            if (equals & !elem.contains(".") & !elem.contains(",") & !elem.contains("-") & !elem.contains("/")) {
                setPhone(Long.parseLong(elem));
            } else if (equals & elem.contains("-") | elem.contains(".") | elem.contains(",") | elem.contains("/")) {
                stringToDate(elem);
            } else if (elem.length() == 1) {
                setGender(elem);
            } else addName(elem);

        }
    }

    public void stringToDate(String args) {
        if(args.contains(",") ) {
          args = args.replace(",", ".");
        }

        if(args.contains("-") ) {
            args = args.replace("-", ".");
        }

        if(args.contains("/") ) {
            args = args.replace("/", ".");
            System.out.println(args);
        }

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);
        try {
            String[] dateList = args.split("\\.");
            String month = dateList[1];
            String day = dateList[0];
            if (Integer.parseInt(day) > 31 || Integer.parseInt(day) < 0)
                System.out.println("дата рождения содержит недопустимое значение : " + day);
            ;
            String yeer = dateList[2];
            if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 0)
                System.out.println("дата рождения содержит недопустимое значение : " + month);
            setDate(formatter.parse(day + "." + month + "." + yeer));
        } catch (ParseException e) {
            System.out.println("дата должна быть в формате \"dd.MM.yyyy\" ");
        }
    }

    public void addName(String arg) {

        if (getFullName() == null) {
            setFullName(arg);
            setSurname(arg);
        } else setFullName(getFullName() + " " + arg);

    }


}

