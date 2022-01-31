import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlw
  extends sys
{
  public static final String a;
  public List<uvp> a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.homepage_batch_feeds_detail_720");
  }
  
  public tlw()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeed localRspStoryFeed = new qqstory_service.RspStoryFeed();
    try
    {
      localRspStoryFeed.mergeFrom(paramArrayOfByte);
      return new tlx(localRspStoryFeed);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqStoryFeed localReqStoryFeed = new qqstory_service.ReqStoryFeed();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvp localuvp = (uvp)localIterator.next();
      if (localuvp != null) {
        if (TextUtils.isEmpty(localuvp.jdField_a_of_type_JavaLangString)) {
          ved.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "check your param feedId is null");
        } else {
          localArrayList.add(localuvp.a());
        }
      }
    }
    if (localArrayList.size() == 0) {
      throw new QQStoryCmdHandler.IllegalUinException("feed id seq is null");
    }
    localReqStoryFeed.feed_id_list.set(localArrayList);
    return localReqStoryFeed.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlw
 * JD-Core Version:    0.7.0.1
 */