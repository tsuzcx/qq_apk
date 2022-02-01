import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;

class umk
  implements PopupWindow.OnDismissListener
{
  umk(umj paramumj) {}
  
  public void onDismiss()
  {
    umj.a(this.a);
    unw.a().a(new WSCommentShowEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umk
 * JD-Core Version:    0.7.0.1
 */