package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import acqs;
import android.text.TextUtils;
import android.util.Pair;
import aqgv;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DiscMessageProcessor$1
  implements Runnable
{
  public DiscMessageProcessor$1(acqs paramacqs, ArrayList paramArrayList, long paramLong1, long paramLong2, String paramString, MsgInfo paramMsgInfo, long paramLong3) {}
  
  public void run()
  {
    if (this.ef.contains(Long.valueOf(this.Rh)))
    {
      this.ef.remove(Long.valueOf(this.Rh));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "陌生人uin包括自己,移出");
      }
    }
    if (this.ef.size() != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.ef.size() * 8);
      int i = 0;
      if (i < this.ef.size())
      {
        String str2 = (String)((Pair)this.ef.get(i)).second;
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 9 server showName empty");
          }
          str1 = aqgv.m(acqs.a(this.this$0), String.valueOf(this.Ri), String.valueOf(this.ef.get(i)));
        }
        if (i == 0) {
          localStringBuilder.append(str1);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("、" + str1);
        }
      }
      localStringBuilder.append(this.bqz);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "show yinsi tips" + localStringBuilder.toString());
      }
      acqs.a(this.this$0, this.a, this.Rh, this.Ri, this.Rj, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */