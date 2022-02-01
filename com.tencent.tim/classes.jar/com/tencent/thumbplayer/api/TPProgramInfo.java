package com.tencent.thumbplayer.api;

public class TPProgramInfo
{
  public boolean actived;
  public long bandwidth;
  public int programId;
  public String resolution;
  public String url;
  
  public String toString()
  {
    return "TPProgramInfo{bandwidth=" + this.bandwidth + ", url='" + this.url + '\'' + ", resolution='" + this.resolution + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPProgramInfo
 * JD-Core Version:    0.7.0.1
 */