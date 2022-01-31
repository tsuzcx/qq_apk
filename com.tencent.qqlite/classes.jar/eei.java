import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class eei
  extends AsyncTask
  implements Runnable
{
  private String a;
  private String b;
  
  public eei(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      Object localObject = BaseApplicationImpl.a;
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "CreateSkinEngineCacheTask start");
      }
      paramVarArgs = new File(((BaseApplicationImpl)localObject).getCacheDir(), this.a);
      File localFile1 = new File(((BaseApplicationImpl)localObject).getCacheDir(), this.b);
      localObject = new File(((BaseApplicationImpl)localObject).getCacheDir(), this.b + ".tmp");
      File localFile2 = paramVarArgs.getParentFile();
      if (!localFile2.exists()) {
        localFile2.mkdirs();
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
      if (paramVarArgs.exists()) {
        paramVarArgs.delete();
      }
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramVarArgs.createNewFile();
      SkinEngine.getInstances().writeCacheFile((File)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).renameTo(localFile1);
      }
      paramVarArgs = new ObjectOutputStream(new FileOutputStream(paramVarArgs));
      paramVarArgs.writeInt(AppSetting.a);
      paramVarArgs.writeUTF("108074");
      paramVarArgs.close();
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SkinEngine", 2, "", paramVarArgs);
        }
      }
    }
    return null;
  }
  
  public void run()
  {
    Utils.executeAsyncTaskOnThreadPool(this, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eei
 * JD-Core Version:    0.7.0.1
 */