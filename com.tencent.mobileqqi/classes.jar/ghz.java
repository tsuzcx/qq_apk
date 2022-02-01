import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ghz
  extends AsyncTask
{
  public ghz(StatusManager paramStatusManager) {}
  
  private void a(long paramLong)
  {
    long l = StatusManager.a(this.a).getLong("k_icon", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask clearIcons " + l + ", " + paramLong + ", " + 28L);
    }
    Object localObject;
    if (l < paramLong)
    {
      localObject = null;
      if (paramLong <= 28L) {
        break label180;
      }
    }
    for (;;)
    {
      try
      {
        InputStream localInputStream = StatusManager.a(this.a).a().getAssets().open("rich_status.xml");
        localObject = localInputStream;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject = (SparseArray)StatusManager.a(this.a, localObject)[0];
      if (StatusManager.a(this.a, (SparseArray)localObject, StatusManager.a(this.a))) {
        StatusManager.a(this.a).edit().putLong("k_icon", paramLong).commit();
      }
      return;
      try
      {
        label180:
        FileInputStream localFileInputStream = new FileInputStream(new File(StatusManager.a(this.a).a().getFilesDir(), "rich_status.xml"));
        localObject = localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = StatusManager.a(this.a).getLong("k_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local with file " + l + ", " + 28L);
    }
    if (l > 28L) {}
    ArrayList localArrayList;
    label221:
    for (;;)
    {
      try
      {
        paramVarArgs = new FileInputStream(new File(StatusManager.a(this.a).a().getFilesDir(), "rich_status.xml"));
        if (paramVarArgs != null) {
          break label221;
        }
        Object localObject;
        paramVarArgs = null;
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          localObject = StatusManager.a(this.a).a().getAssets().open("rich_status.xml");
          paramVarArgs = (Void[])localObject;
          l = 28L;
          localObject = StatusManager.a(this.a, paramVarArgs);
          paramVarArgs = (SparseArray)localObject[0];
          localArrayList = (ArrayList)localObject[1];
          if ((paramVarArgs != null) && (paramVarArgs.size() != 0) && (localArrayList != null) && (localArrayList.size() != 0)) {
            break;
          }
          publishProgress(new Integer[] { Integer.valueOf(-1) });
          a(l);
          return Integer.valueOf(100);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
      }
    }
    for (;;)
    {
      synchronized (StatusManager.a(this.a))
      {
        if ((!isCancelled()) && (StatusManager.a(this.a).size() == 0))
        {
          StatusManager.a(this.a, paramVarArgs);
          StatusManager.a(this.a).clear();
          StatusManager.a(this.a).addAll(localArrayList);
          publishProgress(new Integer[] { Integer.valueOf(102) });
        }
      }
      cancel(true);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onPostExecute " + paramInteger);
    }
    StatusManager.a(this.a, null);
    if (101 == StatusManager.a(this.a, false)) {
      StatusManager.a(this.a);
    }
    this.a.a(false);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onProgressUpdate " + i);
    }
    if (StatusManager.a(this.a) != null)
    {
      paramVarArgs = StatusManager.a(this.a).iterator();
      while (paramVarArgs.hasNext()) {
        ((IActionListener)paramVarArgs.next()).a(i, 300);
      }
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
    }
    StatusManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghz
 * JD-Core Version:    0.7.0.1
 */