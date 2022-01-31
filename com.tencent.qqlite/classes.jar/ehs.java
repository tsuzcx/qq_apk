import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.widget.QQToast;

public class ehs
  implements Runnable
{
  public ehs(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a, "WebP格式的图片不支持原图发送，请使用标清质量来发送。", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehs
 * JD-Core Version:    0.7.0.1
 */