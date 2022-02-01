import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;

public class yzg
{
  TroopInfo a;
  public boolean a;
  
  public yzg(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<yzg> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      yzg localyzg = new yzg(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localyzg.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localyzg);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzg
 * JD-Core Version:    0.7.0.1
 */