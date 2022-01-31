import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.mobileqq.widget.QQToast;

public class vyl
  extends uhn
{
  public vyl(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
  public void b(int paramInt)
  {
    QQStoryBasicSettingsActivity.a(this.a);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1001: 
      this.a.a(0);
      return;
    case 2: 
      this.a.a(1);
      return;
    case 3: 
      this.a.a(2);
      return;
    }
    QQToast.a(this.a, alpo.a(2131711189), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Beps != null) {
      this.a.jdField_a_of_type_Beps.b();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Uhl.a(this.a.b(this.a.jdField_a_of_type_Int));
      this.a.jdField_a_of_type_Uhl.b(this.a.b(this.a.jdField_a_of_type_Int));
      if (this.a.jdField_a_of_type_Int == 2) {
        wta.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
      }
      do
      {
        return;
        if (this.a.jdField_a_of_type_Int == 0)
        {
          wta.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      } while (this.a.jdField_a_of_type_Int != 1);
      wta.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    QQToast.a(this.a, 2131695132, 0).b(this.a.getTitleBarHeight());
    this.a.a(this.a.b);
    this.a.jdField_a_of_type_Uhk.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vyl
 * JD-Core Version:    0.7.0.1
 */