import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class ajev
{
  private MsgBackupUserData a;
  private int bizType;
  private String encryptKey;
  private int state;
  private String token;
  
  public ajev(int paramInt1, String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt2)
  {
    this.state = paramInt1;
    this.token = paramString1;
    this.encryptKey = paramString2;
    this.a = paramMsgBackupUserData;
    this.bizType = paramInt2;
  }
  
  public int Gi()
  {
    return this.bizType;
  }
  
  public MsgBackupUserData a()
  {
    return this.a;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupQryStateRsp--");
    localStringBuilder.append(",state:").append(this.state).append(",token:").append(this.token).append(",encryptKey:").append(this.encryptKey).append(",userData:").append(this.a).append(",bizType:").append(this.bizType);
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
    private int state;
    private String token;
    
    public a a(int paramInt)
    {
      this.state = paramInt;
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
    
    public ajev a()
    {
      return new ajev(this.state, this.token, this.encryptKey, this.a, this.bizType);
    }
    
    public a b(int paramInt)
    {
      this.bizType = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.encryptKey = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajev
 * JD-Core Version:    0.7.0.1
 */