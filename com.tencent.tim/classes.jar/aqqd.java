import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.FriendCloneSettingFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqqd
  extends aclh
{
  public aqqd(FriendCloneSettingFragment paramFriendCloneSettingFragment) {}
  
  public void aH(boolean paramBoolean, Object paramObject)
  {
    int i;
    if ((paramBoolean) && ((paramObject instanceof ArrayList)))
    {
      paramObject = (ArrayList)paramObject;
      i = ((Integer)paramObject.get(1)).intValue();
      if (i == 257) {
        if (((Boolean)paramObject.get(2)).booleanValue())
        {
          this.a.bV(1);
          this.a.ebA = 1;
        }
      }
    }
    for (;;)
    {
      this.a.eo.set(false);
      if (this.a.a != null) {
        this.a.a.dismiss();
      }
      return;
      this.a.bV(0);
      this.a.ebA = 0;
      continue;
      if (i == 258)
      {
        this.a.ebA = this.a.ebB;
        continue;
        this.a.bV(this.a.ebA);
        if (this.a.mActivity != null) {
          QQToast.a(this.a.mActivity, 1, acfp.m(2131706572), 0).show();
        }
        QLog.e("IphoneTitleBarFragment", 0, "onFriendCloneAuth: failed. ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqd
 * JD-Core Version:    0.7.0.1
 */