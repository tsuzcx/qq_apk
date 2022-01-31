import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wcm
  implements ActionSheet.OnButtonClickListener
{
  public wcm(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.ac) {
      return;
    }
    this.a.ac = true;
    if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.a.v(2131430031);
      paramInt = this.a.jdField_a_of_type_ArrayOfInt[0];
      if (paramInt == 0) {
        this.a.b(true, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.b(false, paramInt);
      continue;
      this.a.v(2131430031);
      this.a.b(true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcm
 * JD-Core Version:    0.7.0.1
 */