import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class rae
  extends BaseAdapter
{
  private rae.a a;
  private boolean aGl;
  private boolean aGm;
  private String azk;
  private String azl = "来自微视APP";
  private List<rmw.a> cj;
  private final Context mContext;
  private int mMode = 1;
  private final List<rmw.a> oi;
  
  public rae(Context paramContext)
  {
    this.mContext = paramContext;
    this.oi = new ArrayList();
    this.cj = new ArrayList();
  }
  
  private static String a(rmw.a parama)
  {
    String str = parama.name;
    parama = str;
    if (aqmr.getWordCount(str) > 20) {
      parama = aqmr.substring(str, 0, 20) + "...";
    }
    return "#" + parama;
  }
  
  private static void o(TextView paramTextView)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if ("2040".equals(str))
    {
      paramTextView.setBackgroundResource(2130847715);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130847716);
      return;
    }
    paramTextView.setBackgroundResource(2130847717);
  }
  
  private void rn(boolean paramBoolean)
  {
    int n = 0;
    this.cj.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(rpq.dip2px(this.mContext, 12.0F));
    int i1 = rpq.getWindowScreenWidth(this.mContext) - rpq.dip2px(this.mContext, 10.0F) * 2;
    int i2 = rpq.dip2px(this.mContext, 23.0F);
    float f1;
    int k;
    label103:
    int j;
    int i;
    float f2;
    int m;
    if (this.aGm)
    {
      f1 = localTextPaint.measureText(this.azl) + rpq.dip2px(this.mContext, 18.0F);
      if (!paramBoolean) {
        break label319;
      }
      k = 2;
      j = 1;
      i = 0;
      if (i >= this.oi.size()) {
        break label475;
      }
      f2 = localTextPaint.measureText(a((rmw.a)this.oi.get(i))) + rpq.dip2px(this.mContext, 18.0F);
      if (f1 + f2 <= i1) {
        break label432;
      }
      m = j + 1;
      if (m <= k) {
        break label417;
      }
      if (!paramBoolean) {
        break label326;
      }
      if (i2 + f1 <= i1) {
        break label468;
      }
      i -= 1;
      j = m;
    }
    for (;;)
    {
      label206:
      if (j <= k)
      {
        i = this.oi.size();
        this.mMode = 1;
        j = n;
      }
      for (;;)
      {
        if (j >= i) {
          break label467;
        }
        this.cj.add(this.oi.get(j));
        j += 1;
        continue;
        if (!TextUtils.isEmpty(this.azk))
        {
          this.aGl = true;
          f1 = localTextPaint.measureText(this.azk) + rpq.dip2px(this.mContext, 18.0F);
          break;
        }
        this.aGl = false;
        f1 = 0.0F;
        break;
        label319:
        k = 6;
        break label103;
        label326:
        i2 = this.oi.size();
        j = i;
        if (localTextPaint.measureText(acfp.m(2131715119) + (i2 - i) + acfp.m(2131715122)) + rpq.dip2px(this.mContext, 18.0F) + f1 > i1) {
          j = i - 1;
        }
        i = j;
        j = m;
        break label206;
        label417:
        f1 = f2;
        j = m;
        for (;;)
        {
          i += 1;
          break;
          label432:
          f1 += f2;
        }
        if (paramBoolean)
        {
          this.mMode = 2;
          j = n;
        }
        else
        {
          this.mMode = 3;
          j = n;
        }
      }
      label467:
      return;
      label468:
      j = m;
      continue;
      label475:
      i = 0;
    }
  }
  
  public void a(List<rmw.a> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if (paramList == null)
    {
      ram.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    ram.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString1, Boolean.valueOf(paramBoolean1), paramList);
    this.oi.clear();
    this.cj.clear();
    this.oi.addAll(paramList);
    this.azk = paramString1;
    this.aGm = paramBoolean2;
    this.azl = paramString2;
    rn(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public void a(rae.a parama)
  {
    this.a = parama;
  }
  
  public int getCount()
  {
    if (this.mMode == 1)
    {
      if ((this.aGm) || (this.aGl)) {
        return this.cj.size() + 1;
      }
      return this.cj.size();
    }
    if ((this.aGm) || (this.aGl)) {
      return this.cj.size() + 2;
    }
    return this.cj.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.mMode == 1) {
      if (((this.aGm) || (this.aGl)) && (paramInt == 0)) {
        if (!this.aGm) {}
      }
    }
    label95:
    label116:
    do
    {
      do
      {
        return 4;
        return 3;
        return 0;
        if (this.mMode != 2) {
          break label116;
        }
        if ((!this.aGm) && (!this.aGl)) {
          break label95;
        }
        if (paramInt != 0) {
          break;
        }
      } while (this.aGm);
      return 3;
      if ((paramInt > 0) && (paramInt <= this.cj.size())) {
        return 0;
      }
      return 1;
      if ((paramInt >= 0) && (paramInt < this.cj.size())) {
        return 0;
      }
      return 1;
      if (this.mMode != 3) {
        break label193;
      }
      if ((!this.aGm) && (!this.aGl)) {
        break label172;
      }
      if (paramInt != 0) {
        break;
      }
    } while (this.aGm);
    return 3;
    if ((paramInt > 0) && (paramInt <= this.cj.size())) {
      return 0;
    }
    return 2;
    label172:
    if ((paramInt >= 0) && (paramInt < this.cj.size())) {
      return 0;
    }
    return 2;
    label193:
    ram.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(this.mMode) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i == 1)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131561981, null);
      ((ImageView)localView.findViewById(2131371943)).setOnClickListener(new raf(this));
      localView.setTag(2131375263, Integer.valueOf(i));
    }
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (i == 2)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2131561979, null);
        localObject1 = (TextView)localView.findViewById(2131368529);
        int j = this.oi.size();
        int k = this.cj.size();
        ((TextView)localObject1).setText(acfp.m(2131715120) + (j - k) + acfp.m(2131715121));
        localView.setTag(2131375263, Integer.valueOf(i));
      }
      else if (i == 3)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2131561977, null);
        localObject1 = (TextView)localView.findViewById(2131379178);
        ((TextView)localObject1).setText(this.azk);
        ((TextView)localObject1).setOnClickListener(new rag(this));
        o((TextView)localObject1);
        localView.setTag(2131375263, Integer.valueOf(i));
      }
      else
      {
        if (i != 4) {
          break;
        }
        localView = LayoutInflater.from(this.mContext).inflate(2131561977, null);
        localObject1 = (TextView)localView.findViewById(2131379178);
        float f = ((TextView)localObject1).getPaint().measureText(this.azl);
        Object localObject2 = Shader.TileMode.CLAMP;
        localObject2 = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -15289095, -8753934, -1161312 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2);
        ((TextView)localObject1).getPaint().setShader((Shader)localObject2);
        ((TextView)localObject1).setText(this.azl);
        ((TextView)localObject1).setOnClickListener(new rah(this));
        o((TextView)localObject1);
        localView.setTag(2131375263, Integer.valueOf(i));
      }
    }
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131561977, null);
      localObject1 = new rae.b(localView);
      localView.setTag(localObject1);
      label471:
      if ((!this.aGm) && (!this.aGl)) {
        break label545;
      }
    }
    label545:
    for (paramView = (rmw.a)this.cj.get(paramInt - 1);; paramView = (rmw.a)this.cj.get(paramInt))
    {
      ((rae.b)localObject1).a(paramView, this.a);
      localView.setTag(2131375263, Integer.valueOf(i));
      paramView = localView;
      break;
      localObject1 = (rae.b)paramView.getTag();
      localView = paramView;
      break label471;
    }
  }
  
  public int getViewTypeCount()
  {
    int i = 2;
    int j = 1;
    if (this.mMode == 1)
    {
      if (!this.aGm)
      {
        i = j;
        if (!this.aGl) {}
      }
      else
      {
        i = 2;
      }
      return i;
    }
    if ((this.aGm) || (this.aGl)) {
      i = 3;
    }
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void a(rmw.a parama);
    
    public abstract void bms();
    
    public abstract void bmt();
    
    public abstract void onMoreClick();
  }
  
  static class b
  {
    public TextView we;
    
    public b(View paramView)
    {
      this.we = ((TextView)paramView.findViewById(2131379178));
    }
    
    public void a(rmw.a parama, rae.a parama1)
    {
      if (TextUtils.isEmpty(parama.name))
      {
        this.we.setVisibility(8);
        return;
      }
      this.we.setVisibility(0);
      this.we.setText(rae.b(parama));
      rae.p(this.we);
      this.we.setOnClickListener(new rai(this, parama1, parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rae
 * JD-Core Version:    0.7.0.1
 */