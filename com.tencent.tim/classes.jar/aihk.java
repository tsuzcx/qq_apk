import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.ResultInfo;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class aihk
  extends QIPCModule
{
  private static volatile aihk a;
  
  public aihk(String paramString)
  {
    super(paramString);
  }
  
  public static aihk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aihk("TogetherBusinessIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessIPCModule", 2, "call TogetherBusinessIPCModule action=" + paramString);
    }
    if ("action_open_identify".equals(paramString)) {
      TogetherBusinessServlet.a("QQAIOMediaSvc.open_identify", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aihk.a(this, paramInt));
    }
    do
    {
      boolean bool2;
      do
      {
        do
        {
          return null;
          if ("action_open_start".equals(paramString))
          {
            TogetherBusinessServlet.a("QQAIOMediaSvc.open_start", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aihk.a(this, paramInt));
            return null;
          }
        } while (!"action_set_floating".equals(paramString));
        boolean bool1 = paramBundle.getBoolean("BUNDLE_SET_STATUS");
        paramString = paramBundle.getString("BUNDLE_SET_KEY_UIN", "");
        paramInt = paramBundle.getInt("BUNDLE_SET_KEY_SESSION_TYPE", -1);
        bool2 = paramBundle.getBoolean("BUNDLE_SET_KEY_REFRESH_UI", true);
        aihl.a(bool1, paramString, paramInt, bool2);
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessIPCModule", 2, "ACTION_SET_FLOATING " + " isShow=" + bool1 + " uin=" + paramString + " sessionType=" + paramInt + " refresh=" + bool2);
        }
      } while (!bool2);
      paramBundle = (aohy)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(339);
      paramString = (WatchTogetherSession)paramBundle.a(2, paramInt, paramString);
    } while (paramString == null);
    paramBundle.b(true, paramString, 1002, "");
    return null;
  }
  
  public static class a
    implements BusinessObserver
  {
    private int ddr;
    private WeakReference<QIPCModule> j;
    
    public a(QIPCModule paramQIPCModule, int paramInt)
    {
      this.j = new WeakReference(paramQIPCModule);
      this.ddr = paramInt;
    }
    
    private void a(Bundle paramBundle, TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
    {
      int i;
      long l;
      String str;
      QQAppInterface localQQAppInterface;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherObserver", 2, "handleStartPackage TogetherControlManager");
        }
        i = paramBundle.getInt("session_type", -1);
        l = paramBundle.getLong("uin", -1L);
        int k = paramBundle.getInt("business_type", 0);
        str = paramBundle.getString("appid", "");
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (k == 2) {
          if (i != 2) {
            break label154;
          }
        }
      }
      label154:
      for (paramBundle = "c2c_AIO";; paramBundle = "Grp_AIO")
      {
        anot.a(localQQAppInterface, "dc00899", paramBundle, "", "video_tab", "clk_share_suc", 0, 0, l + "", str, "", "");
        aoij.a(localQQAppInterface, paramRspOpenStart.jumpType, paramRspOpenStart.jumpUrl, null, new Bundle(), i);
        return;
      }
    }
    
    private boolean a(TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
    {
      if ((paramRspOpenStart.resultInfo != null) && (paramRspOpenStart.resultInfo.showErrorMsg) && (!TextUtils.isEmpty(paramRspOpenStart.resultInfo.errorMsg))) {}
      while (((paramRspOpenStart.jumpType != 1) && (paramRspOpenStart.jumpType != 2)) || (TextUtils.isEmpty(paramRspOpenStart.jumpUrl))) {
        return false;
      }
      return true;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, "type:" + paramInt + " isSuccess:" + paramBoolean);
      }
      if (this.j.get() == null) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherObserver", 2, " mRef is empty");
        }
      }
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = (QIPCModule)this.j.get();
            if ((12 == paramInt) && (paramBoolean))
            {
              ((QIPCModule)localObject).callbackResult(this.ddr, EIPCResult.createResult(0, paramBundle));
              return;
            }
          } while ((13 != paramInt) || (!paramBoolean));
          ((QIPCModule)localObject).callbackResult(this.ddr, EIPCResult.createResult(0, paramBundle));
          localObject = (TogetherBusinessServlet.RspOpenStart)paramBundle.getSerializable("QQAIOMediaSvc.open_start");
          paramBundle = paramBundle.getBundle("bundle");
          if ((paramBundle != null) && (localObject != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherObserver", 2, "bundleExtra is null or rspOpenStart is null");
        return;
      } while (!a((TogetherBusinessServlet.RspOpenStart)localObject));
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, "handleStartPackage jumpToTogetherBusiness");
      }
      a(paramBundle, (TogetherBusinessServlet.RspOpenStart)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihk
 * JD-Core Version:    0.7.0.1
 */