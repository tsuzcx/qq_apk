import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ptz
{
  public int bkr;
  public int bks;
  public List<String> mA;
  public List<String> mB;
  
  public ptz(qqstory_struct.VideoSpreadGroupList paramVideoSpreadGroupList)
  {
    if (paramVideoSpreadGroupList == null) {}
    for (;;)
    {
      return;
      this.bkr = paramVideoSpreadGroupList.visibility_type.get();
      int k;
      int i;
      if ((paramVideoSpreadGroupList.group_list != null) && (paramVideoSpreadGroupList.group_list.has()))
      {
        k = paramVideoSpreadGroupList.group_list.size();
        this.mA = new ArrayList(k);
        i = 0;
        while (i < k)
        {
          this.mA.add(String.valueOf(((Long)paramVideoSpreadGroupList.group_list.get(i)).longValue()));
          i += 1;
        }
      }
      this.bks = paramVideoSpreadGroupList.visibility_sharegroup_type.get();
      if ((paramVideoSpreadGroupList.share_group_list != null) && (paramVideoSpreadGroupList.share_group_list.has()))
      {
        k = paramVideoSpreadGroupList.share_group_list.size();
        this.mB = new ArrayList(k);
        i = j;
        while (i < k)
        {
          this.mB.add(((ByteStringMicro)paramVideoSpreadGroupList.share_group_list.get(i)).toStringUtf8());
          i += 1;
        }
      }
    }
  }
  
  public ptz(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mA = paramList;
    this.bkr = 2;
    this.bks = 2;
  }
  
  public static boolean a(ptz paramptz)
  {
    return (paramptz == null) || (paramptz.mA == null) || (paramptz.mA.isEmpty());
  }
  
  public qqstory_struct.VideoSpreadGroupList a()
  {
    qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
    localVideoSpreadGroupList.setHasFlag(false);
    Iterator localIterator;
    String str;
    if ((this.mA != null) && (!this.mA.isEmpty()))
    {
      localVideoSpreadGroupList.visibility_type.set(this.bkr);
      localIterator = this.mA.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localVideoSpreadGroupList.group_list.add(Long.valueOf(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    if ((this.mB != null) && (!this.mB.isEmpty()))
    {
      localVideoSpreadGroupList.visibility_sharegroup_type.set(this.bks);
      localIterator = this.mB.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    return localVideoSpreadGroupList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptz
 * JD-Core Version:    0.7.0.1
 */