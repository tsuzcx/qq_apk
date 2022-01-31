import com.tencent.mobileqq.app.QQAppInterface;

class tia
  extends ssv
{
  tia(thv paramthv) {}
  
  public void a()
  {
    ved.b(thv.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      ved.e(thv.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    tfy localtfy = (tfy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localtfy.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Thh.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localtfy.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Thh.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Tif.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Thh.a("exp_story", 5);
    return;
    if (localtfy.c())
    {
      this.a.h();
      localtfy.a();
      this.a.jdField_a_of_type_Thh.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Thh.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */