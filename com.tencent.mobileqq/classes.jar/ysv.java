import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.UpdateManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ysv
{
  private static void a()
  {
    ytb localytb = ytc.a(BaseApplicationImpl.sApplication, "Native");
    if (localytb != null) {
      UpdateManager.a(localytb.e());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface);
    a();
  }
  
  public static boolean a(ytb paramytb)
  {
    int j = 701;
    String str1 = paramytb.c();
    Object localObject = PatchCommonUtil.getPatchPath(str1);
    String str2 = PatchCommonUtil.getPatchPath("");
    try
    {
      i = LzmaUtils.a(BaseApplicationImpl.sApplication, (String)localObject, str2);
      if (i != 0) {
        break label136;
      }
      i = 700;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label136:
        int i = 702;
        QLog.d("PatchLogTag", 1, "PatchFileManager un7zNPatchFile throwable=" + localThrowable);
        continue;
        i = j;
        if (((File)localObject).exists())
        {
          i = 703;
          ((File)localObject).delete();
        }
      }
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (700 == i)
    {
      localObject = new File(PatchCommonUtil.getPatchPath(paramytb.b()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramytb.b())) {
        i = 700;
      }
    }
    for (;;)
    {
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, "", "actPatchUnzip", i, str1);
      if (700 == i)
      {
        return true;
        i = 701;
        break;
      }
      return false;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    ytb localytb = ytc.a(BaseApplicationImpl.sApplication, "dex");
    if ((localytb != null) && (localytb.a(BaseApplicationImpl.sApplication, false)))
    {
      String str = localytb.b();
      File localFile = new File(PatchCommonUtil.getPatchPath(str));
      int i;
      if ((!localFile.exists()) || (localFile.length() != localytb.b()))
      {
        i = j;
        if (localFile.exists())
        {
          localFile.delete();
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0) {
          ((yst)paramQQAppInterface.getManager(120)).a(0, "dex", localytb);
        }
        return;
        if (!PatchChecker.checkPatchValid("dex", str))
        {
          localFile.delete();
          i = j;
        }
        else
        {
          i = 0;
          xfs.c();
        }
      }
    }
    xfs.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */