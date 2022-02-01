import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.qphone.base.util.QLog;

public class ynd
  extends acgs
{
  public ynd(AddContactsView paramAddContactsView) {}
  
  protected void b(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      this.this$0.cR = paramLBSInfo.w();
    }
    if ((this.this$0.cR == null) || (this.this$0.cR.length != 4)) {
      this.this$0.cR = new String[] { "-1", "-1", "-1", "-1" };
    }
    if (this.this$0.bnH) {
      this.this$0.cjX();
    }
    if (!"-1".equals(this.this$0.cR[0]))
    {
      this.this$0.cR[3] = "0";
      this.this$0.c.G(this.this$0.cR);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onGetUserLocation|isSuccess : " + paramBoolean + ", autoReqLocation : " + this.this$0.bnH + ", locationCodes[0] : " + this.this$0.cR[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynd
 * JD-Core Version:    0.7.0.1
 */