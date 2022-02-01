import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agoj
  implements View.OnClickListener
{
  agoj(agoh paramagoh, ampx paramampx) {}
  
  public void onClick(View paramView)
  {
    agog localagog = (agog)this.jdField_a_of_type_Ampx;
    localagog.cR(paramView);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367036);
    if (localCheckBox.getVisibility() == 0) {
      localCheckBox.setChecked(localagog.alP());
    }
    if (agoh.a(this.jdField_a_of_type_Agoh) != null) {
      agoh.a(this.jdField_a_of_type_Agoh).dix();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agoj
 * JD-Core Version:    0.7.0.1
 */