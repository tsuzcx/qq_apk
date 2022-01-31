import android.view.View;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ghd
  implements ActionSheet.OnButtonClickListener
{
  public ghd(EditActivity paramEditActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (System.currentTimeMillis() - this.a.jdField_a_of_type_Long <= 1300L);
      this.a.e();
      return;
    }
    EditActivity.a(this.a).e = null;
    EditActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghd
 * JD-Core Version:    0.7.0.1
 */