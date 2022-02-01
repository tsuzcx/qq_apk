import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xoe
  implements View.OnClickListener
{
  public xoe(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b.mMsgActionData;
    int i = this.b.uinType;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = aqik.c(this.this$0.app, this.this$0.mContext, (String)localObject);
      if (localObject != null)
      {
        ((aqhv)localObject).setFrom("webview");
        ((aqhv)localObject).fj("uin_type", i + "");
        ((aqhv)localObject).ace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xoe
 * JD-Core Version:    0.7.0.1
 */