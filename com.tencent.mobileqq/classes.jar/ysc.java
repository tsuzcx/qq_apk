import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.ad.tangram.web.AdBrowserAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.lang.ref.WeakReference;

public final class ysc
  implements AdBrowserAdapter
{
  public AdError show(AdBrowserAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      yxs.d("GdtBrowserAdapter", "show error");
      return new AdError(4);
    }
    yxs.b("GdtBrowserAdapter", String.format("show %s", new Object[] { paramParams.url }));
    Object localObject = (GdtAd)GdtAd.class.cast(paramParams.ad);
    Intent localIntent = new Intent((Context)paramParams.activity.get(), QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", paramParams.url);
    if ((paramParams.extrasForIntent != null) && (!paramParams.extrasForIntent.isEmpty())) {
      localIntent.putExtras(paramParams.extrasForIntent);
    }
    if ((paramParams.ad != null) && (paramParams.ad.isValid()))
    {
      if (((GdtAd)localObject).getNocoId() != 0L) {
        localIntent.putExtra("GdtNocoId", ((GdtAd)localObject).getNocoId());
      }
      localIntent.putExtra("GdtWebReportQQ_TRACE_ID", paramParams.ad.getTraceId());
      localIntent.putExtra("GdtNocoId", ((GdtAd)localObject).getNocoId());
      localIntent.putExtra("GdtWebReportQQ_ACTION_URL", ((GdtAd)localObject).getUrlForAction());
    }
    if ((paramParams.ad != null) && (paramParams.ad.getProductType() == 25))
    {
      localObject = paramParams.ad.getUrlForClick();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("1".equals(AdUriUtil.getQueryParameter(AdUriUtil.parse((String)localObject), "autoclose")))) {
        localIntent.putExtra("keyForForceCloseAfterJump", true);
      }
    }
    ((Activity)paramParams.activity.get()).startActivity(localIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysc
 * JD-Core Version:    0.7.0.1
 */