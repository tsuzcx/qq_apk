package dov.com.qq.im.capture.adapter;

import acfp;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import axov;
import axox;
import ayci;
import java.util.ArrayList;
import java.util.List;

public class CaptureModeAdapter
  extends PagerAdapter
{
  private List<a> Na;
  private List<TextView> Nb = new ArrayList();
  private b a;
  private int eGr = e(-1, 0.6F);
  private Context mContext;
  private int mLastIndex;
  
  public CaptureModeAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private int e(int paramInt, float paramFloat)
  {
    return (int)(255.0F * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void aeA(int paramInt)
  {
    TextView localTextView = (TextView)this.Nb.get(this.mLastIndex);
    if (localTextView != null) {
      localTextView.setTextColor(this.eGr);
    }
    this.mLastIndex = paramInt;
    localTextView = (TextView)this.Nb.get(this.mLastIndex);
    if (localTextView != null) {
      localTextView.setTextColor(-1);
    }
  }
  
  public void cy(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.Nb.get(paramInt);
    if (localTextView != null)
    {
      if (paramBoolean) {
        localTextView.setTextColor(-1);
      }
    }
    else {
      return;
    }
    localTextView.setTextColor(this.eGr);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.Nb.get(paramInt));
  }
  
  public int getCount()
  {
    return this.Nb.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.Nb.get(paramInt));
    return this.Nb.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public int lL(int paramInt)
  {
    if (this.Na != null)
    {
      int i = 0;
      while (i < this.Na.size())
      {
        if (((a)this.Na.get(i)).modeType == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      if (paramInt < this.Nb.size())
      {
        TextView localTextView = (TextView)this.Nb.get(paramInt);
        if (this.mLastIndex == paramInt) {
          localTextView.setTextColor(-1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          localTextView.setTextColor(this.eGr);
        }
      }
    }
  }
  
  public void setData(List<a> paramList, int paramInt)
  {
    this.Na = paramList;
    int i = 0;
    if (i < paramList.size())
    {
      a locala = (a)paramList.get(i);
      TextView localTextView = (TextView)LayoutInflater.from(this.mContext).inflate(2131561103, null);
      localTextView.setText(locala.getTitle());
      localTextView.setTag(Integer.valueOf(i));
      localTextView.setContentDescription(locala.getContentDescription());
      localTextView.setOnClickListener(new axox(this));
      if (locala.PQ() != paramInt) {
        localTextView.setTextColor(this.eGr);
      }
      for (;;)
      {
        this.Nb.add(localTextView);
        i += 1;
        break;
        this.mLastIndex = i;
      }
    }
  }
  
  public void x(int paramInt, float paramFloat)
  {
    int i = this.Nb.size();
    int j = paramInt + 1;
    if ((paramInt >= 0) && (paramInt < i) && (j >= 0) && (j < i))
    {
      ((TextView)this.Nb.get(paramInt)).setTextColor(e(-1, (1.0F - paramFloat) * 0.4F + 0.6F));
      ((TextView)this.Nb.get(j)).setTextColor(e(-1, paramFloat * 0.4F + 0.6F));
    }
  }
  
  public static class a
  {
    String contentDescription;
    int modeType;
    String title;
    
    public a(int paramInt)
    {
      this.modeType = paramInt;
      switch (paramInt)
      {
      case 3: 
      case 6: 
      case 8: 
      case 9: 
      default: 
        return;
      case 5: 
        this.title = acfp.m(2131703411);
        this.contentDescription = acfp.m(2131703408);
        return;
      case 1: 
        this.title = acfp.m(2131703410);
        this.contentDescription = this.title;
        return;
      case 0: 
        this.title = acfp.m(2131703413);
        this.contentDescription = this.title;
        return;
      case 2: 
        this.title = acfp.m(2131703412);
        this.contentDescription = this.title;
        return;
      case 4: 
        this.title = acfp.m(2131703414);
        this.contentDescription = this.title;
        return;
      case 7: 
        ayci localayci = (ayci)axov.a(17);
        return;
      }
      this.title = acfp.m(2131703409);
      this.contentDescription = this.title;
    }
    
    public int PQ()
    {
      return this.modeType;
    }
    
    public String getContentDescription()
    {
      return this.contentDescription;
    }
    
    public String getTitle()
    {
      return this.title;
    }
  }
  
  public static abstract interface b
  {
    public abstract void j(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.CaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */