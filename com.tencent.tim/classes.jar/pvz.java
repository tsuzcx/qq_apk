import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.1;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.11;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.16;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.a;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.b;
import com.tencent.widget.ListView;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class pvz
  implements ausj.a, DrawerFrame.c, ARMapHongBaoListView.b, pro.a, pro.b
{
  private static String TAG;
  public static boolean aCs;
  public static String avB = acfp.m(2131708537);
  public static String avC = acfp.m(2131708541);
  public static String avD = acfp.m(2131708539);
  public static String avE = acfp.m(2131708546);
  public static String avF = acfp.m(2131708538);
  public static String avG = acfp.m(2131708542);
  public static String avH = acfp.m(2131708543);
  public static String avI = acfp.m(2131708545);
  private static HashMap<Integer, String[]> fk;
  public static long sScrollTimestamp;
  long Ay;
  ausj K;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  private int STORY_TRANSLATE;
  private acbo jdField_a_of_type_Acbo = new pwd(this);
  protected akll a;
  auvw jdField_a_of_type_Auvw;
  public MsgNodeShotView a;
  public MsgTabStoryNodeView a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  pvu jdField_a_of_type_Pvu;
  pvv jdField_a_of_type_Pvv;
  public pvz.a a;
  boolean aCm = false;
  boolean aCn = false;
  boolean aCo = false;
  boolean aCp = false;
  public boolean aCq;
  public boolean aCr;
  private DotAnimationView b;
  private final int bkW = 70;
  private int bkX;
  private final pmd c = new pwe(this);
  private Runnable jdField_do = new MsgTabStoryNodeListManager.1(this);
  public Runnable dp = new MsgTabStoryNodeListManager.11(this);
  boolean flag = false;
  private long iu;
  public QQAppInterface mApp;
  private PullRefreshHeader mChatTopRefresh;
  Context mContext;
  DataSetObserver mDataSetObserver;
  private DrawerFrame mDrawer;
  public int mLastScrollState;
  public ARMapHongBaoListView mListView;
  boolean mRunning = false;
  View mShotView;
  private Vibrator mVibrator;
  private float ma;
  private float mb;
  private float mc;
  private float md;
  float me;
  private int mode = 1;
  private View od;
  private int preMode = 1;
  
  static
  {
    TAG = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    fk = new HashMap();
    fk.put(Integer.valueOf(5), new String[] { avB, avC });
    fk.put(Integer.valueOf(6), new String[] { avB, avD });
    fk.put(Integer.valueOf(7), new String[] { avB, avF });
    fk.put(Integer.valueOf(9), new String[] { avB, avE, avH });
    fk.put(Integer.valueOf(11), new String[] { avH });
    fk.put(Integer.valueOf(10), new String[] { avH });
    fk.put(Integer.valueOf(12), new String[] { avB, avH });
  }
  
  public pvz(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    this.jdField_a_of_type_Akll = new pwc(this);
    rom.ap(paramPullRefreshHeader);
    this.mApp = paramConversation.app;
    this.Ay = System.currentTimeMillis();
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.mDrawer = paramDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = paramBreathEffectView;
    this.od = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131378794);
    this.b = ((DotAnimationView)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131366044));
    this.mVibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
    this.jdField_a_of_type_Pvu = new pvu(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView = new MsgNodeShotView(paramContext);
    this.mShotView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView;
    bnr();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.setLayoutParams(new RecyclerView.LayoutParams(wja.dp2px(67.0F, this.od.getResources()), wja.dp2px(102.0F, this.od.getResources())));
    this.jdField_a_of_type_Pvu.addHeaderView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView);
    this.jdField_a_of_type_Pvu.a(this);
    this.jdField_a_of_type_Pvu.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView.setAdapter(this.jdField_a_of_type_Pvu);
    this.jdField_a_of_type_Pvv = new pvv(this, this.jdField_a_of_type_Pvu, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView.setOnScrollListener(new pwf(this));
    this.mDataSetObserver = new pwg(this);
    this.ma = rpq.dip2px(this.mContext, -50.0F);
    this.mb = rpq.dip2px(this.mContext, -50.0F);
    this.mc = rpq.dip2px(this.mContext, -120.0F);
    this.STORY_TRANSLATE = rpq.dip2px(this.mContext, -80.0F);
    this.bkX = rpq.dip2px(this.mContext, 12.0F);
    AbstractGifImage.resumeAll();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "on create");
    }
  }
  
  private boolean Jj()
  {
    if (!Jk())
    {
      ram.d(TAG, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!Jl())
    {
      ram.d(TAG, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_Auvw == null)
    {
      ram.d(TAG, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = auvw.a(this.mContext).a(true).a(acfp.m(2131708544)).a(16.0F).b(5).a(-1);
      ((auvw.a)localObject).c(50);
      this.jdField_a_of_type_Auvw = new auvw.b((auvw.a)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.jdField_a_of_type_Auvw.setAlignMode(82);
      this.jdField_a_of_type_Auvw.setOnClickListener(new pwb(this));
    }
    if (!this.jdField_a_of_type_Auvw.isShowing())
    {
      this.jdField_a_of_type_Auvw.M(this.mShotView, wja.dp2px(7.0F, this.od.getResources()), wja.dp2px(-5.0F, this.od.getResources()));
      localObject = new Rect();
      this.mShotView.getGlobalVisibleRect((Rect)localObject);
      ram.b(TAG, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.jdField_a_of_type_Pvv.b.cr(qem.getQQAppInterface().getCurrentAccountUin(), "3.4.4".replace(".", ""));
      rar.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.aCn = false;
      ((psr)psx.a(10)).n("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private boolean Jk()
  {
    ram.d(TAG, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { this.mShotView, Boolean.valueOf(this.aCn), Boolean.valueOf(this.mRunning), Boolean.valueOf(this.aCr), Boolean.valueOf(this.aCq), Boolean.valueOf(Jm()), Boolean.valueOf(false) });
    return (this.mShotView != null) && (this.aCn) && (this.mRunning) && (!this.aCr) && (this.aCq) && (Jm());
  }
  
  private boolean Jl()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView;
      bool1 = bool2;
      if (localRecyclerView != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Pvu != null) {
          if (((LinearLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() != 0) {
            break label64;
          }
        }
      }
    }
    label64:
    for (bool1 = true;; bool1 = false)
    {
      ram.b(TAG, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
      return bool1;
    }
  }
  
  private boolean Jm()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop();
      ram.a(TAG, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(i), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.isShown()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mDetached));
      bool1 = bool2;
      if (i >= 0)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mDetached) {
          bool1 = true;
        }
      }
    }
    ram.b(TAG, "isMsgTabVisible %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private void a(View paramView, Activity paramActivity, puh parampuh)
  {
    if (parampuh.nodeType == 12)
    {
      parampuh.ava = "";
      parampuh = new OpenPlayerBuilder(new MsgTabPlayInfo(parampuh.unionId, 0, null, parampuh.nodeFeedId, parampuh.nodeVid), 106);
      parampuh.a(mF());
      parampuh = parampuh.b();
      parampuh.mUIStyle.bottomWidgetShowFlag = 3;
      if ((paramView instanceof StoryMsgNodeFrameLayout))
      {
        qgg.a(paramActivity, parampuh, ((StoryMsgNodeFrameLayout)paramView).a);
        return;
      }
      qgg.a(paramActivity, parampuh, paramView);
      return;
    }
    puv localpuv = new puv(TAG);
    localpuv.aBQ = true;
    Stream.of(parampuh).map(new ThreadOffFunction(TAG, 2)).map(localpuv).map(new puk(parampuh)).map(new UIThreadOffFunction(null)).subscribe(new pwi(this, parampuh, paramView, paramActivity));
  }
  
  private void bnm()
  {
    if ((this.dp != null) && (this.aCn)) {
      ThreadManager.getUIHandler().post(this.dp);
    }
    awsw.gC(BaseApplicationImpl.getContext());
  }
  
  private void bnn()
  {
    rar.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private void bnq()
  {
    if (this.jdField_a_of_type_Auvw != null)
    {
      if (this.jdField_a_of_type_Auvw.isShowing())
      {
        this.jdField_a_of_type_Auvw.dismiss();
        ram.d(TAG, "dismissTipWindows() dismiss");
      }
      for (;;)
      {
        this.jdField_a_of_type_Auvw = null;
        return;
        ram.d(TAG, "dismissTipWindows() not showing, not need dismiss()");
      }
    }
    ram.d(TAG, "dismissTipWindows() but mTipWindow is null");
  }
  
  private void bnr()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    if (localBaseActivity != null)
    {
      this.aCp = localBaseActivity.getIntent().getBooleanExtra("show_story_msg_tab", false);
      if (this.aCp) {
        localBaseActivity.getIntent().putExtra("show_story_msg_tab", false);
      }
    }
  }
  
  private void bns()
  {
    bnr();
    if (this.aCp)
    {
      this.aCp = false;
      this.mListView.setSelection(0);
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.16(this));
    }
  }
  
  private void cz(Context paramContext)
  {
    Object localObject = new QQStoryMainActivity.a("mainHallConfig");
    String str;
    if ((!TextUtils.isEmpty(((QQStoryMainActivity.a)localObject).jumpUrl)) && (jqc.isValidUrl(((QQStoryMainActivity.a)localObject).jumpUrl)))
    {
      str = ((QQStoryMainActivity.a)localObject).jumpUrl;
      if ((((QQStoryMainActivity.a)localObject).show != 0) && (((QQStoryMainActivity.a)localObject).show != 1)) {
        break label85;
      }
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      paramContext.startActivity((Intent)localObject);
    }
    label85:
    while ((((QQStoryMainActivity.a)localObject).show == 2) || (((QQStoryMainActivity.a)localObject).show != 3))
    {
      return;
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
    }
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preMode != 3)) {
      this.b.doOnScroll(paramFloat);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%f,offset_scroll_over:%f", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.mb), Float.valueOf(this.md) }));
    }
    float f1;
    if ((paramFloat <= this.mb) && (paramFloat > this.md)) {
      if (paramFloat <= this.mc)
      {
        f1 = (this.mc - paramFloat) / (this.mc - this.md);
        float f2 = this.STORY_TRANSLATE + (this.mb - this.mc) * 1.0F;
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.od.getTranslationY();
        this.od.setTranslationY(f1);
        if (this.od.getTranslationY() < this.STORY_TRANSLATE) {
          this.od.setTranslationY(this.STORY_TRANSLATE);
        }
        if (this.od.getTranslationY() > 0.0F) {
          this.od.setTranslationY(0.0F);
        }
        f2 = this.od.getTranslationY() - f2;
        Z(1.0F - this.od.getTranslationY() / this.STORY_TRANSLATE + 0.8F);
        f1 = f2;
        if (this.mVibrator != null)
        {
          f1 = f2;
          if (this.me > this.mb)
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_do);
            ThreadManager.getSubThreadHandler().post(this.jdField_do);
            f1 = f2;
          }
        }
        label294:
        if (paramFloat <= rpq.dip2px(this.mContext, -75.0F)) {
          break label372;
        }
        this.b.setTranslationY((this.b.getHeight() + paramFloat) / 2.0F);
      }
    }
    for (;;)
    {
      this.me = paramFloat;
      return;
      f1 = this.STORY_TRANSLATE + (this.mb - paramFloat) * 1.0F;
      break;
      if (paramFloat <= this.md) {
        sw(true);
      }
      f1 = 0.0F;
      break label294;
      label372:
      this.b.setTranslationY(f1 + this.b.getTranslationY());
    }
  }
  
  private boolean needIntercept()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView == null) || (this.mListView == null)) {
      bool = false;
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    do
    {
      return bool;
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
    } while ((arrayOfInt1[1] >= arrayOfInt2[1]) && (this.mListView.getScrollY() < 0) && (this.mode == 3));
    return false;
  }
  
  private void onNodeScrollOut()
  {
    String str = TAG;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mDetached) {}
    for (boolean bool = true;; bool = false)
    {
      ram.b(str, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(bool));
      rar.a("msg_tab", "show_story", 0, 0, new String[0]);
      bnm();
      this.jdField_a_of_type_Pvv.bq("exp_story", 6);
      sScrollTimestamp = SystemClock.uptimeMillis();
      return;
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131377032);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void sw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.od.getTranslationY() != 0.0F) {
        this.od.setTranslationY(0.0F);
      }
      if (this.od.getAlpha() != 1.0F) {
        Z(1.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(true, this.mb);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.Cl(false);
      return;
    }
    if (this.od.getTranslationY() != this.STORY_TRANSLATE) {
      this.od.setTranslationY(this.STORY_TRANSLATE);
    }
    if (this.od.getAlpha() != 0.0F) {
      Z(0.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.Cl(true);
  }
  
  public boolean Ji()
  {
    if ((this.mListView.mEnableStory) && (!this.mListView.mForStory) && (this.mListView.getListViewScrollY() == 0))
    {
      this.mListView.setScrollY(-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
      this.mListView.mForStory = true;
      this.mode = 3;
      sw(true);
      setRefreshLayoutVisible(true);
      bnm();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.dEj();
      this.b.resetDots();
      this.jdField_a_of_type_Pvz$a.bnt();
      return true;
    }
    return false;
  }
  
  public void N(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_Pvu.getItemViewType(paramInt);
    String[] arrayOfString = (String[])fk.get(Integer.valueOf(i));
    puh localpuh = (puh)this.jdField_a_of_type_Pvu.getItem(paramInt);
    if (localpuh == null) {}
    do
    {
      return;
      if ((this.K != null) && (this.K.isShowing())) {
        this.K.dismiss();
      }
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    this.K = ausj.b(this.mContext);
    int j = arrayOfString.length;
    i = 0;
    label96:
    if (i < j)
    {
      paramView = arrayOfString[i];
      if ((!avE.equals(paramView)) && (!avF.equals(paramView))) {
        break label303;
      }
      QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(localpuh.unionId);
      if (localQQUserUIItem == null) {
        break label303;
      }
      if (localQQUserUIItem.isSubscribe()) {
        paramView = avF;
      }
    }
    label303:
    for (;;)
    {
      this.K.a(new ausi(paramView, paramInt, 0), 5);
      i += 1;
      break label96;
      paramView = avE;
      continue;
      this.K.addCancelButton(2131721058);
      this.K.a(this);
      this.K.a(new pwa(this, localpuh));
      this.K.show();
      if (localpuh == null) {
        break;
      }
      rar.a("msg_tab", "press_story", 0, 0, new String[] { localpuh.nodeType + "", "", "", localpuh.unionId });
      return;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.K.dismiss();
    Object localObject = this.K.a(paramInt);
    if (localObject == null) {}
    puh localpuh;
    do
    {
      return;
      localpuh = (puh)this.jdField_a_of_type_Pvu.getItem(((ausi)localObject).action);
    } while (localpuh == null);
    paramView = this.mContext;
    localObject = ((ausi)localObject).content;
    if (avB.equals(localObject)) {
      if ((6 == localpuh.nodeType) || (7 == localpuh.nodeType) || (9 == localpuh.nodeType) || (5 == localpuh.nodeType))
      {
        QQStoryMemoriesActivity.a(paramView, 26, localpuh.unionId, false);
        paramView = "1";
      }
    }
    for (;;)
    {
      rar.a("msg_tab", "clk_press", 0, 0, new String[] { localpuh.nodeType + "", paramView, "", localpuh.unionId });
      return;
      if (8 == localpuh.nodeType)
      {
        QQStoryShareGroupProfileActivity.a(paramView, 2, localpuh.unionId, String.valueOf(localpuh.uid), 17, 0);
        break;
      }
      if (12 != localpuh.nodeType) {
        break;
      }
      cz(paramView);
      break;
      if (avC.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryFriendSettings.class);
        ((Intent)localObject).putExtra("from", -1);
        paramView.startActivity((Intent)localObject);
        paramView = "2";
      }
      else if (avD.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryShieldActivity.class);
        ((Intent)localObject).putExtra("uin", String.valueOf(localpuh.uid));
        ((Intent)localObject).putExtra("from", 3);
        paramView.startActivity((Intent)localObject);
        paramView = "3";
      }
      else if (avH.equals(localObject))
      {
        this.jdField_a_of_type_Pvv.q(localpuh);
        paramView = "7";
      }
      else if (avE.equals(localObject))
      {
        this.jdField_a_of_type_Pvv.b(localpuh, 0);
        paramView = "4";
      }
      else if (avF.equals(localObject))
      {
        this.jdField_a_of_type_Pvv.b(localpuh, 1);
        paramView = "5";
      }
      else if ("debug info".equals(localObject))
      {
        Toast.makeText(paramView, localpuh.toString(), 1).show();
        paramView = "";
      }
      else
      {
        if (avI.equals(localObject)) {}
        paramView = "";
      }
    }
  }
  
  void Z(float paramFloat)
  {
    if (this.od != null) {
      this.od.setAlpha(paramFloat);
    }
  }
  
  public void bnh()
  {
    if (QQStoryContext.a() == null) {
      return;
    }
    ((puy)this.mApp.getManager(251)).a().bmP();
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.5(this));
  }
  
  public void bni()
  {
    ram.i(TAG, "MsgTab launch()");
    this.jdField_a_of_type_Pvz$a = new pvz.a();
    rom.checkNotNull(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.mChatTopRefresh != null))
    {
      if (this.mChatTopRefresh.indexOfChild(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView) >= 0) {
        break label337;
      }
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131377032);
      this.mChatTopRefresh.addView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView, (ViewGroup.LayoutParams)localObject);
      setRefreshLayoutVisible(false);
      sw(false);
      this.mListView.setMaxOverScrollTopDistance(70);
      this.mListView.setQQStoryListViewListener(this);
      this.mListView.mEnableStory = true;
      this.mListView.mForStory = false;
      this.mode = 1;
      if (this.mDrawer != null) {
        this.mDrawer.setStoryTouchEventInterceptor(this);
      }
      this.jdField_a_of_type_Pvv.aNg();
      this.mListView.getAdapter().registerDataSetObserver(this.mDataSetObserver);
      localObject = (psr)psx.a(10);
      this.aCo = ((Boolean)((psr)localObject).c("first_show_node", Boolean.valueOf(true))).booleanValue();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.addOnLayoutChangeListener(new pwh(this, (psr)localObject));
    }
    for (;;)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Akll);
      this.mApp.addObserver(this.jdField_a_of_type_Acbo);
      this.mApp.addObserver(this.c);
      aCs = this.mApp.getApp().getSharedPreferences("acc_info" + this.mApp.getAccount(), 0).getBoolean("isFriendlistok", false);
      bnh();
      this.mRunning = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(true, this.mb);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.Cl(false);
      return;
      label337:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "mChatTopRefresh already added msgNodeView " + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      }
    }
  }
  
  public void bnj()
  {
    if (this.jdField_a_of_type_Pvv != null)
    {
      ram.d(TAG, "updateAllFriendNodeItems()");
      this.jdField_a_of_type_Pvv.wb(6);
    }
  }
  
  public void bnk() {}
  
  public void bnl()
  {
    this.aCr = true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDrawerStartMoving");
    }
    bnq();
  }
  
  public void bno()
  {
    if ((this.mListView.mEnableStory) && (getMode() == 1))
    {
      ram.d(TAG, "startBreath() show breathView");
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.dEh();
      rar.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    ram.b(TAG, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.mListView.mEnableStory), Integer.valueOf(getMode()));
  }
  
  public void bnp()
  {
    if ((this.mListView.mEnableStory) && (this.mListView.mForStory))
    {
      this.mListView.setScrollY(0);
      this.mListView.mForStory = false;
      this.mode = 1;
      sw(false);
      setRefreshLayoutVisible(false);
    }
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f = paramARMapHongBaoListView.getScrollY();
    if (this.mode == 1) {
      return 0;
    }
    if (this.mode == 3) {
      return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
    }
    if (this.mode == 2) {
      return -paramARMapHongBaoListView.getOverScrollHeight();
    }
    return (int)f;
  }
  
  public void initLater(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, paramDrawerFrame + " initLater " + this.mListView.mEnableStory);
    }
    this.mDrawer = paramDrawerFrame;
    if (this.mDrawer != null) {
      this.mDrawer.setStoryTouchEventInterceptor(this);
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (needIntercept()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.interceptDrawer(paramView, paramMotionEvent);
    }
    paramMotionEvent = TAG;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      bool1 = true;
      if (this.mListView == null) {
        break label75;
      }
      label40:
      if (this.mListView != null) {
        break label81;
      }
    }
    label75:
    label81:
    for (paramView = "null";; paramView = Integer.valueOf(this.mListView.getScrollY()))
    {
      ram.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label40;
    }
  }
  
  public String mF()
  {
    return String.valueOf(hashCode());
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.bindData();
    this.jdField_a_of_type_Pvv.onAccountChange(paramQQAppInterface);
    this.mApp.removeObserver(this.jdField_a_of_type_Akll);
    this.mApp.removeObserver(this.jdField_a_of_type_Acbo);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView != null))
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView;
      localRecyclerView.setScrollX(0);
      ((LinearLayoutManager)localRecyclerView.getLayoutManager()).scrollToPosition(0);
      ram.d(TAG, "onAccountChanged set Scroll to 0!");
    }
    if (this.mRunning)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Akll);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Acbo);
      aCs = paramQQAppInterface.getApp().getSharedPreferences("acc_info" + this.mApp.getAccount(), 0).getBoolean("isFriendlistok", false);
    }
    this.mApp = paramQQAppInterface;
  }
  
  public void onDrawerClosed()
  {
    this.aCr = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDrawerClosed");
    }
  }
  
  public void onDrawerOpened()
  {
    this.aCr = true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDrawerOpened");
    }
    bnq();
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.mListView.mEnableStory) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null))
    {
      if (paramInt1 == 2) {
        doOnScroll(paramInt2, false);
      }
      if (paramInt2 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        sw(true);
        this.b.resetDots();
      }
    }
    else
    {
      return;
    }
    if ((!this.flag) && (paramInt2 >= 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "fight...onFlingScrollHeader1..scrollY = " + paramInt2 + ",flag = " + this.flag);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.Cl(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 4, "fight...onFlingScrollHeader2..scrollY = " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.aw(paramInt2);
  }
  
  public void onItemClick(View paramView, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu < 500L) {}
    Object localObject3;
    puh localpuh;
    Object localObject1;
    label87:
    Object localObject2;
    label100:
    StringBuilder localStringBuilder;
    int i;
    label158:
    do
    {
      return;
      this.iu = l;
      localObject3 = paramView.getContext();
      int j = this.jdField_a_of_type_Pvu.getItemViewType(paramInt);
      localpuh = (puh)this.jdField_a_of_type_Pvu.getItem(paramInt);
      if (localpuh != null)
      {
        localObject1 = "";
        if (localpuh.nodeType == 5)
        {
          if (localpuh.bkt <= 0) {
            break;
          }
          localObject1 = "2";
        }
        if (localpuh.unreadCount != 0) {
          break label544;
        }
        localObject2 = "2";
        localStringBuilder = new StringBuilder("{");
        localStringBuilder.append("\"mystory\":").append("\"").append((String)localObject1).append("\"");
        localObject1 = localStringBuilder.append(",\"msg\":");
        if (!localpuh.redPoint) {
          break label552;
        }
        i = 1;
        ((StringBuilder)localObject1).append(i);
        localStringBuilder.append("}");
        if (j != 12) {
          break label557;
        }
        l = localpuh.N(localpuh.nodeVid);
        rar.a("msg_tab", "clk_story", 0, 0, new String[] { localpuh.nodeType + ":" + localpuh.nodeVid + ":" + l, localObject2, localStringBuilder.toString(), localpuh.unionId });
      }
      switch (j)
      {
      }
    } while (localpuh == null);
    label275:
    if (QLog.isDevelopLevel()) {
      QLog.e(TAG, 2, "发现一个野生的类型: " + localpuh.nodeType);
    }
    while (localpuh != null)
    {
      paramView = new pve();
      paramView.nodeType = localpuh.nodeType;
      paramView.unionId = localpuh.unionId;
      paramView.recommendId = localpuh.recommendId;
      localpuh.redPoint = false;
      ppv.a().a(paramView, null);
      if (localpuh.unreadCount > 0) {
        ((psr)psx.a(10)).n("key_force_refresh_msg_node_list", Boolean.valueOf(true));
      }
      this.jdField_a_of_type_Pvu.notifyItemChanged(paramInt);
      ram.b(TAG, "onItemClick, unionId:%s", paramView.unionId);
      return;
      localObject1 = "1";
      break label87;
      label544:
      localObject2 = "1";
      break label100;
      label552:
      i = 0;
      break label158;
      label557:
      rar.a("msg_tab", "clk_story", 0, 0, new String[] { localpuh.nodeType + "", localObject2, localStringBuilder.toString(), localpuh.unionId });
      break label275;
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.b();
      if (localObject1 == null)
      {
        paramView = null;
        if (!TextUtils.isEmpty(paramView)) {
          break label885;
        }
        localObject1 = rnq.a();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("entrance_type", 103);
        ((Bundle)localObject2).putInt("report_entrance_type", 1);
        if (!(localObject3 instanceof Activity)) {
          break label873;
        }
        localObject3 = (Activity)localObject3;
        ((rnq)localObject1).a((Activity)localObject3, (Bundle)localObject2, 0);
        ((Activity)localObject3).overridePendingTransition(2130772306, 2130772079);
        label715:
        localObject1 = new StringBuilder("{");
        ((StringBuilder)localObject1).append("\"text\":").append("\"").append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.mE()).append("\"");
        ((StringBuilder)localObject1).append(",\"jumpUrl\":").append("\"").append(paramView).append("\"");
        paramView = ((StringBuilder)localObject1).append(",\"msg\":");
        if (localpuh == null) {
          break label1044;
        }
        if (!localpuh.redPoint) {
          break label1039;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramView.append(paramInt);
        ((StringBuilder)localObject1).append("}");
        rar.a("msg_tab", "clk_story", 0, 0, new String[] { "1", "", ((StringBuilder)localObject1).toString(), "" });
        return;
        paramView = ((puz.a)localObject1).jumpUrl;
        break;
        label873:
        ((rnq)localObject1).g((Context)localObject3, (Bundle)localObject2);
        break label715;
        label885:
        rpt.a(QQStoryContext.a(), this.mContext, paramView, true);
        if (!((puz.a)localObject1).aCb) {
          break label715;
        }
        localObject3 = ((puz)QQStoryContext.a().getManager(252)).a();
        if ((localObject3 != null) && (TextUtils.equals(((puz.a)localObject1).contentId, ((puz.a)localObject3).contentId)))
        {
          ((puz.a)localObject3).alW = true;
          psr.si(true);
          ram.d("Q.qqstory.config.takevideo", "onItemClick configId=%s", ((puz.a)localObject1).contentId);
          localObject1 = new puz.b();
          pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
          break label715;
        }
        ((puz.a)localObject1).alW = true;
        localObject2 = ((puz.a)localObject1).contentId;
        if (localObject3 == null) {}
        for (localObject1 = "";; localObject1 = ((puz.a)localObject3).contentId)
        {
          ram.d("Q.qqstory.config.takevideo", "onItemClick oldId=%s, newId=%s", localObject2, localObject1);
          break;
        }
        label1039:
        paramInt = 0;
        continue;
        label1044:
        paramInt = 0;
      }
      if ((localpuh != null) && (!rpq.isFastDoubleClick()))
      {
        ram.d(TAG, "onItemClick(), unionId=%s, videoCover=%s", localpuh.unionId, localpuh.videoCover);
        a(paramView, (Activity)localObject3, localpuh);
        continue;
        if ((localpuh != null) && (!rpq.isFastDoubleClick()))
        {
          ram.b(TAG, "onItemClick(), unionId=%s, videoCover=%s, vid=%s", localpuh.unionId, localpuh.videoCover, localpuh.nodeVid);
          localpuh.iO.clear();
          a(paramView, (Activity)localObject3, localpuh);
          continue;
          if (((localObject3 instanceof Activity)) && (localpuh != null) && (!TextUtils.isEmpty(localpuh.nodeVid)))
          {
            localObject1 = this.jdField_a_of_type_Pvu.be();
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localObject1 = new OpenPlayerBuilder(new VidListPlayInfo("", localpuh.nodeVid), 107).a().d();
              qgg.a((Activity)localObject3, ((OpenPlayerBuilder)localObject1).b(), paramView);
              localpuh.unreadCount = 0;
              if (this.jdField_a_of_type_Pvv != null) {
                this.jdField_a_of_type_Pvv.o(localpuh);
              }
              pxa.v(localpuh);
            }
            pxa.v(localpuh);
            continue;
            rar.cy("home_page-exp-d4", "5");
            ((Context)localObject3).startActivity(StoryTransitionActivity.a((Context)localObject3));
            continue;
            ((Context)localObject3).startActivity(StoryMessageListActivity.b((Context)localObject3, "1", 3));
            continue;
            if (localpuh == null) {
              break;
            }
            rpt.a(this.mApp, this.mContext, localpuh.jumpUrl, true);
            localpuh.unreadCount = 0;
            if (this.jdField_a_of_type_Pvv != null) {
              this.jdField_a_of_type_Pvv.o(localpuh);
            }
            pxa.v(localpuh);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    this.aCq = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onPause");
    }
    bnq();
    AbstractGifImage.pauseAll();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onPause");
    }
  }
  
  public void onPostThemeChanged()
  {
    this.jdField_a_of_type_Pvu.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.onPostThemeChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.onPostThemeChanged();
  }
  
  public void onResume()
  {
    this.aCq = true;
    AbstractGifImage.resumeAll();
    if ((this.jdField_a_of_type_Pvu != null) && (this.mRunning)) {
      this.jdField_a_of_type_Pvu.notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onResume");
    }
    bns();
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onScrollStateChanged:" + paramInt + ",mode:" + this.mode);
    }
    this.mLastScrollState = paramInt;
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.md == 0.0F) {
      this.md = (-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
    }
    float f = paramARMapHongBaoListView.getScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (this.mode != 1);
        this.flag = true;
        sw(false);
        this.b.resetDots();
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
        return;
        if ((!this.flag) && (this.mode == 1))
        {
          this.flag = true;
          sw(false);
          this.b.resetDots();
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
        }
        if ((f <= 0.0F) && (this.mode == 1))
        {
          doOnScroll(f, true);
          return;
        }
      } while (f >= 0.0F);
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "fight...onTouchMoving.onMove..scrollY = " + f);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.aw(f);
      return;
    }
    this.flag = false;
    this.preMode = this.mode;
    if (f >= 0.0F)
    {
      if (paramARMapHongBaoListView.mForStory) {
        bnn();
      }
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
    }
    for (;;)
    {
      setRefreshLayoutVisible(paramARMapHongBaoListView.mForStory);
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "fight...onTouchMoving.onUp..scrollY = " + f);
      }
      if (f < 0.0F) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.mChatTopRefresh.findViewById(2131377036);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(acfp.m(2131708534)))) {}
          for (this.mode = 3;; this.mode = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            ram.d(TAG, "story node start refresh onTouchMoving");
          }
        }
        if (f <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
          bnn();
        }
      }
      else if (f <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        if (this.mode != 2)
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
          onNodeScrollOut();
        }
      }
      else if (f <= this.ma)
      {
        if (this.mode == 2)
        {
          sw(false);
        }
        else
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
          onNodeScrollOut();
        }
      }
      else
      {
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onViewCompleteAfterRefresh, mode:" + this.mode);
    }
    if (this.mode == 2) {
      if (paramARMapHongBaoListView.mForStory)
      {
        this.mode = 3;
        i = -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
      }
    }
    while (this.mode != 3)
    {
      return i;
      this.mode = 1;
      return 0;
    }
    return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
  }
  
  public void shutdown()
  {
    ram.i(TAG, "MsgTab shutdown()");
    if (!this.mRunning) {
      return;
    }
    try
    {
      this.mChatTopRefresh.removeView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      setRefreshLayoutVisible(true);
      this.mListView.setMaxOverScrollTopDistance(30);
      this.mListView.setQQStoryListViewListener(null);
      this.mListView.scrollTo(0, 0);
      this.mListView.mEnableStory = false;
      this.mListView.mForStory = false;
      this.mode = 1;
      if (this.mDrawer != null) {
        this.mDrawer.setStoryTouchEventInterceptor(null);
      }
      this.jdField_a_of_type_Pvv.onDetached();
      this.mListView.getAdapter().unregisterDataSetObserver(this.mDataSetObserver);
      bnq();
      this.mApp.removeObserver(this.jdField_a_of_type_Akll);
      this.mApp.removeObserver(this.jdField_a_of_type_Acbo);
      this.mApp.removeObserver(this.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.b(false, this.mb);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.Cl(true);
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        annt.e(rpl.a.b("QQStoryMsgTabShutdown, Null", localNullPointerException), "QQStoryMsgTabShutdown NullPointerException");
      }
    }
    this.mRunning = false;
  }
  
  public void tT(int paramInt) {}
  
  public static class a
  {
    public int bkY;
    public int bkZ;
    public String date = "";
    
    public a()
    {
      psr localpsr = (psr)psx.a(10);
      String str = roq.getDateString();
      this.date = ((String)localpsr.c("key_story_msg_tab_autoshow_date", this.date));
      this.bkY = ((Integer)localpsr.c("key_story_msg_tab_autoshow_count", Integer.valueOf(this.bkY))).intValue();
      this.bkZ = ((Integer)localpsr.c("key_story_msg_tab_autoshow_quota", Integer.valueOf(this.bkZ))).intValue();
      if (!TextUtils.equals(this.date, str))
      {
        this.date = str;
        this.bkY = 0;
        localpsr.n("key_story_msg_tab_autoshow_date", this.date);
        localpsr.n("key_story_msg_tab_autoshow_count", Integer.valueOf(this.bkY));
      }
      ram.a(pvz.access$100(), "MsgTabShowCounter(): %d/%d @ %s", Integer.valueOf(this.bkY), Integer.valueOf(this.bkZ), this.date);
    }
    
    public boolean Jn()
    {
      bnu();
      ram.a(pvz.access$100(), "shouldAutoShow(): %d/%d @ %s", Integer.valueOf(this.bkY), Integer.valueOf(this.bkZ), this.date);
      return this.bkY < this.bkZ;
    }
    
    public void bnt()
    {
      bnu();
      this.bkY += 1;
      ((psr)psx.a(10)).n("key_story_msg_tab_autoshow_count", Integer.valueOf(this.bkY));
      ram.a(pvz.access$100(), "addAutoShowCount(): %d/%d @ %s", Integer.valueOf(this.bkY), Integer.valueOf(this.bkZ), this.date);
    }
    
    public void bnu()
    {
      String str = roq.getDateString();
      if (!TextUtils.equals(str, this.date))
      {
        psr localpsr = (psr)psx.a(10);
        this.date = str;
        this.bkY = 0;
        localpsr.n("key_story_msg_tab_autoshow_date", this.date);
        localpsr.n("key_story_msg_tab_autoshow_count", Integer.valueOf(this.bkY));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvz
 * JD-Core Version:    0.7.0.1
 */