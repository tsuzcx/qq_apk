package com.tencent.qqmail.card.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import com.tencent.qqmail.card.fragment.ShareLinkToExternal.SharedType;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CardUtil
{
  private static final String CARD_BIRTHDAY_CAKE_RED_DOT = "card_birthday_cake_red_dot";
  private static final String CARD_BIRTHDAY_REDDOT_CLICK_TIME = "birthday_red_dot_click";
  private static final String CARD_DEFAULT_NAME = "card_default_name";
  private static final String CARD_GET_BIRTHDAY_FRIEND_TIME = "get_birthday_friend_time";
  private static final String CARD_PREFERENCE = "card_info";
  public static final String PLAY_BTN_DISPLAY_INLINE = ".greetingCard_playBtn {display: inline !important;}";
  public static final String PLAY_BTN_DISPLAY_NONE = ".greetingCard_playBtn {display: none !important;}";
  public static final String PREVIEW_BTN_DISPLAY_INLINE = ".greetingCard_previewBtn {display: inline !important;}";
  public static final String PREVIEW_BTN_DISPLAY_NONE = ".greetingCard_previewBtn {display: none !important;}";
  private static final long PROTECT_INTERNAL = 604800000L;
  public static final String PROTOCOL = "http:";
  public static final String SEND_CARD_URL = "//i.mail.qq.com/cgi-bin/uma_compose_card";
  private static final String TAG = "CardUtil";
  public static final String THANKS_BTN_DISPLAY_INLINE = ".greetingCard_thanksBtn {display: inline !important;}";
  public static final String THANKS_BTN_DISPLAY_NONE = ".greetingCard_thanksBtn {display: none !important;}";
  public static final String THANK_EMALI_FLAG = "&email=1";
  public static final String THANK_URL = "//i.mail.qq.com/cgi-bin/uma_ack_card?";
  public static final String THANK_URLARGS = "cardid=%s";
  public static final String WEIXIN_WRAPPER = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx418ef619e2bf54e6&response_type=code&scope=snsapi_base&state=123&redirect_uri=%s";
  private static final String[] days = { "今天", "明天", "后天", "三天后", "四天后", "五天后", "六天后" };
  
  public static HashMap<Integer, String> allReplaceIntem()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(2131691304), "");
    localHashMap.put(Integer.valueOf(2131691305), "");
    localHashMap.put(Integer.valueOf(2131691306), "");
    localHashMap.put(Integer.valueOf(2131691307), "");
    localHashMap.put(Integer.valueOf(2131691308), "");
    localHashMap.put(Integer.valueOf(2131691309), "");
    localHashMap.put(Integer.valueOf(2131691310), "");
    localHashMap.put(Integer.valueOf(2131691311), "");
    localHashMap.put(Integer.valueOf(2131691312), "");
    localHashMap.put(Integer.valueOf(2131691313), "");
    return localHashMap;
  }
  
  public static void clearSyncBirthdayFriendTime()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).edit().putLong("get_birthday_friend_time", 0L).commit();
  }
  
  public static int daysBetween(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    int i = 0;
    while (localCalendar1.before(localCalendar2))
    {
      localCalendar1.add(5, 1);
      i += 1;
    }
    return i;
  }
  
  public static boolean getBirthdayCakeRedDot()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).getBoolean("card_birthday_cake_red_dot", false);
  }
  
  public static String getBirthdayTipByTime(long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramLong = 1000L * paramLong;
    int i = daysBetween(l, paramLong);
    if ((i >= 0) && (i < 7)) {
      localStringBuilder.append(days[i]);
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    if (paramBoolean)
    {
      localObject = QMLunarCalendarUtils.getLunarDate(paramLong, false);
      localStringBuilder.append("(").append(QMApplicationContext.sharedInstance().getString(2131691277)).append(((String)localObject).toString()).append(")");
    }
    for (;;)
    {
      localStringBuilder.append(QMApplicationContext.sharedInstance().getString(2131691292));
      return localStringBuilder.toString();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(QMApplicationContext.sharedInstance().getString(2131691276));
      localStringBuilder.append("(").append(localSimpleDateFormat.format(((Calendar)localObject).getTime())).append(")");
    }
  }
  
  public static String getDefaultSendName()
  {
    Object localObject2 = QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).getString("card_default_name", "");
    Object localObject1 = localObject2;
    Account localAccount;
    if (StringExtention.isNullOrEmpty((String)localObject2))
    {
      localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
      localObject1 = localObject2;
      if (localAccount != null)
      {
        if (localAccount.isQQMail()) {
          break label113;
        }
        localObject2 = QMSettingManager.sharedInstance().getAccountNick(localAccount.getId());
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals("")) {}
        }
        else
        {
          QMPrivateProtocolManager.sharedInstance().syncAccountNick(localAccount.getEmail());
          localObject1 = "";
        }
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 32)) {
      localObject2 = ((String)localObject1).substring(0, 32);
    }
    label113:
    do
    {
      return localObject2;
      localObject1 = localObject2;
      if (!localAccount.isQQMail()) {
        break;
      }
      localObject1 = QMComposeDataManager.sharedInstance().getQMDefaultAlias(localAccount.getId());
      localObject2 = QMComposeDataManager.sharedInstance().getQMAliasNick((String)localObject1, localAccount.getId());
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {
          break;
        }
      }
      localObject1 = QMComposeDataManager.sharedInstance().getQMDefaultNick(localAccount.getId());
      break;
      localObject2 = localObject1;
    } while (localObject1 != null);
    return "";
  }
  
  public static String getFromPlatform(ShareLinkToExternal.SharedType paramSharedType)
  {
    switch (CardUtil.3.$SwitchMap$com$tencent$qqmail$card$fragment$ShareLinkToExternal$SharedType[paramSharedType.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("arg: " + paramSharedType);
    case 1: 
      return "&fromPlatform=2";
    case 2: 
    case 3: 
      return "&fromPlatform=1";
    }
    return "&fromPlatform=3";
  }
  
  public static long getTodayZeroSec()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public static boolean hasTodayGotBirthFriend()
  {
    Calendar localCalendar = Calendar.getInstance();
    long l = QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).getLong("get_birthday_friend_time", 0L);
    if (l == 0L) {}
    int i;
    int j;
    do
    {
      return false;
      localCalendar.setTime(new Date(l));
      i = localCalendar.get(7);
      localCalendar.setTime(new Date(System.currentTimeMillis()));
      j = localCalendar.get(7);
      QMLog.log(4, "CardUtil", "lastUpdateTime:" + l + ",now:" + System.currentTimeMillis());
    } while (i != j);
    return true;
  }
  
  public static boolean isContentCorrect(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((paramString.indexOf("<html data=\"qqmailCard\">") == -1) || (paramString.indexOf("</html>") == -1));
    Log.v("CardUtil", "check content correct:" + (System.currentTimeMillis() - l));
    return true;
  }
  
  public static String replaceContentInSequence(String paramString, Map<Integer, String> paramMap)
  {
    int[] arrayOfInt = new int[17];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131691305;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131691313;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131691306;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131691312;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131691307;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131691304;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131691310;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131691311;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131691309;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131691308;
    int[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 2131691306;
    int[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 2131691312;
    int[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 2131691304;
    int[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 2131691310;
    int[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 2131691311;
    int[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 2131691309;
    int[] tmp96_90 = tmp90_84;
    tmp96_90[16] = 2131691308;
    tmp96_90;
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      String str = (String)paramMap.get(Integer.valueOf(arrayOfInt[i]));
      if (str != null)
      {
        localArrayList1.add(localQMApplicationContext.getString(arrayOfInt[i]));
        localArrayList2.add(str);
      }
      i += 1;
    }
    return replaceContentInSequence(paramString, (String[])localArrayList1.toArray(new String[0]), (String[])localArrayList2.toArray(new String[0]));
  }
  
  private static String replaceContentInSequence(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    if (paramArrayOfString1.length != paramArrayOfString2.length) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = 0;
    int k = 0;
    if (i < paramArrayOfString1.length)
    {
      int n = paramString.indexOf(paramArrayOfString1[i], k);
      int m = j;
      if (n >= 0) {
        if (paramArrayOfString2[i] != null) {
          break label129;
        }
      }
      label129:
      for (String str = "";; str = paramArrayOfString2[i])
      {
        k = paramArrayOfString1[i].length();
        localStringBuilder.append(paramString, j, n).append(str);
        m = n + k;
        k = m;
        i += 1;
        j = m;
        break;
      }
    }
    if (j < paramString.length()) {
      localStringBuilder.append(paramString, j, paramString.length());
    }
    return localStringBuilder.toString();
  }
  
  public static String replaceContentInSequenceStringToString(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    if (paramArrayOfString1.length != paramArrayOfString2.length) {
      return "";
    }
    char[] arrayOfChar2 = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfChar2.length);
    int j = 0;
    int k = 0;
    int i = 0;
    char[] arrayOfChar1;
    if (j < paramArrayOfString1.length)
    {
      i = paramString.indexOf(paramArrayOfString1[j], i);
      if (i < 0) {
        break label165;
      }
      if (paramArrayOfString2[j] == null)
      {
        arrayOfChar1 = new char[0];
        label85:
        int m = paramArrayOfString1[j].length();
        localStringBuilder.append(arrayOfChar2, k, i - k).append(arrayOfChar1);
        k = i + m;
        i = k;
      }
    }
    label165:
    for (;;)
    {
      j += 1;
      break;
      arrayOfChar1 = paramArrayOfString2[j].toCharArray();
      break label85;
      localStringBuilder.append(arrayOfChar2, k, arrayOfChar2.length - k);
      return localStringBuilder.toString();
    }
  }
  
  public static void setBirthdayCakeRedDot(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).edit().putBoolean("card_birthday_cake_red_dot", paramBoolean).commit();
    QMLog.log(4, "CardUtil", "set birthday cake red dot:" + paramBoolean);
  }
  
  public static void setBirthdayRedDotClick(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).edit().putLong("birthday_red_dot_click", paramLong).commit();
  }
  
  public static void setDefaultSendName(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).edit().putString("card_default_name", paramString).commit();
    QMLog.log(4, "CardUtil", "save card default name:" + paramString);
  }
  
  public static void setSyncBirthdayFriendTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).edit().putLong("get_birthday_friend_time", System.currentTimeMillis()).commit();
  }
  
  public static boolean shouldShowBirthdayRedDot()
  {
    if (!QMSettingManager.sharedInstance().getCardBirthdayRemind()) {}
    long l;
    do
    {
      return false;
      l = QMApplicationContext.sharedInstance().getSharedPreferences("card_info", 0).getLong("birthday_red_dot_click", 0L);
    } while (System.currentTimeMillis() - l <= 604800000L);
    return true;
  }
  
  public static boolean thank(String paramString, int paramInt)
  {
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())) {
      return false;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    Object localObject = paramString;
    if ((localAccount instanceof QQMailAccount)) {
      localObject = paramString + "&uin=" + ((QQMailAccount)localAccount).getUin();
    }
    paramString = new CGIRequest(paramInt, (String)localObject);
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnSuccess(new CardUtil.1());
    ((QMCallback)localObject).setOnError(new CardUtil.2());
    paramString.setRequestCallback((QMCallback)localObject);
    QMHttpUtil.asyncSend(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.util.CardUtil
 * JD-Core Version:    0.7.0.1
 */