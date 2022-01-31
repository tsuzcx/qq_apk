import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCollectionViewCount;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vgq
  extends urt<vhz>
{
  public static final String a;
  public List<veh> a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.get_colleciton_view_count");
  }
  
  public vgq()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCollectionViewCount localRspCollectionViewCount = new qqstory_service.RspCollectionViewCount();
    try
    {
      localRspCollectionViewCount.mergeFrom(paramArrayOfByte);
      return new vhz(this.b, localRspCollectionViewCount);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        wxe.d("Q.qqstory:UpdateCollectionViewCountRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCollectionViewCount localReqCollectionViewCount = new qqstory_service.ReqCollectionViewCount();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      veh localveh = (veh)localIterator.next();
      localReqCollectionViewCount.collection_id.add(localveh.a());
    }
    return localReqCollectionViewCount.toByteArray();
  }
  
  public String toString()
  {
    return "UpdateCollectionViewCountRequest{mIdList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */