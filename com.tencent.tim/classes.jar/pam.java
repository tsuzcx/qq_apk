import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class pam
  extends BaseAdapter
{
  private Drawable cW;
  private FeedCloudMeta.StFeed d;
  private float lJ = 11.0F;
  private final WeakReference<Context> mContext;
  private int mMode = 1;
  private final ArrayList<FeedCloudMeta.StTagInfo> mr = new ArrayList();
  private final ArrayList<FeedCloudMeta.StTagInfo> ms = new ArrayList();
  
  public pam(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    if (this.cW == null)
    {
      this.cW = paramContext.getResources().getDrawable(2130844859);
      this.cW.setBounds(0, 0, ImmersiveUtils.dpToPx(14.0F), ImmersiveUtils.dpToPx(14.0F));
    }
  }
  
  private static String a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    String str = paramStTagInfo.tagName.get();
    paramStTagInfo = str;
    if (aqmr.getWordCount(str) > 22) {
      paramStTagInfo = aqmr.substring(str, 0, 22) + "...";
    }
    return paramStTagInfo;
  }
  
  private void rn(boolean paramBoolean)
  {
    int m = 0;
    this.ms.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(ImmersiveUtils.dpToPx(this.lJ));
    int n = ImmersiveUtils.getScreenWidth() - ImmersiveUtils.dpToPx(12.0F) * 2 - ImmersiveUtils.dpToPx(7.0F) - ImmersiveUtils.dpToPx(14.0F) * 2;
    int k;
    int i;
    int j;
    float f1;
    float f2;
    if (paramBoolean)
    {
      k = 1;
      i = 0;
      j = 1;
      f1 = 0.0F;
      if (i >= this.mr.size()) {
        break label300;
      }
      f2 = localTextPaint.measureText(a((FeedCloudMeta.StTagInfo)this.mr.get(i))) + ImmersiveUtils.dpToPx(14.0F) + ImmersiveUtils.dpToPx(4.0F) + ImmersiveUtils.dpToPx(13.0F);
      if (f1 + f2 <= n) {
        break label261;
      }
      j += 1;
      if (j <= k) {
        break label250;
      }
      if (!paramBoolean) {
        break label233;
      }
      if (f1 <= n) {
        break label297;
      }
      i -= 1;
    }
    for (;;)
    {
      label169:
      if (j <= k)
      {
        i = this.mr.size();
        this.mMode = 1;
        j = m;
      }
      for (;;)
      {
        if (j >= i) {
          break label296;
        }
        this.ms.add(this.mr.get(j));
        j += 1;
        continue;
        k = 3;
        break;
        label233:
        if (f1 <= n) {
          break label297;
        }
        i -= 1;
        break label169;
        label250:
        for (f1 = f2;; f1 += f2)
        {
          i += 1;
          break;
        }
        label261:
        if (paramBoolean)
        {
          this.mMode = 2;
          j = m;
        }
        else
        {
          this.mMode = 3;
          j = m;
        }
      }
      label296:
      return;
      label297:
      continue;
      label300:
      i = 0;
    }
  }
  
  private TextView v()
  {
    TextView localTextView = new TextView((Context)this.mContext.get());
    localTextView.setIncludeFontPadding(false);
    localTextView.setPadding(ImmersiveUtils.dpToPx(5.0F), 0, ImmersiveUtils.dpToPx(10.0F), 0);
    localTextView.setCompoundDrawables(this.cW, null, null, null);
    localTextView.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
    localTextView.setGravity(17);
    localTextView.setTextColor(-1);
    localTextView.setMaxLines(1);
    localTextView.setBackgroundResource(2130844759);
    localTextView.setTextSize(1, this.lJ);
    return localTextView;
  }
  
  public void e(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mr.clear();
    this.ms.clear();
    if ((paramStFeed != null) && (paramStFeed.tagInfos.get().size() > 0))
    {
      this.d = paramStFeed;
      this.mr.addAll(paramStFeed.tagInfos.get());
    }
    for (;;)
    {
      rn(true);
      notifyDataSetChanged();
      return;
      ram.e("FeedTagAdapter", "TagList size 0");
    }
  }
  
  public int getCount()
  {
    return this.ms.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new FrameLayout((Context)this.mContext.get());
      paramView = new FrameLayout.LayoutParams(-2, ImmersiveUtils.dpToPx(21.0F));
      paramView.rightMargin = ImmersiveUtils.dpToPx(6.0F);
      paramView.bottomMargin = ImmersiveUtils.dpToPx(9.0F);
      ((FrameLayout)localObject).addView(v(), paramView);
      paramView = new pam.a((FrameLayout)localObject);
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      paramView.a((FeedCloudMeta.StTagInfo)this.ms.get(paramInt), this.d);
      ((View)localObject).setTag(2131375263, Integer.valueOf(getItemViewType(paramInt)));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      pam.a locala = (pam.a)paramView.getTag();
      localObject = paramView;
      paramView = locala;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isFold()
  {
    return this.mMode == 2;
  }
  
  public int rZ()
  {
    if (this.mMode != 2) {}
    for (boolean bool = true;; bool = false)
    {
      rn(bool);
      notifyDataSetChanged();
      return this.mMode;
    }
  }
  
  static class a
  {
    public TextView we;
    
    public a(FrameLayout paramFrameLayout)
    {
      this.we = ((TextView)paramFrameLayout.getChildAt(0));
    }
    
    public void a(FeedCloudMeta.StTagInfo paramStTagInfo, FeedCloudMeta.StFeed paramStFeed)
    {
      if (TextUtils.isEmpty(paramStTagInfo.tagName.get()))
      {
        this.we.setVisibility(8);
        return;
      }
      this.we.setVisibility(0);
      this.we.setText(pam.b(paramStTagInfo));
      this.we.setOnClickListener(new pan(this, paramStFeed, paramStTagInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pam
 * JD-Core Version:    0.7.0.1
 */