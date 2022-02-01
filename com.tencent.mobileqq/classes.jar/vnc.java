import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
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

class vnc
  implements Observer<vbf>
{
  vnc(vmw paramvmw) {}
  
  public void a(@Nullable vbf paramvbf)
  {
    vmw.b(this.a);
    if (paramvbf != null)
    {
      if ((paramvbf.jdField_a_of_type_Boolean) || (paramvbf.jdField_a_of_type_Long == 0L)) {
        break label146;
      }
      if (vmw.a(this.a) != null)
      {
        if (!vmw.a(this.a, paramvbf.jdField_a_of_type_Long)) {
          break label132;
        }
        vmw.a(this.a).a(false);
      }
    }
    for (;;)
    {
      vmw.c(this.a);
      QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramvbf.jdField_a_of_type_Long), paramvbf.jdField_a_of_type_JavaLangString }));
      if (vmw.a(this.a) != null)
      {
        vmw.a(this.a).clearData();
        vmw.a(this.a).notifyDataSetChanged();
      }
      return;
      label132:
      vmw.a(this.a).b(null);
    }
    label146:
    if (vmw.a(this.a) != null) {
      vmw.a(this.a).a();
    }
    Object localObject;
    if ((vmw.a(this.a) != null) && (paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro != null))
    {
      if (!(paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp)) {
        break label377;
      }
      localObject = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).vecFeed.get();
      if (!paramvbf.jdField_a_of_type_Boolean) {
        break label363;
      }
      vmw.a(this.a).addAll((List)localObject);
      vmw.a(this.a);
      vmw.a(this.a, paramvbf);
      QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(((ArrayList)localObject).size()), ((FeedCloudRead.StGetFeedListRsp)paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feedAttchInfo.get() }));
    }
    for (;;)
    {
      if ((vmw.a(this.a).getItemCount() == 0) && (vmw.a(this.a) != null) && (vmw.a(this.a).getExtraTypeInfo() != null) && (vmw.a(this.a).getExtraTypeInfo().pageType == 10)) {
        this.a.a(0.0F, 0.0F);
      }
      vmw.a(this.a, vmw.b(this.a), paramvbf);
      return;
      label363:
      vmw.a(this.a).setDatas((ArrayList)localObject);
      break;
      label377:
      if ((paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
      {
        localObject = ((FeedCloudRead.StGetFeedDetailRsp)paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed;
        vmw.a(this.a).setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StFeed[] { localObject })));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnc
 * JD-Core Version:    0.7.0.1
 */