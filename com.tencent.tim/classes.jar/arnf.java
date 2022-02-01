import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor;
import com.tencent.monitor.file.ExternalDirFileOperationMonitor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class arnf
  implements IFileMonitor
{
  private static Set<String> dl = new HashSet();
  String cAL;
  Context context;
  
  public arnf(Context paramContext)
  {
    File localFile = paramContext.getExternalCacheDir();
    if (localFile != null) {
      this.cAL = localFile.getParent();
    }
    this.context = paramContext;
  }
  
  private static void Wy(String paramString)
  {
    ThreadManagerV2.excute(new ExternalDirFileOperationMonitor.1(paramString), 16, null, false);
  }
  
  private void aS(String paramString, int paramInt1, int paramInt2)
  {
    if (!sh(paramString)) {}
    String str;
    do
    {
      return;
      str = String.format(Locale.getDefault(), "external file open %s, flags %d, mode %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      QLog.e("ExternalDirFileOperationMonitor", 1, str);
      QLog.e("ExternalDirFileOperationMonitor", 1, new Throwable("EXTERNAL_FILE_OPEN_DIR:" + qr(paramString)), new Object[0]);
      Intent localIntent = new Intent();
      localIntent.setAction("action.file.path.change");
      localIntent.putExtra("path", paramString);
      BaseApplication.getContext().sendBroadcast(localIntent);
      paramInt1 = arng.bw(this.context);
    } while (new Random().nextInt(paramInt1) > 1);
    annt.e(new Throwable("EXTERNAL_FILE_OPEN_DIR:" + qr(paramString)), str);
    Wy(qr(paramString));
  }
  
  private String qr(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    if (i <= 0) {
      return "";
    }
    return paramString.substring(0, i);
  }
  
  private boolean sg(String paramString)
  {
    if ((this.cAL == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    if ((!paramString.startsWith(arng.cAM)) || (paramString.startsWith(this.cAL))) {
      return true;
    }
    Iterator localIterator = arnh.b().Jv.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean sh(String paramString)
  {
    if (!paramString.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath())) {}
    do
    {
      do
      {
        return false;
      } while ((this.cAL == null) || (TextUtils.isEmpty(paramString)) || (paramString.startsWith(this.cAL)));
      paramString = qr(paramString);
    } while (dl.contains(paramString));
    dl.add(paramString);
    return true;
  }
  
  public void onFileOpen(String paramString, int paramInt1, int paramInt2)
  {
    aS(paramString, paramInt1, paramInt2);
  }
  
  public void onFileRemove(String paramString)
  {
    report(paramString, null);
  }
  
  public void onFileRename(String paramString1, String paramString2)
  {
    report(paramString1, paramString2);
  }
  
  void report(String paramString1, String paramString2)
  {
    if (!arng.co(this.context)) {}
    while (sg(paramString1)) {
      return;
    }
    if (paramString2 == null) {}
    for (paramString1 = String.format("external file deleted %s", new Object[] { paramString1 });; paramString1 = String.format("external file rename from %s to %s", new Object[] { paramString1, paramString2 }))
    {
      QLog.e("ExternalDirFileOperationMonitor", 1, paramString1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnf
 * JD-Core Version:    0.7.0.1
 */