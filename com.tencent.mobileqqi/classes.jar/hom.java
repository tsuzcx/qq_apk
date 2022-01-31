import android.text.TextUtils;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import java.io.File;

public final class hom
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(Common.a());
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.getName().startsWith("system_old_")) || ((localFile2.isDirectory()) && (!localFile2.getName().equals("tmp")) && (!TextUtils.isEmpty(Common.p())) && (!localFile2.getName().equals(Common.p()))))
        {
          if (!FileUtils.a(new File(localFile1 + File.separator + localFile2.getName()))) {
            break label179;
          }
          LogUtility.b("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> successful");
        }
        for (;;)
        {
          i += 1;
          break;
          label179:
          LogUtility.c("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hom
 * JD-Core Version:    0.7.0.1
 */