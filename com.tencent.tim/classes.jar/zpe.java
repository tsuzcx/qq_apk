import QC.CommonRsp;
import QC.FaceRsp;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;

public class zpe
  extends aclh
{
  public zpe(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, FaceRsp paramFaceRsp)
  {
    if (paramFaceRsp != null)
    {
      int i = paramFaceRsp.authRet;
      localObject = "null";
      if (paramFaceRsp.stRet != null) {
        localObject = "ret:" + paramFaceRsp.stRet.ret + " auth:" + paramFaceRsp.authRet + " url:" + paramFaceRsp.url;
      }
      QLog.d("AvatarPendantActivity", 2, "onSetFace: " + paramBoolean + "," + (String)localObject);
      if (i == 0) {
        this.this$0.cep = 0;
      }
    }
    else
    {
      return;
    }
    this.this$0.cep = 1;
    Object localObject = new Intent(this.this$0, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramFaceRsp.url);
    this.this$0.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpe
 * JD-Core Version:    0.7.0.1
 */