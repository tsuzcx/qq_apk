import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.a;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.b;
import java.util.ArrayList;

class apbe
  implements TroopSearchLogic.b
{
  apbe(apbc paramapbc, apbc.b paramb) {}
  
  public void onResult(ArrayList<TroopSearchLogic.a> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RelationTroopEntity localRelationTroopEntity = new RelationTroopEntity();
      localRelationTroopEntity.troopInfo = ((TroopSearchLogic.a)paramArrayList.get(i)).troopInfo;
      localArrayList.add(localRelationTroopEntity);
      i += 1;
    }
    this.a.eX(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbe
 * JD-Core Version:    0.7.0.1
 */