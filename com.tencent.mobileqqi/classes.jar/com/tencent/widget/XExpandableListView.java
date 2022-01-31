package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;

public class XExpandableListView
  extends ExpandableListView
{
  public XExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aj = 0;
    this.ak = 0;
    setEdgeEffectEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.XExpandableListView
 * JD-Core Version:    0.7.0.1
 */