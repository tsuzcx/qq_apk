import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class vba
  extends unk<vcx>
{
  public static final String a;
  public List<String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.feed_feature_775");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchFeedFeature localRspGetBatchFeedFeature = new qqstory_service.RspGetBatchFeedFeature();
    try
    {
      localRspGetBatchFeedFeature.mergeFrom(paramArrayOfByte);
      return new vcx(localRspGetBatchFeedFeature);
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
    qqstory_service.ReqGetBatchFeedFeature localReqGetBatchFeedFeature = new qqstory_service.ReqGetBatchFeedFeature();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localReqGetBatchFeedFeature.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    return localReqGetBatchFeedFeature.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */