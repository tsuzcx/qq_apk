import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class wbw
  extends ShortVideoObserver
{
  public wbw(BlessResultActivity paramBlessResultActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, onCheckRealNameRsp in bless");
    }
    if ((paramBoolean) && (paramInt == RedBagVideoManager.a)) {
      DialogUtil.b(this.a.getActivity(), 0, null, this.a.getString(2131439096), 2131439098, 2131439097, new wbx(this), new wby(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbw
 * JD-Core Version:    0.7.0.1
 */