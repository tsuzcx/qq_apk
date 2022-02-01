package com.tencent.mobileqq.richstatus;

import amfn;
import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;
import arev;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class RichStatusEditText
  extends EditText
{
  private static float aD = 1.0F;
  private arev a;
  private b b;
  public boolean fn = true;
  private Context mContext;
  int qB = -1;
  int qC = -1;
  private TextWatcher textWatcher = new amfn(this);
  
  public RichStatusEditText(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void L(int paramInt1, int paramInt2)
  {
    arev[] arrayOfarev = (arev[])a().getSpans(paramInt1, paramInt1 + paramInt2, arev.class);
    paramInt1 = 0;
    while (paramInt1 < arrayOfarev.length)
    {
      arev localarev = arrayOfarev[paramInt1];
      if (this.b != null) {
        this.b.a(localarev);
      }
      if (localarev == this.a) {
        this.a = null;
      }
      a().removeSpan(localarev);
      paramInt1 += 1;
    }
  }
  
  private int a(int paramInt, float paramFloat)
  {
    paramFloat = c(paramFloat);
    return getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  private int a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = b(paramInt, paramFloat1, paramFloat2);
    paramInt = i;
    if (i == 0)
    {
      arev localarev = a(i, true, false);
      paramInt = i;
      if (localarev != null)
      {
        paramInt = i;
        if (this.b != null)
        {
          paramInt = i;
          if (!this.b.a(localarev)) {
            paramInt = i + 1;
          }
        }
      }
    }
    return paramInt;
  }
  
  private Spannable a()
  {
    return getText();
  }
  
  private arev a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    arev[] arrayOfarev = (arev[])a().getSpans(0, getText().length(), arev.class);
    while (i < arrayOfarev.length)
    {
      arev localarev = arrayOfarev[i];
      int j = a().getSpanStart(localarev);
      int k = a().getSpanEnd(localarev);
      if ((paramInt > j) && (paramInt < k)) {
        return localarev;
      }
      if ((paramBoolean1) && (paramInt == j)) {
        return localarev;
      }
      if ((paramBoolean2) && (paramInt == k)) {
        return localarev;
      }
      i += 1;
    }
    return null;
  }
  
  private arev a(arev paramarev)
  {
    if (paramarev != null) {
      paramarev.iz(this);
    }
    return paramarev;
  }
  
  private int b(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  private int b(int paramInt, float paramFloat1, float paramFloat2)
  {
    arev localarev1 = a(paramInt, false, true);
    arev localarev2 = a(paramInt, true, false);
    int j;
    if (localarev1 != null)
    {
      j = a().getSpanEnd(localarev1);
      if (paramInt != j) {
        return paramInt;
      }
      if ((j != getText().length()) && (localarev2 == null)) {
        break label276;
      }
      this.fn = false;
      getText().insert(j, " ");
    }
    label276:
    for (int i = 1;; i = 0)
    {
      int k = getOffsetForPosition(getTextSize() * aD + paramFloat1, paramFloat2);
      if (i != 0)
      {
        getText().replace(j, j + 1, "");
        this.fn = true;
      }
      if (k == j) {
        return k - 1;
      }
      if (localarev2 == null) {
        break;
      }
      i = a().getSpanStart(localarev2);
      if (paramInt != i) {
        break;
      }
      if ((i == 0) || (localarev1 != null))
      {
        this.fn = false;
        getText().insert(i, " ");
        j = getOffsetForPosition(paramFloat1 - getTextSize() * aD, paramFloat2);
        getText().replace(i, i + 1, "");
        this.fn = true;
        if (j - 1 != i) {
          break;
        }
        return j;
      }
      j = getOffsetForPosition(paramFloat1 - getTextSize() * aD, paramFloat2);
      if (j != i) {
        break;
      }
      return j + 1;
    }
  }
  
  private float c(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    return Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat) + getScrollX();
  }
  
  private void jg()
  {
    if (this.a != null)
    {
      this.a.iy(this);
      this.a = null;
    }
  }
  
  public a a(int paramInt)
  {
    int k = getText().length();
    if ((paramInt < 0) || (paramInt > k)) {
      return new a(k, k);
    }
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])a().getSpans(0, k, ImageSpan.class);
    int i1 = arrayOfImageSpan.length;
    int j = 0;
    int i = 0;
    int m;
    if (j < i1)
    {
      ImageSpan localImageSpan = arrayOfImageSpan[j];
      m = a().getSpanStart(localImageSpan);
      int n = a().getSpanEnd(localImageSpan);
      if ((n <= paramInt) && (n > i)) {
        i = n;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ((m >= paramInt) && (m < k))
      {
        k = m;
        continue;
        return new a(i, k);
      }
    }
  }
  
  public void a(arev paramarev1, arev paramarev2)
  {
    if (paramarev1 == this.a) {
      this.a = paramarev2;
    }
    int i = a().getSpanStart(paramarev1);
    int j = a().getSpanEnd(paramarev1);
    if ((i == -1) || (j == -1)) {
      return;
    }
    a(paramarev1, false, false);
    setSpan(paramarev2, i, j);
  }
  
  public void a(arev paramarev, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.b != null) && (paramBoolean2)) {
      this.b.a(paramarev);
    }
    if (this.a == paramarev) {
      this.a = null;
    }
    if (!paramBoolean1) {
      a().removeSpan(paramarev);
    }
    int i;
    int j;
    do
    {
      return;
      i = a().getSpanStart(paramarev);
      j = a().getSpanEnd(paramarev);
      a().removeSpan(paramarev);
    } while (i == -1);
    getText().replace(i, j, "", 0, 0);
  }
  
  public int getOffsetForPosition(float paramFloat1, float paramFloat2)
  {
    if (getLayout() == null) {
      return -1;
    }
    return a(b(paramFloat2), paramFloat1);
  }
  
  public void init(Context paramContext)
  {
    addTextChangedListener(this.textWatcher);
    this.mContext = paramContext;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    super.onCreateContextMenu(paramContextMenu);
    paramContextMenu.removeItem(16908319);
    if (getSelectionEnd() == getSelectionStart())
    {
      paramContextMenu.removeItem(16908321);
      paramContextMenu.removeItem(16908320);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (this.a != null)
      {
        paramInt = a().getSpanStart(this.a);
        a(this.a, true, true);
        this.a = null;
        setSelection(paramInt);
        setCursorVisible(true);
      }
      arev localarev;
      do
      {
        return true;
        if (getSelectionStart() != getSelectionEnd())
        {
          L(getSelectionStart(), getSelectionEnd() - getSelectionStart());
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
        localarev = a(getSelectionStart(), false, true);
        if (localarev == null) {
          break;
        }
      } while (!localarev.isEnable());
      this.a = a(localarev);
      setCursorVisible(false);
      return true;
    }
    if ((paramInt == 21) && (paramKeyEvent.getAction() == 0))
    {
      if (this.a != null)
      {
        setCursorVisible(true);
        paramInt = a().getSpanStart(this.a);
        setSelection(paramInt, paramInt);
        jg();
        return true;
      }
    }
    else if ((paramInt == 22) && (paramKeyEvent.getAction() == 0) && (this.a != null))
    {
      setCursorVisible(true);
      paramInt = a().getSpanEnd(this.a);
      setSelection(paramInt, paramInt);
      jg();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.fn = false;
    Editable localEditable = getText();
    super.onRestoreInstanceState(paramParcelable);
    setText(localEditable);
    this.fn = true;
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    Object localObject;
    int i;
    if ((paramInt1 != paramInt2) && (((arev[])a().getSpans(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), arev.class)).length != 0))
    {
      if ((paramInt1 != 0) || (paramInt2 != getText().length())) {
        break label207;
      }
      localObject = a(this.qB);
      this.qB = ((a)localObject).qF;
      this.qC = ((a)localObject).qG;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        if ((this.qC == -1) && (this.qB == -1))
        {
          paramInt1 = getText().length();
          this.qC = paramInt1;
          this.qB = paramInt1;
        }
      }
      try
      {
        setSelection(this.qB, this.qC);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        return;
      }
      if ((paramInt1 == paramInt2) && (paramInt1 == 0))
      {
        localObject = a(0, true, false);
        if ((localObject != null) && (this.b != null) && (!this.b.a((arev)localObject)))
        {
          i = 1;
          continue;
          this.qB = paramInt1;
          this.qC = paramInt2;
          super.onSelectionChanged(paramInt1, paramInt2);
          return;
        }
      }
      i = 0;
      continue;
      label207:
      i = 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int k = paramMotionEvent.getAction();
    if ((!isFocused()) || (getSelectionEnd() != getSelectionStart()) || ((k != 0) && (k != 2) && (k != 3) && (k != 1)))
    {
      if (k == 1)
      {
        localObject = ((BaseActivity)this.mContext).app.getHandler(EditActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = getOffsetForPosition(f1, f2);
    int i = j;
    if (j != -1) {
      i = a(j, f1, f2);
    }
    Object localObject = a(i, false, false);
    if (k == 0)
    {
      if (this.a != null) {
        jg();
      }
      this.a = ((arev)localObject);
      if (this.a != null) {
        setCursorVisible(false);
      }
    }
    for (;;)
    {
      if ((localObject == null) && (this.a != null)) {
        paramMotionEvent.setAction(3);
      }
      if (this.a != null)
      {
        bool = this.a.onTouch(this, paramMotionEvent);
        if ((k == 1) || (k == 3)) {
          this.a = null;
        }
      }
      if (k == 1)
      {
        localObject = ((BaseActivity)this.mContext).app.getHandler(EditActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
        }
      }
      if (!bool) {
        break;
      }
      return true;
      if ((k == 1) || (k == 3)) {
        setCursorVisible(true);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    if (this.a != null) {
      return true;
    }
    return super.performLongClick();
  }
  
  public void setEditListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void setSpan(ImageSpan paramImageSpan, int paramInt1, int paramInt2)
  {
    a().setSpan(paramImageSpan, paramInt1, paramInt2, 33);
  }
  
  static class a
  {
    int qF;
    int qG;
    
    public a(int paramInt1, int paramInt2)
    {
      this.qF = paramInt1;
      this.qG = paramInt2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(arev paramarev);
    
    public abstract boolean a(arev paramarev);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText
 * JD-Core Version:    0.7.0.1
 */