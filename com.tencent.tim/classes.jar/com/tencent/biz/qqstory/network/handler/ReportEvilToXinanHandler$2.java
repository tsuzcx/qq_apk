package com.tencent.biz.qqstory.network.handler;

import acfp;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import org.json.JSONException;
import org.json.JSONObject;
import pmi;
import pxx;
import pxx.a;
import rar;

public class ReportEvilToXinanHandler$2
  implements Runnable
{
  public ReportEvilToXinanHandler$2(pxx parampxx, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int i = -1;
    try
    {
      j = new JSONObject(this.val$response).getInt("rtn_code");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        pxx.a locala;
        localJSONException.printStackTrace();
        continue;
        j = 2;
      }
      QQToast.a(BaseApplication.getContext(), acfp.m(2131713902), 0).show();
      if (!this.val$isVip) {
        break label205;
      }
    }
    if (i == 0)
    {
      QQToast.a(BaseApplication.getContext(), acfp.m(2131713901), 0).show();
      if (this.val$isVip)
      {
        j = 1;
        rar.a("play_video", "report_suc", j, 0, new String[] { this.avP, "", "", this.val$vid });
        locala = new pxx.a(new ErrorMessage(i, ""), this.val$vid, this.val$uin, this.avP);
        pmi.a().dispatch(locala);
        return;
      }
    }
    label205:
    for (int j = 1;; j = 2)
    {
      rar.a("play_video", "report_fail", j, 0, new String[] { this.avP, "", "", this.val$vid });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.2
 * JD-Core Version:    0.7.0.1
 */