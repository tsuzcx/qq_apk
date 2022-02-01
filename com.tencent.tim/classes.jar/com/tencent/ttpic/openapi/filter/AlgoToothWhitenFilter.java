package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import java.util.Map;

public class AlgoToothWhitenFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputAlgoTexture;\n\nuniform lowp float whiteTeeth;\nuniform lowp float eyePouch;\nuniform lowp float radius;\nuniform lowp vec2 center;\n\nbool isTeeth(vec2 i,vec2 c,float r)\n{\n    lowp float t = (i.x - c.x)*(i.x - c.x) + (i.y - c.y)*(i.y - c.y);\n    if ( t <= r*r )\n    {\n        return true;\n    }\n    else\n    {\n        return false;\n    }\n}\n\nvoid main()\n{\n    lowp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 algoColor = texture2D(inputAlgoTexture, textureCoordinate);\n\n    if (isTeeth(textureCoordinate,center,radius)) {\n        gl_FragColor = vec4(mix(color.rgb, algoColor.rgb, whiteTeeth), 1.0);\n    } else {\n        gl_FragColor = vec4(mix(color.rgb, algoColor.rgb, eyePouch), 1.0);\n    }\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n}\n";
  private int algoTexture;
  private float centerX;
  private float centerY;
  private float eyePouch = 0.0F;
  private float radius;
  private float whiteTeeth = 0.0F;
  
  public AlgoToothWhitenFilter(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super("attribute vec4 position;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n}\n", "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputAlgoTexture;\n\nuniform lowp float whiteTeeth;\nuniform lowp float eyePouch;\nuniform lowp float radius;\nuniform lowp vec2 center;\n\nbool isTeeth(vec2 i,vec2 c,float r)\n{\n    lowp float t = (i.x - c.x)*(i.x - c.x) + (i.y - c.y)*(i.y - c.y);\n    if ( t <= r*r )\n    {\n        return true;\n    }\n    else\n    {\n        return false;\n    }\n}\n\nvoid main()\n{\n    lowp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 algoColor = texture2D(inputAlgoTexture, textureCoordinate);\n\n    if (isTeeth(textureCoordinate,center,radius)) {\n        gl_FragColor = vec4(mix(color.rgb, algoColor.rgb, whiteTeeth), 1.0);\n    } else {\n        gl_FragColor = vec4(mix(color.rgb, algoColor.rgb, eyePouch), 1.0);\n    }\n}\n");
    this.algoTexture = paramInt;
    this.radius = paramFloat1;
    this.centerX = paramFloat2;
    this.centerY = paramFloat3;
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("radius", this.radius));
    addParam(new UniformParam.Float2fParam("center", this.centerX, this.centerY));
    addParam(new UniformParam.FloatParam("whiteTeeth", this.whiteTeeth));
    addParam(new UniformParam.FloatParam("eyePouch", this.eyePouch));
    addParam(new UniformParam.TextureParam("inputAlgoTexture", this.algoTexture, 33985));
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("whiteTeeth")) {
      this.whiteTeeth = ((Float)paramMap.get("whiteTeeth")).floatValue();
    }
    if (paramMap.containsKey("eyePouch")) {
      this.eyePouch = ((Float)paramMap.get("eyePouch")).floatValue();
    }
    this.whiteTeeth /= 100.0F;
    this.eyePouch /= 100.0F;
    addParam(new UniformParam.FloatParam("whiteTeeth", this.whiteTeeth));
    addParam(new UniformParam.FloatParam("eyePouch", this.eyePouch));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.AlgoToothWhitenFilter
 * JD-Core Version:    0.7.0.1
 */