package com.tencent.token.ui;

import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;

class ht
  implements Runnable
{
  ht(hs paramhs, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.length() > 0))
    {
      localObject1 = new StringBuffer("");
      Intent localIntent = new Intent(this.b.a, CopyFaceToOtherUinActivity.class);
      int i = 0;
      for (;;)
      {
        Object localObject2 = localObject1;
        try
        {
          if (i >= this.a.length()) {
            break label154;
          }
          localJSONObject = this.a.getJSONObject(i);
          localObject2 = ((StringBuffer)localObject1).append(localJSONObject.getString("nick"));
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          try
          {
            JSONObject localJSONObject;
            ((StringBuffer)localObject2).append("(");
            localObject1 = localObject2;
            localObject2 = ((StringBuffer)localObject2).append(localJSONObject.getString("uin_mask"));
            localObject1 = localObject2;
            ((StringBuffer)localObject2).append(")");
            localObject1 = localObject2;
            if (i < this.a.length() - 1)
            {
              localObject1 = localObject2;
              ((StringBuffer)localObject2).append("、");
            }
            i += 1;
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            Object localObject3;
            break;
          }
          localException1 = localException1;
        }
      }
      localException1.printStackTrace();
      localObject3 = localObject1;
      label154:
      localIntent.putExtra("nofaceuinlists", localObject3.toString());
      this.b.a.startActivity(localIntent);
      this.b.a.finish();
      return;
    }
    Object localObject1 = new Intent(this.b.a, FaceRecognitionDefaultActivity.class);
    ((Intent)localObject1).putExtra("toastflag", 1);
    ((Intent)localObject1).addFlags(67108864);
    this.b.a.startActivity((Intent)localObject1);
    this.b.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ht
 * JD-Core Version:    0.7.0.1
 */