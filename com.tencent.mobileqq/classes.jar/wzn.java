import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;

public abstract class wzn
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  final String c;
  final String d;
  final String e;
  
  wzn(GoldMsgSettingActivity paramGoldMsgSettingActivity, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public abstract void a(View paramView);
  
  void a(boolean paramBoolean, GoldMsgGetReq paramGoldMsgGetReq, GoldMsgGetRsp paramGoldMsgGetRsp) {}
  
  void a(boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp) {}
  
  abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */