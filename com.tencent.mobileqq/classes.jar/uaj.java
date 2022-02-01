import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable;
import com.tencent.qphone.base.util.QLog;

public class uaj
  implements sxa
{
  public uaj(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(sxc paramsxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramsxc.jdField_b_of_type_JavaLangString + ", url=" + paramsxc.jdField_a_of_type_JavaLangString + ", isH265=" + paramsxc.jdField_a_of_type_Boolean + ", isHWCodec=" + paramsxc.jdField_b_of_type_Boolean + ", fileBitRate=" + paramsxc.c);
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramsxc.jdField_b_of_type_JavaLangString.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.jdField_a_of_type_JavaLangString))) {
      if (TextUtils.isEmpty(paramsxc.jdField_a_of_type_JavaLangString)) {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 202, 107, 0, "vid2url failed, get null", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (paramsxc.jdField_a_of_type_Int == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 104, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramsxc.jdField_b_of_type_Boolean, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 101, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramsxc.jdField_b_of_type_Boolean, true, false);
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramsxc.jdField_b_of_type_JavaLangString + " url:" + paramsxc.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uaj
 * JD-Core Version:    0.7.0.1
 */