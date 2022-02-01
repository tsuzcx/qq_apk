package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoop;
import ayii;
import aytd;
import ayte;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import rlq;
import rma;
import rmc;
import rmd.a;

public class HorizontalAlumbListLayout
  extends RelativeLayout
  implements View.OnClickListener, rmd.a
{
  private ImageView IZ;
  public ayii a;
  private a a;
  private LinearLayoutManager mLinearLayoutManager;
  private View mRootView;
  private RecyclerView o;
  private TextView yQ;
  
  public HorizontalAlumbListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public HorizontalAlumbListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131561923, this);
    this.o = ((RecyclerView)this.mRootView.findViewById(2131375239));
    this.o.setLayoutManager(this.mLinearLayoutManager);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$a = new a(getContext(), this, this);
    this.o.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$a);
    this.o.addOnScrollListener(new aytd(this));
    this.IZ = ((ImageView)this.mRootView.findViewById(2131375238));
    this.IZ.setOnClickListener(new ayte(this));
  }
  
  public void a(SlideItemInfo paramSlideItemInfo) {}
  
  public void bJ(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HorizontalAlumbListLayout", 2, "updateData size=" + paramList.size());
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$a != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout$a.bJ(paramList);
    }
  }
  
  public void bvy() {}
  
  public void er(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView) {}
  
  public void sA(String paramString) {}
  
  public void setEditVideoUI(ayii paramayii)
  {
    this.jdField_a_of_type_Ayii = paramayii;
  }
  
  public void setTipsContent(TextView paramTextView)
  {
    this.yQ = paramTextView;
    if (rma.a().tF() == 13)
    {
      this.yQ.setText(String.format(getContext().getString(2131693001), new Object[] { rma.a().getPhotoList().size() + "" }));
      this.yQ.setVisibility(0);
      return;
    }
    this.yQ.setVisibility(8);
  }
  
  public void setTipsGone()
  {
    if (this.yQ != null) {
      this.yQ.setVisibility(8);
    }
  }
  
  public class a
    extends RecyclerView.Adapter<HorizontalAlumbListLayout.b>
    implements rlq
  {
    private rmd.a a;
    private int btl = -1;
    private Bitmap cN;
    private Context mContext;
    private List<SlideItemInfo> mItemList = new CopyOnWriteArrayList();
    private View.OnClickListener mOnClickListener;
    
    public a(Context paramContext, View.OnClickListener paramOnClickListener, rmd.a parama)
    {
      this.mContext = paramContext;
      this.mOnClickListener = paramOnClickListener;
      this.a = parama;
    }
    
    public HorizontalAlumbListLayout.b a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = new HorizontalAlumbListLayout.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561921, paramViewGroup, false));
      paramViewGroup.c.setCorner(4);
      paramViewGroup.c.setOnClickListener(this.mOnClickListener);
      return paramViewGroup;
    }
    
    public void a(HorizontalAlumbListLayout.b paramb, int paramInt)
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.mItemList.get(paramInt);
      paramb.mRoot.setTag(localSlideItemInfo);
      if (localSlideItemInfo.k != null)
      {
        Object localObject = paramb.c.getDrawable();
        if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.k.equals(((URLDrawable)localObject).getURL())))
        {
          localObject = aoop.getDrawable(localSlideItemInfo.k, aoop.am(), aoop.getFailedDrawable());
          ((URLDrawable)localObject).setTag(localSlideItemInfo.d);
          paramb.c.setImageDrawable((Drawable)localObject);
          paramb.c.setTag(localSlideItemInfo);
        }
      }
      switch (localSlideItemInfo.mediaType)
      {
      default: 
        if ((paramInt == this.btl) && (!paramb.isDragging))
        {
          paramb.mRoot.setScaleX(0.94F);
          paramb.mRoot.setScaleY(0.94F);
          paramb.mRoot.setAlpha(1.0F);
          paramb.yN.post(new HorizontalAlumbListLayout.SlideShowAdapter.1(this, paramb));
        }
        break;
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
        paramb.fX.setVisibility(8);
        paramb.yO.setText(rmc.formatTimeToString(localSlideItemInfo.mDuration));
        break;
        paramb.fX.setVisibility(8);
        if (localSlideItemInfo.mDuration <= 0L) {
          break;
        }
        paramb.yO.setText(rmc.formatTimeToString(localSlideItemInfo.endTime - localSlideItemInfo.startTime));
        break;
        if (paramb.isDragging)
        {
          paramb.mRoot.setScaleX(1.13F);
          paramb.mRoot.setScaleY(1.13F);
          paramb.mRoot.setAlpha(0.65F);
          paramb.yN.setBackgroundDrawable(null);
        }
        else
        {
          paramb.mRoot.setScaleX(1.0F);
          paramb.mRoot.setScaleY(1.0F);
          paramb.mRoot.setAlpha(1.0F);
          paramb.yN.setBackgroundDrawable(null);
        }
      }
    }
    
    public void bJ(List<SlideItemInfo> paramList)
    {
      this.mItemList.clear();
      this.mItemList.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public void eq(int paramInt1, int paramInt2)
    {
      Collections.swap(this.mItemList, paramInt1, paramInt2);
      notifyItemMoved(paramInt1, paramInt2);
      if ((this.btl == paramInt1) || (this.btl == paramInt2)) {
        if (this.btl != paramInt1) {
          break label81;
        }
      }
      label81:
      for (this.btl = paramInt2;; this.btl = paramInt1)
      {
        notifyItemChanged(paramInt1, Integer.valueOf(0));
        notifyItemChanged(paramInt2, Integer.valueOf(0));
        if (this.a != null) {
          this.a.er(paramInt1, paramInt2);
        }
        return;
      }
    }
    
    public int getItemCount()
    {
      return this.mItemList.size();
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    public RoundCornerImageView c;
    public RelativeLayout fX;
    public ImageView ir;
    public boolean isDragging;
    public RelativeLayout mRoot;
    public TextView yN;
    public TextView yO;
    
    public b(View paramView)
    {
      super();
      this.mRoot = ((RelativeLayout)paramView.findViewById(2131378497));
      this.c = ((RoundCornerImageView)paramView.findViewById(2131378493));
      this.yN = ((TextView)paramView.findViewById(2131363329));
      this.fX = ((RelativeLayout)paramView.findViewById(2131378494));
      this.fX.setVisibility(8);
      this.yO = ((TextView)paramView.findViewById(2131378496));
      this.yO.setVisibility(8);
      this.ir = ((ImageView)paramView.findViewById(2131378495));
      this.ir.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout
 * JD-Core Version:    0.7.0.1
 */