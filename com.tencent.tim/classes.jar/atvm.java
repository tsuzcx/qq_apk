import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.WpsFileEditManager.FileOverWriter.2.1;
import com.tencent.tim.filemanager.core.WpsFileEditManager.d;
import com.tencent.tim.filemanager.core.WpsFileEditManager.l;
import com.tencent.tim.filemanager.core.WpsFileEditManager.m;

public class atvm
  extends AsyncTask<WpsFileEditManager.l, Integer, WpsFileEditManager.l>
{
  public atvm(WpsFileEditManager.d paramd) {}
  
  protected WpsFileEditManager.l a(WpsFileEditManager.l... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    String str = this.a.EY();
    QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync. copy wpsFilePath:" + paramVarArgs.cHV + "to tempPath:" + str);
    if (!aqhq.copyFile(paramVarArgs.cHV, str))
    {
      QLog.e("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync copy failed");
      paramVarArgs.errCode = WpsFileEditManager.m.eqX;
      return paramVarArgs;
    }
    QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync. delete filePath:" + this.a.filePath);
    if ((aueh.isFileExists(this.a.filePath)) && (!aqhq.deleteFile(this.a.filePath)))
    {
      QLog.e("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync delete file failed");
      paramVarArgs.errCode = WpsFileEditManager.m.eqZ;
      return paramVarArgs;
    }
    QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync. rename");
    if (!aqhq.rename(str, this.a.filePath))
    {
      QLog.e("WpsFileEditManager", 1, "[WPSEDIT]<" + paramVarArgs.sessionid + "> overWriteFileAsync rename file failed. lose orignal file");
      paramVarArgs.errCode = WpsFileEditManager.m.era;
      return paramVarArgs;
    }
    paramVarArgs.errCode = WpsFileEditManager.m.NONE;
    return paramVarArgs;
  }
  
  protected void b(WpsFileEditManager.l paraml)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new WpsFileEditManager.FileOverWriter.2.1(this, paraml));
      return;
    }
    this.a.a(paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvm
 * JD-Core Version:    0.7.0.1
 */