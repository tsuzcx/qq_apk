package com.tencent.ttpic.particle;

import java.util.List;

public class GPUParticleConfig
{
  public BackgroundConfig backgroundConfig;
  public int emitterType;
  public byte[] jsonBytes;
  public SourcePositionPath sourcePositionPath;
  public List<Sprite> sprites;
  public String startColorReference;
  public String svg;
  
  public static class BackgroundConfig
  {
    public float duration;
    public int startSide;
    public float strokeWidth;
    public String texture;
    public int type;
  }
  
  public static class SourcePositionPath
  {
    public float[] anchorPoint = new float[3];
    public float[] canvas;
    public float duration;
    public float[][] path;
    public int scale;
  }
  
  public static class Sprite
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.GPUParticleConfig
 * JD-Core Version:    0.7.0.1
 */