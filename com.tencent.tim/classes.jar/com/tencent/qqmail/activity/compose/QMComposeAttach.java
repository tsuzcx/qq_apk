package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;

public class QMComposeAttach
  extends GridView
{
  private QMComposeAttachCallback composeAttachCallback;
  
  public QMComposeAttach(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMComposeAttach(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMComposeAttach(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QMComposeAttachCallback getComposeAttachCallback()
  {
    return this.composeAttachCallback;
  }
  
  public void init()
  {
    setOnItemClickListener(new QMComposeAttach.1(this));
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }
  
  public void setComposeAttachCallback(QMComposeAttachCallback paramQMComposeAttachCallback)
  {
    this.composeAttachCallback = paramQMComposeAttachCallback;
  }
  
  public static abstract interface QMComposeAttachCallback
  {
    public abstract void onClickItem(QMComposeAttachItem paramQMComposeAttachItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeAttach
 * JD-Core Version:    0.7.0.1
 */