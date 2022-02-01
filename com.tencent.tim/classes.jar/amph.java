import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import java.util.List;

public class amph
  implements ampw
{
  private int mFromType;
  private final String mKeyword;
  public final List<ampx> rc;
  
  public amph(List<ampx> paramList, String paramString, int paramInt)
  {
    this.rc = paramList;
    this.mKeyword = paramString;
    this.mFromType = paramInt;
  }
  
  public int Ex()
  {
    return amkd.aj("fts_native_function_maxnum", 3);
  }
  
  public List<ampx> eX()
  {
    return this.rc;
  }
  
  public void gJ(View paramView)
  {
    FunctionSearchActivity.launch((BaseActivity)paramView.getContext(), this.mKeyword);
    amub.a(null, 0, this.mFromType, "0X8009D4B", 0, 0, null, null);
  }
  
  public String getGroupName()
  {
    return amkd.yY();
  }
  
  public String getKeyword()
  {
    return this.mKeyword;
  }
  
  public int sZ()
  {
    return this.mFromType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amph
 * JD-Core Version:    0.7.0.1
 */