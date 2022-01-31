package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class ChatXListView
  extends FPSXListView
{
  int jdField_a_of_type_Int;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private boolean jdField_a_of_type_Boolean = false;
  private long g;
  
  public ChatXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if ((paramContext instanceof ChatActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = ((ChatActivity)paramContext);
    }
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    super.offsetChildrenTopAndBottom(paramInt);
    if (paramInt != 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.i(paramInt);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.g;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(l1 - l2);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if (paramInt1 != 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.i(-paramInt1);
    }
  }
  
  public void setStartTime(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */