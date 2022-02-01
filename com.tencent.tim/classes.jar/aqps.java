import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqps
  extends aquy
{
  aqps(aqpr paramaqpr, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + paramaquz.getStatus());
    }
    Bundle localBundle = paramaquz.getParams();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (paramaquz.getStatus() == 3)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = localBundle.getBoolean("isExists", false);
        localObject = localBundle.getString("path");
        if (!bool2) {
          break label481;
        }
        label101:
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("ColorRingManager", 2, "rename failure.");
            bool2 = bool1;
          }
        }
      }
      if ((this.a.c != null) && (paramaquz.getParams().getBoolean("isIPC")))
      {
        paramaquz = new Bundle();
        paramaquz.putString("status", "onDone");
        paramaquz.putInt("fcStatus", 3);
        paramaquz.putInt("id", k);
        paramaquz.putInt("callId", k);
        paramaquz.putInt("srcType", localBundle.getInt("srcType"));
        paramaquz.putBoolean("result", bool2);
        paramaquz.putInt("resourceType", localBundle.getInt("resourceType"));
        paramaquz.putString("colorType", localBundle.getString("colorType"));
        paramaquz.putBoolean("result_boo", bool2);
        paramaquz.putInt("resourceType", i);
        this.a.c.onResponse(paramaquz);
      }
      if (i == 3)
      {
        paramaquz = (acle)this.a.mApp.getBusinessHandler(13);
        i = paramaquz.AX();
        if (i != 2) {
          break label511;
        }
        i = 0;
      }
    }
    label526:
    label531:
    for (;;)
    {
      label299:
      int j;
      if ("colorring".equals(localBundle.getString("colorType")))
      {
        localObject = this.a.mApp;
        if (bool2)
        {
          j = 0;
          label330:
          anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
        }
      }
      else if ("comering".equals(localBundle.getString("colorType")))
      {
        if (!bool2) {
          break label526;
        }
      }
      for (i = 0;; i = 1)
      {
        anot.a(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + paramaquz.AX(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = aqhq.rename((String)localObject + ".tmp", (String)localObject);
        break label101;
        label511:
        if (i != 3) {
          break label531;
        }
        i = 2;
        break label299;
        j = 1;
        break label330;
      }
    }
  }
  
  public void onProgress(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + paramaquz.atU + "percent=" + paramaquz.fj);
    }
    if ((paramaquz.getParams().getBoolean("isIPC")) && (this.a.c != null))
    {
      Bundle localBundle1 = paramaquz.getParams();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)paramaquz.fj);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.c.onResponse(localBundle2);
    }
  }
  
  public boolean onStart(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + paramaquz.atU + "percent=" + paramaquz.fj);
    }
    if ((paramaquz.getParams().getBoolean("isIPC")) && (this.a.c != null))
    {
      paramaquz = paramaquz.getParams();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", paramaquz.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", paramaquz.getInt("callId"));
      localBundle.putInt("srcType", paramaquz.getInt("srcType"));
      localBundle.putInt("resourceType", paramaquz.getInt("resourceType"));
      localBundle.putString("colorType", paramaquz.getString("colorType"));
      this.a.c.onResponse(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqps
 * JD-Core Version:    0.7.0.1
 */