import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class ngu
  extends acfd
{
  public ngu(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.this$0.mChannelID == 0) || (this.this$0.mChannelID == 70)) && (paramBoolean))
    {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.this$0.aWI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngu
 * JD-Core Version:    0.7.0.1
 */