package com.tencent.mobileqq.activity.history;

import acfp;
import aghq;
import agkf;
import agkh;
import agne;
import agvl;
import agvn;
import agvq;
import agyr;
import agys;
import ahao;
import ahau;
import ahau.a;
import ahav;
import ahbj;
import ahcb;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import ausj;
import auss;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import zfi;
import zfj;
import zfk;
import zfl;
import zfo;
import zfp;
import ziz;
import ziz.b;
import zjl;

public class ChatHistoryC2CFileFragment
  extends ChatHistoryBaseFragment
  implements View.OnClickListener, ziz.b
{
  private LinkedHashMap<String, List<Object>> E;
  private aghq jdField_a_of_type_Aghq;
  private agyr<FileManagerEntity> jdField_a_of_type_Agyr;
  private QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  private ziz jdField_a_of_type_Ziz;
  private boolean bri;
  private boolean brj = true;
  private View.OnClickListener de = new zfl(this);
  private View.OnClickListener df = new zfo(this);
  private LinearLayout hL;
  private RelativeLayout iy;
  private View mRootView;
  private List<FileManagerEntity> uf;
  private View yD;
  
  private void BE(boolean paramBoolean)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CFileFragment.1(this, paramBoolean));
  }
  
  private void BF(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ziz.BG(paramBoolean);
    this.bri = paramBoolean;
    clearSelected();
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Zjl.yi();
      this.yD.setPadding(0, i, 0, 0);
      this.yD.setVisibility(0);
      return;
    }
    this.yD.setPadding(0, 0, 0, 0);
    this.yD.setVisibility(8);
  }
  
  private boolean Vn()
  {
    if (this.uf == null) {
      this.uf = new ArrayList();
    }
    while (this.uf.size() < 20) {
      return false;
    }
    return true;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.uf == null) {
      this.uf = new ArrayList();
    }
    if (!this.uf.contains(paramFileManagerEntity)) {
      this.uf.add(paramFileManagerEntity);
    }
  }
  
  private void aAf()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 2, 0, "", "", "", "");
    FileSearchActivity.h(getActivity(), 2, getUin());
  }
  
  private LinkedHashMap<String, List<Object>> b()
  {
    Object localObject = new ArrayList(this.mApp.a().av(getUin()));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.bDelInAio))
      {
        QLog.w("ChatHistoryC2CFileFragment<QFile>", 1, "getLocalDataMap Entity[null]");
      }
      else
      {
        QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, " getLocalDataMap : Entity[" + localFileManagerEntity.hashCode() + "]");
        if (localFileManagerEntity.nFileType != 13)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
          }
          String str = ahcb.bt(localFileManagerEntity.srvTime);
          if (!localLinkedHashMap.containsKey(str)) {
            localLinkedHashMap.put(str, new ArrayList());
          }
          ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.uf == null) || (this.uf.size() <= 0)) {
      return;
    }
    this.uf.remove(paramFileManagerEntity);
  }
  
  private LinkedHashMap<String, List<Object>> c()
  {
    Object localObject = new ArrayList(this.mApp.a().aw(getUin()));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "waterTest load : Entity[" + localFileManagerEntity.hashCode() + "]");
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio) && (localFileManagerEntity.nFileType != 13))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryC2CFileFragment<QFile>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
        }
        String str = ahcb.bt(localFileManagerEntity.srvTime);
        if (!localLinkedHashMap.containsKey(str)) {
          localLinkedHashMap.put(str, new ArrayList());
        }
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    return localLinkedHashMap;
  }
  
  private void c(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {}
    while (this.E == null) {
      return;
    }
    this.E.clear();
    this.E.putAll(paramLinkedHashMap);
  }
  
  private void clearSelected()
  {
    if (this.uf != null) {
      this.uf.clear();
    }
  }
  
  private void cpk()
  {
    int i = 0;
    if ((this.E == null) || (this.E.size() == 0))
    {
      this.hL.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
    }
    for (;;)
    {
      this.mRootView.setVisibility(0);
      this.jdField_a_of_type_Ziz.notifyDataSetChanged();
      if (!this.brj) {
        return;
      }
      this.brj = false;
      while (i < this.jdField_a_of_type_Ziz.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(i);
        i += 1;
      }
      this.hL.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new zfj(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new zfk(this));
  }
  
  void BA(boolean paramBoolean)
  {
    super.BA(paramBoolean);
    if (paramBoolean) {
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 3, 0, "", "", "", "");
    }
    BF(paramBoolean);
    if (!paramBoolean) {
      clearSelected();
    }
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if ((this.uf == null) || (this.uf.size() <= 0)) {
      return false;
    }
    return this.uf.contains(paramFileManagerEntity);
  }
  
  protected void bpM()
  {
    if (this.jdField_a_of_type_Aghq != null) {
      return;
    }
    this.jdField_a_of_type_Aghq = new zfi(this);
    this.mApp.a().addObserver(this.jdField_a_of_type_Aghq);
  }
  
  protected void bpN()
  {
    if (this.jdField_a_of_type_Aghq != null)
    {
      this.mApp.a().deleteObserver(this.jdField_a_of_type_Aghq);
      this.jdField_a_of_type_Aghq = null;
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.a().aIH();
    if (this.bri)
    {
      if (b(paramFileManagerEntity)) {
        b(paramFileManagerEntity);
      }
      for (;;)
      {
        if ((paramFileManagerEntity.cloudType == 3) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
        {
          ahao.JD(ahav.kY(paramFileManagerEntity.fileName) + acfp.m(2131703659));
          b(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Ziz.notifyDataSetChanged();
        do
        {
          return;
        } while (Vn());
        a(paramFileManagerEntity);
      }
    }
    Object localObject = new ahau.a();
    ((ahau.a)localObject).bJE = "file_viewer_in";
    ((ahau.a)localObject).cYX = 73;
    ((ahau.a)localObject).bJF = ahbj.getExtension(paramFileManagerEntity.fileName);
    ((ahau.a)localObject).nFileSize = paramFileManagerEntity.fileSize;
    ahau.a(this.mApp.getCurrentAccountUin(), (ahau.a)localObject);
    ahau.JH("0X8004AE4");
    localObject = new agvl(this.mApp, this.mActivity, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.mUin != null) && (this.mUin.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", getUin());
      localBundle.putString("file_browser_extra_params_uin", getUin());
    }
    ((agvl)localObject).cB(localBundle);
    localObject = new agvn(this.mActivity, (agvq)localObject);
    if (paramFileManagerEntity.peerType == 0) {
      ((agvn)localObject).Oy(2);
    }
    for (;;)
    {
      ((agvn)localObject).JE(true);
      ((agvn)localObject).djN();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((agvn)localObject).Oy(6);
      }
    }
  }
  
  protected void coH()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_Zjl.hk(localArrayList);
  }
  
  protected void coK()
  {
    super.coK();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.uf);
    this.jdField_a_of_type_Agyr.a(localArrayList, 1, null);
    coI();
    BF(false);
    clearSelected();
  }
  
  protected void coL()
  {
    super.coL();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.uf);
    this.jdField_a_of_type_Agyr.a(localArrayList, 4, null);
    coI();
    BF(false);
    clearSelected();
  }
  
  protected void coM()
  {
    super.coM();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 3, 0, "", "", "", "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.uf);
    this.jdField_a_of_type_Agyr.a(localArrayList, 2, null);
    coI();
    BF(false);
    clearSelected();
  }
  
  protected void coN()
  {
    super.coN();
    anot.a(this.mApp, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131698325);
    localausj.addButton(getActivity().getString(2131693518), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new zfp(this, localausj));
    localausj.show();
  }
  
  protected void coO()
  {
    super.coO();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.uf);
    this.jdField_a_of_type_Agyr.a(localArrayList, 5, null);
    coI();
    BF(false);
    clearSelected();
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = this.uf.iterator();
    do
    {
      if (!paramFileManagerEntity.hasNext()) {
        break;
      }
    } while (((FileManagerEntity)paramFileManagerEntity.next()).fileSize <= 104857600L);
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_Zjl.aW(5, bool);
      return;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    BF(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    BE(false);
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 4, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aAf();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_Agyr == null) {
      this.jdField_a_of_type_Agyr = new agys(this.mApp, this.mActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mRootView == null)
    {
      this.E = new LinkedHashMap();
      this.uf = new ArrayList();
      this.yD = View.inflate(this.mActivity, 2131561044, null);
      this.yD.setVisibility(8);
      this.mRootView = paramLayoutInflater.inflate(2131561019, paramViewGroup, false);
      this.hL = ((LinearLayout)this.mRootView.findViewById(2131372448));
      this.hL.setVisibility(8);
      this.jdField_a_of_type_Ziz = new ziz(this.mActivity, this.E);
      this.jdField_a_of_type_Ziz.a(this);
      this.jdField_a_of_type_Ziz.z(this.de);
      this.jdField_a_of_type_Ziz.A(this.df);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)this.mRootView.findViewById(2131370584));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ziz);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.yD);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167595);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ziz);
      this.jdField_a_of_type_Ziz.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
      paramLayoutInflater = this.mRootView.findViewById(2131367060);
      ((TextView)paramLayoutInflater.findViewById(2131374642)).setText(2131691417);
      this.iy = ((RelativeLayout)paramLayoutInflater.findViewById(2131374641));
      this.iy.setOnClickListener(this);
    }
    paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.mRootView);
    }
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected int yg()
  {
    return 1602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment
 * JD-Core Version:    0.7.0.1
 */