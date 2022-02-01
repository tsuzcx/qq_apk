public class akuu
{
  public static final String bUm = acfp.m(2131708211);
  public static final String bUn = acfp.m(2131708210);
  public static final String bUo = acfp.m(2131708209);
  public static final String bUp = acfp.m(2131708213);
  public static final String bUq = acfp.m(2131708212);
  public static final String bUr = acfp.m(2131708214);
  public static final String[] gb = { "uin", "uin_type", "senderUin", "msg_type", "msgid", "msgTime", "is_send", "msgContent", "media_path", "mediaStatus" };
  public boolean cuF;
  public int dpp;
  public String mediaPath;
  public String msgContent;
  public String msgId;
  public int msgType;
  public String senderUin;
  public long time;
  public String uin;
  public int uinType;
  
  private akuu() {}
  
  public akuu(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    this.uin = paramString1;
    this.uinType = paramInt1;
    this.senderUin = paramString2;
    this.msgType = paramInt2;
    this.msgId = paramString3;
    this.time = paramLong;
    this.cuF = paramBoolean;
    this.msgContent = paramString4;
    this.mediaPath = paramString5;
    this.dpp = paramInt3;
  }
  
  public Object[] h()
  {
    return new Object[] { this.uin, Integer.valueOf(this.uinType), this.senderUin, Integer.valueOf(this.msgType), this.msgId, Long.valueOf(this.time), Boolean.valueOf(this.cuF), this.msgContent, this.mediaPath, Integer.valueOf(this.dpp) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(this.uin).append("; ");
    localStringBuilder.append(this.msgType).append("; ");
    localStringBuilder.append(this.senderUin).append("; ");
    localStringBuilder.append(this.msgId).append("; ");
    localStringBuilder.append(this.time).append(";");
    localStringBuilder.append(this.cuF).append("; ");
    localStringBuilder.append(this.msgContent).append("; ");
    localStringBuilder.append(this.mediaPath).append("; ");
    localStringBuilder.append(this.dpp).append(". ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuu
 * JD-Core Version:    0.7.0.1
 */