import com.tencent.mobileqq.app.QQAppInterface;

class tid
  extends ssy
{
  tid(thy paramthy) {}
  
  public void a()
  {
    veg.b(thy.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      veg.e(thy.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    tgb localtgb = (tgb)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localtgb.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Thk.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localtgb.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Thk.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Tii.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Thk.a("exp_story", 5);
    return;
    if (localtgb.c())
    {
      this.a.h();
      localtgb.a();
      this.a.jdField_a_of_type_Thk.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Thk.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tid
 * JD-Core Version:    0.7.0.1
 */