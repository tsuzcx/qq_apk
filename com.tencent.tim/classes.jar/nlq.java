import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentHeaderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommonBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.List;

public class nlq
  implements nln
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
    case 13: 
      return 7;
    case 8: 
    case 14: 
      return 8;
    case 15: 
      return 13;
    }
    return 14;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    switch (a(paramBaseData))
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
      return new nlq.d(localLayoutInflater.inflate(2131560372, paramViewGroup, false), paramBaseData);
    case 8: 
      return new nlq.b(localLayoutInflater.inflate(2131560369, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = wja.dp2px(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new nlq.a(paramViewGroup, paramBaseData);
    }
    return new nlq.c(localLayoutInflater.inflate(2131560290, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.type == 7) || (paramBaseData.type == 8) || (paramBaseData.type == 13) || (paramBaseData.type == 14) || (paramBaseData.type == 15) || (paramBaseData.type == 16);
  }
  
  class a
    extends nlm
    implements View.OnClickListener
  {
    private HorizontalLabelLayout jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout = ((HorizontalLabelLayout)paramView);
    }
    
    private void a(String paramString, ArticleTopicData.a parama, ArticleInfo paramArticleInfo)
    {
      long l1 = paramArticleInfo.mArticleID;
      long l2 = parama.vr;
      kbp.a(null, "CliOper", "", kxm.getAccount(), paramString, paramString, 0, 0, String.valueOf(l1), String.valueOf(l2), paramArticleInfo.innerUniqueID, "", false);
    }
    
    private View g(Context paramContext)
    {
      return LayoutInflater.from(paramContext).inflate(2131560364, (ViewGroup)this.itemView, false);
    }
    
    public SpannableStringBuilder a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append("# ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
      double d = 0.0D;
      int i = 0;
      for (;;)
      {
        if (i < paramString.length()) {
          if (!aqmr.isChinese(paramString.charAt(i))) {
            break label144;
          }
        }
        label144:
        for (d += 1.0D; d >= 11.0D; d += 0.5D)
        {
          String str = paramString;
          if (i < paramString.length() - 1) {
            str = paramString.substring(0, i + 1) + kwt.UU;
          }
          localSpannableStringBuilder.append(str);
          return localSpannableStringBuilder;
        }
        i += 1;
      }
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      paramBaseData1 = (ArticleTopicData)paramBaseData2;
      int j = paramBaseData1.kk.size();
      View localView;
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount() < j)
      {
        int k = this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount();
        i = 0;
        while (i < j - k)
        {
          localView = g(this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getContext());
          this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.addView(localView);
          localView.setOnClickListener(this);
          i += 1;
        }
      }
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount())
      {
        localView = this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildAt(i);
        if (i < j)
        {
          localView.setVisibility(0);
          ArticleTopicData.a locala = (ArticleTopicData.a)paramBaseData1.kk.get(i);
          localView.setTag(locala);
          ((TextView)localView.findViewById(2131376699)).setText(a(locala.title));
          if ((!paramBoolean) && (!paramBaseData1.atl))
          {
            a("0X800919F", locala, paramBaseData2.articleInfo);
            paramBaseData1.atl = true;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localView.setVisibility(8);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      ArticleTopicData.a locala = (ArticleTopicData.a)paramView.getTag();
      if (locala != null)
      {
        kxm.aJ(paramView.getContext(), locala.jumpUrl);
        a("0X80091A0", locala, this.g.articleInfo);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  class b
    extends nlm
    implements View.OnClickListener
  {
    private View divider = this.itemView.findViewById(2131363662);
    private View mP = this.itemView.findViewById(2131363678);
    private View mQ = this.itemView.findViewById(2131365037);
    
    public b(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.mQ.setOnClickListener(this);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      int i = 0;
      paramBaseData1 = (CommonBottomData)paramBaseData2;
      if ((paramBaseData1.type == 14) && (paramBaseData1.atq))
      {
        this.mQ.setVisibility(0);
        if (!paramBaseData1.atp) {
          break label148;
        }
        this.mP.setVisibility(0);
        if (paramBaseData2.type != 14) {
          break label123;
        }
        this.mP.getLayoutParams().height = aqcx.dip2px(this.mP.getContext(), 6.0F);
        label78:
        paramBaseData1 = (LinearLayout.LayoutParams)this.divider.getLayoutParams();
        if (paramBaseData2.type != 14) {
          break label160;
        }
      }
      for (;;)
      {
        paramBaseData1.rightMargin = i;
        paramBaseData1.leftMargin = i;
        return;
        this.mQ.setVisibility(8);
        break;
        label123:
        this.mP.getLayoutParams().height = aqcx.dip2px(this.mP.getContext(), 10.0F);
        break label78;
        label148:
        this.mP.setVisibility(8);
        break label78;
        label160:
        i = aqcx.dip2px(this.divider.getContext(), 12.0F);
      }
    }
    
    public void onClick(View paramView)
    {
      ArticleInfo localArticleInfo;
      int i;
      if (this.g.type == 14)
      {
        localObject = (BaseActivity)this.itemView.getContext();
        if ((localObject != null) && ((localObject instanceof FastWebActivity))) {
          ((FastWebActivity)localObject).aYJ();
        }
        localArticleInfo = this.g.articleInfo;
        i = (int)localArticleInfo.mChannelID;
        if (!this.g.d.FP()) {
          break label95;
        }
      }
      label95:
      for (Object localObject = "2";; localObject = "1")
      {
        nns.c(localArticleInfo, "0X800900A", kxm.a(localArticleInfo, i, (String)localObject));
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
  
  class c
    extends nlm
  {
    public c(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean) {}
  }
  
  class d
    extends nlm
  {
    private View divider;
    private View mR;
    private TextView title;
    
    public d(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.title = ((TextView)paramView.findViewById(2131380976));
      this.divider = paramView.findViewById(2131365997);
      this.mR = paramView.findViewById(2131378607);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      paramBaseData1 = "";
      if (paramBaseData2.type == 7)
      {
        paramBaseData1 = ((RecommendTitleData)paramBaseData2).title;
        this.divider.setVisibility(0);
      }
      for (;;)
      {
        this.title.setText(paramBaseData1);
        this.title.setVisibility(8);
        if ((paramBaseData2.type != 7) || (!((RecommendTitleData)paramBaseData2).att)) {
          break;
        }
        this.mR.setVisibility(8);
        return;
        if (paramBaseData2.type == 13)
        {
          paramBaseData1 = ((CommentHeaderData)paramBaseData2).title;
          this.divider.setVisibility(8);
        }
      }
      this.mR.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlq
 * JD-Core Version:    0.7.0.1
 */