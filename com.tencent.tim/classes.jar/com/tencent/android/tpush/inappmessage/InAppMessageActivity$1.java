package com.tencent.android.tpush.inappmessage;

import android.os.Handler;
import com.tencent.android.tpush.logging.TLogger;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class InAppMessageActivity$1
  implements Runnable
{
  InAppMessageActivity$1(InAppMessageActivity paramInAppMessageActivity, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        JSONObject localJSONObject = new JSONObject(this.a).optJSONObject("dispContent");
        if (localJSONObject == null) {
          return;
        }
        localHashMap.put("Message.template.type", Integer.valueOf(localJSONObject.optInt("templateType", 1)));
        Object localObject1 = localJSONObject.optJSONObject("titleLabel");
        if (localObject1 != null)
        {
          Object localObject2 = ((JSONObject)localObject1).optString("text", "");
          String str1 = ((JSONObject)localObject1).optString("color", "");
          int i = ((JSONObject)localObject1).optInt("size", 20);
          String str2 = ((JSONObject)localObject1).optString("font", "");
          int j = ((JSONObject)localObject1).optInt("style", 0);
          int k = ((JSONObject)localObject1).optInt("alignment", 17);
          int m = ((JSONObject)localObject1).optInt("location", 0);
          localHashMap.put("Title.Text", localObject2);
          localHashMap.put("Title.Color", str1);
          localHashMap.put("Title.Size", Integer.valueOf(i));
          localHashMap.put("Title.Align", Integer.valueOf(k));
          localHashMap.put("Title.Paint", str2);
          localHashMap.put("Title.Typeface", Integer.valueOf(j));
          localHashMap.put(Integer.valueOf(m), "Title.Location");
          localHashMap.put("Title Is Have", Boolean.valueOf(true));
          localObject1 = localJSONObject.optJSONObject("contentLabel");
          if (localObject1 == null) {
            break label1189;
          }
          localObject2 = ((JSONObject)localObject1).optString("text", "");
          str1 = ((JSONObject)localObject1).optString("color", "");
          i = ((JSONObject)localObject1).optInt("size", 20);
          str2 = ((JSONObject)localObject1).optString("font", "");
          j = ((JSONObject)localObject1).optInt("style", 0);
          k = ((JSONObject)localObject1).optInt("alignment", 17);
          m = ((JSONObject)localObject1).optInt("location", 0);
          localHashMap.put("Message.Size", Integer.valueOf(i));
          localHashMap.put("Message.Align", Integer.valueOf(k));
          localHashMap.put("Message.Paint", str2);
          localHashMap.put("Message.Typeface", Integer.valueOf(j));
          localHashMap.put("Message.Text", localObject2);
          localHashMap.put("Message.Color", str1);
          localHashMap.put(Integer.valueOf(m), "Message.Location");
          localHashMap.put("Message Is Have", Boolean.valueOf(true));
          localObject1 = localJSONObject.optJSONObject("mediaView");
          if (localObject1 == null) {
            break label1204;
          }
          localObject2 = ((JSONObject)localObject1).optString("url", "");
          i = ((JSONObject)localObject1).optInt("width", SizeUtil.dipTopx(InAppMessageActivity.a(this.b), 255.0F));
          j = ((JSONObject)localObject1).optInt("height", SizeUtil.dipTopx(InAppMessageActivity.a(this.b), 215.0F));
          k = ((JSONObject)localObject1).optInt("location", 0);
          localHashMap.put("Media url", localObject2);
          localHashMap.put("Media width", Integer.valueOf(i));
          localHashMap.put("Media heigh", Integer.valueOf(j));
          localHashMap.put(Integer.valueOf(k), "Media.Location");
          localHashMap.put("Media Is Have", Boolean.valueOf(true));
          localHashMap.put("Close button", Integer.valueOf(localJSONObject.optInt("showCloseBtn", 1)));
          localObject2 = localJSONObject.optJSONArray("customBtns");
          if (localObject2 != null)
          {
            i = ((JSONArray)localObject2).length();
            if (i > 0)
            {
              localObject1 = ((JSONArray)localObject2).getJSONObject(0);
              Object localObject3;
              if (localObject1 != null)
              {
                j = ((JSONObject)localObject1).optInt("buttonId", 0);
                if (j != 0)
                {
                  str1 = ((JSONObject)localObject1).optString("bgColor", "");
                  str2 = ((JSONObject)localObject1).optString("text", "");
                  localObject3 = ((JSONObject)localObject1).optString("textColor", "");
                  k = ((JSONObject)localObject1).optInt("textSize", 20);
                  m = ((JSONObject)localObject1).optInt("corner", 0);
                  int n = ((JSONObject)localObject1).optInt("location", 0);
                  String str3 = ((JSONObject)localObject1).optString("action", "");
                  int i1 = ((JSONObject)localObject1).optInt("actionType", 0);
                  localHashMap.put("Accept button.Text", str2);
                  localHashMap.put("Accept button.Background color", str1);
                  localHashMap.put("Accept button.Text color", localObject3);
                  localHashMap.put("Accept button.Text size", Integer.valueOf(k));
                  localHashMap.put("Accept button.corner", Integer.valueOf(m));
                  localHashMap.put("Accept button.id", Integer.valueOf(j));
                  localHashMap.put("Accept button.action", str3);
                  localHashMap.put(Integer.valueOf(n), "Button.Location");
                  localHashMap.put("Accept button.count", Integer.valueOf(i));
                  localHashMap.put("Accept button.action.type", Integer.valueOf(i1));
                }
              }
              if (i == 2)
              {
                localObject3 = ((JSONArray)localObject2).getJSONObject(1);
                if (localObject3 != null)
                {
                  i = ((JSONObject)localObject3).optInt("buttonId", 0);
                  if (i != 0)
                  {
                    localObject2 = ((JSONObject)localObject3).optString("bgColor", "");
                    str1 = ((JSONObject)localObject3).optString("text", "");
                    str2 = ((JSONObject)localObject3).optString("textColor", "");
                    j = ((JSONObject)localObject3).optInt("textSize", 20);
                    k = ((JSONObject)localObject3).optInt("corner", 0);
                    localObject3 = ((JSONObject)localObject3).optString("action", "");
                    m = ((JSONObject)localObject1).optInt("actionType", 0);
                    localHashMap.put("Accept sec button.Text", str1);
                    localHashMap.put("Accept sec button.Background color", localObject2);
                    localHashMap.put("Accept sec button.Text color", str2);
                    localHashMap.put("Accept sec button.Text size", Integer.valueOf(j));
                    localHashMap.put("Accept sec button.corner", Integer.valueOf(k));
                    localHashMap.put("Accept sec button.id", Integer.valueOf(i));
                    localHashMap.put("Accept sec button.action", localObject3);
                    localHashMap.put("Accept sec button.action.type", Integer.valueOf(m));
                  }
                }
              }
            }
          }
          localJSONObject = localJSONObject.optJSONObject("bgCard");
          if (localJSONObject != null)
          {
            localObject1 = localJSONObject.optString("url", "");
            localObject2 = localJSONObject.optString("action", "");
            i = localJSONObject.optInt("corner", 0);
            localHashMap.put("Background color", localJSONObject.optString("bgColor", ""));
            localHashMap.put("Background image url", localObject1);
            localHashMap.put("Background action", localObject2);
            localHashMap.put("Background corner", Integer.valueOf(i));
          }
          localHashMap.put("Layout.Width", Integer.valueOf(303));
          localHashMap.put("Layout.Height", Integer.valueOf(600));
          InAppMessageActivity.d(this.b).post(new InAppMessageActivity.1.1(this, localHashMap));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("InAppMessageActivity", "unexpected for InAppMsg:" + localThrowable.toString());
        return;
      }
      localThrowable.put("Title Is Have", Boolean.valueOf(false));
      continue;
      label1189:
      localThrowable.put("Message Is Have", Boolean.valueOf(false));
      continue;
      label1204:
      localThrowable.put("Media Is Have", Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.InAppMessageActivity.1
 * JD-Core Version:    0.7.0.1
 */