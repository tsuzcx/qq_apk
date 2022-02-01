import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class aefr
  extends acgs
{
  public aefr(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  protected void b(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Object localObject = null;
    if (paramBoolean) {
      localObject = paramLBSInfo.w();
    }
    if (localObject != null)
    {
      paramLBSInfo = (LBSInfo)localObject;
      if (localObject.length == 4) {}
    }
    else
    {
      paramLBSInfo = new String[4];
      paramLBSInfo[0] = "-1";
      paramLBSInfo[1] = "-1";
      paramLBSInfo[2] = "-1";
      paramLBSInfo[3] = "-1";
    }
    if (!"-1".equals(paramLBSInfo[0]))
    {
      paramLBSInfo[3] = "0";
      this.this$0.b.G(paramLBSInfo);
      if (this.this$0.bTB)
      {
        localObject = this.this$0.b.e(paramLBSInfo);
        this.this$0.b.bZ(0, (String)localObject);
        this.this$0.b.H(paramLBSInfo);
        this.this$0.aw.setRightText(this.this$0.b.je((String)localObject));
      }
      ConditionSearchFriendActivity.a(this.this$0, 1);
      ConditionSearchFriendActivity.a(this.this$0);
      this.this$0.bTC = true;
      this.this$0.bTD = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetUserLocation|isSuccess : " + paramBoolean + ", mIsFirstReqLocation : " + this.this$0.bTB + ", locationCodes[0] : " + paramLBSInfo[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefr
 * JD-Core Version:    0.7.0.1
 */