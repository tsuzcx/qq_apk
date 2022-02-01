import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class vur
{
  private GeneralSettingActivity jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity;
  private vur.c jdField_a_of_type_Vur$c;
  private boolean bau = true;
  private LinearLayoutManager layoutManager;
  private View mRoot;
  private RecyclerView recyclerView;
  
  private void a(URLImageView paramURLImageView, vur.b paramb)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(paramb.imageUrl, (URLDrawable.URLDrawableOptions)localObject);
    boolean bool = a((URLDrawable)localObject);
    if (paramURLImageView != null)
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "onBindViewHolder loadPic colorDrawable=" + localObject + " bReady=" + bool + " checked=" + paramb.checked);
    }
    paramb.p = ((URLDrawable)localObject);
    if (!bool)
    {
      ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity);
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  private boolean a(URLDrawable paramURLDrawable)
  {
    return (paramURLDrawable != null) && ((paramURLDrawable.getStatus() == 1) || (paramURLDrawable.getStatus() == 4));
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.recyclerView == null) {}
    float f;
    do
    {
      return true;
      f = paramMotionEvent.getY();
      paramMotionEvent = new int[2];
      this.recyclerView.getLocationOnScreen(paramMotionEvent);
    } while ((f <= paramMotionEvent[1]) || (f >= paramMotionEvent[1] + this.recyclerView.getHeight()));
    return false;
  }
  
  public void a(View paramView, GeneralSettingActivity paramGeneralSettingActivity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = anlm.Kd();
    int i = 0;
    while (i < anlj.gR.length)
    {
      vur.b localb = new vur.b(anlj.gS[i], anlj.gR[i], i);
      if (i == j) {
        localb.checked = true;
      }
      a(null, localb);
      localArrayList.add(localb);
      i += 1;
    }
    this.recyclerView = ((RecyclerView)paramView.findViewById(2131364880));
    this.recyclerView.setItemViewCacheSize(7);
    this.layoutManager = new LinearLayoutManager(paramGeneralSettingActivity);
    this.layoutManager.setOrientation(0);
    this.recyclerView.setLayoutManager(this.layoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity = paramGeneralSettingActivity;
    this.recyclerView.addItemDecoration(new vur.d(8));
    this.mRoot = paramView;
    this.jdField_a_of_type_Vur$c = new vur.c(localArrayList);
    this.recyclerView.setAdapter(this.jdField_a_of_type_Vur$c);
  }
  
  public void aE(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "updateSimpleUIChoice bpref=" + paramInt + " needChangeTheme=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Vur$c != null))
    {
      vur.b localb = this.jdField_a_of_type_Vur$c.a(paramInt);
      localb.isLoading = paramBoolean;
      if ((this.jdField_a_of_type_Vur$c.a(localb, paramInt, true)) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.AZ(localb.id);
      }
      this.recyclerView.scrollToPosition(paramInt);
    }
  }
  
  public void aI(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "selectSimpleUIChoice bpref=" + paramInt + " isLoading=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Vur$c != null))
    {
      vur.b localb = this.jdField_a_of_type_Vur$c.a(paramInt);
      localb.isLoading = paramBoolean;
      this.jdField_a_of_type_Vur$c.a(localb, paramInt, true);
      this.recyclerView.scrollToPosition(paramInt);
    }
  }
  
  public void xY(boolean paramBoolean)
  {
    this.bau = paramBoolean;
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    URLImageView ak;
    URLImageView e;
    View uO;
    
    public a(View paramView)
    {
      super();
      this.e = ((URLImageView)paramView.findViewById(2131368962));
      this.ak = ((URLImageView)paramView.findViewById(2131368977));
      this.ak.setBackgroundDrawable(az());
      this.uO = paramView.findViewById(2131370787);
    }
    
    private Drawable az()
    {
      Resources localResources = this.itemView.getResources();
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(wja.dp2px(5.0F, localResources));
      localGradientDrawable.setStroke(wja.dp2px(1.5F, localResources), localResources.getColor(2131167407));
      return localGradientDrawable;
    }
  }
  
  public class b
  {
    boolean checked;
    int id;
    String imageUrl;
    boolean isLoading;
    URLDrawable p;
    String themeId;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      this.themeId = paramString1;
      this.imageUrl = paramString2;
      this.checked = false;
      this.id = paramInt;
      this.isLoading = false;
    }
  }
  
  public class c
    extends RecyclerView.Adapter<vur.a>
  {
    private int bKI;
    List<vur.b> rf;
    
    public c()
    {
      Object localObject;
      this.rf = localObject;
      this.bKI = anlm.Kd();
    }
    
    private void BA(int paramInt)
    {
      vur.b localb = a(paramInt);
      if (!localb.checked) {}
      for (boolean bool = true;; bool = false)
      {
        if (a(localb, paramInt, bool)) {
          vur.a(vur.this).AZ(localb.id);
        }
        return;
      }
    }
    
    public vur.a a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = vur.a(vur.this).getLayoutInflater().inflate(2131563085, paramViewGroup, false);
      return new vur.a(vur.this, paramViewGroup);
    }
    
    public vur.b a(int paramInt)
    {
      return (vur.b)this.rf.get(paramInt);
    }
    
    public void a(vur.a parama, int paramInt)
    {
      vur.b localb = a(paramInt);
      if (localb.checked)
      {
        parama.ak.setVisibility(0);
        ViewCompat.setAccessibilityDelegate(parama.e, new vus(this));
        parama.e.setContentDescription(anlj.gT[paramInt]);
        vur.a(vur.this, parama.e, localb);
        if (!localb.isLoading) {
          break label147;
        }
        parama.uO.setVisibility(0);
        ((Animatable)parama.uO.getBackground()).start();
      }
      for (;;)
      {
        parama.itemView.setOnClickListener(new vuu(this, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
        return;
        parama.ak.setVisibility(8);
        ViewCompat.setAccessibilityDelegate(parama.e, new vut(this));
        break;
        label147:
        parama.uO.setVisibility(8);
        ((Animatable)parama.uO.getBackground()).stop();
      }
    }
    
    public boolean a(vur.b paramb, int paramInt, boolean paramBoolean)
    {
      if (this.bKI == paramInt)
      {
        notifyItemChanged(paramInt);
        return false;
      }
      paramb.checked = paramBoolean;
      if (paramb.checked) {
        if (this.bKI >= 0) {
          break label46;
        }
      }
      for (this.bKI = paramInt;; this.bKI = paramInt)
      {
        notifyItemChanged(paramInt);
        return true;
        label46:
        paramb = a(this.bKI);
        paramb.checked = false;
        paramb.isLoading = false;
        notifyItemChanged(this.bKI);
      }
    }
    
    public int getItemCount()
    {
      return this.rf.size();
    }
  }
  
  public class d
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public d(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.right = this.space;
      paramRect.bottom = this.space;
      paramRect.left = this.space;
      if (paramRecyclerView.getChildPosition(paramView) != 0) {
        paramRect.right = this.space;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vur
 * JD-Core Version:    0.7.0.1
 */