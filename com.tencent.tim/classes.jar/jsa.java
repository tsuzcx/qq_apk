import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class jsa
  implements acci
{
  jsa(jrz paramjrz) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramObject = (Bundle)paramObject;
      if (paramObject == null) {
        continue;
      }
      paramInt = paramObject.getInt("reqCode");
      if (paramInt == 10000)
      {
        str1 = paramObject.getString("name");
        String str2 = paramObject.getString("callback");
        String str3 = paramObject.getString("msg");
        long l = paramObject.getLong("uiResId");
        this.a.mCallBack = str2;
        jrz.a(this.a, 1, l, str1, str3);
        return;
      }
      if (paramInt != 10002) {
        continue;
      }
      paramBoolean = paramObject.getBoolean("isOpen");
      String str1 = paramObject.getString("callback");
      boolean bool = paramObject.getBoolean("has");
      paramObject = new JSONObject();
      if (bool) {
        if (paramBoolean) {
          paramInt = 1;
        }
      }
      try
      {
        label153:
        paramObject.put("isOpen", paramInt);
        while (!TextUtils.isEmpty(str1))
        {
          this.a.callJs(str1, new String[] { paramObject.toString() });
          return;
          paramInt = 0;
          break label153;
          paramObject.put("isOpen", 1);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
      paramObject = new JSONObject();
      if (paramBoolean) {}
      try
      {
        paramObject.put("userOption", 1);
        while (!TextUtils.isEmpty(this.a.mCallBack))
        {
          this.a.callJs(this.a.mCallBack, new String[] { paramObject.toString() });
          this.a.mCallBack = null;
          return;
          paramObject.put("userOption", 0);
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsa
 * JD-Core Version:    0.7.0.1
 */