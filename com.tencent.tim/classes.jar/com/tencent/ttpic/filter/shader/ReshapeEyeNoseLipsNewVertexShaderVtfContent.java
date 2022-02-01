package com.tencent.ttpic.filter.shader;

public abstract interface ReshapeEyeNoseLipsNewVertexShaderVtfContent
{
  public static final String CONTENT = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n     gl_Position = vec4(position.x*2.0-1.0, position.y*2.0-1.0, 0.0, 1.0);\n     textureCoordinate = inputTextureCoordinate.xy;\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.ReshapeEyeNoseLipsNewVertexShaderVtfContent
 * JD-Core Version:    0.7.0.1
 */