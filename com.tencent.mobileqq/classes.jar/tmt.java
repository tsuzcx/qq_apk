import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.YearNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tmt
  extends syn
{
  public List<MomeriesYearNode> a = new ArrayList();
  
  public tmt() {}
  
  public tmt(qqstory_service.RspProfileYearNodeList paramRspProfileYearNodeList)
  {
    super(paramRspProfileYearNodeList.result);
    paramRspProfileYearNodeList = paramRspProfileYearNodeList.year_node_list.get().iterator();
    while (paramRspProfileYearNodeList.hasNext())
    {
      qqstory_struct.YearNodeInfo localYearNodeInfo = (qqstory_struct.YearNodeInfo)paramRspProfileYearNodeList.next();
      MomeriesYearNode localMomeriesYearNode = new MomeriesYearNode();
      localMomeriesYearNode.convertFrom(localYearNodeInfo);
      this.a.add(localMomeriesYearNode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmt
 * JD-Core Version:    0.7.0.1
 */