import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class tjf
  extends tjd<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int a;
  
  public tjf(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = 2;
    boolean bool1 = true;
    if (paramWSPushStrategyInfo == null) {
      return false;
    }
    boolean bool2 = TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme);
    if (!bool2)
    {
      tch.a(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = tlv.a();
      if (paramContext != null) {
        paramContext.a(null);
      }
      tlv.a();
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (bool2)
      {
        i = 2;
        if (this.jdField_a_of_type_Tiw != null) {
          break label93;
        }
        paramContext = "";
        label74:
        tju.a(i, 1, paramContext);
        label80:
        if (bool2) {
          break label133;
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label93:
      paramContext = ((WSRedDotPushMsg)this.jdField_a_of_type_Tiw).mFeedIds;
      break label74;
      if (this.jdField_a_of_type_Int != 6) {
        break label80;
      }
      if (bool2) {}
      for (;;)
      {
        tju.d(i);
        break;
        i = 1;
      }
      label133:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjf
 * JD-Core Version:    0.7.0.1
 */