package io.flutter.view;

import java.io.File;
import java.io.FilenameFilter;

class ResourceCleaner$1
  implements FilenameFilter
{
  ResourceCleaner$1(ResourceCleaner paramResourceCleaner) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(".org.chromium.Chromium.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.ResourceCleaner.1
 * JD-Core Version:    0.7.0.1
 */