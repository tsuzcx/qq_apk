package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import wni;
import wni.a;

public class PathAnimation
  extends AIOAnimationConatiner.a
{
  private Animator a;
  ArrayList<wni.a> ql;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @TargetApi(11)
  void a(View paramView, wni.a parama)
  {
    if (!parama.running) {}
    do
    {
      return;
      int i = paramView.getLeft();
      int j = paramView.getWidth() / 2;
      int k = paramView.getTop();
      int m = paramView.getHeight() / 2;
      paramView.offsetTopAndBottom(parama.y - (k + m));
      paramView.offsetLeftAndRight(parama.x - (i + j));
    } while (!VersionUtils.isHoneycomb());
    paramView.setAlpha(parama.alpha);
    paramView.setRotation(parama.rotate);
    paramView.setScaleX(parama.scaleX);
    paramView.setScaleY(parama.scaleY);
    paramView.setRotationX(parama.rotateX);
    paramView.setRotationY(parama.rotateY);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  @TargetApi(11)
  protected boolean c(Object... paramVarArgs)
  {
    try
    {
      Drawable[] arrayOfDrawable;
      long l1;
      wni localwni;
      int i;
      label82:
      View localView;
      int j;
      label159:
      wni.a locala;
      if ((paramVarArgs[0] instanceof Drawable[]))
      {
        arrayOfDrawable = (Drawable[])paramVarArgs[0];
        int k = ((Integer)paramVarArgs[1]).intValue();
        l1 = ((Long)paramVarArgs[2]).longValue();
        localwni = (wni)AIOAnimationConatiner.classLoader.loadClass((String)paramVarArgs[3]).newInstance();
        this.ql = new ArrayList(k);
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        i = 0;
        if (i >= k) {
          break label305;
        }
        localView = new View(this.l.getContext());
        Drawable localDrawable = arrayOfDrawable[((int)(Math.random() * arrayOfDrawable.length))];
        localView.setBackgroundDrawable(localDrawable);
        localView.layout(-localDrawable.getIntrinsicWidth(), -localDrawable.getIntrinsicHeight(), 0, 0);
        this.c.addView(localView);
        if (i != 0) {
          break label272;
        }
        j = 0;
        locala = new wni.a();
        locala.startTime = (j + l2);
        locala.view = localView;
        if (i != 0) {
          break label284;
        }
        paramVarArgs = localwni;
        label192:
        locala.a = paramVarArgs;
        if (!VersionUtils.isHoneycomb()) {
          break label295;
        }
        localView.setLayerType(2, null);
        localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
        localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
      }
      for (;;)
      {
        this.ql.add(locala);
        i += 1;
        break label82;
        arrayOfDrawable = new Drawable[] { (Drawable)paramVarArgs[0] };
        break;
        label272:
        j = (int)(Math.random() * l1);
        break label159;
        label284:
        paramVarArgs = localwni.a();
        break label192;
        label295:
        localView.setTag(locala);
      }
      label305:
      if (this.a == null)
      {
        this.a = new Animator(null);
        this.l.postDelayed(this.a, 16L);
      }
      return true;
    }
    catch (Exception paramVarArgs) {}
    return false;
  }
  
  protected void stop()
  {
    if (this.a != null)
    {
      this.l.removeCallbacks(this.a);
      this.a = null;
    }
  }
  
  class Animator
    implements Runnable
  {
    private Animator() {}
    
    public void run()
    {
      long l3 = AnimationUtils.currentAnimationTimeMillis();
      Iterator localIterator = PathAnimation.this.ql.iterator();
      long l2 = -1L;
      if (localIterator.hasNext())
      {
        wni.a locala = (wni.a)localIterator.next();
        long l1;
        if (l3 < locala.startTime)
        {
          l1 = locala.startTime - l3;
          label63:
          if (l1 < 0L) {
            break label195;
          }
          if (l2 >= 0L) {
            break label186;
          }
          label75:
          PathAnimation.this.a(locala.view, locala);
        }
        for (;;)
        {
          l2 = l1;
          break;
          if (!locala.running)
          {
            l1 = locala.a.a(locala, locala.view.getWidth(), locala.view.getHeight(), PathAnimation.this.c.getWidth(), PathAnimation.this.c.getHeight());
            locala.running = true;
            break label63;
          }
          l1 = locala.a.a(l3 - locala.startTime, locala);
          break label63;
          label186:
          l1 = Math.min(l2, l1);
          break label75;
          label195:
          PathAnimation.this.c.removeViewInLayout(locala.view);
          localIterator.remove();
          l1 = l2;
        }
      }
      if (l2 >= 0L)
      {
        PathAnimation.this.l.postDelayed(this, l2);
        PathAnimation.this.c.invalidate();
        return;
      }
      PathAnimation.this.bZL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation
 * JD-Core Version:    0.7.0.1
 */