package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lbg;
import lbi;
import org.json.JSONObject;

public class DynamicChannelDataModule$6$1
  implements Runnable
{
  public DynamicChannelDataModule$6$1(lbi paramlbi, Bundle paramBundle, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject;
    if (this.B.getInt("isPullDownRefresh", 0) == 1)
    {
      localObject = new ArrayList();
      if (this.val$result == null) {
        break label97;
      }
      localObject = lbg.a(this.a.this$0, this.a.aHH, this.val$result, this.B);
    }
    for (;;)
    {
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        lbg.a(this.a.this$0, bool, this.a.aHH, false, false, null);
      }
      return;
      bool = false;
      break;
      label97:
      QLog.d("DynamicChannelDataModule", 2, "onResult, result is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.6.1
 * JD-Core Version:    0.7.0.1
 */