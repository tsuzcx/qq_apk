import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSimpleInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSimpleInfoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xdg
  extends wpa
{
  public List<String> a = new ArrayList();
  
  public String a()
  {
    return wnu.a("StorySvc.get_date_video_list");
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspSimpleInfoList localRspSimpleInfoList = new qqstory_service.RspSimpleInfoList();
    try
    {
      localRspSimpleInfoList.mergeFrom(paramArrayOfByte);
      return new xew(localRspSimpleInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.b("Q.qqstory.net:GetSimpleInfoListResponse", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqSimpleInfoList localReqSimpleInfoList = new qqstory_service.ReqSimpleInfoList();
    ArrayList localArrayList = new ArrayList();
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
    }
    localReqSimpleInfoList.vid_list.addAll(localArrayList);
    return localReqSimpleInfoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetSimpleInfoListResponse{vidList='" + this.a + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdg
 * JD-Core Version:    0.7.0.1
 */