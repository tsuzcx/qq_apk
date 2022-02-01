import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup.10.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup.10.2;
import com.tencent.mobileqq.data.MessageRecord;

public class ngt
  implements KandianMergeManager.c
{
  public ngt(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.this$0.getCurrentActivity().runOnUiThread(new ReadInJoyProteusFamilyListViewGroup.10.2(this));
  }
  
  public void f(MessageRecord paramMessageRecord) {}
  
  public void g(MessageRecord paramMessageRecord)
  {
    this.this$0.getCurrentActivity().runOnUiThread(new ReadInJoyProteusFamilyListViewGroup.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngt
 * JD-Core Version:    0.7.0.1
 */