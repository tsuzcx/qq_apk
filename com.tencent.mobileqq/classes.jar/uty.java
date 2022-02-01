import UserGrowth.stNotificationRsp;

class uty
  implements uqy
{
  uty(utx paramutx) {}
  
  public void a(urj paramurj)
  {
    uya.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramurj.b + " | resultBean:" + paramurj.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (this.a.a() == null)
    {
      uya.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramurj.a())
    {
      if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramurj.jdField_a_of_type_JavaLangObject;
        uqz localuqz = paramurj.jdField_a_of_type_Uqz;
        if (localuqz != null) {
          uvo.a().a(localstNotificationRsp.trace_id, localuqz.a);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((uuz)this.a.a()).a(localstNotificationRsp, localuqz);
          return;
        }
        ((uuz)this.a.a()).b(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
        return;
      }
      ((uuz)this.a.a()).b(paramurj.b, paramurj.jdField_a_of_type_JavaLangString);
      uya.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramurj.b + " | " + paramurj.jdField_a_of_type_JavaLangString);
      return;
    }
    ((uuz)this.a.a()).b(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */