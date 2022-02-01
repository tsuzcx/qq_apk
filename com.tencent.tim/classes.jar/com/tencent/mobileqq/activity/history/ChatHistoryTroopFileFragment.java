package com.tencent.mobileqq.activity.history;

import acfp;
import agyy;
import ahct;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import apbr;
import apeh;
import apei.a;
import apeo;
import apeq;
import aper;
import apsd;
import apsd.b;
import apsd.c;
import apsf;
import apsv;
import aqhq;
import aqiw;
import ausj;
import auss;
import auuo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import smq.d;
import smq.g;
import zgw;
import zgx;
import zgy;
import zgz;
import zha;
import zhc;
import zhd;
import zjl;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements apeh, apei.a
{
  private XListView E;
  public long KW;
  private long KX = -1L;
  private long KY = -1L;
  private TextView MP;
  private TextView MQ;
  private agyy jdField_a_of_type_Agyy;
  private ahct jdField_a_of_type_Ahct = new zgy(this);
  private apeq jdField_a_of_type_Apeq;
  private aper jdField_a_of_type_Aper;
  private apsf jdField_a_of_type_Apsf;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  protected smq.d a;
  protected smq.g a;
  private apsd.c b;
  private Handler cc = new zgx(this);
  private int cdp = -1;
  private View.OnClickListener eB = new zgz(this);
  private PullRefreshHeader g;
  private LinearLayout hM;
  private auuo mOverScrollViewListener;
  private View mRootView;
  private long mTroopUin;
  private ImageView vl;
  private View yD;
  private View yF;
  private View yG;
  private View yH;
  
  public ChatHistoryTroopFileFragment()
  {
    this.jdField_a_of_type_Smq$d = new zhc(this);
    this.jdField_a_of_type_Smq$g = new zhd(this);
  }
  
  private void BF(boolean paramBoolean)
  {
    this.jdField_a_of_type_Apeq.setSelectMode(paramBoolean);
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
  
  private void Fh(int paramInt)
  {
    if (this.g != null)
    {
      ThreadManager.getUIHandler().postDelayed(new ChatHistoryTroopFileFragment.2(this), 800L);
      if (paramInt == 4)
      {
        this.KW = System.currentTimeMillis();
        this.g.tT(0);
      }
      if (paramInt == 3) {
        this.g.tT(1);
      }
    }
  }
  
  private void Fi(int paramInt)
  {
    if (this.E.getFirstVisiblePosition() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    }
    do
    {
      return;
      if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131720482);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839651);
        return;
      }
    } while (paramInt != 8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
  }
  
  private void Fj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 5: 
      this.E.setVisibility(8);
      this.yG.setVisibility(0);
      this.MP.setText(2131699768);
      return;
    case 2: 
      this.E.setVisibility(0);
      this.yG.setVisibility(0);
      this.MP.setText(2131721495);
      return;
    case 3: 
      this.E.setVisibility(8);
      this.MP.setText(acfp.m(2131703640));
      this.yG.setVisibility(0);
      return;
    case 6: 
      this.E.setVisibility(8);
      this.yG.setVisibility(0);
      this.MP.setText(2131699586);
      return;
    case 4: 
      this.E.setVisibility(0);
      this.yG.setVisibility(8);
      return;
    }
    this.E.setVisibility(0);
    this.yG.setVisibility(0);
    this.MP.setText(2131699770);
  }
  
  private void cpp()
  {
    if (this.mTroopUin != 0L)
    {
      this.jdField_a_of_type_Apsf = apsf.a(this.mApp, this.mTroopUin);
      if (!aqiw.isNetworkAvailable(getActivity())) {
        apsv.A(this.mApp, this.mTroopUin);
      }
      this.jdField_a_of_type_Apeq.jP(0, 0);
      int i = this.jdField_a_of_type_Apsf.LF();
      if (this.jdField_a_of_type_Agyy == null) {
        this.jdField_a_of_type_Agyy = new agyy(this.mApp, this.mActivity, this.mTroopUin);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.mTroopUin + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void cpq()
  {
    this.g = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559847, this.E, false));
    this.mOverScrollViewListener = new zgw(this);
    this.E.setOverScrollHeader(this.g);
    this.E.setOverscrollHeader(getResources().getDrawable(2130839645));
    this.E.setOverScrollListener(this.mOverScrollViewListener);
  }
  
  private void cps()
  {
    if ((this.cdp == -1) || (this.KX == -1L) || (this.KY == -1L))
    {
      if (this.hM != null) {
        this.hM.setVisibility(8);
      }
      return;
    }
    if (this.hM == null)
    {
      this.hM = ((LinearLayout)this.mRootView.findViewById(2131380272));
      this.MQ = ((TextView)this.mRootView.findViewById(2131380273));
    }
    this.hM.setVisibility(0);
    if (this.KY >= this.KX)
    {
      localObject = aqhq.bP(this.KX);
      localObject = String.format(getString(2131700341), new Object[] { Integer.valueOf(this.cdp), localObject });
      int i = ((String)localObject).indexOf(getString(2131700342));
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
      this.MQ.setText((CharSequence)localObject);
      return;
    }
    Object localObject = aqhq.bP(this.KY);
    String str = aqhq.bP(this.KX);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(getString(2131700343), new Object[] { Integer.valueOf(this.cdp), localObject, str }));
    this.MQ.setText(localStringBuilder.toString());
  }
  
  void BA(boolean paramBoolean)
  {
    super.BA(paramBoolean);
    if (paramBoolean) {
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
    }
    BF(paramBoolean);
  }
  
  public void Fk(int paramInt)
  {
    Fj(paramInt);
    cpr();
  }
  
  public void Fl(int paramInt)
  {
    Fh(paramInt);
    Fi(paramInt);
  }
  
  public void a(boolean paramBoolean, apbr paramapbr)
  {
    paramapbr = this.jdField_a_of_type_Apeq.gy().iterator();
    do
    {
      if (!paramapbr.hasNext()) {
        break;
      }
    } while (((apbr)paramapbr.next()).uint64_file_size <= 104857600L);
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.jdField_a_of_type_Zjl.aW(5, paramBoolean);
      return;
    }
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
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
    if (this.jdField_a_of_type_Agyy != null)
    {
      List localList = this.jdField_a_of_type_Apeq.gy();
      this.jdField_a_of_type_Agyy.a(localList, 1, null);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Apeq.setSelectMode(false);
    coI();
  }
  
  protected void coL()
  {
    if (this.jdField_a_of_type_Agyy != null)
    {
      List localList = this.jdField_a_of_type_Apeq.gy();
      this.jdField_a_of_type_Agyy.a(localList, 4, null);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Apeq.setSelectMode(false);
    coI();
  }
  
  protected void coM()
  {
    if (this.jdField_a_of_type_Agyy != null)
    {
      List localList = this.jdField_a_of_type_Apeq.gy();
      this.jdField_a_of_type_Agyy.a(localList, 2, null);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Apeq.setSelectMode(false);
    coI();
  }
  
  protected void coN()
  {
    super.coN();
    Object localObject = this.jdField_a_of_type_Apeq.gy();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (ausj)auss.a(getActivity(), null);
    ((ausj)localObject).setMainTitle(2131698325);
    ((ausj)localObject).addButton(getActivity().getString(2131693518), 3);
    ((ausj)localObject).addCancelButton(2131721058);
    ((ausj)localObject).a(new zha(this, (ausj)localObject));
    ((ausj)localObject).show();
  }
  
  protected void coO()
  {
    if (this.jdField_a_of_type_Agyy != null)
    {
      List localList = this.jdField_a_of_type_Apeq.gy();
      this.jdField_a_of_type_Agyy.a(localList, 5, null);
    }
    this.jdField_a_of_type_Apeq.setSelectMode(false);
    coI();
  }
  
  public void cpr()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Apsf == null) || (this.b != null))
    {
      apsd.b(this.mApp, this.b);
      this.b = null;
    }
    this.jdField_a_of_type_Aper.dYJ();
    this.jdField_a_of_type_Apeq.release();
    apeo.a().release();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.b != null)
    {
      apsd.b(this.mApp, this.b);
      this.b = null;
    }
    BF(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.b == null)
    {
      a locala = new a(this.mTroopUin);
      this.b = new apsd.c(this.mActivity, locala, this.mApp);
    }
    apsd.a(this.mApp, this.b);
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    cpr();
  }
  
  public int getFirstVisiblePosition()
  {
    if (this.E != null) {
      return this.E.getFirstVisiblePosition();
    }
    return 0;
  }
  
  public int getLastVisiblePosition()
  {
    if (this.E != null) {
      return this.E.getLastVisiblePosition();
    }
    return 0;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(getUin())) {
      QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get uin is empty.");
    }
    for (this.mTroopUin = 0L;; this.mTroopUin = Long.valueOf(getUin()).longValue())
    {
      if (this.mRootView == null)
      {
        this.mRootView = paramLayoutInflater.inflate(2131561018, paramViewGroup, false);
        this.E = ((XListView)this.mRootView.findViewById(2131370584));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.mActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838900);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131167304));
        this.E.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.yD = View.inflate(this.mActivity, 2131561044, null);
        this.E.addFooterView(this.yD);
        this.yD.setVisibility(8);
        this.yG = this.mRootView.findViewById(2131372448);
        this.vl = ((ImageView)this.mRootView.findViewById(2131368846));
        this.MP = ((TextView)this.mRootView.findViewById(2131379419));
        this.jdField_a_of_type_Apeq = new apeq(this.mApp, this.mActivity, this.mTroopUin, "/", 13);
        this.E.setAdapter(this.jdField_a_of_type_Apeq);
        this.jdField_a_of_type_Apeq.a(this);
        this.jdField_a_of_type_Apeq.b(this);
        this.E.setOnScrollListener(this.jdField_a_of_type_Apeq);
        this.yF = this.mRootView.findViewById(2131367060).findViewById(2131374641);
        this.yF.setOnClickListener(this.jdField_a_of_type_Ahct);
        this.yH = this.mRootView.findViewById(2131380190);
        this.mRootView.findViewById(2131380189).setOnClickListener(this.eB);
        this.mRootView.findViewById(2131380191).setOnClickListener(this.eB);
        cpq();
      }
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
      Fj(5);
      if (this.jdField_a_of_type_Aper == null)
      {
        this.jdField_a_of_type_Aper = new aper(this.mApp, this.mActivity, String.valueOf(this.mTroopUin), this.cc);
        this.jdField_a_of_type_Aper.dYI();
      }
      this.jdField_a_of_type_Aper.Ry(false);
      cpp();
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  protected int yg()
  {
    return 1602;
  }
  
  class a
    implements apsd.b
  {
    private long Lb;
    
    public a(long paramLong)
    {
      this.Lb = paramLong;
    }
    
    public long er()
    {
      return this.Lb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */