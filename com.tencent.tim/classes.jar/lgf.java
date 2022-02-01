import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.net.MalformedURLException;
import java.net.URL;

public class lgf
  extends lfz
{
  private lgf.h a;
  private boolean ajW;
  
  private static BaseArticleInfo a(lgf paramlgf, View paramView)
  {
    if ((paramlgf == null) || (paramView == null) || (!(paramView.getTag() instanceof lgf.c))) {
      return null;
    }
    paramView = (lgf.c)paramView.getTag();
    if (paramView != null) {
      return paramlgf.c(paramView.getPosition());
    }
    return null;
  }
  
  private static lgf.c a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof lgf.c))) {
      return null;
    }
    return (lgf.c)paramView.getTag();
  }
  
  public static void a(Context paramContext, ImageView paramImageView, mye.b paramb)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)kwz.a(paramContext, paramb));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private static void a(lgf paramlgf, BaseArticleInfo paramBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int k = paramlgf.a().nh();
    String str = kxm.f(paramBaseArticleInfo);
    int i;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label217;
      }
    }
    label217:
    for (int j = 0;; j = 1)
    {
      paramlgf = new nce.a(kxm.a(paramBaseArticleInfo.mAlgorithmID, kxm.a(paramBaseArticleInfo), 0, i, j, aqiw.isWifiConnected(paramlgf.getActivity()), str, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, kxm.h(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      paramlgf.h(paramBaseArticleInfo.innerUniqueID).a(k).d(paramBaseArticleInfo.mStrategyId).g(kct.aHF).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(kxm.F(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo).R(paramInt).r(paramString).f(paramBaseArticleInfo);
      if (paramVideoColumnInfo != null) {
        paramlgf.aa(paramVideoColumnInfo.aHc);
      }
      kbp.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramlgf.a().toJsonString(), false);
      return;
      i = 0;
      break;
    }
  }
  
  private BaseArticleInfo c(int paramInt)
  {
    return a().c(paramInt);
  }
  
  public static void cu(View paramView)
  {
    if (paramView == null) {}
    View localView2;
    do
    {
      return;
      View localView1 = null;
      if ((paramView.getTag() instanceof lgf.i)) {
        localView1 = ((lgf.i)paramView.getTag()).itemView;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131376790) instanceof lgf.i)) {
          localView2 = ((lgf.i)paramView.getTag(2131376790)).itemView;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  public static void cv(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public lgf.i a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = getActivity();
    switch (paramInt2)
    {
    default: 
      return new lgf.f(paramView, this);
    case 4: 
      return new lgf.f(paramView, this);
    case 46: 
      return new lgf.e(paramView, this);
    case 70: 
      return new lgf.j(paramView, this);
    case 118: 
      return new lgf.d(paramView, this);
    case 119: 
      return new lgf.g(paramView, this);
    case 6: 
      return new lgf.b(paramView, this);
    }
    return new lgf.a(paramView, this);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    this.a = new lgf.h(null);
    this.ajW = awit.aMC();
  }
  
  public boolean ab(int paramInt1, int paramInt2)
  {
    return (kxm.j(c(paramInt1))) && (nh() == 56) && (this.ajW) && (paramInt2 == 4);
  }
  
  public View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = c(paramInt).intValue();
    Object localObject;
    nhk localnhk;
    if ((paramView == null) || (!(paramView.getTag() instanceof lgf.i)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((lgf.i)localObject).c(paramInt, paramViewGroup);
      ((lgf.i)localObject).itemView = paramView;
      ((lgf.i)localObject).position = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131370016, f());
      paramViewGroup = new lkt(getActivity(), a().a(), a(), a(), a().a(), a().b());
      paramView.setTag(2131381962, paramViewGroup);
      localnhk = new nhk(paramView);
      paramView.setTag(2131381965, localnhk);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = c(paramInt);
      ((lgf.i)localObject).setOnClickListener(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("ReadInJoyBaseAdapter", 2, "article is null, return");
      return localnhk.getView();
      localObject = (lgf.i)paramView.getTag();
      ((lgf.i)localObject).position = paramInt;
      paramViewGroup = (lkf)paramView.getTag(2131381962);
      localnhk = (nhk)paramView.getTag(2131381965);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((lgf.e)localObject, localBaseArticleInfo);
      nxr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < getCount() - 1) {
        localObject = (ArticleInfo)c(paramInt + 1);
      }
      localObject = new lis(getActivity(), (ArticleInfo)localBaseArticleInfo, i, nh(), ni(), paramInt, Cb(), getCount(), (ArticleInfo)localObject, a());
      paramView.setTag(2131381960, localObject);
      paramViewGroup.a(localnhk, (lie)localObject, i);
      return localnhk.getView();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((lgf.f)localObject, localBaseArticleInfo, paramInt);
        nxr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().getActivity());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((lgf.j)localObject, localBaseArticleInfo, paramInt);
        nxr.a("ReadInJoyBaseAdapter", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((lgf.d)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((lgf.f)localObject, localBaseArticleInfo, paramInt);
        localObject = (lgf.g)localObject;
        ((lgf.g)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((lgf.g)localObject).c(localBaseArticleInfo);
        lgf.g.a((lgf.g)localObject).setTag(localObject);
        lgf.g.a((lgf.g)localObject).setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((lgf.b)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((lgf.a)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public boolean df(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public Boolean g()
  {
    if ((a().a() != null) && (a().a().a() != null) && (a().a().a().EV()))
    {
      a().a().a().aUp();
      return Boolean.valueOf(true);
    }
    return super.g();
  }
  
  public int np()
  {
    return 0;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.removeCallbacksAndMessages(null);
    }
  }
  
  public static class a
    extends lgf.i
    implements View.OnClickListener, lgf.c
  {
    public VideoViewGroup a;
    public mye.b a;
    public KandianUrlImageView h;
    public KandianUrlImageView i;
    public ImageView iT;
    public ImageView iU;
    View kq;
    public View kr;
    public View ks;
    public View kt;
    public TextView pp;
    public TextView pq;
    public TextView pr;
    public TextView ps;
    public TextView pt;
    public TextView pu;
    public TextView pv;
    
    public a(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    private void cw(View paramView)
    {
      if ((paramView == null) || (this.b == null)) {}
      BaseArticleInfo localBaseArticleInfo;
      do
      {
        return;
        localBaseArticleInfo = lgf.b(this.b, paramView);
      } while (localBaseArticleInfo == null);
      if ((muj.pT() == 1) && (this.b.a().a() != null))
      {
        mye localmye = this.b.a().a();
        if ((localmye != null) && (localmye.a() != null))
        {
          localmye.a().cW(paramView);
          return;
        }
      }
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.i != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.i.jumpType != 3))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mSimpleVideoColumnInfo.i);
        if (localBaseArticleInfo.mSimpleVideoColumnInfo.i != null) {
          break label186;
        }
      }
      label186:
      for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.i.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 1, paramView);
        return;
        paramView = lgf.b(paramView);
        if (paramView == null) {
          break;
        }
        this.b.a().a(paramView.a(), localBaseArticleInfo, false, false);
        break;
      }
    }
    
    private void cx(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null))
      {
        if ((localBaseArticleInfo.mSimpleVideoColumnInfo.h == null) || (localBaseArticleInfo.mSimpleVideoColumnInfo.h.jumpType == 3)) {
          break label95;
        }
        muj.a(this.b.getActivity(), localBaseArticleInfo.mSimpleVideoColumnInfo.h);
        if (localBaseArticleInfo.mSimpleVideoColumnInfo.h != null) {
          break label126;
        }
      }
      label95:
      label126:
      for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.h.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 2, paramView);
        return;
        paramView = lgf.b(paramView);
        if (paramView == null) {
          break;
        }
        this.b.a().a(paramView.a(), localBaseArticleInfo, false, false);
        break;
      }
    }
    
    private void cy(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo != null) && (localBaseArticleInfo.mSimpleVideoColumnInfo.k != null))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mSimpleVideoColumnInfo.k);
        if (localBaseArticleInfo.mSimpleVideoColumnInfo.k != null) {
          break label81;
        }
      }
      label81:
      for (paramView = null;; paramView = localBaseArticleInfo.mSimpleVideoColumnInfo.k.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mSimpleVideoColumnInfo, 3, paramView);
        return;
      }
    }
    
    public mye.b a()
    {
      return this.jdField_a_of_type_Mye$b;
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560556, paramViewGroup, false);
      this.kq = paramViewGroup.findViewById(2131377546);
      this.pp = ((TextView)paramViewGroup.findViewById(2131379769));
      this.pq = ((TextView)paramViewGroup.findViewById(2131373382));
      this.pr = ((TextView)paramViewGroup.findViewById(2131366156));
      this.h = ((KandianUrlImageView)paramViewGroup.findViewById(2131368820));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381724));
      this.iT = ((ImageView)paramViewGroup.findViewById(2131372700));
      this.ps = ((TextView)paramViewGroup.findViewById(2131372701));
      this.pt = ((TextView)paramViewGroup.findViewById(2131370088));
      this.kr = paramViewGroup.findViewById(2131379823);
      this.ks = paramViewGroup.findViewById(2131379850);
      this.kt = paramViewGroup.findViewById(2131363627);
      this.pu = ((TextView)paramViewGroup.findViewById(2131366991));
      this.i = ((KandianUrlImageView)paramViewGroup.findViewById(2131366992));
      this.pv = ((TextView)paramViewGroup.findViewById(2131366993));
      this.iU = ((ImageView)paramViewGroup.findViewById(2131381256));
      this.h.setTag(this);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
      this.kt.setTag(this);
      this.kt.setOnClickListener(this);
      this.i.setTag(this);
      this.i.setOnClickListener(this);
      this.pv.setTag(this);
      this.pv.setOnClickListener(this);
      this.kq.setTag(this);
      this.kq.setOnClickListener(this);
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    public void onClick(View paramView)
    {
      lgf.cu(paramView);
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        cw(paramView);
        continue;
        cx(paramView);
        continue;
        cy(paramView);
      }
    }
    
    public boolean z(View paramView)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if (!muj.af(lgf.b(this.b, paramView))) {}
      int j;
      float f;
      do
      {
        do
        {
          return false;
          j = muj.pS();
        } while (j == 0);
        f = kwz.c(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f);
        }
        if (j == 1)
        {
          if ((mst.a().isWifi()) && (f >= 70.0F)) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        }
      } while (j != 2);
      if (f >= 70.0F) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
  }
  
  public static class b
    extends lgf.i
    implements View.OnClickListener, lgf.c
  {
    public VideoViewGroup a;
    public mye.b a;
    public KandianUrlImageView h;
    public ImageView iT;
    public ImageView iU;
    public KandianUrlImageView j;
    public KandianUrlImageView k;
    View kq;
    public View kr;
    public View ks;
    public View kt;
    public TextView pp;
    public TextView pr;
    public TextView ps;
    public TextView pt;
    public TextView pw;
    public TextView px;
    public TextView py;
    public TextView pz;
    public TextView titleTextView;
    
    public b(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    public mye.b a()
    {
      return this.jdField_a_of_type_Mye$b;
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560555, paramViewGroup, false);
      this.kq = paramViewGroup.findViewById(2131377546);
      this.pp = ((TextView)paramViewGroup.findViewById(2131379769));
      this.pw = ((TextView)paramViewGroup.findViewById(2131373382));
      this.pr = ((TextView)paramViewGroup.findViewById(2131366156));
      this.h = ((KandianUrlImageView)paramViewGroup.findViewById(2131368820));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381724));
      this.iT = ((ImageView)paramViewGroup.findViewById(2131372700));
      this.ps = ((TextView)paramViewGroup.findViewById(2131372701));
      this.pt = ((TextView)paramViewGroup.findViewById(2131370088));
      this.kr = paramViewGroup.findViewById(2131379823);
      this.ks = paramViewGroup.findViewById(2131379850);
      this.kt = paramViewGroup.findViewById(2131363627);
      this.titleTextView = ((TextView)paramViewGroup.findViewById(2131367004));
      this.px = ((TextView)paramViewGroup.findViewById(2131366989));
      this.py = ((TextView)paramViewGroup.findViewById(2131365001));
      this.iU = ((ImageView)paramViewGroup.findViewById(2131381256));
      this.pz = ((TextView)paramViewGroup.findViewById(2131367002));
      this.k = ((KandianUrlImageView)paramViewGroup.findViewById(2131367005));
      this.j = ((KandianUrlImageView)paramViewGroup.findViewById(2131369743));
      this.j.setOnClickListener(this);
      this.h.setTag(this);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
      this.kt.setTag(this);
      this.kt.setOnClickListener(this);
      this.kq.setTag(this);
      this.kq.setOnClickListener(this);
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    public void onClick(View paramView)
    {
      lgf.cu(paramView);
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject1 = lgf.b(this.b, paramView);
        if (localObject1 != null)
        {
          if ((muj.pR() == 1) && (this.b.a().a() != null))
          {
            localObject2 = this.b.a().a();
            if ((localObject2 != null) && (((mye)localObject2).a() != null))
            {
              ((mye)localObject2).a().cW(paramView);
              continue;
            }
          }
          Object localObject2 = lgf.b(paramView);
          if (localObject2 != null) {
            if (kxm.a(paramView.getContext(), (BaseArticleInfo)localObject1))
            {
              this.b.a().b(((lgf.c)localObject2).a(), (BaseArticleInfo)localObject1);
              kxm.a(paramView.getContext(), (BaseArticleInfo)localObject1, kxm.eA(((BaseArticleInfo)localObject1).getInnerUniqueID()));
            }
            else if (muj.b(this.b.getActivity(), (BaseArticleInfo)localObject1))
            {
              this.b.a().b(((lgf.c)localObject2).a(), (BaseArticleInfo)localObject1);
            }
            else if (localObject2 != null)
            {
              this.b.a().a(((lgf.c)localObject2).a(), (BaseArticleInfo)localObject1, false, true);
              continue;
              localObject1 = lgf.b(paramView);
              if (localObject1 != null)
              {
                localObject2 = this.b.a().c(this.position);
                if (kxm.a(paramView.getContext(), (BaseArticleInfo)localObject2))
                {
                  this.b.a().b(((lgf.c)localObject1).a(), (BaseArticleInfo)localObject2);
                  kxm.a(paramView.getContext(), (BaseArticleInfo)localObject2, kxm.eA(((BaseArticleInfo)localObject2).getInnerUniqueID()));
                }
                else if (muj.b(this.b.getActivity(), (BaseArticleInfo)localObject2))
                {
                  this.b.a().b(((lgf.c)localObject1).a(), (BaseArticleInfo)localObject2);
                }
                else if (localObject1 != null)
                {
                  this.b.a().a(((lgf.c)localObject1).a(), (BaseArticleInfo)localObject2, false, true);
                  continue;
                  localObject1 = this.b.a().c(this.position);
                  if ((localObject1 != null) && (((BaseArticleInfo)localObject1).familyCommentInfo != null))
                  {
                    kxm.a(this.mContext, (BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).familyCommentInfo.agT);
                    QLog.d("ReadInJoyBaseAdapter", 2, "familyJumpUrl " + ((BaseArticleInfo)localObject1).familyCommentInfo.agT);
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public boolean z(View paramView)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if (!muj.af(lgf.b(this.b, paramView))) {}
      int i;
      float f;
      do
      {
        do
        {
          return false;
          i = muj.pQ();
        } while (i == 0);
        f = kwz.c(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "BigImgVideoItemViewHolder() canAutoPlay percent:" + f);
        }
        if (i == 1)
        {
          if ((mst.a().isWifi()) && (f >= 70.0F)) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        }
      } while (i != 2);
      if (f >= 70.0F) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract mye.b a();
    
    public abstract int getPosition();
    
    public abstract boolean z(View paramView);
  }
  
  public static class d
    extends lgf.i
    implements View.OnClickListener, lgf.c
  {
    public VideoViewGroup a;
    public mye.b a;
    public ViewGroup aU;
    public ViewGroup aV;
    public KanDianUrlRoundCornerImageView c;
    public RelativeLayout fa;
    public KandianUrlImageView h;
    public ImageView iT;
    public ImageView iU;
    public View kr;
    public View ks;
    public KandianUrlImageView l;
    public KandianUrlImageView m;
    public TextView pA;
    public TextView pB;
    public TextView pC;
    public TextView pD;
    public TextView pp;
    public TextView pr;
    public TextView ps;
    public TextView pt;
    public TextView pw;
    
    public d(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    private void cA(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mVideoColumnInfo.k);
        if (localBaseArticleInfo.mVideoColumnInfo.k != null) {
          break label71;
        }
      }
      label71:
      for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.k.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 4, paramView);
        return;
      }
    }
    
    private void cw(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.i != null) && (localBaseArticleInfo.mVideoColumnInfo.i.jumpType != 3))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mVideoColumnInfo.i);
        if (localBaseArticleInfo.mVideoColumnInfo.i != null) {
          break label126;
        }
      }
      label126:
      for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.i.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 3, paramView);
        return;
        paramView = lgf.b(paramView);
        if (paramView == null) {
          break;
        }
        this.b.a().a(paramView.a(), localBaseArticleInfo, false, false);
        break;
      }
    }
    
    private void cx(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.h != null) && (localBaseArticleInfo.mVideoColumnInfo.h.jumpType != 3))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mVideoColumnInfo.h);
        if (localBaseArticleInfo.mVideoColumnInfo.h != null) {
          break label126;
        }
      }
      label126:
      for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.h.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 1, paramView);
        return;
        paramView = lgf.b(paramView);
        if (paramView == null) {
          break;
        }
        this.b.a().a(paramView.a(), localBaseArticleInfo, false, false);
        break;
      }
    }
    
    private void cz(View paramView)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mVideoColumnInfo != null))
      {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mVideoColumnInfo.j);
        muj.b(kxm.a(), localBaseArticleInfo.mVideoColumnInfo.aHc);
        localBaseArticleInfo.mVideoColumnInfo.amw = true;
        VideoColumnInfo localVideoColumnInfo = localBaseArticleInfo.mVideoColumnInfo;
        localVideoColumnInfo.subscribeCount += 1;
        lbz.a().j((ArticleInfo)localBaseArticleInfo);
        paramView.setVisibility(8);
        if (localBaseArticleInfo.mVideoColumnInfo.j != null) {
          break label123;
        }
      }
      label123:
      for (paramView = null;; paramView = localBaseArticleInfo.mVideoColumnInfo.j.WT)
      {
        lgf.b(this.b, localBaseArticleInfo, localBaseArticleInfo.mVideoColumnInfo, 2, paramView);
        return;
      }
    }
    
    public mye.b a()
    {
      return this.jdField_a_of_type_Mye$b;
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560557, paramViewGroup, false);
      this.fa = ((RelativeLayout)paramViewGroup.findViewById(2131368446));
      this.l = ((KandianUrlImageView)paramViewGroup.findViewById(2131368447));
      this.m = ((KandianUrlImageView)paramViewGroup.findViewById(2131364947));
      this.pA = ((TextView)paramViewGroup.findViewById(2131364950));
      this.pB = ((TextView)paramViewGroup.findViewById(2131364948));
      this.pC = ((TextView)paramViewGroup.findViewById(2131378958));
      this.aU = ((ViewGroup)paramViewGroup.findViewById(2131365373));
      this.pp = ((TextView)paramViewGroup.findViewById(2131379769));
      this.pw = ((TextView)paramViewGroup.findViewById(2131373382));
      this.pr = ((TextView)paramViewGroup.findViewById(2131366156));
      this.h = ((KandianUrlImageView)paramViewGroup.findViewById(2131368820));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381724));
      this.iT = ((ImageView)paramViewGroup.findViewById(2131372700));
      this.ps = ((TextView)paramViewGroup.findViewById(2131372701));
      this.pt = ((TextView)paramViewGroup.findViewById(2131370088));
      this.kr = paramViewGroup.findViewById(2131379823);
      this.ks = paramViewGroup.findViewById(2131379850);
      this.aV = ((ViewGroup)paramViewGroup.findViewById(2131362839));
      this.c = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131364943));
      this.pD = ((TextView)paramViewGroup.findViewById(2131364944));
      this.iU = ((ImageView)paramViewGroup.findViewById(2131381256));
      this.fa.setOnClickListener(this);
      this.pC.setOnClickListener(this);
      this.aV.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.pD.setOnClickListener(this);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(this);
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    public void onClick(View paramView)
    {
      lgf.cu(paramView);
      switch (paramView.getId())
      {
      default: 
        cx(paramView);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        cz(paramView);
        continue;
        cx(paramView);
        continue;
        cw(paramView);
        continue;
        cA(paramView);
      }
    }
    
    public boolean z(View paramView)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if (!muj.af(lgf.b(this.b, paramView))) {}
      int i;
      float f;
      do
      {
        do
        {
          return false;
          i = muj.pO();
        } while (i == 0);
        f = kwz.c(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "VideoColumnItemViewHolder() canAutoPlay percent:" + f);
        }
        if (i == 1)
        {
          if ((mst.a().isWifi()) && (f >= 70.0F)) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        }
      } while (i != 2);
      if (f >= 70.0F) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
  }
  
  public static class e
    extends lgf.i
  {
    public RoundAngleFrameLayout a;
    public ViewGroup aW;
    public ViewGroup aX;
    public RoundAngleFrameLayout b;
    public BaseArticleInfo e;
    public ReadInJoyNickNameTextView e;
    public BaseArticleInfo f;
    public ReadInJoyNickNameTextView f;
    public ReadInJoyHeadImageView g;
    public ReadInJoyHeadImageView h;
    public ImageView iV;
    public ImageView iW;
    public View ku;
    public View kv;
    public View kw;
    public View kx;
    public KandianUrlImageView n;
    public KandianUrlImageView o;
    public KandianUrlImageView p;
    public TextView pE;
    public TextView pF;
    public TextView pG;
    public TextView pH;
    public TextView pI;
    public TextView pJ;
    public TextView pK;
    public TextView pL;
    public KandianUrlImageView q;
    public KandianUrlImageView r;
    public View rootView;
    public KandianUrlImageView s;
    
    public e(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560558, paramViewGroup, false);
      this.rootView = paramViewGroup.findViewById(2131377546);
      this.ku = paramViewGroup.findViewById(2131370369);
      this.kv = paramViewGroup.findViewById(2131377305);
      this.pE = ((TextView)paramViewGroup.findViewById(2131370360));
      this.pF = ((TextView)paramViewGroup.findViewById(2131377296));
      this.a = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131370364));
      this.p = ((KandianUrlImageView)paramViewGroup.findViewById(2131370375));
      this.iV = ((ImageView)paramViewGroup.findViewById(2131370377));
      this.pG = ((TextView)paramViewGroup.findViewById(2131370380));
      this.pH = ((TextView)paramViewGroup.findViewById(2131370378));
      this.aW = ((ViewGroup)paramViewGroup.findViewById(2131370370));
      this.pI = ((TextView)paramViewGroup.findViewById(2131370379));
      this.kw = paramViewGroup.findViewById(2131370348);
      this.g = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131370349));
      this.q = ((KandianUrlImageView)paramViewGroup.findViewById(2131370386));
      this.e = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131370350));
      this.n = ((KandianUrlImageView)paramViewGroup.findViewById(2131370363));
      this.b = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131377301));
      this.r = ((KandianUrlImageView)paramViewGroup.findViewById(2131377311));
      this.iW = ((ImageView)paramViewGroup.findViewById(2131377313));
      this.pJ = ((TextView)paramViewGroup.findViewById(2131377316));
      this.pK = ((TextView)paramViewGroup.findViewById(2131377314));
      this.aX = ((ViewGroup)paramViewGroup.findViewById(2131377306));
      this.pL = ((TextView)paramViewGroup.findViewById(2131377315));
      this.kx = paramViewGroup.findViewById(2131377278);
      this.h = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131377279));
      this.s = ((KandianUrlImageView)paramViewGroup.findViewById(2131377325));
      this.f = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131377280));
      this.o = ((KandianUrlImageView)paramViewGroup.findViewById(2131377299));
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
  }
  
  public static class f
    extends lgf.i
    implements lgf.c
  {
    public ReadInJoyVideoInfoViewGroup a;
    public VideoViewGroup a;
    public mye.b a;
    public Handler aX = new Handler(Looper.getMainLooper());
    public ViewGroup aY;
    public ViewGroup aZ;
    public RoundAngleFrameLayout c;
    public LinearLayout dI;
    public LinearLayout dJ;
    public RelativeLayout fb;
    public ReadInJoyNickNameTextView g;
    public KandianUrlImageView h;
    public ReadInJoyHeadImageView i;
    public ImageView iT;
    public ImageView iX;
    public ImageView iY;
    public ImageView iZ;
    public ImageView ja;
    public KandianUrlImageView k;
    public View kA;
    public View kr;
    public View ks;
    public View ky;
    public View kz;
    public TextView pM;
    public TextView pN;
    public TextView pO;
    public TextView pP;
    public TextView pp;
    public TextView pq;
    public TextView pr;
    public TextView ps;
    public TextView pt;
    
    public f(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public f(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    public mye.b a()
    {
      return this.jdField_a_of_type_Mye$b;
    }
    
    public void a(mye.b paramb, int paramInt1, int paramInt2) {}
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560548, paramViewGroup, false);
      this.aZ = ((ViewGroup)paramViewGroup.findViewById(2131366987));
      this.c = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131381801));
      this.pp = ((TextView)paramViewGroup.findViewById(2131379769));
      this.h = ((KandianUrlImageView)paramViewGroup.findViewById(2131368820));
      this.fb = ((RelativeLayout)paramViewGroup.findViewById(2131381717));
      this.aY = ((ViewGroup)paramViewGroup.findViewById(2131361894));
      this.i = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131368698));
      this.g = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131376710));
      this.pr = ((TextView)paramViewGroup.findViewById(2131366156));
      this.pM = ((TextView)paramViewGroup.findViewById(2131373778));
      this.iX = ((ImageView)paramViewGroup.findViewById(2131368954));
      this.iY = ((ImageView)paramViewGroup.findViewById(2131368953));
      this.iZ = ((ImageView)paramViewGroup.findViewById(2131369684));
      this.pN = ((TextView)paramViewGroup.findViewById(2131381728));
      this.pq = ((TextView)paramViewGroup.findViewById(2131373382));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131381724));
      this.kz = paramViewGroup.findViewById(2131377159);
      this.kA = paramViewGroup.findViewById(2131381717);
      this.ky = paramViewGroup.findViewById(2131376672);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131370125));
      this.iT = ((ImageView)paramViewGroup.findViewById(2131372700));
      this.ps = ((TextView)paramViewGroup.findViewById(2131372701));
      this.pt = ((TextView)paramViewGroup.findViewById(2131370088));
      this.kr = paramViewGroup.findViewById(2131379823);
      this.ks = paramViewGroup.findViewById(2131379850);
      this.dI = ((LinearLayout)paramViewGroup.findViewById(2131370306));
      this.pO = ((TextView)paramViewGroup.findViewById(2131362145));
      this.dJ = ((LinearLayout)paramViewGroup.findViewById(2131370156));
      this.pP = ((TextView)paramViewGroup.findViewById(2131362068));
      this.ja = ((ImageView)paramViewGroup.findViewById(2131362067));
      this.k = ((KandianUrlImageView)paramViewGroup.findViewById(2131367005));
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    public boolean z(View paramView)
    {
      if (!muj.af(lgf.b(this.b, paramView))) {}
      while (kwz.c(paramView) < 80.0F) {
        return false;
      }
      return true;
    }
  }
  
  public static class g
    extends lgf.f
    implements View.OnClickListener
  {
    private KanDianUrlRoundCornerImageView d;
    private View kB;
    private TextView pQ;
    private TextView pR;
    private TextView pS;
    
    public g(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    private void a(boolean paramBoolean, ImageView paramImageView)
    {
      if (paramImageView == null) {
        return;
      }
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      localScaleAnimation.setAnimationListener(new lgh(this, paramImageView, paramBoolean));
      paramImageView.startAnimation(localScaleAnimation);
    }
    
    private void cB(View paramView)
    {
      if ((paramView == null) || (this.b == null)) {
        return;
      }
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, paramView);
      if ((localBaseArticleInfo != null) && (this.b != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.h != null) && (localBaseArticleInfo.mVideoColumnInfo.h.jumpType != 3)) {
        muj.a(this.b.getActivity(), localBaseArticleInfo.mVideoColumnInfo.h);
      }
      for (;;)
      {
        kxm.c(localBaseArticleInfo, 1);
        return;
        paramView = lgf.b(paramView);
        if (paramView != null) {
          this.b.a().a(paramView.a(), localBaseArticleInfo, false, false);
        }
      }
    }
    
    private void cC(View paramView)
    {
      boolean bool2 = true;
      if (paramView == null) {}
      BaseArticleInfo localBaseArticleInfo;
      do
      {
        return;
        localBaseArticleInfo = lgf.b(this.b, paramView);
      } while ((localBaseArticleInfo == null) || (localBaseArticleInfo.mSocialFeedInfo == null));
      int i;
      SocializeFeedsInfo localSocializeFeedsInfo;
      label68:
      int j;
      label81:
      label94:
      long l;
      if (localBaseArticleInfo.mSocialFeedInfo.aSH == 1)
      {
        i = 1;
        if (i == 0) {
          break label184;
        }
        localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.mLikeCount -= 1;
        localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
        if (i == 0) {
          break label206;
        }
        j = 0;
        localSocializeFeedsInfo.aSH = j;
        if (i != 0) {
          break label211;
        }
        bool1 = true;
        a(bool1, (ImageView)paramView);
        paramView = kxm.a();
        if (paramView != null)
        {
          paramView = (oep)paramView.getBusinessHandler(126);
          if (i != 0) {
            break label217;
          }
          bool1 = true;
          label129:
          paramView.a(localBaseArticleInfo, bool1);
        }
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          lbz.a().j((ArticleInfo)localBaseArticleInfo);
        }
        l = localBaseArticleInfo.mAlgorithmID;
        if (i != 0) {
          break label223;
        }
      }
      label184:
      label206:
      label211:
      label217:
      label223:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        kxm.U(l, bool1);
        return;
        i = 0;
        break;
        localSocializeFeedsInfo = localBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.mLikeCount += 1;
        break label68;
        j = 1;
        break label81;
        bool1 = false;
        break label94;
        bool1 = false;
        break label129;
      }
    }
    
    private void cz(View paramView)
    {
      paramView = lgf.b(this.b, paramView);
      if ((paramView != null) && (this.b != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.amw))
      {
        this.pS.setSelected(false);
        Object localObject = paramView.mVideoColumnInfo;
        ((VideoColumnInfo)localObject).subscribeCount += 1;
        paramView.mVideoColumnInfo.amw = true;
        if ((paramView instanceof ArticleInfo)) {
          lbz.a().j((ArticleInfo)paramView);
        }
        localObject = Message.obtain();
        ((Message)localObject).obj = this;
        ((Message)localObject).arg1 = paramView.mVideoColumnInfo.aHc;
        ((Message)localObject).what = 1;
        lgf.a(this.b).sendMessageDelayed((Message)localObject, 3000L);
        muj.a(this.b.getActivity(), paramView.mVideoColumnInfo.j);
        muj.b(kxm.a(), paramView.mVideoColumnInfo.aHc);
        kxm.c(paramView, 2);
      }
    }
    
    private int m(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 2130847236;
      }
      return 2130843755;
    }
    
    private void qU(int paramInt)
    {
      BaseArticleInfo localBaseArticleInfo = lgf.b(this.b, this.pS);
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mVideoColumnInfo != null) && (localBaseArticleInfo.mVideoColumnInfo.aHc == paramInt)) {
        muj.a(this.pS, 8, 600);
      }
    }
    
    public void a(VideoColumnInfo paramVideoColumnInfo)
    {
      if (paramVideoColumnInfo == null)
      {
        this.kB.setVisibility(8);
        return;
      }
      this.kB.setVisibility(0);
      try
      {
        a(this.d, new URL(paramVideoColumnInfo.aiO));
        String str = "";
        if (!TextUtils.isEmpty(paramVideoColumnInfo.columnName)) {
          str = "#" + paramVideoColumnInfo.columnName;
        }
        this.pQ.setText(str);
        if (paramVideoColumnInfo.amw)
        {
          this.pS.setVisibility(8);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
        this.pS.setVisibility(0);
        this.pS.setSelected(true);
      }
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = super.c(paramInt, paramViewGroup);
      this.kB = ((ViewStub)paramViewGroup.findViewById(2131381634)).inflate();
      this.kB.setId(2131381634);
      this.d = ((KanDianUrlRoundCornerImageView)this.kB.findViewById(2131369710));
      this.pQ = ((TextView)this.kB.findViewById(2131380614));
      this.pR = ((TextView)this.kB.findViewById(2131380949));
      this.pS = ((TextView)this.kB.findViewById(2131380948));
      paramViewGroup.findViewById(2131381632).setVisibility(0);
      this.d.setCorner(aqnm.dpToPx(2.0F));
      this.kB.setOnClickListener(this);
      this.pS.setOnClickListener(this);
      ViewGroup.LayoutParams localLayoutParams = this.g.getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = aqnm.dip2px(0.0F);
        this.g.setLayoutParams(localLayoutParams);
      }
      this.kA.setPadding(aqnm.dpToPx(1.0F), this.kA.getPaddingTop(), this.kA.getPaddingRight(), this.kA.getPaddingBottom());
      this.pN.setVisibility(0);
      return paramViewGroup;
    }
    
    public void c(BaseArticleInfo paramBaseArticleInfo)
    {
      boolean bool = true;
      if (paramBaseArticleInfo == null) {
        return;
      }
      this.i.setVisibility(8);
      this.k.setVisibility(8);
      this.g.setTextColor(Color.parseColor("#797E8E"));
      label73:
      int i;
      if (paramBaseArticleInfo.mVideoPlayCount == 0)
      {
        this.g.setVisibility(8);
        if (paramBaseArticleInfo.mSocialFeedInfo == null) {
          break label114;
        }
        if (paramBaseArticleInfo.mSocialFeedInfo.aSH != 1) {
          break label108;
        }
        i = m(bool);
        int j = paramBaseArticleInfo.mSocialFeedInfo.mLikeCount;
      }
      for (;;)
      {
        this.iY.setImageResource(i);
        return;
        this.g.setVisibility(0);
        break;
        label108:
        bool = false;
        break label73;
        label114:
        i = 2130843755;
      }
    }
    
    public void onClick(View paramView)
    {
      lgf.cu(paramView);
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        cC(paramView);
        continue;
        cB(paramView);
        continue;
        cz(paramView);
      }
    }
  }
  
  class h
    extends Handler
  {
    private h() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      lgf.g.a((lgf.g)paramMessage.obj, paramMessage.arg1);
    }
  }
  
  public static abstract class i
    implements mza.c
  {
    protected lgf b;
    public View itemView;
    protected Context mContext;
    protected View.OnClickListener mOnClickListener;
    public int position;
    
    public i(Context paramContext, lgf paramlgf)
    {
      this.mContext = paramContext;
      this.b = paramlgf;
    }
    
    protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
    {
      a(paramKandianUrlImageView, paramURL, false);
    }
    
    protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
    {
      kwz.a(paramKandianUrlImageView, paramURL, this.mContext, paramBoolean);
    }
    
    public void a(mye.b paramb, int paramInt1, int paramInt2) {}
    
    public abstract View c(int paramInt, ViewGroup paramViewGroup);
    
    public void setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.mOnClickListener = paramOnClickListener;
    }
  }
  
  public static class j
    extends lgf.i
  {
    public BaseArticleInfo e;
    public BaseArticleInfo f;
    public KandianUrlImageView p;
    public TextView pE;
    public TextView pF;
    public TextView pG;
    public TextView pH;
    public TextView pI;
    public TextView pJ;
    public TextView pK;
    public TextView pL;
    public KandianUrlImageView r;
    
    public j(Context paramContext, lgf paramlgf)
    {
      super(paramlgf);
    }
    
    public View c(int paramInt, ViewGroup paramViewGroup)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560562, paramViewGroup, false);
      this.p = ((KandianUrlImageView)paramViewGroup.findViewById(2131368136));
      this.pG = ((TextView)paramViewGroup.findViewById(2131370380));
      this.pH = ((TextView)paramViewGroup.findViewById(2131370384));
      this.pE = ((TextView)paramViewGroup.findViewById(2131370360));
      this.pI = ((TextView)paramViewGroup.findViewById(2131370379));
      this.r = ((KandianUrlImageView)paramViewGroup.findViewById(2131368138));
      this.pJ = ((TextView)paramViewGroup.findViewById(2131377316));
      this.pK = ((TextView)paramViewGroup.findViewById(2131377322));
      this.pF = ((TextView)paramViewGroup.findViewById(2131377296));
      this.pL = ((TextView)paramViewGroup.findViewById(2131377315));
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgf
 * JD-Core Version:    0.7.0.1
 */