import UserGrowth.stNotificationRsp;

class ulg
  implements ujj
{
  ulg(ulf paramulf) {}
  
  public void a(uju paramuju)
  {
    upe.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramuju.b + " | resultBean:" + paramuju.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (this.a.a() == null)
    {
      upe.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramuju.a())
    {
      if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramuju.jdField_a_of_type_JavaLangObject;
        ujk localujk = paramuju.jdField_a_of_type_Ujk;
        if (localujk != null) {
          ugb.a().a(localstNotificationRsp.trace_id, localujk.a);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((umh)this.a.a()).a(localstNotificationRsp, localujk);
          return;
        }
        ((umh)this.a.a()).b(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
        return;
      }
      ((umh)this.a.a()).b(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
      upe.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramuju.b + " | " + paramuju.jdField_a_of_type_JavaLangString);
      return;
    }
    ((umh)this.a.a()).b(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulg
 * JD-Core Version:    0.7.0.1
 */