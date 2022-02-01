package com.tencent.mobileqq.activity.chathistory;

import aavr;
import aavw;
import acfp;
import android.app.Activity;
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
import anot;
import ausj;
import auss;
import auuo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
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
import wja;
import wkj;
import xje.a;
import xjx.a;
import xov.a;
import ymg;
import ymg.a;
import ymi;
import ymj;

public class ChatHistoryBubbleListForTroopFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, auuo, AbsListView.d, AbsListView.e, ymg.a
{
  private int Hy;
  TextView KO;
  long Kr = 9223372036854775807L;
  long Ks = 0L;
  long Kt;
  public aavw a;
  DispatchTouchEventFrameLayout a;
  MqqHandler b;
  public ymg b;
  private int bEz;
  int bZU = 0;
  public ChatXListView d;
  QQAppInterface mApp;
  int mFrom;
  String mTroopUin;
  private View rK;
  private View rL;
  View xO;
  
  public static void a(Activity paramActivity, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("target_shmsgseq", paramLong);
    localIntent.putExtra("from", paramInt2);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, ChatHistoryBubbleListForTroopFragment.class, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, @Nullable MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if (paramMessageRecord == null) {}
    for (long l = 0L;; l = paramMessageRecord.shmsgseq)
    {
      a(paramActivity, paramString, l, paramInt1, paramInt2);
      return;
    }
  }
  
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
    ((ausj)localObject).a(new ymj(this, paramChatMessage, (ausj)localObject));
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
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.3(this), 5, null, true);
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
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.5(this, i), 5, null, true);
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
    paramLayoutInflater.aTl = this.mTroopUin;
    paramLayoutInflater.cZ = 1;
    paramLayoutInflater.troopUin = this.mTroopUin;
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
    if (this.Kt > 0L) {
      cjH();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aavw = new aavw(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout = ((DispatchTouchEventFrameLayout)this.mContentView.findViewById(2131377546));
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout.setOnDispatchListener(new ymi(this));
      anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_exp", 0, 0, this.mTroopUin, String.valueOf(this.mFrom), "", "");
      return;
      ie();
    }
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
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.2(this), 5, null, true);
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.mTroopUin = paramBundle.getString("troop_uin");
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
    this.KO.setText(acfp.m(2131703629));
    int i = this.bZU + 1;
    this.bZU = i;
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.4(this, i), 5, null, true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 38: 
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "resultCode == Activity.RESULT_OK, case REQUEST_JUMP_TO_POSITION");
      }
      cx(paramIntent);
    }
    ForwardUtils.a(this.mApp, paramIntent, getActivity());
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
    if (this.jdField_a_of_type_Aavw != null) {
      this.jdField_a_of_type_Aavw.Ck(12);
    }
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
      this.mApp.removeHandler(ChatHistoryBubbleListForTroopFragment.class);
    }
    ShortVideoPTVItemBuilder.r(this.d);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    super.onPause();
    this.jdField_a_of_type_Aavw.Ck(9);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    ((MediaPlayerManager)this.mApp.getManager(24)).a(this.d, this.jdField_b_of_type_Ymg, null);
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.mApp.setHandler(ChatHistoryBubbleListForTroopFragment.class, this.jdField_b_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_b_of_type_Ymg != null) {
      this.jdField_b_of_type_Ymg.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Aavw.Ck(5);
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
      AbstractGifImage.resumeAll();
      this.jdField_a_of_type_Aavw.Ck(16);
      return;
    }
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_Aavw.Ck(14);
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
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment
 * JD-Core Version:    0.7.0.1
 */