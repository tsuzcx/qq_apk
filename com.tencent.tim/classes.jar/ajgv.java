import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ajgv
{
  public static AtomicLong F = new AtomicLong(1L);
  public static boolean cov = true;
  public static boolean cow = true;
  public static boolean cox = true;
  public static boolean coy;
  
  public static String J(int paramInt1, int paramInt2)
  {
    return String.format("http://%s:%d/", new Object[] { ez(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static String a(double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean) {
      return f(paramDouble);
    }
    return e(paramDouble);
  }
  
  public static String a(ajel paramajel)
  {
    String str = String.format("%s_%d", new Object[] { paramajel.uin, Integer.valueOf(cS(paramajel.uinType)) });
    if (!TextUtils.isEmpty(paramajel.bQW)) {
      str = String.format("%s_%d_%s", new Object[] { paramajel.uin, Integer.valueOf(cS(paramajel.uinType)), paramajel.bQW });
    }
    return ajgr.bRk + str + ".db";
  }
  
  public static void a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000))
    {
      paramMsgBackupResEntity.msgSeq = paramMessageRecord.shmsgseq;
      return;
    }
    int i = anbk.ac(paramMessageRecord.msgUid);
    paramMsgBackupResEntity.msgSeq = (0xFFFF & (short)(int)paramMessageRecord.shmsgseq);
    paramMsgBackupResEntity.msgRandom = i;
  }
  
  public static void a(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((cow) && (paramMsgBackupMsgEntity != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.decryptFromString(paramMsgBackupMsgEntity.chatUin, ajee.bQT);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extraData, ajee.bQT);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extensionData, ajee.bQT);
      }
    }
  }
  
  public static void a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((cow) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (ajee.bQS != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupResEntity.extraData, ajee.bQS);
    }
  }
  
  public static void a(String paramString, ajel paramajel)
  {
    paramString = paramString.substring(0, paramString.indexOf(".")).split("_");
    paramajel.uin = paramString[0];
    paramajel.uinType = fk(Integer.parseInt(paramString[1]));
    if (paramString.length > 2) {
      paramajel.bQW = paramString[2];
    }
  }
  
  public static String aq(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public static boolean aqD()
  {
    String str = ajgr.bRk;
    Object localObject = new File(str);
    boolean bool2 = ((File)localObject).exists();
    if (!bool2) {
      bool2 = ((File)localObject).mkdirs();
    }
    for (;;)
    {
      boolean bool1;
      if (bool2)
      {
        File localFile = new File(ajgr.bRj);
        boolean bool3 = localFile.exists();
        bool1 = bool3;
        localObject = localFile;
        if (!bool3)
        {
          bool1 = localFile.mkdirs();
          localObject = localFile;
        }
      }
      for (;;)
      {
        logD("Manager.init.file mkdirs result = %b,dbDirExist = %b,filePath = %s,multimsgDirExist = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((File)localObject).exists()), str, Boolean.valueOf(bool1) });
        return bool2;
        bool1 = false;
      }
    }
  }
  
  public static String b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      b("MsgBackup", "decrptUrlPathParams key is null", new Object[0]);
    }
    if ((cow) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      b("MsgBackup", "decrptUrlPathParams originUrl = %s, ipFrom = %d, port = %d, encryptkey is not null!", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1 = paramString1.split(J(paramInt1, paramInt2));
      if (paramString1.length == 2)
      {
        paramString2 = (String)t(MsgBackupJniProxy.decryptFromString(paramString1[1], paramString2)).get("filepath");
        if (TextUtils.isEmpty(paramString2)) {
          return "";
        }
        paramString1 = paramString2;
        if (cox) {
          paramString1 = Uri.decode(paramString2);
        }
        paramString1 = mb(paramString1);
        b("decrptUrlPathParams filepath = %s", paramString1, new Object[0]);
      }
    }
    for (;;)
    {
      return paramString1;
      paramString1 = "";
    }
  }
  
  public static void b(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((cow) && (paramMsgBackupMsgEntity != null) && (ajee.bQS != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.encryptFromString(paramMsgBackupMsgEntity.chatUin, ajee.bQS);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extraData, ajee.bQS);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extensionData, ajee.bQS);
      }
    }
  }
  
  public static void b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((cow) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (ajee.bQT != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupResEntity.extraData, ajee.bQT);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!cov) {}
    String str;
    do
    {
      return;
      str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = "MsgBackup";
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(str, 4, String.format(paramString2, paramVarArgs));
  }
  
  public static String bk(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      b("MsgBackup", "decryptPartionUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (cow)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          b("MsgBackup", "originUrl = %s, encryptkey = %s", new Object[] { paramString1, paramString2 });
          String[] arrayOfString = paramString1.split("\\/");
          str = paramString1;
          if (arrayOfString.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(arrayOfString[1], paramString2);
            str = "/" + paramString1;
            b("MsgBackup", "decryptUrl = %s", new Object[] { str });
          }
        }
      }
    }
    return str;
  }
  
  public static String bl(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      b("MsgBackup", "encryptUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (cow)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          b("MsgBackup", "encryptUrlParams urlParams = %s, encryptkey is not null!", new Object[] { paramString1 });
          str = MsgBackupJniProxy.encryptFromString(paramString1, paramString2);
          b("MsgBackup", "encryptUrlParams params = %s", new Object[] { str });
        }
      }
    }
    return str;
  }
  
  public static String bw(long paramLong)
  {
    return k(paramLong, true);
  }
  
  public static long c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) {
      return paramMessageRecord.shmsgseq;
    }
    return 0xFFFF & (short)(int)paramMessageRecord.shmsgseq;
  }
  
  public static String c(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      b("MsgBackup", "decryptUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (cow)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          b("MsgBackup", "originUrl = %s, ipFrom = %d, port = %d, encryptkey is not null!", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          str = J(paramInt1, paramInt2);
          String[] arrayOfString = paramString1.split(str);
          if (arrayOfString.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(arrayOfString[1], paramString2);
            paramString1 = str + paramString1;
          }
          b("MsgBackup", "decryptUrl = %s", new Object[] { paramString1 });
          str = paramString1;
        }
      }
    }
    return str;
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static int cS(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  public static boolean cl(long paramLong)
  {
    return paramLong <= 1048576L;
  }
  
  public static long d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) {
      return 0L;
    }
    return anbk.ac(paramMessageRecord.msgUid);
  }
  
  public static int dB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split("\\.");
    } while (paramString.length != 4);
    try
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      int m = Integer.parseInt(paramString[3]);
      return m << 24 | i | j << 8 | k << 16;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackup", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static void dwB()
  {
    ahbj.deleteFile(ajgr.ROOT_PATH);
  }
  
  public static String e(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d = -paramDouble;
    }
    long l3 = (100.0D * d + 0.5D);
    long l1 = 100L;
    int i = 3;
    int j;
    long l2;
    for (;;)
    {
      j = i;
      l2 = l1;
      if (l1 * 10L > l3) {
        break;
      }
      l1 *= 10L;
      i += 1;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l1 = l3 / l2 % 10L;
      l2 /= 10L;
      if ((j != 1) || (l1 != 0L)) {
        localStringBuilder.append((char)(int)(l1 + 48L));
      }
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String ez(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static String f(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d = -paramDouble;
    }
    long l3 = (100.0D * d + 0.5D);
    long l1 = 100L;
    int i = 3;
    int j;
    long l2;
    for (;;)
    {
      j = i;
      l2 = l1;
      if (l1 * 10L > l3) {
        break;
      }
      l1 *= 10L;
      i += 1;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l1 = l3 / l2;
      l2 /= 10L;
      localStringBuilder.append((char)(int)(l1 % 10L + 48L));
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int fk(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 3000;
    }
    return 0;
  }
  
  public static long go()
  {
    long l = F.get();
    F.set(1L + l);
    return l;
  }
  
  public static int hW(int paramInt)
  {
    if (paramInt == -1000) {
      return 1;
    }
    return 2;
  }
  
  public static String j(String paramString1, int paramInt, String paramString2)
  {
    String str = String.format("%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(paramString2)) {
      str = String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    }
    return ajgr.bRk + str + ".db";
  }
  
  private static String k(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      str = "0K";
    }
    do
    {
      return str;
      if (paramLong <= 1024L)
      {
        if (paramBoolean) {
          return "1.00K";
        }
        return "1.0K";
      }
      str = "";
      if (paramLong >= 1073741824L)
      {
        str = "" + a(paramLong / 1073741824.0D, paramBoolean);
        return str + "G";
      }
      if (paramLong >= 1048576L)
      {
        if (paramLong >= 1048576000L)
        {
          str = "" + a(paramLong / 1048576.0D / 1024.0D, paramBoolean);
          return str + "G";
        }
        str = "" + a(paramLong / 1048576.0D, paramBoolean);
        return str + "M";
      }
    } while (paramLong < 1024L);
    if (paramLong >= 1024000L)
    {
      str = "" + a(paramLong / 1024.0D / 1024.0D, paramBoolean);
      return str + "M";
    }
    String str = "" + a(paramLong / 1024.0D, paramBoolean);
    return str + "K";
  }
  
  public static void logD(String paramString, Object... paramVarArgs)
  {
    if (!cov) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("MsgBackup", 4, String.format(paramString, paramVarArgs));
  }
  
  public static String mb(String paramString)
  {
    return paramString;
  }
  
  public static String mc(String paramString)
  {
    return ajgr.bRj + paramString;
  }
  
  public static String md(String paramString)
  {
    String str = paramString;
    if (cox) {
      str = Uri.encode(paramString);
    }
    return str;
  }
  
  public static void o(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, String.format(paramString, paramVarArgs));
    }
  }
  
  public static Map<String, String> t(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\?");
      if (paramString.length > 1)
      {
        paramString = paramString[1].split("&");
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          int k = localObject.indexOf("=");
          if (k == -1) {}
          for (;;)
          {
            i += 1;
            break;
            localHashMap.put(localObject.substring(0, k), localObject.substring(k + 1));
          }
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgv
 * JD-Core Version:    0.7.0.1
 */