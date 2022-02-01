import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class abnc
  implements abob.a
{
  public static List<abnc> ws = Collections.synchronizedList(new ArrayList());
  private abnj a;
  private boolean aqY;
  private AudioManager.OnAudioFocusChangeListener c = new abni(this);
  private int cqf;
  private int cqg;
  private AudioManager mAudioManager;
  private MediaPlayer mAudioPlayer;
  private boolean mAutoPlay;
  private AtomicInteger mCurrentState = new AtomicInteger(0);
  private int mGameId;
  
  public abnc(int paramInt1, int paramInt2, String arg3)
  {
    this.cqf = paramInt1;
    this.mGameId = paramInt2;
    abos localabos = abmt.a(paramInt2);
    if (localabos != null) {
      localabos.HE(0);
    }
    if ("effect".equals(???)) {
      if (localabos != null) {
        this.a = new abnj(paramInt2);
      }
    }
    for (;;)
    {
      if (ws != null) {}
      synchronized (ws)
      {
        ws.add(this);
        this.mAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
        return;
        QLog.e("CmGameAudioPlayer", 1, "can not create pool");
        continue;
        this.mAudioPlayer = new MediaPlayer();
        gd(1);
        this.mAudioPlayer.setOnErrorListener(new abnd(this));
      }
    }
  }
  
  private void DS(boolean paramBoolean)
  {
    if (this.mAudioManager == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (int i = this.mAudioManager.requestAudioFocus(this.c, 3, 2); QLog.isColorLevel(); i = this.mAudioManager.abandonAudioFocus(this.c))
      {
        QLog.d("CmGameAudioPlayer", 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
        return;
      }
    }
  }
  
  private void a(abob paramabob, JSONObject paramJSONObject)
  {
    if (paramabob != null) {
      paramabob.aJ(paramJSONObject);
    }
  }
  
  public JSONObject a(float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.mAudioPlayer != null)
    {
      if (getState() != 9) {
        this.mAudioPlayer.setVolume(paramFloat1, paramFloat2);
      }
    }
    else {
      return paramJSONObject;
    }
    QLog.e("CmGameAudioPlayer", 1, " volume in  state " + getState());
    return paramJSONObject;
  }
  
  public JSONObject a(int paramInt, JSONObject paramJSONObject, abob paramabob)
  {
    int i;
    if (this.mAudioPlayer != null)
    {
      i = getState();
      if ((i != 3) && (i != 5) && (i != 7) && (i != 10)) {
        break label66;
      }
      this.mAudioPlayer.setOnSeekCompleteListener(new abne(this, paramJSONObject, paramabob));
      this.mAudioPlayer.seekTo(paramInt);
    }
    for (;;)
    {
      return null;
      label66:
      QLog.e("CmGameAudioPlayer", 1, " seek in  state " + i);
    }
  }
  
  public JSONObject a(abob paramabob, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.optInt("N_R_OBJ") == this.cqf)
        {
          String str = paramJSONObject.optString("N_R_CMD");
          if ("cs.audio_play.local".equals(str)) {
            return b(paramJSONObject, paramabob);
          }
          if ("cs.audio_autoplay.local".equals(str)) {
            return b(paramJSONObject.optBoolean("autoplay"), paramJSONObject);
          }
          if ("cs.audio_load.local".equals(str)) {
            return c(paramJSONObject, paramabob);
          }
          if ("cs.audio_loop.local".equals(str)) {
            return a(paramJSONObject.optBoolean("loop"), paramJSONObject);
          }
          if ("cs.audio_muted.local".equals(str)) {
            return a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_pause.local".equals(str)) {
            return l(paramJSONObject);
          }
          if ("cs.audio_seek.local".equals(str)) {
            return a(paramJSONObject.optInt("seek"), paramJSONObject, paramabob);
          }
          if ("cs.audio_src.local".equals(str)) {
            return a(paramJSONObject.optString("src"), paramJSONObject, paramabob);
          }
          if ("cs.audio_preload.local".equals(str)) {
            return c(paramJSONObject.optBoolean("preloaded"), paramJSONObject);
          }
          if ("cs.audio_volume.local".equals(str)) {
            return a((float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_destroy.local".equals(str)) {
            return b(paramabob, paramJSONObject);
          }
          if ("cs.audio_onend.local".equals(str)) {
            return e(paramJSONObject, paramabob);
          }
          if ("cs.audio_ontimeupdate.local".equals(str)) {
            return n(paramJSONObject);
          }
          if ("cs.audio_duration.local".equals(str)) {
            return m(paramJSONObject);
          }
          if ("cs.audio_effect_resume.local".equals(str)) {
            return p(paramJSONObject);
          }
          if ("cs.audio_stop.local".equals(str)) {
            return o(paramJSONObject);
          }
          if ("cs.audio_attribute_get.local".equals(str)) {
            return k(paramJSONObject);
          }
          if ("cs.audio_attribute_set.local".equals(str))
          {
            paramabob = a(paramJSONObject, paramabob);
            return paramabob;
          }
        }
      }
      catch (Throwable paramabob)
      {
        QLog.e("CmGameAudioPlayer", 1, "audio failed", paramabob);
      }
    }
    return null;
  }
  
  public JSONObject a(String paramString, JSONObject paramJSONObject, abob paramabob)
  {
    if ((this.mAudioPlayer != null) && (getState() != 6) && (getState() != 9))
    {
      try
      {
        this.cqg = 0;
        abos localabos = abmt.b();
        if (localabos != null)
        {
          String str2 = "";
          String str1 = str2;
          if (paramString != null)
          {
            str1 = str2;
            if (paramString.startsWith("GameSandBox://")) {
              str1 = "sandbox";
            }
          }
          if (URLUtil.isNetworkUrl(paramString)) {}
          for (;;)
          {
            this.mAudioPlayer.reset();
            gd(1);
            if (TextUtils.isEmpty(paramString)) {
              break;
            }
            this.mAudioPlayer.setDataSource(paramString);
            gd(2);
            return paramJSONObject;
            paramString = ablp.b(paramString, localabos.getGameId(), str1, false);
          }
        }
        paramJSONObject.put("code", 2);
        paramJSONObject.put("message", "src not exist " + paramString);
        return paramJSONObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmGameAudioPlayer", 1, paramString, new Object[0]);
        if (paramJSONObject == null) {
          return paramJSONObject;
        }
      }
      try
      {
        paramJSONObject.put("code", 1);
        paramJSONObject.put("message", "src error " + paramString.getMessage());
        a(paramabob, paramJSONObject);
        return paramJSONObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmGameAudioPlayer", 1, paramString, new Object[0]);
        return paramJSONObject;
      }
    }
    QLog.e("CmGameAudioPlayer", 1, " src in  state " + getState());
    return paramJSONObject;
  }
  
  public JSONObject a(JSONObject paramJSONObject, abob paramabob)
  {
    try
    {
      if (paramJSONObject.has("src")) {
        a(paramJSONObject.optString("src"), paramJSONObject, paramabob);
      }
      if (paramJSONObject.has("loop")) {
        a(paramJSONObject.optBoolean("loop"), paramJSONObject);
      }
      if (paramJSONObject.has("autoPlay")) {
        b(paramJSONObject.optBoolean("autoPlay"), paramJSONObject);
      }
      if (paramJSONObject.has("volume")) {
        a((float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("muted")) {
        a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("currentTime")) {
        d(paramJSONObject, paramabob);
      }
      return paramJSONObject;
    }
    catch (Throwable paramabob)
    {
      QLog.e("CmGameAudioPlayer", 1, paramabob, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject a(boolean paramBoolean, float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.mAudioPlayer != null) {
      if (paramBoolean) {
        localObject = a(0.0F, 0.0F, paramJSONObject);
      }
    }
    do
    {
      return localObject;
      return a(paramFloat1, paramFloat2, paramJSONObject);
      localObject = paramJSONObject;
    } while (this.a == null);
    Object localObject = this.a;
    if ((paramBoolean) || ((Float.compare(paramFloat1, 0.0F) == 0) && (Float.compare(paramFloat2, 0.0F) == 0))) {}
    for (int i = 0;; i = 1)
    {
      ((abnj)localObject).a(i, BaseActivity.sTopActivity.getAppInterface());
      return paramJSONObject;
    }
  }
  
  public JSONObject a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    if (this.mAudioPlayer != null)
    {
      i = getState();
      if ((i == 1) || (i == 2) || (i == 6) || (i == 3) || (i == 5) || (i == 7) || (i == 10)) {
        this.mAudioPlayer.setLooping(paramBoolean);
      }
    }
    else
    {
      return paramJSONObject;
    }
    QLog.e("CmGameAudioPlayer", 1, " loop in  state " + i);
    return paramJSONObject;
  }
  
  public JSONObject b(abob arg1, JSONObject paramJSONObject)
  {
    try
    {
      if (this.mAudioPlayer != null) {
        this.mAudioPlayer.release();
      }
      if (this.a != null) {
        this.a.onDestroy();
      }
      gd(8);
      this.mAudioPlayer = null;
      this.a = null;
      if (??? != null) {
        ???.b(this);
      }
      if (ws != null) {
        synchronized (ws)
        {
          ws.remove(this);
          return paramJSONObject;
        }
      }
      return paramJSONObject;
    }
    catch (Throwable ???)
    {
      QLog.e("CmGameAudioPlayer", 1, "destroy failed", ???);
    }
  }
  
  public JSONObject b(JSONObject paramJSONObject, abob paramabob)
  {
    if (this.mAudioPlayer != null)
    {
      i = getState();
      if ((i == 3) || (i == 5) || (i == 7) || (i == 10))
      {
        DS(true);
        if (this.mAudioPlayer == null) {}
      }
    }
    while (this.a == null) {
      for (;;)
      {
        int i;
        try
        {
          this.mAudioPlayer.start();
          gd(5);
          if (this.cqg != 0) {
            this.mAudioPlayer.seekTo(this.cqg);
          }
          this.mAudioPlayer.setOnCompletionListener(new abnf(this));
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("CmGameAudioPlayer", 1, "audio play failed", paramJSONObject);
          continue;
        }
        return null;
        QLog.e("CmGameAudioPlayer", 1, " play in  state " + i);
      }
    }
    DS(true);
    return this.a.c(paramabob, paramJSONObject);
  }
  
  public JSONObject b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.mAutoPlay = paramBoolean;
    return paramJSONObject;
  }
  
  public JSONObject c(JSONObject paramJSONObject, abob paramabob)
  {
    if ((this.mAudioPlayer != null) && ((getState() == 2) || (getState() == 6)))
    {
      this.mAudioPlayer.setOnPreparedListener(new abng(this, paramJSONObject, paramabob));
      this.mAudioPlayer.prepareAsync();
    }
    return null;
  }
  
  public JSONObject c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.aqY = paramBoolean;
    return paramJSONObject;
  }
  
  public JSONObject d(JSONObject paramJSONObject, abob paramabob)
  {
    int i;
    if ((this.mAudioPlayer != null) && (getState() != 9))
    {
      i = this.mAudioPlayer.getCurrentPosition();
      if (paramJSONObject != null) {
        if (paramJSONObject.has("currentTime")) {
          this.cqg = paramJSONObject.optInt("currentTime");
        }
      }
    }
    try
    {
      paramJSONObject.put("currentTime", i);
      return paramJSONObject;
    }
    catch (Throwable paramabob)
    {
      QLog.e("CmGameAudioPlayer", 1, paramabob, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject, abob paramabob)
  {
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.setOnCompletionListener(new abnh(this, paramabob, paramJSONObject));
    }
    return null;
  }
  
  public int gd(int paramInt)
  {
    return this.mCurrentState.getAndSet(paramInt);
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public int getState()
  {
    return this.mCurrentState.get();
  }
  
  public JSONObject k(JSONObject paramJSONObject)
  {
    try
    {
      if (this.mAudioPlayer != null)
      {
        if (paramJSONObject.has("duration")) {
          paramJSONObject.put("duration", this.mAudioPlayer.getDuration());
        }
        if (paramJSONObject.has("currentTime")) {
          paramJSONObject.put("currentTime", this.mAudioPlayer.getCurrentPosition());
        }
        if (paramJSONObject.has("paused")) {
          if (getState() != 7) {
            break label89;
          }
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        paramJSONObject.put("paused", bool);
        return paramJSONObject;
      }
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
    }
  }
  
  public JSONObject l(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (this.mAudioPlayer != null)
        {
          i = getState();
          if ((i == 5) || (i == 7) || (i == 10))
          {
            this.mAudioPlayer.pause();
            gd(7);
            DS(false);
            return paramJSONObject;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("CmGameAudioPlayer", 1, " pause in  state " + getState());
          continue;
        }
        if (this.a == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmGameAudioPlayer", 1, "pause failed", localThrowable);
        return paramJSONObject;
      }
      int i = paramJSONObject.optInt("id");
      if (paramJSONObject.optBoolean("auto", true)) {
        this.a.Zx();
      } else {
        this.a.pauseMusic(i, null);
      }
    }
  }
  
  public JSONObject m(JSONObject paramJSONObject)
  {
    int i;
    if (this.mAudioPlayer != null)
    {
      if ((getState() == 1) && (getState() == 2) && (getState() == 9)) {
        break label69;
      }
      i = this.mAudioPlayer.getDuration();
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject.put("duration", i);
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
      return paramJSONObject;
    }
    label69:
    QLog.e("CmGameAudioPlayer", 1, " duration in  state " + getState());
    return paramJSONObject;
  }
  
  public JSONObject n(JSONObject paramJSONObject)
  {
    int i;
    if (this.mAudioPlayer != null) {
      i = this.mAudioPlayer.getCurrentPosition();
    }
    try
    {
      paramJSONObject.put("currentTime", i);
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject o(JSONObject paramJSONObject)
  {
    if (this.a != null)
    {
      this.a.stopMusic(paramJSONObject.optInt("id"), null);
      this.a.q(paramJSONObject);
    }
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.stop();
      this.mAudioPlayer.reset();
    }
    return paramJSONObject;
  }
  
  public JSONObject p(JSONObject paramJSONObject)
  {
    if (this.a != null)
    {
      if (paramJSONObject.optBoolean("audo", true)) {
        this.a.resumeMusic();
      }
    }
    else {
      return paramJSONObject;
    }
    this.a.resumeMusic(paramJSONObject.optInt("id"), null);
    return paramJSONObject;
  }
  
  public String rf()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mAudioPlayer;
      if (localMediaPlayer != null) {}
      try
      {
        this.mAudioPlayer.release();
        this.mAudioPlayer = null;
        if (this.a != null)
        {
          this.a.onDestroy();
          this.a = null;
          return null;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("CmGameAudioPlayer", 1, localThrowable1, new Object[0]);
        }
      }
      return null;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("CmGameAudioPlayer", 1, "audio destroy falied", localThrowable2);
    }
  }
  
  public int zJ()
  {
    return this.cqf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnc
 * JD-Core Version:    0.7.0.1
 */