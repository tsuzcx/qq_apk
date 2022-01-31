import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.image.URLImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class xzg
  extends ydp<CertifiedAccountMeta.StFollowRcmd>
{
  public static int a;
  public static String a;
  private int b = ImmersiveUtils.a(20.0F);
  private int c = ImmersiveUtils.a(12.5F);
  private boolean d = true;
  private boolean e = true;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BlankRecommendFeedsAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.a(12.0F);
  }
  
  public xzg(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558697, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131368878);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.f)
    {
      localURLImageView.setColorFilter(-1728053248);
      ((TextView)paramViewGroup.findViewById(2131379048)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131365360).setBackgroundColor(-14540254);
      return paramViewGroup;
    }
    localURLImageView.clearColorFilter();
    return paramViewGroup;
  }
  
  private void a(List<CertifiedAccountMeta.StFollowRcmd> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a().a(paramBoolean);
    a().a(paramStCommonExt);
    if ((paramList != null) && (paramList.size() > 0)) {
      a((ArrayList)paramList);
    }
    d(true);
  }
  
  private View b(ViewGroup paramViewGroup)
  {
    yvu.b("auth_follow", "exp_more", 0, 0, new String[0]);
    paramViewGroup = LayoutInflater.from(a()).inflate(2131558696, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131369683);
    GradientDrawable localGradientDrawable;
    if (localLinearLayout != null)
    {
      localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      if (!this.f) {
        break label102;
      }
    }
    label102:
    for (int i = -13224394;; i = -460552)
    {
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new xzi(this));
      if (this.f) {
        ((TextView)paramViewGroup.findViewById(2131379047)).setTextColor(-5723992);
      }
      return paramViewGroup;
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public COMM.StCommonExt a()
  {
    if (a().a() != null) {
      return a().a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.h = false;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.b;
      paramRect.left = jdField_a_of_type_Int;
      paramRect.right = jdField_a_of_type_Int;
      paramRect.bottom = this.c;
    }
    while (paramView.getId() != 2131375997) {
      return;
    }
    paramRect.top = ImmersiveUtils.a(19.5F);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = (-ImmersiveUtils.a(30.0F));
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(xzj paramxzj)
  {
    if (a() != null)
    {
      this.h = false;
      SubscribeGetFollowRcmdRequest localSubscribeGetFollowRcmdRequest = new SubscribeGetFollowRcmdRequest(null);
      localSubscribeGetFollowRcmdRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localSubscribeGetFollowRcmdRequest, new xzh(this, localSubscribeGetFollowRcmdRequest, paramxzj));
    }
  }
  
  public void a(yeb paramyeb) {}
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public int getItemCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (!this.h)
    {
      if (j > 0)
      {
        int i = j;
        if (this.d) {
          i = j + 1;
        }
        j = i;
        if (this.e) {
          j = i + 1;
        }
        return j;
      }
      return 0;
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.d) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (!bhns.a(i, b())) {
      return 100002;
    }
    return 100001;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.d) {
      i = paramInt - 1;
    }
    if (bhns.a(i, b())) {
      return;
    }
    CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)b().get(i);
    ((xzk)paramViewHolder).a(localStFollowRcmd, i);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new xzk(this, a(paramViewGroup));
    }
    if (paramInt == 100001) {
      return new xzk(this, b(paramViewGroup));
    }
    paramViewGroup = new BlankRecommendItemView(paramViewGroup.getContext());
    paramViewGroup.setIsInNightMode(this.f);
    return new xzk(this, paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzg
 * JD-Core Version:    0.7.0.1
 */