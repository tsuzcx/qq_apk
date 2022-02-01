package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class DotFilter
  extends BaseFilter
{
  public static final String DOT_FRAGMENT = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float width;\nuniform lowp float height;\nhighp vec2 center = vec2(0.5, 0.5);\nhighp float angle = 1.57;\nhighp float scale = 0.3;\nhighp vec3 brightness = vec3(0.2125, 0.7154, 0.0721);\nhighp float rgb2gray(highp vec4 inputcolor) {\n    return dot(inputcolor.rgb,brightness);\n}\nhighp float blendLighten(highp float base, highp float blend) {\n    return max(blend,base);\n}\nhighp vec3 blendLighten(highp vec3 base, highp vec3 blend) {\n    return vec3(blendLighten(base.r,blend.r),blendLighten(base.g,blend.g),blendLighten(base.b,blend.b));\n}\nhighp vec3 blendLighten(highp vec3 base, highp vec3 blend, highp float opacity) {\n    return (blendLighten(base, blend) * opacity + base * (1.0 - opacity));\n}\nhighp float pattern() {\n    highp float s = sin( angle ), c = cos( angle );\n    highp vec2 tex = textureCoordinate * vec2(width, height) - center;\n    highp vec2 point = vec2( c * tex.x - s * tex.y, s * tex.x + c * tex.y ) * scale;\n    return ( sin( point.x ) * sin( point.y ) ) * 4.0;\n}\nvoid main() {\n    highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    highp float average = ( color.r + color.g + color.b ) / 3.0;\n    highp vec4 halftone = vec4( vec3( average * 10.0  - 5.0 - pattern() ), color.a );\n   gl_FragColor = vec4(blendLighten(color.rgb, halftone.rgb, 0.02), color.a);\n}\n";
  
  public DotFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float width;\nuniform lowp float height;\nhighp vec2 center = vec2(0.5, 0.5);\nhighp float angle = 1.57;\nhighp float scale = 0.3;\nhighp vec3 brightness = vec3(0.2125, 0.7154, 0.0721);\nhighp float rgb2gray(highp vec4 inputcolor) {\n    return dot(inputcolor.rgb,brightness);\n}\nhighp float blendLighten(highp float base, highp float blend) {\n    return max(blend,base);\n}\nhighp vec3 blendLighten(highp vec3 base, highp vec3 blend) {\n    return vec3(blendLighten(base.r,blend.r),blendLighten(base.g,blend.g),blendLighten(base.b,blend.b));\n}\nhighp vec3 blendLighten(highp vec3 base, highp vec3 blend, highp float opacity) {\n    return (blendLighten(base, blend) * opacity + base * (1.0 - opacity));\n}\nhighp float pattern() {\n    highp float s = sin( angle ), c = cos( angle );\n    highp vec2 tex = textureCoordinate * vec2(width, height) - center;\n    highp vec2 point = vec2( c * tex.x - s * tex.y, s * tex.x + c * tex.y ) * scale;\n    return ( sin( point.x ) * sin( point.y ) ) * 4.0;\n}\nvoid main() {\n    highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    highp float average = ( color.r + color.g + color.b ) / 3.0;\n    highp vec4 halftone = vec4( vec3( average * 10.0  - 5.0 - pattern() ), color.a );\n   gl_FragColor = vec4(blendLighten(color.rgb, halftone.rgb, 0.02), color.a);\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("width", 540.0F));
    addParam(new UniformParam.FloatParam("height", 960.0F));
  }
  
  public void setAdjustParam(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.DotFilter
 * JD-Core Version:    0.7.0.1
 */