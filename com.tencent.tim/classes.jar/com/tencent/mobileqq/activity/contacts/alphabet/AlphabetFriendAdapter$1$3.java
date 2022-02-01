package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import yyy;

class AlphabetFriendAdapter$1$3
  implements Runnable
{
  AlphabetFriendAdapter$1$3(AlphabetFriendAdapter.1 param1, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    this.a.this$0.D = ((LinkedHashMap)this.p[0]);
    this.a.this$0.ad = ((int[])this.p[1]);
    this.a.this$0.k = ((String[])this.p[2]);
    yyy.b(this.a.this$0);
    this.a.this$0.cmX();
    yyy.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.1.3
 * JD-Core Version:    0.7.0.1
 */