import com.tencent.tim.activity.profile.BaseProfileFragment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class atba
  implements Function1<List<atbe>, Unit>
{
  public atba(BaseProfileFragment paramBaseProfileFragment) {}
  
  public Unit a(List<atbe> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.this$0.a.cS(paramList);
      this.this$0.a.notifyDataSetChanged();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atba
 * JD-Core Version:    0.7.0.1
 */