package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;

final class i$1
  implements OnSuccessListener<TResult>
{
  i$1(i parami1, SuccessContinuation paramSuccessContinuation, i parami2) {}
  
  public final void onSuccess(TResult paramTResult)
  {
    try
    {
      paramTResult = this.a.then(paramTResult);
      if (paramTResult == null)
      {
        this.b.a(new NullPointerException("SuccessContinuation returned null"));
        return;
      }
    }
    catch (Exception paramTResult)
    {
      this.b.a(paramTResult);
      return;
    }
    paramTResult.addOnCompleteListener(new i.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.i.1
 * JD-Core Version:    0.7.0.1
 */