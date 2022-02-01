import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ausa
  implements Handler.Callback, NotificationReportController
{
  private boolean brR;
  private boolean djJ;
  private Set<Integer> dw;
  Handler mHandler = null;
  private List<ausa.a> yc = new ArrayList();
  
  public ausa()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("NotificationReportControllerImpl", 0);
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private String Fj()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.dw.iterator();
    while (localIterator.hasNext()) {
      localStringBuffer.append((Integer)localIterator.next()).append(",");
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private void ewx()
  {
    Object localObject;
    if ((0 == 0) && (BaseApplicationImpl.sProcessId == 1))
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (QQAppInterface localQQAppInterface = (QQAppInterface)localObject;; localQQAppInterface = null)
    {
      if ((localQQAppInterface != null) && (this.yc.size() > 0))
      {
        Iterator localIterator = this.yc.iterator();
        if (localIterator.hasNext())
        {
          ausa.a locala = (ausa.a)localIterator.next();
          boolean bool = p(localQQAppInterface, locala.esh);
          localObject = "";
          switch (locala.mMsgType)
          {
          default: 
            label132:
            if ((locala.mUinType == 7200) || (locala.mUinType == 1008) || (locala.mUinType == 7220)) {
              anot.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", locala.bIB, locala.esh + "", "" + locala.mUinType, "", "", "", "");
            }
            break;
          }
          while (QLog.isDevelopLevel())
          {
            QLog.d("NotificationReportControllerImpl", 2, "report real msgType:" + locala.mMsgType + "    frienduin:" + locala.bIB + "   uinType:" + locala.mUinType + "    nId:" + locala.esh);
            break;
            localObject = "info_arr";
            break label132;
            localObject = "clk";
            break label132;
            localObject = "lock_arr";
            break label132;
            localObject = "lock_clk";
            break label132;
            anot.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", "", locala.esh + "", "", "", "", "", "");
          }
        }
        this.yc.clear();
      }
      return;
    }
  }
  
  private boolean p(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!this.djJ)
    {
      Object localObject = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      long l1 = localSharedPreferences.getLong("key_begintime_" + (String)localObject, 0L);
      long l2 = aury.f().longValue();
      this.dw = new HashSet();
      if (l1 == l2)
      {
        localObject = localSharedPreferences.getString("kay_reported_notify_ids_" + (String)localObject, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(",");
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localSharedPreferences = localObject[i];
            this.dw.add(Integer.valueOf(localSharedPreferences));
            i += 1;
          }
        }
      }
      else
      {
        localSharedPreferences.edit().putLong("key_begintime_" + (String)localObject, l2).apply();
      }
      this.djJ = true;
    }
    if (!this.dw.contains(Integer.valueOf(paramInt)))
    {
      this.dw.add(Integer.valueOf(paramInt));
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("kay_reported_notify_ids_" + paramQQAppInterface.getAccount(), Fj()).apply();
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      paramMessage = (ausa.a)paramMessage.obj;
      if (this.brR)
      {
        this.yc.add(paramMessage);
        ewx();
        return true;
      }
      this.yc.add(paramMessage);
      return true;
    }
    this.brR = true;
    ewx();
    return true;
  }
  
  public void report(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("NotificationReportControllerImpl", 2, "msgType:" + paramInt1 + "frienduin:" + paramString + "   uinType:" + paramInt3 + "    nId:" + paramInt2);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.obj = new ausa.a(paramInt1, paramInt2, paramString, paramInt3);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void reportAll()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.mHandler.sendMessage(localMessage);
  }
  
  static class a
  {
    String bIB;
    int esh;
    int mMsgType;
    int mUinType;
    
    public a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.mMsgType = paramInt1;
      this.esh = paramInt2;
      this.bIB = paramString;
      this.mUinType = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ausa
 * JD-Core Version:    0.7.0.1
 */