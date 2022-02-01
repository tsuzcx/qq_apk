import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1;
import com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arsc
{
  protected static arsc a;
  protected arsc.b a;
  protected arxh a;
  protected aryj a;
  protected String cBQ;
  protected long gR;
  public String mAction;
  public String mAppid;
  protected Bundle mParams;
  protected String mUrl;
  
  public static arsc a()
  {
    try
    {
      if (jdField_a_of_type_Arsc == null) {
        jdField_a_of_type_Arsc = new arsc();
      }
      arsc localarsc = jdField_a_of_type_Arsc;
      return localarsc;
    }
    finally {}
  }
  
  public void WV(String paramString)
  {
    if ("action_invite".equals(this.mAction))
    {
      SharedPreferences.Editor localEditor = asbf.getGlobalPreference(aroi.a().getContext(), "invite_friend_list_md5").edit();
      localEditor.putString(this.cBQ, paramString);
      localEditor.commit();
    }
  }
  
  public void a(Bundle paramBundle, arsc.c paramc, String paramString)
  {
    if ((paramBundle == null) || (paramc == null))
    {
      arwt.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + paramc);
      return;
    }
    this.mParams = paramBundle;
    this.mAction = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = asbg.a().qP("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", asbf.getGlobalPreference(aroi.a().getContext(), "invite_friend_list_md5").getString(this.cBQ, ""));
    }
    for (;;)
    {
      this.mUrl = paramString;
      this.jdField_a_of_type_Arxh = new arxh(paramString, "GET", new arsc.d(paramc), true);
      this.jdField_a_of_type_Arxh.dL(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = asbg.a().qP("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = asbg.a().qP("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = asbg.a().qP("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = asbg.a().qP("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle, arsc.b paramb)
  {
    this.jdField_a_of_type_Arsc$b = paramb;
    paramBundle.putString("time", asbf.getGlobalPreference(aroi.a().getContext(), "prefer_last_avatar_update_time").getString(this.cBQ, "0"));
    new arxh(paramString, "GET", new arsc.a(), true).dL(paramBundle);
  }
  
  public ArrayList<artm> ef()
  {
    int i = 0;
    if (this.jdField_a_of_type_Aryj == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Aryj.getCount();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((artm)this.jdField_a_of_type_Aryj.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void iG(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        arwt.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.gR = Long.parseLong(asbf.getGlobalPreference(aroi.a().getContext(), "uin_openid_store").getString(paramString2, ""));
      this.mAppid = paramString1;
      this.cBQ = paramString2;
      try
      {
        this.jdField_a_of_type_Aryj = aryg.a().a(artm.class, this.gR, "invite_friend_list_" + this.cBQ);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void nk(List<artm> paramList)
  {
    if (this.jdField_a_of_type_Aryj == null) {
      return;
    }
    artm[] arrayOfartm = new artm[paramList.size()];
    paramList.toArray(arrayOfartm);
    this.jdField_a_of_type_Aryj.a(arrayOfartm, 2);
  }
  
  public void releaseResource()
  {
    this.jdField_a_of_type_Arsc$b = null;
    if (this.jdField_a_of_type_Arxh != null) {
      this.jdField_a_of_type_Arxh.elV();
    }
  }
  
  public class a
    implements arxh.a
  {
    protected a() {}
    
    public void ai(JSONObject paramJSONObject)
    {
      try
      {
        int i = paramJSONObject.getInt("ret");
        Object localObject = paramJSONObject.getString("msg");
        if (i == 0)
        {
          localObject = paramJSONObject.getJSONArray("update_list");
          i = ((JSONArray)localObject).length();
          if (i > 0) {
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.CheckAvatarUpdateCallback.1(this, i, (JSONArray)localObject));
          }
          localObject = asbf.getGlobalPreference(aroi.a().getContext(), "prefer_last_avatar_update_time").edit();
          ((SharedPreferences.Editor)localObject).putString(arsc.this.cBQ, paramJSONObject.getString("time"));
          ((SharedPreferences.Editor)localObject).commit();
          if (arsc.this.a != null) {
            arsc.this.a.elt();
          }
        }
        else
        {
          arwt.e("OpenSdkFriendService", "CheckAvatarUpdateCallback error. ret=" + i + ", msg=" + (String)localObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        arwt.e("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramJSONObject.getMessage(), paramJSONObject);
      }
    }
    
    public void onException(Exception paramException)
    {
      arwt.e("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramException.getMessage(), paramException);
    }
  }
  
  public static abstract interface b
  {
    public abstract void elt();
  }
  
  public static abstract interface c
  {
    public abstract void a(arto paramarto);
    
    public abstract void ea(Intent paramIntent);
  }
  
  public class d
    implements arxh.a
  {
    protected final WeakReference<arsc.c> iK;
    
    public d(arsc.c paramc)
    {
      this.iK = new WeakReference(paramc);
    }
    
    public void ai(JSONObject paramJSONObject)
    {
      arto localarto = new arto();
      for (;;)
      {
        Object localObject;
        try
        {
          localarto.retCode = paramJSONObject.getInt("ret");
          localarto.errMsg = paramJSONObject.getString("msg");
          if (localarto.retCode != 0) {
            break label482;
          }
          if (paramJSONObject.has("conc_max")) {
            localarto.ekW = paramJSONObject.getInt("conc_max");
          }
          if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
          {
            localarto.ekU = paramJSONObject.getInt("inv_max");
            localarto.ekV = paramJSONObject.getInt("inv_count");
          }
          if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
          {
            localarto.ekU = paramJSONObject.getInt("fgmax");
            localarto.ekV = paramJSONObject.getInt("fgcur");
          }
          arwt.d("OpenSdkFriendService", "-->result = " + paramJSONObject);
          localarto.ekR = paramJSONObject.optInt("app_rid", -1);
          localarto.ekS = paramJSONObject.optInt("app_tid", -1);
          if ("action_invite".equals(arsc.this.mAction))
          {
            if (!paramJSONObject.has("md5str")) {
              break label557;
            }
            localObject = paramJSONObject.getString("md5str");
            if (!asbf.getGlobalPreference(aroi.a().getContext(), "invite_friend_list_md5").getString(arsc.this.cBQ, "").equals(localObject))
            {
              paramJSONObject = (ArrayList)artm.f(paramJSONObject);
              localarto.groups = paramJSONObject;
              ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
              paramJSONObject = (arsc.c)this.iK.get();
              if (paramJSONObject == null) {
                break label556;
              }
              paramJSONObject.a(localarto);
              return;
            }
            localarto.groups = arsc.this.ef();
            if (localarto.groups.size() != 0) {
              continue;
            }
            arsc.this.mParams.putString("md5str", "0");
            arsc.this.WV("0");
            paramJSONObject = (arsc.c)this.iK.get();
            if (paramJSONObject == null) {
              break label556;
            }
            new arxh(arsc.this.mUrl, "GET", new d(arsc.this, paramJSONObject), true).dL(arsc.this.mParams);
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          onException(paramJSONObject);
          return;
        }
        if (("action_gift".equals(arsc.this.mAction)) || ("action_ask".equals(arsc.this.mAction)) || ("action_voice".equals(arsc.this.mAction)) || ("action_reactive".equals(arsc.this.mAction)))
        {
          localarto.groups = ((ArrayList)artm.e(paramJSONObject));
        }
        else
        {
          localarto.groups = ((ArrayList)artm.d(paramJSONObject));
          continue;
          label482:
          localarto.response = paramJSONObject;
          paramJSONObject = new Intent();
          paramJSONObject.putExtra("key_error_code", localarto.retCode);
          paramJSONObject.putExtra("key_error_msg", localarto.errMsg);
          paramJSONObject.putExtra("key_error_detail", localarto.response.toString());
          localObject = (arsc.c)this.iK.get();
          if (localObject != null) {
            ((arsc.c)localObject).ea(paramJSONObject);
          }
          label556:
          return;
          label557:
          localObject = null;
        }
      }
    }
    
    public void onException(Exception paramException)
    {
      arwt.e("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
      Intent localIntent = new Intent();
      if ((paramException instanceof ConnectTimeoutException))
      {
        localIntent.putExtra("key_error_code", -7);
        localIntent.putExtra("key_error_msg", arxo.cCU);
      }
      for (;;)
      {
        paramException = (arsc.c)this.iK.get();
        if (paramException != null) {
          paramException.ea(localIntent);
        }
        return;
        if ((paramException instanceof SocketTimeoutException))
        {
          localIntent.putExtra("key_error_code", -8);
          localIntent.putExtra("key_error_msg", arxo.cCV);
        }
        else if ((paramException instanceof MalformedURLException))
        {
          localIntent.putExtra("key_error_code", -3);
          localIntent.putExtra("key_error_msg", "访问url有误!");
        }
        else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
        {
          localIntent.putExtra("key_error_code", -10);
          localIntent.putExtra("key_error_msg", "Http返回码异常!");
        }
        else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
        {
          localIntent.putExtra("key_error_code", -9);
          localIntent.putExtra("key_error_msg", arxo.cCW);
        }
        else if ((paramException instanceof JSONException))
        {
          localIntent.putExtra("key_error_code", -4);
          localIntent.putExtra("key_error_msg", arxo.cCS);
        }
        else if ((paramException instanceof IOException))
        {
          localIntent.putExtra("key_error_code", -2);
          localIntent.putExtra("key_error_msg", arxo.cCR);
        }
        else
        {
          localIntent.putExtra("key_error_code", -6);
          localIntent.putExtra("key_error_msg", arxo.cCT);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsc
 * JD-Core Version:    0.7.0.1
 */