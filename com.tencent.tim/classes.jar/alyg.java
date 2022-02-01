import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alyg
{
  protected View Gt;
  private int OC;
  protected Context V;
  protected alyg.b a;
  protected CharSequence ac;
  protected final ausj an;
  private int bgc;
  public int bgd;
  protected boolean bpu;
  public ElasticHorScrView c;
  public ElasticHorScrView d;
  protected int dAc;
  private int dAd;
  private int dAe;
  private int dAf;
  protected int dAg;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] e;
  protected AdapterView.OnItemClickListener j;
  protected TextView mTitleTv;
  private boolean zO = true;
  
  public alyg(Context paramContext)
  {
    this.V = paramContext;
    this.an = ((ausj)auss.a(this.V, null));
    paramContext = this.V.getResources();
    this.OC = paramContext.getDimensionPixelSize(2131296957);
    this.dAd = this.OC;
    this.dAe = paramContext.getDimensionPixelOffset(2131296959);
    this.dAf = paramContext.getDimensionPixelOffset(2131296960);
    this.a = new alyg.b();
    int i = (paramContext.getDisplayMetrics().widthPixels - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
    setIconMarginLeftRight(i);
    setRowMarginLeftRight((int)(i * 6 / 5.5F));
  }
  
  private static String G(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private String q(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  @TargetApi(9)
  protected View L()
  {
    View localView = View.inflate(this.V, 2131559037, null);
    this.a.B((RelativeLayout)localView.findViewById(2131362258));
    this.mTitleTv = ((TextView)localView.findViewById(2131362010));
    Object localObject2;
    Object localObject1;
    if (this.zO)
    {
      this.mTitleTv.setVisibility(0);
      if (this.ac != null) {
        this.mTitleTv.setText(this.ac);
      }
      this.c = ((ElasticHorScrView)localView.findViewById(2131377768));
      this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label376;
      }
      localObject1 = localObject2[0];
      label122:
      if (!((List)localObject1).isEmpty()) {
        break label893;
      }
    }
    label147:
    label336:
    label376:
    label888:
    label893:
    for (int k = 0;; k = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label888;
        }
      }
      for (int m = 0;; m = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.V.getResources().getDimensionPixelSize(2131299551));
        Object localObject4 = new StaticLayout(G(q((List)localObject1), 6), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        Object localObject5 = new StaticLayout(G(q((List)localObject2), 6), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        localObject3 = localObject5;
        if (((StaticLayout)localObject4).getHeight() >= ((StaticLayout)localObject5).getHeight()) {
          localObject3 = localObject4;
        }
        int n = this.V.getResources().getDimensionPixelOffset(2131296956);
        int i;
        if (k != 0)
        {
          localObject4 = (GridView)localView.findViewById(2131368140);
          if (Build.VERSION.SDK_INT >= 9) {
            this.c.setOverScrollMode(2);
          }
          localObject5 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject5).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject5).next()).visibility != 0) {
              break label885;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label336;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label122;
          localObject2 = new ArrayList(0);
          break label147;
          int i1 = this.dAc + getIconWidth() + this.dAc;
          ((GridView)localObject4).setColumnWidth(i1);
          ((GridView)localObject4).setNumColumns(i);
          localObject5 = ((GridView)localObject4).getLayoutParams();
          ((GridView)localObject4).setPadding(this.dAg, ((GridView)localObject4).getPaddingTop(), this.dAg, ((GridView)localObject4).getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject5).width = (i1 * i + this.dAg + this.dAg);
          this.bgd = ((ViewGroup.LayoutParams)localObject5).width;
          ((ViewGroup.LayoutParams)localObject5).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + n);
          ((GridView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((GridView)localObject4).setAdapter(new alyg.a(this.V, (List)localObject1));
          ((GridView)localObject4).setSelector(new ColorDrawable(0));
          ((GridView)localObject4).setOnItemClickListener(this.j);
          if (m != 0)
          {
            localObject1 = (GridView)localView.findViewById(2131368141);
            if (Build.VERSION.SDK_INT >= 9) {
              this.d.setOverScrollMode(2);
            }
            ((GridView)localObject1).setSmoothScrollbarEnabled(false);
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject4).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
                break label882;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            i1 = this.dAc + getIconWidth() + this.dAc;
            ((GridView)localObject1).setColumnWidth(i1);
            ((GridView)localObject1).setNumColumns(i);
            localObject4 = ((GridView)localObject1).getLayoutParams();
            ((GridView)localObject1).setPadding(this.dAg, ((GridView)localObject1).getPaddingTop(), this.dAg, ((GridView)localObject1).getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject4).width = (i1 * i + this.dAg + this.dAg);
            this.bgc = ((ViewGroup.LayoutParams)localObject4).width;
            ((ViewGroup.LayoutParams)localObject4).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + n);
            ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((GridView)localObject1).setNumColumns(i);
            ((GridView)localObject1).setAdapter(new alyg.a(this.V, (List)localObject2));
            ((GridView)localObject1).setSelector(new ColorDrawable(0));
            ((GridView)localObject1).setOnItemClickListener(this.j);
            localObject1 = (TextView)localView.findViewById(2131362002);
            ((TextView)localObject1).setText(2131721058);
            ((TextView)localObject1).setOnClickListener(new alyh(this));
            if (k == 0) {
              this.c.setVisibility(8);
            }
            if (m == 0) {
              this.d.setVisibility(8);
            }
            localView.post(new ShareActionSheet.2(this));
            return localView;
          }
        }
      }
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (this.e != null) {
      return this.e;
    }
    return (List[])new ArrayList[0];
  }
  
  public ausj getActionSheet()
  {
    return this.an;
  }
  
  public int getIconWidth()
  {
    return this.OC;
  }
  
  public void hideTitle()
  {
    this.zO = false;
    if ((this.mTitleTv != null) && (this.mTitleTv.getVisibility() != 8)) {
      this.mTitleTv.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    return this.an.isShowing();
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.e = paramArrayOfList;
    this.bpu = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.ac = paramCharSequence;
    if (this.mTitleTv != null) {
      this.mTitleTv.setText(this.ac);
    }
  }
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.dAc = paramInt;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.j = paramOnItemClickListener;
    this.bpu = true;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.dAg = paramInt;
  }
  
  public void show()
  {
    if ((this.Gt == null) || (this.bpu)) {
      this.Gt = L();
    }
    this.an.setActionContentView(this.Gt, null);
    try
    {
      if (!isShowing()) {
        this.an.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  static class a
    extends BaseAdapter
  {
    private int OE;
    private alyg.a.a a;
    private LayoutInflater inflater;
    private List<ShareActionSheetBuilder.ActionSheetItem> items;
    private Resources mRes;
    
    public a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
    {
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
    }
    
    public ShareActionSheetBuilder.ActionSheetItem c(int paramInt)
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.items == null) || (paramInt < 0))
      {
        localActionSheetItem = null;
        return localActionSheetItem;
      }
      int j = -1;
      int i = 0;
      for (;;)
      {
        if (i >= this.items.size()) {
          break label89;
        }
        localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          break;
        }
        i += 1;
        j = k;
      }
      label89:
      return null;
    }
    
    public int getCount()
    {
      if (this.items == null) {
        return 0;
      }
      Iterator localIterator = this.items.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
        if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
          break label60;
        }
        i += 1;
      }
      label60:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (this.mRes == null) {
        this.mRes = paramViewGroup.getContext().getResources();
      }
      if (this.OE == 0) {
        this.OE = ((int)this.mRes.getDimension(2131296957));
      }
      if (this.a == null) {
        this.a = new alyg.a.a(paramViewGroup.getContext());
      }
      View localView;
      if (paramView == null)
      {
        localView = this.inflater.inflate(2131559035, paramViewGroup, false);
        paramView = new ShareActionSheetBuilder.b();
        paramView.vIcon = ((ImageView)localView.findViewById(2131378172));
        paramView.vLabel = ((TextView)localView.findViewById(2131378173));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.b = c(paramInt);
        if (paramView.b != null) {
          break;
        }
        QLog.e("ShareActionSheet", 2, "ShareActionSheet.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ShareActionSheetBuilder.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
      localView.setId(paramView.b.id);
      paramView.vLabel.setText(alyg.au(paramView.b.label, 6));
      int i = -8947849;
      Object localObject = paramView.vLabel;
      if (paramView.b.enable)
      {
        label256:
        ((TextView)localObject).setTextColor(i);
        if (!paramView.b.iconNeedBg) {
          break label493;
        }
        if (paramView.b.iconDrawable == null) {
          break label434;
        }
        localObject = paramView.b.iconDrawable;
        label292:
        i = ((Drawable)localObject).getIntrinsicWidth();
        int k = ((Drawable)localObject).getIntrinsicHeight();
        if (this.OE <= i) {
          break label453;
        }
        i = (int)((this.OE - i) / 2.0F);
        label328:
        if (this.OE > k) {
          j = (int)((this.OE - k) / 2.0F);
        }
        localObject = this.a.a((Drawable)localObject, i, j);
        if (!paramView.b.enable) {
          break label459;
        }
        Drawable localDrawable = alyg.a.a.a(this.a, (Drawable)localObject);
        localObject = this.a.a((Drawable)localObject, localDrawable);
        paramView.vIcon.setImageDrawable((Drawable)localObject);
        label408:
        if (Build.VERSION.SDK_INT < 16) {
          break label482;
        }
        paramView.vIcon.setBackground(null);
      }
      for (;;)
      {
        break;
        i = 2138535799;
        break label256;
        label434:
        localObject = this.mRes.getDrawable(paramView.b.icon);
        break label292;
        label453:
        i = 0;
        break label328;
        label459:
        localObject = alyg.a.a.b(this.a, (Drawable)localObject);
        paramView.vIcon.setImageDrawable((Drawable)localObject);
        break label408;
        label482:
        paramView.vIcon.setBackgroundDrawable(null);
        continue;
        label493:
        paramView.vIcon.setImageResource(2130837636);
        if (paramView.b.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            paramView.vIcon.setBackground(paramView.b.iconDrawable);
          } else {
            paramView.vIcon.setBackgroundDrawable(paramView.b.iconDrawable);
          }
        }
        else {
          paramView.vIcon.setBackgroundResource(paramView.b.icon);
        }
      }
    }
    
    static class a
    {
      private final Drawable cy;
      private final Drawable cz;
      
      a(Context paramContext)
      {
        paramContext = paramContext.getResources();
        this.cy = paramContext.getDrawable(2130837635);
        this.cz = paramContext.getDrawable(2130837639);
      }
      
      private Drawable A(Drawable paramDrawable)
      {
        return new LayerDrawable(new Drawable[] { paramDrawable, this.cz });
      }
      
      private Drawable B(Drawable paramDrawable)
      {
        paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
        paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
        return paramDrawable;
      }
      
      Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        paramDrawable = new LayerDrawable(new Drawable[] { this.cy, paramDrawable });
        paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
        return paramDrawable;
      }
      
      StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
      {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
        localStateListDrawable.addState(new int[0], paramDrawable1);
        return localStateListDrawable;
      }
    }
  }
  
  public static class b
  {
    private View Gu;
    private ViewGroup ew;
    
    private void R(ViewGroup paramViewGroup)
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeAllViews();
      }
    }
    
    private void bind()
    {
      if ((this.ew != null) && (this.Gu != null)) {
        this.ew.addView(this.Gu);
      }
    }
    
    public void B(RelativeLayout paramRelativeLayout)
    {
      R(this.ew);
      R(paramRelativeLayout);
      this.ew = paramRelativeLayout;
      bind();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyg
 * JD-Core Version:    0.7.0.1
 */