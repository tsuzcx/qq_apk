package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.tencent.token.gr;
import com.tencent.token.ii;
import com.tencent.token.im;
import com.tencent.token.jc;
import com.tencent.token.jf;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] a = { 16843016 };
  private final im b = im.a(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(jc.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.b.a();
    paramContext = jf.a(getContext(), paramAttributeSet, a, paramInt, 0);
    setCheckMarkDrawable(paramContext.a(0));
    paramContext.a.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    im localim = this.b;
    if (localim != null) {
      localim.a();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ii.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(gr.b(getContext(), paramInt));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    im localim = this.b;
    if (localim != null) {
      localim.a(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */