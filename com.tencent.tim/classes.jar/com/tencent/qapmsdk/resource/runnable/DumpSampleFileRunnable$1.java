package com.tencent.qapmsdk.resource.runnable;

import java.io.File;
import java.util.Comparator;

class DumpSampleFileRunnable$1
  implements Comparator<File>
{
  DumpSampleFileRunnable$1(DumpSampleFileRunnable paramDumpSampleFileRunnable) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    return -paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable.1
 * JD-Core Version:    0.7.0.1
 */