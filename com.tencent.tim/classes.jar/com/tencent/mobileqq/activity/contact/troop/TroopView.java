package com.tencent.mobileqq.activity.contact.troop;

import abge;
import abge.b;
import abge.d;
import accd;
import acfd;
import acfp;
import achq;
import acms;
import acnd;
import ahgg.a;
import ahgq;
import amxk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import apbc;
import aqfp;
import aqiw;
import arts;
import auuo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Map;
import ujs;
import wja;
import yyo;

public class TroopView
  extends BaseTroopView
  implements abge.b, View.OnClickListener, auuo, SlideDetectListView.a, AbsListView.e
{
  TextView GT = null;
  TextView Mo = null;
  protected abge a;
  protected ShowExternalTroopListActivity.a a;
  protected a a;
  protected b a;
  protected c a;
  protected accd b = new yyo(this);
  int bMG;
  boolean bpK = false;
  protected boolean bpw;
  protected PullRefreshHeader i;
  protected SlideDetectListView i;
  RelativeLayout ip;
  protected View kY;
  protected int mFromType;
  
  public TroopView(Context paramContext, boolean paramBoolean, ShowExternalTroopListActivity.a parama)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$a = new a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$c = new c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$b = new b();
    this.bpw = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a = parama;
  }
  
  private void BR(int paramInt)
  {
    Object localObject1 = null;
    if ((getActivity() == null) || (this.jdField_a_of_type_Abge == null)) {}
    int j;
    Object localObject2;
    do
    {
      return;
      j = paramInt - 2;
      if ((j < 0) || (j >= this.jdField_a_of_type_Abge.getCount()))
      {
        this.ip.setVisibility(4);
        return;
      }
      localObject2 = this.jdField_a_of_type_Abge.getItem(j);
    } while (!(localObject2 instanceof abge.d));
    label127:
    Object localObject3;
    switch (((abge.d)localObject2).itemType)
    {
    default: 
      localObject2 = null;
      localObject3 = (abge.d)this.jdField_a_of_type_Abge.getItem(paramInt - 1);
      if ((((abge.d)localObject3).itemType == 6) || (((abge.d)localObject3).itemType == 4) || (((abge.d)localObject3).itemType == 2) || (((abge.d)localObject3).itemType == 8))
      {
        localObject3 = this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject3 != null)
        {
          paramInt = ((View)localObject3).getBottom();
          localObject3 = (RelativeLayout.LayoutParams)this.ip.getLayoutParams();
          if (paramInt >= this.bMG) {
            break label397;
          }
          ((RelativeLayout.LayoutParams)localObject3).topMargin = (paramInt - this.bMG);
          label232:
          this.ip.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.ip.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.ip.setVisibility(0);
      this.GT.setText((CharSequence)localObject2);
      this.Mo.setText((CharSequence)localObject1);
      return;
      localObject2 = acfp.m(2131716175);
      j = this.jdField_a_of_type_Abge.coi;
      localObject1 = String.valueOf(j);
      break label127;
      localObject2 = acfp.m(2131716172);
      j = this.jdField_a_of_type_Abge.cmG;
      localObject1 = String.valueOf(j);
      break label127;
      localObject2 = acfp.m(2131716176);
      j = this.jdField_a_of_type_Abge.cmE;
      localObject1 = String.valueOf(j);
      break label127;
      localObject2 = acfp.m(2131716179);
      j = this.jdField_a_of_type_Abge.cmF;
      localObject1 = String.valueOf(j);
      break label127;
      localObject2 = acfp.m(2131716177);
      j = this.jdField_a_of_type_Abge.cmI;
      localObject1 = String.valueOf(j);
      break label127;
      label397:
      ((RelativeLayout.LayoutParams)localObject3).topMargin = 0;
      break label232;
      localObject3 = (RelativeLayout.LayoutParams)this.ip.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject3).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject3).topMargin = 0;
        this.ip.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.ip.requestLayout();
      }
    }
  }
  
  private void cmy()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l).commit();
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
  
  private long ex()
  {
    return getActivity().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void initViews()
  {
    this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131374470));
    this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setNeedCheckSpringback(true);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    this.ip = ((RelativeLayout)findViewById(2131377518));
    this.GT = ((TextView)findViewById(2131380396));
    this.Mo = ((TextView)findViewById(2131380395));
    Object localObject;
    if (this.bpw)
    {
      localObject = localLayoutInflater.inflate(2131560867, this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      ((TextView)((View)localObject).findViewById(2131374438)).setText(getActivity().getString(2131698444));
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
    }
    for (;;)
    {
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(12.0F, getResources())));
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView((View)localObject);
      this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559847, this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG()) {
        this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
      }
      return;
      this.kY = localLayoutInflater.inflate(2131563007, this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      this.kY.findViewById(2131363801).setVisibility(8);
      localObject = (EditText)this.kY.findViewById(2131366542);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      if (this.mFromType != 3) {
        this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.kY);
      }
    }
  }
  
  protected boolean UK()
  {
    if (aqiw.isNetworkAvailable(getActivity()))
    {
      ((acms)this.app.getBusinessHandler(20)).cMF();
      this.bpK = true;
      return true;
    }
    return false;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader.Q(ex());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.a parama)
  {
    super.a(paramIntent, parama);
    setContentView(2131560844);
    this.mFromType = ((Activity)getContext()).getIntent().getIntExtra("key_from", 0);
    initViews();
    this.bMG = wja.dp2px(44.0F, getResources());
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$a);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$b);
    addObserver(this.b);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$c);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG())
    {
      this.cbx = 6;
      return;
    }
    this.cbx = 1;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    int j = 1;
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
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", j, 0, "", "", "", "");
      return;
      j = 2;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.bpw) {}
    while (paramTroopInfo == null) {
      return;
    }
    Object localObject;
    Bundle localBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.a();
      if (localObject != null)
      {
        localBundle = new Bundle();
        localBundle.putString("uin", paramTroopInfo.troopuin);
        localBundle.putInt("uintype", 1);
        localBundle.putString("troop_uin", paramTroopInfo.troopuin);
        localBundle.putString("uinname", paramTroopInfo.getTroopName());
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A11");
        ((ahgq)localObject).H(ahgg.a.T.intValue(), localBundle);
      }
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        anot.a(this.app, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        paramTroopInfo = "";
        try
        {
          long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.getActivity().getIntent().getLongExtra("req_share_id", 0L);
          if (l > 0L) {
            paramTroopInfo = String.valueOf(l);
          }
        }
        catch (Exception paramTroopInfo)
        {
          for (;;)
          {
            paramTroopInfo = "";
          }
        }
        arts.a().a(this.app.getAccount(), "", paramTroopInfo, "1000", "31", "0", false);
        return;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UH())
    {
      localObject = new Intent();
      localBundle = new Bundle();
      localBundle.putString("uin", paramTroopInfo.troopuin);
      localBundle.putInt("uintype", 1);
      localBundle.putString("troop_uin", paramTroopInfo.troopuin);
      localBundle.putString("uinname", paramTroopInfo.getTroopName());
      ((Intent)localObject).putExtras(localBundle);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
    }
    int j;
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      paramInt = 0;
      switch (this.app.cs(paramTroopInfo.troopuin))
      {
      default: 
        j = 0;
      }
      break;
    }
    for (;;)
    {
      anot.a(this.app, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), j + "", "");
      dT(paramTroopInfo.troopuin, paramTroopInfo.getTroopName());
      return;
      paramInt = 0;
      break;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      j = 0;
      continue;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 1;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.bpw) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
          localTroopInfo = this.jdField_a_of_type_Abge.a(paramInt);
        } while (localTroopInfo == null);
        paramView = (ShaderAnimLayout)paramView.findViewById(2131380244);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131380243);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = (TroopManager)this.app.getManager(52);
    Activity localActivity = getActivity();
    if (paramSlideDetectListView.kv(localTroopInfo.troopuin)) {}
    for (paramInt = 2131694512;; paramInt = 2131694514)
    {
      paramSlideDetectListView = localActivity.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localTroopInfo);
      if (ujs.aTl) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.show();
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader.S(ex());
    if (!UK()) {
      sendEmptyMessageDelayed(103, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader.R(ex());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Abge.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131380244);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131380243);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void bOm()
  {
    if (this.jdField_a_of_type_Abge != null) {
      this.jdField_a_of_type_Abge.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void cml()
  {
    super.cml();
    initAdapter();
    this.jdField_a_of_type_Abge.notifyDataSetChanged();
  }
  
  public void cmn()
  {
    int j = 0;
    Intent localIntent = getActivity().getIntent();
    int k;
    if (localIntent != null)
    {
      k = localIntent.getIntExtra("_key_mode", 0);
      if (k != 0) {}
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UH()) && (j != 0)) {}
      for (j = 24;; j = 16)
      {
        ContactSearchComponentActivity.b(getActivity(), null, 8, j | 0x200000, 561250);
        return;
        if (k != 1) {
          break label81;
        }
        j = 1;
        break;
      }
      label81:
      j = 1;
    }
  }
  
  void dT(String paramString1, String paramString2)
  {
    aqfp.Sz(true);
    Intent localIntent = wja.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((TroopManager)this.app.getManager(52)).b(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      continue;
      this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      showToast(2131720480);
    }
  }
  
  public void initAdapter()
  {
    if (this.jdField_a_of_type_Abge == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UG()) {
        break label107;
      }
    }
    label107:
    for (int j = 1;; j = 0)
    {
      if (this.mFromType == 3) {
        j = 2;
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UH()) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_Abge = new abge(getActivity(), this.app, this, this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView, j, this.bpw, bool, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a);
          this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Abge);
          this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
          return;
        }
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.UH())
    {
      String str = paramIntent.getStringExtra("contactSearchResultTroopUin");
      paramIntent = paramIntent.getStringExtra("contactSearchResultName");
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", str);
      localBundle.putInt("uintype", 1);
      localBundle.putString("troop_uin", str);
      localBundle.putString("uinname", paramIntent);
      localIntent.putExtras(localBundle);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      return;
    }
    dT(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
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
      continue;
      anot.a(this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      anot.a(this.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
      apbc localapbc = (apbc)this.app.getManager(32);
      if (localapbc != null) {
        localapbc.d((BaseActivity)getActivity(), 0);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$a);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$b);
    removeObserver(this.b);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopView$c);
    if (this.jdField_a_of_type_Abge != null) {
      this.jdField_a_of_type_Abge.destroy();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Abge != null) {
      BR(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public class a
    extends acfd
  {
    protected a() {}
    
    public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        TroopView.this.bOm();
      }
    }
    
    public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
    {
      TroopView.this.bOm();
    }
    
    public void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopView.this.bOm();
      }
    }
  }
  
  public class b
    extends achq
  {
    protected b() {}
    
    public void aoF()
    {
      TroopView.this.bOm();
    }
  }
  
  public class c
    extends acnd
  {
    protected c() {}
    
    public void H(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopView.this.bOm();
      }
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
    {
      if (paramBoolean) {
        TroopView.this.bOm();
      }
    }
    
    public void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
    {
      if (paramBoolean) {
        TroopView.this.bOm();
      }
    }
    
    public void jc(boolean paramBoolean)
    {
      if (paramBoolean) {
        TroopView.a(TroopView.this);
      }
      if (TroopView.this.bpK)
      {
        TroopView.this.bpK = false;
        if (!paramBoolean) {
          break label79;
        }
        TroopView.this.jdField_i_of_type_ComTencentMobileqqWidgetPullRefreshHeader.tT(0);
        TroopView.this.sendEmptyMessageDelayed(101, 800L);
      }
      for (;;)
      {
        TroopView.this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new TroopView.MyTroopObserver.1(this), 1200L);
        return;
        label79:
        TroopView.this.jdField_i_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
        TroopView.this.showToast(2131720480);
      }
    }
    
    public void q(int paramInt1, int paramInt2, String paramString)
    {
      if (paramInt1 == 6) {
        if (paramInt2 == 0) {
          TroopView.this.bOm();
        }
      }
      do
      {
        do
        {
          return;
          if (paramInt1 != 2) {
            break;
          }
        } while (paramInt2 != 0);
        TroopView.this.bOm();
        return;
      } while ((paramInt1 != 9) || (paramInt2 != 0));
      TroopView.this.bOm();
    }
    
    public void xj(boolean paramBoolean)
    {
      if (paramBoolean) {
        TroopView.this.bOm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */