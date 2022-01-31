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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bup;
import buq;
import bus;
import but;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static final String b = FileItemBuilder.class.getSimpleName();
  public Handler a;
  public FileManagerEntity a;
  
  public FileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt, -1L);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chaosli", 2, "getFileTransStatus processor.getFileStatus() " + i);
      }
      return i;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt);
    if (paramString2 != null) {
      return paramString2.status;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString1 = (TransFileInfo)paramString2.a(TransFileInfo.class, new String[] { String.valueOf(paramLong3), String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1 });
    paramString2.a();
    if (paramString1 == null) {
      return 0;
    }
    paramString1.status = FileManagerUtil.c(paramString1.status);
    if (paramString1.status == 2) {
      paramString1.status = 0;
    }
    return paramString1.status;
  }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString2 = (TransFileInfo)paramString1.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2 });
    paramString1.a();
    if (paramString2 != null) {
      return paramString2.transferedSize;
    }
    return 0L;
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString });
    localEntityManager.a();
    if (paramString != null) {
      return paramString.fileName;
    }
    return "";
  }
  
  private String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 == null) && (paramString2 != null))
    {
      paramString2 = a(paramLong1, paramLong2, paramString2);
      if (paramString2 != null)
      {
        i = paramString2.lastIndexOf(".");
        if (i >= 0) {}
      }
    }
    do
    {
      return paramString2;
      return paramString2.substring(0, i);
      if (paramString1 == null) {
        return null;
      }
      i = paramString1.lastIndexOf(File.separator);
      paramString2 = paramString1;
    } while (i < 0);
    String str = "";
    paramString2 = str;
    if (i > 0)
    {
      paramString2 = str;
      if (i + 1 < paramString1.length()) {
        paramString2 = paramString1.substring(i + 1);
      }
    }
    return paramString2;
  }
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (j > 0)
      {
        str1 = str2;
        if (j > i)
        {
          str1 = str2;
          if (j + 1 < paramString.length()) {
            str1 = paramString.substring(j + 1);
          }
        }
      }
    }
    return str1;
  }
  
  private void a(Intent paramIntent, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, false);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if ((localChatMessage.msgtype == -2005) || (localChatMessage.msgtype == -2014)) {
        paramString.add(String.valueOf(localChatMessage.uniseq));
      }
    }
    paramIntent.putStringArrayListExtra("Aio_Uinseq_ImageList", paramString);
  }
  
  private void a(MessageForFile paramMessageForFile)
  {
    long l1 = 0L;
    if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 0))
    {
      localObject = paramMessageForFile.tempMsg[0].substring(1);
      paramMessageForFile.url = ((String)localObject);
      if (paramMessageForFile.url.length() == 0)
      {
        paramMessageForFile.url = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.frienduin);
        if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 1)) {
          paramMessageForFile.tempMsg[1] = String.valueOf(a(paramMessageForFile.msgseq, paramMessageForFile.time, "", paramMessageForFile.frienduin));
        }
      }
      paramMessageForFile.fileName = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.url, paramMessageForFile.frienduin);
      paramMessageForFile.fileType = a(paramMessageForFile.url);
      if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 1) || (paramMessageForFile.tempMsg[1] == null) || (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() <= 0L)) {
        break label291;
      }
      paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      label202:
      paramMessageForFile.fileSizeString = FileUtil.a(paramMessageForFile.fileSize);
      if (paramMessageForFile.tempMsg != null) {
        if (paramMessageForFile.tempMsg.length <= 4) {
          break label548;
        }
      }
    }
    label291:
    label548:
    for (Object localObject = paramMessageForFile.tempMsg[4];; localObject = null)
    {
      paramMessageForFile.urlAtServer = ((String)localObject);
      paramMessageForFile.status = a(paramMessageForFile.frienduin, paramMessageForFile.url, paramMessageForFile.isSendFromLocal(), paramMessageForFile.fileSize, paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.uniseq, paramMessageForFile.istroop);
      return;
      localObject = "";
      break;
      if (paramMessageForFile.isSendFromLocal())
      {
        localObject = new File(paramMessageForFile.url);
        if (((File)localObject).exists()) {}
        for (long l2 = ((File)localObject).length();; l2 = 0L)
        {
          paramMessageForFile.fileSize = l2;
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "--------->>bindView 1 filePath:" + paramMessageForFile.url + ",fileExists:" + ((File)localObject).exists() + ", fileSize:" + ((File)localObject).length());
          }
          if ((paramMessageForFile.fileSize != 0L) || (paramMessageForFile.tempMsg == null)) {
            break;
          }
          if (paramMessageForFile.tempMsg.length > 1) {
            l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
          }
          paramMessageForFile.fileSize = l1;
          break;
        }
      }
      if (paramMessageForFile.tempMsg == null) {
        break label202;
      }
      if (paramMessageForFile.tempMsg.length > 1) {
        l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      }
      paramMessageForFile.fileSize = l1;
      if (!QLog.isColorLevel()) {
        break label202;
      }
      QLog.d(b, 2, "--------->>bindView 2 filePath:" + paramMessageForFile.url + "fileMsgLength:" + paramMessageForFile.tempMsg.length + ", fileSize:" + paramMessageForFile.fileSize);
      break label202;
    }
  }
  
  private void d(View paramView)
  {
    MessageForFile localMessageForFile = (MessageForFile)AIOUtils.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "TransfileUtile.TYPE_FILE uniseq " + localMessageForFile.uniseq + " itemStatus" + localMessageForFile.status);
    }
    FileManagerEntity localFileManagerEntity = a(localMessageForFile);
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.b = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = FileUtil.a(localFileManagerEntity.fileName);
    paramView.d = FileManagerUtil.a(localFileManagerEntity.cloudType, localFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
    FileManagerReporter.a("0X8004AE3");
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.a(10004);
    if (localMessageForFile.isSend()) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      localForwardFileInfo.c(localFileManagerEntity.cloudType);
      localForwardFileInfo.a(Long.valueOf(paramView.replace("+", "")).longValue());
      localForwardFileInfo.c(localMessageForFile.uniseq);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localMessageForFile.fileName);
      localForwardFileInfo.d(localMessageForFile.fileSize);
      localForwardFileInfo.b(localFileManagerEntity.Uuid);
      localForwardFileInfo.a(localFileManagerEntity.strFilePath);
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      paramView.putExtra("fileinfo", localForwardFileInfo);
      int i = FileManagerUtil.a(localFileManagerEntity.fileName);
      if ((i == 0) || (i == 1)) {
        a(paramView, localFileManagerEntity.peerUin, localFileManagerEntity.peerType);
      }
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 102);
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((but)paramChatMessage.getTag()).jdField_c_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.f;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (but)paramViewHolder;
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903084, null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296693));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296694));
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296695));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131296691));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131296692));
      paramViewHolder.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131296696));
    }
    a(localMessageForFile);
    a(paramBaseChatItemLayout, localMessageForFile, paramViewHolder, localMessageForFile.status, false);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new but(this);
  }
  
  public FileManagerEntity a(MessageForFile paramMessageForFile)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    FileManagerEntity localFileManagerEntity;
    label287:
    int i;
    if (localObject == null)
    {
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).a();
      localFileManagerEntity.status = FileManagerUtil.c(paramMessageForFile.status);
      if (paramMessageForFile.isSend())
      {
        localFileManagerEntity.cloudType = 3;
        localFileManagerEntity.strFilePath = paramMessageForFile.url;
        if (localTransFileInfo != null)
        {
          if (localTransFileInfo.uuid == null) {
            break label508;
          }
          localObject = new String(localTransFileInfo.uuid);
          localFileManagerEntity.Uuid = ((String)localObject);
        }
        localFileManagerEntity.fileName = paramMessageForFile.fileName;
        localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
        if (!paramMessageForFile.isSend()) {
          break label514;
        }
        i = 0;
        label320:
        localFileManagerEntity.nOpType = i;
        localFileManagerEntity.peerUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        localFileManagerEntity.peerType = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
        localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
        localFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
        localFileManagerEntity.bDelInFM = true;
        paramMessageForFile = localFileManagerEntity;
      }
    }
    label508:
    do
    {
      return paramMessageForFile;
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.strFilePath = paramMessageForFile.url;
      break;
      localObject = "";
      break label287;
      i = 1;
      break label320;
      paramMessageForFile = (MessageForFile)localObject;
    } while (!QLog.isColorLevel());
    label514:
    QLog.d("FileManager", 2, "QueryFileEntityByuniseq finded,FileEntity[" + FileManagerUtil.a((FileManagerEntity)localObject) + "]");
    return localObject;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      Object localObject = a(localMessageForFile);
      switch (((FileManagerEntity)localObject).cloudType)
      {
      case 2: 
      default: 
        break;
      case 1: 
        if (localMessageForFile.isSend())
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          FMToastUtil.b(FileManagerUtil.d(((FileManagerEntity)localObject).fileName) + paramContext.getString(2131362001));
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
            break label347;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, paramChatMessage);
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("@-@", 1, "mEntity[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "]'s relateId[" + String.valueOf(((FileManagerEntity)localObject).nRelatedSessionId) + "] No reInit,Show Juhua");
          }
          paramContext = new FileManagerReporter.fileAssistantReportData();
          paramContext.b = "file_to_weiyun";
          paramContext.jdField_a_of_type_Int = 9;
          paramContext.jdField_a_of_type_Long = ((FileManagerEntity)localObject).fileSize;
          paramContext.c = FileUtil.a(((FileManagerEntity)localObject).fileName);
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramContext);
          break;
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          break label135;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        }
      case 3: 
        label135:
        label347:
        if (((FileManagerEntity)localObject).nRelatedSessionId > 0L) {}
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).nRelatedSessionId);; paramChatMessage = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramChatMessage;
          if ((!FileManagerUtil.a()) || (localMessageForFile.fileSize <= 5242880L)) {
            break label447;
          }
          FMDialogUtil.a(paramContext, 2131362021, 2131362019, new bup(this, localMessageForFile, paramContext, (FileManagerEntity)localObject));
          break;
        }
        label447:
        FMToastUtil.b(FileManagerUtil.d(((FileManagerEntity)localObject).fileName) + paramContext.getString(2131362001));
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).strFilePath, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("@-@", 1, "mEntity[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "]'s relateId[" + String.valueOf(((FileManagerEntity)localObject).nRelatedSessionId) + "] reInit");
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        }
        paramContext = a(localMessageForFile);
        paramChatMessage = new FileManagerReporter.fileAssistantReportData();
        paramChatMessage.b = "file_forward";
        paramChatMessage.jdField_a_of_type_Int = 9;
        paramChatMessage.jdField_a_of_type_Long = paramContext.fileSize;
        paramChatMessage.c = FileUtil.a(paramContext.fileName);
        paramChatMessage.d = FileManagerUtil.a(paramContext.cloudType, paramContext.peerType);
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramChatMessage);
        paramChatMessage = new Bundle();
        paramChatMessage.putInt("forward_type", 0);
        paramChatMessage.putBoolean("not_forward", true);
        localObject = new ForwardFileInfo();
        switch (paramContext.cloudType)
        {
        }
        for (;;)
        {
          ((ForwardFileInfo)localObject).c(paramContext.cloudType);
          ((ForwardFileInfo)localObject).b(paramContext.nSessionId);
          ((ForwardFileInfo)localObject).c(paramContext.uniseq);
          ((ForwardFileInfo)localObject).d(paramContext.fileName);
          ((ForwardFileInfo)localObject).d(paramContext.fileSize);
          ((ForwardFileInfo)localObject).a(paramContext.strFilePath);
          ((ForwardFileInfo)localObject).c(paramContext.WeiYunFileId);
          if (paramContext.Uuid != null) {
            ((ForwardFileInfo)localObject).b(new String(paramContext.Uuid));
          }
          paramChatMessage.putParcelable("fileinfo", (Parcelable)localObject);
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          ((Intent)localObject).putExtras(paramChatMessage);
          ((Intent)localObject).putExtra("forward_text", "已选择" + FileManagerUtil.d(paramContext.fileName) + "。");
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 21);
          break;
          ((ForwardFileInfo)localObject).a(10000);
          continue;
          ((ForwardFileInfo)localObject).a(10002);
          continue;
          ((ForwardFileInfo)localObject).a(10003);
        }
        paramContext = a(localMessageForFile);
        paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
        paramChatMessage.putExtra("dataline_forward_type", 100);
        paramChatMessage.putExtra("dataline_forward_path", paramContext.strFilePath);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramChatMessage);
        continue;
        paramContext = a(localMessageForFile);
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage);
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    but localbut = (but)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)localbut.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = localbut.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = a(localMessageForFile);
    this.jdField_a_of_type_AndroidContentContext.getString(2131363070);
    this.jdField_a_of_type_AndroidContentContext.getString(2131363071);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131361951);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131361949); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131361950))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119);
      localActionSheet.c(str);
      localActionSheet.d(this.jdField_a_of_type_AndroidContentContext.getString(2131362790));
      localActionSheet.a(paramView);
      localActionSheet.a(new buq(this, localMessageForFile, localBaseChatItemLayout, localbut, localActionSheet));
      localActionSheet.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131361952);
    }
    paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext, 2131624119);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131361952));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131362790));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131361950));
    paramView.a(new bus(this, localMessageForFile, localBaseChatItemLayout, localbut, paramView));
    paramView.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (but)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (localMessageForFile.uniseq != paramFileMsg.c) {
      return;
    }
    if (paramInt1 == 5000)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131363129, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "transferListener FileMsg.TRANSFILE_TYPE_FILE uniseq " + localMessageForFile.uniseq + " itemStatus " + localMessageForFile.status);
    }
    a(localBaseChatItemLayout, localMessageForFile, paramView, paramInt1, false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, but parambut, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = a(paramMessageForFile);
    FileManagerUtil.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.strFilePath;
    paramMessageForFile.fileSizeString = FileUtil.a(localFileManagerEntity.fileSize);
    String str;
    if (localFileManagerEntity.cloudType == 3)
    {
      parambut.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.fileName));
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131361978);
      parambut.jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(localFileManagerEntity.fileSize));
      if (parambut.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        parambut.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      switch (localFileManagerEntity.cloudType)
      {
      }
    }
    switch (localFileManagerEntity.status)
    {
    default: 
      parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramBoolean = false;
    case 0: 
    case 16: 
    case -1: 
    case 1: 
    case 3: 
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 4: 
    case 9: 
    case 12: 
    case 10: 
    case 11: 
    case 13: 
      for (;;)
      {
        paramMessageForFile.status = paramInt;
        paramBaseChatItemLayout.setFailedIconVisable(paramBoolean, this);
        FileManagerUtil.a(parambut.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        if ((localFileManagerEntity.nFileType != 1) || (!FileUtil.b(localFileManagerEntity.strFilePath))) {
          break label1518;
        }
        if (!FileViewMusicService.a().b(localFileManagerEntity.strFilePath)) {
          break label1505;
        }
        parambut.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838615);
        parambut.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        parambut.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.strSrcName));
        break;
        parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
        parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageForFile.isSend()) {
          if ((localFileManagerEntity.nOpType == 8) || (localFileManagerEntity.nOpType == 1) || (localFileManagerEntity.nOpType == 5)) {
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362029));
          }
        }
        while (localFileManagerEntity.status == 0)
        {
          paramBoolean = true;
          break label272;
          parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362032));
          continue;
          parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362033));
        }
        parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
        parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
        parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362029));
          paramBoolean = false;
        }
        else
        {
          parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
          paramBoolean = false;
          continue;
          parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
          parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
          parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          if (paramMessageForFile.isSend())
          {
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362029));
            paramBoolean = false;
          }
          else if (localFileManagerEntity.cloudType == 0)
          {
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362039));
            paramBoolean = false;
          }
          else
          {
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362027));
            paramBoolean = false;
            continue;
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            if (paramMessageForFile.isSend())
            {
              if ((localFileManagerEntity.nOpType == 8) || (localFileManagerEntity.nOpType == 5))
              {
                parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362029));
                paramBoolean = false;
                continue;
              }
              if (3 != localFileManagerEntity.cloudType) {
                break label269;
              }
              parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362028));
              paramBoolean = false;
              continue;
            }
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
            paramBoolean = false;
            continue;
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramBoolean = false;
            continue;
            if (13 == localFileManagerEntity.nOpType)
            {
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            for (paramBoolean = true;; paramBoolean = false)
            {
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
              break;
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
            }
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
            paramBoolean = false;
            continue;
            if (10 == localFileManagerEntity.nOpType)
            {
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
            }
            for (paramBoolean = false;; paramBoolean = true)
            {
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
              break;
              parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
              parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
            parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
            parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            parambut.jdField_c_of_type_AndroidWidgetTextView.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362030));
            paramBoolean = false;
          }
        }
      }
    case 14: 
      label269:
      label272:
      label338:
      if (13 != localFileManagerEntity.nOpType) {
        break;
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (9 == localFileManagerEntity.nOpType)
      {
        parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
        parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
        parambut.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362009));
        break;
      }
      parambut.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      parambut.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
      parambut.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(4);
      break;
      label1505:
      parambut.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838614);
      break label338;
      label1518:
      parambut.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    FileManagerEntity localFileManagerEntity = a((MessageForFile)AIOUtils.a(paramView));
    paramView = new QQCustomMenu();
    if (localFileManagerEntity.cloudType != 0)
    {
      paramView.a(2131298999, this.jdField_a_of_type_AndroidContentContext.getString(2131361962));
      paramView.a(2131296656, this.jdField_a_of_type_AndroidContentContext.getString(2131361963));
    }
    if ((localFileManagerEntity.cloudType == 3) || ((localFileManagerEntity.cloudType == 2) && (!TextUtils.isEmpty(localFileManagerEntity.strFilePath)) && (FileUtil.a(localFileManagerEntity.strFilePath)))) {
      paramView.a(2131299000, this.jdField_a_of_type_AndroidContentContext.getString(2131361880));
    }
    if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.cloudType != 2))
    {
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nRelatedSessionId);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.status == 1))
      {
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return paramView.a();
      }
      paramView.a(2131298998, this.jdField_a_of_type_AndroidContentContext.getString(2131361965));
    }
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {}
    do
    {
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      case 2131296297: 
      default: 
        return;
      case 2131296305: 
        d(paramView);
        return;
      }
      paramView = a((MessageForFile)AIOUtils.a(paramView));
    } while (paramView == null);
    if (FileViewMusicService.a().b(paramView.strFilePath))
    {
      FileManagerReporter.a("0X8004BDF");
      FileViewMusicService.a().a();
      FileViewMusicService.a().c();
    }
    for (;;)
    {
      a();
      return;
      FileManagerReporter.a("0X8004BDE");
      FileViewMusicService.a().a(paramView.strFilePath);
      FileViewMusicService.a().b();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.peerUin, paramView.peerType, false);
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (localChatMessage.msgtype == -2005) {
          localArrayList.add(String.valueOf(localChatMessage.uniseq));
        }
      }
      localObject = new ArrayList();
      int i = FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, paramView, (ArrayList)localObject);
      FileViewMusicService.a().a((List)localObject, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder
 * JD-Core Version:    0.7.0.1
 */