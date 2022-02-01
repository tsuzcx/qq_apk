package com.tencent.qqmail.utilities.ui;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class InsertionListView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  InsertionListView$1(InsertionListView paramInsertionListView, int paramInt1, InsertionListView.AnimationListAdapter paramAnimationListAdapter, ViewTreeObserver paramViewTreeObserver, int paramInt2, HashMap paramHashMap1, HashMap paramHashMap2) {}
  
  public boolean onPreDraw()
  {
    int m = this.this$0.getFirstVisiblePosition();
    if (m < this.val$headerViews) {
      i = this.val$headerViews;
    }
    long l;
    while (i < this.this$0.getChildCount())
    {
      j = m + i - this.val$headerViews;
      if ((this.val$adapter == null) || (this.val$adapter.getItem(j) == null)) {}
      do
      {
        return true;
        i = 0;
        break;
        localObject1 = this.val$adapter.getItem(j);
        l = this.val$adapter.getItemId(localObject1);
      } while ((j == 0) && (InsertionListView.access$000(this.this$0) == l));
      i += 1;
    }
    this.val$observer.removeOnPreDrawListener(this);
    if (InsertionListView.access$100(this.this$0))
    {
      InsertionListView.access$200(this.this$0);
      InsertionListView.access$102(this.this$0, false);
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    int k;
    label199:
    int n;
    if (i < this.val$count)
    {
      if (m < this.val$headerViews)
      {
        k = this.val$headerViews;
        localObject1 = this.this$0.getChildAt(k + i);
        if (localObject1 == null) {
          break label258;
        }
        ((ArrayList)localObject2).add(localObject1);
      }
      for (;;)
      {
        k = ((View)localObject1).getMeasuredHeight();
        n = this.this$0.getDividerHeight();
        i += 1;
        j = k + n + j;
        break;
        k = 0;
        break label199;
        label258:
        localObject1 = this.this$0.getAdapter().getView(m + i, null, this.this$0);
        k = View.MeasureSpec.makeMeasureSpec(0, 0);
        ((View)localObject1).measure(k, k);
        ((ArrayList)localObject2).add(localObject1);
      }
    }
    if (m < this.val$headerViews)
    {
      i = this.val$headerViews;
      if (i >= this.this$0.getChildCount()) {
        break label507;
      }
      localObject1 = this.this$0.getChildAt(i);
      k = this.val$headerViews;
      l = this.val$adapter.getItemId(this.val$adapter.getItem(m + i - k));
      localObject2 = (Rect)this.val$listViewItemBounds.get(Long.valueOf(l));
      k = ((View)localObject1).getTop();
      if (localObject2 == null) {
        break label474;
      }
      n = ((Rect)localObject2).top;
      localArrayList.add(ObjectAnimator.ofFloat(localObject1, InsertionListView.TRANSLATION_Y, new float[] { n - k, 0.0F }));
    }
    for (;;)
    {
      this.val$listViewItemBounds.remove(Long.valueOf(l));
      this.val$listViewItemDrawables.remove(Long.valueOf(l));
      i += 1;
      break;
      i = 0;
      break;
      label474:
      localArrayList.add(ObjectAnimator.ofFloat(localObject1, InsertionListView.TRANSLATION_Y, new float[] { k - j - k, 0.0F }));
    }
    label507:
    Object localObject1 = new ArrayList();
    localObject2 = this.val$listViewItemBounds.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject2).next();
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.val$listViewItemDrawables.get(localLong);
      Object localObject3 = (Rect)this.val$listViewItemBounds.get(localLong);
      localBitmapDrawable.setBounds((Rect)localObject3);
      Rect localRect = new Rect((Rect)localObject3);
      localRect.offset(0, j);
      localObject3 = ObjectAnimator.ofObject(localBitmapDrawable, "bounds", InsertionListView.sBoundsEvaluator, new Object[] { localObject3, localRect });
      ((ObjectAnimator)localObject3).addUpdateListener(new InsertionListView.1.1(this));
      ((ArrayList)localObject1).add(localLong);
      InsertionListView.access$300(this.this$0).add(localBitmapDrawable);
      localArrayList.add(localObject3);
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      l = ((Long)((Iterator)localObject1).next()).longValue();
      this.val$listViewItemBounds.remove(Long.valueOf(l));
      this.val$listViewItemDrawables.remove(Long.valueOf(l));
    }
    this.this$0.setEnabled(false);
    InsertionListView.access$402(this.this$0, true);
    this.val$adapter.onRowAdditionAnimationStart();
    if (InsertionListView.access$500(this.this$0) != null) {
      InsertionListView.access$500(this.this$0).onRowAdditionAnimationStart();
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).setDuration(600L);
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).addListener(new InsertionListView.1.2(this));
    ((AnimatorSet)localObject1).start();
    this.val$listViewItemBounds.clear();
    this.val$listViewItemDrawables.clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.InsertionListView.1
 * JD-Core Version:    0.7.0.1
 */