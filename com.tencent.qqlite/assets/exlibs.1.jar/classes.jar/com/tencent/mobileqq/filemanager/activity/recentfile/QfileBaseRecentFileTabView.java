package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MenuPopupDialog;
import dll;
import dlo;
import dlp;
import dls;
import dlx;
import dly;
import dlz;
import dma;
import dmb;
import dmc;
import dmd;
import dme;
import dmf;
import dmg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

public abstract class QfileBaseRecentFileTabView
  extends QfileBaseTabView
{
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public long a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  View jdField_a_of_type_AndroidViewView;
  public QfileBaseExpandableListAdapter a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dls(this);
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public QfilePinnedHeaderExpandableListView a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  public LinkedHashMap a;
  public List a;
  boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  View jdField_b_of_type_AndroidViewView;
  final String jdField_b_of_type_JavaLangString = "LastRequestTime";
  volatile boolean jdField_b_of_type_Boolean = false;
  public View.OnClickListener c;
  View c;
  public boolean c;
  public View.OnClickListener d = new dlp(this);
  int e = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QfileRecentFileActivity<FileAssistant>";
  }
  
  public QfileBaseRecentFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dmc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new dmg(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new dll(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new dlo(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(Boolean paramBoolean, List paramList)
  {
    long l;
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
      l = System.currentTimeMillis();
      paramBoolean.edit().putLong("LastRequestTime", l).commit();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "megre over list size = 0, updata last process time");
      return;
    }
    Collections.sort(paramList, new dmb(this));
    paramBoolean = paramList.iterator();
    label359:
    for (;;)
    {
      Object localObject;
      if (paramBoolean.hasNext())
      {
        paramList = (OfflineFileInfo)paramBoolean.next();
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        FileManagerEntity localFileManagerEntity;
        String str;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
          str = paramList.jdField_a_of_type_JavaLangString.replace("/offline", "");
        } while ((localFileManagerEntity.Uuid == null) || (!localFileManagerEntity.Uuid.equalsIgnoreCase(str)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label359;
        }
        localObject = FileManagerUtil.a(paramList, 0);
        if (((FileManagerEntity)localObject).nFileType == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).Uuid, 3, paramList.jdField_a_of_type_Boolean, localObject);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject);
          QLog.i(jdField_a_of_type_JavaLangString, 1, "insert new entity, updata last process time,newEntity[" + ((FileManagerEntity)localObject).nSessionId + "]");
          b((FileManagerEntity)localObject);
          break;
          if (((FileManagerEntity)localObject).nFileType == 2)
          {
            paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((FileManagerEntity)localObject, 2);
            if (paramList != null) {
              ((FileManagerEntity)localObject).strThumbPath = paramList;
            }
          }
        }
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
        l = System.currentTimeMillis();
        paramBoolean.edit().putLong("LastRequestTime", l).commit();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "process over , updata last process time");
        return;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, 0, 30);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
      }
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileRecentImageExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131298023));
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setContentDescription("最近文件分组");
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131298023));
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    }
  }
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131361975);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  protected abstract QfileBaseExpandableListAdapter a();
  
  public abstract void a();
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    return b(paramFileManagerEntity);
  }
  
  public void b()
  {
    a(2130903422);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter = a();
    k();
    l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130837934));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileRecentImageExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131427345);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130837934));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(i);
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130837934));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(i);
      i += 1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter instanceof QfileRecentImageExpandableListAdapter)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new dlz(this));
    }
    SharedPreferences localSharedPreferences;
    long l2;
    for (;;)
    {
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
      long l1 = localSharedPreferences.getLong("LastRequestTime", 0L);
      l2 = System.currentTimeMillis();
      if (Math.abs(l2 - l1) <= 86400000L) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "updata offlineList");
      g();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new dma(this));
    }
    localSharedPreferences.edit().putLong("LastRequestTime", l2).commit();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "updata last process time");
  }
  
  public abstract void b(FileManagerEntity paramFileManagerEntity);
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)localIterator.next())
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (g()) {
      if (FMDataCache.a(paramFileManagerEntity))
      {
        FMDataCache.b(paramFileManagerEntity);
        s();
        h();
      }
    }
    do
    {
      return;
      FMDataCache.a(paramFileManagerEntity);
      break;
      if (d()) {
        break label68;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    label68:
    q();
    Object localObject = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "file_viewer_in";
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
    ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).c(paramFileManagerEntity.cloudType);
    ((ForwardFileInfo)localObject).a(10001);
    ((ForwardFileInfo)localObject).b(paramFileManagerEntity.nSessionId);
    ((ForwardFileInfo)localObject).c(paramFileManagerEntity.uniseq);
    ((ForwardFileInfo)localObject).d(paramFileManagerEntity.fileName);
    ((ForwardFileInfo)localObject).d(paramFileManagerEntity.fileSize);
    ((ForwardFileInfo)localObject).b(paramFileManagerEntity.Uuid);
    ((ForwardFileInfo)localObject).a(paramFileManagerEntity.strFilePath);
    paramFileManagerEntity = new Intent(a(), FileBrowserActivity.class);
    paramFileManagerEntity.putExtra("fileinfo", (Parcelable)localObject);
    a().startActivityForResult(paramFileManagerEntity, 102);
  }
  
  public void c(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        b((FileManagerEntity)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 484	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: getstatic 36	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: ldc_w 574
    //   15: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 65	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_c_of_type_Boolean	Z
    //   22: istore_1
    //   23: iload_1
    //   24: ifeq +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 65	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_c_of_type_Boolean	Z
    //   35: aload_0
    //   36: getfield 53	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: getfield 53	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   46: invokeinterface 461 1 0
    //   51: aload_0
    //   52: getfield 53	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: ifnonnull +14 -> 69
    //   58: aload_0
    //   59: new 103	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 104	java/util/ArrayList:<init>	()V
    //   66: putfield 53	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   69: new 576	dlk
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 577	dlk:<init>	(Lcom/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView;)V
    //   77: invokestatic 581	com/tencent/mobileqq/app/ThreadManager:b	(Ljava/lang/Runnable;)V
    //   80: goto -53 -> 27
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	QfileBaseRecentFileTabView
    //   22	2	1	bool	boolean
    //   83	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	83	finally
    //   18	23	83	finally
    //   30	51	83	finally
    //   51	69	83	finally
    //   69	80	83	finally
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getWindow().getDecorView().getHeight() / 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), i);
  }
  
  public void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    localActionSheet.a(getResources().getStringArray(2131230747)[0], 3);
    localActionSheet.a(new dmd(this, localActionSheet));
    localActionSheet.setOnDismissListener(new dme(this));
    localActionSheet.setOnCancelListener(new dmf(this));
    localActionSheet.d(2131362794);
    localActionSheet.show();
  }
  
  public void i()
  {
    a(new dlx(this));
  }
  
  public void j()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.j());
  }
  
  public void n()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.j());
  }
  
  public void setSelect(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() <= paramInt)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "setSelect[" + paramInt + "] faild,becouse GroupCount[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() + "]");
      return;
    }
    a(new dly(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
 * JD-Core Version:    0.7.0.1
 */