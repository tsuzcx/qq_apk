package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import agdq;
import agdq.a;
import agga;
import agmz;
import android.content.Context;
import anot;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalFileDelFileTabView
  extends QfileLocalFileDocTabView
  implements agdq.a
{
  List<FileInfo> AP = new ArrayList();
  List<String> AQ = new ArrayList();
  List<FileInfo> AR = new ArrayList();
  final int MAX_COUNT = 1000;
  LinkedHashMap<String, List<FileInfo>> T = new LinkedHashMap();
  LinkedHashMap<String, List<FileInfo>> U = new LinkedHashMap();
  int cWP = 0;
  boolean isInit = false;
  boolean isRunning = false;
  Pair<String, Integer> j;
  int searchType = -1;
  
  public QfileLocalFileDelFileTabView(Context paramContext, List<QfileTabBarView.a> paramList, Pair<String, Integer> paramPair)
  {
    super(paramContext, paramList, false);
    this.BL = 1;
    this.j = paramPair;
    this.searchType = ((Integer)this.j.second).intValue();
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
    do
    {
      bool2 = bool1;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
      localList = (List)this.T.get(str);
    } while ((localList == null) || (!localList.contains(paramFileInfo)));
    localList.remove(paramFileInfo);
    if (localList.size() == 0) {
      this.T.remove(str);
    }
    bool2 = true;
    localObject = this.U.keySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localList = (List)this.U.get(str);
        if ((localList != null) && (localList.contains(paramFileInfo)))
        {
          localList.remove(paramFileInfo);
          if (localList.size() == 0) {
            this.U.remove(str);
          }
        }
      }
    }
    for (bool1 = true;; bool1 = bool2) {
      try
      {
        localObject = a(paramFileInfo);
        paramFileInfo = new File((String)localObject);
        if (!paramFileInfo.exists())
        {
          paramFileInfo = "file not exists";
          if (QLog.isColorLevel()) {
            paramFileInfo = "file not exists" + " : " + (String)localObject;
          }
          QLog.w("delDownloadFiles<FileAssistant>", 1, paramFileInfo);
          return bool1;
        }
        paramFileInfo.delete();
        return bool1;
      }
      catch (Exception paramFileInfo)
      {
        QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + paramFileInfo.toString());
        return bool1;
      }
    }
  }
  
  private int getReportType()
  {
    switch (this.searchType)
    {
    default: 
      return -1;
    case 3: 
      return 1;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public int[] S()
  {
    if (this.searchType == 5) {
      return new int[] { 1, 0 };
    }
    return new int[] { 1, 0, 2 };
  }
  
  public agdq a()
  {
    agga localagga = new agga(a(), this.R, a(), this.m, this.n, this.g, this.eX);
    localagga.a(this);
    return localagga;
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
      catch (Exception paramFileInfo) {}
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
  
  public void b(FileInfo paramFileInfo, boolean paramBoolean)
  {
    super.b(paramFileInfo, paramBoolean);
    a(paramFileInfo, paramBoolean);
  }
  
  public void dfD()
  {
    setEditbarButton(false, false, false, false, true);
    this.a.a(this);
    this.runnable = new QfileLocalFileDelFileTabView.1(this);
    ThreadManager.executeOnFileThread(this.runnable);
  }
  
  public void dfP()
  {
    this.cWP = this.AP.size();
    this.AR.addAll(this.AP);
    long l = agmz.fP() / 1048576L;
    anot.a(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", getReportType(), 0, "" + this.cWP, "" + l, "", "");
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
    if (this.AR.size() == 0) {
      return;
    }
    Iterator localIterator = this.AR.iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      if (!a(localFileInfo)) {
        break label173;
      }
      paramSet.remove(localFileInfo);
      l2 += localFileInfo.getSize();
      l1 = 1L + l1;
    }
    label173:
    for (;;)
    {
      break;
      this.AR.clear();
      refreshUI();
      l2 /= 1048576L;
      anot.a(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", getReportType(), 0, "" + l1, "" + l2, "", "");
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
    super.onStart();
    this.a.a(this);
    this.b.setOnGroupClickListener(null);
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
    switch (this.BL)
    {
    }
    for (;;)
    {
      refreshUI();
      setSelect(0);
      return;
      anot.a(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", getReportType(), 0, "", "", "", "");
      if (this.AP.size() > 0)
      {
        this.R.put(this.j.first, this.AP);
        continue;
        anot.a(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", getReportType(), 0, "", "", "", "");
        this.R.putAll(this.T);
        continue;
        anot.a(null, "dc00898", "", "", "0X800A0CA", "0X800A0CA", getReportType(), 0, "", "", "", "");
        this.R.putAll(this.U);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView
 * JD-Core Version:    0.7.0.1
 */