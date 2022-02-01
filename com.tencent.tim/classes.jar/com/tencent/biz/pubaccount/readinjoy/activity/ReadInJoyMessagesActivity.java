package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqfo;
import ausj;
import auss;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.d;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.XListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import kbp;
import kic;
import kid;
import kie;
import kxm;
import lbz;
import lcc;
import lcd;
import lce;
import mqq.os.MqqHandler;
import msg;
import nzo;
import nzq;
import oal;
import oan;
import odd;
import org.json.JSONException;
import org.json.JSONObject;
import txn;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, KandianMergeManager.d, DragFrameLayout.c, AbsListView.e, SwipListView.a
{
  public static int aIZ;
  public static int aJa = 1;
  protected DragFrameLayout a;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new kid(this);
  private nzq jdField_a_of_type_Nzq;
  public boolean afs;
  public boolean aft;
  private QQAppInterface app;
  private KandianMergeManager b;
  private lce c = new kic(this);
  private SwipListView e;
  private List<oal> ge;
  public View jB;
  private int mScrollState = 0;
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    DragFrameLayout localDragFrameLayout = null;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    int i = 0;
    View localView = null;
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        localView = localViewGroup.getChildAt(i);
        if ((localView instanceof DragFrameLayout)) {
          return (DragFrameLayout)localView;
        }
        if (!(localView instanceof TopGestureLayout)) {}
      }
      else
      {
        if (localView != null)
        {
          localDragFrameLayout = new DragFrameLayout(paramActivity.getApplication());
          localViewGroup.addView(localDragFrameLayout, 0);
          localViewGroup.removeView(localView);
          if (localView.getParent() != null) {
            ((ViewGroup)localView.getParent()).removeView(localView);
          }
          localDragFrameLayout.addView(localView);
        }
        return localDragFrameLayout;
      }
      i += 1;
    }
  }
  
  private void aDg()
  {
    if (this.jdField_a_of_type_Nzq.getCount() == 0)
    {
      TextView localTextView = (TextView)this.jB.findViewById(2131380239);
      this.jB.setVisibility(0);
      ((ImageView)this.jB.findViewById(2131373775)).setImageResource(2130843648);
      this.jB.setBackgroundResource(2131166344);
      this.e.setBackgroundResource(2130851770);
      return;
    }
    this.jB.setVisibility(8);
    this.e.setBackgroundResource(2131166344);
  }
  
  private void initData()
  {
    lcc.a().b(this.c);
    msg localmsg;
    String str;
    if (this.b != null)
    {
      localmsg = msg.a();
      str = this.app.getCurrentAccountUin();
      if (!this.b.BD()) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 1)
    {
      localmsg.aN(str, i);
      return;
    }
  }
  
  private void initUI()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    setContentView(2131560485);
    this.b = ((KandianMergeManager)this.app.getManager(162));
    this.b.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    setTitle("");
    this.jB = findViewById(2131366438);
    this.e = ((SwipListView)findViewById(2131366997));
    this.e.setDivider(getResources().getDrawable(2131166633));
    this.e.setDividerHeight(getResources().getDimensionPixelSize(2131297134));
    this.e.setOnScrollListener(this);
    this.e.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
    this.jdField_a_of_type_Nzq = new nzq(getActivity(), this.app, this.e, getActivity().getLayoutInflater());
    this.jdField_a_of_type_Nzq.setOnClickListener(this);
    this.e.setAdapter(this.jdField_a_of_type_Nzq);
    this.jdField_a_of_type_Nzq.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.e.setBackgroundResource(2131166344);
    this.e.setDragEnable(true);
    this.e.setRightIconMenuListener(this);
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.bI() != null) && (paramDragFrameLayout.bI().getId() == 2131381284))
    {
      paramDragFrameLayout = (oal)paramDragFrameLayout.bI().getTag(2131378978);
      if (paramDragFrameLayout != null)
      {
        anot.a(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.mUin, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.aOr, "", "", "");
        paramDragFrameLayout.bcT();
      }
    }
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label161;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label140;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label140:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label161:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        this.mSystemBarComp.setStatusBarColor(-4210753);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void aDh()
  {
    ((lcd)this.app.getManager(163)).b().aJk();
    msg localmsg;
    String str;
    if (this.b != null)
    {
      localmsg = msg.a();
      str = this.app.getCurrentAccountUin();
      if (!this.b.BD()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localmsg.aN(str, i);
      return;
    }
  }
  
  public void bS(List<oal> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() != -1)) {}
    while ((this.jdField_a_of_type_Nzq == null) || (this.jB == null)) {
      return;
    }
    if (paramList != null) {
      this.ge = paramList;
    }
    if (this.mScrollState != 0)
    {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyMessagesActivity.3(this, paramList), 1500L);
      return;
    }
    this.aft = true;
    this.jdField_a_of_type_Nzq.ds(this.ge);
    this.jdField_a_of_type_Nzq.bcM();
    this.jdField_a_of_type_Nzq.bcL();
    this.jdField_a_of_type_Nzq.notifyDataSetChanged();
    aDg();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initUI();
    aDb();
    initData();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.e != null)
    {
      this.e.setAdapter(null);
      this.e.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_Nzq != null)
    {
      this.jdField_a_of_type_Nzq.onDestory();
      this.jdField_a_of_type_Nzq = null;
    }
    this.b.b(this);
    this.ge = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    lcc.a().c(this.c);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((lcd)this.app.getManager(163)).b().aJk();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.b.oj());
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (getIntent().getBooleanExtra("shouldBackSelfAct", false))
    {
      Intent localIntent = new Intent(this, ReadInJoySelfActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131378975: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (((Integer)paramView.getTag(2131378979)).intValue() != nzo.bdr);
      localObject2 = paramView.getTag(2131378978);
      Object localObject3 = paramView.getTag(2131378987);
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label483;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label488;
        }
        anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject2 = "";
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", kxm.aMw);
          ((JSONObject)localObject3).put("reddot_num", localInteger);
          localObject3 = ((JSONObject)localObject3).toString();
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            localObject2 = "";
          }
        }
        kbp.a(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject2, false);
        anot.a(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        kbp.a(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", kxm.bd(localInteger.intValue()), false);
        if (TextUtils.isEmpty(oan.a().getNickName((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.app.getBusinessHandler(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).AF();
          }
        }
        localObject2 = paramView.getTag(2131378980);
        if (localObject2 == null) {
          break label532;
        }
        localObject2 = (String)localObject2;
        localObject3 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", (String)localObject2);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", localInteger);
        ((Intent)localObject3).putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity((Intent)localObject3);
        odd.bU(null, "SUBSCRIPT_AIO_COST");
        break;
        localObject1 = "";
        break label121;
        i = 0;
        break label135;
        anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131371300: 
      localObject1 = paramView.getTag(2131378987);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        lbz.a().mO((String)localObject1);
        break;
      }
    case 2131371306: 
      localObject1 = paramView.getTag(2131378987);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        lbz.a().mP((String)localObject1);
        break;
      }
    case 2131371305: 
      localObject1 = paramView.getTag(2131378987);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        localObject2 = paramView.getTag(2131378980);
        if (localObject2 == null) {
          break label748;
        }
      }
      for (localObject2 = (String)localObject2;; localObject2 = "")
      {
        ausj localausj = (ausj)auss.a(getActivity(), null);
        localausj.setMainTitle(String.format(getResources().getString(2131698742), new Object[] { localObject2 }));
        localausj.addButton(2131698678, 3);
        localausj.addCancelButton(2131721058);
        localausj.a(new kie(this, (String)localObject1, localausj));
        localausj.show();
        break;
        localObject1 = "";
        break label638;
      }
    case 2131371285: 
      label121:
      label638:
      localObject1 = paramView.getTag(2131378987);
      label135:
      label483:
      label488:
      label748:
      if (localObject1 != null) {}
      label532:
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        lbz.a().mQ((String)localObject1);
        break;
      }
    }
    int j = ((Integer)paramView.getTag(2131378979)).intValue();
    int i = ((Integer)paramView.getTag(2131376669)).intValue();
    if (j == nzo.bds) {
      kxm.aJ(this, (String)paramView.getTag(2131379238));
    }
    j = ((Integer)paramView.getTag(2131376668)).intValue();
    if (j == aIZ) {
      kbp.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", kxm.bd(i), false);
    }
    for (;;)
    {
      paramView.findViewById(2131381284).setVisibility(8);
      paramView.findViewById(2131362995).setVisibility(0);
      this.b.aIM();
      break;
      if (j == aJa) {
        kbp.a(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", kxm.bd(i), false);
      }
    }
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    switch (paramInt)
    {
    default: 
      txn.a().startMonitorScene("list_subscript");
      return;
    }
    txn.a().stopMonitorScene("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */