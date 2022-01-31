import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;

class twq
{
  public TextView a;
  
  public twq(FrameLayout paramFrameLayout)
  {
    this.a = ((TextView)paramFrameLayout.getChildAt(0));
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo, FeedCloudMeta.StFeed paramStFeed)
  {
    if (TextUtils.isEmpty(paramStTagInfo.tagName.get()))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(twp.a(paramStTagInfo));
    this.a.setOnClickListener(new twr(this, paramStFeed, paramStTagInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twq
 * JD-Core Version:    0.7.0.1
 */