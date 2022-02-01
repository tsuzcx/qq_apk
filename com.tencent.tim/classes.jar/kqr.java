import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class kqr
  extends BaseAdapter
{
  private ArrayList<mih.b> info;
  private Context mContext;
  
  public int getCount()
  {
    if (this.info != null) {
      return this.info.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.info != null) {
      return this.info.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == this.info.size() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = this.mContext.getResources();
    Object localObject1;
    if ((paramInt == 0) || (paramInt == this.info.size() - 1))
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = new View(this.mContext);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(wja.dp2px(2.0F, (Resources)localObject2), wja.dp2px(100.0F, (Resources)localObject2)));
      }
      paramView = (View)localObject1;
      localObject2 = localObject1;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new kqr.a(null);
      paramView = new RelativeLayout(this.mContext);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(wja.dp2px(100.0F, (Resources)localObject2), wja.dp2px(100.0F, (Resources)localObject2)));
      localObject3 = new BubbleImageView(this.mContext);
      ((BubbleImageView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((BubbleImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject3).setRadius(5.0F);
      ((BubbleImageView)localObject3).TE(false);
      ((kqr.a)localObject1).a = ((BubbleImageView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new BubbleImageView(this.mContext);
      ((BubbleImageView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((BubbleImageView)localObject3).setRadius(5.0F);
      ((BubbleImageView)localObject3).TE(false);
      ((BubbleImageView)localObject3).setBackgroundColor(1711276032);
      ((kqr.a)localObject1).b = ((BubbleImageView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new TextView(this.mContext);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(wja.dp2px(9.0F, (Resources)localObject2), wja.dp2px(6.0F, (Resources)localObject2), wja.dp2px(9.0F, (Resources)localObject2), 0);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(14.0F);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((kqr.a)localObject1).title = ((TextView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new TextView(this.mContext);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(wja.dp2px(8.0F, (Resources)localObject2), 0, 0, wja.dp2px(8.0F, (Resources)localObject2));
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((TextView)localObject3).setPadding(wja.dp2px(5.0F, (Resources)localObject2), 0, wja.dp2px(5.0F, (Resources)localObject2), 0);
      ((TextView)localObject3).setTextColor(-7745469);
      ((TextView)localObject3).setTextSize(11.0F);
      ((TextView)localObject3).setBackgroundResource(2130843852);
      ((kqr.a)localObject1).bd = ((TextView)localObject3);
      paramView.addView((View)localObject3);
      paramView.setTag(localObject1);
      label501:
      localObject2 = (mih.b)this.info.get(paramInt);
      if (localObject2 != null)
      {
        localObject3 = new ColorDrawable(-1);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        if (TextUtils.isEmpty(((mih.b)localObject2).picUrl)) {
          break label706;
        }
        localObject3 = URLDrawable.getDrawable(((mih.b)localObject2).picUrl, (URLDrawable.URLDrawableOptions)localObject4);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((kqr.a)localObject1).a.setImageDrawable((Drawable)localObject3);
        label601:
        localObject3 = new StringBuilder();
        if (!TextUtils.isEmpty(((mih.b)localObject2).businessNamePrefix)) {
          ((StringBuilder)localObject3).append(((mih.b)localObject2).businessNamePrefix);
        }
        if (!TextUtils.isEmpty(((mih.b)localObject2).businessName)) {
          ((StringBuilder)localObject3).append(((mih.b)localObject2).businessName);
        }
        ((kqr.a)localObject1).title.setText(((StringBuilder)localObject3).toString());
        if (((mih.b)localObject2).aTk > 0) {
          break label719;
        }
        ((kqr.a)localObject1).bd.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (kqr.a)paramView.getTag();
      break label501;
      label706:
      ((kqr.a)localObject1).a.setImageDrawable((Drawable)localObject3);
      break label601;
      label719:
      if (((mih.b)localObject2).aTk < 1000)
      {
        ((kqr.a)localObject1).bd.setVisibility(0);
        ((kqr.a)localObject1).bd.setText("+" + ((mih.b)localObject2).aTk);
      }
      else
      {
        ((kqr.a)localObject1).bd.setVisibility(0);
        ((kqr.a)localObject1).bd.setText("+999");
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setData(List<mih.b> paramList)
  {
    if (paramList != null)
    {
      this.info.clear();
      mih.b localb = new mih.b();
      this.info.add(localb);
      this.info.addAll(paramList);
      paramList = new mih.b();
      this.info.add(paramList);
    }
  }
  
  static class a
  {
    BubbleImageView a;
    BubbleImageView b;
    TextView bd;
    TextView title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqr
 * JD-Core Version:    0.7.0.1
 */