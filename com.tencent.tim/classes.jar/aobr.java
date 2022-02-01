import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aobr
  implements View.OnClickListener
{
  aobr(aobp paramaobp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.V != null) {
      this.V.onClick(this.a, 0);
    }
    try
    {
      if (this.a.isShowing()) {
        this.a.dismiss();
      }
      label38:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobr
 * JD-Core Version:    0.7.0.1
 */