import com.tencent.mobileqq.app.QQAppInterface;

class vbb
  extends ulw
{
  vbb(vaw paramvaw) {}
  
  public void a()
  {
    wxe.b(vaw.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      wxe.e(vaw.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    uyz localuyz = (uyz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localuyz.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Vai.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localuyz.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Vai.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Vbg.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Vai.a("exp_story", 5);
    return;
    if (localuyz.c())
    {
      this.a.h();
      localuyz.a();
      this.a.jdField_a_of_type_Vai.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Vai.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbb
 * JD-Core Version:    0.7.0.1
 */