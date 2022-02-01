package com.tencent.tim.todo;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aunz;
import auod;
import aupe;
import aupf.a;
import auvd.a;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;

public class TodoListViewLogic$4
  implements Runnable
{
  public TodoListViewLogic$4(aunz paramaunz) {}
  
  public void run()
  {
    Object localObject1 = aupe.a(aunz.a(this.this$0), aunz.a(this.this$0) + aunz.a(this.this$0).getHeaderViewsCount());
    if ((localObject1 != null) && (((View)localObject1).getTag() != null) && ((((View)localObject1).getTag() instanceof auvd.a)))
    {
      localObject2 = (auvd.a)((View)localObject1).getTag();
      if ((((auvd.a)localObject2).Lz != null) && (((auvd.a)localObject2).Lz.getTag() != null) && ((((auvd.a)localObject2).Lz.getTag() instanceof aupf.a)))
      {
        locala = (aupf.a)((auvd.a)localObject2).Lz.getTag();
        localObject1 = new ImageView(aunz.a(this.this$0));
        aunz.a(this.this$0, (ImageView)localObject1);
        ((ImageView)localObject1).setBackgroundColor(aunz.a(this.this$0).getResources().getColor(2131167582));
        ((ImageView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, ((auvd.a)localObject2).Lz.getMeasuredHeight()));
        ((ImageView)localObject1).setVisibility(0);
      }
    }
    while (localObject1 != null)
    {
      Object localObject2;
      do
      {
        try
        {
          aupf.a locala;
          locala.aN.addView((View)localObject1, 0);
          localObject2 = (ViewGroup)((auvd.a)localObject2).Lz;
          ((ImageView)localObject1).setAlpha(0.0F);
          aunz.a(this.this$0, ((ImageView)localObject1).animate());
          ((ImageView)localObject1).animate().alpha(1.0F).setInterpolator(new CycleInterpolator(3.0F)).setDuration(3000L).setListener(new auod(this, (ViewGroup)localObject2, (ImageView)localObject1)).start();
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("TodoListViewLogic", 4, localException.toString());
          }
        }
      } while (((auvd.a)localObject2).Lz != null);
      QLog.d("TodoListViewLogic", 2, "leftView is null position " + aunz.a(this.this$0) + " " + aunz.a(this.this$0).getChildCount() + " " + aunz.a(this.this$0).getFirstVisiblePosition() + " " + aunz.a(this.this$0).getLastVisiblePosition());
      return;
    }
    QLog.d("TodoListViewLogic", 2, " position " + aunz.a(this.this$0) + " " + aunz.a(this.this$0).getChildCount() + " " + aunz.a(this.this$0).getFirstVisiblePosition() + " " + aunz.a(this.this$0).getLastVisiblePosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.TodoListViewLogic.4
 * JD-Core Version:    0.7.0.1
 */