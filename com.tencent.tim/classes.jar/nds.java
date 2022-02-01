import android.widget.PopupWindow.OnDismissListener;

class nds
  implements PopupWindow.OnDismissListener
{
  nds(ndi paramndi) {}
  
  public void onDismiss()
  {
    ndi.a(this.this$0).i(1.0F);
    if (this.this$0.afO)
    {
      this.this$0.a.resume();
      this.this$0.afO = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nds
 * JD-Core Version:    0.7.0.1
 */