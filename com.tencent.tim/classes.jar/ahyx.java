import android.util.SparseArray;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import java.util.ArrayList;
import java.util.List;

public class ahyx
{
  private SparseArray<HotPicTagInfo> cI = new SparseArray();
  private ArrayList<HotPicTagInfo> xk = new ArrayList();
  
  public HotPicTagInfo a(int paramInt)
  {
    return (HotPicTagInfo)this.cI.get(paramInt);
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    this.xk.add(paramHotPicTagInfo);
    this.cI.put(paramHotPicTagInfo.tagId, paramHotPicTagInfo);
  }
  
  public HotPicTagInfo b(int paramInt)
  {
    return (HotPicTagInfo)this.xk.get(paramInt);
  }
  
  public void clear()
  {
    this.xk.clear();
    this.cI.clear();
  }
  
  public List<HotPicTagInfo> fk()
  {
    return this.xk;
  }
  
  public int size()
  {
    return this.xk.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyx
 * JD-Core Version:    0.7.0.1
 */