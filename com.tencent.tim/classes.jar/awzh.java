import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;

public class awzh
  extends RecyclerView.Adapter<awzh.b>
{
  private awzh.a a;
  int eCJ;
  private Context mContext;
  List<QIMFilterCategoryItem> mData = new ArrayList();
  
  public awzh(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.eCJ = paramInt;
  }
  
  private boolean aOm()
  {
    awwg localawwg = awwf.a();
    if (localawwg == null) {
      return true;
    }
    return localawwg.dtj;
  }
  
  public awzh.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new awzh.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558546, paramViewGroup, false));
  }
  
  public void a(awzh.a parama)
  {
    this.a = parama;
  }
  
  public void a(awzh.b paramb, int paramInt)
  {
    Object localObject1 = (QIMFilterCategoryItem)this.mData.get(paramInt);
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    Object localObject2;
    if (localObject1 != null)
    {
      localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.mData.get(paramInt);
      localObject2 = ayva.a().d(this.eCJ);
      if (localObject2 == null) {
        break label282;
      }
    }
    label260:
    label272:
    label282:
    for (boolean bool1 = TextUtils.equals(((QIMFilterCategoryItem)localObject2).id, localQIMFilterCategoryItem.id);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (((localObject2 == null) || (((QIMFilterCategoryItem)localObject2).isEmptyFilter())) && (localQIMFilterCategoryItem.isEmptyFilter())) {
          bool2 = true;
        }
      }
      else
      {
        if ((!bool2) || (!aOm())) {
          break label260;
        }
        awzh.b.a(paramb).setVisibility(0);
        label117:
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130845414);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130845414);
        if (paramInt != 0) {
          break label272;
        }
      }
      for (localObject1 = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";; localObject1 = ((QIMFilterCategoryItem)localObject1).iconUrl)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        awzh.b.b(paramb).setImageDrawable((Drawable)localObject1);
        awzh.b.a(paramb).setText(localQIMFilterCategoryItem.name);
        if (this.a != null) {
          paramb.itemView.setOnClickListener(new awzi(this, paramb));
        }
        paramb.itemView.setTag(localQIMFilterCategoryItem);
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
        bool2 = false;
        break;
        awzh.b.a(paramb).setVisibility(8);
        break label117;
      }
    }
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void setData(List<QIMFilterCategoryItem> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    private ImageView HW;
    private ImageView mIcon;
    private TextView mName;
    
    public b(View paramView)
    {
      super();
      this.mIcon = ((ImageView)paramView.findViewById(2131368698));
      this.HW = ((ImageView)paramView.findViewById(2131369118));
      this.mName = ((TextView)paramView.findViewById(2131367090));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzh
 * JD-Core Version:    0.7.0.1
 */