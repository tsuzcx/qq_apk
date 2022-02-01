import com.tencent.mobileqq.app.QQAppInterface;

class wyi
  extends wjd
{
  wyi(wyd paramwyd) {}
  
  public void a()
  {
    yuk.b(wyd.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      yuk.e(wyd.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    wwg localwwg = (wwg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localwwg.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Wxp.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localwwg.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Wxp.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Wyn.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Wxp.a("exp_story", 5);
    return;
    if (localwwg.c())
    {
      this.a.g();
      localwwg.a();
      this.a.jdField_a_of_type_Wxp.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Wxp.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyi
 * JD-Core Version:    0.7.0.1
 */