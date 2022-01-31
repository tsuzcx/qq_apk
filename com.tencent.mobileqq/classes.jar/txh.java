import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;

class txh
{
  public TextView a;
  
  public txh(FrameLayout paramFrameLayout)
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
    this.a.setText(txg.a(paramStTagInfo));
    this.a.setOnClickListener(new txi(this, paramStFeed, paramStTagInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */