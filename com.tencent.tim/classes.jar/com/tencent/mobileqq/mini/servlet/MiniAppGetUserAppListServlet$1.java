package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MiniAppGetUserAppListServlet$1
  implements Runnable
{
  MiniAppGetUserAppListServlet$1(MiniAppGetUserAppListServlet paramMiniAppGetUserAppListServlet, INTERFACE.StGetUserAppListRsp paramStGetUserAppListRsp) {}
  
  public void run()
  {
    if ((this.val$result != null) && (this.val$result.userAppList != null))
    {
      Object localObject1 = this.val$result.userAppList.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
        try
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (INTERFACE.StUserAppInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = (INTERFACE.StApiAppInfo)((INTERFACE.StUserAppInfo)localObject2).appInfo.get();
              if ((localObject2 != null) && (((INTERFACE.StApiAppInfo)localObject2).type.get() == 3)) {
                MiniAppInfo.saveMiniAppShowInfoEntity((INTERFACE.StApiAppInfo)localObject2);
              }
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("miniapp-db", 1, "save showInfo error,", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServlet.1
 * JD-Core Version:    0.7.0.1
 */