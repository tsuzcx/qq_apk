import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.Switch;

public class kip
  implements arhz.a
{
  public kip(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onBackPressed()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.this$0.afG)
    {
      localObject = this.this$0;
      if (ReadInJoySettingActivity.a(this.this$0)) {
        break label61;
      }
      bool1 = true;
      ReadInJoySettingActivity.a((ReadInJoySettingActivity)localObject, bool1);
      localObject = ReadInJoySettingActivity.a(this.this$0);
      if (ReadInJoySettingActivity.a(this.this$0)) {
        break label66;
      }
    }
    label61:
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Switch)localObject).setChecked(bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kip
 * JD-Core Version:    0.7.0.1
 */