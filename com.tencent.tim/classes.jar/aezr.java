import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import java.util.HashMap;
import org.json.JSONObject;

public class aezr
  extends ClickableSpan
{
  public aezr(MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.val$app.getCurrentNickname();
    String str = this.a.frienduin;
    Object localObject1 = new JSONObject();
    paramView = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("name", localObject2);
      ((JSONObject)localObject1).put("grouptype", 1 + "");
      ((JSONObject)localObject1).put("groupid", str);
      localObject2 = (zxj)this.val$app.getManager(125);
      if ((TextUtils.isEmpty(this.a.redBagId)) && (!TextUtils.isEmpty(this.a.redBagIndex))) {
        this.a.redBagId = ((String)((zxj)localObject2).hM.get(this.a.redBagIndex));
      }
      if (TextUtils.isEmpty(this.a.redBagId)) {
        return;
      }
      localObject2 = (String)((zxj)localObject2).hI.get(((zxj)localObject2).fH(this.a.istroop) + "_" + this.a.frienduin + "_" + this.a.redBagId);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      ((JSONObject)localObject1).put("listid", this.a.redBagId);
      ((JSONObject)localObject1).put("authkey", localObject2);
      paramView.put("userId", this.val$app.getCurrentAccountUin());
      paramView.put("viewTag", "redgiftDetail");
      paramView.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      paramView.put("come_from", 2);
      paramView.put("extra_data", localObject1);
    }
    catch (Exception localException)
    {
      label295:
      break label295;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", paramView.toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    paramView = new Intent(this.val$mContext, PayBridgeActivity.class);
    paramView.putExtras((Bundle)localObject1);
    paramView.putExtra("pay_requestcode", 5);
    this.val$mContext.startActivity(paramView);
    return;
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
 * Qualified Name:     aezr
 * JD-Core Version:    0.7.0.1
 */