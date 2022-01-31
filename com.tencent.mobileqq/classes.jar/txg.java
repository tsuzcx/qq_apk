import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;

class txg
  implements Observer<trw>
{
  txg(txe paramtxe) {}
  
  public void a(@Nullable trw paramtrw)
  {
    if (paramtrw != null)
    {
      if ((paramtrw.jdField_a_of_type_Boolean) || (paramtrw.jdField_a_of_type_Long == 0L)) {
        break label103;
      }
      if (txe.a(this.a) != null)
      {
        txe.a(this.a).b();
        QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramtrw.jdField_a_of_type_Long), paramtrw.jdField_a_of_type_JavaLangString }));
        if (txe.a(this.a) != null)
        {
          txe.a(this.a).a();
          txe.a(this.a).notifyDataSetChanged();
        }
      }
    }
    return;
    label103:
    if (txe.a(this.a) != null) {
      txe.a(this.a).c();
    }
    ArrayList localArrayList;
    if ((txe.a(this.a) != null) && (paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro != null))
    {
      if (!(paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp)) {
        break label255;
      }
      localArrayList = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).vecFeed.get();
      if (!paramtrw.jdField_a_of_type_Boolean) {
        break label241;
      }
      txe.a(this.a).a(localArrayList);
      QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(localArrayList.size()), ((FeedCloudRead.StGetFeedListRsp)paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feedAttchInfo.get() }));
    }
    for (;;)
    {
      txe.a(this.a, txe.a(this.a));
      return;
      label241:
      txe.a(this.a).a(localArrayList);
      break;
      label255:
      if ((paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
      {
        txe.a(this.a).b().add(0, ((FeedCloudRead.StGetFeedDetailRsp)paramtrw.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed);
        txe.a(this.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txg
 * JD-Core Version:    0.7.0.1
 */