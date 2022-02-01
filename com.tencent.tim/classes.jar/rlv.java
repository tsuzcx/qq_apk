import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class rlv
  extends RecyclerView.Adapter<rlv.a>
  implements rlq
{
  private rlv.b jdField_a_of_type_Rlv$b;
  private rmd.a jdField_a_of_type_Rmd$a;
  private int btl = -1;
  private Bitmap cN;
  private Context mContext;
  private List<SlideItemInfo> mItemList = new CopyOnWriteArrayList();
  private View.OnClickListener mOnClickListener;
  
  public rlv(Context paramContext, View.OnClickListener paramOnClickListener, rmd.a parama)
  {
    this.mContext = paramContext;
    this.mOnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Rmd$a = parama;
  }
  
  private void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.mItemList.size())) {
      if ((!paramBoolean) || (this.btl == paramInt)) {
        break label44;
      }
    }
    label44:
    for (this.btl = paramInt;; this.btl = -1)
    {
      notifyItemChanged(paramInt, Integer.valueOf(0));
      return;
    }
  }
  
  public rlv.a a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new rlv.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561921, paramViewGroup, false));
    paramViewGroup.c.setCorner(4);
    paramViewGroup.c.setBorder(true);
    paramViewGroup.c.setOnClickListener(this.mOnClickListener);
    paramViewGroup.ir.setOnClickListener(new rlw(this, paramViewGroup));
    return paramViewGroup;
  }
  
  public void a(rlv.a parama, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.mItemList.get(paramInt);
    parama.mRoot.setTag(localSlideItemInfo);
    parama.ir.setTag(localSlideItemInfo);
    if (localSlideItemInfo != null) {
      if (localSlideItemInfo.k != null)
      {
        Object localObject = parama.c.getDrawable();
        if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.k.equals(((URLDrawable)localObject).getURL())))
        {
          localObject = aoop.getDrawable(localSlideItemInfo.k, aoop.am(), aoop.getFailedDrawable());
          ((URLDrawable)localObject).setTag(localSlideItemInfo.d);
          parama.c.setImageDrawable((Drawable)localObject);
          parama.c.setTag(localSlideItemInfo);
        }
      }
    }
    switch (localSlideItemInfo.mediaType)
    {
    default: 
      if ((paramInt == this.btl) && (!parama.isDragging))
      {
        parama.mRoot.setScaleX(0.94F);
        parama.mRoot.setScaleY(0.94F);
        parama.mRoot.setAlpha(1.0F);
        parama.yN.post(new SlideShowAdapter.3(this, parama));
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
      parama.fX.setVisibility(8);
      parama.yO.setText(rmc.formatTimeToString(localSlideItemInfo.mDuration));
      break;
      parama.fX.setVisibility(0);
      if (localSlideItemInfo.mDuration > 0L) {
        parama.yO.setText(rmc.formatTimeToString(localSlideItemInfo.endTime - localSlideItemInfo.startTime));
      }
      parama.fX.setOnClickListener(new rlx(this, paramInt));
      break;
      if (parama.isDragging)
      {
        parama.mRoot.setScaleX(1.13F);
        parama.mRoot.setScaleY(1.13F);
        parama.mRoot.setAlpha(0.65F);
        parama.yN.setBackgroundDrawable(null);
      }
      else
      {
        parama.mRoot.setScaleX(1.0F);
        parama.mRoot.setScaleY(1.0F);
        parama.mRoot.setAlpha(1.0F);
        parama.yN.setBackgroundDrawable(null);
      }
    }
  }
  
  public void a(rlv.b paramb)
  {
    this.jdField_a_of_type_Rlv$b = paramb;
  }
  
  public void bJ(List<SlideItemInfo> paramList)
  {
    this.mItemList.clear();
    this.mItemList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void eq(int paramInt1, int paramInt2)
  {
    int i = 1;
    Collections.swap(this.mItemList, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    SlideItemInfo localSlideItemInfo;
    if ((this.btl == paramInt1) || (this.btl == paramInt2))
    {
      if (this.btl == paramInt1)
      {
        this.btl = paramInt2;
        notifyItemChanged(paramInt1, Integer.valueOf(0));
        notifyItemChanged(paramInt2, Integer.valueOf(0));
      }
    }
    else
    {
      if (this.jdField_a_of_type_Rmd$a != null) {
        this.jdField_a_of_type_Rmd$a.er(paramInt1, paramInt2);
      }
      if (paramInt1 < this.mItemList.size())
      {
        localSlideItemInfo = (SlideItemInfo)this.mItemList.get(paramInt1);
        if (localSlideItemInfo != null) {
          if (rma.a().tF() != 11) {
            break label191;
          }
        }
      }
    }
    label191:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 = i;
      if (localSlideItemInfo.mediaType == 0) {
        paramInt2 = 0;
      }
      rar.a("pic_choose_slides", "edit_seq", paramInt1, 0, new String[] { paramInt2 + "" });
      return;
      this.btl = paramInt1;
      break;
    }
  }
  
  public int getItemCount()
  {
    return this.mItemList.size();
  }
  
  public String nb()
  {
    String str2 = "";
    String str1 = str2;
    if (this.btl >= 0)
    {
      str1 = str2;
      if (this.btl < this.mItemList.size()) {
        str1 = ((SlideItemInfo)this.mItemList.get(this.btl)).mSrcPath;
      }
    }
    return str1;
  }
  
  public void xH(int paramInt)
  {
    if (paramInt >= 0) {
      if (this.btl < 0) {
        setSelection(paramInt, true);
      }
    }
    while (this.btl < 0)
    {
      return;
      setSelection(this.btl, false);
      setSelection(paramInt, true);
      return;
    }
    setSelection(this.btl, false);
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    public RoundCornerImageView c;
    public RelativeLayout fX;
    public ImageView ir;
    public boolean isDragging;
    public RelativeLayout mRoot;
    public TextView yN;
    public TextView yO;
    
    public a(View paramView)
    {
      super();
      this.mRoot = ((RelativeLayout)paramView.findViewById(2131378497));
      this.c = ((RoundCornerImageView)paramView.findViewById(2131378493));
      this.yN = ((TextView)paramView.findViewById(2131363329));
      this.fX = ((RelativeLayout)paramView.findViewById(2131378494));
      this.yO = ((TextView)paramView.findViewById(2131378496));
      this.ir = ((ImageView)paramView.findViewById(2131378495));
    }
  }
  
  static abstract interface b
  {
    public abstract void xI(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlv
 * JD-Core Version:    0.7.0.1
 */