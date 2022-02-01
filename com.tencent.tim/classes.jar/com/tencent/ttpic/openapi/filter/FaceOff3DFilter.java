package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.io.File;
import java.util.List;

public class FaceOff3DFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n    vec4 maskColor = texture2D(inputImageTexture5, grayTextureCoordinate);\n\n    if (enableFaceOff == 1) {\n        if (texColor.a > 0.0) {\n            texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n        }\n        if(enableAlphaFromGray > 0.0){\n            float grayAlpha = (1.0 - mix(maskColor.r, grayColor.r, enableAlphaFromGrayNew));\n            texColor.a = texColor.a * grayAlpha * alpha;\n        } else {\n            texColor.a = texColor.a * alpha;\n        }\n    }\n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue);\n\n    texColor.a = texColor.a * confidence;\n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute float pointsVisValue;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    pointVisValue = pointsVisValue;\n}";
  private static final PointF ZERO_POINT = new PointF(0.0F, 0.0F);
  private Frame copyFrame = new Frame();
  private Face3DCosmeticFilter cosmetic3DFilter = new Face3DCosmeticFilter();
  private byte[] data = null;
  private PTDetectInfo detectInfo;
  private float[] face3dTexCoords = new float[1380];
  protected int faceImageHeight;
  protected int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private PointF irisCenterL = new PointF(0.0F, 0.0F);
  private PointF irisCenterR = new PointF(0.0F, 0.0F);
  private float irisRadiusL;
  private float irisRadiusR;
  private boolean isFaceImageReady;
  private boolean isGrayImageReady;
  private boolean isIrisImageReady;
  protected FaceItem item;
  private int lastIndex = -1;
  public float level1 = 0.0F;
  public float level2 = 0.0F;
  public int levelCount = 0;
  byte[] mData = null;
  float percent1 = 0.05F;
  float percent2 = 0.15F;
  float[] pointVis = new float[''];
  private float[] pointVisVertices = new float[1380];
  private boolean sequenceMode;
  public double sumg = 0.0D;
  public double sumr = 0.0D;
  private float[] texVertices = new float[1380];
  protected int[] texture = new int[4];
  private boolean triggered;
  
  public FaceOff3DFilter(FaceItem paramFaceItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF));
    this.item = paramFaceItem;
    this.dataPath = paramString;
    this.sequenceMode = TextUtils.isEmpty(paramFaceItem.faceExchangeImage);
    initParams();
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((this.data == null) || (this.data.length < paramInt2 * paramInt1 * 4)) {
      return 0.0F;
    }
    int i = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
    int m = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
    int j = (int)((PointF)paramList.get(65)).x;
    int k = (int)((PointF)paramList.get(78)).y;
    if ((j >= paramInt1) || (k >= paramInt2) || (i <= 0) || (m <= 0)) {
      return 0.0F;
    }
    if (j < 0) {
      j = 0;
    }
    for (;;)
    {
      if (k < 0) {
        k = 0;
      }
      for (;;)
      {
        if (j + i > paramInt1) {
          i = paramInt1 - j;
        }
        for (;;)
        {
          if (k + m > paramInt2) {
            paramInt2 -= k;
          }
          for (;;)
          {
            paramList = new byte[i * paramInt2 * 4];
            m = 0;
            while (m < paramInt2)
            {
              int n = 0;
              while (n < i)
              {
                int i1 = (m * i + n) * 4;
                int i2 = ((m + k) * paramInt1 + n + j) * 4;
                paramList[i1] = this.data[i2];
                paramList[(i1 + 1)] = this.data[(i2 + 1)];
                paramList[(i1 + 2)] = this.data[(i2 + 2)];
                paramList[(i1 + 3)] = this.data[(i2 + 3)];
                n += 1;
              }
              m += 1;
            }
            int[] arrayOfInt = new int[256];
            this.sumg = 0.0D;
            this.sumr = 0.0D;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              j = 0;
              while (j < i)
              {
                k = paramList[((paramInt1 * i + j) * 4)] & 0xFF;
                this.sumr += k;
                m = paramList[((paramInt1 * i + j) * 4 + 1)];
                this.sumg += (m & 0xFF);
                arrayOfInt[k] += 1;
                j += 1;
              }
              paramInt1 += 1;
            }
            this.sumg /= i * paramInt2;
            this.sumr /= i * paramInt2;
            this.levelCount = 0;
            paramInt1 = 255;
            if (paramInt1 >= 0)
            {
              this.levelCount += arrayOfInt[paramInt1];
              if (this.levelCount >= paramInt2 * i * this.percent1) {
                this.level1 = paramInt1;
              }
            }
            else
            {
              this.levelCount = 0;
              paramInt1 = 255;
            }
            for (;;)
            {
              if (paramInt1 >= 0)
              {
                this.levelCount += arrayOfInt[paramInt1];
                if (this.levelCount >= paramInt2 * i * this.percent2) {
                  this.level2 = paramInt1;
                }
              }
              else
              {
                return (float)this.sumr;
                paramInt1 -= 1;
                break;
              }
              paramInt1 -= 1;
            }
            paramInt2 = m;
          }
        }
      }
    }
  }
  
  private boolean initGrayImage()
  {
    if (this.isGrayImageReady) {
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FEATURE_TYPE.MASK);
    Object localObject1 = localObject2;
    if (!BitmapUtils.isLegal((Bitmap)localObject2))
    {
      localObject1 = localObject2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localObject1 = FaceOffUtil.getGrayBitmap(this.item.featureType);
      }
    }
    localObject2 = localBitmap;
    if (!BitmapUtils.isLegal(localBitmap))
    {
      localObject2 = localBitmap;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localObject2 = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.MASK);
      }
    }
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if ((BitmapUtils.isLegal((Bitmap)localObject1)) && (BitmapUtils.isLegal((Bitmap)localObject2)))
    {
      GlUtil.loadTexture(this.texture[1], (Bitmap)localObject1);
      this.grayImageWidth = (((Bitmap)localObject1).getWidth() * i);
      this.grayImageHeight = (((Bitmap)localObject1).getHeight() * i);
      initGrayTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      GlUtil.loadTexture(this.texture[3], (Bitmap)localObject2);
      addParam(new UniformParam.TextureParam("inputImageTexture5", this.texture[3], 33989));
      this.isGrayImageReady = true;
    }
    return this.isGrayImageReady;
  }
  
  private void initGrayTexCoords()
  {
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.getGrayCoords(this.item.featureType), 5.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
  }
  
  private boolean initIrisImage()
  {
    if (this.isIrisImageReady) {
      return true;
    }
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.irisImage);
    Bitmap localBitmap1 = localBitmap2;
    if (!BitmapUtils.isLegal(localBitmap2))
    {
      localBitmap1 = localBitmap2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localBitmap1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.irisImage, 1);
      }
    }
    if (BitmapUtils.isLegal(localBitmap1))
    {
      GlUtil.loadTexture(this.texture[2], localBitmap1);
      addParam(new UniformParam.TextureParam("inputImageTexture4", this.texture[2], 33988));
      this.isIrisImageReady = true;
    }
    return this.isIrisImageReady;
  }
  
  private void update3DFaceImage(int paramInt)
  {
    if ((this.detectInfo == null) || (this.detectInfo.face3DVerticesArray == null)) {}
    while (!AlgoUtils.isFace3DPointsValid(this.detectInfo.face3DVerticesArray)) {
      return;
    }
    boolean bool = GlUtil.curBlendModeEnabled;
    GlUtil.setBlendMode(false);
    this.cosmetic3DFilter.updatePreview(this.detectInfo);
    this.cosmetic3DFilter.RenderProcess(paramInt, this.width, this.height, -1, 0.0D, this.copyFrame);
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.copyFrame.getTextureId(), 33986));
    GlUtil.setBlendMode(bool);
  }
  
  private void update3DPointParams()
  {
    if ((this.detectInfo == null) || (this.detectInfo.face3DVerticesArray == null)) {}
    while (!AlgoUtils.isFace3DPointsValid(this.detectInfo.face3DVerticesArray)) {
      return;
    }
    if (this.item.disable3DCorrect) {
      FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterialUtil.copyList(this.detectInfo.facePoints), 5.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.face3dTexCoords);
    }
    for (;;)
    {
      addAttribParam(new AttributeParam("inputTextureCoordinate", this.face3dTexCoords, 2));
      return;
      FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getSelectedCorrectPoints(this.detectInfo.face3DVerticesArray, this.detectInfo.face3DRotationArray, this.detectInfo.featureIndices, (int)(this.height * this.mFaceDetScale), this.detectInfo.facePoints, 5.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.face3dTexCoords);
    }
  }
  
  private void updateMouthOpenFactor(List<PointF> paramList)
  {
    float f2;
    if (this.item.grayScale == 2)
    {
      f1 = AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66));
      f2 = AlgoUtils.getDistance((PointF)paramList.get(73), (PointF)paramList.get(81));
      if (f1 <= 0.0F) {
        break label115;
      }
    }
    label115:
    for (float f1 = Math.max(0.0F, Math.min(1.0F, (f2 - f1 * 0.1F) / (f1 * 0.1F)));; f1 = 0.0F)
    {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", Math.min(1.0F, f1 + 0.002F)));
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.cosmetic3DFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    this.cosmetic3DFilter.clearGLSLSelf();
    this.detectInfo = null;
    this.copyFrame.clear();
    super.clearGLSLSelf();
  }
  
  public FaceItem getFaceOffItem()
  {
    return this.item;
  }
  
  public int getNextFrame(int paramInt)
  {
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.isFaceImageReady = true;
      return this.texture[0];
    }
    VideoMemoryManager.getInstance().recycleBitmap(this.item.id, localBitmap);
    return -1;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    initGrayTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  protected boolean initFaceImage()
  {
    if (this.isFaceImageReady)
    {
      update3DFaceImage(this.texture[0]);
      return true;
    }
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
    VideoMemoryManager.getInstance().getSampleSize();
    Bitmap localBitmap1 = localBitmap2;
    if (!BitmapUtils.isLegal(localBitmap2))
    {
      localBitmap1 = localBitmap2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localBitmap1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage, 1);
      }
    }
    if (BitmapUtils.isLegal(localBitmap1))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap1);
      update3DFaceImage(this.texture[0]);
      this.isFaceImageReady = true;
    }
    return this.isFaceImageReady;
  }
  
  protected void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.genPoints(this.item.facePoints), 5.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices));
  }
  
  public void initParams()
  {
    this.faceImageWidth = this.item.width;
    this.faceImageHeight = this.item.height;
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", this.item.blendAlpha));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("posMatRotate", new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", this.item.grayScale));
    addAttribParam("pointsVisValue", this.pointVisVertices);
    if (this.item.grayScale > 0) {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 1.0F));
    }
    for (;;)
    {
      addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
      addParam(new UniformParam.IntParam("blendIris", this.item.blendIris));
      if (this.item.blendMode == 13)
      {
        addParam(new UniformParam.FloatParam("level1", 0.0F));
        addParam(new UniformParam.FloatParam("level2", 0.0F));
      }
      if (this.item.blendMode != 14) {
        break;
      }
      this.isIrisImageReady = false;
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
      float[] arrayOfFloat = new float[2];
      float[] tmp398_397 = arrayOfFloat;
      tmp398_397[0] = 0.0F;
      float[] tmp402_398 = tmp398_397;
      tmp402_398[1] = 0.0F;
      tmp402_398;
      addParam(new UniformParam.FloatsParam("center1", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("center2", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("size", arrayOfFloat));
      addParam(new UniformParam.FloatParam("radius1", 0.0F));
      addParam(new UniformParam.FloatParam("radius2", 0.0F));
      addParam(new UniformParam.FloatParam("leftEyeClosed", 0.0F));
      addParam(new UniformParam.FloatParam("rightEyeClosed", 0.0F));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", 1.0F));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", 1.0F));
      return;
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 0.0F));
    }
    this.isIrisImageReady = true;
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isFaceImageReady) && (this.isGrayImageReady) && (this.detectInfo != null) && (AlgoUtils.isFace3DPointsValid(this.detectInfo.face3DVerticesArray));
  }
  
  public float[] mat4RotationYXZ(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = new float[16];
    float[] tmp8_6 = arrayOfFloat;
    tmp8_6[0] = 1.0F;
    float[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 0.0F;
    float[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 0.0F;
    float[] tmp20_16 = tmp16_12;
    tmp20_16[3] = 0.0F;
    float[] tmp24_20 = tmp20_16;
    tmp24_20[4] = 0.0F;
    float[] tmp28_24 = tmp24_20;
    tmp28_24[5] = 1.0F;
    float[] tmp32_28 = tmp28_24;
    tmp32_28[6] = 0.0F;
    float[] tmp37_32 = tmp32_28;
    tmp37_32[7] = 0.0F;
    float[] tmp42_37 = tmp37_32;
    tmp42_37[8] = 0.0F;
    float[] tmp47_42 = tmp42_37;
    tmp47_42[9] = 0.0F;
    float[] tmp52_47 = tmp47_42;
    tmp52_47[10] = 1.0F;
    float[] tmp57_52 = tmp52_47;
    tmp57_52[11] = 0.0F;
    float[] tmp62_57 = tmp57_52;
    tmp62_57[12] = 0.0F;
    float[] tmp67_62 = tmp62_57;
    tmp67_62[13] = 0.0F;
    float[] tmp72_67 = tmp67_62;
    tmp72_67[14] = 0.0F;
    float[] tmp77_72 = tmp72_67;
    tmp77_72[15] = 1.0F;
    tmp77_72;
    float f1 = (float)Math.cos(paramFloat1);
    paramFloat1 = (float)Math.sin(paramFloat1);
    float f2 = (float)Math.cos(paramFloat2);
    paramFloat2 = (float)Math.sin(paramFloat2);
    float f3 = (float)Math.cos(paramFloat3);
    paramFloat3 = (float)Math.sin(paramFloat3);
    arrayOfFloat[0] = (f2 * f3 + paramFloat1 * paramFloat2 * paramFloat3);
    arrayOfFloat[1] = (f1 * paramFloat3);
    arrayOfFloat[2] = (f2 * paramFloat1 * paramFloat3 - f3 * paramFloat2);
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (f3 * paramFloat1 * paramFloat2 - f2 * paramFloat3);
    arrayOfFloat[5] = (f1 * f3);
    arrayOfFloat[6] = (f3 * f2 * paramFloat1 + paramFloat3 * paramFloat2);
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = (paramFloat2 * f1);
    arrayOfFloat[9] = (-paramFloat1);
    arrayOfFloat[10] = (f1 * f2);
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    return arrayOfFloat;
  }
  
  public void reset() {}
  
  public void setCosAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.data = paramArrayOfByte;
  }
  
  public void updatePointParams(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    Object localObject = FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterialUtil.copyList(paramList), 5.0F);
    this.pointVis = FaceOffUtil.getFullPointsVisForFaceOffFilter(paramArrayOfFloat);
    setPositions(FaceOffUtil.initFacePositions((List)localObject, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    paramArrayOfFloat = FaceOffUtil.initPointVis(this.pointVis, this.pointVisVertices);
    if (paramArrayOfFloat != null) {
      addAttribParam("pointsVisValue", paramArrayOfFloat);
    }
    if (this.item.blendMode == 13)
    {
      getAverageGreen(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale));
      addParam(new UniformParam.FloatParam("level1", this.level1 / 255.0F));
      addParam(new UniformParam.FloatParam("level2", this.level2 / 255.0F));
    }
    PointF localPointF1;
    PointF localPointF2;
    float f2;
    float f1;
    if (this.item.blendMode == 14)
    {
      paramArrayOfFloat = new PointF(((PointF)paramList.get(44)).x, ((PointF)paramList.get(44)).y);
      localObject = new PointF(((PointF)paramList.get(54)).x, ((PointF)paramList.get(54)).y);
      localPointF1 = (PointF)paramList.get(39);
      localPointF2 = (PointF)paramList.get(35);
      PointF localPointF3 = (PointF)paramList.get(49);
      PointF localPointF4 = (PointF)paramList.get(45);
      f2 = 0.26F * AlgoUtils.getDistance(localPointF1, localPointF2);
      f1 = AlgoUtils.getDistance(localPointF3, localPointF4) * 0.26F;
      if ((AlgoUtils.getDistance(this.irisCenterL, ZERO_POINT) >= 0.001D) && (AlgoUtils.getDistance(this.irisCenterR, ZERO_POINT) >= 0.001D)) {
        break label784;
      }
      this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
      this.irisCenterR = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
      this.irisRadiusL = f2;
    }
    for (this.irisRadiusR = f1;; this.irisRadiusR = f1)
    {
      localPointF1 = (PointF)paramList.get(41);
      localPointF2 = (PointF)paramList.get(37);
      float f3 = (float)(f2 * 2.0D);
      f3 = (float)Math.min(1.0D, Math.max(0.0D, AlgoUtils.getDistance(localPointF1, localPointF2) / f3 - 0.04F) / (0.4F - 0.04F));
      localPointF1 = (PointF)paramList.get(47);
      paramList = (PointF)paramList.get(51);
      float f4 = (float)(f1 * 2.0D);
      f4 = (float)Math.min(1.0D, Math.max(0.0D, AlgoUtils.getDistance(paramList, localPointF1) / f4 - 0.04F) / (0.4F - 0.04F));
      paramArrayOfFloat.x = ((float)(paramArrayOfFloat.x / this.mFaceDetScale));
      paramArrayOfFloat.y = ((float)(paramArrayOfFloat.y / this.mFaceDetScale));
      ((PointF)localObject).x = ((float)(((PointF)localObject).x / this.mFaceDetScale));
      ((PointF)localObject).y = ((float)(((PointF)localObject).y / this.mFaceDetScale));
      f2 = (float)(f2 / this.mFaceDetScale);
      f1 = (float)(f1 / this.mFaceDetScale);
      addParam(new UniformParam.Float2fParam("center1", paramArrayOfFloat.x, paramArrayOfFloat.y));
      addParam(new UniformParam.Float2fParam("center2", ((PointF)localObject).x, ((PointF)localObject).y));
      addParam(new UniformParam.Float2fParam("size", this.width, this.height));
      addParam(new UniformParam.FloatParam("radius1", f2));
      addParam(new UniformParam.FloatParam("radius2", f1));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", f3));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", f4));
      return;
      label784:
      f3 = (float)(Math.min(this.width, this.height) * this.mFaceDetScale);
      f4 = (float)(1.0D + 65536.0D * Math.pow((float)Math.sqrt(Math.pow(paramArrayOfFloat.x - this.irisCenterL.x, 2.0D) + Math.pow(paramArrayOfFloat.y - this.irisCenterL.y, 2.0D)) / f3, 2.0D));
      f4 = (float)(f4 / (f4 + 1.5D));
      paramArrayOfFloat.x = ((float)(this.irisCenterL.x * (1.0D - f4) + paramArrayOfFloat.x * f4));
      paramArrayOfFloat.y = ((float)(this.irisCenterL.y * (1.0D - f4) + paramArrayOfFloat.y * f4));
      f2 = (float)(this.irisRadiusL * (1.0D - f4) + f2 * f4);
      this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
      this.irisRadiusL = f2;
      f3 = (float)(Math.pow((float)Math.sqrt(Math.pow(((PointF)localObject).x - this.irisCenterR.x, 2.0D) + Math.pow(((PointF)localObject).y - this.irisCenterR.y, 2.0D)) / f3, 2.0D) * 65536.0D + 1.0D);
      f3 = (float)(f3 / (f3 + 1.5D));
      ((PointF)localObject).x = ((float)(this.irisCenterR.x * (1.0D - f3) + ((PointF)localObject).x * f3));
      ((PointF)localObject).y = ((float)(this.irisCenterR.y * (1.0D - f3) + ((PointF)localObject).y * f3));
      double d1 = this.irisRadiusR;
      double d2 = f3;
      f1 = (float)(f1 * f3 + d1 * (1.0D - d2));
      this.irisCenterR = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.detectInfo = paramObject;
      if (CollectionUtils.isEmpty(paramObject.facePoints)) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      this.triggered = bool;
      if (this.triggered) {
        break;
      }
      this.lastIndex = -1;
      return;
    }
    List localList = VideoMaterialUtil.copyList(paramObject.facePoints);
    float[] arrayOfFloat = paramObject.pointsVis;
    updateMouthOpenFactor(localList);
    updatePointParams(localList, arrayOfFloat);
    update3DPointParams();
    updateTextureParams(paramObject.timestamp, paramObject.frameIndex);
  }
  
  public void updateRandomGroupValue(int paramInt) {}
  
  public void updateTextureParams(long paramLong, int paramInt)
  {
    boolean bool1 = initGrayImage();
    boolean bool2 = initIrisImage();
    if ((!bool1) || (!bool2)) {}
    int i;
    do
    {
      do
      {
        return;
        if (!this.sequenceMode) {
          break label98;
        }
        if (paramInt != this.lastIndex) {
          break;
        }
      } while (!this.isFaceImageReady);
      update3DFaceImage(this.texture[0]);
      return;
      i = getNextFrame(paramInt);
      if (i > 0) {
        break;
      }
    } while (!this.isFaceImageReady);
    update3DFaceImage(this.texture[0]);
    return;
    update3DFaceImage(i);
    this.lastIndex = paramInt;
    return;
    label98:
    initFaceImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.cosmetic3DFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceOff3DFilter
 * JD-Core Version:    0.7.0.1
 */