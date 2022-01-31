package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopProxyActivity;
import eql;
import eqm;
import eqo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  long a;
  public Context a;
  public Drawable a;
  public SessionInfo a;
  public QQAppInterface a;
  public TroopFeedsDataManager a;
  public eql a;
  protected HashMap a;
  public boolean a;
  public Drawable b;
  public boolean b;
  int c;
  public Drawable c;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Eql = new eql(this, null);
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 1000;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramTroopFeedsDataManager;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    int i = a(paramTroopFeedItem.type);
    TroopFeedViewFactory.ViewProvider localViewProvider2 = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    TroopFeedViewFactory.ViewProvider localViewProvider1 = localViewProvider2;
    if (localViewProvider2 == null)
    {
      localViewProvider1 = a(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localViewProvider1);
    }
    if (localViewProvider1 != null) {
      return localViewProvider1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected TroopFeedViewFactory.ViewProvider a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new eqm(this);
    case 0: 
      return new eqm(this);
    }
    return new eqo(this);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    TroopFeedViewFactory.ViewHolder localViewHolder;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localViewHolder = (TroopFeedViewFactory.ViewHolder)paramView.getTag();
        } while (localViewHolder == null);
        localObject = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
      } while (localObject == null);
      int i = a(((TroopFeedItem)localObject).type);
      localObject = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    } while (localObject == null);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
    ((TroopFeedViewFactory.ViewProvider)localObject).a(paramView);
  }
  
  protected void a(TroopFeedItem paramTroopFeedItem)
  {
    if ((paramTroopFeedItem == null) || (!paramTroopFeedItem.isVaild())) {}
    Activity localActivity;
    Intent localIntent;
    Object localObject;
    do
    {
      do
      {
        return;
        localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
        localIntent = new Intent();
        localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), null, paramTroopFeedItem.linkUrl, paramTroopFeedItem.title, Long.parseLong(paramTroopFeedItem.ex_1), Integer.parseInt(paramTroopFeedItem.content));
      } while (localObject == null);
      switch (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        localIntent.putExtra(TroopProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        TroopProxyActivity.b(localActivity, localIntent);
        return;
      case 6: 
      case 11: 
        paramTroopFeedItem = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
    } while ((paramTroopFeedItem == null) || (localObject == null));
    if (!FileUtil.a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      paramTroopFeedItem.b();
      return;
    }
    localIntent.setClass(localActivity, FileBrowserActivity.class);
    paramTroopFeedItem = new FileInfo();
    paramTroopFeedItem.d(((TroopFileStatusInfo)localObject).e);
    paramTroopFeedItem.e(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString);
    paramTroopFeedItem.a(((TroopFileStatusInfo)localObject).jdField_b_of_type_Long);
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a((TroopFileStatusInfo)localObject);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.c(4);
    localForwardFileInfo.a(10006);
    localForwardFileInfo.a(paramTroopFeedItem.d());
    localForwardFileInfo.d(paramTroopFeedItem.e());
    localForwardFileInfo.d(paramTroopFeedItem.a());
    localForwardFileInfo.a(((TroopFileStatusInfo)localObject).jdField_a_of_type_Long);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramTroopFeedItem);
      FMDataCache.a((ArrayList)localObject);
      localIntent.putExtra("clicked_file_hashcode", paramTroopFeedItem.hashCode());
    }
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    localActivity.startActivityForResult(localIntent, 102);
    return;
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    try
    {
      localIntent.putExtra("fileSize", Long.parseLong(paramTroopFeedItem.ex_1));
      localIntent.putExtra("fileName", paramTroopFeedItem.title);
      localIntent.putExtra("Url", paramTroopFeedItem.linkUrl);
      localIntent.putExtra("bisID", Integer.parseInt(paramTroopFeedItem.content));
      TroopProxyActivity.b(localActivity, localIntent, 5001);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localIntent.putExtra("fileSize", 0);
      }
    }
    TroopFileError.a(localActivity, String.format(localActivity.getString(2131362278), new Object[] { TroopFileUtils.a(localNumberFormatException.e) }));
  }
  
  void a(TroopFeedItem paramTroopFeedItem, int paramInt)
  {
    if (paramTroopFeedItem == null) {
      return;
    }
    int i = paramTroopFeedItem.type;
    if (paramInt == 0) {}
    for (String str = "0";; str = "1") {
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 131: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
        return;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramTroopFeedItem.ex_1, "");
  }
  
  protected void b(TroopFeedItem paramTroopFeedItem)
  {
    if ((paramTroopFeedItem == null) || (!paramTroopFeedItem.isVaild())) {
      return;
    }
    Object localObject1 = paramTroopFeedItem.linkUrl.trim();
    boolean bool = ((String)localObject1).startsWith("http://gamecenter.qq.com");
    int i;
    label64:
    Intent localIntent;
    Object localObject2;
    if ((((String)localObject1).startsWith("http://m.qzone.com")) || (((String)localObject1).startsWith("http://mobile.qzone.qq.com")))
    {
      i = 1;
      if ((!bool) && (i == 0)) {
        break label440;
      }
      i = 1;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
      localObject2 = new StringBuilder((String)localObject1);
      if (((String)localObject1).indexOf("?") <= 0) {
        break label445;
      }
      localObject1 = "";
      label107:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("&from=androidqq");
      if (i == 0) {
        break label453;
      }
    }
    label440:
    label445:
    label453:
    for (localObject1 = "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();; localObject1 = "")
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1);
      localIntent.putExtra("param_force_internal_browser", true);
      if (bool) {
        ((StringBuilder)localObject1).append("&platformId=qq_m");
      }
      localObject1 = ((StringBuilder)localObject1).toString().trim();
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", (String)localObject1);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
      {
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject2).putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Bundle)localObject2).putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        localIntent.putExtras((Bundle)localObject2);
      }
      if (paramTroopFeedItem.type == 132)
      {
        localIntent.putExtra("BUDNLE_KEY_IS_MY_PROFILE", ((String)localObject1).contains("gene/index.html?uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, MusicGeneQQBrowserActivity.class);
      }
      PublicAccountUtil.a(localIntent, (String)localObject1);
      localIntent.putExtra("fromAio", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      i = 0;
      break;
      i = 0;
      break label64;
      localObject1 = "?";
      break label107;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    do
    {
      do
      {
        return;
      } while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      paramView = paramView.getTag();
    } while (!(paramView instanceof TroopFeedViewFactory.ViewHolder));
    Object localObject = (TroopFeedViewFactory.ViewHolder)paramView;
    paramView = ((TroopFeedViewFactory.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    a(paramView, ((TroopFeedViewFactory.ViewHolder)localObject).jdField_a_of_type_Int);
    if (paramView.orginType == 99)
    {
      b(paramView);
      return;
    }
    switch (paramView.type)
    {
    default: 
      b(paramView);
      return;
    case 18: 
      paramView = paramView.linkUrl.trim();
      localObject = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((QZoneHelper.UserInfo)localObject).b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      ((QZoneHelper.UserInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, (QZoneHelper.UserInfo)localObject, paramView, "mqqChat.QzoneCard", -1);
      return;
    case 0: 
    case 131: 
      a(paramView);
      return;
    }
    localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    if ((localObject != null) && (((TroopInfoManager)localObject).a(paramView.linkUrl)) && (((TroopInfoManager)localObject).b()))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      ((Intent)localObject).putExtra("video_play_url", paramView.linkUrl);
      ((Intent)localObject).putExtra("video_play_feed", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory
 * JD-Core Version:    0.7.0.1
 */