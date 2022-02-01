package com.tencent.biz.pubaccount.readinjoy.engine;

import affn;
import affo;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jqc;
import lci;
import lci.a;
import lcl;
import org.json.JSONObject;

public final class ReadInjoyWebRenderSoLoader$1
  implements Runnable
{
  public ReadInjoyWebRenderSoLoader$1(lci.a parama) {}
  
  public void run()
  {
    Object localObject = lcl.access$000();
    int j;
    int i;
    label124:
    boolean bool;
    for (;;)
    {
      try
      {
        String str = jqc.a(BaseApplication.context, (String)localObject, "GET", null, null);
        if (QLog.isColorLevel()) {
          QLog.d("viola.ReadInjoyWebRenderSoLoader", 2, "open :" + (String)localObject + ", result: " + str);
        }
        if (TextUtils.isEmpty(str))
        {
          lcl.access$100();
          lci.a("viola.ReadInjoyWebRenderSoLoader", this.a);
          return;
        }
        localObject = new JSONObject(str);
        if (((JSONObject)localObject).optInt("reJSC", 0) != 1) {
          break label286;
        }
        j = 1;
        if (((JSONObject)localObject).optInt("reBiz", 0) != 1) {
          break label291;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        label183:
        lcl.access$100();
        lcl.access$300();
        return;
      }
      if (j < affo.eX.length)
      {
        if ((!bool) || (!lcl.ah(affo.eX[j]))) {
          break label296;
        }
        bool = true;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delJSC : " + bool);
      }
      lcl.access$100();
      if (i != 0)
      {
        i = 0;
        bool = true;
        if (i < affn.eX.length)
        {
          if ((!bool) || (!lcl.ah(affn.eX[i]))) {
            break label308;
          }
          bool = true;
          break label301;
        }
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delBiz : " + bool);
        }
      }
      lcl.access$300();
      continue;
      label268:
      if (j == 0) {
        break label294;
      }
      j = 0;
      bool = true;
    }
    for (;;)
    {
      j += 1;
      break label124;
      label286:
      j = 0;
      break;
      label291:
      i = 0;
      break label268;
      label294:
      break label183;
      label296:
      bool = false;
    }
    for (;;)
    {
      label301:
      i += 1;
      break;
      label308:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader.1
 * JD-Core Version:    0.7.0.1
 */