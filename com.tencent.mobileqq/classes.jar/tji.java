import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class tji
  extends tjd<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public tji(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Int == 2)
    {
      tlv.a(paramContext, null, 0, null, null, (WSRedDotPushMsg)this.jdField_a_of_type_Tiw, 2);
      paramWSPushStrategyInfo = tlv.a();
      if ((paramWSPushStrategyInfo != null) && ((paramContext instanceof Activity))) {
        paramWSPushStrategyInfo.a((Activity)paramContext);
      }
      tlv.a();
      bool = true;
    }
    while (this.jdField_a_of_type_Int != 6) {
      return bool;
    }
    tch.a((Activity)paramContext, this.jdField_a_of_type_AndroidContentIntent, (WSRedDotPushMsg)this.jdField_a_of_type_Tiw);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tji
 * JD-Core Version:    0.7.0.1
 */