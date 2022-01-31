import UserGrowth.stNotificationRsp;

class tiq
  implements tgt
{
  tiq(tip paramtip) {}
  
  public void a(the paramthe)
  {
    tlo.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramthe.b + " | resultBean:" + paramthe.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (this.a.a() == null)
    {
      tlo.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramthe.a())
    {
      if ((paramthe.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramthe.jdField_a_of_type_JavaLangObject;
        tgu localtgu = paramthe.jdField_a_of_type_Tgu;
        if (localtgu != null) {
          tee.a().a(localstNotificationRsp.trace_id, localtgu.a);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((tjm)this.a.a()).a(localstNotificationRsp, localtgu);
          return;
        }
        ((tjm)this.a.a()).a(paramthe.b, paramthe.jdField_a_of_type_JavaLangString);
        return;
      }
      ((tjm)this.a.a()).a(paramthe.b, paramthe.jdField_a_of_type_JavaLangString);
      tlo.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramthe.b + " | " + paramthe.jdField_a_of_type_JavaLangString);
      return;
    }
    ((tjm)this.a.a()).a(paramthe.jdField_a_of_type_Int, paramthe.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tiq
 * JD-Core Version:    0.7.0.1
 */