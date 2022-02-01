package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import acfp;
import agdq;
import agdq.a;
import agex;
import agmz;
import android.content.Context;
import anot;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDelMediaTabView
  extends QfileLocalFilePicTabView
  implements agdq.a
{
  List<FileInfo> AP = new ArrayList();
  List<String> AQ = new ArrayList();
  List<FileInfo> AR = new ArrayList();
  final int MAX_COUNT = 1000;
  LinkedHashMap<String, List<FileInfo>> T = new LinkedHashMap();
  int cWP = 0;
  boolean isInit = false;
  boolean isRunning = false;
  
  public QfileLocalFileDelMediaTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.BL = 1;
    a(this);
    dfD();
  }
  
  private boolean a(FileInfo paramFileInfo)
  {
    boolean bool2 = false;
    Object localObject = this.R.keySet().iterator();
    String str;
    List localList;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.R.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.R.remove(str);
    }
    boolean bool1 = true;
    this.AP.remove(paramFileInfo);
    localObject = this.T.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localList = (List)this.T.get(str);
      if ((localList != null) && (localList.contains(paramFileInfo)))
      {
        localList.remove(paramFileInfo);
        if (localList.size() == 0) {
          this.T.remove(str);
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      try
      {
        paramFileInfo = a(paramFileInfo);
        localObject = new File(paramFileInfo);
        if (!((File)localObject).exists())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          new StringBuilder().append("file not exists").append(" : ").append(paramFileInfo).toString();
          return bool1;
        }
        ((File)localObject).delete();
        return bool1;
      }
      catch (Exception paramFileInfo)
      {
        QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + paramFileInfo.toString());
        return bool1;
      }
    }
    return bool1;
  }
  
  public int[] S()
  {
    return new int[] { 1, 0 };
  }
  
  public agdq a()
  {
    agex localagex = new agex(a(), this.R, 2);
    localagex.a(this);
    return localagex;
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    String str = paramFileInfo.getPath();
    if (paramFileInfo.isLitePath()) {
      try
      {
        int i = Integer.parseInt(str);
        paramFileInfo = (String)this.AQ.get(i) + paramFileInfo.getName();
        return paramFileInfo;
      }
      catch (Exception paramFileInfo)
      {
        paramFileInfo.printStackTrace();
      }
    }
    return str;
  }
  
  public void a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cWP += 1;
      this.AR.add(paramFileInfo);
      paramFileInfo = a();
      if ((this.cWP != 0) && (this.cWP >= this.AP.size())) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFileInfo.setSelectAllOrCancelAll(paramBoolean);
      return;
      this.cWP -= 1;
      this.AR.remove(paramFileInfo);
      break;
    }
  }
  
  public void dfD()
  {
    setEditbarButton(false, false, false, false, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.runnable = new QfileLocalFileDelMediaTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  public void dfP()
  {
    this.cWP = this.AP.size();
    this.AR.addAll(this.AP);
    long l = agmz.fP() / 1048576L;
    anot.a(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", 2, 0, "" + this.cWP, "" + l, "", "");
    super.dfP();
  }
  
  public void dfQ()
  {
    this.cWP = 0;
    this.AR.clear();
    super.dfQ();
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    if ((this.AR == null) || (this.AR.size() == 0)) {
      return;
    }
    paramSet = this.AR.iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (paramSet.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramSet.next();
      if (!a(localFileInfo)) {
        break label164;
      }
      l2 += localFileInfo.getSize();
      l1 = 1L + l1;
    }
    label164:
    for (;;)
    {
      break;
      this.AR.clear();
      refreshUI();
      l2 /= 1048576L;
      anot.a(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", 2, 0, "" + l1, "" + l2, "", "");
      return;
    }
  }
  
  public void onResume()
  {
    if (this.isInit) {
      refreshUI();
    }
  }
  
  public void onStart()
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.deR();
    this.b.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
    if (this.AP != null) {}
    for (int i = this.AP.size();; i = 0)
    {
      BaseFileAssistantActivity localBaseFileAssistantActivity = a();
      if ((i == 0) || (this.cWP < i)) {
        bool = true;
      }
      localBaseFileAssistantActivity.setSelectAllOrCancelAll(bool);
      return;
    }
  }
  
  public void setSortType(int paramInt)
  {
    super.setSortType(paramInt);
    this.R.clear();
    switch (paramInt)
    {
    }
    for (;;)
    {
      refreshUI();
      setSelect(0);
      return;
      anot.a(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 2, 0, "", "", "", "");
      if (this.AP.size() > 0)
      {
        this.R.put(acfp.m(2131711096), this.AP);
        continue;
        anot.a(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", 2, 0, "", "", "", "");
        this.R.putAll(this.T);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView
 * JD-Core Version:    0.7.0.1
 */