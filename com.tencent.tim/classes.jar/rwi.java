import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.biz.qrcode.ipc.VoiceScan.1;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.chirp.PCMRecorder.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class rwi
  implements afet.a, Handler.Callback, PCMRecorder.a
{
  private static final String aCO = acfp.m(2131716866);
  private static final String aCP = acfp.m(2131716867);
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private boolean aKn;
  private boolean aKo;
  private boolean aKp;
  private QQAppInterface app;
  private afet b;
  private Handler bw;
  private Context mContext;
  private boolean mIsResume;
  private Handler mUiHandler;
  private Dialog w;
  
  public rwi(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.bw = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mUiHandler = new Handler(this);
  }
  
  private boolean Mb()
  {
    if (this.app == null) {
      return false;
    }
    this.app.cKW();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "checkVoiceScanEnable enableTalkBack = " + AppSetting.enableTalkBack);
    }
    return AppSetting.enableTalkBack;
  }
  
  private static void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8 & 0xFF00));
      i += 1;
    }
  }
  
  private void bxg()
  {
    boolean bool = ChirpWrapper.loadLibrary();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "isSoLoaded " + bool);
    }
    if (!bool)
    {
      if (this.b == null) {
        this.b = ((afet)((afem)this.app.getManager(77)).a("qq.android.system.chirp"));
      }
      if (this.b != null)
      {
        this.b.a(this);
        this.b.HL(true);
      }
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AudioHelper.isForbidByRubbishMeizu(1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VoiceScan", 2, "checkInitVoiceScan, permission is forbidden, " + this.aKn);
            }
          } while (this.aKn);
          BaseApplicationImpl.sUiHandler.post(new VoiceScan.1(this));
          return;
          if (!this.app.bF()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceScan", 2, "isVedioChatting");
        return;
        SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("qrcode", 0);
        bool = localSharedPreferences.getBoolean("key_first_enter_voice_qrcode" + this.app.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceScan", 2, "checkInitVoiceScan, isFirst = " + bool);
        }
        if (bool)
        {
          localSharedPreferences.edit().putBoolean("key_first_enter_voice_qrcode" + this.app.getCurrentAccountUin(), false).commit();
          if (this.bw != null) {
            this.bw.sendEmptyMessageDelayed(295, 2000L);
          }
        }
      } while (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null);
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = new ChirpWrapper();
      i = this.jdField_a_of_type_ComTencentChirpChirpWrapper.init();
      if (i == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceScan", 2, "decode chirp init failed = " + i);
    return;
    this.jdField_a_of_type_ComTencentChirpPCMRecorder = new PCMRecorder(this.mContext, 44100, this);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder.start();
  }
  
  private void bxh()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder != null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder.stop();
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = null;
    }
    if (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null)
    {
      this.jdField_a_of_type_ComTencentChirpChirpWrapper.release();
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = null;
    }
  }
  
  /* Error */
  public void U(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 223	rwi:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: arraylength
    //   12: iconst_2
    //   13: idiv
    //   14: newarray short
    //   16: astore_3
    //   17: aload_1
    //   18: aload_3
    //   19: invokestatic 257	rwi:a	([B[S)V
    //   22: aload_0
    //   23: getfield 223	rwi:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   26: aload_3
    //   27: bipush 15
    //   29: invokevirtual 260	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne -28 -> 9
    //   40: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 87
    //   48: iconst_2
    //   49: new 89	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 268
    //   59: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_1
    //   73: ldc_w 270
    //   76: invokevirtual 276	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +269 -> 348
    //   82: iload_2
    //   83: aload_1
    //   84: invokevirtual 279	java/lang/String:length	()I
    //   87: if_icmpge +20 -> 107
    //   90: aload_1
    //   91: iload_2
    //   92: invokevirtual 283	java/lang/String:charAt	(I)C
    //   95: bipush 48
    //   97: if_icmpne +10 -> 107
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -22 -> 82
    //   107: aload_1
    //   108: iload_2
    //   109: invokevirtual 286	java/lang/String:substring	(I)Ljava/lang/String;
    //   112: astore_1
    //   113: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +29 -> 145
    //   119: ldc 87
    //   121: iconst_2
    //   122: new 89	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 288
    //   132: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_1
    //   146: invokestatic 294	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   149: pop2
    //   150: ldc_w 295
    //   153: invokestatic 41	acfp:m	(I)Ljava/lang/String;
    //   156: invokestatic 299	com/tencent/mobileqq/app/QQAppInterface:EI	(Ljava/lang/String;)V
    //   159: ldc2_w 300
    //   162: invokestatic 307	java/lang/Thread:sleep	(J)V
    //   165: aload_1
    //   166: ifnull +27 -> 193
    //   169: ldc_w 309
    //   172: aload_1
    //   173: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +17 -> 193
    //   179: aload_0
    //   180: getfield 55	rwi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 194	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   186: aload_1
    //   187: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +82 -> 272
    //   193: new 315	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   196: dup
    //   197: aload_0
    //   198: getfield 55	rwi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 194	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   204: iconst_0
    //   205: invokespecial 318	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 53	rwi:mContext	Landroid/content/Context;
    //   213: aload_1
    //   214: invokestatic 323	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   217: aload_0
    //   218: getfield 55	rwi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   221: ldc_w 325
    //   224: ldc_w 309
    //   227: ldc_w 309
    //   230: ldc_w 327
    //   233: ldc_w 327
    //   236: iconst_0
    //   237: iconst_0
    //   238: ldc_w 309
    //   241: ldc_w 309
    //   244: ldc_w 309
    //   247: ldc_w 309
    //   250: invokestatic 332	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   253: return
    //   254: astore_1
    //   255: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -249 -> 9
    //   261: ldc 87
    //   263: iconst_2
    //   264: ldc_w 309
    //   267: aload_1
    //   268: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: return
    //   272: aload_0
    //   273: getfield 55	rwi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: bipush 51
    //   278: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   281: checkcast 337	acff
    //   284: aload_1
    //   285: invokevirtual 341	acff:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   288: astore_3
    //   289: aload_3
    //   290: ifnull +39 -> 329
    //   293: aload_3
    //   294: invokevirtual 346	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   297: ifeq +32 -> 329
    //   300: new 315	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   303: dup
    //   304: aload_1
    //   305: iconst_1
    //   306: invokespecial 318	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   309: astore_1
    //   310: aload_1
    //   311: aload_3
    //   312: getfield 349	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   315: putfield 352	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:nickname	Ljava/lang/String;
    //   318: aload_1
    //   319: aload_3
    //   320: getfield 355	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   323: putfield 356	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:remark	Ljava/lang/String;
    //   326: goto -117 -> 209
    //   329: new 315	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   332: dup
    //   333: aload_1
    //   334: iconst_3
    //   335: invokespecial 318	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   338: astore_1
    //   339: aload_1
    //   340: bipush 12
    //   342: putfield 360	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:subSourceId	I
    //   345: goto -136 -> 209
    //   348: getstatic 46	rwi:aCP	Ljava/lang/String;
    //   351: invokestatic 299	com/tencent/mobileqq/app/QQAppInterface:EI	(Ljava/lang/String;)V
    //   354: return
    //   355: astore_3
    //   356: goto -191 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	rwi
    //   0	359	1	paramArrayOfByte	byte[]
    //   1	108	2	i	int
    //   16	304	3	localObject	Object
    //   355	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   145	159	254	java/lang/Exception
    //   169	193	254	java/lang/Exception
    //   193	209	254	java/lang/Exception
    //   209	253	254	java/lang/Exception
    //   272	289	254	java/lang/Exception
    //   293	326	254	java/lang/Exception
    //   329	345	254	java/lang/Exception
    //   159	165	355	java/lang/Exception
  }
  
  public void bwK()
  {
    if ((this.mIsResume) && (this.bw != null)) {
      this.bw.sendEmptyMessage(293);
    }
  }
  
  public void bxd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerResume");
    }
    this.mIsResume = true;
    if (this.aKo)
    {
      Process.setThreadPriority(-19);
      this.bw.sendEmptyMessage(293);
    }
    while (this.aKp) {
      return;
    }
    this.bw.sendEmptyMessage(292);
  }
  
  public void bxe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerPause");
    }
    this.mIsResume = false;
    this.bw.removeCallbacksAndMessages(null);
    this.mUiHandler.removeCallbacksAndMessages(Integer.valueOf(291));
    if (this.aKo)
    {
      Process.setThreadPriority(0);
      bxh();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        this.aKo = Mb();
        this.aKp = true;
      } while (!this.aKo);
      this.mUiHandler.sendEmptyMessage(291);
      return true;
      bxg();
      return true;
      QQAppInterface.EI(aCO);
      return true;
    } while (this.bw == null);
    Process.setThreadPriority(-19);
    this.bw.removeCallbacksAndMessages(null);
    this.bw.sendEmptyMessage(293);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onDestroy");
    }
    this.mIsResume = false;
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    if (this.bw != null)
    {
      this.bw.removeCallbacksAndMessages(null);
      this.bw = null;
    }
    if (this.b != null)
    {
      this.b.b(this);
      this.b = null;
    }
    if ((this.w != null) && (this.w.isShowing())) {}
    try
    {
      this.w.dismiss();
      this.w = null;
      label109:
      bxh();
      this.mContext = null;
      this.app = null;
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public void ye(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "record error = " + paramInt);
    }
    bxh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwi
 * JD-Core Version:    0.7.0.1
 */