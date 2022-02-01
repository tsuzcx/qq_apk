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

class pbh
  implements Observer<owb>
{
  pbh(pbc parampbc) {}
  
  public void a(@Nullable owb paramowb)
  {
    pbc.b(this.this$0);
    if (paramowb != null)
    {
      if ((paramowb.ayN) || (paramowb.zl == 0L)) {
        break label110;
      }
      if (pbc.a(this.this$0) != null)
      {
        pbc.a(this.this$0).bkU();
        QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramowb.zl), paramowb.mErrorMsg }));
        if (pbc.a(this.this$0) != null)
        {
          pbc.a(this.this$0).clearData();
          pbc.a(this.this$0).notifyDataSetChanged();
        }
      }
    }
    return;
    label110:
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).bkV();
    }
    ArrayList localArrayList;
    if ((pbc.a(this.this$0) != null) && (paramowb.a != null))
    {
      if (!(paramowb.a instanceof FeedCloudRead.StGetFeedListRsp)) {
        break label269;
      }
      localArrayList = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramowb.a).vecFeed.get();
      if (!paramowb.ayN) {
        break label255;
      }
      pbc.a(this.this$0).addAll(localArrayList);
      pbc.a(this.this$0);
      QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(localArrayList.size()), ((FeedCloudRead.StGetFeedListRsp)paramowb.a).feedAttchInfo.get() }));
    }
    for (;;)
    {
      pbc.a(this.this$0, pbc.b(this.this$0));
      return;
      label255:
      pbc.a(this.this$0).setDatas(localArrayList);
      break;
      label269:
      if ((paramowb.a instanceof FeedCloudRead.StGetFeedDetailRsp))
      {
        paramowb = ((FeedCloudRead.StGetFeedDetailRsp)paramowb.a).feed;
        pbc.a(this.this$0).setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StFeed[] { paramowb })));
        pbc.a(this.this$0).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbh
 * JD-Core Version:    0.7.0.1
 */