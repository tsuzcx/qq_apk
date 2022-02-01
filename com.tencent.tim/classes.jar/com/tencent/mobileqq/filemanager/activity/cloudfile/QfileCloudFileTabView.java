package com.tencent.mobileqq.filemanager.activity.cloudfile;

import agdp;
import agdq;
import agdy;
import agep;
import ageq;
import ager;
import aget;
import ageu;
import agev;
import agew;
import aghq;
import aghw;
import agkf;
import agkh;
import agmz;
import agvn;
import agvs;
import ahao;
import ahau;
import ahav;
import ahbj;
import ahbk;
import ahbo;
import ahcb;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anot;
import aqha;
import aqha.a;
import aqiw;
import aqju;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  aghq jdField_a_of_type_Aghq = null;
  QfilePinnedHeaderExpandableListView.a jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new ageu(this);
  private ahbk jdField_b_of_type_Ahbk;
  a jdField_b_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$a = null;
  public String bGR;
  final int cWM = 15;
  public int cWN = 0;
  private int cWO;
  private boolean cda;
  private boolean cdb;
  private boolean cdc;
  public boolean cdd = false;
  private View.OnClickListener eT = new agev(this);
  private View.OnClickListener eU = new agew(this);
  
  public QfileCloudFileTabView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.cWO = paramInt;
    pZ(paramString);
  }
  
  private void I(View paramView, boolean paramBoolean)
  {
    paramView = (WeiYunFileInfo)((agdp)paramView.getTag()).entity;
    this.app.a().aIH();
    if (paramBoolean) {
      if (agmz.c(paramView))
      {
        agmz.d(paramView);
        deR();
        refreshList();
      }
    }
    for (;;)
    {
      IT(akL());
      do
      {
        return;
        agmz.c(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setDocsCheck(true);
        if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akO()) || (agmz.hasFlag(agmz.cYa))) {
          break;
        }
        paramView = aqha.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131700305);
        paramView.setPositiveButton(2131721303, new aqha.a());
        paramView.show();
        agmz.setFlag(agmz.cYa);
        ahau.JH("0X800942F");
        break;
        if (H()) {
          break label152;
        }
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "click too fast , wait a minute.");
      return;
      label152:
      if (akL()) {
        anot.a(this.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      aM();
      ahau.JH("0X8004AE6");
      agvs localagvs = new agvs(this.app, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
      if (ahav.getFileType(paramView.strFileName) == 0) {
        localagvs.eq(a(paramView));
      }
      paramView = new agvn(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localagvs);
      paramView.Oy(9);
      paramView.djN();
    }
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_Ahbk == null) {
      this.jdField_b_of_type_Ahbk = new ageq(this);
    }
    if (this.id.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlo();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_b_of_type_Ahbk);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlt();
      continue;
      if (this.id.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlp();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlu();
        }
      }
      else if (this.id.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlq();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlv();
        }
      }
      else if (this.id.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlr();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlw();
        }
      }
      else if (this.id.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.akI()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dls();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().dlx();
        }
      }
    }
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((ahav.getFileType(ahbj.getExtension(paramWeiYunFileInfo.strFileName)) != 0) || ((akL()) && (((agmz.c(paramWeiYunFileInfo)) && (paramBoolean)) || ((!agmz.c(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label65;
      }
      agmz.c(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      agmz.d(paramWeiYunFileInfo);
    }
  }
  
  private void pZ(String paramString)
  {
    this.id = paramString;
    if (this.jdField_a_of_type_Aghq == null) {
      bMC();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$a == null) {
      dfH();
    }
    IS(false);
  }
  
  protected void IS(boolean paramBoolean)
  {
    this.cdc = paramBoolean;
    this.app.a().b(this.cWO, this.id, 0, 15, this.bGR);
  }
  
  protected agdq a()
  {
    if (this.id.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new agdy(this.jdField_b_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$a, a(), this.R, this.m, this.eT, this.eU, this.g, this.eX);
    }
    setEditbarButton(false, true, false, true, true);
    return new agep(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.wB.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.wB.remove(paramWeiYunFileInfo);
    String str = ahcb.bt(paramWeiYunFileInfo.mtime);
    if (!this.R.containsKey(str))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.R.get(str)).remove(paramWeiYunFileInfo);
    if (((List)this.R.get(str)).size() == 0) {
      this.R.remove(str);
    }
    refreshUI();
    return true;
  }
  
  void bMC()
  {
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
    }
    this.jdField_a_of_type_Aghq = new aget(this);
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
  }
  
  public void dfD()
  {
    runOnUiThread(new QfileCloudFileTabView.4(this));
  }
  
  void dfH()
  {
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$a = new ager(this);
  }
  
  public void dfI()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileCloudFileTabView.7(this));
  }
  
  public boolean isEnd()
  {
    return this.cda;
  }
  
  public void onGetMore()
  {
    this.cdc = false;
    if (!aqiw.isNetworkAvailable(a()))
    {
      ahao.OS(2131693819);
      return;
    }
    this.cdd = false;
    this.app.a().b(this.cWO, this.id, this.cWN * 15, 15, this.bGR);
    dfF();
  }
  
  public void onResume()
  {
    super.onResume();
    bMC();
    if (this.cdb) {
      refreshUI();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.id.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      Nx();
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    Nx();
  }
  
  public void onStop()
  {
    super.onStop();
    this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
  }
  
  public static abstract interface a
  {
    public abstract View.OnClickListener a(TextView paramTextView);
    
    public abstract boolean akX();
    
    public abstract boolean akY();
    
    public abstract boolean isEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */