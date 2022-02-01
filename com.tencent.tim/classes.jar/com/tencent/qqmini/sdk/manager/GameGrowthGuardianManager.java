package com.tencent.qqmini.sdk.manager;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GameGrowthGuardianManager
{
  private static final String ENABLE_HEART_BEAT_APPID_WHITELIST;
  private static final String ENABLE_HEART_BEAT_SCENE_WHITELIST;
  private static final String ENABLE_HEART_BEAT_VIA_WHITELIST;
  private static final int GUARD_INSTRUCTION_TYPE_REAL_NAME_AUTHENTICATE = 7;
  private static final int JUDGE_TIMING_REQUEST_BEGIN_DELAY = WnsConfig.getConfig("qqminiapp", "mini_game_judge_timing_request_begin_delay", 1000);
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_BEGIN = 11;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_END = 13;
  private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_HEARTBEAT = 12;
  private static final String TAG = "GameGrowthGuardianManager";
  private static long beginExecuteMillis;
  private static Runnable heartBeatRunnable = null;
  private static boolean isForeground;
  private static COMM.StCommonExt previousExtInfo;
  private static OnStopCallback sOnStopCallback;
  
  static
  {
    ENABLE_HEART_BEAT_SCENE_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_scene_whitelist", "");
    ENABLE_HEART_BEAT_APPID_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_appid_whitelist", "");
    ENABLE_HEART_BEAT_VIA_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_via_whitelist", "");
    previousExtInfo = null;
    isForeground = false;
    beginExecuteMillis = 0L;
    sOnStopCallback = null;
  }
  
  private static boolean enableHeartBeatCheck(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isEngineTypeMiniGame()) {}
      while ((!paramMiniAppInfo.isEngineTypeMiniGame()) && (enableHeartBeatForMiniApp(paramMiniAppInfo))) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  private static boolean enableHeartBeatForMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = false;
    if (paramMiniAppInfo != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (paramMiniAppInfo.launchParam == null) {
          break label260;
        }
        i = paramMiniAppInfo.launchParam.scene;
        if (paramMiniAppInfo != null)
        {
          str1 = paramMiniAppInfo.via;
          if ((i == 2093) || ("2016_4".equals(str1))) {
            break label267;
          }
          if (!TextUtils.isEmpty(ENABLE_HEART_BEAT_SCENE_WHITELIST))
          {
            arrayOfString = ENABLE_HEART_BEAT_SCENE_WHITELIST.split(",");
            if (arrayOfString != null)
            {
              int k = arrayOfString.length;
              j = 0;
              if (j < k)
              {
                if (i != Integer.parseInt(arrayOfString[j])) {
                  break label273;
                }
                return true;
              }
            }
          }
          if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(ENABLE_HEART_BEAT_APPID_WHITELIST)))
          {
            arrayOfString = ENABLE_HEART_BEAT_APPID_WHITELIST.split(",");
            if (arrayOfString != null)
            {
              j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                if (!paramMiniAppInfo.appId.equals(str2)) {
                  break label280;
                }
                return true;
              }
            }
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(ENABLE_HEART_BEAT_VIA_WHITELIST)) {
            break label270;
          }
          paramMiniAppInfo = ENABLE_HEART_BEAT_VIA_WHITELIST.split(",");
          bool1 = bool2;
          if (paramMiniAppInfo == null) {
            break label270;
          }
          j = paramMiniAppInfo.length;
          i = 0;
          bool1 = bool2;
          if (i >= j) {
            break label270;
          }
          String[] arrayOfString = paramMiniAppInfo[i];
          if (arrayOfString != null)
          {
            bool1 = arrayOfString.equals(str1);
            if (bool1) {
              return true;
            }
          }
          i += 1;
          continue;
        }
        String str1 = null;
      }
      catch (Exception paramMiniAppInfo)
      {
        QMLog.e("GameGrowthGuardianManager", "enableHeartBeatForLaunchScene", paramMiniAppInfo);
        return false;
      }
      continue;
      label260:
      int i = 9999;
      continue;
      label267:
      boolean bool1 = true;
      label270:
      return bool1;
      label273:
      j += 1;
      continue;
      label280:
      i += 1;
    }
  }
  
  private static void execute(Context paramContext, MiniAppInfo paramMiniAppInfo, @GameGrowthGuardianManager.JudgeTimingRequestFactType int paramInt)
  {
    if ((paramContext == null) || (paramMiniAppInfo == null)) {}
    do
    {
      return;
      if ((!isForeground) && ((paramInt == 11) || (paramInt == 12)))
      {
        QMLog.e("GameGrowthGuardianManager", "not in foreground, not allowed to send begin or heartbeat protocol");
        return;
      }
    } while (!enableHeartBeatCheck(paramMiniAppInfo));
    String str2 = MiniProgramReportHelper.launchIdForMiniAppConfig(paramMiniAppInfo);
    String str1;
    int i;
    label70:
    int j;
    label86:
    int k;
    label95:
    ChannelProxy localChannelProxy;
    long l;
    if (paramMiniAppInfo.appId != null)
    {
      str1 = paramMiniAppInfo.appId;
      if (!paramMiniAppInfo.isEngineTypeMiniGame()) {
        break label185;
      }
      i = 1;
      if (paramMiniAppInfo.launchParam == null) {
        break label190;
      }
      j = paramMiniAppInfo.launchParam.scene;
      if (paramInt != 11) {
        break label196;
      }
      k = 0;
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (str2 == null) {
        break label215;
      }
      label121:
      if (paramMiniAppInfo.via == null) {
        break label222;
      }
    }
    label185:
    label190:
    label196:
    label215:
    label222:
    for (String str3 = paramMiniAppInfo.via;; str3 = "")
    {
      localChannelProxy.JudgeTiming(str1, i, j, paramInt, l, k, str2, 0, str3, paramMiniAppInfo.gameAdsTotalTime, previousExtInfo, paramMiniAppInfo.customInfo, new GameGrowthGuardianManager.2(paramMiniAppInfo, paramContext, paramInt));
      return;
      str1 = "";
      break;
      i = 0;
      break label70;
      j = 0;
      break label86;
      k = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - beginExecuteMillis);
      break label95;
      str2 = "";
      break label121;
    }
  }
  
  public static void executeBegin(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    isForeground = true;
    ThreadManager.getUIHandler().postDelayed(new GameGrowthGuardianManager.1(paramMiniAppInfo, paramContext), JUDGE_TIMING_REQUEST_BEGIN_DELAY);
  }
  
  public static void executeEnd(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    isForeground = false;
    execute(paramContext, paramMiniAppInfo, 13);
    if (heartBeatRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(heartBeatRunnable);
      heartBeatRunnable = null;
    }
    if (sOnStopCallback != null) {
      sOnStopCallback.onStop();
    }
  }
  
  public static void registerActivityOnStopCallback(OnStopCallback paramOnStopCallback)
  {
    sOnStopCallback = paramOnStopCallback;
  }
  
  private static void reportInstructionExecuteResult(MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, INTERFACE.GuardInstruction paramGuardInstruction)
  {
    if ((paramMiniAppInfo == null) || (paramStJudgeTimingRsp == null)) {
      return;
    }
    ChannelProxy localChannelProxy;
    String str;
    int i;
    if ((paramGuardInstruction != null) && (paramGuardInstruction.type.get() == 7))
    {
      paramStJudgeTimingRsp = paramStJudgeTimingRsp.loginTraceId.get();
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      str = paramMiniAppInfo.appId;
      i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (paramGuardInstruction == null) {
        break label103;
      }
    }
    label103:
    for (paramMiniAppInfo = paramGuardInstruction.ruleName.get();; paramMiniAppInfo = "")
    {
      localChannelProxy.ReportExecute(str, i, paramStJudgeTimingRsp, paramMiniAppInfo, new GameGrowthGuardianManager.3());
      return;
      paramStJudgeTimingRsp = paramStJudgeTimingRsp.timingTraceId.get();
      break;
    }
  }
  
  private static INTERFACE.StJudgeTimingRsp testForIncomeTips()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(6);
    localGuardInstruction.ruleName.set("INCOME_TIPS");
    localGuardInstruction.title.set("Test Income Tips dialog title");
    localGuardInstruction.msg.set("Test Income dialog message");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.nextDuration.set(30);
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForLogoutDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(2);
    localGuardInstruction.title.set("Logout dialog title");
    localGuardInstruction.msg.set("Logout dialog message");
    localGuardInstruction.ruleName.set("LOGOUT");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(60);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForMultipleInstructions()
  {
    INTERFACE.GuardInstruction localGuardInstruction1 = new INTERFACE.GuardInstruction();
    localGuardInstruction1.type.set(1);
    localGuardInstruction1.title.set("First instruction dialog title");
    localGuardInstruction1.msg.set("First instruction dialog message");
    localGuardInstruction1.ruleName.set("FIRST");
    INTERFACE.GuardInstruction localGuardInstruction2 = new INTERFACE.GuardInstruction();
    localGuardInstruction2.type.set(3);
    localGuardInstruction2.title.set("Second instruction dialog title");
    localGuardInstruction2.msg.set("Second instruction dialog message");
    localGuardInstruction2.url.set("https://www.qq.com");
    localGuardInstruction2.ruleName.set("SECOND");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(30);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction1);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction2);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForOpenUrlDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(3);
    localGuardInstruction.title.set("Test OpenUrl dialog title");
    localGuardInstruction.msg.set("Test OpenUrl dialog message");
    localGuardInstruction.url.set("https://www.qq.com");
    localGuardInstruction.ruleName.set("OPENURL");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(180);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForRealNameAuthentication()
  {
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    Object localObject = new INTERFACE.GuardInstruction();
    ((INTERFACE.GuardInstruction)localObject).type.set(7);
    ((INTERFACE.GuardInstruction)localObject).title.set("Real name dialog title");
    ((INTERFACE.GuardInstruction)localObject).msg.set("Real name dialog message");
    ((INTERFACE.GuardInstruction)localObject).url.set("https://www.qq.com");
    ((INTERFACE.GuardInstruction)localObject).ruleName.set("REALNAME");
    localStJudgeTimingRsp.loginInstructions.add((MessageMicro)localObject);
    localStJudgeTimingRsp.loginTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(120);
    if ((localStJudgeTimingRsp != null) && (!localStJudgeTimingRsp.loginInstructions.isEmpty()))
    {
      localObject = localStJudgeTimingRsp.loginInstructions.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((INTERFACE.GuardInstruction)((Iterator)localObject).next()).type.set(7);
      }
      localStJudgeTimingRsp.timingInstructions.get().addAll(0, localStJudgeTimingRsp.loginInstructions.get());
    }
    return localStJudgeTimingRsp;
  }
  
  private static INTERFACE.StJudgeTimingRsp testForTipsDialog()
  {
    INTERFACE.GuardInstruction localGuardInstruction = new INTERFACE.GuardInstruction();
    localGuardInstruction.type.set(1);
    localGuardInstruction.title.set("Tips dialog title");
    localGuardInstruction.msg.set("Tips dialog message");
    localGuardInstruction.ruleName.set("TIPS");
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    localStJudgeTimingRsp.timingTraceId.set(UUID.randomUUID().toString());
    localStJudgeTimingRsp.nextDuration.set(120);
    localStJudgeTimingRsp.timingInstructions.add(localGuardInstruction);
    return localStJudgeTimingRsp;
  }
  
  public static void unregisterActivityOnStopCallback()
  {
    sOnStopCallback = null;
  }
  
  static class DialogAction
  {
    private final DialogInterface.OnClickListener onClickListener;
    private final int stringResId;
    
    DialogAction(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.stringResId = paramInt;
      this.onClickListener = paramOnClickListener;
    }
    
    public DialogInterface.OnClickListener getOnClickListener()
    {
      return this.onClickListener;
    }
    
    int getStringResId()
    {
      return this.stringResId;
    }
  }
  
  static abstract class GuardInstructionDialog
  {
    private final Context context;
    private final INTERFACE.GuardInstruction guardInstruction;
    private INTERFACE.StJudgeTimingRsp judgeTimingRsp;
    private final MiniAppInfo miniAppInfo;
    private DialogInterface.OnDismissListener onDismissListener;
    
    GuardInstructionDialog(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      this.guardInstruction = paramGuardInstruction;
      this.context = paramContext;
      this.miniAppInfo = paramMiniAppInfo;
    }
    
    static void tryBuildAndShow(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt)
    {
      if ((paramContext == null) || (paramStJudgeTimingRsp == null) || (paramStJudgeTimingRsp.timingInstructions.isEmpty())) {}
      for (;;)
      {
        return;
        try
        {
          if (paramInt >= paramStJudgeTimingRsp.timingInstructions.size()) {
            continue;
          }
          Object localObject1 = (INTERFACE.GuardInstruction)paramStJudgeTimingRsp.timingInstructions.get(paramInt);
          if (localObject1 == null) {
            continue;
          }
          if (((INTERFACE.GuardInstruction)localObject1).type.get() == 1)
          {
            localObject1 = new GameGrowthGuardianManager.GuardInstructionDialogTips((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppInfo);
            if (localObject1 == null) {
              continue;
            }
            ((GuardInstructionDialog)localObject1).setJudgeTimingRsp(paramStJudgeTimingRsp);
            ((GuardInstructionDialog)localObject1).setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.1(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
            ((GuardInstructionDialog)localObject1).buildAndShow();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.e("GameGrowthGuardianManager", "tryBuildAndShow", localException);
            Object localObject2 = null;
            continue;
            if (((INTERFACE.GuardInstruction)localObject2).type.get() == 2)
            {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogLogout((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            }
            else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
            {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            }
            else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
            {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogIncomeTips((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            }
            else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
            {
              QMLog.d("GameGrowthGuardianManager", "tryBuildAndShow() called with: modal = " + ((INTERFACE.GuardInstruction)localObject2).modal.get());
              if (((INTERFACE.GuardInstruction)localObject2).modal.get() == 0) {
                localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
              } else {
                localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
              }
            }
            else
            {
              QMLog.w("GameGrowthGuardianManager", "tryBuildAndShow not create and show dialog for " + ((INTERFACE.GuardInstruction)localObject2).type.get());
              tryBuildAndShow(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt + 1);
              localObject2 = null;
            }
          }
        }
      }
    }
    
    void buildAndShow()
    {
      if ((getContext() == null) || (getGuardInstruction() == null)) {
        return;
      }
      MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(getContext(), 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().msg.get());
      if (getPositiveDialogAction() != null) {
        localMiniCustomDialog.setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
      }
      if (getNegativeDialogAction() != null) {
        localMiniCustomDialog.setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
      }
      localMiniCustomDialog.setOnShowListener(new GameGrowthGuardianManager.GuardInstructionDialog.3(this, new GameGrowthGuardianManager.GuardInstructionDialog.2(this)));
      localMiniCustomDialog.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.4(this));
      localMiniCustomDialog.setCancelable(false);
      localMiniCustomDialog.show();
    }
    
    public Context getContext()
    {
      return this.context;
    }
    
    INTERFACE.GuardInstruction getGuardInstruction()
    {
      return this.guardInstruction;
    }
    
    public MiniAppInfo getMiniAppInfo()
    {
      return this.miniAppInfo;
    }
    
    protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
    {
      return null;
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return null;
    }
    
    String getReportActionType()
    {
      return "sys_alert";
    }
    
    protected String getReportSubActionType()
    {
      return null;
    }
    
    protected void onBackgroundForReport()
    {
      QMLog.d("GameGrowthGuardianManager", "onBackgroundForReport() called");
      performReport("hide");
    }
    
    protected void onDismissForReport(DialogInterface paramDialogInterface) {}
    
    protected void onShowForReport(DialogInterface paramDialogInterface) {}
    
    protected void performReport(String paramString)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      if (getGuardInstruction() != null)
      {
        str1 = getGuardInstruction().ruleName.get();
        str2 = String.valueOf(getGuardInstruction().type.get());
        str3 = String.valueOf(getGuardInstruction().modal.get());
        str4 = getGuardInstruction().msg.get();
      }
      for (;;)
      {
        if (this.judgeTimingRsp != null) {}
        for (String str5 = String.valueOf(this.judgeTimingRsp.nextDuration.get());; str5 = null)
        {
          if (getMiniAppInfo() != null) {}
          for (String str6 = SDKMiniProgramLpReportDC04239.getAppType(getMiniAppInfo());; str6 = null)
          {
            SDKMiniProgramLpReportDC04239.report(getMiniAppInfo(), str6, null, getReportActionType(), getReportSubActionType(), paramString, str1, str2, str3, str4, str5);
            QMLog.d("GameGrowthGuardianManager", "performReport called with action = " + getReportActionType() + ",subaction = " + getReportSubActionType() + ",reserves = " + paramString + ",reverses2 = " + str1 + ",reverses3 = " + str2 + ",reverses4 = " + str3 + ",reverses5 = " + str4 + ",reserves6 = " + str5);
            return;
          }
        }
        str4 = null;
        str3 = null;
        str2 = null;
        str1 = null;
      }
    }
    
    public void setJudgeTimingRsp(INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
    {
      this.judgeTimingRsp = paramStJudgeTimingRsp;
    }
    
    public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.onDismissListener = paramOnDismissListener;
    }
  }
  
  static class GuardInstructionDialogIncomeTips
    extends GameGrowthGuardianManager.GuardInstructionDialog
  {
    GuardInstructionDialogIncomeTips(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new GameGrowthGuardianManager.GuardInstructionDialogIncomeTips.1(this));
    }
  }
  
  static class GuardInstructionDialogLogout
    extends GameGrowthGuardianManager.GuardInstructionDialog
  {
    GuardInstructionDialogLogout(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new GameGrowthGuardianManager.GuardInstructionDialogLogout.1(this));
    }
    
    protected String getReportSubActionType()
    {
      return "loginout";
    }
    
    protected void onShowForReport(DialogInterface paramDialogInterface)
    {
      performReport("expo");
    }
  }
  
  static class GuardInstructionDialogOpenUrl
    extends GameGrowthGuardianManager.GuardInstructionDialog
  {
    GuardInstructionDialogOpenUrl(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_cancel, new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.2(this));
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_lite_open, new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.1(this));
    }
  }
  
  static class GuardInstructionDialogRealNameAuthenticate
    extends GameGrowthGuardianManager.GuardInstructionDialog
  {
    GuardInstructionDialogRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_exit_game, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1(this));
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_qb_tenpay_tenpay_shiming_title, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2(this));
    }
    
    protected String getReportSubActionType()
    {
      return "off_idAlert";
    }
    
    protected void onShowForReport(DialogInterface paramDialogInterface)
    {
      performReport("expo");
    }
  }
  
  static class GuardInstructionDialogSkippedRealNameAuthenticate
    extends GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
  {
    GuardInstructionDialogSkippedRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_pretty_number_cancel, new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate.1(this));
    }
    
    protected String getReportSubActionType()
    {
      return "skip_idAlert";
    }
  }
  
  static class GuardInstructionDialogTips
    extends GameGrowthGuardianManager.GuardInstructionDialog
  {
    GuardInstructionDialogTips(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
    {
      super(paramContext, paramMiniAppInfo);
    }
    
    protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
    {
      return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new GameGrowthGuardianManager.GuardInstructionDialogTips.1(this));
    }
    
    protected String getReportSubActionType()
    {
      return "timeAlert";
    }
    
    protected void onShowForReport(DialogInterface paramDialogInterface)
    {
      performReport("expo");
    }
  }
  
  static abstract interface OnStopCallback
  {
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager
 * JD-Core Version:    0.7.0.1
 */