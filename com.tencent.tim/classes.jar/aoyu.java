import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

public class aoyu
  implements aozi.a
{
  public aoyu(NewTroopContactView paramNewTroopContactView) {}
  
  public ArrayList<ResultRecord> ce()
  {
    return this.b.aQ;
  }
  
  public ArrayList<String> cf()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.b.aQ.size())
    {
      localArrayList.add(((ResultRecord)this.b.aQ.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  public void czX()
  {
    this.b.a.notifyDataSetChanged();
    if (this.b.a.getGroupCount() > 0)
    {
      Groups localGroups1 = this.b.a.a(1007L);
      Groups localGroups2 = this.b.a.a(1008L);
      if ((localGroups1 != null) || (localGroups2 != null))
      {
        this.b.b.expandGroup(0);
        this.b.b.setIsNeedScrollPositionTop(true);
        this.b.b.smoothScrollToPositionFromTop(1, 0, 0);
      }
      if (localGroups1 != null) {
        this.b.c.dYb();
      }
      if (localGroups2 != null) {
        this.b.c.dYd();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyu
 * JD-Core Version:    0.7.0.1
 */