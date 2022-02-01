import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class zjn
{
  TroopInfo a;
  public boolean a;
  
  public zjn(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<zjn> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      zjn localzjn = new zjn(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localzjn.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localzjn);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjn
 * JD-Core Version:    0.7.0.1
 */