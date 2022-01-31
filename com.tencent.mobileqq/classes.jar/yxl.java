import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.PopupMenu.1.1;

public class yxl
  implements View.OnClickListener
{
  yxl(yxk paramyxk, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yxk.a != null) {
      this.jdField_a_of_type_Yxk.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2);
    }
    paramView.post(new PopupMenu.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxl
 * JD-Core Version:    0.7.0.1
 */