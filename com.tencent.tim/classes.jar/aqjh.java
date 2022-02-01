import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;

public class aqjh
{
  private static final SparseIntArray ak = new SparseIntArray(8);
  private static boolean cUm;
  private static boolean cUn;
  
  static
  {
    ak.put(4, 13);
    ak.put(12, 14);
    ak.put(20, 16);
    ak.put(28, 18);
    ak.put(36, 20);
    ak.put(44, 21);
    ak.put(52, 27);
    ak.put(60, 32);
  }
  
  public static void Q(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 8;
    if (paramInt == 8) {}
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 1) {
        i = 1;
      } else if (paramInt == 2) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static void SE(boolean paramBoolean)
  {
    HashMap localHashMap;
    if (!cUm)
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "actRPSonicSoLoadStatus", true, 0L, 0L, localHashMap, "");
      cUm = true;
      return;
    }
  }
  
  public static void Xt(int paramInt)
  {
    if (!cUn)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_type", paramInt + "");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "actRPPttPlayerType", true, 0L, 0L, localHashMap, "");
      cUn = true;
    }
  }
  
  public static ptt_waveform.PttWaveform a(int[] paramArrayOfInt)
  {
    ptt_waveform.PttWaveform localPttWaveform = new ptt_waveform.PttWaveform();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localPttWaveform.uin32_size.set(paramArrayOfInt.length);
      byte[] arrayOfByte = new byte[paramArrayOfInt.length];
      int j = 0;
      if (j < paramArrayOfInt.length)
      {
        int k = paramArrayOfInt[j];
        int i;
        if (k < 0) {
          i = 0;
        }
        for (;;)
        {
          arrayOfByte[j] = ((byte)(i & 0xFF));
          j += 1;
          break;
          i = k;
          if (k > 255) {
            i = 255;
          }
        }
      }
      localPttWaveform.bytes_amplitudes.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    return localPttWaveform;
  }
  
  private static final boolean a(ByteArrayInputStream paramByteArrayInputStream, int[] paramArrayOfInt)
    throws IOException
  {
    paramByteArrayInputStream.read("#!AMR\n".getBytes());
    int j = paramByteArrayInputStream.read();
    int i = 0;
    if ((i >= paramArrayOfInt.length) || (j == paramArrayOfInt[i])) {
      if (i != paramArrayOfInt.length) {
        break label45;
      }
    }
    label45:
    do
    {
      return false;
      i += 1;
      break;
      i = ak.get(j, -1);
    } while (i == -1);
    paramArrayOfInt = new byte[i - 1];
    paramByteArrayInputStream.read(paramArrayOfInt);
    for (;;)
    {
      i = paramByteArrayInputStream.read();
      if (i == -1) {
        break label95;
      }
      if (i != j) {
        break;
      }
      paramByteArrayInputStream.read(paramArrayOfInt);
    }
    label95:
    return true;
  }
  
  public static int[] a(ptt_waveform.PttWaveform paramPttWaveform)
  {
    int j;
    int[] arrayOfInt;
    if ((paramPttWaveform != null) && (paramPttWaveform.uin32_size.has()) && (paramPttWaveform.uin32_size.get() > 0) && (paramPttWaveform.bytes_amplitudes.has()))
    {
      j = paramPttWaveform.uin32_size.get();
      arrayOfInt = new int[j];
      paramPttWaveform = paramPttWaveform.bytes_amplitudes.get().toByteArray();
      if (paramPttWaveform.length != j) {
        QLog.e("PttUtils", 2, "changePtToWaveform, data error");
      }
    }
    else
    {
      return null;
    }
    int i = 0;
    while (i < j)
    {
      paramPttWaveform[i] &= 0xFF;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      if (paramInt2 != 8) {
        break label147;
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt2 + ", sessionType = " + paramInt1 + ", seconds = " + paramInt3);
      }
      return;
      if (paramInt1 == 3000)
      {
        paramInt1 = 2;
        break;
      }
      if (paramInt1 == 1)
      {
        paramInt1 = 3;
        break;
      }
      paramInt1 = 4;
      break;
      label147:
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt2 == 1) {}
        for (int i = 1;; i = 2)
        {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i + "", paramInt1 + "", paramInt3 + "", "");
          break;
        }
      }
      if (paramInt2 == 4) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      } else {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      }
    }
  }
  
  /* Error */
  public static final boolean e(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 224	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: iload_3
    //   12: istore_2
    //   13: aload_0
    //   14: invokevirtual 230	java/io/File:exists	()Z
    //   17: ifeq +14 -> 31
    //   20: aload_0
    //   21: invokevirtual 234	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne +7 -> 33
    //   29: iload_3
    //   30: istore_2
    //   31: iload_2
    //   32: ireturn
    //   33: new 169	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokestatic 240	aqhq:fileToBytes	(Ljava/io/File;)[B
    //   41: invokespecial 243	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore 4
    //   46: aload 4
    //   48: astore_0
    //   49: aload 4
    //   51: aload_1
    //   52: invokestatic 245	aqjh:a	(Ljava/io/ByteArrayInputStream;[I)Z
    //   55: istore_2
    //   56: iload_2
    //   57: istore_3
    //   58: iload_3
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull -31 -> 31
    //   65: aload 4
    //   67: invokevirtual 248	java/io/ByteArrayInputStream:close	()V
    //   70: iload_3
    //   71: ireturn
    //   72: astore_0
    //   73: iload_3
    //   74: ireturn
    //   75: astore 5
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +15 -> 99
    //   87: aload_1
    //   88: astore_0
    //   89: ldc 196
    //   91: iconst_2
    //   92: ldc 250
    //   94: aload 5
    //   96: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: iload_3
    //   100: istore_2
    //   101: aload_1
    //   102: ifnull -71 -> 31
    //   105: aload_1
    //   106: invokevirtual 248	java/io/ByteArrayInputStream:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 248	java/io/ByteArrayInputStream:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_0
    //   128: goto -3 -> 125
    //   131: astore_1
    //   132: goto -15 -> 117
    //   135: astore 5
    //   137: aload 4
    //   139: astore_1
    //   140: goto -61 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramArrayOfInt	int[]
    //   12	89	2	bool1	boolean
    //   1	99	3	bool2	boolean
    //   44	94	4	localByteArrayInputStream	ByteArrayInputStream
    //   75	20	5	localThrowable1	java.lang.Throwable
    //   135	1	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	70	72	java/lang/Exception
    //   33	46	75	java/lang/Throwable
    //   105	109	111	java/lang/Exception
    //   33	46	114	finally
    //   121	125	127	java/lang/Exception
    //   49	56	131	finally
    //   81	87	131	finally
    //   89	99	131	finally
    //   49	56	135	java/lang/Throwable
  }
  
  public static void eA(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      str1 = paramQQAppInterface.getCurrentUin();
      if (!TextUtils.equals(xla.currentUin, str1))
      {
        xla.currentUin = str1;
        xla.bhC = false;
        QLog.e("vip_ptt.PttUtils", 1, "it have change the account so init ptt state value");
      }
    } while (xla.bhC);
    String str1 = "businessinfo_ptt_auto_change_text_" + paramQQAppInterface.getCurrentAccountUin();
    String str2 = "businessinfo_ptt_auto_change_time_" + paramQQAppInterface.getCurrentAccountUin();
    String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("check_update_sp_key", 0);
    aemd localaemd = (aemd)aeif.a().o(442);
    aera localaera = aerb.c();
    boolean bool2 = VipUtils.ce(paramQQAppInterface);
    boolean bool1;
    if (localaera.stage > 1)
    {
      bool1 = bool2;
      label165:
      QLog.e("vip_ptt.PttUtils", 1, "ignore initAutoToTextSwitch is svip=" + bool2 + " stage=" + localaera.stage);
      if (((localaemd == null) || (localaemd.isOpen())) && (!bool1)) {
        break label346;
      }
      paramQQAppInterface = localSharedPreferences.edit();
      paramQQAppInterface.putBoolean(str1, false);
      paramQQAppInterface.apply();
      xla.bhz = false;
    }
    for (;;)
    {
      xla.Jb = localSharedPreferences.getLong(str2, 9223372036854775807L);
      xla.bhA = localSharedPreferences.getBoolean(str3, false);
      xla.bhC = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PttUtils", 2, "initAutoToTextSwitch switch:" + xla.bhz + ", time:" + xla.Jb + ", hasAddTips:" + xla.bhA);
      return;
      bool1 = false;
      break label165;
      label346:
      xla.bhz = localSharedPreferences.getBoolean(str1, false);
      QLog.e("vip_ptt.PttUtils", 1, "initAutoToTextSwitch enable=" + xla.bhz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjh
 * JD-Core Version:    0.7.0.1
 */