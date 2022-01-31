import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqIconPostfix;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;

public class vdf
  extends uub
{
  private ArrayList<String> a;
  
  public vdf(ArrayList<String> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public String a()
  {
    return uqn.a("StorySvc.batch_get_user_icon_info");
  }
  
  public uuc a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspIconPostfix localRspIconPostfix = new qqstory_service.RspIconPostfix();
    try
    {
      localRspIconPostfix.mergeFrom(paramArrayOfByte);
      return new vdg(localRspIconPostfix);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wxe.d("GetUserIconHandler", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqIconPostfix localReqIconPostfix = new qqstory_service.ReqIconPostfix();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localReqIconPostfix.union_id_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    return localReqIconPostfix.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdf
 * JD-Core Version:    0.7.0.1
 */