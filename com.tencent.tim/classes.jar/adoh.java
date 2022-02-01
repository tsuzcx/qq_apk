import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.1;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.2;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.3;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.4;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class adoh
  extends adnq.b
{
  private static adoh.a a;
  private static String buN = "";
  public static final ArrayList<WeakReference<adoh>> uF = new ArrayList();
  protected long Vu = 0L;
  protected String buO;
  protected SongInfo f;
  private WeakReference<adoh> mWeakThis;
  
  public adoh(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    a = new adoh.a(this.mAppName);
    this.mWeakThis = new WeakReference(this);
    uF.add(this.mWeakThis);
  }
  
  protected static int dY(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 5;
    case 0: 
      return 4;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 0;
  }
  
  public static String getToken()
  {
    if (TextUtils.isEmpty(buN)) {
      buN = QQPlayerService.I(1, "ark.music.module");
    }
    return buN;
  }
  
  public void Destruct()
  {
    QQPlayerService.c(a);
    uF.remove(this.mWeakThis);
    this.mWeakThis = null;
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQMusic";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("Play")) {}
    while ((paramString.equals("Stop")) || (paramString.equals("Pause")) || (paramString.equals("Resume")) || (paramString.equals("GetCurrentTime")) || (paramString.equals("GetDuration")) || (paramString.equals("GetState")) || (paramString.equals("GetCurrentSong")) || (paramString.equals("SetCallback")) || (paramString.equals("AttachEvent")) || (paramString.equals("DetachEvent"))) {
      return true;
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    double d2 = 0.0D;
    if ((QLog.isColorLevel()) && (!paramString.equals("GetCurrentTime")) && (!paramString.equals("GetDuration"))) {
      QLog.i("ark.music.module", 2, String.format("ArkAppMusicModule.invokeFunc.%s", new Object[] { paramString }));
    }
    if (paramString.equals("Play"))
    {
      QQPlayerService.a(null);
      a(paramArrayOfVariantWrapper);
      return true;
    }
    if (paramString.equals("Stop"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.2(this));
      return true;
    }
    if (paramString.equals("Pause"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.3(this));
      return true;
    }
    if (paramString.equals("Resume"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.4(this));
      return true;
    }
    double d1;
    if (paramString.equals("GetCurrentTime"))
    {
      if (QQPlayerService.getPlayState() != 2)
      {
        d1 = d2;
        if (QQPlayerService.getPlayState() != 3) {
          break label182;
        }
      }
      try
      {
        int i = QQPlayerService.Gt();
        d1 = i / 1000.0D;
      }
      catch (IllegalStateException paramString)
      {
        for (;;)
        {
          label182:
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.invokeFunc.getCurrentPlayPosition.error", paramString.getMessage() });
          d1 = d2;
        }
      }
      paramVariantWrapper.SetDouble(d1);
      return true;
    }
    if (paramString.equals("GetDuration"))
    {
      paramVariantWrapper.SetDouble(QQPlayerService.getDuration() / 1000.0D);
      return true;
    }
    if (paramString.equals("GetState"))
    {
      paramVariantWrapper.SetInt(dY(QQPlayerService.getPlayState()));
      return true;
    }
    if (paramString.equals("GetCurrentSong"))
    {
      a(paramArrayOfVariantWrapper[0], QQPlayerService.a());
      return true;
    }
    if (paramString.equals("SetCallback"))
    {
      paramString = a(this.Vu);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsFunction()))
      {
        this.Vu = 0L;
        return true;
      }
      this.Vu = a(paramString.Copy());
      QQPlayerService.b(a);
      QQPlayerService.a(null);
      return true;
    }
    if (paramString.equals("AttachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsString()) || (!"State".equals(paramString.GetString()))) {
        return true;
      }
      paramString = a(this.Vu);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[1];
      if ((paramString == null) || (!paramString.IsFunction()))
      {
        this.Vu = 0L;
        return true;
      }
      this.Vu = a(paramString.Copy());
      QQPlayerService.a(null);
      return true;
    }
    if (paramString.equals("DetachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsString()) || (!"State".equals(paramString.GetString()))) {
        return true;
      }
      paramString = a(this.Vu);
      if (paramString != null) {
        paramString.Reset();
      }
      return true;
    }
    return false;
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, int paramInt, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction()) || (paramSongInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
    }
    do
    {
      return;
      paramInt = dY(paramInt);
      if (paramInt != 5) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.state.invalid");
    return;
    ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
    if (QLog.isColorLevel()) {
      QLog.i("ark.music.module", 2, String.format(Locale.CHINA, "ArkAppMusicModule.callback.state: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    localVariantWrapper1.SetInt(paramInt);
    ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramSongInfo.url);
      localJSONObject.put("title", paramSongInfo.title);
      localJSONObject.put("singer", paramSongInfo.singer);
      localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.id) }));
      localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      paramSongInfo = paramVariantWrapper.Create();
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1, localVariantWrapper2 }, paramSongInfo);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      paramSongInfo.Reset();
      return;
    }
    catch (JSONException paramSongInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.1.json.", paramSongInfo.getMessage() });
        }
      }
    }
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
    ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
    JSONObject localJSONObject;
    if (paramSongInfo != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("url", paramSongInfo.url);
      localJSONObject.put("title", paramSongInfo.title);
      localJSONObject.put("singer", paramSongInfo.singer);
      localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.id) }));
      localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper1);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
    }
    catch (JSONException paramSongInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.2.json.", paramSongInfo.getMessage() });
        }
      }
    }
  }
  
  protected void a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {
      return;
    }
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.type = 4;
    localSongInfo.url = paramArrayOfVariantWrapper[0].GetString();
    try
    {
      paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[1].GetTableAsJsonString());
      localSongInfo.detailUrl = paramArrayOfVariantWrapper.optString("url");
      localSongInfo.title = paramArrayOfVariantWrapper.optString("title");
      localSongInfo.singer = paramArrayOfVariantWrapper.optString("singer");
      localSongInfo.id = paramArrayOfVariantWrapper.optLong("id");
      this.buO = localSongInfo.url;
      this.f = localSongInfo;
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.1(this, localSongInfo));
      return;
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, "QQMusic.Play parameter error: " + paramArrayOfVariantWrapper.getMessage());
        }
      }
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if (this.Vu == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
    }
    do
    {
      return;
      ark.VariantWrapper localVariantWrapper = b(this.Vu);
      SongInfo localSongInfo2 = QQPlayerService.a();
      SongInfo localSongInfo1 = localSongInfo2;
      if (localSongInfo2 == null) {
        localSongInfo1 = this.f;
      }
      a(localVariantWrapper, paramInt, localSongInfo1);
    } while (paramInt != 4);
    this.f = null;
  }
  
  public static final class a
    implements QQPlayerService.c
  {
    private String mAppName;
    
    public a(String paramString)
    {
      this.mAppName = paramString;
    }
    
    public String getToken()
    {
      return adoh.getToken();
    }
    
    public void onPlaySongChanged(SongInfo paramSongInfo)
    {
      ArkAppCenter.a().post(this.mAppName, new ArkAppMusicModule.GlobalMusicCallback.2(this, paramSongInfo));
    }
    
    public void onPlayStateChanged(int paramInt)
    {
      ArkAppCenter.a().post(this.mAppName, new ArkAppMusicModule.GlobalMusicCallback.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoh
 * JD-Core Version:    0.7.0.1
 */