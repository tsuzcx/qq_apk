import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class lzp
  extends lwm
{
  TextView qc;
  TextView qd;
  
  public lzp(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    return l().t().n();
  }
  
  public lwm d()
    throws Exception
  {
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOnClickListener(new lzq(this));
    if ((this.iB != null) && (this.iB.size() >= 2))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.context).inflate(2131560380, localLinearLayout, false);
      this.qc = ((TextView)localRelativeLayout.findViewById(2131379769));
      this.qd = ((TextView)localRelativeLayout.findViewById(2131371927));
      Object localObject = this.context.getResources().getDisplayMetrics();
      if (localObject != null)
      {
        this.qc.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
        this.qd.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 4);
      }
      localObject = (LinearLayout)localRelativeLayout.findViewById(2131365362);
      int i = 0;
      while (i < 2)
      {
        ComponentTopicItemMulti localComponentTopicItemMulti = (ComponentTopicItemMulti)this.iB.get(i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        if (i < 1) {
          localLayoutParams.rightMargin = wja.dp2px(0.75F, this.context.getResources());
        }
        if (i > 0) {
          localLayoutParams.leftMargin = wja.dp2px(0.75F, this.context.getResources());
        }
        localComponentTopicItemMulti.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView(localComponentTopicItemMulti);
        i += 1;
      }
      localLinearLayout.addView(localRelativeLayout);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public lwm e()
    throws Exception
  {
    return null;
  }
  
  public lwm o()
  {
    super.o();
    ArticleInfo localArticleInfo;
    mih localmih;
    if ((this.aN instanceof lie))
    {
      localArticleInfo = ((lie)this.aN).a();
      localmih = localArticleInfo.mTopicRecommendFeedsInfo;
      if ((localmih != null) && (localmih.ld != null) && (localmih.ld.size() >= 2)) {
        break label57;
      }
    }
    label271:
    label281:
    for (;;)
    {
      return this;
      label57:
      if (localmih.a != null)
      {
        this.qc.setText(localmih.a.aiK);
        label78:
        if ((localmih.b == null) || (TextUtils.isEmpty(localmih.b.aiK))) {
          break label271;
        }
        this.qd.setVisibility(0);
        this.qd.setText(localmih.b.aiK);
        if (!TextUtils.isEmpty(localmih.b.url)) {
          break label251;
        }
        this.qd.setCompoundDrawables(null, null, null, null);
        this.qd.setOnClickListener(null);
      }
      for (;;)
      {
        if ((this.iB == null) || (this.iB.size() < 2)) {
          break label281;
        }
        int i = 0;
        while (i < 2)
        {
          ((ComponentTopicItemMulti)this.iB.get(i)).P(localmih.ld.get(i));
          ((ComponentTopicItemMulti)this.iB.get(i)).setArticleInfo(localArticleInfo, ((lie)this.aN).nh());
          i += 1;
        }
        break;
        this.qc.setText("");
        break label78;
        label251:
        this.qd.setOnClickListener(new lzr(this, localArticleInfo, localmih));
        continue;
        this.qd.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lzp
 * JD-Core Version:    0.7.0.1
 */