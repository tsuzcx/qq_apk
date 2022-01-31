import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;

public class ujt
  extends ssv
{
  public ujt(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
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
    bcql.a(this.a, ajya.a(2131710817), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Bcqi != null) {
      this.a.jdField_a_of_type_Bcqi.b();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Sst.a(this.a.b(this.a.jdField_a_of_type_Int));
      this.a.jdField_a_of_type_Sst.b(this.a.b(this.a.jdField_a_of_type_Int));
      if (this.a.jdField_a_of_type_Int == 2) {
        vei.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
      }
      do
      {
        return;
        if (this.a.jdField_a_of_type_Int == 0)
        {
          vei.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      } while (this.a.jdField_a_of_type_Int != 1);
      vei.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    bcql.a(this.a, 2131694975, 0).b(this.a.getTitleBarHeight());
    this.a.a(this.a.b);
    this.a.jdField_a_of_type_Sss.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujt
 * JD-Core Version:    0.7.0.1
 */