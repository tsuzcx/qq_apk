package com.tencent.mobileqq.activity.history;

import aavp;
import aavr;
import aavw;
import accd;
import acfp;
import achs;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import ausj;
import auss;
import auuo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.d;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import rpq;
import wja;
import wkj;
import xje.a;
import xjx.a;
import xov.a;
import ymg;
import ymg.a;
import zgt;
import zgu;
import zgv;
import zmw;

public class ChatHistoryTroopAllFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, auuo, AbsListView.d, AbsListView.e, ymg.a
{
  private int Hy;
  TextView KO;
  long Kr = 9223372036854775807L;
  long Ks = 0L;
  long Kt;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public ymg b;
  private zmw jdField_b_of_type_Zmw;
  private int bEz;
  int bZU = 0;
  private accd c = new zgv(this);
  public ChatXListView d;
  RelativeLayout ix;
  public QQAppInterface mApp;
  private View mEmptyView;
  private SessionInfo mSessionInfo;
  String mTroopUin;
  private View rK;
  private View rL;
  View xO;
  
  private void ey(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen in history, view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("chatHistory.troop.msgList", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramView.toString();
            break;
            paramView = wja.a(paramView);
            if (ShortVideoItemBuilder.b.class.isInstance(paramView))
            {
              ((ShortVideoItemBuilder.b)paramView).cdi();
              return;
            }
            if (ShortVideoRealItemBuilder.a.class.isInstance(paramView))
            {
              ((ShortVideoRealItemBuilder.a)paramView).cee();
              return;
            }
            if (LightVideoItemBuilder.a.class.isInstance(paramView))
            {
              ((LightVideoItemBuilder.a)paramView).cdi();
              return;
            }
            if (!(paramView instanceof xov.a)) {
              break label136;
            }
            paramView = (xov.a)paramView;
          } while (paramView.a == null);
          paramView.a.detach();
          return;
          if (!(paramView instanceof xjx.a)) {
            break label163;
          }
          paramView = (xjx.a)paramView;
        } while (paramView.a == null);
        paramView.a.detach();
        return;
      } while (!(paramView instanceof xje.a));
      paramView = (xje.a)paramView;
    } while (paramView.a == null);
    label136:
    label163:
    paramView.a.detach();
  }
  
  public void Am(int paramInt)
  {
    if (paramInt < 0) {
      loadMore();
    }
  }
  
  public void N(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "deleteMessage uniseq=" + paramChatMessage.uniseq + ",id=" + paramChatMessage.getId());
    }
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = (ausj)auss.a((Context)localObject, null);
    ((ausj)localObject).setMainTitle(getResources().getString(2131698325));
    ((ausj)localObject).addButton(2131692505, 3);
    ((ausj)localObject).addCancelButton(2131721058);
    ((ausj)localObject).a(new zgu(this, paramChatMessage, (ausj)localObject));
    ((ausj)localObject).show();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle, View paramView)
  {
    if (this.mApp == null) {}
    do
    {
      return;
      paramViewGroup = getActivity();
    } while (paramViewGroup == null);
    this.d = ((ChatXListView)paramView.findViewById(2131370538));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.aTl = this.mTroopUin;
    paramLayoutInflater.cZ = 1;
    paramLayoutInflater.troopUin = this.mTroopUin;
    paramLayoutInflater.a = new wkj();
    paramLayoutInflater.cN = ChatTextSizeSettingActivity.ag(paramViewGroup);
    int i = rpq.dip2px(paramViewGroup, 10.0F);
    this.xO = LayoutInflater.from(paramViewGroup).inflate(2131559032, this.d, false);
    this.xO.setPadding(0, 0, 0, i);
    this.KO = new TextView(paramViewGroup);
    this.KO.setTextSize(16.0F);
    this.KO.setTextColor(getResources().getColorStateList(2131167385));
    this.KO.setGravity(1);
    this.KO.setPadding(0, i, 0, i);
    this.KO.setVisibility(8);
    this.KO.setOnClickListener(this);
    this.d.addFooterView(this.KO);
    this.d.setOnScrollToButtomListener(this);
    this.d.setOnScrollListener(this);
    this.jdField_b_of_type_Ymg = new ymg(this.mApp, paramViewGroup, paramLayoutInflater);
    this.d.setAdapter(this.jdField_b_of_type_Ymg);
    this.jdField_b_of_type_Ymg.a(this);
    if (this.Kt > 0L) {
      cjH();
    }
    for (;;)
    {
      fO(paramView);
      paramViewGroup = (DispatchTouchEventLinearLayout)paramView.findViewById(2131377556);
      paramViewGroup.setOnDispatchListener(new zgt(this));
      this.mEmptyView = paramView.findViewById(2131366437);
      if (!wkj.a(BaseApplicationImpl.getContext(), this.mApp.getCurrentAccountUin(), paramLayoutInflater.aTl, true, 0, paramLayoutInflater.a)) {
        break;
      }
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.a.img);
      return;
      ie();
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    cjI();
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  protected void bf(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.d.setOverScrollHeader(this.xO);
      this.d.setOverScrollListener(this);
      localTextView = this.KO;
      if (!paramBoolean2) {
        break label61;
      }
    }
    label61:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
      this.d.setOverScrollHeader(null);
      this.d.setOverScrollListener(null);
      break;
    }
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void cjH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.3(this), 5, null, true);
  }
  
  public void cjI()
  {
    if (!this.jdField_b_of_type_Ymg.bnz) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.bZU + 1;
    this.bZU = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.5(this, i), 5, null, true);
  }
  
  public void cx(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l <= 0L) {
      return;
    }
    paramIntent = this.jdField_b_of_type_Ymg.getList();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.Kt = l;
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "locateToPosition, mTargetShmsgseq = " + this.Kt + " , loadTarget");
    }
    cjH();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "ChatHistoryTroopAllFragment doOnActivityResult, resultCode = " + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("chatHistory.troop.msgList", 2, "ChatHistoryTroopAllFragment, locateToPosition");
        }
      } while (paramIntent == null);
      cx(paramIntent);
      return;
    } while (-1 != paramInt2);
    ForwardUtils.a(this.mApp, paramIntent, getActivity());
  }
  
  void fO(View paramView)
  {
    this.ix = ((RelativeLayout)((LinearLayout)paramView.findViewById(2131377556)).findViewById(2131377786));
    this.ix.findViewById(2131363801).setVisibility(8);
    paramView = (EditText)this.ix.findViewById(2131366542);
    paramView.setFocusableInTouchMode(false);
    paramView.setCursorVisible(false);
    paramView.setOnClickListener(this);
    if ((this.ix != null) && (Build.VERSION.SDK_INT > 10)) {
      this.ix.setLayerType(0, null);
    }
  }
  
  protected void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
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
    this.jdField_b_of_type_Zmw = new zmw(getActivity(), this.mApp, this.mSessionInfo, localachs.abb());
    this.jdField_b_of_type_Zmw.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Ymg != null)
      {
        if (this.jdField_b_of_type_Ymg.getCount() == 0) {
          this.d.setEmptyView(this.mEmptyView);
        }
        this.jdField_b_of_type_Ymg.notifyDataSetChanged();
      }
    }
  }
  
  public void ie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.2(this), 5, null, true);
  }
  
  protected void init()
  {
    this.mTroopUin = getUin();
    if (this.mTroopUin == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      finish();
      return;
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof QQAppInterface); localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      this.mApp = ((QQAppInterface)localObject);
      QLog.i("chatHistory.troop.msgList", 1, "mTargetShmsgseq:" + this.Kt);
      this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    finish();
  }
  
  public void loadMore()
  {
    if (!this.jdField_b_of_type_Ymg.mHasMore) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.KO.setText(acfp.m(2131703622));
    int i = this.bZU + 1;
    this.bZU = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.KO) {
      loadMore();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131366542)
      {
        gX();
        anot.a(this.mApp, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131560771, paramViewGroup, false);
    init();
    a(paramLayoutInflater, paramViewGroup, paramBundle, localView);
    this.mApp.addObserver(this.c);
    V4FragmentCollector.onV4FragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.mApp.removeObserver(this.c);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.mApp.getManager(24)).c(this.d);
    this.jdField_b_of_type_Ymg.destroy();
    super.onDestroyView();
  }
  
  public void onPause()
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.mApp.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    ShortVideoPTVItemBuilder.r(this.d);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    ShortVideoItemBuilder.cea();
    ShortVideoRealItemBuilder.cea();
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (localaavp.Xy())) {
      localaavp.detach();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    ShortVideoItemBuilder.ceb();
    ShortVideoRealItemBuilder.ceb();
    ((MediaPlayerManager)this.mApp.getManager(24)).a(this.d, this.jdField_b_of_type_Ymg, null);
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.mApp.setHandler(ChatHistoryTroopAllFragment.class, this.jdField_b_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_b_of_type_Ymg != null)
    {
      if (this.jdField_b_of_type_Ymg.getCount() == 0) {
        this.d.setEmptyView(this.mEmptyView);
      }
      this.jdField_b_of_type_Ymg.notifyDataSetChanged();
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.Hy < paramInt1) {
      ey(this.rK);
    }
    for (;;)
    {
      this.Hy = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.bEz = (paramInt1 + paramInt2 - 1);
      }
      this.rK = paramAbsListView.getChildAt(0);
      this.rL = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 > 0) && (paramInt1 + paramInt2 - 1 < this.bEz)) {
        ey(this.rL);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.Ck(16);
      AbstractGifImage.resumeAll();
      return;
    }
    this.a.Ck(14);
    AbstractGifImage.pauseAll();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */