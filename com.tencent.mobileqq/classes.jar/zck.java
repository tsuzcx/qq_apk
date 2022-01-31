import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.UpdateManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class zck
{
  private static void a()
  {
    zcq localzcq = zcr.a(BaseApplicationImpl.sApplication, "Native");
    if (localzcq != null) {
      UpdateManager.a(localzcq.e());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface);
    a();
  }
  
  public static boolean a(zcq paramzcq)
  {
    int j = 701;
    String str1 = paramzcq.c();
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
      localObject = new File(PatchCommonUtil.getPatchPath(paramzcq.b()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramzcq.b())) {
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
    zcq localzcq = zcr.a(BaseApplicationImpl.sApplication, "dex");
    if ((localzcq != null) && (localzcq.a(BaseApplicationImpl.sApplication, false)))
    {
      String str = localzcq.b();
      File localFile = new File(PatchCommonUtil.getPatchPath(str));
      int i;
      if ((!localFile.exists()) || (localFile.length() != localzcq.b()))
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
          ((zci)paramQQAppInterface.getManager(120)).a(0, "dex", localzcq);
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
          xop.c();
        }
      }
    }
    xop.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zck
 * JD-Core Version:    0.7.0.1
 */