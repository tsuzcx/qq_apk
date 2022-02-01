import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class aljv
  implements avyx
{
  private static volatile aljv a;
  
  public static aljv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aljv();
      }
      return a;
    }
    finally {}
  }
  
  private void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    try
    {
      Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
      if (localObject != null)
      {
        localObject = (Long)((Map)localObject).get(Integer.valueOf(2783));
        if (localObject != null) {
          aajd.a().al(((Long)localObject).longValue(), 2783);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2783));
        aljn.a().b(paramMobileQbossAdvRsp, paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramMobileQbossAdvRsp)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossPreDownloadRsp exception", paramMobileQbossAdvRsp);
    }
  }
  
  private void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QzoneQbossHelper", 1, "coversation getQbossSuccess requestType = " + paramString);
    if (paramMobileQbossAdvRsp != null)
    {
      paramString = paramMobileQbossAdvRsp.map_next_query_ts;
      if (paramString != null)
      {
        paramString = (Long)paramString.get(Integer.valueOf(2741));
        if (paramString != null) {
          aajd.a().al(paramString.longValue(), 2741);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if (paramMobileQbossAdvRsp != null)
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2741));
        if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0)) {
          eH(paramMobileQbossAdvRsp);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = paramQQAppInterface.getHandler(Conversation.class);
        if (paramMobileQbossAdvRsp != null) {
          paramMobileQbossAdvRsp.sendEmptyMessage(1063);
        }
      }
      return;
    }
  }
  
  private void c(aajc paramaajc)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      aajc localaajc;
      do
      {
        return;
        localaajc = aajd.a().a(localQQAppInterface.getAccount());
      } while ((paramaajc == null) || (paramaajc.b == null) || (localaajc == null) || (localaajc.b == null) || (paramaajc.b.pattern_id == localaajc.b.pattern_id));
      paramaajc = localQQAppInterface.getHandler(Conversation.class);
    } while (paramaajc == null);
    QLog.e("QzoneQbossHelper", 1, "checkIfNeedRemoveBanner remove");
    paramaajc.sendEmptyMessage(1063);
  }
  
  private void eH(ArrayList<tAdvDesc> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (tAdvDesc)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        QLog.i("QzoneQbossHelper", 4, "handleQbossBannerData data = " + paramArrayList.res_data);
        paramArrayList = aajc.a(paramArrayList);
        c(paramArrayList);
        aajd.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramArrayList);
      }
    }
    else
    {
      return;
    }
    QLog.e("QzoneQbossHelper", 1, "handleQbossBannerData data = null");
  }
  
  public static void p(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList;
    HashMap localHashMap;
    try
    {
      Object localObject1 = aljs.b(BaseApplicationImpl.getContext(), paramLong);
      localArrayList = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        if ((aljs.mx == null) || (aljs.mx.size() == 0))
        {
          localHashMap = aljs.a(BaseApplicationImpl.getApplication(), paramLong + "");
          localObject1 = ((List)localObject1).iterator();
        }
      }
      else {
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if (localHashMap.containsKey(localObject2))
          {
            localObject2 = (aljt)localHashMap.get(localObject2);
            if (((aljt)localObject2).atI())
            {
              localArrayList.add(localObject2);
              QLog.i("QSplash@QbossSplashNetService", 1, "checkNeedDowloadAndDowload aid =" + ((aljt)localObject2).bWM + "UIN" + paramLong % 10000L);
            }
            if ((((aljt)localObject2).mJumpType == 3) || (((aljt)localObject2).mJumpType == 2))
            {
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(((aljt)localObject2).bWP, false, null);
              continue;
              return;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, paramQQAppInterface, new Object[0]);
    }
    do
    {
      localHashMap = aljs.mx;
      break;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    aljq.a(paramQQAppInterface, localArrayList);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramArrayList.contains(Integer.valueOf(2741)));
        QLog.i("QzoneQbossHelper", 1, "getQbossFail msg = " + paramString1 + " requestType = " + paramString2);
        paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (paramString1 == null);
      paramString1 = paramString1.getHandler(Conversation.class);
    } while (paramString1 == null);
    paramString1.sendEmptyMessage(1063);
  }
  
  public void a(Bundle paramBundle, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QSplash@QbossSplashNetService", 1, "getQbossSuccess requestType = " + paramString);
    try
    {
      ArrayList localArrayList = paramBundle.getIntegerArrayList("appid");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramBundle = paramBundle.getSerializable("data");
        if ((paramBundle != null) && ((paramBundle instanceof MobileQbossAdvRsp)))
        {
          paramBundle = (MobileQbossAdvRsp)paramBundle;
          if (localArrayList.contains(Integer.valueOf(2741))) {
            a(paramBundle, paramString, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2742))) {
            b(paramBundle, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2783))) {
            a(paramBundle, paramQQAppInterface);
          }
        }
        else
        {
          a(-1, "rsp is not MobileQbossAdvRsp", paramString, localArrayList);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("QzoneQbossHelper", 1, paramBundle, new Object[0]);
    }
  }
  
  public void a(String paramString, MqqHandler paramMqqHandler)
  {
    try
    {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest  minigame preload ");
      Object localObject = new ArrayList();
      boolean bool2 = aajd.a().hz(2741);
      boolean bool1;
      if (((!bool2) || ("qboss_banner_net_change".equals(paramString))) || (awit.A(BaseApplicationImpl.getApplication().getRuntime())))
      {
        bool1 = aajd.a().hz(2742);
        if (!bool1) {
          break label262;
        }
        ((ArrayList)localObject).add(Integer.valueOf(2742));
      }
      for (;;)
      {
        boolean bool3 = aajd.a().hz(2783);
        if (bool3) {
          ((ArrayList)localObject).add(Integer.valueOf(2783));
        }
        if (((ArrayList)localObject).size() != 0) {
          y(paramString, (ArrayList)localObject);
        }
        if ("qboss_banner_login".equals(paramString))
        {
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            if (!bool1)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest checkNeedDowloadAndDowload ");
              p((QQAppInterface)localObject, aljs.Z(((QQAppInterface)localObject).getAccount()));
            }
            if (!bool3)
            {
              QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest QbossPreDownloadManager.checkPreDownloadResStatus ");
              aljn.a().dK((QQAppInterface)localObject);
            }
          }
        }
        if ((bool2) || (!"qboss_banner_pull_refresh".equals(paramString))) {
          break;
        }
        paramMqqHandler.sendEmptyMessage(1063);
        return;
        QLog.i("QSplash@QbossSplashNetService", 1, "关闭了频控");
        ((ArrayList)localObject).add(Integer.valueOf(2742));
        bool1 = false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneQbossHelper", 1, paramString, new Object[0]);
      return;
    }
    label262:
  }
  
  public void b(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    for (;;)
    {
      try
      {
        Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
        if (localObject != null)
        {
          localObject = (Long)((Map)localObject).get(Integer.valueOf(2742));
          if (localObject != null) {
            aajd.a().al(((Long)localObject).longValue(), 2742);
          }
        }
        paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
        if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
        {
          paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2742));
          localObject = paramQQAppInterface.getAccount();
          if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0))
          {
            QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp appid =2742");
            aljp.a(paramMobileQbossAdvRsp, paramQQAppInterface, (String)localObject);
            i = 1;
            if ((i == 0) && (paramQQAppInterface != null))
            {
              paramMobileQbossAdvRsp = paramQQAppInterface.getAccount();
              QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp cleardata");
              aljs.b(BaseApplicationImpl.getContext(), aljs.Z(paramMobileQbossAdvRsp), false);
              aljs.p(BaseApplicationImpl.getContext(), aljs.Z(paramMobileQbossAdvRsp));
            }
            return;
          }
        }
      }
      catch (Exception paramMobileQbossAdvRsp)
      {
        QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp exception" + paramMobileQbossAdvRsp.toString());
        return;
      }
      int i = 0;
    }
  }
  
  public void y(String paramString, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendRequestQboss requestType = " + paramString + " contain id = " + paramArrayList.toString());
    }
    avzb.a().a(paramArrayList, this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljv
 * JD-Core Version:    0.7.0.1
 */