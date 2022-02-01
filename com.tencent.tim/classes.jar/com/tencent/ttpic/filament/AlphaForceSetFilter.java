package com.tencent.ttpic.filament;

import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class AlphaForceSetFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec4 color = texture2D (inputImageTexture, textureCoordinate);gl_FragColor = color / color.a;\n}\n";
  
  public AlphaForceSetFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec4 color = texture2D (inputImageTexture, textureCoordinate);gl_FragColor = color / color.a;\n}\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.AlphaForceSetFilter
 * JD-Core Version:    0.7.0.1
 */