import android.text.TextUtils;

public class afdv
{
  public String bDe;
  public int count;
  public long fileId;
  public long key;
  public String md5;
  public String url;
  public String uuid;
  
  public afdv() {}
  
  public afdv(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.count = paramInt;
  }
  
  public afdv(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.uuid = paramString1;
    this.md5 = paramString2;
    this.fileId = paramLong;
    this.url = paramString3;
    this.bDe = paramString4;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.uuid)) && (!TextUtils.isEmpty(this.md5));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoutuItem uuid:").append(this.uuid);
    localStringBuilder.append(", md5").append(this.md5);
    localStringBuilder.append(", fileId").append(this.fileId);
    localStringBuilder.append(", url").append(this.url);
    localStringBuilder.append(",key:").append(this.key);
    localStringBuilder.append(",count:").append(this.count);
    localStringBuilder.append(",picUin:").append(this.bDe);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdv
 * JD-Core Version:    0.7.0.1
 */