import MConch.Conch;
import MConch.ConchTask;
import MConch.NewCommonConchArgs;
import MConch.SCPullConchs;
import MWIFI.SCGet3rdCloudCheck;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acod
  implements acci
{
  private acod.a a;
  private QQAppInterface mApp;
  
  public acod(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void a(SCPullConchs paramSCPullConchs)
  {
    if ((paramSCPullConchs == null) || (paramSCPullConchs.conchTaskList == null) || (paramSCPullConchs.conchTaskList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs scPullConchs is null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramSCPullConchs = paramSCPullConchs.conchTaskList.iterator();
        if (!paramSCPullConchs.hasNext()) {
          break;
        }
        localObject1 = (ConchTask)paramSCPullConchs.next();
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "WifiSdkObserver, handlePullConchs conchTask.taskId: " + ((ConchTask)localObject1).taskId + " taskSeqno: " + ((ConchTask)localObject1).taskSeqno);
        }
        if ((((ConchTask)localObject1).conchList != null) && (((ConchTask)localObject1).conchList.size() != 0)) {
          break label179;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs ER_Invalid");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramSCPullConchs) {}
      QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs, exception: " + paramSCPullConchs.getMessage());
      return;
      label179:
      Object localObject1 = ((ConchTask)localObject1).conchList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Conch)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (6129 == ((Conch)localObject2).cmdId)
          {
            localObject2 = (NewCommonConchArgs)awck.b(new NewCommonConchArgs(), ((Conch)localObject2).params);
            if ((localObject2 == null) || (((NewCommonConchArgs)localObject2).newParam == null) || (((NewCommonConchArgs)localObject2).newParam.size() < 3))
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs conchArgs is invaild");
              }
            }
            else if (!TextUtils.equals("102769", (CharSequence)((NewCommonConchArgs)localObject2).newParam.get(0)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs channel is wrong");
              }
            }
            else if (this.mApp == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs app is null");
              }
            }
            else
            {
              int i = Integer.valueOf((String)((NewCommonConchArgs)localObject2).newParam.get(1)).intValue();
              localObject2 = String.valueOf(((NewCommonConchArgs)localObject2).newParam.get(2));
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs jumpType: " + i + " url: " + (String)localObject2);
              }
              arna.j(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), i, (String)localObject2);
              arna.D(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), System.currentTimeMillis());
            }
          }
          else if (6142 == ((Conch)localObject2).cmdId)
          {
            localObject2 = (NewCommonConchArgs)awck.b(new NewCommonConchArgs(), ((Conch)localObject2).params);
            if ((localObject2 == null) || (((NewCommonConchArgs)localObject2).newParam == null) || (((NewCommonConchArgs)localObject2).newParam.size() < 2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs conchArgs is invaild");
              }
            }
            else if (!TextUtils.equals("102769", (CharSequence)((NewCommonConchArgs)localObject2).newParam.get(0)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs channel is wrong");
              }
            }
            else if (this.mApp == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs app is null");
              }
            }
            else
            {
              localObject2 = String.valueOf(((NewCommonConchArgs)localObject2).newParam.get(1));
              if (QLog.isColorLevel()) {
                QLog.d("WifiSdk", 2, "WifiSdkObserver, handlePullConchs wording: " + (String)localObject2);
              }
              arna.cY(this.mApp.getApp(), (String)localObject2);
              arna.D(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), System.currentTimeMillis());
            }
          }
        }
      }
    }
  }
  
  public void a(acod.a parama)
  {
    this.a = parama;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "WifiSdkObserver, onUpdate, type: " + paramInt + " isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && (paramObject != null)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.Kd(paramInt);
      }
      return;
      try
      {
        a((SCPullConchs)paramObject);
      }
      catch (Exception paramObject) {}
      if (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "WifiSdkObserver, onUpdate exception: " + paramObject.getMessage());
        continue;
        paramObject = (String)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("WifiSdk", 2, "WifiSdkObserver, onUpdate, guid: " + paramObject);
        }
        if (!TextUtils.isEmpty(paramObject))
        {
          arna.al(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramObject);
          continue;
          paramObject = (arnc)paramObject;
          a(paramObject.a);
          if (this.a != null) {
            this.a.a(paramObject.b);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Kd(int paramInt);
    
    public abstract void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acod
 * JD-Core Version:    0.7.0.1
 */