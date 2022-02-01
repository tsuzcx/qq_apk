package com.tencent.mobileqq.filemanager.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.BaseFileAdapter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOfflineFileListSubKey;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOfflineFuntion;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter;
import com.tencent.mobileqq.filemanager.data.OfflineFileAdapter;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileAdapter;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.OverScrollViewListener;
import fpm;
import fpn;
import fpo;
import fpp;
import fpq;
import fpr;
import fps;
import fpt;
import fpu;
import fpv;
import fpx;
import java.util.ArrayList;
import java.util.Iterator;

public class CloudFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static long b = 0L;
  public static String b;
  static final int jdField_c_of_type_Int = 4;
  static final int jdField_d_of_type_Int = 6;
  static final int jdField_g_of_type_Int = 1;
  int jdField_a_of_type_Int = 15;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new fpq(this);
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public View a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseFileAdapter a;
  public ImageFileAdapter a;
  private OfflineFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataOfflineFileInfo = null;
  private WeiYunFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public ViewerMoreRelativeLayout a;
  public GridListView a;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = null;
  public ArrayList a;
  public int b;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public View.OnClickListener b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fpo(this);
  NoFileRelativeLayout jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public ArrayList b;
  public long c;
  public View.OnClickListener c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  int f;
  public boolean f;
  boolean jdField_g_of_type_Boolean;
  boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k;
  public boolean l;
  
  static
  {
    jdField_b_of_type_JavaLangString = "CloudFileBrowserActivity<FileAssistant>";
    jdField_b_of_type_Long = 0L;
  }
  
  public CloudFileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.g = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fpp(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fpu(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new fpv(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new fpx(this);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt + 1) * 6)) / paramInt;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      CloudFileBrowserActivity.OverScrollViewTag localOverScrollViewTag = (CloudFileBrowserActivity.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.a = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        if (paramInt == 0) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  private void a(ForwardFileInfo paramForwardFileInfo)
  {
    Intent localIntent = new Intent(getApplicationContext(), QfileFileViewerActivity.class);
    localIntent.putExtra("fileinfo", paramForwardFileInfo);
    if (paramForwardFileInfo.c() == 1) {
      if (FileManagerUtil.a(paramForwardFileInfo.d()) == 0) {
        localIntent.putParcelableArrayListExtra("local_offline_list", this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 102);
      return;
      if ((paramForwardFileInfo.c() == 2) && (FileManagerUtil.a(paramForwardFileInfo.d()) == 0)) {
        localIntent.putParcelableArrayListExtra("local_weiyun_list", this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  private void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localWeiYunFileInfo);
        this.jdField_e_of_type_Int += 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    long l1 = 0L;
    int m;
    Object localObject3;
    switch ((int)this.jdField_a_of_type_Long)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      m = -1;
      if (this.jdField_a_of_type_Long != 9L) {
        break label376;
      }
      localObject3 = (OfflineFileInfo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      if (g()) {
        if (FMDataCache.a((OfflineFileInfo)localObject3))
        {
          FMDataCache.b((OfflineFileInfo)localObject3);
          label106:
          f();
          c(true);
          localObject1 = null;
          if (m != -1)
          {
            localObject2 = new FileManagerReporter.fileAssistantReportData();
            ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_JavaLangString = "file_viewer_in";
            ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = m;
            ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString = FileUtil.a((String)localObject1);
            ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Long = l1;
            FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject2);
          }
        }
      }
      break;
    }
    label174:
    do
    {
      return;
      m = 74;
      break;
      m = 75;
      break;
      m = 76;
      break;
      m = 77;
      break;
      m = 78;
      break;
      m = 79;
      break;
      FMDataCache.a((OfflineFileInfo)localObject3);
      break label106;
      if (c()) {
        break label243;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 1, "click too fast , wait a minute.");
    return;
    label243:
    d();
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((OfflineFileInfo)localObject3).jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = FileManagerUtil.a((OfflineFileInfo)localObject3, 0);
    }
    localObject2 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject2).c(1);
    ((ForwardFileInfo)localObject2).a(((OfflineFileInfo)localObject3).jdField_a_of_type_Long);
    ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
    ((ForwardFileInfo)localObject2).a(10002);
    ((ForwardFileInfo)localObject2).d(((OfflineFileInfo)localObject3).jdField_b_of_type_JavaLangString);
    localObject1 = ((OfflineFileInfo)localObject3).jdField_b_of_type_JavaLangString;
    ((ForwardFileInfo)localObject2).b(((OfflineFileInfo)localObject3).jdField_a_of_type_JavaLangString);
    ((ForwardFileInfo)localObject2).d(((OfflineFileInfo)localObject3).jdField_b_of_type_Long);
    l1 = ((OfflineFileInfo)localObject3).jdField_b_of_type_Long;
    a((ForwardFileInfo)localObject2);
    for (;;)
    {
      break;
      label376:
      localObject3 = (WeiYunFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localObject3 == null) {
        break label174;
      }
      if (g())
      {
        if (FMDataCache.a((WeiYunFileInfo)localObject3)) {
          FMDataCache.b((WeiYunFileInfo)localObject3);
        }
        for (;;)
        {
          f();
          c(true);
          localObject1 = null;
          break;
          FMDataCache.a((WeiYunFileInfo)localObject3);
        }
      }
      if (!c())
      {
        if (!QLog.isColorLevel()) {
          break label174;
        }
        QLog.i(jdField_b_of_type_JavaLangString, 1, "click too fast , wait a minute.");
        return;
      }
      d();
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = FileManagerUtil.a((WeiYunFileInfo)localObject3);
      }
      localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).c(2);
      ((ForwardFileInfo)localObject2).a(10003);
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
      ((ForwardFileInfo)localObject2).d(((WeiYunFileInfo)localObject3).jdField_b_of_type_JavaLangString);
      localObject1 = ((WeiYunFileInfo)localObject3).jdField_b_of_type_JavaLangString;
      ((ForwardFileInfo)localObject2).c(((WeiYunFileInfo)localObject3).jdField_a_of_type_JavaLangString);
      ((ForwardFileInfo)localObject2).b(((WeiYunFileInfo)localObject3).c);
      ((ForwardFileInfo)localObject2).d(((WeiYunFileInfo)localObject3).jdField_a_of_type_Long);
      l1 = ((WeiYunFileInfo)localObject3).jdField_a_of_type_Long;
      a((ForwardFileInfo)localObject2);
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OfflineFileInfo localOfflineFileInfo = (OfflineFileInfo)localIterator.next();
      if (localOfflineFileInfo.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(localOfflineFileInfo);
        this.jdField_f_of_type_Int += 1;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      break label4;
    }
    label4:
    while ((!this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if (this.jdField_a_of_type_Long == 9L) {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
        if (this.j)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter.notifyDataSetChanged();
      }
      if (this.g) {
        break;
      }
      this.g = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      continue;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (this.i)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter.a(Integer.valueOf(-1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new fpm(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    CloudFileBrowserActivity.OverScrollViewTag localOverScrollViewTag = new CloudFileBrowserActivity.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new fpr(this);
    if (this.jdField_a_of_type_Long == 10L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setContentBackground(2130837729);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131558714);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131562672);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131230904));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131232728));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130903493, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232728));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    l();
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(new fps(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getViewTreeObserver().addOnGlobalLayoutListener(new fpt(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(a(4));
    int m = (int)(6.0F * this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(m, m);
  }
  
  private void m()
  {
    if (!NetworkUtil.f(a()))
    {
      FMToastUtil.a(2131562488);
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long == 9L)
    {
      String str = FMConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, FMConfig.eOfflineFuntion.OfflineFileList, FMConfig.eOfflineFileListSubKey.Merge);
      boolean bool = false;
      if (str != null) {
        bool = Boolean.valueOf(str).booleanValue();
      }
      if (!bool) {
        break label137;
      }
    }
    label137:
    for (int m = 2;; m = 1)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int);
      for (;;)
      {
        o();
        c(true);
        return;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int * this.jdField_a_of_type_Int - this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, jdField_b_of_type_Long);
      }
    }
  }
  
  private boolean m()
  {
    return super.b();
  }
  
  private void n()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_l_of_type_AndroidWidgetTextView;
    setTitle(getString(FileCategoryEntity.a((int)this.jdField_a_of_type_Long)));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231375));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_k_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new fpn(this));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_k_of_type_AndroidWidgetTextView;
  }
  
  private void o()
  {
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837856);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void p()
  {
    this.jdField_e_of_type_Boolean = false;
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  private void q()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837854);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void r()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    setContentView(2130903510);
    this.jdField_b_of_type_Int = 0;
    paramBundle = getIntent().getBundleExtra("bundle");
    this.jdField_a_of_type_Long = paramBundle.getLong("category");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("categoryid");
    n();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    k();
    if (this.jdField_a_of_type_Long == 9L)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter = new OfflineFileAdapter(this, this.jdField_b_of_type_JavaUtilArrayList, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter);
      if (this.jdField_a_of_type_Long != 10L) {
        break label318;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(0);
      label141:
      q();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      if (this.jdField_a_of_type_Long != 9L) {
        break label337;
      }
      paramBundle = FMConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, FMConfig.eOfflineFuntion.OfflineFileList, FMConfig.eOfflineFileListSubKey.Merge);
      if (paramBundle != null) {
        bool = Boolean.valueOf(paramBundle).booleanValue();
      }
      if (!bool) {
        break label368;
      }
    }
    label318:
    label337:
    label368:
    for (int m = 2;; m = 1)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int);
      for (;;)
      {
        i();
        return true;
        if (this.jdField_a_of_type_Long == 10L)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter = new ImageFileAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Int = 30;
          this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataImageFileAdapter);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter = new WeiYunFileAdapter(this, this.jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataBaseFileAdapter);
        break;
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(4);
        break label141;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int, jdField_b_of_type_Long);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight());
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight());
  }
  
  public void h()
  {
    int m = 1;
    String str;
    if (NetworkUtil.f(a()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Long == 9L)
      {
        str = FMConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, FMConfig.eOfflineFuntion.OfflineFileList, FMConfig.eOfflineFileListSubKey.Merge);
        if (str == null) {
          break label117;
        }
      }
    }
    label117:
    for (boolean bool = Boolean.valueOf(str).booleanValue();; bool = false)
    {
      if (bool) {
        m = 2;
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(m, 0, this.jdField_a_of_type_Int);
      return;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Int, jdField_b_of_type_Long);
      return;
      a(1);
      FMToastUtil.a(2131562488);
      return;
    }
  }
  
  public boolean j()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean k()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean l()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5)) {
      return;
    }
    c(true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */