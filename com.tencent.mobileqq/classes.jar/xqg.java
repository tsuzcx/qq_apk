import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.mobileqq.widget.QQToast;

public class xqg
  extends vzx
{
  public xqg(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
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
    QQToast.a(this.a, anvx.a(2131710265), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Biso != null) {
      this.a.jdField_a_of_type_Biso.b();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Vzv.a(this.a.b(this.a.jdField_a_of_type_Int));
      this.a.jdField_a_of_type_Vzv.b(this.a.b(this.a.jdField_a_of_type_Int));
      if (this.a.jdField_a_of_type_Int == 2) {
        ykv.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
      }
      do
      {
        return;
        if (this.a.jdField_a_of_type_Int == 0)
        {
          ykv.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      } while (this.a.jdField_a_of_type_Int != 1);
      ykv.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    QQToast.a(this.a, 2131694515, 0).b(this.a.getTitleBarHeight());
    this.a.a(this.a.b);
    this.a.jdField_a_of_type_Vzu.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqg
 * JD-Core Version:    0.7.0.1
 */