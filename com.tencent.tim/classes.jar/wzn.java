import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

class wzn
  implements QQPermissionCallback
{
  wzn(wzl paramwzl, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.val$activity, paramArrayOfString, paramArrayOfInt);
    this.a.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */