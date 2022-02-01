import com.tencent.mobileqq.app.QQAppInterface;

class wun
  extends wfi
{
  wun(wui paramwui) {}
  
  public void a()
  {
    yqp.b(wui.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      yqp.e(wui.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    wsl localwsl = (wsl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localwsl.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Wtu.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localwsl.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Wtu.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Wus.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Wtu.a("exp_story", 5);
    return;
    if (localwsl.c())
    {
      this.a.g();
      localwsl.a();
      this.a.jdField_a_of_type_Wtu.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Wtu.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */