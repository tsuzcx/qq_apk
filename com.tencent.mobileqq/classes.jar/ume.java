import UserGrowth.stNotificationRsp;

class ume
  implements ukd
{
  ume(umd paramumd) {}
  
  public void a(uko paramuko)
  {
    uqf.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramuko.b + " | resultBean:" + paramuko.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (this.a.a() == null)
    {
      uqf.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramuko.a())
    {
      if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramuko.jdField_a_of_type_JavaLangObject;
        uke localuke = paramuko.jdField_a_of_type_Uke;
        if (localuke != null) {
          unu.a().a(localstNotificationRsp.trace_id, localuke.a);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((unf)this.a.a()).a(localstNotificationRsp, localuke);
          return;
        }
        ((unf)this.a.a()).b(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
        return;
      }
      ((unf)this.a.a()).b(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
      uqf.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramuko.b + " | " + paramuko.jdField_a_of_type_JavaLangString);
      return;
    }
    ((unf)this.a.a()).b(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ume
 * JD-Core Version:    0.7.0.1
 */