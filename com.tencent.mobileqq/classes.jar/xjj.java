import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

public class xjj
  implements zqq
{
  public long a;
  public StoryVideoItem a;
  public String a;
  public String b;
  
  public xjj(String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.b = paramString2;
  }
  
  public void onFailure(String paramString)
  {
    paramString = new xji(this.b, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    wjj.a().dispatch(paramString);
    yup.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    yup.a("play_video", "down_watermark", 0, 1, new String[0]);
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    xji localxji = new xji(this.b, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    wjj.a().dispatch(localxji);
  }
  
  public void onSuccess(String paramString)
  {
    paramString = new xji(this.b, 2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    paramString.b = this.jdField_a_of_type_JavaLangString;
    wjj.a().dispatch(paramString);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    long l3 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration;
    yup.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    yup.a("play_video", "down_watermark_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(l3) });
    yup.a("play_video", "down_watermark", 0, 0, new String[0]);
    zom.a(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjj
 * JD-Core Version:    0.7.0.1
 */