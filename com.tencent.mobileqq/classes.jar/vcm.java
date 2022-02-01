import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;

class vcm
  implements vct
{
  vcm(vck paramvck) {}
  
  public void a()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131720142, 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = TroopInfoActivity.a(paramString1, paramString2, 60006);
    TroopUtils.openTroopInfoActivity(vck.a(this.a), paramString1, 2);
  }
  
  public boolean a()
  {
    return (vck.a(this.a) != null) && (vck.a(this.a).isShowing());
  }
  
  public void b()
  {
    vck.a(this.a);
  }
  
  public void c()
  {
    vck.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcm
 * JD-Core Version:    0.7.0.1
 */