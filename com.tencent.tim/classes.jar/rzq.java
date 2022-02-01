import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class rzq
  extends RecyclerView.Adapter<rzq.a>
{
  protected CertifiedAccountMeta.StEntry a;
  private rzp a;
  private boolean aKG;
  private boolean aKH;
  private boolean avA;
  protected List<sam> mDatas;
  
  public rzq.a a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    paramViewGroup = new RecyclerView.LayoutParams(aqcx.dip2px((Context)localObject, 144.0F), aqcx.dip2px((Context)localObject, 213.0F));
    if (paramInt == 3)
    {
      localObject = new RecommendBannerEntryItemView((Context)localObject);
      ((RecommendBannerEntryItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerEntryItemView)localObject).setIsCloseShadow(this.aKG);
      ((RecommendBannerEntryItemView)localObject).setInNightMode(this.avA);
      return new rzq.a((View)localObject);
    }
    if (paramInt == 1)
    {
      localObject = new RecommendBannerItemView((Context)localObject);
      ((RecommendBannerItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerItemView)localObject).setIsCloseShadow(this.aKG);
      ((RecommendBannerItemView)localObject).setInNightMode(this.avA);
      ((RecommendBannerItemView)localObject).setInNewFolderPage(this.aKH);
      return new rzq.a((View)localObject);
    }
    if (paramInt == 2)
    {
      localObject = new RecommendBannerFeedItemView((Context)localObject);
      ((RecommendBannerFeedItemView)localObject).setLayoutParams(paramViewGroup);
      ((RecommendBannerFeedItemView)localObject).setIsCloseShadow(this.aKG);
      ((RecommendBannerFeedItemView)localObject).setInNightMode(this.avA);
      return new rzq.a((View)localObject);
    }
    return null;
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<sam> paramList)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    this.mDatas = paramList;
  }
  
  public void a(rzp paramrzp)
  {
    this.jdField_a_of_type_Rzp = paramrzp;
  }
  
  public void a(rzq.a parama)
  {
    super.onViewAttachedToWindow(parama);
    int i = parama.getAdapterPosition() - uh();
    if ((!auqt.b(i, getDatas())) && (getDatas().get(i) != null)) {
      sqn.b(((sam)getDatas().get(i)).user.id.get(), "auth_page", "recom_exp", 0, 0, new String[] { "", "", String.valueOf(i), ((sam)getDatas().get(i)).user.nick.get() });
    }
  }
  
  public void a(rzq.a parama, int paramInt)
  {
    if (parama == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
      if ((parama.itemView instanceof RecommendBannerEntryItemView))
      {
        ((RecommendBannerEntryItemView)parama.itemView).setEntry(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry);
      }
      else
      {
        int i = paramInt - uh();
        if ((parama.itemView instanceof RecommendBannerItemView))
        {
          RecommendBannerItemView localRecommendBannerItemView = (RecommendBannerItemView)parama.itemView;
          localRecommendBannerItemView.setData(((sam)getDatas().get(i)).user, i);
          localRecommendBannerItemView.setRecommendBannerFolwListener(this.jdField_a_of_type_Rzp);
        }
        else if ((parama.itemView instanceof RecommendBannerFeedItemView))
        {
          ((RecommendBannerFeedItemView)parama.itemView).setData(((sam)getDatas().get(i)).feed, i);
        }
      }
    }
  }
  
  public List<sam> getDatas()
  {
    return this.mDatas;
  }
  
  public int getItemCount()
  {
    if (getDatas() == null) {
      return uh();
    }
    return getDatas().size() + uh();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null)) {
      return 3;
    }
    return ((sam)getDatas().get(paramInt - uh())).type;
  }
  
  public void setInNewFolderPage(boolean paramBoolean)
  {
    this.aKH = paramBoolean;
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  protected int uh()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry != null) {
      return 1;
    }
    return 0;
  }
  
  public void us(boolean paramBoolean)
  {
    this.aKG = paramBoolean;
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzq
 * JD-Core Version:    0.7.0.1
 */