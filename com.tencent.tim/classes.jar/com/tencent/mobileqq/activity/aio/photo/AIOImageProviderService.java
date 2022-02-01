package com.tencent.mobileqq.activity.aio.photo;

import accd;
import acei;
import acfp;
import acfx;
import acrb;
import acsp;
import aghq;
import aghw;
import agkf;
import agkh;
import agkw;
import aglf;
import agnk;
import agsw;
import agta;
import agtd;
import agtf;
import ahav;
import ahbj;
import ahbr;
import ahhq;
import ahtr;
import ajlq;
import ajlu;
import akxj;
import akxq;
import akxv;
import akxz;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import anfr;
import anfu;
import angi;
import anot;
import anpc;
import ansu;
import aoiz;
import aoji;
import aoju;
import aooi;
import aoop;
import apbr;
import apcy;
import apsf;
import apsv;
import aqhq;
import aqiu;
import aqiw;
import audx;
import auru;
import aviz;
import awpd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import ton;
import top;
import xkl;
import xtj;
import xtm;
import xtx;
import xty;
import xtz;
import xua;
import xug;
import xuh.a;
import xui;
import ykm;
import zsz;

public class AIOImageProviderService
  extends xuh.a
{
  public static final HashMap<String, AIOImageProviderService> gU = new HashMap();
  long FH = 9223372036854775807L;
  long FI = 9223372036854775807L;
  long FJ = 9223372036854775807L;
  long Jy;
  aghq jdField_a_of_type_Aghq;
  private IncreasinglyLoadMediaTask jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask = new IncreasinglyLoadMediaTask();
  public a a;
  WeakReference<BaseActivity> af = null;
  int bFx = 3;
  int bWY = 60;
  int bWZ = 0;
  volatile boolean bjm = false;
  private accd c;
  String friendUin;
  private HashMap<String, MessageForTroopFile> gV;
  auru h;
  boolean isFlashPic = false;
  volatile boolean isLoading = false;
  boolean isMultiMsg = false;
  final List<AIORichMediaData> jl = Collections.synchronizedList(new LinkedList());
  String myUin;
  ArrayList<Long> qM = new ArrayList();
  int sessionType;
  final List<ChatMessage> sn = Collections.synchronizedList(new LinkedList());
  int topicId;
  
  protected AIOImageProviderService() {}
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.myUin = paramString1;
    this.friendUin = paramString2;
    this.sessionType = paramInt;
    if (paramChatMessage != null)
    {
      this.isMultiMsg = paramChatMessage.isMultiMsg;
      this.Jy = paramChatMessage.msgseq;
      this.sn.add(paramChatMessage);
      if (top.eD(paramChatMessage.istroop) == 1032) {
        this.topicId = paramChatMessage.getConfessTopicId();
      }
    }
    this.h = new auru(ThreadManager.getFileThreadLooper(), null);
    this.isFlashPic = acei.W(paramChatMessage);
    if ((!this.isMultiMsg) && (!MessageForApollo.class.isInstance(paramChatMessage)))
    {
      paramString2 = getKey();
      paramChatMessage = (AIOImageProviderService)gU.get(paramString2);
      if (paramChatMessage != null) {
        paramChatMessage.destory();
      }
      gU.put(paramString2, this);
    }
    try
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramString1);
      ba(paramString1);
      bb(paramString1);
      QLog.e("AIOImageProviderService", 1, "～～～～～～～call AIOImageProviderService～～～～～～～");
      if (!Build.MODEL.equalsIgnoreCase("SM-A5100")) {
        QLog.e("AIOImageProviderService", 1, ahav.ti());
      }
      paramString1 = BaseActivity.sTopActivity;
      if (paramString1 != null)
      {
        this.af = new WeakReference(paramString1);
        return;
      }
    }
    catch (AccountNotMatchException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
      dE("Static Null", "Init");
    }
  }
  
  private boolean M(MessageRecord paramMessageRecord)
  {
    if (MessageForFile.class.isInstance(paramMessageRecord)) {
      paramMessageRecord = (MessageForFile)paramMessageRecord;
    }
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if (localObject != null)
      {
        FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).a().b(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localFileManagerEntity != null)
        {
          localObject = ((QQAppInterface)localObject).a().b(localFileManagerEntity.nSessionId);
          if (localObject != null) {
            paramMessageRecord.fileName = ((FileManagerEntity)localObject).fileName;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    return 2 == ahav.getFileType(paramMessageRecord.fileName);
    if (MessageForTroopFile.class.isInstance(paramMessageRecord)) {
      return 2 == ahav.getFileType(((MessageForTroopFile)paramMessageRecord).fileName);
    }
    return false;
  }
  
  private void O(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.shmsgseq < this.FI) {
      this.FI = paramMessageRecord.shmsgseq;
    }
    if (paramMessageRecord.versionCode < this.bFx) {
      this.bFx = paramMessageRecord.versionCode;
    }
    if ((paramMessageRecord.getId() > 0L) && (paramMessageRecord.getId() < this.FH)) {
      this.FH = paramMessageRecord.getId();
    }
    if (paramMessageRecord.time < this.FJ) {
      this.FJ = paramMessageRecord.time;
    }
  }
  
  private ajlu a()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if (localQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "getRichMedialSaveManager app == null");
        }
        return null;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      Object localObject;
      for (;;)
      {
        localAccountNotMatchException.printStackTrace();
        localObject = null;
      }
      return (ajlu)localObject.getManager(324);
    }
  }
  
  public static Intent a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "Forward menu clicked, md5 is empty.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    String str1 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.f(paramMessageForShortVideo));
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str2 = ShortVideoUtils.e(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    if (aqhq.fileExistsAndNotEmpty(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
    }
    return new Intent().putExtras(localBundle);
  }
  
  private Intent a(MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject1;
    try
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      localObject1 = apsv.a((QQAppInterface)localObject1, paramMessageForTroopFile);
      if (localObject1 == null)
      {
        QLog.w("AIOImageProviderService", 1, "getFileStatusInfo is null");
        return null;
      }
    }
    catch (AccountNotMatchException paramMessageForTroopFile)
    {
      paramMessageForTroopFile.printStackTrace();
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject2 = ahav.a((apcy)localObject1);
    ((FileManagerEntity)localObject2).status = 2;
    ((FileManagerEntity)localObject2).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(((FileManagerEntity)localObject2).nSessionId);
    localForwardFileInfo.setType(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
      localForwardFileInfo.setLocalPath(((apcy)localObject1).LocalFile);
    }
    localForwardFileInfo.setFileName(((apcy)localObject1).FileName);
    localForwardFileInfo.setFileSize(((apcy)localObject1).ProgressTotal);
    localForwardFileInfo.jA(Long.parseLong(paramMessageForTroopFile.frienduin));
    if (((apcy)localObject1).Id != null) {
      localForwardFileInfo.Ja(((apcy)localObject1).Id.toString());
    }
    if (!TextUtils.isEmpty(((apcy)localObject1).ThumbnailFile_Large)) {
      localForwardFileInfo.aA(((apcy)localObject1).ThumbnailFile_Large);
    }
    for (;;)
    {
      localForwardFileInfo.Oj(1);
      localForwardFileInfo.Oh(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(localBundle);
      ((Intent)localObject2).putExtra("forward_text", ((apcy)localObject1).FileName);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject2).putExtra("forward _key_nojump", false);
      ((Intent)localObject2).putExtra("sender_uin", paramMessageForTroopFile.senderuin);
      ((Intent)localObject2).putExtra("last_time", paramMessageForTroopFile.lastTime);
      return localObject2;
      if (!TextUtils.isEmpty(((apcy)localObject1).coc)) {
        localForwardFileInfo.aA(((apcy)localObject1).coc);
      }
    }
  }
  
  public static AIOImageProviderService a(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    String str = paramString1 + "_" + paramString2 + "_" + paramInt;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      if (paramChatMessage != null)
      {
        localObject1 = localObject2;
        if (paramChatMessage.isMultiMsg) {}
      }
      else
      {
        localObject1 = (AIOImageProviderService)gU.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AIOImageProviderService(paramString1, paramString2, paramInt, paramChatMessage);
    }
    return localObject2;
  }
  
  private BaseActivity a(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      this.af = new WeakReference(localObject);
      return localObject;
    }
    if (this.af != null) {
      localObject = (BaseActivity)this.af.get();
    }
    for (String str = null; localObject != null; str = "WeakReference Null") {
      return localObject;
    }
    localObject = str;
    if (str == null) {
      localObject = "WeakReference has freed";
    }
    dE((String)localObject, paramString);
    return null;
  }
  
  private ChatMessage a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      synchronized (this.sn)
      {
        Iterator localIterator = this.sn.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (MessageForPic.class.isInstance(localChatMessage))
          {
            MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
            if ((paramLong1 != localMessageForPic.uniseq) || (paramLong2 != localMessageForPic.subMsgId)) {
              continue;
            }
            return localChatMessage;
          }
          if (paramLong1 != localChatMessage.uniseq) {
            continue;
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  private MessageForTroopFile a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((this.gV != null) && (!this.gV.isEmpty())) {}
    for (Object localObject1 = (MessageForTroopFile)this.gV.get(paramString);; localObject1 = null)
    {
      if (localObject1 == null) {
        for (;;)
        {
          synchronized (this.sn)
          {
            Iterator localIterator = this.sn.iterator();
            if (localIterator.hasNext())
            {
              Object localObject2 = (ChatMessage)localIterator.next();
              if (MessageForTroopFile.class.isInstance(localObject2))
              {
                localObject2 = (MessageForTroopFile)localObject2;
                if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject2).url)) && (((MessageForTroopFile)localObject2).url.equals(paramString)))
                {
                  localObject1 = localObject2;
                  if ((this.gV != null) && (localObject1 != null)) {
                    this.gV.put(paramString, localObject1);
                  }
                  return localObject1;
                }
              }
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, agsw paramagsw)
  {
    aglf localaglf = agkw.a(paramagsw);
    localaglf.a(new xtz(this, paramagsw, paramLong, paramInt1, paramInt2));
    localaglf.a(new xua(this, paramagsw, paramLong));
    localaglf.setPlaying(true);
    localaglf.ZE();
  }
  
  private void a(QQAppInterface paramQQAppInterface, apcy paramapcy, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
    if ((paramapcy.Status == 11) && (aqhq.fileExists(paramapcy.LocalFile)))
    {
      if (this.jdField_c_of_type_Xui != null) {
        this.jdField_c_of_type_Xui.b(paramLong, paramInt1, paramInt2, 1, paramapcy.LocalFile, false);
      }
      return;
    }
    if ((paramapcy.Status == 7) || ((paramapcy.Status == 11) && (!aqhq.fileExists(paramapcy.LocalFile))))
    {
      paramQQAppInterface.a(paramapcy.FilePath, paramapcy.FileName, paramapcy.ProgressTotal, paramapcy.BusId);
      return;
    }
    paramQQAppInterface.c(paramapcy.Id);
  }
  
  private void a(QQAppInterface paramQQAppInterface, apcy paramapcy, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramapcy.ThumbnailFile_Large)) {
      if (!aqiw.isNetSupport(BaseApplicationImpl.getApplication())) {
        if (this.jdField_c_of_type_Xui != null) {
          this.jdField_c_of_type_Xui.b(paramMessageForTroopFile.uniseq, 0, 18, 2, paramapcy.ThumbnailFile_Large, false);
        }
      }
    }
    while (this.jdField_c_of_type_Xui == null)
    {
      return;
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramapcy.Id != null)
      {
        paramQQAppInterface.a(paramapcy.Id, 640);
        return;
      }
      paramQQAppInterface.e(paramapcy.FilePath, paramapcy.FileName, paramapcy.BusId, 640);
      return;
    }
    this.jdField_c_of_type_Xui.b(paramMessageForTroopFile.uniseq, 0, 18, 1, paramapcy.ThumbnailFile_Large, false);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    String str = paramChatMessage.frienduin;
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      paramChatMessage = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
      if (paramChatMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + paramInt + "], info == null");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video pause id:" + paramLong + " type:" + paramInt + " troopId:" + paramChatMessage.Id);
    }
    TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(str).longValue()).d(paramChatMessage.Id);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((akxv)paramQQAppInterface.getManager(73)).t(paramMessageForPic);
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface.a.c(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.consume();
  }
  
  private void a(MessageForFile paramMessageForFile, long paramLong)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      paramMessageForFile = ahav.a(localQQAppInterface, paramMessageForFile);
      localQQAppInterface.a().bZ(paramMessageForFile.nSessionId);
      return;
    }
    catch (Exception paramMessageForFile)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  private void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForTroopFile paramMessageForTroopFile)
  {
    int j = 1;
    int k = ahav.getFileType(paramMessageForTroopFile.fileName);
    int i;
    label26:
    Object localObject;
    if (k == 0)
    {
      i = 1;
      if (k != 2) {
        break label48;
      }
      localObject = apsv.a(getQQAppInterface(), paramMessageForTroopFile);
      if (localObject != null) {
        break label54;
      }
    }
    label48:
    label54:
    label92:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
          j = 0;
          break label26;
          if (i == 0) {
            break label92;
          }
          localObject = xtm.a(paramMessageForTroopFile, getQQAppInterface());
        } while (localObject == null);
        paramList.add(localObject);
        paramList1.add(paramMessageForTroopFile);
        return;
      } while ((j == 0) || ((!ahbj.fileExistsAndNotEmpty(((apcy)localObject).LocalFile)) && (!ahbr.aM(getQQAppInterface()))));
      localObject = xtm.a(paramMessageForTroopFile, getQQAppInterface());
    } while (localObject == null);
    paramList.add(localObject);
    paramList1.add(paramMessageForTroopFile);
  }
  
  private void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    int j = 1;
    int k = 0;
    MessageForFile localMessageForFile = (MessageForFile)paramMessageRecord;
    if ((top.eD(this.sessionType) == 1032) && (this.topicId > 0) && (paramMessageRecord.getConfessTopicId() != this.topicId)) {
      return;
    }
    paramMessageRecord = getQQAppInterface().a().a(localMessageForFile.uniseq, localMessageForFile.frienduin, localMessageForFile.istroop);
    int i;
    if ((paramMessageRecord != null) && (((ahav.s(paramMessageRecord)) && (paramMessageRecord.nFileType != 2)) || (16 != paramMessageRecord.status))) {
      if (paramMessageRecord.nFileType == 0)
      {
        i = 1;
        if (paramMessageRecord.nFileType != 2) {
          break label167;
        }
      }
    }
    for (;;)
    {
      label116:
      Object localObject = null;
      if (i != 0)
      {
        localMessageForFile.parse();
        paramMessageRecord = xtm.a(localMessageForFile, getQQAppInterface());
      }
      for (;;)
      {
        if (paramMessageRecord == null) {
          break label236;
        }
        paramList.add(paramMessageRecord);
        paramList1.add(localMessageForFile);
        return;
        i = 0;
        break;
        label167:
        j = 0;
        break label116;
        if (j != 0)
        {
          localMessageForFile.parse();
          paramMessageRecord = xtm.a(localMessageForFile, getQQAppInterface());
        }
        else
        {
          paramMessageRecord = localObject;
          if (QLog.isColorLevel())
          {
            QLog.i("AIOImageProviderService", 2, "ignore filePic: " + localMessageForFile);
            paramMessageRecord = localObject;
          }
        }
      }
      label236:
      break;
      i = 0;
      j = k;
    }
  }
  
  public static boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData)) {
      paramAIORichMediaData = (AIOShortVideoData)paramAIORichMediaData;
    }
    while ((AIOFileVideoData.class.isInstance(paramAIORichMediaData)) || (!AIOLightVideoData.class.isInstance(paramAIORichMediaData))) {
      return false;
    }
    return true;
  }
  
  private void b(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      case 17: 
      case 19: 
      default: 
        return;
      case 18: 
        paramAIOFilePicData.bim = true;
        return;
      case 20: 
        paramAIOFilePicData.bin = true;
        return;
      }
      paramAIOFilePicData.bio = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePicData.aVW = paramString;
      return;
    case 18: 
      paramAIOFilePicData.aVX = paramString;
      return;
    }
    paramAIOFilePicData.aVY = paramString;
  }
  
  private void b(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOImageData.bim = true;
      return;
      paramAIOImageData.bin = true;
      return;
      paramAIOImageData.bio = true;
      return;
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case 1: 
        paramAIOImageData.aVW = paramString;
        return;
      case 2: 
        paramAIOImageData.aVX = paramString;
      }
    } while ((paramAIOImageData.bjf) || (!new File(paramAIOImageData.aVW + "_hd").exists()));
    paramAIOImageData.aVW += "_hd";
    return;
    paramAIOImageData.aVY = paramString;
    return;
    paramAIOImageData.aVZ = paramString;
  }
  
  private void b(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOShortVideoData.bio = true;
        return;
      }
      paramAIOShortVideoData.bjB = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOShortVideoData.aWo = paramString;
      return;
    }
    paramAIOShortVideoData.aWp = paramString;
  }
  
  private void b(QQAppInterface paramQQAppInterface, apcy paramapcy, String paramString, MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramapcy.coc))
    {
      if ((!aqiw.isNetSupport(BaseApplicationImpl.getApplication())) && (this.jdField_c_of_type_Xui != null)) {
        this.jdField_c_of_type_Xui.b(paramMessageForTroopFile.uniseq, 0, 16, 2, paramapcy.ThumbnailFile_Large, false);
      }
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf(paramString).longValue());
      if (paramapcy.Id != null) {
        paramQQAppInterface.a(paramapcy.Id, 383);
      }
    }
    while (this.jdField_c_of_type_Xui == null)
    {
      return;
      paramQQAppInterface.e(paramapcy.FilePath, paramapcy.FileName, paramapcy.BusId, 383);
      return;
    }
    this.jdField_c_of_type_Xui.b(paramMessageForTroopFile.uniseq, 0, 1, 1, paramapcy.coc, false);
  }
  
  private void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, long paramLong, int paramInt)
  {
    Object localObject = paramChatMessage.frienduin;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    label191:
    do
    {
      do
      {
        return;
        paramChatMessage = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
        if (paramChatMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.main", 2, "onFileVideoStatusChange[" + paramInt + "], info == null");
      return;
      paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.valueOf((String)localObject).longValue());
      localObject = paramQQAppInterface.a(paramChatMessage.Id);
      if (ahbj.fileExistsAndNotEmpty(paramChatMessage.LocalFile))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop VideoPlayControllerForFile.main", 1, "Play id:" + paramLong + " type: FILE_VIDEO_PEEK_PAUSE file is exsited");
        }
        if (13 == paramInt)
        {
          localObject = BaseApplicationImpl.sApplication.getBaseContext();
          if (localObject == null) {
            break label191;
          }
          ahav.by((Context)localObject, paramChatMessage.LocalFile);
        }
        for (;;)
        {
          paramChatMessage = paramQQAppInterface.a(paramChatMessage.Id);
          if (paramChatMessage == null) {
            break;
          }
          paramQQAppInterface.c(paramChatMessage, 11);
          return;
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.main", 1, "set mobileqq video Play id:" + paramLong + " type:" + paramInt + " troopId:" + paramChatMessage.Id);
      }
    } while (localObject == null);
    paramQQAppInterface.c((TroopFileTransferManager.Item)localObject, 8);
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    ajlu localajlu = a();
    if (localajlu != null) {
      localajlu.d(paramMessageForPic, paramLong, paramInt1, paramInt2);
    }
  }
  
  private void dE(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localHashMap.put("result", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("fromaction", paramString1);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "ImageProviderService_getTopActivity_event", false, 0L, 0L, localHashMap, null);
  }
  
  private String getKey()
  {
    String str2 = this.myUin + "_" + this.friendUin + "_" + this.sessionType;
    String str1 = str2;
    if (this.isFlashPic) {
      str1 = str2 + "_f";
    }
    return str1;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      return localQQAppInterface;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      localAccountNotMatchException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
      }
    }
    return null;
  }
  
  private void go(List<AIORichMediaData> paramList)
  {
    xui localxui = this.jdField_c_of_type_Xui;
    ArrayList localArrayList;
    if (localxui != null)
    {
      localArrayList = new ArrayList();
      if ((this.sessionType != 1) && (this.sessionType != 1026)) {
        break label140;
      }
    }
    label140:
    for (Object localObject = paramList; (this.sessionType == 1) || (this.sessionType == 0) || (this.sessionType == 3000); localObject = this.jl)
    {
      localObject = (AIORichMediaData[])((List)localObject).toArray(new AIORichMediaData[((List)localObject).size()]);
      if (localObject.length > 0) {
        localxui.b((AIORichMediaData[])localObject, -1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a;
      if (localObject != null)
      {
        paramList = (AIORichMediaData[])paramList.toArray(new AIORichMediaData[paramList.size()]);
        if (paramList.length > 0) {
          ((a)localObject).a(paramList, -1);
        }
      }
      return;
    }
    List localList = this.jl;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < ((List)localObject).size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)((List)localObject).get(i);
          if (a(localAIORichMediaData)) {
            break label238;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      localObject = (AIORichMediaData[])localArrayList.toArray(new AIORichMediaData[localArrayList.size()]);
      break;
      label238:
      i += 1;
    }
  }
  
  public Intent a(MessageForFile paramMessageForFile)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (localFileManagerEntity == null) {
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putParcelable("fileinfo", ahhq.a(localFileManagerEntity, paramMessageForFile));
      localBundle.putString("forward_text", acfp.m(2131702255) + ahav.kY(localFileManagerEntity.fileName) + acfp.m(2131702257) + ahbj.g(localFileManagerEntity.fileSize) + "。");
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", ahav.q(localFileManagerEntity));
      if ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7))
      {
        localBundle.putBoolean("isFromShare", true);
        if (localFileManagerEntity.nFileType == 0) {
          localBundle.putInt("forward_type", 1);
        }
      }
      if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
        localBundle.putInt("forward_type", 1);
      }
      localIntent.putExtras(localBundle);
      return localIntent;
    }
    catch (AccountNotMatchException paramMessageForFile)
    {
      paramMessageForFile.printStackTrace();
    }
    return null;
  }
  
  public ChatMessage a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.sn)
      {
        Iterator localIterator = this.sn.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (paramLong != localChatMessage.uniseq) {
            continue;
          }
          return localChatMessage;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public MessageForShortVideo a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.sn)
      {
        Object localObject1 = this.sn.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject1).next();
          if ((paramLong != localChatMessage.uniseq) || (!MessageForShortVideo.class.isInstance(localChatMessage))) {
            continue;
          }
          localObject1 = (MessageForShortVideo)localChatMessage;
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public List<ChatMessage> a(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = a(paramArrayOfLong[i]);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a = parama;
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      AppRuntime localAppRuntime;
      FileManagerEntity localFileManagerEntity;
      try
      {
        localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
        localObject = ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
        if (localObject == null) {
          return;
        }
        localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().b(((FileManagerEntity)localObject).nSessionId);
        if (localFileManagerEntity == null) {
          break label272;
        }
        if (!TextUtils.isEmpty(paramMessageForFile.fileName)) {
          break label275;
        }
        paramMessageForFile.fileName = localFileManagerEntity.fileName;
      }
      catch (AccountNotMatchException paramMessageForFile)
      {
        paramMessageForFile.printStackTrace();
        return;
      }
      if (!M(paramMessageForFile)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 1, "msg is video, isTroop: " + paramMessageForFile.istroop);
      }
      if (paramMessageForFile.istroop == 3000)
      {
        a(paramLong, paramInt1, paramInt2, new agtd((QQAppInterface)localAppRuntime, localFileManagerEntity));
        return;
      }
      a(paramLong, paramInt1, paramInt2, new agta((QQAppInterface)localAppRuntime, localFileManagerEntity));
      return;
      ((FileManagerEntity)localObject).mContext = new String("igonFlow");
      ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject, 5);
      return;
      ((FileManagerEntity)localObject).mContext = new String("igonFlow");
      ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject, 7);
      return;
      ((QQAppInterface)localAppRuntime).a().l((FileManagerEntity)localObject);
      return;
      label272:
      continue;
      label275:
      Object localObject = localFileManagerEntity;
    }
    switch (paramInt2)
    {
    }
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 3: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "downloadImage fail, businessType not recognize");
      }
      break;
    }
    for (;;)
    {
      return;
      akxq localakxq = akxj.a(6, 1536, 1);
      int i = 1;
      try
      {
        for (;;)
        {
          localakxq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
          String str = aoiz.getFilePath(aoop.a(paramMessageForPic, i, null).toString().toString());
          localakxq.b(new xtx(this, paramLong, paramInt1, paramInt2, paramMessageForPic.size, str));
          akxj.a(localakxq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin));
          return;
          localakxq = akxj.a(7, 1);
          i = 131075;
          continue;
          localakxq = akxj.a(5, 1);
          i = 65537;
        }
      }
      catch (AccountNotMatchException paramMessageForPic)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "downloadImage, no appRuntime");
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "downloadImage end");
        }
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    ajlu localajlu = a();
    if (localajlu != null) {
      localajlu.c(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(MessageForTroopFile paramMessageForTroopFile, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      localObject = localQQAppInterface;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      apcy localapcy;
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                localAccountNotMatchException.printStackTrace();
              }
              localapcy = apsv.a(localObject, paramMessageForTroopFile);
              if (localapcy != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info == null");
            return;
            if (M(paramMessageForTroopFile))
            {
              if (QLog.isColorLevel()) {
                QLog.i("AIOImageProviderService", 1, "troop file is video, getUrl");
              }
              a(paramLong, paramInt1, paramInt2, new agtf(localObject, localapcy));
              return;
            }
            if (!TextUtils.isEmpty(localapcy.FilePath)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, info.FilePath is empty");
          return;
          str = localapcy.FilePath;
          str = paramMessageForTroopFile.frienduin;
        } while (TextUtils.isEmpty(str));
        if (paramInt2 == 20)
        {
          a(localObject, localapcy, str, paramLong, paramInt1, paramInt2);
          return;
        }
        if (paramInt2 == 18)
        {
          a(localObject, localapcy, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
          return;
        }
      } while (paramInt2 != 16);
      b(localObject, localapcy, str, paramMessageForTroopFile, paramLong, paramInt1, paramInt2);
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "downloadTroopFileImage, app == null");
      }
      return;
    }
  }
  
  protected void a(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if (((localMessageRecord instanceof MessageForPic)) && (!b((MessageForPic)localMessageRecord)))
      {
        ((MessageForPic)localMessageRecord).isInMixedMsg = true;
        paramList.add(b((MessageForPic)localMessageRecord));
        paramList1.add((MessageForPic)localMessageRecord);
      }
    }
  }
  
  public void a(xui paramxui)
  {
    super.a(paramxui);
    ajlu localajlu = a();
    if (localajlu != null) {
      localajlu.a(paramxui);
    }
  }
  
  protected List<AIORichMediaData> aG(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      O(localMessageRecord);
      if ((localMessageRecord instanceof MessageForPic)) {
        d(localArrayList1, localArrayList2, localMessageRecord);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localMessageRecord instanceof MessageForMixedMsg)) {
          a(localArrayList1, localArrayList2, (MessageForMixedMsg)localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForStructing)) {
          c(localArrayList1, localArrayList2, localMessageRecord);
        } else if (MessageForShortVideo.class.isInstance(localMessageRecord)) {
          b(localArrayList1, localArrayList2, localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForFile)) {
          a(localArrayList1, localArrayList2, localMessageRecord);
        } else if ((localMessageRecord instanceof MessageForTroopFile)) {
          a(localArrayList1, localArrayList2, (MessageForTroopFile)localMessageRecord);
        } else if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "messageRecordToData " + localMessageRecord.getBaseInfoString());
        }
      }
    }
    if (this.bjm)
    {
      this.sn.addAll(0, localArrayList2);
      this.jl.addAll(0, localArrayList1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "messageRecordToData total size " + localArrayList2.size() + ", cost " + (System.currentTimeMillis() - l));
      }
      return localArrayList1;
      this.sn.clear();
      this.jl.clear();
      this.sn.addAll(localArrayList2);
      this.jl.addAll(localArrayList1);
    }
  }
  
  protected AIOImageData b(MessageForPic paramMessageForPic)
  {
    return xtm.a(paramMessageForPic);
  }
  
  /* Error */
  public ChatMessage b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_3
    //   11: iload_3
    //   12: aload_0
    //   13: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   16: invokeinterface 987 1 0
    //   21: if_icmpge +156 -> 177
    //   24: aload_0
    //   25: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   28: iload_3
    //   29: invokeinterface 1005 2 0
    //   34: checkcast 126	com/tencent/mobileqq/data/ChatMessage
    //   37: astore 5
    //   39: lload_1
    //   40: aload 5
    //   42: getfield 651	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   45: lcmp
    //   46: ifne +95 -> 141
    //   49: iconst_1
    //   50: istore 4
    //   52: iload 4
    //   54: ifeq +14 -> 68
    //   57: aload_0
    //   58: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   61: iload_3
    //   62: invokeinterface 1229 2 0
    //   67: pop
    //   68: aload 6
    //   70: monitorexit
    //   71: aload_0
    //   72: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   75: astore 6
    //   77: aload 6
    //   79: monitorenter
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_3
    //   83: aload_0
    //   84: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   87: invokeinterface 987 1 0
    //   92: if_icmpge +79 -> 171
    //   95: aload_0
    //   96: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   99: iload_3
    //   100: invokeinterface 1005 2 0
    //   105: checkcast 989	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   108: getfield 1232	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:id	J
    //   111: lload_1
    //   112: lcmp
    //   113: ifne +43 -> 156
    //   116: iconst_1
    //   117: istore 4
    //   119: iload 4
    //   121: ifeq +14 -> 135
    //   124: aload_0
    //   125: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   128: iload_3
    //   129: invokeinterface 1229 2 0
    //   134: pop
    //   135: aload 6
    //   137: monitorexit
    //   138: aload 5
    //   140: areturn
    //   141: iload_3
    //   142: iconst_1
    //   143: iadd
    //   144: istore_3
    //   145: goto -134 -> 11
    //   148: astore 5
    //   150: aload 6
    //   152: monitorexit
    //   153: aload 5
    //   155: athrow
    //   156: iload_3
    //   157: iconst_1
    //   158: iadd
    //   159: istore_3
    //   160: goto -78 -> 82
    //   163: astore 5
    //   165: aload 6
    //   167: monitorexit
    //   168: aload 5
    //   170: athrow
    //   171: iconst_0
    //   172: istore 4
    //   174: goto -55 -> 119
    //   177: iconst_0
    //   178: istore 4
    //   180: aconst_null
    //   181: astore 5
    //   183: goto -131 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	AIOImageProviderService
    //   0	186	1	paramLong	long
    //   10	150	3	i	int
    //   50	129	4	j	int
    //   37	102	5	localChatMessage	ChatMessage
    //   148	6	5	localObject1	Object
    //   163	6	5	localObject2	Object
    //   181	1	5	localObject3	Object
    //   4	162	6	localList	List
    // Exception table:
    //   from	to	target	type
    //   11	49	148	finally
    //   57	68	148	finally
    //   68	71	148	finally
    //   150	153	148	finally
    //   82	116	163	finally
    //   124	135	163	finally
    //   135	138	163	finally
    //   165	168	163	finally
  }
  
  /* Error */
  public ChatMessage b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   7: astore 9
    //   9: aload 9
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore 6
    //   15: iload 6
    //   17: aload_0
    //   18: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   21: invokeinterface 987 1 0
    //   26: if_icmpge +217 -> 243
    //   29: aload_0
    //   30: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   33: iload 6
    //   35: invokeinterface 1005 2 0
    //   40: checkcast 126	com/tencent/mobileqq/data/ChatMessage
    //   43: astore 7
    //   45: ldc_w 646
    //   48: aload 7
    //   50: invokevirtual 179	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   53: ifeq +143 -> 196
    //   56: aload 7
    //   58: checkcast 646	com/tencent/mobileqq/data/MessageForPic
    //   61: astore 10
    //   63: lload_1
    //   64: aload 10
    //   66: getfield 647	com/tencent/mobileqq/data/MessageForPic:uniseq	J
    //   69: lcmp
    //   70: ifne +183 -> 253
    //   73: lload_3
    //   74: aload 10
    //   76: getfield 650	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   79: i2l
    //   80: lcmp
    //   81: ifne +172 -> 253
    //   84: iconst_1
    //   85: istore 5
    //   87: iload 5
    //   89: ifeq +15 -> 104
    //   92: aload_0
    //   93: getfield 83	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:sn	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 1229 2 0
    //   103: pop
    //   104: aload 9
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   111: astore 8
    //   113: aload 8
    //   115: monitorenter
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: aload_0
    //   122: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   125: invokeinterface 987 1 0
    //   130: if_icmpge +107 -> 237
    //   133: aload_0
    //   134: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   137: iload 5
    //   139: invokeinterface 1005 2 0
    //   144: checkcast 989	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   147: astore 9
    //   149: aload 9
    //   151: getfield 1232	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:id	J
    //   154: lload_1
    //   155: lcmp
    //   156: ifne +64 -> 220
    //   159: aload 9
    //   161: getfield 1235	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:subId	I
    //   164: i2l
    //   165: lload_3
    //   166: lcmp
    //   167: ifne +53 -> 220
    //   170: iconst_1
    //   171: istore 6
    //   173: iload 6
    //   175: ifeq +15 -> 190
    //   178: aload_0
    //   179: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jl	Ljava/util/List;
    //   182: iload 5
    //   184: invokeinterface 1229 2 0
    //   189: pop
    //   190: aload 8
    //   192: monitorexit
    //   193: aload 7
    //   195: areturn
    //   196: lload_1
    //   197: aload 7
    //   199: getfield 651	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   202: lcmp
    //   203: ifne +50 -> 253
    //   206: iconst_1
    //   207: istore 5
    //   209: goto -122 -> 87
    //   212: astore 7
    //   214: aload 9
    //   216: monitorexit
    //   217: aload 7
    //   219: athrow
    //   220: iload 5
    //   222: iconst_1
    //   223: iadd
    //   224: istore 5
    //   226: goto -107 -> 119
    //   229: astore 7
    //   231: aload 8
    //   233: monitorexit
    //   234: aload 7
    //   236: athrow
    //   237: iconst_0
    //   238: istore 6
    //   240: goto -67 -> 173
    //   243: iconst_0
    //   244: istore 5
    //   246: aload 8
    //   248: astore 7
    //   250: goto -163 -> 87
    //   253: iload 6
    //   255: iconst_1
    //   256: iadd
    //   257: istore 6
    //   259: goto -244 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	AIOImageProviderService
    //   0	262	1	paramLong1	long
    //   0	262	3	paramLong2	long
    //   85	160	5	i	int
    //   13	245	6	j	int
    //   43	155	7	localChatMessage	ChatMessage
    //   212	6	7	localObject1	Object
    //   229	6	7	localObject2	Object
    //   248	1	7	localList1	List
    //   1	246	8	localList2	List
    //   7	208	9	localObject3	Object
    //   61	14	10	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   15	84	212	finally
    //   92	104	212	finally
    //   104	107	212	finally
    //   196	206	212	finally
    //   214	217	212	finally
    //   119	170	229	finally
    //   178	190	229	finally
    //   190	193	229	finally
    //   231	234	229	finally
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    ajlu localajlu = a();
    if (localajlu != null) {
      localajlu.b(paramMessageForShortVideo, paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(MessageForTroopFile paramMessageForTroopFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if (localQQAppInterface1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, app == null");
        }
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      apcy localapcy;
      do
      {
        QQAppInterface localQQAppInterface2;
        do
        {
          do
          {
            for (;;)
            {
              localAccountNotMatchException.printStackTrace();
              localQQAppInterface2 = null;
            }
            paramMessageForTroopFile.isPause = true;
            localapcy = apsv.a(localQQAppInterface2, paramMessageForTroopFile);
            if (localapcy != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("AIOImageProviderService", 2, "cancelDownloadTroopOriginalImage, info == null");
          return;
          paramMessageForTroopFile = paramMessageForTroopFile.frienduin;
        } while (TextUtils.isEmpty(paramMessageForTroopFile));
        paramMessageForTroopFile = TroopFileTransferManager.a(localQQAppInterface2, Long.valueOf(paramMessageForTroopFile).longValue());
      } while (localapcy.Status != 8);
      paramMessageForTroopFile.d(localapcy.Id);
      paramMessageForTroopFile.c(localapcy.Id);
    }
  }
  
  protected void b(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    if (MessageForLightVideo.class.isInstance(paramMessageRecord))
    {
      paramMessageRecord = (MessageForLightVideo)paramMessageRecord;
      paramList.add(xtm.a(paramMessageRecord));
      paramList1.add(paramMessageRecord);
    }
    do
    {
      return;
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
    } while ((paramMessageRecord.busiType != 1) && (paramMessageRecord.busiType != 2) && (paramMessageRecord.busiType != 1007) && (paramMessageRecord.busiType != 1009) && (paramMessageRecord.busiType != 0));
    paramList.add(xtm.a(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void b(long[] paramArrayOfLong)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      List localList = a(paramArrayOfLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "saveToWeiyunMulti, idList.length = " + paramArrayOfLong.length);
      }
      paramArrayOfLong = a("saveToWeiyunMulti");
      if (paramArrayOfLong != null)
      {
        awpd.a((QQAppInterface)localAppRuntime, paramArrayOfLong, paramArrayOfLong.getTitleBarHeight(), localList, null);
        anot.a((QQAppInterface)localAppRuntime, "dc00898", "", "", "0X8009DBA", "0X8009DBA", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (AccountNotMatchException paramArrayOfLong)
    {
      paramArrayOfLong.printStackTrace();
      QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
    }
  }
  
  protected boolean b(MessageForPic paramMessageForPic)
  {
    if ((paramMessageForPic.msgtype == -3000) || (paramMessageForPic.msgtype == -30003)) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOImageProviderService", 2, "LoadMediaTask msgType is " + paramMessageForPic.msgtype);
      }
    }
    while ((acfx.W(paramMessageForPic)) || (acei.W(paramMessageForPic)) || ((top.eD(this.sessionType) == 1032) && (this.topicId > 0) && (paramMessageForPic.getConfessTopicId() != this.topicId)) || (xkl.a(paramMessageForPic)) || (ykm.d(paramMessageForPic))) {
      return true;
    }
    return false;
  }
  
  protected void ba(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_Aghq == null)
    {
      this.jdField_a_of_type_Aghq = new b(paramQQAppInterface);
      paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aghq);
    }
  }
  
  protected void bb(QQAppInterface paramQQAppInterface)
  {
    if (this.gV == null) {
      this.gV = new HashMap();
    }
    if (this.jdField_c_of_type_Accd == null)
    {
      this.jdField_c_of_type_Accd = new c();
      paramQQAppInterface.addObserver(this.jdField_c_of_type_Accd);
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.jl;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i >= this.jl.size()) {
          break label185;
        }
        localObject = (AIORichMediaData)this.jl.get(i);
        if (AIOImageData.class.isInstance(localObject))
        {
          localObject = (AIOImageData)localObject;
          if ((((AIOImageData)localObject).id != paramLong) || (((AIOImageData)localObject).subId != paramInt1)) {
            break label189;
          }
          b(paramInt2, paramString, (AIOImageData)localObject);
          return;
        }
        if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).id != paramLong) {
            break label189;
          }
          b(paramInt2, paramString, (AIOShortVideoData)localObject);
          return;
        }
      }
      finally {}
      if (AIOFilePicData.class.isInstance(localObject))
      {
        localObject = (AIOFilePicData)localObject;
        if (((AIOFilePicData)localObject).id == paramLong)
        {
          b(paramInt2, paramString, (AIOFilePicData)localObject);
          return;
          label185:
          return;
        }
      }
      label189:
      i += 1;
    }
  }
  
  public void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    ajlu localajlu = a();
    if ((paramInt2 != 24) && (localajlu != null) && (localajlu.S(paramMessageForPic))) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "cancelDownloadImage return");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt2 == 24) && (localajlu != null)) {}
        try
        {
          localajlu.e(paramMessageForPic, paramLong, paramInt1, paramInt2);
          paramMessageForPic = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).a().a(aooi.o(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
          if (!(paramMessageForPic instanceof aoju)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "destroy cancel processor c2c :" + paramMessageForPic);
          }
          ((aoji)paramMessageForPic).cancel();
          return;
        }
        catch (AccountNotMatchException paramMessageForPic) {}
      } while (!QLog.isColorLevel());
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      if ((paramMessageForPic instanceof aoji))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + paramMessageForPic);
        }
        ((aoji)paramMessageForPic).cancel();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "destroy cancel fail");
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if ((paramMessageForShortVideo.busiType == 0) && ((localAppRuntime instanceof QQAppInterface)) && (paramInt2 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "carverW downloadVideo GetUrlAction");
        }
        new xug((QQAppInterface)localAppRuntime, paramMessageForShortVideo, this.jdField_c_of_type_Xui, paramLong, paramInt1, paramInt2).ceS();
        return;
      }
      localangi = anfr.a(2, 2);
      localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
      if (paramInt2 != 0) {
        break label174;
      }
      localanfu.thumbPath = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
      localanfu.jv(paramMessageForShortVideo.istroop, 1);
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      AppRuntime localAppRuntime;
      angi localangi;
      anfu localanfu;
      while (QLog.isColorLevel())
      {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
        return;
        label174:
        localanfu.localPath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localanfu.jv(paramMessageForShortVideo.istroop, 0);
      }
    }
    localangi.c(localanfu);
    localangi.b(new xty(this, paramLong, paramInt1, paramInt2));
    anfr.a(localangi, (QQAppInterface)localAppRuntime);
    return;
  }
  
  protected void c(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    localMessageForStructing.parse();
    StructMsgForImageShare localStructMsgForImageShare;
    Object localObject2;
    Object localObject1;
    if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
    {
      localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
      ansu localansu = localStructMsgForImageShare.getFirstImageElement();
      if (localansu != null)
      {
        localObject2 = localansu.j;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (localansu.d == null) {
            localansu.d = localStructMsgForImageShare;
          }
          localObject1 = localansu.a();
        }
        localObject2 = b((MessageForPic)localObject1);
        ((AIOImageData)localObject2).time = localMessageForStructing.time;
        ((AIOImageData)localObject2).shmsgseq = localMessageForStructing.shmsgseq;
        if ((localStructMsgForImageShare.mMsgActionData == null) || (!localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk"))) {
          break label203;
        }
        ((AIOImageData)localObject2).EP = 1;
        ((AIOImageData)localObject2).bQ = localStructMsgForImageShare.getBytes();
        ((AIOImageData)localObject2).bWU = xtj.a(xtj.a(localStructMsgForImageShare));
      }
    }
    for (;;)
    {
      paramList.add(localObject2);
      paramList1.add(localObject1);
      return;
      label203:
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
      {
        ((AIOImageData)localObject2).EP = 2;
        ((AIOImageData)localObject2).bQ = localStructMsgForImageShare.getBytes();
        if ((aqiu.mt(paramMessageRecord.issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
          ((AIOImageData)localObject2).aVX = ((MessageForPic)localObject1).path;
        }
      }
      else if (ahtr.c(localStructMsgForImageShare))
      {
        ((AIOImageData)localObject2).EP = 5;
        ahtr.b((AIOImageData)localObject2, localStructMsgForImageShare);
      }
    }
  }
  
  public void cD(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "cleanMessage type = " + paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      acsp.c(paramString, paramInt, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin));
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "cleanMessage exception = " + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  public void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    ChatMessage localChatMessage = a(paramLong, paramInt1);
    if (localChatMessage != null)
    {
      if (!MessageForPic.class.isInstance(localChatMessage)) {
        break label39;
      }
      c((MessageForPic)localChatMessage, paramLong, paramInt1, paramInt2);
    }
    label39:
    do
    {
      do
      {
        return;
        if (!MessageForShortVideo.class.isInstance(localChatMessage)) {
          break;
        }
      } while (paramInt2 != 256);
      b((MessageForShortVideo)localChatMessage, paramLong, paramInt1, paramInt2);
      return;
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        a((MessageForFile)localChatMessage, paramLong);
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localChatMessage));
    b((MessageForTroopFile)localChatMessage);
  }
  
  public void ceR()
  {
    Object localObject = this.jdField_c_of_type_Xui;
    if (localObject != null) {
      ((xui)localObject).b(null, -1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a;
    if (localObject != null) {
      ((a)localObject).a(null, -1);
    }
  }
  
  protected void d(List<AIORichMediaData> paramList, List<ChatMessage> paramList1, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForPic)paramMessageRecord;
    paramMessageRecord.parse();
    if (b(paramMessageRecord)) {
      return;
    }
    paramList.add(b(paramMessageRecord));
    paramList1.add(paramMessageRecord);
  }
  
  public void destory()
  {
    super.destory();
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "[destroy] " + this.myUin + "_" + this.friendUin + "_" + this.sessionType);
    }
    this.sn.clear();
    this.jl.clear();
    gU.remove(getKey());
    this.friendUin = null;
    this.sessionType = 0;
    this.bWY = 60;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a = null;
    if (this.jdField_a_of_type_Aghq != null) {}
    try
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).a().deleteObserver(this.jdField_a_of_type_Aghq);
      this.jdField_a_of_type_Aghq = null;
      if (this.jdField_c_of_type_Accd == null) {}
    }
    catch (AccountNotMatchException localAccountNotMatchException1)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).removeObserver(this.jdField_c_of_type_Accd);
        this.jdField_c_of_type_Accd = null;
        QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver suc");
        if (this.gV != null)
        {
          this.gV.clear();
          this.gV = null;
        }
        QLog.e("AIOImageProviderService", 1, "～～～～～～～destory AIOImageProviderService～～～～～～～");
        this.myUin = null;
        return;
        localAccountNotMatchException1 = localAccountNotMatchException1;
        localAccountNotMatchException1.printStackTrace();
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        for (;;)
        {
          QLog.i("AIOImageProviderService<QFile>", 1, "clear TroopFileObserver, but AccountNotMatchException");
          localAccountNotMatchException2.printStackTrace();
        }
      }
    }
  }
  
  public void downloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramLong, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "carverW downloadMedia type=" + paramInt2 + " id=" + paramLong);
    }
    if (localObject != null) {
      if (MessageForPic.class.isInstance(localObject))
      {
        localObject = (MessageForPic)localObject;
        if (paramInt2 == 24) {
          b((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        a((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
        return;
        if (MessageForShortVideo.class.isInstance(localObject))
        {
          localObject = (MessageForShortVideo)localObject;
          if (paramInt2 == 256)
          {
            a((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
            return;
          }
          c((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
        if (MessageForFile.class.isInstance(localObject))
        {
          localObject = (MessageForFile)localObject;
          Looper localLooper = Looper.getMainLooper();
          if (Thread.currentThread() != localLooper.getThread())
          {
            new Handler(localLooper).post(new AIOImageProviderService.1(this, (MessageForFile)localObject, paramLong, paramInt1, paramInt2));
            return;
          }
          a((MessageForFile)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
        if (MessageForTroopFile.class.isInstance(localObject))
        {
          localObject = (MessageForTroopFile)localObject;
          ((MessageForTroopFile)localObject).isPause = false;
          a((MessageForTroopFile)localObject, paramLong, paramInt1, paramInt2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOImageProviderService", 2, "downloadMedia fail, msg type not recognize");
      return;
    }
    QLog.d("AIOImageProviderService", 2, "downloadMedia fail, not find msg");
  }
  
  public void favorite(long paramLong)
  {
    Object localObject2 = a(paramLong);
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
        if (localObject2 != null)
        {
          if (!MessageForFile.class.isInstance(localObject2)) {
            break label130;
          }
          localObject2 = (MessageForFile)localObject2;
          localObject1 = ((QQAppInterface)localObject1).a().a(((MessageForFile)localObject2).uniseq, ((MessageForFile)localObject2).frienduin, ((MessageForFile)localObject2).istroop);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
        QLog.e("AIOImageProviderService", 1, "getAppRuntime Exception!");
        return;
      }
      localObject2 = new Intent(BaseApplicationImpl.sApplication.getBaseContext(), FilePicQFavActivity.class);
      ((Intent)localObject2).putExtra("file_pic_favorites", localAccountNotMatchException.nSessionId);
      BaseApplicationImpl.sApplication.getBaseContext().startActivity((Intent)localObject2);
      return;
      label130:
      if (MessageForTroopFile.class.isInstance(localObject2))
      {
        MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localObject2;
        Object localObject3 = apsv.a((QQAppInterface)localAccountNotMatchException, localMessageForTroopFile);
        FileManagerEntity localFileManagerEntity = ahav.a((apcy)localObject3);
        localObject3 = apsf.a((QQAppInterface)localAccountNotMatchException, ((apcy)localObject3).TroopUin).a(localFileManagerEntity.strTroopFilePath);
        if (localObject3 != null)
        {
          localFileManagerEntity.lastTime = ((apbr)localObject3).dTh;
          localFileManagerEntity.selfUin = String.valueOf(((apbr)localObject3).aqT);
        }
        localObject3 = BaseApplicationImpl.sApplication.getBaseContext();
        if (localObject3 != null) {
          new aviz(3).a((QQAppInterface)localAccountNotMatchException, (Context)localObject3, localFileManagerEntity, (ChatMessage)localObject2, false);
        }
        while (localMessageForTroopFile.isMultiMsg)
        {
          anot.a((QQAppInterface)localAccountNotMatchException, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
          return;
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save fav].");
        }
      }
    }
  }
  
  public void gc(long paramLong)
  {
    ChatMessage localChatMessage = b(paramLong);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("revokeMsg msgseq:");
      if (localChatMessage == null) {
        break label65;
      }
    }
    label65:
    for (long l = localChatMessage.uniseq;; l = 0L)
    {
      QLog.i("AIOImageProviderService", 2, l + ", uniseq:" + paramLong);
      return;
    }
  }
  
  public void gd(long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.5(this, paramLong));
  }
  
  public void ge(long paramLong)
  {
    Object localObject1 = a(paramLong);
    if (localObject1 != null)
    {
      Object localObject2;
      ArrayList localArrayList;
      if (MessageForFile.class.isInstance(localObject1))
      {
        localObject2 = (MessageForFile)localObject1;
        if (((MessageForFile)localObject2).uniseq != paramLong) {
          return;
        }
        try
        {
          localObject1 = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
          localObject2 = ((QQAppInterface)localObject1).a().a(((MessageForFile)localObject2).uniseq, ((MessageForFile)localObject2).frienduin, ((MessageForFile)localObject2).istroop);
          if (localObject2 == null) {
            return;
          }
          localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          audx.b((QQAppInterface)localObject1, localArrayList, true);
          return;
        }
        catch (AccountNotMatchException localAccountNotMatchException1)
        {
          localAccountNotMatchException1.printStackTrace();
          return;
        }
      }
      if (MessageForTroopFile.class.isInstance(localAccountNotMatchException1))
      {
        MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localAccountNotMatchException1;
        if (localMessageForTroopFile.uniseq == paramLong) {
          try
          {
            localObject2 = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
            localArrayList = new ArrayList();
            localArrayList.add(localMessageForTroopFile);
            apsv.p((QQAppInterface)localObject2, localArrayList);
            return;
          }
          catch (AccountNotMatchException localAccountNotMatchException2)
          {
            localAccountNotMatchException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public Intent getFavorateParams(long paramLong, int paramInt)
    throws RemoteException
  {
    long l = paramInt;
    try
    {
      Object localObject1 = a(paramLong, l);
      if ((localObject1 != null) && (MessageForPic.class.isInstance(localObject1)))
      {
        Object localObject2 = (MessageForPic)localObject1;
        localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
        localObject1 = aviz.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).F();
        return localObject1;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
    throw new IllegalArgumentException("message not find..");
  }
  
  public Intent getForwardData(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramLong, paramInt1);
    if (localObject != null)
    {
      if (!MessageForPic.class.isInstance(localObject)) {
        break label53;
      }
      localObject = (MessageForPic)localObject;
      if ((((MessageForPic)localObject).uniseq != paramLong) || (((MessageForPic)localObject).subMsgId != paramInt1)) {}
    }
    return null;
    label53:
    Intent localIntent;
    if (MessageForShortVideo.class.isInstance(localObject))
    {
      localObject = (MessageForShortVideo)localObject;
      if (((MessageForShortVideo)localObject).uniseq != paramLong) {
        break label227;
      }
      localIntent = a((MessageForShortVideo)localObject);
      localObject = localIntent;
      if (localIntent != null) {
        localIntent.putExtra("from_uin_type", paramInt2);
      }
    }
    label227:
    for (localObject = localIntent;; localObject = null)
    {
      return localObject;
      if (MessageForFile.class.isInstance(localObject))
      {
        localObject = (MessageForFile)localObject;
        if (((MessageForFile)localObject).uniseq != paramLong) {
          break;
        }
        return a((MessageForFile)localObject);
      }
      if (!MessageForTroopFile.class.isInstance(localObject)) {
        break;
      }
      localObject = (MessageForTroopFile)localObject;
      if (((MessageForTroopFile)localObject).uniseq != paramLong)
      {
        QLog.e("AIOImageProviderService", 1, "msg id : " + ((MessageForTroopFile)localObject).uniseq + " request id:" + paramLong);
        return null;
      }
      return a((MessageForTroopFile)localObject);
    }
  }
  
  public int getSaveFileProgress(long paramLong, int paramInt)
  {
    int j = -1;
    Object localObject = a();
    int i = j;
    if (localObject != null)
    {
      ChatMessage localChatMessage = a(paramLong, paramInt);
      if ((localChatMessage == null) && (QLog.isColorLevel())) {
        QLog.i("AIOImageProviderService", 2, "getSaveFileProgress chatMessage is null");
      }
      localObject = ((ajlu)localObject).a(((ajlu)localObject).h(localChatMessage));
      i = j;
      if (localObject != null)
      {
        i = j;
        if (!((ajlq)localObject).isCompleted)
        {
          i = j;
          if (((ajlq)localObject).djL == 1) {
            i = ((ajlq)localObject).progress;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "getSaveFileProgress progress = " + i);
    }
    return i;
  }
  
  public String getTroopMemberName(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).getManager(52);
      paramString1 = localTroopManager.getTroopMemberName(localTroopManager.jp(paramString1), paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "getTroopMemberName exception = " + paramString1.getMessage());
      }
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public void i(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo != null) {
      paramMessageForShortVideo.serial();
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      }
      return;
    }
    catch (Exception paramMessageForShortVideo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, paramMessageForShortVideo.toString());
    }
  }
  
  public void loadMedias(int paramInt)
  {
    if ((this.jdField_c_of_type_Xui == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "[loadMedias] + loadType: " + paramInt + ", dataList.size = " + this.jl.size());
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
        return;
      }
    } while (this.jdField_c_of_type_Xui == null);
    ArrayList localArrayList;
    if (this.jl.size() > 0)
    {
      localArrayList = new ArrayList();
      ??? = this.jl;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jl.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jl.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label324;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])localObject2.toArray(new AIORichMediaData[localObject2.size()]);
      this.jdField_c_of_type_Xui.b((AIORichMediaData[])???, -1);
      return;
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a == null) {
        break;
      }
      if (this.jl.size() > 0) {
        synchronized (this.jl)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jl.toArray(new AIORichMediaData[this.jl.size()]);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$a.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$IncreasinglyLoadMediaTask, 64, null, false);
      return;
      label324:
      paramInt += 1;
    }
  }
  
  public void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle)
  {
    ChatMessage localChatMessage;
    QQAppInterface localQQAppInterface;
    try
    {
      localChatMessage = a(paramLong);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if ((localChatMessage != null) && (M(localChatMessage))) {
        break label341;
      }
      QLog.e("VideoPlayControllerForFile.main", 1, "msg is not video, id:" + paramLong);
      return;
    }
    catch (AccountNotMatchException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    agkw.ci(paramBundle.getString("contextid"), true);
    return;
    agkw.IM(paramBundle.getString("contextid"));
    if (MessageForTroopFile.class.isInstance(localChatMessage))
    {
      a(localQQAppInterface, localChatMessage, paramLong, paramInt);
      return;
    }
    paramBundle = (MessageForFile)localChatMessage;
    paramBundle = localQQAppInterface.a().a(paramBundle.uniseq, paramBundle.frienduin, paramBundle.istroop);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.main", 1, "set  video pause id:" + paramLong + " type: FILE_VIDEO_PEEK_CANCEL entityId:" + paramBundle.nSessionId);
      }
      localQQAppInterface.a().bZ(paramBundle.nSessionId);
      return;
      if (!this.qM.contains(Long.valueOf(paramLong))) {
        this.qM.add(Long.valueOf(paramLong));
      }
      paramBundle = paramBundle.getString("contextid");
      agkw.fM(paramBundle);
      agkw.ci(paramBundle, true);
      if (MessageForTroopFile.class.isInstance(localChatMessage))
      {
        b(localQQAppInterface, localChatMessage, paramLong, paramInt);
        return;
        paramBundle = paramBundle.getString("contextid");
        agkw.fM(paramBundle);
        agkw.ci(paramBundle, false);
        if (MessageForTroopFile.class.isInstance(localChatMessage))
        {
          b(localQQAppInterface, localChatMessage, paramLong, paramInt);
          return;
          agkw.IN(paramBundle.getString("contextid"));
        }
      }
    }
    return;
    label341:
    switch (paramInt)
    {
    }
  }
  
  public void payFlow(long paramLong, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AIOImageProviderService.4(this, paramLong, paramInt));
  }
  
  public void reportData(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "reportData,sendReportType:" + paramString + ",count:" + paramInt);
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      if (paramInt == 55)
      {
        zsz.a(paramString, this.sessionType, (QQAppInterface)localAppRuntime);
        return;
      }
      anpc.a(BaseApplication.getContext()).a(localAppRuntime, this.myUin, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      throw new IllegalArgumentException("no appRuntime", paramString);
    }
  }
  
  public void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    BaseActivity localBaseActivity = a("safetyReport");
    if (localBaseActivity != null) {
      ThreadManager.getUIHandler().post(new AIOImageProviderService.6(this, paramBoolean, localBaseActivity, paramString2, paramString1, paramString3, paramString4, paramInt));
    }
  }
  
  public void saveToWeiyun(long paramLong)
  {
    AppRuntime localAppRuntime;
    Object localObject2;
    label92:
    String str;
    label200:
    BaseActivity localBaseActivity;
    do
    {
      do
      {
        do
        {
          try
          {
            localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
            Object localObject1 = a(paramLong);
            if (localObject1 != null)
            {
              if (!MessageForFile.class.isInstance(localObject1)) {
                break label200;
              }
              localObject1 = (MessageForFile)localObject1;
              if (((MessageForFile)localObject1).uniseq == paramLong)
              {
                localObject2 = ((QQAppInterface)localAppRuntime).a().a(((MessageForFile)localObject1).uniseq, ((MessageForFile)localObject1).frienduin, ((MessageForFile)localObject1).istroop);
                if (localObject2 != null) {
                  break label92;
                }
              }
            }
            return;
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            localAccountNotMatchException.printStackTrace();
            QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
            return;
          }
          switch (((FileManagerEntity)localObject2).getCloudType())
          {
          case 2: 
          case 4: 
          default: 
            return;
          case 1: 
            if (localAccountNotMatchException.isSend()) {}
            for (str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();; str = ((FileManagerEntity)localObject2).peerUin)
            {
              ((QQAppInterface)localAppRuntime).a().a((FileManagerEntity)localObject2, str);
              return;
            }
          }
          ((QQAppInterface)localAppRuntime).a().a(((FileManagerEntity)localObject2).getFilePath(), null, localAppRuntime.getAccount(), 0, false);
          return;
          if (MessageForTroopFile.class.isInstance(str))
          {
            localObject2 = BaseApplicationImpl.sApplication.getBaseContext();
            if (localObject2 != null)
            {
              apsv.d((Context)localObject2, (QQAppInterface)localAppRuntime, str);
              return;
            }
            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file to weiyun].");
            return;
          }
          if (!(str instanceof MessageForPic)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single pic, uniseq = " + str.uniseq);
          }
          localObject2 = new ArrayList(1);
          ((List)localObject2).add(str);
          localBaseActivity = a("saveToWeiyun_MessageForPic");
        } while (localBaseActivity == null);
        awpd.b((QQAppInterface)localAppRuntime, localBaseActivity, localBaseActivity.getTitleBarHeight(), (List)localObject2, null);
        anot.a((QQAppInterface)localAppRuntime, "dc00898", "", str.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
        return;
      } while (!(str instanceof MessageForShortVideo));
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "saveToWeiyun, save single video, uniseq = " + str.uniseq);
      }
      localObject2 = new ArrayList(1);
      ((List)localObject2).add(str);
      localBaseActivity = a("saveToWeiyun_MessageForShortVideo");
    } while (localBaseActivity == null);
    awpd.b((QQAppInterface)localAppRuntime, localBaseActivity, localBaseActivity.getTitleBarHeight(), (List)localObject2, null);
    anot.a((QQAppInterface)localAppRuntime, "dc00898", "", str.frienduin, "0X8009DB8", "0X8009DB8", 0, 0, "", "", "", "");
  }
  
  public void sendFileToPC(long paramLong)
  {
    ChatMessage localChatMessage;
    do
    {
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
        localChatMessage = a(paramLong);
        if (localChatMessage == null) {
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
        QLog.e("AIOImageProviderService", 1, "saveToWeiyun get app faild");
        return;
      }
      if (MessageForFile.class.isInstance(localChatMessage))
      {
        localContext = BaseApplicationImpl.sApplication.getBaseContext();
        if (localContext != null)
        {
          ahav.a((QQAppInterface)localAccountNotMatchException, localChatMessage, localContext);
          return;
        }
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file send pc].");
        return;
      }
    } while (!MessageForTroopFile.class.isInstance(localChatMessage));
    Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
    if (localContext != null)
    {
      apsv.c(localContext, (QQAppInterface)localAccountNotMatchException, localChatMessage);
      return;
    }
    QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file send pc].");
  }
  
  public void unregisterCallback()
  {
    this.jdField_c_of_type_Xui = null;
    ajlu localajlu = a();
    if (localajlu != null) {
      localajlu.unregisterCallback();
    }
  }
  
  class IncreasinglyLoadMediaTask
    implements Runnable
  {
    IncreasinglyLoadMediaTask() {}
    
    public void run()
    {
      for (;;)
      {
        try
        {
          AIOImageProviderService.this.isLoading = true;
          if (AIOImageProviderService.this.bWY < 60)
          {
            AIOImageProviderService.this.isLoading = false;
            AIOImageProviderService.this.ceR();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          long l;
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int[] arrayOfInt;
          Object localObject4;
          Object localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
          AIOImageProviderService.this.isLoading = false;
          continue;
          List localList = AIOImageProviderService.a(AIOImageProviderService.this).b().a(AIOImageProviderService.this.friendUin, AIOImageProviderService.this.sessionType, AIOImageProviderService.this.FH, AIOImageProviderService.this.bFx, AIOImageProviderService.this.FJ, arrayOfInt, 60);
          continue;
          if ((AIOImageProviderService.a(AIOImageProviderService.this).a() != null) && (!AIOImageProviderService.this.bjm)) {
            continue;
          }
          AIOImageProviderService.this.isLoading = false;
          AIOImageProviderService.this.ceR();
          AIOImageProviderService.this.isLoading = false;
          continue;
          localList = ahav.bg(AIOImageProviderService.a(AIOImageProviderService.this).a().k(AIOImageProviderService.this.Jy));
          continue;
          localArrayList1.addAll(0, localList);
          localArrayList2.addAll(0, AIOImageProviderService.this.aG(localList));
          continue;
        }
        catch (Exception localException)
        {
          label135:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImageProviderService", 2, "IncreasinglyLoadMediaTask exception = " + localException.getMessage());
          AIOImageProviderService.this.isLoading = false;
          continue;
          AIOImageProviderService.this.ceR();
          continue;
        }
        finally
        {
          AIOImageProviderService.this.isLoading = false;
        }
        try
        {
          AIOImageProviderService.this.isLoading = false;
          return;
        }
        finally {}
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] start");
        }
        if ((AIOImageProviderService.this.c == null) && (AIOImageProviderService.this.a == null))
        {
          AIOImageProviderService.this.isLoading = false;
          AIOImageProviderService.this.ceR();
          AIOImageProviderService.this.isLoading = false;
        }
        else
        {
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if (AIOImageProviderService.this.isMultiMsg) {
            continue;
          }
          if (AIOImageProviderService.this.friendUin != null) {
            continue;
          }
          AIOImageProviderService.this.isLoading = false;
          AIOImageProviderService.this.ceR();
          AIOImageProviderService.this.isLoading = false;
        }
      }
      arrayOfInt = new int[8];
      int[] tmp189_187 = arrayOfInt;
      tmp189_187[0] = -20000;
      int[] tmp195_189 = tmp189_187;
      tmp195_189[1] = -2000;
      int[] tmp201_195 = tmp195_189;
      tmp201_195[2] = -1035;
      int[] tmp207_201 = tmp201_195;
      tmp207_201[3] = -2011;
      int[] tmp213_207 = tmp207_201;
      tmp213_207[4] = -2022;
      int[] tmp219_213 = tmp213_207;
      tmp219_213[5] = -2005;
      int[] tmp225_219 = tmp219_213;
      tmp225_219[6] = -2017;
      int[] tmp232_225 = tmp225_219;
      tmp232_225[7] = -2071;
      tmp232_225;
      if (!AIOImageProviderService.this.bjm)
      {
        localObject4 = AIOImageProviderService.a(AIOImageProviderService.this).a(AIOImageProviderService.this.sessionType).a(AIOImageProviderService.this.friendUin, AIOImageProviderService.this.sessionType, arrayOfInt);
        localObject2 = localObject4;
        if (((List)localObject4).size() < 60)
        {
          localObject2 = AIOImageProviderService.a(AIOImageProviderService.this).b().a(AIOImageProviderService.this.friendUin, AIOImageProviderService.this.sessionType, arrayOfInt, 60);
          AIOImageProviderService.this.bWY = ((List)localObject2).size();
        }
      }
      for (;;)
      {
        if (AIOImageProviderService.this.bjm) {
          break label809;
        }
        localArrayList1.addAll((Collection)localObject2);
        localArrayList2.addAll(AIOImageProviderService.this.aG((List)localObject2));
        AIOImageProviderService.this.bjm = true;
        if ((!AIOImageProviderService.this.isMultiMsg) && (localArrayList2.size() < 30) && (AIOImageProviderService.this.bWY >= 60)) {
          break label135;
        }
        if (localArrayList2.size() <= 0) {
          break label885;
        }
        AIOImageProviderService.a(AIOImageProviderService.this, localArrayList2);
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + AIOImageProviderService.this.isMultiMsg + ", tempList.size: " + localArrayList1.size() + ", tempDataList.size: " + localArrayList2.size() + ", cost:" + (System.currentTimeMillis() - l));
        }
        AIOImageProviderService.this.isLoading = false;
        break;
        if (!top.fs(AIOImageProviderService.this.sessionType)) {
          break label677;
        }
        localObject2 = AIOImageProviderService.this;
        ((AIOImageProviderService)localObject2).FI -= 1L;
        localObject2 = AIOImageProviderService.a(AIOImageProviderService.this).b().a(AIOImageProviderService.this.friendUin, AIOImageProviderService.this.sessionType, AIOImageProviderService.this.FH, AIOImageProviderService.this.bFx, AIOImageProviderService.this.FI, arrayOfInt, 60);
        AIOImageProviderService.this.bWY = ((List)localObject2).size();
        localObject4 = AIOImageProviderService.this;
        ((AIOImageProviderService)localObject4).bWZ += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
    
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
    
    public abstract void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
  }
  
  class b
    extends aghq
  {
    private QQAppInterface mApp;
    
    public b(QQAppInterface paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
    }
    
    public void a(agnk paramagnk)
    {
      long l = paramagnk.nSessionId;
      FileManagerEntity localFileManagerEntity = this.mApp.a().b(l);
      xui localxui = AIOImageProviderService.this.c;
      if ((localFileManagerEntity == null) || (localxui == null))
      {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + localFileManagerEntity + "] callback[" + localxui + "]");
        return;
      }
      int i = 18;
      if (paramagnk.thumbSize == 5) {
        i = 16;
      }
      if (ahbj.isFileExists(paramagnk.filePath))
      {
        localxui.b(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramagnk.filePath, false);
        AIOImageProviderService.this.c(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramagnk.filePath);
        return;
      }
      paramagnk = "";
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("errorType", "thumb_download");
        ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
        localObject = ((JSONObject)localObject).toString();
        paramagnk = (agnk)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      localxui.b(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramagnk, false);
      AIOImageProviderService.this.c(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
    }
    
    public void a(agnk paramagnk, int paramInt)
    {
      long l = paramagnk.nSessionId;
      paramagnk = this.mApp.a().b(l);
      xui localxui = AIOImageProviderService.this.c;
      if ((paramagnk == null) || (localxui == null))
      {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramagnk + "] callback[" + localxui + "]");
        return;
      }
      localxui.b(paramagnk.uniseq, paramagnk.status, 18, paramInt, paramagnk.fileSize, false);
    }
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      paramString = this.mApp.a().b(paramLong2);
      xui localxui = AIOImageProviderService.this.c;
      if ((paramString == null) || (localxui == null)) {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString + "] callback[" + localxui + "]");
      }
      while (paramString.nFileType != 0) {
        return;
      }
      localxui.b(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
    }
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      paramString1 = this.mApp.a().b(paramLong2);
      xui localxui = AIOImageProviderService.this.c;
      if ((paramString1 == null) || (localxui == null)) {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString1 + "] callback[" + localxui + "]");
      }
      label217:
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break;
          }
          if (paramString1.nFileType == 0)
          {
            localxui.b(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
            AIOImageProviderService.this.c(paramLong1, paramString1.status, 20, paramString1.getFilePath());
            return;
          }
        } while (paramString1.nFileType != 2);
        if (AIOImageProviderService.this.qM.contains(Long.valueOf(paramLong1)))
        {
          paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
          if (paramString2 == null) {
            break label217;
          }
          ahav.by(paramString2, paramString1.getFilePath());
        }
        for (;;)
        {
          AIOImageProviderService.this.qM.remove(Long.valueOf(paramLong1));
          localxui.b(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
          return;
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
        }
        if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
          paramString1.status = 16;
        }
        if (paramString1.nFileType == 0)
        {
          localxui.b(paramLong1, paramString1.status, 20, 2, paramString2, false);
          AIOImageProviderService.this.c(paramLong1, paramString1.status, 20, "I:E");
          return;
        }
      } while (paramString1.nFileType != 2);
      localxui.b(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
    }
  }
  
  class c
    extends accd
  {
    c() {}
    
    private void b(apcy paramapcy, MessageForTroopFile paramMessageForTroopFile)
    {
      if (aqhq.fileExistsAndNotEmpty(paramapcy.coc)) {
        AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 16, 1, paramapcy.coc, false);
      }
      label157:
      do
      {
        for (;;)
        {
          if (!aqhq.fileExistsAndNotEmpty(paramapcy.ThumbnailFile_Large)) {
            break label157;
          }
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 18, 1, paramapcy.ThumbnailFile_Large, false);
          return;
          if (paramapcy.thumbInvalidCode != 0) {
            localObject1 = "";
          }
          try
          {
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("errorType", "thumb_download");
            ((JSONObject)localObject2).put("errorCode", paramapcy.thumbInvalidCode);
            localObject2 = ((JSONObject)localObject2).toString();
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject1, false);
        }
      } while (paramapcy.thumbInvalidCode == 0);
      Object localObject1 = "";
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("errorType", "thumb_download");
        localJSONObject.put("errorCode", paramapcy.thumbInvalidCode);
        paramapcy = localJSONObject.toString();
        AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 18, 2, paramapcy, false);
        return;
      }
      catch (JSONException paramapcy)
      {
        for (;;)
        {
          paramapcy.printStackTrace();
          paramapcy = (apcy)localObject1;
        }
      }
    }
    
    private void c(apcy paramapcy, MessageForTroopFile paramMessageForTroopFile)
    {
      if (AIOImageProviderService.a(AIOImageProviderService.this, paramMessageForTroopFile)) {
        if ((paramapcy.Status == 8) && (paramapcy.ProgressTotal > 0L))
        {
          int i = (int)((float)paramapcy.ProgressValue / (float)paramapcy.ProgressTotal * 10000.0F);
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 1, i, paramapcy.ProgressTotal, true);
        }
      }
      label165:
      do
      {
        do
        {
          do
          {
            return;
            if (paramapcy.Status == 11)
            {
              if (AIOImageProviderService.this.qM.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
              {
                Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
                if (localContext == null) {
                  break label165;
                }
                ahav.by(localContext, paramapcy.LocalFile);
              }
              for (;;)
              {
                AIOImageProviderService.this.qM.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
                AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 1, 269484034, 1, paramapcy.LocalFile, false);
                return;
                QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
              }
            }
          } while ((paramapcy.Status != 12) && (paramapcy.Status != 10));
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 269484034, 2, paramapcy.LocalFile, false);
          return;
          if (!paramMessageForTroopFile.isPause) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + paramapcy.Status);
        return;
        if ((paramapcy.Status == 8) && (paramapcy.ProgressTotal > 0L))
        {
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 20, (int)(paramapcy.ProgressValue * 10000L / paramapcy.ProgressTotal), paramMessageForTroopFile.fileSize, true);
          return;
        }
        if (paramapcy.Status == 11)
        {
          AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 20, 1, paramapcy.LocalFile, false);
          return;
        }
      } while ((paramapcy.Status != 12) && (paramapcy.Status != 10));
      AIOImageProviderService.this.c.b(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
    }
    
    public void ar(Object paramObject)
    {
      apcy localapcy = (apcy)paramObject;
      paramObject = null;
      if (localapcy != null) {
        paramObject = AIOImageProviderService.a(AIOImageProviderService.this, localapcy.FilePath);
      }
      if ((localapcy == null) || (paramObject == null))
      {
        QLog.i("AIOImageProviderService", 2, "onTroopFileStatusUpdate: error, info[" + localapcy + "] troopFileMsg[" + paramObject + "]");
        return;
      }
      if (!paramObject.url.equals(localapcy.FilePath))
      {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + localapcy.FilePath + "]");
        return;
      }
      if (AIOImageProviderService.this.c == null)
      {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
        return;
      }
      b(localapcy, paramObject);
      c(localapcy, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */