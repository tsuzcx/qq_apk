import com.tencent.mobileqq.app.QQAppInterface;

class uws
  extends uhn
{
  uws(uwn paramuwn) {}
  
  public void a()
  {
    wsv.b(uwn.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      wsv.e(uwn.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    uuq localuuq = (uuq)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localuuq.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Uvz.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localuuq.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Uvz.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Uwx.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Uvz.a("exp_story", 5);
    return;
    if (localuuq.c())
    {
      this.a.h();
      localuuq.a();
      this.a.jdField_a_of_type_Uvz.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Uvz.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */