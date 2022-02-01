package com.tencent.mobileqq.util;

import java.util.HashMap;

public final class KeepAliveGuideUtil$1
  extends HashMap<String, String[]>
{
  public KeepAliveGuideUtil$1()
  {
    put("HUAWEI", new String[] { "com.huawei.systemmanager/com.huawei.systemmanager.optimize.process.ProtectActivity" });
    put("Xiaomi", new String[] { "com.miui.securitycenter/com.miui.optimizemanage.memoryclean.LockAppManageActivity", "com.miui.cleanmaster/com.miui.optimizecenter.whitelist.WhiteListActivity", "com.miui.securitycenter/com.miui.optimizecenter.whitelist.WhiteListActivity" });
    put("samsung", new String[] { "com.samsung.android.sm_cn/com.samsung.android.sm.ui.battery.BatteryActivity", "com.samsung.android.sm/.ui.ram.RamActivity", "com.samsung.memorymanager/.FragmentTabsActivity" });
    put("OPPO", new String[] { "com.coloros.oppoguardelf/com.coloros.powermanager.fuelgaue.PowerConsumptionActivity", "com.oppo.purebackground/.PurebackgroundTopActivity" });
    put("vivo", new String[] { "com.vivo.abe/com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity", "com.iqoo.secure/.ui.phoneoptimize.AddWhiteListActivity" });
    put("Meizu", new String[] { "com.meizu.safe/.permission.SmartBGActivity", "com.meizu.safe/.ramcleaner.RAMCleanerWhiteList", "com.aliyun.SecurityCenter/.applications.MemoryOptimizationIgnoreActivity" });
    put("Letv", new String[] { "com.letv.android.letvsafe/.BackgroundAppManageActivity" });
    put("LeMobile", new String[] { "com.letv.android.letvsafe/.BackgroundAppManageActivity" });
    put("GIONEE", new String[] { "com.gionee.softmanager/.oneclean.WhiteListMrgActivity" });
    put("GiONEE", new String[] { "com.gionee.softmanager/.oneclean.WhiteListMrgActivity" });
    put("ALL", new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.KeepAliveGuideUtil.1
 * JD-Core Version:    0.7.0.1
 */