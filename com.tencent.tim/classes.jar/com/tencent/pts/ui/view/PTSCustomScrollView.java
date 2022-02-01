package com.tencent.pts.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PTSCustomScrollView
  extends ScrollView
{
  public PTSCustomScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PTSCustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PTSCustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSCustomScrollView
 * JD-Core Version:    0.7.0.1
 */