package cooperation.qzone.networkedmodule;

import avcc;
import avpq;
import avwe.a;
import avwe.b;
import avwh;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.reflect.Method;
import java.util.HashMap;

public class QzoneModuleRecordFactory
{
  private static final String TAG = "QzoneModuleRecordFactory";
  private static volatile QzoneModuleRecordFactory sFactory;
  private HashMap<String, a> mMethodMap = new HashMap();
  
  private QzoneModuleRecordFactory()
  {
    this.mMethodMap.putAll(loadMethods(this, QzoneModuleRecordFactory.class));
  }
  
  public static QzoneModuleRecordFactory getInstance()
  {
    if (sFactory == null) {}
    try
    {
      if (sFactory == null) {
        sFactory = new QzoneModuleRecordFactory();
      }
      return sFactory;
    }
    finally {}
  }
  
  private HashMap<String, a> loadMethods(Object paramObject, Class<?> paramClass)
  {
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = paramClass[i];
        try
        {
          if (localObject.isAnnotationPresent(avwh.class))
          {
            localObject.setAccessible(true);
            String str = ((avwh)localObject.getAnnotation(avwh.class)).value();
            a locala = new a(null);
            locala.instance = paramObject;
            locala.method = localObject;
            localHashMap.put(str, locala);
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.w("QzoneModuleRecordFactory", 1, "catch an exception:", localThrowable);
          }
        }
      }
    }
    return localHashMap;
  }
  
  @avwh("upload.so")
  public avwe.a createQzoneUploadSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSo", "https://d3g.qq.com/sngapp/app/update/20200113193058_6341/qzoneuploadso.zip");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSoMD5", "0bdd196ce6962895dbe3634ab1d55d2a");
    avwe.b localb = new avwe.b();
    localb.a("upload.so").d(str1).e(str2);
    return localb.c();
  }
  
  public avwe.a createRecord(String paramString)
  {
    paramString = (a)this.mMethodMap.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (avwe.a)paramString.method.invoke(paramString.instance, new Object[0]);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneModuleRecordFactory", 1, "catch an exception:", paramString);
      }
    }
    return null;
  }
  
  @avwh("libandroidndkbeauty.so")
  public avwe.a createRecordForAntiBeautyDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "1047ac302378fe17735c98f67d470496");
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 4741347);
    avwe.b localb = new avwe.b();
    localb.a("libandroidndkbeauty.so").d(str1).e(str2).a(i);
    return localb.c();
  }
  
  @avwh("pictureMarkerSo.zip")
  public avwe.a createRecordForAntishakeDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySo", "https://d3g.qq.com/sngapp/app/update/20190529163630_2122/photoQulatitySo.zip");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoMD5", "2111365a079cdbdc66ddfc31f140c474");
    long l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoLength", 1312085);
    avwe.b localb = new avwe.b();
    localb.a("pictureMarkerSo.zip").d(str1).e(str2).a(l);
    return localb.c();
  }
  
  @avwh("qzlive_live_audio.jar")
  public avwe.a createRecordForLiveAudioSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioUrl", "https://d3g.qq.com/sngapp/app/update/20160803113848_6187/qzoneliveaudio.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioMd5", "73bf723be02a6b71b17a0d47888c4e04");
    avwe.b localb = new avwe.b();
    localb.a("qzlive_live_audio.jar").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("qzlive_res1_yt_facedetect.jar")
  public avwe.a createRecordForLivePtuDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoUrl", "https://d3g.qq.com/sngapp/app/update/20191226133414_2167/res1_yt_facedetect.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoMd5", "1cdaf8508cc7343f796ef21b5e65c2b6");
    avwe.b localb = new avwe.b();
    localb.a("qzlive_res1_yt_facedetect.jar").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("qzlive_res1_yt_seg_and_hand.jar")
  public avwe.a createRecordForLivePtuSegAndHandDetect()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandUrl", "https://d3g.qq.com/sngapp/app/update/20180110162244_5632/res1_yt_seg_and_hand.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandMd5", "586bcad62ef42fc352676e485dc38d96");
    avwe.b localb = new avwe.b();
    localb.a("qzlive_res1_yt_seg_and_hand.jar").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("osk_exoplayer2_bundle.jar")
  public avwe.a createRecordForOskPlayer()
  {
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libOskPlayerJarConfig", "https://d3g.qq.com/sngapp/app/update/20170728155227_6686/osk_exoplayer2_bundle.jar|f9d35ec8e90af758354bb174abc12df4");
    String[] arrayOfString = str2.split("\\|");
    String str1 = "";
    Object localObject1 = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i == 0) {
        localObject2 = arrayOfString[i];
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (i == 1)
        {
          str1 = arrayOfString[i];
          localObject2 = localObject1;
        }
      }
    }
    Object localObject2 = new avwe.b();
    ((avwe.b)localObject2).a("osk_exoplayer2_bundle.jar").d((String)localObject1).e(str1).f("com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer").b("1").c(avpq.getQUA3());
    QLog.i("QzoneModuleRecordFactory", 1, "oskplayerconfig:" + str2);
    return ((avwe.b)localObject2).c();
  }
  
  @avwh("filterengine.bundle.jar")
  public avwe.a createRecordForPtuFilterEngineJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarUrl", "https://d3g.qq.com/sngapp/app/update/20170117164907_3213/filterengine.bundle.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarMD5", "4d5cfa42acc64e9fadecff38bdde6cbd");
    avwe.b localb = new avwe.b();
    localb.a("filterengine.bundle.jar").d(str1).e(str2).f("com.tencent.filterengine.bundle.BuildConfig").b("1").c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("libalgo_rithm_jni.so")
  public avwe.a createRecordForPtuJniSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoUrl", "https://d3g.qq.com/sngapp/app/update/20170117162505_7464/libalgo_rithm_jni.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoMD5", "3dcc7162dd785eb4bfa4fb6689efd7e9");
    avwe.b localb = new avwe.b();
    localb.a("libalgo_rithm_jni.so").d(str1).e(str2).b("1").c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("libsuperresolution.jar")
  public avwe.a createRecordForSuperResolutionSo()
  {
    String str1 = avcc.a().getConfig("QZoneSetting", "libSuperResolutionJarUrl", "https://d3g.qq.com/sngapp/app/update/20181204152623_3844/libsuperresolution.jar");
    String str2 = avcc.a().getConfig("QZoneSetting", "libSuperResolutionJarMD5", "6dc8f2f6f95d50ef6daef91c0f1595ec");
    avwe.b localb = new avwe.b();
    localb.a("libsuperresolution.jar").d(str1).e(str2).b("1").c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("tag_classify.jar")
  public avwe.a createRecordForTagClassifySo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_tag_classify_file", "https://d3g.qq.com/sngapp/app/update/20180329102523_4877/pic_tag_sdk.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_classify_file_md5", "6b5338544a7c9baff2af16413d3d5119");
    avwe.b localb = new avwe.b();
    localb.a("tag_classify.jar").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("test_log.dex")
  public avwe.a createRecordForTest()
  {
    avwe.b localb = new avwe.b();
    localb.a("test_log.dex").d("https://d3g.qq.com/sngapp/app/update/20161212150740_4388/qzonemodule_mapsdk.jar").e("158c17d81b2aa6c0f8347aaa64dd015b").f("com.tencent.tencentmap.mapsdk.map.Projection").b("1").c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("upload.jar")
  public avwe.a createRecordForUploadJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarUrl", "https://d3g.qq.com/sngapp/app/update/20200225165213_5410/upload.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarMD5", "f0cee072f5851282b04dc809a834dd0d");
    avwe.b localb = new avwe.b();
    localb.a("upload.jar").d(str1).e(str2).g("3-31;3-32;3-33;3-34;3-35;3-36;3-37;3-38;3-39;3-40;3-41;3-42;3-43;3-44;3-45;3-46;3-47;3-48;3-49;3-50;3-51;3-52;3-53;3-54;3-55;3-56;3-57;3-58;3-59;3-60;3-61;3-62;3-63;3-64;3-65;3-66;3-67;3-68;3-69;3-70;3-71;3-72;3-73;3-74;3-75;3-76;3-77;3-78;3-79;3-80;3-81;3-125;3-126;3-127;3-128;3-197;3-198;3-199;3-5892;3-5788;3-5884;3-5889;3-5890;3-5800;3-5801;3-5802;3-5803;3-5804;3-5805;3-5811;3-5812;3-5814;3-5815;3-5816;3-5817;3-5841;3-5862;3-5863;3-5877;3-5878;3-5879;3-5880;3-5881;3-5882;3-5883;3-5885;3-5886;3-5887;3-5888;3-5891;3-5893;3-5894;3-5895;3-5896;3-5897;3-5898;3-5899;3-5900;3-5901;3-5902;3-5903;3-5904;3-5905;3-5906;3-5907;3-5908;3-5909;3-5910;3-5911;3-5912;3-5939;3-5913;3-5914;3-5915;3-5916;3-5917;3-5918;3-5919;3-5920;3-5921;3-5922;3-5923;3-5924;3-5925;3-5926;3-5927;3-5928;3-5929;3-5930;3-5931;3-5932;3-5933;3-5934;3-5935;3-5936;3-5937;3-5938;3-5940;3-5941;3-5942;3-5943;3-5944;3-5945;3-5946;3-5947;3-5948;3-5949;3-5950;3-5951;3-5952").f("com.tencent.upload.impl.UploadServiceProxy").b("1").a(150).c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("frameanimation.jar")
  public avwe.a createRecordForVoiceShuoshuoAnimation()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimation", "https://d3g.qq.com/sngapp/app/update/20170628223109_9590/frameanimation.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimationMD5", "3F2512458A3F6EB1E23775FB9C8743A2");
    long l = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimationLength", 1739513);
    avwe.b localb = new avwe.b();
    localb.a("frameanimation.jar").d(str1).e(str2).a(l);
    return localb.c();
  }
  
  @avwh("vip_tar_engine.jar")
  public avwe.a createRecrodForARTarEngineJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine.jar", "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine_md5", "3c4cd9ff849e9b6576ffa6d8fe60bcaa");
    String str3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "3");
    avwe.b localb = new avwe.b();
    localb.a("vip_tar_engine.jar").d(str1).e(str2).b(str3).c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("libTar.so")
  public avwe.a createRecrodForARTarEngineSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libTar.so", "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "lib_tar_so_md5", "3a0222c4b9d441a4cf4a3ac620f5dfbc");
    String str3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "1");
    avwe.b localb = new avwe.b();
    localb.a("libTar.so").d(str1).e(str2).b(str3).c(avpq.getQUA3());
    return localb.c();
  }
  
  @avwh("animatedWebp.so")
  public avwe.a createRecrodForAnimatedWebp()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebp", "https://d3g.qq.com/sngapp/app/update/20190724163607_2917/libanimwebp_jni.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
    avwe.b localb = new avwe.b();
    localb.a("animatedWebp.so").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("cyber_clink_version_2.jar")
  public avwe.a createRecrodForDLNAJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkUrl", "https://d3g.qq.com/sngapp/app/update/20180824143533_9249/cyber_clink.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkJarMD5", "1fa71f228a6daff1fb04f7148f2c95d7");
    avwe.b localb = new avwe.b();
    localb.a("cyber_clink_version_2.jar").d(str1).f("com.qzone.album.business.dlna.DLNAServiceImpl").e(str2);
    return localb.c();
  }
  
  @avwh("qzlive_filterbundle.jar")
  public avwe.a createRecrodForLiveFilterBundle()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleUrl", "https://d3g.qq.com/sngapp/app/update/20171105201346_3221/filterengine.bundle_qzone_7.6.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleMd5", "b11e343a1096d3b6331b32e2b1bada88");
    avwe.b localb = new avwe.b();
    localb.a("qzlive_filterbundle.jar").d(str1).e(str2);
    return localb.c();
  }
  
  @avwh("xmpcore.jar")
  public avwe.a createRecrodForXMPCoreJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
    avwe.b localb = new avwe.b();
    localb.a("xmpcore.jar").d(str1).e(str2);
    return localb.c();
  }
  
  static class a
  {
    Object instance;
    Method method;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleRecordFactory
 * JD-Core Version:    0.7.0.1
 */