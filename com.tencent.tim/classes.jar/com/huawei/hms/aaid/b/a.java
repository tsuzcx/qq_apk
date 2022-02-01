package com.huawei.hms.aaid.b;

import android.content.Context;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class a
  implements Callable<AAIDResult>
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public AAIDResult call()
    throws Exception
  {
    if (this.a == null) {
      throw com.huawei.hms.aaid.constant.a.a(com.huawei.hms.aaid.constant.a.s);
    }
    String str = com.huawei.hms.aaid.c.a.b(this.a);
    AAIDResult localAAIDResult = new AAIDResult();
    localAAIDResult.setId(str);
    return localAAIDResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.b.a
 * JD-Core Version:    0.7.0.1
 */