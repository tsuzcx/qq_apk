import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;

public class uha
  extends aklm
{
  public uha(AuthDevActivity paramAuthDevActivity) {}
  
  public void a(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    AuthDevActivity.a(this.this$0, paramSecureCheckResponse);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.this$0, paramString2, 0).show();
    QLog.e("Q.devlock.AuthDevActivity", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */