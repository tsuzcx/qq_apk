package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;

public class StrokeFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision lowp float;\n\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n varying highp vec2 textureCoordinate3;\n\n uniform sampler2D inputImageTexture;//image\n uniform sampler2D inputImageTexture3;//filtered image\n\n uniform vec2 strokeGapInPixel;     //描边与边缘间距\n uniform vec2 strokeWidthInPixel;   //描边宽度\n uniform vec4 strokeColor;          //描边颜色\n uniform int strokeType;    //描边类型\n\n float alphaForStep(float step_x, float step_y, float weight) {\n     float step_x45 = step_x * 0.7071;\n     float step_y45 = step_y * 0.7071;\n\n     vec4 v3_10 = texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+step_y));\n     vec4 v3_11 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45));\n     vec4 v3_12 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x, textureCoordinate.y));\n     vec4 v3_13 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_14 = texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-step_y));\n     vec4 v3_15 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_16 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x, textureCoordinate.y));\n     vec4 v3_17 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45));\n\n     float alpha = step(weight, v3_10.a+v3_11.a+v3_12.a+v3_13.a+v3_14.a+v3_15.a+v3_16.a+v3_17.a);\n     return alpha;\n }\n float alphaForStep2(float step_x, float step_y, float weight) {\n     float step_x45 = step_x * 0.7071;\n     float step_y45 = step_y * 0.7071;\n\n     vec4 v3_10 = texture2D(inputImageTexture3, vec2(textureCoordinate.x, textureCoordinate.y+step_y));\n     vec4 v3_11 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45));\n     vec4 v3_12 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x, textureCoordinate.y));\n     vec4 v3_13 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_14 = texture2D(inputImageTexture3, vec2(textureCoordinate.x, textureCoordinate.y-step_y));\n     vec4 v3_15 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_16 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x, textureCoordinate.y));\n     vec4 v3_17 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45));\n\n     float alpha = step(weight, v3_10.a+v3_11.a+v3_12.a+v3_13.a+v3_14.a+v3_15.a+v3_16.a+v3_17.a);\n     return alpha;\n }\n\n void main()\n {\n     vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n     vec4 v3 = texture2D(inputImageTexture3, textureCoordinate3);\n\n     float mask = v1.a;\n     vec4 bg = vec4(0.0);\n     mask = smoothstep(0.7, 0.9, v3.a);\n\n     if (strokeType == 1) { //描边\n         if (mask < 0.9) {\n             //背景\n             float x = strokeGapInPixel.x;\n             float y = strokeGapInPixel.y;\n             float innerAlpha = alphaForStep(x, y, 4.0);\n             if (innerAlpha > 0.9) {\n                 //gl_FragColor = v1;\n                 if (v1.a < 0.9) {\n                     gl_FragColor = strokeColor;\n                 } else {\n                     gl_FragColor = v1;\n                 }\n             }\n             else {\n                 x += strokeWidthInPixel.x;\n                 y += strokeWidthInPixel.y;\n                 float outterAlpha = alphaForStep2(x, y, 0.5);\n                 if (outterAlpha > 0.9) {\n                     gl_FragColor = strokeColor;\n                 }\n                 else {\n                     gl_FragColor = bg;\n                 }\n             }\n         }\n         else {\n             //前景\n             //判断前景是否之前很低\n             float mask2 = v1.a;\n             if (mask2 < 0.9) {\n                 gl_FragColor = strokeColor;\n             } else {\n                 gl_FragColor = v1;\n             }\n         }\n     } else if (strokeType == 2) {  //外发光\n         if (mask < 0.5) {\n             if (mask < 0.01){\n                 gl_FragColor = bg;\n             } else {\n                 gl_FragColor = vec4(strokeColor.rgb, mask * 2.0);\n             }\n         }\n         else {\n             //前景\n             gl_FragColor = v1;\n         }\n     } else if (strokeType == 0) {  //羽化\n         if (strokeWidthInPixel.x > 0.0) {\n             gl_FragColor = v1;\n         }\n         else {\n             gl_FragColor = mix(bg, v1, v1.a < 0.4?0.0:1.0);\n         }\n     } else if (strokeType >= 3){\n         if (textureCoordinate3.x < 0.0 || textureCoordinate3.x > 1.0 || textureCoordinate3.y < 0.0 || textureCoordinate3.y > 1.0){\n             v3 = vec4(0.0);\n         }\n         float alphaMix = v1.a + v3.r - v1.a * v3.r;\n         vec3 xColor = vec3(0.0);\n         if (alphaMix > 0.001) {\n             xColor = (strokeColor.rgb * v3.r + v1.rgb * (1.0 - v3.r)) / alphaMix;\n         }\n         gl_FragColor = vec4(xColor * alphaMix, alphaMix);\n     }\n }";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate3;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate3 = inputTextureCoordinate;\n}";
  
  public StrokeFilter()
  {
    super("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate3;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate3 = inputTextureCoordinate;\n}", "precision lowp float;\n\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n varying highp vec2 textureCoordinate3;\n\n uniform sampler2D inputImageTexture;//image\n uniform sampler2D inputImageTexture3;//filtered image\n\n uniform vec2 strokeGapInPixel;     //描边与边缘间距\n uniform vec2 strokeWidthInPixel;   //描边宽度\n uniform vec4 strokeColor;          //描边颜色\n uniform int strokeType;    //描边类型\n\n float alphaForStep(float step_x, float step_y, float weight) {\n     float step_x45 = step_x * 0.7071;\n     float step_y45 = step_y * 0.7071;\n\n     vec4 v3_10 = texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+step_y));\n     vec4 v3_11 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45));\n     vec4 v3_12 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x, textureCoordinate.y));\n     vec4 v3_13 = texture2D(inputImageTexture, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_14 = texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-step_y));\n     vec4 v3_15 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_16 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x, textureCoordinate.y));\n     vec4 v3_17 = texture2D(inputImageTexture, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45));\n\n     float alpha = step(weight, v3_10.a+v3_11.a+v3_12.a+v3_13.a+v3_14.a+v3_15.a+v3_16.a+v3_17.a);\n     return alpha;\n }\n float alphaForStep2(float step_x, float step_y, float weight) {\n     float step_x45 = step_x * 0.7071;\n     float step_y45 = step_y * 0.7071;\n\n     vec4 v3_10 = texture2D(inputImageTexture3, vec2(textureCoordinate.x, textureCoordinate.y+step_y));\n     vec4 v3_11 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45));\n     vec4 v3_12 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x, textureCoordinate.y));\n     vec4 v3_13 = texture2D(inputImageTexture3, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_14 = texture2D(inputImageTexture3, vec2(textureCoordinate.x, textureCoordinate.y-step_y));\n     vec4 v3_15 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45));\n     vec4 v3_16 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x, textureCoordinate.y));\n     vec4 v3_17 = texture2D(inputImageTexture3, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45));\n\n     float alpha = step(weight, v3_10.a+v3_11.a+v3_12.a+v3_13.a+v3_14.a+v3_15.a+v3_16.a+v3_17.a);\n     return alpha;\n }\n\n void main()\n {\n     vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n     vec4 v3 = texture2D(inputImageTexture3, textureCoordinate3);\n\n     float mask = v1.a;\n     vec4 bg = vec4(0.0);\n     mask = smoothstep(0.7, 0.9, v3.a);\n\n     if (strokeType == 1) { //描边\n         if (mask < 0.9) {\n             //背景\n             float x = strokeGapInPixel.x;\n             float y = strokeGapInPixel.y;\n             float innerAlpha = alphaForStep(x, y, 4.0);\n             if (innerAlpha > 0.9) {\n                 //gl_FragColor = v1;\n                 if (v1.a < 0.9) {\n                     gl_FragColor = strokeColor;\n                 } else {\n                     gl_FragColor = v1;\n                 }\n             }\n             else {\n                 x += strokeWidthInPixel.x;\n                 y += strokeWidthInPixel.y;\n                 float outterAlpha = alphaForStep2(x, y, 0.5);\n                 if (outterAlpha > 0.9) {\n                     gl_FragColor = strokeColor;\n                 }\n                 else {\n                     gl_FragColor = bg;\n                 }\n             }\n         }\n         else {\n             //前景\n             //判断前景是否之前很低\n             float mask2 = v1.a;\n             if (mask2 < 0.9) {\n                 gl_FragColor = strokeColor;\n             } else {\n                 gl_FragColor = v1;\n             }\n         }\n     } else if (strokeType == 2) {  //外发光\n         if (mask < 0.5) {\n             if (mask < 0.01){\n                 gl_FragColor = bg;\n             } else {\n                 gl_FragColor = vec4(strokeColor.rgb, mask * 2.0);\n             }\n         }\n         else {\n             //前景\n             gl_FragColor = v1;\n         }\n     } else if (strokeType == 0) {  //羽化\n         if (strokeWidthInPixel.x > 0.0) {\n             gl_FragColor = v1;\n         }\n         else {\n             gl_FragColor = mix(bg, v1, v1.a < 0.4?0.0:1.0);\n         }\n     } else if (strokeType >= 3){\n         if (textureCoordinate3.x < 0.0 || textureCoordinate3.x > 1.0 || textureCoordinate3.y < 0.0 || textureCoordinate3.y > 1.0){\n             v3 = vec4(0.0);\n         }\n         float alphaMix = v1.a + v3.r - v1.a * v3.r;\n         vec3 xColor = vec3(0.0);\n         if (alphaMix > 0.001) {\n             xColor = (strokeColor.rgb * v3.r + v1.rgb * (1.0 - v3.r)) / alphaMix;\n         }\n         gl_FragColor = vec4(xColor * alphaMix, alphaMix);\n     }\n }");
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("textureCoordinate3", GlUtil.ORIGIN_TEX_COORDS);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33986));
    addParam(new UniformParam.Float2fParam("strokeGapInPixel", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("strokeWidthInPixel", 0.0F, 0.0F));
    addParam(new UniformParam.Float4fParam("strokeColor", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.IntParam("strokeType", 0));
  }
  
  public void updateParams(StrokeModel paramStrokeModel, Frame paramFrame, Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    float f = Math.max(paramFrame.width / paramInt1, paramFrame.height / paramInt2);
    int i = (int)(paramInt1 * f);
    int j = (int)(f * paramInt2);
    Rect localRect = new Rect();
    localRect.left = ((i - paramFrame.width) / 2 + paramRect.left);
    localRect.right = ((i - paramFrame.width) / 2 + paramRect.right);
    localRect.top = ((j - paramFrame.height) / 2 + paramRect.top);
    localRect.bottom = ((j - paramFrame.height) / 2 + paramRect.bottom);
    paramRect = new Rect();
    paramRect.left = ((i - paramFrame.width) / 2);
    paramRect.right = ((i - paramFrame.width) / 2 + paramFrame.width);
    paramRect.top = ((j - paramFrame.height) / 2);
    paramRect.bottom = ((j - paramFrame.height) / 2 + paramFrame.height);
    setTexCords(AlgoUtils.calTexCoordsFill(localRect, i, j));
    addAttribParam("textureCoordinate3", AlgoUtils.calTexCoordsFill(paramRect, i, j));
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramFrame.getTextureId(), 33986));
    paramFrame = new PointF();
    paramFrame.x = paramStrokeModel.getStrokeGap();
    paramFrame.y = (paramStrokeModel.getStrokeGap() * paramInt1 / paramInt2);
    paramRect = new PointF();
    if (paramInt2 > paramInt1)
    {
      paramRect.y = paramStrokeModel.getStrokeWidth();
      paramRect.x = (paramStrokeModel.getStrokeWidth() * paramInt2 / paramInt1);
    }
    for (;;)
    {
      addParam(new UniformParam.Float2fParam("strokeGapInPixel", paramFrame.x, paramFrame.y));
      addParam(new UniformParam.Float2fParam("strokeWidthInPixel", paramRect.x, paramRect.y));
      if (paramStrokeModel.getStrokeColor().length >= 4) {
        addParam(new UniformParam.Float4fParam("strokeColor", paramStrokeModel.getStrokeColor()[0], paramStrokeModel.getStrokeColor()[1], paramStrokeModel.getStrokeColor()[2], paramStrokeModel.getStrokeColor()[3]));
      }
      addParam(new UniformParam.IntParam("strokeType", paramStrokeModel.getStrokeType()));
      return;
      paramRect.x = paramStrokeModel.getStrokeWidth();
      paramRect.y = (paramStrokeModel.getStrokeWidth() * paramInt1 / paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StrokeFilter
 * JD-Core Version:    0.7.0.1
 */