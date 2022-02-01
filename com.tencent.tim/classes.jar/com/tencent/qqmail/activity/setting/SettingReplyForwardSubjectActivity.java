package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.oss.KvHelper;

public class SettingReplyForwardSubjectActivity
  extends BaseActivityEx
{
  private static final String TAG = "SettingReplyForwardSubjectActivity";
  private final int ID_AUTO = 0;
  private final int ID_CHN = 1;
  private final int ID_ENG = 2;
  private final int ID_WITHOUT_ORIGIN = 1;
  private final int ID_WITH_ORIGIN = 0;
  private QMBaseView mSettingView;
  private QMRadioGroup.OnCheckedChangeListener onOriginCheckedChangeListener = new SettingReplyForwardSubjectActivity.2(this);
  private QMRadioGroup.OnCheckedChangeListener onSubjectCheckedChangeListener = new SettingReplyForwardSubjectActivity.1(this);
  private QMRadioGroup replyGroup;
  private QMRadioGroup subjectGroup;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingReplyForwardSubjectActivity.class);
  }
  
  private void createReplyWithOriginGroup()
  {
    this.replyGroup = new QMRadioGroup(this);
    this.replyGroup.setCaption(2131719945);
    this.mSettingView.addContentView(this.replyGroup);
    this.replyGroup.addItem(0, 2131719944);
    this.replyGroup.addItem(1, 2131719946);
    int i = QMSettingManager.sharedInstance().getReplyWithOriginType();
    this.replyGroup.commit();
    this.replyGroup.setOnCheckedChangeListener(this.onOriginCheckedChangeListener);
    this.replyGroup.setSelectedItem(i);
  }
  
  private void createSubjectGroup()
  {
    this.subjectGroup = new QMRadioGroup(this);
    this.subjectGroup.setCaption(2131719941);
    this.mSettingView.addContentView(this.subjectGroup);
    this.subjectGroup.addItem(0, 2131719940);
    this.subjectGroup.addItem(1, 2131719942);
    this.subjectGroup.addItem(2, 2131719943);
    int i = QMSettingManager.sharedInstance().getReplyForwardSubjectType();
    this.subjectGroup.commit();
    this.subjectGroup.setOnCheckedChangeListener(this.onSubjectCheckedChangeListener);
    this.subjectGroup.setSelectedItem(i);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719939);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void refreshOrigin(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      KvHelper.eventReplyWithOrigin(new double[0]);
      return;
    }
    KvHelper.eventReplyWithoutOrigin(new double[0]);
  }
  
  private void refreshSubject(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      KvHelper.eventReplyForwardSubjectUseAuto(new double[0]);
      return;
    case 1: 
      KvHelper.eventReplyForwardSubjectUseChn(new double[0]);
      return;
    }
    KvHelper.eventReplyForwardSubjectUseEng(new double[0]);
  }
  
  private void saveReplyForwardSubjectType(int paramInt)
  {
    QMSettingManager.sharedInstance().setReplyForwardSubjectType(paramInt);
  }
  
  private void saveReplyOriginType(int paramInt)
  {
    QMSettingManager.sharedInstance().setReplyWithOriginType(paramInt);
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createSubjectGroup();
    createReplyWithOriginGroup();
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingReplyForwardSubjectActivity
 * JD-Core Version:    0.7.0.1
 */