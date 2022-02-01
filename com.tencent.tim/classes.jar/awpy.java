import android.text.TextUtils;

public class awpy
  implements Cloneable
{
  public awpy.a a;
  public final String cSa;
  public final int cmdType;
  public final String fileId;
  public final String fileName;
  public final long fileSize;
  public String groupRootDirKey;
  public final String pDirKey;
  public final String sha;
  public final String thumbUrl;
  public final int type;
  
  private awpy(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    this.cmdType = paramInt1;
    this.fileId = paramString1;
    this.fileName = paramString2;
    this.sha = paramString3;
    this.fileSize = paramLong;
    this.type = paramInt2;
    this.cSa = paramString4;
    this.pDirKey = paramString5;
    this.thumbUrl = paramString6;
  }
  
  public static awpy a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString5)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)) || (paramLong < 0L)) {
      throw new IllegalArgumentException("The params fileName, pDirKey, fileId, sha and fileSize should be valid.");
    }
    return new awpy(paramInt1, paramString1, paramString2, paramString3.toLowerCase(), paramLong, paramInt2, paramString4, paramString5, paramString6);
  }
  
  public awpy a()
  {
    try
    {
      awpy localawpy = (awpy)super.clone();
      return localawpy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4))) {
      return;
    }
    this.a = new awpy.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public class a
    implements Cloneable
  {
    public String cookie;
    public String downloadUrl;
    public String fileVersion;
    public String serverName;
    public int serverPort;
    public String videoUrl;
    
    private a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.serverName = paramString1;
      this.serverPort = paramInt;
      this.cookie = paramString2;
      this.downloadUrl = paramString3;
      this.videoUrl = paramString4;
      this.fileVersion = paramString5;
    }
    
    public a a()
    {
      try
      {
        a locala = (a)super.clone();
        return locala;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpy
 * JD-Core Version:    0.7.0.1
 */