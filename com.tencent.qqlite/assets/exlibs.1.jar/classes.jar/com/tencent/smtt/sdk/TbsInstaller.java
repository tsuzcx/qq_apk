package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TbsInstaller
{
  private static final String APK_FOLDER = "tbs_apk";
  static final String APP_DEMO = "com.tencent.x5sdk.demo";
  static final String APP_DEMO_TEST = "com.tencent.mtt.sdk.test";
  static final String APP_QB = "com.tencent.mtt";
  static final String APP_QQ = "com.tencent.mobileqq";
  static final String APP_QZONE = "com.qzone";
  static final String APP_WX = "com.tencent.mm";
  static final int COPY_STATUS_FAIL = 2;
  static final int COPY_STATUS_START = 0;
  static final int COPY_STATUS_SUCCESS = 1;
  static final int COPY_STATUS_UNKNOWN = -1;
  static final int COPY_STATUS_WILLUSE = 3;
  private static final String DEMO_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  static final int INCRUPDATE_STATUS_PATCH_SUCCESS = 1;
  static final int INCRUPDATE_STATUS_UNKNOW = -1;
  static final int INSTALL_STATUS_CANNOTUSE = 5;
  static final int INSTALL_STATUS_DEXOPT = 1;
  static final int INSTALL_STATUS_RENAME = 2;
  static final int INSTALL_STATUS_UNKNOWN = -1;
  static final int INSTALL_STATUS_UNZIP = 0;
  static final int INSTALL_STATUS_USING = 4;
  static final int INSTALL_STATUS_WILLUSE = 3;
  static final String KEY_DIFF_FILE_LOCATION = "diff_file_location";
  static final String KEY_NEW_APK_LOCATION = "new_apk_location";
  static final String KEY_NEW_CORE_VERSION = "new_core_ver";
  static final String KEY_OLD_APK_LOCATION = "old_apk_location";
  static final String KEY_OLD_CORE_VERSION = "old_core_ver";
  static final String KEY_OPERATION = "operation";
  private static final String KEY_PATCH_APK_PATH = "apk_path";
  private static final String KEY_PATCH_RESULT = "patch_result";
  private static final String KEY_PATCH_TBSCORE_VER = "tbs_core_ver";
  private static final String MD5_FILE = "1";
  private static final String MM_SIG = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
  private static final String MOBILEQQ_SIG = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
  private static final int MSG_COPY_TBS_CORE = 2;
  private static final int MSG_INSTALL_TBS_CORE = 1;
  private static final int MSG_INSTALL_TBS_CORE_EX = 3;
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final int OP_CONTINUE_PATCH = 10001;
  private static final int PATCH_FAIL = 1;
  private static final int PATCH_NONEEDPATCH = 2;
  private static final int PATCH_SUCCESS = 0;
  private static final String QZONE_SIG = "308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677";
  private static final int RETRY_NUM_COPY = 10;
  private static final int RETRY_NUM_DEXOPT = 10;
  private static final int RETRY_NUM_UNZIP = 10;
  private static final String TAG = "TbsInstaller";
  private static final String TBS_CONF = "tbs.conf";
  private static final String TBS_CONF_TIMESTAMP = "tbs_core_build_number";
  private static final String TBS_CORE_LOCK_FILE = "tbslock.txt";
  private static final String TBS_CORE_VER = "tbs_core_version";
  static final String TBS_EXTENSION_CFG_FILE = "tbs_extension.conf";
  private static final String TBS_FILE_APK = "tbs.apk";
  private static final String TBS_FILE_CONF = "tbs.conf";
  static final String TBS_FOLDER_NAME = "tbs";
  private static final String TBS_LOCAL_INSTALLATION = "tbs_local_installation";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  static final String TBS_SHARE_FOLDER_NAME = "core_share";
  static final String TBS_SHARE_NAME = "share";
  static final String TMP_TBS_COPY_FOLDER_NAME = "core_copy_tmp";
  static final String TMP_TBS_UNZIP_FOLDER_NAME = "core_unzip_tmp";
  private static final String WEBCORE_LIB_FILENAME = "libmttwebcore.so";
  private static final Long[][] WEBCORE_LIB_LENGTH_MAP = { { Long.valueOf(25413L), Long.valueOf(11460320L) }, { Long.valueOf(25436L), Long.valueOf(12009376L) }, { Long.valueOf(25437L), Long.valueOf(11489180L) }, { Long.valueOf(25438L), Long.valueOf(11489180L) }, { Long.valueOf(25439L), Long.valueOf(12013472L) }, { Long.valueOf(25440L), Long.valueOf(11489180L) }, { Long.valueOf(25442L), Long.valueOf(11489180L) } };
  private static boolean isQuickDexOptForThirdPartyAppCalled = false;
  private static TbsInstaller mInstance = null;
  private static final Lock mTbsInstallLock;
  private static Handler mTbsInstallerHandler;
  private static final Lock mTbsRenameLock = new ReentrantLock();
  int mTbsCoreInstalledVer = 0;
  
  static
  {
    mTbsInstallLock = new ReentrantLock();
    mTbsInstallerHandler = null;
  }
  
  private TbsInstaller()
  {
    if (mTbsInstallerHandler == null) {
      mTbsInstallerHandler = new Handler(TbsHandlerThread.getInstance().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            super.handleMessage(paramAnonymousMessage);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installTbsCoreInThread((Context)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.copyTbsCoreInThread((Context)arrayOfObject[0], (Context)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installLocalTbsCoreExInThread((Context)arrayOfObject[0], (Bundle)arrayOfObject[1]);
          }
        }
      };
    }
  }
  
  private void cleanStatusAndTmpDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
    TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, -1);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
    FileUtil.delete(getTmpTbsCoreUnzipDir(paramContext), true);
    FileUtil.delete(getTmpTbsCoreCopyDir(paramContext), true);
  }
  
  private void clearNewTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = getTmpTbsCoreUnzipDir(paramContext);
    if (localFile != null) {
      FileUtil.delete(localFile, false);
    }
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 5);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
    TbsLog.e("TbsInstaller", "clearNewTbsCore forceSysWebViewInner!");
    QbSdk.forceSysWebViewInner();
  }
  
  private void copyApkFromAssets(Context paramContext, String paramString, File paramFile)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssets");
    copyAssetsFileTo(paramContext, paramString, paramFile);
  }
  
  private void copyApkFromAssetsIfNeeded(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssetsIfNeeded");
    File localFile = new File(paramContext.getDir("tbs_apk", 0), "tbs.apk");
    if (localFile.exists()) {
      return;
    }
    copyApkFromAssets(paramContext, "tbs.apk", localFile);
  }
  
  /* Error */
  private void copyAssetsFileTo(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: ldc 116
    //   2: new 347	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 350
    //   12: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 8
    //   37: aload 9
    //   39: astore 6
    //   41: aload_1
    //   42: invokevirtual 362	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   45: aload_2
    //   46: invokevirtual 368	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_1
    //   50: aload 9
    //   52: astore 6
    //   54: aload_1
    //   55: astore 5
    //   57: aload_1
    //   58: astore 7
    //   60: new 370	java/io/FileOutputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 373	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: astore_2
    //   69: ldc_w 374
    //   72: newarray byte
    //   74: astore_3
    //   75: aload_1
    //   76: aload_3
    //   77: invokevirtual 380	java/io/InputStream:read	([B)I
    //   80: istore 4
    //   82: iload 4
    //   84: iconst_m1
    //   85: if_icmpeq +42 -> 127
    //   88: aload_2
    //   89: aload_3
    //   90: iconst_0
    //   91: iload 4
    //   93: invokevirtual 384	java/io/FileOutputStream:write	([BII)V
    //   96: goto -21 -> 75
    //   99: astore_3
    //   100: aload_2
    //   101: astore 6
    //   103: aload_1
    //   104: astore 5
    //   106: aload_3
    //   107: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 391	java/io/InputStream:close	()V
    //   126: return
    //   127: aload_2
    //   128: invokevirtual 394	java/io/FileOutputStream:flush	()V
    //   131: aload_2
    //   132: ifnull +111 -> 243
    //   135: aload_2
    //   136: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   139: aload_1
    //   140: ifnull -14 -> 126
    //   143: aload_1
    //   144: invokevirtual 391	java/io/InputStream:close	()V
    //   147: goto -21 -> 126
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   155: goto -29 -> 126
    //   158: astore_1
    //   159: aload 6
    //   161: ifnull +8 -> 169
    //   164: aload 6
    //   166: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   169: aload 5
    //   171: ifnull +8 -> 179
    //   174: aload 5
    //   176: invokevirtual 391	java/io/InputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore_2
    //   182: aload_2
    //   183: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   186: goto -17 -> 169
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   194: goto -15 -> 179
    //   197: astore_2
    //   198: aload_2
    //   199: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   202: goto -84 -> 118
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   210: goto -84 -> 126
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   218: goto -79 -> 139
    //   221: astore_3
    //   222: aload_2
    //   223: astore 6
    //   225: aload_1
    //   226: astore 5
    //   228: aload_3
    //   229: astore_1
    //   230: goto -71 -> 159
    //   233: astore_3
    //   234: aload 8
    //   236: astore_2
    //   237: aload 7
    //   239: astore_1
    //   240: goto -140 -> 100
    //   243: goto -104 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	TbsInstaller
    //   0	246	1	paramContext	Context
    //   0	246	2	paramString	String
    //   0	246	3	paramFile	File
    //   80	12	4	i	int
    //   29	198	5	localContext1	Context
    //   39	185	6	localObject1	Object
    //   26	212	7	localContext2	Context
    //   35	200	8	localObject2	Object
    //   32	19	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	75	99	java/io/IOException
    //   75	82	99	java/io/IOException
    //   88	96	99	java/io/IOException
    //   127	131	99	java/io/IOException
    //   143	147	150	java/io/IOException
    //   41	50	158	finally
    //   60	69	158	finally
    //   106	110	158	finally
    //   164	169	181	java/io/IOException
    //   174	179	189	java/io/IOException
    //   114	118	197	java/io/IOException
    //   122	126	205	java/io/IOException
    //   135	139	213	java/io/IOException
    //   69	75	221	finally
    //   75	82	221	finally
    //   88	96	221	finally
    //   127	131	221	finally
    //   41	50	233	java/io/IOException
    //   60	69	233	java/io/IOException
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void copyTbsCoreInThread(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 405	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   5: ifeq +4 -> 9
    //   8: return
    //   9: ldc 116
    //   11: ldc_w 407
    //   14: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 412	android/os/Build$VERSION:SDK_INT	I
    //   20: bipush 11
    //   22: if_icmplt +60 -> 82
    //   25: aload_2
    //   26: ldc_w 414
    //   29: iconst_4
    //   30: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: astore 14
    //   35: aload 14
    //   37: ldc_w 420
    //   40: iconst_m1
    //   41: invokeinterface 426 3 0
    //   46: iload_3
    //   47: if_icmpne +48 -> 95
    //   50: ldc 116
    //   52: new 347	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 428
    //   62: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc_w 433
    //   72: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: return
    //   82: aload_2
    //   83: ldc_w 414
    //   86: iconst_0
    //   87: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   90: astore 14
    //   92: goto -57 -> 35
    //   95: aload_2
    //   96: invokestatic 437	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   99: astore 20
    //   101: aload 20
    //   103: ifnull -95 -> 8
    //   106: aload_2
    //   107: aload 20
    //   109: invokestatic 441	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   112: astore 21
    //   114: aload 21
    //   116: ifnull -108 -> 8
    //   119: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   122: invokeinterface 446 1 0
    //   127: ifeq +1370 -> 1497
    //   130: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 449 1 0
    //   138: aload_2
    //   139: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   142: invokevirtual 453	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyVer	()I
    //   145: istore 5
    //   147: aload_2
    //   148: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   151: invokevirtual 456	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyStatus	()I
    //   154: istore 4
    //   156: iload 5
    //   158: iload_3
    //   159: if_icmpne +27 -> 186
    //   162: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 459 1 0
    //   170: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   173: invokeinterface 459 1 0
    //   178: aload 21
    //   180: aload 20
    //   182: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   185: return
    //   186: aload_0
    //   187: aload_2
    //   188: invokevirtual 467	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   191: istore 6
    //   193: ldc 116
    //   195: new 347	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 469
    //   205: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload 6
    //   210: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: iload 6
    //   221: iload_3
    //   222: if_icmpne +22 -> 244
    //   225: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   228: invokeinterface 459 1 0
    //   233: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   236: invokeinterface 459 1 0
    //   241: goto -63 -> 178
    //   244: aload_2
    //   245: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   248: invokevirtual 472	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   251: istore 7
    //   253: iload 7
    //   255: ifle +1296 -> 1551
    //   258: iload_3
    //   259: iload 7
    //   261: if_icmpgt +6 -> 267
    //   264: goto +1287 -> 1551
    //   267: aload_0
    //   268: aload_2
    //   269: invokespecial 474	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   272: goto +1293 -> 1565
    //   275: iconst_m1
    //   276: istore 5
    //   278: aload_0
    //   279: aload_2
    //   280: invokespecial 474	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   283: ldc 116
    //   285: ldc_w 476
    //   288: iconst_1
    //   289: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   292: invokestatic 485	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   295: ldc2_w 486
    //   298: aload_0
    //   299: aload_1
    //   300: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   303: invokestatic 494	com/tencent/smtt/utils/TbsUtils:getDirSize	(Ljava/io/File;)J
    //   306: lmul
    //   307: lcmp
    //   308: ifge +83 -> 391
    //   311: invokestatic 485	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   314: lstore 8
    //   316: aload_0
    //   317: aload_1
    //   318: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   321: invokestatic 494	com/tencent/smtt/utils/TbsUtils:getDirSize	(Ljava/io/File;)J
    //   324: lstore 10
    //   326: aload_2
    //   327: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   330: sipush 210
    //   333: new 347	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 501
    //   343: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: lload 8
    //   348: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   351: ldc_w 506
    //   354: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc2_w 486
    //   360: lload 10
    //   362: lmul
    //   363: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   372: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   375: invokeinterface 459 1 0
    //   380: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   383: invokeinterface 459 1 0
    //   388: goto -210 -> 178
    //   391: iload 5
    //   393: ifle +22 -> 415
    //   396: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   399: invokeinterface 459 1 0
    //   404: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   407: invokeinterface 459 1 0
    //   412: goto -234 -> 178
    //   415: iload 5
    //   417: ifne +62 -> 479
    //   420: aload_2
    //   421: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   424: invokevirtual 513	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyRetryNum	()I
    //   427: istore 4
    //   429: iload 4
    //   431: bipush 10
    //   433: if_icmple +35 -> 468
    //   436: aload_2
    //   437: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   440: sipush 211
    //   443: ldc_w 515
    //   446: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   449: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   452: invokeinterface 459 1 0
    //   457: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   460: invokeinterface 459 1 0
    //   465: goto -287 -> 178
    //   468: aload_2
    //   469: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   472: iload 4
    //   474: iconst_1
    //   475: iadd
    //   476: invokevirtual 284	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyRetryNum	(I)V
    //   479: aload_0
    //   480: aload_1
    //   481: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   484: astore 14
    //   486: aload_0
    //   487: aload_2
    //   488: invokevirtual 303	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreCopyDir	(Landroid/content/Context;)Ljava/io/File;
    //   491: astore 22
    //   493: aload 14
    //   495: ifnull +963 -> 1458
    //   498: aload 22
    //   500: ifnull +958 -> 1458
    //   503: iconst_1
    //   504: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   507: aload_2
    //   508: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   511: iload_3
    //   512: iconst_0
    //   513: invokevirtual 287	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   516: new 521	com/tencent/smtt/utils/TbsCopyVerify
    //   519: dup
    //   520: invokespecial 522	com/tencent/smtt/utils/TbsCopyVerify:<init>	()V
    //   523: astore 15
    //   525: aload 15
    //   527: aload 14
    //   529: invokevirtual 525	com/tencent/smtt/utils/TbsCopyVerify:generateReferenceValue	(Ljava/io/File;)V
    //   532: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   535: lstore 8
    //   537: aload 14
    //   539: aload 22
    //   541: invokestatic 534	com/tencent/smtt/utils/FileUtil:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   544: istore 12
    //   546: ldc 116
    //   548: new 347	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 536
    //   558: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   564: lload 8
    //   566: lsub
    //   567: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: iload 12
    //   578: ifeq +841 -> 1419
    //   581: aload 15
    //   583: aload 14
    //   585: invokevirtual 539	com/tencent/smtt/utils/TbsCopyVerify:generateVerifyValue	(Ljava/io/File;)V
    //   588: aload 15
    //   590: invokevirtual 542	com/tencent/smtt/utils/TbsCopyVerify:verify	()Z
    //   593: ifne +49 -> 642
    //   596: ldc 116
    //   598: ldc_w 544
    //   601: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload 22
    //   606: iconst_1
    //   607: invokestatic 300	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   610: aload_2
    //   611: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   614: sipush 213
    //   617: ldc_w 546
    //   620: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   623: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   626: invokeinterface 459 1 0
    //   631: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   634: invokeinterface 459 1 0
    //   639: goto -461 -> 178
    //   642: iconst_1
    //   643: istore 5
    //   645: iconst_1
    //   646: istore 4
    //   648: iconst_1
    //   649: istore 13
    //   651: iconst_1
    //   652: istore 12
    //   654: aconst_null
    //   655: astore 17
    //   657: aconst_null
    //   658: astore 14
    //   660: aconst_null
    //   661: astore 16
    //   663: aconst_null
    //   664: astore 19
    //   666: aconst_null
    //   667: astore 18
    //   669: aload 14
    //   671: astore 15
    //   673: new 328	java/io/File
    //   676: dup
    //   677: aload 22
    //   679: ldc 91
    //   681: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   684: astore 23
    //   686: aload 14
    //   688: astore 15
    //   690: new 548	java/util/Properties
    //   693: dup
    //   694: invokespecial 549	java/util/Properties:<init>	()V
    //   697: astore 14
    //   699: aload 23
    //   701: ifnull +151 -> 852
    //   704: aload 23
    //   706: invokevirtual 341	java/io/File:exists	()Z
    //   709: ifeq +143 -> 852
    //   712: aload 14
    //   714: ifnull +138 -> 852
    //   717: new 551	java/io/FileInputStream
    //   720: dup
    //   721: aload 23
    //   723: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   726: astore 15
    //   728: aload 14
    //   730: aload 15
    //   732: invokevirtual 556	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   735: aload 15
    //   737: ifnull +8 -> 745
    //   740: aload 15
    //   742: invokevirtual 557	java/io/FileInputStream:close	()V
    //   745: aload 14
    //   747: astore 15
    //   749: iload 4
    //   751: ifeq +368 -> 1119
    //   754: aload 22
    //   756: invokevirtual 561	java/io/File:listFiles	()[Ljava/io/File;
    //   759: astore 14
    //   761: iconst_0
    //   762: istore 5
    //   764: iload 12
    //   766: istore 13
    //   768: iload 5
    //   770: aload 14
    //   772: arraylength
    //   773: if_icmpge +346 -> 1119
    //   776: aload 14
    //   778: iload 5
    //   780: aaload
    //   781: astore 16
    //   783: iload 12
    //   785: istore 13
    //   787: ldc 91
    //   789: aload 16
    //   791: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   794: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   797: ifne +42 -> 839
    //   800: iload 12
    //   802: istore 13
    //   804: aload 16
    //   806: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   809: ldc_w 572
    //   812: invokevirtual 576	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   815: ifne +24 -> 839
    //   818: ldc 119
    //   820: aload 16
    //   822: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   825: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   828: istore 13
    //   830: iload 13
    //   832: ifeq +165 -> 997
    //   835: iload 12
    //   837: istore 13
    //   839: iload 5
    //   841: iconst_1
    //   842: iadd
    //   843: istore 5
    //   845: iload 13
    //   847: istore 12
    //   849: goto -85 -> 764
    //   852: iconst_0
    //   853: istore 4
    //   855: aload 19
    //   857: astore 15
    //   859: goto -124 -> 735
    //   862: astore 16
    //   864: aload 18
    //   866: astore 14
    //   868: aload 17
    //   870: astore 15
    //   872: aload 16
    //   874: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   877: iload 5
    //   879: istore 4
    //   881: aload 14
    //   883: astore 15
    //   885: aload 17
    //   887: ifnull -138 -> 749
    //   890: aload 17
    //   892: invokevirtual 557	java/io/FileInputStream:close	()V
    //   895: iload 5
    //   897: istore 4
    //   899: aload 14
    //   901: astore 15
    //   903: goto -154 -> 749
    //   906: astore 15
    //   908: aload 15
    //   910: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   913: iload 5
    //   915: istore 4
    //   917: aload 14
    //   919: astore 15
    //   921: goto -172 -> 749
    //   924: astore_1
    //   925: aload_2
    //   926: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   929: sipush 215
    //   932: aload_1
    //   933: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   936: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   939: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   942: invokeinterface 459 1 0
    //   947: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   950: invokeinterface 459 1 0
    //   955: goto -777 -> 178
    //   958: astore_1
    //   959: aload 15
    //   961: ifnull +8 -> 969
    //   964: aload 15
    //   966: invokevirtual 557	java/io/FileInputStream:close	()V
    //   969: aload_1
    //   970: athrow
    //   971: astore_1
    //   972: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   975: invokeinterface 459 1 0
    //   980: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   983: invokeinterface 459 1 0
    //   988: aload 21
    //   990: aload 20
    //   992: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   995: aload_1
    //   996: athrow
    //   997: aload 16
    //   999: invokestatic 584	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   1002: astore 17
    //   1004: aload 15
    //   1006: aload 16
    //   1008: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   1011: ldc_w 277
    //   1014: invokevirtual 588	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1017: astore 18
    //   1019: aload 18
    //   1021: ldc_w 277
    //   1024: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifne +54 -> 1081
    //   1030: aload 17
    //   1032: aload 18
    //   1034: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1037: ifeq +44 -> 1081
    //   1040: ldc 116
    //   1042: new 347	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 590
    //   1052: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload 16
    //   1057: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   1060: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 592
    //   1066: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: iconst_1
    //   1076: istore 13
    //   1078: goto -239 -> 839
    //   1081: iconst_0
    //   1082: istore 13
    //   1084: ldc 116
    //   1086: new 347	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 594
    //   1096: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload 16
    //   1101: invokevirtual 564	java/io/File:getName	()Ljava/lang/String;
    //   1104: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: ldc_w 592
    //   1110: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1119: ldc 116
    //   1121: new 347	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1128: ldc_w 596
    //   1131: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: iload 13
    //   1136: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1139: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1145: iload 4
    //   1147: ifeq +54 -> 1201
    //   1150: iload 13
    //   1152: ifne +49 -> 1201
    //   1155: ldc 116
    //   1157: ldc_w 601
    //   1160: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 22
    //   1165: iconst_1
    //   1166: invokestatic 300	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1169: aload_2
    //   1170: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1173: sipush 213
    //   1176: ldc_w 603
    //   1179: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1182: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1185: invokeinterface 459 1 0
    //   1190: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1193: invokeinterface 459 1 0
    //   1198: goto -1020 -> 178
    //   1201: ldc 116
    //   1203: ldc_w 605
    //   1206: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1209: aload_1
    //   1210: invokestatic 610	com/tencent/smtt/sdk/TbsApkDownloader:backupApkPath	(Landroid/content/Context;)Ljava/io/File;
    //   1213: astore_1
    //   1214: aload_1
    //   1215: ifnull +25 -> 1240
    //   1218: aload_1
    //   1219: invokevirtual 341	java/io/File:exists	()Z
    //   1222: ifeq +18 -> 1240
    //   1225: new 328	java/io/File
    //   1228: dup
    //   1229: aload_1
    //   1230: ldc_w 612
    //   1233: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1236: aload_2
    //   1237: invokestatic 616	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1240: aload_2
    //   1241: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1244: iload_3
    //   1245: iconst_1
    //   1246: invokevirtual 287	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1249: aload_2
    //   1250: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1253: sipush 220
    //   1256: ldc_w 618
    //   1259: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1262: ldc 116
    //   1264: new 347	java/lang/StringBuilder
    //   1267: dup
    //   1268: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1271: ldc_w 620
    //   1274: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: iload_3
    //   1278: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1281: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1287: getstatic 412	android/os/Build$VERSION:SDK_INT	I
    //   1290: bipush 11
    //   1292: if_icmplt +83 -> 1375
    //   1295: aload_2
    //   1296: ldc_w 414
    //   1299: iconst_4
    //   1300: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1303: astore_1
    //   1304: aload_1
    //   1305: invokeinterface 624 1 0
    //   1310: astore_1
    //   1311: aload_1
    //   1312: ldc_w 626
    //   1315: iconst_0
    //   1316: invokeinterface 632 3 0
    //   1321: pop
    //   1322: aload_1
    //   1323: ldc_w 634
    //   1326: iconst_0
    //   1327: invokeinterface 632 3 0
    //   1332: pop
    //   1333: aload_1
    //   1334: ldc_w 636
    //   1337: iload_3
    //   1338: invokeinterface 632 3 0
    //   1343: pop
    //   1344: aload_1
    //   1345: invokeinterface 639 1 0
    //   1350: pop
    //   1351: aload_2
    //   1352: invokestatic 642	com/tencent/smtt/utils/TbsUtils:createDirectoryTBS	(Landroid/content/Context;)Z
    //   1355: pop
    //   1356: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1359: invokeinterface 459 1 0
    //   1364: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1367: invokeinterface 459 1 0
    //   1372: goto -1194 -> 178
    //   1375: aload_2
    //   1376: ldc_w 414
    //   1379: iconst_0
    //   1380: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1383: astore_1
    //   1384: goto -80 -> 1304
    //   1387: astore_1
    //   1388: ldc 116
    //   1390: new 347	java/lang/StringBuilder
    //   1393: dup
    //   1394: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1397: ldc_w 644
    //   1400: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload_1
    //   1404: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1407: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1416: goto -65 -> 1351
    //   1419: ldc 116
    //   1421: ldc_w 652
    //   1424: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1427: aload_2
    //   1428: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1431: iload_3
    //   1432: iconst_2
    //   1433: invokevirtual 287	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1436: aload 22
    //   1438: iconst_0
    //   1439: invokestatic 300	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1442: aload_2
    //   1443: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1446: sipush 212
    //   1449: ldc_w 654
    //   1452: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1455: goto -99 -> 1356
    //   1458: aload 14
    //   1460: ifnonnull +16 -> 1476
    //   1463: aload_2
    //   1464: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1467: sipush 213
    //   1470: ldc_w 656
    //   1473: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1476: aload 22
    //   1478: ifnonnull -122 -> 1356
    //   1481: aload_2
    //   1482: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1485: sipush 214
    //   1488: ldc_w 658
    //   1491: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1494: goto -138 -> 1356
    //   1497: aload 21
    //   1499: aload 20
    //   1501: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1504: return
    //   1505: astore 14
    //   1507: aload 14
    //   1509: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   1512: goto -543 -> 969
    //   1515: astore 15
    //   1517: aload 15
    //   1519: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   1522: goto -777 -> 745
    //   1525: astore_1
    //   1526: aload 16
    //   1528: astore 15
    //   1530: goto -571 -> 959
    //   1533: astore_1
    //   1534: goto -575 -> 959
    //   1537: astore 16
    //   1539: goto -671 -> 868
    //   1542: astore 16
    //   1544: aload 15
    //   1546: astore 17
    //   1548: goto -680 -> 868
    //   1551: iload 5
    //   1553: ifle +12 -> 1565
    //   1556: iload_3
    //   1557: iload 5
    //   1559: if_icmple +6 -> 1565
    //   1562: goto -1295 -> 267
    //   1565: iload 4
    //   1567: istore 5
    //   1569: iload 4
    //   1571: iconst_3
    //   1572: if_icmpne -1280 -> 292
    //   1575: iload 4
    //   1577: istore 5
    //   1579: iload 6
    //   1581: ifle -1289 -> 292
    //   1584: iload_3
    //   1585: iload 6
    //   1587: if_icmpgt -1312 -> 275
    //   1590: iload 4
    //   1592: istore 5
    //   1594: iload_3
    //   1595: ldc_w 659
    //   1598: if_icmpne -1306 -> 292
    //   1601: goto -1326 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1604	0	this	TbsInstaller
    //   0	1604	1	paramContext1	Context
    //   0	1604	2	paramContext2	Context
    //   0	1604	3	paramInt	int
    //   154	1437	4	i	int
    //   145	1448	5	j	int
    //   191	1397	6	k	int
    //   251	11	7	m	int
    //   314	251	8	l1	long
    //   324	37	10	l2	long
    //   544	304	12	bool1	boolean
    //   649	502	13	bool2	boolean
    //   33	1426	14	localObject1	Object
    //   1505	3	14	localIOException1	IOException
    //   523	379	15	localObject2	Object
    //   906	3	15	localIOException2	IOException
    //   919	86	15	localObject3	Object
    //   1515	3	15	localIOException3	IOException
    //   1528	17	15	localObject4	Object
    //   661	160	16	localObject5	Object
    //   862	665	16	localException1	Exception
    //   1537	1	16	localException2	Exception
    //   1542	1	16	localException3	Exception
    //   655	892	17	localObject6	Object
    //   667	366	18	str	String
    //   664	192	19	localObject7	Object
    //   99	1401	20	localFileOutputStream	FileOutputStream
    //   112	1386	21	localFileLock	FileLock
    //   491	986	22	localFile1	File
    //   684	38	23	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   673	686	862	java/lang/Exception
    //   690	699	862	java/lang/Exception
    //   890	895	906	java/io/IOException
    //   138	156	924	java/lang/Exception
    //   186	219	924	java/lang/Exception
    //   244	253	924	java/lang/Exception
    //   267	272	924	java/lang/Exception
    //   278	292	924	java/lang/Exception
    //   292	372	924	java/lang/Exception
    //   420	429	924	java/lang/Exception
    //   436	449	924	java/lang/Exception
    //   468	479	924	java/lang/Exception
    //   479	493	924	java/lang/Exception
    //   503	576	924	java/lang/Exception
    //   581	623	924	java/lang/Exception
    //   740	745	924	java/lang/Exception
    //   754	761	924	java/lang/Exception
    //   768	776	924	java/lang/Exception
    //   787	800	924	java/lang/Exception
    //   804	830	924	java/lang/Exception
    //   890	895	924	java/lang/Exception
    //   908	913	924	java/lang/Exception
    //   964	969	924	java/lang/Exception
    //   969	971	924	java/lang/Exception
    //   997	1075	924	java/lang/Exception
    //   1084	1119	924	java/lang/Exception
    //   1119	1145	924	java/lang/Exception
    //   1155	1182	924	java/lang/Exception
    //   1201	1214	924	java/lang/Exception
    //   1218	1240	924	java/lang/Exception
    //   1240	1304	924	java/lang/Exception
    //   1304	1351	924	java/lang/Exception
    //   1351	1356	924	java/lang/Exception
    //   1375	1384	924	java/lang/Exception
    //   1388	1416	924	java/lang/Exception
    //   1419	1455	924	java/lang/Exception
    //   1463	1476	924	java/lang/Exception
    //   1481	1494	924	java/lang/Exception
    //   1507	1512	924	java/lang/Exception
    //   1517	1522	924	java/lang/Exception
    //   673	686	958	finally
    //   690	699	958	finally
    //   872	877	958	finally
    //   138	156	971	finally
    //   186	219	971	finally
    //   244	253	971	finally
    //   267	272	971	finally
    //   278	292	971	finally
    //   292	372	971	finally
    //   420	429	971	finally
    //   436	449	971	finally
    //   468	479	971	finally
    //   479	493	971	finally
    //   503	576	971	finally
    //   581	623	971	finally
    //   740	745	971	finally
    //   754	761	971	finally
    //   768	776	971	finally
    //   787	800	971	finally
    //   804	830	971	finally
    //   890	895	971	finally
    //   908	913	971	finally
    //   925	939	971	finally
    //   964	969	971	finally
    //   969	971	971	finally
    //   997	1075	971	finally
    //   1084	1119	971	finally
    //   1119	1145	971	finally
    //   1155	1182	971	finally
    //   1201	1214	971	finally
    //   1218	1240	971	finally
    //   1240	1304	971	finally
    //   1304	1351	971	finally
    //   1351	1356	971	finally
    //   1375	1384	971	finally
    //   1388	1416	971	finally
    //   1419	1455	971	finally
    //   1463	1476	971	finally
    //   1481	1494	971	finally
    //   1507	1512	971	finally
    //   1517	1522	971	finally
    //   1304	1351	1387	java/lang/Throwable
    //   964	969	1505	java/io/IOException
    //   740	745	1515	java/io/IOException
    //   704	712	1525	finally
    //   717	728	1525	finally
    //   728	735	1533	finally
    //   704	712	1537	java/lang/Exception
    //   717	728	1537	java/lang/Exception
    //   728	735	1542	java/lang/Exception
  }
  
  private Context createHostContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private void deleteOldTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.delete(getTbsCoreShareDir(paramContext), false);
  }
  
  /* Error */
  private boolean doTbsCoreDexOpt(Context paramContext)
  {
    // Byte code:
    //   0: ldc 116
    //   2: ldc_w 672
    //   5: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 294	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: astore 5
    //   15: aload 5
    //   17: new 8	com/tencent/smtt/sdk/TbsInstaller$2
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 675	com/tencent/smtt/sdk/TbsInstaller$2:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;)V
    //   25: invokevirtual 678	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   28: astore 6
    //   30: aload 6
    //   32: arraylength
    //   33: istore_3
    //   34: getstatic 412	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 16
    //   39: if_icmpge +32 -> 71
    //   42: aload_1
    //   43: invokevirtual 681	android/content/Context:getPackageName	()Ljava/lang/String;
    //   46: ifnull +25 -> 71
    //   49: aload_1
    //   50: invokevirtual 681	android/content/Context:getPackageName	()Ljava/lang/String;
    //   53: ldc 21
    //   55: invokevirtual 684	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   58: istore 4
    //   60: iload 4
    //   62: ifeq +9 -> 71
    //   65: ldc2_w 685
    //   68: invokestatic 692	java/lang/Thread:sleep	(J)V
    //   71: iconst_0
    //   72: istore_2
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmpge +92 -> 167
    //   78: ldc 116
    //   80: new 347	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 694
    //   90: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: iload_2
    //   96: aaload
    //   97: invokevirtual 697	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 701	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   113: astore 7
    //   115: new 703	dalvik/system/DexClassLoader
    //   118: dup
    //   119: aload 6
    //   121: iload_2
    //   122: aaload
    //   123: invokevirtual 697	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   126: aload 5
    //   128: invokevirtual 697	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: aconst_null
    //   132: aload 7
    //   134: invokespecial 706	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   137: pop
    //   138: iload_2
    //   139: iconst_1
    //   140: iadd
    //   141: istore_2
    //   142: goto -69 -> 73
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   152: aload_1
    //   153: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   156: sipush 209
    //   159: aload 5
    //   161: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   167: ldc 116
    //   169: ldc_w 708
    //   172: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_1
    //   176: ireturn
    //   177: astore 7
    //   179: goto -108 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TbsInstaller
    //   0	182	1	paramContext	Context
    //   72	70	2	i	int
    //   33	43	3	j	int
    //   58	3	4	bool	boolean
    //   13	114	5	localFile	File
    //   145	15	5	localException1	Exception
    //   28	92	6	arrayOfFile	File[]
    //   113	20	7	localClassLoader	java.lang.ClassLoader
    //   177	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	60	145	java/lang/Exception
    //   78	138	145	java/lang/Exception
    //   65	71	177	java/lang/Exception
  }
  
  /* Error */
  private boolean enableTbsCoreFromCopy(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 116
    //   2: ldc_w 712
    //   5: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: iconst_0
    //   9: istore 5
    //   11: iconst_0
    //   12: istore 8
    //   14: iconst_0
    //   15: istore 7
    //   17: iload 8
    //   19: istore 6
    //   21: aload_1
    //   22: invokestatic 437	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   25: astore 10
    //   27: aload 10
    //   29: ifnonnull +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: iload 8
    //   36: istore 6
    //   38: aload_1
    //   39: aload 10
    //   41: invokestatic 441	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   44: astore 11
    //   46: aload 11
    //   48: ifnonnull +5 -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: iload 8
    //   55: istore 6
    //   57: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 446 1 0
    //   65: istore 9
    //   67: iload 8
    //   69: istore 6
    //   71: ldc 116
    //   73: new 347	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 714
    //   83: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload 9
    //   88: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   91: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iload 9
    //   99: ifeq +112 -> 211
    //   102: aload_1
    //   103: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   106: invokevirtual 456	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyStatus	()I
    //   109: istore_3
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 467	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   115: istore 4
    //   117: ldc 116
    //   119: new 347	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 716
    //   129: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_3
    //   133: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: ldc 116
    //   144: new 347	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 718
    //   154: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 4
    //   159: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: iload 7
    //   170: istore 5
    //   172: iload_3
    //   173: iconst_1
    //   174: if_icmpne +25 -> 199
    //   177: iload 4
    //   179: ifne +46 -> 225
    //   182: ldc 116
    //   184: ldc_w 720
    //   187: iconst_1
    //   188: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   191: aload_0
    //   192: aload_1
    //   193: invokespecial 723	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   196: iconst_1
    //   197: istore 5
    //   199: iload 5
    //   201: istore 6
    //   203: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   206: invokeinterface 459 1 0
    //   211: iload 5
    //   213: istore 6
    //   215: aload 11
    //   217: aload 10
    //   219: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   222: iload 5
    //   224: ireturn
    //   225: iload 7
    //   227: istore 5
    //   229: iload_2
    //   230: ifeq -31 -> 199
    //   233: ldc 116
    //   235: ldc_w 725
    //   238: iconst_1
    //   239: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   242: aload_0
    //   243: aload_1
    //   244: invokespecial 723	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   247: iconst_1
    //   248: istore 5
    //   250: goto -51 -> 199
    //   253: astore 10
    //   255: iload 8
    //   257: istore 6
    //   259: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface 459 1 0
    //   267: iload 8
    //   269: istore 6
    //   271: aload 10
    //   273: athrow
    //   274: astore 10
    //   276: aload_1
    //   277: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   280: sipush 215
    //   283: aload 10
    //   285: invokevirtual 726	java/lang/Throwable:toString	()Ljava/lang/String;
    //   288: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   291: invokestatic 316	com/tencent/smtt/sdk/QbSdk:forceSysWebViewInner	()V
    //   294: ldc 116
    //   296: new 347	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 728
    //   306: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 10
    //   311: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: iload 6
    //   325: istore 5
    //   327: goto -105 -> 222
    //   330: astore_1
    //   331: aload_1
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	TbsInstaller
    //   0	333	1	paramContext	Context
    //   0	333	2	paramBoolean	boolean
    //   109	66	3	i	int
    //   115	63	4	j	int
    //   9	317	5	bool1	boolean
    //   19	305	6	bool2	boolean
    //   15	211	7	bool3	boolean
    //   12	256	8	bool4	boolean
    //   65	33	9	bool5	boolean
    //   25	193	10	localFileOutputStream	FileOutputStream
    //   253	19	10	localObject	Object
    //   274	36	10	localThrowable	Throwable
    //   44	172	11	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   102	168	253	finally
    //   182	196	253	finally
    //   233	247	253	finally
    //   21	27	274	java/lang/Throwable
    //   38	46	274	java/lang/Throwable
    //   57	67	274	java/lang/Throwable
    //   71	97	274	java/lang/Throwable
    //   203	211	274	java/lang/Throwable
    //   215	222	274	java/lang/Throwable
    //   259	267	274	java/lang/Throwable
    //   271	274	274	java/lang/Throwable
    //   21	27	330	finally
    //   38	46	330	finally
    //   57	67	330	finally
    //   71	97	330	finally
    //   203	211	330	finally
    //   215	222	330	finally
    //   259	267	330	finally
    //   271	274	330	finally
    //   276	323	330	finally
  }
  
  /* Error */
  private boolean enableTbsCoreFromUnzip(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 116
    //   2: new 347	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 731
    //   12: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_1
    //   26: invokestatic 437	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnonnull +5 -> 38
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_1
    //   39: aload 6
    //   41: invokestatic 441	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnull +175 -> 223
    //   51: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   54: invokeinterface 446 1 0
    //   59: istore 5
    //   61: ldc 116
    //   63: new 347	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 733
    //   73: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload 5
    //   78: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iload 5
    //   89: ifeq +75 -> 164
    //   92: aload_1
    //   93: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   96: invokevirtual 736	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallStatus	()I
    //   99: istore_3
    //   100: ldc 116
    //   102: new 347	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 738
    //   112: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_3
    //   116: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: aload_1
    //   127: invokevirtual 467	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   130: istore 4
    //   132: iload_3
    //   133: iconst_2
    //   134: if_icmpne +22 -> 156
    //   137: iload 4
    //   139: ifne +52 -> 191
    //   142: ldc 116
    //   144: ldc_w 740
    //   147: iconst_0
    //   148: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   151: aload_0
    //   152: aload_1
    //   153: invokespecial 743	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromUnzip	(Landroid/content/Context;)V
    //   156: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   159: invokeinterface 459 1 0
    //   164: aload 7
    //   166: aload 6
    //   168: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_1
    //   174: ldc 116
    //   176: ldc_w 745
    //   179: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: invokestatic 316	com/tencent/smtt/sdk/QbSdk:forceSysWebViewInner	()V
    //   185: aload_1
    //   186: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: iload_2
    //   192: ifeq -36 -> 156
    //   195: ldc 116
    //   197: ldc_w 747
    //   200: iconst_0
    //   201: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   204: aload_0
    //   205: aload_1
    //   206: invokespecial 743	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromUnzip	(Landroid/content/Context;)V
    //   209: goto -53 -> 156
    //   212: astore_1
    //   213: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   216: invokeinterface 459 1 0
    //   221: aload_1
    //   222: athrow
    //   223: iconst_0
    //   224: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	TbsInstaller
    //   0	225	1	paramContext	Context
    //   0	225	2	paramBoolean	boolean
    //   99	36	3	i	int
    //   130	8	4	j	int
    //   59	29	5	bool	boolean
    //   29	138	6	localFileOutputStream	FileOutputStream
    //   44	121	7	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   25	31	173	java/lang/Exception
    //   38	46	173	java/lang/Exception
    //   51	87	173	java/lang/Exception
    //   156	164	173	java/lang/Exception
    //   164	171	173	java/lang/Exception
    //   213	223	173	java/lang/Exception
    //   92	132	212	finally
    //   142	156	212	finally
    //   195	209	212	finally
  }
  
  private void finishLocalTbsInstall(int paramInt, String paramString, Context paramContext)
  {
    new File(paramString).delete();
    TbsLog.i("TbsInstaller", "Local tbs apk(" + paramString + ") is deleted!", true);
    paramString = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((paramString != null) && (paramString.canRead()))
    {
      paramContext = new File(paramString, "tbs.conf");
      paramString = new Properties();
    }
    try
    {
      paramString.load(new FileInputStream(paramContext));
      paramContext = new FileOutputStream(paramContext);
      paramString.setProperty("tbs_local_installation", "true");
      paramString.store(paramContext, null);
      TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  static void freeFileLock(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {}
    try
    {
      paramFileLock.release();
      if (paramFileOutputStream == null) {}
    }
    catch (Exception paramFileLock)
    {
      for (;;)
      {
        try
        {
          paramFileOutputStream.close();
          return;
        }
        catch (Exception paramFileLock)
        {
          paramFileLock.printStackTrace();
        }
        paramFileLock = paramFileLock;
        paramFileLock.printStackTrace();
      }
    }
  }
  
  private void generateNewTbsCoreFromCopy(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    try
    {
      deleteOldTbsCore(paramContext);
      renameTbsCoreCopyDir(paramContext);
      TbsShareManager.shareTbsCore(paramContext);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, 3);
      this.mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
    }
  }
  
  private void generateNewTbsCoreFromUnzip(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    try
    {
      deleteOldTbsCore(paramContext);
      renameTbsCoreShareDir(paramContext);
      TbsShareManager.shareTbsCore(paramContext);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 3);
      TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
      this.mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localException.toString());
      TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
    }
  }
  
  /* Error */
  private String getInstalledTbsTimeStamp(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 328	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc 119
    //   16: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +12 -> 33
    //   24: aload_1
    //   25: invokevirtual 341	java/io/File:exists	()Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifne +17 -> 47
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 807	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: aconst_null
    //   46: areturn
    //   47: new 548	java/util/Properties
    //   50: dup
    //   51: invokespecial 549	java/util/Properties:<init>	()V
    //   54: astore 5
    //   56: new 551	java/io/FileInputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_1
    //   65: aload 5
    //   67: aload_1
    //   68: invokevirtual 556	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_1
    //   72: invokevirtual 557	java/io/FileInputStream:close	()V
    //   75: aload 5
    //   77: ldc 122
    //   79: invokevirtual 811	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +13 -> 97
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 557	java/io/FileInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 557	java/io/FileInputStream:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_1
    //   108: aload 4
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 557	java/io/FileInputStream:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 557	java/io/FileInputStream:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: goto -14 -> 119
    //   136: astore_3
    //   137: goto -7 -> 130
    //   140: astore_1
    //   141: goto -96 -> 45
    //   144: astore_1
    //   145: goto -50 -> 95
    //   148: astore_1
    //   149: goto -44 -> 105
    //   152: astore 4
    //   154: aload_1
    //   155: astore_3
    //   156: aload 4
    //   158: astore_1
    //   159: goto -37 -> 122
    //   162: astore_3
    //   163: goto -52 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TbsInstaller
    //   0	166	1	paramContext	Context
    //   28	2	2	bool	boolean
    //   1	126	3	str	String
    //   136	1	3	localIOException	IOException
    //   155	1	3	localContext	Context
    //   162	1	3	localException	Exception
    //   3	106	4	localObject1	Object
    //   152	5	4	localObject2	Object
    //   54	22	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   5	20	107	java/lang/Exception
    //   24	29	107	java/lang/Exception
    //   47	65	107	java/lang/Exception
    //   5	20	121	finally
    //   24	29	121	finally
    //   47	65	121	finally
    //   115	119	132	java/io/IOException
    //   126	130	136	java/io/IOException
    //   37	45	140	java/io/IOException
    //   91	95	144	java/io/IOException
    //   101	105	148	java/io/IOException
    //   65	83	152	finally
    //   65	83	162	java/lang/Exception
  }
  
  static TbsInstaller getInstance()
  {
    if (mInstance == null) {
      mInstance = new TbsInstaller();
    }
    return mInstance;
  }
  
  static File getLockFile(Context paramContext, String paramString)
  {
    paramContext = getTbsCorePrivateDir(paramContext);
    if (paramContext == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramString = new File(paramContext, paramString);
      if (paramString == null) {
        break;
      }
      paramContext = paramString;
    } while (paramString.exists());
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  static FileOutputStream getLockFos(Context paramContext)
  {
    paramContext = getLockFile(paramContext, "tbslock.txt");
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  private Context getTbsCoreHostContext(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "com.tencent.x5sdk.demo";
    arrayOfString[1] = "com.tencent.mtt";
    arrayOfString[2] = "com.tencent.mm";
    arrayOfString[3] = "com.tencent.mobileqq";
    arrayOfString[4] = "com.tencent.mtt.sdk.test";
    arrayOfString[5] = "com.qzone";
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i])) {}
      Context localContext;
      label178:
      int j;
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (isHostAppInstalled(paramContext, arrayOfString[i]))
          {
            localContext = createHostContext(paramContext, arrayOfString[i]);
            if (localContext != null)
            {
              if (vertificateApp(localContext)) {
                break label178;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i] + " illegal signature go on next");
            }
          }
        }
        j = getTbsCoreInstalledVerInNolock(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + j);
      } while ((j == 0) || (j != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i]);
      return localContext;
    }
    return null;
  }
  
  static File getTbsCorePrivateDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "core_private");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  private String getTbsCoreTimeStampFromApk(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 128);
    if (paramContext != null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreTimeStampFromApk  timestamp=" + paramContext.applicationInfo.metaData.getString("TIMESTAMP"));
      return paramContext.applicationInfo.metaData.getString("TIMESTAMP");
    }
    return null;
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void installTbsCoreInThread(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 405	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   5: ifeq +13 -> 18
    //   8: ldc 116
    //   10: ldc_w 890
    //   13: iconst_1
    //   14: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   17: return
    //   18: ldc 116
    //   20: new 347	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 892
    //   30: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 116
    //   45: new 347	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 894
    //   55: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 116
    //   70: new 347	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 896
    //   80: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 900	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   87: getfield 903	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   90: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: ldc 116
    //   101: new 347	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 905
    //   111: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokestatic 910	android/os/Process:myPid	()I
    //   117: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 116
    //   128: new 347	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 912
    //   138: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokestatic 916	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   144: invokevirtual 917	java/lang/Thread:getName	()Ljava/lang/String;
    //   147: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: getstatic 412	android/os/Build$VERSION:SDK_INT	I
    //   159: bipush 11
    //   161: if_icmplt +60 -> 221
    //   164: aload_1
    //   165: ldc_w 414
    //   168: iconst_4
    //   169: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   172: astore 14
    //   174: aload 14
    //   176: ldc_w 420
    //   179: iconst_m1
    //   180: invokeinterface 426 3 0
    //   185: iload_3
    //   186: if_icmpne +48 -> 234
    //   189: ldc 116
    //   191: new 347	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 919
    //   201: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_3
    //   205: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 433
    //   211: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: return
    //   221: aload_1
    //   222: ldc_w 414
    //   225: iconst_0
    //   226: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   229: astore 14
    //   231: goto -57 -> 174
    //   234: new 347	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   241: getstatic 924	com/tencent/smtt/sdk/WebView:TBS_DEBUG_INSTALL_ONLINE	Ljava/lang/String;
    //   244: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 681	android/content/Context:getPackageName	()Ljava/lang/String;
    //   251: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 16
    //   259: getstatic 927	com/tencent/smtt/sdk/QbSdk:mTbsDebugInstallOnline	Z
    //   262: ifne +104 -> 366
    //   265: aconst_null
    //   266: astore 14
    //   268: aload_1
    //   269: invokevirtual 931	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   272: aload 16
    //   274: invokestatic 936	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   277: astore 15
    //   279: aload 15
    //   281: astore 14
    //   283: aload 14
    //   285: ifnull +81 -> 366
    //   288: aload 14
    //   290: ldc_w 762
    //   293: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq +70 -> 366
    //   299: ldc 116
    //   301: ldc_w 938
    //   304: invokestatic 941	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: ldc2_w 942
    //   310: invokestatic 692	java/lang/Thread:sleep	(J)V
    //   313: aload_1
    //   314: invokevirtual 931	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   317: aload 16
    //   319: invokestatic 936	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   322: astore 15
    //   324: aload 15
    //   326: astore 14
    //   328: aload 14
    //   330: ifnull +150 -> 480
    //   333: aload 14
    //   335: ldc_w 762
    //   338: invokevirtual 570	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   341: ifeq +139 -> 480
    //   344: aload_1
    //   345: invokevirtual 931	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   348: aload 16
    //   350: ldc_w 945
    //   353: invokestatic 949	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   356: pop
    //   357: ldc 116
    //   359: ldc_w 951
    //   362: iconst_1
    //   363: invokestatic 953	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   366: aload_2
    //   367: ifnull +123 -> 490
    //   370: aload_2
    //   371: invokevirtual 956	java/lang/String:length	()I
    //   374: ifle +116 -> 490
    //   377: invokestatic 485	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   380: ldc2_w 957
    //   383: aload_2
    //   384: invokestatic 962	com/tencent/smtt/utils/TbsUtils:getApkSize	(Ljava/lang/String;)J
    //   387: lmul
    //   388: lcmp
    //   389: ifge +101 -> 490
    //   392: invokestatic 485	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   395: lstore 9
    //   397: aload_2
    //   398: invokestatic 962	com/tencent/smtt/utils/TbsUtils:getApkSize	(Ljava/lang/String;)J
    //   401: lstore 11
    //   403: aload_1
    //   404: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   407: sipush 210
    //   410: new 347	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 964
    //   420: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 9
    //   425: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 506
    //   431: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc2_w 957
    //   437: lload 11
    //   439: lmul
    //   440: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   443: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   449: return
    //   450: astore 15
    //   452: aload 15
    //   454: invokevirtual 965	java/lang/SecurityException:printStackTrace	()V
    //   457: goto -174 -> 283
    //   460: astore 15
    //   462: aload 15
    //   464: invokevirtual 965	java/lang/SecurityException:printStackTrace	()V
    //   467: goto -139 -> 328
    //   470: astore 14
    //   472: aload 14
    //   474: invokevirtual 965	java/lang/SecurityException:printStackTrace	()V
    //   477: goto -120 -> 357
    //   480: ldc 116
    //   482: ldc_w 967
    //   485: iconst_1
    //   486: invokestatic 953	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   489: return
    //   490: aload_1
    //   491: invokestatic 437	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   494: astore 16
    //   496: aload 16
    //   498: ifnull -481 -> 17
    //   501: aload_1
    //   502: aload 16
    //   504: invokestatic 441	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   507: astore 17
    //   509: aload 17
    //   511: ifnull -494 -> 17
    //   514: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   517: invokeinterface 446 1 0
    //   522: istore 13
    //   524: ldc 116
    //   526: new 347	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 969
    //   536: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: iload 13
    //   541: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   544: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: iload 13
    //   552: ifeq +1041 -> 1593
    //   555: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   558: invokeinterface 449 1 0
    //   563: aload_1
    //   564: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   567: invokevirtual 453	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyVer	()I
    //   570: istore 4
    //   572: aload_1
    //   573: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   576: invokevirtual 472	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   579: istore 5
    //   581: ldc 116
    //   583: new 347	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 971
    //   593: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iload 4
    //   598: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: ldc 116
    //   609: new 347	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   616: ldc_w 973
    //   619: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: iload 5
    //   624: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: ldc 116
    //   635: new 347	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 975
    //   645: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: iload_3
    //   649: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: iload 5
    //   660: ifle +946 -> 1606
    //   663: iload_3
    //   664: iload 5
    //   666: if_icmpgt +6 -> 672
    //   669: goto +937 -> 1606
    //   672: aload_0
    //   673: aload_1
    //   674: invokespecial 474	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   677: iconst_0
    //   678: istore 6
    //   680: aload_1
    //   681: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   684: invokevirtual 736	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallStatus	()I
    //   687: istore 7
    //   689: aload_0
    //   690: aload_1
    //   691: invokevirtual 467	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   694: istore 8
    //   696: ldc 116
    //   698: new 347	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   705: ldc_w 977
    //   708: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: iload 7
    //   713: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   722: ldc 116
    //   724: new 347	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 979
    //   734: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 8
    //   739: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: iload 7
    //   750: iflt +140 -> 890
    //   753: iload 7
    //   755: iconst_2
    //   756: if_icmpge +134 -> 890
    //   759: iconst_1
    //   760: istore 5
    //   762: ldc 116
    //   764: ldc_w 981
    //   767: iconst_1
    //   768: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   771: iload 7
    //   773: istore 4
    //   775: ldc 116
    //   777: new 347	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   784: ldc_w 983
    //   787: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: iload 4
    //   792: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: iconst_0
    //   802: istore 6
    //   804: iload 4
    //   806: iconst_1
    //   807: if_icmpge +431 -> 1238
    //   810: ldc 116
    //   812: ldc_w 985
    //   815: iconst_1
    //   816: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   819: iconst_1
    //   820: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   823: iload 5
    //   825: ifeq +174 -> 999
    //   828: aload_1
    //   829: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   832: invokevirtual 988	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreUnzipRetryNum	()I
    //   835: istore 6
    //   837: iload 6
    //   839: bipush 10
    //   841: if_icmple +147 -> 988
    //   844: aload_1
    //   845: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   848: sipush 201
    //   851: ldc_w 990
    //   854: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   857: aload_0
    //   858: aload_1
    //   859: invokespecial 992	com/tencent/smtt/sdk/TbsInstaller:clearNewTbsCore	(Landroid/content/Context;)V
    //   862: iconst_0
    //   863: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   866: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   869: invokeinterface 459 1 0
    //   874: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   877: invokeinterface 459 1 0
    //   882: aload 17
    //   884: aload 16
    //   886: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   889: return
    //   890: iload 7
    //   892: istore 4
    //   894: iload 6
    //   896: istore 5
    //   898: iload 7
    //   900: iconst_3
    //   901: if_icmpne -126 -> 775
    //   904: iload 7
    //   906: istore 4
    //   908: iload 6
    //   910: istore 5
    //   912: iload 8
    //   914: ifle -139 -> 775
    //   917: iload_3
    //   918: iload 8
    //   920: if_icmpgt +18 -> 938
    //   923: iload 7
    //   925: istore 4
    //   927: iload 6
    //   929: istore 5
    //   931: iload_3
    //   932: ldc_w 659
    //   935: if_icmpne -160 -> 775
    //   938: iconst_m1
    //   939: istore 4
    //   941: aload_0
    //   942: aload_1
    //   943: invokespecial 474	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   946: ldc 116
    //   948: ldc_w 994
    //   951: iconst_1
    //   952: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   955: iload 6
    //   957: istore 5
    //   959: goto -184 -> 775
    //   962: astore_1
    //   963: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   966: invokeinterface 459 1 0
    //   971: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   974: invokeinterface 459 1 0
    //   979: aload 17
    //   981: aload 16
    //   983: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   986: aload_1
    //   987: athrow
    //   988: aload_1
    //   989: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   992: iload 6
    //   994: iconst_1
    //   995: iadd
    //   996: invokevirtual 271	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreUnzipRetryNum	(I)V
    //   999: aload_2
    //   1000: astore 15
    //   1002: aload 15
    //   1004: astore 14
    //   1006: aload 15
    //   1008: ifnonnull +62 -> 1070
    //   1011: aload_1
    //   1012: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1015: invokevirtual 997	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsApkPath	()Ljava/lang/String;
    //   1018: astore 15
    //   1020: aload 15
    //   1022: astore 14
    //   1024: aload 15
    //   1026: ifnonnull +44 -> 1070
    //   1029: aload_1
    //   1030: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1033: sipush 202
    //   1036: ldc_w 999
    //   1039: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1042: iconst_0
    //   1043: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1046: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1049: invokeinterface 459 1 0
    //   1054: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1057: invokeinterface 459 1 0
    //   1062: aload 17
    //   1064: aload 16
    //   1066: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1069: return
    //   1070: ldc 116
    //   1072: new 347	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 1001
    //   1082: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload 14
    //   1087: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1096: aload_0
    //   1097: aload_1
    //   1098: aload 14
    //   1100: invokevirtual 1005	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreVerFromApk	(Landroid/content/Context;Ljava/lang/String;)I
    //   1103: istore 6
    //   1105: iload 6
    //   1107: ifne +44 -> 1151
    //   1110: aload_1
    //   1111: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1114: sipush 203
    //   1117: ldc_w 1007
    //   1120: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1123: iconst_0
    //   1124: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1127: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1130: invokeinterface 459 1 0
    //   1135: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1138: invokeinterface 459 1 0
    //   1143: aload 17
    //   1145: aload 16
    //   1147: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1150: return
    //   1151: aload_1
    //   1152: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1155: aload 14
    //   1157: invokevirtual 281	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsApkPath	(Ljava/lang/String;)V
    //   1160: aload_1
    //   1161: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1164: iload 6
    //   1166: iconst_0
    //   1167: invokevirtual 275	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1170: aload_0
    //   1171: aload_1
    //   1172: new 328	java/io/File
    //   1175: dup
    //   1176: aload 14
    //   1178: invokespecial 751	java/io/File:<init>	(Ljava/lang/String;)V
    //   1181: invokespecial 1011	com/tencent/smtt/sdk/TbsInstaller:unzipTbsApk	(Landroid/content/Context;Ljava/io/File;)Z
    //   1184: ifne +44 -> 1228
    //   1187: aload_1
    //   1188: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1191: sipush 207
    //   1194: ldc_w 1013
    //   1197: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1200: iconst_0
    //   1201: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1204: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1207: invokeinterface 459 1 0
    //   1212: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1215: invokeinterface 459 1 0
    //   1220: aload 17
    //   1222: aload 16
    //   1224: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1227: return
    //   1228: aload_1
    //   1229: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1232: iload 6
    //   1234: iconst_1
    //   1235: invokevirtual 275	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1238: iload 4
    //   1240: iconst_2
    //   1241: if_icmpge +274 -> 1515
    //   1244: iload 5
    //   1246: ifeq +76 -> 1322
    //   1249: aload_1
    //   1250: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1253: invokevirtual 1016	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreDexoptRetryNum	()I
    //   1256: istore 4
    //   1258: iload 4
    //   1260: bipush 10
    //   1262: if_icmple +49 -> 1311
    //   1265: aload_1
    //   1266: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1269: sipush 208
    //   1272: ldc_w 1018
    //   1275: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1278: aload_0
    //   1279: aload_1
    //   1280: invokespecial 992	com/tencent/smtt/sdk/TbsInstaller:clearNewTbsCore	(Landroid/content/Context;)V
    //   1283: iconst_0
    //   1284: invokestatic 519	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1287: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1290: invokeinterface 459 1 0
    //   1295: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1298: invokeinterface 459 1 0
    //   1303: aload 17
    //   1305: aload 16
    //   1307: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1310: return
    //   1311: aload_1
    //   1312: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1315: iload 4
    //   1317: iconst_1
    //   1318: iadd
    //   1319: invokevirtual 268	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreDexoptRetryNum	(I)V
    //   1322: aload_0
    //   1323: aload_1
    //   1324: invokespecial 1020	com/tencent/smtt/sdk/TbsInstaller:doTbsCoreDexOpt	(Landroid/content/Context;)Z
    //   1327: istore 13
    //   1329: iload 13
    //   1331: ifne +27 -> 1358
    //   1334: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1337: invokeinterface 459 1 0
    //   1342: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1345: invokeinterface 459 1 0
    //   1350: aload 17
    //   1352: aload 16
    //   1354: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1357: return
    //   1358: aload_1
    //   1359: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1362: iload 6
    //   1364: iconst_2
    //   1365: invokevirtual 275	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1368: ldc 116
    //   1370: ldc_w 1022
    //   1373: iconst_1
    //   1374: invokestatic 479	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1377: ldc 116
    //   1379: new 347	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1386: ldc_w 1024
    //   1389: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: iload_3
    //   1393: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1402: getstatic 412	android/os/Build$VERSION:SDK_INT	I
    //   1405: bipush 11
    //   1407: if_icmplt +132 -> 1539
    //   1410: aload_1
    //   1411: ldc_w 414
    //   1414: iconst_4
    //   1415: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1418: astore 14
    //   1420: aload 14
    //   1422: invokeinterface 624 1 0
    //   1427: astore 14
    //   1429: aload 14
    //   1431: ldc_w 626
    //   1434: iconst_0
    //   1435: invokeinterface 632 3 0
    //   1440: pop
    //   1441: aload 14
    //   1443: ldc_w 634
    //   1446: iconst_0
    //   1447: invokeinterface 632 3 0
    //   1452: pop
    //   1453: aload 14
    //   1455: ldc_w 636
    //   1458: iload_3
    //   1459: invokeinterface 632 3 0
    //   1464: pop
    //   1465: aload 14
    //   1467: invokeinterface 639 1 0
    //   1472: pop
    //   1473: iload_3
    //   1474: ldc_w 659
    //   1477: if_icmpne +10 -> 1487
    //   1480: aload_0
    //   1481: iload_3
    //   1482: aload_2
    //   1483: aload_1
    //   1484: invokespecial 1026	com/tencent/smtt/sdk/TbsInstaller:finishLocalTbsInstall	(ILjava/lang/String;Landroid/content/Context;)V
    //   1487: aload_1
    //   1488: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1491: astore_2
    //   1492: aload_1
    //   1493: invokestatic 264	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1496: invokevirtual 1029	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreIncrUpdateStatus	()I
    //   1499: iconst_1
    //   1500: if_icmpne +86 -> 1586
    //   1503: sipush 221
    //   1506: istore_3
    //   1507: aload_2
    //   1508: iload_3
    //   1509: ldc_w 618
    //   1512: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1515: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1518: invokeinterface 459 1 0
    //   1523: getstatic 184	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1526: invokeinterface 459 1 0
    //   1531: aload 17
    //   1533: aload 16
    //   1535: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1538: return
    //   1539: aload_1
    //   1540: ldc_w 414
    //   1543: iconst_0
    //   1544: invokevirtual 418	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1547: astore 14
    //   1549: goto -129 -> 1420
    //   1552: astore 14
    //   1554: ldc 116
    //   1556: new 347	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   1563: ldc_w 1031
    //   1566: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload 14
    //   1571: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1574: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1583: goto -110 -> 1473
    //   1586: sipush 200
    //   1589: istore_3
    //   1590: goto -83 -> 1507
    //   1593: aload 17
    //   1595: aload 16
    //   1597: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1600: return
    //   1601: astore 15
    //   1603: goto -1290 -> 313
    //   1606: iload 4
    //   1608: ifle -931 -> 677
    //   1611: iload_3
    //   1612: iload 4
    //   1614: if_icmple -937 -> 677
    //   1617: goto -945 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1620	0	this	TbsInstaller
    //   0	1620	1	paramContext	Context
    //   0	1620	2	paramString	String
    //   0	1620	3	paramInt	int
    //   570	1045	4	i	int
    //   579	666	5	j	int
    //   678	685	6	k	int
    //   687	237	7	m	int
    //   694	227	8	n	int
    //   395	29	9	l1	long
    //   401	37	11	l2	long
    //   522	808	13	bool	boolean
    //   172	162	14	localObject1	Object
    //   470	3	14	localSecurityException1	java.lang.SecurityException
    //   1004	544	14	localObject2	Object
    //   1552	18	14	localThrowable	Throwable
    //   277	48	15	str1	String
    //   450	3	15	localSecurityException2	java.lang.SecurityException
    //   460	3	15	localSecurityException3	java.lang.SecurityException
    //   1000	25	15	str2	String
    //   1601	1	15	localException	Exception
    //   257	1339	16	localObject3	Object
    //   507	1087	17	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   268	279	450	java/lang/SecurityException
    //   313	324	460	java/lang/SecurityException
    //   344	357	470	java/lang/SecurityException
    //   563	658	962	finally
    //   672	677	962	finally
    //   680	748	962	finally
    //   762	771	962	finally
    //   775	801	962	finally
    //   810	823	962	finally
    //   828	837	962	finally
    //   844	866	962	finally
    //   941	955	962	finally
    //   988	999	962	finally
    //   1011	1020	962	finally
    //   1029	1046	962	finally
    //   1070	1105	962	finally
    //   1110	1127	962	finally
    //   1151	1204	962	finally
    //   1228	1238	962	finally
    //   1249	1258	962	finally
    //   1265	1287	962	finally
    //   1311	1322	962	finally
    //   1322	1329	962	finally
    //   1358	1420	962	finally
    //   1420	1473	962	finally
    //   1480	1487	962	finally
    //   1487	1503	962	finally
    //   1507	1515	962	finally
    //   1539	1549	962	finally
    //   1554	1583	962	finally
    //   1420	1473	1552	java/lang/Throwable
    //   307	313	1601	java/lang/Exception
  }
  
  private boolean isHostAppInstalled(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private boolean isPrepareTbsCore(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
    if ((paramContext == null) || (!paramContext.exists())) {}
    do
    {
      return false;
      paramContext = new File(paramContext, "tbs.conf");
    } while ((paramContext == null) || (!paramContext.exists()));
    return true;
  }
  
  private void renameTbsCoreCopyDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile = getTmpTbsCoreCopyDir(paramContext);
    paramContext = getTbsCoreShareDir(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  private void renameTbsCoreShareDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile = getTmpTbsCoreUnzipDir(paramContext);
    paramContext = getTbsCoreShareDir(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  static FileLock tryFileLock(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramFileOutputStream.getChannel().tryLock();
        boolean bool = paramContext.isValid();
        if (bool) {}
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  private boolean unzipTbsApk(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: ldc 116
    //   2: ldc_w 1059
    //   5: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: invokestatic 1062	com/tencent/smtt/utils/FileUtil:isFileValid	(Ljava/io/File;)Z
    //   12: ifne +18 -> 30
    //   15: aload_1
    //   16: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   19: sipush 204
    //   22: ldc_w 1064
    //   25: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: new 328	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: ldc 138
    //   37: iconst_0
    //   38: invokevirtual 334	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   41: ldc 156
    //   43: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 7
    //   48: aload 7
    //   50: ifnull +16 -> 66
    //   53: aload 7
    //   55: invokevirtual 341	java/io/File:exists	()Z
    //   58: ifeq +8 -> 66
    //   61: aload 7
    //   63: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 294	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   71: astore 7
    //   73: aload 7
    //   75: ifnonnull +52 -> 127
    //   78: aload_1
    //   79: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   82: sipush 205
    //   85: ldc_w 1068
    //   88: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: astore 7
    //   95: ldc 116
    //   97: new 347	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 1070
    //   107: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 7
    //   112: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 311	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: goto -58 -> 66
    //   127: iconst_0
    //   128: istore 5
    //   130: iconst_0
    //   131: istore 4
    //   133: aload 7
    //   135: invokestatic 1073	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   138: pop
    //   139: aload_2
    //   140: aload 7
    //   142: invokestatic 1076	com/tencent/smtt/utils/FileUtil:copyTbsFilesIfNeeded	(Ljava/io/File;Ljava/io/File;)Z
    //   145: istore 6
    //   147: iload 6
    //   149: ifne +38 -> 187
    //   152: aload 7
    //   154: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   157: ldc 116
    //   159: new 347	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1078
    //   169: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 7
    //   174: invokevirtual 341	java/io/File:exists	()Z
    //   177: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   186: pop
    //   187: iconst_0
    //   188: ifeq +43 -> 231
    //   191: aload 7
    //   193: ifnull +38 -> 231
    //   196: aload 7
    //   198: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   201: ldc 116
    //   203: new 347	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 1083
    //   213: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 7
    //   218: invokevirtual 341	java/io/File:exists	()Z
    //   221: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   224: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: ldc 116
    //   233: ldc_w 1085
    //   236: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: iload 6
    //   241: ireturn
    //   242: astore_2
    //   243: aload_1
    //   244: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   247: sipush 206
    //   250: aload_2
    //   251: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   257: iload 4
    //   259: istore_3
    //   260: aload 7
    //   262: ifnull +20 -> 282
    //   265: aload 7
    //   267: invokevirtual 341	java/io/File:exists	()Z
    //   270: istore 6
    //   272: iload 4
    //   274: istore_3
    //   275: iload 6
    //   277: ifeq +5 -> 282
    //   280: iconst_1
    //   281: istore_3
    //   282: iload_3
    //   283: ifeq +43 -> 326
    //   286: aload 7
    //   288: ifnull +38 -> 326
    //   291: aload 7
    //   293: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   296: ldc 116
    //   298: new 347	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 1083
    //   308: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 7
    //   313: invokevirtual 341	java/io/File:exists	()Z
    //   316: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   319: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   325: pop
    //   326: ldc 116
    //   328: ldc_w 1085
    //   331: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: iconst_0
    //   335: ireturn
    //   336: astore_2
    //   337: aload_1
    //   338: invokestatic 499	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   341: sipush 207
    //   344: aload_2
    //   345: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   348: invokevirtual 510	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   351: iload 5
    //   353: istore_3
    //   354: aload 7
    //   356: ifnull +20 -> 376
    //   359: aload 7
    //   361: invokevirtual 341	java/io/File:exists	()Z
    //   364: istore 6
    //   366: iload 5
    //   368: istore_3
    //   369: iload 6
    //   371: ifeq +5 -> 376
    //   374: iconst_1
    //   375: istore_3
    //   376: iload_3
    //   377: ifeq +43 -> 420
    //   380: aload 7
    //   382: ifnull +38 -> 420
    //   385: aload 7
    //   387: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   390: ldc 116
    //   392: new 347	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 1083
    //   402: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 7
    //   407: invokevirtual 341	java/io/File:exists	()Z
    //   410: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   413: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   419: pop
    //   420: ldc 116
    //   422: ldc_w 1085
    //   425: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: iconst_0
    //   429: ireturn
    //   430: astore_1
    //   431: iconst_0
    //   432: ifeq +43 -> 475
    //   435: aload 7
    //   437: ifnull +38 -> 475
    //   440: aload 7
    //   442: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   445: ldc 116
    //   447: new 347	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 1083
    //   457: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 7
    //   462: invokevirtual 341	java/io/File:exists	()Z
    //   465: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   468: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   474: pop
    //   475: ldc 116
    //   477: ldc_w 1085
    //   480: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload_1
    //   484: athrow
    //   485: astore_2
    //   486: ldc 116
    //   488: new 347	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 1088
    //   498: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_2
    //   502: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   505: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   514: pop
    //   515: goto -40 -> 475
    //   518: astore_1
    //   519: ldc 116
    //   521: new 347	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 1088
    //   531: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   538: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   547: pop
    //   548: goto -222 -> 326
    //   551: astore_1
    //   552: ldc 116
    //   554: new 347	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1088
    //   564: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   571: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   580: pop
    //   581: goto -161 -> 420
    //   584: astore_1
    //   585: ldc 116
    //   587: new 347	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   594: ldc_w 1088
    //   597: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_1
    //   601: invokestatic 650	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   604: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   613: pop
    //   614: goto -383 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	TbsInstaller
    //   0	617	1	paramContext	Context
    //   0	617	2	paramFile	File
    //   259	118	3	i	int
    //   131	142	4	j	int
    //   128	239	5	k	int
    //   145	225	6	bool	boolean
    //   46	28	7	localFile	File
    //   93	368	7	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   30	48	93	java/lang/Throwable
    //   53	66	93	java/lang/Throwable
    //   133	147	242	java/io/IOException
    //   152	187	242	java/io/IOException
    //   133	147	336	java/lang/Exception
    //   152	187	336	java/lang/Exception
    //   133	147	430	finally
    //   152	187	430	finally
    //   243	257	430	finally
    //   265	272	430	finally
    //   337	351	430	finally
    //   359	366	430	finally
    //   440	475	485	java/lang/Throwable
    //   291	326	518	java/lang/Throwable
    //   385	420	551	java/lang/Throwable
    //   196	231	584	java/lang/Throwable
  }
  
  private boolean vertificateApp(Context paramContext)
  {
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      if (paramContext.getPackageName().equals("com.tencent.mtt"))
      {
        if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          break label163;
        }
        return false;
      }
      if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        if (localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
          break label163;
        }
      }
      else
      {
        if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
        {
          if (localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
            break label163;
          }
          return false;
        }
        if (paramContext.getPackageName().equals("com.tencent.x5sdk.demo"))
        {
          if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            break label163;
          }
          return false;
        }
        if (!paramContext.getPackageName().equals("com.qzone")) {
          break label163;
        }
        boolean bool = localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677");
        if (bool) {
          break label163;
        }
        return false;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    }
    return false;
    label163:
    return true;
  }
  
  void continueInstallTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    Object localObject = getLockFos(paramContext);
    if (localObject == null) {}
    int i;
    int k;
    do
    {
      FileLock localFileLock;
      do
      {
        return;
        localFileLock = tryFileLock(paramContext, (FileOutputStream)localObject);
      } while (localFileLock == null);
      int j = -1;
      int m = 0;
      String str = null;
      i = -1;
      k = 0;
      if (mTbsRenameLock.tryLock()) {}
      try
      {
        j = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
        m = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallVer();
        str = TbsCoreVerManager.getInstance(paramContext).getTbsApkPath();
        i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyStatus();
        k = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyVer();
        mTbsRenameLock.unlock();
        freeFileLock(localFileLock, (FileOutputStream)localObject);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + j);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + m);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + k);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          installTbsCoreForThirdPartyApp(paramContext, TbsShareManager.getAvailableTbsCoreVersion(paramContext));
          return;
        }
      }
      finally
      {
        mTbsRenameLock.unlock();
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("operation", 10001);
      installLocalTesCoreEx(paramContext, (Bundle)localObject);
      if ((j > -1) && (j < 2)) {
        installTbsCore(paramContext, str, m);
      }
    } while (i != 0);
    installLocalTbsCore(paramContext, k);
  }
  
  /* Error */
  int getTbsCoreInstalledVer(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 437	com/tencent/smtt/sdk/TbsInstaller:getLockFos	(Landroid/content/Context;)Ljava/io/FileOutputStream;
    //   4: astore 8
    //   6: aload 8
    //   8: ifnonnull +5 -> 13
    //   11: iconst_m1
    //   12: ireturn
    //   13: aload_1
    //   14: aload 8
    //   16: invokestatic 441	com/tencent/smtt/sdk/TbsInstaller:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   19: astore 7
    //   21: aload 7
    //   23: ifnull -12 -> 11
    //   26: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 446 1 0
    //   34: istore_3
    //   35: ldc 116
    //   37: new 347	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 1142
    //   47: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload_3
    //   51: invokevirtual 599	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: iload_3
    //   61: ifeq +282 -> 343
    //   64: aconst_null
    //   65: astore 6
    //   67: aconst_null
    //   68: astore 5
    //   70: aload 6
    //   72: astore 4
    //   74: new 328	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   83: ldc 119
    //   85: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +16 -> 106
    //   93: aload 6
    //   95: astore 4
    //   97: aload_1
    //   98: invokevirtual 341	java/io/File:exists	()Z
    //   101: istore_3
    //   102: iload_3
    //   103: ifne +32 -> 135
    //   106: iconst_0
    //   107: ifeq +11 -> 118
    //   110: new 807	java/lang/NullPointerException
    //   113: dup
    //   114: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   117: athrow
    //   118: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   121: invokeinterface 459 1 0
    //   126: aload 7
    //   128: aload 8
    //   130: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 6
    //   137: astore 4
    //   139: new 548	java/util/Properties
    //   142: dup
    //   143: invokespecial 549	java/util/Properties:<init>	()V
    //   146: astore 9
    //   148: aload 6
    //   150: astore 4
    //   152: new 551	java/io/FileInputStream
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: astore_1
    //   161: aload 9
    //   163: aload_1
    //   164: invokevirtual 556	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   167: aload_1
    //   168: invokevirtual 557	java/io/FileInputStream:close	()V
    //   171: aload 9
    //   173: ldc 128
    //   175: invokevirtual 811	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 4
    //   180: aload 4
    //   182: ifnonnull +28 -> 210
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 557	java/io/FileInputStream:close	()V
    //   193: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   196: invokeinterface 459 1 0
    //   201: aload 7
    //   203: aload 8
    //   205: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   208: iconst_0
    //   209: ireturn
    //   210: aload_0
    //   211: aload 4
    //   213: invokestatic 1148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   216: putfield 224	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	I
    //   219: aload_0
    //   220: getfield 224	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	I
    //   223: istore_2
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 557	java/io/FileInputStream:close	()V
    //   232: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   235: invokeinterface 459 1 0
    //   240: aload 7
    //   242: aload 8
    //   244: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   247: iload_2
    //   248: ireturn
    //   249: astore 4
    //   251: aload 5
    //   253: astore_1
    //   254: aload 4
    //   256: astore 5
    //   258: aload_1
    //   259: astore 4
    //   261: ldc 116
    //   263: new 347	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 1150
    //   273: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 5
    //   278: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   281: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 557	java/io/FileInputStream:close	()V
    //   298: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   301: invokeinterface 459 1 0
    //   306: aload 7
    //   308: aload 8
    //   310: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: aload 4
    //   318: ifnull +8 -> 326
    //   321: aload 4
    //   323: invokevirtual 557	java/io/FileInputStream:close	()V
    //   326: getstatic 182	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   329: invokeinterface 459 1 0
    //   334: aload 7
    //   336: aload 8
    //   338: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   341: aload_1
    //   342: athrow
    //   343: aload 7
    //   345: aload 8
    //   347: invokestatic 463	com/tencent/smtt/sdk/TbsInstaller:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore 4
    //   354: ldc 116
    //   356: new 347	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 1152
    //   366: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 4
    //   371: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   374: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto -57 -> 326
    //   386: astore_1
    //   387: ldc 116
    //   389: new 347	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 1152
    //   399: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   406: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: goto -117 -> 298
    //   418: astore_1
    //   419: ldc 116
    //   421: new 347	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 1152
    //   431: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   438: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: goto -329 -> 118
    //   450: astore_1
    //   451: ldc 116
    //   453: new 347	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 1152
    //   463: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_1
    //   467: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   470: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: goto -286 -> 193
    //   482: astore_1
    //   483: ldc 116
    //   485: new 347	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 1152
    //   495: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   502: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: goto -279 -> 232
    //   514: astore 5
    //   516: aload_1
    //   517: astore 4
    //   519: aload 5
    //   521: astore_1
    //   522: goto -206 -> 316
    //   525: astore 5
    //   527: goto -269 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	TbsInstaller
    //   0	530	1	paramContext	Context
    //   223	25	2	i	int
    //   34	69	3	bool	boolean
    //   72	140	4	localObject1	Object
    //   249	6	4	localException1	Exception
    //   259	63	4	localContext1	Context
    //   352	18	4	localIOException	IOException
    //   517	1	4	localContext2	Context
    //   68	209	5	localObject2	Object
    //   514	6	5	localObject3	Object
    //   525	1	5	localException2	Exception
    //   65	84	6	localObject4	Object
    //   19	325	7	localFileLock	FileLock
    //   4	342	8	localFileOutputStream	FileOutputStream
    //   146	26	9	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   74	89	249	java/lang/Exception
    //   97	102	249	java/lang/Exception
    //   139	148	249	java/lang/Exception
    //   152	161	249	java/lang/Exception
    //   74	89	315	finally
    //   97	102	315	finally
    //   139	148	315	finally
    //   152	161	315	finally
    //   261	290	315	finally
    //   321	326	352	java/io/IOException
    //   294	298	386	java/io/IOException
    //   110	118	418	java/io/IOException
    //   189	193	450	java/io/IOException
    //   228	232	482	java/io/IOException
    //   161	180	514	finally
    //   210	224	514	finally
    //   161	180	525	java/lang/Exception
    //   210	224	525	java/lang/Exception
  }
  
  /* Error */
  int getTbsCoreInstalledVerInNolock(Context paramContext)
  {
    // Byte code:
    //   0: ldc 116
    //   2: ldc_w 1154
    //   5: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 6
    //   16: astore 4
    //   18: new 328	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   27: ldc 119
    //   29: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +16 -> 50
    //   37: aload 6
    //   39: astore 4
    //   41: aload_1
    //   42: invokevirtual 341	java/io/File:exists	()Z
    //   45: istore_3
    //   46: iload_3
    //   47: ifne +17 -> 64
    //   50: iconst_0
    //   51: ifeq +11 -> 62
    //   54: new 807	java/lang/NullPointerException
    //   57: dup
    //   58: invokespecial 808	java/lang/NullPointerException:<init>	()V
    //   61: athrow
    //   62: iconst_0
    //   63: ireturn
    //   64: aload 6
    //   66: astore 4
    //   68: new 548	java/util/Properties
    //   71: dup
    //   72: invokespecial 549	java/util/Properties:<init>	()V
    //   75: astore 7
    //   77: aload 6
    //   79: astore 4
    //   81: new 551	java/io/FileInputStream
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: aload 7
    //   92: aload_1
    //   93: invokevirtual 556	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   96: aload_1
    //   97: invokevirtual 557	java/io/FileInputStream:close	()V
    //   100: aload 7
    //   102: ldc 128
    //   104: invokevirtual 811	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 4
    //   109: aload 4
    //   111: ifnonnull +13 -> 124
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 557	java/io/FileInputStream:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload 4
    //   126: invokestatic 1148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   129: istore_2
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 557	java/io/FileInputStream:close	()V
    //   138: iload_2
    //   139: ireturn
    //   140: astore 4
    //   142: aload 5
    //   144: astore_1
    //   145: aload 4
    //   147: astore 5
    //   149: aload_1
    //   150: astore 4
    //   152: ldc 116
    //   154: new 347	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 1156
    //   164: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   172: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_1
    //   182: ifnull -120 -> 62
    //   185: aload_1
    //   186: invokevirtual 557	java/io/FileInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: new 347	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 1158
    //   202: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   209: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore_1
    //   216: ldc 116
    //   218: aload_1
    //   219: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 557	java/io/FileInputStream:close	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore 4
    //   239: ldc 116
    //   241: new 347	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 1158
    //   251: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 4
    //   256: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   259: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -33 -> 235
    //   271: astore_1
    //   272: new 347	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 1158
    //   282: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   289: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore_1
    //   296: goto -80 -> 216
    //   299: astore_1
    //   300: ldc 116
    //   302: new 347	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 1158
    //   312: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   319: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: goto -206 -> 122
    //   331: astore_1
    //   332: ldc 116
    //   334: new 347	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 1158
    //   344: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_1
    //   348: invokevirtual 1086	java/io/IOException:toString	()Ljava/lang/String;
    //   351: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -222 -> 138
    //   363: astore 5
    //   365: aload_1
    //   366: astore 4
    //   368: aload 5
    //   370: astore_1
    //   371: goto -146 -> 225
    //   374: astore 5
    //   376: goto -227 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	TbsInstaller
    //   0	379	1	paramContext	Context
    //   129	10	2	i	int
    //   45	2	3	bool	boolean
    //   16	109	4	localObject1	Object
    //   140	6	4	localException1	Exception
    //   150	81	4	localContext1	Context
    //   237	18	4	localIOException	IOException
    //   366	1	4	localContext2	Context
    //   12	156	5	localObject2	Object
    //   363	6	5	localObject3	Object
    //   374	1	5	localException2	Exception
    //   9	69	6	localObject4	Object
    //   75	26	7	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   18	33	140	java/lang/Exception
    //   41	46	140	java/lang/Exception
    //   68	77	140	java/lang/Exception
    //   81	90	140	java/lang/Exception
    //   185	189	191	java/io/IOException
    //   18	33	224	finally
    //   41	46	224	finally
    //   68	77	224	finally
    //   81	90	224	finally
    //   152	181	224	finally
    //   230	235	237	java/io/IOException
    //   54	62	271	java/io/IOException
    //   118	122	299	java/io/IOException
    //   134	138	331	java/io/IOException
    //   90	109	363	finally
    //   124	130	363	finally
    //   90	109	374	java/lang/Exception
    //   124	130	374	java/lang/Exception
  }
  
  File getTbsCoreShareDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "core_share");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  int getTbsCoreVerFromApk(Context paramContext, String paramString)
  {
    int i = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      i = paramContext.versionCode;
    }
    return i;
  }
  
  File getTbsShareDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "share");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  File getTmpTbsCoreCopyDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "core_copy_tmp");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  File getTmpTbsCoreUnzipDir(Context paramContext)
  {
    File localFile = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if (localFile != null)
    {
      paramContext = localFile;
      if (!localFile.isDirectory())
      {
        paramContext = localFile;
        if (!localFile.mkdir()) {
          paramContext = null;
        }
      }
      return paramContext;
    }
    return null;
  }
  
  boolean installLocalTbsCore(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = getTbsCoreHostContext(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      mTbsInstallerHandler.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  void installLocalTbsCoreExInThread(Context paramContext, Bundle paramBundle)
  {
    if (isTbsLocalInstalled(paramContext)) {}
    Object localObject1;
    FileOutputStream localFileOutputStream;
    FileLock localFileLock;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
          } while ((paramBundle == null) || (paramContext == null));
          localObject1 = paramBundle.getString("old_apk_location");
          if ((localObject1 != null) && (((String)localObject1).length() > 0) && (TbsUtils.getROMAvailableSize() < 2L * TbsUtils.getApkSize((String)localObject1)))
          {
            long l2 = TbsUtils.getROMAvailableSize();
            long l1 = TbsUtils.getApkSize((String)localObject1);
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + l2 + ",minReqRom=" + 2L * l1);
            return;
          }
        } while (TbsShareManager.isThirdPartyApp(paramContext));
        localFileOutputStream = getLockFos(paramContext);
      } while (localFileOutputStream == null);
      localFileLock = tryFileLock(paramContext, localFileOutputStream);
    } while (localFileLock == null);
    boolean bool = mTbsInstallLock.tryLock();
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + bool);
    Object localObject5;
    Object localObject6;
    Object localObject4;
    int j;
    Object localObject2;
    int k;
    int i;
    if (bool)
    {
      localObject5 = null;
      localObject6 = null;
      localObject4 = null;
      j = 2;
      localObject2 = localObject5;
      k = j;
      localObject1 = localObject6;
      try
      {
        if (getTbsCoreInstalledVerInNolock(paramContext) > 0)
        {
          localObject2 = localObject5;
          k = j;
          localObject1 = localObject6;
          i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus();
          if (i != 1) {
            break label310;
          }
        }
        mTbsInstallLock.unlock();
        freeFileLock(localFileLock, localFileOutputStream);
        if (2 != 0) {
          break label924;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
        throw new NullPointerException();
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          label310:
          k = j;
          localObject1 = localObject2;
          paramBundle.printStackTrace();
          k = 1;
          localObject1 = localObject2;
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(218, paramBundle.toString());
          mTbsInstallLock.unlock();
          freeFileLock(localFileLock, localFileOutputStream);
          if (1 != 0) {
            break;
          }
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
          paramBundle = ((Bundle)localObject2).getString("apk_path");
          TbsApkDownloader.backupTbsApk(new File(paramBundle), paramContext);
          i = ((Bundle)localObject2).getInt("tbs_core_ver");
        }
      }
      finally
      {
        mTbsInstallLock.unlock();
        freeFileLock(localFileLock, localFileOutputStream);
        if (k != 0) {
          break label791;
        }
      }
      installTbsCore(paramContext, paramBundle, i);
      return;
      localObject2 = localObject5;
      k = j;
      localObject1 = localObject6;
      i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if (i == 1) {
        break label1026;
      }
      if (i == 2) {
        break label1026;
      }
    }
    for (;;)
    {
      label352:
      i = j;
      Object localObject3 = localObject4;
      if (k == 0)
      {
        localObject2 = localObject5;
        k = j;
        localObject1 = localObject6;
        File localFile = getTbsCorePrivateDir(paramContext);
        i = j;
        localObject3 = localObject4;
        if (localFile != null)
        {
          localObject2 = localObject5;
          k = j;
          localObject1 = localObject6;
          localFile = new File(localFile, "x5.tbs");
          i = j;
          localObject3 = localObject4;
          if (localFile != null)
          {
            i = j;
            localObject3 = localObject4;
            localObject2 = localObject5;
            k = j;
            localObject1 = localObject6;
            if (localFile.exists())
            {
              localObject2 = localObject5;
              k = j;
              localObject1 = localObject6;
              paramBundle = QbSdk.incrUpdate(paramContext, paramBundle);
              if (paramBundle != null) {
                break label567;
              }
              i = 1;
            }
          }
        }
      }
      for (localObject3 = paramBundle;; localObject3 = paramBundle)
      {
        mTbsInstallLock.unlock();
        freeFileLock(localFileLock, localFileOutputStream);
        if (i != 0) {
          break label975;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
        paramBundle = ((Bundle)localObject3).getString("apk_path");
        TbsApkDownloader.backupTbsApk(new File(paramBundle), paramContext);
        i = ((Bundle)localObject3).getInt("tbs_core_ver");
        break;
        k = 0;
        break label352;
        label567:
        localObject2 = paramBundle;
        k = j;
        localObject1 = paramBundle;
        i = paramBundle.getInt("patch_result");
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
      localObject2 = ((Bundle)localObject1).getString("apk_path");
      TbsApkDownloader.backupTbsApk(new File((String)localObject2), paramContext);
      installTbsCore(paramContext, (String)localObject2, ((Bundle)localObject1).getInt("tbs_core_ver"));
      for (;;)
      {
        throw paramBundle;
        freeFileLock(localFileLock, localFileOutputStream);
        return;
        label791:
        if (k == 2)
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
        }
        else
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
          TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
          TbsDownloadConfig.getInstance(paramContext).commit();
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(217, "incrUpdate fail!");
        }
      }
      if (1 == 2)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
        return;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
      TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      TbsDownloadConfig.getInstance(paramContext).commit();
      paramContext = TbsLogReport.getInstance(paramContext);
      for (;;)
      {
        paramContext.setInstallErrorCode(217, "incrUpdate fail!");
        return;
        label924:
        if (2 == 2) {
          break;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
        TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
        TbsDownloadConfig.getInstance(paramContext).commit();
        paramContext = TbsLogReport.getInstance(paramContext);
        continue;
        label975:
        if (i == 2) {
          break;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
        TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
        TbsDownloadConfig.getInstance(paramContext).commit();
        paramContext = TbsLogReport.getInstance(paramContext);
      }
      label1026:
      k = 1;
    }
  }
  
  void installLocalTesCoreEx(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCore(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCoreForThirdPartyApp(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int i;
    do
    {
      do
      {
        return;
        i = getTbsCoreInstalledVerInNolock(paramContext);
      } while (i == paramInt);
      Context localContext = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
      if (localContext != null)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        TbsLog.e("TbsInstaller", "installTbsCoreForThirdPartyApp forceSysWebViewInner #1");
        QbSdk.forceSysWebViewInner();
        quickDexOptForThirdPartyApp(paramContext, localContext);
        return;
      }
    } while (i > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    TbsLog.e("TbsInstaller", "installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
    QbSdk.forceSysWebViewInner();
  }
  
  void installTbsCoreIfNeeded(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.mIsSysWebViewForcedByOuter) {}
    label99:
    label103:
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i;
        if (!isPrepareTbsCore(paramContext, "core_copy_tmp"))
        {
          i = 0;
          if (isPrepareTbsCore(paramContext, "core_unzip_tmp")) {
            break label99;
          }
        }
        for (int j = 0;; j = 1)
        {
          if (((i == 0) || (!enableTbsCoreFromCopy(paramContext, paramBoolean))) && ((j == 0) || (!enableTbsCoreFromUnzip(paramContext, paramBoolean)))) {
            break label103;
          }
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, SUCCESS!!", true);
          return;
          i = 1;
          break;
        }
      }
    }
  }
  
  boolean isTbsCoreLegal(Context paramContext, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      bool3 = TbsShareManager.isThirdPartyApp(paramContext);
      if (bool3) {
        if (TbsShareManager.isShareTbsCoreAvailable(paramContext)) {
          localFile = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
        }
      }
    }
    catch (Throwable paramContext)
    {
      boolean bool3;
      File localFile;
      Long[][] arrayOfLong1;
      int j;
      TbsLog.e("loaderror", "ISTBSCORELEGAL exception getMessage is " + paramContext.getMessage());
      TbsLog.e("loaderror", "ISTBSCORELEGAL exception getCause is " + paramContext.getCause());
      bool1 = false;
    }
    try
    {
      bool1 = localFile.getAbsolutePath().contains("com.tencent.x5sdk.demo");
      if (!bool1) {
        break label283;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      break label215;
      break label71;
    }
    TbsLog.e("loaderror", "321");
    return false;
    localFile = getTbsCoreShareDir(paramContext);
    label71:
    int i;
    if (localFile != null)
    {
      arrayOfLong1 = WEBCORE_LIB_LENGTH_MAP;
      j = arrayOfLong1.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        Long[] arrayOfLong = arrayOfLong1[i];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label289;
        }
        localFile = new File(localFile, "libmttwebcore.so");
        if ((localFile != null) && (localFile.exists()) && (localFile.length() == arrayOfLong[1].longValue()))
        {
          bool1 = bool2;
        }
        else
        {
          if (!bool3) {
            FileUtil.delete(paramContext.getDir("tbs", 0));
          }
          this.mTbsCoreInstalledVer = 0;
          TbsLog.e("loaderror", "322");
          bool1 = false;
          break label286;
          TbsLog.e("loaderror", "323");
          bool1 = false;
        }
      }
      label215:
      return bool1;
      label283:
      label286:
      label289:
      i += 1;
    }
  }
  
  /* Error */
  boolean isTbsLocalInstalled(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 328	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 490	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   11: ldc 119
    //   13: invokespecial 337	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +11 -> 31
    //   23: aload 4
    //   25: invokevirtual 341	java/io/File:exists	()Z
    //   28: ifne +5 -> 33
    //   31: iconst_0
    //   32: ireturn
    //   33: new 548	java/util/Properties
    //   36: dup
    //   37: invokespecial 549	java/util/Properties:<init>	()V
    //   40: astore 5
    //   42: aconst_null
    //   43: astore_1
    //   44: aconst_null
    //   45: astore 6
    //   47: new 551	java/io/FileInputStream
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 552	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 5
    //   60: aload 4
    //   62: invokevirtual 556	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload 5
    //   67: ldc 141
    //   69: ldc_w 945
    //   72: invokevirtual 588	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 1331	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   78: invokevirtual 1334	java/lang/Boolean:booleanValue	()Z
    //   81: istore_2
    //   82: aload 4
    //   84: ifnull +97 -> 181
    //   87: aload 4
    //   89: invokevirtual 557	java/io/FileInputStream:close	()V
    //   92: iload_2
    //   93: ireturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   99: goto -7 -> 92
    //   102: astore 5
    //   104: aload 6
    //   106: astore 4
    //   108: aload 4
    //   110: astore_1
    //   111: aload 5
    //   113: invokevirtual 773	java/lang/Throwable:printStackTrace	()V
    //   116: iload_3
    //   117: istore_2
    //   118: aload 4
    //   120: ifnull -28 -> 92
    //   123: aload 4
    //   125: invokevirtual 557	java/io/FileInputStream:close	()V
    //   128: iload_3
    //   129: istore_2
    //   130: goto -38 -> 92
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   138: iload_3
    //   139: istore_2
    //   140: goto -48 -> 92
    //   143: astore 4
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 557	java/io/FileInputStream:close	()V
    //   153: aload 4
    //   155: athrow
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   161: goto -8 -> 153
    //   164: astore 5
    //   166: aload 4
    //   168: astore_1
    //   169: aload 5
    //   171: astore 4
    //   173: goto -28 -> 145
    //   176: astore 5
    //   178: goto -70 -> 108
    //   181: goto -89 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	TbsInstaller
    //   0	184	1	paramContext	Context
    //   81	59	2	bool1	boolean
    //   1	138	3	bool2	boolean
    //   16	108	4	localObject1	Object
    //   143	24	4	localObject2	Object
    //   171	1	4	localObject3	Object
    //   40	26	5	localProperties	Properties
    //   102	10	5	localThrowable1	Throwable
    //   164	6	5	localObject4	Object
    //   176	1	5	localThrowable2	Throwable
    //   45	60	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	94	java/io/IOException
    //   47	58	102	java/lang/Throwable
    //   123	128	133	java/io/IOException
    //   47	58	143	finally
    //   111	116	143	finally
    //   149	153	156	java/io/IOException
    //   58	82	164	finally
    //   58	82	176	java/lang/Throwable
  }
  
  /* Error */
  public boolean quickDexOptForThirdPartyApp(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 116
    //   4: ldc_w 1336
    //   7: invokestatic 259	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 220	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   27: new 10	com/tencent/smtt/sdk/TbsInstaller$3
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1339	com/tencent/smtt/sdk/TbsInstaller$3:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1342	com/tencent/smtt/sdk/TbsInstaller$3:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsInstaller
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  boolean tbsFileConfExists(Context paramContext)
  {
    paramContext = new File(getTbsCoreShareDir(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInstaller
 * JD-Core Version:    0.7.0.1
 */