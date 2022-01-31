import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.UiCallBack;

public abstract interface eas
{
  public abstract MessageRecord a(PicFowardInfo paramPicFowardInfo);
  
  public abstract MessageRecord a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void a(PicFowardInfo paramPicFowardInfo);
  
  public abstract void a(PicUploadInfo paramPicUploadInfo);
  
  public abstract void a(UiCallBack paramUiCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eas
 * JD-Core Version:    0.7.0.1
 */