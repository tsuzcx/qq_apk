import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class aijx
  implements skj.a
{
  public aijx(QQApiPlugin.3 param3, Bitmap paramBitmap) {}
  
  public void callback(Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramBundle.getInt("readinjoy_to_wx_config") == 0)
    {
      paramBundle = WxShareHelperFromReadInjoy.a();
      str1 = this.a.this$0.Qt;
      str2 = this.a.val$title;
      localBitmap = this.val$image;
      str3 = this.a.val$desc;
      str4 = this.a.ake;
      if ("2".equals(this.a.amz)) {}
      for (;;)
      {
        paramBundle.a(str1, str2, localBitmap, str3, str4, i);
        return;
        i = 1;
      }
    }
    paramBundle = WXShareHelper.a();
    String str1 = this.a.this$0.Qt;
    String str2 = this.a.val$title;
    Bitmap localBitmap = this.val$image;
    String str3 = this.a.val$desc;
    String str4 = this.a.ake;
    if ("2".equals(this.a.amz)) {}
    for (i = j;; i = 1)
    {
      paramBundle.a(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijx
 * JD-Core Version:    0.7.0.1
 */