import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.qphone.base.util.QLog;

public class vdd
  extends acfd
{
  public vdd(GroupManagerActivity paramGroupManagerActivity) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onAddGroupResp isSuccess = " + paramBoolean);
    }
    this.a.xt(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onDeleteGroupResp isSuccess = " + paramBoolean);
    }
    this.a.xt(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onRenameGroupResp isSuccess = " + paramBoolean);
    }
    this.a.xt(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onResortGroupResp isSuccess = " + paramBoolean);
    }
    this.a.xt(true);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdd
 * JD-Core Version:    0.7.0.1
 */