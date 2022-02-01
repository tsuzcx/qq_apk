package com.tencent.mobileqq.activity.history;

import ahao;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqjb;
import aurf;
import ausj;
import auss;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import wkj;
import ymn;
import zer;
import zfr;
import zfu;
import zfv;
import zja;
import zjl;
import zky;

public class ChatHistoryC2CLinkFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, AbsListView.e
{
  public static final Pattern J = Pattern.compile(aOv, 2);
  protected static final String aOv = aqjb.an.pattern() + "|" + aqjb.WEB_URL.pattern();
  private static int bFw = 30;
  long FH = 9223372036854775807L;
  long FI = 9223372036854775807L;
  long FJ = 9223372036854775807L;
  private LinkedHashMap<String, List<MessageRecord>> H = new LinkedHashMap();
  ymn jdField_a_of_type_Ymn;
  private zky jdField_a_of_type_Zky;
  public String aLX;
  boolean aUg = false;
  public zfr b;
  int bFx = 3;
  View.OnClickListener de;
  View.OnClickListener df;
  private RelativeLayout gp;
  long iu = 0L;
  RelativeLayout ix;
  XListView l;
  public QQAppInterface mApp;
  public Context mContext;
  ArrayList<Object> mData = new ArrayList();
  private SessionInfo mSessionInfo;
  String mUin;
  int mUinType;
  View rS;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private TextView xQ;
  
  private void bKj()
  {
    if (this.df != null) {
      return;
    }
    this.df = new zfu(this);
  }
  
  private List<ChatMessage> dm()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Zja.dl();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof ChatMessage)) {
          localArrayList.add((ChatMessage)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  void BA(boolean paramBoolean)
  {
    super.BA(paramBoolean);
    this.b.notifyDataSetChanged();
    if (paramBoolean) {
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 4, 0, "", "", "", "");
    }
  }
  
  void bJC()
  {
    this.ix = ((RelativeLayout)this.gp.findViewById(2131377786));
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
    localArrayList.add(Integer.valueOf(4));
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
    ahao.OS(2131694153);
  }
  
  protected void coM()
  {
    super.coM();
    List localList = dm();
    if (localList.size() == 0) {
      ahao.OU(2131691424);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.jdField_a_of_type_Ymn.gG(localArrayList);
      coI();
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 4, 0, "", "", "", "");
    }
  }
  
  protected void coN()
  {
    super.coN();
    if (dm().size() > 0)
    {
      ausj localausj = (ausj)auss.a(getActivity(), null);
      localausj.setMainTitle(2131698325);
      localausj.addButton(getString(2131693518), 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new zfv(this, localausj));
      localausj.show();
      return;
    }
    ahao.OU(2131691424);
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
    this.b.notifyDataSetChanged();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.b != null) && (this.b.getCount() == 0)) {
      this.jdField_a_of_type_Zer.BB(false);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 5, 0, "", "", "", "");
  }
  
  public void fG(List<ChatMessage> paramList)
  {
    Iterator localIterator;
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mData.removeAll(paramList);
      localIterator = this.mData.iterator();
      paramList = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = paramList;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof String))
        {
          localObject1 = paramList;
          if (i == 0) {
            localObject1 = localObject2;
          }
          int j = i + 1;
          paramList = (List<ChatMessage>)localObject1;
          i = j;
          if (j != 2) {
            continue;
          }
        }
      }
      else
      {
        if (localObject1 != null)
        {
          this.mData.remove(localObject1);
          this.H.remove(localObject1);
        }
        this.b.b(this.H);
        ahao.OT(2131692514);
        this.uiHandler.sendEmptyMessage(1);
        return;
      }
      paramList = null;
      i = 0;
    }
  }
  
  void gX()
  {
    this.mSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.mSessionInfo.aTl = localBundle.getString("uin");
    this.mSessionInfo.cZ = localBundle.getInt("uintype");
    this.mSessionInfo.a = new wkj();
    this.mSessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
    this.jdField_a_of_type_Zky = new zky(getActivity(), this.mApp, this.mSessionInfo);
    this.jdField_a_of_type_Zky.setData(this.mData);
    this.jdField_a_of_type_Zky.show();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 3, 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.b.b(this.H);
      if (this.b.getCount() == 0)
      {
        this.xQ.setVisibility(0);
        this.l.setVisibility(4);
        return false;
      }
      this.xQ.setVisibility(8);
      this.rS.setVisibility(8);
      this.l.setVisibility(0);
      return false;
    }
    fG((List)paramMessage.obj);
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
      long l1 = System.currentTimeMillis();
      if (l1 - this.iu > 1000L)
      {
        this.iu = l1;
        gX();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mApp = getActivity().app;
    this.mContext = getActivity();
    this.mUin = getActivity().getIntent().getStringExtra("uin");
    this.mUinType = getActivity().getIntent().getIntExtra("uintype", 0);
    this.aLX = getActivity().getIntent().getStringExtra("uinname");
    bKj();
    this.gp = ((RelativeLayout)paramLayoutInflater.inflate(2131558946, paramViewGroup, false));
    this.xQ = ((TextView)this.gp.findViewById(2131366437));
    this.xQ.setVisibility(0);
    this.l = ((XListView)this.gp.findViewById(2131378827));
    this.l.setCacheColorHint(0);
    this.l.setOnScrollListener(this);
    this.rS = View.inflate(this.mContext, 2131563125, null);
    this.rS.setVisibility(0);
    this.l.addFooterView(this.rS);
    bJC();
    wu(true);
    this.b = new zfr(this.mApp, this.mContext, this.df, this.de, this, this.jdField_a_of_type_Zja);
    this.b.b(this.H);
    this.l.setAdapter(this.b);
    this.jdField_a_of_type_Ymn = new ymn(getActivity(), 3);
    this.jdField_a_of_type_Ymn.onCreate();
    paramLayoutInflater = this.gp;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.aUg))
    {
      this.rS.setVisibility(0);
      wu(false);
      this.b.notifyDataSetChanged();
    }
  }
  
  public void wu(boolean paramBoolean)
  {
    ThreadManager.post(new ChatHistoryC2CLinkFragment.2(this, paramBoolean), 10, null, true);
  }
  
  protected int yg()
  {
    return 1602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment
 * JD-Core Version:    0.7.0.1
 */