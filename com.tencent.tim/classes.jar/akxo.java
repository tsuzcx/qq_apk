import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class akxo
{
  private static SharedPreferences V = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
  private static SharedPreferences.Editor editor = V.edit();
  public static final String[] gd = { "XG预下载配额余量", "XG当前消耗流量", "XG流量总消耗", "XG预下载总数", "XG预下载命中数", "XG预下载未命中数", "XG手动看图数", "XG消耗量余量", "WIFI预下载总数", "WIFI预下载命中数", "WIFI预下载未命中数", "WIFI手动看图数", "XG是否超过上限", acfp.m(2131709639) };
  static String[] ge = { "1031637263", "81118728", "354653668", "87587790", "745798311", "362675669", "27801478", "991636135", "249484612", "279242625", "517152365", "349808804", "1053134469", "303137720", "9948938", "165326859", "584781501", "864600712", "410363461", "306392284", "878898475", "34242313", "842714741", "26080655", "1003187685" };
  public static final String[] keys = { "xgFlowPre", "xgFlowWaste", "accFlowPreTotal", "xgPreDownCount", "xgHitCount", "xgMissCount", "xgManulClickCount", "xgFlowWasteBalance", "wifiPreDownCout", "wifiHitCount", "wifiMissCount", "wifiManulClickCount" };
  
  public static int Hi()
  {
    int j = 3;
    int k = aqiw.getSystemNetwork(BaseApplication.getContext());
    int i;
    if (k == 1) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (k == 2);
      if (k == 3) {
        return 2;
      }
      i = j;
    } while (k != 4);
    return 1;
  }
  
  public static void NQ(String paramString) {}
  
  @TargetApi(9)
  public static void Q(String paramString1, String paramString2, boolean paramBoolean)
  {
    editor.putString(paramString1, paramString2);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        editor.apply();
      }
    }
    else {
      return;
    }
    editor.commit();
  }
  
  public static Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(V.getBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aool paramaool)
  {
    if (paramaool == null) {}
    while ((!(paramaool.F instanceof MessageForPic)) || (paramaool.mFileType == 65537)) {
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)paramaool.F;
    akxe.a("PIC_TAG_PRELOAD", "updateDownState", "Before update, networkType:" + localMessageForPic.preDownNetworkType + ",state:" + localMessageForPic.preDownState + ",uniseq:" + localMessageForPic.uniseq);
    if (paramaool.dpB == 1) {
      localMessageForPic.preDownState = 1;
    }
    for (;;)
    {
      akxe.a("PIC_TAG_PRELOAD", "updateDownState", "After update, networkType:" + localMessageForPic.preDownNetworkType + ",state:" + localMessageForPic.preDownState + ",uniseq:" + localMessageForPic.uniseq);
      b(paramQQAppInterface, localMessageForPic);
      return;
      if (paramaool.dpB == 3) {
        localMessageForPic.preDownState = 4;
      } else if ((localMessageForPic.preDownState != 1) && (localMessageForPic.preDownState != 4)) {
        localMessageForPic.preDownState = 0;
      }
    }
  }
  
  @TargetApi(9)
  public static void aw(String paramString, long paramLong)
  {
    m(paramString, paramLong, true);
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i;
    if (paramInt == 1)
    {
      i = 1;
      if ((i == 0) || (paramQQAppInterface == null)) {
        break label65;
      }
    }
    label65:
    label71:
    label77:
    label82:
    do
    {
      int j;
      for (;;)
      {
        try
        {
          bool = aizp.a().J(paramQQAppInterface, paramString);
          if (paramInt != 3000) {
            break label71;
          }
          j = 1;
          if (paramInt != 0) {
            break label77;
          }
          paramInt = 1;
          if (!bool) {
            break label82;
          }
          return 1;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.e(".troop", 1, "PicPreDownloadUtils.calcUinType Error", paramQQAppInterface);
        }
        i = 0;
        break;
        boolean bool = false;
        continue;
        j = 0;
        continue;
        paramInt = 0;
      }
      if (i != 0) {
        return 0;
      }
      if (j != 0) {
        return 2;
      }
    } while (paramInt == 0);
    return 3;
  }
  
  /* Error */
  public static long b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: lload_2
    //   5: lreturn
    //   6: aload_0
    //   7: getstatic 303	mqq/manager/ServerConfigManager$ConfigType:common	Lmqq/manager/ServerConfigManager$ConfigType;
    //   10: aload_1
    //   11: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:a	(Lmqq/manager/ServerConfigManager$ConfigType;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +74 -> 90
    //   19: aload_0
    //   20: invokestatic 313	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 317	java/lang/Long:longValue	()J
    //   28: lstore 4
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 317	java/lang/Long:longValue	()J
    //   35: invokestatic 319	akxo:aw	(Ljava/lang/String;J)V
    //   38: ldc 217
    //   40: ldc_w 321
    //   43: new 221	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 323
    //   53: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 325
    //   63: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: lload 4
    //   68: invokevirtual 250	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc_w 327
    //   74: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: lload_2
    //   78: invokevirtual 250	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 259	akxe:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   87: lload 4
    //   89: lreturn
    //   90: aload_1
    //   91: lload_2
    //   92: invokestatic 319	akxo:aw	(Ljava/lang/String;J)V
    //   95: lload_2
    //   96: lstore 4
    //   98: goto -60 -> 38
    //   101: astore_0
    //   102: lload_2
    //   103: lstore 4
    //   105: goto -67 -> 38
    //   108: astore_0
    //   109: goto -71 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramQQAppInterface	QQAppInterface
    //   0	112	1	paramString	String
    //   0	112	2	paramLong	long
    //   28	76	4	l	long
    // Exception table:
    //   from	to	target	type
    //   6	15	101	java/lang/Exception
    //   19	30	101	java/lang/Exception
    //   90	95	101	java/lang/Exception
    //   30	38	108	java/lang/Exception
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {}
    Object localObject;
    label193:
    do
    {
      do
      {
        ansu localansu;
        do
        {
          do
          {
            return;
            akxe.a("PIC_TAG_PRELOAD", "updateMsg", "uniseq:" + paramMessageForPic.uniseq + ",network:" + paramMessageForPic.preDownNetworkType + "state:" + paramMessageForPic.preDownState);
            paramMessageForPic.serial();
            localObject = paramQQAppInterface.b().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
            if (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
              break label193;
            }
            if (!(localObject instanceof MessageForStructing)) {
              break;
            }
            localObject = (MessageForStructing)localObject;
          } while (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare));
          localansu = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
        } while (localansu == null);
        localansu.j = paramMessageForPic;
        paramQQAppInterface.b().c(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, ((MessageForStructing)localObject).structingMsg.getBytes());
        return;
        paramQQAppInterface.b().c(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
        return;
      } while (!(localObject instanceof MessageForMixedMsg));
      localObject = ((MessageForMixedMsg)localObject).upateMessageForPic(paramMessageForPic);
    } while (localObject == null);
    paramQQAppInterface.b().c(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, (byte[])localObject);
  }
  
  public static String bp(String paramString1, String paramString2)
  {
    return V.getString(paramString1, paramString2);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {}
    while (paramMessageForPic.preDownState != 0) {
      return;
    }
    paramMessageForPic.preDownState = 1;
    paramMessageForPic.preDownNetworkType = Hi();
    akxe.a("PIC_TAG_PRELOAD", "updateDownState4SD", "networkType:" + paramMessageForPic.preDownNetworkType + ",state:" + paramMessageForPic.preDownState + ",uniseq:" + paramMessageForPic.uniseq);
    b(paramQQAppInterface, paramMessageForPic);
  }
  
  public static long i(String paramString, long paramLong)
  {
    return V.getLong(paramString, paramLong);
  }
  
  public static long[] j()
  {
    Object localObject = V.getString("PeakFlowTimePeriod", "");
    if ((localObject == null) || (localObject == ""))
    {
      localObject = new long[0];
      return localObject;
    }
    String[] arrayOfString = ((String)localObject).split(";");
    if (arrayOfString == null) {
      return new long[0];
    }
    long[] arrayOfLong = new long[arrayOfString.length * 2];
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      localObject = arrayOfLong;
      if (i >= k) {
        break;
      }
      localObject = arrayOfString[i].split("-");
      if ((localObject == null) || (localObject.length != 2)) {
        return new long[0];
      }
      arrayOfLong[j] = Long.valueOf(localObject[0]).longValue();
      arrayOfLong[(j + 1)] = Long.valueOf(localObject[1]).longValue();
      j += 2;
      i += 1;
    }
  }
  
  @TargetApi(9)
  public static void m(String paramString, long paramLong, boolean paramBoolean)
  {
    editor.putLong(paramString, paramLong);
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        editor.apply();
      }
    }
    else {
      return;
    }
    editor.commit();
  }
  
  static int o(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 8 + paramInt2 * 2 + paramInt3;
  }
  
  @TargetApi(9)
  public static void o(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    editor.putBoolean(paramString, paramBoolean1);
    if (paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        editor.apply();
      }
    }
    else {
      return;
    }
    editor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxo
 * JD-Core Version:    0.7.0.1
 */