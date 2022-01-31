package com.tencent.mobileqq.filemanager.activity;

import android.app.Dialog;
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
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.BubblePopupWindow;
import frt;
import fru;
import frv;
import frw;
import frx;
import fry;
import frz;
import fsa;
import fsb;
import fsc;
import fse;
import fsf;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String b;
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public LocalFileAdapter a;
  public NoFileRelativeLayout a;
  public SlideDetectListView a;
  protected AdapterView.OnItemClickListener a;
  public BubblePopupWindow a;
  public ArrayList a;
  public Map a;
  public int b;
  public View.OnClickListener b;
  TextView b;
  public BaseActivity b;
  TextView c;
  public String c;
  String d;
  
  static
  {
    jdField_b_of_type_JavaLangString = "LocalFileBrowserActivity<FileAssistant>";
  }
  
  public LocalFileBrowserActivity()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fry(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new fsc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fse(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new fru(this);
  }
  
  private void a(int paramInt)
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new frw(this, paramInt));
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
      this.jdField_a_of_type_JavaUtilMap.put(this.jdField_c_of_type_JavaLangString, Integer.valueOf(i));
      this.jdField_c_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      new frv(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_c_of_type_JavaLangString);
      break;
      if (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase(this.d)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131558677);
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131558765);
      }
    }
  }
  
  private void h()
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232737));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131232738));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131562479);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
    if ((this.jdField_b_of_type_Int == 7) || (this.jdField_b_of_type_Int == 8) || (this.jdField_b_of_type_Int == 11))
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new frx(this));
  }
  
  private void j()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.d = this.jdField_c_of_type_JavaLangString;
      return;
      this.jdField_c_of_type_JavaLangString = AppConstants.as;
      continue;
      this.jdField_c_of_type_JavaLangString = AppConstants.al;
      continue;
      this.jdField_c_of_type_JavaLangString = "/";
      continue;
      File localFile = (File)FileManagerUtil.a().get("externalSdCard");
      if (localFile == null) {
        this.jdField_c_of_type_JavaLangString = "/";
      } else {
        this.jdField_c_of_type_JavaLangString = localFile.getPath();
      }
    }
  }
  
  private boolean j()
  {
    if (((this.jdField_b_of_type_Int == 8) || (this.jdField_b_of_type_Int == 11)) && (this.jdField_c_of_type_JavaLangString.equals(this.d))) {
      return super.b();
    }
    if (this.jdField_b_of_type_Int == 6) {
      return super.b();
    }
    String str = new File(this.jdField_c_of_type_JavaLangString).getParent();
    if (str != null)
    {
      a(str, false);
      return false;
    }
    return super.b();
  }
  
  private void k()
  {
    Object localObject = AppConstants.as;
    String str = AppConstants.au;
    File localFile = new File((String)localObject);
    if (!FileUtils.a((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!FileUtils.a(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void l()
  {
    setTitle(getString(FileCategoryEntity.a(this.jdField_b_of_type_Int)));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = this.k;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new fsf(this));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = this.k;
  }
  
  private void m() {}
  
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903497);
    this.jdField_b_of_type_Int = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_b_of_type_ComTencentMobileqqAppBaseActivity = this;
    j();
    k();
    l();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232736));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232735));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = new LocalFileAdapter(this, this.jdField_a_of_type_JavaUtilArrayList, this);
    i();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new frt(this));
    a(this.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_b_of_type_Int == 6) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    return true;
  }
  
  public int f()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getStringArray(2131689515)[1], 3);
    localActionSheet.a(new frz(this, localActionSheet));
    localActionSheet.setOnDismissListener(new fsa(this));
    localActionSheet.setOnCancelListener(new fsb(this));
    localActionSheet.d(2131561746);
    localActionSheet.show();
  }
  
  public void onBackPressed()
  {
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */