package com.tencent.mobileqq.confess;

import aegs;
import aegs.b;
import anaz;
import android.text.TextUtils;
import aqgv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ConfessManager$4
  implements Runnable
{
  public ConfessManager$4(aegs paramaegs, String paramString, aegs.b paramb) {}
  
  public void run()
  {
    aegs.b localb = this.this$0.a;
    if ((localb == null) || (this.this$0.mApp == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localb.strRecNick)) {
        localb.strRecNick = aqgv.h(this.this$0.mApp, this.val$groupUin, this.c.strRecUin);
      }
      if (localb.flag == 0) {
        localb.flag = this.this$0.a(this.val$groupUin, localb.strRecUin, localb.bxe, localb.strConfessorUin, localb.nTopicId);
      }
    } while (localb.flag != 1);
    long l2 = anaz.gQ();
    List localList = this.this$0.mApp.b().f(this.val$groupUin, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localb.bTL) }));
      }
      this.this$0.a(this.val$groupUin, localb, l2, l2, l1);
      return;
      l1 = Math.abs(new Random().nextInt());
      localb.bTL = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */