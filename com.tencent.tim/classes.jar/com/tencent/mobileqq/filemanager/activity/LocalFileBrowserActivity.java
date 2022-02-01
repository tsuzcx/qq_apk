package com.tencent.mobileqq.filemanager.activity;

import acbn;
import agca;
import agcb;
import agcc;
import agcd;
import agce;
import agcf;
import agcg;
import agch;
import agci;
import agcl;
import agcm;
import agnc;
import agnh;
import ahaf;
import ahav;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqhq;
import ausj;
import auss;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String TAG = "LocalFileBrowserActivity<FileAssistant>";
  public agnh a;
  public NoFileRelativeLayout a;
  String bGy;
  EditText bg = null;
  public SlideDetectListView c = null;
  public int cWH = -1;
  boolean ccK;
  public boolean ccS = false;
  boolean ccT = true;
  public String currentPath;
  private AsyncTask d;
  public View.OnClickListener eQ = new agce(this);
  public View.OnClickListener eR = new agcl(this);
  public View.OnLongClickListener f = new agci(this);
  public BaseActivity h;
  LinearLayout iT = null;
  public BubblePopupWindow k = null;
  public Map<String, Integer> kv = new HashMap();
  public int lN = 0;
  protected AdapterView.c mOnItemClickListener = new agcb(this);
  TextView mTitleView;
  public ArrayList<FileInfo> wA = new ArrayList();
  TextView y;
  
  public LocalFileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_Agnh = null;
  }
  
  private void NS(int paramInt)
  {
    refreshList();
    this.c.setSelected(true);
    this.c.setSelection(paramInt);
    this.c.setSelected(true);
    this.c.post(new LocalFileBrowserActivity.12(this, paramInt));
  }
  
  private void aC()
  {
    this.bGk = getString(agnc.hu(this.lN));
    setTitle(this.bGk);
    if (this.mTitleView == null) {
      this.mTitleView = ((TextView)findViewById(2131369627));
    }
    this.y = this.leftView;
    if (this.y != null) {
      this.y.setOnClickListener(new agcm(this));
    }
    this.y = this.leftView;
  }
  
  private void aC(boolean paramBoolean, String paramString)
  {
    this.d = new agcc(this, paramBoolean).execute(new String[] { paramString });
  }
  
  private boolean akU()
  {
    if (((this.lN == 8) || (this.lN == 11)) && (this.currentPath.equals(this.bGy))) {
      return super.onBackEvent();
    }
    if (this.lN == 6) {
      return super.onBackEvent();
    }
    if (this.lN == 23)
    {
      finish();
      return false;
    }
    String str = new VFSFile(this.currentPath).getParent();
    if (str != null)
    {
      cg(str, false);
      return false;
    }
    return super.onBackEvent();
  }
  
  private void cg(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {
        break label15;
      }
    }
    label15:
    do
    {
      return;
      do
      {
        VFSFile localVFSFile = new VFSFile(str);
        paramString = str;
        if (localVFSFile.exists()) {
          break;
        }
        paramString = localVFSFile.getParent();
        str = paramString;
      } while (paramString != null);
    } while (paramString == null);
    if (paramBoolean)
    {
      int i = this.c.getFirstVisiblePosition();
      this.kv.put(this.currentPath, Integer.valueOf(i));
      this.currentPath = paramString;
      this.bg.setText(this.currentPath);
      switch (this.lN)
      {
      }
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.cancel(true);
      }
      aC(paramBoolean, paramString);
      return;
      if (!this.kv.containsKey(this.currentPath)) {
        break;
      }
      this.kv.remove(this.currentPath);
      break;
      if (this.currentPath.equalsIgnoreCase(this.bGy)) {
        this.y.setText(2131693606);
      } else {
        this.y.setText(2131693860);
      }
    }
  }
  
  private void dfs()
  {
    switch (this.lN)
    {
    }
    for (;;)
    {
      this.bGy = this.currentPath;
      return;
      this.currentPath = ahaf.a().vZ();
      continue;
      this.currentPath = acbn.SDCARD_ROOT;
      continue;
      this.currentPath = "/";
      continue;
      File localFile = (File)ahav.k(this).get("externalSdCard");
      if (localFile == null) {
        this.currentPath = "/";
      } else {
        this.currentPath = localFile.getPath();
      }
    }
  }
  
  private void dft()
  {
    Object localObject = ahaf.a().vZ();
    String str = ahaf.a().wa();
    VFSFile localVFSFile = new VFSFile((String)localObject);
    if (!aqhq.fileExists((String)localObject)) {
      localVFSFile.mkdirs();
    }
    localObject = new VFSFile(str);
    if (!aqhq.fileExists(str)) {
      ((VFSFile)localObject).mkdirs();
    }
  }
  
  private void initListView()
  {
    this.c = ((SlideDetectListView)findViewById(2131370595));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131372417));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131693124);
    this.c.setOnItemClickListener(this.mOnItemClickListener);
    this.c.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if ((this.lN == 7) || (this.lN == 8) || (this.lN == 11))
    {
      IN(false);
      return;
    }
    this.jdField_a_of_type_Agnh.a(this.c);
    this.c.setOnSlideListener(new agcd(this));
  }
  
  private void refreshList()
  {
    if (this.wA.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agnh.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
  }
  
  public void bP()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getResources().getStringArray(2130968637)[1], 3);
    localausj.a(new agcf(this, localausj));
    localausj.setOnDismissListener(new agcg(this));
    localausj.setOnCancelListener(new agch(this));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561014);
    paramBundle = getIntent();
    this.lN = paramBundle.getBundleExtra("bundle").getInt("category");
    this.ccS = paramBundle.getBooleanExtra("open_with_qq_images", false);
    this.h = this;
    dfs();
    dft();
    aC();
    this.bg = ((EditText)findViewById(2131365551));
    this.iT = ((LinearLayout)findViewById(2131370502));
    this.jdField_a_of_type_Agnh = new agnh(this, this.wA, this);
    initListView();
    this.c.setAdapter(this.jdField_a_of_type_Agnh);
    this.c.setOnItemClickListener(this.mOnItemClickListener);
    this.c.setOnScrollToTopListener(new agca(this));
    cg(this.currentPath, true);
    if (this.lN == 6) {
      this.iT.setVisibility(8);
    }
    if (paramBundle.getIntExtra("localSdCardfile", -1) != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      deL();
    }
    this.ccK = paramBundle.getBooleanExtra("select_file_only_docs_file", false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.ccK);
    if (this.ccK) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
    }
    deR();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.d != null) {
      this.d.cancel(true);
    }
    this.d = null;
    super.doOnDestroy();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    akU();
  }
  
  public void refreshUI()
  {
    refreshList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */