package com.tencent.tim.teamwork;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqha;
import aqiw;
import aqju;
import aqmj;
import aqnm;
import audx;
import auks;
import aukt;
import auku;
import aukx;
import aulg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

public class TeamWorkFileImportActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private View HC;
  private View HD;
  private TextView ZH;
  private TextView ZI;
  private aukx jdField_a_of_type_Aukx;
  private AutoVerticalScrollTextView jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView;
  aulg b = new auks(this);
  private TeamWorkFileImportInfo c;
  public String cIx = "";
  private int dNN = 1;
  public Handler handler;
  private String[] hh = new String[2];
  ValueAnimator.AnimatorUpdateListener j = new auku(this);
  private aqju m;
  
  private void Zo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      localBundle.putParcelable("key_team_work_file_import_info", this.c);
      localBundle.putBoolean("temp_preview_from_qq", true);
      localBundle.putString("tdsourcetag", "s_tim_aio_edit");
      TeamWorkDocEditBrowserActivity.a(BaseApplicationImpl.getApplication(), localBundle, false);
      finish();
    }
  }
  
  private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo1, TeamWorkFileImportInfo paramTeamWorkFileImportInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTeamWorkFileImportInfo1 != null)
    {
      bool1 = bool2;
      if (paramTeamWorkFileImportInfo2 != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo1.fileName))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo2.fileName))
          {
            bool1 = bool2;
            if (paramTeamWorkFileImportInfo1.fileName.equals(paramTeamWorkFileImportInfo2.fileName))
            {
              bool1 = bool2;
              if (paramTeamWorkFileImportInfo1.fileSize == paramTeamWorkFileImportInfo2.fileSize) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TeamWorkFileImportActivity", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  private void evt()
  {
    this.dNN = 4;
    this.ZI.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
    this.HD.setVisibility(8);
    this.HC.setVisibility(0);
  }
  
  private void evu()
  {
    dUd();
    Object localObject = getString(2131720930);
    String str = getString(2131694716);
    this.m = aqha.a(this, 230).setMessage((CharSequence)localObject);
    localObject = this.m.getMessageTextView();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.gravity = 17;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    this.m.setPositiveButton(str, new aukt(this));
    this.m.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563165);
    this.HC = findViewById(2131379278);
    this.ZH = ((TextView)findViewById(2131379274));
    this.HD = findViewById(2131379279);
    this.ZI = ((TextView)findViewById(2131379280));
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView = ((AutoVerticalScrollTextView)findViewById(2131379276));
    this.hh[0] = getString(2131720906);
    this.hh[1] = getString(2131720907);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setTextArray(this.hh);
    this.handler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aukx = ((aukx)this.app.getBusinessHandler(120));
    this.jdField_a_of_type_Aukx.QH(false);
    this.app.addObserver(this.b);
    initData();
    paramBundle = (LinearLayout)LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131563161, this.titleRoot, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.bottomMargin = aqnm.dpToPx(12.0F);
    this.titleRoot.addView(paramBundle, localLayoutParams);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.b);
    if (this.handler != null)
    {
      this.handler.removeMessages(7001);
      this.handler.removeMessages(7002);
    }
    if (this.jdField_a_of_type_Aukx != null) {
      this.jdField_a_of_type_Aukx.QH(true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView != null) {
      this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.destroy();
    }
    this.j = null;
    dUd();
    this.handler = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.i("TeamWorkFileImportActivity", 2, "-------MSG_START_ANIMATION-----");
        continue;
        Zo(this.cIx);
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkFileImportActivity", 2, "-------MSG_NEXT_SECOND_ANIMATION mFileImportStatus : " + this.dNN + " ------");
        }
        this.handler.removeMessages(7002);
      }
    }
  }
  
  public void initData()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getBundleExtra("key_team_work_file_import_info_bundle");
      if (localObject != null) {
        this.c = ((TeamWorkFileImportInfo)((Bundle)localObject).getParcelable("key_team_work_file_import_info"));
      }
      if (this.c != null)
      {
        audx.fM(this.c.fileName);
        this.ZI.setText(getString(2131720924));
        this.dNN = 2;
        this.centerView.setText(this.c.fileName);
        if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
          break label266;
        }
        if (this.c.fileSize <= 20971520L) {
          break label127;
        }
        evt();
        this.ZH.setText(getString(2131720915));
      }
    }
    return;
    label127:
    if (this.jdField_a_of_type_Aukx.a(this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportActivity", 2, "---isFileImporting, fileName： " + this.c.fileName + " ---");
      }
      this.handler.sendEmptyMessageDelayed(7002, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkFileImportActivity", 2, "---FileImport start, fileName： " + this.c.fileName + " ---");
    }
    this.handler.sendEmptyMessageDelayed(7001, 0L);
    this.jdField_a_of_type_Aukx.c(this.c);
    return;
    label266:
    QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
    evt();
  }
  
  public boolean onBackEvent()
  {
    if (this.dNN == 2)
    {
      if (aqmj.c(this.app.getApp(), this.app.getCurrentAccountUin(), "team_work_file_importing_tips_show", true))
      {
        evu();
        return true;
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportActivity
 * JD-Core Version:    0.7.0.1
 */