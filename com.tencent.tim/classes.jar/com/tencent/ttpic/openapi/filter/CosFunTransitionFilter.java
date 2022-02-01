package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.filter.CFFaceOffFilter;
import com.tencent.ttpic.filter.CFSkinCropFilter;
import com.tencent.ttpic.filter.CFSkinCropFilterV2;
import com.tencent.ttpic.model.FaceFeature;
import com.tencent.ttpic.model.FaceFeatureTex;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.model.CosFunParam;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate.ImageLayer;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.util.CfTemplateParser;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CosFunTransitionFilter
{
  private SizeI MAX_SIZE;
  private final int backgroundMode1;
  private final int backgroundMode2;
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private FaceFeatureTex dstFeature;
  private boolean isInited = false;
  private Frame materialFrame;
  private FaceFeatureTex srcFeature;
  private CrazyFaceDataTemplate template;
  private CFTransformFilterForTex transFilter;
  private List<CosFunParam> userCosFunParams = new ArrayList();
  
  public CosFunTransitionFilter(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    this.template = CfTemplateParser.parseCrazyFace(FileUtils.getRealPath(paramString), (String)localObject);
    this.MAX_SIZE = initMaxLength();
    this.backgroundMode1 = paramInt1;
    this.backgroundMode2 = paramInt2;
    if (this.template == null) {}
    do
    {
      return;
      paramString = FaceOffUtil.getFaceBitmap(this.template.folderPath + File.separator + this.template.getFaceLayer(0).imagePath, this.MAX_SIZE.width, this.MAX_SIZE.height);
    } while (!BitmapUtils.isLegal(paramString));
    paramInt1 = RendererUtils.createTexture(paramString);
    paramString.recycle();
    this.materialFrame = new Frame(0, paramInt1, paramString.getWidth(), paramString.getHeight());
    this.isInited = true;
  }
  
  private SizeI initMaxLength()
  {
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
      return new SizeI(1080, 1920);
    }
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      return new SizeI(720, 1280);
    }
    return new SizeI(720, 1280);
  }
  
  private void processCosFun()
  {
    BenchUtil.benchStart("[CosFunTransitionFilter] initCos 0");
    if ((this.template == null) || (this.materialFrame == null)) {
      return;
    }
    this.copyFilter.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
    Object localObject2 = this.template.faceLayers;
    FaceImageLayer localFaceImageLayer1 = this.template.getFaceLayer(0);
    int i = (int)Math.min(localFaceImageLayer1.width, this.MAX_SIZE.width);
    int j = (int)Math.min(localFaceImageLayer1.height, this.MAX_SIZE.height);
    double d = Math.min(i / localFaceImageLayer1.width, j / localFaceImageLayer1.height);
    j = (int)(localFaceImageLayer1.width * d);
    int k = (int)(localFaceImageLayer1.height * d);
    CFFaceOffFilter localCFFaceOffFilter = new CFFaceOffFilter(this.template.folderPath);
    localCFFaceOffFilter.updateVideoSize(j, k, d);
    localCFFaceOffFilter.ApplyGLSLFilter();
    BenchUtil.benchEnd("[CosFunTransitionFilter] initCos 0");
    BenchUtil.benchStart("[CosFunTransitionFilter] initCos 1");
    Object localObject1 = new Frame();
    this.copyFilter.RenderProcess(this.materialFrame.getTextureId(), this.materialFrame.width, this.materialFrame.height, -1, 0.0D, (Frame)localObject1);
    BenchUtil.benchEnd("[CosFunTransitionFilter] initCos 1");
    i = 0;
    while (i < ((List)localObject2).size())
    {
      BenchUtil.benchStart("[CosFunTransitionFilter] processCos 0");
      localFrame = new Frame();
      this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), j, k, -1, 0.0D, localFrame);
      CosFunParam localCosFunParam = (CosFunParam)this.userCosFunParams.get(i);
      FaceImageLayer localFaceImageLayer2 = (FaceImageLayer)((List)localObject2).get(i);
      localCFFaceOffFilter.setFaceLayer(localFaceImageLayer2);
      localCFFaceOffFilter.setUserFaceTex(localCosFunParam.mFaceTexture);
      localCFFaceOffFilter.setSkinColorParams(localCosFunParam);
      BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 0");
      BenchUtil.benchStart("[CosFunTransitionFilter] processCos 1");
      localCFFaceOffFilter.setFacePointsInfo(localCosFunParam.mUserFacePointsList, localCosFunParam.mWidth, localCosFunParam.mHeight, localFaceImageLayer2.faceTriangleID);
      BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 1");
      BenchUtil.benchStart("[CosFunTransitionFilter] processCos 2");
      localCFFaceOffFilter.RenderProcess(((Frame)localObject1).getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, localFrame);
      ((Frame)localObject1).clear();
      this.dstFeature.faceFeature = localCFFaceOffFilter.getFaceFeature();
      BenchUtil.benchEnd("[CosFunTransitionFilter] processCos 2");
      i += 1;
      localObject1 = localFrame;
    }
    localCFFaceOffFilter.clearGLSLSelf();
    BenchUtil.benchStart("[CosFunTransitionFilter] processBgFg");
    d = ((Frame)localObject1).width / localFaceImageLayer1.width;
    i = (int)(this.template.width * d);
    j = (int)(this.template.height * d);
    GlUtil.setBlendMode(true);
    Frame localFrame = new Frame();
    if (this.template.backgroundLayer != null)
    {
      localObject2 = FaceOffUtil.getFaceBitmap(this.template.folderPath + File.separator + this.template.backgroundLayer.imagePath, this.MAX_SIZE.width, this.MAX_SIZE.height);
      f1 = (float)this.template.backgroundLayer.x;
      f2 = (float)(this.template.backgroundLayer.x + this.template.backgroundLayer.width);
      f3 = (float)this.template.backgroundLayer.y;
      f4 = (float)(this.template.backgroundLayer.y + this.template.backgroundLayer.height);
      k = RendererUtils.createTexture((Bitmap)localObject2);
      ((Bitmap)localObject2).recycle();
      this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
      this.copyFilter.RenderProcess(k, i, j, -1, 0.0D, localFrame);
      RendererUtils.clearTexture(k);
    }
    float f1 = (float)localFaceImageLayer1.x;
    float f2 = (float)(localFaceImageLayer1.x + localFaceImageLayer1.width);
    float f3 = (float)localFaceImageLayer1.y;
    float f4 = (float)(localFaceImageLayer1.y + localFaceImageLayer1.height);
    this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
    this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), i, j, -1, 0.0D, localFrame);
    ((Frame)localObject1).clear();
    if (this.template.foregroundLayer != null)
    {
      localObject1 = FaceOffUtil.getFaceBitmap(this.template.folderPath + File.separator + this.template.foregroundLayer.imagePath, this.MAX_SIZE.width, this.MAX_SIZE.height);
      f1 = (float)this.template.foregroundLayer.x;
      f2 = (float)(this.template.foregroundLayer.x + this.template.foregroundLayer.width);
      f3 = (float)this.template.foregroundLayer.y;
      f4 = (float)(this.template.foregroundLayer.y + this.template.foregroundLayer.height);
      k = RendererUtils.createTexture((Bitmap)localObject1);
      ((Bitmap)localObject1).recycle();
      this.copyFilter.setPositions(AlgoUtils.calPositions(f1, f4, f2, f3, (int)this.template.width, (int)this.template.height));
      this.copyFilter.RenderProcess(k, i, j, -1, 0.0D, localFrame);
      RendererUtils.clearTexture(k);
    }
    GlUtil.setBlendMode(false);
    GlUtil.resetFilterCoords(this.copyFilter);
    CosFunUtil.scale(this.dstFeature.faceFeature, d);
    this.dstFeature.faceTex = RendererUtils.createTexture();
    localObject1 = new Frame();
    this.copyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, this.dstFeature.faceTex, 0.0D, (Frame)localObject1);
    ((Frame)localObject1).clear();
    localFrame.clear();
    BenchUtil.benchEnd("[CosFunTransitionFilter] processBgFg");
  }
  
  private CosFunParam processUserBitmap(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, FaceImageLayer paramFaceImageLayer)
  {
    BenchUtil.benchStart("[CosFunTransitionFilter] crop");
    CosFunParam localCosFunParam = new CosFunParam();
    Object localObject1 = (PointF)paramList.get(101);
    Object localObject2 = (PointF)paramList.get(99);
    PointF localPointF1 = (PointF)paramList.get(105);
    PointF localPointF2 = (PointF)paramList.get(103);
    int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF1);
    int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
    float f1 = ((PointF)localObject2).x / paramInt2;
    float f2 = ((PointF)localObject2).y / paramInt3;
    float f3 = ((PointF)localObject1).x / paramInt2;
    float f4 = ((PointF)localObject1).y / paramInt3;
    float f5 = localPointF2.x / paramInt2;
    float f6 = localPointF2.y / paramInt3;
    float f7 = localPointF1.x / paramInt2;
    float f8 = localPointF1.y / paramInt3;
    this.copyFilter.setTexCords(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 });
    localCosFunParam.mFaceTexture = RendererUtils.createTexture();
    localObject1 = new Frame();
    this.copyFilter.RenderProcess(paramInt1, i, j, localCosFunParam.mFaceTexture, 0.0D, (Frame)localObject1);
    ((Frame)localObject1).clear();
    BenchUtil.benchEnd("[CosFunTransitionFilter] crop");
    BenchUtil.benchStart("[CosFunTransitionFilter] updateFacePoints");
    CosFunUtil.updateFacePoints(paramList);
    BenchUtil.benchEnd("[CosFunTransitionFilter] updateFacePoints");
    BenchUtil.benchStart("[CosFunTransitionFilter] calSkin");
    localObject1 = new Frame();
    if (paramFaceImageLayer.getVersion() == 1)
    {
      localObject2 = new CFSkinCropFilter();
      ((CFSkinCropFilter)localObject2).setFacePoints(paramList);
      ((CFSkinCropFilter)localObject2).applyFilterChain(false, i, j);
      ((CFSkinCropFilter)localObject2).RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor);
      ((CFSkinCropFilter)localObject2).clearGLSLSelf();
    }
    for (;;)
    {
      ((Frame)localObject1).clear();
      BenchUtil.benchEnd("[CosFunTransitionFilter] calSkin");
      localCosFunParam.mWidth = i;
      localCosFunParam.mHeight = j;
      localCosFunParam.mUserFacePointsList = paramList;
      return localCosFunParam;
      localObject2 = new CFSkinCropFilterV2(this.template.folderPath);
      ((CFSkinCropFilterV2)localObject2).setFacePointsInfo(paramList, i, j, paramFaceImageLayer.faceTriangleID);
      ((CFSkinCropFilterV2)localObject2).ApplyGLSLFilter();
      ((CFSkinCropFilterV2)localObject2).RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor2, paramFaceImageLayer.faceColorRange);
      ((CFSkinCropFilterV2)localObject2).clearGLSLSelf();
    }
  }
  
  public void destroy()
  {
    this.copyFilter.clearGLSLSelf();
    if (this.dstFeature != null) {
      RendererUtils.clearTexture(this.dstFeature.faceTex);
    }
    Iterator localIterator = this.userCosFunParams.iterator();
    while (localIterator.hasNext()) {
      RendererUtils.clearTexture(((CosFunParam)localIterator.next()).mFaceTexture);
    }
    if (this.transFilter != null) {
      this.transFilter.clearGLSLSelf();
    }
    if (this.materialFrame != null) {
      RendererUtils.clearTexture(this.materialFrame.getTextureId());
    }
    FaceOffUtil.recycleCrazySkinMergeBitmap();
  }
  
  public int getHeight()
  {
    if (this.template == null) {
      return 0;
    }
    return (int)this.template.height;
  }
  
  public Frame getMergedFrame(float paramFloat)
  {
    if (this.transFilter == null) {
      return this.materialFrame;
    }
    return this.transFilter.getMergedFrame(paramFloat);
  }
  
  public int getWidth()
  {
    if (this.template == null) {
      return 0;
    }
    return (int)this.template.width;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, double paramDouble)
  {
    this.copyFilter.ApplyGLSLFilter();
    BenchUtil.benchStart("[CosFunTransitionFilter] preprocess");
    paramList = VideoMaterialUtil.copyList(paramList);
    CosFunUtil.scale(paramList, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    this.srcFeature = new FaceFeatureTex();
    this.dstFeature = new FaceFeatureTex();
    this.srcFeature.faceFeature = new FaceFeature(paramList, paramInt2, paramInt3);
    this.srcFeature.faceTex = paramInt1;
    BenchUtil.benchEnd("[CosFunTransitionFilter] preprocess");
    BenchUtil.benchStart("[CosFunTransitionFilter] processUserBitmap");
    if (this.template != null)
    {
      int i = 0;
      while (i < this.template.faceLayers.size())
      {
        Object localObject = (FaceImageLayer)this.template.faceLayers.get(i);
        localObject = processUserBitmap(paramInt1, paramInt2, paramInt3, VideoMaterialUtil.copyList(paramList), (FaceImageLayer)localObject);
        this.userCosFunParams.add(localObject);
        i += 1;
      }
    }
    BenchUtil.benchEnd("[CosFunTransitionFilter] processUserBitmap");
    BenchUtil.benchStart("[CosFunTransitionFilter] processCosFun");
    processCosFun();
    BenchUtil.benchEnd("[CosFunTransitionFilter] processCosFun");
    if (this.dstFeature.faceFeature != null)
    {
      this.transFilter = new CFTransformFilterForTex(this.srcFeature, this.dstFeature, this.backgroundMode1, this.backgroundMode2);
      this.transFilter.ApplyGLSLFilter();
    }
  }
  
  public boolean isInited()
  {
    return this.isInited;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CosFunTransitionFilter
 * JD-Core Version:    0.7.0.1
 */