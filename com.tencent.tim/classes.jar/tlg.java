import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.statistics.GdtReporter;

public class tlg
{
  public static void a(Ad paramAd, int paramInt)
  {
    if (TextUtils.isEmpty(paramAd.getUrlForEffect()))
    {
      tkw.e("GdtTraceReporter", String.format("report %d error", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    tkw.i("GdtTraceReporter", String.format("report %d", new Object[] { Integer.valueOf(paramInt) }));
    GdtReporter.doCgiReport(paramAd.getUrlForEffect().replaceAll("__CLICK_ID__", paramAd.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(paramInt)));
  }
  
  public static void n(int paramInt, String paramString1, String paramString2)
  {
    GdtReporter.doCgiReport("https://t.gdt.qq.com/conv/src/50/conv?" + "click_id={$clickid$}&product_id={$appid$}&conv_type={$convtype$}&conv_time={$convtime$}".replace("{$clickid$}", paramString1).replace("{$appid$}", paramString2).replace("{$convtype$}", new StringBuilder().append(paramInt).append("").toString()).replace("{$convtime$}", new StringBuilder().append(System.currentTimeMillis() / 1000L).append("").toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlg
 * JD-Core Version:    0.7.0.1
 */