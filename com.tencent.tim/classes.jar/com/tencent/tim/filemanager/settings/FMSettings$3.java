package com.tencent.tim.filemanager.settings;

import audn;
import audn.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FMSettings$3
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.kK.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l = audn.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (audn.b)this.this$0.kK.get(localObject);
      localObject = audn.b(this.this$0, ((audn.b)localObject).rootPath + ((audn.b)localObject).ext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.settings.FMSettings.3
 * JD-Core Version:    0.7.0.1
 */