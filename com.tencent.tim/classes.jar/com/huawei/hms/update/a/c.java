package com.huawei.hms.update.a;

import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.utils.Checker;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class c
  implements a
{
  private static final Executor a = ;
  private final a b;
  
  public c(a parama)
  {
    Checker.checkNonNull(parama, "update must not be null.");
    this.b = parama;
  }
  
  private static b b(b paramb)
  {
    return new c.1(paramb);
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(b paramb, com.huawei.hms.update.a.a.c paramc)
  {
    a.execute(new c.2(this, paramb, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.a.c
 * JD-Core Version:    0.7.0.1
 */