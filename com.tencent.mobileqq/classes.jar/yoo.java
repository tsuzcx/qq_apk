import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;

public class yoo
{
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    yol.a("http://t.gdt.qq.com/conv/src/50/conv?" + "click_id={$clickid$}&product_id={$appid$}&conv_type={$convtype$}&conv_time={$convtime$}".replace("{$clickid$}", paramString1).replace("{$appid$}", paramString2).replace("{$convtype$}", new StringBuilder().append(paramInt).append("").toString()).replace("{$convtime$}", new StringBuilder().append(System.currentTimeMillis() / 1000L).append("").toString()));
  }
  
  public static void a(GdtAd paramGdtAd, int paramInt)
  {
    if (TextUtils.isEmpty(paramGdtAd.getUrlForEffect()))
    {
      yny.d("GdtTraceReporter", String.format("report %d error", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    yny.b("GdtTraceReporter", String.format("report %d", new Object[] { Integer.valueOf(paramInt) }));
    yol.a(paramGdtAd.getUrlForEffect().replaceAll("__CLICK_ID__", paramGdtAd.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */