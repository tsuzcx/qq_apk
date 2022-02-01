package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import avwe.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QzoneModuleConst
{
  public static final String QZONE_DECODE_ANIMATED_WEBP_KEY = "animatedWebp";
  public static final String QZONE_DECODE_ANIMATED_WEBP_MD5 = "4c8590a921c2722051416111dfd57122";
  public static final String QZONE_DECODE_ANIMATED_WEBP_MD5_SECONDARY_KEY = "animatedWebpMD5";
  public static final String QZONE_DECODE_ANIMATED_WEBP_SO = "animatedWebp.so";
  public static final String QZONE_DECODE_ANIMATED_WEBP_SO_URL = "https://d3g.qq.com/sngapp/app/update/20190724163607_2917/libanimwebp_jni.so";
  public static final List<String> QZONE_MODULES_NEED_INSTALL;
  public static final List<String> QZONE_MODULES_PREDOWNLOAD;
  public static final List<String> QZONE_MODULES_QBOSS;
  public static final String QZONE_MODULE_ADDITIONAL_BLACK_LIST = "qzone_module_black_list";
  public static final String QZONE_MODULE_ANTISHAKE_SO = "pictureMarkerSo.zip";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR = "vip_tar_engine.jar";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_MD5 = "3c4cd9ff849e9b6576ffa6d8fe60bcaa";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_MD5 = "vip_tar_engine_md5";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_VERSION = "version";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_VERSION_DEFAULT = "3";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO = "libTar.so";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_MD5 = "3a0222c4b9d441a4cf4a3ac620f5dfbc";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_MD5 = "lib_tar_so_md5";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_VERSION = "version";
  public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_VERSION_DEFAULT = "1";
  public static final String QZONE_MODULE_CONFIG_ANTISHAKE_SO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20170410195647_4697/pictureMarkerSo.so";
  public static final String QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_MD5 = "73bf723be02a6b71b17a0d47888c4e04";
  public static final String QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20160803113848_6187/qzoneliveaudio.jar";
  public static final String QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_MD5 = "b11e343a1096d3b6331b32e2b1bada88";
  public static final String QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20171105201346_3221/filterengine.bundle_qzone_7.6.jar";
  public static final String QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_MD5 = "1cdaf8508cc7343f796ef21b5e65c2b6";
  public static final String QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191226133414_2167/res1_yt_facedetect.so";
  public static final String QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_MD5 = "586bcad62ef42fc352676e485dc38d96";
  public static final String QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20180110162244_5632/res1_yt_seg_and_hand.so";
  public static final String QZONE_MODULE_CONFIG_MODULE_CLASS_IDS = "module_class_ids";
  public static final String QZONE_MODULE_CONFIG_MODULE_FILE_LENGTH = "module_file_length";
  public static final String QZONE_MODULE_CONFIG_MODULE_ID = "module_id";
  public static final String QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_IDS_COUNT = "module_class_ids_count";
  public static final String QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_NAME = "module_key_class_name";
  public static final String QZONE_MODULE_CONFIG_MODULE_MAIN_VERSION = "module_main_version";
  public static final String QZONE_MODULE_CONFIG_MODULE_MD5 = "module_md5";
  public static final String QZONE_MODULE_CONFIG_MODULE_URL = "module_url";
  public static final String QZONE_MODULE_CONFIG_MODULE_VERSION = "module_version";
  public static final String QZONE_MODULE_CONFIG_NETWORKED_MODULE = "qzone_networked_modules";
  public static final String QZONE_MODULE_CONFIG_PTU_ALGORITHM_JNI_SO_DEFAULT_MD5 = "3dcc7162dd785eb4bfa4fb6689efd7e9";
  public static final String QZONE_MODULE_CONFIG_PTU_ALGORITHM_JNI_SO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20170117162505_7464/libalgo_rithm_jni.so";
  public static final String QZONE_MODULE_CONFIG_PTU_ALGORITHM_JNI_SO_MD5_SECONDARY_KEY = "libAlgorithmJniSoMD5";
  public static final String QZONE_MODULE_CONFIG_PTU_ALGORITHM_JNI_SO_URL_SECONDARY_KEY = "libAlgorithmJniSoUrl";
  public static final String QZONE_MODULE_CONFIG_PTU_FILTER_ENGINE_JAR_DEFAULT_MD5 = "4d5cfa42acc64e9fadecff38bdde6cbd";
  public static final String QZONE_MODULE_CONFIG_PTU_FILTER_ENGINE_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20170117164907_3213/filterengine.bundle.jar";
  public static final String QZONE_MODULE_CONFIG_PTU_FILTER_ENGINE_JAR_MD5_SECONDARY_KEY = "libFilterEngineJarMD5";
  public static final String QZONE_MODULE_CONFIG_PTU_FILTER_ENGINE_JAR_URL_SECONDARY_KEY = "libFilterEngineJarUrl";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_64_DEFAULT_MD5 = "f12dae831c929686229d1666fffcb012";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_64_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191105145019_6289/libsuperresolution.jar";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_64_MD5_SECONDARY_KEY = "libSuperResolutionJarMD5_64";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_64_URL_SECONDARY_KEY = "libSuperResolutionJarUrl_64";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_DEFAULT_MD5 = "6dc8f2f6f95d50ef6daef91c0f1595ec";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20181204152623_3844/libsuperresolution.jar";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_MD5_SECONDARY_KEY = "libSuperResolutionJarMD5";
  public static final String QZONE_MODULE_CONFIG_SUPER_RESOLUTION_JAR_URL_SECONDARY_KEY = "libSuperResolutionJarUrl";
  public static final String QZONE_MODULE_DISABLE = "qzone_module_disable";
  public static final String QZONE_MODULE_DLNA_DEFAULT_MD5 = "1fa71f228a6daff1fb04f7148f2c95d7";
  public static final String QZONE_MODULE_DLNA_DEFAULT_MD5_SECONDARY_KEY = "cyberClinkJarMD5";
  public static final String QZONE_MODULE_DLNA_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20180824143533_9249/cyber_clink.jar";
  public static final String QZONE_MODULE_DLNA_DEFAULT_URL_SECONDARY_KEY = "cyberClinkUrl";
  public static final String QZONE_MODULE_DLNA_JAR = "cyber_clink_version_2.jar";
  public static final String QZONE_MODULE_KNOWN_BLACK_LIST = "";
  public static final String QZONE_MODULE_LIVE_AUDIO = "qzlive_live_audio.jar";
  public static final String QZONE_MODULE_LIVE_FILTER_BUNDLE = "qzlive_filterbundle.jar";
  public static final String QZONE_MODULE_LIVE_PTU_DM = "qzlive_res1_yt_facedetect.jar";
  public static final String QZONE_MODULE_LIVE_SEG_AND_HAND_DETECT = "qzlive_res1_yt_seg_and_hand.jar";
  public static final String QZONE_MODULE_MAPSDK_LAST_CRASH_COUNT = "qzone_module_mapsdk_last_crash_count";
  public static final String QZONE_MODULE_MAP_SDK = "qzonemodule_mapsdk.jar";
  public static final int QZONE_MODULE_MAX_CRASH_COUNT = 2;
  private static final String QZONE_MODULE_OSKPLAYER_JAR_CRASH_KEY_WORDS_0 = "Exo2MediaPlayer";
  public static final String QZONE_MODULE_OSK_PLAYER = "osk_exoplayer2_bundle.jar";
  public static final String QZONE_MODULE_OSK_PLAYER_CONFIG_DEFAULT = "https://d3g.qq.com/sngapp/app/update/20170728155227_6686/osk_exoplayer2_bundle.jar|f9d35ec8e90af758354bb174abc12df4";
  public static final String QZONE_MODULE_OSK_PLAYER_CONFIG_SECONDARY_KEY = "libOskPlayerJarConfig";
  public static final String QZONE_MODULE_PIC_BEAUTY_SO = "libandroidndkbeauty.so";
  public static final String QZONE_MODULE_PTU_ALGORITHM_JNI_SO = "libalgo_rithm_jni.so";
  public static final String QZONE_MODULE_PTU_FILTER_ENGINE_JAR = "filterengine.bundle.jar";
  public static final String QZONE_MODULE_SUPER_RESOLUTION_JAR = "libsuperresolution.jar";
  public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5 = "6b5338544a7c9baff2af16413d3d5119";
  public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5_SECONDARY_KEY = "photo_classify_file_md5";
  public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20180329102523_4877/pic_tag_sdk.jar";
  public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL_SECONDARY_KEY = "photo_tag_classify_file";
  public static final String QZONE_MODULE_TAGCLASSIFY_SO = "tag_classify.jar";
  public static final String QZONE_MODULE_TEST_ID = "test_log.dex";
  public static final String QZONE_MODULE_UPLOAD_JAR = "upload.jar";
  private static final String QZONE_MODULE_UPLOAD_JAR_CRASH_KEY_WORDS_0 = "com.tencent.upload";
  public static final String QZONE_MODULE_UPLOAD_JAR_DEFAULT_MD5 = "f0cee072f5851282b04dc809a834dd0d";
  public static final String QZONE_MODULE_UPLOAD_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20200225165213_5410/upload.jar";
  public static final String QZONE_MODULE_UPLOAD_JAR_MD5_SECONDARY_KEY = "libUploadJarMD5";
  public static final String QZONE_MODULE_UPLOAD_JAR_URL_SECONDARY_KEY = "libUploadJarUrl";
  public static final String QZONE_MODULE_UPLOAD_SO = "upload.so";
  public static final String QZONE_MODULE_VIDEO_HEROPLAYER = "lib_heroplayer.jar";
  public static final String QZONE_MODULE_VOICE_SHUOSHUO_ANIMATION = "frameanimation.jar";
  public static final String QZONE_MODULE_XMP_CORE_DEFAULT_MD5 = "a0c5ac44fc2d0e35187f0c1479db48b2";
  public static final String QZONE_MODULE_XMP_CORE_DEFAULT_MD5_SECONDARY_KEY = "XMPcoreJarMD5";
  public static final String QZONE_MODULE_XMP_CORE_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar";
  public static final String QZONE_MODULE_XMP_CORE_DEFAULT_URL_SECONDARY_KEY = "xmpcoreUrl";
  public static final String QZONE_MODULE_XMP_CORE_JAR = "xmpcore.jar";
  private static final String QZONE_MOMULE_CRASH_TAG = "QzoneModuleCrash";
  private static String QZONE_NETWORKED_MODULE_FILE_PATH;
  private static final String TAG = "QzoneModuleConst";
  private static List<String> sCrashKeyWords;
  private static Map<String, String> sKeyWords2IdMap;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    QZONE_MODULES_QBOSS = Collections.unmodifiableList(localArrayList);
    localArrayList.add("upload.jar");
    QZONE_MODULES_PREDOWNLOAD = Collections.unmodifiableList(new ArrayList());
    QZONE_MODULES_NEED_INSTALL = Collections.unmodifiableList(new ArrayList());
    QZONE_NETWORKED_MODULE_FILE_PATH = "qzone_networked_module";
    sCrashKeyWords = new ArrayList();
    sKeyWords2IdMap = new HashMap();
    sCrashKeyWords.add("com.tencent.upload");
    sCrashKeyWords.add("Exo2MediaPlayer");
    sKeyWords2IdMap.put("com.tencent.upload", "upload.jar");
    sKeyWords2IdMap.put("Exo2MediaPlayer", "osk_exoplayer2_bundle.jar");
  }
  
  public static void clearLastCrashCount(String paramString)
  {
    if ("qzonemodule_mapsdk.jar".equals(paramString))
    {
      LocalMultiProcConfig.putInt("Qz_setting", getSpKeyById(paramString), 0);
      QLog.e("QzoneModuleCrash", 1, "clear last crash count");
    }
  }
  
  public static String getModuleSavePath(Context paramContext, avwe.a parama)
  {
    return new File(paramContext.getApplicationContext().getDir(QZONE_NETWORKED_MODULE_FILE_PATH, 0), parama.mMD5.toLowerCase() + "_" + parama.mModuleId).getAbsolutePath();
  }
  
  private static String getSpKeyById(String paramString)
  {
    return "qzone_module_" + paramString + "_last_crash_count";
  }
  
  /* Error */
  public static boolean isLoadAccordingToCrashCount(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 360
    //   8: aload_0
    //   9: invokestatic 364	cooperation/qzone/networkedmodule/QzoneModuleConst:getSpKeyById	(Ljava/lang/String;)Ljava/lang/String;
    //   12: iconst_0
    //   13: invokestatic 432	cooperation/qzone/LocalMultiProcConfig:getInt	(Ljava/lang/String;Ljava/lang/String;I)I
    //   16: istore_1
    //   17: ldc_w 303
    //   20: iconst_1
    //   21: new 394	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 434
    //   31: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: iload_1
    //   45: iconst_2
    //   46: if_icmpne +28 -> 74
    //   49: iload_3
    //   50: istore_2
    //   51: invokestatic 444	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +15 -> 69
    //   57: ldc_w 303
    //   60: iconst_2
    //   61: ldc_w 446
    //   64: invokestatic 449	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iload_3
    //   68: istore_2
    //   69: ldc 2
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -7 -> 69
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   16	31	1	i	int
    //   50	26	2	bool1	boolean
    //   1	67	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	44	79	finally
    //   51	67	79	finally
  }
  
  public static void updateCrashInfo(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneModuleCrash", 1, "errMsg is empty");
      return;
    }
    if ((paramBoolean) && (paramString.contains("nativeResolvePatchClass"))) {
      QLog.e("QzoneModuleCrash", 1, "load2QQClassLoader crash, native crash caused by nativeResolvePatchClass");
    }
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = sCrashKeyWords.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (paramString.contains(str))
        {
          paramString = (String)sKeyWords2IdMap.get(str);
          QLog.e("QzoneModuleCrash", 1, "loaded Module get a crash, module id:" + paramString);
          i = 1;
        }
      }
      while ((i != 0) && (!TextUtils.isEmpty(paramString)))
      {
        i = LocalMultiProcConfig.getInt("Qz_setting", getSpKeyById(paramString), 0);
        if (i >= 2)
        {
          QLog.e("QzoneModuleCrash", 1, "qzone module have crashed " + (i + 1) + " times,so clear qzone module crash count.moduleId:" + paramString);
          LocalMultiProcConfig.putInt("Qz_setting", getSpKeyById(paramString), 0);
          return;
        }
        LocalMultiProcConfig.putInt("Qz_setting", getSpKeyById(paramString), i + 1);
        return;
        paramString = null;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleConst
 * JD-Core Version:    0.7.0.1
 */