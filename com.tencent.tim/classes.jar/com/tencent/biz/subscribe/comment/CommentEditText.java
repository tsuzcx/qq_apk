package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.theme.ISkinIgnoreTypeface;
import com.tencent.theme.TextHook;
import scs;

public class CommentEditText
  extends EditText
  implements ISkinIgnoreTypeface
{
  private a a;
  private int mMaxLength = 140;
  
  public CommentEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    addTextChangedListener(new scs(this));
  }
  
  public CommentEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void bxX()
  {
    setTypeface(TextHook.getInstance().getSystemDefaultFont());
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (getContext() != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null) {
        return super.dispatchKeyEventPreIme(paramKeyEvent);
      }
      if ((localInputMethodManager.isActive()) && (paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1)) {
        getHandler().postDelayed(new CommentEditText.2(this), 50L);
      }
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public void setOnInputBackListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dv(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentEditText
 * JD-Core Version:    0.7.0.1
 */