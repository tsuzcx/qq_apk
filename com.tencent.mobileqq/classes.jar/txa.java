import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;

public class txa
  extends sgc
{
  public txa(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
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
    bbmy.a(this.a, ajjy.a(2131645018), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Bbmv != null) {
      this.a.jdField_a_of_type_Bbmv.b();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Sga.a(this.a.b(this.a.jdField_a_of_type_Int));
      this.a.jdField_a_of_type_Sga.b(this.a.b(this.a.jdField_a_of_type_Int));
      if (this.a.jdField_a_of_type_Int == 2) {
        urp.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
      }
      do
      {
        return;
        if (this.a.jdField_a_of_type_Int == 0)
        {
          urp.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      } while (this.a.jdField_a_of_type_Int != 1);
      urp.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    bbmy.a(this.a, 2131629297, 0).b(this.a.getTitleBarHeight());
    this.a.a(this.a.b);
    this.a.jdField_a_of_type_Sfz.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txa
 * JD-Core Version:    0.7.0.1
 */