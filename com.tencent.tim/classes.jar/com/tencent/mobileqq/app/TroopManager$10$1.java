package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopManager$10$1
  implements Runnable
{
  TroopManager$10$1(TroopManager.10 param10, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    Object localObject = (List)this.a.this$0.js.remove(this.a.Uf + "_" + this.a.aMs);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "getTroopMemberInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopManager.b localb = (TroopManager.b)((WeakReference)((Iterator)localObject).next()).get();
      if (localb != null) {
        localb.b(this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.10.1
 * JD-Core Version:    0.7.0.1
 */