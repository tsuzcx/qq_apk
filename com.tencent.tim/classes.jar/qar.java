import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qar
  extends ppu
{
  public final String avr;
  public final int blG;
  public final List<rmw> nD = new ArrayList();
  
  public qar(qqstory_service.RspGetTagList paramRspGetTagList)
  {
    Object localObject = paramRspGetTagList.tag_list.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        qqstory_struct.TagItem localTagItem = (qqstory_struct.TagItem)((Iterator)localObject).next();
        this.nD.add(new rmw(localTagItem));
      }
    }
    this.blG = paramRspGetTagList.is_end.get();
    this.avr = paramRspGetTagList.next_cookie.get();
  }
  
  public String toString()
  {
    return "GetTagListResponse{mTagItems=" + this.nD + ", mIsEnd=" + this.blG + ", mNextCookie='" + this.avr + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qar
 * JD-Core Version:    0.7.0.1
 */