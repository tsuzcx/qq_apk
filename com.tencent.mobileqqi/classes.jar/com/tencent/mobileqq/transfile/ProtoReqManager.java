package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import gnr;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class ProtoReqManager
{
  public static final String a = "Q.richmedia.ProtoReqManager";
  public static final String b = "key_runnable_index";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ConcurrentHashMap a;
  
  public ProtoReqManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Intent paramIntent, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_b_of_type_Boolean = true;
    paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(ProtoReqManager.ProtoResp paramProtoResp)
  {
    paramProtoResp.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramProtoResp.jdField_a_of_type_ArrayOfGnr.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramProtoResp.jdField_a_of_type_ArrayOfGnr[i]);
      i += 1;
    }
  }
  
  private boolean a(ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = 0;
    while (i < paramProtoResp.jdField_a_of_type_ArrayOfGnr.length)
    {
      if ((!paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_b_of_type_Boolean) && ((paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_a_of_type_Boolean == true) || (paramProtoResp.jdField_a_of_type_ArrayOfGnr[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      ProtoReqManager.ProtoResp localProtoResp;
      ProtoReqManager.ProtoReq localProtoReq;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onRecieve." + paramFromServiceMsg);
        }
        if ((paramIntent != null) && (paramFromServiceMsg != null))
        {
          localProtoResp = (ProtoReqManager.ProtoResp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
          if (localProtoResp != null)
          {
            boolean bool = localProtoResp.jdField_a_of_type_Boolean;
            if (!bool) {
              continue;
            }
          }
        }
        return;
        a(paramIntent, localProtoResp);
        localProtoReq = localProtoResp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq;
        localProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        localProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo.jdField_b_of_type_Int = localProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a(localProtoResp);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack == null) {
            continue;
          }
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramIntent = new byte[i];
          PkgTools.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramIntent);
          localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack.a(localProtoResp, localProtoReq);
          continue;
        }
        if (i != 2901) {
          break label340;
        }
      }
      finally {}
      long l1 = System.currentTimeMillis() - localProtoResp.jdField_a_of_type_Long;
      if ((l1 < localProtoReq.e) && (localProtoResp.jdField_a_of_type_Int < localProtoReq.jdField_b_of_type_Int))
      {
        long l2 = localProtoReq.jdField_a_of_type_Int;
        paramIntent = localProtoResp.jdField_a_of_type_ArrayOfGnr[localProtoResp.jdField_a_of_type_Int];
        localProtoResp.jdField_a_of_type_Int += 1;
        paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
        a(paramIntent, 0L);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localProtoResp.jdField_a_of_type_Int);
        continue;
        label340:
        if (a(localProtoResp))
        {
          a(localProtoResp);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack != null) {
            localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack.a(localProtoResp, localProtoReq);
          }
        }
      }
    }
  }
  
  public void a(ProtoReqManager.ProtoReq paramProtoReq)
  {
    int k = 0;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramProtoReq.jdField_a_of_type_JavaLangString);
      }
      if (paramProtoReq != null)
      {
        ProtoReqManager.ProtoResp localProtoResp = new ProtoReqManager.ProtoResp();
        paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp = localProtoResp;
        localProtoResp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = paramProtoReq;
        localProtoResp.jdField_a_of_type_Long = System.currentTimeMillis();
        localProtoResp.jdField_a_of_type_ArrayOfGnr = new gnr[paramProtoReq.jdField_b_of_type_Int];
        byte[] arrayOfByte = paramProtoReq.jdField_a_of_type_ArrayOfByte;
        Object localObject = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject).array();
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramProtoReq.jdField_b_of_type_Int) {
            break;
          }
          localObject = new gnr(this);
          localProtoResp.jdField_a_of_type_ArrayOfGnr[i] = localObject;
          ((gnr)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp = localProtoResp;
          ((gnr)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), ProtoServlet.class);
          localObject = ((gnr)localObject).jdField_a_of_type_MqqAppNewIntent;
          ((NewIntent)localObject).putExtra("key_body", arrayOfByte);
          ((NewIntent)localObject).putExtra("key_cmd", paramProtoReq.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("key_fastresend", paramProtoReq.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramProtoReq.jdField_b_of_type_Boolean);
          i += 1;
        }
        while (j < paramProtoReq.c)
        {
          long l1 = paramProtoReq.jdField_a_of_type_Int * j / paramProtoReq.c;
          long l2 = paramProtoReq.jdField_a_of_type_Int;
          long l3 = paramProtoReq.d * j;
          localProtoResp.jdField_a_of_type_ArrayOfGnr[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localProtoResp.jdField_a_of_type_ArrayOfGnr[j], l1);
          j += 1;
        }
        localProtoResp.jdField_a_of_type_Int = paramProtoReq.c;
      }
      return;
    }
    finally {}
  }
  
  void a(gnr paramgnr, long paramLong)
  {
    paramgnr.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramgnr, paramLong);
  }
  
  public void a(NewIntent paramNewIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramNewIntent);
  }
  
  public void b(ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoReq != null) {}
    try
    {
      if (paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp != null) {
        a(paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp);
      }
      return;
    }
    finally
    {
      paramProtoReq = finally;
      throw paramProtoReq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */