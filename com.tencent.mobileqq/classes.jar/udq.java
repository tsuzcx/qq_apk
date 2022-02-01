import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class udq
  extends blsv<stSimpleMetaFeed, blsy<stSimpleMetaFeed>>
{
  public static int b;
  public int a;
  public RockDownloadListenerWrapper a;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  public RecyclerViewWithHeaderFooter a;
  private udr jdField_a_of_type_Udr;
  public ugy a;
  public int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public udq(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.d = bdep.e(paramContext);
    this.e = bdep.a(5.0F);
    this.f = bdep.a(18.0F);
    this.g = bdep.a(14.0F);
  }
  
  public int a(int paramInt)
  {
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stSimpleMetaFeed)((List)localObject).get(paramInt);
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).waterFallCardStyle != null))
      {
        paramInt = ((stSimpleMetaFeed)localObject).waterFallCardStyle.cardType;
        if (uiq.a(paramInt)) {
          return paramInt;
        }
        return 1;
      }
    }
    return 1;
  }
  
  public blsy<stSimpleMetaFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    return uiq.a(paramInt, paramViewGroup, this);
  }
  
  public RockDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = new WSRecommendAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper;
  }
  
  public ugy a()
  {
    if (this.jdField_a_of_type_Ugy == null) {
      this.jdField_a_of_type_Ugy = ugz.a(100, 2);
    }
    return this.jdField_a_of_type_Ugy;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + this.c;
    if ((i < 0) || (i >= a().size())) {
      uqf.c("weishi-ding", "点赞position越界:" + i);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      localstSimpleMetaFeed = (stSimpleMetaFeed)a(i);
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
      uqf.b("weishi-ding", "第" + i + "个条目的点赞改变了~~~");
      return;
      paramInt1 -= 1;
    }
  }
  
  public void a(blsy<stSimpleMetaFeed> paramblsy)
  {
    if (this.jdField_a_of_type_Udr != null) {
      this.jdField_a_of_type_Udr.a(paramblsy);
    }
  }
  
  public void a(blsy<stSimpleMetaFeed> paramblsy, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)a(paramInt);
    if (localstSimpleMetaFeed != null) {
      paramblsy.a(localstSimpleMetaFeed);
    }
  }
  
  public void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = paramWSRedDotPushMsg;
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void a(udr paramudr)
  {
    this.jdField_a_of_type_Udr = paramudr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udq
 * JD-Core Version:    0.7.0.1
 */