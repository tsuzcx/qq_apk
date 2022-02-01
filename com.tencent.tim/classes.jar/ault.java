import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.teamworkforgroup.GPadInfo;
import com.tencent.tim.teamworkforgroup.GroupPadTemplateInfo;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public class ault
{
  public static String TAG = "TeamWorkUtils";
  public static long aoS;
  public static String cIE;
  public static String cjR = ".doc|.docx|.xls|.xlsx|";
  public static String cjS;
  public static final Map<Integer, String> ns;
  
  static
  {
    aoS = 101458937L;
    cjS = "https://docs.qq.com/desktop/m/index.html?_wv=2";
    ns = new HashMap();
    cIE = "key_is_show_loading_and_failed";
    ns.put(Integer.valueOf(6), "s_tim_mini_importing");
  }
  
  public static Intent a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString19);
    if (paramLong != -1L) {
      localIntent.putExtra("req_share_id", paramLong);
    }
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    if ((paramInt2 == 44) || (paramInt2 == 95)) {
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 45) {
        paramString1 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString1);
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString5.length() > 60) {
        paramString1 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("forward_thumb", paramString18);
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    paramString1 = anre.a(localIntent.getExtras());
    if (paramString1 != null) {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
    }
    return localIntent;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    String str = "https://docs.qq.com/desktop/m/send.html";
    if (!TextUtils.isEmpty(paramString3)) {
      str = "https://docs.qq.com/desktop/m/send.html" + "?team_id=" + paramString3;
    }
    return a(paramQQAppInterface, str, paramString1, paramString2, paramInt) + "#/recentfile/";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str1 = "";
    Object localObject = str1;
    for (;;)
    {
      try
      {
        String str2 = URLEncoder.encode(paramString2, "UTF-8");
        if (paramInt == 1)
        {
          localObject = str1;
          paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
          if (paramQQAppInterface != null)
          {
            localObject = str1;
            paramQQAppInterface = paramQQAppInterface.b(paramString3);
            if (paramQQAppInterface != null)
            {
              localObject = str1;
              l = paramQQAppInterface.dwGroupClassExt;
              localObject = str1;
              paramString2 = paramString1 + "?toUin=" + paramString3 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
              paramQQAppInterface = paramString2;
              localObject = paramString2;
              if (paramString1.contains("?"))
              {
                localObject = paramString2;
                paramQQAppInterface = paramString1 + "&toUin=" + paramString3 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
              }
              localObject = paramQQAppInterface;
              if (!TextUtils.isEmpty(""))
              {
                localObject = paramQQAppInterface;
                paramQQAppInterface = paramQQAppInterface + "&create_from=" + "";
                paramString1 = paramQQAppInterface;
                if (l == -1L) {}
              }
              continue;
            }
          }
        }
        long l = -1L;
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString1 = paramQQAppInterface + "&group_type=" + l;
          return paramString1;
        }
        catch (Exception paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        paramQQAppInterface = (QQAppInterface)localObject;
        paramString1.printStackTrace();
        return paramQQAppInterface;
      }
    }
  }
  
  public static online_docs.DocId a(int paramInt, String paramString)
  {
    online_docs.DocId localDocId = new online_docs.DocId();
    localDocId.pad_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDocId.domain_id.set(paramInt);
    return localDocId;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("tdsourcetag", paramString);
    paramQQAppInterface = "https://docs.qq.com/desktop/m/index.html?_wv=2097154";
    if (paramString != null) {
      paramQQAppInterface = bD("https://docs.qq.com/desktop/m/index.html?_wv=2097154", paramString);
    }
    paramContext.startActivity(localIntent.putExtra("url", paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    int i = 2;
    paramQQAppInterface = "";
    if (paramInt == 2)
    {
      paramQQAppInterface = "https://docs.qq.com/mall/m/index/doc?padtype=0&_wv=2&_wwv=512";
      if (paramInt != 2) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      paramQQAppInterface = bE(paramQQAppInterface, "s_tim_myfile_menu_create");
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramQQAppInterface);
      localBundle.putString("title", paramActivity.getString(2131720937));
      localBundle.putInt("key_team_work_edit_type", i);
      localBundle.putString("tdsourcetag", "s_tim_cloud_new");
      TeamWorkDocEditBrowserActivity.a(paramActivity, localBundle, true);
      return;
      if (paramInt == 3)
      {
        paramQQAppInterface = "https://docs.qq.com/mall/m/index/sheet?padtype=1&_wv=2&_wwv=512";
        break;
      }
      if (paramInt == 8)
      {
        paramQQAppInterface = "https://docs.qq.com/mall/m/index/form/collect?padtype=2&_wv=2&_wwv=512";
        break;
      }
      if (paramInt != 9) {
        break;
      }
      paramQQAppInterface = "https://docs.qq.com/mall/m/index/slide?padtype=4&_wv=2&_wwv=512";
      break;
      label127:
      if (paramInt != 3) {
        if (paramInt == 8) {
          i = 3;
        } else if (paramInt == 9) {
          i = 4;
        } else {
          i = 1;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, long paramLong)
  {
    int i = 2;
    Object localObject = "";
    String str = String.valueOf(paramLong);
    if (paramInt == 1)
    {
      localObject = "https://docs.qq.com/mall/m/index/doc?padtype=0&_wv=2&_wwv=512&group_code=" + str;
      if (paramInt != 1) {
        break label266;
      }
      i = 1;
    }
    for (;;)
    {
      label49:
      str = bE((String)localObject, "s_tim_grpfile");
      localObject = new Bundle();
      ((Bundle)localObject).putString("tdsourcetag", "s_tim_grpfile");
      ((Bundle)localObject).putString("url", str);
      ((Bundle)localObject).putString("title", paramActivity.getString(2131720937));
      ((Bundle)localObject).putInt("key_team_work_edit_type", i);
      ((Bundle)localObject).putBoolean(cIE, true);
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(String.valueOf(paramLong));
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
        ((Bundle)localObject).putString("troop_name", paramQQAppInterface.troopname);
      }
      for (;;)
      {
        TeamWorkDocEditBrowserActivity.a(paramActivity, (Bundle)localObject, true);
        return;
        if (paramInt == 2)
        {
          localObject = "https://docs.qq.com/mall/m/index/sheet?padtype=1&_wv=2&_wwv=512&group_code=" + str;
          break;
        }
        if (paramInt == 3)
        {
          localObject = "https://docs.qq.com/mall/m/index/form/collect?padtype=2&_wv=2&_wwv=512&group_code=" + str;
          break;
        }
        if (paramInt != 4) {
          break;
        }
        localObject = "https://docs.qq.com/mall/m/index/slide?padtype=4&_wv=2&_wwv=512&group_code=" + str;
        break;
        label266:
        if (paramInt == 2) {
          break label49;
        }
        if (paramInt == 3)
        {
          i = 3;
          break label49;
        }
        if (paramInt != 4) {
          break label323;
        }
        i = 4;
        break label49;
        ((Bundle)localObject).putString("troop_name", "" + paramLong);
      }
      label323:
      i = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    String str = "";
    Object localObject = "";
    int k;
    int j;
    if (paramGroupPadTemplateInfo != null)
    {
      k = paramGroupPadTemplateInfo.docOrSheetType;
      j = paramGroupPadTemplateInfo.templateID;
      str = String.valueOf(paramGroupPadTemplateInfo.groupCode);
    }
    for (paramGroupPadTemplateInfo = paramGroupPadTemplateInfo.templateUrl;; paramGroupPadTemplateInfo = (GroupPadTemplateInfo)localObject)
    {
      int i;
      if (!TextUtils.isEmpty(paramGroupPadTemplateInfo))
      {
        paramGroupPadTemplateInfo = "https:" + paramGroupPadTemplateInfo;
        if (aurr.isValidUrl(paramGroupPadTemplateInfo)) {
          break label384;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (k == 1)
          {
            paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=doc&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
            paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str;
          }
        }
        label149:
        label157:
        label376:
        label381:
        for (;;)
        {
          if (k == 1) {
            i = 1;
          }
          for (;;)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("tdsourcetag", "s_tim_grpfile");
            ((Bundle)localObject).putString("url", paramGroupPadTemplateInfo);
            ((Bundle)localObject).putInt("key_team_work_edit_type", i);
            ((Bundle)localObject).putBoolean(cIE, true);
            paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(str);
            if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
              ((Bundle)localObject).putString("troop_name", paramQQAppInterface.troopname);
            }
            for (;;)
            {
              TeamWorkDocEditBrowserActivity.a(paramActivity, (Bundle)localObject, true);
              return;
              paramGroupPadTemplateInfo = "";
              i = 1;
              break;
              if (k != 2) {
                break label381;
              }
              paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=sheet&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
              paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str;
              break label149;
              if (k != 2) {
                break label376;
              }
              i = 2;
              break label157;
              ((Bundle)localObject).putString("troop_name", "" + str);
            }
            i = 1;
          }
        }
        label384:
        i = 0;
      }
      j = 0;
      k = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, GPadInfo paramGPadInfo, String paramString)
  {
    String str1 = aobw.nT(paramGPadInfo.pad_url);
    Object localObject1 = aull.Az();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      String str2 = paramGPadInfo.title;
      Object localObject2 = paramQQAppInterface.getApp().getString(2131720968);
      if (paramGPadInfo.type == 2)
      {
        localObject1 = paramQQAppInterface.getApp().getString(2131720969);
        paramGPadInfo = aull.AA();
        if (TextUtils.isEmpty(paramGPadInfo)) {}
      }
      for (;;)
      {
        localObject2 = paramGPadInfo;
        if (TextUtils.isEmpty(paramGPadInfo)) {
          localObject2 = null;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (paramGPadInfo = str1;; paramGPadInfo = (GPadInfo)localObject1)
        {
          paramGPadInfo = a(1001, 95, "web_share", "", (String)localObject2, str2, paramGPadInfo, paramQQAppInterface.getApp().getString(2131698632, new Object[] { str2 }), str1, "web", null, null, null, " ", null, null, null, null, null, "", null, -1L);
          paramGPadInfo.putExtra("uintype", 1);
          paramGPadInfo.putExtra("uin", paramString);
          paramGPadInfo.putExtra("troop_uin", "");
          paramString = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
          if (paramString != null) {
            paramGPadInfo.putExtra("uinname", paramString.troopname);
          }
          paramString = ForwardUtils.a(paramGPadInfo);
          ForwardUtils.a(paramQQAppInterface, paramQQAppInterface.getApp(), paramString, paramGPadInfo);
          return;
        }
        paramGPadInfo = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
        continue;
        paramGPadInfo = (GPadInfo)localObject1;
        localObject1 = localObject2;
      }
      localObject1 = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", c(paramQQAppInterface, paramString2, paramString1, paramInt));
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt);
    paramActivity.startActivity(localIntent);
    return true;
  }
  
  public static String aS(String paramString, int paramInt)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    String[] arrayOfString1 = paramString.split("\\?");
    paramString = localStringBuilder;
    if (arrayOfString1 != null)
    {
      paramString = localStringBuilder;
      if (arrayOfString1.length > 0)
      {
        localStringBuilder = new StringBuilder(arrayOfString1[0]);
        int i = j;
        if (arrayOfString1.length > 1)
        {
          arrayOfString1 = arrayOfString1[1].split("&");
          i = j;
          if (arrayOfString1 != null)
          {
            int k = 0;
            i = 0;
            if (k < arrayOfString1.length)
            {
              String[] arrayOfString2 = arrayOfString1[k].split("=");
              int m = i;
              if (arrayOfString2 != null)
              {
                m = i;
                if (arrayOfString2.length == 2)
                {
                  paramString = null;
                  if (!arrayOfString2[0].equals("type")) {
                    break label227;
                  }
                  if (i == 0) {
                    localStringBuilder.append("?");
                  }
                  if (i != 0) {
                    localStringBuilder.append("&");
                  }
                  paramString = "type=" + arrayOfString2[1];
                  j = 1;
                }
              }
              for (;;)
              {
                m = j;
                if (paramString != null)
                {
                  localStringBuilder.append(paramString);
                  m = j;
                }
                k += 1;
                i = m;
                break;
                label227:
                j = i;
                if (arrayOfString2[0].equals("_wv"))
                {
                  if (i == 0) {
                    localStringBuilder.append("?");
                  }
                  if (i != 0) {
                    localStringBuilder.append("&");
                  }
                  paramString = "_wv=" + arrayOfString2[1];
                  j = 1;
                }
              }
            }
          }
        }
        if ((i == 0) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4))) {
          localStringBuilder.append("?type=").append(paramInt).append("&_wv=1");
        }
        paramString = localStringBuilder;
      }
    }
    return paramString.toString();
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    String str = "https://docs.qq.com/desktop/m/send.html";
    if (!TextUtils.isEmpty(paramString3)) {
      str = "https://docs.qq.com/desktop/m/send.html" + "?team_id=" + paramString3;
    }
    return a(paramQQAppInterface, str, paramString1, paramString2, paramInt) + "#/cloudfile/";
  }
  
  public static String bD(String paramString1, String paramString2)
  {
    String str = "?tdsourcetag=" + paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1.contains("?")) {
        str = "&tdsourcetag=" + paramString2;
      }
      return paramString1 + str;
    }
    return "";
  }
  
  public static String bE(String paramString1, String paramString2)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString1))
    {
      str = "?from_page=" + paramString2;
      if (paramString1.contains("?")) {
        str = "&from_page=" + paramString2;
      }
      str = paramString1 + str;
    }
    return str;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return a(paramQQAppInterface, "https://docs.qq.com/desktop/m/send.html", paramString1, paramString2, paramInt);
  }
  
  public static boolean cm(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1 != null)
        {
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
    }
    paramString1 = aueh.getExtension(str);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.toLowerCase();
      bool1 = bool2;
      if (cjR.indexOf(paramString1) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String ft(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    Object localObject = "";
    paramInt -= 1;
    int i;
    String str;
    do
    {
      i = paramInt;
      if (((String)localObject).length() > 0) {
        i = paramInt - 1;
      }
      str = (char)(i % 26 + 65) + (String)localObject;
      i = (i - i % 26) / 26;
      localObject = str;
      paramInt = i;
    } while (i > 0);
    return str;
  }
  
  public static String nT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("\\?");
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    return arrayOfString[0];
  }
  
  public static boolean pP(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.contains("docs.qq.com/doc/")) && (!paramString.contains("docs.qq.com/sheet/")) && (!paramString.contains("docs.qq.com/form/fill/")))
      {
        bool1 = bool2;
        if (!paramString.contains("docs.qq.com/form/edit/")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ault
 * JD-Core Version:    0.7.0.1
 */