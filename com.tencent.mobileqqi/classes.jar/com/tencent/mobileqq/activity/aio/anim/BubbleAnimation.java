package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dxa;
import dxb;
import dxc;
import dxe;
import dxq;

public class BubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  public static final String a;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private BubbleInfo.CommonAttrs jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
  private dxq jdField_a_of_type_Dxq;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private BubbleInfo.CommonAttrs jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
  private dxq jdField_b_of_type_Dxq;
  
  static
  {
    jdField_a_of_type_JavaLangString = BubbleAnimation.class.getSimpleName();
  }
  
  public BubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ChatXListView paramChatXListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramChatXListView);
    this.jdField_a_of_type_Dxq = new dxq(paramChatXListView.getResources());
    this.jdField_b_of_type_Dxq = new dxq(paramChatXListView.getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private boolean a(long paramLong)
  {
    boolean bool3 = false;
    int i = AIOUtils.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a());
    Object localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i));
    boolean bool1;
    boolean bool2;
    label309:
    label316:
    int n;
    int k;
    int j;
    int m;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.top = (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getTop() + ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.left = (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getLeft() + ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getBottom() + ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.right = (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.getRight() + ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView bubbleRect top=" + this.jdField_a_of_type_AndroidGraphicsRect.top + ",left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + ",bottom=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + ",right=" + this.jdField_a_of_type_AndroidGraphicsRect.right);
      }
      if (!((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
      {
        bool1 = true;
        this.jdField_a_of_type_Dxq.a(bool1);
        if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString)) {
            break label1057;
          }
          localObject = this.jdField_b_of_type_Dxq;
          if (bool1) {
            break label1051;
          }
          bool2 = true;
          ((dxq)localObject).a(bool2);
        }
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
        i = localObject[1];
        n = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top + i;
        if (bool1) {
          break label1069;
        }
        i = localObject[0];
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left + i;
        k = i;
        if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
          break label1301;
        }
        localObject = a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
        j = localObject[0] - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
        m = localObject[1] + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
        k = i;
        i = m;
      }
    }
    for (;;)
    {
      label489:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mView master_x=" + k + ",master_y=" + n + ",mAttrsFirst.mRect.right=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mAttrsFirst.mRect.bottom=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight());
      }
      if ((k >= -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) && (k <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth()) && (n >= -this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom) && (n <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()))
      {
        k -= this.jdField_a_of_type_AndroidViewView.getLeft();
        m = n - this.jdField_a_of_type_AndroidViewView.getTop();
        if ((k != 0) || (m != 0))
        {
          this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k);
          this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mView.offsetLeftAndRight " + k + ",mView.offsetTopAndBottom " + m);
          }
        }
      }
      label749:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_b_of_type_AndroidViewView != null) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mLinkView x=" + j + ",y=" + i + ",mRect.right=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mRect.bottom=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight());
          }
          bool1 = bool3;
          if (j >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right)
          {
            bool1 = bool3;
            if (j <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth())
            {
              bool1 = bool3;
              if (i >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom)
              {
                bool1 = bool3;
                if (i <= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight())
                {
                  j -= this.jdField_b_of_type_AndroidViewView.getLeft();
                  i -= this.jdField_b_of_type_AndroidViewView.getTop();
                  if ((j == 0) && (i == 0)) {
                    break label1229;
                  }
                  this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(j);
                  this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(i);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mLinkView.offsetLeftAndRight " + j + ",mLinkView.offsetTopAndBottom " + i);
                  }
                }
              }
            }
          }
          for (;;)
          {
            bool1 = true;
            return bool1;
            bool1 = false;
            break;
            bool2 = false;
            break label309;
            this.jdField_b_of_type_Dxq.a(bool1);
            break label316;
            m = localObject[0] - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
            k = m;
            if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
              break label1301;
            }
            localObject = a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
            j = localObject[0] + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left;
            i = localObject[1] + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
            k = m;
            break label489;
            if (!QLog.isColorLevel()) {
              break label749;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mView dx=" + k + ",dy=" + m);
            break label749;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView mLinkView dx=" + j + ",dy=" + i);
            }
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new dxa(this));
          return false;
        }
        return bool1;
      }
      label1051:
      label1057:
      label1069:
      label1229:
      i = 0;
      label1301:
      j = 0;
    }
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      return new int[] { paramInt2, paramInt1 };
    case 0: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 6: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
    {
      paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  private void e()
  {
    c();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  protected void a(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_a_of_type_Dxq.a()) && (this.jdField_a_of_type_AndroidViewView.getBottom() > 0) && (this.jdField_a_of_type_AndroidViewView.getTop() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
        if ((!this.jdField_b_of_type_Dxq.a()) && (this.jdField_b_of_type_AndroidViewView.getBottom() > 0))
        {
          paramInt = j;
          if (this.jdField_b_of_type_AndroidViewView.getTop() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()) {
            break label112;
          }
        }
      }
      for (paramInt = 1;; paramInt = i)
      {
        label112:
        if (paramInt != 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new dxb(this));
        }
        return;
      }
    }
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    return a(this.jdField_a_of_type_Long);
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    int j = 1;
    int k = ((Integer)paramVarArgs[0]).intValue();
    long l = ((Long)paramVarArgs[1]).longValue();
    int i;
    if ((l != this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Int != k))
    {
      paramVarArgs = (Pair)paramVarArgs[2];
      if ((paramVarArgs == null) || (paramVarArgs.first == null) || (((BubbleInfo.CommonAttrs)paramVarArgs.first).jdField_a_of_type_ArrayOfJavaLangString == null)) {
        return false;
      }
      e();
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Int = k;
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramVarArgs.first);
      this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramVarArgs.second);
      this.jdField_a_of_type_Dxq.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
      if (k != 0)
      {
        paramVarArgs = this.jdField_a_of_type_Dxq;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean)
        {
          i = 1;
          paramVarArgs.a(i);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView = new dxc(this, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Dxq);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_Dxq.getIntrinsicWidth(), this.jdField_a_of_type_Dxq.getIntrinsicHeight());
        if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString != null))
        {
          this.jdField_b_of_type_Dxq.a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
          if (k != 0)
          {
            paramVarArgs = this.jdField_b_of_type_Dxq;
            if (!this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean) {
              break label391;
            }
            i = j;
            label292:
            paramVarArgs.a(i);
          }
          this.jdField_b_of_type_AndroidViewView = new dxe(this, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
          this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_Dxq);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
          this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_Dxq.getIntrinsicWidth(), this.jdField_b_of_type_Dxq.getIntrinsicHeight());
        }
      }
    }
    for (boolean bool = a(this.jdField_a_of_type_Long);; bool = false)
    {
      return bool;
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break;
      label391:
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break label292;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Dxq != null) {
      this.jdField_a_of_type_Dxq.a();
    }
    if (this.jdField_b_of_type_Dxq != null) {
      this.jdField_b_of_type_Dxq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.BubbleAnimation
 * JD-Core Version:    0.7.0.1
 */