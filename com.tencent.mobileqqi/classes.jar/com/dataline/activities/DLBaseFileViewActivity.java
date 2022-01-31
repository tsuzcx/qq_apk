package com.dataline.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MenuItemCompat;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.PreviewImageAdapter;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import d;
import e;
import f;
import g;
import h;
import i;
import j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DLBaseFileViewActivity
  extends BaseFileViewerActivity
  implements View.OnClickListener
{
  public static final int b = 1001;
  public static final int c = 1002;
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final int g = 1006;
  protected int a;
  protected ViewGroup a;
  protected Button a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  public DLFileInfo a;
  protected AsyncImageView a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new j(this);
  PreviewImageAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter = null;
  protected Gallery a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  protected Button b;
  protected ProgressBar b;
  protected RelativeLayout b;
  protected TextView b;
  public boolean b;
  protected RelativeLayout c;
  protected TextView c;
  boolean c;
  protected TextView d;
  protected boolean d;
  protected TextView e;
  protected TextView f;
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  
  public DLBaseFileViewActivity()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected float a()
  {
    return 1.0F;
  }
  
  protected int a(List paramList)
  {
    return 0;
  }
  
  public long a()
  {
    return 0L;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 0)
    {
      i(2130903484);
      x();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231448));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232359));
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)findViewById(2131232360));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232361));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131231775));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232372));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231519));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232374));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131362070));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232375));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232373));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232363));
      this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231505));
      this.f = ((TextView)findViewById(2131232364));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232365));
      this.g = ((TextView)findViewById(2131232710));
      this.h = ((TextView)findViewById(2131232709));
      this.i = ((TextView)findViewById(2131232711));
      this.j = ((TextView)findViewById(2131232362));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232712));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e = ((TextView)findViewById(2131232713));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new c(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new d(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.g.setOnClickListener(this);
      this.h.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (paramInt != 0) {
        break label479;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    for (;;)
    {
      d();
      this.m.setVisibility(4);
      this.p.setVisibility(4);
      this.p.setContentDescription(getString(2131558526));
      this.p.setImageResource(2130838009);
      this.p.setOnClickListener(new e(this));
      return;
      setContentView(2130903484);
      break;
      label479:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(DLFileInfo paramDLFileInfo)
  {
    this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = paramDLFileInfo;
  }
  
  protected void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setImageResource(FileManagerUtil.b(paramString));
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  protected void a_()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter = new PreviewImageAdapter(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    int k = a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(k);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131427408));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataPreviewImageAdapter.notifyDataSetChanged();
  }
  
  protected void b(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    long l1 = this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long;
    int k = this.jdField_a_of_type_Int;
    float f1 = a();
    e();
    long l2 = ((float)l1 * f1);
    String str;
    if (paramInt == 2131558748)
    {
      str = getString(paramInt);
      if (k != 0) {
        break label191;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!bool) {
        break label180;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(f1 * 100.0F));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      return;
      str = getString(paramInt) + "(" + FileUtil.a(l2) + "/" + FileUtil.a(l1) + ")";
      break;
      label180:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
    label191:
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.g.setVisibility(4);
    this.h.setVisibility(4);
    if (bool) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.f.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress((int)(f1 * 100.0F));
      this.f.setText(str);
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    }
  }
  
  protected void b_()
  {
    this.j.setText(FileUtil.a(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long));
  }
  
  protected void c(int paramInt)
  {
    int k = this.jdField_a_of_type_Int;
    e();
    if (paramInt == 2131558749)
    {
      this.i.setVisibility(0);
      this.i.setText(paramInt);
      return;
    }
    if (k == 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramInt == 2131558729)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
      }
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.g.setVisibility(0);
    this.g.setText(paramInt);
    this.g.setClickable(true);
    if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE)
    {
      if (FileManagerUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString) != true) {
        break label182;
      }
      this.h.setText(2131562565);
      this.h.setVisibility(0);
    }
    for (;;)
    {
      g();
      return;
      label182:
      if (FileManagerUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString) == true)
      {
        this.h.setText(2131563152);
        this.h.setVisibility(0);
      }
    }
  }
  
  protected void d()
  {
    setTitle(2131558721);
  }
  
  public void d(int paramInt) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.f.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    this.g.setVisibility(4);
    this.h.setVisibility(4);
    this.i.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int k = this.jdField_a_of_type_Int;
    DLBaseFileViewActivity.DLFileState localDLFileState = this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState;
    b_();
    d();
    switch (k.a[localDLFileState.ordinal()])
    {
    default: 
      return;
    case 1: 
      if (k == 0)
      {
        c(2131558726);
        return;
      }
      c(2131558725);
      return;
    case 4: 
      if (k == 0) {
        c(2131558729);
      }
      for (;;)
      {
        this.p.setVisibility(0);
        this.p.invalidate();
        return;
        c(2131558727);
      }
    case 3: 
      c(2131558730);
      return;
    case 5: 
      b(2131558733);
      return;
    case 2: 
      c(2131558731);
      return;
    }
    b(2131558732);
  }
  
  protected void g()
  {
    if ((this.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.SENDFAILED) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.DONE)))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    long l = a();
    if (l == 0L)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558703);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localObject == null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558703);
      return;
    }
    if ((((FileManagerEntity)localObject).cloudType != 2) && (((FileManagerEntity)localObject).status == 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (((FileManagerEntity)localObject).nOpType != 6)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558743);
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
      return;
    }
    switch (((FileManagerEntity)localObject).status)
    {
    default: 
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558703);
      return;
    case 0: 
    case 3: 
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558703);
      return;
    case 2: 
      localObject = getString(2131558744) + "(" + Integer.valueOf((int)(((FileManagerEntity)localObject).fProgress * 100.0F)) + "%)";
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131558743);
    this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  public void h() {}
  
  protected void i() {}
  
  public void j()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (!this.jdField_a_of_type_Boolean) {
        break label128;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.g.setVisibility(4);
      this.h.setVisibility(4);
    }
    for (;;)
    {
      f();
      return;
      this.jdField_a_of_type_Boolean = true;
      break;
      label128:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void k()
  {
    long l = a();
    Object localObject;
    if (l > 0L)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      if ((localObject == null) || (((FileManagerEntity)localObject).status != 2)) {
        break label157;
      }
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.a(10000);
      localForwardFileInfo.c(((FileManagerEntity)localObject).cloudType);
      localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
      localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
      localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
      localForwardFileInfo.a(((FileManagerEntity)localObject).strFilePath);
      localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
      localObject = new Intent(this, QfileFileViewerActivity.class);
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      startActivity((Intent)localObject);
    }
    label157:
    while ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.DONE) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.SENDFAILED))
    {
      ForwardFileInfo localForwardFileInfo;
      return;
      localObject = null;
      break;
    }
    if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long > 5242880L))
    {
      FMDialogUtil.a(a(), 2131558759, 2131558756, new f(this, (FileManagerEntity)localObject, l));
      return;
    }
    if (localObject == null)
    {
      FMToastUtil.b(getString(2131558737, new Object[] { FileManagerUtil.d(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString) }));
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString, null, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false).nSessionId);
      return;
    }
    FMToastUtil.b(getString(2131558737, new Object[] { FileManagerUtil.d(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString) }));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
  }
  
  public void l()
  {
    if (new File(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString).exists())
    {
      Object localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = "transmit";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 3;
      FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).a(10000);
      ((ForwardFileInfo)localObject).d(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString);
      ((ForwardFileInfo)localObject).d(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_Long);
      ((ForwardFileInfo)localObject).a(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(this, ForwardRecentActivity.class);
      localIntent.putExtra("forward_text", this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 0) {
        localIntent.putExtra("forward_type", 1);
      }
      for (;;)
      {
        localIntent.putExtra("forward_filepath", this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("fileinfo", (Parcelable)localObject);
        localIntent.putExtra("isFromShare", true);
        startActivityForResult(localIntent, 103);
        return;
        localIntent.putExtra("forward_type", 0);
        localIntent.putExtra("not_forward", true);
      }
    }
    FMToastUtil.a(2131558522);
  }
  
  public void m()
  {
    FileManagerUtil.b(this, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void n()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.clear();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int m;
    if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) || (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.SENDFAILED))
    {
      localActionSheet.a(2131558701, 1);
      localSparseIntArray.put(0, 2131558701);
      if (this.jdField_a_of_type_Int == 0)
      {
        localActionSheet.a(getString(2131560772), 1);
        m = 2;
        localSparseIntArray.put(1, 2131560772);
        long l = a();
        k = m;
        if (LiteActivity.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l))
        {
          localActionSheet.a(2131558703, 1);
          localSparseIntArray.put(m, 2131558703);
        }
      }
    }
    for (int k = m + 1;; k = 0)
    {
      m = k;
      if (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE)
      {
        m = k;
        if (this.jdField_a_of_type_Int == 0)
        {
          localActionSheet.c(getString(2131558745, new Object[] { Integer.valueOf(1) }));
          int n = k + 1;
          localSparseIntArray.put(k, 2131558745);
          localActionSheet.a(getString(2131558727), 1);
          m = n + 1;
          localSparseIntArray.put(n, 2131558727);
        }
      }
      if ((this.jdField_d_of_type_Boolean == true) && (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE))
      {
        localActionSheet.a(getString(2131558596), 1);
        localSparseIntArray.put(m, 2131558596);
      }
      localActionSheet.a(new g(this, localSparseIntArray, localActionSheet));
      localActionSheet.setOnDismissListener(new h(this));
      localActionSheet.setOnCancelListener(new i(this));
      localActionSheet.d(2131561746);
      localActionSheet.show();
      return;
      m = 1;
      break;
    }
  }
  
  protected void o() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232710: 
      switch (k.a[this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState.ordinal()])
      {
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        h();
        return;
      }
      m();
      return;
    case 2131232709: 
      FileViewerFacade.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_b_of_type_JavaLangString);
      return;
    case 2131232365: 
    case 2131232375: 
      i();
      return;
    case 2131231775: 
      j();
      return;
    case 2131232712: 
      k();
      return;
    }
    h();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 1001: 
      l();
    }
    for (;;)
    {
      return true;
      QfavBuilder.c(this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 7, 3);
      continue;
      k();
      continue;
      FileManagerUtil.a(a(), this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_JavaLangString);
      continue;
      m();
      continue;
      h();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (this.p.getVisibility() == 8) {}
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo == null);
      if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) || (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.SENDFAILED))
      {
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1001, 0, getString(2131558701)), 0);
        if (this.jdField_a_of_type_Int == 0) {
          MenuItemCompat.setShowAsAction(paramMenu.add(0, 1002, 0, getString(2131560772)), 0);
        }
        long l = a();
        if (LiteActivity.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l)) {
          MenuItemCompat.setShowAsAction(paramMenu.add(0, 1003, 0, getString(2131558703)), 0);
        }
      }
      if ((this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState == DLBaseFileViewActivity.DLFileState.DONE) && (this.jdField_a_of_type_Int == 0))
      {
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1004, 0, getString(2131558745)), 0);
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1005, 0, getString(2131558727)), 0);
      }
    } while ((this.jdField_d_of_type_Boolean != true) || (this.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState != DLBaseFileViewActivity.DLFileState.DONE));
    MenuItemCompat.setShowAsAction(paramMenu.add(0, 1006, 0, getString(2131558596)), 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.activities.DLBaseFileViewActivity
 * JD-Core Version:    0.7.0.1
 */