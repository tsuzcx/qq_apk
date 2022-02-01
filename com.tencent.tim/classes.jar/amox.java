import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class amox
  implements ampw
{
  private List<ampx> Bu;
  private String aZp;
  private yow c;
  private String keyword;
  
  public amox(yow paramyow, List<ampx> paramList, String paramString1, String paramString2)
  {
    this.Bu = paramList;
    this.keyword = paramString1;
    this.c = paramyow;
    this.aZp = paramString2;
  }
  
  public int Ex()
  {
    return 1;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    amxk.a(this.keyword, 110, 0, paramView);
    amoy localamoy = (amoy)this.Bu.get(0);
    if ((localamoy != null) && (!TextUtils.isEmpty(this.aZp)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.aZp);
      paramView.getContext().startActivity((Intent)localObject);
      if (localamoy.a() != null)
      {
        localObject = localamoy.a().hotword.get();
        int i = localamoy.a().hotword_type.get();
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localamoy.getKeyword(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    kbp.b(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.keyword, "0");
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707038);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amox
 * JD-Core Version:    0.7.0.1
 */