package com.tencent.mobileqq.activity.contact.troop;

import abec;
import abec.a;
import acdt;
import acdv;
import ahgg.a;
import ahgq;
import amxk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqfp;
import aqiw;
import arts;
import auuo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import wja;

public class DiscussionView
  extends BaseTroopView
  implements abec.a, View.OnClickListener, auuo, SlideDetectListView.a, AbsListView.e
{
  private TextView GT;
  protected abec a;
  private a a;
  int bMG;
  boolean bpj = false;
  Button ep;
  protected SlideDetectListView f;
  private PullRefreshHeader h;
  View yj;
  
  public DiscussionView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$a = new a(null);
  }
  
  private void BR(int paramInt)
  {
    if ((getActivity() == null) || (this.jdField_a_of_type_Abec == null)) {
      return;
    }
    if (paramInt == 0)
    {
      this.GT.setVisibility(4);
      return;
    }
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Abec.getCount()))
    {
      this.GT.setVisibility(4);
      return;
    }
    Object localObject = this.jdField_a_of_type_Abec.getItem(0);
    if ((localObject instanceof Integer)) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      if (i == 0)
      {
        i = 2131696103;
        this.GT.setVisibility(0);
        this.GT.setText(i);
        if (!(this.jdField_a_of_type_Abec.getItem(paramInt) instanceof Integer)) {
          break label214;
        }
        if (paramInt >= this.jdField_a_of_type_Abec.getCount()) {
          break;
        }
        localObject = this.f.getChildAt(0);
        if (localObject == null) {
          break;
        }
        paramInt = ((View)localObject).getBottom();
        localObject = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
        if (paramInt >= this.bMG) {
          break label206;
        }
      }
      label206:
      for (((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt - this.bMG);; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
      {
        this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.GT.requestLayout();
        return;
        if (paramInt <= i + 1)
        {
          i = 2131696114;
          break;
        }
        i = 2131696103;
        break;
      }
      label214:
      if (paramInt >= this.jdField_a_of_type_Abec.getCount()) {
        break;
      }
      localObject = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject).topMargin == 0) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.GT.requestLayout();
      return;
    }
  }
  
  private void bKu()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    startActivityForResult(localIntent, 1300);
    anot.a(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
  
  private void cmo()
  {
    this.yj = findViewById(2131366430);
    this.ep = ((Button)this.yj.findViewById(2131365512));
    this.yj.setVisibility(8);
    this.GT = ((TextView)findViewById(2131380396));
    this.bMG = getResources().getDimensionPixelSize(2131299688);
    this.f = ((SlideDetectListView)findViewById(2131370940));
    this.f.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    View localView = localLayoutInflater.inflate(2131563007, this.f, false);
    localView.findViewById(2131363801).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131366542);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.f.addHeaderView(localView);
    this.f.setContentBackground(2130838900);
    this.f.setEmptyView(this.yj);
    this.f.setVisibility(8);
    this.h = ((PullRefreshHeader)localLayoutInflater.inflate(2131559847, this.f, false));
    this.f.setOverScrollHeader(this.h);
    this.f.setOverScrollListener(this);
    this.f.setOnScrollGroupFloatingListener(this);
    this.ep.setOnClickListener(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG()) {
      this.f.setOnSlideListener(this);
    }
  }
  
  private void dS(String paramString1, String paramString2)
  {
    aqfp.Sz(true);
    Intent localIntent = wja.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
  }
  
  private long ew()
  {
    return getActivity().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
  }
  
  protected boolean UI()
  {
    if (aqiw.isNetworkAvailable(getActivity()))
    {
      this.bpj = true;
      ((acdt)this.app.getBusinessHandler(6)).hp(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.h.Q(ew());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.a parama)
  {
    super.a(paramIntent, parama);
    setContentView(2131560074);
    cmo();
    reset();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG())
    {
      this.cbx = 7;
      return;
    }
    this.cbx = 2;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.a();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramDiscussionInfo.uin);
        localBundle.putInt("uintype", 3000);
        localBundle.putString("uinname", ForwardUtils.c(this.app, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A12");
        ((ahgq)localObject).H(ahgg.a.U.intValue(), localBundle);
      }
      paramDiscussionInfo = "";
      try
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.getActivity().getIntent().getLongExtra("req_share_id", 0L);
        if (l > 0L) {
          paramDiscussionInfo = String.valueOf(l);
        }
      }
      catch (Exception paramDiscussionInfo)
      {
        for (;;)
        {
          paramDiscussionInfo = "";
        }
      }
      arts.a().a(this.app.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
      return;
    }
    dS(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    Object localObject = this.app;
    if (paramDiscussionInfo.hasCollect) {}
    for (;;)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    DiscussionInfo localDiscussionInfo = this.jdField_a_of_type_Abec.a(paramInt);
    if (localDiscussionInfo == null) {}
    Button localButton;
    do
    {
      do
      {
        return;
        paramView = (ShaderAnimLayout)paramView.findViewById(2131365947);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131365946);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = getActivity();
    if (!localDiscussionInfo.hasCollect) {}
    for (paramInt = 2131698422;; paramInt = 2131698418)
    {
      paramSlideDetectListView = paramSlideDetectListView.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localDiscussionInfo);
      if (AppSetting.enableTalkBack) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.show();
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.h.S(ew());
    if (!UI()) {
      sendEmptyMessageDelayed(102, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.h.R(ew());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Abec.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131365947);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365946);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void cmn()
  {
    ContactSearchComponentActivity.b(getActivity(), null, 5, 8, 561249);
  }
  
  void cmp()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l).commit();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.f.springBackOverScrollHeaderView();
      continue;
      this.f.springBackOverScrollHeaderView();
      showToast(2131720480);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (paramIntent == null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG())
    {
      amxk.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.a());
      return;
    }
    dS(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
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
      cmn();
      anot.a(this.app, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
      continue;
      bKu();
      continue;
      bKu();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$a);
    if (this.jdField_a_of_type_Abec != null) {
      this.jdField_a_of_type_Abec.destroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Abec != null) {
      this.jdField_a_of_type_Abec.mIsResume = false;
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Abec != null)
    {
      this.jdField_a_of_type_Abec.mIsResume = true;
      this.jdField_a_of_type_Abec.notifyDataSetChanged();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Abec != null) {
      BR(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  protected void reset()
  {
    this.jdField_a_of_type_Abec = new abec(getActivity(), this, this.f, this.app, false);
    this.f.setAdapter(this.jdField_a_of_type_Abec);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDiscussionView$a);
  }
  
  class a
    extends acdv
  {
    private a() {}
    
    public void AW(boolean paramBoolean)
    {
      if (paramBoolean) {
        DiscussionView.this.cmp();
      }
      DiscussionView.this.a.notifyDataSetChanged();
      if (DiscussionView.this.bpj)
      {
        DiscussionView.this.bpj = false;
        if (paramBoolean)
        {
          DiscussionView.a(DiscussionView.this).tT(0);
          DiscussionView.this.sendEmptyMessageDelayed(100, 800L);
        }
      }
      else
      {
        return;
      }
      DiscussionView.this.f.springBackOverScrollHeaderView();
      DiscussionView.this.showToast(2131720480);
    }
    
    public void B(boolean paramBoolean, long paramLong)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
    
    public void N(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
    
    public void V(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
    
    public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
    
    public void a(boolean paramBoolean, Long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
      }
      DiscussionView.this.a.notifyDataSetChanged();
    }
    
    public void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
    {
      DiscussionView.this.a.notifyDataSetChanged();
    }
    
    public void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
    
    public void b(boolean paramBoolean, Long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
      }
      DiscussionView.this.a.notifyDataSetChanged();
    }
    
    public void bMN()
    {
      DiscussionView.this.a.notifyDataSetChanged();
    }
    
    public void cmq()
    {
      DiscussionView.this.a.notifyDataSetChanged();
    }
    
    public void p(boolean paramBoolean, Object paramObject)
    {
      if (paramBoolean) {
        DiscussionView.this.a.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView
 * JD-Core Version:    0.7.0.1
 */