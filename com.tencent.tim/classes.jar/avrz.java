import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import eipc.EIPCClient;

public class avrz
  implements aqxm, aqxt.a
{
  private static avrz jdField_a_of_type_Avrz;
  private String GW = TraeHelper.S(BaseApplicationImpl.getContext());
  public aqxn a;
  private awet jdField_a_of_type_Awet;
  private long azW;
  private String cNi;
  private String cNj;
  private int eyb;
  private long recordTime;
  
  private avrz()
  {
    if (TextUtils.isEmpty(this.GW)) {
      QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
    }
  }
  
  public static avrz a()
  {
    if (jdField_a_of_type_Avrz == null) {}
    try
    {
      if (jdField_a_of_type_Avrz == null) {
        jdField_a_of_type_Avrz = new avrz();
      }
      return jdField_a_of_type_Avrz;
    }
    finally {}
  }
  
  public static void bg(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncSecretShuoshuoMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.syncSecretShuoshuoMsgType", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(String paramString, int paramInt, awet paramawet)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "playMoodVoice voiceID: " + paramInt);
    if (paramInt == 3) {
      this.azW = (((float)this.recordTime / 0.6F));
    }
    for (;;)
    {
      long l = (this.azW + 500L) / 1000L;
      paramawet.bG(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyPlayMoodVoice changeVoiceTime=" + this.azW + ", time = " + l);
      abW(paramInt);
      return;
      if (paramInt == 4) {
        this.azW = (((float)this.recordTime * 0.5833333F));
      } else {
        this.azW = this.recordTime;
      }
    }
  }
  
  public void a(String paramString, awet paramawet)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceRecordTime");
    if (this.jdField_a_of_type_Aqxn == null) {
      return;
    }
    if ((this.eyb == 0) || ((this.eyb != 0) && (this.azW == 0L)))
    {
      l = (this.recordTime + 500L) / 1000L;
      paramawet.bF(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
      return;
    }
    long l = (this.azW + 500L) / 1000L;
    paramawet.bF(paramString, l);
    QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
  }
  
  public void aI(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("data:audio/amr;base64,");
      localStringBuilder.append(rR(paramString));
      QZLog.d("RecordAndChangeVoiceService", 2, "base64=" + localStringBuilder.toString());
      this.jdField_a_of_type_Awet.jy(this.cNj, localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void abW(int paramInt)
  {
    if (TextUtils.isEmpty(this.GW))
    {
      this.GW = TraeHelper.S(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.GW))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131713768), 1);
      }
    }
    while (this.jdField_a_of_type_Aqxn == null) {
      return;
    }
    this.eyb = paramInt;
    this.jdField_a_of_type_Aqxn.changeType = paramInt;
    aqxp.b(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Aqxn, this.GW, this);
  }
  
  public void ad(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b(String paramString, int paramInt, awet paramawet)
  {
    if (TextUtils.isEmpty(this.GW))
    {
      this.GW = TraeHelper.S(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.GW))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131713769), 1);
      }
      return;
    }
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceData callback" + paramString + " voiceID " + paramInt);
    this.cNj = paramString;
    this.jdField_a_of_type_Awet = paramawet;
    aqxp.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Aqxn, this.GW, this);
    aqxp.a(this.cNi, this);
  }
  
  public void buY() {}
  
  public void cOx()
  {
    this.cNi = null;
    this.cNj = null;
    this.jdField_a_of_type_Aqxn = null;
    this.recordTime = -1L;
    this.azW = -1L;
    this.eyb = -1;
    this.jdField_a_of_type_Awet = null;
  }
  
  public void eBK()
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "stopPlayingMoodVoice");
    if (this.jdField_a_of_type_Aqxn != null) {
      aqxp.b(this.jdField_a_of_type_Aqxn);
    }
  }
  
  public void onError() {}
  
  public void onPlayStop() {}
  
  /* Error */
  public String rR(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 239	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: new 242	java/io/FileInputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 245	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: aload 4
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 249	java/io/File:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_1
    //   42: aload 4
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 253	java/io/FileInputStream:read	([B)I
    //   51: pop
    //   52: aload 4
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 256	java/io/FileInputStream:close	()V
    //   63: aload 4
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +105 -> 172
    //   70: aload_1
    //   71: iconst_0
    //   72: invokestatic 262	com/tencent/smtt/utils/Base64:encodeToString	([BI)Ljava/lang/String;
    //   75: areturn
    //   76: astore_1
    //   77: ldc 71
    //   79: iconst_1
    //   80: aload_1
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 266	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   88: aload 4
    //   90: astore_1
    //   91: goto -25 -> 66
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc 71
    //   102: iconst_1
    //   103: aload 4
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 266	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull -49 -> 66
    //   118: aload_3
    //   119: invokevirtual 256	java/io/FileInputStream:close	()V
    //   122: aload_2
    //   123: astore_1
    //   124: goto -58 -> 66
    //   127: astore_1
    //   128: ldc 71
    //   130: iconst_1
    //   131: aload_1
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 266	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   139: aload_2
    //   140: astore_1
    //   141: goto -75 -> 66
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 256	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: ldc 71
    //   160: iconst_1
    //   161: aload_1
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 266	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   169: goto -14 -> 155
    //   172: ldc_w 268
    //   175: areturn
    //   176: astore_2
    //   177: goto -30 -> 147
    //   180: astore 4
    //   182: goto -84 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	avrz
    //   0	185	1	paramString	String
    //   4	136	2	arrayOfByte1	byte[]
    //   144	12	2	localObject1	Object
    //   176	1	2	localObject2	Object
    //   24	95	3	localFileInputStream	java.io.FileInputStream
    //   1	88	4	arrayOfByte2	byte[]
    //   94	10	4	localThrowable1	java.lang.Throwable
    //   180	1	4	localThrowable2	java.lang.Throwable
    //   13	18	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   59	63	76	java/lang/Exception
    //   15	25	94	java/lang/Throwable
    //   118	122	127	java/lang/Exception
    //   15	25	144	finally
    //   151	155	157	java/lang/Exception
    //   30	40	176	finally
    //   45	52	176	finally
    //   100	112	176	finally
    //   30	40	180	java/lang/Throwable
    //   45	52	180	java/lang/Throwable
  }
  
  public void s(Intent paramIntent, int paramInt)
  {
    this.eyb = 0;
    this.azW = 0L;
    this.cNi = paramIntent.getStringExtra("key_record_path");
    this.recordTime = paramIntent.getLongExtra("key_record_time", 0L);
    int i = paramIntent.getIntExtra("key_record_param_sample_rate", 0);
    int j = paramIntent.getIntExtra("key_record_param_bit_rate", 0);
    int k = paramIntent.getIntExtra("key_record_param_audio_type", 0);
    if ((!TextUtils.isEmpty(this.cNi)) && (this.recordTime > 0L))
    {
      this.jdField_a_of_type_Aqxn = new aqxn(this.cNi, i, j, k, 0);
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        bg(BaseApplicationImpl.getContext(), 1);
        return;
      }
      awev.eDp();
      return;
    }
    bg(BaseApplicationImpl.getContext(), 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrz
 * JD-Core Version:    0.7.0.1
 */