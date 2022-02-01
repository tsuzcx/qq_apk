import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.QSecPushSeriveMsg.QSecPushSeriveBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecPushServiceMgr.1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class aszh
{
  private asyv jdField_a_of_type_Asyv;
  private aszd jdField_a_of_type_Aszd;
  private int eoq;
  private Object mLock = new Object();
  private HashMap<Integer, List<aszh.a>> qa = new HashMap();
  
  public aszh(aszd paramaszd, asyv paramasyv)
  {
    this.jdField_a_of_type_Aszd = paramaszd;
    this.jdField_a_of_type_Asyv = paramasyv;
    this.jdField_a_of_type_Aszd.b(new aszi(this));
  }
  
  private aszh.a a(byte[] paramArrayOfByte)
  {
    int j = -1;
    boolean bool = true;
    int i;
    try
    {
      localQSecPushSeriveBody = new QSecPushSeriveMsg.QSecPushSeriveBody();
      localQSecPushSeriveBody.mergeFrom(paramArrayOfByte);
      if ((localQSecPushSeriveBody.ver == null) || (!localQSecPushSeriveBody.ver.has())) {
        break label411;
      }
      i = localQSecPushSeriveBody.ver.get();
    }
    catch (Exception paramArrayOfByte)
    {
      QSecPushSeriveMsg.QSecPushSeriveBody localQSecPushSeriveBody;
      label80:
      paramArrayOfByte.printStackTrace();
      return null;
    }
    if ((localQSecPushSeriveBody.platform != null) && (localQSecPushSeriveBody.platform.has()))
    {
      i = localQSecPushSeriveBody.platform.get();
      if ((i & 0x1) == 0) {
        break label418;
      }
      if ((localQSecPushSeriveBody.qsecJavaVer != null) && (localQSecPushSeriveBody.qsecJavaVer.has()))
      {
        i = localQSecPushSeriveBody.qsecJavaVer.get();
        break label420;
      }
    }
    for (;;)
    {
      i = j;
      if (localQSecPushSeriveBody.qsecNativeVer != null)
      {
        i = j;
        if (localQSecPushSeriveBody.qsecNativeVer.has()) {
          i = localQSecPushSeriveBody.qsecNativeVer.get();
        }
      }
      if ((i == 0) || (i == QSecFramework.a().Oa()))
      {
        if ((localQSecPushSeriveBody.packageName != null) && (localQSecPushSeriveBody.packageName.has())) {
          paramArrayOfByte = localQSecPushSeriveBody.packageName.get();
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(paramArrayOfByte)) || (paramArrayOfByte.equalsIgnoreCase(asxv.getAppPackageName())))
          {
            paramArrayOfByte = new aszh.a(null);
            if ((localQSecPushSeriveBody.pluginId != null) && (localQSecPushSeriveBody.pluginId.has()))
            {
              paramArrayOfByte.eok = localQSecPushSeriveBody.pluginId.get();
              if ((localQSecPushSeriveBody.pluginCmd != null) && (localQSecPushSeriveBody.pluginCmd.has()))
              {
                paramArrayOfByte.mCmd = localQSecPushSeriveBody.pluginCmd.get();
                if ((localQSecPushSeriveBody.pluginVer != null) && (localQSecPushSeriveBody.pluginVer.has()))
                {
                  paramArrayOfByte.eor = localQSecPushSeriveBody.pluginVer.get();
                  if ((localQSecPushSeriveBody.canCache != null) && (localQSecPushSeriveBody.canCache.has())) {
                    if (localQSecPushSeriveBody.canCache.get() != 1) {
                      break label383;
                    }
                  }
                  for (;;)
                  {
                    paramArrayOfByte.dgL = bool;
                    if ((localQSecPushSeriveBody.extraInfo != null) && (localQSecPushSeriveBody.extraInfo.has())) {
                      paramArrayOfByte.mData = localQSecPushSeriveBody.extraInfo.get().toByteArray();
                    }
                    return paramArrayOfByte;
                    label383:
                    bool = false;
                  }
                  paramArrayOfByte = null;
                  continue;
                  i = -1;
                  break label420;
                  i = 0;
                  break label80;
                  label411:
                  i = 0;
                  if (i == 1) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
      label418:
      label420:
      do
      {
        return null;
        if (i == 0) {
          break;
        }
      } while (i != 33751040);
    }
  }
  
  private void a(aszh.a parama)
  {
    if (parama.eok == 0)
    {
      c(parama);
      return;
    }
    b(parama);
  }
  
  private void b(aszh.a parama)
  {
    int i = this.jdField_a_of_type_Aszd.b(parama.eok, parama.eor, parama.mCmd, new Object[] { parama.mData }, null);
    if (((i == 17) || (i == 7) || (i == 4)) && (parama.dgL)) {
      synchronized (this.mLock)
      {
        if (this.eoq < 50)
        {
          List localList = (List)this.qa.get(Integer.valueOf(parama.eok));
          Object localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new LinkedList();
            this.qa.put(Integer.valueOf(parama.eok), localObject1);
          }
          ((List)localObject1).add(parama);
          this.eoq += 1;
        }
        return;
      }
    }
  }
  
  private void c(aszh.a parama)
  {
    switch (parama.mCmd)
    {
    }
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Asyv.Vj(true);
        return;
        try
        {
          parama = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
          if (parama != null)
          {
            ((aszu)parama.getManager(194)).aaa(0);
            return;
          }
        }
        catch (Exception parama)
        {
          return;
        }
      }
      parama = parama.mData;
    } while (!asym.a().v(parama));
    asym.a().est();
  }
  
  public void bX(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    QSecFramework.C().post(new QSecPushServiceMgr.1(this, paramArrayOfByte));
  }
  
  public static class a
  {
    public boolean dgL;
    public int eok;
    public int eor;
    public int mCmd;
    public byte[] mData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszh
 * JD-Core Version:    0.7.0.1
 */