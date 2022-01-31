package com.tencent.service.update;

import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.ISharkCallBackOut;

class s
  implements ISharkCallBackOut
{
  s(k paramk, d paramd) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (paramInt3 == 0)
    {
      Log.i("UpdateManager", "DoubleCheck : " + paramInt1 + "|" + paramInt2 + "|" + paramInt3 + "|" + paramInt4);
      if (paramInt2 == 13150)
      {
        try
        {
          paramJceStruct = (SCDCheckRes)paramJceStruct;
          Log.i("UpdateManager", "DoubleCheck : " + paramJceStruct.retCode + "|" + paramJceStruct.res);
          if (paramJceStruct.retCode == 0)
          {
            if (paramJceStruct.res == 0)
            {
              this.a.b();
              return;
            }
            if (paramJceStruct.res != 1) {
              return;
            }
            this.a.a();
            return;
          }
        }
        catch (Exception paramJceStruct)
        {
          this.a.c();
          paramJceStruct.printStackTrace();
          return;
        }
        this.a.c();
      }
      else
      {
        this.a.c();
      }
    }
    else
    {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.s
 * JD-Core Version:    0.7.0.1
 */