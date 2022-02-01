import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.parser.QQstoryAction.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class acvj
  extends acuk
{
  public acvj(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((TextUtils.isEmpty(str1)) || ((TextUtils.isEmpty(paramQQAppInterface)) && (TextUtils.isEmpty(str2))) || (TextUtils.isEmpty(paramHashMap))) {
      return false;
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        ppf.f(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        ppf.b(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i = c(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int k = b(paramHashMap, "ptype", 0);
    int j;
    if ("0".equals(paramHashMap.get("identify")))
    {
      j = 0;
      if (str2 != null) {
        break label773;
      }
      str2 = (String)paramHashMap.get("videoid");
    }
    label773:
    for (;;)
    {
      String str3 = str4;
      if (str4 == null) {
        str3 = (String)paramHashMap.get("fromid");
      }
      if ((!TextUtils.isEmpty(paramString)) && (k == 0)) {
        k = 7;
      }
      for (;;)
      {
        switch (k)
        {
        default: 
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          j = i;
          if (i == 0) {
            j = 7;
          }
          qgg.c(paramActivity, str2, paramQQAppInterface, j);
          return true;
          j = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            rar.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          j = i;
          if (i == 0) {
            j = 7;
          }
          qgg.c(paramActivity, str2, paramQQAppInterface, j);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            rar.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            qgg.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            qgg.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          j = i;
          if (i == 0) {
            j = 30;
          }
          qgg.b(paramActivity, str2, str1, j);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          k = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            k = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            qgg.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), k, i, str1, j, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            qgg.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), k, i, str1, j, null);
          }
          return false;
        case 7: 
          j = i;
          if (i == 0) {
            j = 19;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 6: 
          j = i;
          if (i == 0) {
            j = 57;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 5: 
          qgg.a(paramActivity, str6, str1, j, i, 0, null);
          return true;
        case 8: 
          j = i;
          if (i == 0) {
            j = 90;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 9: 
          b(paramHashMap, "time_zone", -1);
          j = i;
          if (i == 0) {
            j = 96;
          }
          qgg.j(paramActivity, str1, j);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            qgg.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).b());
          }
          return true;
        case 0: 
          return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  private boolean acA()
  {
    if (!TextUtils.isEmpty(jE((String)this.attrs.get("parter_api")))) {
      rar.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.attrs.get("parter_api") });
    }
    if ((this.context instanceof Activity))
    {
      Activity localActivity = (Activity)this.context;
      if ("1".equals((String)this.attrs.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean acv()
  {
    boolean bool = ((Boolean)((psr)psx.a(10)).c("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.attrs.get("token");
    if (!TextUtils.isEmpty(str)) {
      qdy.a(this.context, str, new acvk(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.ctj, "publish"))
      {
        acw();
      }
      else
      {
        if (bool)
        {
          this.ctj = "open";
          qdy.u(this.attrs);
        }
        acw();
      }
    }
  }
  
  private boolean acw()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new QQstoryAction.2(this));
      return false;
    }
    if ((((puz)this.app.getManager(252)).aBT) && (!"open".equals(this.ctj)) && (!"openTag".equals(this.ctj)) && (!"openSquare".equals(this.ctj)) && (!"publish".equals(this.ctj))) {
      return acy();
    }
    String str2 = (String)this.attrs.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      puz localpuz = (puz)this.app.getManager(252);
      str1 = str2;
      if (localpuz != null)
      {
        str1 = str2;
        if (!localpuz.aBT)
        {
          str1 = String.valueOf(0);
          this.attrs.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return acx();
    }
    if ("open".equals(this.ctj)) {
      return acx();
    }
    return acy();
  }
  
  private boolean acx()
  {
    Intent localIntent;
    if (this.app.a().abu)
    {
      ram.d("QQstoryAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.app.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.bIp);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = f(localIntent);
      if ((localIntent != null) && ((this.context instanceof Activity)))
      {
        this.context.startActivity(localIntent);
        return true;
      }
      if (!(this.context instanceof Activity)) {
        ram.e("QQstoryAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.context));
      }
      if (localIntent == null) {
        ram.e("QQstoryAction", "Error: jumpIntent is null");
      }
      return false;
    }
    ram.d("QQstoryAction", "startStoryMainActivity, isNowTabShow==false");
    if (((this.context instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
    {
      localIntent = new Intent(this.app.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.setFlags(335544320);
      localIntent.putExtra("jump_to_story", true);
    }
    for (;;)
    {
      localIntent = f(localIntent);
      if ((localIntent == null) || ((!(this.context instanceof Activity)) && (!(this.context instanceof BaseApplicationImpl)))) {
        break;
      }
      this.context.startActivity(localIntent);
      return true;
      localIntent = v();
    }
  }
  
  private boolean acy()
  {
    if ("open".equals(this.ctj))
    {
      localObject = new Intent(this.context, QQStoryMainActivity.class);
      ((Activity)this.context).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.ctj))
    {
      if ((this.context instanceof Activity)) {
        return a(this.app, (Activity)this.context, this.attrs, null);
      }
      return false;
    }
    if ("opencontent".equals(this.ctj)) {
      return b(this.attrs, false);
    }
    if ("opendiscovery".equals(this.ctj)) {
      return acA();
    }
    if ("opentopic".equals(this.ctj)) {
      return acz();
    }
    if ("infoCard".equals(this.ctj)) {
      return a(this.app, (Activity)this.context, this.attrs);
    }
    if ("sharegroupcard".equals(this.ctj)) {
      return b(this.app, (Activity)this.context, this.attrs);
    }
    Object localObject = new qqr((Activity)this.context, new acvl(this));
    Intent localIntent = f(new Intent());
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((qqr)localObject).b(i, localIntent);
    }
    return false;
  }
  
  private boolean acz()
  {
    Object localObject = (String)this.attrs.get("topicid");
    localObject = (String)this.attrs.get("topicname");
    jE((String)this.attrs.get("sharefromtype"));
    if ((this.context instanceof Activity))
    {
      localObject = (Activity)this.context;
      return true;
    }
    return false;
  }
  
  public static int b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.e("QQstoryAction", 2, "getIntAttribute, NumberFormatException, key:" + paramString + " strVal:" + paramMap);
    }
    return paramInt;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i = -1;
    try
    {
      int j = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
      i = j;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.e("QQstoryAction", 2, "gotoStoryShareGroupCard from id is error:" + paramHashMap);
      }
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i = c(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    b(paramHashMap, "ptype", 0);
    label120:
    int j;
    label139:
    int m;
    label158:
    int k;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label685;
        }
        j = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label691;
        }
        m = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label697;
        }
        k = 0;
        try
        {
          label175:
          if ("17".equals(str1))
          {
            if (j == 0) {
              break label269;
            }
            rar.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (m == 0) {
              break label449;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            j = i;
            if (i == 0) {
              j = 30;
            }
            qgg.b(paramActivity, paramQQAppInterface, str2, j);
            break label683;
            label269:
            rar.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQstoryAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str3 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
          }
          return false;
        }
        j = -1;
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          j = Integer.valueOf(paramQQAppInterface).intValue();
        }
        if (!TextUtils.isEmpty(str4))
        {
          qgg.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), j, i, str2, k, null);
          break label683;
        }
        if (TextUtils.isEmpty(str3)) {
          break label703;
        }
        qgg.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), j, i, str2, k, null);
        break label683;
        label449:
        if ("17".equals(str1))
        {
          if (j != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramQQAppInterface = (String)paramHashMap.get("time_zone");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              Integer.valueOf(paramQQAppInterface).intValue();
            }
            if (!TextUtils.isEmpty(str4))
            {
              qgg.a(paramActivity, str4, str2, k, i, 0, null);
              break label705;
            }
            if (TextUtils.isEmpty(str3)) {
              break label707;
            }
            qgg.a(paramActivity, str3, str2, k, i, 0, null);
            break label705;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            j = i;
            if (i == 0) {
              j = 57;
            }
            qgg.c(paramActivity, paramQQAppInterface, str2, j);
            break label705;
          }
          if (!"onedaylist".equals(str5)) {
            break label709;
          }
          qgg.a(paramActivity, str4, str2, k, i, 0, null);
          break label705;
          label622:
          qgg.c(paramActivity, paramQQAppInterface, str2, j);
          break label705;
        }
        if (TextUtils.isEmpty(paramString)) {
          break label725;
        }
        j = i;
        if (i == 0) {
          j = 19;
        }
        qgg.c(paramActivity, paramQQAppInterface, str2, j);
        break label705;
      }
    }
    for (;;)
    {
      qgg.c(paramActivity, paramQQAppInterface, paramHashMap, j);
      break label705;
      break label120;
      break;
      label683:
      return true;
      label685:
      j = 0;
      break label139;
      label691:
      m = 0;
      break label158;
      label697:
      k = 1;
      break label175;
      label703:
      return false;
      label705:
      return true;
      label707:
      return false;
      label709:
      j = i;
      if (i != 0) {
        break label622;
      }
      j = 17;
      break label622;
      label725:
      paramHashMap = str2;
      if (str2 == null) {
        paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      j = i;
      if (i == 0) {
        j = 7;
      }
    }
  }
  
  private boolean b(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    c(paramMap);
    if (((str5 == null) || (!str5.equals("0"))) || (TextUtils.isEmpty(str4)))
    {
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
        return false;
      }
      try
      {
        int i = Integer.parseInt(str2);
        if (i == 1)
        {
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          ppf.f(this.context, 23, str3);
        }
        for (;;)
        {
          return true;
          if (i != 5) {}
        }
        return true;
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQstoryAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
  }
  
  public static int c(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!QLog.isColorLevel()) {
        break label60;
      }
      QLog.e("QQstoryAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label60:
    return 0;
  }
  
  private Intent f(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.attrs.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      ram.b("QQstoryAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.ctj, Boolean.valueOf(bool));
      ram.b("QQstoryAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.attrs));
      if (!"open".equals(this.ctj)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.attrs.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.attrs.get("lebaVersion"));
      if (bool) {
        rar.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.attrs.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.ctj)) || ("openvideo".equals(this.ctj)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.attrs.get("videoOwnerUin") + "&vid=" + (String)this.attrs.get("videoId");
        rar.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.attrs.get("parter_api"), "", str1 });
      }
      return g(paramIntent);
    }
    String str2;
    String str4;
    String str5;
    if ("opencontent".equals(this.ctj))
    {
      if (bool)
      {
        str1 = (String)this.attrs.get("userid");
        str2 = (String)this.attrs.get("usertype");
        str4 = (String)this.attrs.get("storyid");
        str5 = (String)this.attrs.get("unionid");
        if (!TextUtils.isEmpty(str4)) {
          break label460;
        }
      }
      label460:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        rar.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.attrs.get("parter_api"), "", str1 });
        return j(paramIntent);
      }
    }
    if ("opentopic".equals(this.ctj))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.attrs.get("topicid");
        rar.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.attrs.get("parter_api"), "", str1 });
      }
      return h(paramIntent);
    }
    if ("opendiscovery".equals(this.ctj))
    {
      if (bool) {
        rar.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.attrs.get("parter_api") });
      }
      return i(paramIntent);
    }
    if ("publish".equals(this.ctj))
    {
      if (bool) {
        rar.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.attrs.get("parter_api") });
      }
      paramIntent.putExtra("story_default_label", (String)this.attrs.get("default_label"));
      str1 = (String)this.attrs.get("from_type");
      str2 = (String)this.attrs.get("capture_mode");
      str4 = (String)this.attrs.get("tab_id");
      str5 = (String)this.attrs.get("category_id");
      String str6 = (String)this.attrs.get("item_id");
      String str7 = (String)this.attrs.get("album_id");
      String str8 = (String)this.attrs.get("one_page");
      String str9 = (String)this.attrs.get("dispatch_event");
      paramIntent.putExtra("cameraDirection", 2);
      paramIntent.putExtra("story_game_id", str4);
      paramIntent.putExtra("story_capture_album_id", str7);
      if (!TextUtils.isEmpty(str9)) {
        paramIntent.putExtra("web_dispatch_event", str9);
      }
      try
      {
        if (!TextUtils.isEmpty(str8)) {
          paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str8));
        }
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
        }
        if (!TextUtils.isEmpty(str4)) {
          paramIntent.putExtra("firsttab", Integer.valueOf(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
          paramIntent.putExtra("secondtab", Integer.valueOf(str5));
        }
        paramIntent.putExtra("itemid", str6);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("Q.qqstory.publish.QQstoryAction", 2, "start story publish, NumberFormatException, attrs=" + this.attrs.toString() + "\n" + localNumberFormatException);
        }
      }
      paramIntent.putExtra("from_type", str1);
      paramIntent.putExtra("action", 1);
      return paramIntent;
    }
    String str3;
    if ("infoCard".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("uin");
      str3 = (String)this.attrs.get("usertype");
      str4 = (String)this.attrs.get("fromId");
      str5 = (String)this.attrs.get("unionid");
      if ((TextUtils.isEmpty(str3)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str5))) || (TextUtils.isEmpty(str4))) {
        return null;
      }
      try
      {
        paramIntent.putExtra("union_id", str5);
        paramIntent.putExtra("qq_number", Long.valueOf(str1));
        paramIntent.putExtra("source", Integer.valueOf(str4));
        paramIntent.putExtra("action", 11);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("sharegroupcard".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("unionid");
      str3 = (String)this.attrs.get("fromId");
      str4 = (String)this.attrs.get("fromuid");
      try
      {
        paramIntent.putExtra("union_id", str1);
        paramIntent.putExtra("extra_share_from_uid", str4);
        paramIntent.putExtra("source", Integer.valueOf(str3));
        paramIntent.putExtra("action", 13);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("openTag".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("tag_id");
      str3 = (String)this.attrs.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str3);
      return paramIntent;
    }
    if ("openSquare".equals(this.ctj))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  public static String jE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      switch (i)
      {
      default: 
        return paramString;
      case 21: 
        return "2";
      case 20: 
        return "3";
      case 15: 
        return "4";
      case 3001: 
        return "5";
      case 22: 
        return "6";
      }
      return "7";
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  private Intent v()
  {
    ((pso)psx.a(18)).IH();
    Intent localIntent = new Intent(this.context, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public boolean ace()
  {
    try
    {
      if ("openNow".equals(this.ctj)) {
        return acu();
      }
      boolean bool = acv();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQstoryAction", 1, "doAction error: " + localException.getMessage());
      Ge("QQstoryAction");
    }
    return false;
  }
  
  public boolean acu()
  {
    Object localObject1;
    String str2;
    if ((this.context instanceof Activity))
    {
      localObject1 = ((Activity)this.context).getIntent();
      if (localObject1 != null)
      {
        str2 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.source;
      }
      for (;;)
      {
        if (this.attrs.containsKey("roomid")) {}
        for (String str3 = (String)this.attrs.get("roomid");; str3 = "0")
        {
          if (this.attrs.containsKey("fromid")) {}
          for (String str4 = (String)this.attrs.get("fromid");; str4 = "")
          {
            if (this.attrs.containsKey("roomtype")) {}
            for (String str5 = (String)this.attrs.get("roomtype");; str5 = "")
            {
              if (this.attrs.containsKey("list_name")) {}
              for (String str6 = (String)this.attrs.get("list_name");; str6 = "")
              {
                if (this.attrs.containsKey("first_jump_mode")) {}
                for (String str7 = (String)this.attrs.get("first_jump_mode");; str7 = "h5")
                {
                  if (this.attrs.containsKey("need_record")) {}
                  for (String str8 = (String)this.attrs.get("need_record");; str8 = "1")
                  {
                    if (this.attrs.containsKey("is_record")) {}
                    for (String str9 = (String)this.attrs.get("is_record");; str9 = "0")
                    {
                      if (this.attrs.containsKey("enter_record_if_finish")) {}
                      for (String str10 = (String)this.attrs.get("enter_record_if_finish");; str10 = "1")
                      {
                        if (this.attrs.containsKey("nowapp_ext")) {}
                        for (String str11 = (String)this.attrs.get("nowapp_ext");; str11 = "")
                        {
                          if (this.attrs.containsKey("nowplugin_ext")) {}
                          for (String str12 = (String)this.attrs.get("nowplugin_ext");; str12 = "")
                          {
                            if (this.attrs.containsKey("h5_ext")) {}
                            for (String str13 = (String)this.attrs.get("h5_ext");; str13 = "")
                            {
                              if (this.attrs.containsKey("shakespearetime")) {}
                              for (String str14 = (String)this.attrs.get("shakespearetime");; str14 = "")
                              {
                                if (this.attrs.containsKey("msgurl")) {}
                                for (String str15 = toBase64Decode((String)this.attrs.get("msgurl"));; str15 = "")
                                {
                                  if (this.attrs.containsKey("hostloading_percent")) {}
                                  for (String str16 = (String)this.attrs.get("hostloading_percent");; str16 = "0")
                                  {
                                    String str17 = (String)this.attrs.get("coverurl");
                                    String str18 = (String)this.attrs.get("extras");
                                    Object localObject2 = (String)this.attrs.get("bid");
                                    localObject2 = (String)this.attrs.get("first");
                                    localObject2 = new Bundle();
                                    ((Bundle)localObject2).putString("coverurl", str17);
                                    ((Bundle)localObject2).putString("roomid", str3);
                                    ((Bundle)localObject2).putString("roomtype", str5);
                                    ((Bundle)localObject2).putString("extras_from_js", str18);
                                    ((Bundle)localObject2).putBoolean("can_use_h5_first", true);
                                    ((Bundle)localObject2).putString("first_jump_mode", str7);
                                    ((Bundle)localObject2).putString("is_record", str9);
                                    ((Bundle)localObject2).putString("enter_record_if_finish", str10);
                                    ((Bundle)localObject2).putString("nowapp_ext", str11);
                                    ((Bundle)localObject2).putString("nowplugin_ext", str12);
                                    ((Bundle)localObject2).putString("h5_ext", str13);
                                    ((Bundle)localObject2).putString("shakespearetime", str14);
                                    ((Bundle)localObject2).putString("fromid", str4);
                                    ((Bundle)localObject2).putString("url", str15);
                                    ((Bundle)localObject2).putString("listname", str6);
                                    ((Bundle)localObject2).putString("mqqScheme", (String)localObject1);
                                    if (!TextUtils.isEmpty(str2)) {
                                      ((Bundle)localObject2).putString("big_brother_source_key", str2);
                                    }
                                    boolean bool2 = true;
                                    boolean bool1 = bool2;
                                    if (!TextUtils.isEmpty(str8))
                                    {
                                      bool1 = bool2;
                                      if ("0".equals(str8)) {
                                        bool1 = false;
                                      }
                                    }
                                    ((Bundle)localObject2).putBoolean("need_record", bool1);
                                    if (this.attrs.containsKey("topic")) {
                                      ((Bundle)localObject2).putString("topic", (String)this.attrs.get("topic"));
                                    }
                                    if (this.attrs.containsKey("story_ext")) {
                                      ((Bundle)localObject2).putString("story_ext", (String)this.attrs.get("story_ext"));
                                    }
                                    if (this.attrs.containsKey("startsrc")) {
                                      ((Bundle)localObject2).putString("startsrc", (String)this.attrs.get("startsrc"));
                                    }
                                    if (this.attrs.containsKey("hostloading_percent")) {
                                      ((Bundle)localObject2).putInt("hostloading_percent", Integer.valueOf(str16).intValue());
                                    }
                                    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
                                    {
                                      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).show();
                                      return false;
                                    }
                                    try
                                    {
                                      ((aifl)this.app.getManager(306)).cL((Bundle)localObject2);
                                      QLog.i("QQstoryAction", 1, "enter now plugin use shadow");
                                      return true;
                                    }
                                    catch (Exception localException)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.e("QQstoryAction", 2, localException.toString());
                                      }
                                      return false;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
  
  public Intent g(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.attrs);
    return paramIntent;
  }
  
  public Intent h(Intent paramIntent)
  {
    paramIntent.putExtra("action", 4);
    String str2 = (String)this.attrs.get("topicname");
    String str3 = (String)this.attrs.get("topicid");
    String str4 = (String)this.attrs.get("storysharefrom");
    String str1 = str2;
    try
    {
      if (TextUtils.equals(str4, "qzone")) {
        str1 = URLDecoder.decode(str2, "utf-8");
      }
      paramIntent.putExtra("extra_topic_id", Long.parseLong(str3));
      paramIntent.putExtra("extra_topic_name", str1);
      paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", c(this.attrs));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public Intent i(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", c(this.attrs));
      paramIntent.putExtra("to_new_version", (String)this.attrs.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public Intent j(Intent paramIntent)
  {
    String str1 = (String)this.attrs.get("userid");
    String str2 = (String)this.attrs.get("usertype");
    String str3 = (String)this.attrs.get("unionid");
    String str4 = (String)this.attrs.get("storyid");
    String str5 = (String)this.attrs.get("showinfocard");
    int i = c(this.attrs);
    if ((str5 != null) && (str5.equals("0"))) {}
    for (boolean bool = false;; bool = true)
    {
      if (TextUtils.isEmpty(str4))
      {
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          return null;
        }
        int j;
        try
        {
          j = Integer.parseInt(str2);
          if (j == 1)
          {
            if (TextUtils.isEmpty(str1)) {
              return null;
            }
            paramIntent.putExtra("action", 7);
            paramIntent.putExtra("EXTRA_USER_UIN", str1);
            paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
            paramIntent.putExtra("extra_is_show_info_card", bool);
            paramIntent.putExtra("extra_share_from_type", i);
            paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQstoryAction", 2, "makeStoryPlayVideoPageIntent, NumberFormatException, userId:" + str1 + ", userType:" + str2);
          }
          return null;
        }
        if (j == 5)
        {
          paramIntent.putExtra("action", 4);
          paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
          paramIntent.putExtra("extra_topic_name", (String)this.attrs.get("topicname"));
          str3 = (String)this.attrs.get("topiccolor");
          if (!TextUtils.isEmpty(str3)) {
            paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
          }
          paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
          paramIntent.putExtra("extra_share_from_type", i);
          return paramIntent;
        }
        paramIntent.putExtra("action", 6);
        paramIntent.putExtra("user_type", Integer.parseInt(str2));
        paramIntent.putExtra("user_unionid", str3);
        paramIntent.putExtra("come_from", i);
        paramIntent.putExtra("showTitleBar", false);
        paramIntent.putExtra("showInfoCard", bool);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("story_id", str4);
      paramIntent.putExtra("come_from", i);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", false);
      return paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvj
 * JD-Core Version:    0.7.0.1
 */