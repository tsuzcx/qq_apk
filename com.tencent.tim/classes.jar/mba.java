import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

public class mba
  implements View.OnClickListener
{
  public mba(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    lie locallie = this.a.a.a();
    ArticleInfo localArticleInfo = locallie.a();
    Object localObject2 = (mhr.a)localArticleInfo.mNewPolymericInfo.iP.get(0);
    Object localObject3;
    if ((localArticleInfo.mNewPolymericInfo.aRX == 12) && (((mhr.a)localObject2).jdField_a_of_type_Mhr$c != null))
    {
      localObject3 = new Intent(this.a.mContext, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject3).putExtra("arg_topic_id", String.valueOf(String.valueOf(((mhr.a)localObject2).jdField_a_of_type_Mhr$c.aSe)));
      ((Intent)localObject3).putExtra("support_topic", true);
      ((Intent)localObject3).putExtra("support_linkify", true);
    }
    try
    {
      String str1 = new String(aqgo.decode(((mhr.a)localObject2).jdField_a_of_type_Mhr$c.topicName, 0));
      ((Intent)localObject3).putExtra("is_from_poly_topic", true);
      if (locallie.nh() == 70)
      {
        bool = true;
        ((Intent)localObject3).putExtra("is_from_dian_dian", bool);
        ((Intent)localObject3).putExtra("arg_topic_name", str1);
        ((Intent)localObject3).putExtra("arg_ad_tag", ((mhr.a)localObject2).jdField_a_of_type_Mhr$c.adTag);
        this.a.getContext().startActivity((Intent)localObject3);
        localObject3 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject3).put("channel_id", locallie.nh());
        if (((mhr.a)localObject2).jdField_a_of_type_Mhr$b == null) {
          break label401;
        }
        str1 = ((mhr.a)localObject2).jdField_a_of_type_Mhr$b.rowKey;
        ((JSONObject)localObject3).put("rowkey", str1);
        if (((mhr.a)localObject2).jdField_a_of_type_Mhr$c == null) {
          break label410;
        }
        i = ((mhr.a)localObject2).jdField_a_of_type_Mhr$c.aSe;
        ((JSONObject)localObject3).put("topicid", i);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i;
          Object localObject1;
          localException2.printStackTrace();
          continue;
          String str2 = "2";
        }
      }
      localObject2 = localArticleInfo.mFeedId + "";
      if (kxm.x(localArticleInfo))
      {
        str1 = "1";
        kbp.a(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject2, str1, localArticleInfo.mStrategyId + "", ((JSONObject)localObject3).toString(), false);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        localObject1 = "";
        continue;
        boolean bool = false;
        continue;
        label401:
        localObject1 = Integer.valueOf(0);
        continue;
        label410:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mba
 * JD-Core Version:    0.7.0.1
 */