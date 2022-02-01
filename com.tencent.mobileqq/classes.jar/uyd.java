import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class uyd
  extends blig<stSimpleMetaFeed, blij<stSimpleMetaFeed>>
{
  public static int b;
  public int a;
  public RockDownloadListenerWrapper a;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  public RecyclerViewWithHeaderFooter a;
  private uye jdField_a_of_type_Uye;
  public vbp a;
  public int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public uyd(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.d = ScreenUtil.getRealWidth(paramContext);
    this.e = ScreenUtil.dip2px(5.0F);
    this.f = ScreenUtil.dip2px(18.0F);
    this.g = ScreenUtil.dip2px(14.0F);
  }
  
  public int a(int paramInt)
  {
    Object localObject = b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stSimpleMetaFeed)((List)localObject).get(paramInt);
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).waterFallCardStyle != null))
      {
        paramInt = ((stSimpleMetaFeed)localObject).waterFallCardStyle.cardType;
        if (vdm.a(paramInt)) {
          return paramInt;
        }
        return 1;
      }
    }
    return 1;
  }
  
  public blij<stSimpleMetaFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    return vdm.a(paramInt, paramViewGroup, this);
  }
  
  public RockDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = new WSRecommendAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper;
  }
  
  public vbp a()
  {
    if (this.jdField_a_of_type_Vbp == null) {
      this.jdField_a_of_type_Vbp = vbq.a(100, 2);
    }
    return this.jdField_a_of_type_Vbp;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + this.c;
    if ((i < 0) || (i >= b().size())) {
      vmp.c("weishi-ding", "点赞position越界:" + i);
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
      vmp.b("weishi-ding", "第" + i + "个条目的点赞改变了~~~");
      return;
      paramInt1 -= 1;
    }
  }
  
  public void a(blij<stSimpleMetaFeed> paramblij)
  {
    if (this.jdField_a_of_type_Uye != null) {
      this.jdField_a_of_type_Uye.a(paramblij);
    }
  }
  
  public void a(blij<stSimpleMetaFeed> paramblij, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)a(paramInt);
    if (localstSimpleMetaFeed != null) {
      paramblij.a(localstSimpleMetaFeed);
    }
  }
  
  public void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = paramWSRedDotPushMsg;
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    List localList = b();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void a(uye paramuye)
  {
    this.jdField_a_of_type_Uye = paramuye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyd
 * JD-Core Version:    0.7.0.1
 */