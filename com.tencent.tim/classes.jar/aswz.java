import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aswz
  implements View.OnClickListener
{
  aswz(aswu.b paramb) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = aswu.b.a(this.a);
    if (!aswu.b.a(this.a).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswz
 * JD-Core Version:    0.7.0.1
 */