import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akhw
  implements View.OnClickListener
{
  akhw(akhv paramakhv, Context paramContext, akjj paramakjj, akhv.a parama) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
    String str1 = this.jdField_a_of_type_Akjj.lng;
    String str2 = this.jdField_a_of_type_Akjj.lat;
    Object localObject2 = this.jdField_a_of_type_Akjj.name;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.jdField_a_of_type_Akjj.city;
      localIntent.putExtra("url", String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, localObject1, localObject2 }));
      this.val$context.startActivity(localIntent);
      localObject2 = new anov(this.jdField_a_of_type_Akhv.mApp).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(this.jdField_a_of_type_Akhv$a.b.uin));
      if (!this.jdField_a_of_type_Akhv.xv) {
        break label220;
      }
    }
    label220:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ((anov)localObject2).a(new String[] { localObject1, "", "", this.jdField_a_of_type_Akhv$a.b.feedId }).report();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhw
 * JD-Core Version:    0.7.0.1
 */