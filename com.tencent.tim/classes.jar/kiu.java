import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class kiu
  implements ausj.a
{
  public kiu(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.this$0).setRadioButtonChecked(paramInt);
    ((TextView)this.this$0.findViewById(2131373274)).setText(ReadInJoySettingActivity.a(this.this$0)[paramInt]);
    kxm.mC(Integer.toString(paramInt));
    kbp.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kiu
 * JD-Core Version:    0.7.0.1
 */