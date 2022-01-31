import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Arrays;

class tye
  implements Observer<tsb>
{
  tye(txz paramtxz) {}
  
  public void a(@Nullable tsb paramtsb)
  {
    if (paramtsb != null)
    {
      if ((paramtsb.jdField_a_of_type_Boolean) || (paramtsb.jdField_a_of_type_Long == 0L)) {
        break label103;
      }
      if (txz.a(this.a) != null)
      {
        txz.a(this.a).b();
        QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramtsb.jdField_a_of_type_Long), paramtsb.jdField_a_of_type_JavaLangString }));
        if (txz.a(this.a) != null)
        {
          txz.a(this.a).clearData();
          txz.a(this.a).notifyDataSetChanged();
        }
      }
    }
    return;
    label103:
    if (txz.a(this.a) != null) {
      txz.a(this.a).c();
    }
    ArrayList localArrayList;
    if ((txz.a(this.a) != null) && (paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro != null))
    {
      if (!(paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp)) {
        break label262;
      }
      localArrayList = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).vecFeed.get();
      if (!paramtsb.jdField_a_of_type_Boolean) {
        break label248;
      }
      txz.a(this.a).addAll(localArrayList);
      txz.a(this.a);
      QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(localArrayList.size()), ((FeedCloudRead.StGetFeedListRsp)paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feedAttchInfo.get() }));
    }
    for (;;)
    {
      txz.a(this.a, txz.b(this.a));
      return;
      label248:
      txz.a(this.a).setDatas(localArrayList);
      break;
      label262:
      if ((paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
      {
        paramtsb = ((FeedCloudRead.StGetFeedDetailRsp)paramtsb.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed;
        txz.a(this.a).setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StFeed[] { paramtsb })));
        txz.a(this.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */