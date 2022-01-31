package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.MenuPopupDialog;
import dgy;
import dgz;
import dha;
import dhb;
import dhc;
import dhd;
import dhe;
import dhf;
import dhg;
import dhh;
import dhk;
import dhl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String c;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public BaseActivity a;
  public LocalFileAdapter a;
  public NoFileRelativeLayout a;
  public SlideDetectListView a;
  protected AdapterView.OnItemClickListener a;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  public ArrayList a;
  public Map a;
  public int b;
  public View.OnClickListener b;
  TextView b;
  public int c;
  TextView c;
  TextView d;
  public String d;
  String e;
  
  static
  {
    jdField_c_of_type_JavaLangString = "LocalFileBrowserActivity<FileAssistant>";
  }
  
  public LocalFileBrowserActivity()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dhd(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new dhh(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new dhk(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new dgz(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
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
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.q();
      this.jdField_a_of_type_JavaUtilMap.put(this.jdField_d_of_type_JavaLangString, Integer.valueOf(i));
      this.jdField_d_of_type_JavaLangString = paramString;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      switch (this.jdField_c_of_type_Int)
      {
      }
    }
    for (;;)
    {
      new dha(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_d_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_d_of_type_JavaLangString);
      break;
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase(this.e)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131361937);
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131362023);
      }
    }
  }
  
  private void b(int paramInt)
  {
    o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new dhb(this, paramInt));
  }
  
  private boolean k()
  {
    if (((this.jdField_c_of_type_Int == 8) || (this.jdField_c_of_type_Int == 11)) && (this.jdField_d_of_type_JavaLangString.equals(this.e))) {
      return super.a();
    }
    if (this.jdField_c_of_type_Int == 6) {
      return super.a();
    }
    String str = new File(this.jdField_d_of_type_JavaLangString).getParent();
    if (str != null)
    {
      a(str, false);
      return false;
    }
    return super.a();
  }
  
  private void o()
  {
    NoFileRelativeLayout localNoFileRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {}
    for (int i = 0;; i = 8)
    {
      localNoFileRelativeLayout.setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298011));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131298012));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131363839);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
    if ((this.jdField_c_of_type_Int == 7) || (this.jdField_c_of_type_Int == 8) || (this.jdField_c_of_type_Int == 11))
    {
      d(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new dhc(this));
  }
  
  private void q()
  {
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      this.e = this.jdField_d_of_type_JavaLangString;
      return;
      this.jdField_d_of_type_JavaLangString = AppConstants.ay;
      continue;
      this.jdField_d_of_type_JavaLangString = AppConstants.aq;
      continue;
      this.jdField_d_of_type_JavaLangString = "/";
      continue;
      File localFile = (File)FileManagerUtil.a(this).get("externalSdCard");
      if (localFile == null) {
        this.jdField_d_of_type_JavaLangString = "/";
      } else {
        this.jdField_d_of_type_JavaLangString = localFile.getPath();
      }
    }
  }
  
  private void r()
  {
    Object localObject = AppConstants.ay;
    String str = AppConstants.aA;
    File localFile = new File((String)localObject);
    if (!FileUtils.a((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!FileUtils.a(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void s()
  {
    this.jdField_b_of_type_JavaLangString = getString(FileCategoryEntity.a(this.jdField_c_of_type_Int));
    setTitle(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296891));
    }
    this.jdField_c_of_type_AndroidWidgetTextView = this.h;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new dhl(this));
    }
    this.jdField_c_of_type_AndroidWidgetTextView = this.h;
  }
  
  private void t() {}
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    paramString = new File(paramString);
    String str = MimeTypesTools.a(this, paramString.getName());
    localIntent.setDataAndType(Uri.fromFile(paramString), str);
    startActivity(localIntent);
  }
  
  public void d()
  {
    o();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903416);
    this.jdField_c_of_type_Int = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    q();
    r();
    s();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298010));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298009));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = new LocalFileAdapter(this, this.jdField_a_of_type_JavaUtilArrayList, this);
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new dgy(this));
    a(this.jdField_d_of_type_JavaLangString, true);
    if (this.jdField_c_of_type_Int == 6) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (getIntent().getIntExtra("localSdCardfile", -1) != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      f();
    }
    m();
    return true;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void n()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getStringArray(2131230747)[1], 3);
    localActionSheet.a(new dhe(this, localActionSheet));
    localActionSheet.setOnDismissListener(new dhf(this));
    localActionSheet.setOnCancelListener(new dhg(this));
    localActionSheet.d(2131362794);
    localActionSheet.show();
  }
  
  public void onBackPressed()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */