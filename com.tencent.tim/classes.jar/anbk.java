import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class anbk
{
  @Deprecated
  public static final short[] a = { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 };
  public static final short[] j = { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 };
  public static final short[] k = { 33, 40, 19, 43, 21, 9, 20, 106, 35, 250, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219 };
  @Deprecated
  public static final short[] l = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 251, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static byte[] B(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length * 2);
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] != 20) {
        if (paramArrayOfByte[i] == 13) {
          if ((i > 0) && (paramArrayOfByte[(i - 1)] == 20))
          {
            localByteBuffer.put(paramArrayOfByte[i]);
            m = i;
          }
        }
      }
      int n;
      do
      {
        for (;;)
        {
          i = m + 1;
          break;
          if (i + 1 < paramArrayOfByte.length)
          {
            m = i;
            if (paramArrayOfByte[(i + 1)] != 10)
            {
              localByteBuffer.put((byte)10);
              m = i;
            }
          }
          else
          {
            localByteBuffer.put((byte)10);
            m = i;
            continue;
            localByteBuffer.put(paramArrayOfByte[i]);
            m = i;
          }
        }
        n = (short)(paramArrayOfByte[(i + 1)] & 0xFF);
        localByteBuffer.put(paramArrayOfByte[i]);
        m = i;
      } while (l[n] <= 0);
      int m = l[n] - 1;
      if (m < 128) {
        localByteBuffer.put((byte)m);
      }
      for (;;)
      {
        m = i + 1;
        break;
        localByteBuffer.put((byte)(m >> 6 & 0x1F | 0xC0));
        localByteBuffer.put((byte)(m >> 0 & 0x3F | 0x80));
      }
    }
    paramArrayOfByte = new byte[localByteBuffer.position()];
    localByteBuffer.flip();
    localByteBuffer.get(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public static long I(int paramInt)
  {
    return 0x0 | paramInt;
  }
  
  public static int Ji()
  {
    return Math.abs(new Random().nextInt());
  }
  
  public static byte[] X(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = paramString.length();
    byte[] arrayOfByte = new byte[i1 << 2];
    int n = 0;
    int m = 0;
    if (n < i1)
    {
      int i = paramString.charAt(n);
      if (i != 20) {
        m += a(i, arrayOfByte, m);
      }
      for (;;)
      {
        n += 1;
        break;
        int i2 = m + 1;
        arrayOfByte[m] = ((byte)i);
        i = paramString.charAt(n + 1);
        if (i >= a.length)
        {
          m = a(i, arrayOfByte, i2) + i2;
        }
        else
        {
          int i3 = (char)(a[i] + 65);
          m = i2 + 1;
          arrayOfByte[i2] = ((byte)i3);
          n += 1;
        }
      }
    }
    paramString = new byte[m];
    System.arraycopy(arrayOfByte, 0, paramString, 0, m);
    return paramString;
  }
  
  static int a(char paramChar, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramChar < '')
    {
      paramArrayOfByte[(0 + paramInt)] = ((byte)paramChar);
      return 1;
    }
    if (paramChar < 'ࠀ')
    {
      paramArrayOfByte[(paramInt + 0)] = ((byte)(paramChar >> '\006' & 0x1F | 0xC0));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar & 0x3F | 0x80));
      return 2;
    }
    if (paramChar < 65536)
    {
      paramArrayOfByte[(paramInt + 0)] = ((byte)(paramChar >> '\f' & 0xF | 0xE0));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar >> '\006' & 0x3F | 0x80));
      paramArrayOfByte[(paramInt + 2)] = ((byte)(paramChar & 0x3F | 0x80));
      return 3;
    }
    if (paramChar < 2097152)
    {
      paramArrayOfByte[(paramInt + 0)] = ((byte)(paramChar >> '\022' & 0x7 | 0xF0));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar >> '\f' & 0x3F | 0x80));
      paramArrayOfByte[(paramInt + 2)] = ((byte)(paramChar >> '\006' & 0x3F | 0x80));
      paramArrayOfByte[(paramInt + 3)] = ((byte)(paramChar & 0x3F | 0x80));
      return 4;
    }
    return 0;
  }
  
  public static String a(String paramString, boolean paramBoolean, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int i4 = 0;
    int m = 0;
    int i5 = 0;
    int n = 0;
    int i3 = 0;
    int i;
    if (i3 < arrayOfChar.length)
    {
      paramString = null;
      i = m;
      if (paramArrayList != null)
      {
        i = m;
        label49:
        if (i >= paramArrayList.size()) {
          break label396;
        }
        paramString = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
        if ((paramString == null) || (!paramString.isValid())) {
          break label212;
        }
      }
    }
    for (;;)
    {
      int i1 = i;
      m = n;
      int i2 = i5;
      if (paramString != null)
      {
        i1 = i;
        m = n;
        i2 = i5;
        if (paramString.startPos <= i3)
        {
          if (paramString.startPos == i3) {
            n = i4;
          }
          if (i3 < paramString.startPos + paramString.textLen)
          {
            i1 = i;
            m = n;
            i2 = i5;
            if (arrayOfChar[i3] != '\024') {
              break label254;
            }
            i4 -= 2;
            i1 = n;
            m = i5 - 2;
            i2 = i3 + 1;
            n = i;
            i = i1;
            i1 = i2;
          }
        }
      }
      for (;;)
      {
        i5 = m;
        i3 = i1 + 1;
        m = n;
        n = i;
        break;
        label212:
        i += 1;
        break label49;
        paramString.startPos = ((short)(n + paramString.startPos));
        m = 0;
        paramString.textLen = ((short)(i5 + paramString.textLen));
        i2 = 0;
        i1 = i + 1;
        label254:
        if ((arrayOfChar[i3] == '\r') && ((!paramBoolean) || (i3 <= 0) || (arrayOfChar[(i3 - 1)] != '\024')))
        {
          arrayOfChar[(i3 + i4)] = '\n';
          if ((i3 + 1 < arrayOfChar.length) && (arrayOfChar[(i3 + 1)] == '\n'))
          {
            i4 -= 1;
            i = m;
            m = i2;
            n = i1;
            i1 = i3 + 1;
          }
        }
        else if (i4 != 0)
        {
          arrayOfChar[(i3 + i4)] = arrayOfChar[i3];
        }
        i = m;
        m = i2;
        n = i1;
        i1 = i3;
      }
      return new String(arrayOfChar, 0, arrayOfChar.length + i4);
      label396:
      paramString = null;
    }
  }
  
  public static void aI(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 0;
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = acfp.m(2131708241);
    long l1 = anaz.gQ();
    MessageRecord localMessageRecord = anbi.d(-2012);
    localMessageRecord.init(str1, paramString, str1, str2, l1, 0, 0, l1);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    paramString = paramQQAppInterface.b().k(paramString, 0);
    int i = m;
    if (paramString != null)
    {
      i = m;
      if (paramString.size() > 0)
      {
        i = m;
        if (top.a((MessageRecord)paramString.get(paramString.size() - 1), localMessageRecord, false))
        {
          if (QLog.isColorLevel()) {
            QLog.w("MessageUtils", 2, "inserShieldTipsForFriends filtered!");
          }
          i = 1;
        }
      }
    }
    if (i == 0) {
      paramQQAppInterface.b().b(localMessageRecord, str1);
    }
  }
  
  public static boolean aW(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1000)
    {
      if ((paramMessageRecord.msg == null) || (paramMessageRecord.msg.length() == 0)) {}
      while ((paramMessageRecord.msg.trim().length() == 0) && (paramMessageRecord.msg.charAt(0) != '\024')) {
        return true;
      }
    }
    return false;
  }
  
  public static int ab(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static int ac(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static boolean ah(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    return (paramInt != 0) && ((paramString.endsWith(".gif")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".bmp")));
  }
  
  public static boolean ai(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    return (paramInt != 0) && (paramString.endsWith(".amr"));
  }
  
  public static long d(long paramLong, int paramInt)
  {
    if (top.fv(paramInt)) {
      return (short)(int)paramLong;
    }
    return 0L;
  }
  
  public static int k(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = VipUtils.a(paramQQAppInterface, paramString);
    if ((i & 0x4) != 0) {}
    for (;;)
    {
      return 0;
      if ((i & 0x2) == 0) {}
    }
  }
  
  public static boolean ls(int paramInt)
  {
    return (paramInt == -1002) || (paramInt == -1001) || (paramInt == -1004) || (paramInt == -1047) || (paramInt == -1013) || (paramInt == -2030) || (paramInt == -1019) || (paramInt == -1018) || (paramInt == -4000) || (paramInt == -4001) || (paramInt == -3007) || (paramInt == -1012) || (paramInt == -2012) || (paramInt == -2013) || (paramInt == -3008) || (paramInt == -3009) || (paramInt == -4020) || (paramInt == -3010) || (paramInt == -3013) || (paramInt == -3014) || (paramInt == -3011) || (paramInt == -2015) || (paramInt == -2061) || (paramInt == -4008) || (paramInt == -4002) || (paramInt == -4003) || (paramInt == -4004) || (paramInt == -4005) || (paramInt == -1014) || (paramInt == -1016) || (paramInt == -1017) || (paramInt == -1050) || (paramInt == -4004) || (paramInt == -2019) || (paramInt == -7006) || (paramInt == -1041) || (paramInt == -1043) || (paramInt == -1044) || (paramInt == -1045) || (paramInt == -5000) || (paramInt == -5001) || (paramInt == 1018) || (paramInt == -4010) || (paramInt == -1024) || (paramInt == -1028) || (paramInt == -5002) || (paramInt == 2024) || (paramInt == -2042) || (paramInt == -1026) || (paramInt == -1027) || (paramInt == -5005) || (paramInt == -1046) || (paramInt == -2027) || (paramInt == -2037) || (paramInt == -4505) || (paramInt == -4506) || (paramInt == -4507) || (paramInt == -4011) || (paramInt == -5006) || (paramInt == -5007) || (paramInt == -2029) || (paramInt == -2031) || (paramInt == -2033) || (paramInt == -2034) || (paramInt == -1048) || (paramInt == -2041) || (paramInt == -2043) || (paramInt == -4021) || (paramInt == -4022) || (paramInt == -5011) || (paramInt == -2049) || (paramInt == -4012) || (paramInt == -2060) || (paramInt == -2065) || (paramInt == -2063) || (paramInt == -3016) || (paramInt == -4023) || (paramInt == -4024) || (paramInt == -7010) || (paramInt == -7009) || (paramInt == -7011);
  }
  
  public static boolean lt(int paramInt)
  {
    return (paramInt != -1002) && (paramInt != -1001) && (paramInt != -1004) && (paramInt != -4000) && (paramInt != -4001) && (paramInt != -3007) && (paramInt != -1012) && (paramInt != -2012) && (paramInt != -2013) && (paramInt != -3008) && (paramInt != -2015) && (paramInt != -2061) && (paramInt != -4002) && (paramInt != -4003) && (paramInt != -4004) && (paramInt != -4009) && (paramInt != -2021) && (paramInt != -5000) && (paramInt != -5001) && (paramInt != -2034) && (paramInt != -2033) && (paramInt != -1016) && (paramInt != -2060) && (paramInt != -2065) && (paramInt != -2066) && (paramInt != -2049) && (paramInt != -2023) && (paramInt != -2063) && (paramInt != -3016) && (paramInt != -4023) && (paramInt != -4024) && (paramInt != -7007) && (paramInt != -4012) && (paramInt != -7010) && (paramInt != -7009) && (paramInt != -7011);
  }
  
  public static boolean lu(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 31) || (paramInt == 79) || (paramInt == 97) || (paramInt == 120) || (paramInt == 132) || (paramInt == 133) || (paramInt == 166) || (paramInt == 167);
  }
  
  public static String nm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 1 < paramString.length()))
      {
        int n = afky.hl(paramString.charAt(i + 1));
        m = i;
        if (n >= 0)
        {
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(n / 128 + 65));
          localStringBuilder.append((char)(n % 128 + 65));
        }
      }
      for (int m = i + 1;; m = i)
      {
        i = m + 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String nn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int n = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        m = i;
        if (n >= 0) {
          localStringBuilder.append(String.valueOf(new char[] { '\024', (char)afky.hm(n) }));
        }
      }
      for (int m = i + 1 + 1;; m = i)
      {
        i = m + 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String[] r(String paramString)
  {
    String[] arrayOfString = new String[3];
    int i = paramString.indexOf("http://maps.google.com/maps?q=");
    Object localObject;
    int m;
    if (i >= 0)
    {
      paramString = paramString.substring(i);
      localObject = Pattern.compile("\\s*(loc:)?-?\\d+(.\\d+)?\\s*,\\s*-?\\d+(.\\d+)?").matcher(paramString);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          m = ((String)localObject).indexOf(',');
          i = ((String)localObject).indexOf("loc:");
          if (m >= 0)
          {
            if (i < 0) {
              break label181;
            }
            i += 4;
          }
        }
      }
    }
    for (;;)
    {
      arrayOfString[0] = ((String)localObject).substring(i, m);
      arrayOfString[1] = ((String)localObject).substring(m + 1, ((String)localObject).length());
      paramString = Pattern.compile("\\(.+\\)").matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group();
        if ((paramString != null) && (paramString.length() > 2)) {
          arrayOfString[2] = paramString.substring(1, paramString.length() - 1);
        }
      }
      if (arrayOfString[2] == null) {
        arrayOfString[2] = "";
      }
      return arrayOfString;
      label181:
      i = 0;
    }
  }
  
  public static String w(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbk
 * JD-Core Version:    0.7.0.1
 */