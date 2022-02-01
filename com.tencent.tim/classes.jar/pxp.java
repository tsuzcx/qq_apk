import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pxp
  extends pxe
  implements ppv.b<pxp.b, pxp.c>
{
  public List<String> uinList = new ArrayList();
  
  public pxp(String paramString)
  {
    this.uinList.add(paramString);
  }
  
  public void a(@NonNull pxp.b paramb, @Nullable pxp.c paramc, @NonNull ErrorMessage paramErrorMessage)
  {
    paramb = new pxp.a(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramc != null) && (paramc.mU != null))
    {
      paramb.mU = paramc.mU;
      bnw();
    }
    for (;;)
    {
      pmi.a().dispatch(paramb);
      return;
      notifyError();
    }
  }
  
  public void sendRequest()
  {
    pxp.b localb = new pxp.b();
    localb.bli = 1;
    localb.uinList = this.uinList;
    ppv.a().a(localb, this);
  }
  
  public static class a
    extends plt
  {
    public List<qqd> mU;
    
    public a(ErrorMessage paramErrorMessage)
    {
      this.b = paramErrorMessage;
    }
  }
  
  public static class b
    extends ppw<pxp.c>
  {
    public static final String CMD = ppf.fQ("StoryGroupSvc.convert_group_id");
    public int bli;
    public List<String> uinList;
    
    public ppu a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspConvertGroupId localRspConvertGroupId = new qqstory_service.RspConvertGroupId();
      try
      {
        localRspConvertGroupId.mergeFrom(paramArrayOfByte);
        return new pxp.c(localRspConvertGroupId);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("Q.qqstory.net:BatchNetHandler", mg(), paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
      throws QQStoryCmdHandler.IllegalUinException
    {
      qqstory_service.ReqConvertGroupId localReqConvertGroupId = new qqstory_service.ReqConvertGroupId();
      localReqConvertGroupId.convert_from.set(this.bli);
      if (this.uinList != null)
      {
        Iterator localIterator = this.uinList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          qqstory_struct.GroupId localGroupId = new qqstory_struct.GroupId();
          localGroupId.group_uin.set(Long.valueOf(str).longValue());
          localReqConvertGroupId.group_req_list.add(localGroupId);
        }
      }
      return localReqConvertGroupId.toByteArray();
    }
    
    public String mg()
    {
      return CMD;
    }
  }
  
  public static class c
    extends ppu
  {
    public List<qqd> mU = new ArrayList();
    
    public c(qqstory_service.RspConvertGroupId paramRspConvertGroupId)
    {
      super();
      if (paramRspConvertGroupId.group_rsp_list.has())
      {
        paramRspConvertGroupId = paramRspConvertGroupId.group_rsp_list.get().iterator();
        while (paramRspConvertGroupId.hasNext())
        {
          Object localObject = (qqstory_struct.GroupId)paramRspConvertGroupId.next();
          localObject = new qqd(String.valueOf(((qqstory_struct.GroupId)localObject).group_uin.get()), ((qqstory_struct.GroupId)localObject).group_union_id.get().toStringUtf8());
          this.mU.add(localObject);
        }
      }
    }
    
    public String toString()
    {
      return "GetUserGroupUnionIDResponse{groupIDList=" + this.mU + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxp
 * JD-Core Version:    0.7.0.1
 */