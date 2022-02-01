import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import java.util.List;

public class pef
  extends rxi
{
  public static String TAG = "QCirclePolyListViewModel";
  private String mAttachInfo = "";
  private MutableLiveData<pel<List<FeedCloudMeta.StLightInteractInfo>>> v = new MutableLiveData();
  
  public void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.mAttachInfo = "";
    }
    paramStFeed = new QCircleGetLightInteractRequest(paramStFeed, this.mAttachInfo);
    paramStFeed.setEnableCache(paramBoolean2);
    this.v.setValue(pel.b());
    a(paramStFeed, new peg(this, paramStFeed, paramBoolean1));
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetLightInteractListRsp == null))
    {
      this.v.setValue(pel.a(paramString).b(paramBoolean2));
      return;
    }
    this.mAttachInfo = paramStGetLightInteractListRsp.attachInfo.get();
    Object localObject = paramStGetLightInteractListRsp.listInfo.get();
    if (((List)localObject).size() > 0)
    {
      paramString = this.v;
      localObject = pel.a(bool2).a(paramBoolean2, localObject);
      if (paramStGetLightInteractListRsp.isFinish.get() == 1) {}
      for (paramBoolean1 = bool1;; paramBoolean1 = false)
      {
        paramString.setValue(((pel)localObject).c(paramBoolean1));
        return;
      }
    }
    this.v.setValue(pel.a().b(paramBoolean2));
  }
  
  public String getLogTag()
  {
    return TAG;
  }
  
  public MutableLiveData<pel<List<FeedCloudMeta.StLightInteractInfo>>> q()
  {
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pef
 * JD-Core Version:    0.7.0.1
 */