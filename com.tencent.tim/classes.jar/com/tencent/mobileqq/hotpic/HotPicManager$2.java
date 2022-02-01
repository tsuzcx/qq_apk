package com.tencent.mobileqq.hotpic;

import ahzd;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HotPicManager$2
  implements Runnable
{
  public HotPicManager$2(ahzd paramahzd, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.drb();
    switch (this.JC)
    {
    default: 
    case 10001: 
      do
      {
        return;
        if ((this.this$0.cjg) || (this.this$0.aoB())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotPicManager", 2, "cancel request");
      return;
      boolean bool = this.this$0.kb(this.GD);
      localObject = this.this$0;
      int j = this.this$0.Ft();
      int k = this.GD;
      if (bool) {}
      for (i = 10003;; i = 10002)
      {
        ((ahzd)localObject).b(0, 15, j, k, true, i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HotPicManager", 2, "request REQ_CHECK_UPDATE getLoaclVersion is " + this.this$0.Ft());
        return;
      }
    case 10002: 
      localArrayList = (ArrayList)ahzd.a(this.this$0).get(this.GD);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        ahzd.a(this.this$0).put(this.GD, localObject);
      }
      i = ((ArrayList)localObject).size();
      this.this$0.b(i, 16 + i - 1, this.this$0.Ft(), this.GD, false, this.JC);
      return;
    }
    ArrayList localArrayList = (ArrayList)ahzd.a(this.this$0).get(this.GD);
    Object localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      ahzd.a(this.this$0).put(this.GD, localObject);
    }
    int i = ((ArrayList)localObject).size();
    this.this$0.b(i, 8 + i - 1, this.this$0.Ft(), this.GD, false, this.JC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.2
 * JD-Core Version:    0.7.0.1
 */