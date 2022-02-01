import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class vky
  implements Observer<uzp>
{
  vky(vks paramvks) {}
  
  public void a(@Nullable uzp paramuzp)
  {
    vks.b(this.a);
    if (paramuzp != null)
    {
      if ((paramuzp.jdField_a_of_type_Boolean) || (paramuzp.jdField_a_of_type_Long == 0L)) {
        break label139;
      }
      if (vks.a(this.a) != null)
      {
        if (!vks.a(this.a, paramuzp.jdField_a_of_type_Long)) {
          break label125;
        }
        vks.a(this.a).a(false);
      }
    }
    for (;;)
    {
      QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramuzp.jdField_a_of_type_Long), paramuzp.jdField_a_of_type_JavaLangString }));
      if (vks.a(this.a) != null)
      {
        vks.a(this.a).clearData();
        vks.a(this.a).notifyDataSetChanged();
      }
      return;
      label125:
      vks.a(this.a).b(null);
    }
    label139:
    if (vks.a(this.a) != null) {
      vks.a(this.a).a();
    }
    Object localObject;
    if ((vks.a(this.a) != null) && (paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro != null))
    {
      if (!(paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp)) {
        break label370;
      }
      localObject = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).vecFeed.get();
      if (!paramuzp.jdField_a_of_type_Boolean) {
        break label356;
      }
      vks.a(this.a).addAll((List)localObject);
      vks.a(this.a);
      vks.a(this.a, paramuzp);
      QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(((ArrayList)localObject).size()), ((FeedCloudRead.StGetFeedListRsp)paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feedAttchInfo.get() }));
    }
    for (;;)
    {
      if ((vks.a(this.a).getItemCount() == 0) && (vks.a(this.a) != null) && (vks.a(this.a).getExtraTypeInfo() != null) && (vks.a(this.a).getExtraTypeInfo().pageType == 10)) {
        this.a.a(0.0F, 0.0F);
      }
      vks.a(this.a, vks.b(this.a), paramuzp);
      return;
      label356:
      vks.a(this.a).setDatas((ArrayList)localObject);
      break;
      label370:
      if ((paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
      {
        localObject = ((FeedCloudRead.StGetFeedDetailRsp)paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed;
        vks.a(this.a).setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StFeed[] { localObject })));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vky
 * JD-Core Version:    0.7.0.1
 */