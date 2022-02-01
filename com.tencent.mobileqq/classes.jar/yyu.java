import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.2;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yyu
  extends SimpleItemAnimator
{
  private ArrayList<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilArrayList;
  private yza jdField_a_of_type_Yza;
  private ArrayList<RecyclerView.ViewHolder> b;
  private ArrayList<yzc> c;
  private ArrayList<yzb> d;
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> e;
  private ArrayList<ArrayList<yzc>> f;
  private ArrayList<ArrayList<yzb>> g;
  private ArrayList<RecyclerView.ViewHolder> h;
  private ArrayList<RecyclerView.ViewHolder> i;
  private ArrayList<RecyclerView.ViewHolder> j;
  private ArrayList<RecyclerView.ViewHolder> k;
  
  private void a()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = null;
    if ((paramViewHolder instanceof yys)) {
      localViewPropertyAnimatorCompat1 = ((yys)paramViewHolder).a(paramViewHolder);
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = localViewPropertyAnimatorCompat1;
    if (localViewPropertyAnimatorCompat1 == null)
    {
      localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView).setDuration(getRemoveDuration());
      localViewPropertyAnimatorCompat2.setDuration(getRemoveDuration()).alpha(0.0F);
    }
    this.j.add(paramViewHolder);
    localViewPropertyAnimatorCompat2.setListener(new yyv(this, paramViewHolder, localViewPropertyAnimatorCompat2)).start();
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if (m != 0) {
      ViewCompat.animate(localView).translationX(0.0F);
    }
    if (n != 0) {
      ViewCompat.animate(localView).translationY(0.0F);
    }
    Object localObject1 = new yzc(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null);
    if ((paramViewHolder instanceof yys)) {}
    for (localObject1 = ((yys)paramViewHolder).a((yzc)localObject1, getMoveDuration());; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ViewCompat.animate(localView).setDuration(getMoveDuration());
      }
      this.i.add(paramViewHolder);
      ((ViewPropertyAnimatorCompat)localObject2).setListener(new yyx(this, paramViewHolder, m, n, (ViewPropertyAnimatorCompat)localObject2)).start();
      return;
    }
  }
  
  private void a(List<yzb> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      yzb localyzb = (yzb)paramList.get(m);
      if ((a(localyzb, paramViewHolder)) && (localyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) && (localyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)) {
        paramList.remove(localyzb);
      }
      m -= 1;
    }
  }
  
  private void a(yzb paramyzb)
  {
    Object localObject4 = null;
    RecyclerView.ViewHolder localViewHolder = paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    Object localObject2;
    View localView;
    if (localViewHolder == null)
    {
      localObject2 = null;
      localObject1 = paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
      if (localObject1 == null) {
        break label284;
      }
      localView = ((RecyclerView.ViewHolder)localObject1).itemView;
      label31:
      if (localObject2 != null) {
        if (!(localViewHolder instanceof yys)) {
          break label289;
        }
      }
    }
    label284:
    label289:
    for (Object localObject1 = ((yys)localViewHolder).a(paramyzb, getChangeDuration(), true);; localObject1 = null)
    {
      this.k.add(paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = ViewCompat.animate((View)localObject2).setDuration(getChangeDuration());
        ((ViewPropertyAnimatorCompat)localObject3).translationX(paramyzb.c - paramyzb.jdField_a_of_type_Int);
        ((ViewPropertyAnimatorCompat)localObject3).scaleY(1.0F);
        ((ViewPropertyAnimatorCompat)localObject3).scaleX(1.0F);
        ((ViewPropertyAnimatorCompat)localObject3).translationY(paramyzb.d - paramyzb.jdField_b_of_type_Int);
        ((ViewPropertyAnimatorCompat)localObject3).alpha(0.0F);
      }
      ((ViewPropertyAnimatorCompat)localObject3).setListener(new yyy(this, paramyzb, (ViewPropertyAnimatorCompat)localObject3)).start();
      if (localView != null)
      {
        localObject1 = localObject4;
        if ((localViewHolder instanceof yys)) {
          localObject1 = ((yys)localViewHolder).a(paramyzb, getChangeDuration(), false);
        }
        this.k.add(paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = ViewCompat.animate(localView);
          ((ViewPropertyAnimatorCompat)localObject2).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setDuration(getChangeDuration()).alpha(1.0F);
        }
        ((ViewPropertyAnimatorCompat)localObject2).setListener(new yyz(this, paramyzb, (ViewPropertyAnimatorCompat)localObject2, localView)).start();
      }
      return;
      localObject2 = localViewHolder.itemView;
      break;
      localView = null;
      break label31;
    }
  }
  
  private boolean a(yzb paramyzb, RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == paramViewHolder) {
      paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    }
    for (;;)
    {
      ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
      ViewCompat.setScaleX(paramViewHolder.itemView, 1.0F);
      ViewCompat.setScaleY(paramViewHolder.itemView, 1.0F);
      ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
      ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
      dispatchChangeFinished(paramViewHolder, bool1);
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != paramViewHolder);
      paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
      bool1 = true;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.h.add(paramViewHolder);
    localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(getAddDuration()).translationX(0.0F).translationY(0.0F).setInterpolator(new DecelerateInterpolator()).setListener(new yyw(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void b(yzb paramyzb)
  {
    if (paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
      a(paramyzb, paramyzb.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    }
    if (paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
      a(paramyzb, paramyzb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  void a(List<RecyclerView.ViewHolder> paramList)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(m)).itemView).cancel();
      m -= 1;
    }
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    Object localObject = paramViewHolder.itemView.getTag(2131376392);
    if (!Boolean.TRUE.equals(localObject)) {}
    for (;;)
    {
      this.b.add(paramViewHolder);
      return true;
      if (this.jdField_a_of_type_Yza != null)
      {
        if (this.jdField_a_of_type_Yza.jdField_a_of_type_Int == 2)
        {
          localObject = new int[2];
          paramViewHolder.itemView.getLocationOnScreen((int[])localObject);
          int m = this.jdField_a_of_type_Yza.jdField_b_of_type_Int;
          m = paramViewHolder.itemView.getWidth() / 2;
          m = this.jdField_a_of_type_Yza.c;
          m = paramViewHolder.itemView.getHeight() / 2;
          animateMove(paramViewHolder, this.jdField_a_of_type_Yza.jdField_b_of_type_Int, this.jdField_a_of_type_Yza.c, 0, 0);
          return true;
        }
      }
      else {
        ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
      }
    }
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    yzb localyzb = new yzb(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, null);
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    paramInt1 = (int)(paramInt3 - paramInt1 - f1);
    paramInt2 = (int)(paramInt4 - paramInt2 - f2);
    c(paramViewHolder1);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null)
    {
      c(paramViewHolder2);
      boolean bool = false;
      if ((paramViewHolder2 instanceof yys)) {
        bool = ((yys)paramViewHolder2).a(localyzb);
      }
      if (!bool)
      {
        ViewCompat.setTranslationX(paramViewHolder2.itemView, -paramInt1);
        ViewCompat.setTranslationY(paramViewHolder2.itemView, -paramInt2);
        ViewCompat.setScaleX(paramViewHolder2.itemView, 1.0F);
        ViewCompat.setScaleY(paramViewHolder2.itemView, 1.0F);
        ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
      }
    }
    this.d.add(localyzb);
    return true;
  }
  
  public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    return super.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    c(paramViewHolder);
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if ((m == 0) && (n == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (m != 0) {
      ViewCompat.setTranslationX(localView, -m);
    }
    if (n != 0) {
      ViewCompat.setTranslationY(localView, -n);
    }
    this.c.add(new yzc(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    int m = this.c.size() - 1;
    while (m >= 0)
    {
      if (((yzc)this.c.get(m)).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.c.remove(m);
      }
      m -= 1;
    }
    a(this.d, paramViewHolder);
    if (this.jdField_a_of_type_JavaUtilArrayList.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.b.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    m = this.g.size() - 1;
    ArrayList localArrayList;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.g.get(m);
      a(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        this.g.remove(m);
      }
      m -= 1;
    }
    m = this.f.size() - 1;
    if (m >= 0)
    {
      localArrayList = (ArrayList)this.f.get(m);
      int n = localArrayList.size() - 1;
      for (;;)
      {
        if (n >= 0)
        {
          if (((yzc)localArrayList.get(n)).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != paramViewHolder) {
            break label293;
          }
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList.remove(n);
          if (localArrayList.isEmpty()) {
            this.f.remove(m);
          }
        }
        m -= 1;
        break;
        label293:
        n -= 1;
      }
    }
    m = this.e.size() - 1;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.e.get(m);
      if (localArrayList.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          this.e.remove(m);
        }
      }
      m -= 1;
    }
    if ((!this.j.remove(paramViewHolder)) || ((!this.h.remove(paramViewHolder)) || ((!this.k.remove(paramViewHolder)) || (this.i.remove(paramViewHolder))))) {}
    a();
  }
  
  public void endAnimations()
  {
    int m = this.c.size() - 1;
    Object localObject1;
    Object localObject2;
    while (m >= 0)
    {
      localObject1 = (yzc)this.c.get(m);
      localObject2 = ((yzc)localObject1).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView;
      ViewCompat.setTranslationY((View)localObject2, 0.0F);
      ViewCompat.setTranslationX((View)localObject2, 0.0F);
      dispatchMoveFinished(((yzc)localObject1).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      this.c.remove(m);
      m -= 1;
    }
    m = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (m >= 0)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(m));
      this.jdField_a_of_type_JavaUtilArrayList.remove(m);
      m -= 1;
    }
    m = this.b.size() - 1;
    while (m >= 0)
    {
      localObject1 = (RecyclerView.ViewHolder)this.b.get(m);
      ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject1).itemView, 1.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject1);
      this.b.remove(m);
      m -= 1;
    }
    m = this.d.size() - 1;
    while (m >= 0)
    {
      b((yzb)this.d.get(m));
      m -= 1;
    }
    this.d.clear();
    if (isRunning())
    {
      m = this.f.size() - 1;
      int n;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.f.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          localObject2 = (yzc)((ArrayList)localObject1).get(n);
          View localView = ((yzc)localObject2).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView;
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(((yzc)localObject2).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          ((ArrayList)localObject1).remove(n);
          if (((ArrayList)localObject1).isEmpty()) {
            this.f.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      m = this.e.size() - 1;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.e.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(n);
          ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject2).itemView, 1.0F);
          dispatchAddFinished((RecyclerView.ViewHolder)localObject2);
          ((ArrayList)localObject1).remove(n);
          if (((ArrayList)localObject1).isEmpty()) {
            this.e.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      m = this.g.size() - 1;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.g.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          b((yzb)((ArrayList)localObject1).get(n));
          if (((ArrayList)localObject1).isEmpty()) {
            this.g.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      a(this.j);
      a(this.i);
      a(this.h);
      a(this.k);
      dispatchAnimationsFinished();
    }
  }
  
  public boolean isRunning()
  {
    return (!this.b.isEmpty()) || (!this.d.isEmpty()) || (!this.c.isEmpty()) || (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (!this.i.isEmpty()) || (!this.j.isEmpty()) || (!this.h.isEmpty()) || (!this.k.isEmpty()) || (!this.f.isEmpty()) || (!this.e.isEmpty()) || (!this.g.isEmpty());
  }
  
  public void onChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder.itemView instanceof yyt)) {
      ((yyt)paramViewHolder.itemView).b(paramBoolean);
    }
  }
  
  public void onChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder.itemView instanceof yyt)) {
      ((yyt)paramViewHolder.itemView).a(paramBoolean);
    }
  }
  
  public void onMoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof yyt)) {
      ((yyt)paramViewHolder.itemView).b();
    }
  }
  
  public void onMoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof yyt)) {
      ((yyt)paramViewHolder.itemView).a();
    }
  }
  
  public void runPendingAnimations()
  {
    int m;
    int n;
    label24:
    int i1;
    label36:
    int i2;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      m = 1;
      if (this.c.isEmpty()) {
        break label107;
      }
      n = 1;
      if (this.d.isEmpty()) {
        break label112;
      }
      i1 = 1;
      if (this.b.isEmpty()) {
        break label117;
      }
      i2 = 1;
    }
    label49:
    Object localObject1;
    label107:
    label112:
    label117:
    Object localObject2;
    for (;;)
    {
      if ((m != 0) || (n != 0) || (i2 != 0) || (i1 != 0))
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            a((RecyclerView.ViewHolder)((Iterator)localObject1).next());
            continue;
            m = 0;
            break;
            n = 0;
            break label24;
            i1 = 0;
            break label36;
            i2 = 0;
            break label49;
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (n != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.c);
          this.f.add(localObject1);
          this.c.clear();
          localObject2 = new EnhanceItemAnimator.1(this, (ArrayList)localObject1);
          if (m == 0) {
            break label363;
          }
          ViewCompat.postOnAnimationDelayed(((yzc)((ArrayList)localObject1).get(0)).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView, (Runnable)localObject2, getRemoveDuration());
        }
        if (i1 != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.d);
          this.g.add(localObject1);
          this.d.clear();
          localObject2 = new EnhanceItemAnimator.2(this, (ArrayList)localObject1);
          if (m == 0) {
            break label373;
          }
          ViewCompat.postOnAnimationDelayed(((yzb)((ArrayList)localObject1).get(0)).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView, (Runnable)localObject2, getRemoveDuration());
        }
      }
    }
    for (;;)
    {
      if (i2 != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.b);
        this.e.add(localObject1);
        this.b.clear();
        localObject2 = new EnhanceItemAnimator.3(this, (ArrayList)localObject1);
        if ((m != 0) || (n != 0) || (i1 != 0)) {
          break label383;
        }
        ((Runnable)localObject2).run();
      }
      return;
      label363:
      ((Runnable)localObject2).run();
      break;
      label373:
      ((Runnable)localObject2).run();
    }
    label383:
    long l1;
    long l2;
    if (m != 0)
    {
      l1 = getRemoveDuration();
      if (n == 0) {
        break label451;
      }
      l2 = getMoveDuration();
      label403:
      if (i1 == 0) {
        break label457;
      }
    }
    label451:
    label457:
    for (long l3 = getChangeDuration();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)((ArrayList)localObject1).get(0)).itemView, (Runnable)localObject2, l1 + l2);
      return;
      l1 = 0L;
      break;
      l2 = 0L;
      break label403;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyu
 * JD-Core Version:    0.7.0.1
 */