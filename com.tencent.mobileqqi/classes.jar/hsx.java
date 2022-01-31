import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.pcpush.PCPushDBHelper;
import com.tencent.open.pcpush.PCPushProxy;
import com.tencent.open.pcpush.PCPushProxy.PkgEntry;
import java.util.concurrent.ConcurrentHashMap;

public class hsx
  extends Handler
{
  public hsx(PCPushProxy paramPCPushProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    LogUtility.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    PCPushProxy.PkgEntry localPkgEntry;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localPkgEntry = (PCPushProxy.PkgEntry)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localPkgEntry == null) {
          LogUtility.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        StaticAnalyz.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localPkgEntry.jdField_b_of_type_Int != 1) {
          str1 = localPkgEntry.jdField_b_of_type_JavaLangString.substring(localPkgEntry.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localPkgEntry.jdField_b_of_type_JavaLangString;
            continue;
            LogUtility.e("PCPushProxy", "handleMessage get key = null");
            localPkgEntry = null;
          }
        }
      } while (localPkgEntry == null);
      if (localPkgEntry.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        StaticAnalyz.a("100", localPkgEntry.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(localPkgEntry);
        return;
        StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH." + localPkgEntry.c, str1);
      }
      this.a.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper.a(str2);
      return;
    } while (localPkgEntry == null);
    StaticAnalyz.a("500", localPkgEntry.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hsx
 * JD-Core Version:    0.7.0.1
 */