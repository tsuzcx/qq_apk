import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.utils.DialogUtil;

public class ard
  implements View.OnClickListener
{
  public ard(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a = ((Groups)paramView.getTag());
    GroupManagerActivity.a(this.a, DialogUtil.a(this.a, 2131363795, 2131363796, this.a.a.group_name, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ard
 * JD-Core Version:    0.7.0.1
 */