import android.view.View;
import feedcloud.FeedCloudMeta.StFeed;

public class vus
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private long b;
  private long c;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
    this.c = (this.b - this.jdField_a_of_type_Long);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vus
 * JD-Core Version:    0.7.0.1
 */