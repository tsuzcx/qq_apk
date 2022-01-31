package com.tencent.biz.bmqq.app;

import android.os.Bundle;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class BmqqBusinessHandler
  extends BusinessHandler
{
  public static final int a = 1001;
  
  public BmqqBusinessHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    if (paramObject == null)
    {
      a(1001, false, null);
      return;
    }
    int j = ((Bundle)paramObject).getInt("result");
    paramToServiceMsg = (BmqqUserSimpleInfo)((Bundle)paramObject).getParcelable("info");
    EntityManager localEntityManager;
    boolean bool;
    if ((j == 0) && (paramToServiceMsg != null))
    {
      localEntityManager = this.a.a().createEntityManager();
      paramFromServiceMsg = paramToServiceMsg;
      if (localEntityManager != null)
      {
        paramObject = (BmqqUserSimpleInfo)localEntityManager.a(BmqqUserSimpleInfo.class, paramToServiceMsg.mBmqqUin);
        if (paramObject != null) {
          i = 1;
        }
        if (i != 0)
        {
          paramFromServiceMsg = paramToServiceMsg;
          if (!paramObject.equals(paramToServiceMsg))
          {
            paramObject.copyValue(paramToServiceMsg);
            localEntityManager.a(paramObject);
            paramFromServiceMsg = paramObject;
          }
          localEntityManager.a();
        }
      }
      else
      {
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      a(1001, bool, paramToServiceMsg);
      return;
      localEntityManager.a(paramToServiceMsg);
      paramFromServiceMsg = paramToServiceMsg;
      break;
      bool = false;
    }
  }
  
  protected Class a()
  {
    return BmqqBusinessObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!BmqqSegmentUtil.a(this.a.getApplication(), paramString)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("hrtxformqq.service", this.a.a(), "hrtxformqq.getUsrSimpleInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", Long.valueOf(paramString));
    localToServiceMsg.setAttributes(localHashMap);
    a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.app.BmqqBusinessHandler
 * JD-Core Version:    0.7.0.1
 */