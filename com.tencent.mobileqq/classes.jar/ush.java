import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder;

public class ush
  implements View.OnClickListener
{
  public ush(CommonHobbyForAIOShowItemBuilder paramCommonHobbyForAIOShowItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      CommonHobbyForAIOShowItemBuilder.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */