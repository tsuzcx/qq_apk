package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract class SelectMemberInnerFrame
  extends InnerFrame
{
  public LayoutInflater a;
  public InnerFrameManager a;
  public SelectMemberActivity a;
  public QQAppInterface a;
  
  public SelectMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract String a();
  
  public abstract List a();
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)a());
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater();
  }
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */