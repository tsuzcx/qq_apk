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
  private QQAppInterface app;
  public AudioPanel b;
  private boolean beU;
  private BaseChatPie c;
  private ViewGroup dc;
  public ViewGroup de;
  private ViewGroup df;
  private ViewGroup dg;
  public ViewGroup dh;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.app = paramQQAppInterface;
    this.c = paramBaseChatPie;
    this.b = paramAudioPanel;
    this.dc = paramViewGroup1;
    this.df = paramViewGroup2;
    this.dg = paramViewGroup3;
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
    if (this.beU) {
      return 1;
    }
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
    if ((this.c.aSM) || (paramInt == 0))
    {
      localFrameLayout = new FrameLayout(this.app.getApp());
      localFrameLayout.setId(1001);
      localObject1 = (PressToSpeakPanel)LayoutInflater.from(this.app.getApp()).inflate(2131561186, null);
      ((PressToSpeakPanel)localObject1).a(this.app, this.c, localFrameLayout, this.b, this.dc, this.df, this.dg);
      localObject2 = (ListenPanel)LayoutInflater.from(this.app.getApp()).inflate(2131561183, null);
      ((ListenPanel)localObject2).a(this.app, this.c, localFrameLayout, this.b, this.dc, 1);
      ((ListenPanel)localObject2).setNeedAudioData(true);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((PressToSpeakPanel)localObject1).reset();
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
      localFrameLayout = new FrameLayout(this.app.getApp());
      localFrameLayout.setId(1002);
      localObject1 = (RecordSoundPanel)LayoutInflater.from(this.app.getApp()).inflate(2131561189, null);
      ((RecordSoundPanel)localObject1).a(this.app, this.c, localFrameLayout, this.b, this.dc, this.df, this.dg);
      localObject2 = (ListenPanel)LayoutInflater.from(this.app.getApp()).inflate(2131561183, null);
      ((ListenPanel)localObject2).a(this.app, this.c, localFrameLayout, this.b, this.dc, 2);
      ((ListenPanel)localObject2).setNeedAudioData(true);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((RecordSoundPanel)localObject1).reset();
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
      this.de = ((ViewGroup)paramObject);
    }
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.beU = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter
 * JD-Core Version:    0.7.0.1
 */