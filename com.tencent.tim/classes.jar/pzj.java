import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pzj
  extends ppw<qar>
{
  private static final String CMD = ppf.fQ("StorySvc.get_label_list");
  private final String avJ;
  private int blw;
  private final boolean mHasMusic;
  private final int mSize;
  private long qu;
  
  public pzj(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.blw = paramInt1;
    this.qu = paramLong;
    this.avJ = paramString;
    this.mSize = paramInt2;
    this.mHasMusic = true;
  }
  
  public pzj(String paramString, int paramInt)
  {
    this.avJ = paramString;
    this.mSize = paramInt;
    this.mHasMusic = false;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetTagList localRspGetTagList = new qqstory_service.RspGetTagList();
    try
    {
      localRspGetTagList.mergeFrom(paramArrayOfByte);
      return new qar(localRspGetTagList);
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
    qqstory_service.ReqGetTagList localReqGetTagList = new qqstory_service.ReqGetTagList();
    if (this.mHasMusic)
    {
      localReqGetTagList.music_type.set(this.blw);
      localReqGetTagList.music_id.set(this.qu);
    }
    localReqGetTagList.start_cookie.set(this.avJ);
    localReqGetTagList.size.set(this.mSize);
    return localReqGetTagList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzj
 * JD-Core Version:    0.7.0.1
 */