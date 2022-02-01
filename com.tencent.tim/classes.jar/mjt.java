import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.b;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class mjt
  extends ReadInJoyNinePicDeliverDynamicGridView.b
  implements View.OnTouchListener
{
  private mjt.b jdField_a_of_type_Mjt$b;
  private mjt.c jdField_a_of_type_Mjt$c;
  
  public mjt(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private Drawable getDrawable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = akyr.lP(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.cF;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.cF;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = aqnm.dpToPx(114.0F);
        localURLDrawableOptions.mRequestHeight = aqnm.dpToPx(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(mjt.b paramb)
  {
    this.jdField_a_of_type_Mjt$b = paramb;
  }
  
  public void a(mjt.c paramc)
  {
    this.jdField_a_of_type_Mjt$c = paramc;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131560494, null);
      paramView = new mjt.a(null);
      paramView.jA = ((ImageView)localView.findViewById(2131381189));
      paramView.jB = ((ImageView)localView.findViewById(2131381186));
      localView.setTag(paramView);
      localObject = this.mItems.get(paramInt);
      if (!(localObject instanceof HotPicData)) {
        break label204;
      }
      localObject = ReadInJoyDeliverUGCActivity.a((HotPicData)localObject);
      if (localObject != null)
      {
        paramView.jB.setImageDrawable((Drawable)localObject);
        paramView.jB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.jA.setVisibility(0);
      }
    }
    for (;;)
    {
      paramView.jB.setTag(Integer.valueOf(paramInt));
      paramView.jA.setTag(Integer.valueOf(paramInt));
      paramView.jB.setOnTouchListener(this);
      paramView.jA.setOnClickListener(new mju(this));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (mjt.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label204:
      if ("".equals(localObject))
      {
        paramView.jB.setImageResource(2130842561);
        paramView.jB.setScaleType(ImageView.ScaleType.CENTER);
        paramView.jA.setVisibility(8);
      }
      else
      {
        localObject = getDrawable((String)localObject);
        if (localObject != null)
        {
          paramView.jB.setImageDrawable((Drawable)localObject);
          paramView.jB.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView.jA.setVisibility(0);
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Mjt$c != null) {
      return this.jdField_a_of_type_Mjt$c.g(paramView, paramMotionEvent);
    }
    return false;
  }
  
  class a
  {
    ImageView jA;
    ImageView jB;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void D(View paramView, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean g(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjt
 * JD-Core Version:    0.7.0.1
 */