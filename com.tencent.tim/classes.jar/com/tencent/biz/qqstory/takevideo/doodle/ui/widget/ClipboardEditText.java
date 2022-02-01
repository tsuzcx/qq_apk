package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class ClipboardEditText
  extends EditText
{
  private a a;
  
  public ClipboardEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onTextContextMenuItem(paramInt);
      if (this.a != null)
      {
        this.a.aXm();
        continue;
        if (this.a != null)
        {
          this.a.aXl();
          continue;
          if (this.a != null) {
            this.a.onCopy();
          }
        }
      }
    }
  }
  
  public void setClipboardCallBack(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aXl();
    
    public abstract void aXm();
    
    public abstract void onCopy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText
 * JD-Core Version:    0.7.0.1
 */