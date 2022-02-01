import android.os.Bundle;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;
import com.tencent.mobileqq.widget.QQToast;

public class jsc
  implements acci
{
  public jsc(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Bundle)paramObject;
    switch (paramInt)
    {
    default: 
      return;
    case 17: 
      paramBoolean = paramObject.getBoolean("result");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean)
      {
        paramObject = this.this$0.getString(2131698215);
        localStringBuilder.append(paramObject);
        localStringBuilder.append(this.this$0.getString(2131698213));
        localStringBuilder.append(this.this$0.mPluginName);
        if (!paramBoolean) {
          break label233;
        }
        paramInt = 2;
        label104:
        QQToast.a(this.this$0, paramInt, localStringBuilder.toString(), 1).show(this.this$0.getTitleBarHeight());
        paramObject = this.this$0;
        if (!paramBoolean) {
          break label238;
        }
      }
      break;
    }
    label233:
    label238:
    for (paramInt = -1;; paramInt = 0)
    {
      paramObject.setResult(paramInt);
      return;
      this.this$0.mIsOpen = paramObject.getBoolean("isOpen");
      this.this$0.mPluginName = paramObject.getString("name");
      if (this.this$0.mPluginName != null) {
        this.this$0.Ui = this.this$0.getString(2131698275, new Object[] { this.this$0.mPluginName });
      }
      LebaSearchMoreInfoActivity.a(this.this$0);
      return;
      paramObject = this.this$0.getString(2131698214);
      break;
      paramInt = 1;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsc
 * JD-Core Version:    0.7.0.1
 */