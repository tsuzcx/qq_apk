import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class ajer
{
  private MsgBackupUserData a;
  private String bQX;
  private int bizType;
  private String encryptKey;
  private String token;
  
  public ajer(String paramString1, String paramString2, String paramString3, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.bQX = paramString1;
    this.token = paramString2;
    this.encryptKey = paramString3;
    this.a = paramMsgBackupUserData;
    this.bizType = paramInt;
  }
  
  public int Gi()
  {
    return this.bizType;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupGetQrRsp--");
    localStringBuilder.append(",qr_sig:").append(this.bQX).append(",token:").append(this.token).append(",encryptKey:").append(this.encryptKey).append(",userData:").append(this.a).append(",bizType:").append(this.bizType);
    return localStringBuilder.toString();
  }
  
  public String xl()
  {
    return this.encryptKey;
  }
  
  public String xm()
  {
    return this.bQX;
  }
  
  public static class a
  {
    private MsgBackupUserData a;
    private String bQX;
    private int bizType;
    private String encryptKey;
    private String token;
    
    public a a(int paramInt)
    {
      this.bizType = paramInt;
      return this;
    }
    
    public a a(MsgBackupUserData paramMsgBackupUserData)
    {
      this.a = paramMsgBackupUserData;
      return this;
    }
    
    public a a(String paramString)
    {
      this.bQX = paramString;
      return this;
    }
    
    public a b(String paramString)
    {
      this.token = paramString;
      return this;
    }
    
    public ajer b()
    {
      return new ajer(this.bQX, this.token, this.encryptKey, this.a, this.bizType);
    }
    
    public a c(String paramString)
    {
      this.encryptKey = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajer
 * JD-Core Version:    0.7.0.1
 */