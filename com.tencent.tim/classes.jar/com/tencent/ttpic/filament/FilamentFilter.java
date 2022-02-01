package com.tencent.ttpic.filament;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.filament.Engine;
import com.google.android.filament.FilamentJNI;
import com.google.android.filament.Texture;
import com.google.android.filament.Texture.Builder;
import com.google.android.filament.Texture.InternalFormat;
import com.google.android.filament.Texture.Sampler;
import com.google.android.filament.android.TextureHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.Range;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.AnimojiExpressionJava;
import com.tencent.ttpic.openapi.model.EyeNodeItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.GLB_FIELD;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.trigger.AETriggerI;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.util.ColorUtil;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

public class FilamentFilter
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = FilamentFilter.class.getSimpleName();
  private static final boolean USE_SHARE_CONTEXT = true;
  public static float averageL = 0.0F;
  private List<String> animationItemNames;
  private Texture cameraTexture;
  private List<Texture> cameraTextures = new ArrayList();
  private boolean canUseShareContext;
  private String dataPath;
  private String defaultAnimationName;
  private int defaultAnimationPlaycount;
  private LinkedBlockingDeque<Runnable> drawQueue = new LinkedBlockingDeque();
  private String faceMeshTextureKey;
  private Frame filamentFrame = new Frame();
  private FilamentJNI filamentJNI;
  private Map<String, Frame> frames = new HashMap();
  private Map<GLBItemJava, byte[]> glbBytesMap = new HashMap();
  private List<GLBItemJava> glbList;
  private boolean hasLoadGlbData;
  private boolean hasSetCameraTexture = false;
  private int height = -1;
  private final boolean isBloomMaterial;
  private final HashMap<String, Float> jawOpenThresholdMap = new HashMap();
  private byte[] jsonData;
  private float[] key = { 30.0F, 80.0F };
  private Set<String> keys = new HashSet();
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame mCopyFrame = new Frame();
  private SimpleGLThread mHandler;
  private SurfaceTextureFilter mPreviewFilter = new SurfaceTextureFilter();
  private int[] mPreviewTextureId = new int[2];
  private EGLContext mShareContext;
  private volatile boolean modelLoadSucceed;
  private volatile boolean modelReady;
  private boolean needFaceMesh = false;
  private boolean needRender;
  private MaterialLoadFinishListener onLoadFinishListener;
  private int rotation = 0;
  private int skipFrame;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private TriggerManager triggerManager;
  private float[] value = { 30000.0F, 80000.0F };
  private int width = -1;
  
  @RequiresApi(api=17)
  public FilamentFilter(VideoMaterial paramVideoMaterial, TriggerManager paramTriggerManager)
  {
    this.triggerManager = paramTriggerManager;
    this.glbList = paramVideoMaterial.getGlbList();
    updateJawOpenThreshold(this.glbList);
    this.dataPath = paramVideoMaterial.getDataPath();
    this.isBloomMaterial = VideoMaterialUtil.isFilamentBloomMaterial(paramVideoMaterial);
    paramVideoMaterial = this.glbList.iterator();
    for (;;)
    {
      if (!paramVideoMaterial.hasNext()) {
        break label291;
      }
      paramTriggerManager = ((GLBItemJava)paramVideoMaterial.next()).nodeList.iterator();
      if (paramTriggerManager.hasNext())
      {
        if (((NodeItemJava)paramTriggerManager.next()).needFaceMesh != 1) {
          break;
        }
        this.needFaceMesh = true;
      }
    }
    label291:
    paramVideoMaterial = this.glbList.iterator();
    do
    {
      if (!paramVideoMaterial.hasNext()) {
        break;
      }
      this.faceMeshTextureKey = ((GLBItemJava)paramVideoMaterial.next()).faceMeshTextureKey;
    } while (this.faceMeshTextureKey.isEmpty());
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((GLBItemJava)paramVideoMaterial.next()).hasSetCameraTexture()) {
        this.hasSetCameraTexture = true;
      }
    }
    paramVideoMaterial = this.glbList.iterator();
    while (paramVideoMaterial.hasNext())
    {
      paramTriggerManager = (GLBItemJava)paramVideoMaterial.next();
      this.keys.addAll(paramTriggerManager.specialFilterFrameKeys());
    }
    this.mShareContext = EGL14.eglGetCurrentContext();
    this.mHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "HTM_Fila", new FilamentFilter.1(this));
    FilamentFilterManager.getInstance().setFilter(this);
  }
  
  private void initCameraTexture()
  {
    if ((!this.keys.isEmpty()) && (this.cameraTextures.isEmpty()))
    {
      Iterator localIterator = this.keys.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (Frame)this.frames.get(localObject);
        if (localObject != null) {
          this.cameraTextures.add(new Texture.Builder().width(((Frame)localObject).width).height(((Frame)localObject).height).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine()));
        }
      }
    }
  }
  
  private void loadGlbData()
  {
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.LOAD_DATA.tag);
    Iterator localIterator = this.glbList.iterator();
    while (localIterator.hasNext())
    {
      GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
      byte[] arrayOfByte = (byte[])this.glbBytesMap.get(localGLBItemJava);
      this.filamentJNI.setGlbData(FileUtils.getFileNameWithSuffixByPath(localGLBItemJava.path), arrayOfByte);
    }
    this.filamentJNI.loadAllData();
    this.modelLoadSucceed = true;
    FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.LOAD_DATA.tag);
    if (this.needFaceMesh) {
      this.filamentJNI.setImage(this.cameraTexture);
    }
  }
  
  private byte[] openGlbFile(GLBItemJava paramGLBItemJava)
  {
    if (!TextUtils.isEmpty(paramGLBItemJava.path)) {
      return FilamentJavaUtil.decryptGlb(paramGLBItemJava.path);
    }
    return null;
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height) || (this.rotation != paramInt3))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rotation = paramInt3;
      float f = Math.min(paramInt1 / FilamentJavaUtil.getProcessWidth(), 1.0F);
      int i = (int)(paramInt1 * f);
      int j = (int)(f * paramInt2);
      if (paramInt3 != 90)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (paramInt3 != 270) {}
      }
      else
      {
        paramInt1 = i + j;
        paramInt2 = paramInt1 - j;
        paramInt1 -= paramInt2;
      }
      setupFilament();
      this.filamentJNI.resize(paramInt1, paramInt2);
      this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      if ((this.needFaceMesh) || (this.hasSetCameraTexture))
      {
        this.cameraTexture = new Texture.Builder().width(paramInt1).height(paramInt2).levels(1).usage(16).sampler(Texture.Sampler.SAMPLER_2D).format(Texture.InternalFormat.RGBA8).build(this.filamentJNI.getEngine());
        if ((this.needFaceMesh) && (this.modelLoadSucceed)) {
          this.filamentJNI.setImage(this.cameraTexture);
        }
      }
    }
  }
  
  private Point rotate(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (this.rotation != 90)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.rotation != 270) {}
    }
    else
    {
      paramInt1 += paramInt2;
      i = paramInt1 - paramInt2;
      j = paramInt1 - i;
    }
    return new Point(j, i);
  }
  
  private void setupFilament()
  {
    this.mHandler.waitDone();
    if (this.filamentJNI != null) {}
    do
    {
      return;
      this.modelReady = false;
      this.modelLoadSucceed = false;
      this.hasLoadGlbData = false;
      this.filamentJNI = FilamentJNI.create(this.surface, this.mShareContext, Math.min(this.width, this.height), Math.max(this.width, this.height), FeatureManager.Features.FILAMENT.getFinalResourcesDir() + File.separator, this.dataPath, this.jsonData);
      if (!DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
        this.filamentJNI.setNewFurLayers(0);
      }
      this.canUseShareContext = this.filamentJNI.canUseShareContext();
      this.mHandler.postJob(new FilamentFilter.4(this));
    } while (this.animationItemNames == null);
    this.filamentJNI.registerAnimation((String[])this.animationItemNames.toArray(new String[this.animationItemNames.size()]));
  }
  
  private void updateActionTriggered(int paramInt, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    if (!this.modelLoadSucceed) {}
    for (;;)
    {
      return;
      BenchUtil.benchStart("[filament] updateActionTriggered 0");
      Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
      Object localObject2 = AIActionCounter.getActions(AEDetectorType.HAND);
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      paramAIAttr = new PTDetectInfo.Builder().faceActionCounter((Map)localObject1).handActionCounter((Map)localObject2).triggeredExpression(localSet).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).timestamp(paramPTFaceAttr.getTimeStamp()).build();
      BenchUtil.benchStart("[filament] updateActionTriggered 1");
      paramPTFaceAttr = this.glbList.iterator();
      while (paramPTFaceAttr.hasNext()) {
        ((GLBItemJava)paramPTFaceAttr.next()).updateActionTriggered(paramAIAttr);
      }
      paramPTFaceAttr = ((GLBItemJava)this.glbList.get(paramInt)).nodeList.iterator();
      while (paramPTFaceAttr.hasNext())
      {
        localObject1 = (NodeItemJava)paramPTFaceAttr.next();
        ((NodeItemJava)localObject1).updateActionTriggered(paramAIAttr);
        localObject2 = ((NodeItemJava)localObject1).getTexture(((GLBItemJava)this.glbList.get(paramInt)).folder);
        this.filamentJNI.setMaterialImage((String)localObject2, ((NodeItemJava)localObject1).name, ((NodeItemJava)localObject1).material, true, false);
      }
    }
  }
  
  private void updateJawOpenThreshold(List<GLBItemJava> paramList)
  {
    paramList = paramList.iterator();
    label35:
    NodeItemJava localNodeItemJava;
    Object localObject;
    float f1;
    if (paramList.hasNext())
    {
      Iterator localIterator = ((GLBItemJava)paramList.next()).nodeList.iterator();
      if (localIterator.hasNext())
      {
        localNodeItemJava = (NodeItemJava)localIterator.next();
        localObject = localNodeItemJava.expressionConfigList.iterator();
        f1 = 1.1F;
        label73:
        if (((Iterator)localObject).hasNext())
        {
          AnimojiExpressionJava localAnimojiExpressionJava = (AnimojiExpressionJava)((Iterator)localObject).next();
          if (!localAnimojiExpressionJava.shapeName.equals("disableeyeblinkwhenopenjaw")) {
            break label204;
          }
          float f2 = localAnimojiExpressionJava.shapeRange.min;
          if (f2 > 0.0F)
          {
            f1 = f2;
            if (f2 <= 1.0F) {}
          }
          else
          {
            f1 = 1.1F;
          }
        }
      }
    }
    label204:
    for (;;)
    {
      break label73;
      this.jawOpenThresholdMap.put(localNodeItemJava.name, Float.valueOf(f1));
      if ((this.triggerManager == null) || (localNodeItemJava == null)) {
        break label35;
      }
      localObject = new TriggerCtrlItem(localNodeItemJava);
      if (localObject == null) {
        break label35;
      }
      this.triggerManager.addTriggers((AETriggerI)localObject);
      localNodeItemJava.triggerCtrlItem = ((TriggerCtrlItem)localObject);
      break label35;
      break;
      return;
    }
  }
  
  private void updateParams(AIAttr paramAIAttr, @NotNull PTFaceAttr paramPTFaceAttr, Frame paramFrame)
  {
    this.needRender = false;
    if (!this.modelReady) {}
    do
    {
      return;
      if (!this.modelLoadSucceed) {
        loadGlbData();
      }
    } while (CollectionUtils.isEmpty(paramPTFaceAttr.getFaceInfoList()));
    int m = Math.min(paramPTFaceAttr.getFaceInfoList().size(), this.filamentJNI.getMaxFaceCount());
    int i = 0;
    while (i < this.glbList.size())
    {
      updateActionTriggered(i, paramAIAttr, paramPTFaceAttr);
      i += 1;
    }
    i = 0;
    paramAIAttr = new int[paramPTFaceAttr.getFaceInfoList().size()];
    int j = 0;
    Object localObject1;
    if (j < m)
    {
      localObject1 = (FaceInfo)paramPTFaceAttr.getFaceInfoList().get(j);
      paramAIAttr[j] = ((FaceInfo)localObject1).gender;
      if (FilamentJavaUtil.isValidTransform(((FaceInfo)localObject1).transform)) {}
    }
    for (;;)
    {
      j += 1;
      break;
      Object localObject2 = new float[16];
      Matrix.transposeM((float[])localObject2, 0, ((FaceInfo)localObject1).transform, 0);
      this.filamentJNI.setMaterialTransform(j, (float[])localObject2, ((FaceInfo)localObject1).denseFaceModel);
      localObject2 = ((FaceInfo)localObject1).eyeRollWeights;
      int k = 0;
      label957:
      while (k < this.glbList.size())
      {
        Object localObject3 = (GLBItemJava)this.glbList.get(k);
        Object localObject4;
        if (((FaceInfo)localObject1).expressionWeights != null)
        {
          localObject4 = ((GLBItemJava)localObject3).nodeList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            NodeItemJava localNodeItemJava = (NodeItemJava)((Iterator)localObject4).next();
            if (localNodeItemJava.enableExpressionConfigRemap) {
              FilamentJavaUtil.adjustExpressionWeights(localNodeItemJava.expressionConfigList, ((FaceInfo)localObject1).expressionWeights, ((Float)this.jawOpenThresholdMap.get(localNodeItemJava.name)).floatValue(), ((FaceInfo)localObject1).angles);
            }
            FilamentJavaUtil.setMorphWeights(this.filamentJNI, localNodeItemJava, ((FaceInfo)localObject1).expressionWeights, j, k);
          }
        }
        localObject3 = ((GLBItemJava)localObject3).eyeNodeList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (EyeNodeItem)((Iterator)localObject3).next();
          this.filamentJNI.updateEyeNodeEuler(((EyeNodeItem)localObject4).name, (float[])localObject2, j, k);
        }
        k += 1;
        continue;
        localObject1 = new int[this.glbList.size()];
        j = 0;
        while (j < localObject1.length)
        {
          localObject1[j] = ((GLBItemJava)this.glbList.get(j)).isHit();
          j += 1;
        }
        this.filamentJNI.setHeadCount(i);
        this.filamentJNI.changeAssetsDynamic((int[])localObject1, localObject1.length, paramAIAttr, paramAIAttr.length);
        averageL = (float)paramPTFaceAttr.getFaceAverageL();
        this.filamentJNI.setAverageL(averageL);
        if ((this.needFaceMesh) && (this.modelLoadSucceed))
        {
          this.mCopyFilter.setRotationAndFlip(this.rotation, 0, 0);
          paramAIAttr = rotate(this.width, this.height);
          if (!this.canUseShareContext) {
            break label1020;
          }
          if (this.faceMeshTextureKey.isEmpty()) {
            break label979;
          }
          paramPTFaceAttr = (Frame)this.frames.get(this.faceMeshTextureKey);
          if (paramPTFaceAttr != null) {
            this.mCopyFilter.RenderProcess(paramPTFaceAttr.getTextureId(), paramAIAttr.x, paramAIAttr.y, this.cameraTexture.getId(this.filamentJNI.getEngine()), 0.0D, this.mCopyFrame);
          }
          GLES20.glFlush();
        }
        label711:
        label976:
        label979:
        label1365:
        label1368:
        label1371:
        for (;;)
        {
          this.mCopyFilter.setRotationAndFlip(0, 0, 0);
          if (this.hasSetCameraTexture)
          {
            this.mCopyFilter.setRotationAndFlip(this.rotation, 0, 0);
            paramAIAttr = rotate(this.width, this.height);
            if (this.canUseShareContext)
            {
              this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramAIAttr.x, paramAIAttr.y, this.cameraTexture.getId(this.filamentJNI.getEngine()), 0.0D, this.mCopyFrame);
              this.mCopyFilter.setRotationAndFlip(0, 0, 0);
              paramAIAttr = this.filamentJNI;
              long l = this.cameraTexture.getNativeObject();
              paramAIAttr.setDynamicTexture(new String[] { "$cameraTexture" }, new long[] { l });
            }
          }
          else
          {
            if ((this.keys.isEmpty()) || (this.frames.isEmpty())) {
              break label1291;
            }
            paramAIAttr = new ArrayList();
            paramPTFaceAttr = new long[this.keys.size()];
            this.mCopyFilter.setRotationAndFlip(this.rotation, 0, 0);
            paramFrame = this.keys.iterator();
            i = 0;
            for (;;)
            {
              if (paramFrame.hasNext())
              {
                localObject2 = (String)paramFrame.next();
                paramAIAttr.add(localObject2);
                localObject1 = (Texture)this.cameraTextures.get(i);
                localObject2 = (Frame)this.frames.get(localObject2);
                localObject3 = rotate(((Frame)localObject2).width, ((Frame)localObject2).height);
                if (localObject2 == null) {
                  break label1365;
                }
                if (this.canUseShareContext)
                {
                  this.mCopyFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Point)localObject3).x, ((Point)localObject3).y, ((Texture)localObject1).getId(this.filamentJNI.getEngine()), 0.0D, this.mCopyFrame);
                  j = i + 1;
                  paramPTFaceAttr[i] = ((Texture)localObject1).getNativeObject();
                  i = j;
                  continue;
                  this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramAIAttr.x, paramAIAttr.y, this.cameraTexture.getId(this.filamentJNI.getEngine()), 0.0D, this.mCopyFrame);
                  break;
                  label1020:
                  if (!this.faceMeshTextureKey.isEmpty())
                  {
                    paramPTFaceAttr = (Frame)this.frames.get(this.faceMeshTextureKey);
                    if (paramPTFaceAttr == null) {
                      break label1368;
                    }
                    this.mCopyFilter.RenderProcess(paramPTFaceAttr.getTextureId(), paramAIAttr.x, paramAIAttr.y, -1, 0.0D, this.mCopyFrame);
                    paramAIAttr = RendererUtils.saveTexture(this.mCopyFrame);
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (paramAIAttr == null) {
              break label1371;
            }
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), this.cameraTexture, 0, paramAIAttr);
            break;
            this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramAIAttr.x, paramAIAttr.y, -1, 0.0D, this.mCopyFrame);
            paramAIAttr = RendererUtils.saveTexture(this.mCopyFrame);
            continue;
            this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramAIAttr.x, paramAIAttr.y, -1, 0.0D, this.mCopyFrame);
            paramAIAttr = RendererUtils.saveTexture(this.mCopyFrame);
            if (paramAIAttr == null) {
              break label711;
            }
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), this.cameraTexture, 0, paramAIAttr);
            break label711;
            this.mCopyFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Point)localObject3).x, ((Point)localObject3).y, -1, 0.0D, this.mCopyFrame);
            localObject2 = RendererUtils.saveTexture(this.mCopyFrame);
            if (localObject2 == null) {
              break label957;
            }
            TextureHelper.setBitmap(this.filamentJNI.getEngine(), (Texture)localObject1, 0, (Bitmap)localObject2);
            break label957;
            this.mCopyFilter.setRotationAndFlip(0, 0, 0);
            this.filamentJNI.setDynamicTexture((String[])paramAIAttr.toArray(new String[0]), paramPTFaceAttr);
            if ((!this.keys.isEmpty()) && (this.frames.isEmpty())) {
              LogUtils.e(TAG, "自定义shader配置错误，导致获取不到吐出的frame（请检查滤镜顺序）。");
            }
            LogUtils.d(TAG, "test for averageL: " + averageL);
            this.filamentJNI.render();
            this.needRender = true;
            return;
            break label976;
            paramAIAttr = null;
          }
        }
      }
      label1291:
      i += 1;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void addBone(String paramString)
  {
    this.filamentJNI.addBone(paramString);
  }
  
  public void deleteBone(String paramString)
  {
    this.filamentJNI.deleteBone(paramString);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.cameraTextures.iterator();
    while (localIterator.hasNext())
    {
      Texture localTexture = (Texture)localIterator.next();
      this.filamentJNI.getEngine().destroyTexture(localTexture);
    }
    LogUtils.d(TAG, "test for filament destory 1");
    this.mHandler.destroy();
    this.surfaceTexture.setOnFrameAvailableListener(null);
    LogUtils.d(TAG, "test for filament destory 2");
    this.surface.release();
    this.surfaceTexture.release();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.filamentFrame.clear();
    this.mCopyFrame.clear();
    this.mCopyFilter.clearGLSLSelf();
    this.mPreviewFilter.clearGLSLSelf();
    if (this.filamentJNI != null) {
      this.filamentJNI.destroy();
    }
    FilaBenchUtil.init();
    LogUtils.d(TAG, "test for filament destory 3");
  }
  
  public void exportLightParams(JsonObject paramJsonObject)
    throws JSONException
  {
    int j = 0;
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, VideoMaterialUtil.GLB_FIELD.LIGHT.value);
    if (paramJsonObject != null)
    {
      paramJsonObject.addProperty(VideoMaterialUtil.GLB_FIELD.INTENSITY.value, Integer.valueOf(getDirectionIntensity()));
      Object localObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.DIRECTION.value);
      int i;
      if (localObject != null)
      {
        float[] arrayOfFloat = this.filamentJNI.getLightDirection();
        i = 0;
        while ((i < ((JsonArray)localObject).size()) && (i < 3))
        {
          ((JsonArray)localObject).set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
          i += 1;
        }
      }
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, VideoMaterialUtil.GLB_FIELD.COLOR.value);
      if (paramJsonObject != null)
      {
        localObject = this.filamentJNI.getDirectionColor();
        i = j;
        while ((i < paramJsonObject.size()) && (i < 3))
        {
          paramJsonObject.set(i, new JsonPrimitive(Float.valueOf(localObject[i])));
          i += 1;
        }
      }
    }
  }
  
  public boolean exportParams()
  {
    JsonObject localJsonObject = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(this.dataPath, "params", true, VideoTemplateParser.decryptListener);
    Object localObject = GsonUtils.optJsonArray(localJsonObject, VideoMaterialUtil.GLB_FIELD.GLB_LIST.value);
    if (localObject != null)
    {
      localObject = GsonUtils.optJsonObject((JsonArray)localObject, 0);
      if (localObject == null) {}
    }
    try
    {
      JsonArray localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.TRANSLATE.value);
      float[] arrayOfFloat;
      int i;
      if (localJsonArray != null)
      {
        arrayOfFloat = this.filamentJNI.getPosition();
        i = 0;
        while ((i < localJsonArray.size()) && (i < 3))
        {
          localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
          i += 1;
        }
      }
      localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.SCALE.value);
      if (localJsonArray != null)
      {
        arrayOfFloat = this.filamentJNI.getScale();
        i = 0;
        while ((i < localJsonArray.size()) && (i < 3))
        {
          localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
          i += 1;
        }
      }
      localJsonArray = GsonUtils.optJsonArray((JsonObject)localObject, VideoMaterialUtil.GLB_FIELD.ROTATE.value);
      if (localJsonArray != null)
      {
        arrayOfFloat = this.filamentJNI.getRotation();
        i = 0;
        while ((i < localJsonArray.size()) && (i < 3))
        {
          localJsonArray.set(i, new JsonPrimitive(Float.valueOf(arrayOfFloat[i])));
          i += 1;
        }
      }
      ((JsonObject)localObject).addProperty(VideoMaterialUtil.GLB_FIELD.IBL_INTENSITY.value, Integer.valueOf(this.filamentJNI.getIblIntensity()));
      ((JsonObject)localObject).addProperty(VideoMaterialUtil.GLB_FIELD.IBL_ROTATION.value, Integer.valueOf(this.filamentJNI.getIblRotation()));
      exportLightParams((JsonObject)localObject);
      FileUtils.saveFile(this.dataPath + "/" + "params" + ".json", localJsonObject.toString());
      return true;
    }
    catch (JSONException localJSONException) {}
    return false;
  }
  
  public String getDirectionColor()
  {
    float[] arrayOfFloat = this.filamentJNI.getDirectionColor();
    return ColorUtil.rgb2Hex(new int[] { (int)arrayOfFloat[0] * 255, (int)arrayOfFloat[1] * 255, (int)arrayOfFloat[2] * 255 });
  }
  
  public int getDirectionIntensity()
  {
    return this.filamentJNI.getDirectionIntensity();
  }
  
  public List<GLBItemJava> getGlbList()
  {
    return this.glbList;
  }
  
  public int getIblIntensity()
  {
    return this.filamentJNI.getIblIntensity();
  }
  
  public int getIblRotation()
  {
    return this.filamentJNI.getIblRotation();
  }
  
  public float[] getLightDirection()
  {
    float[] arrayOfFloat = this.filamentJNI.getLightDirection();
    return FilamentJavaUtil.xyz2lglt(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
  }
  
  public float[] getPosition()
  {
    return this.filamentJNI.getPosition();
  }
  
  public float[] getRotation()
  {
    float[] arrayOfFloat = this.filamentJNI.getRotation();
    return new float[] { arrayOfFloat[0] * 180.0F / 3.141593F, arrayOfFloat[1] * 180.0F / 3.141593F, arrayOfFloat[2] * 180.0F / 3.141593F };
  }
  
  public float[] getScale()
  {
    float[] arrayOfFloat = this.filamentJNI.getScale();
    return new float[] { arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2] };
  }
  
  public void initial()
  {
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.INIT.tag);
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.FIRST_RENDER.tag);
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.AFTER_RENDER.tag);
    GlUtil.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.mHandler.postJobSync(new FilamentFilter.2(this));
    this.mPreviewFilter.apply();
    this.mCopyFilter.apply();
    this.surface = new Surface(this.surfaceTexture);
    String str2 = VideoTemplateParser.readMaterialFile(this.dataPath, "params", true, VideoTemplateParser.decryptListener);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jsonData = str1.getBytes();
    this.surfaceTexture.setOnFrameAvailableListener(new FilamentFilter.3(this));
    FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.INIT.tag);
  }
  
  public boolean isModelReady()
  {
    return this.modelReady;
  }
  
  public Frame render(Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr)
  {
    BenchUtil.benchStart("[filament] updateParams");
    if ((this.needFaceMesh) && (!this.canUseShareContext) && (!DeviceUtils.hasDeviceHigh(AEModule.getContext()))) {
      return paramFrame;
    }
    resize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getRotation());
    initCameraTexture();
    updateParams(paramAIAttr, paramPTFaceAttr, paramFrame);
    BenchUtil.benchEnd("[filament] updateParams");
    long l1 = FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.FIRST_RENDER.tag);
    if (!this.needRender)
    {
      this.skipFrame = 0;
      return paramFrame;
    }
    LogUtils.d(TAG, "test for filament render called");
    FilaBenchUtil.benchStart(FilamentJavaUtil.BenchTag.FIRST_FRAME.tag);
    try
    {
      BenchUtil.benchStart("[filament] wait");
      paramAIAttr = (Runnable)this.drawQueue.take();
      BenchUtil.benchEnd("[filament] wait");
      BenchUtil.benchStart("[filament] render");
      paramAIAttr.run();
      BenchUtil.benchEnd("[filament] render");
      long l2 = FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.FIRST_FRAME.tag);
      if ((l1 > 0L) && (this.onLoadFinishListener != null)) {
        this.onLoadFinishListener.onLoadFinish(l2 + l1);
      }
      FilaBenchUtil.benchEnd(FilamentJavaUtil.BenchTag.AFTER_RENDER.tag);
      FilaBenchUtil.reset();
      if (this.skipFrame < 1)
      {
        this.skipFrame += 1;
        return paramFrame;
      }
    }
    catch (InterruptedException paramAIAttr)
    {
      for (;;)
      {
        paramAIAttr.printStackTrace();
      }
      GlUtil.setBlendMode(true);
      this.mCopyFilter.RenderProcess(this.filamentFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      GlUtil.setBlendMode(false);
    }
    return paramFrame;
  }
  
  public void reset()
  {
    Iterator localIterator1 = this.glbList.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((GLBItemJava)localIterator1.next()).nodeList.iterator();
      while (localIterator2.hasNext()) {
        ((NodeItemJava)localIterator2.next()).reset();
      }
    }
    if (this.filamentJNI != null) {
      this.filamentJNI.reset();
    }
  }
  
  public void setAnimationItemNames(List<String> paramList)
  {
    this.animationItemNames = paramList;
  }
  
  public void setDefaultAnimation(String paramString, int paramInt)
  {
    this.defaultAnimationName = paramString;
    this.defaultAnimationPlaycount = paramInt;
  }
  
  public void setDirectionColor(String paramString)
  {
    if (this.filamentJNI != null)
    {
      paramString = ColorUtil.hex2Rgb(paramString);
      this.filamentJNI.setDirectionColor(paramString[0] / 255.0F, paramString[1] / 255.0F, paramString[2] / 255.0F);
    }
  }
  
  public void setDirectionIntensity(int paramInt)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setDirectionIntensity(paramInt);
    }
  }
  
  public void setFrames(Map<String, Frame> paramMap)
  {
    if (paramMap == null)
    {
      this.frames = new HashMap();
      return;
    }
    this.frames = paramMap;
  }
  
  public void setIblIntensity(int paramInt)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setIblIntensity(paramInt);
    }
  }
  
  public void setIblRotation(int paramInt)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setIblDegree(paramInt);
    }
  }
  
  public void setLightDirection(float paramFloat1, float paramFloat2)
  {
    if (this.filamentJNI != null)
    {
      float[] arrayOfFloat = FilamentJavaUtil.lglt2xyz(paramFloat1, paramFloat2);
      this.filamentJNI.setLightDirection(-arrayOfFloat[0], arrayOfFloat[1], -arrayOfFloat[2]);
    }
  }
  
  public void setLightIntensity(int paramInt) {}
  
  public void setOnLoadFinishListener(MaterialLoadFinishListener paramMaterialLoadFinishListener)
  {
    this.onLoadFinishListener = paramMaterialLoadFinishListener;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setPosition(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setRotation(paramFloat1 * 3.141593F / 180.0F, paramFloat2 * 3.141593F / 180.0F, 3.141593F * paramFloat3 / 180.0F);
    }
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentJNI != null) {
      this.filamentJNI.setScale(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public boolean updateBoneGravity(String paramString, float[] paramArrayOfFloat)
  {
    return this.filamentJNI.updateBoneGravity(paramString, paramArrayOfFloat);
  }
  
  public boolean updateBoneNoRotationUpdate(String paramString, int paramInt)
  {
    return this.filamentJNI.updateBoneNoRotationUpdate(paramString, paramInt);
  }
  
  public boolean updateBoneParams(String paramString1, int paramInt, String paramString2, float paramFloat)
  {
    return this.filamentJNI.updateBoneParams(paramString1, paramInt, paramString2, paramFloat);
  }
  
  public void updateIntensity(float paramFloat, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.filamentJNI != null) {
        this.filamentJNI.updateIntensityMap(this.key, this.value);
      }
      return;
      this.key[paramInt1] = paramFloat;
      continue;
      this.value[paramInt1] = paramFloat;
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if (this.filamentJNI == null) {
      return;
    }
    Iterator localIterator = ((Map)paramObject).entrySet().iterator();
    int k = 1;
    int i = 0;
    label29:
    String str;
    Integer localInteger;
    int m;
    int j;
    if (localIterator.hasNext())
    {
      paramObject = (Map.Entry)localIterator.next();
      str = (String)paramObject.getKey();
      localInteger = (Integer)paramObject.getValue();
      m = i;
      if (localInteger == null) {
        break label349;
      }
      if ((!this.filamentJNI.isAnimationRunning(str)) && (localInteger.intValue() >= 0))
      {
        if ((!TextUtils.isEmpty(this.defaultAnimationName)) && (!str.equals(this.defaultAnimationName)) && (this.filamentJNI.isAnimationRunning(this.defaultAnimationName))) {
          this.filamentJNI.stopAnimation(this.defaultAnimationName);
        }
        if (localInteger.intValue() == 0)
        {
          j = 999;
          label159:
          paramObject = Integer.valueOf(j);
          this.filamentJNI.playAnimation(str, paramObject.intValue());
          j = i;
          label179:
          m = j;
          if (paramObject.intValue() <= 0) {
            break label349;
          }
          k = 0;
          i = j;
          j = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      break label29;
      j = localInteger.intValue();
      break label159;
      paramObject = localInteger;
      j = i;
      if (!this.filamentJNI.isAnimationRunning(str)) {
        break label179;
      }
      paramObject = localInteger;
      j = i;
      if (localInteger.intValue() >= 0) {
        break label179;
      }
      if (!str.equals(this.defaultAnimationName))
      {
        this.filamentJNI.stopAnimation(str);
        paramObject = localInteger;
        j = i;
        if (TextUtils.isEmpty(this.defaultAnimationName)) {
          break label179;
        }
        paramObject = localInteger;
        j = i;
        if (this.filamentJNI.isAnimationRunning(this.defaultAnimationName)) {
          break label179;
        }
        this.filamentJNI.playAnimation(this.defaultAnimationName, this.defaultAnimationPlaycount);
        paramObject = localInteger;
        j = i;
        break label179;
      }
      j = 1;
      paramObject = localInteger;
      break label179;
      if ((k != 0) || (i == 0)) {
        break;
      }
      this.filamentJNI.stopAnimation(this.defaultAnimationName);
      return;
      label349:
      j = k;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter
 * JD-Core Version:    0.7.0.1
 */