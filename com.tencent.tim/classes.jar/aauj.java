import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.1;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.2;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.3;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aauj
  extends aaue
{
  private static aauj a;
  public int aYL;
  public WeakReference<aauj.a> mListenerRef = null;
  public final ArrayList<alwk> sk = new ArrayList();
  public final ArrayList<alwk.a> sl = new ArrayList();
  
  private aauj()
  {
    super(231, true, false);
  }
  
  public static final aauj a()
  {
    try
    {
      if (a == null) {
        a = new aauj();
      }
      return a;
    }
    finally {}
  }
  
  private String a(alwk.a parama)
  {
    if (this.sk == null) {
      return null;
    }
    Iterator localIterator = this.sk.iterator();
    while (localIterator.hasNext())
    {
      alwk localalwk = (alwk)localIterator.next();
      if (localalwk.b == parama) {
        return localalwk.bZa;
      }
    }
    return null;
  }
  
  private boolean a(alwk.a parama)
  {
    if (parama == null) {
      return false;
    }
    String str = qH() + parama.mTitle;
    if (aqhq.fileExists(str))
    {
      parama.mFile = str;
      parama.mState = 2;
      return true;
    }
    parama.mFile = null;
    parama.mState = 0;
    return false;
  }
  
  private boolean a(String paramString, alwk.a parama)
  {
    paramString = aE(paramString, parama.bZb);
    if (!TextUtils.isEmpty(paramString))
    {
      aqhq.copyFile(paramString, qH() + parama.mTitle);
      a(parama);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, parama));
      return true;
    }
    return false;
  }
  
  private void cyD()
  {
    int i = aomi.a().getNetType();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.sl.iterator();
    while (localIterator.hasNext())
    {
      alwk.a locala = (alwk.a)localIterator.next();
      a(locala);
      if ((i == 1) && (locala.dyA == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + locala.mName);
        }
        a(a(locala), locala);
      }
    }
  }
  
  private void dp(ArrayList<alwk> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new aauk(this));
  }
  
  private boolean iU(String paramString)
  {
    boolean bool3 = false;
    bool1 = false;
    bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return bool2;
    }
    for (bool2 = bool1;; bool2 = false)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        bool2 = bool1;
        bool1 = s(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            bool2 = r(localJSONObject);
            if ((bool2) && (bool1)) {
              bool2 = true;
            }
          }
          catch (JSONException localJSONException2)
          {
            JSONObject localJSONObject;
            boolean bool4;
            bool2 = bool1;
            continue;
          }
          try
          {
            bool4 = t(localJSONObject);
            bool1 = bool3;
            if (bool4)
            {
              bool1 = bool3;
              if (bool2) {
                bool1 = true;
              }
            }
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            cyD();
            return bool1;
          }
          catch (JSONException localJSONException3) {}
        }
        localJSONException1 = localJSONException1;
      }
      localJSONException1.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse failed.context = " + paramString);
      return bool2;
    }
  }
  
  private String qH()
  {
    return aaug.p(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private boolean r(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("font");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        alwk.a locala = new alwk.a();
        locala.mID = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        locala.mTitle = localJSONObject.getString("title");
        locala.mName = localJSONObject.getString("name");
        locala.bYU = localJSONObject.getString("resurl");
        locala.mMd5 = localJSONObject.getString("md5");
        locala.bZb = localJSONObject.optString("md5_ttf");
        locala.dyA = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.sl.add(locala);
        i += 1;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse fonts exception:" + paramJSONObject);
    }
    return false;
  }
  
  private boolean s(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      Df("on".equalsIgnoreCase(paramJSONObject.getString("switch")));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse switch exception " + paramJSONObject);
    }
    return false;
  }
  
  private boolean t(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    for (;;)
    {
      int i;
      alwk localalwk;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label286;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localalwk = new alwk();
        localalwk.mID = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!aatg.hD(localalwk.mID)) {
          break label296;
        }
        localalwk.mName = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.sl.iterator();
        if (localIterator.hasNext())
        {
          alwk.a locala = (alwk.a)localIterator.next();
          if (locala.mID != j) {
            continue;
          }
          localalwk.b = locala;
        }
        localalwk.bZa = localJSONObject.optString("avfontfolder");
        localalwk.mPosition = localJSONObject.optInt("position");
        localalwk.mIsShow = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localalwk.mIsShow = true;
          }
        }
        else
        {
          localalwk.mIconUrl = localJSONObject.getString("iconurl");
          if (!localalwk.mIsShow) {
            break label296;
          }
          this.sk.add(localalwk);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localalwk.mIsShow = false;
      continue;
      label286:
      dp(this.sk);
      return true;
      label296:
      i += 1;
    }
  }
  
  public void a(aauj.a parama)
  {
    if (parama == null)
    {
      this.mListenerRef = null;
      return;
    }
    this.mListenerRef = new WeakReference(parama);
  }
  
  public void a(String paramString, alwk.a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        return;
      } while ((parama.mState == 1) || (parama.mState == 2));
      parama.mState = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, parama), 5, null, true);
        return;
      }
    } while (a(paramString, parama));
    parama.dyB = b(parama.bYU, qH() + parama.mMd5, parama.mMd5, qH());
  }
  
  public String aE(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      paramString1 = aasa.SDCARD_ROOT + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = aqhq.px(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString)
  {
    return iU(paramString);
  }
  
  public ArrayList<alwk> cd()
  {
    try
    {
      if (getState() != 2) {
        return null;
      }
      ArrayList localArrayList = this.sk;
      return localArrayList;
    }
    finally {}
  }
  
  public void g(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadResult: nID:" + paramInt1 + " nResult:" + paramInt2 + " file:" + paramString1 + " unzipPath:" + paramString2);
    }
    Iterator localIterator = this.sl.iterator();
    while (localIterator.hasNext())
    {
      paramString2 = (alwk.a)localIterator.next();
      if (paramString2.dyB == paramInt1)
      {
        if (paramInt2 != 0)
        {
          paramString2.mState = 0;
          paramString2.mProgress = 0;
          paramString2.dyB = -1;
        }
        while (this.mListenerRef != null)
        {
          paramString1 = (aauj.a)this.mListenerRef.get();
          localIterator = this.sk.iterator();
          while (localIterator.hasNext())
          {
            alwk localalwk = (alwk)localIterator.next();
            if ((localalwk.b == paramString2) && (localalwk.b != null)) {
              paramString1.y(localalwk.mID, paramInt2, localalwk.b.mFile);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void gt(int paramInt1, int paramInt2)
  {
    this.sk.clear();
    this.sl.clear();
  }
  
  public void gu(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onConfigEnd: nVersion:" + paramInt1 + " nTaskCount:" + paramInt2);
    }
    if (this.mListenerRef != null) {
      ThreadManager.getUIHandler().post(new SubtitleDataManager.1(this));
    }
  }
  
  public void gv(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadProgress: nID:" + paramInt1 + " progress:" + paramInt2);
    }
    Object localObject = this.sl.iterator();
    alwk.a locala;
    while (((Iterator)localObject).hasNext())
    {
      locala = (alwk.a)((Iterator)localObject).next();
      if (locala.dyB == paramInt1) {
        locala.mProgress = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.mListenerRef != null) && (locala != null))
      {
        localObject = (aauj.a)this.mListenerRef.get();
        Iterator localIterator = this.sk.iterator();
        while (localIterator.hasNext())
        {
          alwk localalwk = (alwk)localIterator.next();
          if (localalwk.b == locala) {
            ((aauj.a)localObject).gv(localalwk.mID, localalwk.b.mProgress);
          }
        }
      }
      return;
      locala = null;
    }
  }
  
  public void onInit()
  {
    this.aYL = 0;
    aath.a().l(aniq.bth, aniq.ckG, aniq.mAudioFormat);
  }
  
  public static abstract interface a
  {
    public abstract void cyE();
    
    public abstract void gv(int paramInt1, int paramInt2);
    
    public abstract void y(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauj
 * JD-Core Version:    0.7.0.1
 */