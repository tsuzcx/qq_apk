import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class ampb
  implements ampw
{
  private List<ampx> Bu;
  private yow c;
  private String keyword;
  
  public ampb(yow paramyow, List<ampx> paramList, String paramString)
  {
    this.Bu = paramList;
    this.keyword = paramString;
    this.c = paramyow;
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
    amxk.a(this.keyword, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.keyword);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.c);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity))) {
      kbp.a(((BaseActivity)paramView).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.keyword, "", false);
    }
  }
  
  public String getGroupName()
  {
    if (UniteSearchActivity.dCK == 12) {
      return acfp.m(2131707035) + obt.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return acfp.m(2131707034);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampb
 * JD-Core Version:    0.7.0.1
 */