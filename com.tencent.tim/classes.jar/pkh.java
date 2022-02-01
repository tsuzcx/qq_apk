import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkh
  extends ppw<pkh.a>
{
  private static final String CMD = ppf.fQ("StorySvc.check_location_blacklist");
  private List<pkx.a> lW;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckBlackList localRspCheckBlackList = new qqstory_service.RspCheckBlackList();
    try
    {
      localRspCheckBlackList.mergeFrom(paramArrayOfByte);
      return new pkh.a(localRspCheckBlackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public void dO(@NonNull List<pkx.a> paramList)
  {
    this.lW = paramList;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    if (this.lW == null) {
      throw new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    }
    qqstory_service.ReqCheckBlackList localReqCheckBlackList = new qqstory_service.ReqCheckBlackList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lW.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((pkx.a)localIterator.next()).a());
    }
    localReqCheckBlackList.gps_list.addAll(localArrayList);
    return localReqCheckBlackList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppu
  {
    public List<qqstory_struct.GpsMsg> lY;
    
    public a(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
    {
      super();
      this.lY = paramRspCheckBlackList.black_gps_list.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */