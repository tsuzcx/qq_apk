import MQQ.GetRoamToastRsp;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class upi
  extends aclh
{
  public upi(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(boolean paramBoolean, GetRoamToastRsp paramGetRoamToastRsp)
  {
    if (this.this$0.cM == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramBoolean) && (paramGetRoamToastRsp != null) && (!TextUtils.isEmpty(paramGetRoamToastRsp.sToast)) && (((acle)this.this$0.app.getBusinessHandler(13)).a(paramGetRoamToastRsp)))
    {
      localObject1 = paramGetRoamToastRsp.sToast;
      int i = ((String)localObject1).indexOf('#');
      if (i < 0) {
        break label306;
      }
      int j = ((String)localObject1).indexOf('#', i + 1);
      if (j < 0) {
        break label306;
      }
      localObject2 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1, 0, i);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1, i + 1, j);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1, j + 1, ((String)localObject1).length());
      ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(-12541697), i, j - 1, 33);
      localObject1 = localObject2;
    }
    label298:
    label306:
    for (;;)
    {
      this.this$0.CH.setText((CharSequence)localObject1);
      this.this$0.cM.setTag(paramGetRoamToastRsp);
      this.this$0.cM.setVisibility(0);
      anot.a(this.this$0.app, "dc00898", "", "", "0X8009E31", "0X8009E31", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel())
      {
        localObject1 = ChatSettingActivity.a(this.this$0);
        localObject2 = new StringBuilder().append("onGetRoamToast: ").append(paramBoolean).append(",");
        if (paramGetRoamToastRsp != null) {
          break label298;
        }
      }
      for (paramGetRoamToastRsp = "null";; paramGetRoamToastRsp = paramGetRoamToastRsp.sToast)
      {
        QLog.d((String)localObject1, 2, paramGetRoamToastRsp);
        this.this$0.cM.setVisibility(8);
        return;
      }
    }
  }
  
  public void cj(String paramString, int paramInt)
  {
    ChatSettingActivity.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upi
 * JD-Core Version:    0.7.0.1
 */