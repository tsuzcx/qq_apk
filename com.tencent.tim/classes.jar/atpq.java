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
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class atpq
  extends atpo
{
  private LinkedHashMap<String, List<FileInfo>> Q = new LinkedHashMap();
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
  
  public atpq(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
    paramViewGroup.setTag(new atpq.a(null));
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
    atpq.a locala = (atpq.a)paramView.getTag();
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
    for (FileInfo localFileInfo = (FileInfo)paramViewGroup;; localFileInfo = null)
    {
      if (localFileInfo == null) {
        return null;
      }
      if (paramView == null) {}
      try
      {
        paramViewGroup = this.mInflater.inflate(2131561021, null);
        paramView = paramViewGroup;
        try
        {
          paramViewGroup.setOnClickListener(this.cn);
          paramView = paramViewGroup;
          atpn localatpn = new atpn();
          paramView = paramViewGroup;
          localatpn.b = ((AsyncImageView)paramViewGroup.findViewById(2131368820));
          paramView = paramViewGroup;
          localatpn.zH = ((ImageView)paramViewGroup.findViewById(2131368840));
          paramView = paramViewGroup;
          localatpn.aj = ((ImageView)paramViewGroup.findViewById(2131368836));
          paramView = paramViewGroup;
          paramViewGroup.setTag(localatpn);
          paramView = paramViewGroup;
          localFileInfo.setGroupName((String)getGroup(paramInt1));
          paramView = paramViewGroup;
          localatpn.entity = localFileInfo;
          paramView = paramViewGroup;
          localatpn.position = paramInt2;
          paramView = paramViewGroup;
          localatpn.cWI = paramInt1;
          paramView = paramViewGroup;
          localatpn.b.setAdjustViewBounds(false);
          paramView = paramViewGroup;
          localatpn.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView = paramViewGroup;
          localatpn.b.setDefaultImage(2130848704);
          paramView = paramViewGroup;
          localatpn.b.setAsyncClipSize(this.cWJ, this.cWJ);
          paramView = paramViewGroup;
          paramInt1 = paramInt2 / 4;
          paramView = paramViewGroup;
          String str = String.format(this.b.getString(2131693610), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
          paramView = paramViewGroup;
          str = str + "图片名称" + localFileInfo.getName();
          paramView = paramViewGroup;
          localatpn.b.setContentDescription(str);
          paramView = paramViewGroup;
          if (localFileInfo.getPath() != null)
          {
            paramView = paramViewGroup;
            if (localFileInfo.getPath().length() > 0)
            {
              paramView = paramViewGroup;
              if (aueh.fileExistsAndNotEmpty(localFileInfo.getPath()))
              {
                paramView = paramViewGroup;
                localatpn.b.setAsyncImage(localFileInfo.getPath());
              }
            }
          }
          paramView = paramViewGroup;
          if (this.b.akL())
          {
            paramView = paramViewGroup;
            if (atwb.d(localFileInfo))
            {
              paramView = paramViewGroup;
              localatpn.aj.setVisibility(0);
              paramView = paramViewGroup;
              localatpn.zH.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.b.getResources().getColor(2131167654));
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
            }
          }
          for (;;)
          {
            return paramViewGroup;
            localatpn = (atpn)paramView.getTag();
            paramViewGroup = paramView;
            break;
            paramView = paramViewGroup;
            localatpn.aj.setVisibility(4);
            paramView = paramViewGroup;
            localatpn.zH.setVisibility(4);
            paramView = paramViewGroup;
            paramViewGroup.setOnLongClickListener(this.g);
          }
          paramViewGroup.printStackTrace();
        }
        catch (Exception paramViewGroup) {}
      }
      catch (Exception paramViewGroup)
      {
        label554:
        break label554;
      }
      QLog.e("#######", 1, paramViewGroup.toString());
      return paramView;
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
 * Qualified Name:     atpq
 * JD-Core Version:    0.7.0.1
 */