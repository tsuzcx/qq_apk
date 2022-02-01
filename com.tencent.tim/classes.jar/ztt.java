import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ztt
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private NewPhotoPreviewActivity a;
  private ColorDrawable colorDrawable;
  private Drawable mDefaultPhotoDrawable;
  private ArrayList<String> rO = new ArrayList();
  
  public ztt(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.a = paramNewPhotoPreviewActivity;
    this.colorDrawable = new ColorDrawable(570425344);
    this.mDefaultPhotoDrawable = this.a.getResources().getDrawable(2130848704);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoSelectedThumbAdapter", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public int getCount()
  {
    return this.rO.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.rO != null)
    {
      localObject1 = localObject2;
      if (this.rO.size() > paramInt) {
        localObject1 = (String)this.rO.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ztt.a locala;
    Object localObject2;
    String str;
    LocalMediaInfo localLocalMediaInfo;
    Object localObject1;
    int i;
    if (paramView == null)
    {
      locala = new ztt.a();
      localObject2 = new RelativeLayout(this.a);
      locala.av = new URLImageView(this.a);
      locala.av.setPadding(wja.dp2px(8.0F, this.a.getResources()), 0, 0, 0);
      ((RelativeLayout)localObject2).addView(locala.av, wja.dp2px(63.0F, this.a.getResources()), wja.dp2px(55.0F, this.a.getResources()));
      locala.vB = new ImageView(this.a);
      locala.vB.setPadding(wja.dp2px(8.0F, this.a.getResources()), 0, 0, 0);
      locala.vB.setImageResource(2130842318);
      ((RelativeLayout)localObject2).addView(locala.vB, wja.dp2px(63.0F, this.a.getResources()), wja.dp2px(55.0F, this.a.getResources()));
      locala.vC = new ImageView(this.a);
      locala.vC.setImageResource(2130839600);
      locala.vC.setPadding(wja.dp2px(8.0F, this.a.getResources()), 0, 0, wja.dp2px(1.0F, this.a.getResources()));
      paramView = new RelativeLayout.LayoutParams(wja.dp2px(26.0F, this.a.getResources()), wja.dp2px(19.0F, this.a.getResources()));
      paramView.addRule(12);
      paramView.addRule(9);
      locala.vC.setLayoutParams(paramView);
      locala.vC.setVisibility(4);
      ((RelativeLayout)localObject2).addView(locala.vC);
      ((View)localObject2).setTag(locala);
      str = (String)getItem(paramInt);
      localLocalMediaInfo = this.a.getMediaInfoTemp(str);
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.thumbWidth = wja.dp2px(55.0F, this.a.getResources());
      localLocalMediaInfo.thumbHeight = wja.dp2px(55.0F, this.a.getResources());
      paramView = (String)this.a.gallery.getSelectedItem();
      if (paramView != null)
      {
        localObject1 = locala.vB;
        if (!paramView.equals(str)) {
          break label510;
        }
        i = 0;
        label429:
        ((ImageView)localObject1).setVisibility(i);
      }
      if (this.a.getMediaType(str) != 1) {
        break label530;
      }
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label516;
      }
      paramView = a(localLocalMediaInfo, "VIDEO");
      i = 0;
    }
    for (;;)
    {
      if ((paramView == null) && (i == 0))
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return localObject2;
        locala = (ztt.a)paramView.getTag();
        localObject2 = paramView;
        break;
        label510:
        i = 4;
        break label429;
        label516:
        paramView = a(localLocalMediaInfo, "APP_VIDEO");
        i = 0;
        continue;
        label530:
        if (new File(str).exists())
        {
          paramView = a(localLocalMediaInfo, "DEFAULT");
          i = 0;
          continue;
        }
        if (!aqfy.isNetUrl(str)) {
          break label756;
        }
        i = 1;
        paramView = null;
        continue;
      }
      URLDrawable localURLDrawable = locala.mDrawable;
      localObject1 = null;
      if (i != 0)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = wja.dp2px(55.0F, this.a.getResources());
        paramView.mRequestHeight = wja.dp2px(55.0F, this.a.getResources());
        paramView.mLoadingDrawable = this.colorDrawable;
        localObject1 = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), paramView);
      }
      label645:
      label754:
      for (;;)
      {
        if (localObject1 != null)
        {
          ((URLDrawable)localObject1).setTag(localLocalMediaInfo);
          locala.av.setImageDrawable((Drawable)localObject1);
          locala.mDrawable = ((URLDrawable)localObject1);
        }
        if (this.a.mPhotoPreviewData.editPathMap.containsValue(str)) {
          locala.vC.setVisibility(0);
        }
        for (;;)
        {
          break;
          if ((localURLDrawable != null) && (localURLDrawable.getURL().toString().equals(paramView.toString()))) {
            break label754;
          }
          localObject1 = aoop.getDrawable(paramView, this.colorDrawable, this.mDefaultPhotoDrawable);
          break label645;
          locala.vC.setVisibility(4);
        }
      }
      label756:
      paramView = null;
      i = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)this.rO.get(paramInt);
    int i = this.a.mPhotoPreviewData.paths.indexOf(str);
    this.a.gallery.setSelection(i);
    notifyDataSetChanged();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    this.rO = paramArrayList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public URLImageView av;
    public URLDrawable mDrawable;
    public ImageView vB;
    public ImageView vC;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztt
 * JD-Core Version:    0.7.0.1
 */