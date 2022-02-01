package com.tencent.mobileqq.util;

import aqdk.a;
import aqdk.b;
import aqdk.f;
import aqdm;

public class FaceManager$1
  implements Runnable
{
  public FaceManager$1(aqdm paramaqdm, Object paramObject, int paramInt, boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if ((this.fs instanceof aqdk.b)) {
      switch (this.val$type)
      {
      }
    }
    do
    {
      return;
      ((aqdk.b)this.fs).onUpdateMobileQQHead(this.val$isSuccess, (String)this.val$args[0]);
      return;
      ((aqdk.b)this.fs).onUpdateCustomHead(this.val$isSuccess, (String)this.val$args[0]);
      return;
      ((aqdk.b)this.fs).onUpdateTroopHead(this.val$isSuccess, (String)this.val$args[0]);
      return;
      ((aqdk.b)this.fs).onUpdateStrangerHead(this.val$isSuccess, (String)this.val$args[0], ((Integer)this.val$args[1]).intValue(), ((Boolean)this.val$args[2]).booleanValue());
      return;
      ((aqdk.b)this.fs).onUpdateQCallHead(this.val$isSuccess, (String)this.val$args[0], ((Integer)this.val$args[1]).intValue(), ((Boolean)this.val$args[2]).booleanValue());
      return;
      if ((this.fs instanceof aqdk.a))
      {
        switch (this.val$type)
        {
        default: 
          return;
        }
        ((aqdk.a)this.fs).d(this.val$isSuccess, ((Boolean)this.val$args[0]).booleanValue(), (String)this.val$args[1]);
        return;
      }
    } while (!(this.fs instanceof aqdk.f));
    switch (this.val$type)
    {
    default: 
      return;
    }
    ((aqdk.f)this.fs).m(this.val$isSuccess, ((Boolean)this.val$args[0]).booleanValue(), (String)this.val$args[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceManager.1
 * JD-Core Version:    0.7.0.1
 */