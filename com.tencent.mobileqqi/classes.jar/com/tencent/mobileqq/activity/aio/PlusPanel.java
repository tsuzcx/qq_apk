package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import ebo;
import ebp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PlusPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final String a = "200002";
  private static final int[] l = { 2131562180, 2130838353 };
  private long jdField_a_of_type_Long = -1L;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private PanelAdapter2 jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131562612, 2130837777 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_secretfile", "chat_tool_audio", "chat_tool_gaudio", "chat_tool_qlink_file" };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.b };
  private final int[] b = { 2131561737, 2130837772 };
  private final int[] c = { 2131563172, 2130837781 };
  private final int[] d = { 2131563189, 2130837771 };
  private final int[] e = { 2131561855, 2130837771 };
  private final int[] f = { 2131562304, 2130837773 };
  private final int[] g = { 2131562174, 2130837775 };
  private final int[] h = { 2131562109, 2130837779 };
  private final int[] i = { 2131561665, 2130837779 };
  private final int[] j = { 2131562179, 2130837776 };
  private final int[] k = { 2131562900, 2130837780 };
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("mobileQQi", 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  private void c()
  {
    int m = 0;
    while (m < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ArrayOfJavaLangString[m], Boolean.valueOf(a(this.jdField_a_of_type_ArrayOfJavaLangString[m])));
      m += 1;
    }
  }
  
  private void d()
  {
    ThridAppShareHelper.a().b();
    if (ThridAppShareHelper.a().a("200002")) {}
  }
  
  public void a()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(this.jdField_a_of_type_Array2dOfInt));
    Object localObject;
    label138:
    int[] arrayOfInt;
    PlusPanel.PluginData localPluginData;
    int n;
    if (m == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
      d();
      if (VideoController.b() == 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.d);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.e);
      }
      localObject = new ArrayList();
      m = 0;
      if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label1409;
      }
      arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(m);
      localPluginData = new PlusPanel.PluginData();
      localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getDrawable(arrayOfInt[1]);
      localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
      localPluginData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(arrayOfInt[0]);
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localGameCenterManagerImp != null)
      {
        if (localGameCenterManagerImp.a("999999.100004") == -1) {
          break label1267;
        }
        n = 1;
      }
      label250:
      if ((arrayOfInt != this.d) || (!a("chat_tool_audio"))) {
        break label1272;
      }
      localPluginData.jdField_a_of_type_Boolean = true;
      label274:
      if (arrayOfInt != this.c) {
        break label1308;
      }
      localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(2131560180);
    }
    for (;;)
    {
      ((ArrayList)localObject).add(localPluginData);
      m += 1;
      break label138;
      if (m == 1)
      {
        localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject != null) && (((FriendManager)localObject).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        d();
        break;
      }
      if ((m == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.k);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {}
        for (;;)
        {
          d();
          break;
          if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.c);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.h);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.f);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.k);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.g);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
          }
        }
      }
      if ((m == 1000) || (m == 1004) || (m == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if ((m == 1009) || (m == 1008) || (m == 1023) || (m == 1024))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 1001)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 1021)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (m == 1022)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (m == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
      break;
      label1267:
      n = 0;
      break label250;
      label1272:
      if ((arrayOfInt == this.e) && (a("chat_tool_gaudio")))
      {
        localPluginData.jdField_a_of_type_Boolean = true;
        break label274;
      }
      localPluginData.jdField_a_of_type_Boolean = false;
      break label274;
      label1308:
      if (arrayOfInt == this.e) {
        localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(2131560162);
      } else if (arrayOfInt == this.d) {
        localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(2131560148);
      } else if (arrayOfInt == this.k) {
        localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(2131558930);
      } else {
        localPluginData.b = "";
      }
    }
    label1409:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2.a((ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2.notifyDataSetChanged();
    post(new ebo(this));
  }
  
  public void a(ChatActivity paramChatActivity, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramChatActivity.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2 = new PanelAdapter2(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2.a(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131231108));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2 = new PanelAdapter2(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2.a(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2);
    paramChatActivity = getResources().getDrawable(2130840136);
    if ((paramChatActivity instanceof BitmapDrawable)) {
      paramChatActivity = ((BitmapDrawable)paramChatActivity).getBitmap();
    }
    for (;;)
    {
      paramChatActivity = new BitmapDrawable(paramChatActivity);
      if (paramChatActivity != null)
      {
        paramChatActivity.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramChatActivity.setDither(true);
        setBackgroundDrawable(paramChatActivity);
      }
      for (;;)
      {
        a();
        return;
        if (!(paramChatActivity instanceof SkinnableBitmapDrawable)) {
          break label190;
        }
        paramChatActivity = ((SkinnableBitmapDrawable)paramChatActivity).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "PlusPanle background is null:");
        }
      }
      label190:
      paramChatActivity = null;
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("mobileQQi", 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter2.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      }
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void onClick(View paramView)
  {
    int m;
    switch (((PanelAdapter2.ViewHolder)paramView.getTag()).jdField_a_of_type_Int)
    {
    default: 
    case 2130837772: 
    case 2130837777: 
    case 2130837773: 
    case 2130837775: 
    case 2130837781: 
    case 2130837771: 
      long l1;
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.w();
          }
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 1);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.w();
          }
          paramView = ScreenShot.a();
          if (paramView != null)
          {
            ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
            String[] arrayOfString = getResources().getStringArray(2131689480);
            int n = arrayOfString.length;
            m = 0;
            while (m < n)
            {
              localActionSheet.c(arrayOfString[m]);
              m += 1;
            }
            localActionSheet.d(2131561746);
            localActionSheet.a(new ebp(this, paramView, localActionSheet));
            localActionSheet.show();
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
            return;
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
            }
          }
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004082", "0X8004082", 0, 0, "", "", "", "");
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, false, null, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.w();
        }
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.t();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        a("chat_tool_gaudio");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.t();
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
        }
        l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == l1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
      return;
      a("chat_tool_audio");
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.t();
      b();
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407B", "0X800407B", 0, 0, "", "", "", "");
      return;
    case 2130837779: 
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
          PlusPanelUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.jdField_a_of_type_JavaLangString = "send_file";
          paramView.jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131562497, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getDimensionPixelSize(2131427376));
      return;
    case 2130837780: 
      m = 1;
      if (this.jdField_a_of_type_Long == -1L)
      {
        if (m == 0) {
          break label1106;
        }
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004081", "0X8004081", 0, 0, "", "", "", "");
        return;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 10000L) {
          break;
        }
        m = 0;
        break;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getString(2131558931), 0).a();
      }
    case 2130837778: 
      label1106:
      a("chat_tool_remind");
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.e(false);
      }
      b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004080", "0X8004080", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Bundle();
    paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramView.putBoolean("hide_operation_bar", true);
    paramView.putBoolean("hide_more_button", true);
    paramView.putBoolean("isScreenOrientationPortrait", true);
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */