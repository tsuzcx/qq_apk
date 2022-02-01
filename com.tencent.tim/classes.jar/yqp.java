import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class yqp
  extends BaseAdapter
{
  private yqp.b b;
  private Context mContext;
  private List<yqp.a> sX = new ArrayList();
  
  public yqp(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(255.0F * paramFloat))) << 24) + (0xFFFFFF & paramInt);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, { 16842910 }, { 16842908 }, { 16842909 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable e(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = s(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = s(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = s(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = s(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private Drawable s(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(42.0F);
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public yqp.a a(int paramInt)
  {
    return (yqp.a)this.sX.get(paramInt);
  }
  
  public void a(yqp.a parama)
  {
    this.sX.add(parama);
  }
  
  public void a(yqp.b paramb)
  {
    this.b = paramb;
  }
  
  public void clearData()
  {
    this.sX.clear();
  }
  
  public int getCount()
  {
    return this.sX.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    yqp.a locala;
    Object localObject;
    label104:
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561376, null, false);
      paramView = new yqp.c();
      paramView.textView = ((TextView)localView.findViewById(2131380958));
      paramView.textView.setOnClickListener(paramView);
      localView.setTag(paramView);
      locala = a(paramInt);
      if (locala != null)
      {
        paramView.keyword = locala.keyword;
        paramView.position = paramInt;
        TextView localTextView = paramView.textView;
        if (!TextUtils.isEmpty(locala.keyword)) {
          break label216;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          break label226;
        }
        i = Color.parseColor("#A8A8A8");
        paramView.textView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846217));
      }
    }
    for (;;)
    {
      int j = a(0.5F, i);
      paramView.textView.setTextColor(a(i, j, j, i));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (yqp.c)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label216:
      localObject = locala.keyword;
      break label104;
      label226:
      if (locala.aZw == null)
      {
        i = Color.parseColor("#03081A");
        paramView.textView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130846216));
      }
      else
      {
        i = Color.parseColor(locala.aZw);
        paramView.textView.setBackgroundDrawable(e(a(0.1F, i), a(0.2F, i)));
      }
    }
  }
  
  public static class a
  {
    public String aZw;
    public String keyword;
    
    public a(String paramString1, String paramString2)
    {
      this.keyword = paramString1;
      this.aZw = paramString2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void xP(String paramString);
  }
  
  public class c
    implements View.OnClickListener
  {
    String keyword;
    int position;
    TextView textView;
    
    protected c() {}
    
    public void onClick(View paramView)
    {
      if (yqp.a(yqp.this) != null) {
        yqp.a(yqp.this).xP(this.keyword);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqp
 * JD-Core Version:    0.7.0.1
 */