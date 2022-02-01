import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.POI;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetPOIList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkf
  extends ppw<pkf.a>
{
  private static final String CMD = ppf.fQ("StorySvc.batch_get_poi_list");
  private List<pkx.a> lW;
  
  public pkf.a a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetPOIList localRspBatchGetPOIList = new qqstory_service.RspBatchGetPOIList();
    try
    {
      localRspBatchGetPOIList.mergeFrom(paramArrayOfByte);
      return new pkf.a(localRspBatchGetPOIList);
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
    if ((this.lW == null) || (this.lW.isEmpty())) {
      throw new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    }
    if ((QLog.isDebugVersion()) && (this.lW.size() > 100)) {
      throw new QQStoryCmdHandler.IllegalUinException("over LIMIT_MX data to send LIMIT_MX=100");
    }
    qqstory_service.ReqBatchGetPOIList localReqBatchGetPOIList = new qqstory_service.ReqBatchGetPOIList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lW.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((pkx.a)localIterator.next()).a());
    }
    localReqBatchGetPOIList.gps.addAll(localArrayList);
    return localReqBatchGetPOIList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public int si()
  {
    if (this.lW != null) {
      return this.lW.size();
    }
    return 0;
  }
  
  public static class a
    extends ppu
  {
    List<AddressItem> lX = new ArrayList();
    
    public a(qqstory_service.RspBatchGetPOIList paramRspBatchGetPOIList)
    {
      super();
      paramRspBatchGetPOIList = paramRspBatchGetPOIList.poi_list.get();
      if (paramRspBatchGetPOIList != null)
      {
        paramRspBatchGetPOIList = paramRspBatchGetPOIList.iterator();
        while (paramRspBatchGetPOIList.hasNext())
        {
          qqstory_service.POI localPOI = (qqstory_service.POI)paramRspBatchGetPOIList.next();
          AddressItem localAddressItem = AddressItem.getAddressFromProtoObject(localPOI.address);
          localAddressItem.poiType = localPOI.poi_type.get();
          this.lX.add(localAddressItem);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkf
 * JD-Core Version:    0.7.0.1
 */