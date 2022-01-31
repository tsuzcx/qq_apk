import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryReq;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StUinTime;
import com.tencent.mobileqq.mini.servlet.ProtoBufRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class wxz
  extends ProtoBufRequest
{
  private CLIENT.StGetUserNewestStoryReq a = new CLIENT.StGetUserNewestStoryReq();
  
  public wxz(COMM.StCommonExt paramStCommonExt, long paramLong1, long paramLong2)
  {
    CLIENT.StUinTime localStUinTime = new CLIENT.StUinTime();
    localStUinTime.newestTime.set(paramLong1);
    localStUinTime.uin.set(paramLong2);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localStUinTime);
    this.a.vecUinTime.set(localArrayList);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  public static CLIENT.StGetUserNewestStoryRsp a(byte[] paramArrayOfByte)
  {
    CLIENT.StGetUserNewestStoryRsp localStGetUserNewestStoryRsp = new CLIENT.StGetUserNewestStoryRsp();
    try
    {
      localStGetUserNewestStoryRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetUserNewestStoryRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAioStoryFeedRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.a.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */