package com.tencent.thumbplayer.common.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPBeaconReportWrapper
{
  private static final String APP_KEY = "00000GODBG3702Y1";
  private static final String TAG = "TPBeaconReportWrapper";
  
  public static void init(Context paramContext)
  {
    TPLogUtil.i("TPBeaconReportWrapper", "Beacon sdk init.");
    BeaconConfig.builder();
    BeaconReport.getInstance().setCollectMac(false);
    if ((!TextUtils.isEmpty(TPPlayerConfig.beacon_policy_host)) && (!TextUtils.isEmpty(TPPlayerConfig.beacon_log_host))) {
      UserAction.setReportDomain(TPPlayerConfig.beacon_policy_host, TPPlayerConfig.beacon_log_host);
    }
    BeaconAdapter.registerTunnel("00000GODBG3702Y1", "", "");
  }
  
  public static void trackCustomKVEvent(String paramString, ITPReportProperties paramITPReportProperties)
  {
    HashMap localHashMap = new HashMap();
    paramITPReportProperties.propertiesToMap(localHashMap);
    trackCustomKVEvent(paramString, "00000GODBG3702Y1", localHashMap);
  }
  
  public static void trackCustomKVEvent(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    BeaconAdapter.onUserActionToTunnel(paramString2, paramString1, true, -1L, -1L, paramMap, true, true);
  }
  
  public static void trackCustomKVEvent(String paramString, Map<String, String> paramMap)
  {
    trackCustomKVEvent(paramString, "00000GODBG3702Y1", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.common.report.TPBeaconReportWrapper
 * JD-Core Version:    0.7.0.1
 */