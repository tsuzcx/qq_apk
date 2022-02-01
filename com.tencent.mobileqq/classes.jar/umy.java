import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class umy
  extends umw<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int a;
  
  public umy(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
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
      ueg.a(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = uqt.a();
      if (paramContext != null) {
        paramContext.a(null);
      }
      uqt.a();
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (bool2)
      {
        i = 2;
        if (this.jdField_a_of_type_Umn != null) {
          break label93;
        }
        paramContext = "";
        label74:
        unx.a(i, 1, paramContext);
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
      paramContext = ((WSRedDotPushMsg)this.jdField_a_of_type_Umn).mFeedIds;
      break label74;
      if (this.jdField_a_of_type_Int != 6) {
        break label80;
      }
      if (bool2) {}
      for (;;)
      {
        unx.d(i);
        break;
        i = 1;
      }
      label133:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umy
 * JD-Core Version:    0.7.0.1
 */