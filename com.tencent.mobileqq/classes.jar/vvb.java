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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vvb
  implements amyz, Handler.Callback, xfl
{
  private static final String jdField_a_of_type_JavaLangString = ajjy.a(2131651054);
  private static final String jdField_b_of_type_JavaLangString = ajjy.a(2131651055);
  private amyy jdField_a_of_type_Amyy;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public vvb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
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
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "checkVoiceScanEnable enableTalkBack = " + AppSetting.c);
    }
    return AppSetting.c;
  }
  
  private void d()
  {
    boolean bool = ChirpWrapper.a();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "isSoLoaded " + bool);
    }
    if (!bool)
    {
      if (this.jdField_a_of_type_Amyy == null) {
        this.jdField_a_of_type_Amyy = ((amyy)((amyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(77)).a("qq.android.system.chirp"));
      }
      if (this.jdField_a_of_type_Amyy != null)
      {
        this.jdField_a_of_type_Amyy.a(this);
        this.jdField_a_of_type_Amyy.a(true);
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
            if (!AudioHelper.b(1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VoiceScan", 2, "checkInitVoiceScan, permission is forbidden, " + this.jdField_b_of_type_Boolean);
            }
          } while (this.jdField_b_of_type_Boolean);
          BaseApplicationImpl.sUiHandler.post(new VoiceScan.1(this));
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceScan", 2, "isVedioChatting");
        return;
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qrcode", 0);
        bool = localSharedPreferences.getBoolean("key_first_enter_voice_qrcode" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceScan", 2, "checkInitVoiceScan, isFirst = " + bool);
        }
        if (bool)
        {
          localSharedPreferences.edit().putBoolean("key_first_enter_voice_qrcode" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
          if (this.jdField_b_of_type_AndroidOsHandler != null) {
            this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(295, 2000L);
          }
        }
      } while (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null);
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = new ChirpWrapper();
      i = this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      if (i == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceScan", 2, "decode chirp init failed = " + i);
    return;
    this.jdField_a_of_type_ComTencentChirpPCMRecorder = new PCMRecorder(this.jdField_a_of_type_AndroidContentContext, 44100, this);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentChirpPCMRecorder != null)
    {
      this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = null;
    }
    if (this.jdField_a_of_type_ComTencentChirpChirpWrapper != null)
    {
      this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerResume");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.c)
    {
      Process.setThreadPriority(-19);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    }
    while (this.d) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(292);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "record error = " + paramInt);
    }
    e();
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 205	vvb:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
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
    //   19: invokestatic 252	vvb:a	([B[S)V
    //   22: aload_0
    //   23: getfield 205	vvb:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   26: aload_3
    //   27: bipush 15
    //   29: invokevirtual 255	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 261	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne -28 -> 9
    //   40: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 83
    //   48: iconst_2
    //   49: new 85	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 263
    //   59: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_1
    //   73: ldc_w 265
    //   76: invokevirtual 271	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +269 -> 348
    //   82: iload_2
    //   83: aload_1
    //   84: invokevirtual 274	java/lang/String:length	()I
    //   87: if_icmpge +20 -> 107
    //   90: aload_1
    //   91: iload_2
    //   92: invokevirtual 278	java/lang/String:charAt	(I)C
    //   95: bipush 48
    //   97: if_icmpne +10 -> 107
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -22 -> 82
    //   107: aload_1
    //   108: iload_2
    //   109: invokevirtual 281	java/lang/String:substring	(I)Ljava/lang/String;
    //   112: astore_1
    //   113: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +29 -> 145
    //   119: ldc 83
    //   121: iconst_2
    //   122: new 85	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 283
    //   132: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_1
    //   146: invokestatic 289	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   149: pop2
    //   150: ldc_w 290
    //   153: invokestatic 31	ajjy:a	(I)Ljava/lang/String;
    //   156: invokestatic 294	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   159: ldc2_w 295
    //   162: invokestatic 302	java/lang/Thread:sleep	(J)V
    //   165: aload_1
    //   166: ifnull +27 -> 193
    //   169: ldc_w 304
    //   172: aload_1
    //   173: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +17 -> 193
    //   179: aload_0
    //   180: getfield 45	vvb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   186: aload_1
    //   187: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +82 -> 272
    //   193: new 310	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   196: dup
    //   197: aload_0
    //   198: getfield 45	vvb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   204: iconst_0
    //   205: invokespecial 313	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 43	vvb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   213: aload_1
    //   214: invokestatic 318	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   217: aload_0
    //   218: getfield 45	vvb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   221: ldc_w 320
    //   224: ldc_w 304
    //   227: ldc_w 304
    //   230: ldc_w 322
    //   233: ldc_w 322
    //   236: iconst_0
    //   237: iconst_0
    //   238: ldc_w 304
    //   241: ldc_w 304
    //   244: ldc_w 304
    //   247: ldc_w 304
    //   250: invokestatic 327	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   253: return
    //   254: astore_1
    //   255: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -249 -> 9
    //   261: ldc 83
    //   263: iconst_2
    //   264: ldc_w 304
    //   267: aload_1
    //   268: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: return
    //   272: aload_0
    //   273: getfield 45	vvb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: bipush 51
    //   278: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   281: checkcast 332	ajjj
    //   284: aload_1
    //   285: invokevirtual 335	ajjj:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   288: astore_3
    //   289: aload_3
    //   290: ifnull +39 -> 329
    //   293: aload_3
    //   294: invokevirtual 340	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   297: ifeq +32 -> 329
    //   300: new 310	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   303: dup
    //   304: aload_1
    //   305: iconst_1
    //   306: invokespecial 313	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   309: astore_1
    //   310: aload_1
    //   311: aload_3
    //   312: getfield 343	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   315: putfield 346	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:h	Ljava/lang/String;
    //   318: aload_1
    //   319: aload_3
    //   320: getfield 349	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   323: putfield 352	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:i	Ljava/lang/String;
    //   326: goto -117 -> 209
    //   329: new 310	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   332: dup
    //   333: aload_1
    //   334: iconst_3
    //   335: invokespecial 313	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   338: astore_1
    //   339: aload_1
    //   340: bipush 12
    //   342: putfield 356	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	I
    //   345: goto -136 -> 209
    //   348: getstatic 36	vvb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   351: invokestatic 294	com/tencent/mobileqq/app/QQAppInterface:f	(Ljava/lang/String;)V
    //   354: return
    //   355: astore_3
    //   356: goto -191 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	vvb
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onScannerPause");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(291));
    if (this.c)
    {
      Process.setThreadPriority(0);
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceScan", 2, "onDestroy");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Amyy != null)
    {
      this.jdField_a_of_type_Amyy.b(this);
      this.jdField_a_of_type_Amyy = null;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label109:
      e();
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      break label109;
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
        this.c = a();
        this.d = true;
      } while (!this.c);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(291);
      return true;
      d();
      return true;
      QQAppInterface.f(jdField_a_of_type_JavaLangString);
      return true;
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    Process.setThreadPriority(-19);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    return true;
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vvb
 * JD-Core Version:    0.7.0.1
 */