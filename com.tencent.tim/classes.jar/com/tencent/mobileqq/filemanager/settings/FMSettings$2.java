package com.tencent.mobileqq.filemanager.settings;

import ahaf;
import ahaf.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FMSettings$2
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.kK.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l = ahaf.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (ahaf.b)this.this$0.kK.get(localObject);
      localObject = ahaf.c(this.this$0, ((ahaf.b)localObject).rootPath + ((ahaf.b)localObject).ext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.2
 * JD-Core Version:    0.7.0.1
 */