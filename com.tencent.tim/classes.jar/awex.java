import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class awex
  extends awfr
  implements avzi
{
  private String cPK;
  
  private void i(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str1;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        l = paramVarArgs.optLong("uin");
        str1 = paramVarArgs.optString("payKey");
        localObject = paramVarArgs.optString("nickName");
        this.cPK = paramVarArgs.optString("callback");
        if (l == 0L)
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "uin error , uin " + l);
          return;
        }
        if (TextUtils.isEmpty(str1))
        {
          QLog.e("QZoneRedPocketGiftJsPlugin", 1, "payKey error , paykey = " + str1);
          return;
        }
      }
      catch (Exception paramWebViewPlugin)
      {
        x(this.cPK, null, acfp.m(2131713345), -1);
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, paramWebViewPlugin.getMessage());
        return;
      }
      if (TextUtils.isEmpty(this.cPK))
      {
        QLog.e("QZoneRedPocketGiftJsPlugin", 1, "callback is empty.");
        return;
      }
      paramVarArgs = (String[])localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramVarArgs = String.valueOf(l);
      }
      avzf.a().a().be(l, str1);
      Object localObject = avpw.d.a();
      String str2 = ((TicketManager)parama.a().getManager(2)).getSkey(parama.a().getAccount());
      int i = avpw.a(paramWebViewPlugin, parama, 8);
      avpw.a(parama.getActivity(), (avpw.d)localObject, str2, l, paramVarArgs, str1, i);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!"sendRedPocketGift".equals(paramString3)) {
      return false;
    }
    avzf.a().a(this);
    i(this.f, this.f.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      x(this.cPK, null, acfp.m(2131713343), 0);
      return;
    }
    x(this.cPK, null, acfp.m(2131713346), -1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        if (paramBundle.getBundle("data") != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QZoneRedPocketGiftJsPlugin", 2, "call js function,bundle is empty");
      return;
    } while (!"cmd.qzoneSendRedPocketGift".equals(paramString));
    if (TextUtils.isEmpty(this.cPK))
    {
      x(this.cPK, null, acfp.m(2131713342), -1);
      return;
    }
    x(this.cPK, null, acfp.m(2131713347), 0);
  }
  
  protected void x(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    JSONObject localJSONObject;
    if (this.f != null)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        paramInt = -1;
        paramString3 = acfp.m(2131713344);
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("data", paramString2);
      localJSONObject.put("message", paramString3);
      this.f.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awex
 * JD-Core Version:    0.7.0.1
 */