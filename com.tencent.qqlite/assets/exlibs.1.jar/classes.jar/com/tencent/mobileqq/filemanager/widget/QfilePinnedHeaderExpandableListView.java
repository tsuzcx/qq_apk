package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.PinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
{
  private final String a = "QfilePinnedHeaderExpandableListView<FileAssistant>";
  
  public QfilePinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setSelector(2131427345);
    setGroupIndicator(paramContext.getResources().getDrawable(2130837934));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */