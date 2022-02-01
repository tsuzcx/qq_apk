import com.tencent.av.qav_gvideo_sdk_transfer.gVideoAcceptType;
import com.tencent.av.qav_gvideo_sdk_transfer.gVideoDownChannelControl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class iil
{
  public static volatile int amE = -1;
  volatile boolean PM = false;
  volatile HashMap<Long, Integer> cA = new HashMap();
  
  public static int kI()
  {
    return AudioHelper.jY(20);
  }
  
  public void Clear()
  {
    this.cA.clear();
    this.PM = false;
  }
  
  public boolean a(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("GVideoDownloadChannelControl", 2, "UpdateChannelCtlList start");
    }
    int k = kI();
    boolean bool1;
    if (paramgVideoDownChannelControl == null)
    {
      bool1 = false;
      return bool1;
    }
    if (paramgVideoDownChannelControl.uint32_switch.get() == 1)
    {
      bool1 = true;
      label46:
      if (bool1 == this.PM) {
        break label300;
      }
      this.PM = bool1;
    }
    label297:
    label300:
    for (int i = 1;; i = 0)
    {
      if (!bool1)
      {
        Clear();
        if (i != 0)
        {
          bool1 = bool2;
          if (k < 0) {
            break;
          }
        }
        return false;
        bool1 = false;
        break label46;
      }
      HashMap localHashMap = new HashMap();
      int m = paramgVideoDownChannelControl.uint32_videoacceptTypeSize.get();
      int j = 0;
      label113:
      if (j < m)
      {
        Object localObject = (qav_gvideo_sdk_transfer.gVideoAcceptType)paramgVideoDownChannelControl.msg_video_accept_type.get(j);
        long l = ((qav_gvideo_sdk_transfer.gVideoAcceptType)localObject).uint64_account.get();
        int n = ((qav_gvideo_sdk_transfer.gVideoAcceptType)localObject).video_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("GVideoDownloadChannelControl", 2, "UpdateChannelCtlList index=" + j + " |uin=" + l + " |type=" + n);
        }
        localObject = (Integer)this.cA.get(Long.valueOf(l));
        if ((localObject != null) && (((Integer)localObject).intValue() == n)) {
          break label297;
        }
        localHashMap.put(Long.valueOf(l), Integer.valueOf(n));
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break label113;
        if ((m != this.cA.size()) || (i != 0)) {
          this.cA = localHashMap;
        }
        if (i != 0)
        {
          bool1 = bool2;
          if (k < 0) {
            break;
          }
        }
        return false;
      }
    }
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    boolean bool = true;
    int i = kI();
    if (i >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GVideoDownloadChannelControl", 2, "CheckUinIsBig Debug Mode DEBUG_SMALL_CHANNEL_NUM=" + i);
      }
      return paramInt >= i;
    }
    if (this.cA.containsKey(Long.valueOf(paramLong)))
    {
      if (((Integer)this.cA.get(Long.valueOf(paramLong))).intValue() == 2) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return iiv.tk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iil
 * JD-Core Version:    0.7.0.1
 */