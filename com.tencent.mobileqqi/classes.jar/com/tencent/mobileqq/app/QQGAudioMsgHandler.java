package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fke;
import java.util.Vector;
import mqq.app.NewIntent;

public class QQGAudioMsgHandler
{
  static final int jdField_a_of_type_Int = 141;
  static final String jdField_a_of_type_JavaLangString = "QQGAudioMsgHandler";
  static final int jdField_b_of_type_Int = 195;
  private static final String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq:video";
  static final int c = 145;
  static final int d = 49;
  static final int e = 59;
  GAudioNotifyCenter jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  public byte[] a;
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte['ª'];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    int j = 0;
    int i = j;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        i = j;
      }
    }
    else {
      return i;
    }
    j = paramInt - 1;
    paramInt = k;
    for (;;)
    {
      i = paramInt;
      if (j < 0) {
        break;
      }
      paramInt = (int)(paramInt | (paramArrayOfByte[j] & 0xFF) << j * 8);
      j -= 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilVector != null) {
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(paramLong) <= 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(paramLong, null, 0L);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 14, false, String.valueOf(paramLong), str, false, null, false);
    this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(21, paramLong, 0L);
    ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramLong);
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(paramLong);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = (arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2CData: msgType = " + i);
    }
    if (!a()) {
      if (141 == i) {
        f(paramArrayOfByte);
      }
    }
    do
    {
      do
      {
        return;
        switch (i)
        {
        case 59: 
        default: 
          return;
        }
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      i = paramArrayOfByte.length;
    } while (i < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < i) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
    g(this.jdField_a_of_type_ArrayOfByte);
    return;
    a(paramArrayOfByte, 27);
    return;
    e(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "sendRoomInfoBroadcast");
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
  
  boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 9) || (!VcSystemInfo.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "device not surpport, SDK Version: " + i);
      }
      return false;
    }
    return true;
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    byte[] arrayOfByte = new byte[33];
    arrayOfByte[0] = ((byte)0);
    arrayOfByte[1] = ((byte)48);
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 2)] = ((byte)(int)(l >> (7 - i) * 8 & 0xFF));
      i += 1;
    }
    arrayOfByte[10] = 0;
    arrayOfByte[11] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = 1;
    arrayOfByte[16] = 4;
    i = 0;
    while (i < 4)
    {
      arrayOfByte[(i + 17)] = ((byte)(int)(paramLong >> (3 - i) * 8 & 0xFF));
      i += 1;
    }
    i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 21)] = ((byte)(int)(531L >> (7 - i) * 8 & 0xFF));
      i += 1;
    }
    arrayOfByte[29] = 0;
    arrayOfByte[30] = 0;
    arrayOfByte[31] = 0;
    arrayOfByte[32] = 1;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VideoConfigServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)462);
    localNewIntent.putExtra("selfuin", l);
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", arrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    int i = localObject[0];
    if (((localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      d(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((Intent)localObject).putExtra("type", 30);
      ((Intent)localObject).putExtra("buffer", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject);
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (!a()) {}
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    Object localObject;
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        arrayOfByte2 = new byte[4];
        arrayOfByte3 = new byte[8];
        localObject = null;
      } while ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (arrayOfByte3 == null));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
    } while (((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) < 4);
    int k = 2;
    int j = 0;
    int i = 0;
    int n = 0;
    label87:
    if (n < 4)
    {
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
      k += 2;
      switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
      {
      }
    }
    for (;;)
    {
      n += 1;
      break label87;
      k += 2;
      System.arraycopy(paramArrayOfByte, k, arrayOfByte2, 0, 4);
      j = VideoController.a(arrayOfByte2, 4);
      k += 4;
      continue;
      k += 2;
      System.arraycopy(paramArrayOfByte, k, arrayOfByte2, 0, 4);
      i = VideoController.a(arrayOfByte2, 4);
      if (i == 0)
      {
        a(j);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("GroupId", j);
        paramArrayOfByte.putExtra("Exit", true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfByte);
        return;
        k += 6;
        continue;
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
        int m = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (m <= 0) {
          break;
        }
        int i2 = m / 8;
        long[] arrayOfLong = new long[i2];
        m = k + 2;
        int i1 = 0;
        for (;;)
        {
          k = m;
          localObject = arrayOfLong;
          if (i1 >= i2) {
            break;
          }
          System.arraycopy(paramArrayOfByte, m, arrayOfByte3, 0, 8);
          arrayOfLong[i1] = VideoController.a(arrayOfByte3, 8);
          i1 += 1;
          m += 8;
        }
        if (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null) {
          break;
        }
        long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
        if ((i == 1) && (l == localObject[0]) && (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a() == 0L))
        {
          if (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(j) != 0L) {
            break;
          }
          b(j);
          return;
        }
        this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(j, localObject, i);
        this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(21, j, 0L);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("GroupId", j);
        paramArrayOfByte.putExtra("Exit", false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfByte);
        return;
      }
      k += 4;
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = Long.valueOf((String)localObject2).longValue();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      byte[] arrayOfByte3 = new byte[8];
      if ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (arrayOfByte3 == null)) {
        break;
      }
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte2, 0, 4);
      if (VideoController.a(arrayOfByte2, 4) != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31 error");
        return;
      }
      System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 2);
      int n = arrayOfByte1[0];
      int i1 = arrayOfByte1[1];
      int i = 0;
      int j = 10;
      int k = 0;
      localObject2 = null;
      label163:
      if (k < ((n & 0xFF) << 8 | (i1 & 0xFF) << 0))
      {
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        j += 2;
        switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
        {
        }
      }
      for (;;)
      {
        k += 1;
        break label163;
        i = j + 2;
        System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
        j = i + 4;
        i = VideoController.a(arrayOfByte2, 4);
        continue;
        j += 6;
        continue;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        j = j + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
        continue;
        j += 10;
        continue;
        j += 6;
        continue;
        j += 6;
        continue;
        j += 6;
        continue;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        j = j + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
        continue;
        j += 6;
        continue;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        int i2 = ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) / 8;
        localObject2 = new long[i2];
        int m = 0;
        j += 2;
        for (;;)
        {
          if (m < i2)
          {
            System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
            long l2 = VideoController.a(arrayOfByte3, 8);
            localObject2[m] = l2;
            if ((l2 == l1) && (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a() == 0L) && (0L == this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(i)))
            {
              String str = Integer.toString(i);
              VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, str, localObject1, true, null, false);
            }
            m += 1;
            j += 8;
            continue;
            if (localObject2.length <= 0) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(i, (long[])localObject2);
            this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(21, i, 0L);
            return;
          }
        }
      }
      l1 = 0L;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x91");
    }
    if (!a()) {}
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    int j;
    int i;
    label88:
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        arrayOfByte2 = new byte[4];
        arrayOfByte3 = new byte[8];
      } while ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (arrayOfByte3 == null) || (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null));
      System.arraycopy(paramArrayOfByte, 10, arrayOfByte1, 0, 2);
      int n = arrayOfByte1[0];
      int i1 = arrayOfByte1[1];
      j = 0;
      i = 12;
      if (j >= ((n & 0xFF) << 8 | (i1 & 0xFF) << 0)) {
        break label335;
      }
      i += 1;
      System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
      i += 2;
      if (((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) >= 22) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x91 tlvValueLength<22");
    return;
    System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
    i += 4;
    int i2 = VideoController.a(arrayOfByte2, 4);
    System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
    i += 2;
    int i3 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    if (i3 > 1) {}
    long[] arrayOfLong;
    for (int k = 2;; k = 1)
    {
      arrayOfLong = new long[k];
      if (arrayOfLong == null) {
        break label396;
      }
      int m = 0;
      while (m < k)
      {
        System.arraycopy(paramArrayOfByte, i, arrayOfByte3, 0, 8);
        i += 8;
        arrayOfLong[m] = VideoController.a(arrayOfByte3, 8);
        m += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(i2, arrayOfLong, i3);
    this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(21, i2, 0L);
    label396:
    for (;;)
    {
      j += 1;
      break label88;
      label335:
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilVector == null) {
        break;
      }
      j = this.jdField_a_of_type_JavaUtilVector.size();
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          i((byte[])this.jdField_a_of_type_JavaUtilVector.elementAt(i));
          i += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
  }
  
  void f(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[10];
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, arrayOfByte, 0, 4);
    i = a(arrayOfByte, 4);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 18, false, String.valueOf(i), paramArrayOfByte, false, null, false);
  }
  
  void g(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    Object localObject = new byte[8];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
    long l = VideoController.a((byte[])localObject, 8);
    i += 12;
    localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    int j = localObject[0];
    if (((localObject[1] & 0xFF) << 0 | (j & 0xFF) << 8) != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "current verion is only surpport discussion multiVideo");
      }
      return;
    }
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 3, localObject, 0, 4);
    i = a((byte[])localObject, 4);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite discussId is" + i + "InviteUin:" + l);
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(i);
    if (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter != null) {
      this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(i, new long[] { l }, 1L);
    }
    paramArrayOfByte = Integer.toString(i);
    localObject = Long.toString(l);
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, false);
    new QavWrapper(BaseApplication.getContext()).a(new fke(this));
    ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(0, i);
  }
  
  public void h(byte[] paramArrayOfByte)
  {
    if (!a()) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
          localObject = new byte[2];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
          i = localObject[0];
        } while (((localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8) != 141);
        i = (paramArrayOfByte[10] & 0xFF) + 19;
        localObject = new byte[8];
        System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
        l = VideoController.a((byte[])localObject, 8);
        i += 12;
        localObject = new byte[2];
        System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
        int j = localObject[0];
        if (((localObject[1] & 0xFF) << 0 | (j & 0xFF) << 8) == 2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "current verion is only surpport discussion multiVideo");
      return;
      Object localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, i + 3, localObject, 0, 4);
      int i = a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg discussId is:" + i);
      }
      localObject = Integer.toString(i);
      String str = Long.toString(l);
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, (String)localObject, str, false, null, false);
      if (this.jdField_a_of_type_Boolean)
      {
        i(paramArrayOfByte);
        return;
      }
    } while (this.jdField_a_of_type_JavaUtilVector == null);
    this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
  }
  
  void i(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i;
    do
    {
      return;
      i = paramArrayOfByte[10];
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, localObject, 0, 4);
      i = a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "dealGAudioOfflineMsg discussId is:" + i);
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter.a(i) <= 0L);
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(i);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Intent localIntent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler
 * JD-Core Version:    0.7.0.1
 */