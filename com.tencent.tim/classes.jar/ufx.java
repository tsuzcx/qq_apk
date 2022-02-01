import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;

public class ufx
  implements CompoundButton.OnCheckedChangeListener
{
  public ufx(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = this.this$0.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildAt(i);
      if ((localObject instanceof FormSwitchItem))
      {
        localObject = (FormSwitchItem)localObject;
        if (paramCompoundButton != ((FormSwitchItem)localObject).a()) {}
      }
    }
    for (;;)
    {
      if ((localObject == null) || (!(((FormSwitchItem)localObject).getTag() instanceof zbm))) {}
      zbm localzbm;
      boolean bool;
      label109:
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i += 1;
        break;
        localzbm = (zbm)((FormSwitchItem)localObject).getTag();
        if (paramBoolean) {
          break label267;
        }
        bool = true;
        localzbm.bqy = bool;
        if (this.this$0.jdField_a_of_type_Zbq != null) {
          this.this$0.jdField_a_of_type_Zbq.a(localzbm, localzbm.bqy);
        }
        localObject = this.this$0.app;
        k = localzbm.id;
        i = j;
        if (localzbm.bqy) {
          i = 2;
        }
        anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X80097A0", "0X80097A0", k, 0, String.valueOf(i), "", "", "");
      } while (localzbm.id != 3);
      QQAppInterface localQQAppInterface = this.this$0.app;
      if (paramBoolean)
      {
        localObject = "0X8009C0A";
        label227:
        if (!paramBoolean) {
          break label280;
        }
      }
      label267:
      label280:
      for (String str = "0X8009C0A";; str = "0X8009C0B")
      {
        anot.a(localQQAppInterface, "dc00898", "", "", (String)localObject, str, localzbm.id, 0, "", "", "", "");
        break;
        bool = false;
        break label109;
        localObject = "0X8009C0B";
        break label227;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufx
 * JD-Core Version:    0.7.0.1
 */