package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

public class GameContentView
  extends LinearLayout
{
  GameSessionView jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  private a jdField_b_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a;
  
  public GameContentView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GameContentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameContentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void dqp()
  {
    this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView = ((GameSessionView)findViewById(2131370676));
    if (this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView.a(BaseApplicationImpl.getApplication().getRuntime(), this.jdField_b_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a);
    }
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131559361, this);
  }
  
  public int EZ()
  {
    return getHeight();
  }
  
  public void dqo()
  {
    this.jdField_b_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a = null;
  }
  
  public void init()
  {
    dqp();
  }
  
  public void onDestory()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
      this.jdField_b_of_type_ComTencentMobileqqGamecenterViewGameSessionView.onDestory();
    }
  }
  
  public void setUiRefresh(a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dqk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.GameContentView
 * JD-Core Version:    0.7.0.1
 */