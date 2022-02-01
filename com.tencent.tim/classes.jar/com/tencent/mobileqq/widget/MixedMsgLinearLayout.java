package com.tencent.mobileqq.widget;

import aawc;
import aawe;
import afeg;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofk;
import aofr;
import aoop;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import xjx.a;
import xmb;

public class MixedMsgLinearLayout
  extends LinearLayout
  implements aawc
{
  private a jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$a = new a();
  private b jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$b = new b();
  private aawc b;
  public AnimationTextView.a b;
  private MotionEvent mCurrentDownEvent;
  private boolean mHasSelected;
  private int mHighlightBackgroundColor = -5250572;
  private boolean mIsHighlight;
  private boolean mIsSelectable = true;
  private MotionEvent mPreviousUpEvent;
  private aawe mSelectDelegate;
  private int mSelectEnd;
  private int mSelectStart;
  private final int[] mTempLocation = new int[2];
  public AnimationTextView.a onDoubleClick;
  
  public MixedMsgLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MixedMsgLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ChatThumbView a(MessageForPic paramMessageForPic)
  {
    int k = 99;
    ChatThumbView localChatThumbView = new ChatThumbView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    localChatThumbView.setLayoutParams(localLayoutParams);
    localChatThumbView.setAdjustViewBounds(true);
    int m = aoop.G(false);
    int i = aoop.I(false);
    int j = aoop.J(false);
    localChatThumbView.setMaxHeight(m);
    localChatThumbView.setMaxWidth(m);
    m = paramMessageForPic.thumbWidth;
    int n = paramMessageForPic.thumbHeight;
    if ((m > 0) && (n > 0)) {
      if ((m < j) || (n < j)) {
        if (m < n)
        {
          k = (int)(j / m * n + 0.5F);
          if (k > i) {
            k = j;
          }
        }
      }
    }
    for (;;)
    {
      float f1 = getResources().getDisplayMetrics().densityDpi / 160.0F;
      j = (int)(k * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      if (!(aoop.am() instanceof SkinnableBitmapDrawable)) {
        break label526;
      }
      paramMessageForPic = ((SkinnableBitmapDrawable)aoop.am()).getBitmap();
      localChatThumbView.setImageDrawable(new afeg(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
      i = k;
      break;
      k = (int)(j / n * m + 0.5F);
      i = k;
      if (k > j) {
        i = j;
      }
      k = i;
      i = j;
      j = k;
      break;
      if ((m < i) && (n < i))
      {
        i = n;
        k = m;
      }
      else
      {
        label337:
        float f2;
        if (m > n)
        {
          f1 = i / m;
          if (m <= n) {
            break label408;
          }
          f2 = j / n;
          label352:
          Math.max(f1, f2);
          if (f1 >= f2) {
            break label426;
          }
          if (m <= n) {
            break label419;
          }
        }
        label408:
        label419:
        for (m = i;; m = j)
        {
          k = m;
          if (n > m) {
            break;
          }
          i = j;
          k = m;
          break;
          f1 = i / n;
          break label337;
          f2 = j / m;
          break label352;
        }
        label426:
        if (m > n) {}
        for (f1 = i / m;; f1 = i / n)
        {
          k = (int)(m * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, "MessageForPic without width/height of thumb, width = " + m + ", height = " + n);
        }
        i = 99;
      }
    }
    label526:
    if ((aoop.am() instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)aoop.am()).getBitmap();
      localChatThumbView.setImageDrawable(new afeg(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(aoop.am());
    return localChatThumbView;
  }
  
  private AnimationTextView a()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131167322));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131167316));
    localAnimationTextView.setSpannableFactory(aofk.a);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.bNT);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(0, 0, 0, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.onDoubleClick = this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$a;
    return localAnimationTextView;
  }
  
  private boolean bk(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = ((MessageForText)paramMessageRecord).sb;
      bool1 = bool2;
      if (paramMessageRecord != null)
      {
        bool1 = bool2;
        if (paramMessageRecord.toString().equals("\n")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof AnimationTextView))
      {
        localObject = (AnimationTextView)localObject;
        ((AnimationTextView)localObject).setTextColor(paramColorStateList1);
        ((AnimationTextView)localObject).setLinkTextColor(paramColorStateList2);
      }
      i += 1;
    }
  }
  
  public void a(List<MessageRecord> paramList, xjx.a parama)
  {
    int k = 0;
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (bk((MessageRecord)paramList.get(i))) {
        ((List)localObject1).add(paramList.get(i));
      }
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.remove((MessageRecord)((Iterator)localObject1).next());
    }
    int j = getChildCount();
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof AnimationTextView)) {
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (View)localArrayList.get(i);
      detachViewFromParent((View)localObject1);
      ((AnimationTextView)localObject1).setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$b.a((AnimationTextView)localObject1);
      i += 1;
    }
    j = paramList.size();
    i = 0;
    if (i < j)
    {
      Object localObject2 = paramList.get(i);
      if ((localObject2 instanceof MessageForReplyText))
      {
        localObject1 = new SelectableLinearLayout(getContext());
        ((LinearLayout)localObject1).setOrientation(1);
        localObject2 = xmb.a(getContext());
        parama.bTz = i;
        parama.Jm = ((TextView)((ViewGroup)localObject2).findViewById(2131372190));
        parama.d = ((ETTextView)((ViewGroup)localObject2).findViewById(2131371989));
        parama.e = ((ETTextView)((ViewGroup)localObject2).findViewById(2131372006));
        ((LinearLayout)localObject1).addView((View)localObject2);
        localObject2 = new ETTextView(getContext());
        ((ETTextView)localObject2).setTextColor(getContext().getResources().getColorStateList(2131167322));
        ((ETTextView)localObject2).setLinkTextColor(getContext().getResources().getColorStateList(2131167316));
        ((ETTextView)localObject2).setEditableFactory(aofr.a);
        ((ETTextView)localObject2).setSpannableFactory(aofk.a);
        ((ETTextView)localObject2).setMaxWidth(BaseChatItemLayout.bNS);
        ((ETTextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addViewInLayout((View)localObject1, i, ((LinearLayout)localObject1).getLayoutParams(), true);
        parama.mText = ((TextView)localObject2);
      }
      label509:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof MessageForText)) {
            break label509;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$b.b();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a();
          }
          addViewInLayout((View)localObject1, i, ((AnimationTextView)localObject1).getLayoutParams(), true);
        }
      } while (!(localObject2 instanceof MessageForPic));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$a.a();
      if (localObject1 != null) {
        break label677;
      }
      localObject1 = a((MessageForPic)localObject2);
    }
    label677:
    for (;;)
    {
      addViewInLayout((View)localObject1, i, ((ChatThumbView)localObject1).getLayoutParams(), true);
      break;
      localArrayList.clear();
      int m = getChildCount();
      i = k;
      if (m > j) {
        for (;;)
        {
          i = k;
          if (j >= m) {
            break;
          }
          localArrayList.add(getChildAt(j));
          j += 1;
        }
      }
      while (i < localArrayList.size())
      {
        paramList = (View)localArrayList.get(i);
        detachViewFromParent(paramList);
        if ((paramList instanceof ChatThumbView))
        {
          ((ChatThumbView)paramList).setImageDrawable(null);
          ((ChatThumbView)paramList).setURLDrawableDownListener(null);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMixedMsgLinearLayout$a.b((ChatThumbView)paramList);
        }
        i += 1;
      }
      return;
    }
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
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgLinearLayout", 2, "doSelecting msg = null.");
      }
      return;
    }
    if (this.mSelectDelegate == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
    this.jdField_b_of_type_Aawc = null;
    this.mSelectDelegate.O(paramChatMessage);
    anot.a(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 2, 0, "", "", "", "");
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
          QLog.d("MixedMsgLinearLayout", 2, new Object[] { "left=", Integer.valueOf(localView.getLeft()), " right=", Integer.valueOf(localView.getRight()), " top=", Integer.valueOf(localView.getTop()), " bottom=", Integer.valueOf(localView.getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > localView.getLeft()) && (i < localView.getRight()) && (paramInt2 > localView.getTop()) && (paramInt2 < localView.getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(@ColorInt int paramInt)
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.onDoubleClick != null) {
      if ((this.mPreviousUpEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.mPreviousUpEvent != null) && (this.mCurrentDownEvent != null) && (AnimationTextView.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent)))
        {
          this.mCurrentDownEvent = null;
          this.mPreviousUpEvent = null;
          if (this.onDoubleClick != null)
          {
            this.onDoubleClick.R(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
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
        this.jdField_b_of_type_Aawc = localaawc;
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
        if (this.jdField_b_of_type_Aawc == localObject) {
          return this.jdField_b_of_type_Aawc.touchIndex(paramInt1, paramInt2) + i;
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
  
  @Nullable
  public View view()
  {
    return this;
  }
  
  public CharSequence z()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = getChildCount();
    int j = this.mSelectStart;
    int k = this.mSelectEnd;
    int n = 0;
    int i = 0;
    Object localObject;
    int m;
    int i1;
    if (n < i3)
    {
      localObject = getChildAt(n);
      if ((localObject instanceof aawc))
      {
        localObject = (aawc)localObject;
        m = i;
        if (i != 0) {
          break label211;
        }
        i1 = ((aawc)localObject).contentLength();
        if (j >= i1)
        {
          m = k - i1;
          k = j - i1;
          j = m;
        }
      }
    }
    for (;;)
    {
      label96:
      m = k;
      i1 = j;
      int i2 = i;
      for (;;)
      {
        n += 1;
        i = i2;
        k = i1;
        j = m;
        break;
        if (k <= i1) {
          i = 1;
        }
        localObject = ((aawc)localObject).selectContent();
        if (localObject != null) {
          localStringBuilder.append((CharSequence)localObject);
        }
        m = i;
        if (i != 0) {
          break label211;
        }
        j = k - i1;
        k = 0;
        break label96;
        i2 = i;
        i1 = k;
        m = j;
        if (n != 0)
        {
          localStringBuilder.append(" ");
          i2 = i;
          i1 = k;
          m = j;
        }
      }
      return localStringBuilder.toString();
      label211:
      i = k;
      k = j;
      j = i;
      i = m;
    }
  }
  
  class a
  {
    private Stack<ChatThumbView> m = new Stack();
    
    a() {}
    
    public ChatThumbView a()
    {
      if (this.m.isEmpty()) {
        return null;
      }
      return (ChatThumbView)this.m.pop();
    }
    
    public void b(ChatThumbView paramChatThumbView)
    {
      this.m.push(paramChatThumbView);
    }
  }
  
  class b
  {
    private Stack<AnimationTextView> m = new Stack();
    
    b() {}
    
    public void a(AnimationTextView paramAnimationTextView)
    {
      this.m.push(paramAnimationTextView);
    }
    
    public AnimationTextView b()
    {
      if (this.m.isEmpty()) {
        return null;
      }
      return (AnimationTextView)this.m.pop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */