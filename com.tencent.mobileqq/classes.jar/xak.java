import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xak
  extends wov
{
  public List<ydb> a = new ArrayList();
  
  public xak(qqstory_service.RspConvertGroupId paramRspConvertGroupId)
  {
    super(paramRspConvertGroupId.result);
    if (paramRspConvertGroupId.group_rsp_list.has())
    {
      paramRspConvertGroupId = paramRspConvertGroupId.group_rsp_list.get().iterator();
      while (paramRspConvertGroupId.hasNext())
      {
        Object localObject = (qqstory_struct.GroupId)paramRspConvertGroupId.next();
        localObject = new ydb(String.valueOf(((qqstory_struct.GroupId)localObject).group_uin.get()), ((qqstory_struct.GroupId)localObject).group_union_id.get().toStringUtf8());
        this.a.add(localObject);
      }
    }
  }
  
  public String toString()
  {
    return "GetUserGroupUnionIDResponse{groupIDList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xak
 * JD-Core Version:    0.7.0.1
 */