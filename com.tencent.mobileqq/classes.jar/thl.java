import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class thl
  extends tgr
  implements View.OnClickListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public thl(thk paramthk, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369451));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380011));
    paramthk = (LinearLayout)paramView.findViewById(2131366437);
    int j = paramthk.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramContext = paramthk.getChildAt(i);
      ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
      paramContext.setOnClickListener(this);
      i += 1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)DeviceInfoUtil.getPortraitWidth(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298728) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298729)) * 1.0D / paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnSubThread(new WebFastLikeDislikeCreator.ViewHolder.1(this, paramArticleInfo));
    a("0X80101DC");
  }
  
  private void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new thm(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    pqg localpqg = tkj.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localpqg.b("source_from", "2");
        localpqg.j();
        localpqg.k();
        localpqg.l();
        localpqg.a(localArticleInfo.mAlgorithmID);
        localpqg.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localpqg.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localpqg.b("businessID", i);
        }
        if (!pqt.b()) {
          break label217;
        }
        i = 1;
        localpqg.b("artical_interact_area", i);
        localpqg.b("artical_interact_type", pqt.d());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!pqt.c()) {
            break label222;
          }
          i = j;
          localpqg.b("ad_relative_pos", i);
        }
        tkj.a(localArticleInfo, paramString, localpqg.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(thk.a(), 2, "parseR5 has error !", paramString);
      return;
      label217:
      int i = 0;
      continue;
      label222:
      i = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80099DA");
      a("0X80100DB");
      a("0X8009A5A");
    }
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      if (pqt.d() != 1) {
        break label288;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370346).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370326).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370394).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (int i = 2130842915;; i = 2130841703)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370327)).setImageResource(2130841690);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370395)).setImageResource(2130842679);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370328)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370396)).setTextColor(Color.parseColor("#737373"));
      if (!pqt.b())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366437);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131366437).setPadding(paramBaseData1.getPaddingLeft(), ViewUtils.dpToPx(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370346).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370326).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370394).getLayoutParams().height = -2;
      return;
    }
    label288:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130842914;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bmhv.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", thk.a));
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label403;
      }
      i = Color.parseColor("#F64B31");
      label350:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label411;
      }
    }
    label403:
    label411:
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849405);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849404))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370346).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841702;
      break;
      i = -16777216;
      break label350;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a;
      if (localObject == null) {
        AIOUtils.catchedExceptionInReleaseV2(thk.a(), "", new IllegalArgumentException());
      } else {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131370326: 
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
          break;
        case 2131370346: 
          if (((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean)
          {
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = false;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int -= 1;
            tkj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
          }
          for (;;)
          {
            a((FastWebArticleInfo)localObject);
            pvm.a().c();
            pvj.a().a(pkh.a(), ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean, (FastWebArticleInfo)localObject);
            break;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = true;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int += 1;
            tkj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
          }
        case 2131370394: 
          localObject = this.jdField_a_of_type_AndroidViewView.getContext();
          a("0X8009A5B");
          if ((localObject instanceof FastWebActivity)) {
            ((FastWebActivity)localObject).a(false);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     thl
 * JD-Core Version:    0.7.0.1
 */