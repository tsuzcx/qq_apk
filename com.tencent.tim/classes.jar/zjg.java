import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class zjg
  implements View.OnClickListener
{
  zjg(zje paramzje, TroopLinkElement paramTroopLinkElement, zje.b paramb) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!zje.a(this.b))
    {
      localObject = new Intent(zje.a(this.b), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      zje.a(this.b).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = zje.b.a(this.jdField_a_of_type_Zje$b).isChecked();
    if (bool)
    {
      zje.a(this.b).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = zje.b.a(this.jdField_a_of_type_Zje$b);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      zje.a(this.b).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjg
 * JD-Core Version:    0.7.0.1
 */