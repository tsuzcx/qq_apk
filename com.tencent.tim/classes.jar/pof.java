import com.tencent.biz.qqstory.base.ErrorMessage;

public class pof
{
  public String atV;
  public int bjz;
  public String cdnUrl;
  public ErrorMessage e = new ErrorMessage();
  public String fileId;
  public String fileKey;
  
  public String toString()
  {
    return "UploadResult{errorMessage=" + this.e + ", fileKey='" + this.fileKey + '\'' + ", fileId='" + this.fileId + '\'' + ", uploadServerIp='" + this.atV + '\'' + ", mLastUploadOffset='" + this.bjz + '\'' + ", cdnUrl='" + this.cdnUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pof
 * JD-Core Version:    0.7.0.1
 */