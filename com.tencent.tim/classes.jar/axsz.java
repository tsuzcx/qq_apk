import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.1;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.2;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(16)
public class axsz
  extends axon
{
  private static File bo = new File(axwf.g(), "information_paster");
  private static String cWc = bo.getPath() + File.separator;
  private ConcurrentLinkedQueue<ayna.c> X = new ConcurrentLinkedQueue();
  public axsz.b a = null;
  private java.lang.ref.WeakReference<RelativeLayout> jm;
  private Context mContext;
  private RelativeLayout nZ;
  
  public static String Ig()
  {
    return cWc;
  }
  
  public static String a(ayna.c paramc)
  {
    paramc = paramc.resName + "_" + paramc.tT + ".zip";
    return new File(bo, paramc).getPath();
  }
  
  public static String b(ayna.c paramc)
  {
    return cWc + paramc.resName + "_" + paramc.tT + File.separator + paramc.resName;
  }
  
  private boolean b(ayna.c paramc)
  {
    if (bo != null)
    {
      int i;
      boolean bool1;
      label44:
      String str;
      if (!bo.exists())
      {
        bo.mkdirs();
        String[] arrayOfString = bo.list();
        if (arrayOfString == null) {
          break label229;
        }
        int j = arrayOfString.length;
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i >= j) {
          break label232;
        }
        str = arrayOfString[i];
        bool2 = bool1;
        if (str.startsWith(paramc.resName))
        {
          if (!str.endsWith(".zip")) {
            break label151;
          }
          aqhq.delete(bo + str, false);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break label44;
        if (bo.isDirectory()) {
          break;
        }
        bo.delete();
        bo.mkdirs();
        break;
        label151:
        if (str.endsWith(paramc.tT))
        {
          bool2 = true;
        }
        else
        {
          bool2 = bool1;
          if (!str.endsWith("png"))
          {
            bool2 = bool1;
            if (!str.endsWith("tmp"))
            {
              aqhq.delete(cWc + str, false);
              bool2 = bool1;
            }
          }
        }
      }
      label229:
      boolean bool2 = false;
      label232:
      return bool2;
    }
    return false;
  }
  
  public void a(ayna.c paramc, axsz.a parama)
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, paramc, parama), null, true);
  }
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      ayna.c localc = (ayna.c)paramDoodleEmojiItem.next();
      if ((localc.predownload == 1) && (!a(localc))) {
        a(localc, new axtb(this));
      }
    }
  }
  
  public boolean a(ayna.c paramc)
  {
    if (TextUtils.isEmpty(paramc.resUrl)) {
      if (paramc.eKF != 7) {}
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          return true;
        } while (!b(paramc));
        localObject = b(paramc);
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
        }
        localObject = new File((String)localObject);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length != aynb.a(paramc)));
    return true;
  }
  
  public boolean c(ayna.c paramc)
  {
    return this.a.isDownloading(paramc.resUrl);
  }
  
  public boolean d(ayna.c paramc)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(cWc + paramc.resName + "_" + paramc.tT);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      jqp.b(new File(a(paramc)), localFile.getAbsolutePath() + File.separator);
      bool = true;
    }
    catch (Exception paramc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIMInformationPasterManager", 2, paramc, new Object[0]);
    }
    return bool;
    return false;
  }
  
  public void eOM()
  {
    if ((this.nZ != null) && (this.jm != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jm.get();
      if (localRelativeLayout != null)
      {
        localRelativeLayout.removeView(this.nZ);
        this.jm = null;
        this.nZ = null;
      }
    }
  }
  
  public void oK(List<ayna.c> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public void onDestroy() {}
  
  public void onInit()
  {
    this.mContext = BaseApplication.getContext();
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat, String paramString, int paramInt);
    
    public abstract void a(boolean paramBoolean, String paramString, ayna.c paramc);
  }
  
  public static class b
  {
    private axsz b;
    private ConcurrentHashMap<String, ArrayList<mqq.util.WeakReference<axsz.a>>> kk = new ConcurrentHashMap();
    
    public b(axsz paramaxsz)
    {
      this.b = paramaxsz;
    }
    
    public void b(@NonNull ayna.c paramc, axsz.a parama)
    {
      String str = paramc.resUrl;
      if ((str == null) || (TextUtils.isEmpty(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicText res url: " + str);
      }
      for (;;)
      {
        synchronized (this.kk)
        {
          localArrayList = (ArrayList)this.kk.get(str);
          if (localArrayList != null)
          {
            paramc = localArrayList.iterator();
            if (!paramc.hasNext()) {
              break label292;
            }
            if (((mqq.util.WeakReference)paramc.next()).get() != parama) {
              continue;
            }
            i = 1;
            if (i == 0) {
              localArrayList.add(new mqq.util.WeakReference(parama));
            }
            if (QLog.isColorLevel()) {
              QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
            }
            return;
          }
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new mqq.util.WeakReference(parama));
        this.kk.put(str, localArrayList);
        parama = new aoll();
        parama.f = new axtc(this);
        parama.bZ = str;
        parama.mHttpMethod = 0;
        parama.atY = axsz.a(paramc);
        parama.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        parama.bw(paramc);
        ige.a().a(parama);
        return;
        label292:
        int i = 0;
      }
    }
    
    public boolean isDownloading(String paramString)
    {
      return this.kk.get(paramString) != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsz
 * JD-Core Version:    0.7.0.1
 */