import UserGrowth.stNotificationRsp;

class omd
  implements oko
{
  omd(omc paramomc) {}
  
  public void a(okz paramokz)
  {
    ooz.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramokz.mResultCode + " | resultBean:" + paramokz.bb + " | thread:" + Thread.currentThread().getName());
    if (this.a.b() == null)
    {
      ooz.e("WSRecommendFragmentPresenter", "getNotification onTaskResponse getView(): null");
      return;
    }
    if (paramokz.succeeded())
    {
      if ((paramokz.bb instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramokz.bb;
        okp localokp = paramokz.a;
        if (localokp != null) {
          ohy.a().f(localstNotificationRsp.trace_id, localokp.mapExt);
        }
        if (localstNotificationRsp.type > 0)
        {
          ((omy.b)this.a.b()).a(localstNotificationRsp, localokp);
          return;
        }
        ((omy.b)this.a.b()).aG(paramokz.mResultCode, paramokz.msg);
        return;
      }
      ((omy.b)this.a.b()).aG(paramokz.mResultCode, paramokz.msg);
      ooz.e("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramokz.mResultCode + " | " + paramokz.msg);
      return;
    }
    ((omy.b)this.a.b()).aG(paramokz.bfj, paramokz.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omd
 * JD-Core Version:    0.7.0.1
 */