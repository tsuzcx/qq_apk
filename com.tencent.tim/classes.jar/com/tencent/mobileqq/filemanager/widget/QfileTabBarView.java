package com.tencent.mobileqq.filemanager.widget;

import acbn;
import acfp;
import ahaf;
import ahdo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqul;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
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
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = null;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  private TabBarView.a jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a = new ahdo(this);
  public TabBarView2 a;
  private int cWT;
  private int cZy;
  public boolean cgj = false;
  public BaseFileAssistantActivity d = null;
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
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131368613));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131379122));
    this.kx = ((RelativeLayout)findViewById(2131379125));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setBackgroundResource(2130851105);
  }
  
  private QfileBaseTabView a(int paramInt)
  {
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return null;
      }
    }
    if (i != 0) {}
    for (Object localObject = new QfileRecentAllFileTabView(this.d, this.mUin);; localObject = new QfileRecentAllFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentTDocFileTabView(this.d, this.mUin);; localObject = new QfileRecentTDocFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentDocFileTabView(this.d, this.mUin);; localObject = new QfileRecentDocFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentPicFileTabView(this.d, this.mUin);; localObject = new QfileRecentPicFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentMediaFileTabView(this.d, this.mUin);; localObject = new QfileRecentMediaFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentAppFileTabView(this.d, this.mUin);; localObject = new QfileRecentAppFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentTencentDocFileTabView(this.d, this.mUin);; localObject = new QfileRecentTencentDocFileTabView(this.d))
    {
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
  }
  
  private QfileBaseTabView b(int paramInt)
  {
    if (this.d.sB() == 8) {}
    String str;
    ArrayList localArrayList;
    for (int i = 1;; i = 0)
    {
      localObject = aqul.getSDKPrivatePath(acbn.SDCARD_PATH) + "/" + "diskcache" + "/";
      str = ShortVideoUtils.zK();
      localArrayList = new ArrayList();
      localArrayList.add(new a(ahaf.a().vZ(), false, false, true));
      switch (paramInt)
      {
      default: 
        return null;
      }
    }
    Object localObject = new QfileLocalFileAppTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileDelFileTabView(this.d, localArrayList, new Pair(acfp.m(2131711115), Integer.valueOf(5)));
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFilePicTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    if (i != 0) {
      localArrayList.add(new a((String)localObject, true, true, true));
    }
    localObject = new QfileLocalFileDelPicTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileDocTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileDelFileTabView(this.d, localArrayList, new Pair(acfp.m(2131711114), Integer.valueOf(3)));
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localArrayList.add(new a(ahaf.a().wa(), true, false, false));
    localArrayList.add(new a(ahaf.a().vZ() + ".trooptmp", true, false, false));
    localObject = new QfileLocalFileDelFileTabView(this.d, localArrayList, new Pair(acfp.m(2131711116), Integer.valueOf(11)));
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.d, 3, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    if (i != 0) {
      localArrayList.add(new a(str, false, true, true));
    }
    localObject = new QfileLocalFileDelMediaTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.d, 1, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.d, 2, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
    localObject = new QfileLocalFileOtherTabView(this.d, localArrayList, true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
  }
  
  private QfileBaseTabView c(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(new a(acbn.SDCARD_ROOT + "/Tencent/MicroMsg/Download/", false, false, true));
    ((List)localObject).add(new a(acbn.SDCARD_ROOT + "/Tencent/MicroMsg/WeiXin/", false, false, true));
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      localObject = new QfileCloudFileTabView(this.d, "document", this.cZy);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 15: 
      localObject = new QfileCloudFileTabView(this.d, "picture", this.cZy);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 17: 
      localObject = new QfileCloudFileTabView(this.d, "video", this.cZy);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 18: 
      localObject = new QfileCloudFileTabView(this.d, "music", this.cZy);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 19: 
      localObject = new QfileCloudFileTabView(this.d, "other", this.cZy);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 1118: 
      localObject = new QfileLocalFileAppTabView(this.d, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 1111: 
      localObject = new QfileLocalFileMediaTabView(this.d, 3, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 1119: 
      localObject = new QfileLocalFilePicTabView(this.d, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    case 1110: 
      localObject = new QfileLocalFileDocTabView(this.d, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).onCreate();
      return localObject;
    }
    localObject = new QfileLocalFileOtherTabView(this.d, (List)localObject, false);
    ((QfileBaseTabView)localObject).setFromWeiXin(true);
    ((QfileBaseTabView)localObject).onCreate();
    return localObject;
  }
  
  private void doReport(int paramInt)
  {
    if (!this.N.containsKey(Integer.valueOf(paramInt))) {}
    do
    {
      do
      {
        return;
        switch (((Integer)this.N.get(Integer.valueOf(paramInt))).intValue())
        {
        default: 
          return;
        case 3: 
          if (this.cWT == 1)
          {
            anot.a(this.d.app, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
            return;
          }
          break;
        case 1118: 
          anot.a(this.d.app, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
          return;
        case 1111: 
          anot.a(this.d.app, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
          return;
        case 1119: 
          anot.a(this.d.app, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
          return;
        case 1110: 
          anot.a(this.d.app, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
          return;
        case 1114: 
          anot.a(this.d.app, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
          return;
        }
      } while (this.cWT != 2);
      anot.a(this.d.app, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      return;
      if (this.cWT == 1)
      {
        anot.a(this.d.app, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
        return;
      }
    } while (this.cWT != 2);
    anot.a(this.d.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
    return;
    anot.a(this.d.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
  }
  
  public void OW(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setVisibility(paramInt);
  }
  
  public int[] R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.S();
  }
  
  public ListView b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.b();
    }
    return null;
  }
  
  public void cw(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.lR, paramString, false, false, true);
    this.N.put(Integer.valueOf(this.lR), Integer.valueOf(paramInt));
    this.lR += 1;
  }
  
  public QfileBaseTabView d(int paramInt)
  {
    try
    {
      localObject1 = (QfileBaseTabView)this.kU.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        return localObject1;
      }
      i = ((Integer)this.N.get(Integer.valueOf(paramInt))).intValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        QLog.e("QfileTabBarView<FileAssistant>", 1, "tabPos[" + paramInt + "]");
        int i = 3;
      }
    }
    localObject2 = a(i);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(i);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = c(i);
    }
    ((QfileBaseTabView)localObject2).setFocusable(false);
    if ((localObject2 instanceof QfileBaseRecentFileTabView)) {
      ((QfileBaseRecentFileTabView)localObject2).setAttribution(this.cWT);
    }
    if ((this.d instanceof FMActivity)) {
      ((FMActivity)this.d).a().setAttribution(i);
    }
    this.kU.put(Integer.valueOf(paramInt), localObject2);
    return localObject2;
  }
  
  public void dmJ()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.YO(0);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelected(false);
    this.N.clear();
    this.kU.clear();
    this.kT.clear();
    this.kx.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public int eA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.eA();
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.ei(paramArrayList);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.ek(paramArrayList);
  }
  
  public void hG(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = d(paramInt);
    if (localQfileBaseTabView == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
    {
      if (isResume()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.onPause();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.onStop();
      this.kx.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.onStart();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
      if (isResume()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.onResume();
      }
      this.kx.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView, -1, -1);
    }
    doReport(paramInt);
  }
  
  boolean isResume()
  {
    return true;
  }
  
  public void k(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.lR, paramString);
    this.N.put(Integer.valueOf(this.lR), Integer.valueOf(paramInt));
    this.lR += 1;
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    Iterator localIterator = this.kU.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.kU.get(Integer.valueOf(i))).m(paramSet);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refreshUI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.refreshUI();
    }
  }
  
  public void setAttribution(int paramInt)
  {
    this.cWT = paramInt;
  }
  
  public void setHeaderScrollView(HeaderScrollView paramHeaderScrollView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = paramHeaderScrollView;
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.clearSelected();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelectedTab(i, true);
      }
    }
  }
  
  public void setSortType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setSortType(paramInt);
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.d.akL())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.Ec();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.resetData();
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void setWYSubAppId(int paramInt)
  {
    this.cZy = paramInt;
  }
  
  public class a
  {
    private String aTN;
    private boolean cgk;
    private boolean cgl;
    private boolean cgm = true;
    
    public a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.aTN = paramString;
      this.cgk = paramBoolean1;
      this.cgl = paramBoolean2;
      this.cgm = paramBoolean3;
    }
    
    public boolean amS()
    {
      return this.cgk;
    }
    
    public boolean amT()
    {
      return this.cgl;
    }
    
    public String wd()
    {
      return this.aTN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */