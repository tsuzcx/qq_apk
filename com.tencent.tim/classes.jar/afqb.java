import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class afqb
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private afqb.b a;
  private ColorDrawable colorDrawable;
  private String currentPath;
  private Context mContext;
  private Drawable mDefaultPhotoDrawable;
  private ArrayList<String> rO = new ArrayList();
  private int thumbWidth;
  
  public afqb(Context paramContext, afqb.b paramb)
  {
    this.mContext = paramContext;
    this.a = paramb;
    this.colorDrawable = new ColorDrawable(570425344);
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130848704);
    this.thumbWidth = wja.dp2px(50.0F, this.mContext.getResources());
  }
  
  public static URL a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewThumbAdapter", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.rO != null) {
      return this.rO.size();
    }
    return 0;
  }
  
  public ArrayList<String> getDataList()
  {
    return this.rO;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.rO != null) && (paramInt < this.rO.size())) {
      return (String)this.rO.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public LocalMediaInfo getMediaInfoTemp(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMediaType = 0;
    localLocalMediaInfo.path = paramString;
    localLocalMediaInfo.thumbWidth = this.thumbWidth;
    localLocalMediaInfo.thumbHeight = this.thumbWidth;
    return localLocalMediaInfo;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new afqb.a();
      localView = LayoutInflater.from(this.mContext).inflate(2131559779, paramViewGroup, false);
      paramView.av = ((URLImageView)localView.findViewById(2131379634));
      paramView.vB = ((ImageView)localView.findViewById(2131379632));
      localView.setTag(paramView);
    }
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      localObject2 = getItem(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (afqb.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    if (((String)localObject2).equals(this.currentPath)) {
      paramView.vB.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = getMediaInfoTemp((String)localObject2);
      localObject2 = a((String)localObject2, "DEFAULT");
      URLDrawable localURLDrawable = paramView.mDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().toString().equals(((URL)localObject2).toString())))
      {
        localObject2 = aoop.getDrawable((URL)localObject2, this.colorDrawable, this.mDefaultPhotoDrawable);
        ((URLDrawable)localObject2).setTag(localObject1);
        paramView.av.setImageDrawable((Drawable)localObject2);
        paramView.mDrawable = ((URLDrawable)localObject2);
      }
      break;
      paramView.vB.setVisibility(8);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a != null) {
      this.a.MS(paramInt);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setCurrentPath(String paramString)
  {
    this.currentPath = paramString;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    this.rO = paramArrayList;
    notifyDataSetChanged();
  }
  
  public String uz()
  {
    return this.currentPath;
  }
  
  public class a
  {
    public URLImageView av;
    public URLDrawable mDrawable;
    public ImageView vB;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void MS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqb
 * JD-Core Version:    0.7.0.1
 */