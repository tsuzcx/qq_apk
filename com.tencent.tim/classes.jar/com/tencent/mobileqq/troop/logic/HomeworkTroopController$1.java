package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import apml;
import apmm;
import auvw;
import auvw.a;
import auvw.b;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class HomeworkTroopController$1
  implements Runnable
{
  public HomeworkTroopController$1(apml paramapml, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (BaseActivity)apml.a(this.this$0).get();
    if (localObject2 == null) {
      return;
    }
    label31:
    Object localObject1;
    if (this.val$type == 1)
    {
      i = 1;
      localObject1 = this.this$0.a;
      if (i == 0) {
        break label79;
      }
    }
    label79:
    for (int j = 32;; j = 31)
    {
      localObject1 = ((PanelIconLinearLayout)localObject1).findViewWithTag(Integer.valueOf(j));
      if (localObject1 != null) {
        break label85;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HomeworkTroopController", 2, "showAIOPanelTip anchorView null.");
      return;
      i = 0;
      break label31;
    }
    label85:
    this.this$0.dZr();
    auvw.a locala = auvw.a((Context)localObject2).b(0).a(true);
    if (i != 0) {}
    for (int i = 2131699718;; i = 2131699719)
    {
      localObject2 = locala.a(((BaseActivity)localObject2).getString(i)).a(16.0F).a(-1);
      ((auvw.a)localObject2).c(49);
      localObject2 = new auvw.b((auvw.a)localObject2).b(Color.argb(255, 0, 0, 0)).a(5).a();
      if (localObject2 != null) {
        this.this$0.f = ((auvw.a)localObject2).a();
      }
      if (this.this$0.f == null) {
        break;
      }
      this.this$0.dUY = this.val$type;
      this.this$0.f.setAlignMode(82);
      this.this$0.f.setOnClickListener(new apmm(this));
      this.this$0.f.jb((View)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.1
 * JD-Core Version:    0.7.0.1
 */