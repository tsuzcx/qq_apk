import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aczn
  extends QIPCModule
{
  private static volatile aczn a;
  private static Object sLock = new Object();
  
  private aczn(String paramString)
  {
    super(paramString);
  }
  
  public static aczn a()
  {
    if (a != null) {
      return a;
    }
    synchronized (sLock)
    {
      if (a != null)
      {
        aczn localaczn1 = a;
        return localaczn1;
      }
    }
    a = new aczn("soso_interface");
    aczn localaczn2 = a;
    return localaczn2;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.SosoInterfaceModule", 2, "onCall s: " + paramString);
    }
    long l;
    boolean bool2;
    if ("get_lbs_info".equals(paramString))
    {
      bool1 = paramBundle.getBoolean("req_location");
      l = paramBundle.getLong("max_cache_interval");
      bool2 = paramBundle.getBoolean("goon");
      paramInt = paramBundle.getInt("level");
    }
    label243:
    do
    {
      try
      {
        paramString = SosoInterface.a(l, bool2, paramInt, bool1);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder().append("onCall action on get lbs info : maxCacheInterval: ").append(l).append(" goonListener: ").append(bool2).append(" level: ").append(paramInt).append(" reqLocation:").append(bool1).append(" lbsInfo is null: ");
          if (paramString == null)
          {
            bool1 = true;
            QLog.i("SOSO.LBS.SosoInterfaceModule", 2, bool1);
          }
        }
        else
        {
          paramBundle = new Bundle();
          localObject1 = new EIPCResult();
          ((EIPCResult)localObject1).data = paramBundle;
          if (paramString == null) {
            break label243;
          }
          ((EIPCResult)localObject1).code = 0;
          paramBundle.putParcelable("soso_lbs_info", paramString);
          return localObject1;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramString = (String)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("SOSO.LBS.SosoInterfaceModule", 2, Log.getStackTraceString(paramBundle));
            paramString = (String)localObject1;
            continue;
            bool1 = false;
            continue;
            ((EIPCResult)localObject1).code = -102;
          }
        }
      }
      localObject1 = localObject2;
    } while (!"set_lbs_info".equals(paramString));
    paramBundle.setClassLoader(SosoInterface.class.getClassLoader());
    boolean bool1 = paramBundle.getBoolean("req_location");
    localObject1 = new Bundle();
    paramString = new EIPCResult();
    paramString.data = ((Bundle)localObject1);
    if (bool1) {}
    try
    {
      SosoInterface.f(paramBundle.getInt("level"), (SosoInterface.SosoLbsInfo)paramBundle.getParcelable("soso_lbs_info"));
      for (;;)
      {
        paramString.code = 0;
        return paramString;
        SosoInterface.i(paramBundle.getString("prodiver"), paramBundle.getByteArray("raw_data"));
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SOSO.LBS.SosoInterfaceModule", 2, Log.getStackTraceString(paramBundle));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczn
 * JD-Core Version:    0.7.0.1
 */