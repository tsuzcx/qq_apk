import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nlr
  implements nln
{
  public int a(BaseData paramBaseData)
  {
    return 11;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new nlr.a(LayoutInflater.from(paramContext).inflate(2131560365, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 11;
  }
  
  static class a
    extends nlm
    implements View.OnClickListener
  {
    private URLImageView I;
    private TextView title;
    private TextView to;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      paramView.setOnClickListener(this);
      this.I = ((URLImageView)paramView.findViewById(2131369555));
      this.title = ((TextView)paramView.findViewById(2131380976));
      this.to = ((TextView)paramView.findViewById(2131380650));
      odc.a((FrameLayout)paramView.findViewById(2131367353), 0.0F, Color.parseColor("#dedfe0"), 1);
      odc.a((TextView)paramView.findViewById(2131380725), wja.dp2px(2.0F, paramView.getResources()), Color.parseColor("#fa8726"), 1);
      odc.a((TextView)paramView.findViewById(2131380843), wja.dp2px(2.0F, paramView.getResources()), Color.parseColor("#12b7f5"), 1);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      switch (paramBaseData2.type)
      {
      default: 
        throw new IllegalArgumentException();
      }
      paramBaseData1 = (AttachedAdData)paramBaseData2;
      this.title.setText(paramBaseData1.title);
      this.to.setText(paramBaseData1.content);
      paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
      paramBaseData2.mRequestWidth = wja.dp2px(85.0F, this.itemView.getContext().getResources());
      paramBaseData2.mRequestHeight = wja.dp2px(72.0F, this.itemView.getContext().getResources());
      paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData2.mPlayGifImage = true;
      paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData1 = URLDrawable.getDrawable(obs.a(paramBaseData1.imgUrl, 4), paramBaseData2);
      if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
        paramBaseData1.restartDownload();
      }
      this.I.setImageDrawable(paramBaseData1);
    }
    
    public void onClick(View paramView)
    {
      nno.a((Activity)paramView.getContext(), (AdData)this.g);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlr
 * JD-Core Version:    0.7.0.1
 */