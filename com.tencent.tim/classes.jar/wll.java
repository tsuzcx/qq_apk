import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.11;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.12;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.18;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.4;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.7;
import com.tencent.mobileqq.activity.aio.IntimateInfoView.8;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView.a;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView.a;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonBody;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.c;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class wll
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, IntimateTitleSwitchView.a, IntimateScoreCardView.a, FeedListView.c, wxr
{
  private TextView HU;
  private TextView HV;
  private TextView HW;
  private TextView HX;
  private TextView HY;
  private TextView HZ;
  private TextView Ia;
  private TextView Ib;
  private TextView Ic;
  private TextView Id;
  private TextView Ie;
  private TextView If;
  private TextView Ig;
  private ausj K;
  private Long N;
  private aqju P;
  public String QE;
  acfd jdField_a_of_type_Acfd = new wlp(this);
  private ahpj jdField_a_of_type_Ahpj;
  ahpp jdField_a_of_type_Ahpp = new wlr(this);
  ajjl jdField_a_of_type_Ajjl;
  aqdf.a jdField_a_of_type_Aqdf$a = new wlq(this);
  private aqdf jdField_a_of_type_Aqdf;
  private awmh jdField_a_of_type_Awmh;
  private IntimateTitleSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView;
  private IntimateScoreCardView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  @Nullable
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private wlh jdField_a_of_type_Wlh;
  private wll.a jdField_a_of_type_Wll$a;
  private wll.b jdField_a_of_type_Wll$b;
  private wxw jdField_a_of_type_Wxw;
  protected yxd a;
  private String aTa;
  public boolean aqw;
  private int bPf;
  private int bPg;
  protected int bPh;
  private boolean bdU;
  private boolean bdV;
  private boolean bdW;
  public boolean bdX;
  private boolean bdY;
  private boolean bdZ;
  private final boolean bea;
  private boolean beb;
  private boolean bec;
  private int bvC = 1;
  @Nullable
  private BounceScrollView f;
  private arhz g;
  private LinearLayout gV;
  private View hY;
  private RelativeLayout hr;
  private HorizontalListView m;
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Context mContext;
  protected List<yvy> mDataList = new ArrayList();
  public String mFriendUin;
  private View mRootView;
  private Handler mUIHandler;
  private HorizontalListView n;
  private ImageView sf;
  private ImageView sg;
  private ImageView sh;
  private ImageView si;
  private ImageView sj;
  private URLDrawable t;
  private View wf;
  private View wg;
  private View wh;
  private View wi;
  private View wj;
  private View wk;
  private View wl;
  private View wm;
  private View wn;
  private View wo;
  private View wp;
  private View wq;
  
  public wll(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Yxd = new yxd();
    this.mApp = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mFriendUin = paramString;
    try
    {
      l = Long.parseLong(this.mFriendUin);
      Object localObject;
      if ((l > 0L) && (avsn.aLy()))
      {
        paramString = QzonePluginProxyActivity.a();
        localObject = new StringBuilder().append("IntimateInfoView: start to load qzone plugin ");
        if (paramString != null)
        {
          bool = true;
          QLog.i("IntimateInfoView", 1, bool);
          if (paramString != null) {
            break label1426;
          }
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramFragmentActivity, paramQQAppInterface));
          bool = false;
          paramString = null;
          if (!bool) {
            break label1518;
          }
        }
      }
      try
      {
        localObject = LayoutInflater.from(paramContext).inflate(2131559440, null);
        paramString = (String)localObject;
        this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)((View)localObject).findViewById(2131369335));
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          float f1;
          QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable);
          continue;
          this.bea = true;
          continue;
          String str = paramString;
          continue;
          this.f = ((BounceScrollView)paramString.findViewById(2131377766));
          this.f.setOverScrollMode(0);
          this.f.setEdgeEffectEnabled(false);
          this.f.setVerticalScrollBarEnabled(false);
        }
      }
      if ((paramString == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null))
      {
        paramString = LayoutInflater.from(paramContext).inflate(2131559437, null);
        this.bea = false;
        this.mRootView = paramString.findViewById(2131377565);
        this.hY = paramString.findViewById(2131379873);
        this.HU = ((TextView)paramString.findViewById(2131363226));
        this.HV = ((TextView)paramString.findViewById(2131379832));
        this.sf = ((ImageView)paramString.findViewById(2131371275));
        if (!this.bea) {
          break label1469;
        }
        localObject = LayoutInflater.from(paramContext).inflate(2131559438, null);
        this.sg = ((ImageView)((View)localObject).findViewById(2131377976));
        this.sh = ((ImageView)((View)localObject).findViewById(2131367682));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView = ((IntimateTitleSwitchView)((View)localObject).findViewById(2131369337));
        this.wf = ((View)localObject).findViewById(2131365090);
        this.wg = ((View)localObject).findViewById(2131365094);
        this.HW = ((TextView)((View)localObject).findViewById(2131365093));
        this.HX = ((TextView)((View)localObject).findViewById(2131365092));
        this.HY = ((TextView)((View)localObject).findViewById(2131365091));
        this.HZ = ((TextView)((View)localObject).findViewById(2131365096));
        this.wh = ((View)localObject).findViewById(2131376864);
        this.si = ((ImageView)((View)localObject).findViewById(2131376862));
        this.Ia = ((TextView)((View)localObject).findViewById(2131376863));
        this.Ib = ((TextView)((View)localObject).findViewById(2131376865));
        this.wl = ((View)localObject).findViewById(2131366251);
        this.wi = ((View)localObject).findViewById(2131367698);
        this.wj = ((View)localObject).findViewById(2131367696);
        this.Ic = ((TextView)((View)localObject).findViewById(2131367691));
        this.Id = ((TextView)((View)localObject).findViewById(2131367694));
        this.m = ((HorizontalListView)((View)localObject).findViewById(2131367697));
        this.sj = ((ImageView)((View)localObject).findViewById(2131369348));
        this.wk = ((View)localObject).findViewById(2131367668);
        this.gV = ((LinearLayout)((View)localObject).findViewById(2131367666));
        this.wo = ((View)localObject).findViewById(2131367677);
        this.wp = ((View)localObject).findViewById(2131367672);
        this.If = ((TextView)((View)localObject).findViewById(2131367673));
        this.n = ((HorizontalListView)((View)localObject).findViewById(2131367676));
        this.Ig = ((TextView)((View)localObject).findViewById(2131367675));
        this.wm = ((View)localObject).findViewById(2131370926);
        this.wn = ((View)localObject).findViewById(2131370923);
        this.Ie = ((TextView)((View)localObject).findViewById(2131370925));
        this.hr = ((RelativeLayout)((View)localObject).findViewById(2131371265));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView = ((IntimateScoreCardView)((View)localObject).findViewById(2131369350));
        this.wq = ((View)localObject).findViewById(2131367671);
        if (!this.bea) {
          break label1476;
        }
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView((View)localObject);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(paramQQAppInterface, paramFragmentActivity, l);
        this.bdU = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(paramQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setApp(paramQQAppInterface);
        this.HU.setOnClickListener(this);
        this.sf.setOnClickListener(this);
        this.wg.setOnClickListener(this);
        this.wh.setOnClickListener(this);
        this.wj.setOnClickListener(this);
        this.wk.setOnClickListener(this);
        this.wn.setOnClickListener(this);
        this.sg.setOnClickListener(this);
        this.sh.setOnClickListener(this);
        this.wl.setOnClickListener(this);
        this.jdField_a_of_type_Wll$b = new wll.b(null);
        this.m.setDividerWidth(aqnm.dip2px(5.0F));
        this.m.setOverScrollMode(2);
        this.m.setAdapter(this.jdField_a_of_type_Wll$b);
        this.jdField_a_of_type_Wll$a = new wll.a(null);
        this.n.setDividerWidth(aqnm.dip2px(5.0F));
        this.n.setAdapter(this.jdField_a_of_type_Wll$a);
        this.wp.setOnClickListener(this);
        this.HU.setOnTouchListener(this);
        this.sf.setOnTouchListener(this);
        this.wg.setOnTouchListener(this);
        this.wh.setOnTouchListener(this);
        this.wj.setOnTouchListener(this);
        this.wn.setOnTouchListener(this);
        this.wl.setOnTouchListener(this);
        this.sg.setOnTouchListener(this);
        this.sh.setOnTouchListener(this);
        this.m.setOnTouchListener(this);
        this.m.setTransTouchStateToParent(true);
        this.n.setOnTouchListener(this);
        this.n.setTransTouchStateToParent(true);
        this.wp.setOnTouchListener(this);
        if (AppSetting.enableTalkBack)
        {
          this.HU.setContentDescription(acfp.m(2131707458));
          this.sf.setContentDescription(acfp.m(2131707468));
          this.sh.setContentDescription(acfp.m(2131707473));
          this.sg.setContentDescription(acfp.m(2131707471));
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.hY.getLayoutParams();
          paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
          this.hY.setLayoutParams(paramQQAppInterface);
        }
        f1 = paramContext.getResources().getDisplayMetrics().density;
        wja.i(this.HY, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F));
        wja.i(this.HZ, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(f1 * 10.0F + 0.5F));
        paramQQAppInterface = new wls(this);
        paramFragmentActivity = new wlt(this);
        this.HY.setOnClickListener(paramFragmentActivity);
        this.HZ.setOnClickListener(paramQQAppInterface);
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l = 0L;
        continue;
        boolean bool = false;
        continue;
        label1426:
        bool = avsn.d(paramFragmentActivity, this.mApp);
        continue;
        bool = false;
        continue;
        label1469:
        label1476:
        label1518:
        paramString = null;
      }
    }
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i = ajnl.a(this.mApp, this.mFriendUin, paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
    if (i == 0) {
      return null;
    }
    Bitmap localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), i);
    if (localBitmap1 == null) {
      return null;
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    int j = localBitmap1.getHeight() + 32;
    i = j;
    if (paramPrefetchMutualMarkInfo.days > 0) {
      i = j * paramPrefetchMutualMarkInfo.currentDays / paramPrefetchMutualMarkInfo.days;
    }
    i = 16 + localBitmap1.getHeight() - i;
    paramPrefetchMutualMarkInfo = new Rect(0, 0, localBitmap1.getWidth(), i);
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, localPaint);
    paramPrefetchMutualMarkInfo = new Rect(0, i, localBitmap1.getWidth(), localBitmap1.getHeight());
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
    return localBitmap2;
  }
  
  private String a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo, boolean paramBoolean)
  {
    paramPrefetchMutualMarkInfo = "intimate_" + paramPrefetchMutualMarkInfo.type + paramPrefetchMutualMarkInfo.level + paramPrefetchMutualMarkInfo.days + paramPrefetchMutualMarkInfo.currentDays + paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "cacheName" + paramPrefetchMutualMarkInfo);
    }
    return paramPrefetchMutualMarkInfo;
  }
  
  private void a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("getPrefetchMarkIcon, type=%s, currDay=%s, day=%s", new Object[] { Integer.valueOf(paramPrefetchMutualMarkInfo.type), Integer.valueOf(paramPrefetchMutualMarkInfo.currentDays), Integer.valueOf(paramPrefetchMutualMarkInfo.days) }));
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.18(this, paramPrefetchMutualMarkInfo));
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "updateIntimateInfo: " + paramIntimateInfo);
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.bPf = paramIntimateInfo.maskType;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    int i;
    label374:
    int k;
    if (paramIntimateInfo.beFriendDays >= -1) {
      if (this.bPf == 3)
      {
        this.bvC = 4;
        this.wm.setVisibility(8);
        this.sf.setVisibility(0);
        fm(this.bPf, paramIntimateInfo.maskLevel);
        this.bdW = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a(paramIntimateInfo, this.bPf);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setData(paramIntimateInfo, this.bPf);
        if (paramIntimateInfo.memoryDayInfoList != null)
        {
          AbstractGifImage.resumeAll();
          if (this.jdField_a_of_type_Wxw == null)
          {
            this.jdField_a_of_type_Wxw = new wxw(this.mContext, this.mFriendUin);
            this.jdField_a_of_type_Wxw.a(new wlu(this));
          }
          localObject1 = new ArrayList(paramIntimateInfo.memoryDayInfoList);
          this.jdField_a_of_type_Wxw.f(this.mContext, (ArrayList)localObject1);
          if ((this.jdField_a_of_type_Wxw.k() != null) && (this.hr != null))
          {
            this.hr.removeAllViews();
            this.hr.addView(this.jdField_a_of_type_Wxw.k());
          }
        }
        if (this.bdX) {
          bZr();
        }
        if ((this.HV != null) && (this.jdField_a_of_type_Ajjl != null))
        {
          localObject3 = this.jdField_a_of_type_Ajjl.nD();
          localObject4 = (TroopManager)this.mApp.getManager(52);
          localObject1 = "";
          localObject2 = this.jdField_a_of_type_Ajjl.a();
          if (localObject2 != null) {
            localObject1 = ((ajjf)localObject2).getNickName();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = ((TroopManager)localObject4).getTroopMemberName((String)localObject3, this.mFriendUin);
          }
          this.HV.setText((CharSequence)localObject2);
        }
        if ((paramIntimateInfo.commonTroopInfoList == null) || (paramIntimateInfo.commonTroopInfoList.size() <= 0)) {
          break label950;
        }
        i = 1;
        if ((this.mDataList == null) || (this.mDataList.size() <= 0)) {
          break label955;
        }
        j = 1;
        label395:
        k = 0;
        localObject1 = this.mActivity.getResources().getString(2131695051);
        if (j != 0) {
          k = yyx.a(this.mApp, this.mFriendUin);
        }
        if (k == 2) {
          localObject1 = this.mActivity.getResources().getString(2131695050);
        }
        if ((i == 0) && (j == 0)) {
          break label1153;
        }
        this.wf.setVisibility(0);
        if (i == 0) {
          break label960;
        }
        this.HY.setVisibility(8);
        if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
        {
          i = paramIntimateInfo.commonTroopInfoList.size();
          this.HW.setText(String.valueOf(i));
          localObject2 = paramIntimateInfo.recentChatTroopInfo;
          this.si.setVisibility(8);
          this.Ia.setVisibility(8);
          this.Ib.setVisibility(8);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject2).troopUin)))
          {
            this.si.setVisibility(0);
            this.Ia.setVisibility(0);
            this.Ib.setVisibility(0);
            this.Ia.setText(((IntimateInfo.CommonTroopInfo)localObject2).troopName);
            this.Ib.setText(paramIntimateInfo.commonTroopTips);
            localObject2 = aqdj.a(this.mApp, 4, ((IntimateInfo.CommonTroopInfo)localObject2).troopCode);
            this.si.setImageDrawable((Drawable)localObject2);
          }
        }
        this.HZ.setVisibility(8);
        if (j != 0)
        {
          this.HZ.setVisibility(0);
          this.HZ.setText((CharSequence)localObject1);
          anot.a(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
        }
        if (this.bdX) {
          anot.a(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.bvC, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if ((paramIntimateInfo.markInfoList == null) || (paramIntimateInfo.markInfoList.size() <= 0)) {
        break label2032;
      }
      localObject2 = paramIntimateInfo.markInfoList.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
        if (!a((IntimateInfo.MutualMarkInfo)localObject3)) {
          break label2029;
        }
        ((ArrayList)localObject1).add(localObject3);
        i += 1;
      }
      if (this.bPf == 2)
      {
        this.bvC = 3;
        this.wm.setVisibility(8);
        this.sf.setVisibility(0);
        fm(this.bPf, paramIntimateInfo.maskLevel);
        this.bdW = true;
        break;
      }
      if (this.bPf == 1)
      {
        b(paramIntimateInfo);
        break;
      }
      this.bvC = 1;
      this.wm.setVisibility(8);
      this.sf.setVisibility(0);
      fm(0, paramIntimateInfo.maskLevel);
      this.bdW = false;
      break;
      fm(0, paramIntimateInfo.maskLevel);
      break;
      label950:
      i = 0;
      break label374;
      label955:
      j = 0;
      break label395;
      label960:
      this.HW.setVisibility(8);
      this.HX.setText(this.mActivity.getResources().getString(2131695053));
      localObject2 = (LinearLayout.LayoutParams)this.HX.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
      this.HX.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.wg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(10.0F, this.mActivity.getResources());
      this.wg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.HY.setVisibility(0);
      this.HY.setText((CharSequence)localObject1);
      this.HZ.setVisibility(8);
      this.wh.setVisibility(8);
      this.si.setVisibility(8);
      this.Ia.setVisibility(8);
      this.Ib.setVisibility(8);
      anot.a(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      continue;
      label1153:
      this.wf.setVisibility(8);
    }
    int j = i;
    if (this.bdX) {
      anot.a(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.bvC, 0, "", "", "", "");
    }
    label1419:
    label1441:
    label1488:
    label1501:
    label1897:
    label2029:
    label2032:
    for (j = i;; j = 0)
    {
      if ((paramIntimateInfo.prefetchMutualMarkInfoList != null) && (paramIntimateInfo.prefetchMutualMarkInfoList.size() > 0))
      {
        localObject2 = paramIntimateInfo.prefetchMutualMarkInfoList.iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IntimateInfo.MutualMarkInfo)((Iterator)localObject2).next();
          if (!a((IntimateInfo.MutualMarkInfo)localObject3)) {
            break label2020;
          }
          ((ArrayList)localObject1).add(localObject3);
          i += 1;
        }
        k = i;
        if (this.bdX) {
          anot.a(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.bvC, 0, "", "", "", "");
        }
      }
      for (k = i;; k = 0)
      {
        if (!((ArrayList)localObject1).isEmpty()) {
          if (j == 0)
          {
            this.Ic.setText(String.valueOf(k));
            this.Id.setText(this.mActivity.getResources().getString(2131695078));
            this.wi.setVisibility(0);
            this.jdField_a_of_type_Wll$b.setData((List)localObject1);
            this.m.setVisibility(0);
            this.bdZ = ajnk.bd(this.mApp);
            localObject1 = this.sj;
            if ((!paramIntimateInfo.isShowRedPoint) && (!this.bdZ)) {
              break label1826;
            }
            i = 0;
            ((ImageView)localObject1).setVisibility(i);
            if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
              break label1897;
            }
            this.wk.setVisibility(0);
            if (this.jdField_a_of_type_Ajjl != null) {
              break label1832;
            }
            this.gV.removeAllViews();
            localObject3 = paramIntimateInfo.dnaInfoList.iterator();
            i = 0;
            if (!((Iterator)localObject3).hasNext()) {
              break label1906;
            }
            localObject4 = (IntimateInfo.DNAInfo)((Iterator)localObject3).next();
            localObject1 = null;
            if (this.jdField_a_of_type_Ajjl != null) {
              localObject1 = this.jdField_a_of_type_Ajjl.cj();
            }
            if (localObject1 != null) {
              break label2017;
            }
            localObject1 = wxu.i(this.mContext);
          }
        }
        for (;;)
        {
          localObject2 = (TextView)((View)localObject1).findViewById(2131379870);
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131379752);
          ((TextView)localObject2).setText(((IntimateInfo.DNAInfo)localObject4).wording);
          if (((IntimateInfo.DNAInfo)localObject4).viceTitle != null)
          {
            localObject2 = new SpannableString(((IntimateInfo.DNAInfo)localObject4).viceTitle);
            if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject4).linkWording))
            {
              int i1 = ((IntimateInfo.DNAInfo)localObject4).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject4).linkWording);
              k = ((IntimateInfo.DNAInfo)localObject4).linkWording.length() + i1;
              j = i1;
              if (i1 < 0)
              {
                String str = ((IntimateInfo.DNAInfo)localObject4).viceTitle + ((IntimateInfo.DNAInfo)localObject4).linkWording;
                localObject2 = new SpannableString(str);
                j = ((IntimateInfo.DNAInfo)localObject4).viceTitle.length();
                k = str.length();
              }
              ((SpannableString)localObject2).setSpan(new wlv(this, (IntimateInfo.DNAInfo)localObject4), j, k, 33);
              localTextView.setText((CharSequence)localObject2);
              localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
          }
          for (;;)
          {
            localObject2 = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject2).topMargin = aqnm.dip2px(16.0F);
            this.gV.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            i += 1;
            break label1501;
            this.Ic.setText(String.valueOf(j));
            break;
            this.wi.setVisibility(8);
            this.m.setVisibility(8);
            break label1419;
            i = 8;
            break label1441;
            j = this.gV.getChildCount();
            i = 0;
            while (i < j)
            {
              localObject1 = this.gV.getChildAt(0);
              this.jdField_a_of_type_Ajjl.e(this.gV, (View)localObject1);
              i += 1;
            }
            break label1488;
            localTextView.setText((CharSequence)localObject2);
            continue;
            localTextView.setVisibility(8);
          }
          this.wk.setVisibility(8);
          label1906:
          c(paramIntimateInfo);
          IntimatePlayTogetherMiniGameCardView.a(this.mRootView, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
          if (this.bdX)
          {
            anot.a(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.bvC, 0, "", "", "", "");
            if (this.bvC == 2) {
              anot.a(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
            }
          }
          QLog.d("Intimatetest", 2, "ui ok");
          return;
        }
        break;
      }
      break;
    }
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (!ajnl.i(this.mApp, paramMutualMarkInfo.type)) {}
    int i;
    do
    {
      return false;
      int j = ajnl.a(this.mApp, this.mFriendUin, paramMutualMarkInfo.type, paramMutualMarkInfo.level);
      ajog localajog = ajnl.a(this.mApp, paramMutualMarkInfo.type);
      i = j;
      if (localajog != null)
      {
        i = j;
        if (localajog.cpu) {
          i = 0;
        }
      }
    } while ((TextUtils.isEmpty(paramMutualMarkInfo.icon_static_url)) && (i == 0));
    return true;
  }
  
  private void ath()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    try
    {
      this.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int j = wja.dp2px(45.0F, this.mContext.getResources());
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas1 = new Canvas(localBitmap);
    Object localObject = new RectF(0.0F, 0.0F, j, j);
    RectF localRectF = new RectF(2, 2, j - 2, j - 2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#E8E9F3"));
    localCanvas1.drawRoundRect((RectF)localObject, 14, 14, localPaint);
    localPaint.setColor(-1);
    localCanvas1.drawRoundRect(localRectF, 12, 12, localPaint);
    localObject = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas2 = new Canvas((Bitmap)localObject);
    localPaint.setColor(Color.parseColor("#F2F4F9"));
    localCanvas2.drawRoundRect(localRectF, 12, 12, localPaint);
    if (paramPrefetchMutualMarkInfo.days > 0) {}
    for (int i = paramPrefetchMutualMarkInfo.currentDays * j / paramPrefetchMutualMarkInfo.days;; i = j)
    {
      paramPrefetchMutualMarkInfo = new Rect(0, j - i, j, j);
      localCanvas1.drawBitmap((Bitmap)localObject, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
      return localBitmap;
    }
  }
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {
      return;
    }
    this.bvC = 2;
    this.sf.setVisibility(0);
    if ((this.wm.getVisibility() == 8) && (this.aqw)) {
      bZp();
    }
    this.wm.setVisibility(0);
    aiwk.K("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.mApp));
    fm(this.bPf, paramIntimateInfo.maskLevel);
    if ((!this.bdV) && (this.aqw))
    {
      this.bdV = true;
      preloadWebProcess();
    }
    this.bdW = true;
  }
  
  private void bZl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("isIntimate" + this.bdW, new Object[0]));
    }
    anot.a(null, "dc00898", "", "", "0X800A119", "0X800A119", this.bvC, 0, "", "", "", "");
    this.K = ausj.d(this.mContext);
    String str = ajok.M(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str)) {
      this.K.addButton(2131695090, 0);
    }
    if (this.bdW) {
      this.K.addButton(2131695054, 3);
    }
    for (;;)
    {
      this.K.a(new wlw(this, str));
      this.K.addCancelButton(2131721058);
      this.K.show();
      return;
      this.K.addButton(2131695066, 0);
    }
  }
  
  private void bZm()
  {
    anot.a(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = ajok.mn(this.mFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      this.mActivity.startActivity(localIntent.putExtra("url", str));
    }
  }
  
  private void bZn()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing()))
    {
      QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
      return;
    }
    if (this.P == null) {
      this.P = aqha.a(this.mActivity, 230).setMessage(2131695058).setPositiveButton(2131695057, new wlo(this)).setNegativeButton(2131695056, new wln(this));
    }
    this.P.show();
  }
  
  private void bZq()
  {
    String str = ajok.M(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      xo(str);
      return;
    }
    QQToast.a(this.mActivity, 1, acfp.m(2131707459), 1).show();
  }
  
  private void bZr()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      Iterator localIterator;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.memoryDayInfoList != null)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.memoryDayInfoList.iterator();
        while (localIterator.hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)localIterator.next();
          if (!TextUtils.isEmpty(localMemoryDayInfo.linkWording))
          {
            anot.a(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A207");
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (localIterator.hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localIterator.next()).linkWording))
          {
            anot.a(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else
    {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  private void bZs()
  {
    if ((this.bea) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      if ((this.bPg == 3) || (this.bPg == 4)) {
        this.bec = true;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
  }
  
  private void bZv()
  {
    if ((this.mDataList == null) || (this.mDataList.isEmpty())) {
      return;
    }
    TroopWithCommonFriendsFragment.zo(this.mFriendUin);
    TroopWithCommonFriendsFragment.ac(this.mActivity, 2);
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    if ((this.jdField_a_of_type_Wll$a != null) && (paramIntimateInfo != null) && (paramIntimateInfo.commonBodyList != null) && (paramIntimateInfo.commonBodyList.size() > 0))
    {
      Iterator localIterator = paramIntimateInfo.commonBodyList.iterator();
      while (localIterator.hasNext())
      {
        IntimateInfo.CommonBody localCommonBody = (IntimateInfo.CommonBody)localIterator.next();
        if (localCommonBody.cmd == 3436)
        {
          paramIntimateInfo.friendGiftInfo = IntimateInfo.FriendGiftInfo.copyFrom(localCommonBody);
          if ((paramIntimateInfo.friendGiftInfo != null) && (paramIntimateInfo.friendGiftInfo.str_send_times > 0))
          {
            this.If.setText(String.valueOf(paramIntimateInfo.friendGiftInfo.str_send_times));
            this.Ig.setText(paramIntimateInfo.friendGiftInfo.str_desc);
            this.wo.setVisibility(0);
            if (paramIntimateInfo.friendGiftInfo.str_gift_url.size() > 6) {
              this.jdField_a_of_type_Wll$a.setData(paramIntimateInfo.friendGiftInfo.str_gift_url.subList(0, 6));
            }
            for (;;)
            {
              this.n.setVisibility(0);
              if (!this.bdX) {
                break;
              }
              anot.a(null, "dc00898", "", "", "0X800A3B3", "0X800A3B3", this.bvC, 0, "", "", "", "");
              break;
              this.jdField_a_of_type_Wll$a.setData(paramIntimateInfo.friendGiftInfo.str_gift_url);
            }
          }
          this.wo.setVisibility(8);
          this.n.setVisibility(8);
        }
      }
    }
  }
  
  private void cy(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!aqiw.isNetworkAvailable(this.mActivity)) {
        break label91;
      }
      if (this.jdField_a_of_type_Ahpj == null) {
        this.jdField_a_of_type_Ahpj = ((ahpj)this.mApp.getBusinessHandler(153));
      }
      this.jdField_a_of_type_Ahpj.cy(paramString, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, type: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return;
      label91:
      Message localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = this.mContext.getResources().getString(2131720447);
      this.mUIHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  private void fm(int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(this.mApp, true, null)) {}
    for (String str = ajok.L(paramInt1, paramInt2); (!TextUtils.isEmpty(this.aTa)) && (str.equals(this.aTa)); str = ajok.K(paramInt1, paramInt2)) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.mContext.getResources().getDrawable(2130841183);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
      }
      if (TextUtils.isEmpty(str)) {
        break;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aqnm.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = aqnm.getScreenHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.y);
      this.mRootView.setBackgroundDrawable((Drawable)localObject);
      this.aTa = str;
      return;
      if (paramInt1 == 2) {
        localObject = this.mContext.getResources().getDrawable(2130841181);
      } else if (paramInt1 == 1) {
        localObject = this.mContext.getResources().getDrawable(2130841185);
      } else {
        localObject = this.mContext.getResources().getDrawable(2130841189);
      }
    }
    this.mRootView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private Bitmap getFaceBitmap(String paramString)
  {
    if (this.jdField_a_of_type_Aqdf == null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(this.mContext, this.mApp);
      this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_Aqdf$a);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void h(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Wlh == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.12(this, paramURLDrawable));
      return;
    }
    this.jdField_a_of_type_Wlh.show();
  }
  
  private void preloadWebProcess()
  {
    WebProcessManager localWebProcessManager;
    if ((this.mActivity != null) && (this.mActivity.app != null))
    {
      localWebProcessManager = (WebProcessManager)this.mActivity.app.getManager(13);
      if (localWebProcessManager != null) {
        break label38;
      }
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.aFT());
      localWebProcessManager.egu();
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "start preloadWebProcess");
  }
  
  private void xo(String paramString)
  {
    anot.a(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.bvC, 0, "", "", "", "");
    if (this.t == null)
    {
      xq(this.mActivity.getResources().getString(2131695695));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.t = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.t.getStatus() == 1) || (this.t.getStatus() == 4))
    {
      ath();
      h(this.t);
      return;
    }
    this.t.setURLDrawableListener(new wlm(this));
    ThreadManager.getFileThreadHandler().post(new IntimateInfoView.11(this));
  }
  
  private void xp(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    awmf localawmf = new awmf();
    try
    {
      localawmf.aP(Long.parseLong(this.mApp.getCurrentUin()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString = this.mUIHandler.obtainMessage();
      paramString.what = 5;
      this.mUIHandler.sendMessage(paramString);
    }
  }
  
  private void xq(String paramString)
  {
    if (this.g == null)
    {
      this.g = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
      this.g.setBackAndSearchFilter(true);
    }
    this.g.setMessage(paramString);
    if ((this.g != null) && (!this.g.isShowing()) && (!this.mActivity.isFinishing())) {
      this.g.show();
    }
  }
  
  public void a(ajjf paramajjf, String paramString)
  {
    if (paramajjf == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.mFriendUin = paramajjf.getUin();
          this.QE = paramString;
        } while (paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
        if (this.mUIHandler == null) {
          this.mUIHandler = new Handler(this);
        }
        if (this.mApp != null)
        {
          this.mApp.addObserver(this.jdField_a_of_type_Ahpp);
          this.mApp.addObserver(this.jdField_a_of_type_Acfd);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        paramString = this.mUIHandler.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        this.mUIHandler.sendMessage(paramString);
        if (!this.bea) {
          break;
        }
      } while (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.scrollTo(0, 0);
      return;
    } while (this.f == null);
    this.f.scrollTo(0, 0);
  }
  
  public void a(ajjl paramajjl)
  {
    if (this.jdField_a_of_type_Ajjl != null)
    {
      this.jdField_a_of_type_Ajjl.dxS();
      this.jdField_a_of_type_Ajjl = null;
      if (this.mUIHandler != null) {
        this.mUIHandler.removeCallbacksAndMessages(null);
      }
    }
    setCurrentShowType(3);
    this.jdField_a_of_type_Ajjl = paramajjl;
    this.bdY = true;
  }
  
  public void bZe()
  {
    Bitmap localBitmap = getFaceBitmap(this.mApp.getCurrentAccountUin());
    if (localBitmap != null) {
      this.sg.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.mFriendUin))
    {
      localBitmap = getFaceBitmap(this.mFriendUin);
      if (localBitmap != null) {
        this.sh.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void bZf()
  {
    if ((!TextUtils.isEmpty(this.mFriendUin)) && (aqiw.isNetworkAvailable(this.mActivity)))
    {
      if (this.jdField_a_of_type_Ahpj == null) {
        this.jdField_a_of_type_Ahpj = ((ahpj)this.mApp.getBusinessHandler(153));
      }
      this.jdField_a_of_type_Ahpj.Ks(this.mFriendUin);
    }
  }
  
  /* Error */
  public void bZg()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 172	wll:mFriendUin	Ljava/lang/String;
    //   4: invokestatic 815	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +55 -> 62
    //   10: aload_0
    //   11: getfield 168	wll:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   14: invokestatic 1340	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
    //   17: ifeq +152 -> 169
    //   20: aload_0
    //   21: getfield 1342	wll:jdField_a_of_type_Ahpj	Lahpj;
    //   24: ifnonnull +20 -> 44
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 166	wll:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: sipush 153
    //   35: invokevirtual 1346	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   38: checkcast 1348	ahpj
    //   41: putfield 1342	wll:jdField_a_of_type_Ahpj	Lahpj;
    //   44: aload_0
    //   45: getfield 786	wll:jdField_a_of_type_Ajjl	Lajjl;
    //   48: ifnonnull +45 -> 93
    //   51: aload_0
    //   52: getfield 1342	wll:jdField_a_of_type_Ahpj	Lahpj;
    //   55: aload_0
    //   56: getfield 172	wll:mFriendUin	Ljava/lang/String;
    //   59: invokevirtual 1572	ahpj:Kr	(Ljava/lang/String;)V
    //   62: invokestatic 664	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +27 -> 92
    //   68: ldc_w 666
    //   71: iconst_2
    //   72: ldc_w 1574
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 172	wll:mFriendUin	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 693	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 670	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: new 139	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 140	java/util/ArrayList:<init>	()V
    //   100: astore 5
    //   102: aload_0
    //   103: getfield 172	wll:mFriendUin	Ljava/lang/String;
    //   106: invokestatic 1577	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   109: invokevirtual 1581	java/lang/Long:longValue	()J
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 1534	wll:QE	Ljava/lang/String;
    //   117: invokestatic 1577	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   120: invokevirtual 1581	java/lang/Long:longValue	()J
    //   123: lstore_1
    //   124: aload 5
    //   126: lload_3
    //   127: invokestatic 1584	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 911	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 1342	wll:jdField_a_of_type_Ahpj	Lahpj;
    //   138: lload_1
    //   139: aload 5
    //   141: aconst_null
    //   142: invokevirtual 1587	ahpj:a	(JLjava/util/ArrayList;Ljava/lang/Object;)V
    //   145: goto -83 -> 62
    //   148: astore 6
    //   150: lconst_0
    //   151: lstore_1
    //   152: ldc_w 666
    //   155: iconst_2
    //   156: ldc_w 1589
    //   159: invokestatic 1591	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: lload_1
    //   163: lstore_3
    //   164: lconst_0
    //   165: lstore_1
    //   166: goto -42 -> 124
    //   169: aload_0
    //   170: getfield 640	wll:mUIHandler	Landroid/os/Handler;
    //   173: invokevirtual 1357	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   176: astore 5
    //   178: aload 5
    //   180: iconst_1
    //   181: putfield 1362	android/os/Message:what	I
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 170	wll:mContext	Landroid/content/Context;
    //   190: invokevirtual 506	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   193: ldc_w 1363
    //   196: invokevirtual 837	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   199: putfield 1367	android/os/Message:obj	Ljava/lang/Object;
    //   202: aload_0
    //   203: getfield 640	wll:mUIHandler	Landroid/os/Handler;
    //   206: aload 5
    //   208: invokevirtual 1371	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   211: pop
    //   212: ldc_w 666
    //   215: iconst_1
    //   216: ldc_w 1593
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: getfield 172	wll:mFriendUin	Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 693	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokestatic 670	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: goto -174 -> 62
    //   239: astore 6
    //   241: lload_3
    //   242: lstore_1
    //   243: goto -91 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	wll
    //   123	120	1	l1	long
    //   112	130	3	l2	long
    //   100	107	5	localObject	Object
    //   148	1	6	localNumberFormatException1	NumberFormatException
    //   239	1	6	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   102	113	148	java/lang/NumberFormatException
    //   113	124	239	java/lang/NumberFormatException
  }
  
  public void bZh()
  {
    long l2;
    if (!TextUtils.isEmpty(this.mFriendUin))
    {
      if (!aqiw.isNetworkAvailable(this.mActivity)) {
        break label110;
      }
      l2 = 0L;
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.mFriendUin);
        yyx.a(l1, 1, this.mApp);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.mFriendUin }));
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.mFriendUin }));
        l1 = l2;
        continue;
      }
      label110:
      Message localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = this.mContext.getResources().getString(2131720447);
      this.mUIHandler.sendMessage(localMessage);
      QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.mFriendUin }));
    }
  }
  
  public void bZi()
  {
    if (this.jdField_a_of_type_Ajjl != null) {
      this.jdField_a_of_type_Ajjl.onBackEvent();
    }
    while (this.mActivity == null) {
      return;
    }
    this.mActivity.finish();
  }
  
  public void bZj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.7(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onScoreUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void bZk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
      ThreadManager.postImmediately(new IntimateInfoView.8(this), null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDaysUpdated: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
  
  public void bZo()
  {
    bZp();
  }
  
  public void bZp()
  {
    if ((this.wm.getVisibility() != 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType != 1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
    }
    if (this.jdField_a_of_type_Awmh == null) {
      this.jdField_a_of_type_Awmh = new awmh();
    }
    this.jdField_a_of_type_Awmh.nS(Long.parseLong(this.mApp.getCurrentAccountUin()));
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
  }
  
  public void bZt()
  {
    QLog.i("IntimateInfoView", 4, "onZoomIn: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {}
    do
    {
      return;
      if (this.bdU)
      {
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this.mApp, this.mActivity, Long.parseLong(this.mFriendUin));
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
        this.bdU = false;
        return;
      }
    } while (!this.bec);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this);
    this.bec = false;
  }
  
  public void bZu()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.RR();
    }
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.bea) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.h(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      do
      {
        do
        {
          return true;
          a((IntimateInfo)paramMessage.obj);
          return true;
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.mActivity, 1, paramMessage, 1).show();
          return true;
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.mActivity, 2, paramMessage, 1).show();
          return true;
          xq((String)paramMessage.obj);
          return true;
          ath();
          return true;
          ath();
          QQToast.a(this.mActivity, 2, 2131695059, 1).show();
          return true;
          bZg();
          QQToast.a(this.mActivity, 2, 2131695060, 1).show();
          return true;
        } while (this.Ie == null);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
        {
          Object localObject = (Object[])paramMessage.obj;
          paramMessage = (String)localObject[0];
          String str = (String)localObject[1];
          localObject = (String)localObject[2];
          paramMessage = String.format("<font color=\"#878B99\">" + paramMessage + " </font> <font color=\"#FF7EAE\">" + str + "</font>", new Object[0]);
          this.Ie.setText(Html.fromHtml(paramMessage));
          this.Ie.setTag(localObject);
          this.Ie.setVisibility(0);
          return true;
        }
        this.Ie.setVisibility(8);
        return true;
      } while (this.Ie == null);
      this.Ie.setVisibility(8);
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    return true;
  }
  
  public void initData()
  {
    if (this.mUIHandler == null) {
      this.mUIHandler = new Handler(this);
    }
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.4(this));
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.N != null) && (l - this.N.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.N = Long.valueOf(l);
      Object localObject1;
      Object localObject2;
      switch (paramView.getId())
      {
      case 2131367668: 
      default: 
        break;
      case 2131363226: 
        bZi();
        break;
      case 2131371275: 
        bZl();
        break;
      case 2131365094: 
        if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null))
        {
          CommonTroopListActivity.c(this.mActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.bvC);
          anot.a(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.bvC, 0, "", "", "", "");
        }
        else
        {
          bZv();
        }
        break;
      case 2131376864: 
        if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
          localObject2 = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
          ((Intent)localObject2).putExtra("uintype", 1);
          ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
          this.mActivity.startActivity((Intent)localObject2);
          anot.a(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.bvC, 0, "", "", "", "");
        }
        break;
      case 2131367696: 
        localObject1 = new Intent(this.mActivity, QQBrowserActivity.class);
        localObject2 = aelb.b().kj(this.mFriendUin);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject2 }));
        }
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("finish_animation_out_to_right", true);
        ((Intent)localObject1).putExtra("is_wrap_content", true);
        ((Intent)localObject1).putExtra("hide_left_button", false);
        if (this.mActivity != null) {
          this.mActivity.startActivity((Intent)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint)
        {
          bZf();
          this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint = false;
        }
        if (this.bdZ)
        {
          this.bdZ = false;
          ajnk.dt(this.mApp);
        }
        anot.a(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.bvC, 0, "", "", "", "");
        break;
      case 2131370923: 
        aiwk.a(this.mApp, this.mActivity, 2064, "2");
        anot.a(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
        break;
      case 2131367672: 
        localObject1 = new Intent(this.mActivity, QQBrowserActivity.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendGiftInfo.str_custom_url;
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, String.format("goToFriendGiftWebPage, url: %s", new Object[] { localObject2 }));
        }
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("finish_animation_out_to_right", true);
        ((Intent)localObject1).putExtra("is_wrap_content", true);
        ((Intent)localObject1).putExtra("hide_left_button", false);
        if (this.mActivity != null) {
          this.mActivity.startActivity((Intent)localObject1);
        }
        anot.a(null, "dc00898", "", "", "0X800A3B4", "0X800A3B4", this.bvC, 0, "", "", "", "");
        break;
      case 2131366251: 
        if (this.mActivity != null)
        {
          localObject1 = new Intent(this.mActivity, FriendProfileMoreInfoActivity.class);
          this.mActivity.startActivity((Intent)localObject1);
        }
        break;
      case 2131377976: 
        if (this.jdField_a_of_type_Ajjl == null)
        {
          localObject1 = new ProfileActivity.AllInOne(this.mApp.getCurrentAccountUin(), 0);
          ProfileActivity.b(this.mActivity, (ProfileActivity.AllInOne)localObject1);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Ajjl.nD();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            aldj.a(this.mApp, this.mContext, (String)localObject1, this.mApp.getCurrentAccountUin(), 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131367682: 
        if (this.jdField_a_of_type_Ajjl == null)
        {
          localObject1 = new ProfileActivity.AllInOne(this.mFriendUin, 1);
          ProfileActivity.b(this.mActivity, (ProfileActivity.AllInOne)localObject1);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_Ajjl.nD();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            aldj.a(this.mApp, this.mContext, (String)localObject1, this.mFriendUin, 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131365091: 
      case 2131365096: 
        bZv();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    }
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
    if (this.jdField_a_of_type_Wlh != null) {
      this.jdField_a_of_type_Wlh.onDestroy();
    }
    if (this.jdField_a_of_type_Wxw != null)
    {
      this.jdField_a_of_type_Wxw.clear();
      this.jdField_a_of_type_Wxw = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setApp(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setApp(null);
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onDestroy();
      this.bdU = true;
    }
    if (this.wq != null) {
      this.wq.setVisibility(8);
    }
  }
  
  public void onDrawerClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.onDrawerClosed();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.onDrawerClosed();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void onDrawerOpened()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.onDrawerOpened();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.onDrawerOpened();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void onPaused()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.onPaused();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.onPaused();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
  
  public void onResumed()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.onResumed();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.onResumed();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void setCurrentShowType(int paramInt)
  {
    boolean bool = true;
    QLog.i("IntimateInfoView", 4, "setCurrentShowType: " + paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.bPg);
    }
    this.bPg = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.setCurrentShowType(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView.setCurrentShowType(paramInt);
    if (!this.beb)
    {
      bZs();
      this.beb = true;
    }
    FeedListView localFeedListView;
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)
    {
      localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if ((paramInt == 3) || (paramInt == 4)) {
        break label139;
      }
    }
    for (;;)
    {
      localFeedListView.setLongClickValid(bool);
      return;
      label139:
      bool = false;
    }
  }
  
  public void xn(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateInfoView", 2, "onScoreCardActionClick strUrl:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("selfSet_leftViewText", acfp.m(2131708115));
      this.mContext.startActivity(localIntent);
    }
  }
  
  public void yA(boolean paramBoolean)
  {
    QLog.i("IntimateInfoView", 4, "onLoadOver: " + paramBoolean);
    if ((this.wq == null) || (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null)) {
      return;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.hp() > 0)
    {
      this.wq.setVisibility(0);
      return;
    }
    this.wq.setVisibility(8);
  }
  
  public void yx(boolean paramBoolean)
  {
    this.aqw = paramBoolean;
  }
  
  public void yy(boolean paramBoolean)
  {
    this.bdX = paramBoolean;
  }
  
  public void yz(boolean paramBoolean)
  {
    if (this.hY != null)
    {
      if (paramBoolean)
      {
        this.HU.setVisibility(0);
        this.sf.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.HU.setVisibility(4);
    this.sf.setVisibility(4);
  }
  
  class a
    extends BaseAdapter
  {
    private List<String> rB;
    
    private a() {}
    
    public int getCount()
    {
      if (this.rB == null) {
        return 0;
      }
      return this.rB.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.rB.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    @RequiresApi(api=16)
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = LayoutInflater.from(wll.this.mContext).inflate(2131559445, null);
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131367693);
        String str = (String)this.rB.get(paramInt);
        if (!TextUtils.isEmpty(str)) {}
        try
        {
          URLDrawable localURLDrawable = URLDrawable.getDrawable(str, null);
          localURLDrawable.setDecodeHandler(aqbn.y);
          localImageView.setImageDrawable(localURLDrawable);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("intimate_relationship", 1, String.format("Url for friend gift:" + str, new Object[] { localException }));
          }
        }
      }
    }
    
    public void setData(List<String> paramList)
    {
      this.rB = paramList;
      notifyDataSetChanged();
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private int bPi;
    private List<IntimateInfo.MutualMarkInfo> markInfoList;
    
    private b() {}
    
    public IntimateInfo.MutualMarkInfo a(int paramInt)
    {
      return (IntimateInfo.MutualMarkInfo)this.markInfoList.get(paramInt);
    }
    
    public int getCount()
    {
      if (this.markInfoList == null) {
        return 0;
      }
      if (this.markInfoList.size() > this.bPi) {
        return this.bPi;
      }
      return this.markInfoList.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    @RequiresApi(api=16)
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {}
      for (View localView = LayoutInflater.from(wll.this.mContext).inflate(2131559446, null);; localView = paramView)
      {
        ImageView localImageView = (ImageView)localView.findViewById(2131367693);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView;
        paramView = a(paramInt);
        if ((paramView instanceof IntimateInfo.PrefetchMutualMarkInfo))
        {
          paramView = (IntimateInfo.PrefetchMutualMarkInfo)paramView;
          wll.a(wll.this, paramView);
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
        }
        if (!TextUtils.isEmpty(paramView.icon_static_url)) {
          paramView = new ajns(wll.this.mContext, paramView.icon_static_url);
        }
        for (;;)
        {
          localImageView.setImageDrawable(paramView);
          localRelativeLayout.setBackgroundDrawable(wll.this.mActivity.getResources().getDrawable(2130841178));
          break;
          int i = ajnl.a(wll.this.mApp, wll.this.mFriendUin, paramView.type, paramView.level);
          if (i != 0) {
            paramView = new ajns(wll.this.mContext, i);
          } else {
            paramView = null;
          }
        }
      }
    }
    
    public void setData(List<IntimateInfo.MutualMarkInfo> paramList)
    {
      this.markInfoList = paramList;
      if (this.bPi == 0)
      {
        this.bPi = ((aqnm.getScreenWidth() - aqnm.dip2px(40.0F) - 80) / aqnm.dip2px(50.0F));
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, "friend mark max count: " + this.bPi);
        }
        if (this.bPi <= 0) {
          this.bPi = 6;
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wll
 * JD-Core Version:    0.7.0.1
 */