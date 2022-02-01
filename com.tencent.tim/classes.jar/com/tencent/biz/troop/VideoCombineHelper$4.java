package com.tencent.biz.troop;

import acfp;
import java.io.File;
import java.util.ArrayList;
import sli;
import sli.d;
import sll;

public class VideoCombineHelper$4
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(sli.aEA + File.separator + "v1.mp4");
    File localFile2 = new File(sli.aEA + File.separator + "v2.mp4");
    File localFile3 = new File(sli.aEA + File.separator + "v3.mp4");
    File localFile4 = new File(sli.aEA + File.separator + "v4.mp4");
    File localFile5 = new File(sli.aEA + File.separator + "m1.m4a");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localFile4.getAbsolutePath());
    localArrayList.add(localFile2.getAbsolutePath());
    localArrayList.add(localFile3.getAbsolutePath());
    localArrayList.add(localFile1.getAbsolutePath());
    new sli.d(this.this$0, new sll(this), "key", localArrayList, localFile5.getAbsolutePath(), acfp.m(2131716368)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.4
 * JD-Core Version:    0.7.0.1
 */