package dov.com.qq.im.capture.text;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aoll;
import aolm;
import aomi;
import aqiw;
import axon;
import axrf;
import axug;
import axuh;
import axwf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ige;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jqp;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicTextConfigManager
  extends axon
{
  public static File bp = new File(axwf.g(), "dynamic_text");
  private static String cWh = bp.getPath() + File.separator + "usable" + File.separator;
  private ArrayList<DynamicTextConfigBean> Ge = new ArrayList();
  private a a = new a(this);
  public int aDH = 120;
  private String cWi;
  private String cWj;
  private String cWk;
  private String cWl;
  private volatile boolean dwB;
  private volatile boolean dwC;
  private boolean dwD;
  
  public static String a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.a parama)
  {
    return new File(bp, parama.Ih()).getPath();
  }
  
  public static boolean aPM()
  {
    boolean bool = new File(bp + File.separator + "dynamic_text_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "DynamicTextConfigManager isStickerConfigFileExist" + bool);
    }
    return bool;
  }
  
  private void adr(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("text_guide");
        if (paramString == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DText", 2, paramString.toString());
        }
        this.cWi = paramString.optString("default");
        this.cWj = paramString.optString("local_slides");
        this.cWk = paramString.optString("local_singlePhoto");
        this.cWl = paramString.optString("local_singleVideo");
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
        if (localSharedPreferences == null) {
          return;
        }
        if (paramString.optInt("is_text_guide_on") == 1)
        {
          this.dwD = bool;
          localSharedPreferences.edit().putBoolean("dynamic_text_key_is_hint_on", this.dwD).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_default", this.cWi).apply();
          localSharedPreferences.edit().putString("key_dynamic_text_hint_local_slides", this.cWj).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_photo", this.cWk).apply();
          localSharedPreferences.edit().putString("key_dtext_hint_single_video", this.cWl).apply();
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private ArrayList<DynamicTextConfigBean> as(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString).getJSONArray("texts");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        DynamicTextConfigBean localDynamicTextConfigBean = DynamicTextConfigBean.convertFrom(paramString.getJSONObject(i));
        if (localDynamicTextConfigBean != null)
        {
          localDynamicTextConfigBean.iconDrawableId = axug.lO(localDynamicTextConfigBean.text_id);
          localArrayList.add(localDynamicTextConfigBean);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public DynamicTextConfigBean a(String arg1)
  {
    try
    {
      i = Integer.valueOf(???).intValue();
      synchronized (this.Ge)
      {
        Iterator localIterator = this.Ge.iterator();
        while (localIterator.hasNext())
        {
          DynamicTextConfigBean localDynamicTextConfigBean = (DynamicTextConfigBean)localIterator.next();
          if ((localDynamicTextConfigBean != null) && (localDynamicTextConfigBean.text_id == i)) {
            return localDynamicTextConfigBean;
          }
        }
        return null;
      }
    }
    catch (Exception ???)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public void a(DynamicTextConfigBean paramDynamicTextConfigBean, b paramb)
  {
    if ((paramDynamicTextConfigBean == null) || (paramDynamicTextConfigBean.fontInfos == null)) {
      return;
    }
    ThreadManager.postImmediately(new DynamicTextConfigManager.1(this, paramDynamicTextConfigBean, paramb), null, true);
  }
  
  public boolean a(DynamicTextConfigManager.DynamicTextConfigBean.a parama)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((parama == null) || (TextUtils.isEmpty(parama.name))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(parama.resurl));
      if (!new File(bp, parama.Ih()).exists()) {
        return false;
      }
      bool1 = bool2;
    } while (new File(cWh + parama.name).exists());
    return false;
  }
  
  public boolean a(DynamicTextConfigBean paramDynamicTextConfigBean)
  {
    if (paramDynamicTextConfigBean == null) {
      return false;
    }
    if (paramDynamicTextConfigBean.fontInfos == null) {
      return true;
    }
    paramDynamicTextConfigBean = paramDynamicTextConfigBean.fontInfos.iterator();
    while (paramDynamicTextConfigBean.hasNext()) {
      if (!a((DynamicTextConfigManager.DynamicTextConfigBean.a)paramDynamicTextConfigBean.next())) {
        return false;
      }
    }
    return true;
  }
  
  public void aK(List<DynamicTextConfigBean> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((DynamicTextConfigBean)((Iterator)localObject).next()).text_id == 28) {
            ((Iterator)localObject).remove();
          }
        }
      } while (!paramBoolean);
      localObject = new DynamicTextConfigBean();
      ((DynamicTextConfigBean)localObject).text_id = 28;
      ((DynamicTextConfigBean)localObject).iconDrawableId = axug.lO(((DynamicTextConfigBean)localObject).text_id);
    } while ((paramList == null) || (paramList.size() <= 1));
    paramList.add(1, localObject);
  }
  
  public boolean aPL()
  {
    return (this.dwB) || (this.dwC);
  }
  
  public boolean aPN()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("dynamic_text_key_is_hint_on", false);
    }
    return bool;
  }
  
  public void adq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "handleDynamicTextConfig config is: " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString.trim())))
    {
      Object localObject2 = as(paramString);
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        synchronized (this.Ge)
        {
          this.Ge.clear();
          this.Ge.addAll((Collection)localObject2);
          adr(paramString);
          this.dwB = true;
          a().notifyObservers(axrf.class, 3, false, null);
          ??? = ((ArrayList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (DynamicTextConfigBean)((Iterator)???).next();
            if ((((DynamicTextConfigBean)localObject2).predownload == 1) && (!a((DynamicTextConfigBean)localObject2)) && (NetConnInfoCenter.isWifiConn())) {
              a((DynamicTextConfigBean)localObject2, null);
            }
          }
        }
        axwf.b(bp, "dynamic_text_config.cfg", paramString);
      }
    }
  }
  
  public String b(DynamicTextConfigManager.DynamicTextConfigBean.a parama)
  {
    if (parama == null) {
      return null;
    }
    return cWh + parama.name + File.separator;
  }
  
  public boolean b(DynamicTextConfigManager.DynamicTextConfigBean.a parama)
  {
    try
    {
      jqp.b(new File(bp, parama.Ih()), cWh);
      return true;
    }
    catch (Exception parama)
    {
      if (QLog.isColorLevel()) {
        parama.printStackTrace();
      }
    }
    return false;
  }
  
  public ArrayList<DynamicTextConfigBean> eM()
  {
    return this.Ge;
  }
  
  public void eOS()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "initConfigListByFile start");
    }
    if ((this.dwC) || (this.dwB)) {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "initConfigListByFile return by mIsInitByCache");
      }
    }
    for (;;)
    {
      return;
      if (aPM())
      {
        ??? = axwf.d(bp, "dynamic_text_config.cfg");
        Object localObject1 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile dir=" + bp + " file=" + "dynamic_text_config.cfg");
          localObject1 = ???;
        }
      }
      Object localObject3;
      for (;;)
      {
        synchronized (this.Ge)
        {
          if ((!this.dwB) && (!this.dwC)) {
            break;
          }
          return;
        }
        ??? = axwf.py("dynamic_text_config.cfg");
        localObject3 = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("DText", 2, "initConfigListByFile read from asset");
          localObject3 = ???;
        }
      }
      this.Ge.clear();
      ArrayList localArrayList = as((String)localObject3);
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.Ge.addAll(localArrayList);
      }
      adr((String)localObject3);
      this.dwC = true;
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (DynamicTextConfigBean)((Iterator)localObject3).next();
          if ((((DynamicTextConfigBean)???).predownload == 1) && (!a((DynamicTextConfigBean)???)) && (NetConnInfoCenter.isWifiConn())) {
            a((DynamicTextConfigBean)???, null);
          }
        }
      }
    }
  }
  
  public String gV(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DText", 2, "hint get from:" + paramInt);
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("dynamic_text_pre", 4);
    if (paramInt == 1)
    {
      if (this.cWj != null) {
        return this.cWj;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dynamic_text_hint_local_slides", "");
      }
    }
    else if (paramInt == 2)
    {
      if (this.cWk != null) {
        return this.cWk;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dtext_hint_single_photo", "");
      }
    }
    else if (paramInt == 3)
    {
      if (this.cWl != null) {
        return this.cWl;
      }
      if (localSharedPreferences != null) {
        return localSharedPreferences.getString("key_dtext_hint_single_video", "");
      }
    }
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("key_dynamic_text_hint_default", "");
    }
    return this.cWi;
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public static class DynamicTextConfigBean
  {
    public ArrayList<a> fontInfos = new ArrayList();
    public int iconDrawableId;
    public int predownload;
    public int text_id;
    
    public static DynamicTextConfigBean convertFrom(JSONObject paramJSONObject)
    {
      do
      {
        try
        {
          DynamicTextConfigBean localDynamicTextConfigBean = new DynamicTextConfigBean();
          int j;
          int i;
          Object localObject2 = paramJSONObject;
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            if (paramJSONObject.has("text_id")) {
              localDynamicTextConfigBean.text_id = paramJSONObject.getInt("text_id");
            }
            if (paramJSONObject.has("predownload")) {
              localDynamicTextConfigBean.predownload = paramJSONObject.getInt("predownload");
            }
            if (paramJSONObject.has("fonts"))
            {
              paramJSONObject = paramJSONObject.getJSONArray("fonts");
              j = paramJSONObject.length();
              i = 0;
              while (i < j)
              {
                localObject2 = a.a((JSONObject)paramJSONObject.get(i));
                ((a)localObject2).text_id = localDynamicTextConfigBean.text_id;
                if (localObject2 != null) {
                  localDynamicTextConfigBean.fontInfos.add(localObject2);
                }
                i += 1;
              }
            }
            localObject2 = localDynamicTextConfigBean;
            return localObject2;
          }
          catch (JSONException localJSONException2)
          {
            paramJSONObject = localJSONException1;
            Object localObject1 = localJSONException2;
            continue;
          }
          localJSONException1 = localJSONException1;
          paramJSONObject = null;
        }
      } while (!QLog.isColorLevel());
      QLog.i("DText", 2, localJSONException1.toString());
      return paramJSONObject;
    }
    
    public int getProgress()
    {
      int j;
      if (this.fontInfos == null)
      {
        j = 100;
        return j;
      }
      int k = this.fontInfos.size();
      Iterator localIterator = this.fontInfos.iterator();
      for (int i = 0;; i = ((a)localIterator.next()).progress * 1 / k + i)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    
    public boolean isContainsResUrl(String paramString)
    {
      if ((this.fontInfos == null) || (TextUtils.isEmpty(paramString))) {
        return false;
      }
      Iterator localIterator = this.fontInfos.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala != null) && (paramString.equals(locala.resurl))) {
          return true;
        }
      }
      return false;
    }
    
    public static class a
    {
      public String md5;
      public String name;
      public int progress;
      public String resurl;
      public int text_id;
      
      public static a a(JSONObject paramJSONObject)
      {
        a locala = new a();
        locala.resurl = paramJSONObject.optString("resurl");
        locala.md5 = paramJSONObject.optString("md5");
        locala.name = paramJSONObject.optString("name");
        locala.text_id = paramJSONObject.optInt("text_id");
        locala.progress = paramJSONObject.optInt("progress");
        return locala;
      }
      
      public String Ih()
      {
        return this.name + "_" + this.md5;
      }
    }
  }
  
  public static class a
  {
    private DynamicTextConfigManager c;
    private ConcurrentHashMap<String, ArrayList<WeakReference<DynamicTextConfigManager.b>>> kk = new ConcurrentHashMap();
    
    public a(DynamicTextConfigManager paramDynamicTextConfigManager)
    {
      this.c = paramDynamicTextConfigManager;
    }
    
    private void a(DynamicTextConfigManager.DynamicTextConfigBean.a parama)
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.name))) {}
      File[] arrayOfFile;
      do
      {
        return;
        arrayOfFile = DynamicTextConfigManager.bp.listFiles();
      } while ((arrayOfFile == null) || (arrayOfFile.length == 0));
      int j = arrayOfFile.length;
      int i = 0;
      label40:
      File localFile;
      if (i < j)
      {
        localFile = arrayOfFile[i];
        if (localFile != null) {
          break label63;
        }
      }
      for (;;)
      {
        i += 1;
        break label40;
        break;
        label63:
        String str1 = localFile.getName();
        if (TextUtils.isEmpty(str1)) {
          localFile.delete();
        }
        if (str1.contains("_"))
        {
          String str2 = str1.substring(0, str1.lastIndexOf("_"));
          if ((parama.name.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(parama.Ih()))) {
            localFile.delete();
          }
        }
      }
    }
    
    public void a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.a parama, DynamicTextConfigManager.b paramb)
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.resurl)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
        }
        return;
      }
      Object localObject = parama.resurl;
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
      }
      for (;;)
      {
        synchronized (this.kk)
        {
          if (this.kk.containsKey(localObject))
          {
            parama = (ArrayList)this.kk.get(localObject);
            localObject = parama.iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label268;
            }
            if (((WeakReference)((Iterator)localObject).next()).get() != paramb) {
              continue;
            }
            i = 1;
            if (i == 0) {
              parama.add(new WeakReference(paramb));
            }
            return;
          }
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new WeakReference(paramb));
        this.kk.put(localObject, localArrayList);
        paramb = new aoll();
        paramb.f = new axuh(this);
        paramb.bZ = ((String)localObject);
        paramb.mHttpMethod = 0;
        paramb.atY = DynamicTextConfigManager.a(parama);
        paramb.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        paramb.bw(parama);
        ige.a().a(paramb);
        return;
        label268:
        int i = 0;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat, String paramString, int paramInt);
    
    public abstract void bd(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager
 * JD-Core Version:    0.7.0.1
 */