package com.tencent.tim.filemanager.activity.fileassistant;

import aghw;
import agkh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqiw;
import atqt;
import atqu;
import atqv;
import atsn;
import atwc;
import atwd;
import auds;
import audw;
import audw.b;
import avhc;
import awph;
import awpk;
import awpk.a;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;

public class QfileFileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String TAG = "FileAssistantActivity<FileAssistant>";
  List<atwd> AO = new ArrayList();
  atwc jdField_a_of_type_Atwc = null;
  private awpk.a jdField_a_of_type_Awpk$a = new atqv(this);
  private awpk jdField_a_of_type_Awpk;
  BroadcastMain jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain;
  public View.OnClickListener bJ = new atqt(this);
  public boolean cdf = false;
  private atsn d = new atqu(this);
  LayoutInflater mInflater = null;
  XListView mListView;
  private volatile boolean mPaused;
  TextView mTitle;
  
  private void aC()
  {
    this.mTitle = this.centerView;
    setTitle(2131693604);
    deL();
  }
  
  private void dfV()
  {
    this.app.a().gK("0X800474E", 1);
    avhc.c(this, 2, null);
  }
  
  private void dfX()
  {
    this.jdField_a_of_type_Awpk = new awpk();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Awpk);
    awph.gz(this.app.getApplication());
  }
  
  private void dfY()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void dfZ()
  {
    this.mPaused = false;
    if (this.app.a().hasQueriedVerifyPassword() == true)
    {
      this.app.a().dfZ();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    auds.JD(BaseApplication.getContext().getString(2131696270));
  }
  
  private void euu()
  {
    if (this.jdField_a_of_type_Awpk == null) {
      return;
    }
    int i = this.jdField_a_of_type_Awpk.getState();
    Iterator localIterator = this.AO.iterator();
    while (localIterator.hasNext())
    {
      atwd localatwd = (atwd)localIterator.next();
      if (localatwd.category == 16)
      {
        if (i == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "AlbumBackup:updateBackupInfo, upload state");
          }
          localatwd.state = getResources().getString(2131721854);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "AlbumBackup:updateBackupInfo, other state");
          }
          localatwd.state = null;
        }
      }
      else if (localatwd.category == 13) {
        localatwd.cev = this.app.a().alc();
      }
    }
    this.jdField_a_of_type_Atwc.notifyDataSetChanged();
  }
  
  private void gb()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initAdapter()
  {
    String str1 = getString(2131719485);
    String str2 = getString(2131721791);
    String str3 = getString(2131721848);
    String str4 = getString(2131693508);
    String str5 = getString(2131693533);
    String str6 = getString(2131693551);
    String str7 = getString(2131693537);
    getString(2131693582);
    a(2131561007, 2130845072, 0, str1, 0, false, 12, "offline", 2, true, false);
    a(2131561007, 2130851982, 0, str3, 0, false, 16, "offline", 4, true, false);
    a(2131561031, 2130846240, 1, str7, 0, true, 0, "other", 1, false, false);
    a(2131561008, 2130845157, 0, str6, 0, false, 13, "picture", 3, false, false);
    a(2131561008, 2130845159, 0, str5, 0, false, 15, "other", 3, false, false);
    a(2131561008, 2130840065, 0, str2, 0, false, 19, "music", 3, false, false);
    a(2131561008, 2130845154, 0, str4, 0, false, 14, "music", 4, false, false);
    this.jdField_a_of_type_Atwc.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    atwd localatwd = new atwd();
    localatwd.cYb = paramInt1;
    localatwd.iconId = paramInt2;
    localatwd.type = paramInt3;
    localatwd.name = paramString1;
    localatwd.num = paramInt4;
    localatwd.isShowNum = paramBoolean1;
    localatwd.category = paramInt5;
    localatwd.categoryId = paramString2;
    localatwd.cPu = paramInt6;
    localatwd.ceu = paramBoolean2;
    localatwd.cev = paramBoolean3;
    this.AO.add(localatwd);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561012);
    this.cdf = getIntent().getBooleanExtra("COMEFROMDESK", false);
    this.mInflater = LayoutInflater.from(getActivity());
    this.mListView = ((XListView)findViewById(2131370830));
    this.jdField_a_of_type_Atwc = new atwc(this, this.AO, this.bJ);
    this.mListView.setAdapter(this.jdField_a_of_type_Atwc);
    aC();
    initAdapter();
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain = new BroadcastMain();
    registerReceiver(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain, new IntentFilter("com.tencent.mobileqq.process.stopping"));
    paramBundle = new audw.b();
    paramBundle.bJE = "file_asst_in";
    paramBundle.cYX = 11;
    audw.a(this.app.getCurrentAccountUin(), paramBundle);
    this.app.a().addObserver(this.d);
    dfX();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
    awph.gA(this.app.getApplication());
    this.jdField_a_of_type_Awpk.a(null);
    unregisterReceiver(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mPaused = true;
    this.jdField_a_of_type_Awpk.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    euu();
    this.jdField_a_of_type_Awpk.a(this.jdField_a_of_type_Awpk$a);
    if ((this.AO == null) || (this.AO.size() == 0)) {
      return;
    }
    String str = getString(2131693582);
    Iterator localIterator = this.AO.iterator();
    while (localIterator.hasNext()) {
      if (str.equalsIgnoreCase(((atwd)localIterator.next()).name) == true) {
        return;
      }
    }
    ThreadManager.executeOnFileThread(new QfileFileAssistantActivity.1(this));
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public class BroadcastMain
    extends BroadcastReceiver
  {
    public BroadcastMain() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext.getSharedPreferences("Offline_Flags", 0).edit().clear().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.fileassistant.QfileFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */