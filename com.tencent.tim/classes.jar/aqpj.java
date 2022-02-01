import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class aqpj
  extends aquy
{
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    Object localObject2 = paramaquz.getParams();
    String str1 = ((Bundle)localObject2).getString("method");
    if (str1 == null) {
      str1 = "other";
    }
    for (;;)
    {
      String str2 = ((Bundle)localObject2).getString("ifromet");
      if (str2 == null) {
        str2 = "null";
      }
      for (;;)
      {
        boolean bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Club_jsonDownloadListener key = " + paramaquz.key + ",satatus = " + paramaquz.getStatus() + ",errCode = " + paramaquz.errCode + ",errMsg = " + paramaquz.errMsg);
        }
        Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        Object localObject3;
        boolean bool1;
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject1;
          if ((paramaquz.getStatus() != 3) || (paramaquz.errCode != 0)) {
            break label613;
          }
          localObject3 = ((Bundle)localObject2).getString("version_key");
          if (localObject3 != null) {
            aqpi.aP(BaseApplicationImpl.sApplication.getApplicationContext(), (String)localObject3, ((Bundle)localObject2).getInt("version", 0));
          }
          if ((paramaquz.key == null) || (localObject1 == null)) {
            break label540;
          }
          if (!aqpi.c.cuN.equals(paramaquz.key)) {
            break label384;
          }
          aqpi.c.cb = null;
          aqpi.c.e(((QQAppInterface)localObject1).getApplication());
          bool1 = bool2;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "jsonDownloadListener,ret=" + bool1 + ",file.name:" + paramaquz.key + ",method:" + str1 + ",ifromet:" + str2);
          }
          if (localObject1 != null) {}
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_jsonName", paramaquz.key);
            ((HashMap)localObject2).put("param_method", str1);
            ((HashMap)localObject2).put("param_from", str2);
            anpc.a(((QQAppInterface)localObject1).getApplication().getApplicationContext()).collectPerformance(((QQAppInterface)localObject1).getAccount(), "ClubContentJsonLoaded", bool1, 1L, 0L, (HashMap)localObject2, "", false);
            return;
          }
          catch (Exception paramaquz)
          {
            label384:
            label540:
            label561:
            label608:
            label613:
            paramaquz.printStackTrace();
            return;
          }
          localObject1 = null;
          break;
          if (paramaquz.key.equals(aqpi.f.cuN))
          {
            acfi.cp((QQAppInterface)localObject1);
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (!paramaquz.key.equals(aqpi.b.cuN)) {
              if (paramaquz.key.equals(aqpi.h.cuN))
              {
                ((aqqu)((QQAppInterface)localObject1).getManager(150)).eF((QQAppInterface)localObject1);
                bool1 = bool2;
              }
              else if (paramaquz.key.equals(aqpi.d.cuN))
              {
                aqpi.d.cb = null;
                aqpi.d.e(((QQAppInterface)localObject1).getApplication());
                bool1 = bool2;
              }
              else
              {
                bool1 = bool2;
                if (paramaquz.key.equals(aqpi.i.cuN))
                {
                  localObject2 = (ku)((QQAppInterface)localObject1).getManager(42);
                  bool1 = bool2;
                  continue;
                  localObject2 = new StringBuilder().append("jsonDownloadListener, app == null:");
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    localObject2 = ((StringBuilder)localObject2).append(bool1).append(",key == null:");
                    if (paramaquz.key != null) {
                      break label608;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.e("ClubContentJsonTask", 2, bool1);
                    bool1 = bool2;
                    break;
                    bool1 = false;
                    break label561;
                  }
                  QLog.e("ClubContentJsonTask", 1, "ClubContentJsonTask jsondownfail task.key = " + paramaquz.key);
                  if ((paramaquz.key != null) && (paramaquz.key.equals(aqpi.g.cuN)) && (localObject1 != null))
                  {
                    localObject3 = (acgn)((QQAppInterface)localObject1).getManager(131);
                    localObject2 = "0";
                    if (((acgn)localObject3).aas()) {
                      localObject2 = "1";
                    }
                    anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, (String)localObject2, "0", "", "");
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onProgress(aquz paramaquz) {}
  
  public boolean onStart(aquz paramaquz)
  {
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpj
 * JD-Core Version:    0.7.0.1
 */