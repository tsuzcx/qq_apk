import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class uox
  extends accn
{
  public uox(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.this$0) == 0) && (ChatSettingActivity.b(this.this$0).equals(paramObject.uin)))
        {
          String str = aqgv.s(this.this$0.app, ChatSettingActivity.b(this.this$0));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.f(this.this$0)))) {
            ChatSettingActivity.c(this.this$0, str);
          }
        }
        if ((this.this$0.CM != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.this$0))) && (ChatSettingActivity.b(this.this$0).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.this$0, ChatSettingActivity.a(this.this$0, ChatSettingActivity.b(this.this$0)), this.this$0.CM);
        }
      }
      return;
    }
  }
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.this$0.z != null) && (paramBoolean2 != this.this$0.z.isChecked()))
    {
      this.this$0.z.setOnCheckedChangeListener(null);
      this.this$0.z.setChecked(paramBoolean2);
      this.this$0.z.setOnCheckedChangeListener(this.this$0);
    }
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.this$0.z != null) && (paramBoolean2 != this.this$0.z.isChecked()))
    {
      this.this$0.z.setOnCheckedChangeListener(null);
      this.this$0.z.setChecked(paramBoolean2);
      this.this$0.z.setOnCheckedChangeListener(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */