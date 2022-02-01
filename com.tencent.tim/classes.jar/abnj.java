import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class abnj
  implements abnm
{
  private int cqe = 1;
  private Map<String, Integer> iU = Collections.synchronizedMap(new LRULinkedHashMap(20));
  private AppInterface mApp;
  private int mGameId;
  private SharedPreferences mPref;
  private SoundPool mSoundPool;
  
  public abnj(int paramInt)
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[CmGameSoudPoolPlayer]");
    this.mSoundPool = new SoundPool(20, 3, 0);
    this.mGameId = paramInt;
    this.mApp = abmt.getAppInterface();
    this.mPref = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    init();
  }
  
  private void a(abjq paramabjq, int paramInt, long paramLong)
  {
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if (localApolloCmdChannel != null) {
      localApolloCmdChannel.playMusicInner(paramabjq, paramInt, paramLong);
    }
  }
  
  private void init()
  {
    if (this.mApp == null) {}
    while (this.mPref == null) {
      return;
    }
    this.cqe = this.mPref.getInt("apollo_game_music_switch" + this.mApp.getCurrentAccountUin() + "_" + this.mGameId, 1);
  }
  
  public void Zx()
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.autoPause();
    }
  }
  
  public int a(abjq paramabjq, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if ((this.mGameId > 0) && ((this.cqe == 0) || (this.mApp == null) || (!abmt.YK()) || (paramabjq == null)))
    {
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "[playMusic], DO NOT play. switch:" + this.cqe);
      return -1;
    }
    label283:
    label330:
    for (Object localObject = null;; localObject = null)
    {
      try
      {
        if ((paramabjq instanceof ApolloSurfaceView)) {
          localObject = ((ApolloSurfaceView)paramabjq).getRender();
        }
        for (;;)
        {
          if (localObject == null) {
            break label330;
          }
          localObject = ((ApolloRender)localObject).getRscPath(paramString, "mp3");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
          return -1;
          if ((paramabjq instanceof ApolloTextureView)) {
            localObject = ((ApolloTextureView)paramabjq).getRender();
          }
        }
        if (this.mSoundPool == null) {
          break label283;
        }
      }
      catch (Throwable paramabjq)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramabjq, new Object[0]);
        return -1;
      }
      if (this.iU != null)
      {
        this.mSoundPool.setOnLoadCompleteListener(new abnl(this, paramFloat, paramInt2, paramString, paramabjq, paramLong));
        paramString = (Integer)this.iU.get(localObject);
        if (paramString != null) {
          if (-1.0F == paramFloat)
          {
            paramFloat = 1.0F;
            paramInt1 = this.mSoundPool.play(paramString.intValue(), paramFloat, paramFloat, 0, paramInt2, 1.0F);
            if (paramInt1 != 0) {
              a(paramabjq, paramInt1, paramLong);
            }
          }
        }
        for (;;)
        {
          return 0;
          break;
          paramInt1 = this.mSoundPool.load((String)localObject, 1);
          this.iU.put(localObject, Integer.valueOf(paramInt1));
        }
      }
      paramabjq = new StringBuilder().append("pool or cache is null ");
      if (this.mSoundPool == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, bool);
        break;
      }
    }
  }
  
  public void a(int paramInt, AppInterface paramAppInterface)
  {
    if ((this.mPref == null) || (paramAppInterface == null)) {
      return;
    }
    this.mPref.edit().putInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + this.mGameId, paramInt).commit();
    if (paramInt == 0) {
      Zx();
    }
    this.cqe = paramInt;
  }
  
  public int c(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSoudPoolPlayer", 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.mGameId) });
    }
    init();
    return this.cqe;
  }
  
  public JSONObject c(abob paramabob, JSONObject paramJSONObject)
  {
    if ((this.mGameId > 0) && ((this.cqe == 0) || (this.mApp == null) || (!abmt.YK())))
    {
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "[playMusic], DO NOT play. switch:" + this.cqe);
      return paramJSONObject;
    }
    JSONObject localJSONObject;
    int i;
    String str2;
    float f;
    String str1;
    if (paramJSONObject != null) {
      try
      {
        localJSONObject = new JSONObject(paramJSONObject.toString());
        paramJSONObject.optInt("type");
        i = paramJSONObject.optInt("loop");
        str2 = paramJSONObject.optString("src");
        f = (float)paramJSONObject.optDouble("volume");
        str1 = ablp.b(str2, this.mGameId, "", false);
        if (!TextUtils.isEmpty(str1)) {
          break label155;
        }
        QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
        return paramJSONObject;
      }
      catch (Throwable paramabob)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramabob, new Object[0]);
      }
    } else {
      return null;
    }
    label155:
    if ((this.mSoundPool != null) && (this.iU != null))
    {
      this.mSoundPool.setOnLoadCompleteListener(new abnk(this, f, i, str2, paramabob, localJSONObject));
      paramJSONObject = (Integer)this.iU.get(str1);
      if (paramJSONObject != null)
      {
        if (-1.0F != f) {
          break label362;
        }
        f = 1.0F;
      }
    }
    label362:
    for (;;)
    {
      for (;;)
      {
        i = this.mSoundPool.play(paramJSONObject.intValue(), f, f, 0, i, 1.0F);
        if ((i == 0) || (paramabob == null)) {
          break;
        }
        try
        {
          localJSONObject.put("id", i);
          paramabob.aJ(localJSONObject);
        }
        catch (Throwable paramabob)
        {
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramabob, new Object[0]);
        }
      }
      break;
      i = this.mSoundPool.load(str1, 1);
      this.iU.put(str1, Integer.valueOf(i));
      break;
      paramabob = new StringBuilder().append("pool or cache is null ");
      if (this.mSoundPool == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, bool);
        break;
      }
    }
  }
  
  public int gc(int paramInt)
  {
    return 0;
  }
  
  public int getDuration(int paramInt)
  {
    return 0;
  }
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[onDestroy]");
    if (this.mSoundPool != null)
    {
      this.mSoundPool.release();
      this.mSoundPool = null;
    }
  }
  
  public void pauseMusic(int paramInt, String paramString)
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.pause(paramInt);
    }
  }
  
  public JSONObject q(JSONObject paramJSONObject)
  {
    if ((this.mSoundPool != null) && (paramJSONObject != null) && (paramJSONObject.has("id"))) {
      this.mSoundPool.unload(paramJSONObject.optInt("id"));
    }
    return paramJSONObject;
  }
  
  public void resumeMusic()
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.autoResume();
    }
  }
  
  public void resumeMusic(int paramInt, String paramString)
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.resume(paramInt);
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2) {}
  
  public void stopMusic(int paramInt, String paramString)
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.stop(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnj
 * JD-Core Version:    0.7.0.1
 */