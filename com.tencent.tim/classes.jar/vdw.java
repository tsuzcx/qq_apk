import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vdw
  extends acgf
{
  public vdw(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = ((HotChatManager)this.a.app.getManager(60)).a(this.a.mTroopUin);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.memo = this.a.aND;
        paramArrayOfByte.memoUrl = this.a.aNE;
        paramArrayOfByte.memoShowed = false;
      }
      QQToast.a(this.a, 2, acfp.m(2131707195), 0).show(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = acfp.m(2131707189);
    if (paramInt == 1288) {
      paramArrayOfByte = acfp.m(2131707193);
    }
    QQToast.a(this.a, 1, paramArrayOfByte, 0).show(this.a.getTitleBarHeight());
  }
  
  public void e(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetUserCreateHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString2);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString1 = ((HotChatManager)this.a.app.getManager(60)).a(this.a.mTroopUin);
      if (paramString1 != null)
      {
        paramString1.memo = this.a.aND;
        paramString1.memoUrl = this.a.aNE;
        paramString1.memoShowed = false;
      }
      QQToast.a(this.a, 2, acfp.m(2131707188), 0).show(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = acfp.m(2131707191);
    if (paramInt == 1282) {
      paramString1 = acfp.m(2131707196);
    }
    QQToast.a(this.a, 1, paramString1, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdw
 * JD-Core Version:    0.7.0.1
 */