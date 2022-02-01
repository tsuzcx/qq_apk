import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.werewolves.GameView;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class xzp
  extends yam
  implements ajry.a
{
  arhz A;
  protected TextView KF;
  protected TextView KG;
  arec jdField_a_of_type_Arec = new xzw(this);
  public aree a;
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
  public WereWolvesLoadingView a;
  BroadcastReceiver aM = new yad(this);
  BroadcastReceiver aN = new yae(this);
  ardq b;
  private final int bXY = Color.parseColor("#00000000");
  int bXZ;
  int bYa;
  protected boolean bkS;
  protected boolean bkT = true;
  boolean bkU = true;
  protected LinearLayout hm;
  protected RelativeLayout ic;
  boolean isCreate = false;
  protected ajry mGameRoomAVController;
  protected boolean mIsBack;
  protected ImageView ua;
  protected ImageView ub;
  private View.OnClickListener x = new yah(this);
  public View xo;
  View xp;
  
  public xzp(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public HashMap<String, Integer> A()
  {
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared == null) {
      return new HashMap();
    }
    return localared.A();
  }
  
  public void Ib()
  {
    this.TAG = "Q.werewolf.GameRoomChatPie";
  }
  
  public boolean OK()
  {
    return false;
  }
  
  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (paramInt == 25)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2131558657, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.app, this.sessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l = ((Long)ajrb.c(this.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.time < l) {
          paramList.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
            paramList.remove(i);
          }
        }
      }
    }
    super.a(paramList, paramCharSequence, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramCharSequence = (ChatMessage)paramList.next();
      if ((this.jdField_b_of_type_Ardq.cAf != null) && (this.jdField_b_of_type_Ardq.cAf.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  protected View aQ()
  {
    GameView localGameView = new GameView(this.mContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.xo = localGameView;
    return localGameView;
  }
  
  public boolean af(boolean paramBoolean)
  {
    Object localObject = this.mActivity.getIntent().getStringExtra("uin");
    this.mGameRoomAVController = ajry.a();
    this.jdField_b_of_type_Ardq = ((ardq)this.app.getBusinessHandler(107));
    this.jdField_a_of_type_Aree = this.jdField_b_of_type_Ardq.a((String)localObject);
    super.af(paramBoolean);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.mActivity;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        i = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        fV(1);
        return true;
      }
      this.sessionInfo.aTl = this.mActivity.getIntent().getStringExtra("uin");
      this.isCreate = true;
      this.app.addObserver(this.jdField_a_of_type_Arec);
      this.mGameRoomAVController.reset(this.mContext);
      localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.werewoves.plugin");
      try
      {
        this.mActivity.registerReceiver(this.aM, localIntentFilter);
        this.mActivity.registerReceiver(this.aN, (IntentFilter)localObject);
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      i = 1;
    }
  }
  
  public void bGE()
  {
    int j = 0;
    super.bGE();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.app);
    int i;
    if ((localObject == null) || (((String)localObject).equals("1000")))
    {
      i = 1;
      ay(-1, true);
      ay(0, true);
      a().setImmersiveStatus(0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this.mContext, 295.0F);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = aqcx.dip2px(this.mContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setGravity(16);
      this.hm = new LinearLayout(this.mContext);
      this.hm.setId(2131370498);
      this.hm.setOrientation(0);
      this.hm.setGravity(16);
      new RelativeLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 50.0F)).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(this.hm, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, aqcx.dip2px(this.mContext, 0.0F));
      this.hm.setClickable(true);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130838162);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
      localObject = (RelativeLayout)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getParent();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.gravity = 16;
      localLayoutParams.topMargin = 0;
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      if ((((RelativeLayout)localObject).getParent() instanceof LinearLayout))
      {
        localObject = (LinearLayout)((RelativeLayout)localObject).getParent();
        localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
      int k = aqcx.dip2px(this.mContext, 5.0F);
      this.ua = new ImageView(this.mContext);
      this.ua.setPadding(k, k, k, k);
      this.ua.setOnClickListener(this.x);
      this.hm.addView(this.ua, new ViewGroup.LayoutParams(-2, -2));
      this.ub = new ImageView(this.mContext);
      this.ub.setImageResource(2130838207);
      this.ub.setPadding(0, k, 0, k);
      this.ub.setOnClickListener(this.x);
      this.hm.addView(this.ub, new ViewGroup.LayoutParams(-2, -2));
      this.KF = new TextView(this.mContext);
      this.KF.setGravity(17);
      if (i == 0) {
        break label1049;
      }
      this.KF.setTextColor(Color.parseColor("#a1a2a3"));
      label592:
      this.KF.setBackgroundResource(2130850843);
      this.KF.setTextSize(16.0F);
      this.KF.setText(acfp.m(2131706826));
      this.KF.setMinHeight(aqcx.dip2px(this.mContext, 35.0F));
      this.KF.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(this.mContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(this.mContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = aqcx.dip2px(this.mContext, 7.0F);
      this.fs.addView(this.KF, (ViewGroup.LayoutParams)localObject);
      this.KF.setOnTouchListener(new xzq(this));
      this.ic = new RelativeLayout(this.mContext);
      this.ic.setOnTouchListener(new xzy(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this.mContext, 295.0F);
      this.ic.setBackgroundColor(this.bXY);
      this.ic.setVisibility(8);
      this.fs.addView(this.ic, (ViewGroup.LayoutParams)localObject);
      this.KG = new TextView(this.mContext);
      this.KG.setGravity(17);
      this.KG.setTextSize(18.0F);
      this.KG.setText(acfp.m(2131706840));
      this.KG.setEnabled(true);
      this.KG.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.KG.setOnTouchListener(new yag(this));
      this.ic.addView(this.KG, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this.mContext, 50.0F);
      i = j;
      label986:
      if (i >= this.fs.getChildCount()) {
        break label1095;
      }
      if (this.fs.getChildAt(i) != this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout) {
        break label1072;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        this.fs.addView(aQ(), i, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        this.Cu.setVisibility(8);
        cgp();
        return;
        i = 0;
        break;
        label1049:
        this.KF.setTextColor(this.mContext.getResources().getColor(2131167399));
        break label592;
        label1072:
        i += 1;
        break label986;
        this.fs.addView(aQ(), (ViewGroup.LayoutParams)localObject);
      }
      label1095:
      i = -1;
    }
  }
  
  public void bGR()
  {
    this.Cu.setVisibility(8);
  }
  
  public void bGY()
  {
    ausj localausj = (ausj)auss.a(a(), null);
    ared localared = this.jdField_a_of_type_Aree.a();
    boolean bool;
    if (localared != null)
    {
      bool = localared.aGn();
      if (bool) {
        localausj.addButton(acfp.m(2131706757), 3);
      }
      if (!bool) {
        break label102;
      }
      localausj.addButton(acfp.m(2131706821));
    }
    for (;;)
    {
      localausj.addButton(acfp.m(2131706828));
      localausj.addCancelButton(acfp.m(2131706782));
      localausj.a(new yaa(this, bool, localausj));
      localausj.show();
      return;
      bool = false;
      break;
      label102:
      localausj.addButton(acfp.m(2131706779), 3);
    }
  }
  
  public void bHt()
  {
    super.bHt();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) {
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    }
  }
  
  public void bIM() {}
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
  }
  
  public void bt(Intent paramIntent)
  {
    this.Cr.setText(2131690700);
    this.Cr.setContentDescription(acfp.m(2131706819));
    this.pq.setVisibility(4);
    this.aSe = false;
  }
  
  public void cgn()
  {
    if ((this.bkS) || (isDestroy())) {}
    do
    {
      return;
      try
      {
        long l = Long.parseLong(this.sessionInfo.aTl);
        this.mGameRoomAVController.r(l, this.sessionInfo.aTn);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void cgo() {}
  
  public void cgp()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (a().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.fs.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.ehy();
    }
    if (this.jdField_a_of_type_Aree.isLoaded())
    {
      initPlugin();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void cgq()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.bkU = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.bHJ = false;
    a().startActivity(localIntent);
  }
  
  public void cgr()
  {
    ausj localausj = (ausj)auss.a(a(), null);
    localausj.setMainTitle(acfp.m(2131706791));
    localausj.addButton(acfp.m(2131706778), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new yab(this, localausj));
    localausj.show();
  }
  
  public void cgs()
  {
    Object localObject = this.jdField_a_of_type_Aree.a();
    if (localObject == null) {
      return;
    }
    localObject = ((ared)localObject).ad();
    this.ua.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.KF.setVisibility(4);
  }
  
  public void cgt()
  {
    HotChatInfo localHotChatInfo = this.app.a(true).a(this.sessionInfo.aTl);
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared == null) {
      return;
    }
    int i = localared.MD();
    int j = localared.MC();
    this.jdField_b_of_type_Ardq.a(localHotChatInfo, i, j, new yaf(this));
    anot.a(this.app, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + i, "" + j, "", "");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.bkS = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.bkS) {
        this.mGameRoomAVController.reset(this.mContext);
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aree != null) {
      this.jdField_a_of_type_Aree.a(this);
    }
    if ((this.aSY) || (!this.isCreate))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
      return;
    }
    super.doOnDestroy();
    this.isCreate = false;
    if (this.bkS) {
      this.jdField_b_of_type_Ardq.a(this.jdField_b_of_type_ComTencentMobileqqDataHotChatInfo, new yai(this));
    }
    this.app.removeObserver(this.jdField_a_of_type_Arec);
    ((View)this.cL.getParent()).setBackgroundColor(0);
    ay(this.mContext.getResources().getColor(2131167361), true);
    try
    {
      if ((this.A != null) && (this.A.isShowing()))
      {
        this.A.dismiss();
        this.A = null;
      }
      this.mActivity.unregisterReceiver(this.aN);
      this.mActivity.unregisterReceiver(this.aM);
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
  
  public void doOnPause()
  {
    super.doOnPause();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.sessionInfo.aTl);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label19:
      ared localared;
      break label19;
    }
    localared = this.jdField_a_of_type_Aree.a();
    if ((localared != null) && (HotChatManager.bHJ)) {
      localared.ehB();
    }
    HotChatManager.bHJ = true;
    if (((this.jdField_a_of_type_Aree.isReady()) || (!this.mIsBack)) && (!this.bkS) && (this.bkU))
    {
      this.mGameRoomAVController.a(1, null, l1, this.sessionInfo.aTn);
      if ((localared != null) && (localared.isPlaying())) {
        anot.a(this.app, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.bkU = true;
    this.mGameRoomAVController.bdN = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mGameRoomAVController.dyZ();
    this.mGameRoomAVController.bdN = true;
    this.mGameRoomAVController.cpY = false;
    if (!this.mGameRoomAVController.JN()) {
      this.mGameRoomAVController.a(this);
    }
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared != null) {
      localared.ehC();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void hideAllPanels()
  {
    super.hideAllPanels();
    Object localObject = this.jdField_a_of_type_Aree.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ared)localObject).ad();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (localObject == null));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.ua.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    this.KF.setVisibility(0);
  }
  
  public void initPlugin()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    super.n(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_Aree.a();
    if (localObject != null)
    {
      localObject = ((ared)localObject).ad();
      if (localObject == null) {
        QLog.e(this.TAG, 1, "onPanelChanged: drawables == null");
      }
    }
    else
    {
      return;
    }
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
    {
      this.ub.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      return;
    }
    this.ub.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  public boolean onBackEvent()
  {
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared == null) {
      return super.onBackEvent();
    }
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0) {
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_Ajtx != null) && (this.jdField_a_of_type_Ajtx.isShow()))
    {
      bzx();
      return true;
    }
    if (!this.jdField_a_of_type_Aree.isReady())
    {
      this.mIsBack = true;
      this.bkS = true;
      return super.onBackEvent();
    }
    if ((localared.isPlaying()) && (localared.aGn()))
    {
      this.mIsBack = true;
      return super.onBackEvent();
    }
    if ((localared.isPlaying()) && (!localared.aGn()))
    {
      aqha.a(this.mContext, 230, null, acfp.m(2131706798), acfp.m(2131706824), acfp.m(2131706808), new yaj(this), new yak(this)).show();
      return true;
    }
    aqha.a(this.mContext, 230, null, acfp.m(2131706832), acfp.m(2131706788), acfp.m(2131706766), new yal(this, localared), new xzr(this)).show();
    return true;
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.mContext, 1, 2131696273, 0).show();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.mContext, 1, 2131696273, 0).show();
  }
  
  public void setDarkTheme(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bke = paramBoolean1;
    this.jdField_b_of_type_Ardq.isNight = paramBoolean1;
    ay(0, true);
    a().setImmersiveStatus(0);
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared == null) {}
    label651:
    label661:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localared.ad();
      HashMap localHashMap2 = localared.A();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
        this.pz.setVisibility(8);
        this.pz.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.cL.getParent();
        this.cL.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        ay(0, true);
        this.KF.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.KF.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
        {
          this.ub.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.hm.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
            break label599;
          }
          this.ua.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label317:
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130840156);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.notifyDataSetChanged();
          }
          this.mTitleText.setTextColor(((Integer)localHashMap2.get("titleColor")).intValue());
          this.Cu.setVisibility(8);
          this.Cr.setTextColor(((Integer)localHashMap2.get("leftTextColor")).intValue());
          this.Cr.setBackgroundDrawable((Drawable)localHashMap1.get("backIcon"));
          this.pp.setImageDrawable((Drawable)localHashMap1.get("rightMenu"));
          if (!paramBoolean1) {
            break label620;
          }
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(0.2F);
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(false);
          label450:
          if (!paramBoolean1) {
            break label651;
          }
          this.ic.setVisibility(0);
          if ((!paramBoolean2) || (localared.aGn())) {
            break label639;
          }
          this.KG.setVisibility(0);
          this.KG.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.bYa = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.bXZ = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.KG.setTextColor(this.bXZ);
        }
        for (;;)
        {
          if (this.xp == null) {
            break label661;
          }
          this.xp.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.ub.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label599:
          this.ua.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label317;
          label620:
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
          break label450;
          label639:
          this.KG.setVisibility(8);
          continue;
          this.ic.setVisibility(8);
        }
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void vW(boolean paramBoolean)
  {
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared == null)
    {
      super.vW(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_Aree.isReady())
    {
      super.vW(paramBoolean);
      this.mIsBack = true;
      this.bkS = true;
      return;
    }
    if ((localared.isPlaying()) && (localared.aGn()))
    {
      super.vW(paramBoolean);
      this.mIsBack = true;
      return;
    }
    if ((localared.isPlaying()) && (!localared.aGn()))
    {
      aqha.a(this.mContext, 230, null, acfp.m(2131706827), acfp.m(2131706773), acfp.m(2131706806), new xzs(this, paramBoolean), new xzt(this)).show();
      return;
    }
    aqha.a(this.mContext, 230, null, acfp.m(2131706803), acfp.m(2131706760), acfp.m(2131706814), new xzu(this, paramBoolean, localared), new xzv(this)).show();
  }
  
  public void yu(String paramString)
  {
    this.bkS = true;
    this.bkT = false;
    aqju localaqju = aqha.a(this.mActivity, 230);
    localaqju.setMessage(paramString);
    localaqju.setPositiveButton(2131721079, new xzx(this));
    localaqju.setOnDismissListener(new xzz(this));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onKickOut! isStopped = " + this.isStopped);
    }
    if (!this.isStopped)
    {
      localaqju.show();
      return;
    }
    this.bkT = true;
    fV(1);
  }
  
  public void yv(String paramString)
  {
    Intent localIntent = new Intent(this.mContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.app.getCurrentAccountUin()).append("&gc=").append(this.sessionInfo.aTl).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.mContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.mContext.startActivity(localIntent);
    ajry.a().cpY = true;
  }
  
  public void zM(boolean paramBoolean)
  {
    this.KF.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      hideAllPanels();
      this.mGameRoomAVController.aqH();
      this.KF.setEnabled(false);
      this.ua.setEnabled(false);
      this.ub.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      ared localared = this.jdField_a_of_type_Aree.a();
      if (this.xp == null)
      {
        this.xp = new View(this.mContext);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.fs.addView(this.xp, (ViewGroup.LayoutParams)localObject);
          this.xp.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localared != null)
          {
            localObject = localared.A();
            this.xp.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.xp.setVisibility(0);
          if ((localared == null) || (!localared.aGn())) {
            break label292;
          }
          this.KF.setText(acfp.m(2131706823));
          label209:
          if (!this.bke) {
            this.ic.setVisibility(8);
          }
        }
      }
    }
    label292:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.xp.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight();
      this.xp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.KF.setText(acfp.m(2131706776));
      break label209;
      this.KF.setText(acfp.m(2131706799));
      this.KF.setEnabled(true);
      this.ua.setEnabled(true);
      this.ub.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    } while (this.xp == null);
    this.xp.setVisibility(8);
  }
  
  public void zQ(int paramInt)
  {
    super.zQ(paramInt);
    this.mGameRoomAVController.zQ(paramInt);
    ared localared = this.jdField_a_of_type_Aree.a();
    if (localared != null) {
      localared.zQ(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzp
 * JD-Core Version:    0.7.0.1
 */