package com.tencent.biz.pubaccount.serviceAccountFolder;

import aalb;
import acja;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import kaw;
import nyi;
import nyj;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(nyj paramnyj, String paramString, nyi paramnyi) {}
  
  public void run()
  {
    kaw.a().e(nyj.a(this.this$0), this.val$uin);
    Object localObject = (acja)nyj.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((acja)localObject).EA(this.val$uin);
      ((acja)localObject).Ez(this.val$uin);
      AccountDetail localAccountDetail = ((acja)localObject).a(this.val$uin);
      if (localAccountDetail != null)
      {
        ((acja)localObject).Ey(this.val$uin);
        localObject = nyj.a(this.this$0).a().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    nyj.a(this.this$0).b().N(this.b.mUin, 1008);
    aalb.l(nyj.a(this.this$0), this.val$uin, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */