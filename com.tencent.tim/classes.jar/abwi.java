import android.text.TextUtils;

public class abwi
{
  private abws jdField_a_of_type_Abws;
  private abwt jdField_a_of_type_Abwt;
  private abwv jdField_a_of_type_Abwv;
  private String bik;
  private int mAppId;
  private int mTimeOut;
  
  private abwi(int paramInt1, String paramString, int paramInt2, abwv paramabwv, abwt paramabwt, abws paramabws)
  {
    this.mAppId = paramInt1;
    this.bik = paramString;
    this.mTimeOut = paramInt2;
    this.jdField_a_of_type_Abwv = paramabwv;
    this.jdField_a_of_type_Abwt = paramabwt;
    this.jdField_a_of_type_Abws = paramabws;
  }
  
  public abws a()
  {
    return this.jdField_a_of_type_Abws;
  }
  
  public abwt a()
  {
    return this.jdField_a_of_type_Abwt;
  }
  
  public abwv a()
  {
    return this.jdField_a_of_type_Abwv;
  }
  
  public String dn(int paramInt)
  {
    return this.jdField_a_of_type_Abws.dm(paramInt);
  }
  
  public int getAppId()
  {
    return this.mAppId;
  }
  
  public boolean hW(int paramInt)
  {
    return this.jdField_a_of_type_Abws.hW(paramInt);
  }
  
  public String mw()
  {
    return this.bik;
  }
  
  public int zV()
  {
    return this.mTimeOut;
  }
  
  public static class a
  {
    int appId;
    private abws jdField_b_of_type_Abws;
    private abwt jdField_b_of_type_Abwt;
    private abwv jdField_b_of_type_Abwv;
    String bik;
    int ctf = 30000;
    
    public a a(int paramInt)
    {
      this.appId = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.bik = paramString;
      return this;
    }
    
    public abwi a()
    {
      if (this.jdField_b_of_type_Abwv == null) {
        this.jdField_b_of_type_Abwv = new abwr();
      }
      if (this.jdField_b_of_type_Abwt == null) {
        this.jdField_b_of_type_Abwt = new abwq();
      }
      if (this.jdField_b_of_type_Abws == null) {
        this.jdField_b_of_type_Abws = new abwg();
      }
      if (this.appId == 0) {
        throw new IllegalArgumentException("appId required.");
      }
      if (TextUtils.isEmpty(this.bik)) {
        throw new IllegalArgumentException("current account uid is required.");
      }
      return new abwi(this.appId, this.bik, this.ctf, this.jdField_b_of_type_Abwv, this.jdField_b_of_type_Abwt, this.jdField_b_of_type_Abws, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwi
 * JD-Core Version:    0.7.0.1
 */