import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class alwa
  extends BaseAdapter
{
  public String TAG = "SubtitleProviderGridAdapter";
  public int dyp;
  private Context mContext;
  List<alwk> mData;
  
  public alwa(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(alwk paramalwk, View paramView)
  {
    if ((paramalwk == null) || (paramView == null)) {}
    do
    {
      return;
      paramView = (ImageView)paramView.findViewById(2131365459);
    } while (paramView == null);
    if ((paramalwk != null) && (paramalwk.b != null) && (paramalwk.b.mState != 2) && (!paramalwk.czX))
    {
      paramView.setImageResource(2130846916);
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void b(alwk paramalwk, View paramView)
  {
    if ((paramalwk == null) || (paramView == null)) {}
    do
    {
      return;
      CircleProgress localCircleProgress = (CircleProgress)paramView.findViewById(2131379003);
      paramView = (ImageView)paramView.findViewById(2131369118);
      if (paramalwk.czX)
      {
        localCircleProgress.setVisibility(0);
        if (paramalwk.b != null) {
          localCircleProgress.setProgress(paramalwk.b.mProgress);
        }
        paramView.setVisibility(8);
        return;
      }
      localCircleProgress.setVisibility(8);
    } while (this.dyp != paramalwk.mID);
    paramView.setVisibility(0);
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.mContext).inflate(2131561259, paramViewGroup, false);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131367090);
      Object localObject2 = (ImageView)paramView.findViewById(2131369118);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368698);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365459);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131369428);
      Object localObject1 = (CircleProgress)paramView.findViewById(2131379003);
      int i = this.mContext.getResources().getColor(2131167304);
      int j = this.mContext.getResources().getColor(2131165409);
      ((CircleProgress)localObject1).setStrokeWidth(2.0F);
      ((CircleProgress)localObject1).setBgAndProgressColor(30, i, 100, j);
      localObject1 = (alwk)this.mData.get(paramInt);
      if (this.dyp == ((alwk)localObject1).mID)
      {
        i = 1;
        paramView.setTag(localObject1);
        if ((AbsListView.LayoutParams)paramView.getLayoutParams() == null) {
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        if (!((alwk)localObject1).auH()) {
          break label300;
        }
        ((ImageView)localObject2).setVisibility(8);
        if (i == 0) {
          break label280;
        }
        localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130846851));
      }
      for (;;)
      {
        localImageView1.setContentDescription(acfp.m(2131715074));
        localImageView2.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText("");
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        i = 0;
        break;
        label280:
        localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130846852));
      }
      label300:
      if (i != 0)
      {
        ((ImageView)localObject2).setVisibility(0);
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
        localRelativeLayout.setVisibility(8);
      }
      for (;;)
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846844);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130846844);
        b((alwk)localObject1, paramView);
        localObject2 = URLDrawable.getDrawable(((alwk)localObject1).mIconUrl, URLDrawable.URLDrawableOptions.obtain());
        ((URLDrawable)localObject2).startDownload();
        localImageView1.setImageDrawable((Drawable)localObject2);
        localImageView1.setContentDescription(((alwk)localObject1).mName);
        localTextView.setText(((alwk)localObject1).mName);
        localTextView.setVisibility(8);
        a((alwk)localObject1, paramView);
        break;
        ((ImageView)localObject2).setVisibility(8);
        localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
        localRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void setData(List<alwk> paramList)
  {
    this.mData = paramList;
    if ((paramList != null) && (QLog.isColorLevel())) {
      QLog.d(this.TAG, 2, "SubtitleProviderGridAdapter setData size = " + paramList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwa
 * JD-Core Version:    0.7.0.1
 */