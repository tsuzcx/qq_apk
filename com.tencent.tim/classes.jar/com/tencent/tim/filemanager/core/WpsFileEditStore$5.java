package com.tencent.tim.filemanager.core;

import atvp;
import atvp.a;
import atvp.b;
import atvp.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WpsFileEditStore$5
  implements Runnable
{
  public WpsFileEditStore$5(atvp paramatvp, String paramString, boolean paramBoolean1, boolean paramBoolean2, atvp.b paramb) {}
  
  public void run()
  {
    atvp.a(this.this$0).remove(this.bJY);
    Object localObject = (ArrayList)atvp.b(this.this$0).remove(this.bJY);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        atvp.a locala = (atvp.a)((Iterator)localObject).next();
        if ((locala != null) && (locala.a != null)) {
          locala.a.a(this.bJY, this.diH, this.diI, this.a, locala.bH);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.WpsFileEditStore.5
 * JD-Core Version:    0.7.0.1
 */