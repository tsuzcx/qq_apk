public class akwi
{
  public String bUx;
  public String bUy;
  public String countryCode;
  
  public akwi(String paramString1, String paramString2, String paramString3)
  {
    this.countryCode = paramString1;
    this.bUx = paramString2;
    this.bUy = paramString3;
  }
  
  public String toString()
  {
    return "PhoneInfo{countryCode='" + this.countryCode + '\'' + ", areaCode='" + this.bUx + '\'' + ", rawPhoneNum='" + this.bUy + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwi
 * JD-Core Version:    0.7.0.1
 */