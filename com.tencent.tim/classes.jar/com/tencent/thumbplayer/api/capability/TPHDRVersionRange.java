package com.tencent.thumbplayer.api.capability;

public class TPHDRVersionRange
{
  public int lowerboundPatchVersion;
  public int lowerboundSystemVersion;
  public int upperboundPatchVersion;
  public int upperboundSystemVersion;
  
  public TPHDRVersionRange(int paramInt1, int paramInt2)
  {
    this.upperboundSystemVersion = paramInt1;
    this.lowerboundSystemVersion = paramInt2;
    this.upperboundPatchVersion = 0;
    this.lowerboundPatchVersion = 0;
  }
  
  public TPHDRVersionRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.upperboundSystemVersion = paramInt1;
    this.lowerboundSystemVersion = paramInt2;
    this.upperboundPatchVersion = paramInt3;
    this.lowerboundPatchVersion = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPHDRVersionRange
 * JD-Core Version:    0.7.0.1
 */