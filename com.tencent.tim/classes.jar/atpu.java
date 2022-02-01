import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class atpu
  extends atpo
{
  protected LinkedHashMap<String, List<WeiYunFileInfo>> Q = new LinkedHashMap();
  public final int TYPE_ITEM = 1;
  protected QfileCloudFileTabView.a a;
  protected BaseFileAssistantActivity b;
  protected int cWJ = 50;
  public final int cWK = 2;
  protected View.OnClickListener cn;
  protected View.OnClickListener eV;
  protected View.OnLongClickListener g;
  protected View.OnClickListener gr;
  protected Context mContext;
  protected float mDensity = 0.0F;
  protected LayoutInflater mInflater;
  protected View.OnClickListener q;
  protected int spacing;
  
  public atpu(QfileCloudFileTabView.a parama, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.mContext = paramBaseFileAssistantActivity;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.Q = ((LinkedHashMap)paramObject);
    this.q = paramOnClickListener1;
    this.cn = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener3;
    this.a = parama;
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.spacing = ((int)(6.0F * this.mDensity));
    this.cWJ = ht(4);
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.mContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new atpu.a(null));
    return paramViewGroup;
  }
  
  private View d(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    atpu.a locala = (atpu.a)paramView.getTag();
    int i = 0;
    for (;;)
    {
      View localView;
      if (i < 4)
      {
        localView = e(paramInt1, paramInt2 * 4 + i, paramBoolean, locala.v[i], paramViewGroup);
        if (localView != null) {}
      }
      else
      {
        return paramView;
      }
      locala.v[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = new LinearLayout.LayoutParams(this.cWJ, this.cWJ);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      ((LinearLayout.LayoutParams)localObject).width = this.cWJ;
      ((LinearLayout.LayoutParams)localObject).height = this.cWJ;
      ((LinearLayout.LayoutParams)localObject).leftMargin = this.spacing;
      ((LinearLayout.LayoutParams)localObject).topMargin = this.spacing;
      paramView.addView(localView);
      i += 1;
    }
  }
  
  private int ht(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt + 1) * 6)) / paramInt;
  }
  
  public int Eb()
  {
    return this.cWJ + this.spacing;
  }
  
  public void N(View.OnClickListener paramOnClickListener)
  {
    this.gr = paramOnClickListener;
  }
  
  public int aw(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.Q.keySet().size()) {
      return 1;
    }
    List localList = (List)this.Q.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  protected View e(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    label298:
    View localView;
    for (WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramViewGroup;; localView = null)
    {
      if (localWeiYunFileInfo == null)
      {
        if (aw(paramInt1, paramInt2) == 1) {
          return null;
        }
        if (this.a.isEnd()) {
          return null;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("@#@#@#", 4, "groupPosition[" + paramInt1 + "],position[" + paramInt2 + "] add getMoreButton");
        }
        paramView = new agdp();
        paramViewGroup = this.mInflater.inflate(2131561011, null);
        paramViewGroup.setClickable(true);
        paramView.Sn = ((TextView)paramViewGroup.findViewById(2131381971));
        paramView.ab = ((ProgressBar)paramViewGroup.findViewById(2131377037));
        paramView.zI = ((ImageView)paramViewGroup.findViewById(2131370781));
        paramView.ccY = true;
        paramView.cWI = paramInt1;
        paramView.position = paramInt2;
        paramViewGroup.setOnClickListener(this.a.a(paramView.Sn));
        paramViewGroup.setTag(paramView);
        if ((this.Q.size() == 0) && (!this.a.akX()))
        {
          paramViewGroup.setVisibility(8);
          if (!this.a.akY()) {
            break label298;
          }
          paramView.ab.setVisibility(0);
          paramView.zI.setVisibility(8);
          paramView.Sn.setText(2131693865);
        }
        for (;;)
        {
          return paramViewGroup;
          paramViewGroup.setVisibility(0);
          break;
          paramView.ab.setVisibility(8);
          paramView.zI.setVisibility(0);
          paramView.Sn.setText(2131693609);
        }
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.mInflater.inflate(2131561021, null);
          paramViewGroup = paramView;
          paramView.setOnClickListener(this.cn);
          paramViewGroup = paramView;
          localObject = new atpn();
          paramViewGroup = paramView;
          ((atpn)localObject).b = ((AsyncImageView)paramView.findViewById(2131368820));
          paramViewGroup = paramView;
          ((atpn)localObject).zH = ((ImageView)paramView.findViewById(2131368840));
          paramViewGroup = paramView;
          ((atpn)localObject).aj = ((ImageView)paramView.findViewById(2131368836));
          paramViewGroup = paramView;
          ((atpn)localObject).ccY = false;
          paramViewGroup = paramView;
          paramView.setTag(localObject);
          paramViewGroup = (ViewGroup)localObject;
        }
        catch (Exception paramView)
        {
          Object localObject;
          localView = paramView;
          continue;
          paramViewGroup = (ViewGroup)localObject;
          continue;
        }
        try
        {
          paramViewGroup.entity = localWeiYunFileInfo;
          paramViewGroup.cWI = paramInt1;
          paramViewGroup.position = paramInt2;
          paramViewGroup.b.setAdjustViewBounds(false);
          paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup.b.setDefaultImage(2130848704);
          paramViewGroup.b.setAsyncClipSize(this.cWJ, this.cWJ);
          paramViewGroup.ccY = false;
          paramInt1 = paramInt2 / 4;
          localObject = String.format(this.b.getString(2131693610), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
          localObject = (String)localObject + "图片名称" + localWeiYunFileInfo.strFileName;
          paramViewGroup.b.setContentDescription((CharSequence)localObject);
          if ((localWeiYunFileInfo.bIz != null) && (localWeiYunFileInfo.bIz.length() > 0) && (aueh.fileExistsAndNotEmpty(localWeiYunFileInfo.bIz))) {
            paramViewGroup.b.setAsyncImage(localWeiYunFileInfo.bIz);
          }
          if ((!this.b.akL()) || (!atwb.c(localWeiYunFileInfo))) {
            continue;
          }
          paramViewGroup.aj.setVisibility(0);
          paramViewGroup.zH.setVisibility(0);
          paramView.setBackgroundColor(this.b.getResources().getColor(2131167654));
          paramView.setOnLongClickListener(null);
          return paramView;
        }
        catch (Exception localException)
        {
          paramViewGroup = paramView;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localObject = (atpn)paramView.getTag();
        paramViewGroup = paramView;
        if (((atpn)localObject).ccY == true)
        {
          paramViewGroup = paramView;
          paramView = this.mInflater.inflate(2131561021, null);
          paramViewGroup = paramView;
          paramView.setOnClickListener(this.cn);
          paramViewGroup = paramView;
          localObject = new atpn();
          paramViewGroup = paramView;
          ((atpn)localObject).b = ((AsyncImageView)paramView.findViewById(2131368820));
          paramViewGroup = paramView;
          ((atpn)localObject).zH = ((ImageView)paramView.findViewById(2131368840));
          paramViewGroup = paramView;
          ((atpn)localObject).aj = ((ImageView)paramView.findViewById(2131368836));
          paramViewGroup = paramView;
          paramView.setTag(localObject);
          paramViewGroup = (ViewGroup)localObject;
          continue;
          paramViewGroup.aj.setVisibility(4);
          paramViewGroup.zH.setVisibility(4);
          paramView.setOnLongClickListener(this.g);
          return paramView;
        }
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.Q.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.Q.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return d(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    int j = 0;
    Iterator localIterator = this.Q.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt)
      {
        paramInt = ((List)this.Q.get(str)).size();
        if (paramInt < 4) {
          paramInt = 1;
        }
      }
    }
    do
    {
      return paramInt;
      return paramInt / 4 + 1;
      i += 1;
      break;
      paramInt = j;
    } while (this.a.isEnd());
    return 1;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.Q.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.Q.keySet().size() > 0) {
      return this.Q.keySet().size();
    }
    if (!this.a.isEnd()) {
      return 1;
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  static class a
  {
    View[] v = new View[12];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpu
 * JD-Core Version:    0.7.0.1
 */