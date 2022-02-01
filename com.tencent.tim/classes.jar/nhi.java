import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.a;
import com.tencent.biz.widgets.TabLayout.a.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class nhi
  extends TabLayout.a<TabChannelCoverInfo>
{
  public static final String TAG = nhi.class.getSimpleName();
  private kfv a;
  private TabLayout b;
  private Map<Integer, mgu> eF;
  
  public nhi(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, kfv paramkfv)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.a = paramkfv;
  }
  
  private void c(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int qB()
  {
    if (kyo.Bg()) {
      return 11;
    }
    return 6;
  }
  
  public void J(Map<Integer, mgu> paramMap)
  {
    this.eF = paramMap;
  }
  
  protected void a(TabLayout.a.a parama, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)parama.getView(2131380976);
    Object localObject2 = (ImageView)parama.getView(2131369780);
    ImageView localImageView2 = (ImageView)parama.getView(2131369783);
    Object localObject1 = (ImageView)parama.getView(2131372308);
    c(new View[] { localTextView, localObject2, localImageView2, localObject1 });
    ImageView localImageView1 = (ImageView)parama.getView(2131369878);
    if (paramTabChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverPicUrl))
      {
        localImageView2.setVisibility(0);
        localImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mChannelCoverPicUrl, true));
      }
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mIconUrl)) {
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    label778:
    try
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverName)) && (paramTabChannelCoverInfo.only_cover == 0))
      {
        localTextView.setText(paramTabChannelCoverInfo.mChannelCoverName);
        if (paramTabChannelCoverInfo.fonts_color != 0)
        {
          i = paramTabChannelCoverInfo.fonts_color;
          localTextView.setTextColor(i);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.redPoint == null) {
          break label761;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        if (!paramTabChannelCoverInfo.redPoint.isShow) {
          break label744;
        }
        long l = System.currentTimeMillis() / 1000L;
        if ((paramTabChannelCoverInfo.redPoint.vS == 0L) || ((float)(l - paramTabChannelCoverInfo.redPoint.vS) <= 2.5F) || ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.vS / 3600L) >= 1.0F)) {
          break label615;
        }
        i = 1;
        if ((paramTabChannelCoverInfo.redPoint.startTimestamp > l) || ((paramTabChannelCoverInfo.redPoint.endTimestamp != 0L) && (paramTabChannelCoverInfo.redPoint.endTimestamp < l))) {
          break label727;
        }
        if (paramTabChannelCoverInfo.redPoint.type != 0) {
          break label621;
        }
        localImageView1.setVisibility(0);
        parama.getItemView().setOnClickListener(new nhj(this, paramInt, paramTabChannelCoverInfo, localImageView1));
        if (this.b != null)
        {
          i = this.b.getFirstVisiblePosition();
          int j = this.b.getLastVisiblePosition();
          if ((paramInt >= i) && (paramInt <= j) && (this.eF != null))
          {
            localObject1 = new mhy();
            ((mgu)localObject1).f = paramTabChannelCoverInfo;
            ((mgu)localObject1).aRE = paramInt;
            this.eF.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject1);
          }
        }
        if (this.a != null)
        {
          parama = parama.getView(2131369473);
          if (paramInt != this.a.getSelectedItem()) {
            break label778;
          }
          localTextView.setTextColor(localTextView.getResources().getColor(2131167165));
          localTextView.setTypeface(Typeface.defaultFromStyle(1));
          parama.setVisibility(0);
          if (this.a.getScrollState() == 0)
          {
            paramTabChannelCoverInfo = (ViewGroup.MarginLayoutParams)parama.getLayoutParams();
            paramTabChannelCoverInfo.leftMargin = aqnm.dpToPx(0.0F);
            paramTabChannelCoverInfo.rightMargin = aqnm.dpToPx(0.0F);
            parama.setLayoutParams(paramTabChannelCoverInfo);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      label727:
      for (;;)
      {
        int i;
        label615:
        label744:
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "load channel cover error : " + localException);
          continue;
          i = -16777216;
          continue;
          i = 0;
          continue;
          label621:
          if ((paramInt < qB()) && (i == 0))
          {
            if (kfv.aeI)
            {
              ((ImageView)localObject1).setVisibility(0);
              TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
              localTranslateAnimation.setDuration(3000L);
              localTranslateAnimation.setRepeatCount(1);
              localTranslateAnimation.setStartOffset(1000L);
              localTranslateAnimation.setFillAfter(true);
              ((ImageView)localObject1).startAnimation(localTranslateAnimation);
            }
            paramTabChannelCoverInfo.redPoint.vS = (System.currentTimeMillis() / 1000L);
            this.a.b(paramTabChannelCoverInfo);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label761:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localTextView.setTextColor(localTextView.getResources().getColor(2131167166));
            localTextView.setTypeface(Typeface.defaultFromStyle(0));
            parama.setVisibility(4);
          }
        }
      }
    }
  }
  
  public int ha()
  {
    return 2131560419;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhi
 * JD-Core Version:    0.7.0.1
 */