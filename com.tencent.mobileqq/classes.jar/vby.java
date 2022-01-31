import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vby
  extends unk<vdj>
{
  public static final String a;
  public List<String> a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.union_batch_vid_basic_info");
  }
  
  public vby()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetVideoFullInfoList localRspBatchGetVideoFullInfoList = new qqstory_service.RspBatchGetVideoFullInfoList();
    try
    {
      localRspBatchGetVideoFullInfoList.mergeFrom(paramArrayOfByte);
      wsv.a("Q.qqstory.net:GetVideoFullInfoListRequest", "%s", xnh.a(localRspBatchGetVideoFullInfoList));
      return new vdj(localRspBatchGetVideoFullInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.b("Q.qqstory.net:GetVideoFullInfoListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.startsWith("Loading")) {}
        for (boolean bool = true;; bool = false)
        {
          xmh.a(bool);
          localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(str));
          break;
        }
      }
    }
    localReqBatchGetVideoFullInfoList.source.set(this.c);
    return localReqBatchGetVideoFullInfoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoFullInfoListRequest{vidList='" + this.jdField_a_of_type_JavaUtilList + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vby
 * JD-Core Version:    0.7.0.1
 */