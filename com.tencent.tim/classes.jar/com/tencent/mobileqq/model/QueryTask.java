package com.tencent.mobileqq.model;

import ajdq;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public a<Param, Result> a;
  public ajdq<Result> b;
  private Param param;
  
  public QueryTask(a<Param, Result> parama, ajdq<Result> paramajdq)
  {
    this.a = parama;
    this.b = paramajdq;
  }
  
  public void bq(Param paramParam)
  {
    this.param = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.a.c(this.param);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
  
  public static abstract interface a<P, R>
  {
    public abstract R c(P paramP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */