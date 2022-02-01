import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoTarget;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wga
  extends vqm
{
  public String a;
  public List<String> a;
  public boolean a;
  public int b;
  public List<String> b;
  
  public wga(qqstory_service.RspBannerVideoList paramRspBannerVideoList)
  {
    super(paramRspBannerVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if ((paramRspBannerVideoList.video_list.has()) && (!paramRspBannerVideoList.video_list.isEmpty()))
    {
      Iterator localIterator = paramRspBannerVideoList.video_list.get().iterator();
      while (localIterator.hasNext())
      {
        qqstory_struct.VideoTarget localVideoTarget = (qqstory_struct.VideoTarget)localIterator.next();
        this.jdField_a_of_type_JavaUtilList.add(localVideoTarget.vid.get().toStringUtf8());
        this.jdField_b_of_type_JavaUtilList.add(localVideoTarget.feed_id.get().toStringUtf8());
      }
    }
    if (paramRspBannerVideoList.is_end.has()) {
      if (paramRspBannerVideoList.is_end.get() != 1) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (paramRspBannerVideoList.next_cookie.has()) {
        this.jdField_a_of_type_JavaLangString = paramRspBannerVideoList.next_cookie.get().toStringUtf8();
      }
      if (paramRspBannerVideoList.total_count.has()) {
        this.jdField_b_of_type_Int = paramRspBannerVideoList.total_count.get();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */