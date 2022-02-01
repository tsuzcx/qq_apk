import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class ampq
  implements ampw
{
  public static final String cbs = acfp.m(2131707049);
  private final List<ampx> Bu;
  private int fromType;
  private final String keyword;
  
  public ampq(List<ampx> paramList, String paramString, int paramInt)
  {
    this.Bu = paramList;
    this.keyword = paramString;
    this.fromType = paramInt;
  }
  
  public int Ex()
  {
    return amkd.aj("pref_fts_native_search_public_account_max_num", 3);
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    amxk.a(this.keyword, 50, 0, paramView);
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity))) {
      anot.b(((BaseActivity)localContext).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.keyword, "");
    }
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      amxk.b("all_result", "clk_public_uin_more", new String[] { "" + this.keyword });
      amub.a(null, 0, this.fromType, "0X8009D53", 0, 0, null, null);
    }
    PublicAcntSearchActivity.v(paramView.getContext(), this.keyword, this.fromType);
  }
  
  public String getGroupName()
  {
    if (this.fromType == 12) {
      return acfp.m(2131707074) + obt.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return cbs;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampq
 * JD-Core Version:    0.7.0.1
 */