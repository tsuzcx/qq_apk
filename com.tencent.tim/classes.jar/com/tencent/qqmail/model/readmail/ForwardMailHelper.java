package com.tencent.qqmail.model.readmail;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

public class ForwardMailHelper
{
  private static String forwardContentImage = "";
  
  private static void forwardMail(Activity paramActivity, int paramInt1, int paramInt2, MailUI paramMailUI)
  {
    if ((forwardContentImage != null) && (!forwardContentImage.isEmpty()))
    {
      paramMailUI = ComposeMailActivity.createIntentWithMail(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD, paramInt1, paramMailUI, forwardContentImage, "CONTROLLER_SCREENSHOT_REPLY");
      paramMailUI.putExtra("fromController", "folder");
      forwardContentImage = null;
      paramActivity.startActivityForResult(paramMailUI, 5);
      return;
    }
    paramMailUI.getInformation().setAccountId(paramInt2);
    paramMailUI = ComposeMailActivity.createIntentWithMail(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD, paramInt1, paramMailUI);
    if (SendMailInterAppsManager.getInstance().hasFile()) {
      paramMailUI.putExtra("arg_from_third_party", true);
    }
    paramActivity.startActivity(paramMailUI);
  }
  
  private static void isDeleteAttachDialog(Activity paramActivity, int paramInt, MailUI paramMailUI)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramActivity).setTitle(2131696424)).setMessage(2131693990).addAction(2131693985, new ForwardMailHelper.8())).addAction(0, 2131693986, 2, new ForwardMailHelper.7(paramActivity, paramInt, paramMailUI))).create().show();
  }
  
  private static void isShowAttachDialog(Activity paramActivity, int paramInt, MailUI paramMailUI)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramActivity).setTitle(2131696424)).setMessage(2131693989).addAction(2131693985, new ForwardMailHelper.4(paramActivity, paramInt, paramMailUI))).addAction(2131693986, new ForwardMailHelper.3(paramMailUI, paramActivity, paramInt))).create().show();
  }
  
  private static void isShowFullMailDialog(Activity paramActivity, int paramInt, MailUI paramMailUI)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramActivity).setTitle(2131696424)).setMessage(2131693988).addAction(2131693985, new ForwardMailHelper.2(paramActivity, paramInt, paramMailUI))).addAction(2131693986, new ForwardMailHelper.1(paramActivity, paramInt, paramMailUI))).create().show();
  }
  
  private static void isShowInlineImgDialog(Activity paramActivity, int paramInt, MailUI paramMailUI)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramActivity).setTitle(2131696424)).setMessage(2131693991).addAction(2131693985, new ForwardMailHelper.6(paramActivity, paramInt, paramMailUI))).addAction(2131693986, new ForwardMailHelper.5(paramActivity, paramInt, paramMailUI))).create().show();
  }
  
  public static void prepareToForwardMail(Activity paramActivity, int paramInt, MailUI paramMailUI, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramMailUI.getStatus().isProtocolMail()) && (!paramMailUI.getStatus().isContentComplete()))
    {
      isShowFullMailDialog(paramActivity, paramInt, paramMailUI);
      return;
    }
    if ((paramMailUI.getStatus().isProtocolMail()) && (!BigAttachHelper.isAllAttachReady(paramMailUI)))
    {
      isShowAttachDialog(paramActivity, paramInt, paramMailUI);
      return;
    }
    if (((QMSettingManager.sharedInstance().getMailLoadImgType() == 2) || ((QMSettingManager.sharedInstance().getMailLoadImgType() == 1) && (!QMNetworkUtils.isWifiConnected(paramActivity)))) && (!paramBoolean2))
    {
      forwardMail(paramActivity, 1, paramInt, paramMailUI);
      return;
    }
    if (BigAttachHelper.isBigAttachesExpire(paramMailUI))
    {
      DataCollector.logEvent("Event_Expire_Big_Attach_Forward");
      ReadMailHelper.expireAttachForwardLocal(new ForwardMailHelper.9(paramActivity, paramInt, paramMailUI), paramMailUI, paramActivity);
      return;
    }
    forwardMail(paramActivity, 1, paramInt, paramMailUI);
  }
  
  public static void prepareToForwardMailWithContentImage(Activity paramActivity, int paramInt, MailUI paramMailUI, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    forwardContentImage = paramString;
    prepareToForwardMail(paramActivity, paramInt, paramMailUI, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ForwardMailHelper
 * JD-Core Version:    0.7.0.1
 */