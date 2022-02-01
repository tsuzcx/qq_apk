package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.TextView;
import aute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vfu;
import zjo;

class Leba$37
  implements Runnable
{
  Leba$37(Leba paramLeba, int paramInt1, boolean paramBoolean, int paramInt2, List paramList) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject;
    TextView localTextView;
    boolean bool1;
    if (this.val$num > 0)
    {
      if (Leba.d(this.this$0) != null) {
        Leba.d(this.this$0).setVisibility(0);
      }
      aute.updateCustomNoteTxt(Leba.d(this.this$0), 9, this.val$num, 0);
      localObject = this.this$0.a();
      localTextView = Leba.c(this.this$0);
      if (Leba.a(this.this$0).yk() == 1)
      {
        bool1 = true;
        aute.a((Context)localObject, localTextView, 9, bool1);
      }
    }
    for (;;)
    {
      try
      {
        if ((this.aXS) && (this.bHX > 0))
        {
          if (Leba.e(this.this$0) != null)
          {
            Leba.e(this.this$0).setVisibility(0);
            aute.updateCustomNoteTxt(Leba.e(this.this$0), 8, this.val$num, 0);
            localObject = this.this$0.a();
            localTextView = Leba.e(this.this$0);
            bool1 = bool2;
            if (Leba.a(this.this$0).yk() == 1) {
              bool1 = true;
            }
            aute.a((Context)localObject, localTextView, 8, bool1);
          }
          localObject = new ArrayList();
          if (this.fO != null) {
            ((ArrayList)localObject).addAll(this.fO);
          }
          if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0) != null)) {
            Leba.b(this.this$0).cR((ArrayList)localObject);
          }
          Leba.e(this.this$0);
          return;
          bool1 = false;
          break;
          if (Leba.d(this.this$0) == null) {
            continue;
          }
          Leba.d(this.this$0).setVisibility(8);
          continue;
        }
        if ((this.aXS) && (this.bHX == 0) && (this.val$num == 0))
        {
          if (Leba.e(this.this$0) == null) {
            continue;
          }
          Leba.e(this.this$0).setVisibility(0);
          aute.updateCustomNoteTxt(Leba.e(this.this$0), 8, this.val$num, 0);
          localObject = this.this$0.a();
          localTextView = Leba.e(this.this$0);
          bool1 = bool3;
          if (Leba.a(this.this$0).yk() == 1) {
            bool1 = true;
          }
          aute.a((Context)localObject, localTextView, 10, bool1);
          continue;
        }
        if (Leba.e(this.this$0) == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("Leba", 1, "updateQQCircleRedFlag" + localException);
        return;
      }
      Leba.e(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.37
 * JD-Core Version:    0.7.0.1
 */