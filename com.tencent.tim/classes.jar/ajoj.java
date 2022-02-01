import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.mutualmark.mutualmark.ResourceInfo_17;

public class ajoj
{
  public long HR;
  public long HS;
  public long HU;
  public long HV;
  public String aSN = "";
  public String aSO = "";
  public String aSP = "";
  public String aSQ = "";
  public long ada;
  public long adb;
  public boolean bdS;
  public String icon_static_url = "";
  public long type;
  public float xw;
  
  public static ajoj a(mutualmark.MutualMark paramMutualMark)
  {
    ajoj localajoj = new ajoj();
    localajoj.type = paramMutualMark.uint64_type.get();
    localajoj.ada = paramMutualMark.uint64_level.get();
    localajoj.xw = paramMutualMark.float_count.get();
    localajoj.adb = paramMutualMark.uint64_day.get();
    localajoj.HR = paramMutualMark.uint64_time.get();
    localajoj.HU = paramMutualMark.uint64_icon_status.get();
    if (localajoj.HU != 2L)
    {
      localajoj.HV = 0L;
      if (paramMutualMark.uint32_close_flag.has()) {
        if (paramMutualMark.uint32_close_flag.get() == 0) {
          break label302;
        }
      }
    }
    label302:
    for (boolean bool = true;; bool = false)
    {
      localajoj.bdS = bool;
      mutualmark.ResourceInfo_17 localResourceInfo_17;
      if (paramMutualMark.bytes_resource_info.has()) {
        localResourceInfo_17 = new mutualmark.ResourceInfo_17();
      }
      try
      {
        localResourceInfo_17.mergeFrom(paramMutualMark.bytes_resource_info.get().toByteArray());
        paramMutualMark = localResourceInfo_17;
      }
      catch (Throwable paramMutualMark)
      {
        for (;;)
        {
          QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + paramMutualMark.getMessage());
          paramMutualMark = null;
        }
      }
      if (paramMutualMark != null)
      {
        if (paramMutualMark.bytes_static_url.has()) {
          localajoj.icon_static_url = paramMutualMark.bytes_static_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_dynamic_url.has()) {
          localajoj.aSN = paramMutualMark.bytes_dynamic_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_cartoon_url.has()) {
          localajoj.aSO = paramMutualMark.bytes_cartoon_url.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_cartoon_md5.has()) {
          localajoj.aSP = paramMutualMark.bytes_cartoon_md5.get().toStringUtf8();
        }
        if (paramMutualMark.bytes_word.has()) {
          localajoj.aSQ = paramMutualMark.bytes_word.get().toStringUtf8();
        }
      }
      return localajoj;
      if (!paramMutualMark.uint64_icon_status_end_time.has()) {
        break;
      }
      localajoj.HV = paramMutualMark.uint64_icon_status_end_time.get();
      break;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPullInfo{");
    localStringBuilder.append("type:").append(this.type).append(", ");
    localStringBuilder.append("level:").append(this.ada).append(", ");
    localStringBuilder.append("count:").append(this.xw).append(", ");
    localStringBuilder.append("continue_days:").append(this.adb).append(", ");
    localStringBuilder.append("last_action_time:").append(this.HR).append(", ");
    localStringBuilder.append("last_change_time:").append(this.HS).append(", ");
    localStringBuilder.append("icon_status:").append(this.HU).append(", ");
    localStringBuilder.append("icon_status_end_time:").append(this.HV).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.icon_static_url).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.aSN).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.aSO).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.aSP).append(", ");
    localStringBuilder.append("icon_name:").append(this.aSQ).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.bdS).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoj
 * JD-Core Version:    0.7.0.1
 */