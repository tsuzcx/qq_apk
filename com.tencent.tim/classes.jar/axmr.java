import android.content.res.AssetManager;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.1;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.4;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.5;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class axmr
{
  private static volatile axmr a;
  private static final String cVw = axjj.b.b.cVe;
  private volatile boolean dvt;
  private volatile boolean dvu;
  private final Map<String, AEEditorDownloadResBean> qL = new LinkedHashMap();
  private final Map<String, AtomicBoolean> qM = new HashMap();
  private final Map<String, List<axmr.a>> qN = new HashMap();
  private final axzu<List<AEEditorFilterBean>> y = new axzu();
  
  private axmr()
  {
    eMP();
  }
  
  public static axmr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new axmr();
      }
      return a;
    }
    finally {}
  }
  
  @NotNull
  private String a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return cVw + File.separator + paramAEEditorDownloadResBean.getId() + File.separator + paramAEEditorDownloadResBean.getMd5();
  }
  
  private void a(@NotNull AEEditorDownloadResBean paramAEEditorDownloadResBean, axmr.a parama)
  {
    axiy.i("AEEditorFiltersManager", "downLoadOneResInternal---BEGIN: id=" + paramAEEditorDownloadResBean.getId());
    String str = paramAEEditorDownloadResBean.getMd5();
    AtomicBoolean localAtomicBoolean;
    synchronized (this.qM)
    {
      if ((AtomicBoolean)this.qM.get(str) == null) {
        this.qM.put(str, new AtomicBoolean(false));
      }
      localAtomicBoolean = (AtomicBoolean)this.qM.get(str);
    }
    try
    {
      if (localAtomicBoolean.get())
      {
        localObject2 = (List)this.qN.get(str);
        ??? = localObject2;
        if (localObject2 == null)
        {
          ??? = new ArrayList();
          this.qN.put(str, ???);
        }
        if (parama != null) {
          ((List)???).add(parama);
        }
        axiy.i("AEEditorFiltersManager", "downLoadOneResInternal---is DOWNLOADING: id=" + paramAEEditorDownloadResBean.getId());
        return;
        paramAEEditorDownloadResBean = finally;
        throw paramAEEditorDownloadResBean;
      }
      localAtomicBoolean.compareAndSet(false, true);
      if (a(paramAEEditorDownloadResBean))
      {
        if (parama != null) {
          parama.Ys(true);
        }
        dS(str, true);
        axiy.i("AEEditorFiltersManager", "downLoadOneResInternal---is DOWNLOADED by other: id=" + paramAEEditorDownloadResBean.getId());
        return;
      }
    }
    finally {}
    ??? = cVw + File.separator + paramAEEditorDownloadResBean.getId() + File.separator;
    aqhq.cn((String)???);
    Object localObject2 = (String)??? + str + ".zip";
    axiv.a().a(paramAEEditorDownloadResBean.getUrl(), (String)localObject2, new axmv(this, parama, str, paramAEEditorDownloadResBean, (String)localObject2, (String)???));
  }
  
  private boolean a(@NotNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return new File(a(paramAEEditorDownloadResBean)).exists();
  }
  
  private void dS(String paramString, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.qM.get(paramString);
    if (localAtomicBoolean == null) {
      return;
    }
    try
    {
      localAtomicBoolean.compareAndSet(true, false);
      paramString = (List)this.qN.get(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          axmr.a locala = (axmr.a)localIterator.next();
          if (locala != null) {
            locala.Ys(paramBoolean);
          }
        }
        paramString.clear();
      }
    }
    finally {}
  }
  
  private void eMP()
  {
    axiy.i("AEEditorFiltersManager", "loadAssets");
    ThreadManager.excute(new AEEditorFiltersManager.1(this), 64, null, true);
  }
  
  @WorkerThread
  private void eMQ()
  {
    axiy.i("AEEditorFiltersManager", "setupDisplayFilterList--BEGIN");
    Object localObject1 = sI("camera/ae_camera_editor_display_filters.json");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      axiy.e("AEEditorFiltersManager", "setupDisplayFilterList---read assets json content empty");
      return;
    }
    Object localObject3 = new Gson();
    try
    {
      localObject1 = (List)((Gson)localObject3).fromJson((String)localObject1, new axms(this).getType());
      StringBuilder localStringBuilder = new StringBuilder().append("setupDisplayFilterList---filters size = ");
      if (localObject1 == null)
      {
        localObject3 = "null";
        axiy.i("AEEditorFiltersManager", localObject3);
        this.y.postValue(localObject1);
        return;
      }
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      for (;;)
      {
        axiy.e("AEEditorFiltersManager", "setupDisplayFilterList---parse json exception: ", localJsonSyntaxException);
        localJsonSyntaxException.printStackTrace();
        Object localObject2 = null;
        continue;
        localObject3 = Integer.valueOf(localObject2.size());
      }
    }
  }
  
  @WorkerThread
  private void eMR()
  {
    Object localObject3;
    synchronized (this.qL)
    {
      if (this.dvt) {
        return;
      }
      this.dvt = true;
      axiy.i("AEEditorFiltersManager", "ensureSetupDownloadConfig--BEGIN");
      localObject3 = sI("camera/ae_camera_editor_download_resources.json");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        axiy.e("AEEditorFiltersManager", "ensureSetupDownloadConfig---read assets json content empty");
        return;
      }
    }
    Object localObject4 = new Gson();
    Object localObject2 = null;
    try
    {
      localObject3 = (List)((Gson)localObject4).fromJson((String)localObject3, new axmt(this).getType());
      localObject2 = localObject3;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      for (;;)
      {
        axiy.e("AEEditorFiltersManager", "ensureSetupDownloadConfig---parse json exception: ", localJsonSyntaxException);
        localJsonSyntaxException.printStackTrace();
        continue;
        Integer localInteger = Integer.valueOf(((List)localObject2).size());
      }
    }
    localObject4 = new StringBuilder().append("ensureSetupDownloadConfig---size = ");
    if (localObject2 == null)
    {
      localObject3 = "null";
      axiy.i("AEEditorFiltersManager", localObject3);
      if (localObject2 == null) {
        break label210;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEEditorDownloadResBean)((Iterator)localObject2).next();
        this.qL.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
      }
    }
    label210:
  }
  
  private boolean j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      int i;
      try
      {
        jqp.b(new File(paramString1), paramString2);
        paramString1 = new File(paramString2);
        if ((paramString1.exists()) && (paramString1.isDirectory()))
        {
          paramString1 = paramString1.listFiles();
          if ((paramString1 == null) || (paramString1.length <= 0)) {
            break label230;
          }
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            Object localObject = paramString1[i];
            if (!localObject.getName().equals(paramString3)) {
              break label232;
            }
            axiy.i("AEEditorFiltersManager", "begin rename zip folder---from: " + localObject.getName() + ", to: " + paramString4);
            return aqhq.rename(paramString2 + paramString3, paramString2 + paramString4);
          }
          axiy.e("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--NOT found folder named " + paramString3);
          return false;
        }
      }
      catch (Exception paramString1)
      {
        axiy.e("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--exception ", paramString1);
        paramString1.printStackTrace();
        return false;
      }
      axiy.e("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--toDir not exists or not a directory: " + paramString1);
      label230:
      return false;
      label232:
      i += 1;
    }
  }
  
  @WorkerThread
  private String sI(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getAssets().open(paramString);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        String str2 = jqo.e(localInputStream);
        paramString = str2;
        localObject2 = paramString;
      }
      catch (Throwable localThrowable)
      {
        InputStream localInputStream;
        localObject2 = localIOException1;
        axiy.e("AEEditorFiltersManager", "readAssetsFileContent---read assets json exception: fileName=" + paramString, localThrowable);
        localObject2 = localIOException1;
        localThrowable.printStackTrace();
        localObject2 = str1;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return "";
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label131;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = paramString;
        return localObject2;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramString;
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      label131:
      throw paramString;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  public String HX()
  {
    eMR();
    return a((AEEditorDownloadResBean)this.qL.get("AIPhotoConfig"));
  }
  
  public String HY()
  {
    eMR();
    return a((AEEditorDownloadResBean)this.qL.get("AIVideoConfig"));
  }
  
  @Nullable
  public String a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    if (paramAEEditorFilterBean == null) {
      return null;
    }
    eMR();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.qL.get(paramAEEditorFilterBean.getSid());
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramAEEditorFilterBean.getLutName();
  }
  
  public void a(String paramString, axmr.a parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (parama != null) {
        parama.Ys(false);
      }
      return;
    }
    ThreadManager.excute(new AEEditorFiltersManager.5(this, paramString, parama), 128, null, false);
  }
  
  public boolean aPa()
  {
    return new File(HX()).exists();
  }
  
  public boolean aPb()
  {
    return new File(HY()).exists();
  }
  
  public void eMS()
  {
    if (this.dvu) {
      return;
    }
    this.dvu = true;
    ThreadManager.excute(new AEEditorFiltersManager.4(this), 128, null, false);
  }
  
  public axzu<List<AEEditorFilterBean>> s()
  {
    return this.y;
  }
  
  @Nullable
  public String sJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    eMR();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.qL.get(paramString);
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramString + ".png";
  }
  
  public static abstract interface a
  {
    public abstract void Ys(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmr
 * JD-Core Version:    0.7.0.1
 */