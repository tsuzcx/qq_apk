package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.activity.fileviewer.troopfile.TroopFileViewerActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopProxyActivity;
import ebh;
import ebi;
import ebj;
import ebk;
import java.util.ArrayList;
import java.util.UUID;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
{
  public static final String b;
  public Handler a;
  public View.OnClickListener a;
  
  static
  {
    jdField_b_of_type_JavaLangString = TroopFileItemBuilder.class.getSimpleName();
  }
  
  public TroopFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ebh(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = (ebk)paramViewGroup.getTag();
    if (paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131230782);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramChatMessage.isSend()) {
        break label331;
      }
      paramView.addRule(0, 2131230773);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      paramView.addRule(5, 2131230779);
      paramView.addRule(3, 2131230779);
      paramView.topMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout, paramView);
      paramView = null;
      if (paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramView = paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      }
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramView);
      paramOnLongClickAndTouchListener.d = ((TextView)paramView.findViewById(2131234548));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234547));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
      a(paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.f;
      return paramViewGroup;
      paramViewGroup.removeView(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout);
      break;
      label331:
      paramView.addRule(1, 2131230773);
      paramView.addRule(0, 0);
    }
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramContext).inflate(2130904026, null);
    }
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (ebk)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903105, null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131231222));
      paramViewHolder.b = ((TextView)paramChatMessage.findViewById(2131231223));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131231224));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131231221));
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131231225));
    }
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ebk(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558925);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localObject2 == null) {}
    Object localObject1;
    TroopFileStatusInfo localTroopFileStatusInfo;
    int i;
    TroopFileItemOperation localTroopFileItemOperation;
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
                          localObject1 = (MessageForTroopFile)paramChatMessage;
                          localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
                        } while (localTroopFileStatusInfo == null);
                        i = NetworkUtil.a((Activity)paramContext);
                        localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                        switch (paramInt)
                        {
                        default: 
                          return;
                        case 2131234891: 
                          paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
                          paramContext.putExtra("dataline_forward_type", 100);
                          paramContext.putExtra("dataline_forward_path", localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
                          this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
                          return;
                        case 2131234892: 
                          if (i == 0)
                          {
                            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
                            return;
                          }
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                        }
                      } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 8);
                      ((TroopFileTransferManager)localObject2).g(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
                        return;
                      }
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                    } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 1));
                    ((TroopFileTransferManager)localObject2).d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
                    return;
                  } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 9);
                  localTroopFileItemOperation.b(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
                  return;
                } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 2);
                localTroopFileItemOperation.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 8) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 9) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 10));
              ((TroopFileTransferManager)localObject2).g(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
              a(localTroopFileStatusInfo.jdField_a_of_type_Long, (Activity)paramContext, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
                return;
              }
            } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 1) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 2) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject2).d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
            a(localTroopFileStatusInfo.jdField_a_of_type_Long, (Activity)paramContext, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, paramChatMessage);
            return;
            if (i == 0)
            {
              TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
              return;
            }
            paramContext = new Bundle();
            paramContext.putInt("forward_type", 0);
            localObject1 = FileManagerUtil.a(localTroopFileStatusInfo);
            localObject2 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
            ((ForwardFileInfo)localObject2).a(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strFilePath)) {
              ((ForwardFileInfo)localObject2).a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
            }
            ((ForwardFileInfo)localObject2).d(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
            ((ForwardFileInfo)localObject2).d(localTroopFileStatusInfo.jdField_b_of_type_Long);
            ((ForwardFileInfo)localObject2).a(Long.parseLong(paramChatMessage.frienduin));
            if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
              ((ForwardFileInfo)localObject2).e(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString());
            }
            ((ForwardFileInfo)localObject2).c(1);
            paramContext.putParcelable("fileinfo", (Parcelable)localObject2);
            paramContext.putBoolean("not_forward", true);
            paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
            paramChatMessage.putExtras(paramContext);
            paramChatMessage.putExtra("forward_text", localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
            paramChatMessage.putExtra("forward_from_troop_file", true);
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          } while (localTroopFileStatusInfo.d == null);
          if (i == 0)
          {
            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
            return;
          }
          FMToastUtil.b(this.jdField_a_of_type_AndroidContentContext.getString(2131558738, new Object[] { FileManagerUtil.d(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString) }));
          ((TroopFileTransferManager)localObject2).a(localTroopFileStatusInfo.d, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.jdField_e_of_type_Int);
          return;
          FileManagerUtil.a((Activity)paramContext, localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
          return;
        } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 3);
        localTroopFileItemOperation.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        return;
      } while (localTroopFileStatusInfo.jdField_b_of_type_Int != 10);
      localTroopFileItemOperation.b(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
    } while ((localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 7));
    localTroopFileItemOperation.a(localTroopFileStatusInfo.d, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.jdField_e_of_type_Int);
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Press_Clk_preview", 0, 0, "", paramChatMessage.frienduin, "", "");
    if (i == 0)
    {
      TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131560350));
      return;
    }
    paramContext = new Intent();
    paramContext.putExtra("troopUin", ((MessageForTroopFile)localObject1).frienduin);
    paramContext.putExtra("uuid_key", ((MessageForTroopFile)localObject1).uuid);
    paramContext.putExtra("fileSize", ((MessageForTroopFile)localObject1).fileSize);
    paramContext.putExtra("fileName", ((MessageForTroopFile)localObject1).fileName);
    paramContext.putExtra("Url", ((MessageForTroopFile)localObject1).url);
    paramContext.putExtra("bisID", ((MessageForTroopFile)localObject1).bisID);
    paramContext.putExtra("preview", true);
    TroopProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 5001);
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new ebi(this, paramLong, paramUUID, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131560334), this.jdField_a_of_type_AndroidContentContext.getString(2131560377), 2131560313, 2131560314, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new ebj(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131560333), this.jdField_a_of_type_AndroidContentContext.getString(2131560378), 2131560311, 2131560312, paramUUID, paramUUID).show();
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    d(paramView);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, ebk paramebk)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramebk.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    Object localObject = "";
    boolean bool1;
    int k;
    int j;
    int i;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      bool1 = bool2;
      k = m;
      j = n;
      i = i1;
      if (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        m = 1;
        label248:
        if (k == 0) {
          break label1064;
        }
        paramebk.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        paramebk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label270:
        if (i == 0) {
          break label1076;
        }
        paramebk.c.setText((CharSequence)localObject);
        paramebk.c.setVisibility(0);
        label292:
        paramebk.b.setText(FileUtil.a(localTroopFileStatusInfo.jdField_b_of_type_Long));
        paramebk.b.setVisibility(0);
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localTroopFileStatusInfo.jdField_b_of_type_JavaLangString != null) {
          break label1114;
        }
        FileManagerUtil.a(paramebk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break label1088;
        }
        paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 128);
      }
      break;
    }
    for (;;)
    {
      if (m == 0) {
        break label1190;
      }
      paramebk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramebk.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramebk.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(0);
      }
      paramebk.d.setVisibility(0);
      paramebk.d.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558924));
      return;
      k = 1;
      j = 0;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558915);
      i = 1;
      bool1 = bool2;
      break;
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558916);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (localMessageForTroopFile.msgtype != -2017) {
        break;
      }
      if (localMessageForTroopFile.extraflag != 32772)
      {
        localObject = str;
        i = i1;
        j = n;
        k = m;
        bool1 = bool2;
        if (localMessageForTroopFile.extraflag != 32768) {
          break;
        }
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!localMessageForTroopFile.isSendFromLocal()) {
        break;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localMessageForTroopFile.FromUin)) {
        break;
      }
      a(paramChatMessage);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558916);
      a(paramChatMessage);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558915);
      i = 1;
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558917);
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      i = i1;
      bool1 = bool2;
      break;
      i = 1;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558918);
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      i = 1;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558918);
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558919);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558920);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558921);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558921);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558922);
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558923);
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break;
      m = 0;
      break label248;
      label1064:
      paramebk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label270;
      label1076:
      paramebk.c.setVisibility(8);
      break label292;
      label1088:
      paramBaseChatItemLayout.a(localTroopFileStatusInfo.d, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_e_of_type_Int, 128);
      continue;
      label1114:
      if ((TextUtils.isEmpty(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)) || (!FileUtils.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)))
      {
        FileManagerUtil.a(paramebk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
      }
      else
      {
        paramBaseChatItemLayout = RollangleImageView.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString);
        if (paramBaseChatItemLayout != null) {
          paramebk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(paramBaseChatItemLayout);
        } else {
          FileManagerUtil.a(paramebk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
        }
      }
    }
    label1190:
    paramebk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (MessageForTroopFile)localChatMessage;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localTroopFileStatusInfo == null)
    {
      localQQCustomMenu.a(2131234903, this.jdField_a_of_type_AndroidContentContext.getString(2131560330));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      return localQQCustomMenu.a();
    }
    Boolean localBoolean = Boolean.valueOf(false);
    paramView = localBoolean;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      paramView = localBoolean;
    case 4: 
    case 5: 
    case 12: 
      if (paramView.booleanValue()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131234893, this.jdField_a_of_type_AndroidContentContext.getString(2131560321));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131234895, this.jdField_a_of_type_AndroidContentContext.getString(2131560322));
      localQQCustomMenu.a(2131234897, this.jdField_a_of_type_AndroidContentContext.getString(2131560324));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131234901, this.jdField_a_of_type_AndroidContentContext.getString(2131560328));
      localQQCustomMenu.a(2131234897, this.jdField_a_of_type_AndroidContentContext.getString(2131560324));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131234892, this.jdField_a_of_type_AndroidContentContext.getString(2131560321));
      localQQCustomMenu.a(2131234898, this.jdField_a_of_type_AndroidContentContext.getString(2131560325));
      localQQCustomMenu.a(2131234899, this.jdField_a_of_type_AndroidContentContext.getString(2131560326));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131234894, this.jdField_a_of_type_AndroidContentContext.getString(2131560322));
      localQQCustomMenu.a(2131234896, this.jdField_a_of_type_AndroidContentContext.getString(2131560323));
      localQQCustomMenu.a(2131234898, this.jdField_a_of_type_AndroidContentContext.getString(2131560325));
      localQQCustomMenu.a(2131234899, this.jdField_a_of_type_AndroidContentContext.getString(2131560326));
      paramView = localBoolean;
      break;
      boolean bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_b_of_type_Long);
      localQQCustomMenu.a(2131234902, this.jdField_a_of_type_AndroidContentContext.getString(2131560329));
      localQQCustomMenu.a(2131234896, this.jdField_a_of_type_AndroidContentContext.getString(2131560323));
      paramView = localBoolean;
      if (!bool) {
        break;
      }
      localQQCustomMenu.a(2131234904, this.jdField_a_of_type_AndroidContentContext.getString(2131560331));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131234898, this.jdField_a_of_type_AndroidContentContext.getString(2131560325));
      localQQCustomMenu.a(2131234899, this.jdField_a_of_type_AndroidContentContext.getString(2131560326));
      localQQCustomMenu.a(2131234891, this.jdField_a_of_type_AndroidContentContext.getString(2131558554));
      paramView = Boolean.valueOf(true);
      break;
      if (!FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin)).b();
        paramView = localBoolean;
        break;
      }
      if ((!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.e(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        localQQCustomMenu.a(2131234900, this.jdField_a_of_type_AndroidContentContext.getString(2131560327));
      }
      localQQCustomMenu.a(2131234898, this.jdField_a_of_type_AndroidContentContext.getString(2131560325));
      localQQCustomMenu.a(2131234899, this.jdField_a_of_type_AndroidContentContext.getString(2131560326));
      localQQCustomMenu.a(2131234891, this.jdField_a_of_type_AndroidContentContext.getString(2131558554));
      paramView = localBoolean;
      break;
      bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.jdField_b_of_type_Long);
      localQQCustomMenu.a(2131234903, this.jdField_a_of_type_AndroidContentContext.getString(2131560330));
      if (bool) {
        localQQCustomMenu.a(2131234904, this.jdField_a_of_type_AndroidContentContext.getString(2131560331));
      }
      localQQCustomMenu.a(2131234898, this.jdField_a_of_type_AndroidContentContext.getString(2131560325));
      localQQCustomMenu.a(2131234899, this.jdField_a_of_type_AndroidContentContext.getString(2131560326));
      paramView = localBoolean;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  void d(View paramView)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    Object localObject1 = AIOUtils.a(paramView);
    Object localObject2 = (MessageForTroopFile)localObject1;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, "", ((ChatMessage)localObject1).frienduin, "", "");
    new TroopFileItemOperation(Long.parseLong(((ChatMessage)localObject1).frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity);
    paramView = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject2);
    switch (paramView.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 11: 
      do
      {
        return;
        localIntent.putExtra(TroopProxyActivity.jdField_a_of_type_JavaLangString, ((ChatMessage)localObject1).frienduin);
        TroopProxyActivity.b(localActivity, localIntent);
        return;
        localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(((ChatMessage)localObject1).frienduin));
      } while ((localObject2 == null) || (paramView == null));
      if (!FileUtil.a(paramView.jdField_a_of_type_JavaLangString))
      {
        ((TroopFileTransferManager)localObject2).b();
        return;
      }
      if (paramView.jdField_b_of_type_Int == 6) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_file viewer", 0, 0, "", ((ChatMessage)localObject1).frienduin, "", "");
      }
      for (;;)
      {
        localIntent.setClass(localActivity, TroopFileViewerActivity.class);
        localObject1 = new FileInfo();
        ((FileInfo)localObject1).c(paramView.jdField_e_of_type_JavaLangString);
        ((FileInfo)localObject1).d(paramView.jdField_a_of_type_JavaLangString);
        ((FileInfo)localObject1).a(paramView.jdField_b_of_type_Long);
        FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramView);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).b(localFileManagerEntity.nSessionId);
        ((ForwardFileInfo)localObject2).c(4);
        ((ForwardFileInfo)localObject2).a(10006);
        ((ForwardFileInfo)localObject2).a(((FileInfo)localObject1).c());
        ((ForwardFileInfo)localObject2).d(((FileInfo)localObject1).d());
        ((ForwardFileInfo)localObject2).d(((FileInfo)localObject1).a());
        ((ForwardFileInfo)localObject2).a(paramView.jdField_a_of_type_Long);
        if (localFileManagerEntity.nFileType == 0)
        {
          paramView = new ArrayList();
          paramView.add(localObject1);
          FMDataCache.a(paramView);
          localIntent.putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localIntent.putExtra("fileinfo", (Parcelable)localObject2);
        localIntent.putExtra("removemementity", true);
        localIntent.putExtra("forward_from_troop_file", true);
        localIntent.putExtra("not_forward", true);
        localActivity.startActivityForResult(localIntent, 102);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_file viewer", 0, 0, "", ((ChatMessage)localObject1).frienduin, "", "");
      }
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      localIntent.putExtra("troopUin", ((MessageForTroopFile)localObject2).frienduin);
      localIntent.putExtra("uuid_key", ((MessageForTroopFile)localObject2).uuid);
      localIntent.putExtra("fileSize", ((MessageForTroopFile)localObject2).fileSize);
      localIntent.putExtra("fileName", ((MessageForTroopFile)localObject2).fileName);
      localIntent.putExtra("Url", ((MessageForTroopFile)localObject2).url);
      localIntent.putExtra("bisID", ((MessageForTroopFile)localObject2).bisID);
      TroopProxyActivity.b(localActivity, localIntent, 5001);
      return;
    }
    TroopFileError.a(localActivity, String.format(localActivity.getString(2131560369), new Object[] { TroopFileUtils.a(paramView.jdField_e_of_type_JavaLangString) }));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */