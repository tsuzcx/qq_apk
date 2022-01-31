import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;

public class yci
  extends RecyclerView.Adapter<ycj>
{
  protected CertifiedAccountMeta.StEntry a;
  protected List<ydn> a;
  private ych jdField_a_of_type_Ych;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  protected int a()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null) {
      return 1;
    }
    return 0;
  }
  
  public List<ydn> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public ycj a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    paramViewGroup = new RecyclerView.LayoutParams(bdaq.a((Context)localObject, 144.0F), bdaq.a((Context)localObject, 213.0F));
    if (paramInt == 3)
    {
      localObject = new RecommendBannerEntryItemView((Context)localObject);
      ((RecommendBannerEntryItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerEntryItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerEntryItemView)localObject).setInNightMode(this.b);
      return new ycj(this, (View)localObject);
    }
    if (paramInt == 1)
    {
      localObject = new RecommendBannerItemView((Context)localObject);
      ((RecommendBannerItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerItemView)localObject).setInNightMode(this.b);
      ((RecommendBannerItemView)localObject).setInNewFolderPage(this.c);
      return new ycj(this, (View)localObject);
    }
    if (paramInt == 2)
    {
      localObject = new RecommendBannerFeedItemView((Context)localObject);
      ((RecommendBannerFeedItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerFeedItemView)localObject).setIsCloseShadow(this.jdField_a_of_type_Boolean);
      ((RecommendBannerFeedItemView)localObject).setInNightMode(this.b);
      return new ycj(this, (View)localObject);
    }
    return null;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<ydn> paramList)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(ych paramych)
  {
    this.jdField_a_of_type_Ych = paramych;
  }
  
  public void a(ycj paramycj)
  {
    super.onViewAttachedToWindow(paramycj);
    int i = paramycj.getAdapterPosition() - a();
    if ((!bhrz.a(i, a())) && (a().get(i) != null)) {
      zaj.a(((ydn)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), "auth_page", "recom_exp", 0, 0, new String[] { "", "", String.valueOf(i), ((ydn)a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get() });
    }
  }
  
  public void a(ycj paramycj, int paramInt)
  {
    if (paramycj == null) {}
    do
    {
      return;
      if ((paramycj.itemView instanceof RecommendBannerEntryItemView))
      {
        ((RecommendBannerEntryItemView)paramycj.itemView).setEntry(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry);
        return;
      }
      paramInt -= a();
      if ((paramycj.itemView instanceof RecommendBannerItemView))
      {
        paramycj = (RecommendBannerItemView)paramycj.itemView;
        paramycj.setData(((ydn)a().get(paramInt)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, paramInt);
        paramycj.setRecommendBannerFolwListener(this.jdField_a_of_type_Ych);
        return;
      }
    } while (!(paramycj.itemView instanceof RecommendBannerFeedItemView));
    ((RecommendBannerFeedItemView)paramycj.itemView).setData(((ydn)a().get(paramInt)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (a() == null) {
      return a();
    }
    return a().size() + a();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null)) {
      return 3;
    }
    return ((ydn)a().get(paramInt - a())).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yci
 * JD-Core Version:    0.7.0.1
 */