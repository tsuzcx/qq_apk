package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import kbp;
import kxm;
import kxm.b;
import mix;
import mnq;
import mnr;
import mns;
import mnw;
import nch;

class CompressVideoTaskStep$1$1$1
  implements Runnable
{
  CompressVideoTaskStep$1$1$1(CompressVideoTaskStep.1.1 param1, String paramString) {}
  
  public void run()
  {
    long l2 = 0L;
    if ((this.a.val$retCode == 0) || (this.a.val$retCode == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      UgcVideo localUgcVideo;
      if (bool)
      {
        this.a.jdField_a_of_type_Mnr.b.compressPath = this.a.val$outPath;
        this.a.jdField_a_of_type_Mnr.b.fileMd5 = this.ajt;
        localUgcVideo = this.a.jdField_a_of_type_Mnr.b;
        if (this.a.jdField_a_of_type_Nch != null) {}
        for (long l1 = this.a.jdField_a_of_type_Nch.fileSize;; l1 = 0L)
        {
          localUgcVideo.fileSize = l1;
          if (!mnq.a(this.a.jdField_a_of_type_Mnr.a)) {
            this.a.jdField_a_of_type_Mnr.b.compressProgress = 100;
          }
          this.a.jdField_a_of_type_Mnr.b.compressTime = 0L;
          if (this.a.val$retCode == 0) {
            this.a.jdField_a_of_type_Mnr.b.compressTime = (System.currentTimeMillis() - this.a.jdField_a_of_type_Mnr.b.startCompressTime);
          }
          localUgcVideo = this.a.jdField_a_of_type_Mnr.b;
          l1 = l2;
          if (this.a.jdField_a_of_type_Nch != null) {
            l1 = this.a.jdField_a_of_type_Nch.bitrate;
          }
          localUgcVideo.bitrate = l1;
          mnq.a(this.a.jdField_a_of_type_Mnr.a).f(this.a.jdField_a_of_type_Mnr.b);
          if (mnq.a(this.a.jdField_a_of_type_Mnr.a) != null) {
            mnq.a(this.a.jdField_a_of_type_Mnr.a).a(1, bool, true, null);
          }
          this.a.jdField_a_of_type_Mnr.a.aFM();
          return;
        }
      }
      if (this.a.val$retCode == 6) {
        this.a.jdField_a_of_type_Mnr.b.status = UgcVideo.STATUS_PAUSE;
      }
      for (;;)
      {
        mnq.a(this.a.jdField_a_of_type_Mnr.a, false);
        this.a.jdField_a_of_type_Mnr.b.compressProgress = 0;
        kbp.bp("0X800AC65", mix.a(kxm.a(), this.a.jdField_a_of_type_Mnr.b).a("compress_time", Long.valueOf(this.a.jdField_a_of_type_Mnr.b.compressTime)).a("error_code", Integer.valueOf(this.a.val$retCode)).build());
        break;
        this.a.jdField_a_of_type_Mnr.b.status = UgcVideo.STATUS_FAILED;
        localUgcVideo = this.a.jdField_a_of_type_Mnr.b;
        localUgcVideo.retryTime += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */