import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class mqo
  implements mql
{
  public static String TAG = "RIJUGC.RIJUgcImageUploader";
  private mqk jdField_a_of_type_Mqk;
  private mqw jdField_a_of_type_Mqw;
  private QQAppInterface app;
  private Context context;
  private volatile boolean isCanceled;
  private volatile boolean isUploading;
  private String path;
  
  public mqo(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.path = paramString;
    this.context = paramContext;
    this.app = paramQQAppInterface;
  }
  
  public void a(mqk parammqk)
  {
    this.jdField_a_of_type_Mqk = parammqk;
  }
  
  public void cancel()
  {
    if (this.isUploading)
    {
      this.isCanceled = true;
      QLog.i(TAG, 1, "cancel, path=" + this.path);
      if (this.jdField_a_of_type_Mqw != null)
      {
        this.jdField_a_of_type_Mqw.cancel();
        this.jdField_a_of_type_Mqw.onDestroy();
      }
    }
  }
  
  public void upload()
  {
    QLog.i(TAG, 1, "upload, path=" + this.path);
    this.isUploading = true;
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqo
 * JD-Core Version:    0.7.0.1
 */