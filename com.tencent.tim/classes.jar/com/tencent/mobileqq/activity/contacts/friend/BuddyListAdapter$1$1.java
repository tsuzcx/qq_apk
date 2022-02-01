package com.tencent.mobileqq.activity.contacts.friend;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zam;

class BuddyListAdapter$1$1
  implements Runnable
{
  BuddyListAdapter$1$1(BuddyListAdapter.1 param1, ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    zam.a(this.a.this$0, this.val$groups);
    zam.a(this.a.this$0, this.bI);
    zam.a(this.a.this$0, this.N);
    ((FPSPinnedHeaderExpandableListView)zam.a(this.a.this$0)).AP();
    zam.a(this.a.this$0);
    if (zam.a(this.a.this$0))
    {
      zam.a(this.a.this$0, false);
      zam.b(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */