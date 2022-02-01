package com.tencent.biz.qqstory.storyHome;

import acfp;
import akll;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import aqiw;
import arkn;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.c;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.biz.qqstory.view.widget.StorySimpleLoadView;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Map;
import mqq.os.MqqHandler;
import plr;
import pmb;
import pnm;
import pnx;
import ppf;
import psu;
import psx;
import ptf;
import qqr;
import qqr.a;
import qqu;
import qqv;
import qqw;
import qqx;
import qre;
import qrj;
import qvf;
import qxq;
import qye;
import qyk;
import ram;
import rew;
import rnq;
import rom;
import rsd;

public class QQStoryMainController
  implements MystoryListView.c, qqr.a, qye
{
  public static final int[] dP;
  public static final int[] dQ;
  private boolean Wl;
  private boolean Yp;
  private akll jdField_a_of_type_Akll = new qqw(this);
  public arkn a;
  public StoryInputBarView a;
  public ScreenActionBroadcastReceiver a;
  public b a;
  public MystoryListView a;
  public NewMessageYellowBar a;
  public StorySimpleLoadView a;
  private qqr jdField_a_of_type_Qqr;
  public qre a;
  public qvf a;
  public qxq a;
  public rew a;
  public boolean aEO;
  public boolean aEP;
  private boolean aEQ;
  private final int bnH = 1;
  public int[] dO;
  private Handler handler;
  private long ie;
  public QQAppInterface mApp;
  public Activity mContext;
  private boolean mIsResume;
  public View mRoot;
  private ImageView mX;
  public View os;
  private TextView xN;
  
  static
  {
    if (!QQStoryMainController.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      dP = new int[] { 2131382248, 2131382247, 2131375192, 2131375216 };
      dQ = new int[] { 2131382248, 2131382247, 2131375192, 2131375191 };
      return;
    }
  }
  
  public QQStoryMainController(b paramb, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Qre = new qre();
    this.jdField_a_of_type_Arkn = new qqx(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b = paramb;
    this.dO = paramArrayOfInt;
    this.handler = new a(null);
  }
  
  private void bpK()
  {
    ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.2(this), 500L);
  }
  
  private void initData()
  {
    this.mApp = QQStoryContext.a();
    Object localObject = (pmb)this.mApp.getManager(181);
    assert (localObject != null);
    bpM();
    localObject = this.mContext.getIntent().getStringExtra("lebaVersion");
    String str = this.mContext.getIntent().getStringExtra("redid");
    ram.d("Q.qqstory.home.position", "story main from lebaVersion " + (String)localObject + str);
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
    qvf localqvf = this.jdField_a_of_type_Qvf;
    boolean bool2 = "old".equals(localObject);
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aEO = localqvf.g(bool2, bool1);
      Bosses.get().postJob(new qqu(this, "QQStoryMainController"));
      this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
      this.jdField_a_of_type_Qvf.gb.clear();
      return;
    }
  }
  
  public boolean Kh()
  {
    return this.mIsResume;
  }
  
  public boolean Ki()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = a();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      this.os.setVisibility(0);
      return true;
    }
    return false;
  }
  
  public boolean Kj()
  {
    return this.Wl;
  }
  
  public StoryInputBarView a()
  {
    boolean bool;
    ViewStub localViewStub;
    if (this.dO != null)
    {
      bool = true;
      rom.assertTrue(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView == null)
      {
        localViewStub = (ViewStub)this.mRoot.findViewById(this.dO[2]);
        if (localViewStub == null) {
          break label62;
        }
      }
    }
    label62:
    for (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)localViewStub.inflate());; this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.mRoot.findViewById(this.dO[3])))
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
      bool = false;
      break;
    }
  }
  
  public NewMessageYellowBar a()
  {
    boolean bool;
    ViewStub localViewStub;
    if (this.dO != null)
    {
      bool = true;
      rom.assertTrue(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar == null)
      {
        localViewStub = (ViewStub)this.mRoot.findViewById(this.dO[0]);
        if (localViewStub == null) {
          break label62;
        }
      }
    }
    label62:
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)localViewStub.inflate());; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)this.mRoot.findViewById(this.dO[1])))
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar;
      bool = false;
      break;
    }
  }
  
  public rsd a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramString);
  }
  
  public void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Qxq != null)) {
      this.jdField_a_of_type_Qxq.fo(NetConnInfoCenter.getServerTimeMillis());
    }
    this.jdField_a_of_type_Qre.bpS();
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    SystemClock.uptimeMillis();
    paramString = rnq.a();
    Object localObject = this.mContext.getIntent().getStringExtra("from_type");
    int i = this.mContext.getIntent().getIntExtra("capture_intent_mode", -1);
    int j = this.mContext.getIntent().getIntExtra("firsttab", -1);
    int k = this.mContext.getIntent().getIntExtra("secondtab", -1);
    String str1 = this.mContext.getIntent().getStringExtra("itemid");
    String str2 = this.mContext.getIntent().getStringExtra("story_game_id");
    String str3 = this.mContext.getIntent().getStringExtra("story_capture_album_id");
    Bundle localBundle = new Bundle();
    if (TextUtils.equals((CharSequence)localObject, "msgTab"))
    {
      localBundle.putInt("entrance_type", 103);
      localBundle.putString("story_default_label", this.mContext.getIntent().getStringExtra("story_default_label"));
      localObject = this.mContext.getIntent();
      if (((Intent)localObject).hasExtra("story_game_capture_type")) {
        localBundle.putInt("story_game_capture_type", ((Intent)localObject).getIntExtra("story_game_capture_type", 1));
      }
      if (((Intent)localObject).hasExtra("story_game_id")) {
        localBundle.putString("story_game_id", ((Intent)localObject).getStringExtra("story_game_id"));
      }
      if (((Intent)localObject).hasExtra("story_game_pk_vid")) {
        localBundle.putString("story_game_pk_vid", ((Intent)localObject).getStringExtra("story_game_pk_vid"));
      }
      if (((Intent)localObject).hasExtra("story_game_pk_feed_id")) {
        localBundle.putString("story_game_pk_feed_id", ((Intent)localObject).getStringExtra("story_game_pk_feed_id"));
      }
      localBundle.putInt("key_finish_jump_to_page", this.mContext.getIntent().getIntExtra("key_finish_jump_to_page", 1));
      if (i == -1) {
        break label376;
      }
      paramString.a(this.mContext, localBundle, 2, i, j, k, str1, str2, str3, true, 20000);
    }
    for (;;)
    {
      ram.i("QQStoryMainController", "launchNewVideoTakeActivity by StoryPublishLauncher");
      this.mContext.overridePendingTransition(2130772306, 2130772079);
      return;
      localBundle.putInt("entrance_type", paramInt);
      break;
      label376:
      paramString.a(this.mContext, localBundle, 20000);
    }
  }
  
  public void be(Activity paramActivity) {}
  
  public void bpI()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.bpI();
  }
  
  public void bpJ()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.bpJ();
  }
  
  public void bpL()
  {
    ram.d("QQStoryMainController", "reInitData");
    if (this.jdField_a_of_type_Qxq != null)
    {
      this.jdField_a_of_type_Qxq.onDestory();
      this.jdField_a_of_type_Qxq = null;
    }
    this.jdField_a_of_type_Qxq = ((qxq)ppf.a(qxq.class, new Object[] { this.mContext }));
    this.jdField_a_of_type_Qxq.a(this);
    this.jdField_a_of_type_Qxq.onCreate();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.brD();
    initData();
  }
  
  protected void bpM()
  {
    if (this.mApp != null) {
      this.mApp.addObserver(this.jdField_a_of_type_Akll);
    }
  }
  
  protected void bpN()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Akll);
    }
  }
  
  public void bpO()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.brD();
    this.jdField_a_of_type_Qre.bpS();
  }
  
  public boolean fn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((qyk)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("FeedSegment")).sm(paramString);
    return true;
  }
  
  public void initView()
  {
    this.mRoot = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.y();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.rS(plr.asY);
    this.os = this.mRoot.findViewById(2131375211);
    this.jdField_a_of_type_Rew = new rew(new qqv(this), this.os);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)this.mRoot.findViewById(2131375248));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDisableAutoRefresh(this.aEO);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(this.mContext, this, this.os);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setPullRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(false);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(this.mContext.getResources().getColor(2131167363));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView = new StorySimpleLoadView(this.mContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.onCreate();
    this.jdField_a_of_type_Qxq = ((qxq)ppf.a(qxq.class, new Object[] { this.mContext }));
    this.jdField_a_of_type_Qxq.a(this);
    this.jdField_a_of_type_Qxq.onCreate();
    fn(this.mContext.getIntent().getStringExtra("new_video_extra_info"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver = new ScreenActionBroadcastReceiver();
    this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver, localIntentFilter);
  }
  
  public void onAccountChanged()
  {
    bpN();
    this.mApp = QQStoryContext.a();
    bpM();
    if (this.jdField_a_of_type_Qre != null) {
      this.jdField_a_of_type_Qre.onAccountChanged();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ram.d("QQStoryMainController", "onActivityResult %d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Qxq != null) {
      this.jdField_a_of_type_Qxq.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt1 != 20000) || (paramIntent == null) || (!paramIntent.getBooleanExtra("back_when_cancel_from_shot", false)))
    {
      return;
      if (paramIntent != null) {
        fn(paramIntent.getStringExtra("new_video_extra_info"));
      }
      pnx.qU("QQStoryMainController onActivityResult");
      return;
      b(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
      return;
      qrj.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.b, paramIntent);
      ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.6(this), 100L);
      return;
    }
    this.mContext.finish();
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mContext = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.mContext == null) {
      throw new IllegalStateException("mContext should not be null! should call onAttach() pass the activity");
    }
    r(paramBundle);
    initData();
    initView();
    bpK();
    this.ie = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy(Activity paramActivity)
  {
    this.Yp = true;
    ThreadManager.post(new QQStoryMainController.1(this), 5, null, false);
    if (this.ie > 0L)
    {
      int i = this.mContext.getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.ie;
      this.ie = -1L;
      Now.fh((int)(l1 - l2), i);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.destroy();
    }
    this.jdField_a_of_type_Qre.onDestroy();
    this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver);
    bpN();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.onDestroy();
    if (this.jdField_a_of_type_Qxq != null) {
      this.jdField_a_of_type_Qxq.onDestory();
    }
    paramActivity = (psu)psx.a(5);
    qvf localqvf = (qvf)psx.a(11);
    ptf localptf = (ptf)psx.a(2);
    localqvf.bre();
    localptf.bmH();
    paramActivity.bmH();
    ((pnm)psx.a(6)).ff(10000L);
    localqvf.gb.clear();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    r(null);
    fn(paramIntent.getStringExtra("new_video_extra_info"));
  }
  
  public void onPause()
  {
    this.mIsResume = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.onPause();
    qvf localqvf = (qvf)psx.a(11);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0) != null) {
      localqvf.bon = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0).getTop();
    }
    localqvf.mFirstPosition = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition();
    ram.b("Q.qqstory.home.position", "save position:%d, offset:%d", Integer.valueOf(localqvf.mFirstPosition), Integer.valueOf(localqvf.bon));
    if (this.jdField_a_of_type_Qxq != null) {
      this.jdField_a_of_type_Qxq.onPause();
    }
  }
  
  public void onPullRefresh()
  {
    this.jdField_a_of_type_Qxq.KM();
  }
  
  public void onResume(Activity paramActivity)
  {
    this.mIsResume = true;
    if (this.jdField_a_of_type_Qxq != null) {
      this.jdField_a_of_type_Qxq.onResume();
    }
    if (this.os != null) {
      this.os.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.azy();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.onResume();
    if (this.Wl)
    {
      this.Wl = false;
      tg(true);
      ram.i("QQStoryMainController", "force request net");
    }
    pnx.qU("QQStoryMainController onResume");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("bundle_has_jump", this.aEQ);
  }
  
  public boolean r(Bundle paramBundle)
  {
    int i = this.mContext.getIntent().getIntExtra("action", 0);
    this.mContext.getIntent().putExtra("action", 0);
    if ((paramBundle != null) && (paramBundle.getBoolean("bundle_has_jump"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aEQ = bool;
      this.jdField_a_of_type_Qqr = new qqr(this.mContext, this);
      if ((i == 0) || (this.aEQ)) {
        break;
      }
      bool = this.jdField_a_of_type_Qqr.b(i, this.mContext.getIntent());
      ram.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b, result=%b", Integer.valueOf(i), Boolean.valueOf(this.aEQ), Boolean.valueOf(bool));
      if (bool)
      {
        this.aEQ = true;
        this.Wl = true;
      }
      return bool;
    }
    ram.b("QQStoryMainController", "handleAction pass action=%d, hasJump=%b", Integer.valueOf(i), Boolean.valueOf(this.aEQ));
    return false;
  }
  
  public void te(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.te(paramBoolean);
  }
  
  public void tf(boolean paramBoolean)
  {
    this.handler.removeMessages(1);
    if (paramBoolean) {
      this.handler.sendEmptyMessageDelayed(1, 30000L);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.td(paramBoolean);
  }
  
  public void tg(boolean paramBoolean)
  {
    if (!aqiw.isNetworkAvailable(this.mContext)) {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131712320), 0).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Qxq == null)
      {
        ram.w("QQStoryMainController", "refreshIfNecessary, myStoryListPresenter = null!");
        return;
      }
    } while ((!(this.jdField_a_of_type_Qxq.KK() | paramBoolean | this.jdField_a_of_type_Qxq.KL())) || (!this.jdField_a_of_type_Qxq.KM()));
    ram.a("QQStoryMainController", "refreshIfNecessary, forceUpdate: %b, redPoint: %b, overTime: %b", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Qxq.KK()), Boolean.valueOf(this.jdField_a_of_type_Qxq.KL()));
    bpO();
  }
  
  public static class ScreenActionBroadcastReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        ((pnm)psx.a(6)).ff(120000L);
        ram.w("Q.qqstory.home.QQStoryMainActivity", "screen off , preloader stop");
      }
      while (!paramContext.equals("android.intent.action.SCREEN_ON")) {
        return;
      }
      ((pnm)psx.a(6)).blW();
      ram.w("Q.qqstory.home.QQStoryMainActivity", "screen on , preloader start");
    }
  }
  
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      QQStoryMainController.this.a.td(false);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bpH();
    
    public abstract void bpI();
    
    public abstract void bpJ();
    
    public abstract ImageView l();
    
    public abstract void rS(String paramString);
    
    public abstract void td(boolean paramBoolean);
    
    public abstract void te(boolean paramBoolean);
    
    public abstract View y();
    
    public abstract TextView y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController
 * JD-Core Version:    0.7.0.1
 */