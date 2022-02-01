package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashSet;
import java.util.Set;

public class MiniAppUtils
{
  private static final Set<Integer> PULL_DOWN_REFER = new HashSet();
  
  static
  {
    PULL_DOWN_REFER.add(Integer.valueOf(3001));
    PULL_DOWN_REFER.add(Integer.valueOf(3002));
    PULL_DOWN_REFER.add(Integer.valueOf(3003));
    PULL_DOWN_REFER.add(Integer.valueOf(3004));
    PULL_DOWN_REFER.add(Integer.valueOf(3005));
    PULL_DOWN_REFER.add(Integer.valueOf(3006));
    PULL_DOWN_REFER.add(Integer.valueOf(3007));
    PULL_DOWN_REFER.add(Integer.valueOf(3008));
    PULL_DOWN_REFER.add(Integer.valueOf(3009));
    PULL_DOWN_REFER.add(Integer.valueOf(3010));
    PULL_DOWN_REFER.add(Integer.valueOf(3011));
    PULL_DOWN_REFER.add(Integer.valueOf(3012));
    PULL_DOWN_REFER.add(Integer.valueOf(3013));
    PULL_DOWN_REFER.add(Integer.valueOf(1001));
    PULL_DOWN_REFER.add(Integer.valueOf(1022));
  }
  
  public static boolean isFromPullDownEntry(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (PULL_DOWN_REFER.contains(Integer.valueOf(paramMiniAppInfo.launchParam.scene)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppUtils
 * JD-Core Version:    0.7.0.1
 */