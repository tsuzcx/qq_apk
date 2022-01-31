package com.tencent.mobileqq.activity.aio.audiopanel;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelAdapter
  extends PagerAdapter
{
  public ViewGroup a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ViewGroup b;
  private ViewGroup c;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
    return 2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.instantiateItem() is called,position is:" + paramInt);
    }
    FrameLayout localFrameLayout;
    Object localObject1;
    Object localObject2;
    if (paramInt == 0)
    {
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      localObject1 = (PressToSpeakPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903463, null);
      ((PressToSpeakPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, this.c);
      localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903462, null);
      ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, 1);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((PressToSpeakPanel)localObject1).g();
      ((PressToSpeakPanel)localObject1).setVisibility(0);
      ((ListenPanel)localObject2).setVisibility(8);
      localObject2 = (ViewGroup)localFrameLayout.getParent();
      if (localObject2 == null)
      {
        ((ViewGroup)paramView).addView(localFrameLayout);
        localObject1 = localFrameLayout;
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localFrameLayout;
      } while (localObject2 == paramView);
      ((ViewGroup)localObject2).removeView(localFrameLayout);
      ((ViewGroup)paramView).addView(localFrameLayout);
      return localFrameLayout;
      if (paramInt != 1) {
        break;
      }
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      localObject1 = (RecordSoundPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903464, null);
      ((RecordSoundPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, this.c);
      localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903462, null);
      ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.b, 2);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((RecordSoundPanel)localObject1).g();
      ((RecordSoundPanel)localObject1).setVisibility(0);
      ((ListenPanel)localObject2).setVisibility(8);
      localObject2 = (ViewGroup)localFrameLayout.getParent();
      if (localObject2 == null)
      {
        ((ViewGroup)paramView).addView(localFrameLayout);
        return localFrameLayout;
      }
      localObject1 = localFrameLayout;
    } while (localObject2 == paramView);
    ((ViewGroup)localObject2).removeView(localFrameLayout);
    ((ViewGroup)paramView).addView(localFrameLayout);
    return localFrameLayout;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter
 * JD-Core Version:    0.7.0.1
 */