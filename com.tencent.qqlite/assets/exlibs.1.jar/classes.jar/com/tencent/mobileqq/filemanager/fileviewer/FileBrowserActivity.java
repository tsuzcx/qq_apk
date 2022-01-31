package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalApkFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OnlineSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dsm;
import dsn;
import dso;
import dsp;
import dsq;
import java.util.ArrayList;
import java.util.List;

public final class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements IFileBrowser
{
  static final String jdField_a_of_type_JavaLangString = "FileViewerActivity";
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ActionBarManager jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager;
  private BaseActionBar.IActionBarClickEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = null;
  private FileViewBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase;
  private ForwardData jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = null;
  IFileViewListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = new dsp(this);
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 10000;
  
  private FileViewBase a()
  {
    LocalApkFileView localLocalApkFileView = new LocalApkFileView(this);
    localLocalApkFileView.a(a());
    return localLocalApkFileView;
  }
  
  private void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    switch (paramIFileViewerAdapter.c())
    {
    case 5: 
    default: 
      return;
    case 3: 
      if (paramIFileViewerAdapter.g())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      if ((paramIFileViewerAdapter.f()) || (paramIFileViewerAdapter.e()))
      {
        if (a(this.app, paramIFileViewerAdapter))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      if (paramIFileViewerAdapter.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      switch (paramIFileViewerAdapter.a())
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = b();
        return;
      case 5: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
      return;
    case 4: 
      switch (paramIFileViewerAdapter.a())
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = b();
        return;
      case 5: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
      return;
    case 1: 
      if (paramIFileViewerAdapter.g())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      if ((paramIFileViewerAdapter.f()) || (paramIFileViewerAdapter.e()))
      {
        if (a(this.app, paramIFileViewerAdapter))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      if (paramIFileViewerAdapter.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      }
      switch (paramIFileViewerAdapter.a())
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
      return;
    case 2: 
      switch (paramIFileViewerAdapter.a())
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = f();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
      return;
    case 0: 
      switch (paramIFileViewerAdapter.a())
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = h();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = e();
      return;
    }
    switch (paramIFileViewerAdapter.a())
    {
    case 3: 
    case 4: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = b();
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = a();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = c();
      return;
    }
    if (FileUtil.b(paramIFileViewerAdapter.a().strFilePath))
    {
      if ((paramIFileViewerAdapter.a().status != 1) && (!paramIFileViewerAdapter.c()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
  }
  
  private void a(boolean paramBoolean)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
        i();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b();
        continue;
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || (!PreviewingOfflineFileView.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase)))
        {
          a().removeAllViews();
          if ((1 == a().c()) && (a().f()) && (a(this.app, a())))
          {
            this.app.a().a(new OfflinePreviewController(this.app, a().d()));
            localObject = new Intent(this, FilePreviewActivity.class);
            ((Intent)localObject).putExtra("offline_file_type", 0);
            ((Intent)localObject).putExtra("offline_file_name", a().a());
            ((Intent)localObject).putExtra("offline_file_size", a().a());
            QLog.i("FileViewerActivity", 1, "open zip file,open new activity");
            startActivity((Intent)localObject);
            overridePendingTransition(2130968597, 2130968598);
          }
          a(a());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
          a().addView((View)localObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
          f();
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    FileViewerParamParser localFileViewerParamParser = new FileViewerParamParser(this.app);
    if (!localFileViewerParamParser.a(paramIntent)) {}
    do
    {
      return false;
      this.jdField_a_of_type_Int = localFileViewerParamParser.a();
      switch (this.jdField_a_of_type_Int)
      {
      }
    } while (!QLog.isDevelopLevel());
    throw new NullPointerException("未知的mFileViewerType");
    this.jdField_a_of_type_JavaUtilList = localFileViewerParamParser.a();
    this.jdField_b_of_type_Int = localFileViewerParamParser.b();
    a(a());
    for (;;)
    {
      setContentViewNoTitle(2130903446);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
      a().addView(paramIntent);
      e();
      return true;
      this.jdField_a_of_type_JavaUtilList = localFileViewerParamParser.a();
      this.jdField_b_of_type_Int = localFileViewerParamParser.b();
      h();
      continue;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(localFileViewerParamParser.a());
      this.jdField_b_of_type_Int = 0;
      a(a());
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, paramIFileViewerAdapter.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
      return FileManagerUtil.a(i);
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private FileViewBase b()
  {
    LocalSimpleFileView localLocalSimpleFileView = new LocalSimpleFileView(this);
    localLocalSimpleFileView.a(a());
    return localLocalSimpleFileView;
  }
  
  private FileViewBase c()
  {
    boolean bool2 = true;
    LocalMusicFileView localLocalMusicFileView = new LocalMusicFileView(this);
    IFileViewerAdapter localIFileViewerAdapter = a();
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_b_of_type_Int > 0)
      {
        bool1 = true;
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label80;
        }
      }
    }
    for (;;)
    {
      localIFileViewerAdapter.e(bool1);
      localIFileViewerAdapter.f(bool2);
      localLocalMusicFileView.a(localIFileViewerAdapter);
      return localLocalMusicFileView;
      bool1 = false;
      break;
      label80:
      bool2 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  private FileViewBase d()
  {
    LocalVideoFileView localLocalVideoFileView = new LocalVideoFileView(this);
    localLocalVideoFileView.a(a());
    return localLocalVideoFileView;
  }
  
  private FileViewBase e()
  {
    OfflineMusicFileView localOfflineMusicFileView = new OfflineMusicFileView(this);
    localOfflineMusicFileView.a(a());
    return localOfflineMusicFileView;
  }
  
  private void e()
  {
    Object localObject = (TextView)findViewById(2131296901);
    ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    ((TextView)localObject).setOnClickListener(new dsn(this));
    ((TextView)findViewById(2131296895)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    if (this.jdField_b_of_type_Boolean)
    {
      d();
      localObject = (ImageView)findViewById(2131296906);
      ((ImageView)localObject).setOnClickListener(new dso(this));
      ((ImageView)localObject).setImageResource(2130838621);
      ((ImageView)localObject).setContentDescription(getString(2131362012));
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  private FileViewBase f()
  {
    OfflineSimpleFileView localOfflineSimpleFileView = new OfflineSimpleFileView(this);
    localOfflineSimpleFileView.a(a());
    return localOfflineSimpleFileView;
  }
  
  private void f()
  {
    TextView localTextView = (TextView)findViewById(2131296901);
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    ((TextView)findViewById(2131296895)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a());
    if (a().h())
    {
      FileManagerUtil.a(this, localTextView);
      return;
    }
    FileManagerUtil.a(localTextView);
  }
  
  private FileViewBase g()
  {
    OfflineVideoFileView localOfflineVideoFileView = new OfflineVideoFileView(this, this.app);
    localOfflineVideoFileView.a(a());
    return localOfflineVideoFileView;
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Boolean) {
      FileManagerReporter.a("0X8004BC7");
    }
    for (;;)
    {
      localObject = getIntent().getExtras().getString("leftViewText");
      if ((localObject == null) || (!((String)localObject).equals(getString(2131361948)))) {
        break;
      }
      finish();
      overridePendingTransition(2130968590, 2130968591);
      return;
      FileManagerReporter.a("0X8004BDD");
    }
    Object localObject = new Intent(getApplicationContext(), FMActivity.class);
    ((Intent)localObject).putExtra("selectMode", false);
    ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
    ((Intent)localObject).putExtra("tab_tab_type", 0);
    startActivityForResult((Intent)localObject, 103);
    overridePendingTransition(2130968597, 2130968598);
  }
  
  private FileViewBase h()
  {
    OnlineSimpleFileView localOnlineSimpleFileView = new OnlineSimpleFileView(this);
    localOnlineSimpleFileView.a(a());
    return localOnlineSimpleFileView;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = new PhotoFileView(this, this.app, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int > 0);
  }
  
  private FileViewBase i()
  {
    CanPreviewOfflineFileView localCanPreviewOfflineFileView = new CanPreviewOfflineFileView(this);
    localCanPreviewOfflineFileView.a(a());
    return localCanPreviewOfflineFileView;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = new dsq(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent);
    }
  }
  
  private boolean i()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1);
  }
  
  private FileViewBase j()
  {
    PreviewingOfflineFileView localPreviewingOfflineFileView = new PreviewingOfflineFileView(this, this.app);
    localPreviewingOfflineFileView.a(a());
    String str = FMConfig.a(this.app, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    int i;
    if (str != null) {
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      label54:
      break label54;
    }
    if (1 == i) {
      setRequestedOrientation(-1);
    }
    return localPreviewingOfflineFileView;
  }
  
  private boolean j()
  {
    this.jdField_a_of_type_Int = 2;
    Object localObject = FileViewMusicService.a();
    this.jdField_a_of_type_JavaUtilList = ((FileViewMusicService)localObject).a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    this.jdField_b_of_type_Int = ((FileViewMusicService)localObject).a();
    a(a());
    setContentViewNoTitle(2130903446);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(a());
    a().addView((View)localObject);
    e();
    return true;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131298098);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  public IFileViewerAdapter a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public RelativeLayout b()
  {
    return (RelativeLayout)findViewById(2131298100);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    a(false);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296907));
    }
    if (a().a().d())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent;
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = new ForwardData();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a(getIntent());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if (paramInt2 == -1)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((this.c == 10008) || (this.c == 10006)))
      {
        localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        finish();
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    this.c = localForwardFileInfo.a();
    if (10004 == this.c)
    {
      this.jdField_b_of_type_Boolean = true;
      FileManagerReporter.a("0X8004BB3");
      if (10008 != this.c) {
        break label87;
      }
    }
    label87:
    for (boolean bool = j();; bool = a(paramBundle))
    {
      if (bool) {
        break label96;
      }
      return false;
      FileManagerReporter.a("0X8004BC8");
      break;
    }
    label96:
    b(paramBundle);
    if (Build.VERSION.SDK_INT <= 11) {
      removeWebViewLayerType();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = new ActionBarManager(this);
    i();
    FileManagerReporter.a("0X8004C01");
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new dsm(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    return true;
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.d();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
    }
    d();
  }
  
  public boolean f()
  {
    return getIntent().getBooleanExtra("FromEditBarPreview", false);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    super.finish();
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */