import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class acbf
  extends BaseAdapter
{
  int cuu;
  private Context mContext;
  private int mCurrentIndex = -1;
  private LayoutInflater mInflater;
  private List<ApolloActionPackage> xe;
  
  public acbf(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.cuu = paramContext.getResources().getColor(2131165783);
  }
  
  public void IB(int paramInt)
  {
    this.mCurrentIndex = paramInt;
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    ApolloActionPackage localApolloActionPackage = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable2;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable2 = abtn.a("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localURLDrawable1 = localURLDrawable2;
      if (localURLDrawable2 != null) {
        localURLDrawable2.startDownload();
      }
    }
    for (URLDrawable localURLDrawable1 = localURLDrawable2;; localURLDrawable1 = null)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        paramApolloActionPackage = abtn.a("" + paramApolloActionPackage.mIconUnselectedUrl.hashCode(), null, paramApolloActionPackage.mIconUnselectedUrl, true);
        localApolloActionPackage = paramApolloActionPackage;
        if (paramApolloActionPackage != null)
        {
          paramApolloActionPackage.startDownload();
          localApolloActionPackage = paramApolloActionPackage;
        }
      }
      if (localURLDrawable1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable1);
      }
      if (localApolloActionPackage != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localApolloActionPackage);
      }
      return localStateListDrawable;
    }
  }
  
  public ApolloActionPackage b(int paramInt)
  {
    if (this.xe == null) {
      return null;
    }
    return (ApolloActionPackage)this.xe.get(paramInt);
  }
  
  public int getCount()
  {
    if (this.xe == null) {
      return 0;
    }
    return this.xe.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public List<ApolloActionPackage> getPackageList()
  {
    return this.xe;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131558737, paramViewGroup, false);
      paramView = new acbf.a();
      paramView.aU = ((URLImageView)localView.findViewById(2131379131));
      paramView.aU.setActivated(true);
      paramView.aU.setFocusable(true);
      paramView.aU.setEnabled(true);
      paramView.kS = localView.findViewById(2131379127);
      paramView.kS.setBackgroundColor(this.cuu);
      paramView.yc = ((ImageView)localView.findViewById(2131379129));
      localView.setTag(paramView);
      paramView.yc.setVisibility(8);
      localObject = paramView.kS;
      if (paramInt == getCount() - 1) {
        break label256;
      }
      i = 0;
      label134:
      ((View)localObject).setVisibility(i);
      localObject = b(paramInt);
      if (localObject != null)
      {
        paramView.aU.setImageDrawable(a((ApolloActionPackage)localObject));
        paramView.aU.setContentDescription(((ApolloActionPackage)localObject).name);
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime)) {
          paramView.yc.setVisibility(0);
        }
      }
      if (paramInt != this.mCurrentIndex) {
        break label262;
      }
      localView.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (acbf.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label256:
      i = 4;
      break label134;
      label262:
      localView.setSelected(false);
    }
  }
  
  public void iB(List<ApolloActionPackage> paramList)
  {
    this.xe = paramList;
  }
  
  public class a
  {
    URLImageView aU;
    View kS;
    public ImageView yc;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbf
 * JD-Core Version:    0.7.0.1
 */