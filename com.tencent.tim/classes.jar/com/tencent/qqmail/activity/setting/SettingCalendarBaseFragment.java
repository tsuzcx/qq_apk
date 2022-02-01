package com.tencent.qqmail.activity.setting;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMTopBar;

public class SettingCalendarBaseFragment
  extends QMBaseFragment
{
  protected SettingCalendarBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return null;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarBaseFragment
 * JD-Core Version:    0.7.0.1
 */