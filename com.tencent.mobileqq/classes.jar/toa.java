import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class toa
  extends syq
{
  public List<QQUserUIItem> a = new ArrayList();
  
  public toa(qqstory_service.RspConvertUinAndUnionId paramRspConvertUinAndUnionId)
  {
    super(paramRspConvertUinAndUnionId.result);
    paramRspConvertUinAndUnionId = paramRspConvertUinAndUnionId.user_list.get();
    if (paramRspConvertUinAndUnionId != null)
    {
      paramRspConvertUinAndUnionId = paramRspConvertUinAndUnionId.iterator();
      while (paramRspConvertUinAndUnionId.hasNext())
      {
        qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)paramRspConvertUinAndUnionId.next();
        QQUserUIItem localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom(localUserInfo);
        this.a.add(localQQUserUIItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     toa
 * JD-Core Version:    0.7.0.1
 */