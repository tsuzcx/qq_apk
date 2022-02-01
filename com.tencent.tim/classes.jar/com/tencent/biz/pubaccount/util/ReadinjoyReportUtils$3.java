package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.text.TextUtils;
import aqmj;
import awit;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import kbp;
import kxm;
import kxm.b;
import mfo;
import mfs;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tlb;

public final class ReadinjoyReportUtils$3
  implements Runnable
{
  public ReadinjoyReportUtils$3(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    int m = 0;
    Object localObject2 = "0";
    int k = 0;
    if (this.bex == 0) {
      if (!(this.val$activity instanceof BaseActivity)) {
        break label631;
      }
    }
    label589:
    label609:
    label631:
    for (boolean bool1 = aqmj.aJ(this.val$activity, ((BaseActivity)this.val$activity).getCurrentAccountUin());; bool1 = false)
    {
      if ((this.val$activity instanceof BaseActivity)) {}
      for (Object localObject1 = ((mfs)((BaseActivity)this.val$activity).app.getManager(261)).jM();; localObject1 = "0")
      {
        int i;
        Object localObject3;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0")))
        {
          j = 0;
          localObject1 = "0";
          i = 0;
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!(this.val$activity instanceof BaseActivity)) {
            break label609;
          }
          localObject3 = (mfo)((BaseActivity)this.val$activity).app.getManager(270);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (((mfo)localObject3).oH() != 1) {
            break label609;
          }
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!((mfo)localObject3).Dz()) {
            break label609;
          }
          localObject1 = ((mfo)localObject3).jL();
          bool1 = ((mfo)localObject3).Dy();
          i = 0;
        }
        for (int j = 2;; j = k)
        {
          for (;;)
          {
            if (this.bex != 40677)
            {
              localObject2 = mfo.b(this.val$activity, 0);
              if ((!(this.val$activity instanceof BaseActivity)) || (this.bex != 0) || (localObject2 == null) || (!((RefreshData)localObject2).isAD) || (((RefreshData)localObject2).adExposureReports == null) || (((RefreshData)localObject2).adExposureReports.size() <= 0)) {}
            }
            try
            {
              localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo();
              long l = ((RefreshData)localObject2).adId.longValue();
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).report_info.trace_info.aid.set(l);
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adExposureReports));
              tlb.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject3);
              m = this.bex;
              boolean bool2 = this.awC;
              if (bool1)
              {
                k = 1;
                localObject3 = kxm.a(m, (String)localObject1, i, j, bool2, k);
                if ((this.bex == 0) && (localObject2 == null)) {
                  break label589;
                }
              }
              try
              {
                if (!((RefreshData)localObject2).isAD) {
                  break label589;
                }
                k = 1;
                ((kxm.b)localObject3).a("ad_page", k);
                ((kxm.b)localObject3).a("banner_refresh_length", this.bey);
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  localJSONException.printStackTrace();
                  continue;
                  k = 0;
                }
              }
              kbp.a(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", ((kxm.b)localObject3).build(), false);
              kbp.d("0X80066F8", "", "", "", "", kxm.bc(this.bex));
              if (this.bex == 70)
              {
                localObject2 = awit.sn("default_feeds_proteus_offline_bid");
                m = this.bex;
                bool2 = this.awC;
                if (bool1)
                {
                  k = 1;
                  kbp.a(null, "CliOper", "", "", "0X8009861", "0X8009861", 0, 0, (String)localObject2, "", "", kxm.a(m, (String)localObject1, i, j, bool2, k).build(), false);
                  kbp.d("0X8009861", "", "", "", "", kxm.bc(this.bex));
                }
              }
              else
              {
                return;
                if (bool1)
                {
                  i = 1;
                  j = 1;
                  break;
                }
                i = 1;
                j = 2;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                localNumberFormatException.printStackTrace();
                continue;
                k = 0;
                continue;
                k = 0;
              }
            }
          }
          bool1 = false;
          localObject1 = localJSONException;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */