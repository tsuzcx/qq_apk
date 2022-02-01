package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Build;
import android.os.Build.VERSION;
import anpc;
import aqgz;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3
  implements Runnable
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_model", Build.MODEL);
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_qqVer", String.valueOf("3.4.4.3058"));
      localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
      localHashMap.put("param_availableMem", String.valueOf(this.sa));
      localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
      localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
      localHashMap.put("param_clickToCreate", String.valueOf(this.this$0.mCreateTime - this.sb));
      localHashMap.put("param_clickToLoadUrl", String.valueOf(this.this$0.rY - this.sb));
      localHashMap.put("param_clickToPageStart", String.valueOf(this.this$0.mPageStartTime - this.sb));
      localHashMap.put("param_clickToPageFinish", String.valueOf(this.this$0.rZ - this.sb));
      localHashMap.put("param_isSupportNative", this.this$0.Zl);
      localHashMap.put("param_toolProcessLevel", String.valueOf(this.aIJ));
      localHashMap.put("param_inPreloadWhiteList", String.valueOf(this.aeX));
      localHashMap.put("param_uin", this.this$0.mApp.getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.TAG, 2, "doOpenReportAsync:" + localHashMap.toString());
      }
      anpc.a(this.this$0.getActivity()).collectPerformance(this.this$0.mApp.getCurrentAccountUin(), "actReadInJoyArticleOpen", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */