import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class ajeo
{
  private MsgBackupUserData a;
  private int bizType;
  private String encryptKey;
  private String token;
  
  public ajeo(String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.token = paramString1;
    this.encryptKey = paramString2;
    this.a = paramMsgBackupUserData;
    this.bizType = paramInt;
  }
  
  public int Gi()
  {
    return this.bizType;
  }
  
  public MsgBackupUserData a()
  {
    return this.a;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupConfirmQrRsp--");
    localStringBuilder.append(",token:").append(this.token).append(",encryptKey:").append(this.encryptKey).append(",userData:").append(this.a).append(",bizType:").append(this.bizType);
    return localStringBuilder.toString();
  }
  
  public String xl()
  {
    return this.encryptKey;
  }
  
  public static class a
  {
    private MsgBackupUserData a;
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
      this.token = paramString;
      return this;
    }
    
    public ajeo a()
    {
      return new ajeo(this.token, this.encryptKey, this.a, this.bizType);
    }
    
    public a b(String paramString)
    {
      this.encryptKey = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajeo
 * JD-Core Version:    0.7.0.1
 */