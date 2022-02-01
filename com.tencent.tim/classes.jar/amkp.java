import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amkp
  implements View.OnClickListener
{
  amkp(amkn paramamkn, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    argu localargu = new argu(this.val$context);
    View localView = LayoutInflater.from(this.val$context).inflate(2131560000, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363236);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362999);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362986);
    TextView localTextView1 = (TextView)localView.findViewById(2131364221);
    TextView localTextView2 = (TextView)localView.findViewById(2131365703);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130843175);
      localImageView3.setImageResource(2130843175);
      localTextView1.setBackgroundResource(2130846929);
    }
    for (;;)
    {
      localargu.setContentView(localView);
      localargu.setHeight(rpq.dip2px(this.val$context, 96.0F));
      localargu.setWidth(rpq.dip2px(this.val$context, 224.0F));
      localTextView1.setOnClickListener(new amkq(this, localargu));
      localTextView2.setOnClickListener(new amkr(this, localargu));
      localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
      localargu.showAsDropDown(paramView, 0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localImageView1.setImageResource(2130839506);
      localImageView2.setImageResource(2130843176);
      localImageView3.setImageResource(2130843176);
      localTextView1.setBackgroundResource(2130843167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkp
 * JD-Core Version:    0.7.0.1
 */