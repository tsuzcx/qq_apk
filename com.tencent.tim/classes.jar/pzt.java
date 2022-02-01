import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCollectionViewCount;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzt
  extends ppw<qaz>
{
  public static final String CMD = ppf.fQ("StorySvc.get_colleciton_view_count");
  public List<pyb.a> gJ = new ArrayList();
  public String mUin;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCollectionViewCount localRspCollectionViewCount = new qqstory_service.RspCollectionViewCount();
    try
    {
      localRspCollectionViewCount.mergeFrom(paramArrayOfByte);
      return new qaz(this.mUin, localRspCollectionViewCount);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        ram.w("Q.qqstory:UpdateCollectionViewCountRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqCollectionViewCount localReqCollectionViewCount = new qqstory_service.ReqCollectionViewCount();
    Iterator localIterator = this.gJ.iterator();
    while (localIterator.hasNext())
    {
      pyb.a locala = (pyb.a)localIterator.next();
      localReqCollectionViewCount.collection_id.add(locala.a());
    }
    return localReqCollectionViewCount.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "UpdateCollectionViewCountRequest{mIdList=" + this.gJ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzt
 * JD-Core Version:    0.7.0.1
 */