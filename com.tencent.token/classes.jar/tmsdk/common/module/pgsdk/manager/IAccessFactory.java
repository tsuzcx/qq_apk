package tmsdk.common.module.pgsdk.manager;

import android.content.Context;
import taiji.b;
import taiji.cq;

public abstract interface IAccessFactory
{
  public abstract int canPlay(Context paramContext);
  
  public abstract void cancelPlay();
  
  public abstract void startPlay(Context paramContext, b paramb, cq paramcq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.IAccessFactory
 * JD-Core Version:    0.7.0.1
 */