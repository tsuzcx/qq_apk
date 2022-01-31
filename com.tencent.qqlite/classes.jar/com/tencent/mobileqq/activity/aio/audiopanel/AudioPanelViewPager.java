package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelViewPager
  extends ViewPager
{
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public AudioPanelViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AudioPanel paramAudioPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() == 1) {}
    try
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + paramMotionEvent);
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelViewPager
 * JD-Core Version:    0.7.0.1
 */