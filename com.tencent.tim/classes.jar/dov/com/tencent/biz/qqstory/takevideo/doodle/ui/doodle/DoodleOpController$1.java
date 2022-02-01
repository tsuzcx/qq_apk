package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import axol;
import aymj;
import aymk;
import aymt;
import aymu;
import com.tencent.common.app.AppInterface;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DoodleOpController$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.aB.iterator();
    while (localIterator.hasNext())
    {
      aymj localaymj = (aymj)localIterator.next();
      if ((localaymj instanceof aymt))
      {
        AppInterface localAppInterface = axol.getAppInterface();
        this.this$0.b(localAppInterface, ((aymt)localaymj).bGG);
      }
    }
    this.this$0.u = this.aB;
    this.this$0.a.eSO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController.1
 * JD-Core Version:    0.7.0.1
 */