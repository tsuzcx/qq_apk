package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import axic;
import axic.a;
import java.util.ArrayList;
import java.util.List;

public final class FaceChangeUtils$2
  implements Runnable
{
  public FaceChangeUtils$2(List paramList, Bitmap paramBitmap, axic.a parama) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.MF.size())
    {
      localArrayList.add(axic.b(this.ho, (String)this.MF.get(i)));
      i += 1;
    }
    this.a.bl(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.2
 * JD-Core Version:    0.7.0.1
 */