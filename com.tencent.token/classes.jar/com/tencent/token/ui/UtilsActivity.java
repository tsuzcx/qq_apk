package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.e;
import com.tencent.token.core.bean.i;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.GuideQQPimSecureTipsView;
import com.tencent.token.ui.base.LineGridView;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.a;
import com.tencent.token.ui.gallery.GalleryActivity;
import com.tencent.token.ui.qqpim.QQPimActivity;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UtilsActivity
  extends BaseActivity
{
  public static final String ACTION_GET_UTILS_ICON_FLAG = "com.tencent.token.utils_icon_flag";
  public static final String ACTION_SIDEBAR_STATE_CHANGED = "com.tencent.token.siderbar.statechanged";
  public static final int SECENE_ACCOUNT_LOCK = 5;
  public static final int SECENE_EMERGENCY_FREEZE = 10;
  public static final int SECENE_GAME_LOCK = 6;
  public static final int SECENE_GAME_PROTECT = 2;
  public static final int SECENE_LOGIN_PROTECT = 1;
  public static final int SECENE_MAIL_PROTECT = 3;
  public static final int SECENE_MB_INFO = -1;
  public static final int SECENE_MODIFY_PWD = 8;
  public static final int SECENE_PHOTO_PROTECT = 20;
  public static final int SECENE_QBQD_PROTECT = 4;
  public static final int SECENE_QQPIM_PROTECT = 11;
  public static final int SECENE_QQ_PROTECT = -3;
  public static final int SECENE_REAL_NAME = 7;
  public static final int SECENE_RECOVER_FRIENDS = 9;
  public static final int SECENE_TOKEN_LAB = -2;
  private static final String TOKEN_CODE_CHANGE_30S = "com.tencent.token.token_code_change_30s";
  private int[][] ICONS_2D;
  private int[][] SCENEIDS_2D = { { 1, 2, 3, 4, 5, 6, 7, 11, 20 }, { 8, 9, 10 } };
  private int[][] TEXTS_2D;
  private final int UPDATETOKEN;
  es mCache;
  private a mCodeLineView;
  private TextView[] mCodeTexts;
  private UserTask mGetDualMsgTask;
  private GuideQQPimSecureTipsView mGuideQQPimSecureTipsView;
  public Handler mHandler;
  private int mI;
  private boolean[][] mIsItemBusy;
  private int mJ;
  ArrayList mProtectLineGridAdapter;
  ArrayList mProtectLineGridItemDatas;
  private View.OnClickListener mQQFaceListener;
  private boolean mQueryingDualMsg;
  private BroadcastReceiver mReceiver;
  private View.OnClickListener mRightTitleButtonClickListener;
  private int[][] mSceneIds;
  private int mSecene;
  private TitleOptionMenu mTitleMenu;
  private String[] mTitles;
  private boolean needgotologobyprotect;
  
  public UtilsActivity()
  {
    int[] arrayOfInt = { 8, 9, 10 };
    this.mSceneIds = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 11, 20 }, arrayOfInt };
    this.ICONS_2D = new int[][] { { 2130837770, 2130837755, 2130837758, 2130837768, 2130837749, 2130837754, 2130837775, 2130837773, 2130837765 }, { 2130837760, 2130837776, 2130837751 } };
    this.TEXTS_2D = new int[][] { { 2131231533, 2131231548, 2131231534, 2131231598, 2131231122, 2131231123, 2131231331, 2131231304, 2131231061 }, { 2131231243, 2131231602, 2131230954 } };
    this.mIsItemBusy = new boolean[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0 } };
    this.mTitles = new String[] { RqdApplication.l().getResources().getString(2131230773), RqdApplication.l().getResources().getString(2131230775) };
    this.mProtectLineGridItemDatas = new ArrayList();
    this.mProtectLineGridAdapter = new ArrayList();
    this.mSecene = 0;
    this.mI = 0;
    this.mJ = 0;
    this.mCache = dr.a().h;
    this.mCodeTexts = new TextView[6];
    this.mQueryingDualMsg = false;
    this.UPDATETOKEN = -100;
    this.mQQFaceListener = new abo(this);
    this.mRightTitleButtonClickListener = new abr(this);
    this.mReceiver = new abt(this);
    this.mHandler = new abu(this);
  }
  
  private void checkBindQQ(ace paramace)
  {
    dr.a().h.a(es.a[ace.a(paramace)]).a();
    setNewFlag(ace.a(paramace), ace.b(paramace), ace.c(paramace));
    if (this.mIsItemBusy[ace.b(paramace)][ace.c(paramace)] != 0) {
      return;
    }
    this.mIsItemBusy[ace.b(paramace)][ace.c(paramace)] = 1;
    this.mSecene = ace.a(paramace);
    this.mI = ace.b(paramace);
    this.mJ = ace.c(paramace);
    do localdo = do.a();
    if (localdo.e() == null)
    {
      this.mIsItemBusy[ace.b(paramace)][ace.c(paramace)] = 0;
      paramace = new Intent(this, WtLoginAccountInput.class);
      paramace.putExtra("page_id", 4);
      startActivity(paramace);
      return;
    }
    if (localdo.o())
    {
      h.c("UtilsActivity--agent.isPrepare validate");
      if (localdo.e() == null)
      {
        this.mIsItemBusy[ace.b(paramace)][ace.c(paramace)] = 0;
        showUserDialog(9);
        return;
      }
      if (ace.a(paramace) == 7) {
        showProDialog(this, 2131230843, 2131231601, null);
      }
      gotoActivity(this.mSecene, this.mI, this.mJ);
      return;
    }
    cw.a().b(this.mHandler);
    h.c("UtilsActivity--agent.isPrepare invalidate");
    showProDialog(this, 2131230843, 2131231601, null);
  }
  
  private i constructGalleryToolItem()
  {
    Object localObject = String.format("{\"id\":\"%1$d\",\"icon\":\"\",\"title\":\"%2$s\",\"url\":\"\"}", new Object[] { Integer.valueOf(20), getResources().getString(2131231065) });
    try
    {
      localObject = new i(new JSONObject((String)localObject));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private i constructToolItem()
  {
    try
    {
      i locali = new i(new JSONObject("{\"id\":\"11\",\"icon\":\"\",\"title\":\"通讯录保护\",\"url\":\"\"}"));
      return locali;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private void displayIconAccordingToFlag()
  {
    int i = 0;
    while (i < this.mSceneIds.length)
    {
      int j = 0;
      while (j < this.mSceneIds[i].length)
      {
        setNewFlag(this.mSceneIds[i][j], i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private int getIconIdBySceneId(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return -1;
    case 1: 
      return 2130837770;
    case 2: 
      return 2130837755;
    case 3: 
      return 2130837758;
    case 4: 
      return 2130837768;
    case 5: 
      return 2130837749;
    case 6: 
      return 2130837754;
    case 7: 
      return 2130837775;
    case 8: 
      return 2130837760;
    case 9: 
      return 2130837776;
    case 10: 
      return 2130837751;
    case 11: 
      return 2130837773;
    }
    return 2130837765;
  }
  
  private void goToWtLoginAccountInput()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void gotoActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mIsItemBusy[paramInt2][paramInt3] = 0;
    switch (paramInt1)
    {
    case -1: 
    case 0: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 3: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 8, 1);
        return;
      }
      startActivity(new Intent(this, UtilsMailProtectActivity.class));
      return;
    case 5: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 11, 1);
        return;
      }
      startActivity(new Intent(this, UtilsAccountLockActivity.class));
      return;
    case 1: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 12, 1);
        return;
      }
      startActivity(new Intent(this, UtilsLoginProtectActivity.class));
      return;
    case 8: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 10, 1);
        return;
      }
      localObject = new Intent(this, ModifyQQPwdActivity.class);
      pg.a().a(this, (Intent)localObject, pg.b);
      return;
    case 6: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 15, 1);
        return;
      }
      startActivity(new Intent(this, UtilsGameLockActivity.class));
      return;
    case 2: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 15, 1);
        return;
      }
      ch.a().a(System.currentTimeMillis(), 75);
      startActivity(new Intent(this, UtilsGameProtectActivity.class));
      return;
    case 4: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 9, 1);
        return;
      }
      startActivity(new Intent(this, UtilsQbQdProtectActivity.class));
      return;
    case 9: 
      w.a(this, w.g(getResources().getString(2131231603)), getResources().getString(2131231602));
      return;
    case 10: 
      ch.a().a(System.currentTimeMillis(), 220);
      startActivity(new Intent(this, FreezeStatusActivity.class));
      return;
    case -2: 
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 2, 1);
        return;
      }
      startActivity(new Intent(this, UtilsTokenLabActivity.class));
      return;
    }
    if (!do.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    Object localObject = do.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded))
    {
      cw.a().j(0L, this.mHandler);
      return;
    }
    this.mIsItemBusy[paramInt2][paramInt3] = 0;
    dismissDialog();
    startActivity(new Intent(this, RealNameActivity.class));
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void gotologobyprotect()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void init()
  {
    this.mCodeTexts[0] = ((TextView)findViewById(2131559434));
    this.mCodeTexts[1] = ((TextView)findViewById(2131559435));
    this.mCodeTexts[2] = ((TextView)findViewById(2131559436));
    this.mCodeTexts[3] = ((TextView)findViewById(2131559437));
    this.mCodeTexts[4] = ((TextView)findViewById(2131559438));
    this.mCodeTexts[5] = ((TextView)findViewById(2131559439));
    this.mCodeLineView = new a(this);
    ((ImageView)findViewById(2131559442)).setBackgroundDrawable(this.mCodeLineView);
    this.mGuideQQPimSecureTipsView = ((GuideQQPimSecureTipsView)findViewById(2131558612));
    this.mGuideQQPimSecureTipsView.a();
    initLineGridView();
    refreshCodeMaskLayout();
    findViewById(2131559433).setOnClickListener(new abv(this));
    findViewById(2131559432).setOnClickListener(new aby(this));
    displayIconAccordingToFlag();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.token.utils_icon_flag");
    localIntentFilter.addAction("com.tencent.token.token_code_change_30s");
    localIntentFilter.addAction("com.tencent.token.siderbar.statechanged");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, localIntentFilter);
    this.mHandler.postDelayed(new abz(this), 50L);
  }
  
  private void initFace()
  {
    QQUser localQQUser = do.a().e();
    RoundImageView localRoundImageView = (RoundImageView)findViewById(2131559300);
    localRoundImageView.setOnClickListener(this.mQQFaceListener);
    ImageView localImageView1 = (ImageView)findViewById(2131559302);
    ImageView localImageView2 = (ImageView)findViewById(2131559301);
    TextView localTextView = (TextView)findViewById(2131558590);
    localRoundImageView.setVisibility(0);
    localImageView2.setVisibility(0);
    if (localQQUser != null)
    {
      localRoundImageView.setVisibility(0);
      localRoundImageView.setImageDrawable(k.a(localQQUser.b() + "", localQQUser.mUin + ""));
      if (!localQQUser.mIsBinded)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
        localTextView.setVisibility(0);
        return;
      }
      localTextView.setVisibility(8);
      if (localQQUser.mIsZzb)
      {
        localImageView1.setVisibility(0);
        localImageView2.setImageResource(2130838076);
        return;
      }
      localImageView1.setVisibility(8);
      localImageView2.setImageResource(2130837599);
      return;
    }
    localRoundImageView.setImageResource(2130837733);
    localImageView2.setImageResource(2130837599);
    localImageView1.setVisibility(8);
    localTextView.setVisibility(8);
  }
  
  private void initLineGridView()
  {
    Object localObject2 = x.j();
    Object localObject1 = x.k();
    int i;
    if ((localObject2 != null) && (localObject1 != null) && (((JSONArray)localObject2).length() == ((ArrayList)localObject1).size()) && (((ArrayList)localObject1).size() > 0))
    {
      localObject2 = constructToolItem();
      if (localObject2 != null) {
        ((ArrayList)((ArrayList)localObject1).get(0)).add(localObject2);
      }
      localObject2 = constructGalleryToolItem();
      if (localObject2 != null) {
        ((ArrayList)((ArrayList)localObject1).get(0)).add(localObject2);
      }
      this.mSceneIds = new int[((ArrayList)localObject1).size()][];
      localObject2 = (LinearLayout)findViewById(2131559443);
      i = 0;
    }
    while (i < ((ArrayList)localObject1).size())
    {
      this.mSceneIds[i] = new int[((ArrayList)((ArrayList)localObject1).get(i)).size()];
      Object localObject3 = new ArrayList();
      int j = 0;
      while (j < ((ArrayList)((ArrayList)localObject1).get(i)).size())
      {
        localObject4 = (i)((ArrayList)((ArrayList)localObject1).get(i)).get(j);
        this.mSceneIds[i][j] = ((i)localObject4).a;
        int m = getIconIdBySceneId(((i)localObject4).a);
        k = m;
        if (m == -1) {
          if (((i)localObject4).b != null)
          {
            k = m;
            if (((i)localObject4).b.length() > 0) {}
          }
          else
          {
            k = 2130837770;
          }
        }
        ((ArrayList)localObject3).add(new e(new ace(this, ((i)localObject4).a, i, j, ((i)localObject4).d, ((i)localObject4).c), k, ((i)localObject4).c, this.mSceneIds[i][j], ((i)localObject4).b, ((i)localObject4).d));
        if (i == 0) {
          TMSDKContext.SaveStringData(1150108, ((i)localObject4).c);
        }
        j += 1;
      }
      Object localObject4 = new mz(this, (ArrayList)localObject3);
      this.mProtectLineGridItemDatas.add(localObject3);
      this.mProtectLineGridAdapter.add(localObject4);
      Object localObject5 = LayoutInflater.from(RqdApplication.l()).inflate(2130968797, null);
      ((TextView)((View)localObject5).findViewById(2131559378)).setText(this.mTitles[i]);
      LineGridView localLineGridView = (LineGridView)((View)localObject5).findViewById(2131559379);
      localLineGridView.setAdapter((ListAdapter)localObject4);
      ((LinearLayout)localObject2).addView((View)localObject5);
      float f = getResources().getDimension(2131296425);
      localObject4 = (ViewGroup.MarginLayoutParams)localLineGridView.getLayoutParams();
      int k = ((ArrayList)localObject3).size() / 3;
      j = k;
      if (((ArrayList)localObject3).size() % 3 != 0) {
        j = k + 1;
      }
      ((ViewGroup.MarginLayoutParams)localObject4).height = ((int)(j * f));
      i += 1;
      continue;
      localObject1 = (LinearLayout)findViewById(2131559443);
      i = 0;
      while (i < this.ICONS_2D.length)
      {
        localObject2 = new ArrayList();
        j = 0;
        while (j < this.ICONS_2D[i].length)
        {
          h.a("item i=" + i + ",j=" + j);
          ((ArrayList)localObject2).add(new e(new ace(this, this.SCENEIDS_2D[i][j], i, j, null, getResources().getString(this.TEXTS_2D[i][j])), this.ICONS_2D[i][j], getResources().getString(this.TEXTS_2D[i][j]), this.SCENEIDS_2D[i][j], null, null));
          j += 1;
        }
        localObject3 = new mz(this, (ArrayList)localObject2);
        this.mProtectLineGridItemDatas.add(localObject2);
        this.mProtectLineGridAdapter.add(localObject3);
        localObject4 = LayoutInflater.from(RqdApplication.l()).inflate(2130968797, null);
        ((TextView)((View)localObject4).findViewById(2131559378)).setText(this.mTitles[i]);
        localObject5 = (LineGridView)((View)localObject4).findViewById(2131559379);
        ((LineGridView)localObject5).setAdapter((ListAdapter)localObject3);
        ((LinearLayout)localObject1).addView((View)localObject4);
        f = getResources().getDimension(2131296425);
        localObject3 = (ViewGroup.MarginLayoutParams)((LineGridView)localObject5).getLayoutParams();
        k = ((ArrayList)localObject2).size() / 3;
        j = k;
        if (((ArrayList)localObject2).size() % 3 != 0) {
          j = k + 1;
        }
        ((ViewGroup.MarginLayoutParams)localObject3).height = ((int)(j * f));
        i += 1;
      }
    }
  }
  
  private void judgeNextStep()
  {
    com.tencent.token.core.protocolcenter.c.a = 1;
  }
  
  private void jumpToGallery()
  {
    TMSDKContext.saveActionData(170014);
    startActivity(new Intent(this, GalleryActivity.class));
  }
  
  private void jumpToQQpim()
  {
    TMSDKContext.saveActionData(170008);
    startActivity(new Intent(this, QQPimActivity.class));
  }
  
  private void onClickMenu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ch.a().a(System.currentTimeMillis(), 39);
      if ((do.a().e() != null) && (do.a().f() == 0L))
      {
        showUserDialog(2131230843, getString(2131231617), 2131231658, 2131230886, new acc(this), null);
        return;
      }
      queryDualMsg();
      return;
    }
    w.b(this, getString(2131231287));
  }
  
  private void queryDualMsg()
  {
    if (this.mQueryingDualMsg) {
      return;
    }
    this.mQueryingDualMsg = true;
    this.mGetDualMsgTask = new abp(this);
    this.mGetDualMsgTask.c(new String[] { "" });
    showProDialog(this, 2131230843, new abq(this));
  }
  
  private void refreshCodeMaskLayout()
  {
    View localView = findViewById(2131559440);
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (!localQQUser.mIsBinded))
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(4);
  }
  
  private void setNewFlag(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt1)
    {
    default: 
      localObject1 = localObject2;
    case -2: 
    case -1: 
    case 0: 
      if ((localObject1 != null) && (((NewConfigureCacheItem)localObject1).mClickVersion < ((NewConfigureCacheItem)localObject1).mClientVersion)) {
        ((e)((ArrayList)this.mProtectLineGridItemDatas.get(paramInt2)).get(paramInt3)).a(true);
      }
      break;
    }
    for (;;)
    {
      ((mz)this.mProtectLineGridAdapter.get(paramInt2)).notifyDataSetChanged();
      return;
      localObject1 = this.mCache.a("login_protect");
      break;
      localObject1 = this.mCache.a("account_prot");
      break;
      localObject1 = this.mCache.a("mail_protect");
      break;
      localObject1 = this.mCache.a("qb_prot");
      break;
      localObject1 = this.mCache.a("account_lock");
      break;
      localObject1 = this.mCache.a("game_lock");
      break;
      localObject1 = this.mCache.a("real_name");
      break;
      localObject1 = this.mCache.a("modify_pwd");
      break;
      localObject1 = this.mCache.a("recover_friends");
      break;
      localObject1 = this.mCache.a("account_freeze");
      break;
      localObject1 = this.mCache.a("qqpim_protect");
      break;
      ((e)((ArrayList)this.mProtectLineGridItemDatas.get(paramInt2)).get(paramInt3)).a(false);
    }
  }
  
  private void updateTokenCode()
  {
    cx localcx = cx.c();
    localcx.m();
    int i = 0;
    while (i < 6)
    {
      this.mCodeTexts[i].setText("" + localcx.l()[i]);
      i += 1;
    }
    long l = localcx.r();
    this.mHandler.sendEmptyMessageDelayed(-100, l);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((c.f()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if ((this.mTitleMenu != null) && (this.mTitleMenu.getVisibility() == 0))
      {
        this.mTitleMenu.b();
        return true;
      }
      exitToken();
      return true;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130968813);
    init();
    TMSDKContext.saveActionData(1150067);
    TMSDKContext.saveActionData(170007);
    TMSDKContext.saveActionData(170013);
    tryShowGuideTipsAsync();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mCache.c();
    this.mHandler.removeMessages(-100);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mReceiver);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mHandler.removeMessages(-100);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mGuideQQPimSecureTipsView != null) {
      this.mGuideQQPimSecureTipsView.a();
    }
    if ((!RqdApplication.b) && (this.needgotologobyprotect))
    {
      gotologobyprotect();
      this.needgotologobyprotect = false;
      return;
    }
    refreshCodeMaskLayout();
    updateTokenCode();
    initFace();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStop()
  {
    super.onStop();
  }
  
  void tryShowGuideTipsAsync()
  {
    new Thread(new aca(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsActivity
 * JD-Core Version:    0.7.0.1
 */