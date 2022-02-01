package com.tencent.mobileqq.troop.createNewTroop;

import aozi;
import aozi.a;
import aozj;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class RelationFriendsTroopViewHelper$4$1
  implements Runnable
{
  public RelationFriendsTroopViewHelper$4$1(aozj paramaozj, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.BL != null)
    {
      aozi.b(this.a.this$0).clear();
      int i = 0;
      if ((i < this.BL.size()) && (i < 5))
      {
        Object localObject = (RelationTroopEntity)this.BL.get(i);
        aozi.b(this.a.this$0).add(localObject);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("updateRelationTroops entityname:");
          if (((RelationTroopEntity)localObject).troopInfo != null) {
            break label115;
          }
        }
        label115:
        for (localObject = "null";; localObject = ((RelationTroopEntity)localObject).troopInfo.getTroopName())
        {
          QLog.i("RelationFriendsTroopViewHelper", 2, (String)localObject);
          i += 1;
          break;
        }
      }
      aozi.a(this.a.this$0).czX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.4.1
 * JD-Core Version:    0.7.0.1
 */