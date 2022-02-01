import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;

public class mjm
  extends lce
{
  public mjm(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void b(int paramInt, mhn parammhn)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.this$0)))
    {
      ReadInJoyDeliverVideoActivity.a(this.this$0, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.this$0).putString("arg_video_cover_url", parammhn.coverUrl);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putString("arg_video_url", parammhn.url);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putString("arg_video_title", parammhn.title);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putString("arg_video_uuid", parammhn.uuid);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putLong("arg_video_duration", parammhn.duration);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putInt("arg_video_cover_width", parammhn.coverWidth);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putInt("arg_video_cover_height", parammhn.coverHeight);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putInt("arg_video_width", parammhn.videoWidth);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putInt("arg_video_height", parammhn.videoHeight);
      ReadInJoyDeliverVideoActivity.a(this.this$0).putString("arg_topic_id", parammhn.businessId + "");
      ReadInJoyDeliverVideoActivity.a(this.this$0).setHint("#" + parammhn.businessName + "#");
      ReadInJoyDeliverVideoActivity.a(this.this$0, parammhn.businessUrl);
      ReadInJoyDeliverVideoActivity.a(this.this$0, true);
      ReadInJoyDeliverVideoActivity.a(this.this$0, parammhn.coverUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjm
 * JD-Core Version:    0.7.0.1
 */