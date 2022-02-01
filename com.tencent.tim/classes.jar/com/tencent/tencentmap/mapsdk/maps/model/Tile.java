package com.tencent.tencentmap.mapsdk.maps.model;

public final class Tile
{
  public final byte[] mData;
  public final int mHeight;
  public final int mWidth;
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Tile
 * JD-Core Version:    0.7.0.1
 */