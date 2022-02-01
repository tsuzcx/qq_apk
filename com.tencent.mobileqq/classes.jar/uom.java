import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;

class uom
  implements uot
{
  uom(uok paramuok) {}
  
  public void a()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131719689, 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = TroopInfoActivity.a(paramString1, paramString2, 60006);
    TroopUtils.openTroopInfoActivity(uok.a(this.a), paramString1, 2);
  }
  
  public boolean a()
  {
    return (uok.a(this.a) != null) && (uok.a(this.a).isShowing());
  }
  
  public void b()
  {
    uok.a(this.a);
  }
  
  public void c()
  {
    uok.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uom
 * JD-Core Version:    0.7.0.1
 */