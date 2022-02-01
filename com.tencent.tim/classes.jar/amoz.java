import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class amoz
  implements ampw
{
  private List<ampx> Bu;
  private yow c;
  private String keyword;
  
  public amoz(yow paramyow, List<ampx> paramList, String paramString)
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
    amxk.a(this.keyword, 70, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", this.keyword);
    localIntent.putExtra("from_key", 0);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.c);
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707032);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoz
 * JD-Core Version:    0.7.0.1
 */