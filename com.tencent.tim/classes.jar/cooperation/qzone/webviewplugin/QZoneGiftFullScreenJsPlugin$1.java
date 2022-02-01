package cooperation.qzone.webviewplugin;

import aiyf;
import android.text.TextUtils;
import avzf;
import avzh;
import awel;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneGiftFullScreenJsPlugin$1
  implements Runnable
{
  public QZoneGiftFullScreenJsPlugin$1(awel paramawel, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject3;
    if ((this.val$args != null) && (this.val$args.length > 0) && (this.val$args[0] != null))
    {
      localObject3 = "";
      localObject5 = "";
      localObject2 = localObject3;
      localObject1 = localObject5;
    }
    Object localObject6;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(this.val$args[0]);
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject3 = localJSONObject.getString("giftid");
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject6 = localJSONObject.getJSONObject("giftZipUrl");
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (aiyf.getVideoPath().equals("sbig"))
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlSBig");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5SBig");
          localObject1 = localObject6;
          localObject2 = localObject5;
        }
      }
      catch (JSONException localJSONException1)
      {
        JSONObject localJSONObject;
        localObject5 = "";
      }
      try
      {
        awel.a(this.this$0, localJSONObject.getString("callback"));
        localObject6 = localObject3;
        localObject3 = localObject2;
        localObject5 = localObject1;
        if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty(awel.a(this.this$0)))) {
          break;
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localObject5 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          Object localObject4 = localJSONException2;
        }
      }
      localObject2 = localObject3;
      localObject1 = localObject5;
      if (aiyf.getVideoPath().equals("xbig"))
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject5 = ((JSONObject)localObject6).getString("androidZipUrlXBig");
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject6 = ((JSONObject)localObject6).getString("androidMd5XBig");
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      else
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (aiyf.getVideoPath().equals("small"))
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlSmall");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5Small");
          localObject2 = localObject5;
          localObject1 = localObject6;
        }
        else
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlBig");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5Big");
          localObject1 = localObject6;
          localObject2 = localObject5;
          continue;
          localJSONException1.printStackTrace();
          localObject4 = localObject1;
          localObject6 = localObject2;
        }
      }
    }
    avzf.a().a().bB((String)localObject6, localObject4, (String)localObject5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */