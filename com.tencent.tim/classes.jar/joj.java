import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class joj
{
  public static String TK = "msg_key";
  public static String TL = "msg_back";
  private final String TAG = "QQMusicService";
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  QQPlayerService.c jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c = new jok(this);
  long qu = 0L;
  
  public joj(TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramSongInfo.id);
    }
    catch (JSONException localJSONException4)
    {
      try
      {
        localJSONObject.put("audio_url", paramSongInfo.url);
      }
      catch (JSONException localJSONException4)
      {
        try
        {
          localJSONObject.put("title", paramSongInfo.title);
        }
        catch (JSONException localJSONException4)
        {
          try
          {
            localJSONObject.put("desc", paramSongInfo.summary);
          }
          catch (JSONException localJSONException4)
          {
            try
            {
              for (;;)
              {
                localJSONObject.put("image_url", paramSongInfo.coverUrl);
                try
                {
                  localJSONObject.put("share_url", paramSongInfo.detailUrl);
                  return localJSONObject;
                }
                catch (JSONException paramSongInfo)
                {
                  paramSongInfo.printStackTrace();
                  return localJSONObject;
                }
                localJSONException1 = localJSONException1;
                localJSONException1.printStackTrace();
                continue;
                localJSONException2 = localJSONException2;
                localJSONException2.printStackTrace();
                continue;
                localJSONException3 = localJSONException3;
                localJSONException3.printStackTrace();
                continue;
                localJSONException4 = localJSONException4;
                localJSONException4.printStackTrace();
              }
            }
            catch (JSONException localJSONException5)
            {
              for (;;)
              {
                localJSONException5.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt(TK);
    paramAppRuntime = new Bundle();
    paramAppRuntime.putInt(TK, i);
    int j = paramBundle.getInt("seq", -1);
    if (j != -1) {
      paramAppRuntime.putInt("seq", j);
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      kU(paramBundle.getString("music"));
      return;
    case 2: 
      QQPlayerService.eE(BaseApplication.getContext());
      return;
    case 3: 
      QQPlayerService.eF(BaseApplication.getContext());
      return;
    case 4: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c);
      paramAppRuntime.putInt("state", QQPlayerService.getPlayState());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.j(8, paramAppRuntime);
      return;
    case 5: 
      QQPlayerService.setPlayMode(paramBundle.getInt("mode"));
      return;
    case 6: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c);
      paramAppRuntime.putInt("mode", QQPlayerService.getPlayMode());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.j(8, paramAppRuntime);
      return;
    case 7: 
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c);
      paramBundle = a(QQPlayerService.a());
      if (paramBundle != null) {
        paramAppRuntime.putString("music", paramBundle.toString());
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.j(8, paramAppRuntime);
      return;
    }
    QQPlayerService.eG(BaseApplication.getContext());
  }
  
  public void kU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        localObject = new JSONObject(paramString);
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicService", 2, "playQQMusic err:" + paramString);
          }
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
    } while (paramString == null);
    paramString.optInt("mtype", 1);
    localObject = new SongInfo();
    ((SongInfo)localObject).id = paramString.optLong("id");
    ((SongInfo)localObject).url = paramString.optString("audio_url");
    ((SongInfo)localObject).title = paramString.optString("title");
    ((SongInfo)localObject).summary = paramString.optString("desc");
    ((SongInfo)localObject).coverUrl = paramString.optString("image_url");
    ((SongInfo)localObject).detailUrl = paramString.optString("share_url");
    this.qu = ((SongInfo)localObject).id;
    QQPlayerService.ag(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
    QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c);
    QQPlayerService.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$c.getToken(), (SongInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joj
 * JD-Core Version:    0.7.0.1
 */