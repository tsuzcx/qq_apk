package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Build;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import btj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelAdapter
  extends PagerAdapter
{
  public ViewGroup a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ViewGroup b;
  private ViewGroup c;
  private ViewGroup d;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.c = paramViewGroup1;
    this.d = paramViewGroup2;
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
    return 3;
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
      localFrameLayout.setId(1000);
      localObject1 = (PressToChangeVoicePanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903470, null);
      ((PressToChangeVoicePanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d, this);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.toUpperCase().startsWith("HM NOTE")))
      {
        ((PressToChangeVoicePanel)localObject1).g();
        ((PressToChangeVoicePanel)localObject1).setVisibility(0);
        localObject2 = (ViewGroup)localFrameLayout.getParent();
        if (localObject2 != null) {
          break label205;
        }
        ((ViewGroup)paramView).addView(localFrameLayout);
        localObject1 = localFrameLayout;
      }
    }
    label205:
    do
    {
      do
      {
        do
        {
          return localObject1;
          ThreadManager.b().postDelayed(new btj(this), 100L);
          break;
          localObject1 = localFrameLayout;
        } while (localObject2 == paramView);
        ((ViewGroup)localObject2).removeView(localFrameLayout);
        ((ViewGroup)paramView).addView(localFrameLayout);
        return localFrameLayout;
        if (paramInt != 1) {
          break label455;
        }
        localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        localFrameLayout.setId(1001);
        localObject1 = (PressToSpeakPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903471, null);
        ((PressToSpeakPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d);
        localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903469, null);
        ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, 1);
        localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
        ((PressToSpeakPanel)localObject1).d();
        ((PressToSpeakPanel)localObject1).setVisibility(0);
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
      if (paramInt != 2) {
        break label677;
      }
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      localFrameLayout.setId(1002);
      localObject1 = (RecordSoundPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903472, null);
      ((RecordSoundPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d);
      localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2130903469, null);
      ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, 2);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((RecordSoundPanel)localObject1).d();
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
    label455:
    ((ViewGroup)localObject2).removeView(localFrameLayout);
    ((ViewGroup)paramView).addView(localFrameLayout);
    return localFrameLayout;
    label677:
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