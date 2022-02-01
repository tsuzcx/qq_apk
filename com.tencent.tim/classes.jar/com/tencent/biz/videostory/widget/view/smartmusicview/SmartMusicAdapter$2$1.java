package com.tencent.biz.videostory.widget.view.smartmusicview;

import java.util.List;
import srq;
import srs.a;
import ssa;
import ssc;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(ssc paramssc) {}
  
  public void run()
  {
    if ((ssa.a(this.a.b) != null) && (ssa.a(this.a.b) != null))
    {
      int i = ssa.a(this.a.b).getCurrentPosition() % this.a.b.ut();
      ssa.a(this.a.b).a((VsMusicItemInfo)ssa.a(this.a.b).get(i), i, this.a.aML);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */