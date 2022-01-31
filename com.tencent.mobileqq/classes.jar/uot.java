import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqstory.storyHome.VideoEncodeActivity;

public class uot
  implements RadioGroup.OnCheckedChangeListener
{
  public uot(VideoEncodeActivity paramVideoEncodeActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramRadioGroup = (RadioButton)paramRadioGroup.findViewById(paramInt);
    VideoEncodeActivity.a(this.a, (String)paramRadioGroup.getTag());
    veg.d("Q.qqstory:VideoEncodeActivity", "select fake vid %s", new Object[] { VideoEncodeActivity.a(this.a) });
    VideoEncodeActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uot
 * JD-Core Version:    0.7.0.1
 */