import java.util.Objects;

public class Entry {
    private String name;
    private int phone_number;
    private String mailing_address;
    private String email_address;

    public Entry(String name,int phone_number,String mailing_address,String email_address){
        this.name=name;
        this.phone_number=phone_number;
        this.mailing_address=mailing_address;
        this.email_address=email_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return  getPhone_number() == entry.getPhone_number() &&
                Objects.equals(getMailing_address(), entry.getMailing_address()) &&
                Objects.equals(getEmail_address(), entry.getEmail_address()) &&
                Objects.equals(getName(), entry.getName());
    }

    public String getName() {
        return name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getMailing_address() {
        return mailing_address;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setMailing_address(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
