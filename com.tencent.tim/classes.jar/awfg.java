import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class awfg
  extends awfr
{
  private static String TAG = awfg.class.getSimpleName();
  
  private void a(WebViewPlugin.a parama, String[] paramArrayOfString, String paramString)
  {
    try
    {
      paramArrayOfString = this.f.mRuntime.getActivity();
      if ((paramArrayOfString != null) && (!paramArrayOfString.isFinishing()))
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.setAction(paramString);
        if (parama.getActivity() != null) {
          parama.getActivity().sendBroadcast(paramArrayOfString);
        }
      }
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  private void l(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    Activity localActivity = this.f.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      String str;
      do
      {
        return;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_item_id", paramArrayOfString.optInt("item_id"));
          ((Intent)localObject2).putExtra("key_thumb_url", paramArrayOfString.optString("thumb"));
          ((Intent)localObject2).putExtra("key_item_type", paramArrayOfString.optInt("item_type"));
          ((Intent)localObject2).setAction("action_album_skin_js_to_qzone");
          str = paramArrayOfString.optString("callback");
          localObject1 = paramArrayOfString.optString("entry");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.f.callJs(str, new String[] { "{\"result\":\"false\"}" });
            return;
          }
        }
        catch (JSONException parama)
        {
          parama.printStackTrace();
          return;
        }
      } while ((!"createAlbum".equals(localObject1)) && (!"editAlbum".equals(localObject1)) && (!"personal".equals(localObject1)) && (!"photolist".equals(localObject1)));
      if (parama.getActivity() != null) {
        parama.getActivity().sendBroadcast((Intent)localObject2);
      }
      this.f.callJs(str, new String[] { "{\"result\":\"true\"}" });
      parama = this.f.mRuntime.a();
    } while ((!"personal".equals(localObject1)) || (parama == null));
    Object localObject1 = avpw.d.a();
    ((avpw.d)localObject1).cMP = parama.getCurrentAccountUin();
    Object localObject2 = new BaseBusinessAlbumInfo();
    ((BaseBusinessAlbumInfo)localObject2).mAlbumId = paramArrayOfString.optString("albumid");
    ((BaseBusinessAlbumInfo)localObject2).mUin = parama.getLongAccountUin();
    ((BaseBusinessAlbumInfo)localObject2).mAlbumType = 0;
    ((BaseBusinessAlbumInfo)localObject2).doR = true;
    avpw.a(localActivity, (avpw.d)localObject1, (BaseBusinessAlbumInfo)localObject2, -1);
  }
  
  private void m(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.f.mRuntime.getActivity();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_album_comment_list_count", paramArrayOfString.optInt("count"));
        ((Intent)localObject).setAction("broadcastActionUpdateAlbumCommentList");
        if (parama.getActivity() != null) {
          parama.getActivity().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  private void n(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    a(parama, paramArrayOfString, "broadcastActionRefreshPhotoList");
  }
  
  private void o(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    a(parama, paramArrayOfString, "broadcastActionRefreshAlbumList");
  }
  
  private void p(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.f.mRuntime.getActivity();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("broadcastActionBlogShareData");
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
          ((Intent)localObject).putExtra("share_data", paramArrayOfString[0]);
        }
        if (parama.getActivity() != null) {
          parama.getActivity().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equalsIgnoreCase("SetAlbumSkin")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      l(this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ((paramString3.equalsIgnoreCase("UpdateAlbumCommentList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      m(this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("refreshPhotoList".equalsIgnoreCase(paramString3))
    {
      n(this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("RefreshAlbumList".equalsIgnoreCase(paramString3))
    {
      o(this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("getBlogArkShareData".equalsIgnoreCase(paramString3))
    {
      p(this.f.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfg
 * JD-Core Version:    0.7.0.1
 */