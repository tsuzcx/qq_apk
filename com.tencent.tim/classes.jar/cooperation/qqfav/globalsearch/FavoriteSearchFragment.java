package cooperation.qqfav.globalsearch;

import amlt;
import amlu;
import ampx;
import amsq;
import amwd;
import amwt;
import amxy;
import amxz;
import amzk;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqdf;
import avjs;
import avjt;
import avju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class FavoriteSearchFragment
  extends BaseSearchFragment<avjs>
{
  private amwt g;
  
  public int IT()
  {
    return 60;
  }
  
  public void Id(String paramString)
  {
    Jp(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.keyword = paramString;
    }
    while ((this.jdField_a_of_type_Amwd == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Amwd != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Amwd.cancel();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Amwd;
        this.g.keyword = paramString;
        localFavoriteSearchEngine.a(this.g, this);
        this.dCT += 1;
      }
      return;
    }
    this.jdField_a_of_type_Amlt.cS(null);
    this.YL.setVisibility(8);
    this.Hc.setVisibility(8);
    this.Ha.setVisibility(8);
    this.jdField_a_of_type_Amwd.cancel();
    Jn(false);
    Jp(false);
    removeAllMessage();
  }
  
  public amlt<ampx, amxy> a()
  {
    return new a(this.jdField_a_of_type_ComTencentWidgetListView, this.c);
  }
  
  public amwd<avjs> a()
  {
    return new FavoriteSearchEngine(this.d);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.g = new amwt(this.keyword, paramBundle);
  }
  
  public String vn()
  {
    return avju.cLs;
  }
  
  class a
    extends amlu<ampx, amxy>
    implements View.OnClickListener
  {
    public a(ListView paramListView, aqdf paramaqdf)
    {
      super(paramaqdf);
    }
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      return new avjt(FavoriteSearchFragment.a(FavoriteSearchFragment.this));
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131563035);
    }
    
    public int getCount()
    {
      int i = super.getCount();
      if ((i > 0) && (((avjs)super.a(i - 1)).favId == -2L)) {
        return i - 1;
      }
      return i;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == super.getCount() - 1) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (getItemViewType(paramInt) == 1) {
        if (paramView == null)
        {
          paramView = new TextView(paramViewGroup.getContext());
          paramView.setTextSize(18.0F);
          paramView.setTextColor(paramViewGroup.getResources().getColor(2131167315));
          paramView.setGravity(1);
          paramView.setClickable(true);
          paramView.setOnClickListener(this);
          paramView.setPadding(0, 16, 0, 16);
          localObject1 = paramView;
          if (((avjs)super.a(paramInt)).favId != -1L) {
            break label125;
          }
          ((TextView)localObject1).performClick();
          label96:
          localObject1 = paramView;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (TextView)paramView;
        break;
        label125:
        ((TextView)localObject1).setText(2131700234);
        Object localObject2 = (Animatable)localObject1.getCompoundDrawables()[1];
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (localObject2 == null) {
          break label96;
        }
        ((Animatable)localObject2).stop();
        break label96;
        localObject2 = super.getView(paramInt, paramView, paramViewGroup);
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void onClick(View paramView)
    {
      Object localObject = (TextView)paramView;
      ((TextView)localObject).setText(null);
      Animatable localAnimatable = (Animatable)BaseApplicationImpl.sApplication.getResources().getDrawable(2130839651);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
      localAnimatable.start();
      localObject = (FavoriteSearchEngine)FavoriteSearchFragment.this.a;
      FavoriteSearchFragment.a(FavoriteSearchFragment.this).keyword = FavoriteSearchFragment.this.keyword;
      ((FavoriteSearchEngine)localObject).a(FavoriteSearchFragment.a(FavoriteSearchFragment.this), FavoriteSearchFragment.this);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */