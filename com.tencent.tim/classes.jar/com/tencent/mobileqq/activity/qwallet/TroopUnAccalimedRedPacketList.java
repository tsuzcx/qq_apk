package com.tencent.mobileqq.activity.qwallet;

import Wallet.RedPackGrapInfo;
import aaaa;
import aaab;
import aaac;
import aaad;
import aaae;
import aaaf;
import aaca;
import aagd;
import acfp;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import aqdj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rpq;
import xlw;
import xvk;
import zzz;

public class TroopUnAccalimedRedPacketList
  extends FrameLayout
{
  private static final String TAG = TroopUnAccalimedRedPacketList.class.getSimpleName();
  private TextView ND;
  private String QE;
  private b jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$b;
  private d jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d;
  private boolean buQ;
  private Context context;
  private RelativeLayout et;
  private boolean isShown;
  private Animator mAnimator;
  private QQAppInterface mAppInterface;
  private BaseChatPie mBaseChatPie;
  private ImageView mCloseBtn;
  private int mGroupType;
  public PopupWindow mPopupWindow;
  private ImageView vO;
  private RecyclerView y;
  
  public TroopUnAccalimedRedPacketList(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie.a().getApplicationContext());
    try
    {
      this.context = paramBaseChatPie.a().getApplicationContext();
      this.mAppInterface = paramQQAppInterface;
      this.mBaseChatPie = paramBaseChatPie;
      this.et = new RelativeLayout(this.context);
      addView(this.et);
      this.et.getLayoutParams().width = -1;
      this.et.getLayoutParams().height = -1;
      this.et.setBackgroundColor(Color.parseColor("#b2000000"));
      this.et.setOnClickListener(new zzz(this));
      this.mCloseBtn = new ImageView(this.context);
      this.et.addView(this.mCloseBtn);
      this.mCloseBtn.setImageResource(2130844248);
      aqcl.s(this.mCloseBtn, acfp.m(2131716153));
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.mCloseBtn.getLayoutParams();
      paramQQAppInterface.leftMargin = rpq.dip2px(this.context, 12.5F);
      paramQQAppInterface.topMargin = rpq.dip2px(this.context, 37.5F);
      this.mCloseBtn.setLayoutParams(paramQQAppInterface);
      this.mCloseBtn.setOnClickListener(new aaaa(this));
      this.vO = new ImageView(this.context);
      this.et.addView(this.vO);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.vO.getLayoutParams();
      paramQQAppInterface.width = rpq.dip2px(this.context, 80.0F);
      paramQQAppInterface.height = rpq.dip2px(this.context, 32.0F);
      paramQQAppInterface.addRule(13);
      this.ND = new TextView(this.context);
      this.et.addView(this.ND);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.ND.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = -2;
      paramQQAppInterface.addRule(15);
      this.ND.setLayoutParams(paramQQAppInterface);
      paramQQAppInterface = this.context.getResources().getDrawable(2130844247);
      paramQQAppInterface.setBounds(0, 0, rpq.dip2px(this.context, 100.0F), rpq.dip2px(this.context, 100.0F));
      this.ND.setCompoundDrawables(null, paramQQAppInterface, null, null);
      this.ND.setCompoundDrawablePadding(rpq.dip2px(this.context, 20.0F));
      this.ND.setTextColor(Color.parseColor("#FFFFFF"));
      this.ND.setTextSize(1, 14.0F);
      this.ND.setGravity(1);
      this.ND.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$b = new b(this.context);
      this.y = new RecyclerView(this.context);
      this.et.addView(this.y);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = rpq.dip2px(this.context, 300.0F);
      paramQQAppInterface.addRule(15);
      this.y.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
      this.y.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$b);
      int i = (rpq.getWindowScreenWidth(this.context) - rpq.dip2px(this.context, 160.0F)) / 2;
      this.y.addItemDecoration(new c(i, rpq.dip2px(this.context, 3.5F), null));
      this.y.setHasFixedSize(false);
      this.y.getItemAnimator().setRemoveDuration(300L);
      this.y.getItemAnimator().setChangeDuration(300L);
      this.y.setOnScrollListener(new aaab(this));
      this.mAnimator = ObjectAnimator.ofFloat(this.y, "translationX", new float[] { i, 0.0F });
      this.mAnimator.setInterpolator(new LinearInterpolator());
      this.mAnimator.setDuration(300L);
      this.y.setVisibility(8);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "init faile because has occur an exception: " + paramQQAppInterface);
    }
  }
  
  public void cQ(String paramString, int paramInt)
  {
    if (this.mAppInterface != null) {
      aagd.a(this.mAppInterface, this.mAppInterface.getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.show", "", "");
    }
    try
    {
      if (this.vO != null) {
        LottieComposition.Factory.fromJsonString(qe(), new aaac(this));
      }
      this.QE = paramString;
      this.mGroupType = paramInt;
      if (this.mPopupWindow == null) {
        this.mPopupWindow = new PopupWindow(this, -1, -1);
      }
      this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
      this.mPopupWindow.setOutsideTouchable(true);
      this.mPopupWindow.setFocusable(true);
      this.mPopupWindow.showAtLocation(this.mBaseChatPie.mAIORootView, 17, 0, 0);
      this.mPopupWindow.setOnDismissListener(new aaad(this));
      RedPacketManager.getInstance().reqGroupAvailableList(this.QE, this.mGroupType, new aaae(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.isShown = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d = new d(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("troop_hblist_broadcast_action");
    this.context.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.isShown = false;
    if ((this.mAnimator != null) && (this.mAnimator.isRunning())) {
      this.mAnimator.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d != null)
    {
      this.context.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$d = null;
    }
    if ((xvk.hU != null) && (!xvk.hU.isEmpty())) {
      xvk.hU.clear();
    }
  }
  
  public String qe()
  {
    return "{\"v\":\"5.5.3\",\"fr\":25,\"ip\":0,\"op\":12,\"w\":156,\"h\":60,\"nm\":\"预合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"形状图层 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[72]},{\"t\":10,\"s\":[80]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[130,30,0],\"to\":[-4.838,0,0],\"ti\":[10.78,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":2,\"s\":[124.6,30,0],\"to\":[-25.839,0,0],\"ti\":[12.231,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[94.8,30,0],\"to\":[-17.333,0,0],\"ti\":[2.8,0,0]},{\"t\":10,\"s\":[78,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"形状图层 1\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[80]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[8]},{\"t\":10,\"s\":[0]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[78,30,0],\"to\":[-7.767,0,0],\"ti\":[8.667,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[31.4,30,0],\"to\":[-8.667,0,0],\"ti\":[0.9,0,0]},{\"t\":10,\"s\":[26,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  public class HbListItem
    extends FrameLayout
  {
    xlw a;
    ImageView avatar;
    FrameLayout bl;
    Context context;
    LinearLayout dX;
    
    public HbListItem(@NonNull Context paramContext, xlw paramxlw)
    {
      super();
      this.context = paramContext;
      this.jdField_a_of_type_Xlw = paramxlw;
      this.dX = new LinearLayout(paramContext);
      this.dX.setOrientation(1);
      this.dX.setClickable(true);
      addView(this.dX);
      this$1 = (FrameLayout.LayoutParams)this.dX.getLayoutParams();
      TroopUnAccalimedRedPacketList.this.width = -2;
      TroopUnAccalimedRedPacketList.this.height = -2;
      this.bl = new FrameLayout(paramContext);
      this.bl.setBackgroundResource(2130848352);
      this.dX.addView(this.bl);
      this$1 = (LinearLayout.LayoutParams)this.bl.getLayoutParams();
      TroopUnAccalimedRedPacketList.this.width = rpq.dip2px(paramContext, 29.0F);
      TroopUnAccalimedRedPacketList.this.height = rpq.dip2px(paramContext, 29.0F);
      TroopUnAccalimedRedPacketList.this.gravity = 1;
      this.avatar = new ImageView(paramContext);
      this.bl.addView(this.avatar);
      this$1 = (FrameLayout.LayoutParams)this.avatar.getLayoutParams();
      TroopUnAccalimedRedPacketList.this.width = rpq.dip2px(paramContext, 28.0F);
      TroopUnAccalimedRedPacketList.this.height = rpq.dip2px(paramContext, 28.0F);
      TroopUnAccalimedRedPacketList.this.gravity = 17;
    }
    
    public void a(RedPackGrapInfo paramRedPackGrapInfo)
    {
      Object localObject;
      if (this.avatar != null)
      {
        localObject = aqdj.a(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), String.valueOf(paramRedPackGrapInfo.lUin), (byte)1);
        this.avatar.setImageDrawable((Drawable)localObject);
      }
      if (this.jdField_a_of_type_Xlw != null)
      {
        this.jdField_a_of_type_Xlw.a(paramRedPackGrapInfo);
        localObject = this.jdField_a_of_type_Xlw.a(this.dX);
        if (localObject == null) {
          break label120;
        }
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = rpq.dip2px(this.context, 11.5F);
        localLayoutParams.gravity = 16;
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Xlw.a((FrameLayout)localObject, paramRedPackGrapInfo, new aaaf(this));
      }
      label120:
      while (!QLog.isColorLevel())
      {
        LinearLayout.LayoutParams localLayoutParams;
        return;
      }
      QLog.w(TroopUnAccalimedRedPacketList.TAG, 2, "red packet item layout is null");
    }
  }
  
  public static abstract class a
  {
    public abstract void FJ(int paramInt);
  }
  
  public class b
    extends RecyclerView.Adapter<a>
  {
    private Context context;
    private List<RedPackGrapInfo> uW;
    
    b(Context paramContext)
    {
      this.context = paramContext;
      this.uW = new ArrayList();
    }
    
    void Aa(String paramString)
    {
      for (;;)
      {
        try
        {
          if (this.uW == null) {
            break label233;
          }
          if (!this.uW.isEmpty()) {
            break label234;
          }
          return;
        }
        catch (Throwable paramString)
        {
          RedPackGrapInfo localRedPackGrapInfo;
          int j;
          if (!QLog.isColorLevel()) {
            break label233;
          }
          QLog.e(TroopUnAccalimedRedPacketList.TAG, 2, "removeHbList occur an exception: " + paramString);
          return;
          i += 1;
          continue;
          TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this).postDelayed(new TroopUnAccalimedRedPacketList.HbListAdapter.1(this), 300L);
          return;
          i = 0;
          continue;
        }
        if (i < this.uW.size())
        {
          localRedPackGrapInfo = (RedPackGrapInfo)this.uW.get(i);
          if ((localRedPackGrapInfo != null) && (localRedPackGrapInfo.sBiilNo.equals(paramString)))
          {
            j = i;
            if (i == this.uW.size()) {
              j = i - 1;
            }
            this.uW.remove(j);
            notifyItemRemoved(j);
            notifyItemRangeChanged(j, this.uW.size());
            if (TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this) == null) {
              break label233;
            }
            if ((this.uW != null) && (!this.uW.isEmpty())) {
              continue;
            }
            if (TroopUnAccalimedRedPacketList.this.mPopupWindow == null) {
              break label233;
            }
            TroopUnAccalimedRedPacketList.this.mPopupWindow.dismiss();
          }
        }
        label233:
        return;
        label234:
        int i = 0;
      }
    }
    
    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(new TroopUnAccalimedRedPacketList.HbListItem(TroopUnAccalimedRedPacketList.this, this.context, new xlw(TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this), this.context, TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this), TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this), TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this))));
    }
    
    public void a(a parama, int paramInt)
    {
      RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.uW.get(parama.getPosition());
      if (localRedPackGrapInfo == null) {}
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
        return;
        TroopUnAccalimedRedPacketList.HbListItem localHbListItem = parama.a;
        if (localHbListItem != null) {
          localHbListItem.a(localRedPackGrapInfo);
        }
      }
    }
    
    public int getItemCount()
    {
      if ((this.uW == null) || (this.uW.isEmpty())) {
        return 0;
      }
      return this.uW.size();
    }
    
    public void ht(List<RedPackGrapInfo> paramList)
    {
      if (this.uW == null) {
        return;
      }
      this.uW.addAll(paramList);
      notifyDataSetChanged();
    }
    
    class a
      extends RecyclerView.ViewHolder
    {
      TroopUnAccalimedRedPacketList.HbListItem a;
      
      a(View paramView)
      {
        super();
        this.a = ((TroopUnAccalimedRedPacketList.HbListItem)paramView);
      }
    }
  }
  
  static class c
    extends RecyclerView.ItemDecoration
  {
    private int cfN;
    private int cfO;
    
    private c(int paramInt1, int paramInt2)
    {
      this.cfN = paramInt1;
      this.cfO = paramInt2;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      int i = paramRecyclerView.getChildPosition(paramView);
      if (i == 0)
      {
        paramRect.left = this.cfN;
        return;
      }
      if (i == paramRecyclerView.getAdapter().getItemCount() - 1)
      {
        paramRect.left = this.cfO;
        paramRect.right = this.cfN;
        return;
      }
      paramRect.left = this.cfO;
    }
  }
  
  class d
    extends BroadcastReceiver
  {
    private d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((!"troop_hblist_broadcast_action".equals(paramIntent.getAction())) || (!TroopUnAccalimedRedPacketList.b(TroopUnAccalimedRedPacketList.this))) {}
      do
      {
        int i;
        do
        {
          do
          {
            return;
            i = paramIntent.getIntExtra("result_code", 0);
            int j = paramIntent.getIntExtra("grap_hb_state", 0);
            paramContext = paramIntent.getStringExtra("listid");
            if (QLog.isColorLevel()) {
              QLog.d(TroopUnAccalimedRedPacketList.TAG, 2, "RedPacketRefreshReceiver|resultCode:" + i + "|listId: " + paramContext + "|grabHbState: " + j);
            }
            if (i != -20180322) {
              break;
            }
            if (TroopUnAccalimedRedPacketList.b(TroopUnAccalimedRedPacketList.this) != null) {
              TroopUnAccalimedRedPacketList.b(TroopUnAccalimedRedPacketList.this).setVisibility(8);
            }
          } while (TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this) == null);
          TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this).setVisibility(8);
          return;
        } while (i != -20180323);
        if (TroopUnAccalimedRedPacketList.b(TroopUnAccalimedRedPacketList.this) != null) {
          TroopUnAccalimedRedPacketList.b(TroopUnAccalimedRedPacketList.this).setVisibility(0);
        }
        if (TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this) != null) {
          TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this).setVisibility(0);
        }
      } while ((TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this) == null) || (TextUtils.isEmpty(paramContext)));
      TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this).Aa(paramContext);
      aaca.K(TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this), TroopUnAccalimedRedPacketList.a(TroopUnAccalimedRedPacketList.this), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList
 * JD-Core Version:    0.7.0.1
 */