import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class zds
  extends zdp
  implements SimpleEventReceiver, zmo
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private int jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  private zdw jdField_a_of_type_Zdw;
  private int b = ImmersiveUtils.a(16.0F);
  private int jdField_c_of_type_Int = ImmersiveUtils.a(13.0F);
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = ImmersiveUtils.a(3.0F);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int f = -1;
  private int g;
  private int h;
  private int i = -1;
  private int j = 99;
  
  public zds(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RecyclerView.ViewHolder a(ViewGroup paramViewGroup)
  {
    Object localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559651, paramViewGroup, false);
    paramViewGroup = new zec(this, (View)localObject);
    this.g = ((View)localObject).getResources().getDisplayMetrics().widthPixels;
    int k = (int)(this.g * 0.5F - ViewUtils.dpToPx(8.5F));
    this.h = (k - ViewUtils.dpToPx(7.0F));
    int m = this.h;
    int n = ViewUtils.dpToPx(54.0F);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = k;
    ((RelativeLayout.LayoutParams)localObject).height = (n + m);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.h;
    ((RelativeLayout.LayoutParams)localObject).height = this.h;
    return paramViewGroup;
  }
  
  @NotNull
  private FrameLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    FrameLayout localFrameLayout = a(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#222222"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.leftMargin = ImmersiveUtils.a(16.0F);
    localLayoutParams.rightMargin = ImmersiveUtils.a(16.0F);
    paramViewGroup.setText(amtj.a(2131700655));
    return localFrameLayout;
  }
  
  private boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return paramStFeed.live.liveUin.get() != 0L;
  }
  
  private void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    zxp.b(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    zkf.b(a(), paramStFeed.poster.id.get(), new zdu(this, paramStFeed));
  }
  
  public int a()
  {
    return 3;
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    if ((a() == null) || (a().size() == 0)) {
      return null;
    }
    int k = this.jdField_e_of_type_Int + 1;
    while (k < a().size())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)a().get(k);
      if ((localStFeed != null) && (zbh.a(localStFeed.type.get())))
      {
        this.jdField_e_of_type_Int = k;
        return localStFeed;
      }
      k += 1;
    }
    return null;
  }
  
  public String a()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, zjr paramzjr, zjq paramzjq)
  {
    if (paramStFeed == null) {
      return;
    }
    zjm.a(a(), paramStFeed, paramzjr, paramzjq);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt, String paramString3)
  {
    paramContext = new bkjl(paramContext, "subscription", paramString1, paramString2, false, paramArrayList, "", paramInt);
    paramContext.d = paramString3;
    bkke.a(paramContext);
  }
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int k = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.jdField_c_of_type_Boolean) && ((k == 0) || (k == 1)))
    {
      paramRect.bottom = this.jdField_c_of_type_Int;
      return;
    }
    paramRect.bottom = this.b;
  }
  
  public void a(Bundle paramBundle)
  {
    a().addOnScrollListener(new zdv(this));
  }
  
  public void a(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = paramFolderRecommendHeadItemView;
  }
  
  public void a(String paramString, yzn paramyzn)
  {
    super.a(paramString, paramyzn);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramyzn.jdField_a_of_type_JavaLangObject != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramyzn.jdField_a_of_type_JavaLangObject);
      if (paramyzn.jdField_a_of_type_Boolean) {
        a();
      }
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    this.jdField_e_of_type_Int = -1;
    d();
    a().a(paramBoolean);
    a().a(paramStCommonExt);
    a().a(paramString);
    a((ArrayList)paramList);
    a(true);
  }
  
  public void a(yzu paramyzu)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest;
    if ((this.f != -1) && ((paramyzu.c()) || (paramyzu.d()))) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, a().b(), a().a(), null);
    }
    for (;;)
    {
      if (localGetSubscribeFeedListRequest == null)
      {
        return;
        if ((this.f != -1) && (paramyzu.e())) {
          localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, a().b(), a().a(), a().b());
        }
      }
      else
      {
        VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedListRequest, new zdt(this, paramyzu));
        return;
      }
      localGetSubscribeFeedListRequest = null;
    }
  }
  
  public void a(zdw paramzdw)
  {
    this.jdField_a_of_type_Zdw = paramzdw;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (!d()) {
        break label53;
      }
      a().a(paramBoolean, a().a());
    }
    label53:
    while ((a() == null) || (a() == null) || (a().size() != 0)) {
      return;
    }
    a().a(paramBoolean, false);
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)localIterator.next();
      try
      {
        localArrayList.add(new String(localStFeed.toByteArray(), "ISO8859_1"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    a(paramStFeed);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    b(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    a().a(paramBoolean);
    a().a(paramStCommonExt);
    a().a(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramList);
    }
    a(true);
  }
  
  public int c(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((a() == null) || (a().size() == 0) || (this.jdField_e_of_type_Int > a().size())) {
      return;
    }
    int k = this.jdField_e_of_type_Int;
    while (k >= 0)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)a().get(k);
      if ((localStFeed != null) && (zbh.a(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
      {
        this.jdField_e_of_type_Int = k;
        return;
      }
      k -= 1;
    }
    this.jdField_e_of_type_Int = -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int getItemCount()
  {
    int k;
    if (!this.jdField_a_of_type_Boolean) {
      k = 4;
    }
    int m;
    do
    {
      do
      {
        return k;
        m = this.jdField_a_of_type_JavaUtilArrayList.size();
        k = m;
      } while (m <= 0);
      k = m;
    } while (!this.jdField_c_of_type_Boolean);
    return m + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      k = paramInt - 1;
    }
    if (k == -1) {
      return 100000;
    }
    if (a((CertifiedAccountMeta.StFeed)a().get(k))) {
      return 100003;
    }
    if ((!ArrayUtils.isOutOfArrayIndex(k, a())) && (((CertifiedAccountMeta.StFeed)a().get(k)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  @SuppressLint({"WrongConstant"})
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      k = paramInt - 1;
    }
    if (ArrayUtils.isOutOfArrayIndex(k, a())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, k, getItemId(k));
      return;
      CertifiedAccountMeta.StFeed localStFeed;
      if ((paramViewHolder instanceof zec))
      {
        localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((zec)paramViewHolder).a(localStFeed);
        ((zec)paramViewHolder).a((zec)paramViewHolder, localStFeed);
      }
      else
      {
        localStFeed = (CertifiedAccountMeta.StFeed)a().get(k);
        ((zdx)paramViewHolder).a(localStFeed, a());
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new zdx(this, a(paramViewGroup));
    }
    if (paramInt == 1) {
      return new zdx(this, new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    if (paramInt == 100003) {
      return a(paramViewGroup);
    }
    return new zdx(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zds
 * JD-Core Version:    0.7.0.1
 */