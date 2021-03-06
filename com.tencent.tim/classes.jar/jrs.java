import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.GroupInfo;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.ReqBody;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.ReqBody;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x79b.oidb_0x79b.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class jrs
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, String paramString2, long paramLong5, List<String> paramList, String paramString3, long paramLong6, int paramInt2, String paramString4, jrs.b paramb)
  {
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    if ((paramLong2 != 0L) && (paramLong3 != 0L))
    {
      localGroupInfo.uint32_group_type_flag.set(4);
      paramString1 = new oidb_0x88d.GroupGeoInfo();
      paramString1.uint32_cityid.set(paramInt1);
      paramString1.int64_latitude.set(paramLong2);
      paramString1.int64_longitude.set(paramLong3);
      paramString1.bytes_geocontent.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString1.uint64_poi_id.set(paramLong4);
      localGroupInfo.group_geo_info.set(paramString1);
    }
    localGroupInfo.uint32_group_class_ext.set((int)paramLong5);
    paramString1 = apyh.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), String.valueOf(localGroupInfo.uint32_group_class_ext.get()));
    if (paramString1 != null) {
      localGroupInfo.string_group_class_text.set(ByteStringMicro.copyFromUtf8(paramString1.name));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = new ArrayList();
      paramString2 = paramList.iterator();
      while (paramString2.hasNext())
      {
        paramList = (String)paramString2.next();
        oidb_0x88d.TagRecord localTagRecord = new oidb_0x88d.TagRecord();
        localTagRecord.bytes_tag_value.set(ByteStringMicro.copyFromUtf8(paramList));
        paramString1.add(localTagRecord);
      }
      localGroupInfo.rpt_tag_record.set(paramString1);
    }
    localGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    paramString1 = new oidb_0x79b.ReqBody();
    paramString1.uint64_group_code.set(paramLong1);
    paramString1.uint32_source.set(1);
    paramString1.info.set(localGroupInfo);
    if ((paramLong6 != 0L) || (paramInt2 == 4))
    {
      paramString1.uint64_tribe_id.set(paramLong6);
      paramString1.uint32_tribe_type.set(paramInt2);
      paramString1.str_tribe_name.set(paramString4);
    }
    paramString2 = new oidb_sso.OIDBSSOPkg();
    paramString2.uint32_command.set(1947);
    paramString2.uint32_service_type.set(1);
    paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString1 = new NewIntent(paramQQAppInterface.getApplication(), jnl.class);
    paramString1.putExtra("cmd", "OidbSvc.0x79b_1");
    paramString1.putExtra("data", paramString2.toByteArray());
    paramString1.setObserver(new jru(paramQQAppInterface, paramb));
    paramQQAppInterface.startServlet(paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, jnm.d paramd)
  {
    oidb_cmd0x6f6.ReqBody localReqBody = new oidb_cmd0x6f6.ReqBody();
    oidb_cmd0x6f6.GroupInfo localGroupInfo = new oidb_cmd0x6f6.GroupInfo();
    localGroupInfo.uint64_group_code.set(paramLong);
    localReqBody.rpt_msg_group_info.add(localGroupInfo);
    jnm.b(paramQQAppInterface, paramd, localReqBody.toByteArray(), "OidbSvc.0x6f6_0", 1782, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, jrs.a parama)
  {
    Object localObject = new oidb_0x79a.ReqBody();
    ((oidb_0x79a.ReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x79a.ReqBody)localObject).uint32_source.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1946);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x79a.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(paramQQAppInterface.getApplication(), jnl.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x79a_1");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).setObserver(new jrt(paramQQAppInterface, parama));
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, jrs.a parama)
  {
    try
    {
      paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()) || (paramQQAppInterface.uint32_result.get() != 0) || (!paramQQAppInterface.bytes_bodybuffer.has()) || (paramQQAppInterface.bytes_bodybuffer.get() == null))
      {
        parama.onFailed();
        return;
      }
      paramArrayOfByte = new oidb_0x79a.RspBody();
      paramArrayOfByte.mergeFrom(paramQQAppInterface.bytes_bodybuffer.get().toByteArray());
      parama.a(paramArrayOfByte);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      parama.onFailed();
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, jrs.b paramb)
  {
    try
    {
      paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()) || (paramQQAppInterface.uint32_result.get() != 0) || (!paramQQAppInterface.bytes_bodybuffer.has()) || (paramQQAppInterface.bytes_bodybuffer.get() == null))
      {
        paramb.onFailed(paramQQAppInterface.str_error_msg.get());
        return;
      }
      paramb.azf();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramb.onFailed("");
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(oidb_0x79a.RspBody paramRspBody);
    
    public abstract void onFailed();
  }
  
  public static abstract interface b
  {
    public abstract void azf();
    
    public abstract void onFailed(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrs
 * JD-Core Version:    0.7.0.1
 */