package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kbp;
import org.json.JSONObject;

public final class ReadInJoyUtils$16
  implements Runnable
{
  public ReadInJoyUtils$16(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (this.val$app != null)
      {
        Object localObject = (KandianMergeManager)this.val$app.getManager(162);
        if (localObject != null)
        {
          localObject = ((KandianMergeManager)localObject).a();
          if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isExpose))
          {
            ((KandianMsgBoxRedPntInfo)localObject).isExpose = true;
            ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("tab_status", 3);
            localJSONObject.put("reddot_num", ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt);
            kbp.a(null, "CliOper", "", "", "0X80091DC", "0X80091DC", 0, 0, "0", "", "", localJSONObject.toString(), false);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReadInJoyUtils", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.16
 * JD-Core Version:    0.7.0.1
 */