import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mjn
  implements kql.a
{
  public mjn(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void b(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onError: code - " + paramInt + " msg - " + paramString);
    ReadInJoyDeliverVideoActivity.a(this.this$0).post(new ReadInJoyDeliverVideoActivity.2.2(this));
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onSuccess: outputPath - " + paramString);
    ReadInJoyDeliverVideoActivity.b(this.this$0, paramString);
    ReadInJoyDeliverVideoActivity.a(this.this$0).post(new ReadInJoyDeliverVideoActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjn
 * JD-Core Version:    0.7.0.1
 */