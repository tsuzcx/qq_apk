import android.widget.PopupWindow;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.b;
import com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.4.1;
import com.tencent.qphone.base.util.QLog;

public class saz
  implements PopViewAnimationDrawableHelper.b
{
  public saz(DetailBaseBlock.4.1 param1) {}
  
  public void onEnd()
  {
    QLog.d(sat.TAG, 2, "dismiss popupWindow priseTipView");
    if (this.a.a.this$0.mPopupWindow != null) {
      this.a.a.this$0.mPopupWindow.dismiss();
    }
  }
  
  public void onStart()
  {
    QLog.d(sat.TAG, 2, "showPraiseTipView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     saz
 * JD-Core Version:    0.7.0.1
 */