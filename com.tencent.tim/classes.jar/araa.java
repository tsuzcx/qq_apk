import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class araa
  implements aqez.a<String>
{
  public araa(WebViewFragment paramWebViewFragment) {}
  
  public void B(String paramString, Bitmap paramBitmap)
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, "screen long shot error, activity is null");
      return;
    }
    paramBitmap = new Intent();
    paramBitmap.putExtra("public_fragment_window_feature", 1);
    paramBitmap.putExtra("screen_path", paramString);
    paramBitmap.putExtra("is_web_screen_long_shot", true);
    PublicFragmentActivity.b.start(this.this$0.getActivity(), paramBitmap, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
  
  public void g(Exception paramException)
  {
    QLog.e("WebLog_WebViewFragment", 1, "onScreenShotError, error is " + paramException.getMessage());
    if (this.this$0.getActivity() == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, "screen long shot onScreenShotError, activity is null");
      return;
    }
    QQToast.a(this.this$0.getActivity(), 2131719216, 0).show();
  }
  
  public String i(Bitmap paramBitmap)
  {
    String str = aqez.BU() + System.currentTimeMillis() + ".jpg";
    Utils.saveBitmapToFile(paramBitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     araa
 * JD-Core Version:    0.7.0.1
 */