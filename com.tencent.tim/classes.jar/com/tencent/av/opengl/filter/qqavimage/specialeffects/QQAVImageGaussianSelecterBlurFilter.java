package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter;
import java.util.List;

public class QQAVImageGaussianSelecterBlurFilter
  extends QQAVImageTwoPassTextureSamplingFilter
{
  public static final String FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\nuniform highp float aspectRatio;\n\nuniform highp float radius;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tlowp vec3 sum = vec3(0.0);\n   highp vec2 blurCenter = vec2(0.50, 0.50);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n   highp vec2 textureCoordinateToUse = vec2((textureCoordinate.x), (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));   highp float dist = distance(blurCenter, textureCoordinateToUse);\n\t\n\tif (dist > radius)   {\n       sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n       sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n       sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n     highp vec4 blurredImageColor = vec4(sum,fragColor.a);\n     \n     gl_FragColor = mix(fragColor, blurredImageColor, smoothstep(radius , 0.5, dist));    }   else    {\n\t    gl_FragColor = fragColor;\n    }}";
  public static final String VERTEX_SHADER = "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    highp vec2 blurStep;\n    highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n    {\n        multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n        // Blur in x (horizontal)\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n     }\n}";
  private float mAspectRatio;
  protected float mBlurSize = 2.0F;
  private PointF mCenter;
  protected float mRadius;
  
  public QQAVImageGaussianSelecterBlurFilter()
  {
    this(new PointF(0.5F, 0.5F), 2.0F, 0.34F);
  }
  
  public QQAVImageGaussianSelecterBlurFilter(PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    highp vec2 blurStep;\n    highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n    {\n        multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n        // Blur in x (horizontal)\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n     }\n}", "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\nuniform highp float aspectRatio;\n\nuniform highp float radius;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tlowp vec3 sum = vec3(0.0);\n   highp vec2 blurCenter = vec2(0.50, 0.50);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n   highp vec2 textureCoordinateToUse = vec2((textureCoordinate.x), (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));   highp float dist = distance(blurCenter, textureCoordinateToUse);\n\t\n\tif (dist > radius)   {\n       sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n       sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n       sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n     highp vec4 blurredImageColor = vec4(sum,fragColor.a);\n     \n     gl_FragColor = mix(fragColor, blurredImageColor, smoothstep(radius , 0.5, dist));    }   else    {\n\t    gl_FragColor = fragColor;\n    }}", "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    highp vec2 blurStep;\n    highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n    {\n        multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n        // Blur in x (horizontal)\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n     }\n}", "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\nuniform highp float aspectRatio;\n\nuniform highp float radius;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tlowp vec3 sum = vec3(0.0);\n   highp vec2 blurCenter = vec2(0.50, 0.50);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n   highp vec2 textureCoordinateToUse = vec2((textureCoordinate.x), (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));   highp float dist = distance(blurCenter, textureCoordinateToUse);\n\t\n\tif (dist > radius)   {\n       sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n       sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n       sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n     highp vec4 blurredImageColor = vec4(sum,fragColor.a);\n     \n     gl_FragColor = mix(fragColor, blurredImageColor, smoothstep(radius , 0.5, dist));    }   else    {\n\t    gl_FragColor = fragColor;\n    }}");
    super.setQQAVEffectType(1008);
    this.mCenter = paramPointF;
    this.mBlurSize = paramFloat1;
    this.mRadius = paramFloat2;
  }
  
  public float getHorizontalTexelOffsetRatio()
  {
    return this.mBlurSize;
  }
  
  public float getVerticalTexelOffsetRatio()
  {
    return this.mBlurSize;
  }
  
  public void onInit()
  {
    super.onInit();
    setRadius(0.34F);
    setCenter(new PointF(0.5F, 0.5F));
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    this.mAspectRatio = (paramInt2 / paramInt1);
    updateUinformValue("aspectRatio", this.mAspectRatio);
    super.onOutputSizeChanged(paramInt1, paramInt2);
  }
  
  public void setBlurSize(float paramFloat)
  {
    this.mBlurSize = paramFloat;
    runOnDraw(new QQAVImageGaussianSelecterBlurFilter.1(this));
  }
  
  public void setCenter(PointF paramPointF)
  {
    this.mCenter = paramPointF;
    updateUinformValue("blurCenter", this.mCenter);
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    runOnDraw(new QQAVImageGaussianSelecterBlurFilter.2(this));
  }
  
  protected void updateUinformValue(String paramString, float paramFloat)
  {
    int i = 0;
    while (i < this.mFilters.size())
    {
      QQAVImageFilter localQQAVImageFilter = (QQAVImageFilter)this.mFilters.get(i);
      localQQAVImageFilter.setFloat(GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), paramString), paramFloat);
      i += 1;
    }
    runOnDraw(new QQAVImageGaussianSelecterBlurFilter.3(this));
  }
  
  protected void updateUinformValue(String paramString, PointF paramPointF)
  {
    int i = 0;
    while (i < this.mFilters.size())
    {
      QQAVImageFilter localQQAVImageFilter = (QQAVImageFilter)this.mFilters.get(i);
      localQQAVImageFilter.setPoint(GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), paramString), paramPointF);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter
 * JD-Core Version:    0.7.0.1
 */