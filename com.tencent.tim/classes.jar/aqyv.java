import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.1;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqyv
{
  private WebViewFragment a;
  private String bPo;
  private boolean cXe;
  private boolean cXf;
  private boolean cXg;
  private boolean cXh;
  public String cyG;
  private String cyH;
  private int edO;
  private int mAioType;
  private int mDuration;
  private String mIcon;
  private int mMediaType;
  
  public aqyv(WebViewFragment paramWebViewFragment)
  {
    this.a = paramWebViewFragment;
  }
  
  private void VP(String paramString)
  {
    if (this.a != null) {
      QQToast.a(BaseApplicationImpl.getApplication(), paramString, 1).show();
    }
  }
  
  private boolean aFW()
  {
    return (!TextUtils.isEmpty(this.cyH)) && (this.a.mApp.getAccount().equals(this.cyH));
  }
  
  private void dT(Intent paramIntent)
  {
    int i = 2;
    Object localObject1 = paramIntent.getStringExtra("forward_ark_app_meta");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONObject("music");
        Object localObject3 = paramIntent.getExtras();
        if (this.mAioType == 0)
        {
          paramIntent = "friend_uin";
          Object localObject2 = ((Bundle)localObject3).getString(paramIntent, "");
          if (this.mAioType == 0)
          {
            paramIntent = "h5_ark_url_web_sender_uin";
            paramIntent = ((Bundle)localObject3).getString(paramIntent);
            int j = ((JSONObject)localObject1).getInt("appid");
            Object localObject4 = ((JSONObject)localObject1).getString("title");
            localObject3 = ((JSONObject)localObject1).getString("musicUrl");
            localObject1 = ((JSONObject)localObject1).getString("desc");
            JSONObject localJSONObject = new JSONObject();
            if (this.mAioType == 0)
            {
              localJSONObject.put("enum_aio_type", i);
              localJSONObject.put("uint64_id", localObject2);
              localJSONObject.put("uint32_share_appid", j);
              localJSONObject.put("bytes_song_name", localObject4);
              localObject2 = new JSONArray();
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("singer", localObject1);
              ((JSONArray)localObject2).put(localObject4);
              localJSONObject.put("rpt_bytes_singer", localObject2);
              localJSONObject.put("bytes_song_url", localObject3);
              localJSONObject.put("bool_cut_song", this.cXe);
              localJSONObject.put("str_song_id", this.bPo);
              localJSONObject.put("uint32_duration", this.mDuration);
              localJSONObject.put("uint64_sharer_uin", paramIntent);
              localJSONObject.put("bytes_cover", this.mIcon);
              if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "realStartAioShareMusic() jsonObject = " + localJSONObject.toString());
              }
              iga.a(localJSONObject, "startListenAioShareMusic", null);
            }
          }
          else
          {
            paramIntent = "friendUin";
            continue;
          }
          i = 1;
          continue;
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      paramIntent = "groupUin";
    }
  }
  
  private boolean rN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    EntityManager localEntityManager = this.a.mApp.getEntityManagerFactory(this.a.mApp.getAccount()).createEntityManager();
    paramString = (TroopInfo)localEntityManager.find(TroopInfo.class, paramString);
    localEntityManager.close();
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " isTroopAdminOrOwner() troopInfo = " + paramString.isAdmin());
      }
      if ((paramString.isTroopOwner(this.a.mApp.getAccount())) || (paramString.isAdmin())) {
        return true;
      }
    }
    return false;
  }
  
  private void showDialog(String paramString)
  {
    if ((this.a != null) && (this.a.getActivity() != null)) {
      aqha.a(this.a.getActivity(), 230).setMessage(paramString).setPositiveButton(2131695487, new aqyw(this)).show();
    }
  }
  
  public void bT(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("isSuccess");
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + bool + " data = " + paramJSONObject.toString());
      }
      if (bool)
      {
        bool = paramJSONObject.getBoolean("bool_show_icon");
        this.edO = paramJSONObject.getInt("enum_aio_state");
        this.mMediaType = paramJSONObject.getInt("enum_media_type");
        this.bPo = paramJSONObject.getString("str_song_id");
        this.mDuration = paramJSONObject.getInt("uint32_duration");
        this.cyH = String.valueOf(paramJSONObject.getLong("uint64_create_uin"));
        this.cXf = paramJSONObject.getBoolean("bool_song_existed");
        this.cXg = paramJSONObject.getBoolean("bool_allow_member_start");
        this.cXh = paramJSONObject.getBoolean("bool_allow_member_add");
        this.cyG = paramJSONObject.getString("current_song_id");
        if ((this.a != null) && (this.a.getActivity() != null)) {
          this.a.getActivity().runOnUiThread(new WebViewAioShareMusicHelper.1(this, bool));
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void bU(JSONObject paramJSONObject)
  {
    for (;;)
    {
      String str;
      try
      {
        if ((this.a == null) || (paramJSONObject == null) || (this.a.getActivity() == null))
        {
          if (!QLog.isColorLevel()) {
            break label339;
          }
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic()  data  = " + paramJSONObject + " mWebViewFragment = " + this.a);
          return;
        }
        boolean bool = paramJSONObject.getBoolean("isSuccess");
        if (bool) {
          break label304;
        }
        int i = paramJSONObject.getInt("uint32_result");
        str = paramJSONObject.getString("bytes_errmsg");
        if (!TextUtils.isEmpty(str)) {}
        switch (i)
        {
        case 0: 
          if (!QLog.isColorLevel()) {
            break label339;
          }
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + bool + " data = " + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      VP(this.a.getString(2131696691));
      continue;
      VP(String.format(this.a.getString(2131695363), new Object[] { str }));
      continue;
      VP(str);
      continue;
      showDialog(str);
      continue;
      label304:
      VP(this.a.getString(2131695361));
      this.a.getActivity().runOnUiThread(new WebViewAioShareMusicHelper.2(this));
      continue;
      label339:
      return;
    }
  }
  
  public void dR(Intent paramIntent)
  {
    int i = 2;
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
      }
    }
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getStringExtra("forward_ark_app_view");
        this.mAioType = paramIntent.getIntExtra("uinType", 0);
        if (("music".equalsIgnoreCase(str)) && ((this.mAioType == 0) || (this.mAioType == 1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is not music just return, ShareType = " + str + " mAioType = " + this.mAioType);
      return;
      str = paramIntent.getStringExtra("forward_ark_app_meta");
    } while (TextUtils.isEmpty(str));
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str).getJSONObject("music");
        if (this.mAioType == 0)
        {
          str = "friend_uin";
          Object localObject1 = paramIntent.getStringExtra(str);
          int j = localJSONObject.getInt("appid");
          Object localObject2 = localJSONObject.getString("title");
          paramIntent = localJSONObject.getString("musicUrl");
          str = localJSONObject.getString("desc");
          this.mIcon = localJSONObject.getString("preview");
          localJSONObject = new JSONObject();
          if (this.mAioType != 0) {
            break label389;
          }
          localJSONObject.put("enum_aio_type", i);
          localJSONObject.put("uint64_id", localObject1);
          localJSONObject.put("uint32_share_appid", j);
          localJSONObject.put("bytes_song_name", localObject2);
          localJSONObject.put("uint32_duration", 0);
          localObject1 = new JSONArray();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("singer", str);
          ((JSONArray)localObject1).put(localObject2);
          localJSONObject.put("rpt_bytes_singer", localObject1);
          localJSONObject.put("bytes_song_url", paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is music jsonObject = " + localJSONObject.toString());
          }
          iga.a(localJSONObject, "checkAioShareMusic", null);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      str = "groupUin";
      continue;
      label389:
      i = 1;
    }
  }
  
  public void dS(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
      }
      return;
    }
    this.cXe = true;
    String str4 = paramIntent.getStringExtra("groupUin");
    String str1;
    String str2;
    label63:
    String str3;
    if (this.mAioType == 0)
    {
      str1 = "c2c_AIO";
      if (this.mAioType != 0) {
        break label167;
      }
      str2 = "clk_share_c2c";
      if (this.mAioType != 0) {
        break label175;
      }
      str3 = "";
      label74:
      anot.a(null, "dc00899", str1, "", "music_tab", str2, 0, 0, str3, "", "", "");
      if ((this.mMediaType == 1) || (this.edO == 3)) {
        break label196;
      }
      if (this.mMediaType != 2) {
        break label182;
      }
    }
    label167:
    label175:
    label182:
    for (paramIntent = this.a.getString(2131700719);; paramIntent = this.a.getString(2131700693))
    {
      VP(String.format(this.a.getString(2131695363), new Object[] { paramIntent }));
      return;
      str1 = "Grp_AIO";
      break;
      str2 = "clk_share_grp";
      break label63;
      str3 = str4;
      break label74;
    }
    label196:
    if ((this.edO != 3) && (this.cyG.equals(this.bPo)))
    {
      VP(this.a.getString(2131695357));
      return;
    }
    if (this.mAioType == 1)
    {
      boolean bool = rN(str4);
      if ((this.edO == 3) && (!bool) && (!this.cXg))
      {
        showDialog(this.a.getString(2131695355));
        return;
      }
      if ((this.edO == 3) && (!bool) && (this.cXg) && (!this.cXh))
      {
        showDialog(this.a.getString(2131695356));
        return;
      }
      if ((this.edO != 3) && (!bool) && (!this.cXh))
      {
        showDialog(this.a.getString(2131695354));
        return;
      }
      if ((this.edO != 3) && (!aFW()) && (!bool) && (this.cXh))
      {
        if (this.cXf)
        {
          VP(this.a.getString(2131695361));
          return;
        }
        this.cXe = false;
      }
    }
    dT(paramIntent);
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyv
 * JD-Core Version:    0.7.0.1
 */