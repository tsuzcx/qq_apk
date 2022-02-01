import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afvb
  extends BaseAdapter
{
  private List<aftp> Az = new ArrayList();
  private boolean caJ;
  private Context mContext;
  
  public afvb(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(255.0F * paramFloat))) << 24) + (0xFFFFFF & paramInt);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842910, 16842908 };
    int[] arrayOfInt2 = { 16842908 };
    int[] arrayOfInt3 = { 16842909 };
    int[] arrayOfInt4 = new int[0];
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, arrayOfInt1, { 16842910 }, arrayOfInt2, arrayOfInt3, arrayOfInt4 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private SpannableString a(Drawable paramDrawable)
  {
    SpannableString localSpannableString = new SpannableString(" ");
    int i = wja.dp2px(11.0F, this.mContext.getResources());
    paramDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new VerticalCenterImageSpan(paramDrawable, 0), 0, 1, 33);
    return localSpannableString;
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
    localGradientDrawable.setCornerRadius(25.0F);
    localGradientDrawable.setColor(paramInt);
    if (this.caJ) {
      localGradientDrawable.setStroke(1, -1);
    }
    return localGradientDrawable;
  }
  
  public void Iy(boolean paramBoolean)
  {
    this.caJ = paramBoolean;
  }
  
  public aftp a(int paramInt)
  {
    return (aftp)this.Az.get(paramInt);
  }
  
  public void clearData()
  {
    this.Az.clear();
  }
  
  public int getCount()
  {
    return this.Az.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    aftp localaftp;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561329, null, false);
      paramView = new afvb.a();
      paramView.textView = ((TextView)localView.findViewById(2131380687));
      localView.setTag(paramView);
      localaftp = a(paramInt);
      if (localaftp != null)
      {
        paramView.position = paramInt;
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        if (localaftp.icon != null) {
          localSpannableStringBuilder.append(a(localaftp.icon));
        }
        if (!TextUtils.isEmpty(localaftp.label)) {
          localSpannableStringBuilder.append(localaftp.label);
        }
        TextView localTextView = paramView.textView;
        localObject = localSpannableStringBuilder;
        if (TextUtils.isEmpty(localSpannableStringBuilder)) {
          localObject = "";
        }
        localTextView.setText((CharSequence)localObject);
        if (!TextUtils.isEmpty(localaftp.bFA)) {
          break label249;
        }
        i = Color.parseColor("#FF80BF");
        paramView.textView.setBackgroundDrawable(e(a(0.2F, i), a(0.2F, i)));
      }
    }
    for (;;)
    {
      paramView.textView.setTextColor(a(i, i, i, i));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afvb.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label249:
      i = Color.parseColor(localaftp.bFA);
      if (TextUtils.isEmpty(localaftp.bFB)) {
        paramView.textView.setBackgroundDrawable(e(a(0.2F, i), a(0.2F, i)));
      } else {
        paramView.textView.setBackgroundDrawable(e(Color.parseColor(localaftp.bFB), Color.parseColor(localaftp.bFB)));
      }
    }
  }
  
  public void kA(List<aftp> paramList)
  {
    this.Az.addAll(paramList);
  }
  
  public class a
  {
    int position;
    TextView textView;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvb
 * JD-Core Version:    0.7.0.1
 */