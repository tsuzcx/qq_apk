import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vji
  extends vjd<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public vji(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
      WSVerticalPageFragment.a(paramContext, "aio_new_msg", "direct", null, 0);
      bool = true;
    }
    while (this.jdField_a_of_type_Int != 6) {
      return bool;
    }
    uyt.a((Activity)paramContext, this.jdField_a_of_type_AndroidContentIntent, (WSRedDotPushMsg)this.jdField_a_of_type_Viu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vji
 * JD-Core Version:    0.7.0.1
 */