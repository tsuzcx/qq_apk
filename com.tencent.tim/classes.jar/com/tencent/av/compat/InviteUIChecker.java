package com.tencent.av.compat;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anot;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igv;
import ihn;
import iiv;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jjc;
import jko;

public class InviteUIChecker
{
  private final ConcurrentHashMap<String, CheckTask> aF = new ConcurrentHashMap(2);
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public long a(VideoAppInterface paramVideoAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramIntent != null) && (paramIntent.getComponent() != null)) {}
    for (String str1 = paramIntent.getComponent().getClassName();; str1 = null)
    {
      long l2;
      if ((paramIntent == null) || (paramVideoAppInterface == null) || (TextUtils.isEmpty(str1)))
      {
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker className[" + str1 + "], app[" + paramVideoAppInterface + "], intent[" + paramIntent + "]");
          l2 = l1;
        }
      }
      String str2;
      do
      {
        return l2;
        str2 = paramIntent.getStringExtra("session_id");
        if (!TextUtils.isEmpty(str2)) {
          break;
        }
        l2 = l1;
      } while (!QLog.isColorLevel());
      QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + str2 + "]");
      return 0L;
      je(str1);
      jf(str2);
      l1 = 5000L;
      if (!paramBoolean) {
        l1 = 200L;
      }
      for (;;)
      {
        paramVideoAppInterface = new CheckTask(str1, paramIntent, paramVideoAppInterface, null);
        this.aF.put(str2, paramVideoAppInterface);
        this.mHandler.postDelayed(paramVideoAppInterface, l1);
        l2 = l1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + str2 + "], task[" + paramVideoAppInterface + "], timeout[" + l1 + "]");
        return l1;
        if (jjc.xA()) {
          l1 = 1500L;
        }
      }
    }
  }
  
  public void je(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InviteUIChecker", 2, "removeCheckTaskByClass class[" + paramString + "]");
    }
    Iterator localIterator = this.aF.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      CheckTask localCheckTask = (CheckTask)this.aF.get(str);
      if ((localCheckTask != null) && (CheckTask.a(localCheckTask).equals(paramString))) {
        jf(str);
      }
    }
  }
  
  public void jf(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      CheckTask localCheckTask = (CheckTask)this.aF.remove(paramString);
      localObject = localCheckTask;
      if (localCheckTask != null)
      {
        this.mHandler.removeCallbacks(localCheckTask);
        localObject = localCheckTask;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("InviteUIChecker", 2, "removeCheckTaskBySession session[" + paramString + "], task[" + localObject + "]");
    }
  }
  
  static class CheckTask
    implements Runnable
  {
    private final String className;
    private final Intent intent;
    private final WeakReference<VideoAppInterface> mRef;
    private final long seq = AudioHelper.hG();
    
    private CheckTask(String paramString, Intent paramIntent, VideoAppInterface paramVideoAppInterface)
    {
      this.className = paramString;
      this.intent = paramIntent;
      this.mRef = new WeakReference(paramVideoAppInterface);
    }
    
    public void a(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
    {
      long l1 = paramIntent.getLongExtra("discussId", 0L);
      int i = paramIntent.getIntExtra("relationType", 0);
      long l2 = paramIntent.getLongExtra("friendUin", 0L);
      paramIntent = igv.a(i, String.valueOf(l1), new int[0]);
      Object localObject = igv.a().c(paramIntent);
      if ((localObject != null) && (((iiv)localObject).tc()))
      {
        i = ((iiv)localObject).uinType;
        String str = ((iiv)localObject).MP;
        Bitmap localBitmap = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
        localObject = paramVideoAppInterface.getDisplayName(jjc.cJ(((iiv)localObject).relationType), String.valueOf(l2), String.valueOf(((iiv)localObject).senderUin));
        str = paramVideoAppInterface.getDisplayName(i, String.valueOf(l1), str);
        jko.a(paramVideoAppInterface).a(true, paramIntent, (String)localObject, localBitmap, String.valueOf(l1), 61, i, 3, str);
        ihn.amp();
      }
      if (QLog.isColorLevel()) {
        QLog.i("InviteUIChecker", 2, "showInviteNotifyForGroup session[" + paramIntent + "]");
      }
    }
    
    public void b(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("uinType", -1);
      int j;
      Object localObject1;
      String str;
      Object localObject2;
      Object localObject3;
      if (jjc.co(i))
      {
        long l1 = paramIntent.getLongExtra("discussId", 0L);
        j = paramIntent.getIntExtra("relationType", 0);
        long l2 = paramIntent.getLongExtra("friendUin", 0L);
        localObject1 = igv.a(j, String.valueOf(l1), new int[0]);
        paramIntent = igv.a().c((String)localObject1);
        if ((paramIntent != null) && (paramIntent.tc()))
        {
          str = paramIntent.MP;
          localObject2 = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
          localObject3 = paramVideoAppInterface.getDisplayName(jjc.cJ(paramIntent.relationType), String.valueOf(l2), String.valueOf(paramIntent.senderUin));
          str = paramVideoAppInterface.getDisplayName(i, String.valueOf(l1), str);
          jko.a(paramVideoAppInterface).a(paramIntent.sessionId, (String)localObject3, (Bitmap)localObject2, String.valueOf(l1), 57, i, 3, str);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InviteUIChecker", 2, "showInviteNotifyForMultiIncomingCall session[" + (String)localObject1 + "]");
        }
        return;
        localObject2 = paramIntent.getStringExtra("peerUin");
        j = paramIntent.getIntExtra("relationType", 0);
        boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
        if (bool) {}
        for (paramIntent = igv.a(100, (String)localObject2, new int[0]);; paramIntent = igv.a(3, (String)localObject2, new int[0]))
        {
          localObject3 = igv.a().c(paramIntent);
          localObject1 = paramIntent;
          if (localObject3 == null) {
            break;
          }
          localObject1 = paramIntent;
          if (!((iiv)localObject3).tc()) {
            break;
          }
          localObject1 = paramIntent;
          if (j != 3) {
            break;
          }
          str = ((iiv)localObject3).MP;
          localObject1 = paramVideoAppInterface.a(i, (String)localObject2, str, true, true);
          localObject2 = paramVideoAppInterface.getDisplayName(i, (String)localObject2, str);
          paramVideoAppInterface = jko.a(paramVideoAppInterface);
          if ((((iiv)localObject3).QE) || (bool)) {
            break label367;
          }
          paramVideoAppInterface.a(((iiv)localObject3).sessionId, (String)localObject2, (Bitmap)localObject1, null, 56, i, 2);
          localObject1 = paramIntent;
          break;
        }
        label367:
        paramVideoAppInterface.a(((iiv)localObject3).sessionId, (String)localObject2, (Bitmap)localObject1, null, 55, i, 1);
        localObject1 = paramIntent;
      }
    }
    
    public void c(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
    {
      String str1 = paramIntent.getStringExtra("peerUin");
      int i = paramIntent.getIntExtra("relationType", 0);
      Bitmap localBitmap;
      if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
      {
        paramIntent = igv.a(100, str1, new int[0]);
        iiv localiiv = igv.a().c(paramIntent);
        if ((localiiv != null) && (localiiv.tc()) && (i == 3))
        {
          i = localiiv.uinType;
          String str2 = localiiv.MP;
          localBitmap = paramVideoAppInterface.a(i, str1, str2, true, true);
          str1 = paramVideoAppInterface.getDisplayName(i, str1, str2);
          paramVideoAppInterface = jko.a(paramVideoAppInterface);
          if (!localiiv.QE) {
            break label183;
          }
          paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 45, i, 1, null);
        }
      }
      for (;;)
      {
        ihn.amp();
        if (QLog.isColorLevel()) {
          QLog.i("InviteUIChecker", 2, "showInviteNotifyForDouble sessionId[" + paramIntent + "]");
        }
        return;
        paramIntent = igv.a(3, str1, new int[0]);
        break;
        label183:
        paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 40, i, 2, null);
      }
    }
    
    public void run()
    {
      VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.mRef.get();
      if (localVideoAppInterface == null)
      {
        QLog.e("InviteUIChecker", 1, "CheckTask app is null.");
        return;
      }
      for (;;)
      {
        try
        {
          if (VideoInviteActivity.class.getName().equals(this.className))
          {
            c(localVideoAppInterface, this.intent);
            anot.a(null, "dc00898", "", "", "0X800A2C4", "0X800A2C4", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("InviteUIChecker", 2, "CheckTask className[" + this.className + "]");
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("InviteUIChecker", 1, "CheckTask  fail.", localThrowable);
          return;
        }
        if (GaInviteLockActivity.class.getName().equals(this.className)) {
          a(localThrowable, this.intent);
        } else if (MultiIncomingCallsActivity.class.getName().equals(this.className)) {
          b(localThrowable, this.intent);
        }
      }
    }
    
    public String toString()
    {
      return "CheckTask{" + this.seq + ", " + this.className + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker
 * JD-Core Version:    0.7.0.1
 */