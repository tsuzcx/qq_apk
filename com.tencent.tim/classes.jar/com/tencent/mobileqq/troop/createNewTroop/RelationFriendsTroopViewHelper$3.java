package com.tencent.mobileqq.troop.createNewTroop;

import aozf;
import aozi;
import aozi.a;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

public class RelationFriendsTroopViewHelper$3
  implements Runnable
{
  public RelationFriendsTroopViewHelper$3(aozi paramaozi, String paramString) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.this$0.b.ab(this.val$uin);
    if (localArrayList1 == null) {
      QLog.i("RelationFriendsTroopViewHelper", 1, "updateRelationFriends searchend result null,uin:" + this.val$uin);
    }
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    int j;
    Friends localFriends;
    do
    {
      return;
      QLog.i("RelationFriendsTroopViewHelper", 1, "updateRelationFriends startsearch uin:" + this.val$uin + ",resultsize:" + localArrayList1.size());
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList3.addAll(aozi.a(this.this$0).cf());
      i = 0;
      j = 0;
      if (i < localArrayList1.size())
      {
        localFriends = (Friends)localArrayList1.get(i);
        if (j < 5) {
          break;
        }
      }
    } while (this.this$0.a == null);
    this.this$0.a.post(new RelationFriendsTroopViewHelper.3.1(this, localArrayList2));
    return;
    if (localArrayList3.contains(localFriends.uin)) {}
    for (int m = 1;; m = 0)
    {
      int k = j;
      if (m == 0)
      {
        localArrayList2.add(localFriends);
        j += 1;
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationFriends relationuin:" + localFriends.uin);
          k = j;
        }
      }
      i += 1;
      j = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.3
 * JD-Core Version:    0.7.0.1
 */