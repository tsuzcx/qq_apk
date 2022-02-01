import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Map;
import org.json.JSONObject;

public class aezy
  extends ClickableSpan
{
  public aezy(MessageForQQWalletTips paramMessageForQQWalletTips, SoftReference paramSoftReference1, SoftReference paramSoftReference2, QQAppInterface paramQQAppInterface, Context paramContext, wwn paramwwn, zxj paramzxj, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (Context)this.q.get();
    Object localObject1 = (QQAppInterface)this.r.get();
    if ((localObject1 == null) || (paramView == null)) {}
    do
    {
      return;
      QLog.i(MessageForQQWalletTips.access$000(), 2, "rich click, msgtype: " + this.this$0.msgType + ", msgsubtype: " + this.this$0.subType + ",isEq:" + TextUtils.equals(((QQAppInterface)localObject1).getCurrentAccountUin(), this.this$0.reciverUin));
      if (!TextUtils.isEmpty(this.this$0.bytes_jumpurl))
      {
        QLog.i(MessageForQQWalletTips.access$000(), 2, "gold red package...");
        paramView = avor.a(this.this$0.bytes_jumpurl, MessageForQQWalletTips.access$100(this.this$0, this.val$app), true);
        aagc.M(this.val$context, paramView);
        return;
      }
      if ((MessageForQQWalletTips.access$200(this.this$0) != 524288) || (this.b == null) || (this.d == null)) {
        break;
      }
      localObject2 = this.d.a(MessageForQQWalletTips.access$300(this.this$0));
      if ((localObject2 == null) || (((zxi)localObject2).isOpen) || (((zxi)localObject2).isFinish) || (((zxi)localObject2).VU())) {
        break;
      }
      paramView = this.d.hV(((zxi)localObject2).bbb);
    } while (aqmr.isEmpty(paramView));
    this.b.k(MessageForQQWalletTips.access$300(this.this$0), paramView, xvk.cI(this.this$0.subChannel), this.this$0.subChannel);
    return;
    if (TextUtils.isEmpty(MessageForQQWalletTips.access$300(this.this$0)))
    {
      QLog.i(MessageForQQWalletTips.access$000(), 2, "error, listId is null");
      return;
    }
    Object localObject2 = MessageForQQWalletTips.access$400(this.this$0, (QQAppInterface)localObject1);
    String str1 = (String)((Map)localObject2).get("grouptype");
    String str2 = (String)((Map)localObject2).get("name");
    String str3 = (String)((Map)localObject2).get("groupId");
    JSONObject localJSONObject = new JSONObject();
    localObject2 = new JSONObject();
    try
    {
      localJSONObject.put("listid", MessageForQQWalletTips.access$300(this.this$0));
      localJSONObject.put("name", str2);
      localJSONObject.put("grouptype", str1);
      localJSONObject.put("groupid", str3);
      if (this.this$0.authKey != null) {
        localJSONObject.put("authkey", this.this$0.authKey);
      }
      ((JSONObject)localObject2).put("userId", ((QQAppInterface)localObject1).getCurrentAccountUin());
      ((JSONObject)localObject2).put("viewTag", "redgiftDetail");
      ((JSONObject)localObject2).put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      ((JSONObject)localObject2).put("come_from", 2);
      ((JSONObject)localObject2).put("extra_data", localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    localObject2 = new Intent(paramView, PayBridgeActivity.class);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("pay_requestcode", 5);
    paramView.startActivity((Intent)localObject2);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.TJ);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezy
 * JD-Core Version:    0.7.0.1
 */