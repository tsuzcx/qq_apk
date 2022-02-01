import android.app.Activity;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

final class ahbc
  implements ValueCallback<String>
{
  ahbc(WeakReference paramWeakReference, String paramString, WXShareHelper paramWXShareHelper) {}
  
  public void onReceiveValue(String paramString)
  {
    Activity localActivity = (Activity)this.gV.get();
    if ((localActivity == null) || (paramString == null)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramString.split(":");
        if ((localObject == null) || (localObject.length != 2) || (localObject[0].startsWith("http"))) {
          break;
        }
        paramString = localObject[0];
        localObject = localObject[1];
        String str = ahav.access$000(paramString);
        i = ahav.dd((String)localObject);
        if (str != null) {
          anot.a(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
        }
      } while (((!paramString.startsWith("userClick")) && (!paramString.startsWith("extraMenuEvent"))) || (!((String)localObject).equalsIgnoreCase("send_to_wx")) || (!ahbr.T(localActivity, this.val$filePath)));
      int i = ahav.r(this.val$filePath);
      paramString = BitmapFactory.decodeResource(localActivity.getResources(), i);
      this.a.D(this.val$filePath, paramString);
      return;
    } while (!paramString.startsWith("http"));
    if (aglz.a().ms("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386")) {}
    anot.a(null, "dc00898", "", "", "0X800AE47", "0X800AE47", 0, 0, "", "", "", "");
    ahal.a(localActivity, null, 2131700297, new ahbd(this, localActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbc
 * JD-Core Version:    0.7.0.1
 */