package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import eyk;
import eyl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgLinearLayout
  extends LinearLayout
{
  public static final String a = "MixedMsgLinearLayout";
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public AnimationTextView.OnDoubleClick a;
  private eyk jdField_a_of_type_Eyk = new eyk(this);
  private eyl jdField_a_of_type_Eyl = new eyl(this);
  private MotionEvent b;
  public AnimationTextView.OnDoubleClick b;
  
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
    localLayoutParams.leftMargin = BaseChatItemLayout.p;
    localLayoutParams.rightMargin = BaseChatItemLayout.q;
    localChatThumbView.setLayoutParams(localLayoutParams);
    localChatThumbView.setAdjustViewBounds(true);
    localChatThumbView.setMaxHeight(AIOUtils.a(URLDrawableHelper.f, getContext().getResources()));
    localChatThumbView.setMaxWidth(AIOUtils.a(URLDrawableHelper.f, getContext().getResources()));
    int j = paramMessageForPic.thumbWidth;
    int i = paramMessageForPic.thumbHeight;
    float f1;
    if ((j > 0) && (i > 0)) {
      if ((j < URLDrawableHelper.e) || (i < URLDrawableHelper.e)) {
        if (j < i)
        {
          f1 = URLDrawableHelper.e / j;
          k = URLDrawableHelper.e;
          int m = (int)(f1 * i + 0.5F);
          i = m;
          j = k;
          if (m > URLDrawableHelper.f)
          {
            i = URLDrawableHelper.f;
            j = k;
          }
        }
      }
    }
    for (;;)
    {
      f1 = getResources().getDisplayMetrics().densityDpi / 160.0F;
      j = (int)(j * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      if (!(URLDrawableHelper.a instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramMessageForPic = ((SkinnableBitmapDrawable)URLDrawableHelper.a).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
      j = (int)(URLDrawableHelper.e / i * j + 0.5F);
      i = j;
      if (j > URLDrawableHelper.f) {
        i = URLDrawableHelper.f;
      }
      k = URLDrawableHelper.e;
      j = i;
      i = k;
      continue;
      if ((j >= URLDrawableHelper.f) || (i >= URLDrawableHelper.f))
      {
        label363:
        float f2;
        if (j > i)
        {
          f1 = URLDrawableHelper.f / j;
          if (j <= i) {
            break label430;
          }
          f2 = URLDrawableHelper.e / i;
          label379:
          Math.max(f1, f2);
          if (f1 >= f2) {
            break label458;
          }
          if (j <= i) {
            break label442;
          }
        }
        label430:
        label442:
        for (j = URLDrawableHelper.f;; j = URLDrawableHelper.e)
        {
          if (i <= j) {
            break label450;
          }
          i = URLDrawableHelper.f;
          break;
          f1 = URLDrawableHelper.f / i;
          break label363;
          f2 = URLDrawableHelper.e / j;
          break label379;
        }
        label450:
        i = URLDrawableHelper.e;
        continue;
        label458:
        if (j > i) {}
        for (f1 = URLDrawableHelper.f / j;; f1 = URLDrawableHelper.f / i)
        {
          j = (int)(j * f1 + 0.5F);
          i = (int)(f1 * i + 0.5F);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgLinearLayout", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + i);
        }
        j = 99;
        i = k;
      }
    }
    if ((URLDrawableHelper.a instanceof BitmapDrawable))
    {
      paramMessageForPic = ((BitmapDrawable)URLDrawableHelper.a).getBitmap();
      localChatThumbView.setImageDrawable(new BitmapDrawableWithMargin(getResources(), paramMessageForPic, j, i, -921103));
      return localChatThumbView;
    }
    localChatThumbView.setImageDrawable(URLDrawableHelper.a);
    return localChatThumbView;
  }
  
  private AnimationTextView a()
  {
    AnimationTextView localAnimationTextView = new AnimationTextView(getContext());
    localAnimationTextView.setTextColor(getContext().getResources().getColorStateList(2131427478));
    localAnimationTextView.setLinkTextColor(getContext().getResources().getColorStateList(2131427477));
    localAnimationTextView.setSpannableFactory(QQText.a);
    localAnimationTextView.setMaxWidth(BaseChatItemLayout.g);
    localAnimationTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localAnimationTextView.setPadding(BaseChatItemLayout.p, 0, BaseChatItemLayout.q, 0);
    localAnimationTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localAnimationTextView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return localAnimationTextView;
  }
  
  public static boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= 10000);
    return true;
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
  
  public void a(List paramList)
  {
    int k = 0;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (((localObject3 instanceof MessageForText)) && (((MessageForText)localObject3).sb.toString().equals("\n"))) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.remove((MessageRecord)((Iterator)localObject1).next());
    }
    int j = getChildCount();
    Object localObject3 = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof AnimationTextView)) {
        ((ArrayList)localObject3).add(localObject1);
      }
      i += 1;
    }
    i = 0;
    while (i < ((ArrayList)localObject3).size())
    {
      localObject1 = (View)((ArrayList)localObject3).get(i);
      detachViewFromParent((View)localObject1);
      ((AnimationTextView)localObject1).setText("");
      this.jdField_a_of_type_Eyl.a((AnimationTextView)localObject1);
      i += 1;
    }
    j = paramList.size();
    i = 0;
    if (i < j)
    {
      localObject2 = paramList.get(i);
      if ((localObject2 instanceof MessageForText))
      {
        localObject2 = this.jdField_a_of_type_Eyl.a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a();
        }
        addViewInLayout((View)localObject1, i, ((AnimationTextView)localObject1).getLayoutParams(), true);
      }
      while ((!(localObject2 instanceof MessageForPic)) || (i < getChildCount()))
      {
        i += 1;
        break;
      }
      localObject1 = this.jdField_a_of_type_Eyk.a();
      if (localObject1 != null) {
        break label474;
      }
      localObject1 = a((MessageForPic)localObject2);
    }
    label474:
    for (;;)
    {
      addViewInLayout((View)localObject1, i, ((ChatThumbView)localObject1).getLayoutParams(), true);
      break;
      ((ArrayList)localObject3).clear();
      int m = getChildCount();
      i = k;
      if (m > j) {
        for (;;)
        {
          i = k;
          if (j >= m) {
            break;
          }
          ((ArrayList)localObject3).add(getChildAt(j));
          j += 1;
        }
      }
      while (i < ((ArrayList)localObject3).size())
      {
        paramList = (View)((ArrayList)localObject3).get(i);
        detachViewFromParent(paramList);
        if ((paramList instanceof ChatThumbView))
        {
          ((ChatThumbView)paramList).setImageDrawable(null);
          ((ChatThumbView)paramList).setURLDrawableDownListener(null);
          this.jdField_a_of_type_Eyk.a((ChatThumbView)paramList);
        }
        i += 1;
      }
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
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */