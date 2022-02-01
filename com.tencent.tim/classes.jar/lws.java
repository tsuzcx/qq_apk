import android.widget.PopupWindow.OnDismissListener;

class lws
  implements PopupWindow.OnDismissListener
{
  lws(lwm paramlwm, autw paramautw) {}
  
  public void onDismiss()
  {
    this.b.i(1.0F);
    if (this.this$0.d.afO)
    {
      mye localmye = this.this$0.d.a();
      if (localmye != null)
      {
        localmye.resume();
        this.this$0.d.afO = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lws
 * JD-Core Version:    0.7.0.1
 */