package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import kxm;
import kxm.b;
import kyn;
import mgu;
import org.json.JSONException;

class ReadInJoyChannelPanelFragment$7
  implements Runnable
{
  ReadInJoyChannelPanelFragment$7(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, TabChannelCoverInfo paramTabChannelCoverInfo, mgu parammgu, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = kyn.a(kxm.getAppRuntime(), this.b.mChannelCoverId);
      ReadInJoyChannelPanelFragment.C("0X8009954", new kxm.b().a(this.b.mChannelCoverId).c().n(ReadInJoyChannelPanelFragment.a(this.b)).b(this.a.aRE + 1).c(this.aOd).b("is_change", i).b("style", 0).build());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "reportChannelExposure exception ", localJSONException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.7
 * JD-Core Version:    0.7.0.1
 */