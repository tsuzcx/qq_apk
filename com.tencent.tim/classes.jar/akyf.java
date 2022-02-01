import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface akyf
{
  public abstract MessageRecord a(im_msg_body.RichText paramRichText);
  
  public abstract void a(akyf.a parama);
  
  public abstract void b(akyf.a parama);
  
  public static class a
  {
    public long JW;
    public Object data;
    public String downUrl;
    public int errCode;
    public String errStr;
    public long groupFileID;
    public String md5;
    public String path;
    public int result;
    public long size;
    public String uuid;
    public int videoAttr;
    public int videoKandianType;
    
    public String toString()
    {
      return "SendResult{result=" + this.result + ", errCode=" + this.errCode + ", errStr='" + this.errStr + '\'' + ", path='" + this.path + '\'' + ", size=" + this.size + ", uuid='" + this.uuid + '\'' + ", md5='" + this.md5 + '\'' + ", groupFileID=" + this.groupFileID + ", thumbFileSize=" + this.JW + ", videoAttr=" + this.videoAttr + ", videoKandianType=" + this.videoKandianType + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akyf
 * JD-Core Version:    0.7.0.1
 */