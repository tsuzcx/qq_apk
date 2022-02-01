package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import psv;
import psx;
import qjc;
import ram;
import roq;

public class PromoteWidgetController$1
  implements Runnable
{
  public PromoteWidgetController$1(qjc paramqjc, ArrayList paramArrayList, String paramString, int paramInt) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    ram.a("PromoteWidgetController", "checkValidateAsync(%s, %s, %d)", this.na, this.atK, Integer.valueOf(this.val$size));
    if (this.this$0.bmy == 0)
    {
      ram.e("PromoteWidgetController", "checkValidateAsync() should not check validate of the promotetask, promotetype = 0");
      this.this$0.AL = -1L;
      return;
    }
    Object localObject = (psv)psx.a(29);
    ArrayList localArrayList = new ArrayList();
    if (!this.na.isEmpty()) {
      localArrayList.addAll(((psv)localObject).e(this.na, this.this$0.bmy));
    }
    if (!TextUtils.isEmpty(this.atK)) {
      localArrayList.addAll(((psv)localObject).e(this.atK, this.this$0.bmy));
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject = (PromoteTaskEntry)localArrayList.get(i);
      if ((this.val$size < ((PromoteTaskEntry)localObject).minimalVideoCount) || (l > ((PromoteTaskEntry)localObject).expireTime)) {}
    }
    for (;;)
    {
      if (localObject == null)
      {
        ram.w("PromoteWidgetController", "checkValidateAsync() didn't find promote task for feedId: %s, unionId: %s, size: %d, now=%s(%d)", new Object[] { this.na, this.atK, Integer.valueOf(this.val$size), roq.aH(l), Long.valueOf(l) });
        this.this$0.AL = -1L;
        return;
        i += 1;
        break;
      }
      ram.w("PromoteWidgetController", "checkValidateAsync() find the promote task %s", new Object[] { localObject });
      this.this$0.AL = ((PromoteTaskEntry)localObject).taskId;
      this.this$0.axv = this.atK;
      ThreadManager.getUIHandlerV2().post(new PromoteWidgetController.1.1(this));
      return;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.1
 * JD-Core Version:    0.7.0.1
 */