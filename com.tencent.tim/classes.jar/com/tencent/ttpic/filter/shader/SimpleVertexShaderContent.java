package com.tencent.ttpic.filter.shader;

public abstract interface SimpleVertexShaderContent
{
  public static final String CONTENT = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.SimpleVertexShaderContent
 * JD-Core Version:    0.7.0.1
 */