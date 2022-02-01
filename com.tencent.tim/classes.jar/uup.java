import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity.a;
import com.tencent.mobileqq.data.Card;

public class uup
  extends accn
{
  public uup(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (DiscussionInfoCardActivity.a(this.this$0) != null)) {
        DiscussionInfoCardActivity.a(this.this$0).notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uup
 * JD-Core Version:    0.7.0.1
 */