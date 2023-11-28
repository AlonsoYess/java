package BEAN;
public class Employee {
    private int EmployeeId;
    private String FirstName;
    private String Title;
    private int ReportsTo;
    private String BirthDate;
    private String HireDate;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Fax;
    private String Email;

    public Employee() {
    }

    public Employee(int EmployeeId, String FirstName, String Title, int ReportsTo, String BirthDate, String HireDate, String Address, String City, String State, String Country, String PostalCode, String Phone, String Fax, String Email) {
        this.EmployeeId = EmployeeId;
        this.FirstName = FirstName;
        this.Title = Title;
        this.ReportsTo = ReportsTo;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Phone = Phone;
        this.Fax = Fax;
        this.Email = Email;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getReportsTo() {
        return ReportsTo;
    }

    public void setReportsTo(int ReportsTo) {
        this.ReportsTo = ReportsTo;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    @Override
    public String toString() {
        return getFirstName();
    }
}
