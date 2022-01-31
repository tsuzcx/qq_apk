package cooperation.qlink;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import iam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Timer;

public class QQProxyForQlink
  extends Observable
  implements QlAndQQInterface.Ql2QQ
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = "QQProxyForQlink";
  private static final String b = "trans_failed_infos";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private Map jdField_a_of_type_JavaUtilMap = null;
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QQProxyForQlink(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private int a()
  {
    int i = 0;
    try
    {
      Map localMap = BaseApplication.getContext().getSharedPreferences("trans_failed_infos", 0).getAll();
      if (localMap != null) {
        i = localMap.size();
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  private int a(long paramLong)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).intValue();
  }
  
  private FileManagerEntity a(String paramString, QLAndQQStructDef.Ql2QQRecvFileInfo paramQl2QQRecvFileInfo)
  {
    String str1 = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramQl2QQRecvFileInfo.filename, 0, null);
    String str2 = TransfileUtile.a(str1, paramQl2QQRecvFileInfo.filesize, 0, false, null);
    long l = MessageRecordFactory.a(-2005).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString, 0);
    a(localFileManagerEntity, paramQl2QQRecvFileInfo.fileinfo);
    localFileManagerEntity.nSessionId = paramQl2QQRecvFileInfo.fileinfo.fileSessionId;
    localFileManagerEntity.cloudType = 5;
    localFileManagerEntity.fileName = paramQl2QQRecvFileInfo.filename;
    localFileManagerEntity.fileSize = paramQl2QQRecvFileInfo.filesize;
    localFileManagerEntity.nOpType = 1;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    if (paramQl2QQRecvFileInfo.failed) {
      if (-2 == paramQl2QQRecvFileInfo.errCode) {
        localFileManagerEntity.status = 19;
      }
    }
    for (;;)
    {
      if ((paramQl2QQRecvFileInfo.fileinfo != null) && (paramQl2QQRecvFileInfo.fileinfo.thumPath != null)) {
        localFileManagerEntity.strThumbPath = paramQl2QQRecvFileInfo.fileinfo.thumPath;
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.msgUid = FileManagerUtil.b();
      localFileManagerEntity.qlmsgSrc = paramQl2QQRecvFileInfo.source;
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + localFileManagerEntity.nSessionId + "] insertRecevieFileMsgToQQ. filename:" + localFileManagerEntity.fileName + " fileSize:" + localFileManagerEntity.fileSize + " thumbPath:" + localFileManagerEntity.strThumbPath);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      int i = 0;
      if (!((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString)) {
        i = 1001;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramString, false, str1, 0L, true, i, str2, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 0, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      return localFileManagerEntity;
      localFileManagerEntity.status = 0;
      localFileManagerEntity.errCode = -102;
      continue;
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nWeiYunSrcType = paramQl2QQRecvFileInfo.peerIp;
      localFileManagerEntity.nOlSenderProgress = paramQl2QQRecvFileInfo.peerPort;
    }
  }
  
  private FileManagerEntity a(String paramString1, QLAndQQStructDef.SendFileNbyInfo paramSendFileNbyInfo, String paramString2)
  {
    String str1 = TransfileUtile.a(paramString2, 0L, 0, true);
    String str2 = FileManagerUtil.a(paramString2);
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString1, 0);
    localFileManagerEntity.nOpType = 0;
    localFileManagerEntity.fileSize = FileManagerUtil.a(paramString2);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
    localFileManagerEntity.strFilePath = paramString2;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.fileName = str2;
    localFileManagerEntity.cloudType = 5;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.status = 18;
    localFileManagerEntity.qlmsgSrc = paramSendFileNbyInfo.source;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    int i = 0;
    if (!((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString1)) {
      i = 1001;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, paramString2, 0L, true, i, str1, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, i, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
    return localFileManagerEntity;
  }
  
  private Map a()
  {
    localHashMap = new HashMap();
    try
    {
      Object localObject = BaseApplication.getContext().getSharedPreferences("trans_failed_infos", 0).getAll();
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localHashMap.put(Long.valueOf((String)localEntry.getKey()), localEntry.getValue());
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return localHashMap;
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ addSid2MsgExtraInfo:" + paramLong + "-" + paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[" + paramLong1 + "] addTransFailedInfo. failedTime:" + paramLong2);
      }
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("trans_failed_infos", 0).edit();
      localEditor.putLong(String.valueOf(paramLong1), paramLong2);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean, QLAndQQStructDef.ReportNbFileFileRecvInfo paramReportNbFileFileRecvInfo)
  {
    if ((paramReportNbFileFileRecvInfo == null) || (paramReportNbFileFileRecvInfo.sessionid == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [QL_REPORT] reportNbFileFileRecv. data=null");
      return;
    }
    long l = Long.valueOf(paramReportNbFileFileRecvInfo.sessionid).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileRecv. start:" + paramBoolean);
    }
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (paramBoolean)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileRecv start. but had report start!");
          }
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
    }
    while (this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(l)))
    {
      QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramReportNbFileFileRecvInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileRecv end. but had report end!");
    }
  }
  
  private void a(boolean paramBoolean, QLAndQQStructDef.ReportNbFileFileSendInfo paramReportNbFileFileSendInfo)
  {
    if ((paramReportNbFileFileSendInfo == null) || (paramReportNbFileFileSendInfo.sessionid == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [QL_REPORT] reportNbFileFileSend. data=null");
      return;
    }
    long l = Long.valueOf(paramReportNbFileFileSendInfo.sessionid).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileSend. start:" + paramBoolean);
    }
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (paramBoolean)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileSend start. but had report start!");
          }
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
    }
    while (this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(l)))
    {
      QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramReportNbFileFileSendInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + l + "] reportNbFileFileSend end. but had report end!");
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (1 == paramInt) || (16 == paramInt) || (17 == paramInt) || (19 == paramInt) || (paramInt == 0);
  }
  
  private void b(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] removeTransFailedInfo.");
      }
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("trans_failed_infos", 0).edit();
      localEditor.remove(String.valueOf(paramLong));
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ startTrans2InvaildTimer...");
        }
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(new iam(this), 30000L, 30000L);
      }
      return;
    }
    finally {}
  }
  
  private void c(long paramLong)
  {
    a(paramLong, MessageCache.a() * 1000L);
    c();
  }
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ stopTrans2InvaildTimer...");
        }
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally {}
  }
  
  private void d(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ removeSid2MsgExtraInfo:" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  private void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + paramLong + "] reportNbFileFileRecvToTakeOverFromQl <- QL");
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [QL_REPORT] [" + paramLong + "] reportNbFileFileRecvToTakeOverFromQl. but had takeover!");
        }
        return;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      return;
    }
  }
  
  public FileManagerEntity a(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null)
    {
      QLAndQQStructDef.QQ2QlSendFileInfo localQQ2QlSendFileInfo = new QLAndQQStructDef.QQ2QlSendFileInfo();
      Object localObject = new QLAndQQStructDef.SendFileNbyInfo();
      ((QLAndQQStructDef.SendFileNbyInfo)localObject).source = 257;
      localObject = a(localFileManagerEntity.peerUin, (QLAndQQStructDef.SendFileNbyInfo)localObject, localFileManagerEntity.strFilePath);
      localQQ2QlSendFileInfo.sessionid = ((FileManagerEntity)localObject).nSessionId;
      localQQ2QlSendFileInfo.filePath = ((FileManagerEntity)localObject).strFilePath;
      localQQ2QlSendFileInfo.fileSize = ((FileManagerEntity)localObject).fileSize;
      localQQ2QlSendFileInfo.msgseq = ((int)((FileManagerEntity)localObject).msgSeq);
      localQQ2QlSendFileInfo.msguid = ((FileManagerEntity)localObject).msgUid;
      localQQ2QlSendFileInfo.msgtime = ((int)((FileManagerEntity)localObject).msgTime);
      localFileManagerEntity.status = 16;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      b(paramLong);
      if (QLog.isColorLevel()) {
        QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] <" + ((FileManagerEntity)localObject).nSessionId + "> reSendFileMsg. file:" + localFileManagerEntity.strFilePath);
      }
      c(((FileManagerEntity)localObject).nSessionId);
      a(((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).qlmsgSrc);
      a(true, new QLAndQQStructDef.ReportNbFileFileSendInfo(true, 1, 257, ((FileManagerEntity)localObject).fileSize, ((FileManagerEntity)localObject).fileName, 0L, 0L, 0L, null, 0, String.valueOf(((FileManagerEntity)localObject).nSessionId), null, null, null));
      QLAndQQStructDef.QQ2QlSendFileInfos localQQ2QlSendFileInfos = new QLAndQQStructDef.QQ2QlSendFileInfos();
      localQQ2QlSendFileInfos.infos.add(localQQ2QlSendFileInfo);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localQQ2QlSendFileInfos))
      {
        QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] <" + ((FileManagerEntity)localObject).nSessionId + "> reSendFileMsg. failed:" + localFileManagerEntity.strFilePath);
        ((FileManagerEntity)localObject).status = 0;
        ((FileManagerEntity)localObject).errCode = -109;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).nSessionId, ((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, 15, null, 5, null);
        d(((FileManagerEntity)localObject).nSessionId);
        a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, ((FileManagerEntity)localObject).errCode, 257, ((FileManagerEntity)localObject).fileSize, ((FileManagerEntity)localObject).fileName, 0L, 0L, 0L, null, 0, String.valueOf(((FileManagerEntity)localObject).nSessionId), null, null, null));
      }
      return localObject;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] reSendFileMsg. failed. not this entity:");
    return null;
  }
  
  public QLAndQQStructDef.QQ2QlRecvFileInfo a(String paramString, QLAndQQStructDef.Ql2QQRecvFileInfo paramQl2QQRecvFileInfo)
  {
    FileManagerEntity localFileManagerEntity = a(paramString, paramQl2QQRecvFileInfo);
    if (localFileManagerEntity != null)
    {
      if ((paramQl2QQRecvFileInfo.isLastMsg) && (!((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString)))
      {
        MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1001);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1001, -3010, BaseApplicationImpl.getContext().getString(2131560932));
      }
      paramString = new QLAndQQStructDef.QQ2QlRecvFileInfo();
      paramString.sessionid = localFileManagerEntity.nSessionId;
      paramString.filename = localFileManagerEntity.fileName;
      paramString.fileinfo = paramQl2QQRecvFileInfo.fileinfo.clone();
      paramString.fileinfo.fileName = localFileManagerEntity.fileName;
      if (19 == localFileManagerEntity.status)
      {
        b(localFileManagerEntity.nSessionId);
        return paramString;
      }
      a(paramString.sessionid, localFileManagerEntity.qlmsgSrc);
      c(paramString.sessionid);
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      c();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt, Serializable paramSerializable)
  {
    if (paramSerializable == null)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. data=null. type:" + paramInt);
      return;
    }
    if (1 == paramInt)
    {
      if ((paramSerializable instanceof QLAndQQStructDef.ReportNbFileContactScanInfo))
      {
        QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QLAndQQStructDef.ReportNbFileContactScanInfo)paramSerializable);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error data. TYPE_SCAN ");
      return;
    }
    if (2 == paramInt)
    {
      if ((paramSerializable instanceof QLAndQQStructDef.ReportNbFileContactArbitrateInfo))
      {
        QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QLAndQQStructDef.ReportNbFileContactArbitrateInfo)paramSerializable);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error data. TYPE_ARBITRATE  ");
      return;
    }
    if (3 == paramInt)
    {
      if ((paramSerializable instanceof QLAndQQStructDef.ReportNbFileFileSendInfo))
      {
        QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QLAndQQStructDef.ReportNbFileFileSendInfo)paramSerializable);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error data. TYPE_SEND ");
      return;
    }
    if (4 == paramInt)
    {
      if ((paramSerializable instanceof QLAndQQStructDef.ReportNbFileFileRecvInfo))
      {
        QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QLAndQQStructDef.ReportNbFileFileRecvInfo)paramSerializable);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error data. TYPE_RECV ");
      return;
    }
    if (5 == paramInt)
    {
      if ((paramSerializable instanceof QLAndQQStructDef.ReportNbFileChannelDetect))
      {
        QlinkReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QLAndQQStructDef.ReportNbFileChannelDetect)paramSerializable);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error data. TYPE_CHNDETECT ");
      return;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQReportNbInfo. error type:" + paramInt);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    QLAndQQStructDef.QQ2QlMsgRecord localQQ2QlMsgRecord = new QLAndQQStructDef.QQ2QlMsgRecord();
    if (localFileManagerEntity != null) {
      localQQ2QlMsgRecord.hasRecord = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, localQQ2QlMsgRecord);
  }
  
  public void a(long paramLong, float paramFloat, int paramInt)
  {
    QLog.d("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] TransProgressUpdated. progress:" + paramFloat);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null)
    {
      c(paramLong);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = paramFloat;
      localFileManagerEntity.transSpeed = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, paramLong, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
      return;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] TransProgressUpdated. no find entity:");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, QLAndQQStructDef.Ql2QQExtraTransInfo paramQl2QQExtraTransInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] TransStatusUpdated. status:" + paramInt1 + " errcode:" + paramInt2 + " extErrCode:" + paramInt3 + " pjSpeed:" + paramInt4 + " inSpeed:" + paramInt5 + " outSpeed:" + paramInt6 + " ssid:" + paramString);
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    label234:
    int k;
    label289:
    int i;
    Object localObject;
    boolean bool;
    if (localFileManagerEntity != null)
    {
      if (a(localFileManagerEntity.status))
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] TransStatusUpdated. but isFinalFileStatus curstatus:" + localFileManagerEntity.status);
        }
        return;
      }
      localFileManagerEntity.status = paramInt1;
      if ((17 == paramInt1) || (19 == paramInt1) || (3 == paramInt1) || (1 == paramInt1) || (16 == paramInt1))
      {
        b(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 0, null);
        if ((-596 == paramInt2) && (!localFileManagerEntity.bSend)) {
          FileManagerUtil.a(12, localFileManagerEntity.fileName);
        }
        if (localFileManagerEntity.qlmsgSrc == 0) {
          break label475;
        }
        paramInt2 = localFileManagerEntity.qlmsgSrc;
        k = QlinkReport.a(paramInt2);
        d(localFileManagerEntity.nSessionId);
        if (!localFileManagerEntity.bSend) {
          break label656;
        }
        i = 0;
        localObject = null;
        switch (paramInt1)
        {
        default: 
          paramInt2 = 0;
          bool = false;
          paramInt3 = -1;
          paramString = localObject;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(bool, paramInt3, k, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, paramInt4, paramInt5, paramInt6, null, i, String.valueOf(localFileManagerEntity.nSessionId), paramString, paramQl2QQExtraTransInfo, null));
        return;
        if (paramInt1 != 0) {
          break label234;
        }
        c(paramLong);
        localFileManagerEntity.errCode = paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        break label234;
        label475:
        paramInt2 = a(localFileManagerEntity.nSessionId);
        break label289;
        i = localFileManagerEntity.errCode;
        paramInt2 = i;
        if (-209 == i) {
          paramInt2 = paramInt3 - 500;
        }
        if (-103 != localFileManagerEntity.errCode) {
          break label900;
        }
        i = paramInt3;
        j = 1;
        bool = false;
        paramInt3 = paramInt2;
        paramInt2 = j;
        continue;
        paramInt2 = 1;
        bool = false;
        paramInt3 = -9;
        paramString = localObject;
        continue;
        paramInt2 = 1;
        bool = false;
        paramInt3 = -7;
        paramString = localObject;
        continue;
        paramInt2 = 1;
        bool = false;
        paramInt3 = -111;
        paramString = localObject;
        continue;
        paramInt2 = 1;
        bool = true;
        paramInt3 = 0;
        paramString = localObject;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] TransStatusUpdated. send status err. not report:" + paramInt1);
      return;
      label656:
      paramInt4 = 1;
      long l = localFileManagerEntity.transSpeed;
      paramInt2 = -1;
      i = 0;
      switch (paramInt1)
      {
      default: 
        paramInt4 = 0;
        paramInt3 = i;
      }
      for (;;)
      {
        if (paramInt4 != 0)
        {
          a(false, new QLAndQQStructDef.ReportNbFileFileRecvInfo(false, paramInt2, k, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, l, paramInt5, paramInt6, null, paramInt3, String.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity.peerUin, paramQl2QQExtraTransInfo, null));
          return;
          paramInt2 = localFileManagerEntity.errCode;
          if (-311 == paramInt2)
          {
            paramInt2 = paramInt3 - 600;
            continue;
            paramInt2 = -8;
            paramInt3 = i;
            continue;
            paramInt2 = -111;
            paramInt3 = i;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] TransStatusUpdated. recv status err. not report:" + paramInt1);
          return;
          QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] TransStatusUpdated. no find entity:");
          return;
        }
      }
      label900:
      i = paramInt3;
      int j = 1;
      bool = false;
      paramInt3 = paramInt2;
      paramInt2 = j;
      paramString = localObject;
    }
  }
  
  public void a(long paramLong, QLAndQQStructDef.QQ2QlSendFileResultInfo paramQQ2QlSendFileResultInfo)
  {
    if (paramQQ2QlSendFileResultInfo != null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity != null)
      {
        if (paramQQ2QlSendFileResultInfo.success)
        {
          if (paramQQ2QlSendFileResultInfo.fileinfo != null)
          {
            a(localFileManagerEntity, paramQQ2QlSendFileResultInfo.fileinfo);
            return;
          }
          QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] Ql2QQSetSendFileResult. send succ but no fileinfo:");
          return;
        }
        QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] Ql2QQSetSendFileResult. send failed:");
        c(paramLong);
        localFileManagerEntity.status = 0;
        localFileManagerEntity.errCode = paramQQ2QlSendFileResultInfo.errCode;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, 5, null);
        if (localFileManagerEntity.qlmsgSrc != 0) {}
        for (int i = localFileManagerEntity.qlmsgSrc;; i = a(localFileManagerEntity.nSessionId))
        {
          i = QlinkReport.a(i);
          d(paramLong);
          a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, localFileManagerEntity.errCode, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, 0L, 0L, 0L, null, 0, String.valueOf(localFileManagerEntity.nSessionId), null, paramQQ2QlSendFileResultInfo.etinfo, null));
          return;
        }
      }
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] Ql2QQSetSendFileResult. not find file entity:");
      return;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] Ql2QQSetSendFileResult. info=null:");
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong) == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLAndQQStructDef.QQ2QlNeedDataOfMsg localQQ2QlNeedDataOfMsg = new QLAndQQStructDef.QQ2QlNeedDataOfMsg();
      if (bool)
      {
        localQQ2QlNeedDataOfMsg.strUin = paramString;
        localQQ2QlNeedDataOfMsg.strNick = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, bool, localQQ2QlNeedDataOfMsg);
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt1, String paramString, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, QLAndQQStructDef.Ql2QQExtraTransInfo paramQl2QQExtraTransInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] FileTransCompleted. bSucess:" + paramBoolean1 + " errcode:" + paramInt1 + " path:" + paramString + " isThumb:" + paramBoolean2 + " pjSpeed:" + paramInt2 + " inSpeed:" + paramInt3 + " outSpeed:" + paramInt4);
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null) {
      if (localFileManagerEntity.qlmsgSrc != 0)
      {
        i = localFileManagerEntity.qlmsgSrc;
        i = QlinkReport.a(i);
        if (!paramBoolean1) {
          break label621;
        }
        if (!paramBoolean2) {
          break label256;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] thumb TransCompleted. path:" + paramString + " isThumb:" + paramBoolean2);
        }
        localFileManagerEntity.strThumbPath = paramString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 0, null);
      }
    }
    label256:
    label621:
    while (paramBoolean2)
    {
      int i;
      do
      {
        do
        {
          for (;;)
          {
            return;
            i = a(localFileManagerEntity.nSessionId);
          }
          if (!a(localFileManagerEntity.status)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] FileTransCompleted sucess. but isFinalFileStatus curstatus:" + localFileManagerEntity.status);
        return;
        localFileManagerEntity.status = 1;
        b(paramLong);
        d(paramLong);
        if (!localFileManagerEntity.bSend)
        {
          localFileManagerEntity.strFilePath = paramString;
          localFileManagerEntity.fileName = FileManagerUtil.a(paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        if (localFileManagerEntity.bSend)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 14, new Object[] { localFileManagerEntity.strFilePath, Long.valueOf(localFileManagerEntity.fileSize), Boolean.valueOf(true), null }, 0, null);
          a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(true, 0, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, paramInt2, paramInt3, paramInt4, null, 0, String.valueOf(localFileManagerEntity.nSessionId), null, paramQl2QQExtraTransInfo, null));
          return;
        }
        localFileManagerEntity.cloudType = 5;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 11, new Object[] { localFileManagerEntity.strFilePath, Long.valueOf(localFileManagerEntity.fileSize), Boolean.valueOf(true), null }, 0, null);
        a(false, new QLAndQQStructDef.ReportNbFileFileRecvInfo(true, 0, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, paramInt2, paramInt3, paramInt4, null, 0, String.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity.peerUin, paramQl2QQExtraTransInfo, null));
        return;
        if (paramBoolean2)
        {
          QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] thumb TransCompleted. failed");
          return;
        }
        if (!a(localFileManagerEntity.status)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramLong + "] FileTransCompleted failed. but isFinalFileStatus curstatus:" + localFileManagerEntity.status);
      return;
      c(paramLong);
      d(paramLong);
      localFileManagerEntity.status = 0;
      localFileManagerEntity.errCode = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      if (localFileManagerEntity.bSend)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, 5, null);
        a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, localFileManagerEntity.errCode, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, paramInt2, paramInt3, paramInt4, null, 0, String.valueOf(localFileManagerEntity.nSessionId), null, paramQl2QQExtraTransInfo, null));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
      if (-596 == paramInt1) {
        FileManagerUtil.a(12, localFileManagerEntity.fileName);
      }
      a(false, new QLAndQQStructDef.ReportNbFileFileRecvInfo(false, localFileManagerEntity.errCode, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, paramInt2, paramInt3, paramInt4, null, 0, String.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity.peerUin, paramQl2QQExtraTransInfo, null));
      return;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramLong + "] FileTransCompleted. no find entity:");
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void a(FileManagerEntity paramFileManagerEntity, QLAndQQStructDef.FileInfo paramFileInfo)
  {
    if ((paramFileInfo == null) || (paramFileManagerEntity == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ fillFileManagerEntityFromFileInfo failed. param=null");
      return;
    }
    paramFileManagerEntity.fileName = paramFileInfo.fileName;
    paramFileManagerEntity.fileSize = paramFileInfo.fileSize;
    paramFileManagerEntity.fProgress = paramFileInfo.fProgress;
    paramFileManagerEntity.strServerPath = paramFileInfo.url;
    paramFileManagerEntity.WeiYunFileId = paramFileInfo.thumbUrl;
    paramFileManagerEntity.strThumbPath = paramFileInfo.thumPath;
    paramFileManagerEntity.Uuid = paramFileInfo.fileMd5;
    paramFileManagerEntity.strSrcName = paramFileInfo.thumbMd5;
  }
  
  public void a(QLAndQQStructDef.FileInfo paramFileInfo, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileInfo == null) || (paramFileManagerEntity == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ fillFileInfoFromFileManagerEntity failed. param=null");
      return;
    }
    paramFileInfo.fileName = paramFileManagerEntity.fileName;
    paramFileInfo.filePath = paramFileManagerEntity.strFilePath;
    paramFileInfo.fileSize = paramFileManagerEntity.fileSize;
    paramFileInfo.fProgress = paramFileManagerEntity.fProgress;
    paramFileInfo.url = paramFileManagerEntity.strServerPath;
    paramFileInfo.thumbUrl = paramFileManagerEntity.WeiYunFileId;
    paramFileInfo.thumPath = paramFileManagerEntity.strThumbPath;
    paramFileInfo.fileMd5 = paramFileManagerEntity.Uuid;
    paramFileInfo.thumbMd5 = paramFileManagerEntity.strSrcName;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ GetContactHead. uin:" + paramString);
    }
  }
  
  public void a(String paramString, QLAndQQStructDef.Ql2QQRecvFileInfo paramQl2QQRecvFileInfo)
  {
    QLAndQQStructDef.QQ2QlRecvFileInfo localQQ2QlRecvFileInfo = a(paramString, paramQl2QQRecvFileInfo);
    if ((paramQl2QQRecvFileInfo != null) && (!paramQl2QQRecvFileInfo.failed))
    {
      localQQ2QlRecvFileInfo.peerIp = paramQl2QQRecvFileInfo.peerIp;
      localQQ2QlRecvFileInfo.peerPort = paramQl2QQRecvFileInfo.peerPort;
      localQQ2QlRecvFileInfo.ssid = paramQl2QQRecvFileInfo.ssid;
      localQQ2QlRecvFileInfo.source = paramQl2QQRecvFileInfo.source;
      localQQ2QlRecvFileInfo.connApTimeout = paramQl2QQRecvFileInfo.connApTimeout;
      localQQ2QlRecvFileInfo.forceConnAp = paramQl2QQRecvFileInfo.forceConnAp;
      localQQ2QlRecvFileInfo.preSharedKey = paramQl2QQRecvFileInfo.preSharedKey;
      e(localQQ2QlRecvFileInfo.sessionid);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, localQQ2QlRecvFileInfo);
      return;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ Ql2QQRecvFileMessage had failed. uin:" + paramString);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      FMDataCache.a(paramString2, paramArrayOfByte);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (!NetworkUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQProxyForQlink", 2, "Ql2QQNotifyWifiApCreated: is not mobile network");
      }
    }
    for (;;)
    {
      return;
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        boolean bool = localFriendManager.b(str);
        int i = 0;
        if (!bool) {
          i = 1001;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i, -3011, BaseApplicationImpl.getContext().getString(2131560938));
        if (QLog.isColorLevel()) {
          QLog.d("QQProxyForQlink", 2, "Ql2QQNotifyWifiApCreated: peerType[" + i + "], friendUin[" + FileManagerUtil.e(str) + "]");
        }
      }
    }
  }
  
  public boolean a(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null)
    {
      String str = localFileManagerEntity.peerUin;
      QLAndQQStructDef.QQ2QlRecvFileInfo localQQ2QlRecvFileInfo = new QLAndQQStructDef.QQ2QlRecvFileInfo();
      localQQ2QlRecvFileInfo.sessionid = localFileManagerEntity.nSessionId;
      localQQ2QlRecvFileInfo.filename = localFileManagerEntity.fileName;
      a(localQQ2QlRecvFileInfo.fileinfo, localFileManagerEntity);
      localQQ2QlRecvFileInfo.fileinfo.fileName = localFileManagerEntity.fileName;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, localQQ2QlRecvFileInfo);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, paramLong, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 16, null, 0, null);
      return true;
    }
    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ reRecvFile failed. not find entity. sessionid:" + paramLong);
    return true;
  }
  
  public boolean a(String paramString1, QLAndQQStructDef.SendFileNbyInfo paramSendFileNbyInfo, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ sendFileMsg. param error");
      return false;
    }
    QLAndQQStructDef.QQ2QlSendFileInfo localQQ2QlSendFileInfo = new QLAndQQStructDef.QQ2QlSendFileInfo();
    paramSendFileNbyInfo = a(paramString1, paramSendFileNbyInfo, paramString2);
    localQQ2QlSendFileInfo.sessionid = paramSendFileNbyInfo.nSessionId;
    localQQ2QlSendFileInfo.filePath = paramSendFileNbyInfo.strFilePath;
    localQQ2QlSendFileInfo.fileSize = paramSendFileNbyInfo.fileSize;
    localQQ2QlSendFileInfo.msgseq = ((int)paramSendFileNbyInfo.msgSeq);
    localQQ2QlSendFileInfo.msguid = paramSendFileNbyInfo.msgUid;
    localQQ2QlSendFileInfo.msgtime = ((int)paramSendFileNbyInfo.msgTime);
    localQQ2QlSendFileInfo.strUin = paramString1;
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ [" + paramSendFileNbyInfo.nSessionId + "] sendFileMsg. file:" + paramString2);
    }
    c(paramSendFileNbyInfo.nSessionId);
    a(paramSendFileNbyInfo.nSessionId, paramSendFileNbyInfo.qlmsgSrc);
    int i = QlinkReport.a(paramSendFileNbyInfo.qlmsgSrc);
    a(true, new QLAndQQStructDef.ReportNbFileFileSendInfo(true, 1, i, paramSendFileNbyInfo.fileSize, paramSendFileNbyInfo.fileName, 0L, 0L, 0L, null, 0, String.valueOf(paramSendFileNbyInfo.nSessionId), null, null, null));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, localQQ2QlSendFileInfo);
    if (!bool)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramSendFileNbyInfo.nSessionId + "] sendFileMsg failed. qq2ql send err. file:" + paramString2);
      paramSendFileNbyInfo.status = 0;
      paramSendFileNbyInfo.errCode = -109;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramSendFileNbyInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendFileNbyInfo.uniseq, paramSendFileNbyInfo.nSessionId, paramSendFileNbyInfo.peerUin, paramSendFileNbyInfo.peerType, 15, null, 5, null);
      d(paramSendFileNbyInfo.nSessionId);
      a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, paramSendFileNbyInfo.errCode, i, paramSendFileNbyInfo.fileSize, paramSendFileNbyInfo.fileName, 0L, 0L, 0L, null, 0, String.valueOf(paramSendFileNbyInfo.nSessionId), null, null, null));
    }
    return bool;
  }
  
  public boolean a(String paramString, QLAndQQStructDef.SendFileNbyInfo paramSendFileNbyInfo, List paramList)
  {
    if ((paramList == null) || (paramString == null))
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ sendFileMsgs. param error");
      return false;
    }
    if (paramList.size() <= 0)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ sendFileMsgs. no any file");
      return false;
    }
    QLAndQQStructDef.QQ2QlSendFileInfos localQQ2QlSendFileInfos = new QLAndQQStructDef.QQ2QlSendFileInfos();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FileManagerEntity localFileManagerEntity = a(paramString, paramSendFileNbyInfo, (String)paramList.next());
      QLAndQQStructDef.QQ2QlSendFileInfo localQQ2QlSendFileInfo = new QLAndQQStructDef.QQ2QlSendFileInfo();
      localQQ2QlSendFileInfo.sessionid = localFileManagerEntity.nSessionId;
      localQQ2QlSendFileInfo.filePath = localFileManagerEntity.strFilePath;
      localQQ2QlSendFileInfo.fileSize = localFileManagerEntity.fileSize;
      localQQ2QlSendFileInfo.msgseq = ((int)localFileManagerEntity.msgSeq);
      localQQ2QlSendFileInfo.msguid = localFileManagerEntity.msgUid;
      localQQ2QlSendFileInfo.msgtime = ((int)localFileManagerEntity.msgTime);
      localQQ2QlSendFileInfo.strUin = paramString;
      localQQ2QlSendFileInfos.infos.add(localQQ2QlSendFileInfo);
      c(localFileManagerEntity.nSessionId);
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.qlmsgSrc);
      localArrayList.add(localFileManagerEntity);
      a(true, new QLAndQQStructDef.ReportNbFileFileSendInfo(true, 1, QlinkReport.a(localFileManagerEntity.qlmsgSrc), localFileManagerEntity.fileSize, localFileManagerEntity.fileName, 0L, 0L, 0L, null, 0, String.valueOf(localFileManagerEntity.nSessionId), null, null, null));
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, localQQ2QlSendFileInfos);
    if (!bool)
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        paramSendFileNbyInfo = (FileManagerEntity)paramString.next();
        QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ [" + paramSendFileNbyInfo.nSessionId + "] sendFileMsg failed. qq2ql send err. file:" + paramSendFileNbyInfo.fileName);
        paramSendFileNbyInfo.status = 0;
        paramSendFileNbyInfo.errCode = -109;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramSendFileNbyInfo);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendFileNbyInfo.uniseq, paramSendFileNbyInfo.nSessionId, paramSendFileNbyInfo.peerUin, paramSendFileNbyInfo.peerType, 15, null, 5, null);
        d(paramSendFileNbyInfo.nSessionId);
        int i = QlinkReport.a(paramSendFileNbyInfo.qlmsgSrc);
        a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, paramSendFileNbyInfo.errCode, i, paramSendFileNbyInfo.fileSize, paramSendFileNbyInfo.fileName, 0L, 0L, 0L, null, 0, String.valueOf(paramSendFileNbyInfo.nSessionId), null, null, null));
      }
    }
    return bool;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ exitQlinkLocalFileBrowser...");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void b(String paramString)
  {
    a(1, new Object[] { paramString });
  }
  
  public boolean b(long paramLong)
  {
    b(paramLong);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    int i;
    if (localFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, paramLong, localFileManagerEntity.Uuid);
      localFileManagerEntity.status = 3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 3, null, 0, null);
      if (localFileManagerEntity.qlmsgSrc != 0)
      {
        i = localFileManagerEntity.qlmsgSrc;
        i = QlinkReport.a(i);
        d(localFileManagerEntity.nSessionId);
        if (!localFileManagerEntity.bSend) {
          break label190;
        }
        a(false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, -8, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, 0L, 0L, 0L, null, 0, String.valueOf(localFileManagerEntity.nSessionId), null, null, null));
      }
    }
    for (;;)
    {
      return true;
      i = a(localFileManagerEntity.nSessionId);
      break;
      label190:
      a(false, new QLAndQQStructDef.ReportNbFileFileRecvInfo(false, -7, i, localFileManagerEntity.fileSize, localFileManagerEntity.fileName, 0L, 0L, 0L, null, 0, String.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity.peerUin, null, null));
      continue;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ cancel failed. not find entity. sessionid:" + paramLong);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink
 * JD-Core Version:    0.7.0.1
 */