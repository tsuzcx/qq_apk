import android.widget.PopupWindow.OnDismissListener;

class lwq
  implements PopupWindow.OnDismissListener
{
  lwq(lwm paramlwm, auua paramauua) {}
  
  public void onDismiss()
  {
    this.a.i(1.0F);
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
 * Qualified Name:     lwq
 * JD-Core Version:    0.7.0.1
 */