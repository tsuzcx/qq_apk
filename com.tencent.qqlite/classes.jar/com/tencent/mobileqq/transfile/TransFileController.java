package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import ehr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransFileController
  implements INetEngine.INetEngineListener
{
  public static final int a = 0;
  public static final String a = "Q.richmedia.TransFileController";
  public static final boolean a = false;
  public static final int b = 1;
  public static final String b = "key_pre_conn";
  public static final int c = 2;
  public static final String c = "use";
  public QQAppInterface a;
  public ehr a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  ArrayList b;
  public ConcurrentHashMap b;
  public String d = null;
  
  public TransFileController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ehr = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ehr = new ehr(ThreadManager.b());
  }
  
  public static String a(TransferRequest paramTransferRequest)
  {
    return a(paramTransferRequest.e, paramTransferRequest.d, paramTransferRequest.jdField_b_of_type_Int);
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString, long paramLong1, long paramLong2)
  {
    return paramString + paramLong1 + "_" + paramLong2;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private Set a(ConcurrentHashMap paramConcurrentHashMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramConcurrentHashMap != null) {}
    for (paramConcurrentHashMap = paramConcurrentHashMap.keySet(); paramConcurrentHashMap != null; paramConcurrentHashMap = null)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.iterator();
      while (paramConcurrentHashMap.hasNext()) {
        localHashSet.add((String)paramConcurrentHashMap.next());
      }
    }
    return localHashSet;
  }
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.jdField_b_of_type_Int, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "callwait", "");
      paramBaseTransProcessor.wait();
      RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.jdField_b_of_type_Int, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "waitfin", "");
      return;
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label419;
      }
      if (!(??? instanceof BaseDownloadProcessor)) {}
    }
    label419:
    do
    {
      do
      {
        long l;
        TransferRequest localTransferRequest;
        do
        {
          synchronized ((BaseDownloadProcessor)???)
          {
            l = ((BaseDownloadProcessor)???).c();
            localTransferRequest = ((BaseDownloadProcessor)???).a();
            RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.jdField_b_of_type_Int, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = localTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
              if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null) {
                ((BaseDownloadProcessor)???).jdField_b_of_type_JavaUtilArrayList.add(paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack);
              }
              if (paramBoolean) {
                a(paramTransferRequest, (BaseTransProcessor)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramBaseTransProcessor);
                paramBaseTransProcessor.b(paramString);
                if ((paramBaseTransProcessor == null) || (paramBaseTransProcessor.e() != 0)) {
                  continue;
                }
                PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
                paramBaseTransProcessor.a();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.jdField_b_of_type_Int, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramTransferRequest)
                {
                  paramTransferRequest.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = localTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
        if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
        {
          paramBaseTransProcessor = new DownCallBack.DownResult();
          paramBaseTransProcessor.jdField_a_of_type_Int = 0;
          paramBaseTransProcessor.jdField_b_of_type_JavaLangString = paramTransferRequest.g;
          paramBaseTransProcessor.jdField_c_of_type_JavaLangString = paramTransferRequest.e;
          paramBaseTransProcessor.jdField_c_of_type_Int = paramTransferRequest.jdField_b_of_type_Int;
          paramBaseTransProcessor.d = paramTransferRequest.f;
          paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramBaseTransProcessor);
        }
        return;
        RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.jdField_b_of_type_Int, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramBaseTransProcessor);
        paramBaseTransProcessor.b(paramString);
      } while ((paramBaseTransProcessor == null) || (paramBaseTransProcessor.e() != 0));
      PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
      paramBaseTransProcessor.a();
    } while (!paramBoolean);
    try
    {
      a(paramTransferRequest, paramBaseTransProcessor);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString(paramString1, paramString2).commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof C2CPicUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof GroupPicUploadProcessor)) {}
      }
      else
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.c() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, boolean paramBoolean)
  {
    String str = paramString1 + paramLong;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      if ((1 == paramInt2) && (!paramBoolean))
      {
        paramString1 = new LbsTransfileProcessor(paramString1, paramInt1, null, paramBoolean, this);
        paramString1.e(paramString2);
        paramString1.a((short)0);
      }
      for (;;)
      {
        if (paramString3 != null) {
          paramString1.c(paramString3);
        }
        if (paramLong != 0L) {
          paramString1.a(paramLong);
        }
        paramString1.e(paramInt2);
        paramString1.b(str);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
        paramString1.a();
        return true;
        paramString2 = new LbsTransfileProcessor(paramString1, paramInt1, paramString2, paramBoolean, this);
        paramString1 = paramString2;
        if (65537 == paramInt2)
        {
          paramString1 = paramString2;
          if (!paramBoolean)
          {
            paramString2.a((short)120);
            paramString1 = paramString2;
          }
        }
      }
    }
    paramString1 = (LbsTransfileProcessor)a(paramString1, paramLong);
    if (paramString1 != null) {
      paramString1.g();
    }
    return false;
  }
  
  private void b(TransferRequest paramTransferRequest) {}
  
  private boolean b(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, boolean paramBoolean)
  {
    String str = paramString1 + paramLong;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new GrpTransfileProcessor(paramString1, paramInt1, paramString2, paramBoolean, this);
      if (paramString3 != null) {
        paramString1.c(paramString3);
      }
      if (paramLong > 0L) {
        paramString1.a(paramLong);
      }
      paramString1.b(str);
      paramString1.e(paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
      paramString1.a();
      return true;
    }
    paramString1 = (GrpTransfileProcessor)a(paramString1, paramLong);
    if (paramString1 != null) {
      paramString1.g();
    }
    return false;
  }
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).d();
      }
    }
    return 0;
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).b();
      }
    }
    return -1L;
  }
  
  BaseTransProcessor a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return null;
    }
    if (paramTransferRequest.jdField_b_of_type_Int == 131078)
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean) {
        return new MultiMsgUpProcessor(this, paramTransferRequest);
      }
      return new MultiMsgDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean)
      {
        if ((paramTransferRequest.jdField_b_of_type_Int == 6) || (paramTransferRequest.jdField_b_of_type_Int == 17) || (paramTransferRequest.jdField_b_of_type_Int == 9)) {
          return new ShortVideoUploadProcessor(this, paramTransferRequest);
        }
        return new GroupPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.jdField_b_of_type_Int == 2) {
        return new GroupPttDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.jdField_b_of_type_Int == 1) || (paramTransferRequest.jdField_b_of_type_Int == 65537) || (paramTransferRequest.jdField_b_of_type_Int == 131075)) {
        return new GroupPicDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.jdField_b_of_type_Int == 6) || (paramTransferRequest.jdField_b_of_type_Int == 7) || (paramTransferRequest.jdField_b_of_type_Int == 17) || (paramTransferRequest.jdField_b_of_type_Int == 18) || (paramTransferRequest.jdField_b_of_type_Int == 9) || (paramTransferRequest.jdField_b_of_type_Int == 16)) {
        return new ShortVideoDownloadProcessor(this, paramTransferRequest);
      }
    }
    else
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean)
      {
        if (paramTransferRequest.jdField_b_of_type_Int == 2) {
          return new C2CPttUploadProcessor(this, paramTransferRequest);
        }
        if ((paramTransferRequest.jdField_b_of_type_Int == 6) || (paramTransferRequest.jdField_b_of_type_Int == 17) || (paramTransferRequest.jdField_b_of_type_Int == 9)) {
          return new ShortVideoUploadProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.jdField_b_of_type_Int == 8) {
          return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
        }
        return new C2CPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.jdField_b_of_type_Int == 2) {
        return new C2CPttDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.jdField_b_of_type_Int == 6) || (paramTransferRequest.jdField_b_of_type_Int == 7) || (paramTransferRequest.jdField_b_of_type_Int == 17) || (paramTransferRequest.jdField_b_of_type_Int == 18) || (paramTransferRequest.jdField_b_of_type_Int == 9) || (paramTransferRequest.jdField_b_of_type_Int == 16)) {
        return new ShortVideoDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.jdField_b_of_type_Int == 1) || (paramTransferRequest.jdField_b_of_type_Int == 65537) || (paramTransferRequest.jdField_b_of_type_Int == 131075)) {
        return new C2CPicDownloadProcessor(this, paramTransferRequest);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    }
    return null;
  }
  
  public BaseTransProcessor a(String paramString, long paramLong)
  {
    paramString = a(paramString + paramLong);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.e) && (paramString.d)) {
        return paramString;
      }
    }
    return null;
  }
  
  public BaseTransProcessor a(String paramString1, String paramString2, String paramString3, short paramShort, int paramInt1, int paramInt2)
  {
    String str = paramString3 + paramShort;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new PortraitTransfileProcessor(paramString1, -1, paramString2, false, paramInt1, paramInt2, this);
      paramString1.c(paramString3);
      paramString1.a(paramShort);
      paramString1.e(1);
      paramString1.b(str);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
      paramString1.a();
    }
    do
    {
      return paramString1;
      paramString2 = (PortraitTransfileProcessor)a(str);
      paramString1 = paramString2;
    } while (paramString2 == null);
    paramString2.g();
    return paramString2;
  }
  
  public TransferResult a(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.jdField_a_of_type_Boolean = false;
    paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = new TransferResult();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramTransferRequest.jdField_b_of_type_Int == 131076)
      {
        localObject = new UrlDownloader(this, paramTransferRequest);
        a(paramTransferRequest, (BaseTransProcessor)localObject, a(paramTransferRequest), true);
      }
    }
    for (;;)
    {
      return paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
      {
        localObject = new GroupPicDownloadProcessor(this, paramTransferRequest);
        break;
      }
      localObject = new C2CPicDownloadProcessor(this, paramTransferRequest);
      break;
      localObject = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      ((TransferResult)localObject).d = -1;
      ((TransferResult)localObject).jdField_a_of_type_Long = 9366L;
      ((TransferResult)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public IHttpCommunicatorListener a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public IHttpCommunicatorListener a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  public IHttpCommunicatorListener a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramLong);
  }
  
  public String a(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public void a() {}
  
  public void a(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    String str = paramString2 + paramLong1;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = a(paramString2, paramLong1);
      if ((localIHttpCommunicatorListener instanceof ForwardImageProcessor)) {
        ((ForwardImageProcessor)localIHttpCommunicatorListener).a();
      }
    }
    paramString1 = new ForwardImageProcessor(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2)
  {
    String str2 = StreamDataManager.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = BuddyTransfileProcessor.a(String.valueOf(l2), null, 2, null);
      StreamDataManager.a(str1, 1, paramStreamInfo.iMsgId);
    }
    a(String.valueOf(l1), str1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramNetResp.a).append(" result:");
      if (paramNetResp.d != 0) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("Q.richmedia.TransFileController", 2, bool);
      return;
    }
  }
  
  public void a(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.a(paramTransProcessorHandler);
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    for (;;)
    {
      try
      {
        String str = paramTransferRequest.jdField_b_of_type_JavaLangString + paramTransferRequest.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
          {
            paramTransferRequest = a(paramTransferRequest);
            if ((paramTransferRequest != null) && (paramTransferRequest.e() == 0))
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramTransferRequest);
              paramTransferRequest.b(str);
              if (this.jdField_a_of_type_Ehr != null) {
                this.jdField_a_of_type_Ehr.a(paramTransferRequest);
              }
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.TransFileController", 2, "bad bad");
          }
          ((BaseTransProcessor)a(paramTransferRequest.jdField_b_of_type_JavaLangString, paramTransferRequest.jdField_a_of_type_Long)).f();
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.e("Q.richmedia.TransFileController", 2, AbstractImageDownloader.a(new Exception("tranfilecontroller closed")));
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_b_of_type_JavaLangString)) && (!((BaseTransProcessor)localObject).d))
          {
            ((BaseTransProcessor)localObject).i();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "pause pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localIHttpCommunicatorListener instanceof BuddyTransfileProcessor)) && (paramString.equals(((BuddyTransfileProcessor)localIHttpCommunicatorListener).a.m)))
        {
          ((BaseTransProcessor)localIHttpCommunicatorListener).h();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
        break;
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_b_of_type_JavaLangString)) && (paramLong == ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long))
          {
            ((BaseTransProcessor)localObject).g();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, TransFileController.OnCancelListener paramOnCancelListener)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_b_of_type_JavaLangString)) && (((BaseTransProcessor)localObject).c()))
          {
            ((BaseTransProcessor)localObject).g();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
            if (((BaseTransProcessor)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((BaseTransProcessor)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (paramOnCancelListener == null);
    paramOnCancelListener.a(localArrayList);
  }
  
  public void a(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramIHttpCommunicatorListener);
  }
  
  public void a(String paramString1, String paramString2, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString2))
    {
      paramString2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
      if ((paramString2 instanceof CommenTransFileProcessor)) {
        ((CommenTransFileProcessor)paramString2).a(paramString1, paramHashMap);
      }
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((paramString instanceof CommenTransFileProcessor)) {
        ((CommenTransFileProcessor)paramString).a(paramHashMap);
      }
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label171;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).f) || (((BaseTransProcessor)localObject).d)) {
        break label171;
      }
      ((BaseTransProcessor)localObject).i();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((BaseTransProcessor)localObject).a());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      paramString = (PortraitTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        paramString.h();
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return a(paramString1, paramInt, paramString2, null, paramLong, 2, true);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    return a(paramString1, paramInt, paramString3, paramString2, paramLong, 1, false);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = new HttpDownloadFileProcessor(paramString1, paramString2, this);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      paramString2.b(paramString1);
      paramString2.a();
      return true;
    }
    paramString1 = (HttpDownloadFileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if (paramString1 != null) {
      paramString1.g();
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString2))
    {
      paramString1 = new PortraitTransfileProcessor(paramString1, -1, paramString2, true, 0, paramInt, this);
      paramString1.a(paramByte);
      paramString1.e(1);
      paramString1.b(paramString2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      paramString1.a();
      return true;
    }
    paramString1 = (PortraitTransfileProcessor)a(paramString2);
    if (paramString1 != null) {
      paramString1.g();
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramString2 + paramLong1))
    {
      BuddyTransfileProcessor localBuddyTransfileProcessor = new BuddyTransfileProcessor(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
      localBuddyTransfileProcessor.a(paramLong1);
      localBuddyTransfileProcessor.a().e = paramString2;
      localBuddyTransfileProcessor.b(paramString1 + paramString2 + paramLong1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localBuddyTransfileProcessor);
      localBuddyTransfileProcessor.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3);
      return true;
    }
    paramString1 = (BuddyTransfileProcessor)a(paramString1 + paramString2 + paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, short paramShort)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramLong))
    {
      paramString2 = new BuddyTransfileProcessor(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong);
      paramString2.a(paramLong);
      paramString2.c();
      paramString2.b(paramString1 + paramLong);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong, paramString2);
      paramString2.a(paramShort, false);
      return true;
    }
    paramString1 = (BuddyTransfileProcessor)a(paramString1, paramString2, paramLong);
    if (paramString1 != null) {
      paramString1.a(paramShort, false);
    }
    return false;
  }
  
  public boolean a(String paramString, short paramShort)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString + paramShort))
    {
      PortraitTransfileProcessor localPortraitTransfileProcessor = (PortraitTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramShort);
      if (localPortraitTransfileProcessor != null) {
        localPortraitTransfileProcessor.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString + paramShort);
      return true;
    }
    return false;
  }
  
  public int b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).b();
      }
    }
    return 0;
  }
  
  public TransferResult b(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.jdField_a_of_type_Boolean = false;
    paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = new TransferResult();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramTransferRequest.jdField_b_of_type_Int == 131076)
      {
        localObject = new UrlDownloader(this, paramTransferRequest);
        a(paramTransferRequest, (BaseTransProcessor)localObject, a(paramTransferRequest), false);
      }
    }
    for (;;)
    {
      return paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
      {
        localObject = new GroupPicDownloadProcessor(this, paramTransferRequest);
        break;
      }
      localObject = new C2CPicDownloadProcessor(this, paramTransferRequest);
      break;
      localObject = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      ((TransferResult)localObject).d = -1;
      ((TransferResult)localObject).jdField_a_of_type_Long = 9366L;
      ((TransferResult)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public IHttpCommunicatorListener b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (BaseTransProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          FileMsg localFileMsg = ((BaseTransProcessor)localObject).a();
          if ((localFileMsg != null) && (paramString.equalsIgnoreCase(localFileMsg.e))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
    }
  }
  
  public void b(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.b(paramTransProcessorHandler);
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_b_of_type_JavaLangString)) && (((BaseTransProcessor)localObject).d))
          {
            ((BaseTransProcessor)localObject).f();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label171;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).g) || (((BaseTransProcessor)localObject).d)) {
        break label171;
      }
      ((BaseTransProcessor)localObject).i();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + ((BaseTransProcessor)localObject).a());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      PortraitTransfileProcessor localPortraitTransfileProcessor = (PortraitTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localPortraitTransfileProcessor != null) {
        localPortraitTransfileProcessor.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return a(paramString1, paramInt, null, paramString2, paramLong, 2, false);
  }
  
  /* Error */
  public boolean b(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 67	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 43	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 333	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 43	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 222	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 400	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 689	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:i	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	TransFileController
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1 + paramString2);
    if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
    {
      localObject = (BaseTransProcessor)localObject;
      if (((BaseTransProcessor)localObject).e)
      {
        ((BaseTransProcessor)localObject).i();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "pauseRawSend uin:" + paramString1 + ",uniseq:" + paramString2 + ",key:" + ((BaseTransProcessor)localObject).a());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString1 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null) {
        paramString1.h();
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, short paramShort)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString + paramShort))
    {
      paramString = (PortraitTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramShort);
      if (paramString != null) {
        paramString.h();
      }
      return true;
    }
    return false;
  }
  
  public int c(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).a();
      }
    }
    return 0;
  }
  
  public void c()
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        ((BaseTransProcessor)localObject).h();
        ((BaseTransProcessor)localObject).g();
        ((BaseTransProcessor)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public boolean c()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label178;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).e) || (((BaseTransProcessor)localObject).d)) {
        break label178;
      }
      ((BaseTransProcessor)localObject).i();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((BaseTransProcessor)localObject).a());
      }
      bool = true;
    }
    label178:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        HttpDownloadFileProcessor localHttpDownloadFileProcessor = (HttpDownloadFileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (localHttpDownloadFileProcessor != null) {
          localHttpDownloadFileProcessor.h();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
      return false;
    }
  }
  
  public boolean c(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return a(paramString1, paramInt, paramString2, null, paramLong, 1, true);
  }
  
  /* Error */
  public boolean c(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 67	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 43	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 333	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 43	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 222	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 389	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 707	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:i	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	TransFileController
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return e(paramString1 + paramString2);
  }
  
  public boolean c(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramString2 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public int d(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return (int)((BaseTransProcessor)paramString1).c();
      }
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = a((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
      {
        localObject = (BaseTransProcessor)localObject;
        if (((BaseTransProcessor)localObject).d)
        {
          ((BaseTransProcessor)localObject).f();
          if (QLog.isColorLevel()) {
            QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + ((BaseTransProcessor)localObject).a());
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public boolean d(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return a(paramString1, paramInt, null, paramString2, paramLong, 65537, false);
  }
  
  public boolean d(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      paramString = (CommenTransFileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null)
      {
        paramString.h();
        paramString.v();
      }
      return true;
    }
    return false;
  }
  
  public boolean d(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString1 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null) {
        paramString1.h();
      }
      return true;
    }
    return false;
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
      {
        localObject = (BaseTransProcessor)localObject;
        if ((((BaseTransProcessor)localObject).e) && (((BaseTransProcessor)localObject).d))
        {
          ((BaseTransProcessor)localObject).f();
          if (QLog.isColorLevel()) {
            QLog.d("raw_photo", 2, "resumeAllRawSend key" + ((BaseTransProcessor)localObject).a());
          }
        }
      }
    }
  }
  
  public boolean e(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.e) && (paramString.d))
      {
        paramString.f();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.a());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean e(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return b(paramString1, paramInt, paramString2, null, paramLong, 2, true);
  }
  
  public boolean e(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      CommenTransFileProcessor localCommenTransFileProcessor = (CommenTransFileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localCommenTransFileProcessor != null) {
        localCommenTransFileProcessor.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return true;
    }
    return false;
  }
  
  public boolean e(String paramString1, String paramString2, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = new HttpContinueDownloadFileProcessor(paramString1, paramString2, paramLong, this);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      paramString2.b(paramString1);
      paramString2.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "startContinueDownloadFile  failed,url is:" + paramString1 + ",filePath is:" + paramString2 + ",destFileLen is:" + paramLong);
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      e((String)localIterator.next());
    }
  }
  
  public boolean f(String paramString)
  {
    if (paramString == null) {}
    label90:
    label91:
    for (;;)
    {
      return false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localIHttpCommunicatorListener)) || (!paramString.equals(((BaseTransProcessor)localIHttpCommunicatorListener).a.jdField_b_of_type_JavaLangString))) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label91;
        }
        return true;
      }
    }
  }
  
  public boolean f(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return b(paramString1, paramInt, null, paramString2, paramLong, 2, false);
  }
  
  public boolean f(String paramString, long paramLong)
  {
    return a(paramString, paramLong) != null;
  }
  
  public boolean g(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return b(paramString1, paramInt, paramString2, null, paramLong, 1, true);
  }
  
  public boolean h(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    return b(paramString1, paramInt, null, paramString2, paramLong, 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController
 * JD-Core Version:    0.7.0.1
 */