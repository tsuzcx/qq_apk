import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;

class vak
  implements PopupWindow.OnDismissListener
{
  vak(vaj paramvaj) {}
  
  public void onDismiss()
  {
    vaj.a(this.a);
    vbw.a().a(new WSCommentShowEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vak
 * JD-Core Version:    0.7.0.1
 */