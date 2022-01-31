package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fwj;
import fwk;
import fwl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ThumbDownLoader
  implements IHttpCommunicatorListener
{
  static final int jdField_a_of_type_Int = 2;
  static long jdField_a_of_type_Long = 0L;
  static final String jdField_a_of_type_JavaLangString = AppConstants.as + ".thumbnails/";
  private static final String jdField_b_of_type_JavaLangString = "ThumbDownLoader<FileAssistant>";
  public QQAppInterface a;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new fwk(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List jdField_a_of_type_JavaUtilList = null;
  private final int jdField_b_of_type_Int = 5;
  List jdField_b_of_type_JavaUtilList = null;
  
  public ThumbDownLoader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    File localFile = new File(AppConstants.at);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void a(fwl paramfwl, long paramLong)
  {
    if (paramfwl.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ThumbDownLoader<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramfwl.jdField_a_of_type_Long) + "],tmpname[" + String.valueOf(paramfwl.jdField_c_of_type_JavaLangString) + "]");
      paramfwl.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramfwl.jdField_c_of_type_JavaLangString, true);
      HttpMsg localHttpMsg = new HttpMsg(paramfwl.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localHttpMsg.a("Net-type", str);
      localHttpMsg.a("Range", "bytes=0-");
      localHttpMsg.b(5);
      localHttpMsg.a("Cookie", "FTN5K=" + paramfwl.jdField_d_of_type_JavaLangString);
      localHttpMsg.a(true);
      localHttpMsg.jdField_d_of_type_Int = 0;
      localHttpMsg.jdField_e_of_type_Int = 3000;
      localHttpMsg.ad = String.valueOf(paramLong);
      QLog.d("ThumbDownLoader<FileAssistant>", 1, "Id[" + String.valueOf(paramLong) + "]" + "nSessionId[" + String.valueOf(paramfwl.jdField_a_of_type_Long) + "]" + "recv http data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localHttpMsg.jdField_e_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      paramfwl.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      QLog.e("ThumbDownLoader<FileAssistant>", 2, "new FileOutputStream exception!!! info:" + paramfwl.toString());
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramfwl.jdField_a_of_type_Long, "actFileDiscThumb", paramfwl.jdField_e_of_type_Long, paramfwl.jdField_a_of_type_JavaLangString, paramfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramfwl.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramfwl.jdField_a_of_type_Long, "actFileDiscThumbDetail", paramfwl.jdField_e_of_type_Long, paramfwl.jdField_a_of_type_JavaLangString, paramfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramfwl.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
      localFileNotFoundException.printStackTrace();
      synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramfwl.jdField_d_of_type_Long));
        a(null);
        return;
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_JavaUtilList.size() < 2)
    {
      Thread localThread = new Thread(new fwj(this));
      this.jdField_b_of_type_JavaUtilList.add(localThread);
      localThread.start();
      QLog.i("ThumbDownLoader<FileAssistant>", 2, "thread less 2,created one new thread! threadDownList.size(" + String.valueOf(this.jdField_b_of_type_JavaUtilList.size()) + ")");
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      QLog.i("ThumbDownLoader<FileAssistant>", 2, "download discFile Thumb,nSession[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],discUin[" + String.valueOf(paramFileManagerEntity.peerUin) + "],size[" + str + "]");
      if (paramFileManagerEntity.Uuid != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      QLog.e("ThumbDownLoader<FileAssistant>", 1, "FileEntity uuid null!!!!!!id[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
      return null;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
    ??? = paramFileManagerEntity.Uuid.replace("/", "");
    a();
    str = jdField_a_of_type_JavaLangString + str + (String)???;
    if (FileUtils.b(str) == true)
    {
      paramFileManagerEntity.strThumbPath = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity });
      QLog.i("ThumbDownLoader<FileAssistant>", 2, "download discFile Thumb existed,nSession[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],discUin[" + String.valueOf(paramFileManagerEntity.peerUin) + "],path[" + str + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, 0L, 0L, 0L, 0, null);
      return str;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        if (((fwl)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong)).jdField_a_of_type_Long == paramFileManagerEntity.nSessionId)
        {
          QLog.i("ThumbDownLoader<FileAssistant>", 2, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] is downloading, return! cacheDowload size(" + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) + ")");
          return null;
        }
      }
    }
    ??? = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        if (((fwl)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long == paramFileManagerEntity.nSessionId)
        {
          QLog.i("ThumbDownLoader<FileAssistant>", 2, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] is in download list, return! cacheDowload size(" + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) + ")");
          return null;
        }
      }
      finally {}
      i += 1;
    }
    Object localObject2 = new fwl(this);
    ((fwl)localObject2).jdField_b_of_type_JavaLangString = str;
    ((fwl)localObject2).jdField_c_of_type_JavaLangString = (str + ".tmp");
    ((fwl)localObject2).jdField_a_of_type_Long = paramFileManagerEntity.nSessionId;
    ((fwl)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    ((fwl)localObject2).jdField_a_of_type_Int = paramInt;
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    ((fwl)localObject2).jdField_d_of_type_Long = l;
    this.jdField_a_of_type_JavaUtilList.add(localObject2);
    QLog.i("ThumbDownLoader<FileAssistant>", 2, "add download discFile Thumb task," + ((fwl)localObject2).toString());
    b();
    return null;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  /* Error */
  public void a(HttpMsg paramHttpMsg1, HttpMsg arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 177	com/tencent/mobileqq/utils/httputils/HttpMsg:ad	Ljava/lang/String;
    //   4: invokestatic 400	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   7: lstore 4
    //   9: aload_0
    //   10: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   13: astore 10
    //   15: aload 10
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   22: lload 4
    //   24: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: invokevirtual 372	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 93	fwl
    //   33: astore 9
    //   35: aload 10
    //   37: monitorexit
    //   38: aload_2
    //   39: ifnonnull +208 -> 247
    //   42: aload_0
    //   43: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: aload 9
    //   48: getfield 99	fwl:jdField_a_of_type_Long	J
    //   51: ldc 212
    //   53: aload 9
    //   55: getfield 214	fwl:jdField_e_of_type_Long	J
    //   58: aload 9
    //   60: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload 9
    //   65: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   68: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   71: aload 9
    //   73: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   76: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   79: ldc2_w 401
    //   82: ldc_w 404
    //   85: lconst_0
    //   86: lconst_0
    //   87: lconst_0
    //   88: aload 9
    //   90: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: ldc 231
    //   95: iconst_0
    //   96: ldc_w 404
    //   99: ldc 231
    //   101: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: aload 9
    //   110: getfield 99	fwl:jdField_a_of_type_Long	J
    //   113: ldc 238
    //   115: aload 9
    //   117: getfield 214	fwl:jdField_e_of_type_Long	J
    //   120: aload 9
    //   122: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   125: aload 9
    //   127: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   130: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   133: aload 9
    //   135: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   138: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   141: ldc2_w 401
    //   144: ldc_w 404
    //   147: aload 9
    //   149: getfield 405	fwl:jdField_e_of_type_Int	I
    //   152: i2l
    //   153: aload 9
    //   155: getfield 407	fwl:jdField_c_of_type_Long	J
    //   158: aload 9
    //   160: getfield 386	fwl:jdField_a_of_type_Int	I
    //   163: i2l
    //   164: aload 9
    //   166: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: ldc 231
    //   171: iconst_0
    //   172: ldc_w 404
    //   175: ldc 231
    //   177: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   184: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   187: iconst_0
    //   188: bipush 50
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 9
    //   198: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   201: aastore
    //   202: invokevirtual 300	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   205: aload_0
    //   206: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   209: astore_1
    //   210: aload_1
    //   211: monitorenter
    //   212: aload_0
    //   213: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   216: aload 9
    //   218: getfield 245	fwl:jdField_d_of_type_Long	J
    //   221: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   224: invokevirtual 254	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload_1
    //   229: monitorexit
    //   230: aload_0
    //   231: aconst_null
    //   232: invokevirtual 257	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:a	(Lfwl;)V
    //   235: return
    //   236: astore_1
    //   237: aload 10
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: astore_2
    //   243: aload_1
    //   244: monitorexit
    //   245: aload_2
    //   246: athrow
    //   247: aload_1
    //   248: aload 9
    //   250: getfield 205	fwl:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   253: if_acmpne -18 -> 235
    //   256: aload 9
    //   258: getfield 410	fwl:jdField_a_of_type_ArrayOfInt	[I
    //   261: astore_1
    //   262: aload_1
    //   263: monitorenter
    //   264: aload_2
    //   265: invokevirtual 412	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   268: sipush 206
    //   271: if_icmpeq +15 -> 286
    //   274: aload_2
    //   275: invokevirtual 412	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   278: istore_3
    //   279: iload_3
    //   280: sipush 200
    //   283: if_icmpne +782 -> 1065
    //   286: aload 9
    //   288: getfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   291: aload_2
    //   292: invokevirtual 415	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   295: invokevirtual 419	java/io/FileOutputStream:write	([B)V
    //   298: aload 9
    //   300: getfield 421	fwl:jdField_b_of_type_Long	J
    //   303: lconst_0
    //   304: lcmp
    //   305: ifne +68 -> 373
    //   308: aload_2
    //   309: invokevirtual 424	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()J
    //   312: lstore 6
    //   314: ldc 16
    //   316: iconst_1
    //   317: new 24	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 426
    //   327: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 9
    //   332: getfield 99	fwl:jdField_a_of_type_Long	J
    //   335: invokestatic 105	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   338: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 428
    //   344: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 6
    //   349: invokestatic 105	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   352: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 115
    //   357: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload 9
    //   368: lload 6
    //   370: putfield 421	fwl:jdField_b_of_type_Long	J
    //   373: aload 9
    //   375: aload_2
    //   376: invokevirtual 415	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   379: arraylength
    //   380: putfield 405	fwl:jdField_e_of_type_Int	I
    //   383: aload 9
    //   385: aload 9
    //   387: getfield 407	fwl:jdField_c_of_type_Long	J
    //   390: aload 9
    //   392: getfield 405	fwl:jdField_e_of_type_Int	I
    //   395: i2l
    //   396: ladd
    //   397: putfield 407	fwl:jdField_c_of_type_Long	J
    //   400: aload 9
    //   402: getfield 407	fwl:jdField_c_of_type_Long	J
    //   405: aload 9
    //   407: getfield 421	fwl:jdField_b_of_type_Long	J
    //   410: lcmp
    //   411: iflt +654 -> 1065
    //   414: aload 9
    //   416: aconst_null
    //   417: putfield 205	fwl:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   420: aload 9
    //   422: getfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   425: ifnull +30 -> 455
    //   428: aload 9
    //   430: getfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   433: invokevirtual 431	java/io/FileOutputStream:flush	()V
    //   436: aload 9
    //   438: getfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   441: invokevirtual 435	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   444: invokevirtual 440	java/io/FileDescriptor:sync	()V
    //   447: aload 9
    //   449: getfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   452: invokevirtual 443	java/io/FileOutputStream:close	()V
    //   455: aload 9
    //   457: aconst_null
    //   458: putfield 96	fwl:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   461: new 72	java/io/File
    //   464: dup
    //   465: aload 9
    //   467: getfield 110	fwl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   473: new 72	java/io/File
    //   476: dup
    //   477: aload 9
    //   479: getfield 382	fwl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   482: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   485: invokestatic 446	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   488: ifne +469 -> 957
    //   491: aload_0
    //   492: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: aload 9
    //   497: getfield 99	fwl:jdField_a_of_type_Long	J
    //   500: ldc 212
    //   502: aload 9
    //   504: getfield 214	fwl:jdField_e_of_type_Long	J
    //   507: aload 9
    //   509: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   512: aload 9
    //   514: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   517: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   520: aload 9
    //   522: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   525: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   528: ldc2_w 226
    //   531: ldc_w 448
    //   534: aload 9
    //   536: getfield 405	fwl:jdField_e_of_type_Int	I
    //   539: i2l
    //   540: aload 9
    //   542: getfield 407	fwl:jdField_c_of_type_Long	J
    //   545: aload 9
    //   547: getfield 386	fwl:jdField_a_of_type_Int	I
    //   550: i2l
    //   551: aload 9
    //   553: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: aload_2
    //   557: getfield 451	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   560: aload 9
    //   562: getfield 452	fwl:jdField_b_of_type_Int	I
    //   565: ldc_w 448
    //   568: ldc 231
    //   570: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   573: aload_0
    //   574: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   577: aload 9
    //   579: getfield 99	fwl:jdField_a_of_type_Long	J
    //   582: ldc 238
    //   584: aload 9
    //   586: getfield 214	fwl:jdField_e_of_type_Long	J
    //   589: aload 9
    //   591: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   594: aload 9
    //   596: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   599: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   602: aload 9
    //   604: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   607: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   610: ldc2_w 226
    //   613: ldc_w 448
    //   616: aload 9
    //   618: getfield 405	fwl:jdField_e_of_type_Int	I
    //   621: i2l
    //   622: aload 9
    //   624: getfield 407	fwl:jdField_c_of_type_Long	J
    //   627: aload 9
    //   629: getfield 386	fwl:jdField_a_of_type_Int	I
    //   632: i2l
    //   633: aload 9
    //   635: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   638: aload_2
    //   639: getfield 451	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   642: aload 9
    //   644: getfield 453	fwl:jdField_d_of_type_Int	I
    //   647: ldc_w 448
    //   650: ldc 231
    //   652: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   655: iconst_0
    //   656: istore 8
    //   658: aload_0
    //   659: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   662: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   665: iload 8
    //   667: bipush 50
    //   669: iconst_1
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: aload 9
    //   677: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   680: aastore
    //   681: invokevirtual 300	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   684: aload_0
    //   685: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   688: astore_2
    //   689: aload_2
    //   690: monitorenter
    //   691: aload_0
    //   692: getfield 54	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   695: aload 9
    //   697: getfield 245	fwl:jdField_d_of_type_Long	J
    //   700: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   703: invokevirtual 254	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   706: pop
    //   707: aload_2
    //   708: monitorexit
    //   709: iconst_1
    //   710: istore_3
    //   711: aload_1
    //   712: monitorexit
    //   713: iload_3
    //   714: ifeq -479 -> 235
    //   717: aload_0
    //   718: aconst_null
    //   719: invokevirtual 257	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:a	(Lfwl;)V
    //   722: return
    //   723: astore 10
    //   725: aload_0
    //   726: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   729: aload 9
    //   731: getfield 99	fwl:jdField_a_of_type_Long	J
    //   734: ldc 212
    //   736: aload 9
    //   738: getfield 214	fwl:jdField_e_of_type_Long	J
    //   741: aload 9
    //   743: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   746: aload 9
    //   748: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   751: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   754: aload 9
    //   756: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   759: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   762: ldc2_w 226
    //   765: ldc_w 455
    //   768: lconst_0
    //   769: aload 9
    //   771: getfield 407	fwl:jdField_c_of_type_Long	J
    //   774: aload 9
    //   776: getfield 386	fwl:jdField_a_of_type_Int	I
    //   779: i2l
    //   780: aload 9
    //   782: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   785: aload_2
    //   786: getfield 451	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   789: aload 9
    //   791: getfield 452	fwl:jdField_b_of_type_Int	I
    //   794: ldc_w 455
    //   797: ldc 231
    //   799: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   802: aload_0
    //   803: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   806: aload 9
    //   808: getfield 99	fwl:jdField_a_of_type_Long	J
    //   811: ldc 238
    //   813: aload 9
    //   815: getfield 214	fwl:jdField_e_of_type_Long	J
    //   818: aload 9
    //   820: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   823: aload 9
    //   825: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   828: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   831: aload 9
    //   833: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   836: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   839: ldc2_w 226
    //   842: ldc_w 455
    //   845: lconst_0
    //   846: aload 9
    //   848: getfield 407	fwl:jdField_c_of_type_Long	J
    //   851: aload 9
    //   853: getfield 386	fwl:jdField_a_of_type_Int	I
    //   856: i2l
    //   857: aload 9
    //   859: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   862: aload_2
    //   863: getfield 451	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   866: aload 9
    //   868: getfield 453	fwl:jdField_d_of_type_Int	I
    //   871: ldc_w 455
    //   874: ldc 231
    //   876: invokestatic 236	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   879: aload 10
    //   881: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   884: aload_0
    //   885: aconst_null
    //   886: aconst_null
    //   887: invokevirtual 458	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   890: aload_1
    //   891: monitorexit
    //   892: return
    //   893: astore_2
    //   894: aload_1
    //   895: monitorexit
    //   896: aload_2
    //   897: athrow
    //   898: astore 10
    //   900: ldc_w 460
    //   903: iconst_1
    //   904: new 24	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   911: ldc 179
    //   913: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: lload 4
    //   918: invokestatic 105	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   921: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: ldc 115
    //   926: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: ldc_w 462
    //   932: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: aload 10
    //   937: invokevirtual 463	java/io/IOException:toString	()Ljava/lang/String;
    //   940: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   949: aload 10
    //   951: invokevirtual 464	java/io/IOException:printStackTrace	()V
    //   954: goto -499 -> 455
    //   957: aload_0
    //   958: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   961: aload 9
    //   963: getfield 99	fwl:jdField_a_of_type_Long	J
    //   966: ldc 212
    //   968: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   971: aload 9
    //   973: getfield 214	fwl:jdField_e_of_type_Long	J
    //   976: lsub
    //   977: aload 9
    //   979: getfield 129	fwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   982: aload 9
    //   984: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   987: getfield 222	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   990: aload 9
    //   992: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   995: getfield 225	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   998: aload 9
    //   1000: getfield 405	fwl:jdField_e_of_type_Int	I
    //   1003: i2l
    //   1004: aload 9
    //   1006: getfield 407	fwl:jdField_c_of_type_Long	J
    //   1009: aload 9
    //   1011: getfield 386	fwl:jdField_a_of_type_Int	I
    //   1014: i2l
    //   1015: aload 9
    //   1017: getfield 452	fwl:jdField_b_of_type_Int	I
    //   1020: aconst_null
    //   1021: invokestatic 347	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJILjava/lang/String;)V
    //   1024: aload 9
    //   1026: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1029: aload 9
    //   1031: getfield 382	fwl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1034: putfield 332	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   1037: aload_0
    //   1038: getfield 69	com/tencent/mobileqq/filemanager/core/ThumbDownLoader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1041: invokevirtual 335	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   1044: aload 9
    //   1046: getfield 217	fwl:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1049: invokevirtual 340	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1052: iconst_1
    //   1053: istore 8
    //   1055: goto -397 -> 658
    //   1058: astore 9
    //   1060: aload_2
    //   1061: monitorexit
    //   1062: aload 9
    //   1064: athrow
    //   1065: iconst_0
    //   1066: istore_3
    //   1067: goto -356 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1070	0	this	ThumbDownLoader
    //   0	1070	1	paramHttpMsg1	HttpMsg
    //   278	789	3	i	int
    //   7	910	4	l1	long
    //   312	57	6	l2	long
    //   656	398	8	bool	boolean
    //   33	1012	9	localfwl	fwl
    //   1058	5	9	localObject	Object
    //   13	225	10	localLinkedHashMap	LinkedHashMap
    //   723	157	10	localException	java.lang.Exception
    //   898	52	10	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   18	38	236	finally
    //   237	240	236	finally
    //   212	230	242	finally
    //   243	245	242	finally
    //   286	298	723	java/lang/Exception
    //   264	279	893	finally
    //   286	298	893	finally
    //   298	373	893	finally
    //   373	420	893	finally
    //   420	455	893	finally
    //   455	655	893	finally
    //   658	691	893	finally
    //   711	713	893	finally
    //   725	892	893	finally
    //   894	896	893	finally
    //   900	954	893	finally
    //   957	1052	893	finally
    //   1062	1065	893	finally
    //   420	455	898	java/io/IOException
    //   691	709	1058	finally
    //   1060	1062	1058	finally
  }
  
  public void a(fwl arg1)
  {
    QLog.i("ThumbDownLoader<FileAssistant>", 2, "bengin download discFile thumb,cacheDowload.size(" + String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) + ")");
    ??? = ???;
    fwl localfwl;
    if (??? == null)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          ??? = this.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)???).hasNext()) {
            Thread localThread = (Thread)((Iterator)???).next();
          }
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            this.jdField_b_of_type_JavaUtilList.clear();
            return;
          }
        }
      }
      localfwl = (fwl)this.jdField_a_of_type_JavaUtilList.get(0);
      this.jdField_a_of_type_JavaUtilList.remove(localfwl);
      QLog.i("ThumbDownLoader<FileAssistant>", 2, "get download discFile thumb info," + localfwl.toString());
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(localfwl.jdField_d_of_type_Long), localfwl);
      localfwl.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localfwl.jdField_d_of_type_Long, localfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(localfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), localfwl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      return;
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    Object localObject1 = null;
    if (paramHttpMsg2 != null) {
      localObject1 = paramHttpMsg2.c();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "null";
    }
    if (??? != null) {}
    for (long l1 = Long.parseLong(???.ad);; l1 = -1L) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          localObject1 = (fwl)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(l1));
          if (localObject1 == null)
          {
            QLog.w("ThumbDownLoader<FileAssistant>", 1, "get mapDowload task fail, may be is success taskid[" + String.valueOf(l1) + "]");
            a(null);
            return;
          }
        }
        QLog.i("ThumbDownLoader<FileAssistant>", 1, "handleError....., info:" + ((fwl)localObject1).toString());
        long l2;
        String str1;
        String str2;
        long l3;
        long l4;
        long l5;
        String str3;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = ((fwl)localObject1).jdField_a_of_type_Long;
          l2 = ((fwl)localObject1).jdField_e_of_type_Long;
          ??? = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          str1 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str2 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          l3 = ((fwl)localObject1).jdField_e_of_type_Int;
          l4 = ((fwl)localObject1).jdField_c_of_type_Long;
          l5 = ((fwl)localObject1).jdField_a_of_type_Int;
          str3 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          if (paramHttpMsg2 != null) {
            ??? = paramHttpMsg2.ag;
          }
          for (;;)
          {
            FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)???, str1, str2, 9004L, "no network", l3, l4, l5, str3, ???, ((fwl)localObject1).jdField_b_of_type_Int, "no network", "");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            l1 = ((fwl)localObject1).jdField_a_of_type_Long;
            l2 = ((fwl)localObject1).jdField_e_of_type_Long;
            ??? = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
            str1 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
            str2 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
            l3 = ((fwl)localObject1).jdField_e_of_type_Int;
            l4 = ((fwl)localObject1).jdField_c_of_type_Long;
            l5 = ((fwl)localObject1).jdField_a_of_type_Int;
            str3 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
            if (paramHttpMsg2 != null)
            {
              ??? = paramHttpMsg2.ag;
              FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, (String)???, str1, str2, 9004L, "no network", l3, l4, l5, str3, ???, ((fwl)localObject1).jdField_d_of_type_Int, "no network", "");
            }
            synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
            {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(((fwl)localObject1).jdField_d_of_type_Long));
              a(null);
              return;
              ??? = "respose null";
              continue;
              ??? = "respose null";
            }
          }
        }
        int i = paramHttpMsg2.h;
        label475:
        long l6;
        String str4;
        if (??? == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = ((fwl)localObject1).jdField_a_of_type_Long;
          l2 = ((fwl)localObject1).jdField_e_of_type_Long;
          str1 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          str2 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          l3 = i;
          l4 = ((fwl)localObject1).jdField_e_of_type_Int;
          l5 = ((fwl)localObject1).jdField_c_of_type_Long;
          l6 = ((fwl)localObject1).jdField_a_of_type_Int;
          str4 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          if (paramHttpMsg2 == null) {
            break label1046;
          }
          ??? = paramHttpMsg2.ag;
          label590:
          FileManagerUtil.a((QQAppInterface)???, l1, "actFileDiscThumb", l2, str1, str2, str3, l3, (String)localObject2, l4, l5, l6, str4, ???, ((fwl)localObject1).jdField_b_of_type_Int, (String)localObject2, "");
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = ((fwl)localObject1).jdField_a_of_type_Long;
          l2 = ((fwl)localObject1).jdField_e_of_type_Long;
          str1 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          str2 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          l3 = i;
          l4 = ((fwl)localObject1).jdField_e_of_type_Int;
          l5 = ((fwl)localObject1).jdField_c_of_type_Long;
          l6 = ((fwl)localObject1).jdField_a_of_type_Int;
          str4 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
          if (paramHttpMsg2 == null) {
            break label1053;
          }
          ??? = paramHttpMsg2.ag;
          FileManagerUtil.a((QQAppInterface)???, l1, "actFileDiscThumbDetail", l2, str1, str2, str3, l3, (String)localObject2, l4, l5, l6, str4, ???, ((fwl)localObject1).jdField_d_of_type_Int, (String)localObject2, "");
        }
        synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(((fwl)localObject1).jdField_d_of_type_Long));
          a(null);
          return;
          if (!paramHttpMsg2.d()) {
            break label475;
          }
          if (((fwl)localObject1).jdField_b_of_type_Int < 5)
          {
            ((fwl)localObject1).jdField_b_of_type_Int += 1;
            if ((paramHttpMsg2.h == 9056) && (((fwl)localObject1).jdField_c_of_type_Int < 3))
            {
              ((fwl)localObject1).jdField_b_of_type_Int -= 1;
              ((fwl)localObject1).jdField_c_of_type_Int += 1;
              i = 9056;
            }
            for (;;)
            {
              ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              l1 = ((fwl)localObject1).jdField_a_of_type_Long;
              l2 = ((fwl)localObject1).jdField_e_of_type_Long;
              str1 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
              str2 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
              str3 = ((fwl)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
              l3 = i;
              l4 = ((fwl)localObject1).jdField_e_of_type_Int;
              l5 = ((fwl)localObject1).jdField_c_of_type_Long;
              l6 = ((fwl)localObject1).jdField_a_of_type_Int;
              str4 = ((fwl)localObject1).jdField_a_of_type_JavaLangString;
              if (paramHttpMsg2 != null)
              {
                ??? = paramHttpMsg2.ag;
                FileManagerUtil.a((QQAppInterface)???, l1, "actFileDiscThumbDetail", l2, str1, str2, str3, l3, (String)localObject2, l4, l5, l6, str4, ???, ((fwl)localObject1).jdField_d_of_type_Int, (String)localObject2, "");
              }
              synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
              {
                this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(((fwl)localObject1).jdField_d_of_type_Long));
                a((fwl)localObject1);
                return;
                ((fwl)localObject1).jdField_c_of_type_Int = 0;
                continue;
                ??? = "respose null";
              }
            }
            label1046:
            ??? = "respose null";
            break label590;
            label1053:
            ??? = "respose null";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownLoader
 * JD-Core Version:    0.7.0.1
 */