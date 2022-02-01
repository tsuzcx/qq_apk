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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class atps
  extends atpo
{
  private LinkedHashMap<String, List<FileManagerEntity>> Q = new LinkedHashMap();
  private BaseFileAssistantActivity b;
  private int cWJ = 50;
  private View.OnClickListener cn;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private Context mContext;
  private float mDensity = 0.0F;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private int spacing;
  
  public atps(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
    paramViewGroup.setTag(new atps.a(null));
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
    atps.a locala = (atps.a)paramView.getTag();
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
          try
          {
            paramViewGroup.entity = localFileManagerEntity;
            paramViewGroup.position = paramInt2;
            paramViewGroup.cWI = paramInt1;
            paramViewGroup.b.setAdjustViewBounds(false);
            paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramViewGroup.b.setDefaultImage(2130848704);
            paramViewGroup.b.setAsyncClipSize(this.cWJ, this.cWJ);
            paramInt1 = paramInt2 / 4;
            localObject = String.format(this.b.getString(2131693610), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
            localObject = (String)localObject + "图片名称" + localFileManagerEntity.fileName;
            paramViewGroup.b.setContentDescription((CharSequence)localObject);
            ahav.a(paramViewGroup.b, localFileManagerEntity);
            if ((!this.b.akL()) || (!atwb.b(localFileManagerEntity))) {
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
        }
        catch (Exception paramView)
        {
          Object localObject;
          localView = paramView;
          continue;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localObject = (atpn)paramView.getTag();
        paramViewGroup = (ViewGroup)localObject;
        continue;
        paramViewGroup.aj.setVisibility(4);
        paramViewGroup.zH.setVisibility(4);
        paramView.setOnLongClickListener(this.g);
        return paramView;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atps
 * JD-Core Version:    0.7.0.1
 */