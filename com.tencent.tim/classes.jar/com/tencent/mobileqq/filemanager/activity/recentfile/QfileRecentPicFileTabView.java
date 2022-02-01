package com.tencent.mobileqq.filemanager.activity.recentfile;

import acfp;
import agdp;
import agdq;
import agdw;
import aggy;
import aggz;
import agha;
import aghb;
import aghc;
import aghq;
import aghw;
import agkf;
import agkh;
import agmz;
import agvl;
import agvn;
import agvq;
import ahao;
import ahau;
import ahau.a;
import ahav;
import ahbj;
import ahbk;
import ahbo;
import ahcb;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import anot;
import aqha;
import aqha.a;
import aqiw;
import aqju;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import sxx;

public class QfileRecentPicFileTabView
  extends QfileBaseRecentFileTabView
{
  private aghq jdField_a_of_type_Aghq;
  QfilePinnedHeaderExpandableListView.a jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new agha(this);
  private ahbk b;
  private View.OnClickListener eT = new aghb(this);
  private View.OnClickListener eU = new aghc(this);
  
  public QfileRecentPicFileTabView(Context paramContext)
  {
    super(paramContext);
    if (this.jdField_a_of_type_Aghq == null) {
      bMC();
    }
    dgj();
    setEditbarButton(true, true, true, true, true);
  }
  
  public QfileRecentPicFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void I(View paramView, boolean paramBoolean)
  {
    Object localObject1 = (agdp)paramView.getTag();
    paramView = (FileManagerEntity)((agdp)localObject1).entity;
    localObject1 = ((agdp)localObject1).b;
    if (paramView == null) {}
    do
    {
      return;
      this.app.a().aIH();
      if (paramBoolean)
      {
        if (agmz.b(paramView)) {
          agmz.b(paramView);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.aWg) && (paramView.cloudType == 3) && (!ahbj.fileExistsAndNotEmpty(paramView.getFilePath())))
          {
            ahao.JD(ahav.kY(paramView.fileName) + acfp.m(2131711112));
            agmz.b(paramView);
          }
          deR();
          refreshList();
          return;
          agmz.a(paramView);
          if (f(paramView))
          {
            localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700303);
            ((aqju)localObject1).setPositiveButton(2131721303, new aqha.a());
            ((aqju)localObject1).show();
            agmz.setFlag(agmz.cXZ);
            ahau.JH("0X800942D");
          }
        }
      }
      if (akL()) {
        anot.a(this.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (H()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "click too fast , wait a minute.");
    return;
    aM();
    Object localObject2 = new ahau.a();
    ((ahau.a)localObject2).bJE = "file_viewer_in";
    ((ahau.a)localObject2).cYX = 73;
    ((ahau.a)localObject2).bJF = ahbj.getExtension(paramView.fileName);
    ((ahau.a)localObject2).nFileSize = paramView.fileSize;
    ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject2);
    ahau.JH("0X8004AE4");
    localObject2 = new agvl(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akM());
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", this.mUin);
    }
    ((agvl)localObject2).cB(localBundle);
    localObject2 = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (agvq)localObject2);
    ((agvn)localObject2).Oy(7);
    if (((paramView.nFileType == 0) || (paramView.nFileType == 2)) && (localObject1 != null) && ((((View)localObject1).getId() == 2131367020) || (((View)localObject1).getId() == 2131368820)))
    {
      ((agvn)localObject2).k(sxx.getViewRect((View)localObject1));
      ((agvn)localObject2).JE(true);
    }
    if (paramView.nFileType == 2)
    {
      if (ahbj.fileExistsAndNotEmpty(paramView.getFilePath()))
      {
        ((agvn)localObject2).djN();
        return;
      }
      if ((paramView.isSend()) && (!ahbj.fileExistsAndNotEmpty(paramView.getFilePath())) && (paramView.status != 1) && (paramView.status != -1))
      {
        ahao.JD(acfp.m(2131711109));
        return;
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ahao.OS(2131693819);
        return;
      }
      ((agvn)localObject2).djN();
      return;
    }
    ((agvn)localObject2).djN();
  }
  
  private void Nx()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlF();
    }
    while (this.jdField_b_of_type_Ahbk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_b_of_type_Ahbk);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlK();
    }
    this.jdField_b_of_type_Ahbk = new aggz(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_b_of_type_Ahbk);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 0) || ((akL()) && (((agmz.b(paramFileManagerEntity)) && (paramBoolean)) || ((!agmz.b(paramFileManagerEntity)) && (!paramBoolean))))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label59;
      }
      agmz.a(paramFileManagerEntity);
    }
    for (;;)
    {
      return true;
      label59:
      agmz.b(paramFileManagerEntity);
    }
  }
  
  private void bMC()
  {
    this.jdField_a_of_type_Aghq = new aggy(this);
  }
  
  private boolean f(FileManagerEntity paramFileManagerEntity)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) && (!agmz.hasFlag(agmz.cXZ)) && (!agmz.n(paramFileManagerEntity));
  }
  
  protected agdq a()
  {
    return new agdw(a(), this.R, this.m, this.eT, this.eU, this.g, this.eX);
  }
  
  protected void dfD()
  {
    if (this.AT == null) {
      return;
    }
    this.R.clear();
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
    }
    Iterator localIterator = this.AT.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.bDelInFM) && (localFileManagerEntity.nFileType == 0))
      {
        if ((!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.getCloudType() != 1) {
            break label194;
          }
          this.app.a().a(localFileManagerEntity, 7);
        }
        for (;;)
        {
          String str = ahcb.bt(localFileManagerEntity.srvTime);
          if (!this.R.containsKey(str)) {
            this.R.put(str, new ArrayList());
          }
          ((List)this.R.get(str)).add(localFileManagerEntity);
          break;
          label194:
          if (localFileManagerEntity.getCloudType() == 2) {
            this.app.a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
          }
        }
      }
    }
    refreshUI();
    setSelect(0);
    IU(true);
    this.cdo = false;
  }
  
  public void dfI()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileRecentPicFileTabView.5(this));
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = ahcb.bt(paramFileManagerEntity.srvTime);
    if (!this.R.containsKey(localObject))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.R)
    {
      localObject = ((List)this.R.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      refreshUI();
      return true;
    }
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        e((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  protected void g(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " refreshRecentFileRecords");
    }
    if (!this.AT.contains(paramFileManagerEntity)) {
      if ((this.mUin == null) || (this.mUin.trim().length() == 0) || (this.mUin.equals(paramFileManagerEntity.peerUin))) {}
    }
    while (paramFileManagerEntity.nFileType != 0)
    {
      return;
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
    }
    runOnUiThread(new QfileRecentPicFileTabView.3(this, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(true, true, true, true, true);
    Nx();
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
  }
  
  public void onStop()
  {
    super.onStop();
    this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView
 * JD-Core Version:    0.7.0.1
 */