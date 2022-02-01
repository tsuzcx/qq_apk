import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.subscribe.SubscribeJsPlugin.2;
import com.tencent.biz.subscribe.SubscribeJsPlugin.3;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rzb
  extends WebViewPlugin
  implements aduk.a
{
  private aduk a;
  private skj mClient;
  
  private boolean c(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      QLog.e(this.TAG, 2, "args is null");
      bool = false;
    }
    return bool;
  }
  
  private void f(String paramString, String[] paramArrayOfString)
    throws JSONException
  {
    if ("opendetail".equals(paramString)) {
      if (c(paramArrayOfString)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          paramString = new rzb.a(paramArrayOfString[0]);
                          QLog.d(this.TAG, 2, paramString.toString());
                          if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof SubscribeHybirdFragment)))
                          {
                            ((SubscribeHybirdFragment)this.mRuntime.b()).e(rzd.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
                            return;
                          }
                        } while ((this.mRuntime == null) || (this.mRuntime.getActivity() == null));
                        rzd.a(null, rzd.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
                        return;
                        if (!"sharepersonalpage".equals(paramString)) {
                          break;
                        }
                      } while (!c(paramArrayOfString));
                      paramString = new rzb.a(paramArrayOfString[0]);
                    } while ((this.mRuntime == null) || (!(this.mRuntime.b() instanceof SubscribeHybirdFragment)));
                    QLog.d(this.TAG, 2, paramString.toString());
                    ((SubscribeHybirdFragment)this.mRuntime.b()).h(paramString.getString("uin"), paramString.getString("nickname"), paramString.getString("icon"), paramString.getString("desc"), paramString.getString("usertype"));
                    return;
                    if (!"reloadmainpage".equals(paramString)) {
                      break;
                    }
                  } while ((this.mRuntime == null) || (!(this.mRuntime.b() instanceof SubscribeHybirdFragment)));
                  ((SubscribeHybirdFragment)this.mRuntime.b()).bye();
                  return;
                  if (!"openpublishpage".equals(paramString)) {
                    break;
                  }
                } while ((!c(paramArrayOfString)) || (this.mRuntime == null) || (this.mRuntime.b() == null));
                paramString = new rzb.a(paramArrayOfString[0]).optString("puin");
                new Intent().putExtra("postUin", paramString);
                avpw.i(this.mRuntime.b().getActivity(), null, 0);
                return;
                if (!"attachGoods".equals(paramString)) {
                  break;
                }
              } while (!c(paramArrayOfString));
              sT(paramArrayOfString[0]);
              return;
              if (!"cancelfollow".equals(paramString)) {
                break;
              }
            } while (!c(paramArrayOfString));
            sU(paramArrayOfString[0]);
            return;
            if (!"getavatar".equals(paramString)) {
              break;
            }
          } while (!c(paramArrayOfString));
          sV(paramArrayOfString[0]);
          return;
          if (!"refreshreturnpage".equals(paramString)) {
            break;
          }
        } while ((this.mRuntime == null) || (!(this.mRuntime.b() instanceof SubscribeHybirdFragment)));
        ((SubscribeHybirdFragment)this.mRuntime.b()).byf();
        return;
        if (!"getlbslocation".equals(paramString)) {
          break;
        }
      } while (!c(paramArrayOfString));
      sS(paramArrayOfString[0]);
      return;
    } while ((!"openhomepage".equals(paramString)) || (!c(paramArrayOfString)));
    rzd.bf(null, new rzb.a(paramArrayOfString[0]).optString("uid"));
  }
  
  private void n(String paramString, Bitmap paramBitmap)
  {
    ThreadManager.post(new SubscribeJsPlugin.3(this, paramBitmap, paramString), 8, null, false);
  }
  
  private void sS(String paramString)
    throws JSONException
  {
    paramString = new rzb.a(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("code", paramString.optString("code"));
    localBundle.putString("location", paramString.optString("location"));
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    this.mClient.ba(localBundle);
  }
  
  private void sT(String paramString)
    throws JSONException
  {
    paramString = new rzb.a(paramString).getJSONArray("goods");
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject != null) {
          localArrayList.add(new CommodityBean(localJSONObject));
        }
        i += 1;
      }
      if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof SubscribeHybirdFragment))) {
        ((SubscribeHybirdFragment)this.mRuntime.b()).cy(localArrayList);
      }
    }
  }
  
  private void sU(String paramString)
    throws JSONException
  {
    if ((this.mRuntime == null) || (this.mRuntime.b() == null) || (this.mRuntime.b().getActivity() == null)) {
      return;
    }
    Object localObject = new rzb.a(paramString);
    paramString = ((rzb.a)localObject).optString("uin");
    String str = ((rzb.a)localObject).optString("nick");
    localObject = ((rzb.a)localObject).optString("callback");
    shk.a(this.mRuntime.b().getActivity(), paramString, str, new rzc(this, (String)localObject, str));
  }
  
  private void sV(String paramString)
    throws JSONException
  {
    if ((this.mRuntime == null) || (this.mRuntime.b() == null) || (this.mRuntime.b().getActivity() == null)) {
      return;
    }
    paramString = new rzb.a(paramString);
    JSONArray localJSONArray = paramString.optJSONArray("accountList");
    int i;
    if ("1".equals(paramString.getString("avatarType")))
    {
      i = 4;
      if (this.a != null) {
        break label130;
      }
      this.a = new aduk(this.mRuntime.getActivity(), i);
      this.a.init();
      this.a.a(this);
    }
    for (;;)
    {
      ThreadManagerV2.excute(new SubscribeJsPlugin.2(this, localJSONArray), 16, null, false);
      return;
      i = 1;
      break;
      label130:
      this.a.LB(i);
    }
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    n(paramString1, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 4, "handleGetAvatar onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qsubscribe".equals(paramString2))
    {
      QLog.i(this.TAG, 2, "handleJsRequest:" + paramString1);
      try
      {
        f(paramString3, paramVarArgs);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          QLog.d(this.TAG, 2, paramJsBridgeListener, new Object[0]);
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mClient != null)
    {
      this.mClient.bzk();
      this.mClient = null;
    }
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
  }
  
  public class a
    extends JSONObject
  {
    public a(String paramString)
      throws JSONException
    {
      super();
    }
    
    public int getInt(String paramString)
      throws JSONException
    {
      if (!has(paramString)) {
        return 0;
      }
      return super.getInt(paramString);
    }
    
    public String getString(String paramString)
      throws JSONException
    {
      if (!has(paramString)) {
        return "";
      }
      return super.getString(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzb
 * JD-Core Version:    0.7.0.1
 */