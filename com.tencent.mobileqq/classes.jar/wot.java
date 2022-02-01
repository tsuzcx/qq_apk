import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class wot
  extends vzx
{
  wot(woo paramwoo) {}
  
  public void a()
  {
    ykq.b(woo.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      ykq.e(woo.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    wmr localwmr = (wmr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    if (localwmr.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Woa.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localwmr.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Woa.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Woy.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Woa.a("exp_story", 5);
    return;
    if (localwmr.c())
    {
      this.a.g();
      localwmr.a();
      this.a.jdField_a_of_type_Woa.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Woa.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wot
 * JD-Core Version:    0.7.0.1
 */