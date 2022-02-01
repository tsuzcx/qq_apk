package com.tencent.qqmini.miniapp.util;

import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;

public abstract class VideoCompressProxy
{
  protected VideoCompress.Option compressOption;
  public VideoCompress.Listener compresslistener;
  public LocalMediaInfo mediaInfo;
  public String outputPath;
  
  public abstract void execute();
  
  public VideoCompressProxy listen(VideoCompress.Listener paramListener)
  {
    this.compresslistener = paramListener;
    return this;
  }
  
  public VideoCompressProxy setMedia(LocalMediaInfo paramLocalMediaInfo)
  {
    this.mediaInfo = paramLocalMediaInfo;
    return this;
  }
  
  public VideoCompressProxy setOption(VideoCompress.Option paramOption)
  {
    this.compressOption = paramOption;
    return this;
  }
  
  public VideoCompressProxy setOutputPath(String paramString)
  {
    this.outputPath = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.VideoCompressProxy
 * JD-Core Version:    0.7.0.1
 */