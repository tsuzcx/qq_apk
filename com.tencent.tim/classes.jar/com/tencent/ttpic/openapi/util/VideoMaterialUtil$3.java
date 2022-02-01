package com.tencent.ttpic.openapi.util;

import java.io.File;
import java.io.FilenameFilter;

final class VideoMaterialUtil$3
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoMaterialUtil.3
 * JD-Core Version:    0.7.0.1
 */