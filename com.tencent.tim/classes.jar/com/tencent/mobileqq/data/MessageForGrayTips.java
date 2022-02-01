package com.tencent.mobileqq.data;

import acff;
import acfp;
import acsv;
import aegp;
import aegq;
import aegu;
import aela;
import aelb;
import aezs;
import aezt;
import aezu;
import aezv;
import afdh;
import ahwa;
import ahwb;
import aine;
import aiob;
import aiwk;
import ajcw;
import ajnk;
import ajnu;
import ajnw;
import aldj;
import alui;
import anbb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import anot;
import anov;
import aoaf;
import aobh;
import aobw;
import apdr;
import appb;
import apqz;
import apuh;
import apwn;
import apzg;
import aqfr;
import aqfx;
import aqgv;
import aqha;
import aqhv;
import aqik;
import aqju;
import aqmj;
import aqnm;
import aqrf;
import arts;
import ashy;
import avpw;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.a;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import jqc;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import ocp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qgg;
import rar;
import top;
import ujt;
import wwz;
import xwq;
import xxt;
import xys;

public class MessageForGrayTips
  extends ChatMessage
{
  public static final int ABILITY_SUPPORT_COLOR = 2;
  public static final int ABILITY_SUPPORT_IMAGE = 1;
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  public static final String KEY_TROOP_NEW_MEMBER_UIN = "troop_new_member_uin";
  private static final String TAG = "MessageForGrayTips";
  
  public static void decodeImageSpan(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder, HightlightItem paramHightlightItem, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    if ((paramHightlightItem.icon.startsWith("http://")) || (paramHightlightItem.icon.startsWith("https://"))) {
      if (paramBoolean)
      {
        paramSpannableStringBuilder.setSpan(new a(paramContext, 0, paramHightlightItem.icon, 32), paramHightlightItem.start, paramHightlightItem.end, 33);
        if (QLog.isColorLevel()) {
          QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Url Image=" + paramHightlightItem.icon);
        }
      }
    }
    label293:
    label427:
    for (;;)
    {
      return;
      paramSpannableStringBuilder.setSpan(new a(paramContext, 0, paramHightlightItem.icon), paramHightlightItem.start, paramHightlightItem.end, 33);
      break;
      if (ajnu.nw(paramHightlightItem.icon))
      {
        String str = ajnu.mk(paramHightlightItem.icon);
        if (!TextUtils.isEmpty(str))
        {
          if (paramBoolean) {}
          for (paramContext = new ajnw(paramContext, 0, str, aqnm.dpToPx(16.0F), paramCallback);; paramContext = new ajnw(paramContext, 0, str, paramCallback))
          {
            paramSpannableStringBuilder.setSpan(paramContext, paramHightlightItem.start, paramHightlightItem.end, 33);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("MessageForGrayTips", 2, "decodeImageSpan isMutualMarkImageUrlTemplate Url Image=" + str);
            return;
          }
        }
      }
      else
      {
        int i = paramHightlightItem.icon.indexOf('.');
        if (i != -1)
        {
          paramCallback = paramHightlightItem.icon.substring(0, i);
          if (!ajnu.lP.containsKey(paramCallback)) {
            break label382;
          }
          i = ((Integer)ajnu.lP.get(paramCallback)).intValue();
          if (i != 0)
          {
            if (!paramBoolean) {
              break label402;
            }
            paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i, paramHightlightItem.getIconSize()), paramHightlightItem.start, paramHightlightItem.end, 33);
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label427;
          }
          QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Image=" + paramCallback + " resourceId:" + i);
          return;
          paramCallback = paramHightlightItem.icon;
          break;
          label382:
          i = paramContext.getResources().getIdentifier(paramCallback, "drawable", paramContext.getPackageName());
          break label293;
          paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i), paramHightlightItem.start, paramHightlightItem.end, 33);
        }
      }
    }
  }
  
  public static String getOrginMsg(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("                    ##**##");
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int j = 0;
    if (paramInt1 >= paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForGrayTips", 2, "revoke msg addHightlightItem start >= end error");
      }
      return;
    }
    saveExtInfoToExtStr("new_item_tag", Boolean.TRUE.toString());
    int i;
    String str2;
    String str3;
    String str1;
    if (paramBundle == null)
    {
      i = -1;
      str2 = null;
      str3 = null;
      str1 = null;
    }
    for (;;)
    {
      String str4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "addHightlightItem ==>actionType:" + i);
        }
        str4 = "," + i + "," + paramInt1 + "," + paramInt2;
        switch (i)
        {
        case 5: 
          paramBundle = paramBundle + ",icon";
          if (str3 == null) {
            break label809;
          }
          paramBundle = paramBundle + ",1," + str3;
          if (str2 == null) {
            break label833;
          }
          paramBundle = paramBundle + ",1," + str2;
          paramBundle = paramBundle + ",color";
          if (str1 == null) {
            break label857;
          }
          paramBundle = paramBundle + ",1," + str1;
          paramInt1 = this.msg.indexOf("                    ##**##");
          if (paramInt1 != -1) {
            break label881;
          }
          this.msg = (this.msg + "                    ##**##" + "1" + paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i = paramBundle.getInt("key_action");
      str1 = paramBundle.getString("textColor");
      str3 = paramBundle.getString("image_resource");
      str2 = paramBundle.getString("image_alt");
      continue;
      String str5 = paramBundle.getString("troop_mem_uin");
      paramInt1 = j;
      if (paramBundle.getBoolean("need_update_nick")) {
        paramInt1 = 1;
      }
      paramBundle = str4 + "," + paramInt1 + "," + str5;
      continue;
      paramBundle = paramBundle.getString("troop_mem_uin");
      paramBundle = str4 + "," + paramBundle;
      continue;
      str5 = paramBundle.getString("key_action_DATA");
      paramBundle = paramBundle.getString("key_a_action_DATA");
      paramBundle = str4 + "," + str5 + "," + paramBundle;
      continue;
      str5 = paramBundle.getString("remark");
      paramBundle = str5;
      if (TextUtils.isEmpty(str5)) {
        paramBundle = "";
      }
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramInt1 = paramBundle.getInt("group_id", -1);
      paramBundle = str4 + "," + paramInt1;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      label809:
      paramBundle = paramBundle + ",0";
      continue;
      label833:
      paramBundle = paramBundle + ",0";
      continue;
      label857:
      paramBundle = paramBundle + ",0";
      continue;
      label881:
      str1 = this.msg.substring(0, paramInt1);
      str3 = this.msg.substring(paramInt1 + "                    ##**##".length(), this.msg.length());
      paramInt1 = str3.indexOf(',');
      str2 = str3.substring(0, paramInt1);
      str3 = str3.substring(paramInt1, str3.length());
      paramInt1 = Integer.parseInt(str2);
      paramBundle = paramInt1 + 1 + str3 + paramBundle;
      this.msg = (str1 + "                    ##**##" + paramBundle);
      if ((!QLog.isColorLevel()) || (!(this instanceof MessageForDeliverGiftTips))) {
        break;
      }
      QLog.i(".troop.send_gift", 2, "MessageForGrayTips.addHightlightItem:" + this.msg);
      return;
      paramBundle = str4;
    }
  }
  
  public boolean checkAbillity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return isSupportImage();
    }
    return isSupportColor();
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    String str2;
    Object localObject1;
    Object localObject5;
    int i3;
    ArrayList localArrayList;
    int i1;
    try
    {
      if (this.extStr != null) {
        bool1 = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> isNewHighlitItem:" + bool1);
      }
      String str1 = this.msg;
      i = -1;
      if (!TextUtils.isEmpty(str1)) {
        i = str1.indexOf("                    ##**##");
      }
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageForGrayTips", 2, "revoke msg getHightlightMsgText JSONException");
          bool1 = bool2;
        }
      }
      str2 = this.msg.substring(0, i);
      localObject1 = this.msg.substring(i + "                    ##**##".length(), this.msg.length());
      i = ((String)localObject1).indexOf(',');
      localObject5 = ((String)localObject1).substring(0, i);
      localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
      i3 = Integer.parseInt((String)localObject5);
      new LinkedList();
      localArrayList = new ArrayList(i3);
      i1 = 0;
    }
    int i2;
    int j;
    int k;
    label259:
    Object localObject8;
    Object localObject7;
    Object localObject9;
    Object localObject10;
    if (i1 < i3)
    {
      i2 = -1;
      i = 0;
      j = 0;
      if (bool1)
      {
        k = 0;
        localObject8 = null;
        localObject7 = null;
        localObject9 = null;
        localObject10 = null;
        localObject5 = localObject1;
        if (!bool1) {}
      }
    }
    for (;;)
    {
      int n;
      int m;
      long l;
      for (;;)
      {
        label624:
        Object localObject11;
        label675:
        label1061:
        try
        {
          i = ((String)localObject1).indexOf(',');
          localObject5 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i2 = Integer.parseInt((String)localObject5);
          i = ((String)localObject1).indexOf(',');
          localObject5 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i = Integer.parseInt((String)localObject5);
          j = ((String)localObject1).indexOf(',');
          if (j != -1)
          {
            localObject5 = ((String)localObject1).substring(0, j);
            localObject1 = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            j = Integer.parseInt((String)localObject5);
            localObject5 = localObject1;
            if (QLog.isColorLevel()) {
              QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> actionType:" + i2);
            }
            switch (i2)
            {
            case 0: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 16: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 27: 
            default: 
              if (bool1)
              {
                n = -1;
                m = k;
                localObject1 = localObject5;
                localObject5 = "";
                k = n;
                if (TextUtils.isEmpty((CharSequence)localObject5)) {
                  break label2866;
                }
              }
              break;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label947:
          QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException1);
        }
        try
        {
          l = Long.parseLong((String)localObject5);
          n = ((String)localObject1).indexOf(',');
          if ((n == -1) || (!"icon".equals(((String)localObject1).substring(0, n)))) {
            break label2860;
          }
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = 1;
          if (!checkAbillity(1)) {
            if (n == 0) {
              break label2849;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          for (;;)
          {
            label896:
            if (QLog.isColorLevel()) {
              QLog.e("MessageForGrayTips", 2, "getHightlightMsgText ==>NumberFormatException");
            }
          }
          n = Integer.parseInt(localNumberFormatException3);
          continue;
          n = Integer.parseInt((String)localObject6);
          continue;
          localObject8 = localObject6;
          continue;
          localObject8 = null;
          continue;
        }
        try
        {
          n = ((String)localObject1).indexOf(',');
          if (n != -1)
          {
            localObject5 = ((String)localObject1).substring(0, n);
            localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            n = Integer.parseInt((String)localObject5);
            if (n == 0) {
              break label2967;
            }
            n = ((String)localObject1).indexOf(',');
            if (n == -1) {
              break label2952;
            }
            localObject5 = ((String)localObject1).substring(0, n);
            localObject8 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            localObject1 = localObject5;
            localObject5 = localObject8;
            n = ((String)localObject5).indexOf(',');
            if (n == -1) {
              break label2137;
            }
            localObject8 = ((String)localObject5).substring(0, n);
            localObject5 = ((String)localObject5).substring(n + 1, ((String)localObject5).length());
            n = Integer.parseInt((String)localObject8);
            if (n == 0) {
              break label2154;
            }
            n = ((String)localObject5).indexOf(',');
            if (n == -1) {
              break label2147;
            }
            localObject8 = ((String)localObject5).substring(0, n);
            localObject5 = ((String)localObject5).substring(n + 1, ((String)localObject5).length());
            localObject11 = localObject5;
            localObject5 = localObject1;
            localObject1 = localObject11;
            n = ((String)localObject1).indexOf(',');
            if ((n == -1) || (!"color".equals(((String)localObject1).substring(0, n)))) {
              break label2843;
            }
            localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            n = 1;
            if (!checkAbillity(2)) {
              if (n == 0) {
                break label2835;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          if (!QLog.isColorLevel()) {
            break label1156;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips image resource or alt failed. msg:" + this.msg + "exception:" + localNumberFormatException4.getStackTrace());
          break label1156;
          n = Integer.parseInt(localNumberFormatException4);
          continue;
          localNumberFormatException7 = localNumberFormatException4;
          localObject11 = localNumberFormatException4;
          localObject3 = localNumberFormatException7;
          continue;
        }
        try
        {
          n = ((String)localObject1).indexOf(',');
          if (n == -1) {
            break label2214;
          }
          localObject11 = ((String)localObject1).substring(0, n);
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = Integer.parseInt((String)localObject11);
          if (n == 0) {
            break label2827;
          }
          n = ((String)localObject1).indexOf(',');
          if (n == -1) {
            break label2224;
          }
          localObject11 = ((String)localObject1).substring(0, n);
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = Color.parseColor((String)localObject11);
          localArrayList.add(new HightlightItem(i, j, l, m, i2, (String)localObject7, (String)localObject9, (String)localObject5, (String)localObject8, n, (String)localObject10, k));
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException5)
        {
          if (!QLog.isColorLevel()) {
            break label1156;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips hasColor failed. msg:" + this.msg + "exception:" + localNumberFormatException5.getStackTrace());
          break label1156;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (!QLog.isColorLevel()) {
            break label1156;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips text color failed. msg:" + this.msg + "exception:" + localIllegalArgumentException.getStackTrace());
          break label1156;
          i += 1;
          break label1159;
          localObject6 = "";
          localObject8 = (TroopManager)paramQQAppInterface.getManager(52);
          localObject9 = localArrayList.iterator();
          i = 0;
          localObject4 = str2;
          if (!((Iterator)localObject9).hasNext()) {
            break label2662;
          }
          localObject10 = (HightlightItem)((Iterator)localObject9).next();
          localObject11 = (String)localObject6 + ((String)localObject4).substring(0, ((HightlightItem)localObject10).start - i);
          localObject6 = ((String)localObject4).substring(((HightlightItem)localObject10).start - i, ((HightlightItem)localObject10).end - i);
          localObject7 = ((String)localObject4).substring(((HightlightItem)localObject10).end - i, ((String)localObject4).length());
          i = ((HightlightItem)localObject10).end;
          ((HightlightItem)localObject10).start = ((String)localObject11).length();
          if (!((HightlightItem)localObject10).needUpdateNick) {
            break label2637;
          }
          localObject4 = ((TroopManager)localObject8).aL(this.frienduin, "" + ((HightlightItem)localObject10).uin);
          if ((localObject4 == null) || (!((String)localObject4).equals(((HightlightItem)localObject10).uin + "")) || (TextUtils.isEmpty((CharSequence)localObject6))) {
            break;
          }
          localObject4 = localObject6;
          for (localObject4 = (String)localObject11 + (String)localObject4;; localObject4 = (String)localObject11 + (String)localObject6)
          {
            ((HightlightItem)localObject10).end = ((String)localObject4).length();
            localObject6 = localObject4;
            localObject4 = localObject7;
            break;
          }
          localObject4 = new SpannableStringBuilder((String)localObject6 + (String)localObject4);
          localObject6 = localArrayList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (HightlightItem)((Iterator)localObject6).next();
            if (localObject7 != null) {
              if (TextUtils.isEmpty(((HightlightItem)localObject7).icon)) {
                ((SpannableStringBuilder)localObject4).setSpan(new HightlightClickableSpan(paramQQAppInterface, ((HightlightItem)localObject7).textColor, paramContext, (HightlightItem)localObject7, this), ((HightlightItem)localObject7).start, ((HightlightItem)localObject7).end, 33);
              } else {
                decodeImageSpan(paramContext, (SpannableStringBuilder)localObject4, (HightlightItem)localObject7, paramBoolean, paramCallback);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label2821;
          }
          QLog.i(".troop.send_gift", 2, "revoke msg MessageForGrayTips.getHightlightMsgText:" + localObject4);
          return localObject4;
        }
      }
      k = 1;
      break label259;
      j = Integer.parseInt((String)localObject1);
      continue;
      label1156:
      i = 0;
      label1159:
      if (i < localArrayList.size() - 1)
      {
        j = i + 1;
        for (;;)
        {
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label2347;
            }
            if (((HightlightItem)localArrayList.get(i)).start > ((HightlightItem)localArrayList.get(j)).start)
            {
              localObject2 = (HightlightItem)localArrayList.get(i);
              localArrayList.add(i, localArrayList.get(j));
              localArrayList.add(j, localObject2);
            }
            j += 1;
            continue;
            n = -1;
            Object localObject2 = localObject5;
            localObject5 = "";
            m = k;
            k = n;
            break;
            try
            {
              k = ((String)localObject5).indexOf(',');
              localObject8 = ((String)localObject5).substring(0, k);
              localObject2 = ((String)localObject5).substring(k + 1, ((String)localObject5).length());
              m = Integer.parseInt((String)localObject8);
              k = ((String)localObject2).indexOf(',');
              if (k == -1) {
                break label2895;
              }
              localObject5 = ((String)localObject2).substring(0, k);
              localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
              k = -1;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              QLog.d("MessageForGrayTips", 2, "getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException2);
            }
          }
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2905;
          }
          localObject8 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          n = -1;
          localObject5 = localObject8;
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          localObject2 = localObject5;
          localObject7 = localObject8;
          if (m != -1)
          {
            localObject7 = ((String)localObject5).substring(0, m);
            localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          }
          m = ((String)localObject2).indexOf(',');
          if (m == -1) {
            break label2923;
          }
          localObject9 = ((String)localObject2).substring(0, m);
          localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
          n = -1;
          localObject5 = "";
          m = k;
          k = n;
          break;
          localObject7 = ((String)localObject5).substring(((String)localObject5).indexOf("{"), ((String)localObject5).indexOf("}") + 1);
          n = -1;
          localObject2 = localObject5;
          localObject5 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2872;
          }
          localObject10 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          n = -1;
          localObject5 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2872;
          }
          localObject8 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
        }
      }
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject8);
          n = m;
          localObject5 = "";
          m = k;
          k = n;
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          if (!QLog.isColorLevel()) {
            break label2946;
          }
        }
        QLog.e("MessageForGrayTips", 2, "parse group id ==>NumberFormatException");
        break label2946;
        m = localNumberFormatException6.indexOf(',');
        if (m != -1)
        {
          localObject7 = localNumberFormatException6.substring(0, m);
          localObject2 = localNumberFormatException6.substring(m + 1, localNumberFormatException6.length());
          n = -1;
          localObject6 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject6).indexOf(',');
          if (m != -1)
          {
            localObject7 = ((String)localObject6).substring(0, m);
            localObject2 = ((String)localObject6).substring(m + 1, ((String)localObject6).length());
            n = -1;
            localObject6 = "";
            m = k;
            k = n;
            break;
            i = ((String)localObject6).indexOf(',');
            localObject2 = ((String)localObject6).substring(0, i);
            localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
            j = Integer.parseInt((String)localObject2);
            i = ((String)localObject6).indexOf(',');
            localObject2 = ((String)localObject6).substring(0, i);
            localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
            i = Integer.parseInt((String)localObject2);
            k = ((String)localObject6).indexOf(',');
            localObject8 = ((String)localObject6).substring(0, k);
            localObject2 = ((String)localObject6).substring(k + 1, ((String)localObject6).length());
            m = Integer.parseInt((String)localObject8);
            k = ((String)localObject2).indexOf(',');
            if (k != -1)
            {
              localObject6 = ((String)localObject2).substring(0, k);
              localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
              n = -1;
              k = i;
              i = j;
              j = k;
              k = n;
              break;
            }
            n = -1;
            localObject6 = localObject2;
            k = i;
            i = j;
            j = k;
            k = n;
            break;
            break label1156;
            label2137:
            label2147:
            label2154:
            NumberFormatException localNumberFormatException7;
            label2214:
            label2224:
            Object localObject3;
            label2347:
            label2637:
            label2662:
            for (;;) {}
            label2821:
            label2827:
            n = -14782465;
            break label1061;
            label2835:
            n = -14782465;
            break label1061;
            label2843:
            n = 0;
            break label947;
            label2849:
            localObject8 = null;
            localObject6 = "";
            break label896;
            label2860:
            n = 0;
            break label675;
            label2866:
            l = 0L;
            break label624;
          }
        }
        label2872:
        n = -1;
        localObject4 = localObject6;
        localObject6 = "";
        m = k;
        k = n;
        break;
        label2895:
        k = -1;
        localObject6 = localObject4;
        break;
        label2905:
        n = -1;
        localObject4 = localObject6;
        m = k;
        k = n;
        break;
        label2923:
        n = -1;
        localObject9 = localObject4;
        localObject6 = "";
        m = k;
        k = n;
        break;
        label2946:
        m = -1;
      }
      label2952:
      localObject8 = localObject4;
      Object localObject6 = localObject4;
      Object localObject4 = localObject8;
      continue;
      label2967:
      localObject8 = null;
      localObject6 = localObject4;
      localObject4 = localObject8;
    }
  }
  
  public int getTextGravity()
  {
    String str = getExtInfoFromExtStr("textGravity");
    int i = 19;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 19;
  }
  
  public boolean isSupportColor()
  {
    return false;
  }
  
  public boolean isSupportImage()
  {
    return false;
  }
  
  public void setTextGravity(int paramInt)
  {
    saveExtInfoToExtStr("textGravity", "" + paramInt);
  }
  
  public void switch2HightlightMsg() {}
  
  public static class HightlightClickableSpan
    extends ClickableSpan
  {
    int color = -1;
    private Context context;
    public String frienduin;
    private MessageForGrayTips.HightlightItem item;
    private WeakReference<QQAppInterface> mApp;
    MessageRecord message;
    
    public HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HightlightItem paramHightlightItem, MessageRecord paramMessageRecord)
    {
      this.mApp = new WeakReference(paramQQAppInterface);
      this.context = paramContext;
      this.color = paramInt;
      this.item = paramHightlightItem;
      this.message = paramMessageRecord;
      if (paramMessageRecord != null) {
        this.frienduin = paramMessageRecord.frienduin;
      }
    }
    
    private void deleteFriend(QQAppInterface paramQQAppInterface, String paramString)
    {
      if ((paramQQAppInterface == null) || (paramString == null)) {}
      do
      {
        do
        {
          return;
        } while (!((acff)paramQQAppInterface.getManager(51)).isFriend(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "deleteFriend " + paramString);
        }
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).d(paramString, (byte)2);
        MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, paramString));
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatSettingActivity.class);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711681, paramString));
    }
    
    private void showDeleteDialog(QQAppInterface paramQQAppInterface)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      paramQQAppInterface = acfp.m(2131708175);
      if (this.item.mMsg_A_ActionData != null) {
        paramQQAppInterface = this.item.mMsg_A_ActionData;
      }
      aqha.a(this.context, null, paramQQAppInterface, null, 2131721058, 2131692842, new aezu(this), new aezv(this)).show();
    }
    
    /* Error */
    public boolean clickAppMsg(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   5: ifeq +37 -> 42
      //   8: ldc 165
      //   10: iconst_2
      //   11: new 80	java/lang/StringBuilder
      //   14: dup
      //   15: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   18: ldc 167
      //   20: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   23: aload_1
      //   24: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: ldc 169
      //   29: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: aload_2
      //   33: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   39: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   42: aload_0
      //   43: aload_1
      //   44: aload_2
      //   45: invokevirtual 173	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:parsePackageNameAndData	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
      //   48: astore_2
      //   49: aload_0
      //   50: getfield 36	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
      //   53: invokevirtual 179	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   56: astore 4
      //   58: aload 4
      //   60: aload_2
      //   61: iconst_0
      //   62: aaload
      //   63: iconst_1
      //   64: invokevirtual 185	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
      //   67: ifnull +240 -> 307
      //   70: aload 4
      //   72: aload_2
      //   73: iconst_0
      //   74: aaload
      //   75: invokevirtual 189	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
      //   78: astore 4
      //   80: aload_2
      //   81: iconst_1
      //   82: aaload
      //   83: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   86: ifne +15 -> 101
      //   89: aload 4
      //   91: aload_2
      //   92: iconst_1
      //   93: aaload
      //   94: invokestatic 201	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   97: invokevirtual 207	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   100: pop
      //   101: aload 4
      //   103: ifnull +124 -> 227
      //   106: aload_0
      //   107: getfield 40	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
      //   110: getfield 210	com/tencent/mobileqq/data/MessageRecord:istroop	I
      //   113: sipush 1008
      //   116: if_icmpeq +111 -> 227
      //   119: aload 4
      //   121: ldc 212
      //   123: ldc 214
      //   125: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   128: pop
      //   129: aload_0
      //   130: getfield 34	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
      //   133: invokevirtual 222	mqq/util/WeakReference:get	()Ljava/lang/Object;
      //   136: checkcast 60	com/tencent/mobileqq/app/QQAppInterface
      //   139: bipush 23
      //   141: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
      //   144: checkcast 224	acly
      //   147: astore 5
      //   149: aload 4
      //   151: ldc 226
      //   153: ldc 228
      //   155: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   158: pop
      //   159: aload 4
      //   161: ldc 230
      //   163: ldc 232
      //   165: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   168: pop
      //   169: aload 4
      //   171: ldc 234
      //   173: ldc 236
      //   175: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   178: pop
      //   179: aload 4
      //   181: ldc 238
      //   183: ldc 240
      //   185: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   188: pop
      //   189: aload 4
      //   191: ldc 242
      //   193: aload_0
      //   194: getfield 36	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
      //   197: invokevirtual 248	java/lang/Object:getClass	()Ljava/lang/Class;
      //   200: invokevirtual 253	java/lang/Class:getName	()Ljava/lang/String;
      //   203: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   206: pop
      //   207: aload 5
      //   209: aload_2
      //   210: iconst_0
      //   211: aaload
      //   212: invokevirtual 258	java/lang/String:trim	()Ljava/lang/String;
      //   215: aload_0
      //   216: getfield 36	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
      //   219: aload 4
      //   221: invokevirtual 262	acly:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
      //   224: goto +81 -> 305
      //   227: aload 4
      //   229: ifnull -100 -> 129
      //   232: aload 4
      //   234: ldc 212
      //   236: aload_0
      //   237: getfield 40	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
      //   240: getfield 44	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
      //   243: invokestatic 268	ocp:fq	(Ljava/lang/String;)Ljava/lang/String;
      //   246: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   249: pop
      //   250: goto -121 -> 129
      //   253: astore_2
      //   254: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   257: ifeq +13 -> 270
      //   260: ldc_w 270
      //   263: iconst_2
      //   264: ldc_w 272
      //   267: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   270: aload_0
      //   271: getfield 36	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
      //   274: aload 4
      //   276: invokevirtual 276	android/content/Context:startActivity	(Landroid/content/Intent;)V
      //   279: goto +26 -> 305
      //   282: astore_2
      //   283: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   286: ifeq +13 -> 299
      //   289: ldc 78
      //   291: iconst_2
      //   292: aload_2
      //   293: invokevirtual 279	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
      //   296: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   299: aload_0
      //   300: aload_1
      //   301: invokevirtual 282	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickWebMsg	(Ljava/lang/String;)Z
      //   304: ireturn
      //   305: iconst_1
      //   306: istore_3
      //   307: iload_3
      //   308: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	309	0	this	HightlightClickableSpan
      //   0	309	1	paramString1	String
      //   0	309	2	paramString2	String
      //   1	307	3	bool	boolean
      //   56	219	4	localObject	Object
      //   147	61	5	localacly	acly
      // Exception table:
      //   from	to	target	type
      //   106	129	253	java/lang/Exception
      //   129	224	253	java/lang/Exception
      //   232	250	253	java/lang/Exception
      //   58	101	282	android/content/pm/PackageManager$NameNotFoundException
      //   106	129	282	android/content/pm/PackageManager$NameNotFoundException
      //   129	224	282	android/content/pm/PackageManager$NameNotFoundException
      //   232	250	282	android/content/pm/PackageManager$NameNotFoundException
      //   254	270	282	android/content/pm/PackageManager$NameNotFoundException
      //   270	279	282	android/content/pm/PackageManager$NameNotFoundException
    }
    
    public boolean clickPluginMsg(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
      }
      String str;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!TextUtils.equals("null", paramString2)) {}
      }
      else
      {
        str = paramString1;
      }
      try
      {
        paramString1 = aqik.c((QQAppInterface)this.mApp.get(), this.context, str);
        if (paramString1 != null)
        {
          paramString1.edJ();
          paramString1.ace();
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
          }
        }
      }
      return true;
    }
    
    public boolean clickWebMsg(String paramString)
    {
      if (paramString == null) {}
      do
      {
        do
        {
          do
          {
            return false;
            if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))) {
              break label133;
            }
            if (!paramString.equals("cmd://openGiftPanel")) {
              break;
            }
          } while (!(this.context instanceof FragmentActivity));
          paramString = ((FragmentActivity)this.context).getChatFragment();
        } while ((paramString == null) || (paramString.a() == null));
        paramString.a().wh(true);
        return true;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("mqzone://arouse/lovermainpage")) || (this.mApp == null));
      aiwk.a((QQAppInterface)this.mApp.get(), this.context, 2080, "");
      return false;
      label133:
      if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
        anot.a(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
      }
      afdh.HK(paramString);
      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.dbK == 131078))
      {
        apdr.b("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
        aqmj.af(this.context, ((BaseActivity)this.context).app.getCurrentAccountUin(), this.message.frienduin);
      }
      if ((this.message != null) && (this.message.istroop == 1) && (ajcw.a((BaseActivity)this.context, paramString, this.message)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "mini app jump handled");
        }
        return true;
      }
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("key_isReadModeEnabled", true);
      String str;
      if (this.message == null) {
        str = "biz_src_jc_aio";
      }
      for (;;)
      {
        localIntent.putExtra("big_brother_source_key", str);
        ocp.a(this.message, localIntent, paramString);
        this.context.startActivity(localIntent);
        paramString = (QQAppInterface)this.mApp.get();
        if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
          anot.a(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
        }
        return true;
        if (this.message.istroop == 1008) {
          str = ocp.fq(this.message.frienduin);
        } else {
          str = "biz_src_jc_aio";
        }
      }
    }
    
    public void onClick(View paramView)
    {
      if ((this.item == null) || (this.mApp == null) || (this.mApp.get() == null)) {}
      Object localObject3;
      Object localObject5;
      label475:
      int i;
      label521:
      Object localObject2;
      label1318:
      label1497:
      label3454:
      boolean bool1;
      label1563:
      label1878:
      long l;
      label3270:
      int j;
      label3507:
      Object localObject6;
      Object localObject7;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      do
                                                      {
                                                        return;
                                                        if (QLog.isColorLevel()) {
                                                          QLog.d("MessageForGrayTips", 2, "revoke msg onClick==>item actionType:" + this.item.actionType);
                                                        }
                                                        localObject3 = (QQAppInterface)this.mApp.get();
                                                      } while (localObject3 == null);
                                                      switch (this.item.actionType)
                                                      {
                                                      case 8: 
                                                      case 9: 
                                                      case 22: 
                                                      case 23: 
                                                      case 35: 
                                                      case 37: 
                                                      case 49: 
                                                      default: 
                                                        return;
                                                      case 1: 
                                                        if ((this.message != null) && (this.message.msgtype == -2049)) {
                                                          arts.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
                                                        }
                                                        if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                                        {
                                                          localObject5 = ((MessageForUniteGrayTip)this.message).tipParam;
                                                          if (localObject5 != null)
                                                          {
                                                            if (((ahwa)localObject5).dbK != 2359297) {
                                                              break label521;
                                                            }
                                                            anot.a(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
                                                            if (ajnu.ky(((ahwa)localObject5).dbK))
                                                            {
                                                              if (!TextUtils.isEmpty(this.item.mMsgActionData)) {
                                                                break label1318;
                                                              }
                                                              paramView = this.item.mMsg_A_ActionData;
                                                              ajnk.a((QQAppInterface)localObject3, (MessageForUniteGrayTip)this.message, ((ahwa)localObject5).dbK, paramView);
                                                            }
                                                          }
                                                        }
                                                        if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
                                                        for (paramView = this.item.mMsg_A_ActionData;; paramView = this.item.mMsgActionData)
                                                        {
                                                          clickWebMsg(paramView);
                                                          return;
                                                          if (((ahwa)localObject5).dbK == 2359298)
                                                          {
                                                            anot.a(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 2490369)
                                                          {
                                                            anot.a(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 2621441)
                                                          {
                                                            paramView = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
                                                            if (TextUtils.isEmpty(paramView)) {
                                                              break;
                                                            }
                                                            anot.a(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 3145729)
                                                          {
                                                            anot.a(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 131078)
                                                          {
                                                            VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 2097154)
                                                          {
                                                            if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
                                                            for (paramView = this.item.mMsg_A_ActionData; !TextUtils.isEmpty(paramView); paramView = this.item.mMsgActionData)
                                                            {
                                                              for (;;)
                                                              {
                                                                Object localObject1 = jqc.f(paramView);
                                                                if (!((Map)localObject1).containsKey("type")) {
                                                                  break;
                                                                }
                                                                localObject1 = (String)((Map)localObject1).get("type");
                                                                try
                                                                {
                                                                  i = Integer.parseInt((String)localObject1);
                                                                  anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA6", i, 0, "", "", "", "");
                                                                }
                                                                catch (NumberFormatException localNumberFormatException) {}
                                                              }
                                                              if (!QLog.isColorLevel()) {
                                                                break;
                                                              }
                                                              QLog.d("reactive", 2, "parse url type error:" + paramView);
                                                              break;
                                                            }
                                                          }
                                                          if (((ahwa)localObject5).dbK == 655384)
                                                          {
                                                            localObject2 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
                                                            paramView = (View)localObject2;
                                                            if (TextUtils.isEmpty((CharSequence)localObject2)) {
                                                              paramView = "1";
                                                            }
                                                            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", paramView, "", "2"));
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK == 2097153)
                                                          {
                                                            paramView = this.message.getExtInfoFromExtStr("friendIconType");
                                                            if (TextUtils.isEmpty(paramView)) {
                                                              break;
                                                            }
                                                            VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)localObject3).getCurrentAccountUin(), "friendspark", "aio_click", "", 0, 0, 0, "", paramView, "", "", "", "", "", 0, 0, 0, 0);
                                                            if (paramView.equals("3"))
                                                            {
                                                              LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "2"));
                                                              break;
                                                            }
                                                            if (!paramView.equals("6")) {
                                                              break;
                                                            }
                                                            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "2"));
                                                            break;
                                                          }
                                                          if (((ahwa)localObject5).dbK != 655397) {
                                                            break;
                                                          }
                                                          paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                          localObject2 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                          i = 3;
                                                          if (this.message.istroop == 0) {
                                                            i = 1;
                                                          }
                                                          for (;;)
                                                          {
                                                            anot.a((QQAppInterface)localObject3, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject2, "" + paramView, "web", "");
                                                            if ("1008".equals(localObject2)) {
                                                              anot.a(null, "dc00898", "", "", "0X800A639", "0X800A639", i - 1, 0, "", "", "", "");
                                                            }
                                                            if (!Long.valueOf((String)localObject2).equals(Long.valueOf(1021L))) {
                                                              break;
                                                            }
                                                            anot.a(null, "dc00898", "", "", "0X800AD83", "0X800AD83", 0, 0, "", "", "", "");
                                                            break;
                                                            if (this.message.istroop == 1) {
                                                              i = 2;
                                                            }
                                                          }
                                                          paramView = this.item.mMsgActionData;
                                                          break label475;
                                                        }
                                                      case 3: 
                                                        if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.dbK == 655397))
                                                        {
                                                          paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                          localObject2 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                          i = 3;
                                                          if (this.message.istroop != 0) {
                                                            break label1497;
                                                          }
                                                          i = 1;
                                                        }
                                                        for (;;)
                                                        {
                                                          anot.a((QQAppInterface)localObject3, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject2, "" + paramView, "mqq", "");
                                                          clickPluginMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                          return;
                                                          if (this.message.istroop == 1) {
                                                            i = 2;
                                                          }
                                                        }
                                                      case 2: 
                                                        clickAppMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                        return;
                                                      case 4: 
                                                        if (((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).b(this.frienduin) != null) {
                                                          break;
                                                        }
                                                        i = 2;
                                                        paramView = TroopInfoActivity.c(this.frienduin, 4);
                                                        paramView.putInt("t_s_f", 1001);
                                                        apuh.a(this.context, paramView, i);
                                                        return;
                                                      case 17: 
                                                        localObject2 = new Intent(this.context, PermisionPrivacyActivity.class);
                                                        if (this.message != null) {}
                                                        for (paramView = this.message.getExtInfoFromExtStr("scrollflag");; paramView = null)
                                                        {
                                                          if (!TextUtils.isEmpty(paramView))
                                                          {
                                                            ((Intent)localObject2).putExtra("scrollflag", paramView);
                                                            anot.a((QQAppInterface)this.mApp.get(), "P_CliOper", "invite_friend", "", "auto_pass", "clk_set_entry", 0, 0, this.frienduin, "", "", "");
                                                          }
                                                          this.context.startActivity((Intent)localObject2);
                                                          return;
                                                        }
                                                      case 5: 
                                                        paramView = (QQAppInterface)this.mApp.get();
                                                      }
                                                    } while ((this.context == null) || (paramView == null));
                                                    aldj.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                    return;
                                                    paramView = (QQAppInterface)this.mApp.get();
                                                  } while ((this.context == null) || (paramView == null));
                                                  aldj.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                  paramView = paramView.getCurrentAccountUin();
                                                  localObject2 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                                  if (localObject2 == null) {
                                                    break;
                                                  }
                                                  localObject2 = ((TroopManager)localObject2).b(this.frienduin);
                                                  if (localObject2 == null) {
                                                    break;
                                                  }
                                                  if (((TroopInfo)localObject2).isTroopOwner(paramView)) {}
                                                  for (paramView = "1";; paramView = "2")
                                                  {
                                                    aqfr.b("Grp_manage", "recall_msg", "clk_mberName", 0, 0, new String[] { this.frienduin, paramView });
                                                    return;
                                                  }
                                                } while (this.context == null);
                                                paramView = new Intent(this.context, EditInfoActivity.class);
                                                localObject2 = String.valueOf(this.item.uin);
                                                localObject3 = aqgv.r((QQAppInterface)this.mApp.get(), this.frienduin, (String)localObject2);
                                                paramView.putExtra("edit_type", 0);
                                                paramView.putExtra("troopUin", this.frienduin);
                                                paramView.putExtra("uin", (String)localObject2);
                                                paramView.putExtra("title", this.context.getResources().getString(2131699789));
                                                paramView.putExtra("isTroopNick", true);
                                                paramView.putExtra("default_text", (String)localObject3);
                                                paramView.putExtra("max_num", 60);
                                                paramView.putExtra("default_hint", acfp.m(2131708183));
                                                paramView.putExtra("auto_remark", true);
                                                this.context.startActivity(paramView);
                                                return;
                                                paramView = new TroopInfoData();
                                                paramView.troopUin = this.frienduin;
                                                localObject2 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                              } while (localObject2 == null);
                                              localObject2 = ((TroopManager)localObject2).b(this.frienduin);
                                              if (localObject2 != null)
                                              {
                                                paramView.updateForTroopChatSetting((TroopInfo)localObject2, this.context.getResources(), ((QQAppInterface)this.mApp.get()).getCurrentAccountUin());
                                                paramView.isMember = true;
                                              }
                                              new apzg((SplashActivity)this.context, paramView).a(paramView);
                                              return;
                                              if (QLog.isColorLevel()) {
                                                QLog.d("reactive", 2, "onclick graytip");
                                              }
                                              anot.a(null, "dc00898", "", "", "0X8007603", "0X8007603", 0, 0, "", "", "", "");
                                              paramView = new Intent(this.context, QQBrowserActivity.class);
                                              localObject2 = aelb.b().kj(this.frienduin);
                                              if (QLog.isColorLevel()) {
                                                QLog.d("MessageForGrayTips", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject2 }));
                                              }
                                              paramView.putExtra("url", (String)localObject2);
                                              paramView.putExtra("finish_animation_out_to_right", true);
                                              paramView.putExtra("is_wrap_content", true);
                                              paramView.putExtra("hide_left_button", false);
                                              if (this.context != null) {
                                                this.context.startActivity(paramView);
                                              }
                                              if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                              {
                                                paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                                if ((paramView != null) && (2097154 == paramView.dbK)) {
                                                  anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA7", 0, 0, "", "", "", "");
                                                }
                                                if (paramView != null) {
                                                  ajnk.c((QQAppInterface)localObject3, (MessageForUniteGrayTip)this.message, paramView.dbK);
                                                }
                                              }
                                            } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                            paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                          } while ((paramView == null) || (2097155 != paramView.dbK));
                                          anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A1BD", "0X800A1BD", 0, 0, "", "", "", "");
                                          return;
                                          if (QLog.isColorLevel()) {
                                            QLog.d("specialCare", 2, "onclick graytip");
                                          }
                                          paramView = new Intent(this.context, QQSpecialCareSettingActivity.class);
                                          paramView.putExtra("key_friend_uin", this.frienduin);
                                          paramView.putExtra("key_start_from", 1);
                                          if ((this.context instanceof BaseActivity)) {
                                            this.context.startActivity(paramView);
                                          }
                                          VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "Care", "CareTipClick", "", 1, 0, 0, null, this.item.mMsgActionData, null);
                                          return;
                                          paramView = new Intent(this.context, SelectMemberActivity.class);
                                          paramView.putExtra("param_groupcode", this.frienduin);
                                          paramView.putExtra("param_type", 1);
                                          paramView.putExtra("param_subtype", 1);
                                          paramView.putExtra("param_done_button_wording", this.context.getString(2131699515));
                                          paramView.putExtra("param_only_friends", true);
                                          paramView.putExtra("param_is_troop_admin", true);
                                          paramView.putExtra("param_title", this.context.getString(2131698293));
                                          paramView.putExtra("param_max", 100);
                                          this.context.startActivity(paramView);
                                          return;
                                          paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
                                        } while (paramView == null);
                                        localObject2 = new Intent(this.context, EditInfoActivity.class);
                                        ((Intent)localObject2).putExtra("edit_type", 2);
                                        ((Intent)localObject2).putExtra("title", acfp.m(2131708195));
                                        if (paramView.hasSetNewTroopName) {
                                          ((Intent)localObject2).putExtra("default_text", paramView.troopname);
                                        }
                                        ((Intent)localObject2).putExtra("max_num", 96);
                                        ((Intent)localObject2).putExtra("canPostNull", false);
                                        ((Activity)this.context).startActivityForResult((Intent)localObject2, 13010);
                                        return;
                                        apqz.cj(this.context, this.frienduin);
                                        aqfr.b("Grp_edu", "Grp_AIO", "graybar_showmore", 0, 0, new String[] { this.frienduin });
                                        return;
                                      } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                      paramView = (MessageForUniteGrayTip)this.message;
                                    } while (this.mApp == null);
                                    localObject2 = (ashy)((QQAppInterface)this.mApp.get()).getBusinessHandler(85);
                                  } while (localObject2 == null);
                                  ((ashy)localObject2).b(paramView.extUin, paramView.masterUin, paramView.taskId, paramView.uniseq, paramView.istroop);
                                  return;
                                  paramView = new Intent(this.context, EditActivity.class);
                                  paramView.putExtra("title", 2131694937).putExtra("current", this.item.remark).putExtra("action", 103).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("multiLine", false);
                                  if ((this.context instanceof BaseActivity)) {
                                    ((BaseActivity)this.context).startActivityForResult(paramView, 13008);
                                  }
                                  for (;;)
                                  {
                                    anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800797A", "0X800797A", 0, 0, "", "", "", "");
                                    if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                      break;
                                    }
                                    anot.a((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setRefTips_clk", 0, 0, "", "", "", "");
                                    return;
                                    this.context.startActivity(paramView);
                                  }
                                  paramView = new Intent(this.context, MoveToGroupActivity.class);
                                  i = this.item.groupId;
                                  if ((i != -1) && ((i != 0) || (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)))) {
                                    break label7712;
                                  }
                                  localObject2 = ((acff)((QQAppInterface)this.mApp.get()).getManager(51)).e(this.frienduin);
                                  if (localObject2 != null)
                                  {
                                    i = ((Friends)localObject2).groupid;
                                    paramView.putExtra("friendUin", this.frienduin).putExtra("mgid", (byte)i);
                                    if (!(this.context instanceof BaseActivity)) {
                                      break label3454;
                                    }
                                    ((BaseActivity)this.context).startActivityForResult(paramView, 13009);
                                  }
                                  for (;;)
                                  {
                                    anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X8007979", "0X8007979", 0, 0, "", "", "", "");
                                    if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                      break;
                                    }
                                    if (QLog.isDevelopLevel()) {
                                      QLog.i("MessageForGrayTips", 4, String.format(Locale.getDefault(), "ACTION_FRIEND_GROUP_SETTING gid: %s, groupId: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.item.groupId) }));
                                    }
                                    anot.a((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setGrpTips_clk", 0, 0, "", "", "", "");
                                    return;
                                    i = 0;
                                    break label3270;
                                    this.context.startActivity(paramView);
                                  }
                                  if ((this.message == null) || (this.message.msg == null)) {
                                    break;
                                  }
                                  paramView = this.message.msg.substring(this.item.start, this.item.end);
                                  localObject2 = this.item.mMsgActionData;
                                  localObject3 = this.item.mMsg_A_ActionData;
                                } while ((localObject2 == null) || (localObject3 == null) || (!(this.context instanceof FragmentActivity)));
                                localObject5 = ((FragmentActivity)this.context).getChatFragment();
                              } while ((localObject5 == null) || (((ChatFragment)localObject5).a() == null));
                              localObject5 = ((ChatFragment)localObject5).a();
                              ((BaseChatPie)localObject5).a.setText("");
                              localObject2 = appb.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, (String)localObject2, (String)localObject3, false, ((BaseChatPie)localObject5).a, true);
                              ((BaseChatPie)localObject5).a.setText((CharSequence)localObject2);
                              ((BaseChatPie)localObject5).a.append(paramView);
                              ((BaseChatPie)localObject5).a.setSelection(((BaseChatPie)localObject5).a.getText().length());
                              return;
                              for (;;)
                              {
                                try
                                {
                                  localObject3 = new JSONObject(this.item.mMsgActionData);
                                  paramView = ((JSONObject)localObject3).optString("uin");
                                  localObject2 = ((JSONObject)localObject3).optString("name");
                                  localObject3 = ((JSONObject)localObject3).optString("text");
                                  if ((paramView == null) || (localObject2 == null) || (!(this.context instanceof FragmentActivity))) {
                                    break;
                                  }
                                  localObject5 = ((FragmentActivity)this.context).getChatFragment();
                                  if ((localObject5 == null) || (((ChatFragment)localObject5).a() == null)) {
                                    break;
                                  }
                                  localObject5 = ((ChatFragment)localObject5).a();
                                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                                  {
                                    bool1 = true;
                                    paramView = appb.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, paramView, (String)localObject2, false, ((BaseChatPie)localObject5).a, true, bool1);
                                    ((BaseChatPie)localObject5).a.setText(paramView);
                                    ((BaseChatPie)localObject5).a.append((CharSequence)localObject3);
                                    ((BaseChatPie)localObject5).a.setSelection(((BaseChatPie)localObject5).a.getText().length());
                                    return;
                                  }
                                }
                                catch (JSONException paramView)
                                {
                                  paramView.printStackTrace();
                                  return;
                                }
                                bool1 = false;
                              }
                              qgg.b(this.context, this.item.mMsgActionData, "HightLight_Feed_Id", 1005);
                              rar.a("story_grp", "aio_grey", 0, 0, new String[] { "", "", "", "" });
                              return;
                              paramView = this.item.mMsgActionData;
                            } while (TextUtils.isEmpty(paramView));
                            for (;;)
                            {
                              try
                              {
                                l = Long.parseLong(paramView);
                                if (!(this.context instanceof FragmentActivity)) {
                                  break;
                                }
                                paramView = ((FragmentActivity)this.context).getChatFragment().a();
                                if (!paramView.OP()) {
                                  break;
                                }
                                paramView.a(10, l, 0, null);
                                EmojiStickerManager.a().bGd = 0;
                                if (this.message == null) {
                                  break;
                                }
                                paramView = "1";
                                if (this.message.istroop == 1)
                                {
                                  paramView = "2";
                                  VasWebviewUtil.reportCommercialDrainage("", "Stick", "ClickTip", paramView, 1, 0, 0, null, "", "");
                                  return;
                                }
                              }
                              catch (Exception paramView)
                              {
                                paramView = paramView;
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.e("MessageForGrayTips", 2, "", paramView);
                                return;
                              }
                              finally {}
                              if (this.message.istroop == 3000) {
                                paramView = "3";
                              }
                            }
                          } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                          paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                          i = apwn.eX(apwn.aG(paramView.bLT, 0));
                          paramView = apwn.aG(paramView.bLT, 1);
                          alui.a(this.context, (QQAppInterface)this.mApp.get(), this.item.mMsgActionData, this.item.mMsg_A_ActionData, i, paramView);
                          return;
                          localObject5 = this.frienduin;
                          i = this.message.istroop;
                          j = this.message.getConfessTopicId();
                          localObject6 = new ConfessInfo();
                          ((ConfessInfo)localObject6).parseFromJsonStr(this.message.getExtInfoFromExtStr("ext_key_confess_info"));
                        } while ((!(this.context instanceof FragmentActivity)) || (((FragmentActivity)this.context).isFinishing()) || (top.eD(i) != 1032));
                        localObject7 = ((FragmentActivity)this.context).getChatFragment().a();
                        localObject2 = null;
                        paramView = (View)localObject2;
                        if (localObject7 != null)
                        {
                          paramView = (View)localObject2;
                          if ((localObject7 instanceof xxt)) {
                            paramView = (xxt)localObject7;
                          }
                        }
                      } while (paramView == null);
                      paramView = aqha.a(this.context, 0, aegp.bwR, aegp.bwS, 2131721058, 2131721079, new aezs(this, (QQAppInterface)localObject3, (String)localObject5, i, j, (ConfessInfo)localObject6, paramView), new aezt(this));
                    } while (((FragmentActivity)this.context).isFinishing());
                    paramView.show();
                    return;
                  } while (!(this.context instanceof FragmentActivity));
                  paramView = ((FragmentActivity)this.context).getChatFragment();
                } while ((paramView == null) || (paramView.a() == null));
                paramView = paramView.a();
              } while (!(paramView instanceof xwq));
              ((xwq)paramView).yi(this.item.mMsgActionData);
              return;
              if (!BaseChatItemLayout.bdx) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("MessageForGrayTips", 2, "revoke msg multi msg select forward,return click");
            return;
          } while (!(this.context instanceof FragmentActivity));
          paramView = this.item.mMsgActionData;
          localObject3 = this.item.mMsg_A_ActionData;
          if (QLog.isColorLevel())
          {
            l = 0L;
            if (!TextUtils.isEmpty(paramView)) {
              l = paramView.length();
            }
            QLog.d("MessageForGrayTips", 2, new Object[] { "revoke msg click handle msg length =", Long.valueOf(l) });
          }
          localObject2 = ((FragmentActivity)this.context).getChatFragment();
        } while ((localObject2 == null) || (((ChatFragment)localObject2).a() == null));
        ahwb.an(this.message);
        localObject2 = ((ChatFragment)localObject2).a();
        if ((((BaseChatPie)localObject2).a != null) && (((BaseChatPie)localObject2).a.getEditableText() != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MessageForGrayTips", 2, "revoke msg clickspan chatpie input is null");
      return;
      ((BaseChatPie)localObject2).a.getEditableText().clear();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
      for (;;)
      {
        try
        {
          localObject3 = new JSONArray((String)localObject3);
          if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "revoke msg clickspan handle at info is null");
          }
          ((BaseChatPie)localObject2).a.setText(paramView);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MessageForGrayTips", 2, "revoke msg clickspan json exception,input only text String", localJSONException);
          ((BaseChatPie)localObject2).a.setText(paramView);
          continue;
          j = 0;
        }
        j = ((BaseChatPie)localObject2).a.getText().length();
        i = j;
        if (j < 0) {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "revoke msg click handle input length =" + i);
        }
        ((BaseChatPie)localObject2).aLz = "";
        ((BaseChatPie)localObject2).a.setSelection(i);
        ((BaseChatPie)localObject2).aey();
        return;
        i = 0;
        if (i < ((JSONArray)localObject3).length())
        {
          localObject5 = ((JSONArray)localObject3).getJSONObject(i);
          localObject6 = ((JSONObject)localObject5).optString(anbb.ccT);
          int n = ((JSONObject)localObject5).optInt(anbb.ccU);
          localObject5 = new JSONArray((String)localObject6);
          if ((localObject5 != null) && (((JSONArray)localObject5).length() == 0))
          {
            ((BaseChatPie)localObject2).a.setText(paramView);
          }
          else
          {
            label4821:
            if (j < ((JSONArray)localObject5).length())
            {
              localObject6 = ((JSONArray)localObject5).getJSONObject(j);
              int i1 = ((JSONObject)localObject6).optInt("startPos");
              int k = ((JSONObject)localObject6).optInt("textLen");
              ((JSONObject)localObject6).optInt("flag");
              localObject6 = ((JSONObject)localObject6).optString("uin");
              localObject7 = paramView.substring(i1 + 1, k + i1);
              int m = ((BaseChatPie)localObject2).a.getSelectionEnd();
              k = m;
              if (m < 0) {
                k = 0;
              }
              Object localObject8 = paramView.substring(k, i1);
              ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject8);
              localObject8 = (QQAppInterface)this.mApp.get();
              Context localContext = this.context;
              String str = this.frienduin;
              XEditTextEx localXEditTextEx = ((BaseChatPie)localObject2).a;
              if (n != 1) {
                break label7733;
              }
              bool1 = true;
              label4982:
              localObject6 = appb.a((QQAppInterface)localObject8, localContext, str, (String)localObject6, (String)localObject7, false, localXEditTextEx, bool1);
              if ((localObject6 == null) || (((SpannableString)localObject6).length() == 0)) {
                break;
              }
              m = ((BaseChatPie)localObject2).a.getSelectionEnd();
              k = m;
              if (m < 0) {
                k = 0;
              }
              ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject6);
              if (j != ((JSONArray)localObject5).length() - 1) {
                break;
              }
              m = ((BaseChatPie)localObject2).a.getSelectionEnd();
              k = m;
              if (m < 0) {
                k = 0;
              }
              if (k > paramView.length() - 1) {
                break;
              }
              localObject6 = paramView.substring(k, paramView.length());
              ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject6);
              break;
            }
            i += 1;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("MessageForGrayTips", 2, "revoke msg click handle at info is empty");
            }
            ((BaseChatPie)localObject2).a.setText(paramView);
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!(this.message instanceof MessageForUniteGrayTip)) {
              break label7701;
            }
            paramView = (MessageForUniteGrayTip)this.message;
            if (paramView.istroop != 0) {
              continue;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              continue;
            }
            i = 1;
            anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
          }
          catch (RuntimeException paramView)
          {
            boolean bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("MessageForGrayTips", 1, "0X800A613", paramView);
            continue;
          }
          ujt.a(this.context, localJSONException, (ChatMessage)this.message);
          return;
          i = 2;
          continue;
          if (paramView.istroop == 1)
          {
            bool1 = apuh.f(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
            bool2 = apuh.g(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
            localObject2 = paramView.tipParam.wording;
            localObject5 = acfp.m(2131708187) + localJSONException.getApp().getString(2131699921);
            if (bool1)
            {
              if (((String)localObject2).startsWith((String)localObject5))
              {
                i = 3;
                break label7739;
              }
              if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
                break label7742;
              }
              i = 4;
              break label7739;
            }
            if (bool2)
            {
              if (((String)localObject2).startsWith((String)localObject5))
              {
                i = 5;
                break label7739;
              }
              if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
                break label7748;
              }
              i = 6;
              break label7739;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7754;
            }
            i = 7;
            break label7739;
          }
          if (paramView.istroop == 3000)
          {
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7760;
            }
            i = 9;
          }
          else
          {
            bool1 = paramView.senderuin.equals(localJSONException.getCurrentAccountUin());
            if (bool1)
            {
              i = 11;
            }
            else
            {
              i = 12;
              continue;
              if ((!(this.context instanceof ChatActivity)) && (!(this.context instanceof SplashActivity))) {
                break;
              }
              paramView = (FragmentActivity)this.context;
              if ((paramView.getChatFragment() != null) && (paramView.getChatFragment().a() != null) && ((this.message instanceof ChatMessage)))
              {
                paramView.getChatFragment().a().a((ChatMessage)this.message);
                ((apdr)localJSONException.getManager(231)).SK(this.item.mMsgActionData);
                if (QLog.isColorLevel()) {
                  QLog.d("TroopEnterEffect", 2, "click nolongerPrompt id = " + this.item.mMsgActionData);
                }
              }
              if ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
                break;
              }
              paramView = ((MessageForUniteGrayTip)this.message).tipParam;
              if (paramView == null) {
                break;
              }
              switch (paramView.dbK)
              {
              default: 
                return;
              }
              VasWebviewUtil.reportCommercialDrainage(localJSONException.getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "3");
              return;
              if (this.context != null) {
                aqrf.o(this.item.mMsgActionData, this.context);
              }
              if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
                break;
              }
              paramView = ((MessageForUniteGrayTip)this.message).tipParam;
              if (paramView == null) {
                break;
              }
              switch (paramView.dbK)
              {
              default: 
                return;
              }
              VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "1");
              return;
              if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
                break;
              }
              aiwk.a((QQAppInterface)this.mApp.get(), this.context, 2080, "6");
              return;
              if (aobw.qH()) {
                break;
              }
              try
              {
                paramView = String.valueOf(this.item.uin);
                localObject2 = this.item.mMsg_A_ActionData;
                localObject4 = this.item.mMsgActionData.split("@#@");
                localObject5 = localObject4[0];
                l = Long.parseLong(localObject4[1]);
                i = this.message.istroop;
                localObject2 = aobw.a((String)localObject5, paramView, (String)localObject2);
                QLog.i("MessageForGrayTips" + aoaf.cjv, 1, "click to modify tencent docs auth. frienduin = " + paramView + ", uinType = " + i + ", msgSeq = " + l + ", docsGrayTipsInfo = " + localObject2);
                if (localObject2 == null) {
                  break;
                }
                if (((DocsGrayTipsInfo)localObject2).ciZ.equals(aoaf.cjx))
                {
                  paramView = ((DocsGrayTipsInfo)localObject2).cja;
                  if (TextUtils.isEmpty(paramView)) {
                    break;
                  }
                  aobw.ag(this.context, paramView);
                  anot.a(null, "dc00898", "", "", "0X8009C79", "0X8009C79", 0, 0, "", "", "", "");
                  return;
                }
              }
              catch (Exception paramView)
              {
                QLog.e("MessageForGrayTips" + aoaf.cjv, 1, " docs gray tips action exception =" + paramView.toString());
                return;
              }
            }
          }
        }
        paramView = (aobh)((QQAppInterface)this.mApp.get()).getBusinessHandler(122);
        if (i == 1)
        {
          paramView.b((DocsGrayTipsInfo)localObject2, l);
          return;
        }
        paramView.a((DocsGrayTipsInfo)localObject2, l);
        return;
        Object localObject4 = (QQAppInterface)this.mApp.get();
        if ((localObject4 == null) || (!aegp.i((AppInterface)localObject4))) {
          break;
        }
        if (this.message.isSelfConfessor()) {
          paramView = ((QQAppInterface)localObject4).getAccount();
        }
        for (localObject2 = this.message.frienduin;; localObject2 = ((QQAppInterface)localObject4).getAccount())
        {
          aegp.b((QQAppInterface)localObject4, aegu.g(this.message.frienduin, this.message.istroop, this.message.getConfessTopicId()), false);
          localObject5 = (aegq)((QQAppInterface)localObject4).getBusinessHandler(125);
          if (localObject5 != null) {
            ((aegq)localObject5).notifyUI(9, true, new Object[] { this.message.frienduin, Integer.valueOf(this.message.getConfessTopicId()), Integer.valueOf(this.message.istroop) });
          }
          aegp.a((AppInterface)localObject4, this.context, paramView, (String)localObject2, this.message.getConfessTopicId(), this.message.isSelfConfessor());
          anot.a((QQAppInterface)localObject4, "dc00898", "", "", "0X8009574", "0X8009574", 0, 0, this.message.getConfessTopicId() + "", "", paramView, (String)localObject2);
          return;
          paramView = this.message.frienduin;
        }
        i = this.message.istroop;
        if ((i != 1044) && (i != 1045)) {
          break;
        }
        aine.n(this.context, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
        return;
        if (this.context == null) {
          break;
        }
        PublicFragmentActivity.start(this.context, TempMsgSettingFragment.class);
        j = 0;
        try
        {
          i = Integer.parseInt(this.item.mMsgActionData);
          anot.a(null, "dc00898", "", "", "0X800997A", "0X800997A", i, i, "", "", "", "");
          return;
        }
        catch (NumberFormatException paramView)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
              i = j;
            }
          }
        }
        paramView = TroopInfoActivity.c(this.item.mMsgActionData, 2);
        paramView.putInt("t_s_f", 1000);
        apuh.a(this.context, paramView, 2);
        anot.a(null, "dc00898", "", "", "0X800997B", "0X800997B", 0, 0, "", "", "", "");
        return;
        if (acsv.bKj) {
          this.context.startActivity(acsv.Y);
        }
        for (;;)
        {
          try
          {
            i = Integer.parseInt(this.item.mMsgActionData);
            anot.a(null, "dc00898", "", "", "0X8009AD0", "0X8009AD0", i, i, "", "", "", "");
            return;
          }
          catch (NumberFormatException paramView) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
          return;
          if (this.mApp != null) {
            ThreadManager.executeOnSubThread(new MessageForGrayTips.HightlightClickableSpan.3(this));
          } else if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "ACTION_FROM_MESSAGE_GOTO_PUSH_NOTIFICATION_SWITCH_SETTING= mApp==null");
          }
        }
        paramView = new Intent(this.context, AssistantSettingActivity.class);
        this.context.startActivity(paramView);
        return;
        paramView = this.item.mMsg_A_ActionData;
        localObject2 = this.item.mMsgActionData;
        if ((!TextUtils.isEmpty(paramView)) && (paramView.contains("docs.qq.com/form"))) {
          aobw.l(this.context, paramView, (String)localObject2);
        }
        for (;;)
        {
          anot.a(null, "dc00898", "", this.frienduin, "0X8009FD1", "0X8009FD1", 0, 0, "", "", "", "");
          return;
          if (aobw.pN(paramView)) {
            MiniAppLauncher.startMiniApp(this.context, paramView, 0, null);
          }
        }
        if ((this.context instanceof FragmentActivity))
        {
          paramView = ((FragmentActivity)this.context).getChatFragment();
          if ((paramView != null) && (paramView.a() != null))
          {
            paramView = paramView.a();
            if ((paramView instanceof xys)) {
              ((xys)paramView).cgk();
            }
          }
        }
        anot.a((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A013", "0X800A013", 0, 0, "", "", "", "");
        return;
        paramView = new ProfileActivity.AllInOne(this.item.mMsgActionData, 1);
        ProfileActivity.b(this.context, paramView);
        return;
        showDeleteDialog((QQAppInterface)this.mApp.get());
        return;
        if (this.message == null) {
          break;
        }
        if (this.message.istroop == 1)
        {
          aiob.a((QQAppInterface)localObject4, this.context, 1, this.frienduin, 0);
          return;
        }
        if (this.message.istroop != 0) {
          break;
        }
        aiob.a((QQAppInterface)this.mApp.get(), this.context, 2, this.frienduin, 0);
        return;
        if (!(this.context instanceof FragmentActivity)) {
          break;
        }
        paramView = ((FragmentActivity)this.context).getChatFragment();
        if ((paramView == null) || (paramView.a() == null) || (!(paramView.a() instanceof TroopChatPie))) {
          break;
        }
        paramView = (TroopChatPie)paramView.a();
        localObject2 = paramView.oL();
        if ((TextUtils.isEmpty(this.frienduin)) || (!this.frienduin.equals(localObject2)) || (!(this.message instanceof ChatMessage))) {
          break;
        }
        ((wwz)paramView.a(41)).CW(1);
        ((TroopManager)((QQAppInterface)localObject4).getManager(52)).a().a((QQAppInterface)localObject4, this.context, paramView.a, this.frienduin, 0, (ChatMessage)this.message);
        xqh.bWm = 3;
        xqh.aVU = this.message.senderuin;
        new anov((QQAppInterface)localObject4).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_bar").a(new String[] { localObject2, "", "" + apuh.o((QQAppInterface)localObject4, (String)localObject2) }).report();
        return;
        paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
        localObject2 = new ArrayList(Arrays.asList(this.item.mMsgActionData.split(",")));
        LpReportInfo_pf00064.allReport(40, 3, 2);
        avpw.a((Activity)this.context, ((QQAppInterface)localObject4).getCurrentUin(), 1, 0, Long.parseLong(this.frienduin), paramView.troopname, "$RecentAlbumId", aqfx.ALBUM_NAME, (ArrayList)localObject2, -1, 0, 3);
        return;
        i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_cool_down", 24);
        paramView = String.format(acfp.m(2131721372), new Object[] { Integer.valueOf(i) });
        QQToast.a(BaseApplication.getContext(), 0, paramView, 0).show();
        l = System.currentTimeMillis() / 1000L;
        LocalMultiProcConfig.putLong4Uin("aio_qzone_troop_gray_tips", i * 60 * 60 + l, this.item.uin);
        ujt.a(this.context, (QQAppInterface)localObject4, (ChatMessage)this.message);
        LpReportInfo_pf00064.allReport(40, 3, 3);
        return;
        apuh.c((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsg_A_ActionData, this.item.mMsgActionData);
        return;
        apuh.a((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
        return;
        apuh.b((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
        return;
        label7701:
        i = -1;
        continue;
        paramView = "";
        break label3507;
        label7712:
        break label3270;
        paramView = "";
        break label1878;
        i = 1;
        break label1563;
        j += 1;
        break label4821;
        label7733:
        bool1 = false;
        break label4982;
        for (;;)
        {
          label7739:
          break;
          label7742:
          i = 8;
          continue;
          label7748:
          i = 8;
          continue;
          label7754:
          i = 8;
        }
        label7760:
        i = 10;
      }
    }
    
    protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      if (TextUtils.isEmpty(paramString2)) {
        if (!TextUtils.isEmpty(paramString1)) {
          break label52;
        }
      }
      label52:
      for (int i = -1;; i = paramString1.indexOf("://"))
      {
        if (i != -1) {
          break label63;
        }
        arrayOfString[0] = paramString1;
        return arrayOfString;
        paramString1 = paramString2;
        break;
      }
      label63:
      arrayOfString[0] = paramString1.substring(0, i);
      arrayOfString[1] = paramString1.substring(i + 3);
      return arrayOfString;
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      if (this.color == -1) {
        paramTextPaint.setColor(paramTextPaint.linkColor);
      }
      for (;;)
      {
        paramTextPaint.setUnderlineText(false);
        return;
        paramTextPaint.setColor(this.color);
      }
    }
  }
  
  public static class HightlightItem
  {
    public int actionType;
    public int end;
    public int groupId;
    public String icon;
    public String iconAlt;
    private int iconSize = aqnm.dpToPx(16.0F);
    public String mMsgActionData;
    public String mMsg_A_ActionData;
    public boolean needUpdateNick;
    public String remark;
    public int start;
    public int textColor;
    public long uin;
    
    HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.uin = paramLong;
      if (paramInt3 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.needUpdateNick = bool;
        this.actionType = paramInt4;
        this.mMsgActionData = paramString1;
        this.mMsg_A_ActionData = paramString2;
        return;
      }
    }
    
    public HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5)
    {
      this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2);
      this.icon = paramString3;
      this.iconAlt = paramString4;
      this.textColor = paramInt5;
    }
    
    public HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, String paramString5, int paramInt6)
    {
      this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramString4, paramInt5);
      this.remark = paramString5;
      this.groupId = paramInt6;
    }
    
    public int getIconSize()
    {
      return this.iconSize;
    }
  }
  
  static class a
    extends ImageSpan
  {
    public String imageUrl;
    private Context mContext;
    private int size;
    
    public a(Context paramContext, int paramInt, String paramString)
    {
      super(paramInt, 1);
      this.mContext = paramContext;
      this.imageUrl = paramString;
    }
    
    public a(Context paramContext, int paramInt1, String paramString, int paramInt2)
    {
      super(paramInt1, 1);
      this.mContext = paramContext;
      this.imageUrl = paramString;
      this.size = paramInt2;
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      if (paramCharSequence == null) {
        return;
      }
      if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
      }
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public Drawable getDrawable()
    {
      if (this.imageUrl != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.size > 0)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.size;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.size;
        }
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.imageUrl, (URLDrawable.URLDrawableOptions)localObject);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("UrlCenterImageSpan.getDrawable. url:").append(this.imageUrl).append(" drawable:");
          if (localURLDrawable == null) {
            break label117;
          }
        }
        label117:
        for (localObject = localURLDrawable.getIntrinsicWidth() + "";; localObject = null)
        {
          QLog.e(".troop.send_gift", 2, (String)localObject);
          return localURLDrawable;
        }
      }
      return super.getDrawable();
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      paramCharSequence = getDrawable();
      if (paramCharSequence == null) {
        return 0;
      }
      if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
      }
      paramCharSequence = paramCharSequence.getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramInt2 = paramPaint.bottom - paramPaint.top;
        int i = paramCharSequence.bottom - paramCharSequence.top;
        paramInt1 = i / 2 - paramInt2 / 4;
        i /= 2;
        paramInt2 = paramInt2 / 4 + i;
        paramFontMetricsInt.ascent = (-paramInt2);
        paramFontMetricsInt.top = (-paramInt2);
        paramFontMetricsInt.bottom = paramInt1;
        paramFontMetricsInt.descent = paramInt1;
      }
      return paramCharSequence.right;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */