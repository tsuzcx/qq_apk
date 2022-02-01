package com.tencent.biz.pubaccount.util;

import acja;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import nyn;
import ocp;
import ocq;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class PublicAccountUtil$10$1
  implements Runnable
{
  public PublicAccountUtil$10$1(ocq paramocq, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    int i = 0;
    int j = 0;
    int n = 0;
    int i1 = 0;
    int m = 0;
    if (this.awn) {
      j = i1;
    }
    for (;;)
    {
      try
      {
        localObject3 = this.H.getByteArray("data");
        j = i1;
        int i2 = this.H.getInt("type", 0);
        k = i;
        if (localObject3 != null)
        {
          j = i1;
          localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          j = i1;
          localObject4 = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (i2 != 0) {
            continue;
          }
          j = i1;
          localGetPublicAccountDetailInfoResponse.mergeFrom((byte[])localObject3);
          bool = true;
          k = i;
          if (bool)
          {
            k = i;
            j = i1;
            if (localGetPublicAccountDetailInfoResponse.ret_info.has())
            {
              k = i;
              j = i1;
              if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has())
              {
                k = i;
                j = i1;
                if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
                {
                  j = i1;
                  localObject3 = new AccountDetail(localGetPublicAccountDetailInfoResponse);
                  j = i1;
                  localObject4 = this.this$0.val$app.getEntityManagerFactory(this.this$0.val$app.getAccount()).createEntityManager();
                  k = i;
                  if (localObject4 != null)
                  {
                    j = i1;
                    ((EntityManager)localObject4).persistOrReplace((Entity)localObject3);
                    if (localObject3 != null)
                    {
                      j = i1;
                      localObject4 = (acja)this.this$0.val$app.getManager(56);
                      if (localObject4 != null)
                      {
                        j = i1;
                        ((acja)localObject4).f((AccountDetail)localObject3);
                        j = i1;
                        if (((acja)localObject4).b(((AccountDetail)localObject3).uin) == null)
                        {
                          j = i1;
                          if (((AccountDetail)localObject3).followType == 1)
                          {
                            j = i1;
                            ((acja)localObject4).c(PublicAccountInfo.createPublicAccount((AccountDetail)localObject3, 0L));
                          }
                        }
                      }
                    }
                    j = i1;
                    j = n;
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        int k;
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
        Object localObject4;
        boolean bool;
        continue;
      }
      try
      {
        if (ocp.l != null)
        {
          j = n;
          ocp.l.sendEmptyMessage(36);
          i = 1;
          j = i;
          if (ocp.d() != null)
          {
            j = i;
            if (ocp.d().get() != null)
            {
              j = i;
              if (localGetPublicAccountDetailInfoResponse.uin.has())
              {
                j = i;
                localObject4 = Message.obtain();
                j = i;
                ((Message)localObject4).obj = String.valueOf(localGetPublicAccountDetailInfoResponse.uin.get());
                j = i;
                ((Message)localObject4).what = 200;
                j = i;
                ((Handler)ocp.d().get()).sendMessage((Message)localObject4);
              }
            }
          }
          j = i;
          k = i;
          j = i;
          if (localGetPublicAccountDetailInfoResponse.uin.has())
          {
            k = i;
            if (localObject3 != null)
            {
              j = i;
              nyn.a().b(this.this$0.val$app, (AccountDetail)localObject3);
              k = i;
            }
          }
          j = k;
          if (j != 0) {}
        }
      }
      finally {}
      try
      {
        if (ocp.l != null) {
          ocp.l.sendEmptyMessage(36);
        }
        return;
      }
      finally {}
      j = i1;
      bool = ocp.a((byte[])localObject3, (oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse)localObject4, localGetPublicAccountDetailInfoResponse);
      continue;
      j = n;
      localObject4 = this.this$0.val$app.getHandler(Conversation.class);
      i = m;
      if (localObject4 != null)
      {
        j = n;
        ((MqqHandler)localObject4).sendEmptyMessage(1014);
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.10.1
 * JD-Core Version:    0.7.0.1
 */