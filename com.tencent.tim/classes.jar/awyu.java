import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.SkySegmentInitializer;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.1;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.2;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.3;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class awyu
{
  private static final List<Feature> Mf;
  private static final List<Pair<String, Integer>> Mg;
  private static final List<awyu.c> Mh;
  public static final awyu.d a = new awyu.d();
  private static final axzu<awyu.c> c;
  
  static
  {
    Mf = new LinkedList();
    Mg = new LinkedList();
    Mh = new LinkedList();
    c = new axzu();
    if (aOl())
    {
      eHS();
      eHT();
      eHU();
    }
  }
  
  public static axzu<awyu.c> a()
  {
    return c;
  }
  
  public static List<awyu.c> a(@Nullable awyu.c paramc)
  {
    LinkedList localLinkedList = new LinkedList(Mh);
    if ((paramc == null) || (TextUtils.isEmpty(paramc.mCmd))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      awyu.c localc = (awyu.c)localIterator.next();
      if ((localc != null) && (!TextUtils.isEmpty(localc.mCmd)) && (localc.mCmd.equals(paramc.mCmd)))
      {
        localc.mState = paramc.mState;
        localc.jI = paramc.jI;
      }
    }
    return localLinkedList;
  }
  
  private static void a(@Nullable awyw.d paramd)
  {
    ThreadManager.excute(new AEDashboardUtil.2(paramd), 64, null, true);
  }
  
  public static void a(@Nullable awyw.d paramd, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(paramd), paramLong);
  }
  
  private static void a(@Nullable awyw.d paramd, @NonNull List<awyu.b> paramList, @NonNull List<awyu.a> paramList1)
  {
    if (paramd == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(paramd, paramList, paramList1));
  }
  
  public static boolean aOl()
  {
    return false;
  }
  
  private static void eHS()
  {
    Mf.add(FeatureManager.Features.YT_COMMON);
    Mf.add(FeatureManager.Features.FACE_DETECT);
    Mf.add(FeatureManager.Features.PTU_TOOLS);
    Mf.add(FeatureManager.Features.PTU_ALGO);
    Mf.add(FeatureManager.Features.MASK_IMAGES);
    Mf.add(FeatureManager.Features.FILAMENT);
    Mf.add(FeatureManager.Features.VOICE_CHANGDER);
    Mf.add(FeatureManager.Features.VOICE_TO_TEXT);
    Mf.add(FeatureManager.Features.PARTICLE_SYSTEM);
    Mf.add(FeatureManager.Features.AGE_DETECT);
    Mf.add(FeatureManager.Features.FACE_3D_LIB);
    Mf.add(FeatureManager.Features.RAPID_NET_CAT);
    Mf.add(FeatureManager.Features.RAPID_NET_GENDER_DETECT);
    Mf.add(FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER);
    Mf.add(FeatureManager.Features.PAG);
    Mf.add(FeatureManager.Features.RAPID_NET_SEG_CPU);
    Mf.add(FeatureManager.Features.RAPID_NET_SEG_GPU);
    Mf.add(FeatureManager.Features.RAPID_NET_GENDER_SWITCH);
    Mf.add(FeatureManager.Features.RAPID_NET_GESTURE);
    Mf.add(FeatureManager.Features.IMAGE_ALGO);
    Mf.add(AEHandDetector.HAND_DETECTOR);
    Mf.add(PTHumanSegmenter.HUMAN_SEGMENT);
    Mf.add(PTEmotionDetector.EMOTION_DETECTOR);
    Mf.add(PTSkySegmenter.SKY_SEGMENT);
    Mf.add(PTHairSegmenter.HAIR_SEGMENT);
  }
  
  private static void eHT()
  {
    Mg.add(new Pair("app_alg_aio_camera_type_id", Integer.valueOf(4)));
    Mg.add(new Pair("app_alg_entrance_qzone_id_from833", Integer.valueOf(4)));
    Mg.add(new Pair("app_ui_playshow_ad_id", Integer.valueOf(4)));
  }
  
  private static void eHU()
  {
    Mh.add(new awyu.c("CameraModuleSvc.GetCameraConfig"));
    Mh.add(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"));
    Mh.add(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"));
    Mh.add(new awyu.c("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<awyu.b> hG()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = Mf.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Feature)localIterator.next();
      awyu.b localb = new awyu.b();
      try
      {
        localb.auL = ((Feature)localObject1).getName();
        localb.Zp = ((Feature)localObject1).isFunctionReady();
        StringBuilder localStringBuilder;
        if (localObject1 == PTSkySegmenter.SKY_SEGMENT)
        {
          SkySegmentInitializer localSkySegmentInitializer = (SkySegmentInitializer)localObject1;
          localStringBuilder = new StringBuilder();
          if (!localSkySegmentInitializer.isUseCPULib()) {
            break label149;
          }
          localObject1 = "CPU";
          label94:
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("&");
          if (!localSkySegmentInitializer.isUseSmallModel()) {
            break label156;
          }
        }
        label149:
        label156:
        for (localObject1 = "smallModel";; localObject1 = "bigModel")
        {
          localStringBuilder.append((String)localObject1);
          localb.cJL = localStringBuilder.toString();
          localLinkedList.add(localb);
          break;
          localObject1 = "GPU";
          break label94;
        }
      }
      catch (Exception localException)
      {
        localb.Zp = false;
        localb.mErrMsg = localException.getMessage();
        localLinkedList.add(localb);
      }
      finally
      {
        localLinkedList.add(localb);
      }
    }
    Collections.sort(localLinkedList, new awyv());
    return localLinkedList;
  }
  
  private static List<awyu.a> hH()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = Mg.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      awyu.a locala = new awyu.a();
      locala.cTs = ((String)localPair.first);
      locala.cTt = axis.a().t((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(locala);
    }
    return localLinkedList;
  }
  
  public static class a
  {
    public String cTs;
    public String cTt = "null";
    
    @NonNull
    public String toString()
    {
      return this.cTs + ", value=" + this.cTt;
    }
  }
  
  public static class b
  {
    public boolean Zp;
    public String auL;
    public String cJL = "null";
    public String mErrMsg = "null";
    
    @NonNull
    public String toString()
    {
      return this.auL + ", ready=" + this.Zp + ", extraInfo=" + this.cJL + ", error=" + this.mErrMsg;
    }
  }
  
  public static class c
  {
    public String jI = "null";
    public String mCmd;
    public String mState = "null";
    
    public c(@NonNull String paramString)
    {
      this.mCmd = paramString;
    }
    
    public c(@NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
    {
      this.mCmd = paramString1;
      this.mState = paramString2;
      this.jI = paramString3;
    }
    
    @NonNull
    public String toString()
    {
      return "cmd=" + this.mCmd + ", state=" + this.mState + ", result=" + this.jI;
    }
  }
  
  public static class d
  {
    public boolean dtE;
    public boolean dtF;
    public int eEc;
    public int eEd;
    public int eEe;
    public int eEf;
    public int eEg;
    public int eEh;
    public int eEi;
    public int eEj;
    public int eEk;
    public int eEl;
    public int surfaceViewHeight;
    public int surfaceViewWidth;
    public int videoHeight;
    public int videoWidth;
    
    private String Hv()
    {
      if (this.dtE) {
        return Hx();
      }
      return Hw();
    }
    
    private String Hx()
    {
      if ((this.eEj != 0) && (this.eEi != 0)) {
        return this.eEj + "*" + this.eEi;
      }
      return "none";
    }
    
    private void eHV()
    {
      double d4 = this.eEf * 1.0D / this.eEe;
      double d5 = this.surfaceViewHeight * 1.0D / this.surfaceViewWidth;
      double d2 = this.eEe;
      double d3 = this.eEf;
      double d1;
      if (d4 > d5) {
        d1 = d5 * d2;
      }
      for (;;)
      {
        this.eEk = ((int)d2);
        this.eEl = ((int)d1);
        return;
        d1 = d3;
        if (d4 < d5)
        {
          d2 = 1.0D / d5 * d3;
          d1 = d3;
        }
      }
    }
    
    public String Hr()
    {
      if ((this.surfaceViewHeight != 0) && (this.surfaceViewWidth != 0)) {
        return this.surfaceViewHeight + "*" + this.surfaceViewWidth;
      }
      return "none";
    }
    
    public String Hs()
    {
      if ((this.eEd != 0) && (this.eEc != 0)) {
        return this.eEd + "*" + this.eEc;
      }
      return "none";
    }
    
    public String Ht()
    {
      if ((this.eEf != 0) && (this.eEe != 0)) {
        return this.eEf + "*" + this.eEe;
      }
      return "none";
    }
    
    public String Hu()
    {
      if (this.dtF) {
        return Hv();
      }
      return Hy();
    }
    
    public String Hw()
    {
      if ((this.eEh != 0) && (this.eEg != 0)) {
        return this.eEh + "*" + this.eEg;
      }
      return "none";
    }
    
    public String Hy()
    {
      eHV();
      if ((this.eEl != 0) && (this.eEk != 0)) {
        return this.eEl + "*" + this.eEk;
      }
      return "none";
    }
    
    public String Hz()
    {
      if ((this.videoHeight != 0) && (this.videoWidth != 0)) {
        return this.videoHeight + "*" + this.videoWidth;
      }
      return "none";
    }
    
    public List<String> hI()
    {
      eHV();
      return Arrays.asList(new String[] { "取景框大小: " + this.surfaceViewHeight + "*" + this.surfaceViewWidth, "设置的预览分辨率: " + this.eEd + "*" + this.eEc, "设置的照片分辨率: " + this.eEf + "*" + this.eEe, "普通渲染 & 截帧分辨率: " + this.eEh + "*" + this.eEg, "高清渲染 & 截帧分辨率: " + this.eEj + "*" + this.eEi, "大图拍照分辨率: " + this.eEl + "*" + this.eEk, "视频分辨率: " + this.videoHeight + "*" + this.videoWidth, "预览帧率: TODO" });
    }
    
    @NonNull
    public String toString()
    {
      List localList = hI();
      int j = localList.size();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)localList.get(i));
        if (i < j - 1) {
          localStringBuilder.append("\n");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyu
 * JD-Core Version:    0.7.0.1
 */