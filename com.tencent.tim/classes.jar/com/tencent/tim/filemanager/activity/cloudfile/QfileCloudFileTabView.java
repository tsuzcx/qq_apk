package com.tencent.tim.filemanager.activity.cloudfile;

import anaz;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqiw;
import atpo;
import atpu;
import atpw;
import atqm;
import atqn;
import atqo;
import atqq;
import atqr;
import atsn;
import atso;
import atti;
import atwb;
import auds;
import audx;
import aueh;
import auei;
import auej;
import auem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  QfilePinnedHeaderExpandableListView.a a;
  private auei jdField_b_of_type_Auei;
  a jdField_b_of_type_ComTencentTimFilemanagerActivityCloudfileQfileCloudFileTabView$a = null;
  final int cWM = 15;
  public int cWN = 0;
  private boolean cda;
  private boolean cdb;
  private boolean cdc;
  public boolean cdd = false;
  atsn d = null;
  public String id = null;
  public long mTimestamp = 0L;
  
  public QfileCloudFileTabView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a = new atqr(this);
    this.id = paramString;
    if (this.d == null) {
      bMC();
    }
    if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityCloudfileQfileCloudFileTabView$a == null) {
      dfH();
    }
    IS(false);
  }
  
  private void Nx()
  {
    if (this.jdField_b_of_type_Auei == null) {
      this.jdField_b_of_type_Auei = new atqn(this);
    }
    if (this.id.equalsIgnoreCase("document") == true) {
      if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
        this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlo();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a(this.jdField_b_of_type_Auei);
      return;
      this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlt();
      continue;
      if (this.id.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlp();
        } else {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlu();
        }
      }
      else if (this.id.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlq();
        } else {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlv();
        }
      }
      else if (this.id.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlr();
        } else {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlw();
        }
      }
      else if (this.id.equalsIgnoreCase("other") == true) {
        if (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.akI()) {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dls();
        } else {
          this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.a().dlx();
        }
      }
    }
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((audx.fM(aueh.getExtension(paramWeiYunFileInfo.strFileName)) != 0) || ((akL()) && (((atwb.c(paramWeiYunFileInfo)) && (paramBoolean)) || ((!atwb.c(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (akL())
    {
      if (!paramBoolean) {
        break label65;
      }
      atwb.c(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      atwb.d(paramWeiYunFileInfo);
    }
  }
  
  protected void IS(boolean paramBoolean)
  {
    this.cdc = paramBoolean;
    this.app.a().f(this.id, 0, 15, anaz.gQ());
  }
  
  protected atpo a()
  {
    if (this.id.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      if ((this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.eqG == 4) || (this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.eqG == 6)) {}
      for (Object localObject = new atpw(this.jdField_b_of_type_ComTencentTimFilemanagerActivityCloudfileQfileCloudFileTabView$a, a(), this.R, this.m, this.n, this.g, this.eX);; localObject = new atpu(this.jdField_b_of_type_ComTencentTimFilemanagerActivityCloudfileQfileCloudFileTabView$a, a(), this.R, this.m, this.n, this.g, this.eX))
      {
        ((atpu)localObject).N(this.gs);
        return localObject;
      }
    }
    setEditbarButton(false, true, false, true, true);
    return new atqm(a(), this.R, a(), this.m, this.n, this.g, this.eX, this.gt);
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.wB.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.wB.remove(paramWeiYunFileInfo);
    String str = auem.cl(paramWeiYunFileInfo.mtime);
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
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
    this.d = new atqq(this);
    this.app.a().addObserver(this.d);
  }
  
  public void dfD()
  {
    runOnUiThread(new QfileCloudFileTabView.4(this));
  }
  
  void dfH()
  {
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityCloudfileQfileCloudFileTabView$a = new atqo(this);
  }
  
  public void dfI()
  {
    this.jdField_b_of_type_ComTencentTimFilemanagerActivityFMActivity.runOnUiThread(new QfileCloudFileTabView.7(this));
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
      auds.OS(2131693819);
      return;
    }
    this.cdd = false;
    this.app.a().f(this.id, this.cWN * 15, 15, this.mTimestamp);
    dfF();
  }
  
  public void onResume()
  {
    super.onResume();
    bMC();
    if (this.cdb) {
      refreshUI();
    }
    if (this.diB)
    {
      IS(true);
      this.diB = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.id.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, false, false, true, true);
      Nx();
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView$a);
      return;
    }
    setEditbarButton(false, false, false, true, true);
    Nx();
  }
  
  public void onStop()
  {
    super.onStop();
    this.app.a().deleteObserver(this.d);
  }
  
  public static abstract interface a
  {
    public abstract View.OnClickListener a(TextView paramTextView);
    
    public abstract boolean akX();
    
    public abstract boolean akY();
    
    public abstract boolean isEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */