import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.activity.profile.ProfileCellView;
import java.util.ArrayList;
import java.util.List;

public class atbb
  extends auvp
{
  private atbb.a a;
  private List<atbe> jl = new ArrayList();
  
  private Drawable H(int paramInt)
  {
    int i = aqnm.dip2px(8.0F);
    Object localObject;
    if (paramInt == 0) {
      if (getCount() == 1)
      {
        localObject = new float[8];
        localObject[0] = i;
        localObject[1] = i;
        localObject[2] = i;
        localObject[3] = i;
        localObject[4] = i;
        localObject[5] = i;
        localObject[6] = i;
        localObject[7] = i;
      }
    }
    for (;;)
    {
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColor(-1);
      localGradientDrawable1.setCornerRadii((float[])localObject);
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      localGradientDrawable2.setColor(Color.parseColor("#F1F2F8"));
      localGradientDrawable2.setCornerRadii((float[])localObject);
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localGradientDrawable2);
      ((StateListDrawable)localObject).addState(new int[0], localGradientDrawable1);
      return localObject;
      localObject = new float[8];
      localObject[0] = i;
      localObject[1] = i;
      localObject[2] = i;
      localObject[3] = i;
      localObject[4] = 0.0F;
      localObject[5] = 0.0F;
      localObject[6] = 0.0F;
      localObject[7] = 0.0F;
      continue;
      if (paramInt == be().size() - 1)
      {
        localObject = new float[8];
        localObject[0] = 0.0F;
        localObject[1] = 0.0F;
        localObject[2] = 0.0F;
        localObject[3] = 0.0F;
        localObject[4] = i;
        localObject[5] = i;
        localObject[6] = i;
        localObject[7] = i;
      }
      else
      {
        localObject = new float[8];
        Object tmp257_256 = localObject;
        tmp257_256[0] = 0.0F;
        Object tmp261_257 = tmp257_256;
        tmp261_257[1] = 0.0F;
        Object tmp265_261 = tmp261_257;
        tmp265_261[2] = 0.0F;
        Object tmp269_265 = tmp265_261;
        tmp269_265[3] = 0.0F;
        Object tmp273_269 = tmp269_265;
        tmp273_269[4] = 0.0F;
        Object tmp277_273 = tmp273_269;
        tmp277_273[5] = 0.0F;
        Object tmp281_277 = tmp277_273;
        tmp281_277[6] = 0.0F;
        Object tmp286_281 = tmp281_277;
        tmp286_281[7] = 0.0F;
        tmp286_281;
      }
    }
  }
  
  private View a(View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardAdapter", 2, "getDividerView convertView: " + paramView);
    }
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (((atbb.b)paramView.getTag()).divider != null) {}
    }
    else
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559785, paramViewGroup, false);
      paramView = new atbb.b(null);
      paramView.divider = localView.findViewById(2131365990);
      localView.setTag(paramView);
    }
    return localView;
  }
  
  private void aA(View paramView, int paramInt)
  {
    int i = aqnm.dpToPx(10.0F);
    int j = aqnm.dpToPx(20.0F);
    int k = aqnm.dpToPx(22.0F);
    if (paramInt == 0)
    {
      if (getCount() == 1)
      {
        paramView.setPadding(j, k, j, k);
        return;
      }
      paramView.setPadding(j, k, j, i);
      return;
    }
    if (paramInt == be().size() - 1)
    {
      paramView.setPadding(j, i, j, k);
      return;
    }
    paramView.setPadding(j, i, j, i);
  }
  
  private View s(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (((atbb.b)paramView.getTag()).a == null))
    {
      paramView = new ProfileCellView(paramViewGroup.getContext());
      paramViewGroup = new atbb.b(null);
      paramViewGroup.a = ((ProfileCellView)paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(H(paramInt));
      aA(paramView, paramInt);
      atbe localatbe = (atbe)this.jl.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardAdapter", 2, "getContentView convertView: " + paramView + ", position: " + paramInt + ", data: " + localatbe);
      }
      paramViewGroup.a.c(localatbe);
      paramView.setOnClickListener(new atbc(this, localatbe));
      return paramView;
      paramViewGroup = (atbb.b)paramView.getTag();
    }
  }
  
  private View t(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardAdapter", 2, "getAddSchoolView convertView: " + paramView + ", position: " + paramInt + ", data: " + a(paramInt));
    }
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (((atbb.b)paramView.getTag()).aew != null) {}
    }
    else
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559786, paramViewGroup, false);
      paramView = new atbb.b(null);
      paramView.aew = ((TextView)localView.findViewById(2131380549));
      localView.setTag(paramView);
    }
    localView.setBackgroundDrawable(H(paramInt));
    aA(localView, paramInt);
    localView.setOnClickListener(new atbd(this, paramInt));
    return localView;
  }
  
  public atbe a(int paramInt)
  {
    if ((this.jl != null) && (this.jl.size() > paramInt)) {
      return (atbe)this.jl.get(paramInt);
    }
    return null;
  }
  
  public void a(atbb.a parama)
  {
    this.a = parama;
  }
  
  public List<atbe> be()
  {
    if (this.jl == null) {
      return new ArrayList();
    }
    return this.jl;
  }
  
  public void cS(List<atbe> paramList)
  {
    this.jl = paramList;
  }
  
  public int getCount()
  {
    if (this.jl != null) {
      return this.jl.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    atbe localatbe = a(paramInt);
    if (localatbe != null) {
      return localatbe.id;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jl != null) && (this.jl.size() > paramInt)) {
      return ((atbe)this.jl.get(paramInt)).type;
    }
    return super.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    switch (getItemViewType(paramInt))
    {
    default: 
      localView = s(paramInt, paramView, paramViewGroup);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = a(paramView, paramViewGroup);
      continue;
      localView = t(paramInt, paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public static abstract interface a
  {
    public abstract void b(atbe paramatbe);
  }
  
  static final class b
  {
    ProfileCellView a;
    TextView aew;
    View divider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbb
 * JD-Core Version:    0.7.0.1
 */