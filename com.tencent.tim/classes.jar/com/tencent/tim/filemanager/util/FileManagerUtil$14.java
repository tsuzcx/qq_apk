package com.tencent.tim.filemanager.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import attf;
import audw;
import audx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public final class FileManagerUtil$14
  implements Runnable
{
  public void run()
  {
    if (TextUtils.isEmpty(this.Mu)) {}
    String str1;
    long l1;
    long l2;
    int i;
    String str2;
    int j;
    label262:
    MessageRecord localMessageRecord;
    do
    {
      List localList;
      for (;;)
      {
        return;
        try
        {
          Thread.sleep(500L);
          Object localObject = this.val$app.getCurrentAccountUin() + "BatProcessTips";
          localObject = this.val$app.getApplication().getSharedPreferences((String)localObject, 0);
          str1 = this.Mu + "_" + this.cZa + "_LastShowTime";
          l1 = ((SharedPreferences)localObject).getLong(str1, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 < 86400000L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],today has notify user!return!");
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          localList = this.val$app.b().k(this.Mu, this.cZa);
          if ((localList == null) || (localList.size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],msgRecd null,return");
            }
          }
          else
          {
            i = 1;
            str2 = this.val$app.getCurrentAccountUin();
            j = localList.size() - 1;
          }
        }
      }
      if (j < 0) {
        break;
      }
      localMessageRecord = (MessageRecord)localList.get(j);
    } while ((localMessageRecord.msgtype != -2005) || (localMessageRecord.isSend()) || (localMessageRecord.senderuin.equalsIgnoreCase(str2) == true));
    if (QLog.isDevelopLevel()) {
      QLog.d("FileManagerUtil<FileAssistant>", 4, "updateBatProcessTips count[" + i + "]");
    }
    if (i >= 4)
    {
      this.val$app.a().a(this.Mu, this.aem, this.cZa, -3013, BaseApplicationImpl.getContext().getString(2131693813));
      localInterruptedException.edit().putLong(str1, l2);
      if (QLog.isColorLevel()) {
        QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],[" + audx.kZ(this.Mu) + "]add new grayTips!");
      }
      audw.JH("0X800506B");
      return;
    }
    long l3 = localMessageRecord.time * 1000L;
    if (QLog.isColorLevel()) {
      QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],time[" + l3 + "]");
    }
    if (l3 > l1) {
      i += 1;
    }
    for (;;)
    {
      j -= 1;
      break label262;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileManagerUtil.14
 * JD-Core Version:    0.7.0.1
 */