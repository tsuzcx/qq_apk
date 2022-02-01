import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class awgz
  extends WebViewPlugin
{
  public static String KEY_UIN = "key_uin";
  public static String PKG_NAME = "QZFamousUserHome";
  public static String REFER;
  public static String cQd = "usermoodlist";
  public static String cQe = "useralbum";
  public static String cQf = "userhome";
  public static String cQg = "openRedPocket";
  public static String cQh = "key_nickname";
  
  static
  {
    REFER = "famous";
  }
  
  public awgz()
  {
    this.mPluginNameSpace = PKG_NAME;
  }
  
  private void aF(String... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      String str;
      Activity localActivity;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject).getLong("uin");
        if (!((JSONObject)localObject).has("actiontype")) {
          break label362;
        }
        i = ((JSONObject)localObject).getInt("actiontype");
        if (!((JSONObject)localObject).has("actionurl")) {
          break label367;
        }
        paramVarArgs = ((JSONObject)localObject).optString("actionurl");
        if (!((JSONObject)localObject).has("cover_type")) {
          break label373;
        }
        j = ((JSONObject)localObject).getInt("cover_type");
        if (!((JSONObject)localObject).has("action_url")) {
          break label378;
        }
        str = ((JSONObject)localObject).optString("action_url");
        if (!((JSONObject)localObject).has("autoShowTimeLine")) {
          break label385;
        }
        localObject = ((JSONObject)localObject).optString("autoShowTimeLine");
        boolean bool = "1".equals(localObject);
        localObject = new Intent();
        localActivity = this.mRuntime.getActivity();
        if ((35 == i) && (paramVarArgs != null) && (paramVarArgs.length() > 0))
        {
          if ((localActivity != null) && ((localActivity instanceof awgz.a)) && (((awgz.a)localActivity).mu())) {
            return;
          }
          str = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
          ((Intent)localObject).putExtra("famous_space_webview_url", paramVarArgs);
          paramVarArgs = str;
          QzonePluginProxyActivity.x((Intent)localObject, paramVarArgs);
          ((Intent)localObject).putExtra("qqid", l);
          ((Intent)localObject).putExtra("refer", REFER);
          ((Intent)localObject).putExtra("autoShowTimeLine", bool);
          if (bool) {
            ((Intent)localObject).setFlags(335544320);
          }
          if ((localActivity == null) || ((!(localActivity instanceof awgz.a)) && (!(localActivity instanceof BasePluginActivity)))) {
            break label343;
          }
          ((Intent)localObject).setClassName(localActivity, paramVarArgs);
          localActivity.startActivity((Intent)localObject);
          return;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      if ((j == 35) && (str != null) && (str.length() > 0))
      {
        paramVarArgs = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
        ((Intent)localObject).putExtra("famous_space_webview_url", str);
      }
      else
      {
        paramVarArgs = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
        ((Intent)localObject).setFlags(67108864);
        continue;
        label343:
        QzonePluginProxyActivity.a(localActivity, this.mRuntime.a().getAccount(), (Intent)localObject, 0);
        return;
        label362:
        i = 0;
        continue;
        label367:
        paramVarArgs = "";
        continue;
        label373:
        j = 0;
        continue;
        label378:
        str = "";
        continue;
        label385:
        localObject = "0";
      }
    }
  }
  
  private void aG(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.x(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
      localIntent.putExtra(KEY_UIN, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(cQh, paramVarArgs);
      }
      localIntent.putExtra("refer", REFER);
      QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void aH(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.x(paramVarArgs, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
      paramVarArgs.putExtra("key_left_tab_title", this.mRuntime.getActivity().getString(2131717641));
      paramVarArgs.putExtra("key_right_tab_title", this.mRuntime.getActivity().getString(2131717722));
      paramVarArgs.putExtra("key_album_owner_uin", l);
      paramVarArgs.putExtra("key_selected_tab", 0);
      paramVarArgs.putExtra("refer", REFER);
      QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!PKG_NAME.equals(paramString2)) {}
    do
    {
      return false;
      if (paramString3.equals(cQd))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          aG(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(cQe))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          aH(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(cQf))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          aF(paramVarArgs);
        }
        return true;
      }
    } while (!paramString3.equals(cQg));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      l = Long.parseLong(paramVarArgs[0]);
      if (l != 0L)
      {
        this.mRuntime.getActivity();
        paramJsBridgeListener = new Intent();
        paramJsBridgeListener.setAction("qzoneGrapRedPocket");
        paramJsBridgeListener.putExtra("uin", l);
        if (this.mRuntime.getActivity() != null) {
          this.mRuntime.getActivity().sendBroadcast(paramJsBridgeListener);
        }
      }
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        long l = 0L;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean mu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgz
 * JD-Core Version:    0.7.0.1
 */