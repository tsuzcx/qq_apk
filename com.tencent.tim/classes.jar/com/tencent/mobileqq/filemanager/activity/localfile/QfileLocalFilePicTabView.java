package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import agdp;
import agdq;
import agdq.a;
import agdu;
import aggc;
import aggd;
import agge;
import agkf;
import agmz;
import agvl;
import agvn;
import agvq;
import ahaf;
import ahao;
import ahap;
import ahau;
import ahau.a;
import ahav;
import ahbj;
import ahbo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anot;
import aqha;
import aqha.a;
import aqju;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sxx;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  agdq.a jdField_a_of_type_Agdq$a = null;
  agdu jdField_a_of_type_Agdu;
  protected QfilePinnedHeaderExpandableListView.a a;
  private View.OnClickListener eT = new agge(this);
  private View.OnClickListener eU = new aggd(this);
  
  public QfileLocalFilePicTabView(Context paramContext, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new aggc(this);
    setEditbarButton(true, false, true, true, true);
    this.runnable = new QfileLocalFilePicTabView.1(this);
  }
  
  private void I(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (agdp)paramView.getTag();
    paramView = (FileInfo)((agdp)localObject2).entity;
    Object localObject1 = ((agdp)localObject2).b;
    if (paramView == null) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akM()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akN()))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      ((SharedPreferences.Editor)localObject3).putInt("GROUP", ((agdp)localObject2).cWI);
      ((SharedPreferences.Editor)localObject3).putInt("CHILD", (((agdp)localObject2).position + 1) / 4);
      ((SharedPreferences.Editor)localObject3).commit();
    }
    this.app.a().aIH();
    if (paramBoolean) {
      if (agmz.d(paramView))
      {
        agmz.e(paramView);
        b(paramView, false);
        label139:
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.aWg) && (!ahbj.fileExistsAndNotEmpty(paramView.getPath())))
        {
          ahao.JD(ahav.kY(paramView.getName()) + acfp.m(2131711093));
          agmz.e(paramView);
        }
        refreshList();
        deR();
        dgf();
      }
    }
    for (;;)
    {
      IW(akL());
      return;
      agmz.d(paramView);
      b(paramView, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) || (agmz.hasFlag(agmz.cXZ)) || (agmz.e(paramView))) {
        break label139;
      }
      localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700303);
      ((aqju)localObject1).setPositiveButton(2131721303, new aqha.a());
      ((aqju)localObject1).show();
      agmz.setFlag(agmz.cXZ);
      ahau.JH("0X800942D");
      break label139;
      if (!H())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(TAG, 2, "click too fast , wait a minute.");
        return;
      }
      if (akL()) {
        anot.a(this.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      aM();
      localObject2 = ahav.a(paramView);
      localObject3 = new agvl(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject2, 10000);
      if (((FileManagerEntity)localObject2).nFileType == 0)
      {
        Object localObject4 = new ArrayList();
        if (this.R != null)
        {
          Iterator localIterator = this.R.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((ArrayList)localObject4).addAll((Collection)this.R.get(str));
          }
        }
        agmz.en((ArrayList)localObject4);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("clicked_file_hashcode", paramView.hashCode());
        ((agvl)localObject3).cB((Bundle)localObject4);
      }
      localObject3 = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (agvq)localObject3);
      ((agvn)localObject3).Oy(8);
      if (((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131367020) || (((View)localObject1).getId() == 2131368820))) {
        ((agvn)localObject3).k(sxx.getViewRect((View)localObject1));
      }
      ((agvn)localObject3).djN();
      localObject1 = new ahau.a();
      ((ahau.a)localObject1).bJE = "file_viewer_in";
      ((ahau.a)localObject1).cYX = 80;
      ((ahau.a)localObject1).bJF = ahbj.getExtension(paramView.getName());
      ((ahau.a)localObject1).nFileSize = paramView.getSize();
      ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject1);
      ahau.JH("0X8004AE5");
    }
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {}
    while ((akL()) && (((agmz.d(paramFileInfo)) && (paramBoolean)) || ((!agmz.d(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label70;
      }
      if (this.jdField_a_of_type_Agdq$a != null) {
        this.jdField_a_of_type_Agdq$a.a(paramFileInfo, true);
      }
      agmz.d(paramFileInfo);
    }
    for (;;)
    {
      return true;
      label70:
      if (this.jdField_a_of_type_Agdq$a != null) {
        this.jdField_a_of_type_Agdq$a.a(paramFileInfo, false);
      }
      agmz.e(paramFileInfo);
    }
  }
  
  private Map<String, List<FileInfo>> am()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(acfp.m(2131711091), new ArrayList());
    localLinkedHashMap.put(acfp.m(2131711090), new ArrayList());
    Iterator localIterator = this.wB.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      Object localObject2 = localFileInfo.getGroupName();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase("TIMfile_recv")))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        localObject1 = acfp.m(2131711082);
      }
      localObject2 = localObject1;
      if (((String)localObject1).equalsIgnoreCase("camera") == true) {
        localObject2 = acfp.m(2131711106);
      }
      if (!localLinkedHashMap.containsKey(localObject2)) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject2)).add(localFileInfo);
    }
    Object localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    return localLinkedHashMap;
  }
  
  private void dgi()
  {
    if (this.cdi) {}
    for (HashMap localHashMap = (HashMap)ahap.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject1 = this.AS.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ahap.a(true, ((QfileTabBarView.a)((Iterator)localObject1).next()).wd(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
        }
        if (this.cdi)
        {
          localObject1 = ahaf.a().vY();
          if (localObject1 != null) {
            ahap.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, this);
          }
          if (!akZ()) {
            break label120;
          }
        }
        for (;;)
        {
          return;
          localObject1 = null;
          break;
          label120:
          ahap.ai(localHashMap);
          if (localHashMap != null)
          {
            localObject1 = localHashMap.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (String)((Iterator)localObject1).next();
              if (!"TIMfile_recv".equalsIgnoreCase((String)localObject2))
              {
                localObject2 = (List)localHashMap.get(localObject2);
                this.wB.addAll((Collection)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  protected agdq a()
  {
    this.jdField_a_of_type_Agdu = new agdu(a(), this.R, this.m, this.eT, this.eU, this.g, this.eX);
    return this.jdField_a_of_type_Agdu;
  }
  
  protected void a(agdq.a parama)
  {
    this.jdField_a_of_type_Agdq$a = parama;
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    runOnUiThread(new QfileLocalFilePicTabView.2(this, paramFileInfo));
  }
  
  protected boolean c(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.getGroupName();
    this.wB.remove(paramFileInfo);
    if (!this.R.containsKey(str))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.R.get(str)).remove(paramFileInfo);
    refreshUI();
    return true;
  }
  
  protected void dfD()
  {
    ThreadManagerV2.excute(this.runnable, 64, null, true);
  }
  
  public void dfI()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileLocalFilePicTabView.3(this));
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        c((FileInfo)paramSet.next());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(true, false, true, true, true);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akQ())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
        break label61;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlP();
    }
    for (;;)
    {
      Nx();
      this.b.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
      return;
      label61:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */