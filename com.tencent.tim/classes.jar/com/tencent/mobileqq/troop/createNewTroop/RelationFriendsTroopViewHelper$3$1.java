package com.tencent.mobileqq.troop.createNewTroop;

import aozi;
import aozi.a;
import java.util.ArrayList;

class RelationFriendsTroopViewHelper$3$1
  implements Runnable
{
  RelationFriendsTroopViewHelper$3$1(RelationFriendsTroopViewHelper.3 param3, ArrayList paramArrayList) {}
  
  public void run()
  {
    aozi.a(this.a.this$0).clear();
    if (this.BK.size() > 0)
    {
      int i = 0;
      while ((i < this.BK.size()) && (i < 5))
      {
        aozi.a(this.a.this$0).add(this.BK.get(i));
        i += 1;
      }
    }
    aozi.a(this.a.this$0).czX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.3.1
 * JD-Core Version:    0.7.0.1
 */