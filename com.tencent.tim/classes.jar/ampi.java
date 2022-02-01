import android.view.View;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.List;

public class ampi
  implements ampw
{
  public static final String cbs = acfp.m(2131707052);
  public List<ampx> Bu;
  private ampx c;
  private int fromType;
  private String keyword;
  
  public ampi(List<ampx> paramList, String paramString, int paramInt)
  {
    this.Bu = paramList;
    this.keyword = paramString;
    this.fromType = paramInt;
  }
  
  public int Ex()
  {
    return amkd.aj("fts_native_contactor_maxnum", 3);
  }
  
  public ampx a()
  {
    return this.c;
  }
  
  public void b(ampx paramampx)
  {
    this.c = paramampx;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    if (SearchConfigManager.needSeparate) {}
    for (int i = 1;; i = 0)
    {
      ContactSearchActivity.a(paramView.getContext(), this.keyword, this.fromType, 197437, i);
      amxk.a(this.keyword, 20, 0, paramView);
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        amxk.b("all_result", "more_contact", new String[] { "" + this.keyword });
        if (SearchConfigManager.needSeparate) {
          amxk.d("search", "contact", "more", 0, 0, new String[] { amxk.fc(this.fromType) });
        }
        amub.a(null, 0, this.fromType, "0X8009D39", 0, 0, null, null);
      }
      return;
    }
  }
  
  public String getGroupName()
  {
    return cbs;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public int sZ()
  {
    return this.fromType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampi
 * JD-Core Version:    0.7.0.1
 */