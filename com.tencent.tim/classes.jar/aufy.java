import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aufy
  extends accg
{
  static String strCity = "";
  static String strProvince;
  public static int[] th = { 2011, 2012, 2010, 2014, 2002, 2003, 2004, 2008, 2015, 2023, 2022, 2024, 2027, 2026, 2028, 2029, 2030, 2034, 2032, 2035, 2044, 2040, 2041, 2042, 2038, 2048 };
  private static int[] ti = { 2011, 2012, 2013 };
  private static int[] tj = new int[0];
  private static int[] tk = new int[0];
  public Map<Integer, aufx> pB = new ConcurrentHashMap();
  
  static
  {
    strProvince = "";
  }
  
  public aufy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void aM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramToServiceMsg.extraData.getIntArray("k_cmd_type");
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if ((localObject1 == null) || (localObject1.length == 0)) {
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      i = 0;
      while (i < localObject1.length)
      {
        QLog.i("OperationConfigHandler", 2, "onReceive. isSuccess: " + bool1 + ",cmd: " + localObject1[i] + ",length: " + localObject1.length);
        i += 1;
      }
    }
    Object localObject2 = new ConfigurationService.RespGetConfig();
    try
    {
      ((ConfigurationService.RespGetConfig)localObject2).mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = new HashSet();
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramToServiceMsg.add(Integer.valueOf(localObject1[i]));
        i += 1;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OperationConfigHandler", 2, "error: " + paramToServiceMsg.toString());
        }
        bool1 = false;
      }
      if (!bool1) {
        break label218;
      }
    }
    label218:
    boolean bool2;
    if (((ConfigurationService.RespGetConfig)localObject2).result.get() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OperationConfigHandler", 2, "handle config fail: success:" + bool1 + " result:" + ((ConfigurationService.RespGetConfig)localObject2).result.get());
      }
      bool2 = false;
    }
    do
    {
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        i = ((Integer)paramToServiceMsg.next()).intValue();
        paramFromServiceMsg = a(this.app, i);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(i, bool2, null);
        }
      }
      break;
      bool2 = bool1;
    } while (((ConfigurationService.RespGetConfig)localObject2).config_list == null);
    paramFromServiceMsg = ((ConfigurationService.RespGetConfig)localObject2).config_list.get().iterator();
    for (;;)
    {
      bool2 = bool1;
      if (!paramFromServiceMsg.hasNext()) {
        break;
      }
      localObject1 = (ConfigurationService.Config)paramFromServiceMsg.next();
      i = ((ConfigurationService.Config)localObject1).type.get();
      localObject2 = a(this.app, i);
      if (localObject2 != null) {
        ((aufx)localObject2).a(i, bool1, (ConfigurationService.Config)localObject1);
      }
      paramToServiceMsg.remove(Integer.valueOf(i));
    }
  }
  
  private void p(int[] paramArrayOfInt)
  {
    Object localObject1 = new ArrayList();
    int i2 = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    int j = 0;
    int i = 0;
    int i3;
    Object localObject2;
    int i1;
    int n;
    if (k < i2)
    {
      i3 = paramArrayOfInt[k];
      localObject2 = a(this.app, i3);
      if (localObject2 != null)
      {
        localObject2 = ((aufx)localObject2).a();
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
      }
      if (i != 0) {
        break label514;
      }
      localObject2 = ti;
      i1 = localObject2.length;
      n = 0;
      label92:
      if (n >= i1) {
        break label514;
      }
      if (i3 == localObject2[n]) {
        i = 1;
      }
    }
    label128:
    label514:
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = tj;
        i1 = localObject2.length;
        n = 0;
        if (n < i1) {
          if (i3 == localObject2[n]) {
            j = 1;
          }
        }
      }
      for (;;)
      {
        n = m;
        int i4;
        if (m == 0)
        {
          localObject2 = tk;
          i4 = localObject2.length;
          i1 = 0;
        }
        for (;;)
        {
          n = m;
          if (i1 < i4)
          {
            if (i3 == localObject2[i1]) {
              n = 1;
            }
          }
          else
          {
            k += 1;
            m = n;
            break;
            n += 1;
            break label92;
            n += 1;
            break label128;
          }
          i1 += 1;
        }
        localObject2 = new ConfigurationService.ReqGetConfig();
        ((ConfigurationService.ReqGetConfig)localObject2).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject2).seq_list.addAll((Collection)localObject1);
        localObject1 = new ConfigurationService.DeviceInfo();
        Object localObject3;
        if (i != 0)
        {
          localObject3 = new ConfigurationService.Screen();
          ((ConfigurationService.Screen)localObject3).setHasFlag(true);
          ((ConfigurationService.Screen)localObject3).width.set((int)aqgz.hK());
          ((ConfigurationService.Screen)localObject3).height.set((int)aqgz.hL());
          ((ConfigurationService.DeviceInfo)localObject1).screen = ((ConfigurationService.Screen)localObject3);
          ((ConfigurationService.DeviceInfo)localObject1).setHasFlag(true);
          ((ConfigurationService.ReqGetConfig)localObject2).device_info = ((ConfigurationService.DeviceInfo)localObject1);
        }
        if (j != 0)
        {
          localObject3 = new ConfigurationService.OS();
          ((ConfigurationService.OS)localObject3).setHasFlag(true);
          ((ConfigurationService.OS)localObject3).type.set(2);
          ((ConfigurationService.OS)localObject3).kernel.set(aqgz.getKernelVersion());
          ((ConfigurationService.OS)localObject3).sdk.set(String.valueOf(aqgz.getOsVersion()));
          ((ConfigurationService.OS)localObject3).version.set(aqgz.getDeviceOSVersion());
          ((ConfigurationService.OS)localObject3).rom.set(aqgz.getRomInfo());
          ((ConfigurationService.DeviceInfo)localObject1).brand.set(aqgz.BY());
          ((ConfigurationService.DeviceInfo)localObject1).model.set(aqgz.getDeviceModel());
          ((ConfigurationService.DeviceInfo)localObject1).os = ((ConfigurationService.OS)localObject3);
          ((ConfigurationService.DeviceInfo)localObject1).setHasFlag(true);
          ((ConfigurationService.ReqGetConfig)localObject2).device_info = ((ConfigurationService.DeviceInfo)localObject1);
        }
        if (m != 0)
        {
          ((ConfigurationService.ReqGetConfig)localObject2).province.set(strProvince);
          ((ConfigurationService.ReqGetConfig)localObject2).city.set(strCity);
        }
        localObject1 = createToServiceMsg("ConfigurationService.ReqGetConfig");
        ((ToServiceMsg)localObject1).putWupBuffer(((ConfigurationService.ReqGetConfig)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putIntArray("k_cmd_type", paramArrayOfInt);
        sendPbReq((ToServiceMsg)localObject1);
        return;
      }
    }
  }
  
  public aufx a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    aufx localaufx = (aufx)this.pB.get(Integer.valueOf(paramInt));
    Object localObject = localaufx;
    if (localaufx == null)
    {
      paramQQAppInterface = b(paramQQAppInterface, paramInt);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        this.pB.put(Integer.valueOf(paramInt), paramQQAppInterface);
        localObject = paramQQAppInterface;
      }
    }
    return localObject;
  }
  
  public void aaH(int paramInt)
  {
    p(new int[] { paramInt });
  }
  
  public aufx b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return null;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aufz.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.pB.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ConfigurationService.ReqGetConfig".equals(paramFromServiceMsg.getServiceCmd())) {
      aM(paramToServiceMsg, paramFromServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufy
 * JD-Core Version:    0.7.0.1
 */