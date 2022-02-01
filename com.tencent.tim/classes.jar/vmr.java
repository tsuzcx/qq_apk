import android.widget.ToggleButton;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity.b;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.a;
import java.util.List;

public class vmr
  implements algr
{
  public vmr(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton, Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if ((this.this$0.a(paramProfileLabelInfo.labelId, this.this$0.qV)) || (this.this$0.W(this.this$0.qV)))
      {
        if (this.this$0.W(this.this$0.qV)) {
          this.this$0.showToast(2131694943);
        }
        return;
      }
      anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
      this.this$0.qV.add(paramProfileLabelInfo);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a.c(paramProfileLabelInfo, paramToggleButton);
      this.this$0.Bn(this.this$0.qV.size());
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$b == null) {
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$b.notifyDataSetChanged();
      return;
      if (!this.this$0.a(paramProfileLabelInfo.labelId, this.this$0.qV)) {
        break;
      }
      this.this$0.a(paramProfileLabelInfo, this.this$0.qV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmr
 * JD-Core Version:    0.7.0.1
 */