package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import java.io.File;
import mnw;

public class RIJUgcVideoPublishManager$6
  implements Runnable
{
  public RIJUgcVideoPublishManager$6(mnw parammnw, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    File localFile;
    if ((this.b.compressPath != null) && (!this.b.compressPath.isEmpty()))
    {
      localFile = new File(this.b.compressPath);
      if ((localFile.exists()) && (!this.b.compressPath.equals(this.b.filePath))) {
        localFile.delete();
      }
    }
    if ((this.b.coverPath != null) && (!this.b.coverPath.isEmpty()))
    {
      localFile = new File(this.b.coverPath);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.6
 * JD-Core Version:    0.7.0.1
 */