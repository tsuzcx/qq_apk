import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class vtg
{
  TroopInfo a;
  public boolean a;
  
  public vtg(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<vtg> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      vtg localvtg = new vtg(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
        localvtg.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localvtg);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vtg
 * JD-Core Version:    0.7.0.1
 */