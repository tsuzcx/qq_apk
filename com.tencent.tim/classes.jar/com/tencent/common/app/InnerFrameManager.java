package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InnerFrameManager
  extends ViewFlipper
  implements ViewStub.OnInflateListener
{
  public Activity B;
  private Set<InnerFrame> aT = new HashSet();
  private boolean ajo;
  private QQAppInterface e;
  private Bundle mBundle;
  
  public InnerFrameManager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerFrameManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new InnerFrame(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext, 0);
  }
  
  public void au(int paramInt, boolean paramBoolean)
  {
    paramInt += 1;
    if (getDisplayedChild() == paramInt) {
      return;
    }
    if (this.ajo) {
      ((InnerFrame)getChildAt(getDisplayedChild())).onPause();
    }
    ((InnerFrame)getChildAt(getDisplayedChild())).onStop();
    getChildAt(paramInt).setVisibility(0);
    if (paramBoolean) {
      if (getDisplayedChild() != 0)
      {
        if (getDisplayedChild() >= paramInt) {
          break label135;
        }
        setInAnimation(this.B, 2130772092);
        setOutAnimation(this.B, 2130772093);
      }
    }
    for (;;)
    {
      setDisplayedChild(paramInt);
      ((InnerFrame)getChildAt(paramInt)).be(this.mBundle);
      if (!this.ajo) {
        break;
      }
      ((InnerFrame)getChildAt(paramInt)).onResume();
      return;
      label135:
      setInAnimation(this.B, 2130772088);
      setOutAnimation(this.B, 2130772089);
      continue;
      setInAnimation(this.B, 2130772162);
      setOutAnimation(this.B, 2130772162);
    }
  }
  
  public void j(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.aT.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void k(int paramInt, Bundle paramBundle)
  {
    this.mBundle = paramBundle;
    au(paramInt, true);
  }
  
  public void onCreate(Activity paramActivity)
  {
    this.B = paramActivity;
    int j = getChildCount();
    int i = 1;
    while (i < j)
    {
      ((ViewStub)getChildAt(i)).setOnInflateListener(this);
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.aT.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).onDestroy();
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    paramViewStub = (InnerFrame)paramView;
    this.aT.add(paramViewStub);
    paramViewStub.setActivity(this.B);
    paramViewStub.setInnerFrameManager(this);
    paramViewStub.setAppIntf(this.e);
    paramViewStub.onCreate(this.mBundle);
  }
  
  public void onPause()
  {
    this.ajo = false;
    ((InnerFrame)getChildAt(getDisplayedChild())).onPause();
  }
  
  public void onResume()
  {
    this.ajo = true;
    ((InnerFrame)getChildAt(getDisplayedChild())).onResume();
  }
  
  public void onStop()
  {
    Iterator localIterator = this.aT.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).onStop();
    }
  }
  
  public void setAppIntf(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    Iterator localIterator = this.aT.iterator();
    while (localIterator.hasNext()) {
      ((InnerFrame)localIterator.next()).setAppIntf(paramQQAppInterface);
    }
  }
  
  public int uy()
  {
    return getDisplayedChild() - 1;
  }
  
  public void yW(int paramInt)
  {
    this.mBundle = null;
    au(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.InnerFrameManager
 * JD-Core Version:    0.7.0.1
 */