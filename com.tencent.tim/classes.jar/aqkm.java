import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkm
  implements View.OnClickListener
{
  aqkm(aqkk paramaqkk, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideSoftInputFromWindow();
    if (this.val$pl != null)
    {
      this.val$pl.onClick(this.this$0, 0);
      if (this.this$0.brS)
      {
        if (!this.this$0.cUt) {
          break label100;
        }
        this.this$0.mWindowManager.removeView(this.this$0.b);
      }
    }
    for (;;)
    {
      this.this$0.brS = false;
      try
      {
        if (this.this$0.isShowing()) {
          this.this$0.dismiss();
        }
        label92:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label100:
        this.this$0.mWindowManager.removeView(this.this$0.c);
      }
      catch (Exception localException)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkm
 * JD-Core Version:    0.7.0.1
 */