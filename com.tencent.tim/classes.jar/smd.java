import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class smd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  smd(slz paramslz) {}
  
  public void onGlobalLayout()
  {
    int i = this.this$0.Av.getMeasuredWidth();
    i = (int)(this.this$0.fw.getMeasuredWidth() - i - aqho.convertDpToPixel(this.this$0.mContext, 5.0F));
    this.this$0.Au.setMaxWidth(i);
    this.this$0.Au.setText(new aofe(this.this$0.a.cnZ, 16).k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smd
 * JD-Core Version:    0.7.0.1
 */