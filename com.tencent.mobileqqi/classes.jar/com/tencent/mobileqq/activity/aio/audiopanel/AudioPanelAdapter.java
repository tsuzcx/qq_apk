package com.tencent.mobileqq.activity.aio.audiopanel;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelAdapter
  extends PagerAdapter
{
  public ViewGroup a;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ViewGroup b;
  private ViewGroup c;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, ChatActivity paramChatActivity, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.b = paramViewGroup1;
    this.c = paramViewGroup2;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (View)paramObject;
      ((ViewGroup)paramView).removeView(paramObject);
    } while (!QLog.isColorLevel());
    QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.destroyItem() is called,position is:" + paramInt);
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.instantiateItem() is called,position is:" + paramInt);
    }
    if (paramInt == 0)
    {
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
      Object localObject = (PressToSpeakPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).inflate(2130903540, null);
      ((PressToSpeakPanel)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, this.c);
      ListenPanel localListenPanel = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).inflate(2130903539, null);
      localListenPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, 1);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView(localListenPanel, new FrameLayout.LayoutParams(-1, -1));
      ((PressToSpeakPanel)localObject).c();
      ((PressToSpeakPanel)localObject).setVisibility(0);
      localListenPanel.setVisibility(8);
      localObject = (ViewGroup)localFrameLayout.getParent();
      if (localObject == null) {
        ((ViewGroup)paramView).addView(localFrameLayout);
      }
      while (localObject == paramView) {
        return localFrameLayout;
      }
      ((ViewGroup)localObject).removeView(localFrameLayout);
      ((ViewGroup)paramView).addView(localFrameLayout);
      return localFrameLayout;
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramView, paramInt, paramObject);
    if ((paramObject instanceof ViewGroup)) {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter
 * JD-Core Version:    0.7.0.1
 */