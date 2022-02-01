import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.business.manager.Checker.1;
import com.tencent.av.business.manager.EffectConfigBase.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ijr
  implements Handler.Callback
{
  private auru a = new auru(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, ijr.a> aB = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> g = new ConcurrentLinkedQueue();
  
  private void a(String paramString, ijr.a parama)
  {
    if (parama == null)
    {
      and();
      return;
    }
    if (parama.tu())
    {
      and();
      return;
    }
    if (parama.a == null)
    {
      parama.anK += 1;
      and();
      return;
    }
    parama.anK += 1;
    ThreadManager.excute(new Checker.1(this, parama, paramString), 16, null, false);
  }
  
  private void and()
  {
    if ((this.g.size() > 0) && (!this.a.hasMessages(1))) {
      this.a.sendEmptyMessage(1);
    }
  }
  
  public void a(EffectConfigBase.b paramb, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramb == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.g.contains(localObject))) {
        break label51;
      }
    }
    label51:
    ijr.a locala1;
    do
    {
      return;
      localObject = paramb.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramb + "]");
      }
      ijr.a locala2 = (ijr.a)this.aB.get(localObject);
      locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new ijr.a(paramb, paramArrayList, paramBoolean);
        locala1.zipPath = paramString1;
        locala1.Ng = paramString2;
        this.aB.put(localObject, locala1);
      }
    } while (locala1.tu());
    this.g.offer(localObject);
    and();
  }
  
  public void b(String paramString, ijr.a parama)
  {
    boolean bool = parama.a.isUsable();
    int j;
    if ((bool) && (!aqhq.fileExists(parama.Ng))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        aqhq.W(parama.zipPath, parama.Ng, false);
        parama.RJ = true;
        if ((!parama.RJ) && (parama.tu()) && (parama.RI))
        {
          aqhq.deleteFile(parama.zipPath);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + parama.zipPath + "]");
          }
        }
        return;
        if ((bool) && (parama.ik.size() > 0))
        {
          i = 0;
          label144:
          if (i < parama.ik.size())
          {
            String str = (String)parama.ik.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (parama.Ng.endsWith(File.separator)) {}
              for (str = parama.Ng + str;; str = parama.Ng + File.separator + str)
              {
                if (aqhq.fileExists(str)) {
                  break label327;
                }
                if (!QLog.isColorLevel()) {
                  break label371;
                }
                QLog.i("Checker", 2, "realCheck, id[" + paramString + "], unExistFile[" + str + "]");
                i = 1;
                j = i;
                if (i == 0) {
                  break;
                }
                aqhq.cn(parama.Ng);
                j = i;
                break;
              }
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          parama.RJ = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + parama + "]", localIOException);
          continue;
          label371:
          int i = 1;
          continue;
          i = 0;
        }
        j = 0;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)this.g.poll();
      paramMessage = null;
      if (!TextUtils.isEmpty(str)) {
        paramMessage = (ijr.a)this.aB.get(str);
      }
      a(str, paramMessage);
    }
    return true;
  }
  
  public static class a
  {
    String Ng;
    boolean RI = false;
    boolean RJ = false;
    final EffectConfigBase.b a;
    int anK = 0;
    final ArrayList<String> ik = new ArrayList(0);
    public String zipPath;
    
    a(EffectConfigBase.b paramb, ArrayList<String> paramArrayList, boolean paramBoolean)
    {
      this.a = paramb;
      this.anK = 0;
      if (paramArrayList != null) {
        this.ik.addAll(paramArrayList);
      }
      this.RI = paramBoolean;
    }
    
    public String toString()
    {
      return "ItemRecord{" + this.a + "," + this.anK + "," + this.zipPath + "," + this.Ng + "}";
    }
    
    boolean tu()
    {
      return this.anK >= 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijr
 * JD-Core Version:    0.7.0.1
 */