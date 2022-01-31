import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCollectionViewCount;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tns
  extends syv<tpb>
{
  public static final String a;
  public List<tlj> a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.get_colleciton_view_count");
  }
  
  public tns()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public syq a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCollectionViewCount localRspCollectionViewCount = new qqstory_service.RspCollectionViewCount();
    try
    {
      localRspCollectionViewCount.mergeFrom(paramArrayOfByte);
      return new tpb(this.b, localRspCollectionViewCount);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        veg.d("Q.qqstory:UpdateCollectionViewCountRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCollectionViewCount localReqCollectionViewCount = new qqstory_service.ReqCollectionViewCount();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      tlj localtlj = (tlj)localIterator.next();
      localReqCollectionViewCount.collection_id.add(localtlj.a());
    }
    return localReqCollectionViewCount.toByteArray();
  }
  
  public String toString()
  {
    return "UpdateCollectionViewCountRequest{mIdList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tns
 * JD-Core Version:    0.7.0.1
 */