import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.Map;

public class wht
  extends wje
{
  private String a;
  
  public wht()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    TransFileController localTransFileController = localQQAppInterface.getTransFileController();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new whu(this);
    localTransferRequest.mLocalPath = this.a;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196610;
    localTransferRequest.mSelfUin = localQQAppInterface.getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localTransFileController.transferAsync(localTransferRequest);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.a = ((String)a("UploadImageJob_in_image_file_path"));
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */