package com.tencent.mobileqq.activity.selectable;

import aawc;
import aawe;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class SelectableLinearLayout
  extends LinearLayout
  implements aawc
{
  private aawc b;
  private boolean mHasSelected;
  private int mHighlightBackgroundColor = -5250572;
  private boolean mIsHighlight;
  private boolean mIsSelectable = true;
  private aawe mSelectDelegate;
  private int mSelectEnd;
  private int mSelectStart;
  private final int[] mTempLocation = new int[2];
  
  public SelectableLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectableLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectableLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void bind(@Nullable aawe paramaawe)
  {
    this.mSelectDelegate = paramaawe;
  }
  
  public void clearHighlightContent()
  {
    this.mIsHighlight = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof aawc)) {
        ((aawc)localView).clearHighlightContent();
      }
      i += 1;
    }
  }
  
  @Nullable
  public CharSequence content()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof aawc)) {
        localStringBuilder.append(((aawc)localView).content());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (!(localView instanceof aawc)) {
        break label51;
      }
      i = ((aawc)localView).contentLength() + i;
    }
    label51:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @Nullable
  public aawe delegate()
  {
    return this.mSelectDelegate;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectableLinearLayout", 2, "doSelecting msg = null.");
      }
    }
    while (this.mSelectDelegate == null) {
      return;
    }
    this.mSelectDelegate.O(paramChatMessage);
  }
  
  public boolean hasSelected()
  {
    return this.mHasSelected;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.mTempLocation);
    int i = paramInt1 - this.mTempLocation[0];
    paramInt2 = paramInt2 - this.mTempLocation[1] - getPaddingTop();
    int j = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      View localView = getChildAt(paramInt1);
      if ((localView instanceof aawc))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectableLinearLayout", 2, new Object[] { "left=", Integer.valueOf(localView.getLeft()), " right=", Integer.valueOf(localView.getRight()), " top=", Integer.valueOf(localView.getTop()), " bottom=", Integer.valueOf(localView.getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > localView.getLeft()) && (i < localView.getRight()) && (paramInt2 > localView.getTop()) && (paramInt2 < localView.getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(int paramInt)
  {
    this.mHighlightBackgroundColor = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected())
    {
      clearHighlightContent();
      return;
    }
    int j = getChildCount();
    int i = 0;
    label19:
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if ((localObject instanceof aawc))
      {
        localObject = (aawc)localObject;
        if (!((aawc)localObject).hasSelected()) {
          break label74;
        }
        ((aawc)localObject).highlightBackgroundColor(this.mHighlightBackgroundColor);
        ((aawc)localObject).highlightContent();
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label74:
      ((aawc)localObject).clearHighlightContent();
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if (!(localObject instanceof aawc)) {
        break label79;
      }
      localObject = (aawc)localObject;
      int k = ((aawc)localObject).contentLength();
      if (paramInt > k) {
        paramInt -= k;
      }
    }
    label79:
    for (;;)
    {
      i += 1;
      break;
      ((aawc)localObject).locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
      return;
    }
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.mSelectStart, this.mSelectEnd);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    int i;
    int k;
    label46:
    aawc localaawc;
    int m;
    int j;
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.mSelectStart = -1;
      this.mSelectEnd = -1;
      this.mHasSelected = false;
      paramInt2 = this.mSelectStart;
      i = this.mSelectEnd;
      int n = getChildCount();
      k = 0;
      paramInt1 = 0;
      if (k >= n) {
        break label257;
      }
      View localView = getChildAt(k);
      if (!(localView instanceof aawc)) {
        break label266;
      }
      localaawc = (aawc)localView;
      if (paramInt1 != 0) {
        break label237;
      }
      m = localaawc.contentLength();
      if (paramInt2 < m) {
        break label190;
      }
      i -= m;
      localaawc.selectContent(-1, -1);
      j = paramInt2 - m;
      paramInt2 = paramInt1;
      paramInt1 = j;
      label120:
      localView.invalidate();
    }
    for (;;)
    {
      k += 1;
      j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      break label46;
      if (paramInt1 > paramInt2) {
        this.mSelectStart = paramInt2;
      }
      for (this.mSelectEnd = paramInt1;; this.mSelectEnd = paramInt2)
      {
        if (this.mSelectEnd - this.mSelectStart <= 0) {
          break label188;
        }
        this.mHasSelected = true;
        break;
        this.mSelectStart = paramInt1;
      }
      label188:
      break;
      label190:
      if (i > m)
      {
        j = paramInt1;
        paramInt1 = m;
      }
      for (;;)
      {
        localaawc.selectContent(paramInt2, paramInt1);
        if (j != 0) {
          break label258;
        }
        i -= m;
        paramInt1 = 0;
        paramInt2 = j;
        break;
        paramInt1 = i;
        j = 1;
      }
      label237:
      localaawc.selectContent(-1, -1);
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label257:
      return;
      label258:
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label266:
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.mTempLocation);
    int m = paramInt1 - this.mTempLocation[0] - getPaddingLeft();
    int n = paramInt2 - this.mTempLocation[1] - getPaddingTop();
    int k = getChildCount();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < k)
    {
      localObject = getChildAt(j);
      if (!(localObject instanceof aawc)) {
        break label238;
      }
      aawc localaawc = (aawc)localObject;
      if ((m > ((View)localObject).getLeft()) && (m < ((View)localObject).getRight()) && (n > ((View)localObject).getTop()) && (n < ((View)localObject).getBottom()))
      {
        this.b = localaawc;
        return localaawc.touchIndex(paramInt1, paramInt2) + i;
      }
      i = localaawc.contentLength() + i;
    }
    label235:
    label238:
    for (;;)
    {
      j += 1;
      break;
      j = 0;
      i = 0;
      if (j < k)
      {
        localObject = getChildAt(j);
        if (!(localObject instanceof aawc)) {
          break label235;
        }
        localObject = (aawc)localObject;
        if (this.b == localObject) {
          return this.b.touchIndex(paramInt1, paramInt2) + i;
        }
        i = ((aawc)localObject).contentLength() + i;
      }
      for (;;)
      {
        j += 1;
        break;
        return -1;
      }
    }
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableLinearLayout
 * JD-Core Version:    0.7.0.1
 */