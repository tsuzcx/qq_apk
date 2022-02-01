package com.tencent.mobileqq.activity.history;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.TextView;
import ausj;
import auss;
import auuo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.d;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import rpq;
import wkj;
import ymg;
import ymg.a;
import zes;

public class ChatHistoryBubbleListFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, auuo, AbsListView.d, AbsListView.e, ymg.a
{
  TextView KO;
  long Kr = 9223372036854775807L;
  long Ks = 0L;
  long Kt;
  MqqHandler b;
  public ymg b;
  int bZU = 0;
  ChatXListView d;
  QQAppInterface mApp;
  String mFriendUin;
  int mFrom;
  String mTroopUin;
  int mUinType;
  View xO;
  
  private void cx(Intent paramIntent)
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
    cjH();
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
    ((ausj)localObject).a(new zes(this, paramChatMessage, (ausj)localObject));
    ((ausj)localObject).show();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
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
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void cjH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryBubbleListFragment.2(this), 5, null, true);
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
    ThreadManager.post(new ChatHistoryBubbleListFragment.4(this, i), 5, null, true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mApp == null) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131691410));
    this.d = ((ChatXListView)this.mContentView.findViewById(2131370538));
    paramLayoutInflater = new SessionInfo();
    if (this.mUinType == 1)
    {
      paramLayoutInflater.aTl = this.mTroopUin;
      paramLayoutInflater.cZ = 1;
      paramLayoutInflater.troopUin = this.mTroopUin;
    }
    for (;;)
    {
      paramLayoutInflater.a = new wkj();
      paramLayoutInflater.cN = ChatTextSizeSettingActivity.ag(localFragmentActivity);
      int i = rpq.dip2px(localFragmentActivity, 10.0F);
      this.xO = LayoutInflater.from(localFragmentActivity).inflate(2131559032, this.d, false);
      this.xO.setPadding(0, 0, 0, i);
      this.KO = new TextView(localFragmentActivity);
      this.KO.setTextSize(16.0F);
      this.KO.setTextColor(getResources().getColorStateList(2131167385));
      this.KO.setGravity(1);
      this.KO.setPadding(0, i, 0, i);
      this.KO.setVisibility(8);
      this.KO.setOnClickListener(this);
      this.d.addFooterView(this.KO);
      this.d.setOnScrollToButtomListener(this);
      this.d.setOnScrollListener(this);
      this.jdField_b_of_type_Ymg = new ymg(this.mApp, localFragmentActivity, paramLayoutInflater);
      this.d.setAdapter(this.jdField_b_of_type_Ymg);
      this.jdField_b_of_type_Ymg.a(this);
      if (this.Kt <= 0L) {
        break;
      }
      cjH();
      return;
      paramLayoutInflater.aTl = this.mFriendUin;
      paramLayoutInflater.cZ = 0;
    }
    ie();
  }
  
  protected void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560772;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Ymg != null) {
        this.jdField_b_of_type_Ymg.notifyDataSetChanged();
      }
    }
  }
  
  public void ie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryBubbleListFragment.1(this), 5, null, true);
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.mUinType = paramBundle.getInt("uintype");
    if (this.mUinType == 1)
    {
      this.mTroopUin = paramBundle.getString("troop_uin");
      if (this.mTroopUin == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
        finish();
      }
    }
    else
    {
      this.mFriendUin = paramBundle.getString("uin");
      if (this.mFriendUin == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "friend uin id required");
        finish();
        return;
      }
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof QQAppInterface); localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      this.mApp = ((QQAppInterface)localObject);
      this.Kt = paramBundle.getLong("target_shmsgseq", 0L);
      this.mFrom = paramBundle.getInt("from", 0);
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
    this.KO.setText(acfp.m(2131703652));
    int i = this.bZU + 1;
    this.bZU = i;
    ThreadManager.post(new ChatHistoryBubbleListFragment.3(this, i), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.KO) {
      loadMore();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.mApp.getManager(24)).c(this.d);
    this.jdField_b_of_type_Ymg.destroy();
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    cx(paramIntent);
  }
  
  public void onPause()
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.mApp.removeHandler(ChatHistoryBubbleListFragment.class);
    }
    ShortVideoPTVItemBuilder.r(this.d);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    ShortVideoItemBuilder.cea();
    ShortVideoRealItemBuilder.cea();
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
      this.mApp.setHandler(ChatHistoryBubbleListFragment.class, this.jdField_b_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_b_of_type_Ymg != null) {
      this.jdField_b_of_type_Ymg.notifyDataSetChanged();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment
 * JD-Core Version:    0.7.0.1
 */