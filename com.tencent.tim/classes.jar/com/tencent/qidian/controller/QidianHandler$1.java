package com.tencent.qidian.controller;

import ahwa;
import android.os.Bundle;
import android.text.TextUtils;
import ashy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class QidianHandler$1
  implements Runnable
{
  public QidianHandler$1(ashy paramashy, ToServiceMsg paramToServiceMsg, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.g.extraData.getString("extUin");
      long l = this.g.extraData.getLong("uinseq");
      int i = this.g.extraData.getInt("uinType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.this$0.app.b().b((String)localObject, i, l);
        if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.xg != null))
          {
            ((MessageForUniteGrayTip)localObject).tipParam.xg.clear();
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(this.this$0.app);
            this.this$0.notifyUI(1005, true, this.aK);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(ashy.access$000(), 2, "handleBlockBulkMsg ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianHandler.1
 * JD-Core Version:    0.7.0.1
 */