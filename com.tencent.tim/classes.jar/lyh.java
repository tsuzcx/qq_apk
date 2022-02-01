import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class lyh
  extends lwm
  implements View.OnClickListener
{
  private static Drawable cC;
  private FrameLayout ah;
  private FrameLayout ai;
  private TextView bottomTitle;
  private View contentView;
  private LinearLayout dP;
  private View ev;
  private ImageView je;
  private View kF;
  private TextView pw;
  private TextView qb;
  private TextView titleTextView;
  private KandianUrlImageView jdField_u_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URLImageView jdField_u_of_type_ComTencentImageURLImageView;
  
  public lyh(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  private TextView c(int paramInt)
  {
    TextView localTextView = new TextView(this.context);
    localTextView.setId(2131376717);
    localTextView.setTextSize(2, 11.0F);
    localTextView.setGravity(17);
    localTextView.setWidth(aqcx.dip2px(this.context, 30.0F));
    localTextView.setHeight(aqcx.dip2px(this.context, 17.0F));
    if (paramInt == 0)
    {
      localTextView.setTextColor(Color.argb(255, 255, 255, 255));
      localTextView.setBackgroundResource(2130850273);
      return localTextView;
    }
    localTextView.setTextColor(-89258);
    localTextView.setBackgroundResource(2130850274);
    return localTextView;
  }
  
  public lwm a()
  {
    this.alM = true;
    return this;
  }
  
  public lwm d()
    throws Exception
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    View localView = LayoutInflater.from(this.context).inflate(2131560440, localRelativeLayout, true);
    this.kF = localView.findViewById(2131370296);
    this.je = ((ImageView)localView.findViewById(2131373381));
    this.contentView = localView.findViewById(2131377408);
    this.jdField_u_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131369717));
    this.titleTextView = ((TextView)localView.findViewById(2131380976));
    this.pw = ((TextView)localView.findViewById(2131380845));
    this.jdField_u_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131369780));
    this.qb = new TextView(this.context);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = aqcx.dip2px(this.context, 5.0F);
    localLayoutParams.gravity = 16;
    this.qb.setTextSize(2, 12.0F);
    this.qb.setId(2131376710);
    ((FrameLayout)localView.findViewById(2131367177)).addView(this.qb, localLayoutParams);
    this.jdField_u_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.qb.setOnClickListener(this);
    this.dP = ((LinearLayout)localView.findViewById(2131370625));
    this.ev = localView.findViewById(2131381913);
    this.bottomTitle = ((TextView)localView.findViewById(2131363697));
    this.ah = ((FrameLayout)localView.findViewById(2131367184));
    this.ai = ((FrameLayout)localView.findViewById(2131367183));
    a(localRelativeLayout);
    return this;
  }
  
  public lwm e()
    throws Exception
  {
    return this;
  }
  
  public lwm o()
  {
    lie locallie;
    ArticleInfo localArticleInfo;
    if ((this.aN instanceof lie))
    {
      locallie = (lie)this.aN;
      localArticleInfo = locallie.a();
      if (localArticleInfo != null) {}
    }
    else
    {
      return this;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeNow", 2, "bindData articleId = " + localArticleInfo.mArticleID + "roomId = " + localArticleInfo.mSubscribeID);
    }
    Object localObject1 = (RelativeLayout.LayoutParams)this.contentView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = ankt.SCREEN_WIDTH;
    ((RelativeLayout.LayoutParams)localObject1).height = (((RelativeLayout.LayoutParams)localObject1).width * 9 / 16);
    this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    Object localObject2 = this.jdField_u_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (localArticleInfo.mVideoCoverUrl != null)
    {
      localObject1 = localArticleInfo.mVideoCoverUrl;
      kwz.a((KandianUrlImageView)localObject2, (URL)localObject1, this.context, true);
      if (cC == null) {
        cC = aqhu.at();
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_u_of_type_ComTencentImageURLImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_u_of_type_ComTencentImageURLImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = cC;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = cC;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(localArticleInfo.thirdIcon)) {
          continue;
        }
        localObject1 = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.b);
        this.jdField_u_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FeedItemCellTypeNow", 2, "configVideoItemUI() ERROR e = " + localMalformedURLException.getMessage());
        continue;
        this.titleTextView.setVisibility(0);
        this.titleTextView.setText(localArticleInfo.mTitle);
        this.titleTextView.getPaint().setFakeBoldText(true);
        this.bottomTitle.setVisibility(8);
        this.ah.setVisibility(8);
        this.ai.setVisibility(0);
        this.qb.setTextColor(-8947849);
        this.qb.getPaint().setFakeBoldText(true);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.ai.removeAllViews();
        this.ai.addView(c(56), localLayoutParams);
        if (localArticleInfo.mVideoPlayCount != 0) {
          break label766;
        }
      }
      localObject2 = localArticleInfo.mSubscribeName;
      localObject1 = localObject2;
      if (((String)localObject2).length() > 18) {
        localObject1 = localArticleInfo.mSubscribeName.substring(0, 17) + "…";
      }
      this.qb.setText((CharSequence)localObject1);
      if (locallie.nh() == 0)
      {
        this.kF.setVisibility(8);
        this.je.setVisibility(8);
        this.titleTextView.setVisibility(8);
        this.pw.setVisibility(8);
        this.jdField_u_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.bottomTitle.setVisibility(0);
        this.bottomTitle.setText(localArticleInfo.mTitle);
        this.ah.setVisibility(0);
        this.ai.setVisibility(8);
        this.qb.setTextColor(Color.argb(255, 157, 157, 157));
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).setMargins(aqcx.dip2px(this.context, 5.0F), 0, 0, aqcx.dip2px(this.context, 2.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 16;
        this.ah.removeAllViews();
        this.ah.addView(c(0), (ViewGroup.LayoutParams)localObject1);
        this.dP.setPadding(this.dP.getPaddingLeft(), 0, this.dP.getPaddingRight(), this.dP.getPaddingBottom());
        localObject1 = this.dP.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = aqcx.dip2px(this.context, 47.0F);
        this.dP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.dP.setBackgroundColor(this.dP.getResources().getColor(2131167654));
        return this;
        if (localArticleInfo.mSinglePicture != null)
        {
          localObject1 = localArticleInfo.mSinglePicture;
          break;
        }
        localObject1 = kxm.b(localArticleInfo.mFirstPagePicUrl);
        break;
        localObject1 = new URL(localArticleInfo.thirdIcon);
        continue;
      }
      this.pw.setVisibility(8);
    }
    for (;;)
    {
      this.ev.setVisibility(8);
      return this;
      label766:
      this.pw.setText(muj.bw(localArticleInfo.mVideoPlayCount));
      this.pw.setVisibility(0);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lyh
 * JD-Core Version:    0.7.0.1
 */