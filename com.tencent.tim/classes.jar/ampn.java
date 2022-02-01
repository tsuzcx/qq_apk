import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import java.util.List;

public class ampn
  implements ampw
{
  private int fromType;
  private String keyword;
  
  public ampn(String paramString, int paramInt)
  {
    this.keyword = paramString;
    this.fromType = paramInt;
  }
  
  public int Ex()
  {
    return 0;
  }
  
  public List<ampx> eX()
  {
    return null;
  }
  
  public void gJ(View paramView)
  {
    Intent localIntent = new Intent((Activity)paramView.getContext(), SearchContactsActivity.class);
    localIntent.putExtra("start_search_key", this.keyword);
    localIntent.putExtra("jump_src_key", 0);
    localIntent.putExtra("fromType", this.fromType);
    ((Activity)paramView.getContext()).startActivity(localIntent);
    amxk.a(this.keyword, 0, 0, paramView);
    anot.a(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707060);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampn
 * JD-Core Version:    0.7.0.1
 */