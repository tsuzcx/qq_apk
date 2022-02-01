import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseVidList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qaq
  extends ppu
{
  public final List<pzi.a> nC = new ArrayList();
  
  public qaq(qqstory_service.RspStoryPlayerTagInfo paramRspStoryPlayerTagInfo)
  {
    super(paramRspStoryPlayerTagInfo.result);
    Iterator localIterator = paramRspStoryPlayerTagInfo.tag_info.get().iterator();
    Object localObject;
    String str;
    qqstory_struct.TagInfoBase localTagInfoBase;
    if (localIterator.hasNext())
    {
      localObject = (qqstory_struct.TagInfoBaseVidList)localIterator.next();
      str = ((qqstory_struct.TagInfoBaseVidList)localObject).vid.get().toStringUtf8();
      localTagInfoBase = (qqstory_struct.TagInfoBase)((qqstory_struct.TagInfoBaseVidList)localObject).tag_info.get();
      if (!((qqstory_struct.TagInfoBaseVidList)localObject).comp_info.has()) {
        break label163;
      }
    }
    label163:
    for (paramRspStoryPlayerTagInfo = new rmq((qqstory_struct.CompInfoBase)((qqstory_struct.TagInfoBaseVidList)localObject).comp_info.get());; paramRspStoryPlayerTagInfo = null)
    {
      if (((qqstory_struct.TagInfoBaseVidList)localObject).extern_config_json.has()) {}
      for (localObject = ((qqstory_struct.TagInfoBaseVidList)localObject).extern_config_json.get().toStringUtf8();; localObject = null)
      {
        this.nC.add(new pzi.a(str, new rmw.a(localTagInfoBase), paramRspStoryPlayerTagInfo, (String)localObject));
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qaq
 * JD-Core Version:    0.7.0.1
 */