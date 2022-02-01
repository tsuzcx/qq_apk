import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class amnu
  extends amnt
{
  private int mFromType;
  
  public amnu(List<ampx> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.mFromType = paramInt;
  }
  
  public int Ex()
  {
    return amkd.aj("fts_native_chathistory_maxnum", 3);
  }
  
  public void gJ(View paramView)
  {
    amxk.a(this.keyword, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      amxk.b("all_result", "more_talk", new String[] { "" + this.keyword });
      amub.a(null, 0, this.mFromType, "0X8009D4F", 0, 0, null, null);
    }
    aqoe.a.eaB = -1;
    aqoe.a.itemType = 0;
    aqoe.a.eaC = -1;
    aqoe.a.senderNum = -1;
    aqoe.a.friendNum = -1;
    aqoe.a.friendIndex = -1;
    aqoe.iv(paramView);
    FTSEntitySearchActivity.v(paramView.getContext(), this.keyword, 1);
  }
  
  public String getGroupName()
  {
    return acfp.m(2131706654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnu
 * JD-Core Version:    0.7.0.1
 */