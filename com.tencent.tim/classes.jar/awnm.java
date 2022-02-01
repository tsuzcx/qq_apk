import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class awnm
  extends PopupWindow
{
  private static final Drawable BACKGROUND_DRAWABLE = new ColorDrawable(2130706432);
  private static final SpringConfig jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(60.0D, 8.0D);
  private static final Drawable bF = getDrawable(2130851915);
  private static final Drawable bG = getDrawable(2130851916);
  private boolean ME;
  private boolean MG = true;
  private boolean MH = true;
  private awnm.a jdField_a_of_type_Awnm$a;
  private int ahW;
  private View.OnKeyListener c = new awnp(this);
  public ArrayList<awnm.b> ed;
  private View.OnTouchListener f = new awnq(this);
  private float fq = 0.1F;
  private float ft = 0.0F;
  private Spring g;
  private RelativeLayout i;
  public Activity mActivity;
  private LayoutInflater mInflater;
  private ListView mListView;
  private int mListViewHeight;
  private int mPivotX;
  private int mPivotY;
  
  public awnm(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    onCreate();
  }
  
  private void ajH()
  {
    super.dismiss();
  }
  
  public static Drawable getDrawable(int paramInt)
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private int getTitleBarHeight()
  {
    if (getActivity() == null) {
      return 0;
    }
    Rect localRect = new Rect();
    getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > 0) {
      return localRect.top;
    }
    return aqnm.getScreenHeight() - localRect.height();
  }
  
  public static double mapValueFromRangeToRange(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    return (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2) * (paramDouble5 - paramDouble4) + paramDouble4;
  }
  
  private void onCreate()
  {
    this.ed = new ArrayList();
    setContentView(2131562871);
    setFocusable(true);
    setBackgroundDrawable(null);
    setWidth(-1);
    setHeight(-1);
    this.g = SpringSystem.create().createSpring().setSpringConfig(jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig).addListener(new awnn(this));
    this.jdField_a_of_type_Awnm$a = new awnm.a(this.mActivity);
    this.mListView = ((ListView)this.i.findViewById(2131366148));
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setHeaderDividersEnabled(false);
    this.mListView.setAdapter(this.jdField_a_of_type_Awnm$a);
    this.mListView.setOnTouchListener(new awno(this));
  }
  
  private void render()
  {
    if (this.g == null) {
      return;
    }
    float f1 = (float)this.g.getCurrentValue();
    float f2 = (float)mapValueFromRangeToRange(f1, 0.0D, 1.0D, 0.0D, 1.0D);
    if (f1 < 0.0F) {
      this.ME = true;
    }
    float f3;
    if (this.ME)
    {
      f1 = (float)this.g.getEndValue();
      f3 = (float)this.g.getEndValue();
    }
    for (;;)
    {
      setAlpha(this.i, f1);
      setAlpha(this.mListView, 1.0F);
      aqnm.setScaleX(this.mListView, f3);
      aqnm.setScaleY(this.mListView, f3);
      if (this.MH)
      {
        aqnm.setPivotY(this.mListView, 0.0F);
        aqnm.setPivotX(this.mListView, this.mPivotX);
      }
      for (;;)
      {
        if ((this.MG) || (f3 != 0.0F)) {
          break label221;
        }
        ajH();
        return;
        if (!this.MG) {
          break label223;
        }
        float f4 = this.ft;
        this.ft += this.fq;
        f1 = f4;
        f3 = f2;
        if (this.ft <= 1.0F) {
          break;
        }
        this.ft = 1.0F;
        f1 = f4;
        f3 = f2;
        break;
        aqnm.setPivotY(this.mListView, this.mPivotY);
        aqnm.setPivotX(this.mListView, this.mPivotX);
      }
      label221:
      break;
      label223:
      f1 = f2;
      f3 = f2;
    }
  }
  
  private void setAlpha(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  private void setContentView(int paramInt)
  {
    Activity localActivity;
    if (this.mInflater == null)
    {
      localActivity = getActivity();
      if (localActivity != null) {}
    }
    do
    {
      return;
      this.mInflater = LayoutInflater.from(localActivity);
      if (this.i != null) {
        break;
      }
      this.i = ((RelativeLayout)this.mInflater.inflate(paramInt, null));
    } while (this.i == null);
    setAlpha(this.i, 0.0F);
    this.i.setFocusable(true);
    this.i.setFocusableInTouchMode(true);
    this.i.setOnKeyListener(this.c);
    this.i.setOnTouchListener(this.f);
    aqnm.setViewBackground(this.i, BACKGROUND_DRAWABLE);
    super.setContentView(this.i);
  }
  
  public boolean J(int paramInt1, int paramInt2)
  {
    if ((this.i == null) || (this.mListView == null)) {
      return false;
    }
    paramInt1 = aqnm.getScreenWidth() - this.i.getPaddingRight() * 2;
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mListView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, this.mListViewHeight);
    }
    int j = ka();
    localLayoutParams1.width = paramInt1;
    localLayoutParams1.height = this.mListViewHeight;
    localLayoutParams1.topMargin = (paramInt2 - j - aqnm.dpToPx(5.0F));
    this.mListView.setLayoutParams(localLayoutParams1);
    this.mPivotY = this.mListViewHeight;
    this.mPivotX = (paramInt1 - (this.ahW / 2 - this.i.getPaddingRight()));
    return true;
  }
  
  public void a(awnm.b paramb)
  {
    if ((this.ed != null) && (paramb != null)) {
      this.ed.add(paramb);
    }
  }
  
  public void aiK()
  {
    dismiss();
  }
  
  public void ajI()
  {
    if (isShowing()) {
      return;
    }
    this.ft = 0.0F;
    this.ME = false;
    this.MG = true;
    this.MH = false;
    setAlpha(this.i, 0.0F);
    aqnm.setViewBackground(this.mListView, bF);
    super.showAtLocation(getRootView(), 17, 0, 0);
    handleClick();
  }
  
  public void ajJ()
  {
    if (isShowing()) {
      return;
    }
    this.ft = 0.0F;
    this.ME = false;
    this.MG = true;
    this.MH = true;
    setAlpha(this.i, 0.0F);
    aqnm.setViewBackground(this.mListView, bG);
    if (this.mListView != null) {
      this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop() + aqnm.dpToPx(9.0F), this.mListView.getPaddingRight(), this.mListView.getPaddingBottom());
    }
    super.showAtLocation(getRootView(), 17, 0, 0);
    handleClick();
  }
  
  public void ajM()
  {
    int j = 0;
    int k = 0;
    while (j < this.jdField_a_of_type_Awnm$a.getCount())
    {
      View localView = this.jdField_a_of_type_Awnm$a.getView(j, null, this.mListView);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      k += localView.getMeasuredHeight();
      j += 1;
    }
    this.mListViewHeight = (aqnm.dpToPx(9.0F) + k);
  }
  
  public void dismiss()
  {
    this.MG = false;
    handleClick();
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public View getRootView()
  {
    return getActivity().findViewById(16908290).getRootView();
  }
  
  public void handleClick()
  {
    if (this.g == null) {}
    while (this.g.getCurrentValue() != this.g.getEndValue()) {
      return;
    }
    if (this.g.getEndValue() == 0.0D)
    {
      this.g.setEndValue(1.0D);
      return;
    }
    this.g.setEndValue(0.0D);
  }
  
  public int ka()
  {
    int j;
    if (this.i.getHeight() > 0)
    {
      j = aqnm.getScreenHeight() - this.i.getHeight();
      if (j > aqnm.dpToPx(25.0F)) {}
    }
    int k;
    do
    {
      return j;
      k = getTitleBarHeight();
      j = k;
    } while (k > 0);
    return aqnm.dpToPx(25.0F);
  }
  
  public int kb()
  {
    return this.mListViewHeight;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if ((this.mListView != null) && (paramOnItemClickListener != null)) {
      this.mListView.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private Context context;
    private LayoutInflater mInflater;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private View S()
    {
      return getInflater().inflate(2131563328, null);
    }
    
    private void a(awnm.b paramb, awnm.c paramc)
    {
      paramb = URLDrawable.getDrawable(paramb.actionData, null);
      paramc.Fa.setImageDrawable(paramb);
      paramc.mi.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      paramc.Fa.setVisibility(0);
    }
    
    private LayoutInflater getInflater()
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(this.context);
      }
      return this.mInflater;
    }
    
    public int getCount()
    {
      if (awnm.this.ed != null) {
        return awnm.this.ed.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (awnm.this.ed != null) {
        return awnm.this.ed.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      if (awnm.this.ed != null) {
        return awnm.this.ed.size();
      }
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        paramView = new awnm.c(awnm.this);
        localView = S();
        paramView.mi = ((TextView)localView.findViewById(2131371291));
        paramView.Fa = ((ImageView)localView.findViewById(2131370365));
        paramView.LN = localView.findViewById(2131366147);
        localView.setTag(paramView);
        if (paramView != null) {
          break label107;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        Object localObject = (awnm.c)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label107:
        if (getCount() <= 1)
        {
          paramView.LN.setVisibility(8);
          localView.setBackgroundResource(2130850149);
        }
        for (;;)
        {
          localObject = (awnm.b)getItem(paramInt);
          if (localObject != null) {
            break label218;
          }
          break;
          if (paramInt <= 0)
          {
            paramView.LN.setVisibility(0);
            localView.setBackgroundResource(2130850149);
          }
          else if (paramInt < getCount() - 1)
          {
            paramView.LN.setVisibility(0);
            localView.setBackgroundResource(2130850148);
          }
          else
          {
            paramView.LN.setVisibility(8);
            localView.setBackgroundResource(2130850147);
          }
        }
        label218:
        paramView.a = ((awnm.b)localObject);
        paramView.mi.setText(((awnm.b)localObject).Kn);
        if (TextUtils.isEmpty(((awnm.b)localObject).actionData)) {
          paramView.Fa.setVisibility(8);
        }
        a((awnm.b)localObject, paramView);
      }
    }
  }
  
  public static class b
  {
    public String Kn;
    public String actionData;
    public String jumpUrl;
    public int type;
  }
  
  public class c
  {
    public ImageView Fa;
    public View LN;
    public awnm.b a;
    public TextView mi;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnm
 * JD-Core Version:    0.7.0.1
 */