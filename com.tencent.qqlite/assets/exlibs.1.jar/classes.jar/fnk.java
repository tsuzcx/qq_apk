import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qqfav.widget.FavoriteActionSheet.Actions;
import java.util.List;

public class fnk
  implements ActionSheet.OnButtonClickListener
{
  public fnk(FavoriteActionSheet paramFavoriteActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions == null)) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (paramInt == 16) {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.d();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramInt == 32)
      {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.a();
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.b();
        FavoriteActionSheet.a(this.a);
      }
      else if (paramInt == 2)
      {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.e();
      }
      else if (paramInt == 4)
      {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.f();
      }
      else if (paramInt == 8)
      {
        this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.c();
        continue;
        paramInt -= this.a.jdField_a_of_type_JavaUtilList.size();
        if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.a((String)this.a.b.get(paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fnk
 * JD-Core Version:    0.7.0.1
 */