import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class wms
  extends BaseAdapter
{
  private Context mContext;
  private ArrayList<yfw> mDataList = new ArrayList();
  private Drawable mDefaultDrawable;
  private float pF = 1.25F;
  
  public wms(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDefaultDrawable = paramContext.getResources().getDrawable(2130842311);
  }
  
  private int getColumnNum()
  {
    return 4;
  }
  
  public void cS(List<yfw> paramList)
  {
    this.mDataList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.mDataList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.mDataList != null)
    {
      int i = getColumnNum();
      return (this.mDataList.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt)) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getColumnNum();
    int i = (XPanelContainer.aLe - wja.dp2px(70.0F, this.mContext.getResources()) - wja.dp2px(64.0F, this.mContext.getResources()) * 2) / 3;
    int j;
    if (i >= 0)
    {
      j = wja.dp2px(10.0F, this.mContext.getResources());
      if (i >= j) {
        break label611;
      }
      i = j;
    }
    label419:
    label576:
    label585:
    label611:
    for (;;)
    {
      j = (this.mContext.getResources().getDisplayMetrics().widthPixels - wja.dp2px(64.0F, this.mContext.getResources()) * 4) / 8;
      Object localObject2;
      Object localObject3;
      if (paramView == null)
      {
        localObject1 = new StickerBubbleLinearLayout(this.mContext);
        ((LinearLayout)localObject1).setMinimumHeight(wja.dp2px(64.0F, this.mContext.getResources()) + i);
        ((LinearLayout)localObject1).setOrientation(0);
        j = 0;
        for (;;)
        {
          paramView = (View)localObject1;
          if (j >= k) {
            break;
          }
          paramView = new LinearLayout(this.mContext);
          paramView.setGravity(17);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          if (j == 0) {}
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          localObject2 = new LinearLayout.LayoutParams(wja.dp2px(64.0F, this.mContext.getResources()), wja.dp2px(64.0F, this.mContext.getResources()));
          ((LinearLayout.LayoutParams)localObject2).topMargin = (i / 2);
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = (i / 2);
          localObject3 = new StickerBubbleImageView(this.mContext);
          ((View)localObject3).setPadding(14, 14, 14, 14);
          int m = wja.dp2px(64.0F, this.mContext.getResources());
          int n = wja.dp2px(64.0F, this.mContext.getResources());
          ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
          localShapeDrawable.setIntrinsicHeight(m);
          localShapeDrawable.setIntrinsicWidth(n);
          localShapeDrawable.getPaint().setColor(1728053247);
          ((View)localObject3).setBackgroundDrawable(localShapeDrawable);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramView.addView((View)localObject3);
          ((LinearLayout)localObject1).addView(paramView);
          j += 1;
        }
        i = 0;
        break;
      }
      Object localObject1 = (ViewGroup)paramView;
      if (paramInt == 0)
      {
        ((ViewGroup)localObject1).setPadding(0, i / 2, 0, 0);
        i = 0;
        if (i >= k) {
          break label585;
        }
        j = k * paramInt + i;
        localObject2 = ((ViewGroup)((ViewGroup)localObject1).getChildAt(i)).getChildAt(0);
        if (j >= this.mDataList.size()) {
          break label576;
        }
        ((View)localObject2).setVisibility(0);
        localObject3 = (yfw)this.mDataList.get(j);
        if (localObject3 != null) {
          ((ImageView)localObject2).setImageDrawable(i(((yfw)localObject3).localPath));
        }
        ((View)localObject2).setTag(Integer.valueOf(j));
        if (AppSetting.enableTalkBack) {
          ((View)localObject2).setContentDescription(yfx.cJ(((yfw)localObject3).pokeemoId) + acfp.m(2131709793));
        }
      }
      for (;;)
      {
        i += 1;
        break label419;
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
        break;
        ((View)localObject2).setVisibility(4);
      }
      paramView.setOnLongClickListener(null);
      aqcl.Q(paramView, false);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public Drawable i(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.mDefaultDrawable;
    localURLDrawableOptions.mFailedDrawable = this.mDefaultDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */