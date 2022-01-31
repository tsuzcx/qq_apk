import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqstory.storyHome.VideoEncodeActivity;

public class uoq
  implements RadioGroup.OnCheckedChangeListener
{
  public uoq(VideoEncodeActivity paramVideoEncodeActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramRadioGroup = (RadioButton)paramRadioGroup.findViewById(paramInt);
    VideoEncodeActivity.a(this.a, (String)paramRadioGroup.getTag());
    ved.d("Q.qqstory:VideoEncodeActivity", "select fake vid %s", new Object[] { VideoEncodeActivity.a(this.a) });
    VideoEncodeActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */