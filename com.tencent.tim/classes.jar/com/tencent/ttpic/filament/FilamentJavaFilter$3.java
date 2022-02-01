package com.tencent.ttpic.filament;

import com.tencent.ttpic.openapi.model.GLBItemJava;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FilamentJavaFilter$3
  implements Runnable
{
  FilamentJavaFilter$3(FilamentJavaFilter paramFilamentJavaFilter) {}
  
  public void run()
  {
    Iterator localIterator = FilamentJavaFilter.access$1000(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
      byte[] arrayOfByte = FilamentJavaFilter.access$1100(this.this$0, localGLBItemJava);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        FilamentJavaFilter.access$1200(this.this$0).put(localGLBItemJava, arrayOfByte);
      }
    }
    FilamentJavaFilter.access$1302(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentJavaFilter.3
 * JD-Core Version:    0.7.0.1
 */