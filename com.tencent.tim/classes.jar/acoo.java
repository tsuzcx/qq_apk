import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.InitBeforeSyncMsg;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.app.automator.ReportDevice;
import com.tencent.mobileqq.app.automator.TimerChecker;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.ActivityDAUReport;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.app.automator.step.AppNewsAlert;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.automator.step.CheckAuthCode;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.app.automator.step.CheckHotSpotNode;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.CheckQZoneOatFile;
import com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.CloudFileAsyncStep;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetDiscussionInfo;
import com.tencent.mobileqq.app.automator.step.GetDonateFriends;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile;
import com.tencent.mobileqq.app.automator.step.GetFunCallData;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.app.automator.step.GetNumRedStep;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck;
import com.tencent.mobileqq.app.automator.step.GetRecommendEmotionStep;
import com.tencent.mobileqq.app.automator.step.GetRedpointStep;
import com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSelfPendantId;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.app.automator.step.GetTroopConfig;
import com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep;
import com.tencent.mobileqq.app.automator.step.GetWebViewAuthorize;
import com.tencent.mobileqq.app.automator.step.LimitChatSettingStep;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.MonitorSocketDownload;
import com.tencent.mobileqq.app.automator.step.NotifyQZoneServer;
import com.tencent.mobileqq.app.automator.step.PPCLoginAuth;
import com.tencent.mobileqq.app.automator.step.QAVStep;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.app.automator.step.QQUpdateVersion;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.ReportClientInfo;
import com.tencent.mobileqq.app.automator.step.ReportLoginInfo;
import com.tencent.mobileqq.app.automator.step.SendThemeAuth;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartQSecLogic;
import com.tencent.mobileqq.app.automator.step.StartSecurityScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityUpdate;
import com.tencent.mobileqq.app.automator.step.StartSmartDevice;
import com.tencent.mobileqq.app.automator.step.StartTxVerifyApk;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.VipRequestMessageRoamPassword;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;
import com.tencent.mobileqq.app.automator.step.getLocalRedtouchStep;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import com.tencent.tim.mail.MailPluginPreload;
import java.util.HashSet;
import java.util.Set;

public class acoo
{
  public static Set<Integer> bV;
  public static final String[] ek;
  public static final int[] ko = { 6, 12, 24, 168 };
  
  static
  {
    ek = new String[] { "{,102}", "{95}", "{57,65,36,53,67,69,63,77,76,84}", "{}" };
    bV = new HashSet();
    bV.add(Integer.valueOf(86));
    bV.add(Integer.valueOf(4));
    bV.add(Integer.valueOf(3));
    bV.add(Integer.valueOf(5));
    bV.add(Integer.valueOf(6));
    bV.add(Integer.valueOf(11));
    bV.add(Integer.valueOf(12));
    bV.add(Integer.valueOf(14));
    bV.add(Integer.valueOf(17));
    bV.add(Integer.valueOf(20));
    bV.add(Integer.valueOf(21));
    bV.add(Integer.valueOf(60));
    bV.add(Integer.valueOf(61));
  }
  
  public static int a(LinearGroup paramLinearGroup, boolean paramBoolean)
  {
    if ("{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(paramLinearGroup.mName)) {
      if (paramLinearGroup.mIndex <= 4) {}
    }
    while (paramBoolean)
    {
      return 1;
      return 0;
    }
    return 0;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i = -1;
    if (str.startsWith("{"))
    {
      paramString = new LinearGroup();
      paramString.mPattern = str;
    }
    for (;;)
    {
      paramString.a = paramAutomator;
      paramString.cyx = i;
      if (i < 0) {
        break;
      }
      paramString.mName = paramString.getClass().getSimpleName();
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.mPattern = str;
      }
      else
      {
        i = Integer.parseInt(str);
        switch (i)
        {
        case 50: 
        case 52: 
        case 63: 
        case 80: 
        case 83: 
        case 107: 
        default: 
          paramString = new AsyncStep();
          break;
        case 2: 
          paramString = new ActiveAccount();
          break;
        case 3: 
        case 7: 
        case 8: 
          paramString = new UpdateFriend();
          break;
        case 4: 
        case 9: 
          paramString = new UpdateTroop();
          break;
        case 5: 
          paramString = new UpdateDiscuss();
          break;
        case 6: 
        case 10: 
          paramString = new CheckPublicAccount();
          break;
        case 12: 
        case 13: 
          paramString = new RegisterPush();
          break;
        case 17: 
        case 18: 
        case 19: 
          paramString = new RegisterProxy();
          break;
        case 20: 
          paramString = new GetGeneralSettings();
          break;
        case 21: 
          paramString = new GetTroopAssisMsg();
          break;
        case 14: 
        case 15: 
        case 16: 
          paramString = new InitBeforeSyncMsg();
          break;
        case 11: 
          paramString = new GetSubAccount();
          break;
        case 22: 
        case 23: 
        case 24: 
          paramString = new AfterSyncMsg();
          break;
        case 26: 
          paramString = new GetEmoticonWhenNoFile();
          break;
        case 25: 
          paramString = new QAVStep();
          break;
        case 27: 
          paramString = new GetSelfPendantId();
          break;
        case 28: 
          paramString = new StartSecurityScan();
          break;
        case 29: 
          paramString = new GetEmosmList();
          break;
        case 30: 
          paramString = new GetSelfInfo();
          break;
        case 31: 
          paramString = new EcShopFirstRunMsgConfigs();
          break;
        case 32: 
          paramString = new GetSecMsgConfigs();
          break;
        case 33: 
          paramString = new GetSecMsgNewSeq();
          break;
        case 34: 
          paramString = new CheckFriendsLastLoginInfo();
          break;
        case 35: 
          paramString = new GetSig();
          break;
        case 36: 
          paramString = new StartSecurityUpdate();
          break;
        case 39: 
          paramString = new GetWebViewAuthorize();
          break;
        case 40: 
          paramString = new GetDiscussionInfo();
          break;
        case 41: 
          paramString = new SetLogOn();
          break;
        case 42: 
          paramString = new GetQZoneFeedCount();
          break;
        case 43: 
          paramString = new CheckQZoneOatFile();
          break;
        case 44: 
          paramString = new GetConfig();
          break;
        case 46: 
        case 47: 
          paramString = new GetCheckUpdate();
          break;
        case 48: 
          paramString = new GetSplashConfig();
          break;
        case 73: 
          paramString = new GetFunCallData();
          break;
        case 49: 
          paramString = new SendThemeAuth();
          break;
        case 51: 
          paramString = new GetTbsSwitchInfo();
          break;
        case 92: 
          paramString = new CheckAuthCode();
          break;
        case 53: 
          paramString = new CleanCache();
          break;
        case 54: 
          paramString = new CheckMsgCount();
          break;
        case 76: 
          paramString = new TimerCheckMsgCount();
          break;
        case 56: 
          paramString = new GetClubContentUpdateStatus();
          break;
        case 108: 
          paramString = new GetApolloContentUpdateStatus();
          break;
        case 57: 
          paramString = new VideoConfigUpdate();
          break;
        case 58: 
          paramString = new TimerChecker();
          break;
        case 106: 
          paramString = new AutomatorFinish();
          break;
        case 55: 
          paramString = new SignatureScan();
          break;
        case 59: 
        case 60: 
          paramString = new GetJoinedHotChatListStep();
          break;
        case 61: 
          paramString = new GetJoinedHotChatListMessageStep();
          break;
        case 62: 
          paramString = new GetTroopRedPointInfoStep();
          break;
        case 66: 
          paramString = new UpdateIcon();
          break;
        case 64: 
          paramString = new VipCheckGift();
          break;
        case 65: 
          paramString = new VipRequestMessageRoamPassword();
          break;
        case 67: 
          paramString = new ReportDevice();
          break;
        case 68: 
          paramString = new StartSmartDevice();
          break;
        case 69: 
          paramString = new WeiyunCheckAlbum();
          break;
        case 70: 
          paramString = new ChatBackgroundAuth();
          break;
        case 71: 
          paramString = new GetRecommendEmotionStep();
          break;
        case 74: 
          paramString = new PPCLoginAuth();
          break;
        case 72: 
          paramString = new GetNumRedStep();
          break;
        case 75: 
          paramString = new QQUpdateVersion();
          break;
        case 77: 
          paramString = new MonitorSocketDownload();
          break;
        case 78: 
          paramString = new GetQZoneFeeds();
          break;
        case 79: 
          paramString = new GetBigEmoticonStep();
          break;
        case 81: 
          paramString = new StepServiceAsync();
          break;
        case 82: 
          paramString = new GetQZonePhotoGuideCheck();
          break;
        case 84: 
          paramString = new ActivityDAUReport();
          break;
        case 85: 
          paramString = new CheckHotSpotNode();
          break;
        case 86: 
          paramString = new LoginWelcomeRequest();
          break;
        case 87: 
          paramString = new QQComicStep();
          break;
        case 88: 
          paramString = new GetDonateFriends();
          break;
        case 89: 
        case 90: 
          paramString = new GetRedpointStep();
          break;
        case 91: 
          paramString = new ReadInJoyDAUReport();
          break;
        case 93: 
          paramString = new getLocalRedtouchStep();
          break;
        case 94: 
          paramString = new GetCommonUsedSystemEmojiStep();
          break;
        case 95: 
          paramString = new DailyReport();
          break;
        case 96: 
        case 97: 
          paramString = new GetSubAccountSpecialCare();
          break;
        case 100: 
          paramString = new NotifyQZoneServer();
          break;
        case 37: 
          paramString = new ReportClientInfo();
          break;
        case 38: 
          paramString = new StartTxVerifyApk();
          break;
        case 98: 
        case 99: 
          paramString = new CheckSafeCenterConfig();
          break;
        case 101: 
          paramString = new GameCenterCheck();
          break;
        case 102: 
          paramString = new AppNewsAlert();
          break;
        case 103: 
          paramString = new StartQSecLogic();
          break;
        case 104: 
          paramString = new GetTroopConfig();
          break;
        case 105: 
          paramString = new TroopEnterEffectsStep();
          break;
        case 109: 
          paramString = new MiniMsgTabServerInitStep();
          break;
        case 110: 
          paramString = new QQReminderStepAsync();
          break;
        case 111: 
          paramString = new ReportLoginInfo();
          break;
        case 112: 
          paramString = new CameraCategoryMaterialStep();
          break;
        case 113: 
          paramString = new LimitChatSettingStep();
          break;
        case 114: 
          paramString = new DtSdkInitStep();
          break;
        case 115: 
          paramString = new CloudFileAsyncStep();
          break;
        case 45: 
          paramString = new MailPluginPreload();
        }
      }
    }
    paramString.mName = str;
    return paramString;
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    if ("{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(paramLinearGroup.mName)) {
      if (paramLinearGroup.mIndex < 3) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!"{[13,16],19,21,90,23,47,33,62,93,97,98}".equals(paramLinearGroup.mName)) {
          break;
        }
      } while (paramLinearGroup.mIndex >= 1);
      return false;
    } while (("{15,18,21,24}".equals(paramLinearGroup.mName)) || (!"{[11,12,14],17,20,21,22109,}".equals(paramLinearGroup.mName)) || (paramLinearGroup.mIndex >= 2));
    return false;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    return (!"{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(paramLinearGroup.mName)) || (paramLinearGroup.mIndex > 5);
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    if ("{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(paramLinearGroup.mName)) {
      if (paramLinearGroup.mIndex <= 4) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!"{[13,16],19,21,90,23,47,33,62,93,97,98}".equals(paramLinearGroup.mName)) {
            break;
          }
        } while (paramLinearGroup.mIndex > 2);
        return false;
        if (!"{15,18,21,24}".equals(paramLinearGroup.mName)) {
          break;
        }
      } while (paramLinearGroup.mIndex > 2);
      return false;
    } while ((!"{[11,12,14],17,20,21,22109,}".equals(paramLinearGroup.mName)) || (paramLinearGroup.mIndex > 2));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acoo
 * JD-Core Version:    0.7.0.1
 */