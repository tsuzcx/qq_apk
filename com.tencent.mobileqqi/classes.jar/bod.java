import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.biz.ui.PopupMenu;

public class bod
  implements View.OnClickListener
{
  public bod(PopupMenu paramPopupMenu, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenu.a != null) {
      this.jdField_a_of_type_ComTencentBizUiPopupMenu.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    paramView.post(new boe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bod
 * JD-Core Version:    0.7.0.1
 */