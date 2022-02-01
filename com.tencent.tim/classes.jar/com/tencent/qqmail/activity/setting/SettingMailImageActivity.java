package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingMailImageActivity
  extends BaseActivityEx
{
  private static final String TAG = "SettingMailImageActivity";
  private final int ID_ALL = 0;
  private final int ID_NONE = 2;
  private final int ID_WIFI = 1;
  private QMRadioGroup mRadioGroup;
  private QMBaseView mSettingView;
  private QMRadioGroup.OnCheckedChangeListener onCheckedChangeListener = new SettingMailImageActivity.1(this);
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingMailImageActivity.class);
  }
  
  private void createRadioGroup()
  {
    this.mRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mRadioGroup);
    this.mRadioGroup.addItem(0, 2131719876);
    this.mRadioGroup.addItem(1, 2131719878);
    this.mRadioGroup.addItem(2, 2131719877);
    int i = QMSettingManager.sharedInstance().getMailLoadImgType();
    refreshDescription(i);
    this.mRadioGroup.commit();
    this.mRadioGroup.setOnCheckedChangeListener(this.onCheckedChangeListener);
    this.mRadioGroup.setSelectedItem(i);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719886);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void refreshDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mRadioGroup.setDescription(2131719931);
      return;
    case 1: 
      this.mRadioGroup.setDescription(2131719933);
      return;
    }
    this.mRadioGroup.setDescription(2131719932);
  }
  
  private void saveMailImage(int paramInt)
  {
    QMSettingManager.sharedInstance().setMailLoadImgType(paramInt);
    QMMailManager.sharedInstance().setLoadImgType(paramInt);
    DataCollector.logStatus("AppStat_is_Load_Image", String.valueOf(paramInt));
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createRadioGroup();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailImageActivity
 * JD-Core Version:    0.7.0.1
 */