import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.tim.todo.widget.StrikeThruTextView;
import java.util.ArrayList;
import java.util.List;

public abstract class aupf
{
  public static atiw a;
  private static int[] aq = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299263), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299264) };
  public static atiw b;
  public static atiw d;
  protected static boolean isAnimating;
  public static atiw m = new atiw(0, 2131379966, 2131721217, 2130839770);
  private aupf.b a;
  protected BaseAdapter adapter;
  protected QQAppInterface app;
  protected auve b;
  protected Context context;
  private View.OnClickListener fR = new auph(this);
  
  static
  {
    jdField_b_of_type_Atiw = new atiw(0, 2131364767, 2131691606, 2130839769);
    d = new atiw(0, 2131364768, 2131691631, 2130839768);
    jdField_a_of_type_Atiw = new atiw(0, 2131364769, 2131691636, 2130839768);
  }
  
  public aupf(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.adapter = paramBaseAdapter;
  }
  
  private auve a()
  {
    if (this.jdField_b_of_type_Auve != null) {
      return this.jdField_b_of_type_Auve;
    }
    ArrayList localArrayList = new ArrayList(gt());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Atiw);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      atiw localatiw = (atiw)localArrayList.get(i);
      arrayOfInt1[i] = localatiw.hF();
      arrayOfInt2[i] = localatiw.KB();
      arrayOfInt3[i] = localatiw.KC();
      arrayOfInt4[i] = localatiw.KA();
      i += 1;
    }
    this.jdField_b_of_type_Auve = new aupg(this, localArrayList.size(), 2, aq, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_b_of_type_Auve;
  }
  
  public final View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    auve localauve = a();
    if (paramView == null)
    {
      paramView = new auvd.a();
      paramViewGroup = b(paramInt, paramObject, paramView.Lz, paramViewGroup, paramOnClickListener, paramOnLongClickListener);
      paramOnClickListener = localauve.a(this.context, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localauve.a(this.context, paramView, paramInt, paramObject, paramViewGroup, this.fR);
      if ((paramObject instanceof TodoInfo)) {
        b((ViewGroup)paramView, (TodoInfo)paramObject);
      }
      return paramView;
      auvd.a locala = (auvd.a)paramView.getTag();
      b(paramInt, paramObject, locala.Lz, paramViewGroup, paramOnClickListener, paramOnLongClickListener);
      paramViewGroup = locala;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, TodoInfo paramTodoInfo)
  {
    isAnimating = true;
    int i = paramViewGroup.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new aupi(this, paramViewGroup, i));
    localValueAnimator.addListener(new aupj(this, paramTodoInfo));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  void a(aupf.a parama)
  {
    if (!TextUtils.isEmpty(parama.d.content))
    {
      localObject = parama.d.content.trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        parama.a.setText((CharSequence)localObject);
      }
    }
    Object localObject = aupe.a(parama.d, this.app, this.context);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      parama.afD.setText((CharSequence)localObject);
      parama.afD.setVisibility(0);
      if (parama.d.remindTime == 0L) {
        break label217;
      }
      parama.time.setText(aupe.cm(parama.d.remindTime));
      parama.time.setVisibility(0);
    }
    for (;;)
    {
      localObject = (ViewGroup.MarginLayoutParams)parama.b.getLayoutParams();
      if ((parama.time.getVisibility() != 8) || (parama.afD.getVisibility() != 8)) {
        break label229;
      }
      ((View)parama.a.getParent()).setTranslationY((int)(this.context.getResources().getDisplayMetrics().density * 18.0F));
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.context.getResources().getDisplayMetrics().density * 18.0F));
      return;
      parama.afD.setVisibility(8);
      break;
      label217:
      parama.time.setVisibility(8);
    }
    label229:
    ((View)parama.a.getParent()).setTranslationY(0.0F);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
  }
  
  public void a(aupf.b paramb)
  {
    this.jdField_a_of_type_Aupf$b = paramb;
  }
  
  public abstract View b(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener);
  
  public abstract List<atiw> b(Object paramObject);
  
  protected void b(ViewGroup paramViewGroup, TodoInfo paramTodoInfo)
  {
    auoi localauoi = (auoi)this.app.getManager(376);
    if ((!TextUtils.isEmpty(localauoi.Ff())) && (localauoi.Ff().equals(paramTodoInfo.todoId)))
    {
      localauoi.Zu("");
      int i = paramViewGroup.getMeasuredHeight();
      if (i > 0)
      {
        paramTodoInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        paramTodoInfo.addUpdateListener(new aupk(this, paramViewGroup, i));
        paramTodoInfo.setDuration(300L);
        paramTodoInfo.start();
      }
    }
  }
  
  public abstract List<atiw> gt();
  
  public class a
  {
    public StrikeThruTextView a;
    public RelativeLayout aN;
    public TextView afD;
    public LottieAnimationView b;
    public TodoInfo d;
    public View divider;
    public TextView time;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void b(int paramInt, TodoInfo paramTodoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupf
 * JD-Core Version:    0.7.0.1
 */