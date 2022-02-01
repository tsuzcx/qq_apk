import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rit
  extends BaseAdapter
{
  private int UZ;
  private rir a;
  private SparseArray<ImageView> bc;
  private int bnG;
  private int brZ;
  private int bsa;
  private int bsb;
  private int bsc;
  private Context mContext;
  
  public rit(Context paramContext)
  {
    this.mContext = paramContext;
    this.brZ = riw.dip2px(this.mContext, 30.0F);
    this.bnG = riw.dip2px(this.mContext, 50.0F);
    this.bsa = riw.dip2px(this.mContext, 45.0F);
    this.bsb = riw.dip2px(this.mContext, 10.0F);
    this.bsc = riw.dip2px(this.mContext, 7.5F);
    this.bc = new SparseArray();
  }
  
  private ImageView a(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.bnG, this.bsa);
    localImageView.setPadding(this.bsb, this.bsc, this.bsb, this.bsc);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      rfr.setAlpha(localImageView, f);
      return localImageView;
    }
  }
  
  public void a(rir paramrir)
  {
    if (paramrir == null) {
      ram.d("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.a = paramrir;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.a == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    label38:
    label83:
    rik localrik;
    if (paramView == null)
    {
      localObject = a(false);
      this.bc.put(paramInt, localObject);
      if (paramInt == this.UZ) {
        rfr.setAlpha((View)localObject, 1.0F);
      }
      ((ImageView)localObject).setContentDescription("");
      if (paramInt != 0) {
        break label142;
      }
      ((ImageView)localObject).setContentDescription(acfp.m(2131707961));
      localrik = (rik)getItem(paramInt);
      if (localrik != null)
      {
        if (localrik.C == null) {
          break label160;
        }
        ram.d("LogoIconAdapter", "logo is already load. ");
        ((ImageView)localObject).setImageDrawable(localrik.C);
      }
    }
    for (;;)
    {
      break;
      localObject = (ImageView)paramView;
      rfr.setAlpha((View)localObject, 0.5F);
      break label38;
      label142:
      if (paramInt != 1) {
        break label83;
      }
      ((ImageView)localObject).setContentDescription(acfp.m(2131707960));
      break label83;
      label160:
      String str = (String)((ImageView)localObject).getTag(2131379238);
      if ((TextUtils.isEmpty(str)) || (!str.equals(localrik.logoUrl)))
      {
        ((ImageView)localObject).setTag(2131379238, localrik.logoUrl);
        rgn.a().a(this.mContext, (ImageView)localObject, localrik.logoUrl, this.brZ, this.brZ, null);
      }
    }
  }
  
  public void onChange()
  {
    super.notifyDataSetChanged();
  }
  
  public int tv()
  {
    return this.bnG;
  }
  
  public void xC(int paramInt)
  {
    this.UZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rit
 * JD-Core Version:    0.7.0.1
 */