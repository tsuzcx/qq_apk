import android.os.Build;
import java.io.File;

public class awtn
  extends awto
{
  private static final String SDCARD_IMG_CAMERA = acbn.SDCARD_ROOT + "/DCIM/Camera/";
  private static final String SDCARD_IMG_VIDEO = acbn.SDCARD_ROOT + "/DCIM/Video/";
  private static final String SDCARD_IMG_VIDEO_GN9000L = acbn.SDCARD_ROOT + acfp.m(2131702748);
  private static final String SDCARD_IMG_VIDEO_RUBBISH_MX040;
  private static final String SDCARD_IMG_VIDEO_VIVO_X7 = acbn.SDCARD_ROOT + acfp.m(2131702749);
  
  static
  {
    SDCARD_IMG_VIDEO_RUBBISH_MX040 = acbn.SDCARD_ROOT + "/Camera/Video/";
  }
  
  public static String getCameraPath()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      return SDCARD_IMG_VIDEO_GN9000L;
    }
    if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
      return SDCARD_IMG_VIDEO;
    }
    if (str.contains("M040")) {
      return SDCARD_IMG_VIDEO_RUBBISH_MX040;
    }
    if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
      return SDCARD_IMG_VIDEO_VIVO_X7;
    }
    return SDCARD_IMG_CAMERA;
  }
  
  public static String sx(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    File localFile = new File(localStringBuilder.toString());
    paramString = localStringBuilder;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(paramString))
    {
      paramString.append(anlb.Ab()).append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
  
  public static class a
  {
    public static class a
    {
      public static final String PATH = awto.a.cTi + File.separator + "aiscene";
      public static final String cSI = PATH + File.separator + "res";
      public static final String cSJ = PATH + File.separator + "res_zip_download";
      public static final String cSK = cSI + File.separator + "AISceneGuide";
      public static final String cSL = cSI + File.separator + "AISceneLoading";
      public static final String cSM = cSI + File.separator + "AutoAISceneAni";
    }
  }
  
  public static class b
  {
    public static final String cSN = awtn.b.b.cSS + File.separator + "camera_story_default_template.json";
    
    public static class a
    {
      public static final String PATH = awto.a.cTj + File.separator + "camera";
      public static final String cSO = PATH + File.separator + "photo_compress";
    }
    
    public static class b
    {
      public static final String PATH = awto.a.cTi + File.separator + "camera";
      public static final String cSI = awto.a.cTi + File.separator + "sv_config_resources" + File.separator;
      public static final String cSP = PATH + File.separator + "capture";
      public static final String cSQ = PATH + File.separator + "material_zip_download";
      public static final String cSR = PATH + File.separator + "material_usable";
      public static final String cSS = PATH + File.separator + "material_config";
    }
    
    public static class c
    {
      public static final String cST = awto.cTh + "/app_lib/qq_filter" + File.separator;
      public static final String cSU = cST + "final_ptu_res_file" + File.separator;
    }
  }
  
  public static class c
  {
    public static final String cSN = awtn.c.b.cSX + File.separator + "camera_emo_default_template.json";
    
    public static class a
    {
      public static final String PATH = awto.a.cTj + File.separator + "gif";
      public static final String cSV = PATH + File.separator + "gifPreview";
    }
    
    public static class b
    {
      public static final String PATH = awto.a.cTi + File.separator + "gif";
      public static final String cSI;
      public static final String cSK = cSI + File.separator + "GifGuide";
      public static final String cSP = PATH + File.separator + "capture";
      public static final String cSW;
      public static final String cSX = PATH + File.separator + "material_config";
      
      static
      {
        cSI = PATH + File.separator + "res";
        cSW = PATH + File.separator + "res_zip_download";
      }
    }
  }
  
  public static class d
  {
    public static final String cSY = awtn.d.b.cSX + File.separator + "camera_play_show_default_template.json";
    public static final String cSZ = awtn.d.b.cSX + File.separator + "camera_play_show_updated_template.json";
    
    public static class a
    {
      public static final String PATH = awto.a.cTj + File.separator + "playshow";
      public static final String cTa = PATH + File.separator + "crazyface_tmp";
      public static final String cTb = PATH + File.separator + "qudong_tmp";
      public static final String cTc = PATH + File.separator + "web_tmp";
    }
    
    public static class b
    {
      public static final String PATH = awto.a.cTi + File.separator + "playshow";
      public static final String cSR = awtn.b.b.cSR;
      public static final String cSX = PATH + File.separator + "material_config";
      public static final String cTd = PATH + File.separator + "thumbs";
      public static final String cTe = PATH + File.separator + "videos";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtn
 * JD-Core Version:    0.7.0.1
 */