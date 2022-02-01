package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;

public class FaceAverageBackgroundFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  private FaceImageLayer mFaceLayer = null;
  private FaceItem mItem = null;
  private Bitmap materialBitmap = null;
  private int materialImageHeight = 0;
  private int materialImageWidth = 0;
  
  public FaceAverageBackgroundFilter(String paramString, FaceImageLayer paramFaceImageLayer)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }");
    this.dataPath = paramString;
    this.mFaceLayer = paramFaceImageLayer;
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    float f1 = this.materialImageHeight / this.height;
    if (this.materialImageHeight / this.materialImageWidth > this.height / this.width) {
      f1 = this.materialImageWidth / this.width;
    }
    float f2 = this.materialImageWidth / f1;
    f1 = this.materialImageHeight / f1;
    float f3 = (f2 - this.width) / 2.0F / f2;
    float f4 = (f1 - this.height) / 2.0F / f1;
    float f5 = (f2 - this.width) / 2.0F / f2;
    float f6 = (f1 - this.height) / 2.0F / f1;
    float f7 = (f2 - this.width) / 2.0F / f2;
    float f8 = (f1 - this.height) / 2.0F / f1;
    addAttribParam("inputTextureCoordinate", new float[] { f5, f6, f3, 1.0F - f4, 1.0F - (f2 - this.width) / 2.0F / f2, 1.0F - (f1 - this.height) / 2.0F / f1, 1.0F - f7, f8 });
  }
  
  public void initParams()
  {
    if ((this.materialBitmap == null) && (this.mFaceLayer != null)) {
      this.materialBitmap = FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.mFaceLayer.imagePath);
    }
    if (this.materialBitmap != null)
    {
      this.materialImageWidth = this.materialBitmap.getWidth();
      this.materialImageHeight = this.materialBitmap.getHeight();
    }
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.materialBitmap, 33986, true));
  }
  
  public void updatePreview(Object paramObject)
  {
    float f1 = this.materialImageHeight / this.height;
    if (this.materialImageHeight / this.materialImageWidth > this.height / this.width) {
      f1 = this.materialImageWidth / this.width;
    }
    float f2 = this.materialImageWidth / f1;
    f1 = this.materialImageHeight / f1;
    float f3 = (f2 - this.width) / 2.0F / f2;
    float f4 = (f1 - this.height) / 2.0F / f1;
    float f5 = (f2 - this.width) / 2.0F / f2;
    float f6 = (f1 - this.height) / 2.0F / f1;
    float f7 = (f2 - this.width) / 2.0F / f2;
    float f8 = (f1 - this.height) / 2.0F / f1;
    addAttribParam("inputTextureCoordinate", new float[] { f5, f6, f3, 1.0F - f4, 1.0F - (f2 - this.width) / 2.0F / f2, 1.0F - (f1 - this.height) / 2.0F / f1, 1.0F - f7, f8 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceAverageBackgroundFilter
 * JD-Core Version:    0.7.0.1
 */