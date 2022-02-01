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

public class wyd
  implements almi, blia, bliz, wrm, wrn
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
  Context jdField_a_of_type_AndroidContentContext;
  DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  View jdField_a_of_type_AndroidViewView;
  private antg jdField_a_of_type_Antg = new wyh(this);
  protected ayxm a;
  blir jdField_a_of_type_Blir;
  blrr jdField_a_of_type_Blrr;
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
  private final wjd jdField_a_of_type_Wjd = new wyi(this);
  wxo jdField_a_of_type_Wxo;
  wxp jdField_a_of_type_Wxp;
  public wyn a;
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
    jdField_a_of_type_JavaLangString = anzj.a(2131705853);
    jdField_b_of_type_JavaLangString = anzj.a(2131705857);
    jdField_c_of_type_JavaLangString = anzj.a(2131705855);
    jdField_d_of_type_JavaLangString = anzj.a(2131705862);
    jdField_e_of_type_JavaLangString = anzj.a(2131705854);
    jdField_f_of_type_JavaLangString = anzj.a(2131705858);
    jdField_g_of_type_JavaLangString = anzj.a(2131705859);
    jdField_h_of_type_JavaLangString = anzj.a(2131705861);
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
  
  public wyd(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 1;
    this.jdField_a_of_type_Ayxm = new wyg(this);
    this.jdField_a_of_type_JavaLangRunnable = new MsgTabStoryNodeListManager.11(this);
    znw.a(paramPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = paramPullRefreshHeader;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = paramBreathEffectView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131378038);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView = ((DotAnimationView)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131365684));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)this.jdField_a_of_type_AndroidContentContext.getSystemService("vibrator"));
    this.jdField_a_of_type_Wxo = new wxo(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView = new MsgNodeShotView(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView;
    q();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.setLayoutParams(new RecyclerView.LayoutParams(agej.a(67.0F, this.jdField_b_of_type_AndroidViewView.getResources()), agej.a(102.0F, this.jdField_b_of_type_AndroidViewView.getResources())));
    this.jdField_a_of_type_Wxo.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView);
    this.jdField_a_of_type_Wxo.a(this);
    this.jdField_a_of_type_Wxo.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setAdapter(this.jdField_a_of_type_Wxo);
    this.jdField_a_of_type_Wxp = new wxp(this, this.jdField_a_of_type_Wxo, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setOnScrollListener(new wyj(this));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new wyk(this);
    this.jdField_b_of_type_Float = zps.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_c_of_type_Float = zps.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_d_of_type_Float = zps.a(this.jdField_a_of_type_AndroidContentContext, -120.0F);
    this.jdField_d_of_type_Int = zps.a(this.jdField_a_of_type_AndroidContentContext, -80.0F);
    this.jdField_e_of_type_Int = zps.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
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
        if (paramFloat <= zps.a(this.jdField_a_of_type_AndroidContentContext, -75.0F)) {
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
    Object localObject = new yed("mainHallConfig");
    String str;
    if ((!TextUtils.isEmpty(((yed)localObject).jdField_c_of_type_JavaLangString)) && (nnr.a(((yed)localObject).jdField_c_of_type_JavaLangString)))
    {
      str = ((yed)localObject).jdField_c_of_type_JavaLangString;
      if ((((yed)localObject).jdField_a_of_type_Int != 0) && (((yed)localObject).jdField_a_of_type_Int != 1)) {
        break label85;
      }
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      paramContext.startActivity((Intent)localObject);
    }
    label85:
    while ((((yed)localObject).jdField_a_of_type_Int == 2) || (((yed)localObject).jdField_a_of_type_Int != 3))
    {
      return;
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
      break;
    }
  }
  
  private void a(View paramView, Activity paramActivity, wvn paramwvn)
  {
    if (paramwvn.jdField_a_of_type_Int == 12)
    {
      paramwvn.jdField_i_of_type_JavaLangString = "";
      paramwvn = new OpenPlayerBuilder(new MsgTabPlayInfo(paramwvn.jdField_a_of_type_JavaLangString, 0, null, paramwvn.jdField_f_of_type_JavaLangString, paramwvn.jdField_e_of_type_JavaLangString), 106);
      paramwvn.a(a());
      paramwvn = paramwvn.a();
      paramwvn.mUIStyle.bottomWidgetShowFlag = 3;
      if ((paramView instanceof StoryMsgNodeFrameLayout))
      {
        xlj.a(paramActivity, paramwvn, ((StoryMsgNodeFrameLayout)paramView).a);
        return;
      }
      xlj.a(paramActivity, paramwvn, paramView);
      return;
    }
    wwd localwwd = new wwd(jdField_i_of_type_JavaLangString);
    localwwd.jdField_a_of_type_Boolean = true;
    Stream.of(paramwvn).map(new ThreadOffFunction(jdField_i_of_type_JavaLangString, 2)).map(localwwd).map(new wvq(paramwvn)).map(new UIThreadOffFunction(null)).subscribe(new wym(this, paramwvn, paramView, paramActivity));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(true, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.c(false);
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView.getTranslationY() != this.jdField_d_of_type_Int) {
      this.jdField_b_of_type_AndroidViewView.setTranslationY(this.jdField_d_of_type_Int);
    }
    if (this.jdField_b_of_type_AndroidViewView.getAlpha() != 0.0F) {
      a(0.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.c(true);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131376439);
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
      yuk.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!e())
    {
      yuk.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_Blrr == null)
    {
      yuk.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = blrr.a(this.jdField_a_of_type_AndroidContentContext).a(true).a(anzj.a(2131705860)).a(16.0F).b(5).a(-1);
      ((blrs)localObject).c(50);
      this.jdField_a_of_type_Blrr = new blrt((blrs)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.jdField_a_of_type_Blrr.a(82);
      this.jdField_a_of_type_Blrr.a(new wyf(this));
    }
    if (!this.jdField_a_of_type_Blrr.isShowing())
    {
      this.jdField_a_of_type_Blrr.c(this.jdField_a_of_type_AndroidViewView, agej.a(7.0F, this.jdField_b_of_type_AndroidViewView.getResources()), agej.a(-5.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      yuk.a(jdField_i_of_type_JavaLangString, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.jdField_a_of_type_Wxp.a.a(xiz.a().getCurrentAccountUin(), "8.4.5".replace(".", ""));
      yup.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.jdField_c_of_type_Boolean = false;
      ((wta)wth.a(10)).b("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    yuk.b(jdField_i_of_type_JavaLangString, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { this.jdField_a_of_type_AndroidViewView, Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_g_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(f()), Boolean.valueOf(false) });
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
        if (this.jdField_a_of_type_Wxo != null) {
          if (((LinearLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() != 0) {
            break label64;
          }
        }
      }
    }
    label64:
    for (bool1 = true;; bool1 = false)
    {
      yuk.a(jdField_i_of_type_JavaLangString, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
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
      yuk.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.isShown()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean));
      bool1 = bool2;
      if (j >= 0)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    yuk.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private void m()
  {
    String str = jdField_i_of_type_JavaLangString;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      yuk.a(str, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(bool));
      yup.a("msg_tab", "show_story", 0, 0, new String[0]);
      n();
      this.jdField_a_of_type_Wxp.a("exp_story", 6);
      jdField_b_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_Boolean)) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
    bodt.a(BaseApplicationImpl.getContext());
  }
  
  private void o()
  {
    yup.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Blrr != null)
    {
      if (this.jdField_a_of_type_Blrr.isShowing())
      {
        this.jdField_a_of_type_Blrr.dismiss();
        yuk.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() dismiss");
      }
      for (;;)
      {
        this.jdField_a_of_type_Blrr = null;
        return;
        yuk.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() not showing, not need dismiss()");
      }
    }
    yuk.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() but mTipWindow is null");
  }
  
  private void q()
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
  
  private void r()
  {
    q();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.16(this));
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.dismiss();
    Object localObject = this.jdField_a_of_type_Blir.a(paramInt);
    if (localObject == null) {}
    wvn localwvn;
    do
    {
      return;
      localwvn = (wvn)this.jdField_a_of_type_Wxo.a(((bliq)localObject).jdField_c_of_type_Int);
    } while (localwvn == null);
    paramView = this.jdField_a_of_type_AndroidContentContext;
    localObject = ((bliq)localObject).jdField_a_of_type_JavaLangString;
    if (jdField_a_of_type_JavaLangString.equals(localObject)) {
      if ((6 == localwvn.jdField_a_of_type_Int) || (7 == localwvn.jdField_a_of_type_Int) || (9 == localwvn.jdField_a_of_type_Int) || (5 == localwvn.jdField_a_of_type_Int))
      {
        QQStoryMemoriesActivity.a(paramView, 26, localwvn.jdField_a_of_type_JavaLangString, false);
        paramView = "1";
      }
    }
    for (;;)
    {
      yup.a("msg_tab", "clk_press", 0, 0, new String[] { localwvn.jdField_a_of_type_Int + "", paramView, "", localwvn.jdField_a_of_type_JavaLangString });
      return;
      if (8 == localwvn.jdField_a_of_type_Int)
      {
        QQStoryShareGroupProfileActivity.a(paramView, 2, localwvn.jdField_a_of_type_JavaLangString, String.valueOf(localwvn.jdField_b_of_type_Long), 17, 0);
        break;
      }
      if (12 != localwvn.jdField_a_of_type_Int) {
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
        ((Intent)localObject).putExtra("uin", String.valueOf(localwvn.jdField_b_of_type_Long));
        ((Intent)localObject).putExtra("from", 3);
        paramView.startActivity((Intent)localObject);
        paramView = "3";
      }
      else if (jdField_g_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Wxp.b(localwvn);
        paramView = "7";
      }
      else if (jdField_d_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Wxp.a(localwvn, 0);
        paramView = "4";
      }
      else if (jdField_e_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_Wxp.a(localwvn, 1);
        paramView = "5";
      }
      else if ("debug info".equals(localObject))
      {
        Toast.makeText(paramView, localwvn.toString(), 1).show();
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
    ((wwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a().b();
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
    wvn localwvn;
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
      int k = this.jdField_a_of_type_Wxo.getItemViewType(paramInt);
      localwvn = (wvn)this.jdField_a_of_type_Wxo.a(paramInt);
      if (localwvn != null)
      {
        localObject1 = "";
        if (localwvn.jdField_a_of_type_Int == 5)
        {
          if (localwvn.jdField_d_of_type_Int <= 0) {
            break;
          }
          localObject1 = "2";
        }
        if (localwvn.jdField_b_of_type_Int != 0) {
          break label544;
        }
        localObject2 = "2";
        localStringBuilder = new StringBuilder("{");
        localStringBuilder.append("\"mystory\":").append("\"").append((String)localObject1).append("\"");
        localObject1 = localStringBuilder.append(",\"msg\":");
        if (!localwvn.jdField_c_of_type_Boolean) {
          break label552;
        }
        j = 1;
        ((StringBuilder)localObject1).append(j);
        localStringBuilder.append("}");
        if (k != 12) {
          break label557;
        }
        l = localwvn.a(localwvn.jdField_e_of_type_JavaLangString);
        yup.a("msg_tab", "clk_story", 0, 0, new String[] { localwvn.jdField_a_of_type_Int + ":" + localwvn.jdField_e_of_type_JavaLangString + ":" + l, localObject2, localStringBuilder.toString(), localwvn.jdField_a_of_type_JavaLangString });
      }
      switch (k)
      {
      }
    } while (localwvn == null);
    label275:
    if (QLog.isDevelopLevel()) {
      QLog.e(jdField_i_of_type_JavaLangString, 2, "发现一个野生的类型: " + localwvn.jdField_a_of_type_Int);
    }
    while (localwvn != null)
    {
      paramView = new wwp();
      paramView.jdField_c_of_type_Int = localwvn.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_JavaLangString = localwvn.jdField_a_of_type_JavaLangString;
      paramView.jdField_b_of_type_Long = localwvn.jdField_e_of_type_Long;
      localwvn.jdField_c_of_type_Boolean = false;
      wow.a().a(paramView, null);
      if (localwvn.jdField_b_of_type_Int > 0) {
        ((wta)wth.a(10)).b("key_force_refresh_msg_node_list", Boolean.valueOf(true));
      }
      this.jdField_a_of_type_Wxo.notifyItemChanged(paramInt);
      yuk.a(jdField_i_of_type_JavaLangString, "onItemClick, unionId:%s", paramView.jdField_b_of_type_JavaLangString);
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
      yup.a("msg_tab", "clk_story", 0, 0, new String[] { localwvn.jdField_a_of_type_Int + "", localObject2, localStringBuilder.toString(), localwvn.jdField_a_of_type_JavaLangString });
      break label275;
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a();
      if (localObject1 == null)
      {
        paramView = null;
        if (!TextUtils.isEmpty(paramView)) {
          break label885;
        }
        localObject1 = zmq.a();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("entrance_type", 103);
        ((Bundle)localObject2).putInt("report_entrance_type", 1);
        if (!(localObject3 instanceof Activity)) {
          break label873;
        }
        localObject3 = (Activity)localObject3;
        ((zmq)localObject1).a((Activity)localObject3, (Bundle)localObject2, 0);
        ((Activity)localObject3).overridePendingTransition(2130772242, 2130772039);
        label715:
        localObject1 = new StringBuilder("{");
        ((StringBuilder)localObject1).append("\"text\":").append("\"").append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
        ((StringBuilder)localObject1).append(",\"jumpUrl\":").append("\"").append(paramView).append("\"");
        paramView = ((StringBuilder)localObject1).append(",\"msg\":");
        if (localwvn == null) {
          break label1044;
        }
        if (!localwvn.jdField_c_of_type_Boolean) {
          break label1039;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramView.append(paramInt);
        ((StringBuilder)localObject1).append("}");
        yup.a("msg_tab", "clk_story", 0, 0, new String[] { "1", "", ((StringBuilder)localObject1).toString(), "" });
        return;
        paramView = ((wwl)localObject1).jdField_c_of_type_JavaLangString;
        break;
        label873:
        ((zmq)localObject1).a((Context)localObject3, (Bundle)localObject2);
        break label715;
        label885:
        zpy.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, paramView, true);
        if (!((wwl)localObject1).jdField_a_of_type_Boolean) {
          break label715;
        }
        localObject3 = ((wwh)QQStoryContext.a().getManager(252)).a();
        if ((localObject3 != null) && (TextUtils.equals(((wwl)localObject1).jdField_d_of_type_JavaLangString, ((wwl)localObject3).jdField_d_of_type_JavaLangString)))
        {
          ((wwl)localObject3).jdField_b_of_type_Boolean = true;
          wta.f(true);
          yuk.b("Q.qqstory.config.takevideo", "onItemClick configId=%s", ((wwl)localObject1).jdField_d_of_type_JavaLangString);
          localObject1 = new wwm();
          wjj.a().dispatch((Dispatcher.Dispatchable)localObject1);
          break label715;
        }
        ((wwl)localObject1).jdField_b_of_type_Boolean = true;
        localObject2 = ((wwl)localObject1).jdField_d_of_type_JavaLangString;
        if (localObject3 == null) {}
        for (localObject1 = "";; localObject1 = ((wwl)localObject3).jdField_d_of_type_JavaLangString)
        {
          yuk.b("Q.qqstory.config.takevideo", "onItemClick oldId=%s, newId=%s", localObject2, localObject1);
          break;
        }
        label1039:
        paramInt = 0;
        continue;
        label1044:
        paramInt = 0;
      }
      if ((localwvn != null) && (!zps.b()))
      {
        yuk.b(jdField_i_of_type_JavaLangString, "onItemClick(), unionId=%s, videoCover=%s", localwvn.jdField_a_of_type_JavaLangString, localwvn.jdField_g_of_type_JavaLangString);
        a(paramView, (Activity)localObject3, localwvn);
        continue;
        if ((localwvn != null) && (!zps.b()))
        {
          yuk.b(jdField_i_of_type_JavaLangString, "onItemClick(), unionId=%s, videoCover=%s, vid=%s", localwvn.jdField_a_of_type_JavaLangString, localwvn.jdField_g_of_type_JavaLangString, localwvn.jdField_e_of_type_JavaLangString);
          localwvn.jdField_a_of_type_JavaUtilList.clear();
          a(paramView, (Activity)localObject3, localwvn);
          continue;
          if (((localObject3 instanceof Activity)) && (localwvn != null) && (!TextUtils.isEmpty(localwvn.jdField_e_of_type_JavaLangString)))
          {
            localObject1 = this.jdField_a_of_type_Wxo.a();
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localObject1 = new OpenPlayerBuilder(new VidListPlayInfo("", localwvn.jdField_e_of_type_JavaLangString), 107).a().d();
              xlj.a((Activity)localObject3, ((OpenPlayerBuilder)localObject1).a(), paramView);
              localwvn.jdField_b_of_type_Int = 0;
              if (this.jdField_a_of_type_Wxp != null) {
                this.jdField_a_of_type_Wxp.a(localwvn);
              }
              wzg.b(localwvn);
            }
            wzg.b(localwvn);
            continue;
            yup.a("home_page-exp-d4", "5");
            ((Context)localObject3).startActivity(StoryTransitionActivity.a((Context)localObject3));
            continue;
            ((Context)localObject3).startActivity(StoryMessageListActivity.a((Context)localObject3, "1", 3));
            continue;
            if (localwvn == null) {
              break;
            }
            zpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localwvn.jdField_d_of_type_JavaLangString, true);
            localwvn.jdField_b_of_type_Int = 0;
            if (this.jdField_a_of_type_Wxp != null) {
              this.jdField_a_of_type_Wxp.a(localwvn);
            }
            wzg.b(localwvn);
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
    this.jdField_a_of_type_Wxp.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayxm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antg);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a != null))
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      localRecyclerView.setScrollX(0);
      ((LinearLayoutManager)localRecyclerView.getLayoutManager()).scrollToPosition(0);
      yuk.b(jdField_i_of_type_JavaLangString, "onAccountChanged set Scroll to 0!");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Ayxm);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Antg);
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
      n();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.f();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      this.jdField_a_of_type_Wyn.a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    yuk.c(jdField_i_of_type_JavaLangString, "MsgTab launch()");
    this.jdField_a_of_type_Wyn = new wyn();
    znw.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.indexOfChild(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView) >= 0) {
        break label337;
      }
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131376439);
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
      this.jdField_a_of_type_Wxp.b();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      localObject = (wta)wth.a(10);
      this.jdField_d_of_type_Boolean = ((Boolean)((wta)localObject).b("first_show_node", Boolean.valueOf(true))).booleanValue();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.addOnLayoutChangeListener(new wyl(this, (wta)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayxm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wjd);
      jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("isFriendlistok", false);
      a();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(true, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.c(false);
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
    int j = this.jdField_a_of_type_Wxo.getItemViewType(paramInt);
    String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
    wvn localwvn = (wvn)this.jdField_a_of_type_Wxo.a(paramInt);
    if (localwvn == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
        this.jdField_a_of_type_Blir.dismiss();
      }
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    int k = arrayOfString.length;
    j = 0;
    label96:
    if (j < k)
    {
      paramView = arrayOfString[j];
      if ((!jdField_d_of_type_JavaLangString.equals(paramView)) && (!jdField_e_of_type_JavaLangString.equals(paramView))) {
        break label303;
      }
      QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).b(localwvn.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_Blir.a(new bliq(paramView, paramInt, 0), 5);
      j += 1;
      break label96;
      paramView = jdField_d_of_type_JavaLangString;
      continue;
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(this);
      this.jdField_a_of_type_Blir.a(new wye(this, localwvn));
      this.jdField_a_of_type_Blir.show();
      if (localwvn == null) {
        break;
      }
      yup.a("msg_tab", "press_story", 0, 0, new String[] { localwvn.jdField_a_of_type_Int + "", "", "", localwvn.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public void c()
  {
    yuk.c(jdField_i_of_type_JavaLangString, "MsgTab shutdown()");
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
      this.jdField_a_of_type_Wxp.c();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      p();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayxm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wjd);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.c(true);
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        bdkh.a(zpn.b("QQStoryMsgTabShutdown, Null", localNullPointerException), "QQStoryMsgTabShutdown NullPointerException");
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wxp != null)
    {
      yuk.b(jdField_i_of_type_JavaLangString, "updateAllFriendNodeItems()");
      this.jdField_a_of_type_Wxp.a(6);
    }
  }
  
  public void e()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerStartMoving");
    }
    p();
  }
  
  public void f()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerOpened");
    }
    p();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (getMode() == 1))
    {
      yuk.b(jdField_i_of_type_JavaLangString, "startBreath() show breathView");
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
      yup.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    yuk.a(jdField_i_of_type_JavaLangString, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory), Integer.valueOf(getMode()));
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
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setScrollY(0);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      a(false);
      b(false);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Wxo.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.b();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.c();
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
      yuk.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label40;
    }
  }
  
  public void j()
  {
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerClosed");
    }
  }
  
  public void k()
  {
    this.jdField_f_of_type_Boolean = true;
    AbstractGifImage.resumeAll();
    if ((this.jdField_a_of_type_Wxo != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Wxo.notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onResume");
    }
    r();
  }
  
  public void l()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onPause");
    }
    p();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.c(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 4, "fight...onFlingScrollHeader2..scrollY = " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(paramInt2);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
        return;
        if ((!this.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Int == 1))
        {
          this.jdField_i_of_type_Boolean = true;
          a(false);
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(f1);
      return;
    }
    this.jdField_i_of_type_Boolean = false;
    this.jdField_g_of_type_Int = this.jdField_f_of_type_Int;
    if (f1 >= 0.0F)
    {
      if (paramARMapHongBaoListView.mForStory) {
        o();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_Aljw.a(false, this.jdField_c_of_type_Float);
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131376444);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(anzj.a(2131705850)))) {}
          for (this.jdField_f_of_type_Int = 3;; this.jdField_f_of_type_Int = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            yuk.b(jdField_i_of_type_JavaLangString, "story node start refresh onTouchMoving");
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
          o();
        }
      }
      else if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        if (this.jdField_f_of_type_Int != 2)
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          m();
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
          m();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyd
 * JD-Core Version:    0.7.0.1
 */