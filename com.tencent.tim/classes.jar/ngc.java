import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.42.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.42.2;
import com.tencent.mobileqq.data.MessageRecord;

public class ngc
  implements KandianMergeManager.c
{
  public ngc(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.this$0.getCurrentActivity().runOnUiThread(new ReadInJoyListViewGroup.42.2(this));
  }
  
  public void f(MessageRecord paramMessageRecord) {}
  
  public void g(MessageRecord paramMessageRecord)
  {
    this.this$0.getCurrentActivity().runOnUiThread(new ReadInJoyListViewGroup.42.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngc
 * JD-Core Version:    0.7.0.1
 */