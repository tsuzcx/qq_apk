package com.tencent.ttpic.filter.shader;

public abstract interface FaceMaskVertexShaderContent
{
  public static final String CONTENT = "attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.FaceMaskVertexShaderContent
 * JD-Core Version:    0.7.0.1
 */