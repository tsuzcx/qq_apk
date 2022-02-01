package com.tencent.mobileqq.richmediabrowser.view;

import amea;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.util.SparseArray;
import anot;
import aqly;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import rvx;

public class AIOPictureView$9
  implements Runnable
{
  public AIOPictureView$9(amea paramamea, int paramInt, SparseArray paramSparseArray, ArrayList paramArrayList) {}
  
  @RequiresApi(api=5)
  public void run()
  {
    if ((this.this$0.mContext == null) || (this.this$0.mContext.isFinishing())) {
      return;
    }
    Object localObject;
    String str1;
    String str2;
    if (rvx.fa(this.mO))
    {
      localObject = this.o.get(1);
      if (!(localObject instanceof Pair)) {
        break label296;
      }
      localObject = (Pair)localObject;
      str1 = String.valueOf(((Pair)localObject).second).trim();
      str2 = String.valueOf(((Pair)localObject).first).trim();
    }
    label268:
    label275:
    label296:
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localObject = null;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("scannerType", str1);
            ((JSONObject)localObject).put("scannerResult", str2);
            if (localObject == null)
            {
              localObject = "";
              aqly.a(55, this.qL, (String)localObject, 0);
              anot.a(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
              if (rvx.fb(this.mO))
              {
                localObject = this.o.get(2);
                if (!(localObject instanceof String)) {
                  continue;
                }
                str1 = (String)localObject;
              }
            }
          }
          catch (JSONException localJSONException4)
          {
            continue;
            localObject = null;
            continue;
          }
          try
          {
            localObject = new JSONObject();
          }
          catch (JSONException localJSONException2)
          {
            localObject = null;
            localJSONException2.printStackTrace();
            continue;
            localObject = ((JSONObject)localObject).toString();
          }
        }
        try
        {
          ((JSONObject)localObject).put("strMini", str1);
          if (localObject != null) {
            break label275;
          }
          localObject = "";
          aqly.a(56, this.qL, (String)localObject, 0);
          anot.a(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
          this.this$0.d.updateUI();
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label268;
        }
        localJSONException1 = localJSONException1;
        localObject = null;
        localJSONException1.printStackTrace();
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.9
 * JD-Core Version:    0.7.0.1
 */