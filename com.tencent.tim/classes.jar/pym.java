import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertUinAndUnionId;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pym
  extends ppw<pzz>
{
  public boolean aCE;
  public boolean aCF;
  public boolean bE;
  public int bli;
  public String key = "";
  public List<QQUserUIItem.a> nn = new ArrayList();
  
  public pzz a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertUinAndUnionId localRspConvertUinAndUnionId = new qqstory_service.RspConvertUinAndUnionId();
    try
    {
      localRspConvertUinAndUnionId.mergeFrom(paramArrayOfByte);
      return new pzz(localRspConvertUinAndUnionId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.user:ConvertUinAndUnionIdRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
  {
    int j = 1;
    qqstory_service.ReqConvertUinAndUnionId localReqConvertUinAndUnionId = new qqstory_service.ReqConvertUinAndUnionId();
    localReqConvertUinAndUnionId.convert_from.set(this.bli);
    Object localObject = this.nn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQUserUIItem.a locala = (QQUserUIItem.a)((Iterator)localObject).next();
      localReqConvertUinAndUnionId.user_id_list.add(locala.a());
    }
    localObject = localReqConvertUinAndUnionId.need_medal;
    if (this.aCE)
    {
      i = 1;
      ((PBUInt32Field)localObject).set(i);
      localObject = localReqConvertUinAndUnionId.need_grade_speed;
      if (!this.aCF) {
        break label121;
      }
    }
    label121:
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      return localReqConvertUinAndUnionId.toByteArray();
      i = 0;
      break;
    }
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.convert_uid_and_union_id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pym
 * JD-Core Version:    0.7.0.1
 */