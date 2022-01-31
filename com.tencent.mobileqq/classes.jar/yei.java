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

public class yei
  extends yef
  implements yiy, yow
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private yem jdField_a_of_type_Yem;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = ImmersiveUtils.a(16.0F);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = ImmersiveUtils.a(13.0F);
  private boolean jdField_c_of_type_Boolean = true;
  private int d = ImmersiveUtils.a(3.0F);
  private int e;
  private int f = -1;
  
  public yei(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  @NotNull
  private FrameLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    FrameLayout localFrameLayout = getCommonHeaderFooterWrapper(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#222222"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.leftMargin = ImmersiveUtils.a(16.0F);
    localLayoutParams.rightMargin = ImmersiveUtils.a(16.0F);
    paramViewGroup.setText(alud.a(2131701893));
    return localFrameLayout;
  }
  
  private void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    zaj.b(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    ymg.b(getContext(), paramStFeed.poster.id.get(), new yek(this, paramStFeed));
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    if ((getDataList() == null) || (getDataList().size() == 0)) {
      return null;
    }
    int i = this.e + 1;
    while (i < getDataList().size())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
      if ((localStFeed != null) && (ybt.a(localStFeed.type.get())))
      {
        this.e = i;
        return localStFeed;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, yls paramyls, ylr paramylr)
  {
    if (paramStFeed == null) {
      return;
    }
    yll.a(getContext(), paramStFeed, paramyls, paramylr);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    this.e = -1;
    b();
    getLoadInfo().a(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().b(paramString);
    setDatas((ArrayList)paramList);
    notifyLoadingComplete(true);
  }
  
  public void a(yem paramyem)
  {
    this.jdField_a_of_type_Yem = paramyem;
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
    getLoadInfo().a(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().b(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      addAll(paramList);
    }
    notifyLoadingComplete(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((getDataList() == null) || (getDataList().size() == 0) || (this.e > getDataList().size())) {
      return;
    }
    int i = this.e;
    while (i >= 0)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
      if ((localStFeed != null) && (ybt.a(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
      {
        this.e = i;
        return;
      }
      i -= 1;
    }
    this.e = -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    int i;
    if (!this.mHasInitialized) {
      i = 4;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = this.mDataList.size();
        i = j;
      } while (j <= 0);
      i = j;
    } while (!this.jdField_a_of_type_Boolean);
    return j + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.jdField_a_of_type_Boolean) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.jdField_c_of_type_Int;
      return;
    }
    if (paramRecyclerView.getSpanIndex() % 2 == 0) {
      paramRect.left = this.jdField_a_of_type_Int;
    }
    for (paramRect.right = (this.d / 2);; paramRect.right = this.jdField_a_of_type_Int)
    {
      paramRect.bottom = this.jdField_b_of_type_Int;
      return;
      paramRect.left = (this.d / 2);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if ((!bhrz.a(i, getDataList())) && (((CertifiedAccountMeta.StFeed)getDataList().get(i)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  public int getSpanCount(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public String getUniqueKey()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void handleShareDataChange(String paramString, yif paramyif)
  {
    super.handleShareDataChange(paramString, paramyif);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramyif.jdField_a_of_type_JavaLangObject != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramyif.jdField_a_of_type_JavaLangObject);
      if (paramyif.jdField_a_of_type_Boolean) {
        onRefreshData();
      }
    }
  }
  
  public void loadData(yii paramyii)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = null;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 1, getLoadInfo().b(), getLoadInfo().b());
    }
    if (this.f != -1) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.f, getLoadInfo().b(), getLoadInfo().b());
    }
    if (localGetSubscribeFeedListRequest == null) {
      return;
    }
    VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new yej(this, paramyii));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (bhrz.a(i, getDataList())) {
      return;
    }
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
    ((yen)paramViewHolder).a(localStFeed, getExtraTypeInfo());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new yen(this, a(paramViewGroup));
    }
    if (paramInt == 1) {
      return new yen(this, new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    return new yen(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    getParentRecyclerView().addOnScrollListener(new yel(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yei
 * JD-Core Version:    0.7.0.1
 */