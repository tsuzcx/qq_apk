import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.qphone.base.util.QLog;

public class acac
  extends aquy
{
  public acac(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (3 == paramaquz.getStatus()) {
      this.this$0.f(true, this.val$url, this.val$filePath, this.bkl);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "downloadZip onDone task.getStatus()->" + paramaquz.getStatus());
      }
      return;
      this.this$0.mState = 2;
      this.this$0.f(false, this.val$url, this.val$filePath, this.bkl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acac
 * JD-Core Version:    0.7.0.1
 */