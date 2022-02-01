import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;

public class mgq
  implements Cloneable
{
  public int aRu;
  public String appDesc;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String metaList;
  public String ux;
  public long vd;
  
  public static mgq a(articlesummary.ArkAppFeedsInfo paramArkAppFeedsInfo)
  {
    if (paramArkAppFeedsInfo == null)
    {
      QLog.d("ArkAppFeedsInfo", 1, "covertPBToInfo feedsInfo == null");
      return null;
    }
    mgq localmgq = new mgq();
    long l;
    int i;
    label65:
    String str;
    if (paramArkAppFeedsInfo.uint64_feeds_id.has())
    {
      l = paramArkAppFeedsInfo.uint64_feeds_id.get();
      localmgq.vd = l;
      if (!paramArkAppFeedsInfo.uint32_feeds_style.has()) {
        break label418;
      }
      i = paramArkAppFeedsInfo.uint32_feeds_style.get();
      localmgq.aRu = i;
      if ((!paramArkAppFeedsInfo.bytes_app_name.has()) || (paramArkAppFeedsInfo.bytes_app_name.get() == null)) {
        break label423;
      }
      str = paramArkAppFeedsInfo.bytes_app_name.get().toStringUtf8();
      label103:
      localmgq.appName = str;
      if ((!paramArkAppFeedsInfo.bytes_app_view.has()) || (paramArkAppFeedsInfo.bytes_app_view.get() == null)) {
        break label430;
      }
      str = paramArkAppFeedsInfo.bytes_app_view.get().toStringUtf8();
      label142:
      localmgq.appView = str;
      if ((!paramArkAppFeedsInfo.bytes_app_desc.has()) || (paramArkAppFeedsInfo.bytes_app_desc.get() == null)) {
        break label437;
      }
      str = paramArkAppFeedsInfo.bytes_app_desc.get().toStringUtf8();
      label181:
      localmgq.appDesc = str;
      if ((!paramArkAppFeedsInfo.bytes_app_prompt.has()) || (paramArkAppFeedsInfo.bytes_app_prompt.get() == null)) {
        break label444;
      }
      str = paramArkAppFeedsInfo.bytes_app_prompt.get().toStringUtf8();
      label220:
      localmgq.ux = str;
      if ((!paramArkAppFeedsInfo.bytes_app_ver.has()) || (paramArkAppFeedsInfo.bytes_app_ver.get() == null)) {
        break label451;
      }
      str = paramArkAppFeedsInfo.bytes_app_ver.get().toStringUtf8();
      label259:
      localmgq.appMinVersion = str;
      if ((!paramArkAppFeedsInfo.bytes_app_meta.has()) || (paramArkAppFeedsInfo.bytes_app_meta.get() == null)) {
        break label458;
      }
    }
    label418:
    label423:
    label430:
    label437:
    label444:
    label451:
    label458:
    for (paramArkAppFeedsInfo = paramArkAppFeedsInfo.bytes_app_meta.get().toStringUtf8();; paramArkAppFeedsInfo = "")
    {
      localmgq.metaList = paramArkAppFeedsInfo;
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppFeedsInfo", 2, new Object[] { "mFeedsId: ", Long.valueOf(localmgq.vd), ", mFeedsStyle: ", Integer.valueOf(localmgq.aRu), ", appName: ", localmgq.appName, ", appView: ", localmgq.appView, ", appMinVersion: ", localmgq.appMinVersion, ", metaList: ", localmgq.metaList });
      }
      return localmgq;
      l = 0L;
      break;
      i = 0;
      break label65;
      str = "";
      break label103;
      str = "";
      break label142;
      str = "";
      break label181;
      str = "";
      break label220;
      str = "";
      break label259;
    }
  }
  
  public mgq a()
  {
    try
    {
      mgq localmgq = (mgq)super.clone();
      return localmgq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppFeedsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
      }
    }
    return null;
  }
  
  public articlesummary.ArkAppFeedsInfo a()
  {
    articlesummary.ArkAppFeedsInfo localArkAppFeedsInfo = new articlesummary.ArkAppFeedsInfo();
    localArkAppFeedsInfo.uint32_feeds_style.set(this.aRu);
    localArkAppFeedsInfo.uint64_feeds_id.set(this.vd);
    if (!TextUtils.isEmpty(this.appName)) {
      localArkAppFeedsInfo.bytes_app_name.set(ByteStringMicro.copyFromUtf8(this.appName));
    }
    if (!TextUtils.isEmpty(this.appView)) {
      localArkAppFeedsInfo.bytes_app_view.set(ByteStringMicro.copyFromUtf8(this.appView));
    }
    if (!TextUtils.isEmpty(this.appDesc)) {
      localArkAppFeedsInfo.bytes_app_desc.set(ByteStringMicro.copyFromUtf8(this.appDesc));
    }
    if (!TextUtils.isEmpty(this.ux)) {
      localArkAppFeedsInfo.bytes_app_prompt.set(ByteStringMicro.copyFromUtf8(this.ux));
    }
    if (!TextUtils.isEmpty(this.appMinVersion)) {
      localArkAppFeedsInfo.bytes_app_ver.set(ByteStringMicro.copyFromUtf8(this.appMinVersion));
    }
    if (!TextUtils.isEmpty(this.metaList)) {
      localArkAppFeedsInfo.bytes_app_meta.set(ByteStringMicro.copyFromUtf8(this.metaList));
    }
    return localArkAppFeedsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgq
 * JD-Core Version:    0.7.0.1
 */