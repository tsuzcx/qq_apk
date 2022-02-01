import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqstory.storyHome.VideoEncodeActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qri
  implements RadioGroup.OnCheckedChangeListener
{
  public qri(VideoEncodeActivity paramVideoEncodeActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    RadioButton localRadioButton = (RadioButton)paramRadioGroup.findViewById(paramInt);
    VideoEncodeActivity.a(this.this$0, (String)localRadioButton.getTag());
    ram.w("Q.qqstory:VideoEncodeActivity", "select fake vid %s", new Object[] { VideoEncodeActivity.a(this.this$0) });
    VideoEncodeActivity.a(this.this$0);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qri
 * JD-Core Version:    0.7.0.1
 */