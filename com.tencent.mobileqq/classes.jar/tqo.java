import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class tqo
{
  private int jdField_a_of_type_Int;
  private QCircleInitBean.QCircleActionBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean$QCircleActionBean;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private QQCircleFeedBase.StFeedListBusiReqData jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public QCircleInitBean a()
  {
    return new QCircleInitBean(this, null);
  }
  
  public tqo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType = paramInt;
    return this;
  }
  
  public tqo a(QCircleInitBean.QCircleActionBean paramQCircleActionBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean$QCircleActionBean = paramQCircleActionBean;
    return this;
  }
  
  public tqo a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    return this;
  }
  
  public tqo a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.set(paramStFeed);
    return this;
  }
  
  public tqo a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.set(paramStUser);
    return this;
  }
  
  public tqo a(String paramString)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.set(paramString);
    return this;
  }
  
  public tqo a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = new FeedCloudMeta.StTagInfo();
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.set(paramString2);
    }
    return this;
  }
  
  public tqo a(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData.set(paramStFeedListBusiReqData);
    return this;
  }
  
  public tqo a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return this;
  }
  
  public tqo b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqo
 * JD-Core Version:    0.7.0.1
 */