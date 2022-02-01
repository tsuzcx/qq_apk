package com.tencent.tim.filemanager.activity;

import acbn;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqhq;
import atom;
import aton;
import atoo;
import atop;
import atoq;
import ator;
import atos;
import atot;
import atou;
import atov;
import atoy;
import atoz;
import atwd;
import atwf;
import audn;
import audx;
import ausj;
import auss;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.tim.filemanager.widget.NoFileRelativeLayout;
import com.tencent.tim.filemanager.widget.SendBottomBar;
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
  public atwf a;
  public NoFileRelativeLayout a;
  TextView afg = null;
  String bGy;
  public SlideDetectListView c = null;
  public int cWH = -1;
  public String currentPath;
  public boolean dit;
  public View.OnClickListener eQ = new ator(this);
  public View.OnClickListener eR = new atoy(this);
  public View.OnLongClickListener f = new atov(this);
  public BaseActivity h;
  LinearLayout iT = null;
  public BubblePopupWindow k = null;
  public Map<String, Integer> kv = new HashMap();
  public int lN = 0;
  protected AdapterView.c mOnItemClickListener = new aton(this);
  TextView mTitleView;
  public ArrayList<FileInfo> wA = new ArrayList();
  TextView y;
  
  public LocalFileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_Atwf = null;
  }
  
  private void NS(int paramInt)
  {
    refreshList();
    this.c.setSelected(true);
    this.c.setSelection(paramInt);
    this.c.setSelected(true);
    this.c.post(new LocalFileBrowserActivity.13(this, paramInt));
  }
  
  private void aC()
  {
    this.bGk = getString(atwd.hu(this.lN));
    setTitle(this.bGk);
    if (this.mTitleView == null) {
      this.mTitleView = ((TextView)findViewById(2131369627));
    }
    this.y = this.leftView;
    if (this.y != null) {
      this.y.setOnClickListener(new atoz(this));
    }
    this.y = this.leftView;
  }
  
  private boolean akU()
  {
    if (((this.lN == 8) || (this.lN == 11)) && (this.currentPath.equals(this.bGy))) {
      return super.onBackEvent();
    }
    if (this.lN == 6) {
      return super.onBackEvent();
    }
    String str = new File(this.currentPath).getParent();
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
        File localFile = new File(str);
        paramString = str;
        if (localFile.exists()) {
          break;
        }
        paramString = localFile.getParent();
        str = paramString;
      } while (paramString != null);
    } while (paramString == null);
    if (paramBoolean)
    {
      int i = this.c.getFirstVisiblePosition();
      this.kv.put(this.currentPath, Integer.valueOf(i));
      this.currentPath = paramString;
      this.afg.setText(this.currentPath);
      switch (this.lN)
      {
      }
    }
    for (;;)
    {
      new atop(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.kv.containsKey(this.currentPath)) {
        break;
      }
      this.kv.remove(this.currentPath);
      break;
      if (this.currentPath.equalsIgnoreCase(this.bGy))
      {
        deL();
        this.y.setText(2131693607);
      }
      else
      {
        this.y.setText(2131693860);
        setRightButton(2131721059, new atoo(this));
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
      this.currentPath = audn.a().vZ();
      continue;
      this.currentPath = acbn.SDCARD_ROOT;
      continue;
      this.currentPath = "/";
      continue;
      File localFile = (File)audx.k(this).get("externalSdCard");
      if (localFile == null) {
        this.currentPath = "/";
      } else {
        this.currentPath = localFile.getPath();
      }
    }
  }
  
  private void dft()
  {
    Object localObject = audn.a().vZ();
    String str = audn.a().wa();
    File localFile = new File((String)localObject);
    if (!aqhq.fileExists((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!aqhq.fileExists(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void initListView()
  {
    this.c = ((SlideDetectListView)findViewById(2131370595));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131372417));
    this.c.setOnItemClickListener(this.mOnItemClickListener);
    this.c.setEmptyView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
    if ((this.lN == 7) || (this.lN == 8) || (this.lN == 11))
    {
      IN(false);
      return;
    }
    this.jdField_a_of_type_Atwf.a(this.c);
    this.c.setOnSlideListener(new atoq(this));
  }
  
  private void refreshList()
  {
    if (this.wA.size() == 0)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.aaF(2131693652);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atwf.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
  }
  
  public void bP()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getResources().getStringArray(2130968637)[1], 3);
    localausj.a(new atos(this, localausj));
    localausj.setOnDismissListener(new atot(this));
    localausj.setOnCancelListener(new atou(this));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561014);
    this.lN = getIntent().getBundleExtra("bundle").getInt("category");
    this.dit = getIntent().getBooleanExtra("from_cloud_file", false);
    this.h = this;
    dfs();
    dft();
    aC();
    this.afg = ((TextView)findViewById(2131365551));
    this.iT = ((LinearLayout)findViewById(2131370502));
    this.jdField_a_of_type_Atwf = new atwf(this, this.wA, this);
    initListView();
    this.c.setAdapter(this.jdField_a_of_type_Atwf);
    this.c.setOnItemClickListener(this.mOnItemClickListener);
    this.c.setOnScrollToTopListener(new atom(this));
    cg(this.currentPath, true);
    if (this.lN == 6) {
      this.iT.setVisibility(8);
    }
    if (getIntent().getIntExtra("localSdCardfile", -1) != -1) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
    }
    deR();
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */