package com.tencent.mobileqq.highway.conn;

class ConnManager$1
  implements Runnable
{
  ConnManager$1(ConnManager paramConnManager, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    ConnManager localConnManager = this.this$0;
    int i = this.val$netType;
    if (!this.val$ipv6First) {}
    for (boolean bool = true;; bool = false)
    {
      ConnManager.access$000(localConnManager, i, false, bool);
      ConnManager.access$100(this.this$0).mRacingRunnable = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager.1
 * JD-Core Version:    0.7.0.1
 */