import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSimpleInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSimpleInfoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzg
  extends ppw
{
  public List<String> nv = new ArrayList();
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspSimpleInfoList localRspSimpleInfoList = new qqstory_service.RspSimpleInfoList();
    try
    {
      localRspSimpleInfoList.mergeFrom(paramArrayOfByte);
      return new qap(localRspSimpleInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.net:GetSimpleInfoListResponse", mg(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqSimpleInfoList localReqSimpleInfoList = new qqstory_service.ReqSimpleInfoList();
    ArrayList localArrayList = new ArrayList();
    if (this.nv != null)
    {
      Iterator localIterator = this.nv.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
    }
    localReqSimpleInfoList.vid_list.addAll(localArrayList);
    return localReqSimpleInfoList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.get_date_video_list");
  }
  
  public String toString()
  {
    return "GetSimpleInfoListResponse{vidList='" + this.nv + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzg
 * JD-Core Version:    0.7.0.1
 */