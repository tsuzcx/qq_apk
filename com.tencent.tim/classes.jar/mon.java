import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.mobileqq.widget.QQToast;

public class mon
  extends lce
{
  public mon(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment) {}
  
  public void aD(String paramString, int paramInt)
  {
    if (("OidbSvc.0xbd4_1".equals(paramString)) && (this.this$0.getActivity() != null))
    {
      this.this$0.afc = true;
      this.this$0.aAt();
      if (paramInt == 0)
      {
        ReadInJoySelectMemberAQFragment.a(this.this$0, 0);
        ReadInJoySelectMemberAQFragment.a(this.this$0, false);
        this.this$0.aQO();
        this.this$0.getActivity().finish();
        ReadInJoySelectMemberAQFragment.a(this.this$0, true);
      }
    }
    else
    {
      return;
    }
    ReadInJoySelectMemberAQFragment.a(this.this$0, true);
    ReadInJoySelectMemberAQFragment.a(this.this$0, 2);
    QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131718504), 0).show(ReadInJoySelectMemberAQFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mon
 * JD-Core Version:    0.7.0.1
 */