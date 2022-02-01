import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vdt
  implements View.OnClickListener
{
  public vdt(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = HongbaoShowerActivity.a(this.this$0).isChecked();
    CheckBox localCheckBox = HongbaoShowerActivity.a(this.this$0);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdt
 * JD-Core Version:    0.7.0.1
 */