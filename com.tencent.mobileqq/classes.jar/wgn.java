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

public class wgn
  extends vqm
{
  public final List<wfa> a = new ArrayList();
  
  public wgn(qqstory_service.RspStoryPlayerTagInfo paramRspStoryPlayerTagInfo)
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
    for (paramRspStoryPlayerTagInfo = new ymd((qqstory_struct.CompInfoBase)((qqstory_struct.TagInfoBaseVidList)localObject).comp_info.get());; paramRspStoryPlayerTagInfo = null)
    {
      if (((qqstory_struct.TagInfoBaseVidList)localObject).extern_config_json.has()) {}
      for (localObject = ((qqstory_struct.TagInfoBaseVidList)localObject).extern_config_json.get().toStringUtf8();; localObject = null)
      {
        this.a.add(new wfa(str, new yml(localTagInfoBase), paramRspStoryPlayerTagInfo, (String)localObject));
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgn
 * JD-Core Version:    0.7.0.1
 */