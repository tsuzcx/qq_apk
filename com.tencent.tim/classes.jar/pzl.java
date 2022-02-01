import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzl
  extends ppw<qas>
{
  public static final String CMD = ppf.fQ("StorySvc.union_batch_vid_basic_info");
  public List<String> nv = new ArrayList();
  public int source;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetVideoFullInfoList localRspBatchGetVideoFullInfoList = new qqstory_service.RspBatchGetVideoFullInfoList();
    try
    {
      localRspBatchGetVideoFullInfoList.mergeFrom(paramArrayOfByte);
      ram.b("Q.qqstory.net:GetVideoFullInfoListRequest", "%s", rpf.a(localRspBatchGetVideoFullInfoList));
      return new qas(localRspBatchGetVideoFullInfoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.net:GetVideoFullInfoListRequest", mg(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    if (this.nv != null)
    {
      Iterator localIterator = this.nv.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.startsWith("Loading")) {}
        for (boolean bool = true;; bool = false)
        {
          rom.assertTrue(bool);
          localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(str));
          break;
        }
      }
    }
    localReqBatchGetVideoFullInfoList.source.set(this.source);
    return localReqBatchGetVideoFullInfoList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "GetVideoFullInfoListRequest{vidList='" + this.nv + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzl
 * JD-Core Version:    0.7.0.1
 */