package com.tencent.av.opengl.program;

import iqh;
import iqi;
import iqj;

public class DrawProgram
  extends TextureProgram
{
  public DrawProgram()
  {
    super("uniform mat4 uMatrix;attribute vec2 aPosition;void main() {vec4 pos = vec4 (aPosition, 0.0, 1.0);gl_Position  = uMatrix * pos;}", "precision mediump float;uniform vec4 uColor;void main() {gl_FragColor = uColor;}", new iqi[] { new iqh("aPosition"), new iqj("uMatrix"), new iqj("uColor") }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.program.DrawProgram
 * JD-Core Version:    0.7.0.1
 */