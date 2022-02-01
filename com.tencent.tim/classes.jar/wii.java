import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.MobileQQ;

public class wii
{
  private static final String TAG = wii.class.getSimpleName();
  private static final byte[] cl = new byte[0];
  private wif a;
  private AppInterface mApp;
  private SharedPreferences pref;
  
  public wii(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    if (this.mApp != null) {
      this.a = ((wif)this.mApp.getManager(321));
    }
    this.pref = paramAppInterface.getApp().getSharedPreferences("pref_act_frd" + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  private long b(File paramFile)
  {
    long l = 0L;
    if (paramFile.getName().contains("_")) {}
    try
    {
      l = Long.parseLong(paramFile.getName().split("_")[1]);
      return l;
    }
    catch (Exception paramFile) {}
    return 0L;
  }
  
  private File[] b(File paramFile)
  {
    paramFile = c(paramFile);
    Arrays.sort(paramFile, new wij(this));
    return paramFile;
  }
  
  private String bW()
  {
    return MD5.toMD5("qqnotify_same_day_subscribe" + this.mApp.getCurrentAccountUin());
  }
  
  private File[] c(File paramFile)
  {
    paramFile = paramFile.listFiles(new wik(this));
    if ((QLog.isColorLevel()) && (paramFile.length > 0))
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        QLog.i(TAG, 2, "getReminderFiles file name: " + localObject.getName());
        i += 1;
      }
    }
    return paramFile;
  }
  
  private void f(AcsMsg paramAcsMsg)
  {
    if ((this.mApp != null) && (paramAcsMsg != null))
    {
      if (this.a == null) {
        this.a = ((wif)this.mApp.getManager(321));
      }
      if (this.a == null) {
        break label143;
      }
      this.pref.edit().remove(paramAcsMsg.msg_id + this.mApp.getCurrentAccountUin()).apply();
      this.a.Cb(paramAcsMsg.hashCode());
    }
    while ((this.mApp instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
      localQQAppInterface.b().t(acbn.bla, 9002, paramAcsMsg.msg_id.hashCode());
      localQQAppInterface.cLO();
      return;
      label143:
      aafv.h(paramAcsMsg);
    }
    aafv.i(paramAcsMsg);
  }
  
  private File g()
  {
    return this.mApp.getApplication().getFilesDir();
  }
  
  private void m(File paramFile)
  {
    paramFile = b(paramFile);
    if (paramFile.length > 0)
    {
      Object localObject = paramFile[0];
      if ((localObject != null) && (((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = a((File)localObject);
        if (aqhq.deleteFile(paramFile[0].getAbsolutePath())) {
          f((AcsMsg)localObject);
        }
      }
    }
  }
  
  /* Error */
  private byte[] readFileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 257	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: new 261	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 262	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: astore 5
    //   23: aload_3
    //   24: astore 4
    //   26: sipush 4096
    //   29: newarray byte
    //   31: astore 6
    //   33: aload_1
    //   34: astore 5
    //   36: aload_3
    //   37: astore 4
    //   39: aload_3
    //   40: aload 6
    //   42: iconst_0
    //   43: sipush 4096
    //   46: invokevirtual 266	java/io/FileInputStream:read	([BII)I
    //   49: istore_2
    //   50: iload_2
    //   51: iconst_m1
    //   52: if_icmpeq +57 -> 109
    //   55: aload_1
    //   56: astore 5
    //   58: aload_3
    //   59: astore 4
    //   61: aload_1
    //   62: aload 6
    //   64: iconst_0
    //   65: iload_2
    //   66: invokevirtual 270	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -36 -> 33
    //   72: astore 6
    //   74: aload_1
    //   75: astore 5
    //   77: aload_3
    //   78: astore 4
    //   80: aload 6
    //   82: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 276	java/io/FileInputStream:close	()V
    //   93: aload 7
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +10 -> 107
    //   100: aload_1
    //   101: invokevirtual 277	java/io/ByteArrayOutputStream:close	()V
    //   104: aload 7
    //   106: astore_3
    //   107: aload_3
    //   108: areturn
    //   109: aload_1
    //   110: astore 5
    //   112: aload_3
    //   113: astore 4
    //   115: aload_1
    //   116: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: astore 6
    //   121: aload 6
    //   123: astore 4
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 276	java/io/FileInputStream:close	()V
    //   133: aload 4
    //   135: astore_3
    //   136: aload_1
    //   137: ifnull -30 -> 107
    //   140: aload_1
    //   141: invokevirtual 277	java/io/ByteArrayOutputStream:close	()V
    //   144: aload 4
    //   146: areturn
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore 5
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 276	java/io/FileInputStream:close	()V
    //   176: aload 5
    //   178: ifnull +8 -> 186
    //   181: aload 5
    //   183: invokevirtual 277	java/io/ByteArrayOutputStream:close	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_3
    //   189: aload_3
    //   190: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   193: goto -7 -> 186
    //   196: astore_1
    //   197: aconst_null
    //   198: astore 5
    //   200: goto -32 -> 168
    //   203: astore_1
    //   204: aload 4
    //   206: astore_3
    //   207: goto -39 -> 168
    //   210: astore 6
    //   212: aconst_null
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_3
    //   216: goto -142 -> 74
    //   219: astore 6
    //   221: aconst_null
    //   222: astore_1
    //   223: goto -149 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	wii
    //   0	226	1	paramFile	File
    //   49	17	2	i	int
    //   11	162	3	localObject1	Object
    //   188	2	3	localException1	Exception
    //   206	10	3	localObject2	Object
    //   24	181	4	localObject3	Object
    //   21	178	5	localFile	File
    //   31	32	6	arrayOfByte1	byte[]
    //   72	9	6	localException2	Exception
    //   119	3	6	arrayOfByte2	byte[]
    //   210	1	6	localException3	Exception
    //   219	1	6	localException4	Exception
    //   1	104	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	33	72	java/lang/Exception
    //   39	50	72	java/lang/Exception
    //   61	69	72	java/lang/Exception
    //   115	121	72	java/lang/Exception
    //   129	133	147	java/lang/Exception
    //   140	144	147	java/lang/Exception
    //   89	93	155	java/lang/Exception
    //   100	104	155	java/lang/Exception
    //   3	12	162	finally
    //   172	176	188	java/lang/Exception
    //   181	186	188	java/lang/Exception
    //   12	20	196	finally
    //   26	33	203	finally
    //   39	50	203	finally
    //   61	69	203	finally
    //   80	85	203	finally
    //   115	121	203	finally
    //   3	12	210	java/lang/Exception
    //   12	20	219	java/lang/Exception
  }
  
  public AcsMsg a(File paramFile)
  {
    try
    {
      paramFile = readFileToBytes(paramFile);
      if ((paramFile != null) && (paramFile.length > 0))
      {
        paramFile = new JceInputStream(paramFile);
        paramFile.setServerEncoding("utf-8");
        JceStruct localJceStruct = (JceStruct)AcsMsg.class.newInstance();
        localJceStruct.readFrom(paramFile);
        paramFile = (AcsMsg)localJceStruct;
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  public void a(String paramString, wii.a parama)
  {
    try
    {
      ThreadManagerV2.excute(new ReminderDataManager.5(this, paramString, parama), 64, null, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, wii.b paramb)
  {
    try
    {
      wih.b(paramString, new wil(this, paramb));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public List<AcsMsg> cK()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = c(g());
    if (arrayOfFile.length > 0)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfFile[i];
        if ((localObject != null) && (((File)localObject).isFile()) && (((File)localObject).exists()) && (whn.isToday(b((File)localObject))))
        {
          localObject = a((File)localObject);
          if ((localObject != null) && (!localArrayList.contains(localObject))) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public void e(AcsMsg paramAcsMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 48	wii:a	Lwif;
    //   13: ifnonnull +20 -> 33
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 38	wii:mApp	Lcom/tencent/common/app/AppInterface;
    //   21: sipush 321
    //   24: invokevirtual 44	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   27: checkcast 46	wif
    //   30: putfield 48	wii:a	Lwif;
    //   33: aload_0
    //   34: getfield 48	wii:a	Lwif;
    //   37: ifnull +35 -> 72
    //   40: aload_0
    //   41: getfield 48	wii:a	Lwif;
    //   44: aload_1
    //   45: invokevirtual 353	wif:d	(LWallet/AcsMsg;)V
    //   48: new 355	com/tencent/mobileqq/activity/activateFriend/biz/ReminderDataManager$1
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial 357	com/tencent/mobileqq/activity/activateFriend/biz/ReminderDataManager$1:<init>	(Lwii;LWallet/AcsMsg;)V
    //   57: bipush 64
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokestatic 315	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   64: goto -58 -> 6
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: aload_1
    //   73: invokestatic 359	aafv:g	(LWallet/AcsMsg;)V
    //   76: goto -28 -> 48
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   84: goto -36 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	wii
    //   0	87	1	paramAcsMsg	AcsMsg
    //   79	2	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	33	67	finally
    //   33	48	67	finally
    //   48	64	67	finally
    //   72	76	67	finally
    //   80	84	67	finally
    //   9	33	79	java/lang/Exception
    //   33	48	79	java/lang/Exception
    //   72	76	79	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void bYk();
  }
  
  public static abstract interface b
  {
    public abstract void z(boolean paramBoolean, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wii
 * JD-Core Version:    0.7.0.1
 */