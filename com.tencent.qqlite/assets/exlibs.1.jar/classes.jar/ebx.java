import android.view.View;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ebx
  implements ActionSheet.OnButtonClickListener
{
  public ebx(EditActivity paramEditActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
        this.a.c = 0;
      } while (System.currentTimeMillis() - this.a.jdField_a_of_type_Long <= 1300L);
      this.a.d();
      return;
    }
    this.a.c = 1;
    EditActivity.a(this.a).e = null;
    EditActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebx
 * JD-Core Version:    0.7.0.1
 */