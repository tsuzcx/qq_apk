import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import pb.unify.search.UnifySearchUnite.TabItemGroup;
import pb.unite.search.UniteSearch.TabItemGroup;

public class amps
{
  public List<Long> Ga;
  public String tabName;
  
  public amps() {}
  
  public amps(UnifySearchUnite.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup == null) {
      throw new RuntimeException("group is null in GroupTabModel Constructor.");
    }
    this.tabName = paramTabItemGroup.tab_name.get().toStringUtf8();
    this.Ga = paramTabItemGroup.rpt_group_mask.get();
  }
  
  public amps(UniteSearch.TabItemGroup paramTabItemGroup)
  {
    if (paramTabItemGroup == null) {
      throw new RuntimeException("group is null in GroupTabModel Constructor.");
    }
    this.tabName = paramTabItemGroup.tab_name.get().toStringUtf8();
    this.Ga = paramTabItemGroup.rpt_group_mask.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amps
 * JD-Core Version:    0.7.0.1
 */