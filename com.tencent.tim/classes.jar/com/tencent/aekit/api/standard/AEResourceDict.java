package com.tencent.aekit.api.standard;

import android.text.TextUtils;
import java.util.HashMap;

public class AEResourceDict
{
  public static final String ARCH_ARM64_V8A = "arm64-v8a";
  public static final String ARCH_ARMEABI = "armeabi";
  public static final String ARCH_ARMEABI_V7A = "armeabi-v7a";
  private static final HashMap<String, String> resourceTagMap = new HashMap();
  
  static
  {
    resourceTagMap.put("armeabi-v7a/libYTFaceTrack.so", "72c2f1fbfbf2db15a3555326fa5faa3fdc0d6825");
    resourceTagMap.put("armeabi-v7a/libParticleSystem.so", "348ed8029085fe9abb852b031090f0dd0f9938e1");
    resourceTagMap.put("armeabi-v7a/libimage_filter_common.so", "2bd469c3f0b75a62dec0dd0a27f8c750c1410bd1");
    resourceTagMap.put("armeabi-v7a/libYTIllumination.so", "85c02a6281caa5fcd324ff1d115af2ce979b32dc");
    resourceTagMap.put("armeabi-v7a/libpitu_voice.so", "b6f6d69f369518b0293efbbd1d918ce30468e9d6");
    resourceTagMap.put("armeabi-v7a/libgltfio-jni_11181700.so", "aa4b893c88de8726c0f0238d3db36a9e70731c2a");
    resourceTagMap.put("armeabi-v7a/libfacekit.so", "9568853b45b64785ea109902446e172a6ccfc265");
    resourceTagMap.put("armeabi-v7a/libvoicechanger_shared.so", "04c62be1066496586e19214ef8eb5f6e808a599f");
    resourceTagMap.put("armeabi-v7a/libimage_filter_gpu.so", "12ac74d1f9c9faa37e4bc801d929a7458f166f10");
    resourceTagMap.put("armeabi-v7a/libpitu_device.so", "8f133d276368c25adf81beffa3283d7fb05f5702");
    resourceTagMap.put("armeabi-v7a/libgenderdetector.so", "08e51c02748626dc749e6ac86ae2dcb10465fcd6");
    resourceTagMap.put("armeabi-v7a/libYTFaceTrackPro.so", "7c7aa1ebd72460a75129f0302c505699ef6fccbc");
    resourceTagMap.put("armeabi-v7a/libPictureFaceJNI.so", "7ab84fe6435eab2dd467d1214bb070cc4b304890");
    resourceTagMap.put("armeabi-v7a/libYTFacePicTrack.so", "ba86e8ad55035a015af854541d528dc6a0af2916");
    resourceTagMap.put("armeabi-v7a/libWXVoice.so", "43fb27c452aa91414fcf45e66795ea959697e6a2");
    resourceTagMap.put("armeabi-v7a/libYTCommon.so", "a4e8a89a88d6ac7b7df9ae28a1d0aed3e1bb30ae");
    resourceTagMap.put("armeabi-v7a/libYTFaceAttr.so", "5ae6f5285aedd33506f7d7e5ddf12c1c98b80793");
    resourceTagMap.put("armeabi-v7a/libCameraFaceJNI.so", "bf57ffc64195a2a0ec6a102ed85f6ba1ca887775");
    resourceTagMap.put("armeabi-v7a/libfilament-jni_11081930.so", "d3d05878c59d05476d3e5915c1082943050cc7ad");
    resourceTagMap.put("armeabi-v7a/libanimojisdk.so", "17987b6625dc72fc8a8ce3f92eb1fb7355de95fc");
    resourceTagMap.put("armeabi-v7a/libpitu_tools.so", "df91f03fdb463d8c6cfd06e209535b15cb767ece");
    resourceTagMap.put("armeabi-v7a/libnnpack.so", "e58ae167a4453ebd85b802d97149cba1f73f06db");
    resourceTagMap.put("armeabi-v7a/libgameplay.so", "96d592abeb489036c0f0cd915eba2828af816fc6");
    resourceTagMap.put("armeabi-v7a/libXHumanActionSDK.so", "c8d69637f7bf5ac02571a0cbf704449322639584");
    resourceTagMap.put("arm64-v8a/libYTFaceTrack.so", "54cc0d347dcec3e105386f8ec0d1fc09bd68da45");
    resourceTagMap.put("arm64-v8a/libParticleSystem.so", "9d2ffc3895e7f90529e3bcff04d83035aa6e9391");
    resourceTagMap.put("arm64-v8a/libimage_filter_common.so", "997d3d9d3e3aed63ef86b725e0f96f089929a51c");
    resourceTagMap.put("arm64-v8a/libYTIllumination.so", "7aff2f4a65c446ea10d4951347ac9c164ad16d39");
    resourceTagMap.put("arm64-v8a/libpitu_voice.so", "c101a6dbaf0b8be6949f8b4e18bf07e36b5d8e49");
    resourceTagMap.put("arm64-v8a/libfacekit.so", "8d9d7bd698d8fc9ca17d3fac6a35057beabf9a2c");
    resourceTagMap.put("arm64-v8a/libvoicechanger_shared.so", "e964233f1e633dde3ac56b12d5b016db02dc8a52");
    resourceTagMap.put("arm64-v8a/libimage_filter_gpu.so", "34141d1cb1eec1604196c320dc73da556341b8fe");
    resourceTagMap.put("arm64-v8a/libpitu_device.so", "d4f0e7b70bc3c81abc4e3499a9cd10e4122b40b9");
    resourceTagMap.put("arm64-v8a/libgenderdetector.so", "3d57eecbf29bae34b58494cae9a805698c580fa4");
    resourceTagMap.put("arm64-v8a/libYTFaceTrackPro.so", "6977b450bb503159e982d1fbf71e259d801f32c1");
    resourceTagMap.put("arm64-v8a/libPictureFaceJNI.so", "ce374689610cc03f76f628ceaa1fe6e1994a85bd");
    resourceTagMap.put("arm64-v8a/libYTFacePicTrack.so", "0351ada993abfd8fa1c33ef93e0912b598edfba0");
    resourceTagMap.put("arm64-v8a/libWXVoice.so", "47592b43003533933d838c443b67593054adfd36");
    resourceTagMap.put("arm64-v8a/libYTCommon.so", "106b218aac39cc85eff1839f34b11339bd76e4ce");
    resourceTagMap.put("arm64-v8a/libYTFaceAttr.so", "6d616d7728f43634c7fba3e6137237c0a9142348");
    resourceTagMap.put("arm64-v8a/libCameraFaceJNI.so", "fc0ee64ae66e21ccda2f0ea22c7dca9723c5fa41");
    resourceTagMap.put("arm64-v8a/libimage_filter_cpu.so", "3da15bd62ae2ad7332e30ac1a7e05194bb8deda8");
    resourceTagMap.put("arm64-v8a/libanimojisdk.so", "4a327d3eb36d9a8b83fa68f2abe4e0754dd511b4");
    resourceTagMap.put("arm64-v8a/libpitu_tools.so", "69cf55ff5576a666af3879882923197d8e1625b2");
    resourceTagMap.put("arm64-v8a/libnnpack.so", "7f6b15235bb28030365ddab8ceb7d2f7b10fcbb1");
    resourceTagMap.put("arm64-v8a/libgameplay.so", "e35490671e6898c78b9887f6aad4a68459adf198");
    resourceTagMap.put("arm64-v8a/libXHumanActionSDK.so", "bb8b8958e64cbca54ae528a78cb1858a9ddf03db");
    resourceTagMap.put("armeabi/libYTFaceTrack.so", "72c2f1fbfbf2db15a3555326fa5faa3fdc0d6825");
    resourceTagMap.put("armeabi/libParticleSystem.so", "348ed8029085fe9abb852b031090f0dd0f9938e1");
    resourceTagMap.put("armeabi/libimage_filter_common.so", "2bd469c3f0b75a62dec0dd0a27f8c750c1410bd1");
    resourceTagMap.put("armeabi/libYTIllumination.so", "85c02a6281caa5fcd324ff1d115af2ce979b32dc");
    resourceTagMap.put("armeabi/libpitu_voice.so", "b6f6d69f369518b0293efbbd1d918ce30468e9d6");
    resourceTagMap.put("armeabi/libgltfio-jni_11181700.so", "aa4b893c88de8726c0f0238d3db36a9e70731c2a");
    resourceTagMap.put("armeabi/libfacekit.so", "9568853b45b64785ea109902446e172a6ccfc265");
    resourceTagMap.put("armeabi/libvoicechanger_shared.so", "04c62be1066496586e19214ef8eb5f6e808a599f");
    resourceTagMap.put("armeabi/libimage_filter_gpu.so", "12ac74d1f9c9faa37e4bc801d929a7458f166f10");
    resourceTagMap.put("armeabi/libpitu_device.so", "8f133d276368c25adf81beffa3283d7fb05f5702");
    resourceTagMap.put("armeabi/libgenderdetector.so", "08e51c02748626dc749e6ac86ae2dcb10465fcd6");
    resourceTagMap.put("armeabi/libYTFaceTrackPro.so", "7c7aa1ebd72460a75129f0302c505699ef6fccbc");
    resourceTagMap.put("armeabi/libPictureFaceJNI.so", "c433953b6f9f18ceee745ce72837cd0783588d3e");
    resourceTagMap.put("armeabi/libYTFacePicTrack.so", "ba86e8ad55035a015af854541d528dc6a0af2916");
    resourceTagMap.put("armeabi/libWXVoice.so", "43fb27c452aa91414fcf45e66795ea959697e6a2");
    resourceTagMap.put("armeabi/libYTCommon.so", "a4e8a89a88d6ac7b7df9ae28a1d0aed3e1bb30ae");
    resourceTagMap.put("armeabi/libYTFaceAttr.so", "5ae6f5285aedd33506f7d7e5ddf12c1c98b80793");
    resourceTagMap.put("armeabi/libCameraFaceJNI.so", "bf57ffc64195a2a0ec6a102ed85f6ba1ca887775");
    resourceTagMap.put("armeabi/libfilament-jni_11081930.so", "d3d05878c59d05476d3e5915c1082943050cc7ad");
    resourceTagMap.put("armeabi/libanimojisdk.so", "17987b6625dc72fc8a8ce3f92eb1fb7355de95fc");
    resourceTagMap.put("armeabi/libpitu_tools.so", "df91f03fdb463d8c6cfd06e209535b15cb767ece");
    resourceTagMap.put("armeabi/libnnpack.so", "e58ae167a4453ebd85b802d97149cba1f73f06db");
    resourceTagMap.put("armeabi/libgameplay.so", "96d592abeb489036c0f0cd915eba2828af816fc6");
    resourceTagMap.put("armeabi/libXHumanActionSDK.so", "c8d69637f7bf5ac02571a0cbf704449322639584");
    resourceTagMap.put("armeabi-v7a/libxnet.so", "6e86b0cbece10fae7f1ca53ca1073e3747a7b043");
    resourceTagMap.put("armeabi-v7a/libbodydetector.so", "064fc8b1b46f195701fdc0c0b11befde86510884");
    resourceTagMap.put("armeabi/libxnet.so", "6e86b0cbece10fae7f1ca53ca1073e3747a7b043");
    resourceTagMap.put("armeabi/libbodydetector.so", "064fc8b1b46f195701fdc0c0b11befde86510884");
    resourceTagMap.put("armeabi-v7a/libYTHandDetector.so", "050ef4e3275ff9efb895b3311215ed783e5ecadc");
    resourceTagMap.put("armeabi-v7a/libGestureDetectJni.so", "59fb61e9fef1987333674ef1c979ff1a2efb3154");
    resourceTagMap.put("arm64-v8a/libYTHandDetector.so", "a2e7bd5c6f0e1a0292ba749d16fe2c37a2735e12");
    resourceTagMap.put("arm64-v8a/libGestureDetectJni.so", "880294ec7ca4f50a5eebb77a88a42b9832248e82");
    resourceTagMap.put("armeabi/libYTHandDetector.so", "050ef4e3275ff9efb895b3311215ed783e5ecadc");
    resourceTagMap.put("armeabi/libGestureDetectJni.so", "59fb61e9fef1987333674ef1c979ff1a2efb3154");
    resourceTagMap.put("armeabi-v7a/libexpression_ttpic.so", "c031b4af99b61643daec8b6602209e7bcae62243");
    resourceTagMap.put("arm64-v8a/libexpression_ttpic.so", "33b5b2655feca11c18e51e3190aeda4013280de0");
    resourceTagMap.put("armeabi/libexpression_ttpic.so", "c031b4af99b61643daec8b6602209e7bcae62243");
    resourceTagMap.put("armeabi-v7a/libsegmentern.so", "b99a8556b38b66a9befad7831b9787215704f058");
    resourceTagMap.put("arm64-v8a/libsegmentern.so", "b977cb6ea3550aa95c498d8b237123875b7d09df");
    resourceTagMap.put("armeabi/libsegmentern.so", "b99a8556b38b66a9befad7831b9787215704f058");
  }
  
  public static String getSHA1(String paramString)
  {
    return getSHA1("armeabi-v7a", paramString);
  }
  
  public static String getSHA1(String paramString1, String paramString2)
  {
    if ((TextUtils.equals(paramString1, "armeabi")) || (TextUtils.equals(paramString1, "armeabi-v7a")) || (TextUtils.equals(paramString1, "arm64-v8a"))) {
      return (String)resourceTagMap.get(paramString1 + "/" + paramString2);
    }
    return null;
  }
  
  public static boolean isValidSHA1(String paramString1, String paramString2)
  {
    String str1 = getSHA1("armeabi", paramString1);
    String str2 = getSHA1("armeabi-v7a", paramString1);
    paramString1 = getSHA1("arm64-v8a", paramString1);
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(paramString1))) {}
    while ((TextUtils.equals(paramString2, str1)) || (TextUtils.equals(paramString2, str2)) || (TextUtils.equals(paramString2, paramString1))) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEResourceDict
 * JD-Core Version:    0.7.0.1
 */