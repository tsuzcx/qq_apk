import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wgo
  extends wpa<wgp>
{
  private static final String jdField_a_of_type_JavaLangString = wnu.a("StorySvc.check_location_blacklist");
  private List<whl> jdField_a_of_type_JavaUtilList;
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckBlackList localRspCheckBlackList = new qqstory_service.RspCheckBlackList();
    try
    {
      localRspCheckBlackList.mergeFrom(paramArrayOfByte);
      return new wgp(localRspCheckBlackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public void a(@NonNull List<whl> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected byte[] a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      throw new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    }
    qqstory_service.ReqCheckBlackList localReqCheckBlackList = new qqstory_service.ReqCheckBlackList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((whl)localIterator.next()).a());
    }
    localReqCheckBlackList.gps_list.addAll(localArrayList);
    return localReqCheckBlackList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgo
 * JD-Core Version:    0.7.0.1
 */