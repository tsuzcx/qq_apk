package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.qphone.base.util.QLog;
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
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte['ª'];
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
  
  void a(long paramLong) {}
  
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
        case 195: 
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
    e(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt) {}
  
  boolean a()
  {
    int i = Build.VERSION.SDK_INT;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    if (((arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      d(paramArrayOfByte);
    }
  }
  
  public void c(byte[] paramArrayOfByte) {}
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        Long.valueOf((String)localObject).longValue();
      }
    }
    Object localObject = new byte[2];
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    if ((localObject == null) || (arrayOfByte1 == null) || (arrayOfByte2 == null)) {}
    int n;
    int i1;
    int i;
    int k;
    do
    {
      return;
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte1, 0, 4);
      System.arraycopy(paramArrayOfByte, 8, localObject, 0, 2);
      n = localObject[0];
      i1 = localObject[1];
      i = 10;
      k = 0;
    } while (k >= ((n & 0xFF) << 8 | (i1 & 0xFF) << 0));
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    i += 2;
    switch ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      for (;;)
      {
        k += 1;
        break;
        i += 2;
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
        i += 4;
        continue;
        i += 6;
        continue;
        System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
        i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
        continue;
        i += 10;
        continue;
        i += 6;
        continue;
        i += 6;
        continue;
        i += 6;
        continue;
        System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
        i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
        continue;
        i += 6;
      }
    }
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    int j = i + 2;
    int i2 = ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0) / 8;
    long[] arrayOfLong = new long[i2];
    int m = 0;
    for (;;)
    {
      i = j;
      if (m >= i2) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 8);
      m += 1;
      j += 8;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x91");
    }
    if (!a()) {}
    int i;
    label235:
    do
    {
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      Object localObject;
      do
      {
        do
        {
          return;
          arrayOfByte1 = new byte[2];
          arrayOfByte2 = new byte[4];
          localObject = new byte[8];
        } while ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (localObject == null));
        System.arraycopy(paramArrayOfByte, 10, arrayOfByte1, 0, 2);
        j = 12;
        int k = arrayOfByte1[0];
        int m = arrayOfByte1[1];
        i = 0;
        if (i >= ((k & 0xFF) << 8 | (m & 0xFF) << 0)) {
          break label235;
        }
        j += 1;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        j += 2;
        if (((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) >= 22) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2C_0x91 tlvValueLength<22");
      return;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      int n = j + 4;
      System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, 2);
      if (((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) > 1) {}
      for (j = 2;; j = 1)
      {
        localObject = new long[j];
        i += 1;
        j = n + 2;
        break;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilVector == null);
    int j = this.jdField_a_of_type_JavaUtilVector.size();
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
  }
  
  void f(byte[] paramArrayOfByte) {}
  
  void g(byte[] paramArrayOfByte) {}
  
  public void h(byte[] paramArrayOfByte)
  {
    if (!a()) {
      return;
    }
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = arrayOfByte[1];
  }
  
  void i(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler
 * JD-Core Version:    0.7.0.1
 */