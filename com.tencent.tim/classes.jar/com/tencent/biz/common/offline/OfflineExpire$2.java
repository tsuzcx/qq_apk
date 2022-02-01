package com.tencent.biz.common.offline;

import aopo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jpe;
import jpf;
import jpf.b;

public final class OfflineExpire$2
  implements Runnable
{
  public OfflineExpire$2(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.bW.get();
    if (localObject == null)
    {
      QLog.i(jpf.TAG, 1, "app == null, download wont start");
      return;
    }
    localObject = (aopo)((QQAppInterface)localObject).getManager(193);
    int k = this.jl.size();
    int i = 0;
    label50:
    jpf.b localb;
    String str1;
    String str2;
    String str3;
    if (i < k)
    {
      localb = (jpf.b)this.jl.get(i);
      str1 = localb.a.mBusinessId;
      str2 = localb.a.url;
      str3 = localb.a.TM;
      if (!localb.a.aaY) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 2)
    {
      boolean bool = ((aopo)localObject).a(10066, "app", str1, k - i, str2, str3, j, 0, jpe.dk(localb.a.mBusinessId), localb);
      QLog.i(jpf.TAG, 1, "requestPreDownload bid=" + localb.a.mBusinessId + " re=" + bool);
      i += 1;
      break label50;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.2
 * JD-Core Version:    0.7.0.1
 */