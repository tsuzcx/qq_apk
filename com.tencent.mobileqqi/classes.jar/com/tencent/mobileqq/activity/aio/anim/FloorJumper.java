package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class FloorJumper
  extends AIOAnimationConatiner.AIOAnimator
{
  static final float jdField_a_of_type_Float = BaseApplicationImpl.a().getResources().getDisplayMetrics().density;
  static final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 3.82F, 7.28F, 10.38F, 13.12F, 15.499998F, 17.52F, 19.18F, 20.48F, 21.420002F, 21.999998F, 22.219999F, 22.08F, 21.580004F, 20.720001F, 19.500004F, 17.920002F, 15.98F, 13.680004F, 11.020004F, 8.0F, 4.620003F, 0.8799973F, 0.0F, 0.0F, 1.568F, 2.848F, 3.839999F, 4.543999F, 4.959999F, 5.087998F, 4.927998F, 4.479999F, 3.744F, 2.719999F, 1.407999F, 0.0F, 0.0F, 0.5824001F, 0.9344F, 1.056F, 0.9472004F, 0.6080008F, 0.0384007F, 0.0F };
  static final float jdField_b_of_type_Float = 39.772724F * jdField_a_of_type_Float;
  static final float[] jdField_b_of_type_ArrayOfFloat = { 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.042F, 1.024F, 1.006F, 0.988F, 0.97F, 0.952F, 0.966F, 0.984F, 1.002F, 1.02F, 1.038F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.0356F, 1.0212F, 1.0068F, 0.9924F, 0.978F, 0.9636F, 0.9508F, 0.9652F, 0.9796F, 0.994F, 1.0084F, 1.0228F, 1.0436F, 0.98488F, 0.97336F, 0.96184F, 0.95032F, 0.9612F, 0.97272F, 0.98424F, 1.02288F };
  static final float jdField_c_of_type_Float = 17.5F * jdField_a_of_type_Float;
  static final int jdField_c_of_type_Int = 1;
  static final float jdField_d_of_type_Float = 3000.0F * jdField_a_of_type_Float;
  static final int jdField_d_of_type_Int = 2;
  static final int jdField_e_of_type_Int = 3;
  static final int jdField_f_of_type_Int = 4;
  static final int jdField_g_of_type_Int = 5;
  static final int h = 500;
  static final int i = jdField_a_of_type_ArrayOfFloat.length * 10;
  long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  long jdField_c_of_type_Long = 0L;
  private long jdField_d_of_type_Long = 0L;
  float jdField_e_of_type_Float;
  float jdField_f_of_type_Float;
  float jdField_g_of_type_Float;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  
  public FloorJumper(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ChatXListView paramChatXListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramChatXListView);
    this.g = (750.0F * jdField_a_of_type_Float);
  }
  
  private BaseChatItemLayout a(long paramLong)
  {
    Object localObject2;
    if (paramLong == 0L)
    {
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject2 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject1);
          if ((((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_Int != 0) && (((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getTop() + ((View)localObject1).getTop() + BaseChatItemLayout.i > 0)) {
            return (BaseChatItemLayout)localObject1;
          }
        }
        i1 += 1;
      }
    }
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    int i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.l();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
    int i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
    int i7 = ((ListAdapter)localObject1).getCount();
    int i2 = i3;
    int i1 = 0;
    if (i2 <= i6) {
      if (i2 >= i4) {}
    }
    for (;;)
    {
      i2 += 1;
      break;
      if (i2 >= i7 - i5) {
        return null;
      }
      if (i1 == 0)
      {
        if (paramLong == ((ListAdapter)localObject1).getItemId(i2)) {
          i1 = 1;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i2 - i3);
        if (((localObject2 instanceof BaseChatItemLayout)) && (((BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2)).jdField_a_of_type_Int != 0)) {
          return (BaseChatItemLayout)localObject2;
        }
      }
    }
  }
  
  int a(int paramInt, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i1;
    int i2;
    int i3;
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      i1 = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.l + BaseChatItemLayout.q;
      i2 = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.k - BaseChatItemLayout.p;
      if (paramInt > i1) {
        break label129;
      }
      if (i2 - jdField_c_of_type_Float >= i1) {
        break label108;
      }
      i3 = i1;
    }
    label108:
    do
    {
      return i3;
      i1 = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.k + BaseChatItemLayout.p;
      i2 = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.l - BaseChatItemLayout.l;
      break;
      return (int)(Math.random() * (i2 - i1 - jdField_c_of_type_Float) + i1);
      if (paramInt >= i2)
      {
        if (i1 + jdField_c_of_type_Float < i2) {
          return i2;
        }
        d1 = i1 + jdField_c_of_type_Float;
        double d2 = Math.random();
        return (int)((i2 - i1 - jdField_c_of_type_Float) * d2 + d1);
      }
      if (paramInt - i1 > jdField_c_of_type_Float) {
        break label211;
      }
      i3 = paramInt;
    } while (i2 - paramInt <= jdField_c_of_type_Float);
    label129:
    label211:
    float f1;
    if ((paramInt - i1 > jdField_c_of_type_Float) && (i2 - paramInt > jdField_c_of_type_Float))
    {
      f1 = (int)(Math.random() * (i2 - i1 - jdField_c_of_type_Float - jdField_c_of_type_Float));
      return (int)(i1 + jdField_c_of_type_Float + f1);
    }
    if (paramInt - i1 > jdField_c_of_type_Float)
    {
      f1 = (int)(Math.random() * (paramInt - i1 - jdField_c_of_type_Float));
      return (int)(paramInt - f1);
    }
    double d1 = Math.random();
    return (int)((int)((i2 - paramInt - jdField_c_of_type_Float) * d1) + paramInt);
  }
  
  public long a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return -1L;
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return -1L;
    case 1: 
    case 3: 
      if (l1 < this.jdField_c_of_type_Long) {
        return this.jdField_c_of_type_Long - l1;
      }
      BaseBubbleBuilder.ViewHolder localViewHolder;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_Long = l1;
        localBaseChatItemLayout = a(0L);
        if (localBaseChatItemLayout != null)
        {
          localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(localBaseChatItemLayout);
          if (localViewHolder != null)
          {
            this.jdField_b_of_type_Int = 2;
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
            this.jdField_d_of_type_Long = 0L;
            this.j = 0;
            i1 = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
            this.k = (localBaseChatItemLayout.getTop() + i1 + BaseChatItemLayout.i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY());
            this.l = a((localViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + localViewHolder.jdField_a_of_type_AndroidViewView.getRight()) / 2, localViewHolder);
            this.m = 0;
            this.e = 0.0F;
            this.f = ((float)(500.0F * jdField_a_of_type_Float * Math.random()));
            this.o = 0;
            this.n = 0;
          }
        }
        for (;;)
        {
          return 0L;
          this.jdField_b_of_type_Int = 5;
          this.l = (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() / 2 + (int)(Math.random() * 160.0D * jdField_a_of_type_Float - 80.0D));
          this.m = this.o;
          this.jdField_d_of_type_Long = 0L;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          this.j = 0;
          this.k = 0;
          this.e = 0.0F;
          this.f = ((float)(500.0F * jdField_a_of_type_Float * Math.random()));
        }
      }
      BaseChatItemLayout localBaseChatItemLayout = a(this.jdField_b_of_type_Long);
      if (localBaseChatItemLayout != null)
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(localBaseChatItemLayout);
        if (localViewHolder != null)
        {
          this.l = this.n;
          this.m = this.o;
          this.jdField_b_of_type_Int = 4;
          this.jdField_c_of_type_Long = l1;
          this.jdField_d_of_type_Long = 0L;
          this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
          this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          this.f = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * jdField_a_of_type_Float);
          this.k = (localViewHolder.jdField_a_of_type_AndroidViewView.getTop() + localBaseChatItemLayout.getTop() + BaseChatItemLayout.i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() - this.m);
          double d1 = (Math.sqrt(this.f * this.f + jdField_d_of_type_Float * 2.0F * this.k) - this.f) / jdField_d_of_type_Float;
          this.j = (a(this.n, localViewHolder) - this.n);
          this.e = ((float)(this.j / d1));
        }
      }
      for (;;)
      {
        return 0L;
        this.l = this.n;
        this.m = this.o;
        this.jdField_b_of_type_Int = 5;
        this.jdField_c_of_type_Long = l1;
        this.jdField_d_of_type_Long = 0L;
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        this.jdField_b_of_type_Long = 0L;
        this.j = 0;
        this.k = 0;
        this.e = ((float)(Math.random() * 400.0D - 100.0D));
        this.f = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * jdField_a_of_type_Float);
      }
    case 2: 
    case 4: 
      if (this.jdField_d_of_type_Long == 0L)
      {
        f1 = (float)(l1 - this.jdField_c_of_type_Long) / 1000.0F;
        i2 = (int)(this.f * f1 + jdField_d_of_type_Float * f1 * f1 / 2.0F);
        int i3 = (int)(this.e * f1);
        f2 = this.g;
        f3 = this.f;
        f1 = Math.min(f2, Math.abs(f1 * jdField_d_of_type_Float + f3)) / this.g * 0.25F + 0.9F;
        i1 = i2;
        if (i2 > this.k)
        {
          i1 = this.k;
          f1 = 1.0F;
          this.jdField_d_of_type_Long = l1;
        }
        this.o = (i1 + this.m);
        this.n = (this.l + i3);
        a(this.n, this.o, new float[] { f1 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      if (l1 - this.jdField_d_of_type_Long <= i)
      {
        f1 = (float)(l1 - this.jdField_d_of_type_Long) / 1000.0F;
        i2 = Math.round((float)(l1 - this.jdField_d_of_type_Long) / 10.0F);
        i1 = i2;
        if (i2 >= jdField_a_of_type_ArrayOfFloat.length) {
          i1 = jdField_a_of_type_ArrayOfFloat.length - 1;
        }
        f1 = (int)(f1 * Math.max(Math.min(this.e, jdField_b_of_type_Float), -jdField_b_of_type_Float));
        f2 = jdField_a_of_type_ArrayOfFloat[i1];
        f3 = jdField_a_of_type_Float;
        float f4 = jdField_b_of_type_ArrayOfFloat[i1];
        this.n = ((int)(f1 + (this.l + this.j)));
        this.o = ((int)(this.m + this.k - f2 * f3));
        a(this.n, this.o, new float[] { f4 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      this.o = (this.m + this.k);
      a(this.n, this.o, new float[0]);
      i1 = (int)(500.0D + Math.random() * 800.0D - 400.0D);
      this.jdField_c_of_type_Long = (AnimationUtils.currentAnimationTimeMillis() + i1);
      this.jdField_b_of_type_Int = 3;
      return i1;
    }
    float f1 = (float)(l1 - this.jdField_c_of_type_Long) / 1000.0F;
    int i1 = (int)(this.f * f1 + jdField_d_of_type_Float * f1 * f1 / 2.0F);
    int i2 = (int)(this.e * f1);
    float f2 = this.g;
    float f3 = this.f;
    f1 = Math.min(f2, Math.abs(f1 * jdField_d_of_type_Float + f3)) / this.g;
    this.o = (i1 + this.m);
    this.n = (this.l + i2);
    if ((this.o > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) || (this.n < -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) || (this.n > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
    {
      a(0, this.jdField_a_of_type_AndroidViewView.getWidth(), new float[0]);
      c();
      return -1L;
    }
    a(this.n, this.o, new float[] { f1 * 0.25F + 0.9F });
    return FloorJumperSet.jdField_a_of_type_Long;
  }
  
  @TargetApi(11)
  void a(int paramInt1, int paramInt2, float... paramVarArgs)
  {
    int i1 = this.jdField_a_of_type_AndroidViewView.getLeft();
    int i2 = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
    int i3 = this.jdField_a_of_type_AndroidViewView.getBottom();
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt2 - i3);
    this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(paramInt1 - (i1 + i2));
    if (VersionUtils.e())
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        this.jdField_a_of_type_AndroidViewView.setScaleY(paramVarArgs[0]);
        this.jdField_a_of_type_AndroidViewView.setScaleX(2.0F - paramVarArgs[0]);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
  }
  
  void a(long paramLong)
  {
    if (this.jdField_c_of_type_Long > 0L) {
      this.jdField_c_of_type_Long += paramLong;
    }
    if (this.jdField_d_of_type_Long > 0L) {
      this.jdField_d_of_type_Long += paramLong;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      int i1;
      while ((this.o > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) || (this.n < -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) || (this.n > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
      {
        c();
        return false;
        i1 = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a());
        if (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q())
        {
          this.o = -1;
        }
        else if (i1 > this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r())
        {
          if (this.jdField_d_of_type_Long > 0L)
          {
            c();
            return false;
          }
          this.jdField_b_of_type_Int = 5;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
        }
        else
        {
          BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i1));
          if (localViewHolder != null)
          {
            i1 = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
            i1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + i1 + BaseChatItemLayout.i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() - (this.m + this.k);
            if (i1 != 0)
            {
              this.m += i1;
              this.o += i1;
              this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i1);
            }
          }
          else
          {
            c();
            return false;
            i1 = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a());
            int i2 = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a());
            if ((i1 >= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q()) && (i1 <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i1));
              if (localViewHolder != null)
              {
                i1 = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                i1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + i1 + BaseChatItemLayout.i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() - (this.m + this.k);
                if (i1 != 0)
                {
                  this.m += i1;
                  this.o += i1;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i1);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if ((i2 >= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q()) && (i2 <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i2));
              if (localViewHolder != null)
              {
                i1 = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                i1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + i1 + BaseChatItemLayout.i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() - (this.m + this.k);
                if (i1 != 0)
                {
                  this.m += i1;
                  this.o += i1;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i1);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q())
            {
              this.o = -1;
            }
            else if (i2 > this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r())
            {
              this.jdField_b_of_type_Int = 5;
              this.jdField_a_of_type_Long = 0L;
              this.jdField_b_of_type_Long = 0L;
            }
            else
            {
              c();
              return false;
            }
          }
        }
      }
      if (this.o <= 0) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      for (;;)
      {
        return true;
        i1 = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a());
        if ((i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q()) || (i1 > this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r()))
        {
          a(new Object[0]);
          a(this.n, this.o, new float[0]);
          continue;
          a(new Object[0]);
          a(this.n, this.o, new float[0]);
        }
      }
    }
    c();
    return false;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(true);
    }
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    Rect localRect;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)paramVarArgs[0]);
      localRect = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      if (localRect.isEmpty())
      {
        this.jdField_a_of_type_AndroidViewView.layout(-this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), -this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight(), 0, 0);
        if (VersionUtils.e())
        {
          this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
          this.jdField_a_of_type_AndroidViewView.setPivotY(this.jdField_a_of_type_AndroidViewView.getHeight());
          this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
        }
        label150:
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_Boolean = true;
        if (paramVarArgs.length <= 1) {
          break label286;
        }
      }
    }
    label286:
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = Integer.valueOf(0))
    {
      int i1 = ((Integer)paramVarArgs).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "start floor jumper. delay: " + i1);
      }
      this.jdField_c_of_type_Long = (AnimationUtils.currentAnimationTimeMillis() + i1);
      this.jdField_b_of_type_Int = 1;
      return true;
      this.jdField_a_of_type_AndroidViewView.layout(-localRect.width(), -localRect.height(), 0, 0);
      break;
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(-this.jdField_a_of_type_AndroidViewView.getRight());
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_AndroidViewView.getBottom());
      break label150;
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumper
 * JD-Core Version:    0.7.0.1
 */