package com.tencent.mobileqq.msgbackup.fragment;

import ajee;
import ajfl;
import ajfl.b;
import ajfw;
import ajfx;
import ajfy;
import ajgt;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import aqnm;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import top;

public class MsgBackupSelectionFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private View EG;
  private TextView UO;
  private TextView UP;
  private TextView UQ;
  private ajee jdField_b_of_type_Ajee;
  private ajfl.b jdField_b_of_type_Ajfl$b = new ajfy(this);
  private ajfl jdField_b_of_type_Ajfl;
  private String bQZ;
  private String bRa;
  private String bRb;
  private boolean cok;
  private final int diR = 10000;
  private Button gM;
  private boolean isSelectAll;
  private RelativeLayout kU;
  private int mContentType = -1000;
  public List<RecentBaseData> mDataList = new ArrayList();
  private long mEndTime;
  private int mFrom;
  private LinearLayoutManager mLinearLayoutManager;
  private View mLoadingTips;
  private RecyclerView mRecyclerView;
  private long mStartTime;
  private MqqHandler mUIHandler;
  
  private void QJ(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690736, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.mStartTime != 0L) && (this.mEndTime != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690720, new Object[] { this.bQZ, this.bRa }));
    }
    if (this.mContentType == 2) {
      localStringBuilder.append("\n").append(getString(2131690710));
    }
    if (localStringBuilder.length() > 0)
    {
      this.UO.setVisibility(0);
      this.UO.setText(localStringBuilder.toString());
    }
    while (paramInt > 0)
    {
      this.gM.setEnabled(true);
      if (paramInt == this.mDataList.size())
      {
        this.isSelectAll = true;
        d(this.UP, 2131690767);
        return;
        this.UO.setVisibility(8);
      }
      else
      {
        this.isSelectAll = false;
        d(this.UP, 2131690745);
        return;
      }
    }
    this.gM.setEnabled(false);
    this.isSelectAll = false;
    d(this.UP, 2131690745);
  }
  
  private void bE(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690736, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.mStartTime != 0L) && (this.mEndTime != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690720, new Object[] { this.bQZ, this.bRa }));
    }
    if (this.mContentType == 2) {
      localStringBuilder.append("\n").append(getString(2131690710));
    }
    if (localStringBuilder.length() > 0)
    {
      this.UO.setVisibility(0);
      this.UO.setText(localStringBuilder.toString());
    }
    while (paramBoolean)
    {
      d(this.UP, 2131690767);
      this.gM.setEnabled(true);
      return;
      this.UO.setVisibility(8);
    }
    d(this.UP, 2131690745);
    this.gM.setEnabled(false);
  }
  
  private void cBd()
  {
    if (!this.isSelectAll) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSelectAll = bool;
      bE(0, this.isSelectAll);
      this.jdField_b_of_type_Ajfl.cBd();
      ajee.a().clear();
      return;
    }
  }
  
  private void chz()
  {
    aqnm.setVisible(this.mRecyclerView, 0);
    aqnm.setVisible(this.EG, 8);
    aqnm.setVisible(this.mLoadingTips, 8);
  }
  
  private void cyA()
  {
    this.jdField_b_of_type_Ajee = ajee.a();
  }
  
  private void d(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(paramInt);
      if (AppSetting.enableTalkBack) {
        paramTextView.setContentDescription(getString(paramInt));
      }
    }
  }
  
  private void dwP()
  {
    Bundle localBundle = getArguments();
    this.mFrom = localBundle.getInt("backup_select_from", 0);
    this.bRb = localBundle.getString("0x11bpush_extra");
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "handlerArg, mFrom = " + this.mFrom);
    }
  }
  
  private void dxg()
  {
    if (this.isSelectAll)
    {
      cBd();
      if (this.mFrom == 0) {
        ajgt.cN("0X800A233", 2);
      }
    }
    do
    {
      do
      {
        return;
      } while (!ajee.cnI);
      ajgt.cN("0X800A258", 2);
      return;
      dxh();
      if (this.mFrom == 0)
      {
        ajgt.cN("0X800A233", 1);
        return;
      }
    } while (!ajee.cnI);
    ajgt.cN("0X800A258", 1);
  }
  
  private void dxh()
  {
    if (!this.isSelectAll) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSelectAll = bool;
      if (this.mDataList.size() > 0) {
        bE(this.mDataList.size(), this.isSelectAll);
      }
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        ajee.a().bi.add(localRecentBaseData);
      }
    }
    this.jdField_b_of_type_Ajfl.selectAll();
  }
  
  private void dxi()
  {
    int m = 3;
    int k = 2;
    Object localObject = ajee.a().bi.iterator();
    int i = 0;
    int j = i;
    if (((Iterator)localObject).hasNext())
    {
      if (!top.fv(((RecentBaseData)((Iterator)localObject).next()).ng())) {
        break label135;
      }
      if (i == 2) {
        j = 3;
      }
    }
    else
    {
      i = m;
      if (this.mStartTime != 0L)
      {
        i = m;
        if (this.mEndTime != 0L) {
          i = 1;
        }
      }
      if (this.mContentType != 2) {
        break label169;
      }
      if (i != 1) {
        break label150;
      }
      i = k;
    }
    label135:
    label150:
    label169:
    for (;;)
    {
      label97:
      localObject = "";
      if (this.mFrom == 0) {
        localObject = "0X800A238";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ajgt.ao((String)localObject, j, i);
        }
        return;
        i = 1;
        for (;;)
        {
          break;
          if (i == 1) {
            i = 3;
          } else {
            i = 2;
          }
        }
        i = 4;
        break label97;
        if (ajee.cnI) {
          localObject = "0X800A25D";
        }
      }
    }
  }
  
  private void initData()
  {
    ajee.a().bi.clear();
    ajee.a().a(new ajfw(this));
    ajee.a().dwI();
  }
  
  private void initUI()
  {
    this.kU = ((RelativeLayout)this.mContentView.findViewById(2131363612));
    this.UP = ((TextView)this.mContentView.findViewById(2131377930));
    d(this.gM, 2131690745);
    this.UQ = ((TextView)this.mContentView.findViewById(2131365612));
    d(this.UQ, 2131690746);
    this.gM = ((Button)this.mContentView.findViewById(2131377948));
    d(this.gM, 2131690735);
    this.UP.setOnClickListener(this);
    this.UQ.setOnClickListener(this);
    this.gM.setOnClickListener(this);
    this.gM.setEnabled(false);
    this.UO = ((TextView)this.mContentView.findViewById(2131371516));
    this.UO.setVisibility(8);
    this.mRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131371512));
    this.mLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.mLinearLayoutManager.setOrientation(1);
    this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
    this.jdField_b_of_type_Ajfl = new ajfl(getActivity(), getActivity().app, this.mRecyclerView);
    this.mRecyclerView.setAdapter(this.jdField_b_of_type_Ajfl);
    this.jdField_b_of_type_Ajfl.a(this.jdField_b_of_type_Ajfl$b);
    this.EG = this.mContentView.findViewById(2131366437);
    this.mLoadingTips = this.mContentView.findViewById(2131370776);
    this.mLoadingTips.setVisibility(0);
    this.vg.setOnItemSelectListener(new ajfx(this));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
    dwP();
    cyA();
    initUI();
    initData();
    ajee.a().clear();
  }
  
  public int getContentLayoutId()
  {
    return 2131561666;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    chz();
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_b_of_type_Ajfl.cS(this.mDataList);
      this.jdField_b_of_type_Ajfl.initState();
      this.jdField_b_of_type_Ajfl.notifyDataSetChanged();
      return false;
    }
    this.mRecyclerView.setVisibility(4);
    this.UQ.setEnabled(false);
    this.UP.setEnabled(false);
    this.EG.setVisibility(0);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0)) {
      if (paramIntent != null)
      {
        this.mStartTime = paramIntent.getLongExtra("session_start_time", 0L);
        this.mEndTime = paramIntent.getLongExtra("session_end_time", 0L);
        this.bQZ = paramIntent.getStringExtra("session_start_time_str");
        this.bRa = paramIntent.getStringExtra("session_end_time_str");
        this.mContentType = paramIntent.getIntExtra("session_content_type", 1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onActivityResult startTime = " + this.mStartTime + ", endTime = " + this.mEndTime + ", mCurContentType = " + this.mContentType + ", startTimeShow = " + this.bQZ + ", endTimeShow = " + this.bRa);
        }
        QJ(this.jdField_b_of_type_Ajee.bi.size());
      }
    }
    while ((1000 != paramInt1) || (paramInt2 != 1001)) {
      return;
    }
    if (getActivity() != null) {
      getActivity().setResult(1001);
    }
    onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377930: 
    case 2131365612: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        dxg();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "date_select startTime = " + this.mStartTime + ", endTime = " + this.mEndTime + ", mCurContentType = " + this.mContentType + ", startTimeShow = " + this.bQZ + ", endTimeShow = " + this.bRa);
        }
        localIntent = new Intent();
        localIntent.putExtra("session_start_time", this.mStartTime);
        localIntent.putExtra("session_end_time", this.mEndTime);
        localIntent.putExtra("session_start_time_str", this.bQZ);
        localIntent.putExtra("session_end_time_str", this.bRa);
        localIntent.putExtra("session_content_type", this.mContentType);
        localIntent.putExtra("backup_select_from", this.mFrom);
        PublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupDateFragment.class, 1000);
      }
    }
    ajee.dio = ajee.a().bi.size();
    ajgt.dxs();
    ajgt.a.acq = ajee.dio;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "select session detail, sessionCount = " + ajee.dio);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("session_start_time", this.mStartTime);
    localIntent.putExtra("session_end_time", this.mEndTime);
    localIntent.putExtra("session_content_type", this.mContentType);
    boolean bool;
    if (this.mFrom == 0)
    {
      bool = aqiw.isWifiEnabled(BaseApplication.getContext());
      localIntent.putExtra("session_net_status", bool);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_OTHER_DEVICE isNetEnable = " + bool);
      }
      if (bool)
      {
        ajee.a().LV(false);
        label407:
        PublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupQRFragment.class, 1000);
      }
    }
    for (;;)
    {
      dxi();
      break;
      if (!QLog.isColorLevel()) {
        break label407;
      }
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_OTHER_DEVICE net enable status = " + bool);
      break label407;
      if (this.mFrom == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_PC");
        }
        localIntent.putExtra("0x11bpush_extra", this.bRb);
        localIntent.putExtra("param_start", 2);
        PublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupPCTransportFragment.class, 1000);
      }
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690747));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Ajfl != null) {
      this.jdField_b_of_type_Ajfl.onDestroy();
    }
    ajee.a().a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Ajfl.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment
 * JD-Core Version:    0.7.0.1
 */