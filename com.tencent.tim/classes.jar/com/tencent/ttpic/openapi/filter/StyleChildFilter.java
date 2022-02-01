package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Process;
import com.tencent.ttpic.openapi.model.FaceStyleItem.Render;
import com.tencent.ttpic.openapi.model.FaceStyleItem.STYLE_CHANGE_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StyleChildFilter
  extends AEChainI
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = "StyleChildFilter";
  private SizeI NET_SIZE = new SizeI(256, 256);
  private CartoonStylePreProcessFilter cartoonStylePreProcessFilter;
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private BGColorCropFilter cropFilter = new BGColorCropFilter();
  private Frame cropFrame = new Frame();
  private Bitmap faceMask;
  private StyleChildFaceOffFilter faceOffFilter;
  private FaceStyleItem faceStyleItem;
  private VideoFilterBase fillFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private StyleChildTransformFilter fillFilterStyleChild;
  private Frame fillFrame = new Frame();
  private Frame fillFrame2 = new Frame();
  private Frame mDebugFrame = new Frame();
  private int mGANTYPE = 1;
  Bitmap outBitmap;
  private float[] position = new float[8];
  private int[] tex = new int[2];
  private float[] texCoords = new float[8];
  private List<Bitmap> textureBitmapList = new ArrayList();
  private float[] warpArr;
  Bitmap warpMat;
  
  public StyleChildFilter(FaceStyleItem paramFaceStyleItem)
  {
    this.faceStyleItem = paramFaceStyleItem;
    this.mGANTYPE = this.faceStyleItem.styleChangeType;
    setImageNetSize(paramFaceStyleItem.imageSize[0], paramFaceStyleItem.imageSize[1]);
    StyleChildTransformFilter.setFragmentShader(FileUtils.load(AEModule.getContext(), FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.postRender.function));
    this.fillFilterStyleChild = new StyleChildTransformFilter(this.NET_SIZE.width, this.NET_SIZE.height);
    this.faceOffFilter = new StyleChildFaceOffFilter();
    this.cartoonStylePreProcessFilter = new CartoonStylePreProcessFilter();
    this.warpArr = new float[this.NET_SIZE.width * this.NET_SIZE.height * 2];
    this.warpMat = Bitmap.createBitmap(this.NET_SIZE.width, this.NET_SIZE.height, Bitmap.Config.ARGB_8888);
    this.outBitmap = Bitmap.createBitmap(this.NET_SIZE.width, this.NET_SIZE.height, Bitmap.Config.ARGB_8888);
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.setParams(6, this.faceStyleItem.libraryText, this.faceStyleItem.styleChangeType, this.faceStyleItem.initProcess.function, this.faceStyleItem.preProcess.function, this.faceStyleItem.postProcess.function, processBlobNames(this.faceStyleItem.initProcess.blobNames), processBlobNames(this.faceStyleItem.preProcess.blobNames), processBlobNames(this.faceStyleItem.postProcess.blobNames), this.faceStyleItem.initProcess.scale, this.faceStyleItem.initProcess.bias, this.faceStyleItem.preProcess.scale, this.faceStyleItem.preProcess.bias, this.faceStyleItem.postProcess.scale, this.faceStyleItem.postProcess.bias);
    decodeMaterialBitmap();
    if (BitmapUtils.isLegal(this.faceMask)) {
      this.faceOffFilter.loadMask(this.faceMask);
    }
    initProcessMaterial();
    init();
  }
  
  private void decodeMaterialBitmap()
  {
    Object localObject1;
    if (this.faceStyleItem.textureMaterials != null)
    {
      localObject1 = this.faceStyleItem.textureMaterials.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + (String)localObject2;
        if (FileUtils.exists((String)localObject2))
        {
          localObject2 = BitmapUtils.decodeBitmap((String)localObject2, true);
          if (BitmapUtils.isLegal((Bitmap)localObject2)) {
            this.textureBitmapList.add(localObject2);
          }
        }
      }
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postRender.faceMaskName))
    {
      localObject1 = FileUtils.genSeperateFileDir(this.faceStyleItem.dataPath) + this.faceStyleItem.postRender.faceMaskName;
      if (FileUtils.exists((String)localObject1)) {
        this.faceMask = BitmapUtils.decodeBitmap((String)localObject1, true);
      }
    }
  }
  
  private void initProcessMaterial()
  {
    int i = 0;
    int j = 0;
    if (!TextUtils.isEmpty(this.faceStyleItem.initProcess.function))
    {
      Iterator localIterator = this.textureBitmapList.iterator();
      for (i = j; localIterator.hasNext(); i = 1)
      {
        Bitmap localBitmap = (Bitmap)localIterator.next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addInitMat(6, localBitmap, true);
      }
    }
    if (i != 0) {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.initProcess(6);
    }
  }
  
  public static double norm(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  private String processBlobNames(List<String> paramList)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString().trim();
  }
  
  public static void scale(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x * paramDouble));
        localPointF.y = ((float)(localPointF.y * paramDouble));
      }
    }
  }
  
  private void updateCoords(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    int k = 0;
    this.texCoords[0] = paramArrayOfFloat[2];
    this.texCoords[1] = paramArrayOfFloat[5];
    this.texCoords[2] = (this.NET_SIZE.width * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    this.texCoords[3] = (this.NET_SIZE.width * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    this.texCoords[4] = (this.NET_SIZE.width * paramArrayOfFloat[0] + this.NET_SIZE.width * paramArrayOfFloat[1] + paramArrayOfFloat[2]);
    this.texCoords[5] = (this.NET_SIZE.width * paramArrayOfFloat[3] + this.NET_SIZE.width * paramArrayOfFloat[4] + paramArrayOfFloat[5]);
    this.texCoords[6] = (this.NET_SIZE.width * paramArrayOfFloat[0] + paramArrayOfFloat[2]);
    this.texCoords[7] = (this.NET_SIZE.width * paramArrayOfFloat[3] + paramArrayOfFloat[5]);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8) {
        break;
      }
      this.texCoords[i] /= paramInt1;
      this.texCoords[(i + 1)] /= paramInt2;
      i += 2;
    }
    while (j < this.texCoords.length)
    {
      this.position[j] = (this.texCoords[j] * 2.0F - 1.0F);
      j += 1;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public float[] calCropCoordsV2(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramList.get(35));
    ((List)localObject).add(paramList.get(39));
    ((List)localObject).add(paramList.get(45));
    ((List)localObject).add(paramList.get(49));
    ((List)localObject).add(paramList.get(64));
    ((List)localObject).add(paramList.get(0));
    ((List)localObject).add(paramList.get(18));
    paramList = new PointF();
    float f1 = ((PointF)((List)localObject).get(2)).x;
    float f2 = ((PointF)((List)localObject).get(3)).x;
    float f3 = ((PointF)((List)localObject).get(0)).x;
    paramList.x = (0.5F * (f2 + f1) - (((PointF)((List)localObject).get(1)).x + f3) * 0.5F);
    f1 = ((PointF)((List)localObject).get(2)).y;
    f2 = ((PointF)((List)localObject).get(3)).y;
    f3 = ((PointF)((List)localObject).get(0)).y;
    paramList.y = (0.5F * (f2 + f1) - (((PointF)((List)localObject).get(1)).y + f3) * 0.5F);
    f1 = paramList.y;
    f2 = paramList.x;
    f3 = (float)(1.0D / norm(paramList));
    f1 *= f3;
    f2 = f3 * f2;
    f3 = (float)norm(new PointF(((PointF)((List)localObject).get(5)).x - ((PointF)((List)localObject).get(6)).x, ((PointF)((List)localObject).get(5)).y - ((PointF)((List)localObject).get(6)).y));
    paramList = new PointF();
    float f4 = ((PointF)((List)localObject).get(0)).x;
    float f5 = ((PointF)((List)localObject).get(1)).x;
    float f6 = ((PointF)((List)localObject).get(2)).x;
    float f7 = ((PointF)((List)localObject).get(3)).x;
    paramList.x = ((float)((((PointF)((List)localObject).get(4)).x + (f4 + f5 + f6 + f7)) * 0.2D));
    f4 = ((PointF)((List)localObject).get(0)).y;
    f5 = ((PointF)((List)localObject).get(1)).y;
    f6 = ((PointF)((List)localObject).get(2)).y;
    f7 = ((PointF)((List)localObject).get(3)).y;
    paramList.y = ((float)((((PointF)((List)localObject).get(4)).y + (f4 + f5 + f6 + f7)) * 0.2D));
    f4 = 2.315F * f3 / this.NET_SIZE.width;
    f5 = 0.5F * 2.315F * f3;
    f3 = 2.315F * 0.5F * f3;
    localObject = new float[6];
    localObject[0] = (f2 * f4);
    localObject[1] = (-f1 * f4);
    localObject[2] = (paramList.x - (f2 * f5 - f1 * f3));
    localObject[3] = (f1 * f4);
    localObject[4] = (f4 * f2);
    localObject[5] = (paramList.y - (f3 * f2 + f1 * f5));
    this.texCoords[0] = localObject[2];
    this.texCoords[1] = localObject[5];
    this.texCoords[2] = (this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[3] = (this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[4] = (this.NET_SIZE.width * localObject[0] + this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[5] = (this.NET_SIZE.width * localObject[3] + this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[6] = (this.NET_SIZE.width * localObject[0] + localObject[2]);
    this.texCoords[7] = (this.NET_SIZE.width * localObject[3] + localObject[5]);
    int i = 0;
    while (i < 8)
    {
      this.texCoords[i] /= paramInt1;
      this.texCoords[(i + 1)] /= paramInt2;
      i += 2;
    }
    paramInt1 = 0;
    while (paramInt1 < this.texCoords.length)
    {
      this.position[paramInt1] = (this.texCoords[paramInt1] * 2.0F - 1.0F);
      paramInt1 += 1;
    }
    return localObject;
  }
  
  public void destroy()
  {
    this.cropFilter.clearGLSLSelf();
    this.fillFilter.clearGLSLSelf();
    this.fillFilterStyleChild.clearGLSLSelf();
    this.faceOffFilter.clearGLSLSelf();
    this.cartoonStylePreProcessFilter.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.cropFrame.clear();
    this.fillFrame.clear();
    this.fillFrame2.clear();
    this.mDebugFrame.clear();
    Iterator localIterator = this.textureBitmapList.iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    BitmapUtils.recycle(this.faceMask);
    BitmapUtils.recycle(this.outBitmap);
    BitmapUtils.recycle(this.warpMat);
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.deInitAll();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
  }
  
  public void init()
  {
    this.cropFilter.ApplyGLSLFilter();
    this.fillFilter.ApplyGLSLFilter();
    this.fillFilterStyleChild.ApplyGLSLFilter();
    this.faceOffFilter.ApplyGLSLFilter();
    this.cartoonStylePreProcessFilter.ApplyGLSLFilter();
    this.copyFilter.apply();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH.value) {
      return this.fillFrame;
    }
    this.fillFilterStyleChild.render(paramFrame, this.fillFrame);
    this.copyFilter.RenderProcess(this.fillFrame.getTextureId(), this.fillFrame.width, this.fillFrame.height, -1, 0.0D, this.fillFrame2);
    if (BitmapUtils.isLegal(this.faceMask)) {
      this.faceOffFilter.RenderProcess(this.fillFrame.getTextureId(), this.fillFrame.width, this.fillFrame.height, -1, 0.0D, this.fillFrame2);
    }
    return this.fillFrame2;
  }
  
  public void setImageNetSize(int paramInt1, int paramInt2)
  {
    this.NET_SIZE.width = paramInt1;
    this.NET_SIZE.height = paramInt2;
  }
  
  public void updateAndRender(Frame paramFrame, List<PointF> paramList, double paramDouble)
  {
    int i = paramFrame.getTextureId();
    int j = paramFrame.width;
    int k = paramFrame.height;
    Object localObject = VideoMaterialUtil.copyList(paramList);
    List localList = VideoMaterialUtil.copyList(paramList);
    paramList = VideoMaterialUtil.copyList(paramList);
    scale(paramList, 1.0D / paramDouble);
    scale((List)localObject, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramList, 2.5F);
    paramList = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.computeFaceCropTransform(paramList, this.faceStyleItem.faceCropType, this.faceStyleItem.faceExpandFactor, this.NET_SIZE.width, this.NET_SIZE.height);
    updateCoords(paramList, j, k);
    this.cropFilter.setBackgroundColor(this.faceStyleItem.cropBorderColorRGBA);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CARTOON_STYLE.value)
    {
      FrameUtil.clearFrame(this.mDebugFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mDebugFrame.width, this.mDebugFrame.height);
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mDebugFrame);
      this.mDebugFrame.bindFrame(-1, this.mDebugFrame.width, this.mDebugFrame.height, 0.0D);
      this.cartoonStylePreProcessFilter.updatePoints((List)localObject, paramFrame.width, paramFrame.height);
      this.cartoonStylePreProcessFilter.render(this.mDebugFrame.getTextureId(), paramFrame.width, paramFrame.height);
      this.cropFilter.setTexCords(this.texCoords);
      this.cropFilter.RenderProcess(this.mDebugFrame.getTextureId(), this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
    }
    Bitmap localBitmap;
    for (;;)
    {
      BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] saveTexture");
      paramFrame = GlUtil.saveTexture(this.cropFrame);
      BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] saveTexture");
      BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] forward");
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, paramFrame, true);
      if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE.value)
      {
        localObject = FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.convertFloatToBitmap(6, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, (Bitmap)localObject, true);
      }
      if (TextUtils.isEmpty(this.faceStyleItem.preProcess.function)) {
        break;
      }
      localObject = this.textureBitmapList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPreMat(6, localBitmap, true);
      }
      this.cropFilter.setTexCords(this.texCoords);
      this.cropFilter.RenderProcess(i, this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
    }
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.outBitmap, false);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE.value) {
      FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, this.warpMat, false);
    }
    if (!TextUtils.isEmpty(this.faceStyleItem.postProcess.function))
    {
      localObject = this.textureBitmapList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, localBitmap, true);
      }
    }
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.addPostMat(6, paramFrame, true);
    FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.forward(6, 0);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE.value) {}
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] forward");
    BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] loadTexture");
    GlUtil.loadTexture(this.tex[0], this.outBitmap);
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] loadTexture");
    this.copyFilter.RenderProcess(i, j, k, -1, 0.0D, this.fillFrame);
    if (this.faceStyleItem.styleChangeType == FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH.value)
    {
      this.fillFilter.setPositions(this.position);
      GlUtil.setBlendMode(true);
      this.fillFilter.RenderProcess(this.tex[0], j, k, -1, 0.0D, this.fillFrame);
      GlUtil.setBlendMode(false);
    }
    for (;;)
    {
      if (BitmapUtils.isLegal(this.faceMask))
      {
        this.faceOffFilter.updateVideoSize(j, k, paramDouble);
        this.faceOffFilter.updateParam(localList, i);
      }
      paramFrame.recycle();
      return;
      this.fillFilterStyleChild.setPositions(this.position);
      this.fillFilterStyleChild.updateParams(this.outBitmap, this.warpMat, paramList);
    }
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildFilter
 * JD-Core Version:    0.7.0.1
 */