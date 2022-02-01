import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.view.MiddleBracketsTitleTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

public class mjp
  extends BaseAdapter
{
  private liq a = lbz.a().a();
  private Context context;
  private List<ReadInJoyDraftboxItem> itemList;
  
  public mjp(Context paramContext, List<ReadInJoyDraftboxItem> paramList)
  {
    this.itemList = paramList;
    this.context = paramContext;
  }
  
  private int a(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    if (paramReadInJoyDraftboxItem.type == 0) {
      return 1;
    }
    if (paramReadInJoyDraftboxItem.type == 1) {
      return 4;
    }
    if (paramReadInJoyDraftboxItem.type == 2) {
      return 3;
    }
    if (paramReadInJoyDraftboxItem.type == 3) {
      return 6;
    }
    return 5;
  }
  
  private URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = aqnm.dpToPx(100.0F);
    localURLDrawableOptions.mRequestHeight = aqnm.dpToPx(100.0F);
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      localURLDrawableOptions.mRequestWidth = aqnm.dip2px(50.0F);
      localURLDrawableOptions.mRequestHeight = aqnm.dip2px(50.0F);
      if (paramHotPicData.getDataType() != 2) {
        break label69;
      }
    }
    label69:
    for (paramHotPicData = ahzs.a((HotVideoData)paramHotPicData);; paramHotPicData = ahyv.getURL(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label80;
      }
      return null;
      bool = false;
      break;
    }
    label80:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public int getCount()
  {
    if (this.itemList != null) {
      return this.itemList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = View.inflate(this.context, 2131560356, null);; localView = paramView)
    {
      Object localObject2 = (TextView)localView.findViewById(2131380670);
      MiddleBracketsTitleTextView localMiddleBracketsTitleTextView = (MiddleBracketsTitleTextView)localView.findViewById(2131380668);
      paramView = (TextView)localView.findViewById(2131380669);
      ImageView localImageView = (ImageView)localView.findViewById(2131369729);
      TextView localTextView = (TextView)localView.findViewById(2131380645);
      ((TextView)localObject2).setEditableFactory(aofr.a);
      localMiddleBracketsTitleTextView.setEditableFactory(aofr.a);
      ReadInJoyDraftboxItem localReadInJoyDraftboxItem;
      if ((this.itemList != null) && (paramInt >= 0) && (paramInt < this.itemList.size()))
      {
        localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.itemList.get(paramInt);
        paramView.setText(kxl.c(localReadInJoyDraftboxItem.time, false));
        paramView = localReadInJoyDraftboxItem.title;
        if (localReadInJoyDraftboxItem.type == 3) {
          paramView = this.context.getResources().getString(2131718479);
        }
        if (TextUtils.isEmpty(paramView)) {
          break label509;
        }
        Object localObject1 = paramView;
        if (localReadInJoyDraftboxItem.type == 2) {
          localObject1 = this.context.getResources().getString(2131718475) + ": " + paramView;
        }
        ((TextView)localObject2).setText(new aofk((CharSequence)localObject1, 7, 16));
        ((TextView)localObject2).setVisibility(0);
        localObject1 = localReadInJoyDraftboxItem.digest;
        paramView = (View)localObject1;
        if (localReadInJoyDraftboxItem.type == 3)
        {
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty(localReadInJoyDraftboxItem.title))
          {
            localObject2 = "[" + localReadInJoyDraftboxItem.title + "]";
            paramView = (String)localObject2 + (String)localObject1;
            localMiddleBracketsTitleTextView.setTitle((String)localObject2);
            localMiddleBracketsTitleTextView.setNeedAddBrackets(true);
          }
        }
        if (TextUtils.isEmpty(paramView)) {
          break label519;
        }
        localMiddleBracketsTitleTextView.setText(new aofk(paramView, 7, 16));
        localMiddleBracketsTitleTextView.setVisibility(0);
        label377:
        if ((localReadInJoyDraftboxItem.firstPicData == null) || ((localReadInJoyDraftboxItem.firstPicData.b == null) && (TextUtils.isEmpty(localReadInJoyDraftboxItem.firstPicData.picPath)))) {
          break label615;
        }
        localImageView.setVisibility(0);
        if (localReadInJoyDraftboxItem.firstPicData.b == null) {
          break label529;
        }
        localImageView.setImageDrawable(a(localReadInJoyDraftboxItem.firstPicData.b));
      }
      for (;;)
      {
        localView.setOnClickListener(new mjq(this, localReadInJoyDraftboxItem));
        localTextView.setOnClickListener(new mjr(this, localReadInJoyDraftboxItem, paramInt));
        localView.setTag(-3, Integer.valueOf(aqnm.dip2px(66.0F)));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        label509:
        ((TextView)localObject2).setVisibility(8);
        break;
        label519:
        localMiddleBracketsTitleTextView.setVisibility(8);
        break label377;
        label529:
        if (localReadInJoyDraftboxItem.firstPicData.type == 1)
        {
          paramView = new File(localReadInJoyDraftboxItem.firstPicData.picPath);
          if (paramView.exists()) {
            localImageView.setImageDrawable(URLDrawable.getDrawable(paramView, a()));
          }
        }
        else if (localReadInJoyDraftboxItem.firstPicData.type == 2)
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localReadInJoyDraftboxItem.firstPicData.picPath, a()));
          continue;
          label615:
          localImageView.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjp
 * JD-Core Version:    0.7.0.1
 */