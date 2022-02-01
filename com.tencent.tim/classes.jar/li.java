import com.google.zxing.client.android.wifi.ParsedResultType;

public final class li
  extends lh
{
  private final String eM;
  private final boolean hidden;
  private final String password;
  private final String ssid;
  
  public li(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(ParsedResultType.WIFI);
    this.ssid = paramString2;
    this.eM = paramString1;
    this.password = paramString3;
    this.hidden = paramBoolean;
  }
  
  public String X()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    a(this.ssid, localStringBuilder);
    a(this.eM, localStringBuilder);
    a(this.password, localStringBuilder);
    a(Boolean.toString(this.hidden), localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String ac()
  {
    return this.eM;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     li
 * JD-Core Version:    0.7.0.1
 */