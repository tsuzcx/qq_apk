import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import org.json.JSONObject;

class ywl
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      yxp.a("GdtAppJumpJsCallHandler", "handleJsCallRequest " + paramString);
      paramString.optString("adId");
      paramString.optString("downloadUrlType");
      if ("1".equals(paramString.optString("autoDownload"))) {}
      for (;;)
      {
        new Bundle();
        GdtBaseAdItem localGdtBaseAdItem = GdtBaseAdItem.a(paramVarArgs[0]);
        paramVarArgs = paramywk.a();
        if (paramVarArgs != null)
        {
          paramString = paramVarArgs.getIntent();
          if (TextUtils.isEmpty(paramString.getStringExtra("big_brother_ref_source_key")))
          {
            paramString = paramString.getStringExtra("big_brother_source_key");
            localGdtBaseAdItem.a = new Bundle();
            localGdtBaseAdItem.a.putString("big_brother_ref_source_key", paramString);
          }
        }
        else
        {
          yyn.a(localGdtBaseAdItem);
          if (TextUtils.isEmpty(localGdtBaseAdItem.f)) {
            break label187;
          }
          paramString = localGdtBaseAdItem.f;
          label157:
          if (paramywk == null) {
            break label196;
          }
        }
        label187:
        label196:
        for (paramywk = paramywk.a();; paramywk = null)
        {
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "doAppJump", paramywk, paramString);
          return true;
          paramString = paramString.getStringExtra("big_brother_ref_source_key");
          break;
          paramString = localGdtBaseAdItem.b;
          break label157;
        }
      }
    }
    catch (Exception paramywk)
    {
      yxp.d("GdtAppJumpJsCallHandler", "handleJsCallRequest", paramywk);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywl
 * JD-Core Version:    0.7.0.1
 */