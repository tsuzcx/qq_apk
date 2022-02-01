import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.2;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.3;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.6;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.7;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.8;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.a;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class kfv
  implements KandianSubscribeManager.a
{
  public static TabChannelCoverInfo a;
  public static int aIs = 3;
  private static final int aIt = aqnm.dpToPx(0.0F);
  private static final int aIu = aqnm.dpToPx(0.0F);
  public static boolean aeG;
  private static boolean aeH = true;
  public static boolean aeI;
  private static HashMap<Integer, Long> de = new HashMap();
  private static HashMap<Integer, Long> df = new HashMap();
  private static HashMap<Integer, Integer> dg = new HashMap();
  private static HashMap<Integer, Boolean> dh = new HashMap();
  public static final long rT = awit.g(kxm.getAppRuntime());
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  private kfv.a jdField_a_of_type_Kfv$a;
  private lbz jdField_a_of_type_Lbz;
  private lcm.e jdField_a_of_type_Lcm$e = new kfz(this);
  private nhi jdField_a_of_type_Nhi;
  private int aIv = 1;
  private boolean aeJ;
  private Map<Integer, mgu> dF = new HashMap();
  private List<TabChannelCoverInfo> gc = new ArrayList();
  private List<TabChannelCoverInfo> gd = new ArrayList();
  private ImageView hT;
  private ImageView hU;
  private float iy = 0.4F;
  private float iz = 1.0F;
  private View jv;
  private View jw;
  private View jx;
  private int lastCenterPosition = 1;
  private Context mContext;
  private FragmentManager mFragmentManager;
  private boolean mHasRedPoint;
  private lce mObserver = new kga(this);
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new kgb(this);
  private HorizontalListView.d mOnScrollStateChangedListener;
  private int scrollState;
  
  public kfv(Context paramContext, View paramView, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager)
  {
    this.mContext = paramContext;
    this.jw = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = ((TabLayout)this.jw.findViewById(2131379167));
    this.hT = ((ImageView)this.jw.findViewById(2131369811));
    this.hU = ((ImageView)this.jw.findViewById(2131369878));
    this.jv = ((Activity)this.mContext).getWindow().getDecorView();
    aCx();
    init();
  }
  
  private void D(Map<Integer, mgu> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        mgu localmgu = (mgu)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localmgu.f;
        int j = kqo.aLl;
        if ((localmgu.f != null) && (localmgu.f.redPoint != null) && (localmgu.f.redPoint.isShow)) {}
        for (int i = localmgu.f.redPoint.type + 1;; i = 0)
        {
          kqo.a("0X8009495", localTabChannelCoverInfo, j, i, localmgu.aRE);
          break;
        }
      }
    }
  }
  
  private List<TabChannelCoverInfo> F(List<TabChannelCoverInfo> paramList)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (localTabChannelCoverInfo != null) {
        paramList.add(localTabChannelCoverInfo.clone());
      }
    }
    return paramList;
  }
  
  private List<TabChannelCoverInfo> G(List<TabChannelCoverInfo> paramList)
  {
    int j = 0;
    int m = paramList.size();
    List localList = F(this.gc);
    Iterator localIterator = localList.iterator();
    label99:
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label99;
        }
        if (localTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId)
        {
          localIterator.remove();
          break;
        }
        i += 1;
      }
    }
    int k = 0;
    int i = j;
    j = k;
    while (i <= m - 1)
    {
      localList.add(aIs + j, paramList.get(i));
      j += 1;
      i += 1;
    }
    return localList;
  }
  
  public static void G(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", paramString2, ", r5 = ", paramString3 });
    kbp.a(null, "", paramString1, paramString1, 0, 0, paramString2, "", "", paramString3, false);
  }
  
  private TabChannelCoverInfo a(int paramInt)
  {
    Iterator localIterator = this.gc.iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (localTabChannelCoverInfo.mChannelCoverId == paramInt) {
        return localTabChannelCoverInfo;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsTabLayout == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "mChannelTabLayout null");
      return;
    }
    int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
    if (k >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.ux())
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "currentPosition larger than tablayout childsize, currentPosition " + k + " childsize: " + this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.ux());
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.f(k);
    View localView2;
    int i;
    int j;
    float f2;
    float f1;
    View localView1;
    if (localViewGroup != null)
    {
      localView2 = localViewGroup.findViewById(2131369473);
      i = 0;
      paramInt2 = 0;
      j = 0;
      if (paramInt1 != k - 1) {
        break label284;
      }
      f2 = (1.0F - paramFloat) * this.iz;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      paramInt2 = aIt;
      paramInt1 = k - 1;
      if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.ux())) {
        break label266;
      }
      localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.f(paramInt1);
      paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.eu(paramInt1);
      paramInt2 = (int)(aIt - f1 * paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.5(this, paramFloat, k, localViewGroup, localView1));
      paramInt1 = 0;
    }
    for (;;)
    {
      k(localView2, paramInt2, paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.8(this, localView1, localView2));
      return;
      localView2 = null;
      break;
      label266:
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt1 = 0;
      continue;
      label284:
      if (paramInt1 == k)
      {
        f2 = this.iz * paramFloat;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramInt1 = aIu;
        paramInt2 = k + 1;
        if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.ux()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.f(paramInt2);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.eu(paramInt2);
          paramInt1 = (int)(aIu - f1 * paramInt1);
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.6(this, paramFloat, paramInt2, localView1, localViewGroup, k));
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          paramInt1 = 1;
          break;
          QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
          localView1 = null;
        }
      }
      if (paramInt1 == k + 1)
      {
        paramInt1 = k + 1;
        if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.ux()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.f(paramInt1);
          paramInt2 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.eu(paramInt1);
        }
        for (paramInt2 = aIu - paramInt2;; paramInt2 = i)
        {
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.7(this, paramInt1, localView1, localViewGroup));
          paramInt1 = 1;
          break;
          localView1 = null;
        }
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt1 = j;
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)kxm.getAppRuntime().getManager(280);
    TabChannelCoverInfo.a locala = new TabChannelCoverInfo.a();
    locala.startTimestamp = 0L;
    locala.endTimestamp = 9223372036854775807L;
    locala.isShow = localKandianSubscribeManager.BF();
    paramTabChannelCoverInfo.redPoint = locala;
    b(paramTabChannelCoverInfo);
  }
  
  private void aCn()
  {
    Object localObject = (lcd)kxm.getAppRuntime().getManager(163);
    List localList;
    if (localObject != null)
    {
      localObject = ((lcd)localObject).b();
      if (localObject != null)
      {
        localList = ((lbz)localObject).aD();
        if ((localList != null) && (localList.size() != 0)) {
          break label63;
        }
        ((lbz)localObject).aJs();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "No channel Cache info.");
      }
    }
    for (;;)
    {
      aCo();
      return;
      label63:
      bL(localList);
    }
  }
  
  private void aCo()
  {
    if (kyo.Bg())
    {
      this.hT.setImageResource(2130850264);
      return;
    }
    this.hT.setImageResource(2130843759);
  }
  
  private void aCq()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a(0);
    if (localTabChannelCoverInfo == null) {}
    while ((localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.isShow)) {
      return;
    }
    localTabChannelCoverInfo.redPoint.isShow = false;
    b(localTabChannelCoverInfo);
  }
  
  private void aCr()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.notifyDataSetChanged();
    aCs();
  }
  
  private void aCs()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOverScrollMode(2);
    int j = getCurrentItem();
    if (this.lastCenterPosition == j)
    {
      QLog.i("ReadInJoyChannelViewPagerController", 1, "mLastCenterPosition = " + this.lastCenterPosition + ", no need to move again.");
      return;
    }
    this.lastCenterPosition = j;
    int i = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.eu(j);
    int k = (int)(aqgz.hM() - i) / 2 - aqnm.dip2px(12.0F);
    i = 200;
    if ((j < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getFirstVisiblePosition()) || (j > this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getLastVisiblePosition())) {
      i = 0;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "smoothScrollToPosition, position = ", Integer.valueOf(j), ", offset = ", Integer.valueOf(k) });
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.smoothScrollToPositionFromLeftOrRight(j, -k, i);
    if (this.mOnScrollStateChangedListener == null) {
      this.mOnScrollStateChangedListener = new kfy(this);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(this.mOnScrollStateChangedListener);
  }
  
  private void aCt()
  {
    Object localObject = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    if (localObject != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelBackground, channelID = ", Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId) });
      int i = ((TabChannelCoverInfo)localObject).mChannelCoverId;
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
      if (TextUtils.isEmpty(((TabChannelCoverInfo)localObject).mChannelVersion)) {}
      for (localObject = "0";; localObject = ((TabChannelCoverInfo)localObject).mChannelVersion)
      {
        i(i, j, (String)localObject);
        return;
      }
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "onChannelBackground, channel is null.");
  }
  
  private void aCu()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelBackground, channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId) });
      oI(localTabChannelCoverInfo.mChannelCoverId);
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "onChannelForeground, channel is null.");
  }
  
  private void aCw()
  {
    if (!aeH)
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)kxm.getAppRuntime().getManager(162);
      if (localKandianMergeManager != null)
      {
        localKandianMergeManager.aIW();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "clearKandianRedPoint");
      }
    }
  }
  
  private void aCx()
  {
    this.jdField_a_of_type_Lbz = ((lcd)kxm.getAppRuntime().getManager(163)).b();
  }
  
  public static Integer b(int paramInt)
  {
    return (Integer)dg.remove(Integer.valueOf(paramInt));
  }
  
  private void bL(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "channel list size is 0");
      return;
    }
    aIs = nj();
    List localList = F(paramList);
    this.gc.clear();
    this.gc.addAll(localList);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.notifyDataSetChanged();
    if (this.jdField_a_of_type_Kfv$a != null)
    {
      paramList = F(paramList);
      this.jdField_a_of_type_Kfv$a.bN(paramList);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyChannelViewPagerController.2(this));
    aCq();
    aCr();
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId) != null)) {
      oF(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
    }
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "setAdapterData: " + localList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.jdMethod_do(localList);
      return;
      aCp();
    }
  }
  
  private void bM(List<TabChannelCoverInfo> paramList)
  {
    List localList = this.jdField_a_of_type_Lbz.aC();
    if ((localList != null) && (localList.size() > 0))
    {
      ((mgw)localList.get(0)).iK = paramList;
      this.jdField_a_of_type_Lbz.c(localList, 1, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "updateMyChannelData channelCoverSectionList is null");
  }
  
  private void c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    int i;
    if (this.gd.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.gd.size())
      {
        if (paramTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)this.gd.get(i)).mChannelCoverId) {
          this.gd.remove(i);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.reason == 4) {
          break;
        }
        this.gd.add(0, paramTabChannelCoverInfo);
        return;
      }
      i += 1;
    }
  }
  
  public static void cn(int paramInt1, int paramInt2)
  {
    dg.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public static boolean db(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isNeedRefreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      return (Boolean)dh.remove(Integer.valueOf(paramInt)) != null;
    }
    return false;
  }
  
  public static boolean dc(int paramInt)
  {
    return de.get(Integer.valueOf(paramInt)) != null;
  }
  
  public static boolean dd(int paramInt)
  {
    Long localLong = (Long)df.get(Integer.valueOf(paramInt));
    if ((localLong == null) || (localLong.longValue() <= 0L))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "isLastExitChannelOverTimeLimit, lastExitTime is invalid.");
      return true;
    }
    long l = System.currentTimeMillis() - localLong.longValue();
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refresh_time_limit = ", Long.valueOf(rT), ", channelID = ", Integer.valueOf(paramInt), ", channelExitTime = ", Long.valueOf(l) });
    return l > rT;
  }
  
  private void f(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "tvSelectTab or tvUnselectTab null");
      return;
    }
    paramView1 = (TextView)paramView1.findViewById(2131380976);
    paramView2 = (TextView)paramView2.findViewById(2131380976);
    l(paramView1);
    m(paramView2);
  }
  
  public static void i(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "exitChannel, channelID = ", Integer.valueOf(paramInt1) });
    if (paramInt1 == -1) {
      return;
    }
    Object localObject = (Long)de.remove(Integer.valueOf(paramInt1));
    if ((localObject == null) || (((Long)localObject).longValue() <= 0L))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "exitChannel, enterTime is invalid");
      return;
    }
    long l = (System.currentTimeMillis() - ((Long)localObject).longValue()) / 1000L;
    try
    {
      paramString = new kxm.b().c().g().a(paramInt1).b(paramInt2 + 1).d(paramString);
      if (paramInt1 == 41695)
      {
        localObject = lbz.a().a();
        if (localObject != null)
        {
          localObject = ((SelectPositionModule)localObject).a();
          if (localObject != null)
          {
            paramString.e(((SelectPositionModule.PositionData)localObject).city);
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyChannelViewPagerController", 2, "reportRecommendEvent CHANNEL_ID_LOCAL r5Str = " + paramString.build());
            }
          }
        }
      }
      G("0X8009733", String.valueOf(l), paramString.build());
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    df.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
    oJ(paramInt1);
  }
  
  private void init()
  {
    if ((this.mContext instanceof FragmentActivity)) {
      this.mFragmentManager = ((FragmentActivity)this.mContext).getSupportFragmentManager();
    }
    this.jdField_a_of_type_Nhi = new nhi(this.jw.getContext(), this.gc, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.dF.clear();
    this.jdField_a_of_type_Nhi.J(this.dF);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_Nhi);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getAdapter());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(this.mOnPageChangeListener);
    lcc.a().b(this.mObserver);
    aCn();
    aCp();
    setListener();
    aIs = nj();
    ((KandianSubscribeManager)kxm.getAppRuntime().getManager(280)).a(this);
    lcm.d.a(this.jdField_a_of_type_Lcm$e);
  }
  
  private void k(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "line null");
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (paramInt2 == 0)
    {
      localMarginLayoutParams.leftMargin = paramInt1;
      localMarginLayoutParams.rightMargin = aIu;
    }
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "changeChannelLineMargin: left " + localMarginLayoutParams.leftMargin + " right: " + localMarginLayoutParams.rightMargin);
      paramView.setLayoutParams(localMarginLayoutParams);
      return;
      localMarginLayoutParams.rightMargin = paramInt1;
      localMarginLayoutParams.leftMargin = aIt;
    }
  }
  
  private void l(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131167165));
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
  }
  
  private void lR(boolean paramBoolean)
  {
    int k = 0;
    Object localObject;
    int j;
    if (this.jx != null)
    {
      if ((!paramBoolean) || (anwa.aze())) {
        break label60;
      }
      i = 1;
      localObject = this.jx;
      if (i == 0) {
        break label65;
      }
      j = 0;
      label34:
      ((View)localObject).setVisibility(j);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
      if (i == 0) {
        break label70;
      }
    }
    label60:
    label65:
    label70:
    for (int i = k;; i = 8)
    {
      ((ColorBandVideoEntranceButton)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      j = 4;
      break label34;
    }
  }
  
  private void m(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131167166));
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private int nj()
  {
    List localList = this.jdField_a_of_type_Lbz.aD();
    int k;
    if ((localList == null) || (localList.size() == 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "No channel Cache info.");
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelViewPagerController", 2, "getChannelLockCount lockCount：" + k);
      }
      return k;
    }
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= localList.size()) {
        break;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(j);
      k = i;
      if (localTabChannelCoverInfo != null)
      {
        k = i;
        if (localTabChannelCoverInfo.reason != 4) {
          break;
        }
        k = i + 1;
      }
      j += 1;
    }
  }
  
  private boolean o(List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    paramList = G(paramList);
    if (paramList.size() == this.gc.size())
    {
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramList.size())
        {
          if (((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId != ((TabChannelCoverInfo)this.gc.get(i)).mChannelCoverId) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void oG(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.gc.size())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = (TabChannelCoverInfo)this.gc.get(paramInt);
    } while ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.isShow));
    localTabChannelCoverInfo.redPoint.isShow = false;
    b(localTabChannelCoverInfo);
  }
  
  private void oH(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.gc.get(paramInt);
    if (((localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.isShow)) || (dd(localTabChannelCoverInfo.mChannelCoverId))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "checkBackToTopAndRefresh, position = ", Integer.valueOf(paramInt), ", channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", isNeedRefresh = ", Boolean.valueOf(bool) });
      if (bool)
      {
        Fragment localFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
        if (!(localFragment instanceof ReadInJoyBaseFragment)) {
          break;
        }
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isShowingSelf = ", Boolean.valueOf(((ReadInJoyBaseFragment)localFragment).BR()) });
        ((ReadInJoyBaseFragment)localFragment).qc(3);
      }
      return;
    }
    oK(localTabChannelCoverInfo.mChannelCoverId);
  }
  
  public static void oI(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "enterChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1)
    {
      de.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      npa.tQ(paramInt);
    }
  }
  
  private static void oJ(int paramInt)
  {
    kpf.pu(paramInt);
  }
  
  public static void oK(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      dh.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  private void setListener()
  {
    this.hT.setOnClickListener(new kfw(this));
  }
  
  public static boolean zj()
  {
    return aeH;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.b();
  }
  
  public TabChannelCoverInfo a()
  {
    int i = getCurrentItem();
    if ((i < 0) || (i >= this.gc.size())) {
      return null;
    }
    return (TabChannelCoverInfo)this.gc.get(i);
  }
  
  public void a(View paramView, ColorBandVideoEntranceButton paramColorBandVideoEntranceButton)
  {
    this.jx = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
  }
  
  public void aCp()
  {
    int i = Aladdin.getConfig(220).getIntegerFromString("main_feeds_channel_id", -1);
    if (i != -1) {}
    for (;;)
    {
      oF(i);
      return;
      i = 0;
    }
  }
  
  public void aCv()
  {
    QLog.i("ReadInJoyChannelViewPagerController", 1, "[onReceiveKandianSubscribeMessage] ");
    if ((this.gc == null) || (this.gc.isEmpty())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = a(70);
    } while (localTabChannelCoverInfo == null);
    TabChannelCoverInfo.a locala = new TabChannelCoverInfo.a();
    locala.isShow = true;
    locala.startTimestamp = 0L;
    locala.endTimestamp = 9223372036854775807L;
    localTabChannelCoverInfo.redPoint = locala;
    b(localTabChannelCoverInfo);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.notifyDataSetChanged();
  }
  
  @UiThread
  public void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "updateChannelToCacheAndDB channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
        localObject = (lcd)kxm.getAppRuntime().getManager(163);
      } while (localObject == null);
      localObject = ((lcd)localObject).b();
    } while (localObject == null);
    if (kxm.isInMainThread())
    {
      ((lbz)localObject).e(paramTabChannelCoverInfo);
      return;
    }
    kxm.p().post(new ReadInJoyChannelViewPagerController.3(this, (lbz)localObject, paramTabChannelCoverInfo));
  }
  
  public boolean ds()
  {
    return this.mHasRedPoint;
  }
  
  public int getCurrentItem()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
  }
  
  public int getScrollState()
  {
    return this.scrollState;
  }
  
  public int getSelectedItem()
  {
    return this.aIv;
  }
  
  public void lS(boolean paramBoolean)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onTabChanged, visible = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      D(this.dF);
    }
    for (;;)
    {
      this.dF.clear();
      if (paramBoolean) {
        FrameHelperActivity.cuz();
      }
      if (this.gd.size() <= 0) {
        break label249;
      }
      boolean bool1 = o(this.gd);
      boolean bool2 = awit.aMY();
      QLog.d("ReadInJoyChannelViewPagerController", 2, "has changed :" + bool1 + " ,isDynamicOrderSwitchOn : " + bool2);
      if ((!bool1) || (!bool2) || (paramBoolean)) {
        break label238;
      }
      int i = this.gd.size() - 1;
      while (i > 0)
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.gd.get(i);
        cn(localTabChannelCoverInfo.mChannelCoverId, 2);
        this.jdField_a_of_type_Lbz.c(localTabChannelCoverInfo.mChannelCoverId, 5, false, false);
        i -= 1;
      }
      this.jdField_a_of_type_Nhi.notifyDataSetChanged();
    }
    bM(G(this.gd));
    bL(G(this.gd));
    aeG = true;
    this.gd.clear();
    label238:
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.EN(paramBoolean);
      return;
      label249:
      if (paramBoolean) {
        break;
      }
      aeG = false;
      aCs();
      break;
    }
  }
  
  public void oE(int paramInt)
  {
    int j = 1;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.gc.size()))
    {
      localObject = (TabChannelCoverInfo)this.gc.get(paramInt);
      if ((localObject != null) && (dg.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null)) {
        cn(((TabChannelCoverInfo)localObject).mChannelCoverId, 1);
      }
    }
    for (;;)
    {
      try
      {
        G("0X8009B94", "", new kxm.b().a("source", "302").a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("style", 0).build());
        if (getCurrentItem() == paramInt)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
          if ((localObject instanceof ReadInJoyBaseFragment)) {
            ((ReadInJoyBaseFragment)localObject).qc(5);
          }
          localObject = (TabChannelCoverInfo)this.gc.get(paramInt);
          if (localObject == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          G("0X8009665", "", kxm.a().a(((TabChannelCoverInfo)localObject).mChannelCoverId).m(ReadInJoyChannelPanelFragment.a((ChannelCoverInfo)localObject)).n(ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject)).build());
          boolean bool = awit.aMX();
          if ((paramInt >= 0) && (paramInt < this.gc.size())) {
            if (((TabChannelCoverInfo)this.gc.get(paramInt)).dynamicSort == 1)
            {
              i = 1;
              if ((!bool) || (i == 0)) {
                continue;
              }
              i = j;
              if ((paramInt < aIs) || (i == 0)) {
                continue;
              }
              if ((paramInt >= 0) && (paramInt < this.gc.size()))
              {
                localObject = (TabChannelCoverInfo)this.gc.get(paramInt);
                if ((localObject != null) && (dg.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null)) {
                  cn(((TabChannelCoverInfo)localObject).mChannelCoverId, 0);
                }
              }
              oG(paramInt);
              this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.notifyDataSetChanged();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.postDelayed(new ReadInJoyChannelViewPagerController.10(this, paramInt), 0L);
              return;
              localJSONException1 = localJSONException1;
              QLog.d("ReadInJoyChannelViewPagerController", 2, "report click channel bar exception, e = ", localJSONException1);
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          QLog.d("ReadInJoyChannelViewPagerController", 1, "report channel title click again exception, e = ", localJSONException2);
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          setCurrentItem(paramInt);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void oF(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (i < this.gc.size()) {
      if (((TabChannelCoverInfo)this.gc.get(i)).mChannelCoverId != paramInt) {}
    }
    for (;;)
    {
      if (i == -1) {
        QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "setCurrentItemByChannelID error,channelID= ", Integer.valueOf(paramInt), " recommendIndex=", Integer.valueOf(j) });
      }
      for (;;)
      {
        setCurrentItem(j);
        this.aIv = j;
        return;
        if (((TabChannelCoverInfo)this.gc.get(i)).mChannelCoverId == 0) {
          j = i;
        }
        i += 1;
        break;
        j = i;
      }
      i = -1;
    }
  }
  
  public void onAccountChanged()
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = null;
    de.clear();
    df.clear();
    this.gc.clear();
    this.jdField_a_of_type_Nhi = new nhi(this.jw.getContext(), this.gc, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.dF.clear();
    this.jdField_a_of_type_Nhi.J(this.dF);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_Nhi);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.clearData();
    }
    if (this.mFragmentManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.mFragmentManager);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
      aCn();
      aCp();
      aCx();
      aCo();
      return;
      if ((this.mContext instanceof FragmentActivity)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(((FragmentActivity)this.mContext).getSupportFragmentManager());
      }
    }
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    ((KandianSubscribeManager)kxm.getAppRuntime().getManager(280)).b(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.removeOnPageChangeListener(this.mOnPageChangeListener);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) && ((this.mContext instanceof SplashActivity)) && (!((SplashActivity)this.mContext).isFinishing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.clearData();
    }
    if (de != null) {
      de.clear();
    }
    if (df != null) {
      df.clear();
    }
    if (dh != null) {
      dh.clear();
    }
    if (dg != null)
    {
      dg.clear();
      ReadInJoyBaseFragment.dg.clear();
    }
    if (this.jdField_a_of_type_Lcm$e != null) {
      lcm.d.b(this.jdField_a_of_type_Lcm$e);
    }
    this.jv = null;
    aeH = true;
  }
  
  public void onPause()
  {
    aeI = false;
    this.jv.setY(0.0F);
  }
  
  public void onResume()
  {
    aIs = nj();
    aeI = true;
    this.jv.setY(0.0F);
    aCo();
  }
  
  public void setCurrentItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.gc.size()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.gc.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (dg.get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
        cn(localTabChannelCoverInfo.mChannelCoverId, 0);
      }
    }
    oG(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setCurrentItem(paramInt, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void bN(List<TabChannelCoverInfo> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfv
 * JD-Core Version:    0.7.0.1
 */