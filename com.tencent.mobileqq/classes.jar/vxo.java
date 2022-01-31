import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_COMM.COMM.StCommonExt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.image.URLImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class vxo
  extends wbp<CertifiedAccountMeta.StFollowRcmd>
{
  public static int a;
  public static String a;
  private int b = ImmersiveUtils.a(20.0F);
  private int jdField_c_of_type_Int = ImmersiveUtils.a(12.5F);
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = true;
  private boolean e;
  private boolean f = true;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BlankRecommendFeedsAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.a(12.0F);
  }
  
  public vxo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(a()).inflate(2131493110, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131303036);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.e)
    {
      localURLImageView.setColorFilter(-1728053248);
      ((TextView)paramViewGroup.findViewById(2131312606)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131299708).setBackgroundColor(-14540254);
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
    paramViewGroup = LayoutInflater.from(a()).inflate(2131493109, paramViewGroup, false);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131303035);
    if (localImageView != null)
    {
      localImageView.setImageDrawable(a().getResources().getDrawable(2130849128));
      if (!this.e) {
        break label81;
      }
      localImageView.setColorFilter(-13224394);
    }
    for (;;)
    {
      if (this.e) {
        ((TextView)paramViewGroup.findViewById(2131312605)).setTextColor(-10132123);
      }
      return paramViewGroup;
      label81:
      localImageView.setColorFilter(-4801590);
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
  
  public void a()
  {
    super.a();
    this.g = false;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.b;
      paramRect.left = jdField_a_of_type_Int;
      paramRect.right = jdField_a_of_type_Int;
      paramRect.bottom = this.jdField_c_of_type_Int;
    }
    while (paramView.getId() != 2131303757) {
      return;
    }
    paramRect.top = ImmersiveUtils.a(31.5F);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = (-ImmersiveUtils.a(50.0F));
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(vxq paramvxq)
  {
    if (a() != null)
    {
      this.g = false;
      SubscribeGetFollowRcmdRequest localSubscribeGetFollowRcmdRequest = new SubscribeGetFollowRcmdRequest(null);
      localSubscribeGetFollowRcmdRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localSubscribeGetFollowRcmdRequest, new vxp(this, localSubscribeGetFollowRcmdRequest, paramvxq));
    }
  }
  
  public void a(wca paramwca) {}
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int getItemCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (!this.g)
    {
      if (j > 0)
      {
        int i = j;
        if (this.jdField_c_of_type_Boolean) {
          i = j + 1;
        }
        j = i;
        if (this.d) {
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
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (!been.a(i, b())) {
      return 100002;
    }
    return 100001;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (been.a(i, b())) {
      return;
    }
    CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)b().get(i);
    ((vxr)paramViewHolder).a(localStFollowRcmd, i);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new vxr(this, a(paramViewGroup));
    }
    if (paramInt == 100001) {
      return new vxr(this, b(paramViewGroup));
    }
    paramViewGroup = new BlankRecommendItemView(paramViewGroup.getContext());
    paramViewGroup.setIsInNightMode(this.e);
    return new vxr(this, paramViewGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vxo
 * JD-Core Version:    0.7.0.1
 */