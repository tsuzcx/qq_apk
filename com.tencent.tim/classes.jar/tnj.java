import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class tnj
{
  public static boolean a(tnp paramtnp)
  {
    int j = 701;
    String str1 = paramtnp.ou();
    Object localObject = PatchCommonUtil.getPatchPath(str1);
    String str2 = PatchCommonUtil.getPatchPath("");
    try
    {
      i = LzmaUtils.m(BaseApplicationImpl.sApplication, (String)localObject, str2);
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
      localObject = new File(PatchCommonUtil.getPatchPath(paramtnp.ot()));
      if ((((File)localObject).exists()) && (((File)localObject).length() == paramtnp.uY())) {
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
  
  public static void aE(QQAppInterface paramQQAppInterface)
  {
    aF(paramQQAppInterface);
  }
  
  private static void aF(QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    tnp localtnp = tnq.a(BaseApplicationImpl.sApplication, "dex");
    if ((localtnp != null) && (localtnp.i(BaseApplicationImpl.sApplication, false)))
    {
      String str = localtnp.ot();
      File localFile = new File(PatchCommonUtil.getPatchPath(str));
      int i;
      if ((!localFile.exists()) || (localFile.length() != localtnp.uY()))
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
          ((tni)paramQQAppInterface.getManager(120)).a(0, "dex", localtnp);
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
          swu.bBB();
        }
      }
    }
    swu.bBB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnj
 * JD-Core Version:    0.7.0.1
 */