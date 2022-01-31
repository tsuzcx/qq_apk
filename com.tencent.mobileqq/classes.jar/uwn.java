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
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ListView;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class uwn
  implements ajdu, bhph, bhqd, upw, upx
{
  public static String a;
  private static HashMap<Integer, String[]> jdField_a_of_type_JavaUtilHashMap;
  public static long b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static boolean h;
  private static String jdField_i_of_type_JavaLangString;
  float jdField_a_of_type_Float;
  public int a;
  long jdField_a_of_type_Long;
  private aljr jdField_a_of_type_Aljr = new uwr(this);
  Context jdField_a_of_type_AndroidContentContext;
  DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  View jdField_a_of_type_AndroidViewView;
  protected avqs a;
  bhpy jdField_a_of_type_Bhpy;
  bhyv jdField_a_of_type_Bhyv;
  private DotAnimationView jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView;
  public MsgNodeShotView a;
  public MsgTabStoryNodeView a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
  public QQAppInterface a;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public ARMapHongBaoListView a;
  public Runnable a;
  private final uhn jdField_a_of_type_Uhn = new uws(this);
  uvy jdField_a_of_type_Uvy;
  uvz jdField_a_of_type_Uvz;
  public uwx a;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 30;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new MsgTabStoryNodeListManager.1(this);
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 70;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  private int f;
  public boolean f;
  private int g;
  public boolean g;
  boolean jdField_i_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131707343);
    jdField_b_of_type_JavaLangString = alpo.a(2131707347);
    jdField_c_of_type_JavaLangString = alpo.a(2131707345);
    jdField_d_of_type_JavaLangString = alpo.a(2131707352);
    jdField_e_of_type_JavaLangString = alpo.a(2131707344);
    jdField_f_of_type_JavaLangString = alpo.a(2131707348);
    jdField_g_of_type_JavaLangString = alpo.a(2131707349);
    jdField_h_of_type_JavaLangString = alpo.a(2131707351);
    jdField_i_of_type_JavaLangString = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new String[] { jdField_a_of_type_JavaLangString, jdField_c_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), new String[] { jdField_a_of_type_JavaLangString, jdField_e_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), new String[] { jdField_a_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), new String[] { jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), new String[] { jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), new String[] { jdField_a_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
  }
  
  public uwn(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 1;
    this.jdField_a_of_type_Avqs = new uwq(this);
    this.jdField_a_of_type_JavaLangRunnable = new MsgTabStoryNodeListManager.11(this);
    xmh.a(paramPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = paramPullRefreshHeader;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = paramBreathEffectView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131377027);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView = ((DotAnimationView)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131365404));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)this.jdField_a_of_type_AndroidContentContext.getSystemService("vibrator"));
    this.jdField_a_of_type_Uvy = new uvy(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView = new MsgNodeShotView(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView;
    r();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.setLayoutParams(new RecyclerView.LayoutParams(aekt.a(67.0F, this.jdField_b_of_type_AndroidViewView.getResources()), aekt.a(102.0F, this.jdField_b_of_type_AndroidViewView.getResources())));
    this.jdField_a_of_type_Uvy.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView);
    this.jdField_a_of_type_Uvy.a(this);
    this.jdField_a_of_type_Uvy.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setAdapter(this.jdField_a_of_type_Uvy);
    this.jdField_a_of_type_Uvz = new uvz(this, this.jdField_a_of_type_Uvy, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setOnScrollListener(new uwt(this));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new uwu(this);
    this.jdField_b_of_type_Float = xod.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_c_of_type_Float = xod.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_d_of_type_Float = xod.a(this.jdField_a_of_type_AndroidContentContext, -120.0F);
    this.jdField_d_of_type_Int = xod.a(this.jdField_a_of_type_AndroidContentContext, -80.0F);
    this.jdField_e_of_type_Int = xod.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
    AbstractGifImage.resumeAll();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_i_of_type_JavaLangString, 2, "on create");
    }
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.jdField_g_of_type_Int != 3)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a(paramFloat);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%f,offset_scroll_over:%f", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(this.jdField_e_of_type_Float) }));
    }
    float f1;
    if ((paramFloat <= this.jdField_c_of_type_Float) && (paramFloat > this.jdField_e_of_type_Float)) {
      if (paramFloat <= this.jdField_d_of_type_Float)
      {
        f1 = (this.jdField_d_of_type_Float - paramFloat) / (this.jdField_d_of_type_Float - this.jdField_e_of_type_Float);
        float f2 = this.jdField_d_of_type_Int + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float) * 1.0F;
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY();
        this.jdField_b_of_type_AndroidViewView.setTranslationY(f1);
        if (this.jdField_b_of_type_AndroidViewView.getTranslationY() < this.jdField_d_of_type_Int) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(this.jdField_d_of_type_Int);
        }
        if (this.jdField_b_of_type_AndroidViewView.getTranslationY() > 0.0F) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
        }
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY() - f2;
        a(1.0F - this.jdField_b_of_type_AndroidViewView.getTranslationY() / this.jdField_d_of_type_Int + 0.8F);
        f1 = f2;
        if (this.jdField_a_of_type_AndroidOsVibrator != null)
        {
          f1 = f2;
          if (this.jdField_a_of_type_Float > this.jdField_c_of_type_Float)
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
            f1 = f2;
          }
        }
        label294:
        if (paramFloat <= xod.a(this.jdField_a_of_type_AndroidContentContext, -75.0F)) {
          break label372;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.setTranslationY((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.getHeight() + paramFloat) / 2.0F);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramFloat;
      return;
      f1 = this.jdField_d_of_type_Int + (this.jdField_c_of_type_Float - paramFloat) * 1.0F;
      break;
      if (paramFloat <= this.jdField_e_of_type_Float) {
        a(true);
      }
      f1 = 0.0F;
      break label294;
      label372:
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.setTranslationY(f1 + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.getTranslationY());
    }
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new wco("mainHallConfig");
    String str;
    if ((!TextUtils.isEmpty(((wco)localObject).jdField_c_of_type_JavaLangString)) && (ndd.a(((wco)localObject).jdField_c_of_type_JavaLangString)))
    {
      str = ((wco)localObject).jdField_c_of_type_JavaLangString;
      if ((((wco)localObject).jdField_a_of_type_Int != 0) && (((wco)localObject).jdField_a_of_type_Int != 1)) {
        break label85;
      }
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      paramContext.startActivity((Intent)localObject);
    }
    label85:
    while ((((wco)localObject).jdField_a_of_type_Int == 2) || (((wco)localObject).jdField_a_of_type_Int != 3))
    {
      return;
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
    }
  }
  
  private void a(View paramView, Activity paramActivity, utx paramutx)
  {
    if (paramutx.jdField_a_of_type_Int == 12)
    {
      paramutx.jdField_i_of_type_JavaLangString = "";
      paramutx = new OpenPlayerBuilder(new MsgTabPlayInfo(paramutx.jdField_a_of_type_JavaLangString, 0, null, paramutx.jdField_f_of_type_JavaLangString, paramutx.jdField_e_of_type_JavaLangString), 106);
      paramutx.a(a());
      paramutx = paramutx.a();
      paramutx.mUIStyle.bottomWidgetShowFlag = 3;
      if ((paramView instanceof StoryMsgNodeFrameLayout))
      {
        vju.a(paramActivity, paramutx, ((StoryMsgNodeFrameLayout)paramView).a);
        return;
      }
      vju.a(paramActivity, paramutx, paramView);
      return;
    }
    uun localuun = new uun(jdField_i_of_type_JavaLangString);
    localuun.jdField_a_of_type_Boolean = true;
    Stream.of(paramutx).map(new ThreadOffFunction(jdField_i_of_type_JavaLangString, 2)).map(localuun).map(new uua(paramutx)).map(new UIThreadOffFunction(null)).subscribe(new uww(this, paramutx, paramView, paramActivity));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidViewView.getTranslationY() != 0.0F) {
        this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
      }
      if (this.jdField_b_of_type_AndroidViewView.getAlpha() != 1.0F) {
        a(1.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(true, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.c(false);
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView.getTranslationY() != this.jdField_d_of_type_Int) {
      this.jdField_b_of_type_AndroidViewView.setTranslationY(this.jdField_d_of_type_Int);
    }
    if (this.jdField_b_of_type_AndroidViewView.getAlpha() != 0.0F) {
      a(0.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.c(true);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131375532);
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView == null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null)) {
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
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getLocationInWindow(arrayOfInt2);
    } while ((arrayOfInt1[1] >= arrayOfInt2[1]) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getScrollY() < 0) && (this.jdField_f_of_type_Int == 3));
    return false;
  }
  
  private boolean c()
  {
    if (!d())
    {
      wsv.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!e())
    {
      wsv.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_Bhyv == null)
    {
      wsv.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = bhyv.a(this.jdField_a_of_type_AndroidContentContext).a(true).a(alpo.a(2131707350)).a(16.0F).b(5).a(-1);
      ((bhyw)localObject).c(50);
      this.jdField_a_of_type_Bhyv = new bhyx((bhyw)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.jdField_a_of_type_Bhyv.a(82);
      this.jdField_a_of_type_Bhyv.a(new uwp(this));
    }
    if (!this.jdField_a_of_type_Bhyv.isShowing())
    {
      this.jdField_a_of_type_Bhyv.c(this.jdField_a_of_type_AndroidViewView, aekt.a(7.0F, this.jdField_b_of_type_AndroidViewView.getResources()), aekt.a(-5.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      wsv.a(jdField_i_of_type_JavaLangString, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.jdField_a_of_type_Uvz.a.a(vhj.a().getCurrentAccountUin(), "8.3.3".replace(".", ""));
      wta.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.jdField_c_of_type_Boolean = false;
      ((urk)urr.a(10)).b("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    wsv.b(jdField_i_of_type_JavaLangString, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { this.jdField_a_of_type_AndroidViewView, Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_g_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(f()), Boolean.valueOf(false) });
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (!this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (f());
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      bool1 = bool2;
      if (localRecyclerView != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Uvy != null) {
          if (((LinearLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() != 0) {
            break label64;
          }
        }
      }
    }
    label64:
    for (bool1 = true;; bool1 = false)
    {
      wsv.a(jdField_i_of_type_JavaLangString, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
      return bool1;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop();
      wsv.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.isShown()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean));
      bool1 = bool2;
      if (j >= 0)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    wsv.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private void n()
  {
    String str = jdField_i_of_type_JavaLangString;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      wsv.a(str, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(bool));
      wta.a("msg_tab", "show_story", 0, 0, new String[0]);
      o();
      this.jdField_a_of_type_Uvz.a("exp_story", 6);
      jdField_b_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_Boolean)) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
    bkjr.a(BaseApplicationImpl.getContext());
  }
  
  private void p()
  {
    wta.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Bhyv != null)
    {
      if (this.jdField_a_of_type_Bhyv.isShowing())
      {
        this.jdField_a_of_type_Bhyv.dismiss();
        wsv.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() dismiss");
      }
      for (;;)
      {
        this.jdField_a_of_type_Bhyv = null;
        return;
        wsv.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() not showing, not need dismiss()");
      }
    }
    wsv.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() but mTipWindow is null");
  }
  
  private void r()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    if (localBaseActivity != null)
    {
      this.jdField_e_of_type_Boolean = localBaseActivity.getIntent().getBooleanExtra("show_story_msg_tab", false);
      if (this.jdField_e_of_type_Boolean) {
        localBaseActivity.getIntent().putExtra("show_story_msg_tab", false);
      }
    }
  }
  
  private void s()
  {
    r();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.16(this));
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    Object localObject = this.jdField_a_of_type_Bhpy.a(paramInt);
    if (localObject == null) {}
    utx localutx;
    do
    {
      return;
      localutx = (utx)this.jdField_a_of_type_Uvy.a(((bhpx)localObject).jdField_c_of_type_Int);
    } while (localutx == null);
    paramView = this.jdField_a_of_type_AndroidContentContext;
    localObject = ((bhpx)localObject).jdField_a_of_type_JavaLangString;
    if (jdField_a_of_type_JavaLangString.equals(localObject)) {
      if ((6 == localutx.jdField_a_of_type_Int) || (7 == localutx.jdField_a_of_type_Int) || (9 == localutx.jdField_a_of_type_Int) || (5 == localutx.jdField_a_of_type_Int))
      {
        QQStoryMemoriesActivity.a(paramView, 26, localutx.jdField_a_of_type_JavaLangString, false);
        paramView = "1";
      }
    }
    for (;;)
    {
      wta.a("msg_tab", "clk_press", 0, 0, new String[] { localutx.jdField_a_of_type_Int + "", paramView, "", localutx.jdField_a_of_type_JavaLangString });
      return;
      if (8 == localutx.jdField_a_of_type_Int)
      {
        QQStoryShareGroupProfileActivity.a(paramView, 2, localutx.jdField_a_of_type_JavaLangString, String.valueOf(localutx.jdField_b_of_type_Long), 17, 0);
        break;
      }
      if (12 != localutx.jdField_a_of_type_Int) {
        break;
      }
      a(paramView);
      break;
      if (jdField_b_of_type_JavaLangString.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryFriendSettings.class);
        ((Intent)localObject).putExtra("from", -1);
        paramView.startActivity((Intent)localObject);
        paramView = "2";
      }
      else if (jdField_c_of_type_JavaLangString.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryShieldActivity.class);
        ((Intent)localObject).putExtra("uin", String.valueOf(localutx.jdField_b_of_type_Long));
        ((Intent)localObject).putExtra("from", 3);
        paramView.startActivity((Intent)localObject);
        paramView = "3";
      }
      else if (jdField_g_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Uvz.b(localutx);
        paramView = "7";
      }
      else if (jdField_d_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Uvz.a(localutx, 0);
        paramView = "4";
      }
      else if (jdField_e_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Uvz.a(localutx, 1);
        paramView = "5";
      }
      else if ("debug info".equals(localObject))
      {
        Toast.makeText(paramView, localutx.toString(), 1).show();
        paramView = "";
      }
      else
      {
        if (jdField_h_of_type_JavaLangString.equals(localObject)) {}
        paramView = "";
      }
    }
  }
  
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a()
  {
    if (QQStoryContext.a() == null) {
      return;
    }
    ((uuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().b();
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.5(this));
  }
  
  void a(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setAlpha(paramFloat);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_c_of_type_Long < 500L) {}
    Object localObject3;
    utx localutx;
    Object localObject1;
    label87:
    Object localObject2;
    label100:
    StringBuilder localStringBuilder;
    int j;
    label158:
    do
    {
      return;
      this.jdField_c_of_type_Long = l;
      localObject3 = paramView.getContext();
      int k = this.jdField_a_of_type_Uvy.getItemViewType(paramInt);
      localutx = (utx)this.jdField_a_of_type_Uvy.a(paramInt);
      if (localutx != null)
      {
        localObject1 = "";
        if (localutx.jdField_a_of_type_Int == 5)
        {
          if (localutx.jdField_d_of_type_Int <= 0) {
            break;
          }
          localObject1 = "2";
        }
        if (localutx.jdField_b_of_type_Int != 0) {
          break label544;
        }
        localObject2 = "2";
        localStringBuilder = new StringBuilder("{");
        localStringBuilder.append("\"mystory\":").append("\"").append((String)localObject1).append("\"");
        localObject1 = localStringBuilder.append(",\"msg\":");
        if (!localutx.jdField_c_of_type_Boolean) {
          break label552;
        }
        j = 1;
        ((StringBuilder)localObject1).append(j);
        localStringBuilder.append("}");
        if (k != 12) {
          break label557;
        }
        l = localutx.a(localutx.jdField_e_of_type_JavaLangString);
        wta.a("msg_tab", "clk_story", 0, 0, new String[] { localutx.jdField_a_of_type_Int + ":" + localutx.jdField_e_of_type_JavaLangString + ":" + l, localObject2, localStringBuilder.toString(), localutx.jdField_a_of_type_JavaLangString });
      }
      switch (k)
      {
      }
    } while (localutx == null);
    label275:
    if (QLog.isDevelopLevel()) {
      QLog.e(jdField_i_of_type_JavaLangString, 2, "发现一个野生的类型: " + localutx.jdField_a_of_type_Int);
    }
    while (localutx != null)
    {
      paramView = new uuz();
      paramView.jdField_c_of_type_Int = localutx.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_JavaLangString = localutx.jdField_a_of_type_JavaLangString;
      paramView.jdField_b_of_type_Long = localutx.jdField_e_of_type_Long;
      localutx.jdField_c_of_type_Boolean = false;
      ung.a().a(paramView, null);
      if (localutx.jdField_b_of_type_Int > 0) {
        ((urk)urr.a(10)).b("key_force_refresh_msg_node_list", Boolean.valueOf(true));
      }
      this.jdField_a_of_type_Uvy.notifyItemChanged(paramInt);
      wsv.a(jdField_i_of_type_JavaLangString, "onItemClick, unionId:%s", paramView.jdField_b_of_type_JavaLangString);
      return;
      localObject1 = "1";
      break label87;
      label544:
      localObject2 = "1";
      break label100;
      label552:
      j = 0;
      break label158;
      label557:
      wta.a("msg_tab", "clk_story", 0, 0, new String[] { localutx.jdField_a_of_type_Int + "", localObject2, localStringBuilder.toString(), localutx.jdField_a_of_type_JavaLangString });
      break label275;
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a();
      if (localObject1 == null)
      {
        paramView = null;
        if (!TextUtils.isEmpty(paramView)) {
          break label885;
        }
        localObject1 = xlb.a();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("entrance_type", 103);
        ((Bundle)localObject2).putInt("report_entrance_type", 1);
        if (!(localObject3 instanceof Activity)) {
          break label873;
        }
        localObject3 = (Activity)localObject3;
        ((xlb)localObject1).a((Activity)localObject3, (Bundle)localObject2, 0);
        ((Activity)localObject3).overridePendingTransition(2130772232, 2130772038);
        label715:
        localObject1 = new StringBuilder("{");
        ((StringBuilder)localObject1).append("\"text\":").append("\"").append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
        ((StringBuilder)localObject1).append(",\"jumpUrl\":").append("\"").append(paramView).append("\"");
        paramView = ((StringBuilder)localObject1).append(",\"msg\":");
        if (localutx == null) {
          break label1044;
        }
        if (!localutx.jdField_c_of_type_Boolean) {
          break label1039;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramView.append(paramInt);
        ((StringBuilder)localObject1).append("}");
        wta.a("msg_tab", "clk_story", 0, 0, new String[] { "1", "", ((StringBuilder)localObject1).toString(), "" });
        return;
        paramView = ((uuv)localObject1).jdField_c_of_type_JavaLangString;
        break;
        label873:
        ((xlb)localObject1).a((Context)localObject3, (Bundle)localObject2);
        break label715;
        label885:
        xoj.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, paramView, true);
        if (!((uuv)localObject1).jdField_a_of_type_Boolean) {
          break label715;
        }
        localObject3 = ((uur)QQStoryContext.a().getManager(252)).a();
        if ((localObject3 != null) && (TextUtils.equals(((uuv)localObject1).jdField_d_of_type_JavaLangString, ((uuv)localObject3).jdField_d_of_type_JavaLangString)))
        {
          ((uuv)localObject3).jdField_b_of_type_Boolean = true;
          urk.f(true);
          wsv.b("Q.qqstory.config.takevideo", "onItemClick configId=%s", ((uuv)localObject1).jdField_d_of_type_JavaLangString);
          localObject1 = new uuw();
          uht.a().dispatch((Dispatcher.Dispatchable)localObject1);
          break label715;
        }
        ((uuv)localObject1).jdField_b_of_type_Boolean = true;
        localObject2 = ((uuv)localObject1).jdField_d_of_type_JavaLangString;
        if (localObject3 == null) {}
        for (localObject1 = "";; localObject1 = ((uuv)localObject3).jdField_d_of_type_JavaLangString)
        {
          wsv.b("Q.qqstory.config.takevideo", "onItemClick oldId=%s, newId=%s", localObject2, localObject1);
          break;
        }
        label1039:
        paramInt = 0;
        continue;
        label1044:
        paramInt = 0;
      }
      if ((localutx != null) && (!xod.b()))
      {
        wsv.b(jdField_i_of_type_JavaLangString, "onItemClick(), unionId=%s, videoCover=%s", localutx.jdField_a_of_type_JavaLangString, localutx.jdField_g_of_type_JavaLangString);
        a(paramView, (Activity)localObject3, localutx);
        continue;
        if ((localutx != null) && (!xod.b()))
        {
          wsv.b(jdField_i_of_type_JavaLangString, "onItemClick(), unionId=%s, videoCover=%s, vid=%s", localutx.jdField_a_of_type_JavaLangString, localutx.jdField_g_of_type_JavaLangString, localutx.jdField_e_of_type_JavaLangString);
          localutx.jdField_a_of_type_JavaUtilList.clear();
          a(paramView, (Activity)localObject3, localutx);
          continue;
          if (((localObject3 instanceof Activity)) && (localutx != null) && (!TextUtils.isEmpty(localutx.jdField_e_of_type_JavaLangString)))
          {
            localObject1 = this.jdField_a_of_type_Uvy.a();
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localObject1 = new OpenPlayerBuilder(new VidListPlayInfo("", localutx.jdField_e_of_type_JavaLangString), 107).a().d();
              vju.a((Activity)localObject3, ((OpenPlayerBuilder)localObject1).a(), paramView);
              localutx.jdField_b_of_type_Int = 0;
              if (this.jdField_a_of_type_Uvz != null) {
                this.jdField_a_of_type_Uvz.a(localutx);
              }
              uxq.b(localutx);
            }
            uxq.b(localutx);
            continue;
            wta.a("home_page-exp-d4", "5");
            ((Context)localObject3).startActivity(StoryTransitionActivity.a((Context)localObject3));
            continue;
            ((Context)localObject3).startActivity(StoryMessageListActivity.a((Context)localObject3, "1", 3));
            continue;
            if (localutx == null) {
              break;
            }
            xoj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localutx.jdField_d_of_type_JavaLangString, true);
            localutx.jdField_b_of_type_Int = 0;
            if (this.jdField_a_of_type_Uvz != null) {
              this.jdField_a_of_type_Uvz.a(localutx);
            }
            uxq.b(localutx);
          }
        }
      }
    }
  }
  
  public void a(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_i_of_type_JavaLangString, 2, paramDrawerFrame + " initLater " + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(this);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.d();
    this.jdField_a_of_type_Uvz.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avqs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aljr);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a != null))
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      localRecyclerView.setScrollX(0);
      ((LinearLayoutManager)localRecyclerView.getLayoutManager()).scrollToPosition(0);
      wsv.b(jdField_i_of_type_JavaLangString, "onAccountChanged set Scroll to 0!");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Avqs);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Aljr);
      jdField_h_of_type_Boolean = paramQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("isFriendlistok", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getListViewScrollY() == 0))
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setScrollY(-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = true;
      this.jdField_f_of_type_Int = 3;
      a(true);
      b(true);
      o();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.f();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      this.jdField_a_of_type_Uwx.a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    wsv.c(jdField_i_of_type_JavaLangString, "MsgTab launch()");
    this.jdField_a_of_type_Uwx = new uwx();
    xmh.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.indexOfChild(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView) >= 0) {
        break label337;
      }
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131375532);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.addView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView, (ViewGroup.LayoutParams)localObject);
      b(false);
      a(false);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setMaxOverScrollTopDistance(70);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setQQStoryListViewListener(this);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory = true;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(this);
      }
      this.jdField_a_of_type_Uvz.b();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      localObject = (urk)urr.a(10);
      this.jdField_d_of_type_Boolean = ((Boolean)((urk)localObject).b("first_show_node", Boolean.valueOf(true))).booleanValue();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.addOnLayoutChangeListener(new uwv(this, (urk)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Avqs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aljr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Uhn);
      jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("isFriendlistok", false);
      a();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(true, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.c(false);
      return;
      label337:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 2, "mChatTopRefresh already added msgNodeView " + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onScrollStateChanged:" + paramInt + ",mode:" + this.jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(View paramView, int paramInt)
  {
    int j = this.jdField_a_of_type_Uvy.getItemViewType(paramInt);
    String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
    utx localutx = (utx)this.jdField_a_of_type_Uvy.a(paramInt);
    if (localutx == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
        this.jdField_a_of_type_Bhpy.dismiss();
      }
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    int k = arrayOfString.length;
    j = 0;
    label96:
    if (j < k)
    {
      paramView = arrayOfString[j];
      if ((!jdField_d_of_type_JavaLangString.equals(paramView)) && (!jdField_e_of_type_JavaLangString.equals(paramView))) {
        break label303;
      }
      QQUserUIItem localQQUserUIItem = ((usd)urr.a(2)).b(localutx.jdField_a_of_type_JavaLangString);
      if (localQQUserUIItem == null) {
        break label303;
      }
      if (localQQUserUIItem.isSubscribe()) {
        paramView = jdField_e_of_type_JavaLangString;
      }
    }
    label303:
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.a(new bhpx(paramView, paramInt, 0), 5);
      j += 1;
      break label96;
      paramView = jdField_d_of_type_JavaLangString;
      continue;
      this.jdField_a_of_type_Bhpy.c(2131690648);
      this.jdField_a_of_type_Bhpy.a(this);
      this.jdField_a_of_type_Bhpy.a(new uwo(this, localutx));
      this.jdField_a_of_type_Bhpy.show();
      if (localutx == null) {
        break;
      }
      wta.a("msg_tab", "press_story", 0, 0, new String[] { localutx.jdField_a_of_type_Int + "", "", "", localutx.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public void c()
  {
    wsv.c(jdField_i_of_type_JavaLangString, "MsgTab shutdown()");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.removeView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      b(true);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setMaxOverScrollTopDistance(30);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setQQStoryListViewListener(null);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.scrollTo(0, 0);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory = false;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(null);
      }
      this.jdField_a_of_type_Uvz.c();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      q();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avqs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aljr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Uhn);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.c(true);
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        azlf.a(xny.b("QQStoryMsgTabShutdown, Null", localNullPointerException), "QQStoryMsgTabShutdown NullPointerException");
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Uvz != null)
    {
      wsv.b(jdField_i_of_type_JavaLangString, "updateAllFriendNodeItems()");
      this.jdField_a_of_type_Uvz.a(6);
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerStartMoving");
    }
    q();
  }
  
  public void g()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerOpened");
    }
    q();
  }
  
  public int getMode()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f1 = paramARMapHongBaoListView.getScrollY();
    if (this.jdField_f_of_type_Int == 1) {
      return 0;
    }
    if (this.jdField_f_of_type_Int == 3) {
      return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
    }
    if (this.jdField_f_of_type_Int == 2) {
      return -paramARMapHongBaoListView.getOverScrollHeight();
    }
    return (int)f1;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (getMode() == 1))
    {
      wsv.b(jdField_i_of_type_JavaLangString, "startBreath() show breathView");
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
      wta.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    wsv.a(jdField_i_of_type_JavaLangString, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory), Integer.valueOf(getMode()));
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setScrollY(0);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      a(false);
      b(false);
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (b()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a(paramView, paramMotionEvent);
    }
    paramMotionEvent = jdField_i_of_type_JavaLangString;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
        break label75;
      }
      label40:
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
        break label81;
      }
    }
    label75:
    label81:
    for (paramView = "null";; paramView = Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getScrollY()))
    {
      wsv.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label40;
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Uvy.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.b();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.c();
  }
  
  public void k()
  {
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerClosed");
    }
  }
  
  public void l()
  {
    this.jdField_f_of_type_Boolean = true;
    AbstractGifImage.resumeAll();
    if ((this.jdField_a_of_type_Uvy != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Uvy.notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onResume");
    }
    s();
  }
  
  public void m()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onPause");
    }
    q();
    AbstractGifImage.pauseAll();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onPause");
    }
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null))
    {
      if (paramInt1 == 2) {
        a(paramInt2, false);
      }
      if (paramInt2 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      }
    }
    else
    {
      return;
    }
    if ((!this.jdField_i_of_type_Boolean) && (paramInt2 >= 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 4, "fight...onFlingScrollHeader1..scrollY = " + paramInt2 + ",flag = " + this.jdField_i_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.c(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 4, "fight...onFlingScrollHeader2..scrollY = " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(paramInt2);
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Float == 0.0F) {
      this.jdField_e_of_type_Float = (-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
    }
    float f1 = paramARMapHongBaoListView.getScrollY();
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
        } while (this.jdField_f_of_type_Int != 1);
        this.jdField_i_of_type_Boolean = true;
        a(false);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
        return;
        if ((!this.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Int == 1))
        {
          this.jdField_i_of_type_Boolean = true;
          a(false);
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
        }
        if ((f1 <= 0.0F) && (this.jdField_f_of_type_Int == 1))
        {
          a(f1, true);
          return;
        }
      } while (f1 >= 0.0F);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 4, "fight...onTouchMoving.onMove..scrollY = " + f1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(f1);
      return;
    }
    this.jdField_i_of_type_Boolean = false;
    this.jdField_g_of_type_Int = this.jdField_f_of_type_Int;
    if (f1 >= 0.0F)
    {
      if (paramARMapHongBaoListView.mForStory) {
        p();
      }
      this.jdField_f_of_type_Int = 1;
      paramARMapHongBaoListView.mForStory = false;
    }
    for (;;)
    {
      b(paramARMapHongBaoListView.mForStory);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 4, "fight...onTouchMoving.onUp..scrollY = " + f1);
      }
      if (f1 < 0.0F) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Ajbm.a(false, this.jdField_c_of_type_Float);
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131375536);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(alpo.a(2131707340)))) {}
          for (this.jdField_f_of_type_Int = 3;; this.jdField_f_of_type_Int = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            wsv.b(jdField_i_of_type_JavaLangString, "story node start refresh onTouchMoving");
          }
        }
        if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.jdField_f_of_type_Int = 1;
          paramARMapHongBaoListView.mForStory = false;
          p();
        }
      }
      else if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        if (this.jdField_f_of_type_Int != 2)
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          n();
        }
      }
      else if (f1 <= this.jdField_b_of_type_Float)
      {
        if (this.jdField_f_of_type_Int == 2)
        {
          a(false);
        }
        else
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          n();
        }
      }
      else
      {
        this.jdField_f_of_type_Int = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onViewCompleteAfterRefresh, mode:" + this.jdField_f_of_type_Int);
    }
    if (this.jdField_f_of_type_Int == 2) {
      if (paramARMapHongBaoListView.mForStory)
      {
        this.jdField_f_of_type_Int = 3;
        j = -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
      }
    }
    while (this.jdField_f_of_type_Int != 3)
    {
      return j;
      this.jdField_f_of_type_Int = 1;
      return 0;
    }
    return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */