import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.StateTag;
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

public class edz
  extends AsyncTask
{
  public edz(StatusManager paramStatusManager) {}
  
  private void a(long paramLong)
  {
    long l = StatusManager.a(this.a).getLong("k_icon", 0L);
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
  
  protected Integer a(Void... arg1)
  {
    long l = StatusManager.a(this.a).getLong("k_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local with file " + l + ", " + 65L);
    }
    if (l > 65L) {}
    ArrayList localArrayList;
    label226:
    for (;;)
    {
      try
      {
        ??? = new FileInputStream(new File(StatusManager.a(this.a).a().getFilesDir(), "rich_status.xml"));
        if (??? != null) {
          break label226;
        }
        Object localObject1;
        ??? = null;
      }
      catch (FileNotFoundException ???)
      {
        try
        {
          localObject1 = StatusManager.a(this.a).a().getAssets().open("rich_status.xml");
          ??? = (Void[])localObject1;
          l = 65L;
          ??? = StatusManager.a(this.a, ???);
          localObject1 = (SparseArray)???[0];
          localArrayList = (ArrayList)???[1];
          if ((localObject1 != null) && (((SparseArray)localObject1).size() != 0) && (localArrayList != null) && (localArrayList.size() != 0)) {
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
        ??? = ???;
        ???.printStackTrace();
      }
    }
    for (;;)
    {
      int i;
      int j;
      synchronized (StatusManager.a(this.a))
      {
        if ((!isCancelled()) && (StatusManager.a(this.a).size() == 0))
        {
          StatusManager.a(this.a, localIOException);
          StatusManager.a(this.a).clear();
          StatusManager.a(this.a).addAll(localArrayList);
          publishProgress(new Integer[] { Integer.valueOf(102) });
          i = 0;
          if (i < StatusManager.a(this.a).size())
          {
            StateTag localStateTag = (StateTag)StatusManager.a(this.a).get(i);
            if (!localStateTag.jdField_a_of_type_JavaLangString.equals("日常生活")) {
              break label425;
            }
            j = 0;
            if (j >= localStateTag.jdField_a_of_type_JavaUtilArrayList.size()) {
              break label425;
            }
            if (((Integer)localStateTag.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue() != 15) {
              break label418;
            }
            localStateTag.jdField_a_of_type_JavaUtilArrayList.remove(j);
            break label418;
          }
        }
        else
        {
          cancel(true);
        }
      }
      label418:
      j += 1;
      continue;
      label425:
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edz
 * JD-Core Version:    0.7.0.1
 */