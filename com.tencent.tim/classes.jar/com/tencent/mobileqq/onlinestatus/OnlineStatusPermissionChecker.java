package com.tencent.mobileqq.onlinestatus;

import akts;
import aktt;
import aktu;
import aktv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.widget.TextView;
import anot;
import aofk;
import aqha;
import aqju;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class OnlineStatusPermissionChecker
{
  public static aqju a(QQAppInterface paramQQAppInterface, Activity paramActivity, OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    aqju localaqju = aqha.a(paramActivity, 230, paramOnlineStatusPermissionItem.permissionTitle, "", 2131721058, 2131721079, new akts(), new aktt());
    String str1 = paramOnlineStatusPermissionItem.permissionContent;
    String str2;
    if (OnlineStatusPermissionItem.access$200(paramOnlineStatusPermissionItem)) {
      str2 = str1 + "\n点击可修改为部分好友可见>";
    }
    for (str1 = "部分好友可见>";; str1 = "全部好友可见>")
    {
      SpannableString localSpannableString = new SpannableString(str2);
      paramQQAppInterface = new aktu(paramOnlineStatusPermissionItem, localaqju, paramActivity, paramQQAppInterface);
      localSpannableString.setSpan(paramQQAppInterface, str2.length() - str1.length(), str2.length(), 33);
      localaqju.setMessageWithoutAutoLink(new aofk(localSpannableString, 3, 16));
      if (AppSetting.enableTalkBack) {
        localaqju.getMessageTextView().setAccessibilityDelegate(new aktv(paramQQAppInterface));
      }
      return localaqju;
      str2 = str1 + "\n点击可修改为全部好友可见>";
    }
  }
  
  public static OnlineStatusPermissionItem a(Intent paramIntent, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      paramIntent = null;
    }
    label177:
    do
    {
      return paramIntent;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error responseCode=", Integer.valueOf(paramInt), " data=", paramIntent });
      }
      if (paramInt == -1) {}
      for (paramQQAppInterface = "0X800AE77";; paramQQAppInterface = "0X800AE78")
      {
        anot.a(null, "dc00898", "", "", paramQQAppInterface, paramQQAppInterface, 0, 0, "", "", "", "");
        if ((paramInt == -1) && (paramIntent != null)) {
          break;
        }
        return null;
      }
      paramQQAppInterface = (OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
      Object localObject = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramQQAppInterface == null) || (localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        if (QLog.isColorLevel()) {
          if (localObject != null) {
            break label177;
          }
        }
        for (paramInt = 0;; paramInt = ((ArrayList)localObject).size())
        {
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param is error onlineItem=", paramQQAppInterface, " friendlistSize=", Integer.valueOf(paramInt) });
          return null;
        }
      }
      paramIntent = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        paramIntent.add(Long.valueOf(localResultRecord.uin));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "onActivityResult param uin=", localResultRecord.uin });
        }
      }
      OnlineStatusPermissionItem.access$202(paramQQAppInterface, false);
      OnlineStatusPermissionItem.access$402(paramQQAppInterface, paramIntent);
      paramIntent = paramQQAppInterface;
    } while (!paramBoolean);
    a(paramContext, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.online);
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", OnlineStatusPermissionItem.access$300(paramOnlineStatusPermissionItem));
    PublicFragmentActivity.start(paramContext, localIntent, AccountOnlineStateActivity.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, OnlineStatusPermissionItem paramOnlineStatusPermissionItem, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramOnlineStatusPermissionItem.permissionUins.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      ResultRecord localResultRecord = new ResultRecord();
      localResultRecord.uin = String.valueOf(localLong);
      localArrayList.add(SelectMemberActivity.a(localResultRecord.uin, "", 0, "-1"));
    }
    localObject = new Intent(paramActivity, SelectMemberActivity.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("param_only_friends", true);
    ((Intent)localObject).putExtra("param_selected_records_for_create_discussion", localArrayList);
    ((Intent)localObject).putExtra("param_entrance", 40);
    ((Intent)localObject).putExtra("param_add_passed_members_to_result_set", true);
    ((Intent)localObject).putExtra("param_max", 1000);
    ((Intent)localObject).putExtra("param_title", paramActivity.getString(2131700557));
    ((Intent)localObject).putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    ((Intent)localObject).putExtra("param_done_button_wording", paramActivity.getString(2131700558));
    ((Intent)localObject).putExtra("param_done_button_highlight_wording", paramActivity.getString(2131700559));
    paramOnlineStatusPermissionItem = new ArrayList(1);
    ((Intent)localObject).putStringArrayListExtra("param_uins_hide", paramOnlineStatusPermissionItem);
    ((Intent)localObject).putExtra("filer_robot", true);
    paramOnlineStatusPermissionItem.add(paramQQAppInterface.getCurrentAccountUin());
    paramActivity.startActivityForResult((Intent)localObject, 100);
    if (paramBoolean) {
      paramActivity.overridePendingTransition(2130771991, 2130771992);
    }
  }
  
  public static class OnlineStatusPermissionItem
    implements Serializable
  {
    private boolean allHasPermission;
    private String location;
    private long onlineStateType;
    private String permissionContent;
    private String permissionTitle;
    private List<Long> permissionUins;
    
    private OnlineStatusPermissionItem(long paramLong, boolean paramBoolean)
    {
      this.onlineStateType = paramLong;
      this.allHasPermission = paramBoolean;
    }
    
    private static OnlineStatusPermissionItem a(OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
    {
      if (paramOnlineStatusPermissionItem.onlineStateType == -1L) {
        a(paramOnlineStatusPermissionItem);
      }
      return paramOnlineStatusPermissionItem;
    }
    
    private static void a(OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
    {
      paramOnlineStatusPermissionItem.permissionTitle = "确定切换为“我的位置”吗?";
      if (paramOnlineStatusPermissionItem.allHasPermission)
      {
        paramOnlineStatusPermissionItem.permissionContent = "切换后，系统将自动更新你的位置并展示给全部好友。";
        return;
      }
      paramOnlineStatusPermissionItem.permissionContent = "切换后，系统将自动更新你的位置并展示给你指定的好友。";
    }
    
    public static OnlineStatusPermissionItem create(long paramLong, boolean paramBoolean, @NonNull List<Long> paramList)
    {
      OnlineStatusPermissionItem localOnlineStatusPermissionItem = new OnlineStatusPermissionItem(paramLong, paramBoolean);
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      localOnlineStatusPermissionItem.permissionUins = ((List)localObject);
      a(localOnlineStatusPermissionItem);
      return localOnlineStatusPermissionItem;
    }
    
    public String getLocation()
    {
      return this.location;
    }
    
    public long getOnlineStateType()
    {
      return this.onlineStateType;
    }
    
    public List<Long> getPermissionUins()
    {
      return this.permissionUins;
    }
    
    public boolean isAllHasPermission()
    {
      return this.allHasPermission;
    }
    
    public void setLocation(String paramString)
    {
      this.location = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker
 * JD-Core Version:    0.7.0.1
 */