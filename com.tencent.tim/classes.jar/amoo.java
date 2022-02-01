import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class amoo
  extends amom
{
  public amoo(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (!amxk.lo(this.fromType)) {
      amxk.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
    }
  }
  
  public CharSequence getDescription()
  {
    if (amxk.lo(this.fromType)) {
      return acfp.m(2131704466);
    }
    return acfp.m(2131704433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoo
 * JD-Core Version:    0.7.0.1
 */