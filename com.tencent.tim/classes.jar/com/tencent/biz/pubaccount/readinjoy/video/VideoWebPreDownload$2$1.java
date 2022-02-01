package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import kxz;
import mzl;
import mzl.a;
import mzm;

public class VideoWebPreDownload$2$1
  implements Runnable
{
  public VideoWebPreDownload$2$1(mzm parammzm, kxz paramkxz) {}
  
  public void run()
  {
    if (!mzl.a(this.jdField_a_of_type_Mzm.this$0, this.jdField_a_of_type_Kxz.url, this.jdField_a_of_type_Kxz.vid, this.jdField_a_of_type_Mzm.aWD)) {
      mzl.a(this.jdField_a_of_type_Mzm.this$0, this.jdField_a_of_type_Kxz.url, this.jdField_a_of_type_Kxz.vid, this.jdField_a_of_type_Mzm.wU, this.jdField_a_of_type_Mzm.aWD);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (mzl.a(this.jdField_a_of_type_Mzm.this$0) == null);
      str = (String)mzl.a(this.jdField_a_of_type_Mzm.this$0).get(this.jdField_a_of_type_Kxz.vid);
    } while (TextUtils.isEmpty(str));
    mzl.a(this.jdField_a_of_type_Mzm.this$0).r(this.jdField_a_of_type_Kxz.vid, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.2.1
 * JD-Core Version:    0.7.0.1
 */