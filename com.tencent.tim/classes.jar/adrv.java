import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adrv
  implements View.OnClickListener
{
  adrv(adrt paramadrt) {}
  
  public void onClick(View paramView)
  {
    if ((adrt.a(this.a) == 0) && (!TextUtils.isEmpty(adrt.b(this.a)))) {
      adrt.a(this.a, null);
    }
    adrt.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrv
 * JD-Core Version:    0.7.0.1
 */