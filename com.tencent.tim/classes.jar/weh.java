import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.TroopShortcutbarFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class weh
  extends appa
{
  TroopShortcutbarFragment a;
  
  public weh(QQAppInterface paramQQAppInterface, TroopShortcutbarFragment paramTroopShortcutbarFragment)
  {
    super(paramQQAppInterface);
    this.a = paramTroopShortcutbarFragment;
  }
  
  protected void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    boolean bool = false;
    if ((paramLong1 == this.a.mTroopCode) && (!paramBoolean))
    {
      QQToast.a(this.a.mActivity, acfp.m(2131698437), 0).show(this.a.mActivity.getTitleBarHeight());
      TroopShortcutbarFragment localTroopShortcutbarFragment = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      localTroopShortcutbarFragment.yh(bool);
    }
  }
  
  protected void ab(long paramLong, boolean paramBoolean)
  {
    if ((paramLong == this.a.mTroopCode) && (paramBoolean)) {
      this.a.yh(false);
    }
  }
  
  protected void i(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramLong == this.a.mTroopCode)
    {
      if (!paramBoolean) {
        QQToast.a(this.a.mActivity, acfp.m(2131698437), 0).show(this.a.mActivity.getTitleBarHeight());
      }
      TroopShortcutbarFragment localTroopShortcutbarFragment = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      localTroopShortcutbarFragment.yh(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     weh
 * JD-Core Version:    0.7.0.1
 */