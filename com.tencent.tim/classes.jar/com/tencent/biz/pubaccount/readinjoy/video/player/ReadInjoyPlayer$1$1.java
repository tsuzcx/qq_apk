package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kxz;
import nbi;
import nbj;
import nbk;

public class ReadInjoyPlayer$1$1
  implements Runnable
{
  public ReadInjoyPlayer$1$1(nbj paramnbj, kxz paramkxz) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Kxz.vid.equals(this.jdField_a_of_type_Nbj.val$vid)) && (nbi.a(this.jdField_a_of_type_Nbj.b, this.jdField_a_of_type_Nbj.val$vid, ""))) {
      if (this.jdField_a_of_type_Kxz.errorCode == 2) {
        this.jdField_a_of_type_Nbj.b.j(123, 108, 0, "vid2url failed, video deleted");
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Kxz.url))
      {
        this.jdField_a_of_type_Nbj.b.j(123, 107, 0, "vid2url failed, get null");
        return;
      }
      if (this.jdField_a_of_type_Kxz.videoType == 1) {}
      for (int i = 102;; i = 101)
      {
        this.jdField_a_of_type_Nbj.b.a(this.jdField_a_of_type_Kxz.vid, this.jdField_a_of_type_Kxz.url, this.jdField_a_of_type_Kxz.adF, this.jdField_a_of_type_Kxz.Tx, i, this.jdField_a_of_type_Nbj.xi, this.jdField_a_of_type_Nbj.val$duration);
        this.jdField_a_of_type_Nbj.b.a.c(this.jdField_a_of_type_Kxz);
        return;
      }
    }
    QLog.d(nbi.a(this.jdField_a_of_type_Nbj.b), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_Kxz.vid + " url:" + this.jdField_a_of_type_Kxz.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */