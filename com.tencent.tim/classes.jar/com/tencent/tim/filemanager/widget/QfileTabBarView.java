package com.tencent.tim.filemanager.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aufi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView;
import com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.tim.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.tim.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public HashMap<Integer, Integer> N = new LinkedHashMap();
  private TabBarView.a jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a = new aufi(this);
  public TabBarView a;
  QfileBaseTabView jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView = null;
  a jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView$a;
  private QfileEditBottomBar c;
  public boolean cgj = false;
  public BaseFileAssistantActivity d = null;
  public int erq = 0;
  int ers = -1;
  HashMap<Integer, Class<? extends QfileBaseTabView>> kT = new HashMap();
  HashMap<Integer, QfileBaseTabView> kU = new HashMap();
  RelativeLayout kx;
  public int lR;
  String mUin;
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561029, this);
    this.d = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131379122));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(paramContext.getResources().getColor(2131165692));
    this.kx = ((RelativeLayout)findViewById(2131379125));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a);
  }
  
  @TargetApi(14)
  private void aaG(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16384);
      localAccessibilityEvent.setPackageName(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.b(paramInt).getContext().getPackageName());
      localAccessibilityEvent.setClassName(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.b(paramInt).getClass().getName());
      localAccessibilityEvent.getText().add("已选定" + this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.b(paramInt).getText());
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.requestSendAccessibilityEvent(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.b(paramInt), localAccessibilityEvent);
    }
  }
  
  public void OW(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(paramInt);
  }
  
  public QfileBaseTabView a(int paramInt)
  {
    for (;;)
    {
      try
      {
        QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.kU.get(Integer.valueOf(paramInt));
        if (localQfileBaseTabView != null) {
          return localQfileBaseTabView;
        }
        QLog.e("QfileTabBarView<FileAssistant>", 1, "tabPos[" + paramInt + "]");
      }
      catch (Exception localException1)
      {
        try
        {
          i = ((Integer)this.N.get(Integer.valueOf(paramInt))).intValue();
          if ((this.mUin == null) || (this.mUin.trim().length() == 0)) {
            break label317;
          }
          j = 1;
          switch (i)
          {
          default: 
            localQfileBaseTabView.setFocusable(false);
            this.kU.put(Integer.valueOf(paramInt), localQfileBaseTabView);
            return localQfileBaseTabView;
          }
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          Object localObject;
          break label280;
        }
        localException1 = localException1;
        localObject = null;
      }
      label280:
      i = 3;
      continue;
      label317:
      j = 0;
      continue;
      if (j != 0) {}
      for (localObject = new QfileRecentAllFileTabView(this.d, this.mUin);; localObject = new QfileRecentAllFileTabView(this.d))
      {
        if (this.ers != -1) {
          ((QfileBaseRecentFileTabView)localObject).setCloudType(this.ers);
        }
        ((QfileBaseTabView)localObject).onCreate();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentDocFileTabView(this.d, this.mUin);; localObject = new QfileRecentDocFileTabView(this.d))
      {
        if (this.ers != -1) {
          ((QfileBaseRecentFileTabView)localObject).setCloudType(this.ers);
        }
        ((QfileBaseTabView)localObject).onCreate();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentPicFileTabView(this.d, this.mUin);; localObject = new QfileRecentPicFileTabView(this.d))
      {
        if (this.ers != -1) {
          ((QfileBaseRecentFileTabView)localObject).setCloudType(this.ers);
        }
        ((QfileBaseTabView)localObject).onCreate();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentMediaFileTabView(this.d, this.mUin);; localObject = new QfileRecentMediaFileTabView(this.d))
      {
        if (this.ers != -1) {
          ((QfileBaseRecentFileTabView)localObject).setCloudType(this.ers);
        }
        ((QfileBaseTabView)localObject).onCreate();
        break;
      }
      if (j != 0) {}
      for (localObject = new QfileRecentAppFileTabView(this.d, this.mUin);; localObject = new QfileRecentAppFileTabView(this.d))
      {
        if (this.ers != -1) {
          ((QfileBaseRecentFileTabView)localObject).setCloudType(this.ers);
        }
        ((QfileBaseTabView)localObject).onCreate();
        break;
      }
      localObject = new QfileLocalFileAppTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileDelAppTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFilePicTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileDelPicTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileDocTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.d, 3);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileDelMediaTabView(this.d, 3);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.d, 1);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileMediaTabView(this.d, 2);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileLocalFileOtherTabView(this.d);
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileCloudFileTabView(this.d, "document");
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileCloudFileTabView(this.d, "picture");
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileCloudFileTabView(this.d, "video");
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileCloudFileTabView(this.d, "music");
      ((QfileBaseTabView)localObject).onCreate();
      continue;
      localObject = new QfileCloudFileTabView(this.d, "other");
      ((QfileBaseTabView)localObject).onCreate();
    }
  }
  
  public void dmJ()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.YO(0);
      i += 1;
    }
    Iterator localIterator = this.kU.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.kU.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.onDestroy();
      }
    }
    this.lR = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(false);
    this.N.clear();
    this.kU.clear();
    this.kT.clear();
    this.kx.removeView(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.ei(paramArrayList);
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    Iterator localIterator = this.kU.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.kU.get(Integer.valueOf(i))).ej(paramArrayList);
    }
  }
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.ek(paramArrayList);
  }
  
  public void fn(ArrayList<FileInfo> paramArrayList)
  {
    Iterator localIterator = this.kU.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.kU.get(Integer.valueOf(i))).fn(paramArrayList);
    }
  }
  
  public void hG(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView);
      if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.onPause();
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.onStop();
        this.kx.removeView(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    } while (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView == null);
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.onStart();
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
    if (isResume()) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.onResume();
    }
    this.kx.addView(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  boolean isResume()
  {
    return true;
  }
  
  public void k(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.lR, paramString);
    this.N.put(Integer.valueOf(this.lR), Integer.valueOf(paramInt));
    this.lR += 1;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refreshUI()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.refreshUI();
    }
  }
  
  public void setBottomBar(QfileEditBottomBar paramQfileEditBottomBar)
  {
    this.c = paramQfileEditBottomBar;
  }
  
  public void setFilterCloudType(int paramInt)
  {
    this.ers = paramInt;
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.cgj = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.N.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.N.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.clearSelected();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, true);
      }
    }
  }
  
  public void setTabFileType(int paramInt)
  {
    this.erq = paramInt;
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView != null)
    {
      int i = paramInt;
      if (this.d.akL())
      {
        i = paramInt;
        if ((this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
          i = paramInt + this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.Ec();
        }
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFileassistantQfileBaseTabView.resetData();
    }
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void setqFileTabBarViewChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView$a = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */