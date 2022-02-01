package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class ReadinjoyClipboardEditText
  extends EditText
{
  private a a;
  
  public ReadinjoyClipboardEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyClipboardEditText
 * JD-Core Version:    0.7.0.1
 */