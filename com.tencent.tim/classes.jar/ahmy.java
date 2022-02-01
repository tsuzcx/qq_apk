import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import mqq.app.QQPermissionCallback;

class ahmy
  implements QQPermissionCallback
{
  ahmy(ahmx paramahmx, FaceDetectForThirdPartyManager.AppConf paramAppConf) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.bSZ();
    aqha.a(DeleteFaceFragment.a(this.a.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeleteFaceFragment.a(this.a.a, this.a.bKX, this.a.val$openId, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmy
 * JD-Core Version:    0.7.0.1
 */