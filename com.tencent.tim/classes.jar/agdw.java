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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class agdw
  extends agdq
{
  private LinkedHashMap<String, List<FileManagerEntity>> Q = new LinkedHashMap();
  private BaseFileAssistantActivity b;
  private int cWJ = 50;
  private View.OnClickListener eT;
  private View.OnClickListener eU;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private Context mContext;
  private float mDensity = 0.0F;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private int spacing;
  
  public agdw(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
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
    paramViewGroup.setTag(new agdw.a(null));
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
    agdw.a locala = (agdw.a)paramView.getTag();
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
    View localView;
    for (FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramViewGroup;; localView = null)
    {
      if (localFileManagerEntity == null) {
        return null;
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
          localagdp = new agdp();
          paramViewGroup = paramView;
          localagdp.b = ((AsyncImageView)paramView.findViewById(2131368820));
          paramViewGroup = paramView;
          localagdp.zH = ((ImageView)paramView.findViewById(2131368840));
          paramViewGroup = paramView;
          localagdp.aj = ((ImageView)paramView.findViewById(2131368836));
          paramViewGroup = paramView;
          localagdp.zH.setOnClickListener(this.eT);
          paramViewGroup = paramView;
          localagdp.b.setOnClickListener(this.eU);
          paramViewGroup = paramView;
          localagdp.zH.setTag(localagdp);
          paramViewGroup = paramView;
          localagdp.b.setTag(localagdp);
          paramViewGroup = paramView;
          paramView.setTag(localagdp);
          try
          {
            localagdp.entity = localFileManagerEntity;
            localagdp.position = paramInt2;
            localagdp.cWI = paramInt1;
            localagdp.b.setAdjustViewBounds(false);
            localagdp.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localagdp.b.setDefaultImage(2130848704);
            localagdp.b.setAsyncClipSize(this.cWJ, this.cWJ);
            ahav.a(localagdp.b, localFileManagerEntity);
            paramViewGroup = this.b.getString(2131693611) + localFileManagerEntity.fileName;
            if (!this.b.akL()) {
              continue;
            }
            localagdp.zH.setVisibility(0);
            if (!agmz.b(localFileManagerEntity)) {
              continue;
            }
            paramViewGroup = paramViewGroup + this.b.getString(2131693612);
            localagdp.zH.setImageResource(2130841267);
            paramView.setBackgroundColor(this.b.getResources().getColor(2131167654));
            paramView.setOnLongClickListener(null);
            localagdp.zH.setContentDescription(paramViewGroup);
            localagdp.b.setContentDescription(paramViewGroup);
            return paramView;
          }
          catch (Exception localException)
          {
            paramViewGroup = paramView;
          }
        }
        catch (Exception paramView)
        {
          agdp localagdp;
          localView = paramView;
          continue;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localagdp = (agdp)paramView.getTag();
        continue;
        paramViewGroup = paramViewGroup + acfp.m(2131711110);
        localagdp.aj.setVisibility(4);
        localagdp.zH.setImageResource(2130846606);
        paramView.setOnLongClickListener(this.g);
        continue;
        localagdp.zH.setVisibility(8);
        localagdp.aj.setVisibility(8);
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
        if (i != paramInt) {
          break label82;
        }
        paramInt = ((List)this.Q.get(str)).size();
        if (paramInt < 4) {
          j = 1;
        }
      }
      else
      {
        return j;
      }
      return paramInt / 4 + 1;
      label82:
      i += 1;
    }
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
 * Qualified Name:     agdw
 * JD-Core Version:    0.7.0.1
 */