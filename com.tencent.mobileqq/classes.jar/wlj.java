import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class wlj
  extends wlg
  implements wpy, wvt
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private wln jdField_a_of_type_Wln;
  private int b = ImmersiveUtils.a(16.0F);
  private int jdField_c_of_type_Int = ImmersiveUtils.a(13.0F);
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = ImmersiveUtils.a(3.0F);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int f = -1;
  
  public wlj(Bundle paramBundle)
  {
    super(paramBundle);
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
    paramViewGroup.setText(ajyc.a(2131701497));
    return localFrameLayout;
  }
  
  private void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    xhe.b(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    wte.b(a(), paramStFeed.poster.id.get(), new wll(this, paramStFeed));
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    if ((b() == null) || (b().size() == 0)) {
      return null;
    }
    int i = this.jdField_e_of_type_Int + 1;
    while (i < b().size())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)b().get(i);
      if ((localStFeed != null) && (wiv.a(localStFeed.type.get())))
      {
        this.jdField_e_of_type_Int = i;
        return localStFeed;
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, wsq paramwsq, wsp paramwsp)
  {
    if (paramStFeed == null) {
      return;
    }
    wsj.a(a(), paramStFeed, paramwsq, paramwsp);
  }
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.jdField_c_of_type_Boolean) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.jdField_c_of_type_Int;
      return;
    }
    if (paramRecyclerView.getSpanIndex() % 2 == 0) {
      paramRect.left = this.jdField_a_of_type_Int;
    }
    for (paramRect.right = (this.jdField_d_of_type_Int / 2);; paramRect.right = this.jdField_a_of_type_Int)
    {
      paramRect.bottom = this.b;
      return;
      paramRect.left = (this.jdField_d_of_type_Int / 2);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    a().addOnScrollListener(new wlm(this));
  }
  
  public void a(String paramString, wpi paramwpi)
  {
    super.a(paramString, paramwpi);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramwpi.jdField_a_of_type_JavaLangObject != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramwpi.jdField_a_of_type_JavaLangObject);
      if (paramwpi.jdField_a_of_type_Boolean) {
        o();
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
    c();
    a().a(paramBoolean);
    a().a(paramStCommonExt);
    a().a(paramString);
    a((ArrayList)paramList);
    d(true);
  }
  
  public void a(wln paramwln)
  {
    this.jdField_a_of_type_Wln = paramwln;
  }
  
  public void a(wpn paramwpn)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = null;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 1, a().b(), a().a());
    }
    if (this.f != -1) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, a().b(), a().a());
    }
    if (localGetSubscribeFeedListRequest == null) {
      return;
    }
    VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new wlk(this, paramwpn));
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
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
      a(paramList);
    }
    d(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((b() == null) || (b().size() == 0) || (this.jdField_e_of_type_Int > b().size())) {
      return;
    }
    int i = this.jdField_e_of_type_Int;
    while (i >= 0)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)b().get(i);
      if ((localStFeed != null) && (wiv.a(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
      {
        this.jdField_e_of_type_Int = i;
        return;
      }
      i -= 1;
    }
    this.jdField_e_of_type_Int = -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    int i;
    if (!this.jdField_a_of_type_Boolean) {
      i = 4;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = j;
      } while (j <= 0);
      i = j;
    } while (!this.jdField_c_of_type_Boolean);
    return j + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if ((!bfmh.a(i, b())) && (((CertifiedAccountMeta.StFeed)b().get(i)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (bfmh.a(i, b())) {
      return;
    }
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)b().get(i);
    ((wlo)paramViewHolder).a(localStFeed, a());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new wlo(this, a(paramViewGroup));
    }
    if (paramInt == 1) {
      return new wlo(this, new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    return new wlo(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlj
 * JD-Core Version:    0.7.0.1
 */