package com.tencent.tim.filemanager.activity;

import acbn;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import atoa;
import atob;
import atwc;
import atwd;
import auds;
import audt;
import audx;
import auej;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String TAG = "FileAssistantActivity<FileAssistant>";
  public List<atwd> AO = new ArrayList();
  public atwc a;
  private boolean aWg;
  public View.OnClickListener bJ = new atob(this);
  public boolean dit;
  XListView mListView;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_Atwc = null;
  }
  
  private void NQ(int paramInt)
  {
    Intent localIntent = null;
    switch (paramInt)
    {
    default: 
      if (paramInt == 7) {
        if (!this.aWg) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (localIntent != null) {
        break label318;
      }
      return;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        localIntent.putExtra("is_using_cloud_bottom_bar", getIntent().getBooleanExtra("is_using_cloud_bottom_bar", false));
        localIntent.putExtra("from_cloud_file", this.dit);
        if (getIntent().hasExtra("is_using_cloud_bottom_bar"))
        {
          localIntent.putExtra("is_using_cloud_bottom_bar", getIntent().getBooleanExtra("is_using_cloud_bottom_bar", false));
          if (getIntent().hasExtra("key_parent_dir_name")) {
            localIntent.putExtra("key_parent_dir_name", getIntent().getStringExtra("key_parent_dir_name"));
          }
          if (getIntent().hasExtra("key_parent_dir_key")) {
            localIntent.putExtra("key_parent_dir_key", getIntent().getByteArrayExtra("key_parent_dir_key"));
          }
          localIntent.putExtra("key_bottom_bar_left_action", getIntent().getIntExtra("key_bottom_bar_left_action", 0));
          localIntent.putExtra("key_bottom_bar_right_action", getIntent().getIntExtra("key_bottom_bar_right_action", 0));
        }
        localIntent.putExtra("leftViewText", getString(2131693607));
        break;
      }
      auds.OS(2131721201);
      break;
      a().dma();
      finish();
      overridePendingTransition(2130772039, 2130772040);
      return;
      if (((paramInt != 8) && (paramInt != 8)) || (!akI())) {}
    }
    try
    {
      label318:
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("category", paramInt);
      localIntent.putExtra("bundle", (Bundle)localObject);
      localObject = getIntent();
      boolean bool = ((Intent)localObject).getBooleanExtra("STRING_SingleSelect", false);
      localIntent.putExtra("localSdCardfile", ((Intent)localObject).getIntExtra("localSdCardfile", -1));
      if (bool) {
        localIntent.putExtra("STRING_SingleSelect", bool);
      }
      localObject = ((Intent)localObject).getStringArrayExtra("STRING_Show_Within_Suffixs");
      if (localObject != null) {
        localIntent.putExtra("STRING_Show_Within_Suffixs", (String[])localObject);
      }
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772039, 2130772040);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aC()
  {
    this.bGk = getString(2131693606);
    setTitle(this.bGk);
    deL();
  }
  
  private void initAdapter()
  {
    this.AO.clear();
    String str1 = getString(2131693547);
    String str2 = getString(2131693536);
    String str3 = getString(2131693608);
    String str4 = getString(2131693506);
    String str5 = getString(2131693551);
    String str6 = getString(2131693535);
    String str7 = getString(2131693565);
    String str8 = getString(2131693564);
    String str9 = getString(2131693537);
    Intent localIntent = getIntent();
    boolean bool7;
    boolean bool6;
    boolean bool5;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    boolean bool4;
    if (localIntent != null)
    {
      bool7 = localIntent.getBooleanExtra("STRING_Show_Music_Category", true);
      bool6 = localIntent.getBooleanExtra("STRING_Show_Video_Category", true);
      bool5 = localIntent.getBooleanExtra("STRING_Show_Apk_Category", true);
      bool3 = localIntent.getBooleanExtra("STRING_Show_Pic_Category", true);
      bool2 = localIntent.getBooleanExtra("STRING_Show_Download_Category", true);
      localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      boolean bool8 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
      bool4 = bool2;
      bool2 = bool1;
      bool1 = bool8;
    }
    for (;;)
    {
      if (bool3) {
        a(2131561008, 2130845160, 0, str1, audt.at(this), true, 10, 2);
      }
      if (bool7) {
        a(2131561008, 2130845158, 0, str2, audt.bz(this), true, 1, 3);
      }
      if (bool6) {
        a(2131561008, 2130845163, 0, str3, audt.bA(this), true, 2, 3);
      }
      if (bool5) {
        a(2131561008, 2130845153, 0, str4, 0, true, 4, 4);
      }
      if (bool2) {
        a(2131561008, 2130845156, 0, str9, 0, false, 20, 2);
      }
      if (bool1) {
        a(2131560999, 2130846240, 1, null, 0, false, 0, 1);
      }
      if (bool4) {
        a(2131561008, 2130845155, 0, str5, 0, false, 6, 2);
      }
      a(2131561008, 2130845161, 0, str6, 0, false, 7, 3);
      if (audx.k(this).containsKey("externalSdCard"))
      {
        a(2131561008, 2130845162, 0, str7, 0, false, 8, 3);
        a(2131561008, 2130845162, 0, str8, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_Atwc == null)
      {
        return;
        a(2131561008, 2130845162, 0, str7, 0, false, 8, 4);
      }
      this.jdField_a_of_type_Atwc.notifyDataSetChanged();
      dff();
      return;
      bool1 = true;
      bool2 = false;
      bool4 = true;
      bool5 = true;
      bool6 = true;
      bool7 = true;
      bool3 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    atwd localatwd = new atwd();
    localatwd.cYb = paramInt1;
    localatwd.iconId = paramInt2;
    localatwd.type = paramInt3;
    localatwd.name = paramString;
    localatwd.num = paramInt4;
    localatwd.isShowNum = paramBoolean;
    localatwd.category = paramInt5;
    localatwd.cPu = paramInt6;
    this.AO.add(localatwd);
  }
  
  public void dff()
  {
    new atoa(this).execute(new Void[0]);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (paramInt2 == 5) {
        a().dmb();
      }
      return;
    }
    initAdapter();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561012);
    this.mListView = ((XListView)findViewById(2131370830));
    this.jdField_a_of_type_Atwc = new atwc(this, this.AO, this.bJ);
    this.mListView.setAdapter(this.jdField_a_of_type_Atwc);
    aC();
    initAdapter();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!acbn.bkw.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      this.dit = localIntent.getBooleanExtra("from_cloud_file", false);
      this.aWg = localIntent.getBooleanExtra("from_aio", false);
      deR();
      return true;
      deL();
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      this.bGk = getString(2131693606);
      return true;
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      this.bGk = getString(2131693607);
      break;
      NQ(localIntent.getIntExtra("category", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */