import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aobq
  implements View.OnClickListener
{
  aobq(aobp paramaobp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.U != null) {
      this.U.onClick(this.a, 1);
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
 * Qualified Name:     aobq
 * JD-Core Version:    0.7.0.1
 */