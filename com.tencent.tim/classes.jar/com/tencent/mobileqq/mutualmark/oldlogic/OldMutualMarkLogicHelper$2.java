package com.tencent.mobileqq.mutualmark.oldlogic;

import acff;
import ajol;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public final class OldMutualMarkLogicHelper$2
  implements Runnable
{
  public OldMutualMarkLogicHelper$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    acff localacff = (acff)this.val$app.getManager(51);
    if (localacff != null)
    {
      HashSet localHashSet = ajol.h();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localacff.iN(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2
 * JD-Core Version:    0.7.0.1
 */