import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
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

class amhk
  extends AsyncTask<Void, Integer, Integer>
{
  amhk(amhj paramamhj) {}
  
  private void lf(long paramLong)
  {
    long l = amhj.a(this.e).getLong("k_icon", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask clearIcons " + l + ", " + paramLong + ", " + 65L);
    }
    Object localObject;
    if (l < paramLong)
    {
      localObject = null;
      if (paramLong <= 65L) {
        break label180;
      }
    }
    for (;;)
    {
      try
      {
        InputStream localInputStream = amhj.a(this.e).getApp().getAssets().open("rich_status.xml");
        localObject = localInputStream;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject = (SparseArray)amhj.a(this.e, localObject)[0];
      if (amhj.a(this.e, (SparseArray)localObject, amhj.a(this.e))) {
        amhj.a(this.e).edit().putLong("k_icon", paramLong).commit();
      }
      return;
      try
      {
        label180:
        FileInputStream localFileInputStream = new FileInputStream(new File(amhj.a(this.e).getApp().getFilesDir(), "rich_status.xml"));
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
    long l = amhj.a(this.e).getLong("k_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local with file " + l + ", " + 65L);
    }
    if (l > 65L) {}
    ArrayList localArrayList;
    label221:
    for (;;)
    {
      try
      {
        paramVarArgs = new FileInputStream(new File(amhj.a(this.e).getApp().getFilesDir(), "rich_status.xml"));
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
          localObject = amhj.a(this.e).getApp().getAssets().open("rich_status.xml");
          paramVarArgs = (Void[])localObject;
          l = 65L;
          localObject = amhj.a(this.e, paramVarArgs);
          paramVarArgs = (SparseArray)localObject[0];
          localArrayList = (ArrayList)localObject[1];
          if ((paramVarArgs != null) && (paramVarArgs.size() != 0) && (localArrayList != null) && (localArrayList.size() != 0)) {
            break;
          }
          publishProgress(new Integer[] { Integer.valueOf(-1) });
          lf(l);
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
      synchronized (amhj.a(this.e))
      {
        if ((!isCancelled()) && (amhj.a(this.e).size() == 0))
        {
          amhj.a(this.e, paramVarArgs);
          amhj.a(this.e).clear();
          amhj.a(this.e).addAll(localArrayList);
          publishProgress(new Integer[] { Integer.valueOf(102) });
        }
      }
      cancel(true);
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
    }
    amhj.a(this.e, null);
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onPostExecute " + paramInteger);
    }
    amhj.a(this.e, null);
    if (101 == amhj.a(this.e, false)) {
      amhj.a(this.e);
    }
    this.e.Ph(false);
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onProgressUpdate " + i);
    }
    if (amhj.a(this.e) != null)
    {
      paramVarArgs = amhj.a(this.e).iterator();
      while (paramVarArgs.hasNext()) {
        ((amff)paramVarArgs.next()).fk(i, 300);
      }
    }
    ld.a().E(i, 300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhk
 * JD-Core Version:    0.7.0.1
 */