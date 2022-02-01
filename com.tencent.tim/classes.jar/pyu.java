import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class pyu
  extends ppw<qag>
{
  public static final String CMD = ppf.fQ("StorySvc.feed_feature_775");
  public List<String> no;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchFeedFeature localRspGetBatchFeedFeature = new qqstory_service.RspGetBatchFeedFeature();
    try
    {
      localRspGetBatchFeedFeature.mergeFrom(paramArrayOfByte);
      return new qag(localRspGetBatchFeedFeature);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqGetBatchFeedFeature localReqGetBatchFeedFeature = new qqstory_service.ReqGetBatchFeedFeature();
    Iterator localIterator = this.no.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localReqGetBatchFeedFeature.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    return localReqGetBatchFeedFeature.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyu
 * JD-Core Version:    0.7.0.1
 */