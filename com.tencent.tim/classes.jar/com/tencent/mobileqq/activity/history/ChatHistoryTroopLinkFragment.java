package com.tencent.mobileqq.activity.history;

import achs;
import agmy;
import ahao;
import anbi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anre;
import aqmf;
import aurf;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;
import wkj;
import ymn;
import zer;
import zje;
import zjh;
import zji;
import zjl;
import zlt;

public class ChatHistoryTroopLinkFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, AbsListView.e, zjh
{
  ymn jdField_a_of_type_Ymn;
  private zje jdField_a_of_type_Zje;
  private zji jdField_a_of_type_Zji;
  private zlt jdField_a_of_type_Zlt;
  private boolean bri;
  private boolean brl;
  private boolean brm;
  RelativeLayout ix;
  private View mEmptyView;
  private int mLastVisibleIndex;
  private XListView mListView;
  private SessionInfo mSessionInfo;
  private ArrayList<TroopLinkElement> rB;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private View yf;
  
  private void BF(boolean paramBoolean)
  {
    this.jdField_a_of_type_Zje.BG(paramBoolean);
    this.bri = paramBoolean;
  }
  
  private static void a(LinkedHashMap<String, ArrayList<TroopLinkElement>> paramLinkedHashMap, String paramString, TroopLinkElement paramTroopLinkElement)
  {
    if (paramLinkedHashMap.containsKey(paramString))
    {
      localArrayList = (ArrayList)paramLinkedHashMap.get(paramString);
      localArrayList.add(paramTroopLinkElement);
      paramLinkedHashMap.put(paramString, localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTroopLinkElement);
    paramLinkedHashMap.put(paramString, localArrayList);
  }
  
  private static boolean a(TroopLinkElement paramTroopLinkElement)
  {
    long l = Long.parseLong(paramTroopLinkElement.timeSecond);
    return System.currentTimeMillis() - l * 1000L <= TimeUnit.DAYS.toMillis(7L);
  }
  
  private void aMG()
  {
    this.yf.setVisibility(0);
    this.jdField_a_of_type_Zji.bh(this.mUin, true);
  }
  
  private static Map<String, ArrayList<TroopLinkElement>> b(List<TroopLinkElement> paramList)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (a(localTroopLinkElement)) {
        a(localLinkedHashMap, "7天内", localTroopLinkElement);
      } else {
        a(localLinkedHashMap, localSimpleDateFormat.format(new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L)), localTroopLinkElement);
      }
    }
    return localLinkedHashMap;
  }
  
  private void cB(Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.aTl = paramIntent.getStringExtra("uin");
    localSessionInfo.troopUin = paramIntent.getStringExtra("troop_uin");
    aqmf.a(this.mApp, localSessionInfo.aTl, localSessionInfo.cZ, localAbsStructMsg, null);
  }
  
  private void clearSelected()
  {
    this.jdField_a_of_type_Zje.cpz();
  }
  
  private void cmZ()
  {
    this.yf = LayoutInflater.from(this.mActivity).inflate(2131561721, null);
    this.mListView.addFooterView(this.yf);
    this.yf.setVisibility(8);
    this.mListView.setOnScrollListener(this);
  }
  
  private List<ChatMessage> dm()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Zje.dn().iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("image_url_remote", localTroopLinkElement.url);
      ((Bundle)localObject).putString("detail_url", localTroopLinkElement.iconUrl);
      ((Bundle)localObject).putString("title", localTroopLinkElement.title);
      ((Bundle)localObject).putString("desc", localTroopLinkElement.title);
      ((Bundle)localObject).putString("req_create_time", localTroopLinkElement.timeSecond);
      localObject = anre.a((Bundle)localObject);
      if (localObject != null) {
        ((AbsStructMsg)localObject).mMsgUrl = localTroopLinkElement.url;
      }
      localObject = anbi.a(this.mApp, this.mApp.getCurrentUin(), localTroopLinkElement.uin, "0", 1, Long.parseLong(localTroopLinkElement.msgSeq), (AbsStructMsg)localObject);
      ((MessageForStructing)localObject).shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  private void initData()
  {
    this.rB = new ArrayList();
    this.jdField_a_of_type_Zji = new zji(this.mApp, this, this);
    this.jdField_a_of_type_Zji.bh(this.mUin, false);
    this.jdField_a_of_type_Ymn = new ymn(getActivity(), 3);
    this.jdField_a_of_type_Ymn.onCreate();
  }
  
  private void initViews()
  {
    this.mListView = ((XListView)this.mContentView.findViewById(2131370518));
    this.jdField_a_of_type_Zje = new zje(this.mApp, this.mActivity, this);
    bJC();
    this.mListView.setAdapter(this.jdField_a_of_type_Zje);
    cmZ();
    this.mEmptyView = this.mContentView.findViewById(2131366437);
  }
  
  void BA(boolean paramBoolean)
  {
    super.BA(paramBoolean);
    BF(paramBoolean);
    clearSelected();
    if (paramBoolean) {
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 4, 0, "", "", "", "");
    }
  }
  
  public void E(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (!agmy.mt(localTroopLinkElement.url)) {
        this.rB.add(localTroopLinkElement);
      }
    }
    paramList = b(this.rB);
    this.jdField_a_of_type_Zje.W(paramList);
    if (this.jdField_a_of_type_Zje.getCount() == 0)
    {
      this.brm = true;
      this.mListView.setEmptyView(this.mEmptyView);
    }
  }
  
  void bJC()
  {
    this.ix = ((RelativeLayout)this.mContentView.findViewById(2131377786));
    ((TextView)this.ix.findViewById(2131380917)).setText(getString(2131691420));
    this.ix.findViewById(2131363801).setVisibility(8);
    EditText localEditText = (EditText)this.ix.findViewById(2131366542);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.ix != null) && (Build.VERSION.SDK_INT > 10)) {
      this.ix.setLayerType(0, null);
    }
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  protected void coH()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_Zjl.hk(localArrayList);
  }
  
  protected void coK()
  {
    super.coK();
    showTipsDialog(getString(2131693675));
  }
  
  protected void coL()
  {
    super.coL();
    showTipsDialog(getString(2131693679));
  }
  
  protected void coM()
  {
    super.coM();
    List localList = dm();
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.jdField_a_of_type_Ymn.gG(localArrayList);
      coI();
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 4, 0, "", "", "", "");
      return;
    }
    ahao.OU(2131691424);
  }
  
  protected void coN()
  {
    super.coN();
    showTipsDialog(getString(2131693673));
  }
  
  public void cpt()
  {
    this.brl = true;
    this.yf.setVisibility(8);
  }
  
  void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    cB(paramIntent);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Ymn.onDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    coI();
    this.jdField_a_of_type_Zje.BG(false);
    this.jdField_a_of_type_Zje.notifyDataSetChanged();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.brm) {
      this.jdField_a_of_type_Zer.BB(false);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 5, 0, "", "", "", "");
  }
  
  void gX()
  {
    achs localachs = (achs)this.mApp.getManager(92);
    this.mSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.mSessionInfo.aTl = localBundle.getString("uin");
    this.mSessionInfo.cZ = localBundle.getInt("uintype");
    this.mSessionInfo.troopUin = localBundle.getString("troop_uin");
    this.mSessionInfo.a = new wkj();
    this.mSessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
    this.jdField_a_of_type_Zlt = new zlt(getActivity(), this.mApp, this.mSessionInfo, localachs.abb());
    this.jdField_a_of_type_Zlt.hj(this.rB);
    this.jdField_a_of_type_Zlt.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
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
      gX();
      anot.a(this.mApp, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 3, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560774, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.mLastVisibleIndex == this.jdField_a_of_type_Zje.getCount()) && (!this.brl)) {
      aMG();
    }
    if ((paramInt != 0) && (paramInt != 1)) {}
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    initViews();
    initData();
  }
  
  protected int yg()
  {
    return 1602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment
 * JD-Core Version:    0.7.0.1
 */