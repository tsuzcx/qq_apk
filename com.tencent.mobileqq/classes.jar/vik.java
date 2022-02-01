import UserGrowth.stNotificationRsp;

class vik
  implements vfg
{
  vik(vij paramvij) {}
  
  public void a(vfr paramvfr)
  {
    vmp.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramvfr.b + " | resultBean:" + paramvfr.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (this.a.a() == null)
    {
      vmp.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramvfr.a())
    {
      if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramvfr.jdField_a_of_type_JavaLangObject;
        vfh localvfh = paramvfr.jdField_a_of_type_Vfh;
        if (localvfh != null) {
          vkc.a().a(localstNotificationRsp.trace_id, localvfh.a);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((vjm)this.a.a()).a(localstNotificationRsp, localvfh);
          return;
        }
        ((vjm)this.a.a()).b(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
        return;
      }
      ((vjm)this.a.a()).b(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
      vmp.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramvfr.b + " | " + paramvfr.jdField_a_of_type_JavaLangString);
      return;
    }
    ((vjm)this.a.a()).b(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vik
 * JD-Core Version:    0.7.0.1
 */