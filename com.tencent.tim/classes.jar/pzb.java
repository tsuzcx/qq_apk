import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.YearNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzb
  extends ppw
{
  public String unionId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileYearNodeList localRspProfileYearNodeList = new qqstory_service.RspProfileYearNodeList();
    try
    {
      localRspProfileYearNodeList.mergeFrom(paramArrayOfByte);
      return new pzb.a(localRspProfileYearNodeList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqProfileYearNodeList localReqProfileYearNodeList = new qqstory_service.ReqProfileYearNodeList();
    localReqProfileYearNodeList.union_id.set(ByteStringMicro.copyFromUtf8(this.unionId));
    return localReqProfileYearNodeList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.get_profile_year_node_info");
  }
  
  public static class a
    extends ppu
  {
    public List<MomeriesYearNode> ns = new ArrayList();
    
    public a() {}
    
    public a(qqstory_service.RspProfileYearNodeList paramRspProfileYearNodeList)
    {
      super();
      paramRspProfileYearNodeList = paramRspProfileYearNodeList.year_node_list.get().iterator();
      while (paramRspProfileYearNodeList.hasNext())
      {
        qqstory_struct.YearNodeInfo localYearNodeInfo = (qqstory_struct.YearNodeInfo)paramRspProfileYearNodeList.next();
        MomeriesYearNode localMomeriesYearNode = new MomeriesYearNode();
        localMomeriesYearNode.convertFrom(localYearNodeInfo);
        this.ns.add(localMomeriesYearNode);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzb
 * JD-Core Version:    0.7.0.1
 */