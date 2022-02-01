import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zjl
{
  private QQBlurView a;
  private View av;
  private ahct jdField_b_of_type_Ahct = new zjn(this);
  private zjl.a jdField_b_of_type_Zjl$a;
  private ImageView fg;
  private ImageView lW;
  private Context mContext;
  private View mK;
  private View vb;
  private ImageView vm;
  private ImageView vp;
  private ImageView vq;
  private View yI;
  
  public zjl(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.yI = paramViewGroup;
    this.av = LayoutInflater.from(paramContext).inflate(2131561000, null, false);
    Object localObject = paramViewGroup;
    if (!(paramViewGroup instanceof RelativeLayout))
    {
      localObject = new RelativeLayout(paramContext);
      paramViewGroup.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
    }
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(12);
    ((ViewGroup)localObject).addView(this.av, paramContext);
    this.vm = ((ImageView)this.av.findViewById(2131366196));
    this.fg = ((ImageView)this.av.findViewById(2131366195));
    this.vp = ((ImageView)this.av.findViewById(2131366203));
    this.lW = ((ImageView)this.av.findViewById(2131366197));
    this.vq = ((ImageView)this.av.findViewById(2131366194));
    this.vb = this.av.findViewById(2131366191);
    this.vm.setVisibility(8);
    this.fg.setVisibility(8);
    this.vp.setVisibility(8);
    this.lW.setVisibility(8);
    this.vq.setVisibility(8);
    this.vm.setOnClickListener(this.jdField_b_of_type_Ahct);
    this.fg.setOnClickListener(this.jdField_b_of_type_Ahct);
    this.vp.setOnClickListener(this.jdField_b_of_type_Ahct);
    this.lW.setOnClickListener(this.jdField_b_of_type_Ahct);
    this.vq.setOnClickListener(this.jdField_b_of_type_Ahct);
    dismiss();
  }
  
  private boolean Vp()
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      ahav.JI(this.mContext.getString(2131694663));
      return false;
    }
    return true;
  }
  
  private void fP(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView);
    for (;;)
    {
      if (!localArrayList.isEmpty())
      {
        paramView = (View)localArrayList.remove(0);
        if ((paramView instanceof ListView)) {
          this.mK = paramView;
        }
      }
      else
      {
        return;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.add(paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public void BH(boolean paramBoolean)
  {
    aW(1, paramBoolean);
    aW(2, paramBoolean);
    aW(3, paramBoolean);
    aW(4, paramBoolean);
    aW(5, paramBoolean);
  }
  
  public void a(zjl.a parama)
  {
    this.jdField_b_of_type_Zjl$a = parama;
  }
  
  @TargetApi(19)
  protected void aH()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
    if (this.mK == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.vb.setBackgroundResource(2130845100);
      return;
    }
    this.a = ((QQBlurView)this.av.findViewById(2131381443));
    this.a.setVisibility(0);
    this.a.iD(this.mK);
    this.a.iE(this.a);
    this.a.ae(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.a.YI(0);
    this.a.YJ(-1);
    this.a.bg(8.0F);
    this.a.YK(8);
    this.a.a(new zjm(this));
    this.a.onCreate();
    this.a.onResume();
  }
  
  public void aW(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.fg.setEnabled(paramBoolean);
      return;
    case 2: 
      this.lW.setEnabled(paramBoolean);
      return;
    case 3: 
      this.vp.setEnabled(paramBoolean);
      return;
    case 4: 
      this.vq.setEnabled(paramBoolean);
      return;
    }
    this.vm.setEnabled(paramBoolean);
  }
  
  public void dismiss()
  {
    this.av.setVisibility(8);
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
  
  public void hk(List<Integer> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        default: 
          break;
        case 1: 
          this.fg.setVisibility(0);
          break;
        case 2: 
          this.lW.setVisibility(0);
          break;
        case 3: 
          this.vp.setVisibility(0);
          break;
        case 4: 
          this.vq.setVisibility(0);
          break;
        case 5: 
          this.vm.setVisibility(0);
        }
      }
    }
  }
  
  public void show()
  {
    if (this.mK == null)
    {
      fP(this.yI);
      if (this.mK == null) {
        this.mK = this.av;
      }
    }
    this.av.setVisibility(0);
    aH();
  }
  
  public int yi()
  {
    return wja.dp2px(50.0F, this.mContext.getResources());
  }
  
  public static abstract interface a
  {
    public abstract void Ff(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjl
 * JD-Core Version:    0.7.0.1
 */