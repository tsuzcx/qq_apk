import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTodayStoryVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Calendar;

public class qxd
  implements qxo
{
  protected qxo.a a;
  protected qxo.b a;
  protected qxd.a b;
  
  public Object D()
  {
    return this.b;
  }
  
  public boolean KH()
  {
    return false;
  }
  
  public void a(qxo.a parama)
  {
    this.jdField_a_of_type_Qxo$a = parama;
  }
  
  public void a(qxo.b paramb)
  {
    this.jdField_a_of_type_Qxo$b = paramb;
  }
  
  public void an(Object paramObject) {}
  
  protected void brs()
  {
    String str = ppf.fQ("StorySvc.homepage_my_day_710");
    qqstory_service.ReqTodayStoryVidList localReqTodayStoryVidList = new qqstory_service.ReqTodayStoryVidList();
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localReqTodayStoryVidList.date.set(i * 10000 + (j + 1) * 100 + k);
    this.b = new qxd.a();
    ppv.a().a(new pyl(str, localReqTodayStoryVidList, null), new qxe(this, localReqTodayStoryVidList, str));
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return getClass().getSimpleName();
  }
  
  public void reset() {}
  
  public void run()
  {
    ram.i("GetMyStoryVideoListStep", "GetMyStoryVideoListStep");
    brs();
  }
  
  public static class a
  {
    public boolean aFS;
    public final PBRepeatMessageField<qqstory_struct.UserVidList> b;
    public ptp b;
    public int errorCode;
    public String feedId = "";
    public final ArrayList<String> nq = new ArrayList();
    
    public a()
    {
      this(0, null);
    }
    
    public a(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
    {
      this.jdField_b_of_type_Ptp = new ptp();
      this.errorCode = paramInt;
      this.jdField_b_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
    }
    
    public static a a(String paramString)
    {
      a locala = new a();
      locala.feedId = paramString;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxd
 * JD-Core Version:    0.7.0.1
 */