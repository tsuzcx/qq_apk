package com.tencent.mobileqq.filemanager.activity;

import acbn;
import agbl;
import agbm;
import agnb;
import agnc;
import ahao;
import ahav;
import ahbo;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String TAG = "FileAssistantActivity<FileAssistant>";
  public List<agnc> AO = new ArrayList();
  public agnb a;
  public View.OnClickListener bJ = new agbm(this);
  boolean ccK;
  private AsyncTask d;
  XListView mListView;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_Agnb = null;
  }
  
  private void NQ(int paramInt)
  {
    Intent localIntent = null;
    switch (paramInt)
    {
    default: 
      if (paramInt == 7) {
        if (akI()) {
          a().dmc();
        }
      }
      break;
    }
    for (;;)
    {
      if (localIntent != null) {
        break label194;
      }
      return;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        break;
      }
      ahao.OS(2131721201);
      break;
      a().dma();
      finish();
      overridePendingTransition(2130772289, 2130772290);
      return;
      a().dme();
      continue;
      if (paramInt == 8) {
        if (akI()) {
          a().dmd();
        } else {
          a().dmf();
        }
      }
    }
    try
    {
      label194:
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
      localIntent.putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.amW());
      localIntent.putExtra("qrlogin_appid", this.Yg);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772289, 2130772290);
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
  }
  
  private void initAdapter()
  {
    this.AO.clear();
    getString(2131693547);
    getString(2131693536);
    getString(2131693608);
    getString(2131693506);
    getString(2131693551);
    String str1 = getString(2131693535);
    String str2 = getString(2131693565);
    String str3 = getString(2131693564);
    String str4 = getString(2131693537);
    Intent localIntent = getIntent();
    boolean bool2;
    boolean bool1;
    boolean bool3;
    if (localIntent != null)
    {
      bool2 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      bool3 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
    }
    for (;;)
    {
      if (bool2) {
        a(2131561010, 2130846240, 2, null, 0, false, 0, 1);
      }
      if (bool1) {
        a(2131561008, 2130845156, 0, str4, 0, false, 20, 2);
      }
      if (bool3) {
        a(2131560999, 2130846240, 1, null, 0, false, 0, 1);
      }
      a(2131561008, 2130845161, 0, str1, 0, false, 7, 3);
      if (ahav.k(this).containsKey("externalSdCard"))
      {
        a(2131561008, 2130845162, 0, str2, 0, false, 8, 3);
        a(2131561008, 2130845162, 0, str3, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_Agnb == null)
      {
        return;
        a(2131561008, 2130845162, 0, str2, 0, false, 8, 4);
      }
      this.jdField_a_of_type_Agnb.notifyDataSetChanged();
      dff();
      return;
      bool3 = true;
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    agnc localagnc = new agnc();
    localagnc.cYb = paramInt1;
    localagnc.iconId = paramInt2;
    localagnc.type = paramInt3;
    localagnc.name = paramString;
    localagnc.num = paramInt4;
    localagnc.isShowNum = paramBoolean;
    localagnc.category = paramInt5;
    localagnc.cPu = paramInt6;
    this.AO.add(localagnc);
  }
  
  public void dff()
  {
    if (this.d != null) {
      this.d.cancel(true);
    }
    this.d = new agbl(this).execute(new Void[0]);
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
    this.jdField_a_of_type_Agnb = new agnb(this, this.AO, this.bJ);
    this.mListView.setAdapter(this.jdField_a_of_type_Agnb);
    aC();
    initAdapter();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      this.ccK = localIntent.getBooleanExtra("select_file_only_docs_file", false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.ccK);
      if (this.ccK) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
      }
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!acbn.bkw.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      deR();
      return true;
      deL();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131693606);
      return true;
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131693606);
      break;
      NQ(localIntent.getIntExtra("category", 0));
    }
  }
  
  public void doOnDestroy()
  {
    if (this.d != null) {
      this.d.cancel(true);
    }
    this.d = null;
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */