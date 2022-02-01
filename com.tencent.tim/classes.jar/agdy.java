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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.a;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class agdy
  extends agdq
{
  private LinkedHashMap<String, List<WeiYunFileInfo>> Q = new LinkedHashMap();
  public final int TYPE_ITEM = 1;
  private QfileCloudFileTabView.a a;
  private BaseFileAssistantActivity b;
  private int cWJ = 50;
  public final int cWK = 2;
  private View.OnClickListener eT;
  private View.OnClickListener eU;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private Context mContext;
  private float mDensity = 0.0F;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private int spacing;
  
  public agdy(QfileCloudFileTabView.a parama, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.mContext = paramBaseFileAssistantActivity;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.Q = ((LinkedHashMap)paramObject);
    this.q = paramOnClickListener1;
    this.eT = paramOnClickListener2;
    this.eU = paramOnClickListener3;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener4;
    this.a = parama;
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.spacing = ((int)(2.0F * this.mDensity));
    this.cWJ = ht(4);
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.mContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new agdy.a(null));
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
    agdy.a locala = (agdy.a)paramView.getTag();
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
      if (localLayoutParams == null) {
        localObject = new LinearLayout.LayoutParams(this.cWJ, this.cWJ);
      }
      ((LinearLayout.LayoutParams)localObject).width = this.cWJ;
      ((LinearLayout.LayoutParams)localObject).height = this.cWJ;
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.spacing;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.spacing;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i += 1;
    }
  }
  
  private View e(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    label295:
    Object localObject2;
    for (Object localObject1 = (WeiYunFileInfo)paramViewGroup;; localObject2 = null)
    {
      if (localObject1 == null)
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
            break label295;
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
          localObject3 = new agdp();
          paramViewGroup = paramView;
          ((agdp)localObject3).b = ((AsyncImageView)paramView.findViewById(2131368820));
          paramViewGroup = paramView;
          ((agdp)localObject3).zH = ((ImageView)paramView.findViewById(2131368840));
          paramViewGroup = paramView;
          ((agdp)localObject3).aj = ((ImageView)paramView.findViewById(2131368836));
          paramViewGroup = paramView;
          ((agdp)localObject3).b.setOnClickListener(this.eU);
          paramViewGroup = paramView;
          ((agdp)localObject3).zH.setOnClickListener(this.eT);
          paramViewGroup = paramView;
          ((agdp)localObject3).b.setTag(localObject3);
          paramViewGroup = paramView;
          ((agdp)localObject3).zH.setTag(localObject3);
          paramViewGroup = paramView;
          ((agdp)localObject3).ccY = false;
          paramViewGroup = paramView;
          paramView.setTag(localObject3);
          paramViewGroup = (ViewGroup)localObject3;
        }
        catch (Exception paramView)
        {
          Object localObject3;
          localObject2 = paramView;
          continue;
          paramViewGroup = (ViewGroup)localObject3;
          continue;
        }
        try
        {
          paramViewGroup.entity = localObject1;
          paramViewGroup.cWI = paramInt1;
          paramViewGroup.position = paramInt2;
          paramViewGroup.b.setAdjustViewBounds(false);
          paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup.b.setDefaultImage(2130848704);
          paramViewGroup.b.setAsyncClipSize(this.cWJ, this.cWJ);
          paramViewGroup.ccY = false;
          if ((((WeiYunFileInfo)localObject1).bIz != null) && (((WeiYunFileInfo)localObject1).bIz.length() > 0) && (ahbj.fileExistsAndNotEmpty(((WeiYunFileInfo)localObject1).bIz))) {
            paramViewGroup.b.setAsyncImage(((WeiYunFileInfo)localObject1).bIz);
          }
          localObject3 = this.b.getString(2131693611) + ((WeiYunFileInfo)localObject1).strFileName;
          if (!this.b.akL()) {
            continue;
          }
          paramViewGroup.zH.setVisibility(0);
          if (!agmz.c((WeiYunFileInfo)localObject1)) {
            continue;
          }
          localObject1 = (String)localObject3 + this.b.getString(2131693612);
          paramViewGroup.zH.setImageResource(2130841267);
          paramView.setBackgroundColor(this.b.getResources().getColor(2131167654));
          paramView.setOnLongClickListener(null);
          paramViewGroup.zH.setContentDescription((CharSequence)localObject1);
          paramViewGroup.b.setContentDescription((CharSequence)localObject1);
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
        localObject3 = (agdp)paramView.getTag();
        paramViewGroup = paramView;
        if (!((agdp)localObject3).ccY) {
          continue;
        }
        paramViewGroup = paramView;
        paramView = this.mInflater.inflate(2131561021, null);
        paramViewGroup = paramView;
        localObject3 = new agdp();
        paramViewGroup = paramView;
        ((agdp)localObject3).b = ((AsyncImageView)paramView.findViewById(2131368820));
        paramViewGroup = paramView;
        ((agdp)localObject3).zH = ((ImageView)paramView.findViewById(2131368840));
        paramViewGroup = paramView;
        ((agdp)localObject3).aj = ((ImageView)paramView.findViewById(2131368836));
        paramViewGroup = paramView;
        ((agdp)localObject3).b.setOnClickListener(this.eU);
        paramViewGroup = paramView;
        ((agdp)localObject3).zH.setOnClickListener(this.eT);
        paramViewGroup = paramView;
        ((agdp)localObject3).b.setTag(localObject3);
        paramViewGroup = paramView;
        ((agdp)localObject3).zH.setTag(localObject3);
        paramViewGroup = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
        continue;
        localObject2 = (String)localObject3 + acfp.m(2131711141);
        paramViewGroup.aj.setVisibility(4);
        paramViewGroup.zH.setImageResource(2130846606);
        paramView.setOnLongClickListener(this.g);
        continue;
        paramViewGroup.zH.setVisibility(8);
        paramViewGroup.aj.setVisibility(8);
        localObject2 = localObject3;
      }
    }
  }
  
  private int ht(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 2)) / paramInt;
  }
  
  public int Eb()
  {
    return this.cWJ + this.spacing;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdy
 * JD-Core Version:    0.7.0.1
 */