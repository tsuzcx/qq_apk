import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.POI;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetPOIList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uev
  extends unf
{
  List<AddressItem> a = new ArrayList();
  
  public uev(qqstory_service.RspBatchGetPOIList paramRspBatchGetPOIList)
  {
    super(paramRspBatchGetPOIList.result);
    paramRspBatchGetPOIList = paramRspBatchGetPOIList.poi_list.get();
    if (paramRspBatchGetPOIList != null)
    {
      paramRspBatchGetPOIList = paramRspBatchGetPOIList.iterator();
      while (paramRspBatchGetPOIList.hasNext())
      {
        qqstory_service.POI localPOI = (qqstory_service.POI)paramRspBatchGetPOIList.next();
        AddressItem localAddressItem = AddressItem.getAddressFromProtoObject(localPOI.address);
        localAddressItem.poiType = localPOI.poi_type.get();
        this.a.add(localAddressItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uev
 * JD-Core Version:    0.7.0.1
 */