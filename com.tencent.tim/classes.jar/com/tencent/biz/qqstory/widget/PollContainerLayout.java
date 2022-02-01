package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import ram;
import rpg;
import rpg.a;
import rpg.f;
import rpg.g;

public class PollContainerLayout
  extends FrameLayout
{
  boolean aJH = false;
  private final rpg.a b = rpg.a(getContext(), 1, 1, null);
  public StoryVideoItem.b c;
  public StoryVideoItem o;
  
  public PollContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PollContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.tW(false);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.b.getView(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void ey(int paramInt1, int paramInt2)
  {
    if (this.c == null) {
      return;
    }
    this.b.a(this.c, paramInt1, paramInt2);
    this.b.bvM();
  }
  
  public void a(StoryVideoItem.b paramb, int paramInt, int[] paramArrayOfInt)
  {
    this.c = paramb;
    if (paramb == null)
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    paramb = paramb.bR;
    this.b.a().setText(paramb[0]);
    int i = 1;
    while (i < paramb.length)
    {
      this.b.a(i - 1).setText(paramb[i]);
      this.b.a(i - 1).setSelect(false);
      i += 1;
    }
    if ((this.aJH) && (paramInt >= 0))
    {
      this.b.a(paramInt).setSelect(true);
      if (paramArrayOfInt != null)
      {
        this.b.j(paramArrayOfInt);
        this.b.tW(true);
      }
    }
    for (;;)
    {
      ey(getWidth(), getHeight());
      return;
      this.b.tW(false);
      continue;
      this.b.tW(false);
    }
  }
  
  public boolean ac(boolean paramBoolean)
  {
    boolean bool = this.aJH;
    this.aJH = paramBoolean;
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ey(paramInt3 - paramInt1, paramInt4 - paramInt2);
    ram.b("PollContainerLayout", "onLayout wh(%d, %d)", Integer.valueOf(paramInt3 - paramInt1), Integer.valueOf(paramInt4 - paramInt2));
  }
  
  public void u(StoryVideoItem paramStoryVideoItem)
  {
    this.o = paramStoryVideoItem;
    if (paramStoryVideoItem != null)
    {
      a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mPollResult, paramStoryVideoItem.mPollNumbers);
      return;
    }
    a(null, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.PollContainerLayout
 * JD-Core Version:    0.7.0.1
 */