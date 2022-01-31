import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListReq;
import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StUinTime;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.servlet.ProtoBufRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class yvo
  extends ProtoBufRequest
{
  private final CLIENT.StGetStoryFeedListReq a = new CLIENT.StGetStoryFeedListReq();
  
  public yvo(int paramInt, CLIENT.StUinTime paramStUinTime)
  {
    this.a.listType.set(paramInt);
    this.a.uinTime.set(paramStUinTime);
    this.a.listNum.set(10);
  }
  
  @Nullable
  public static CLIENT.StGetStoryFeedListRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      a("data is null");
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      a("storyData is null");
      return null;
    }
    CLIENT.StGetStoryFeedListRsp localStGetStoryFeedListRsp = new CLIENT.StGetStoryFeedListRsp();
    try
    {
      localStGetStoryFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetStoryFeedListRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      a("onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GetMineStoryFeedListRequest", 2, paramString);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.a.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvo
 * JD-Core Version:    0.7.0.1
 */