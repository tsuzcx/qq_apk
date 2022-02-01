package com.tencent.mobileqq.activity.contact.newfriend;

import acbn;
import accn;
import acdv;
import acfd;
import acfp;
import achg;
import achq;
import ajdo;
import ajdo.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anzd;
import anzf;
import aqha;
import aqju;
import arhz;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import yqv;
import yqy;
import yrh;
import yrp;
import ysa;
import ysc;
import ysd;
import ysf;
import ysr;
import ysr.a;
import yss;
import yst;
import ysx;
import ytd;
import yte;
import ytf;
import ytg;
import yth;
import yti;
import ytj;
import ytk;
import ytl;
import ytq;

public class SystemMsgListView
  extends BaseNewFriendView
  implements ajdo.a, View.OnClickListener, Observer
{
  private arhz A;
  private TextView LT;
  private Context O;
  private yqy jdField_a_of_type_Yqy = new ytj(this);
  private yrp jdField_a_of_type_Yrp;
  private ysf jdField_a_of_type_Ysf;
  private ytd jdField_a_of_type_Ytd;
  acdv jdField_b_of_type_Acdv = new yti(this);
  achq jdField_b_of_type_Achq = new a();
  private SparseArray<yrp> bC = new SparseArray();
  private SparseArray<Boolean> bD = new SparseArray();
  private final int bDP = 0;
  private int bMG;
  public boolean boF;
  acfd jdField_c_of_type_Acfd = new yth(this);
  private TabLayoutCompat.b jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b = new ytf(this);
  private ThemeTabLayout jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  int cbe = -1;
  private accn jdField_d_of_type_Accn = new ytk(this);
  private achg jdField_d_of_type_Achg;
  private ViewGroup dA;
  private ViewGroup dB;
  aqju dialog;
  private ViewGroup dz;
  private SwipListView h;
  Handler handler = new yte(this);
  private RelativeLayout in;
  private FlingHandler mFlingHandler;
  private int mLastVisibleIndex;
  private AbsListView.e o = new ytl(this);
  float qP = 0.0F;
  private View ye;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.O = paramContext;
    this.mFlingHandler = paramFlingHandler;
  }
  
  private void Ad()
  {
    super.setContentView(2131561725);
    this.in = ((RelativeLayout)findViewById(2131370561));
    this.dz = ((ViewGroup)findViewById(2131378048));
    this.LT = ((TextView)findViewById(2131379769));
    this.dA = ((ViewGroup)findViewById(2131366484));
    this.h = ((SwipListView)findViewById(2131379117));
    this.ye = findViewById(2131372405);
    this.bMG = getResources().getDimensionPixelSize(2131297811);
    this.dB = ((ViewGroup)findViewById(2131378047));
    this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131379154));
    fL(this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout);
    this.dz.setVisibility(4);
    this.dB.setVisibility(4);
  }
  
  private void EC(int paramInt)
  {
    if ((((NewFriendActivity)this.O).getActivity() == null) || (this.jdField_a_of_type_Ytd == null)) {}
    do
    {
      return;
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Ytd.getCount()))
      {
        this.dB.setVisibility(4);
        return;
      }
      Object localObject = this.jdField_a_of_type_Ytd.getItem(paramInt);
      if ((paramInt == 0) && (((localObject instanceof ysc)) || ((localObject instanceof ysd))))
      {
        this.dB.setVisibility(4);
        return;
      }
      if ((localObject instanceof ysx))
      {
        this.dB.setVisibility(4);
        return;
      }
      if ((localObject instanceof yst))
      {
        this.dB.setVisibility(4);
        return;
      }
      if ((localObject instanceof yss))
      {
        this.dB.setVisibility(4);
        return;
      }
    } while (paramInt + 1 >= this.jdField_a_of_type_Ytd.getCount());
    ED(paramInt);
  }
  
  private void ED(int paramInt)
  {
    int i = 0;
    Object localObject1;
    if (((ysa)this.jdField_a_of_type_Ytd.getItem(paramInt) instanceof ysr))
    {
      this.cbe = paramInt;
      localObject1 = this.h.getChildAt(0);
      if ((localObject1 != null) && (!this.dB.isShown()))
      {
        this.dB.setVisibility(0);
        Object localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof ysr.a))
        {
          localObject2 = (ysr.a)localObject2;
          if ((((ysr.a)localObject2).b != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null))
          {
            float f = ((ysr.a)localObject2).b.aM();
            if (QLog.isColorLevel()) {
              QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
            }
            this.qP = f;
            this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(f);
          }
        }
        this.jdField_a_of_type_Yrp.caJ = this.h.getFirstVisiblePosition();
        this.jdField_a_of_type_Yrp.caK = ((View)localObject1).getTop();
        int j = this.bC.size();
        paramInt = i;
        while (paramInt < j)
        {
          localObject2 = (yrp)this.bC.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((yrp)localObject2).caJ = this.h.getFirstVisiblePosition();
            ((yrp)localObject2).caK = ((View)localObject1).getTop();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      if (this.cbe > -1) {
        break label256;
      }
      this.dB.setVisibility(4);
    }
    label256:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt > this.cbe)
              {
                this.dB.setVisibility(0);
                return;
              }
            } while (!this.dB.isShown());
            this.dB.setVisibility(4);
          } while (!((ysa)this.jdField_a_of_type_Ytd.getItem(paramInt + 1) instanceof ysr));
          localObject1 = this.h.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof ysr.a));
      localObject1 = (ysr.a)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.aM());
      }
    } while ((((ysr.a)localObject1).b == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null));
    ((ysr.a)localObject1).b.setScrollPosition(this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.aM());
  }
  
  private boolean aA(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject = this.bD.get(paramInt1);
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        return ((Boolean)localObject).booleanValue();
      }
      this.bD.put(paramInt1, Boolean.valueOf(true));
    }
    return false;
  }
  
  private void addObserver()
  {
    this.app.addObserver(this.jdField_b_of_type_Acdv, true);
    this.app.addObserver(this.jdField_c_of_type_Acfd);
    this.app.addObserver(this.jdField_b_of_type_Achq);
    this.app.addObserver(this.jdField_a_of_type_Yqy);
    this.app.addObserver(this.jdField_d_of_type_Accn);
    this.app.b().addObserver(this);
  }
  
  private void cz(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_Ytd = new ytd(this.O, this.app, this.h, this, i, this.mFlingHandler);
    this.h.setAdapter(this.jdField_a_of_type_Ytd);
    clB();
    this.jdField_a_of_type_Yrp = new yrp(23, 0, 0);
  }
  
  private void removeObserver()
  {
    this.app.removeObserver(this.jdField_b_of_type_Acdv);
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app.removeObserver(this.jdField_b_of_type_Achq);
    this.app.removeObserver(this.jdField_a_of_type_Yqy);
    this.app.removeObserver(this.jdField_d_of_type_Accn);
    this.app.b().deleteObserver(this);
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  protected void a(Intent paramIntent, BaseNewFriendView.a parama)
  {
    super.a(paramIntent, parama);
    this.jdField_a_of_type_Ysf = ((ysf)this.app.getManager(34));
    ((ajdo)this.app.getManager(11)).a(this);
    Ad();
    clx();
    cz(paramIntent);
    addObserver();
    this.h.setDragEnable(true);
    this.h.setOnScrollListener(this.o);
    this.jdField_d_of_type_Achg = ((achg)this.app.getManager(159));
  }
  
  void bF()
  {
    if ((this.A != null) && (this.A.isShowing())) {
      this.A.dismiss();
    }
    this.A = null;
  }
  
  public void clB()
  {
    try
    {
      if (this.jdField_a_of_type_Ytd.getCount() > 0)
      {
        this.in.setVisibility(0);
        this.ye.setVisibility(8);
        return;
      }
      this.ye.setVisibility(0);
      this.in.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void clx()
  {
    this.jdField_a_of_type_Ysf.clx();
    if (this.jdField_a_of_type_Ysf.bow)
    {
      this.h.setOverscrollHeader(getResources().getDrawable(2130851105));
      anot.a(this.app, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.h.setOverscrollHeader(null);
  }
  
  public void eH(long paramLong) {}
  
  public void fL(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839642);
      return;
    }
    paramView.setBackgroundResource(2130851238);
  }
  
  public boolean gM(int paramInt)
  {
    Object localObject = this.bD.get(paramInt);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label265:
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_Ytd.refreshData();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Ytd.refreshData();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_Ytd.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_Ytd.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof ysd)) || (!((PhoneContactManagerImp)this.app.getManager(11)).aC(true))) {
            break label265;
          }
          ContactBindedActivity.a(this.app, -1, 2, null);
          break;
        }
      }
    }
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
      yqv.bD((Activity)this.O);
      anot.a(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver();
    this.jdField_a_of_type_Ysf.cls();
    this.bC.clear();
    this.bD.clear();
    if (this.jdField_a_of_type_Ytd != null) {
      this.jdField_a_of_type_Ytd.destroy();
    }
    anzd.a().dTY();
    ((ajdo)this.app.getManager(11)).b(this);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Ytd.xt() == 23) {
      this.jdField_a_of_type_Ytd.cli();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.boF)
    {
      int i = ((PhoneContactManagerImp)this.app.getManager(11)).cU().size();
      this.dialog = aqha.a(getContext(), 230);
      this.dialog.setMessage(acfp.m(2131715106) + i + acfp.m(2131715102));
      this.dialog.setTitle(acfp.m(2131715107));
      ytg localytg = new ytg(this);
      this.dialog.setNegativeButton(acfp.m(2131715103), localytg);
      this.dialog.setPositiveButton(acfp.m(2131715104), localytg);
      this.dialog.show();
      this.boF = false;
      anot.a(this.app, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_Ytd.ckU();
    if (this.jdField_a_of_type_Ytd.xt() == 23) {
      this.jdField_a_of_type_Ytd.clh();
    }
    this.jdField_a_of_type_Ytd.gs(0L);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Ytd.ckT();
    yqv.a(this.app).ckQ();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    clx();
    this.jdField_a_of_type_Ytd.refreshData();
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt) {}
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Ytd.getCount())) {
      this.h.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHeadSelection position : " + paramInt);
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.Ew(paramInt);
    }
  }
  
  public void showProgressDialog()
  {
    if (this.A == null) {
      this.A = new arhz(this.O, getTitleBarHeight());
    }
    this.A.setMessage(this.O.getString(2131719519));
    this.A.show();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.app.runOnUiThread(new SystemMsgListView.4(this));
  }
  
  public void y(ArrayList<yrh> paramArrayList, int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.removeAllTabs();
      this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.b(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b);
      this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.w(paramArrayList, paramInt);
      this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b);
    }
  }
  
  public void zk(String paramString)
  {
    int k = 0;
    String str;
    if (!((ajdo)this.app.getManager(11)).Uv())
    {
      str = this.app.getPreferences().getString("systemmsg_addFriendCount", "");
      if (!TextUtils.isEmpty(str)) {
        break label65;
      }
    }
    label65:
    for (String[] arrayOfString = new String[0]; arrayOfString.length >= 3; arrayOfString = str.split(":")) {
      return;
    }
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.app.getPreferences().edit().putString("systemmsg_addFriendCount", str).commit();
        return;
      }
      i += 1;
    }
    if (arrayOfString.length == 0) {}
    for (;;)
    {
      str = paramString;
      if (arrayOfString.length + 1 != 3) {
        break;
      }
      this.boF = true;
      str = paramString;
      break;
      paramString = str + ":" + paramString;
    }
  }
  
  public class a
    extends achq
  {
    public a() {}
    
    public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
    {
      long l1 = anzd.a().hf();
      if (!TextUtils.isEmpty(paramString1)) {}
      for (;;)
      {
        structmsg.StructMsg localStructMsg;
        try
        {
          l2 = Long.parseLong(paramString1);
          l1 = l2;
          SystemMsgListView.this.handler.sendEmptyMessage(1012);
          localStructMsg = anzd.a().a(Long.valueOf(l1));
          if (SystemMsgListView.this.a.Uj()) {
            break label90;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin");
          }
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
        continue;
        label90:
        if (!paramBoolean)
        {
          if (!TextUtils.isEmpty(paramString3)) {}
          for (;;)
          {
            QQToast.a(SystemMsgListView.a(SystemMsgListView.this), 1, paramString3, 0).show(SystemMsgListView.this.getTitleBarHeight());
            anzf.a(localStructMsg, paramInt3, paramString2, paramString4);
            return;
            paramString3 = SystemMsgListView.a(SystemMsgListView.this).getResources().getString(2131719483);
          }
        }
        paramString1 = SystemMsgListView.a(SystemMsgListView.this).getResources().getString(2131694020);
        QQToast.a(SystemMsgListView.a(SystemMsgListView.this), 2, paramString1, 0).show(SystemMsgListView.this.getTitleBarHeight());
        long l2 = anzd.a().he();
        anzf.a(localStructMsg, paramInt1, paramString2, paramInt2);
        if ((l2 != 0L) && (localStructMsg != null)) {}
        try
        {
          SystemMsgListView.this.app.b().c(acbn.bkJ, 0, l2, localStructMsg.toByteArray());
          if ((paramInt1 != 0) || (localStructMsg == null)) {
            continue;
          }
          paramString3 = new Bundle();
          paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
          paramString2 = localStructMsg.msg.req_uin_nick.get();
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = String.valueOf(localStructMsg.req_uin.get());
          }
          paramString3.putString("base_nick", paramString1);
          paramString3.putInt("verfy_type", localStructMsg.msg.sub_type.get());
          paramString3.putString("verfy_msg", localStructMsg.msg.msg_additional.get());
          if (ytq.a(SystemMsgListView.this.app, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
          {
            paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
            paramString2 = paramString1;
            if (!TextUtils.isEmpty(paramString4)) {
              paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
            }
            paramString3.putString("base_nick", paramString2);
            paramString3.putBoolean("isFromWzry", true);
          }
          AutoRemarkActivity.a(SystemMsgListView.this.a.getActivity(), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
      }
      if (((Activity)SystemMsgListView.a(SystemMsgListView.this)).isFinishing()) {}
      while (!paramBoolean1) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
      }
      try
      {
        if (SystemMsgListView.a(SystemMsgListView.this) != null) {
          SystemMsgListView.a(SystemMsgListView.this).refreshData();
        }
        SystemMsgListView.this.clB();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
    
    public void bh(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.bengin");
      }
      SystemMsgListView.this.bF();
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.success");
        }
        if (SystemMsgListView.a(SystemMsgListView.this) != null) {
          SystemMsgListView.a(SystemMsgListView.this).refreshData();
        }
      }
      while (!paramBoolean2) {
        return;
      }
      SystemMsgListView.this.handler.sendEmptyMessage(1016);
    }
    
    public void clC()
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgError");
      }
      SystemMsgListView.this.bF();
      SystemMsgListView.this.handler.sendEmptyMessage(1016);
    }
    
    public void iv(String paramString)
    {
      if (SystemMsgListView.this.a.Uj())
      {
        paramString = SystemMsgListView.a(SystemMsgListView.this).getResources().getString(2131720702);
        QQToast.a(SystemMsgListView.a(SystemMsgListView.this), 1, paramString, 0).show(SystemMsgListView.this.getTitleBarHeight());
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionError");
    }
    
    public void zl(String paramString)
    {
      if (SystemMsgListView.a(SystemMsgListView.this) != null) {
        SystemMsgListView.a(SystemMsgListView.this).refreshData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */