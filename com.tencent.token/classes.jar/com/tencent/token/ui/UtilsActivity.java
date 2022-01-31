package com.tencent.token.ui;

import android.content.BroadcastReceiver;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.p;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class UtilsActivity
  extends BaseActivity
{
  public static final String ACTION_GET_UTILS_ICON_FLAG = "com.tencent.token.utils_icon_flag";
  public static final String ACTION_SIDEBAR_STATE_CHANGED = "com.tencent.token.siderbar.statechanged";
  public static final int SECENE_ACCOUNT_LOCK = 4;
  public static final int SECENE_GAME_LOCK = 5;
  public static final int SECENE_GAME_PROTECT = 1;
  public static final int SECENE_LOGIN_PROTECT = 0;
  public static final int SECENE_MAIL_PROTECT = 2;
  public static final int SECENE_MB_INFO = -1;
  public static final int SECENE_MODIFY_PWD = 6;
  public static final int SECENE_QBQD_PROTECT = 3;
  public static final int SECENE_QQ_PROTECT = -3;
  public static final int SECENE_REAL_NAME = 8;
  public static final int SECENE_RECOVER_FRIENDS = 7;
  public static final int SECENE_TOKEN_LAB = -2;
  private static final String TOKEN_CODE_CHANGE_30S = "com.tencent.token.token_code_change_30s";
  public static int[] mIcons = { 2130837689, 2130837675, 2130837679, 2130837687, 2130837670, 2130837674, 2130837681, 2130837691 };
  public static int[] mNoAccountScenes = { 12, 14, 8, 9, 11, 15, 10, 17, 3 };
  public static int[] mTexts = { 2131362261, 2131362177, 2131362262, 2131362178, 2131361957, 2131361958, 2131361901, 2131362183 };
  private final int UPDATETOKEN = -100;
  fp mCache = ba.a().h;
  private com.tencent.token.ui.base.e mCodeLineView;
  private TextView[] mCodeTexts = new TextView[6];
  private UserTask mGetDualMsgTask;
  public Handler mHandler = new adi(this);
  private boolean[] mIsBusy = new boolean[9];
  private View.OnClickListener[] mListener = new View.OnClickListener[mIcons.length];
  private View.OnClickListener mQQFaceListener = new adc(this);
  private boolean mQueryingDualMsg = false;
  private RelativeLayout mRealNameLayout;
  private ImageView mRealNameNewIcon;
  private BroadcastReceiver mReceiver = new adh(this);
  private View.OnClickListener mRightTitleButtonClickListener = new adf(this);
  private int mSecene = 0;
  private View mTipVerifyView;
  private int[] mTips = { 2131362181, 2131362185, 2131362186, 2131362187 };
  private TitleOptionMenu mTitleMenu;
  private View[] mViews = new View[mIcons.length];
  private boolean needgotologobyprotect;
  
  private void checkBindQQ(int paramInt)
  {
    ba.a().h.a(fp.a[paramInt]).a();
    setNewFlag(paramInt);
    if (this.mIsBusy[paramInt] != 0) {
      return;
    }
    this.mIsBusy[paramInt] = true;
    this.mSecene = paramInt;
    ax localax = ax.a();
    if (localax.e() == null)
    {
      showNoAccountTipDialog(this, mNoAccountScenes[paramInt], 0);
      this.mIsBusy[paramInt] = false;
      return;
    }
    if (localax.o())
    {
      com.tencent.token.global.e.c("UtilsActivity--agent.isPrepare validate");
      if (localax.e() == null)
      {
        this.mIsBusy[paramInt] = false;
        showUserDialog(9);
        return;
      }
      if (paramInt == 8) {
        showProDialog(this, 2131361808, 2131362203, null);
      }
      gotoActivity(this.mSecene);
      return;
    }
    af.a().b(this.mHandler);
    com.tencent.token.global.e.c("UtilsActivity--agent.isPrepare invalidate");
    showProDialog(this, 2131361808, 2131362203, null);
  }
  
  private void displayIconAccordingToFlag()
  {
    int i = 0;
    while (i < mIcons.length)
    {
      this.mViews[i].setVisibility(0);
      ImageView localImageView = (ImageView)this.mViews[i].findViewById(2131297218);
      TextView localTextView = (TextView)this.mViews[i].findViewById(2131297220);
      localImageView.setImageResource(mIcons[i]);
      localTextView.setText(mTexts[i]);
      this.mViews[i].setOnClickListener(this.mListener[i]);
      setNewFlag(i);
      i += 1;
    }
    setNewFlag(8);
  }
  
  private void goToWtLoginAccountInput()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 7);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void gotoActivity(int paramInt)
  {
    this.mIsBusy[paramInt] = false;
    switch (paramInt)
    {
    case -1: 
    default: 
      return;
    case 2: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 8, 1);
        return;
      }
      startActivity(new Intent(this, UtilsMailProtectActivity.class));
      return;
    case 4: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 11, 1);
        return;
      }
      startActivity(new Intent(this, UtilsAccountLockActivity.class));
      return;
    case 0: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 12, 1);
        return;
      }
      startActivity(new Intent(this, UtilsLoginProtectActivity.class));
      return;
    case 6: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 10, 1);
        return;
      }
      localObject = new Intent(this, ModifyQQPwdActivity.class);
      pv.a().a(this, (Intent)localObject, pv.b);
      return;
    case 5: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 15, 1);
        return;
      }
      startActivity(new Intent(this, UtilsGameLockActivity.class));
      return;
    case 1: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 15, 1);
        return;
      }
      p.a().a(System.currentTimeMillis(), 75);
      startActivity(new Intent(this, UtilsGameProtectActivity.class));
      return;
    case 3: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 9, 1);
        return;
      }
      startActivity(new Intent(this, UtilsQbQdProtectActivity.class));
      return;
    case 7: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 17, 1);
        return;
      }
      s.a(this, getResources().getString(2131362184), getResources().getString(2131362183));
      return;
    case -2: 
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 2, 1);
        return;
      }
      startActivity(new Intent(this, UtilsTokenLabActivity.class));
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 3, 1);
      return;
    }
    Object localObject = ax.a().e();
    if ((localObject != null) && (((QQUser)localObject).mIsBinded))
    {
      af.a().l(0L, this.mHandler);
      return;
    }
    this.mIsBusy[paramInt] = false;
    dismissDialog();
    startActivity(new Intent(this, RealNameActivity.class));
  }
  
  private void gotologobyprotect()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 9);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void init()
  {
    int i = 0;
    this.mCodeTexts[0] = ((TextView)findViewById(2131297275));
    this.mCodeTexts[1] = ((TextView)findViewById(2131297276));
    this.mCodeTexts[2] = ((TextView)findViewById(2131297277));
    this.mCodeTexts[3] = ((TextView)findViewById(2131297278));
    this.mCodeTexts[4] = ((TextView)findViewById(2131297279));
    this.mCodeTexts[5] = ((TextView)findViewById(2131297280));
    this.mRealNameNewIcon = ((ImageView)findViewById(2131297289));
    this.mRealNameLayout = ((RelativeLayout)findViewById(2131296839));
    this.mRealNameLayout.setOnClickListener(new adq(this, 8));
    this.mCodeLineView = new com.tencent.token.ui.base.e();
    ((ImageView)findViewById(2131297281)).setBackgroundDrawable(this.mCodeLineView);
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131296702);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131296703);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131296706);
    int j = (int)((IndexActivity.S_RES_WIDTH - 40.0F * IndexActivity.S_DENSITY) / 4.0F);
    if (i < mIcons.length)
    {
      if (i < 4)
      {
        localObject = getLayoutInflater().inflate(2130903234, null);
        ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, -2));
        localLinearLayout1.addView((View)localObject);
      }
      for (;;)
      {
        this.mViews[i] = localObject;
        ((View)localObject).setVisibility(4);
        this.mListener[i] = new adq(this, i);
        i += 1;
        break;
        if (i < 6)
        {
          localObject = getLayoutInflater().inflate(2130903235, null);
          ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j * 2, -2));
          localLinearLayout2.addView((View)localObject);
        }
        else
        {
          localObject = getLayoutInflater().inflate(2130903235, null);
          ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j * 2, -2));
          localLinearLayout3.addView((View)localObject);
        }
      }
    }
    findViewById(2131297274).setOnClickListener(new adj(this));
    findViewById(2131297273).setOnClickListener(new adl(this));
    this.mTipVerifyView = findViewById(2131297329);
    this.mTipVerifyView.setOnClickListener(new adm(this));
    displayIconAccordingToFlag();
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.utils_icon_flag");
    ((IntentFilter)localObject).addAction("com.tencent.token.token_code_change_30s");
    ((IntentFilter)localObject).addAction("com.tencent.token.siderbar.statechanged");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, (IntentFilter)localObject);
    this.mHandler.postDelayed(new adn(this), 50L);
  }
  
  private void initFace()
  {
    QQUser localQQUser = ax.a().e();
    RoundImageView localRoundImageView = (RoundImageView)findViewById(2131297141);
    localRoundImageView.setOnClickListener(this.mQQFaceListener);
    ImageView localImageView1 = (ImageView)findViewById(2131297143);
    ImageView localImageView2 = (ImageView)findViewById(2131297142);
    TextView localTextView = (TextView)findViewById(2131296349);
    localRoundImageView.setVisibility(0);
    localImageView2.setVisibility(0);
    if (localQQUser != null)
    {
      localRoundImageView.setVisibility(0);
      localRoundImageView.setImageDrawable(k.a(localQQUser.mRealUin + "", localQQUser.mUin + ""));
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
        localImageView2.setImageResource(2130838024);
        return;
      }
      localImageView1.setVisibility(8);
      localImageView2.setImageResource(2130837522);
      return;
    }
    localRoundImageView.setImageResource(2130837654);
    localImageView2.setImageResource(2130837522);
    localImageView1.setVisibility(8);
    localTextView.setVisibility(8);
  }
  
  private void onClickMenu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      p.a().a(System.currentTimeMillis(), 39);
      if ((ax.a().e() != null) && (ax.a().f() == 0L))
      {
        showUserDialog(2131361808, getString(2131362304), 2131362362, 2131361804, new ado(this), null);
        return;
      }
      queryDualMsg();
      return;
    }
    s.b(this, getString(2131361988));
  }
  
  private void queryDualMsg()
  {
    if (this.mQueryingDualMsg) {
      return;
    }
    this.mQueryingDualMsg = true;
    this.mGetDualMsgTask = new add(this);
    this.mGetDualMsgTask.a(new String[] { "" });
    showProDialog(this, 2131361808, new ade(this));
  }
  
  private void setNewFlag(int paramInt)
  {
    if (paramInt < mIcons.length)
    {
      localObject = (ImageView)this.mViews[paramInt].findViewById(2131297219);
      localNewConfigureCacheItem = this.mCache.a(fp.a[paramInt]);
      if (localNewConfigureCacheItem.mClickVersion < localNewConfigureCacheItem.mClientVersion) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
    while (paramInt != 8)
    {
      NewConfigureCacheItem localNewConfigureCacheItem;
      return;
      ((ImageView)localObject).setVisibility(4);
      return;
    }
    Object localObject = this.mCache.a("real_name");
    if (((NewConfigureCacheItem)localObject).mClickVersion < ((NewConfigureCacheItem)localObject).mClientVersion)
    {
      this.mRealNameNewIcon.setVisibility(0);
      return;
    }
    this.mRealNameNewIcon.setVisibility(4);
  }
  
  private void updateTokenCode()
  {
    ag localag = ag.c();
    localag.m();
    int i = 0;
    while (i < 6)
    {
      this.mCodeTexts[i].setText("" + localag.l()[i]);
      i += 1;
    }
    long l = localag.q();
    this.mHandler.sendEmptyMessageDelayed(-100, l);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        com.tencent.token.global.e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if ((this.mTitleMenu != null) && (this.mTitleMenu.getVisibility() == 0))
      {
        this.mTitleMenu.a();
        return true;
      }
      exitToken();
      return true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    setContentView(2130903250);
    init();
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
    if ((!RqdApplication.b) && (this.needgotologobyprotect))
    {
      gotologobyprotect();
      this.needgotologobyprotect = false;
      return;
    }
    QQUser localQQUser = ax.a().e();
    if ((localQQUser != null) && (!localQQUser.mIsBinded)) {
      this.mTipVerifyView.setVisibility(0);
    }
    for (;;)
    {
      updateTokenCode();
      initFace();
      return;
      this.mTipVerifyView.setVisibility(4);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsActivity
 * JD-Core Version:    0.7.0.1
 */