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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class agdu
  extends agdq
{
  private LinkedHashMap<String, List<FileInfo>> Q = new LinkedHashMap();
  protected BaseFileAssistantActivity b;
  protected int cWJ = 50;
  private View.OnClickListener eT;
  private View.OnClickListener eU;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  protected Context mContext;
  private float mDensity = 0.0F;
  protected LayoutInflater mInflater;
  private View.OnClickListener q;
  private int spacing;
  
  public agdu(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.mContext = paramBaseFileAssistantActivity;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.Q = ((LinkedHashMap)paramObject);
    this.q = paramOnClickListener1;
    this.eU = paramOnClickListener3;
    this.eT = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener4;
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.spacing = ((int)(2.0F * this.mDensity));
    this.cWJ = ht(getColumnCount());
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.mContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new agdu.a(null));
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
    agdu.a locala = (agdu.a)paramView.getTag();
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
  
  private int ht(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 2)) / paramInt;
  }
  
  public int Eb()
  {
    return this.cWJ + this.spacing;
  }
  
  protected View e(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (Object localObject = (FileInfo)paramViewGroup;; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          paramViewGroup = this.mInflater.inflate(2131561021, null);
          paramView = paramViewGroup;
          try
          {
            localagdp = new agdp();
            paramView = paramViewGroup;
            localagdp.b = ((AsyncImageView)paramViewGroup.findViewById(2131368820));
            paramView = paramViewGroup;
            localagdp.zH = ((ImageView)paramViewGroup.findViewById(2131368840));
            paramView = paramViewGroup;
            localagdp.aj = ((ImageView)paramViewGroup.findViewById(2131368836));
            paramView = paramViewGroup;
            localagdp.zH.setOnClickListener(this.eT);
            paramView = paramViewGroup;
            localagdp.b.setTag(localagdp);
            paramView = paramViewGroup;
            localagdp.zH.setTag(localagdp);
            paramView = paramViewGroup;
            localagdp.b.setOnClickListener(this.eU);
            paramView = paramViewGroup;
            paramViewGroup.setTag(localagdp);
            paramView = paramViewGroup;
            ((FileInfo)localObject).setGroupName((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localagdp.entity = localObject;
            paramView = paramViewGroup;
            localagdp.position = paramInt2;
            paramView = paramViewGroup;
            localagdp.cWI = paramInt1;
            paramView = paramViewGroup;
            localagdp.b.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localagdp.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localagdp.b.setDefaultImage(2130848704);
            paramView = paramViewGroup;
            localagdp.b.setAsyncClipSize(this.cWJ, this.cWJ);
            paramView = paramViewGroup;
            if (((FileInfo)localObject).getPath() != null)
            {
              paramView = paramViewGroup;
              if (((FileInfo)localObject).getPath().length() > 0)
              {
                paramView = paramViewGroup;
                if (ahbj.fileExistsAndNotEmpty(((FileInfo)localObject).getPath()))
                {
                  paramView = paramViewGroup;
                  localagdp.b.setAsyncImage(((FileInfo)localObject).getPath());
                }
              }
            }
            paramView = paramViewGroup;
            str = this.b.getString(2131693611) + ((FileInfo)localObject).getName();
            paramView = paramViewGroup;
            if (!this.b.akL()) {
              continue;
            }
            paramView = paramViewGroup;
            localagdp.zH.setVisibility(0);
            paramView = paramViewGroup;
            if (agmz.d((FileInfo)localObject))
            {
              paramView = paramViewGroup;
              localObject = str + this.b.getString(2131693612);
              paramView = paramViewGroup;
              localagdp.zH.setImageResource(2130841267);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.b.getResources().getColor(2131167654));
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localagdp.zH.setContentDescription((CharSequence)localObject);
              paramView = paramViewGroup;
              localagdp.b.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localagdp = (agdp)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localObject = str + acfp.m(2131711094);
            paramView = paramViewGroup;
            localagdp.aj.setVisibility(4);
            paramView = paramViewGroup;
            localagdp.zH.setImageResource(2130846606);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          agdp localagdp;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localagdp.zH.setVisibility(8);
        paramView = paramViewGroup;
        localagdp.aj.setVisibility(8);
        localObject = str;
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
    int k = 0;
    Iterator localIterator = this.Q.keySet().iterator();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i == paramInt) {
          j = ((List)this.Q.get(str)).size() / 4 + 1;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  protected int getColumnCount()
  {
    return 4;
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
    return this.Q.keySet().size();
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
 * Qualified Name:     agdu
 * JD-Core Version:    0.7.0.1
 */