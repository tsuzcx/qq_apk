import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class nlu
  implements nln
{
  private static String TAG = "WebFastLikeDislikeCreator";
  private nlu.a a;
  
  public int a(BaseData paramBaseData)
  {
    return 19;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    this.a = new nlu.a(paramContext, LayoutInflater.from(paramContext).inflate(2131560366, null), paramBaseData);
    return this.a;
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 21;
  }
  
  public class a
    extends nlm
    implements View.OnClickListener
  {
    private Animation Z;
    private boolean atu = true;
    private ImageView kM;
    private TextView tp;
    
    public a(Context paramContext, View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.kM = ((ImageView)paramView.findViewById(2131369801));
      this.tp = ((TextView)paramView.findViewById(2131380785));
      this$1 = (LinearLayout)paramView.findViewById(2131366715);
      int j = nlu.this.getChildCount();
      int k = dD(j);
      int i = 0;
      while (i < j)
      {
        paramContext = nlu.this.getChildAt(i);
        ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
        paramContext.setOnClickListener(this);
        i += 1;
      }
    }
    
    private void G(ArticleInfo paramArticleInfo)
    {
      ThreadManager.executeOnSubThread(new WebFastLikeDislikeCreator.ViewHolder.1(this, paramArticleInfo));
      report("0X80101DC");
    }
    
    private void a(FastWebArticleInfo paramFastWebArticleInfo)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      if (this.Z == null)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration(200L);
        localScaleAnimation.setRepeatCount(1);
        localScaleAnimation.setRepeatMode(2);
        localScaleAnimation.setInterpolator(new DecelerateInterpolator());
        this.Z = localScaleAnimation;
      }
      this.Z.setAnimationListener(new nlv(this, paramFastWebArticleInfo));
      this.kM.startAnimation(this.Z);
    }
    
    private int dD(int paramInt)
    {
      return (int)Math.floor(((int)aqgz.i(true) - this.itemView.getContext().getResources().getDimensionPixelSize(2131299171) * 2 - (paramInt - 1) * this.itemView.getContext().getResources().getDimensionPixelSize(2131299172)) * 1.0D / paramInt);
    }
    
    private void report(String paramString)
    {
      int j = 1;
      ArticleInfo localArticleInfo = this.g.articleInfo;
      if (localArticleInfo == null) {
        return;
      }
      kxm.b localb = nns.b(localArticleInfo);
      for (;;)
      {
        try
        {
          localb.b("source_from", "2");
          localb.k();
          localb.l();
          localb.m();
          localb.a(localArticleInfo.mAlgorithmID);
          localb.b(localArticleInfo.mStrategyId);
          AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
          if (localAladdinConfig != null)
          {
            i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
            localb.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
            localb.b("businessID", i);
          }
          if (!kxm.AT()) {
            break label218;
          }
          i = 1;
          localb.b("artical_interact_area", i);
          localb.b("artical_interact_type", kxm.nU());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            if (!kxm.AU()) {
              break label223;
            }
            i = j;
            localb.b("ad_relative_pos", i);
          }
          nns.c(localArticleInfo, paramString, localb.build());
          return;
        }
        catch (JSONException paramString) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(nlu.TAG, 2, "parseR5 has error !", paramString);
        return;
        label218:
        int i = 0;
        continue;
        label223:
        i = 0;
      }
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      paramBaseData1 = paramBaseData2.d;
      if (paramBaseData1 != null)
      {
        if (kxm.nU() != 1) {
          break label288;
        }
        this.itemView.findViewById(2131370686).setBackgroundColor(0);
        this.itemView.findViewById(2131370656).setBackgroundColor(0);
        this.itemView.findViewById(2131370734).setBackgroundColor(0);
        paramBaseData2 = this.kM;
        if (!paramBaseData1.isLiked) {
          break label280;
        }
      }
      label280:
      for (int i = 2130843694;; i = 2130842508)
      {
        paramBaseData2.setImageResource(i);
        ((ImageView)this.itemView.findViewById(2131370657)).setImageResource(2130842495);
        ((ImageView)this.itemView.findViewById(2131370735)).setImageResource(2130843477);
        this.tp.setTextColor(Color.parseColor("#737373"));
        ((TextView)this.itemView.findViewById(2131370658)).setTextColor(Color.parseColor("#737373"));
        ((TextView)this.itemView.findViewById(2131370736)).setTextColor(Color.parseColor("#737373"));
        if (!kxm.AT())
        {
          paramBaseData1 = (LinearLayout)this.itemView.findViewById(2131366715);
          this.itemView.findViewById(2131366715).setPadding(paramBaseData1.getPaddingLeft(), aqnm.dpToPx(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
        }
        this.itemView.findViewById(2131370686).getLayoutParams().height = -2;
        this.itemView.findViewById(2131370656).getLayoutParams().height = -2;
        this.itemView.findViewById(2131370734).getLayoutParams().height = -2;
        return;
      }
      label288:
      paramBaseData2 = this.kM;
      if (paramBaseData1.isLiked)
      {
        i = 2130843693;
        paramBaseData2.setImageResource(i);
        this.tp.setText(awit.a(paramBaseData1.likeCnt, 99990000L, "9999万+", ""));
        if (!paramBaseData1.isLiked) {
          break label403;
        }
        i = Color.parseColor("#F64B31");
        label350:
        this.tp.setTextColor(i);
        if (!paramBaseData1.isLiked) {
          break label411;
        }
      }
      label403:
      label411:
      for (paramBaseData1 = this.itemView.getResources().getDrawable(2130850250);; paramBaseData1 = this.itemView.getResources().getDrawable(2130850249))
      {
        this.itemView.findViewById(2131370686).setBackgroundDrawable(paramBaseData1);
        return;
        i = 2130842507;
        break;
        i = -16777216;
        break label350;
      }
    }
    
    public void onClick(View paramView)
    {
      if (this.g.articleInfo == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject = this.g.d;
        if (localObject == null) {
          wja.a(nlu.TAG, "", new IllegalArgumentException());
        } else {
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131370656: 
            G(this.g.articleInfo);
            break;
          case 2131370686: 
            if (((FastWebArticleInfo)localObject).isLiked)
            {
              ((FastWebArticleInfo)localObject).isLiked = false;
              ((FastWebArticleInfo)localObject).likeCnt -= 1;
              nns.d(this.g.articleInfo, "0X8009765", "2");
            }
            for (;;)
            {
              a((FastWebArticleInfo)localObject);
              lcc.a().aJC();
              lbz.a().a(kxm.getLongAccountUin(), ((FastWebArticleInfo)localObject).isLiked, (FastWebArticleInfo)localObject);
              break;
              ((FastWebArticleInfo)localObject).isLiked = true;
              ((FastWebArticleInfo)localObject).likeCnt += 1;
              nns.d(this.g.articleInfo, "0X8009764", "2");
            }
          case 2131370734: 
            localObject = this.itemView.getContext();
            report("0X8009A5B");
            if ((localObject instanceof FastWebActivity)) {
              ((FastWebActivity)localObject).pP(false);
            }
            break;
          }
        }
      }
    }
    
    public void onShow()
    {
      if (this.atu)
      {
        this.atu = false;
        report("0X80099DA");
        report("0X80100DB");
        report("0X8009A5A");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlu
 * JD-Core Version:    0.7.0.1
 */