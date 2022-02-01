import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class ofv
  extends auwm<stSimpleMetaFeed, auwn<stSimpleMetaFeed>>
{
  public static int beL;
  public RockDownloadListenerWrapper a;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  public RecyclerViewWithHeaderFooter a;
  private ofv.a jdField_a_of_type_Ofv$a;
  public oiq a;
  public int beK;
  public int beM;
  public final int beN;
  public final int beO;
  public final int beP;
  public final int mScreenWidth;
  
  public ofv(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.mScreenWidth = ankt.aE(paramContext);
    this.beN = ankt.dip2px(5.0F);
    this.beO = ankt.dip2px(18.0F);
    this.beP = ankt.dip2px(14.0F);
  }
  
  public RockDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = new WSRecommendAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper;
  }
  
  public oiq a()
  {
    if (this.jdField_a_of_type_Oiq == null) {
      this.jdField_a_of_type_Oiq = oir.c(100, 2);
    }
    return this.jdField_a_of_type_Oiq;
  }
  
  public void a(auwn<stSimpleMetaFeed> paramauwn)
  {
    if (this.jdField_a_of_type_Ofv$a != null) {
      this.jdField_a_of_type_Ofv$a.c(paramauwn);
    }
  }
  
  public void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = paramWSRedDotPushMsg;
  }
  
  public void a(ofv.a parama)
  {
    this.jdField_a_of_type_Ofv$a = parama;
  }
  
  public auwn<stSimpleMetaFeed> b(ViewGroup paramViewGroup, int paramInt)
  {
    return ojj.a(paramInt, paramViewGroup, this);
  }
  
  public void b(auwn<stSimpleMetaFeed> paramauwn, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)getItem(paramInt);
    if (localstSimpleMetaFeed != null) {
      paramauwn.P(localstSimpleMetaFeed);
    }
  }
  
  public int dr(int paramInt)
  {
    Object localObject = be();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stSimpleMetaFeed)((List)localObject).get(paramInt);
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).waterFallCardStyle != null))
      {
        paramInt = ((stSimpleMetaFeed)localObject).waterFallCardStyle.cardType;
        if (ojj.em(paramInt)) {
          return paramInt;
        }
        return 1;
      }
    }
    return 1;
  }
  
  public void dx(List<stSimpleMetaFeed> paramList)
  {
    List localList = be();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void dz(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + this.beM;
    if ((i < 0) || (i >= be().size())) {
      ooz.w("weishi-ding", "点赞position越界:" + i);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      localstSimpleMetaFeed = (stSimpleMetaFeed)getItem(i);
    } while (localstSimpleMetaFeed == null);
    paramInt1 = localstSimpleMetaFeed.ding_count;
    if (paramInt2 == 1) {
      paramInt1 += 1;
    }
    for (;;)
    {
      localstSimpleMetaFeed.ding_count = paramInt1;
      localstSimpleMetaFeed.is_ding = paramInt2;
      notifyItemChanged(i);
      ooz.d("weishi-ding", "第" + i + "个条目的点赞改变了~~~");
      return;
      paramInt1 -= 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(auwn<stSimpleMetaFeed> paramauwn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofv
 * JD-Core Version:    0.7.0.1
 */