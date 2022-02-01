package com.tencent.mobileqq.qcall;

import ajdo;
import alkm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import java.util.ArrayList;
import java.util.List;
import top;

class QCallDetailActivity$3
  implements Runnable
{
  QCallDetailActivity$3(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    Object localObject1;
    int j;
    int i;
    label62:
    label91:
    do
    {
      return;
      if (QCallDetailActivity.a(this.this$0, QCallDetailActivity.a(this.this$0)))
      {
        localObject1 = top.eW;
        j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label405;
        }
        int k = localObject1[i];
        if (QCallDetailActivity.a(this.this$0) != k) {
          break;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = (ajdo)this.this$0.app.getManager(11);
          if (localObject1 != null) {
            break label314;
          }
          localObject1 = null;
          if (localObject1 != null) {
            QCallDetailActivity.a(this.this$0).g(((PhoneContact)localObject1).mobileCode, 1006, QCallDetailActivity.a(this.this$0), QCallDetailActivity.a(this.this$0));
          }
        }
      }
    } while (QCallDetailActivity.a(this.this$0) == null);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (QCallDetailActivity.a(this.this$0))
      {
        if ((QCallDetailActivity.b(this.this$0) == 2) || (QCallDetailActivity.b(this.this$0) == 3) || (QCallDetailActivity.a(this.this$0) == 25))
        {
          localObject1 = QCallDetailActivity.a(this.this$0).t(QCallDetailActivity.a(this.this$0), 8);
          if ((QCallDetailActivity.a(this.this$0) == null) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
            continue;
          }
          i = 20;
          j = 0;
          if ((j >= i) || (j >= ((List)localObject1).size())) {
            break label410;
          }
          if (((QCallRecord)((List)localObject1).get(j)).type != QCallRecord.TYPE_DATE) {
            break label402;
          }
          i += 1;
          localArrayList.add(((List)localObject1).get(j));
          j += 1;
          continue;
          i += 1;
          break;
          label314:
          localObject1 = ((ajdo)localObject1).c(QCallDetailActivity.a(this.this$0));
          break label91;
        }
        localObject1 = QCallDetailActivity.a(this.this$0).t(QCallDetailActivity.a(this.this$0), QCallDetailActivity.a(this.this$0));
        continue;
        this.this$0.app.runOnUiThread(new QCallDetailActivity.3.1(this, localArrayList, bool));
        return;
        bool = true;
      }
      label402:
      continue;
      label405:
      i = 0;
      break label62;
      label410:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */