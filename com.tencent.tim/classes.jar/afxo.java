import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class afxo
  implements View.OnClickListener
{
  afxo(DialogFromBottom paramDialogFromBottom) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      anot.a(null, "dc00898", "", "", "0X800AD9C", "0X800AD9C", 2, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxo
 * JD-Core Version:    0.7.0.1
 */