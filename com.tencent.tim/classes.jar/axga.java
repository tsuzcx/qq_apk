import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class axga
  extends axgh
{
  private ImageView Id;
  private View Mz;
  private axgg jdField_a_of_type_Axgg;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private axgf jdField_b_of_type_Axgf;
  private AECaptureMode[] jdField_b_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private awtq c;
  private PagerAdapter d;
  private boolean dut;
  private boolean duu;
  private AECaptureMode h;
  private RelativeLayout nV;
  
  public axga(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
  }
  
  private void Yf(boolean paramBoolean)
  {
    if (this.Mz == null) {}
    do
    {
      do
      {
        return;
        this.duu = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (this.Mz.getVisibility() == 0);
      this.Mz.setVisibility(0);
      return;
    } while (this.Mz.getVisibility() != 0);
    this.Mz.setVisibility(8);
  }
  
  private axbr b()
  {
    return (axbr)axov.a().c(18);
  }
  
  private void biN()
  {
    this.jdField_b_of_type_Axgf = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.jdField_b_of_type_Axgf.t.a(this.jdField_c_of_type_Awtq, new axgc(this));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this.jdField_c_of_type_Awtq).b(axgg.class));
    this.jdField_a_of_type_Axgg.p().a(this.jdField_c_of_type_Awtq, new axgd(this));
  }
  
  private void c(AECaptureMode paramAECaptureMode)
  {
    if (this.h == paramAECaptureMode) {}
    while (this.jdField_b_of_type_Axgf.aOz()) {
      return;
    }
    this.jdField_b_of_type_Axgf.t.postValue(new axfz(this.h, paramAECaptureMode, 0));
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378864);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      axiy.i("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.Mz = this.mRootView.findViewById(2131377403);
    this.Id = ((ImageView)this.Mz.findViewById(2131369690));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.Mz.findViewById(2131382092));
    this.nV = ((RelativeLayout)this.mRootView.findViewById(2131367348));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (azbx.bG(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - aqnm.dip2px(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new axgb(this));
    this.jdField_b_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class)).u.getValue());
    if (this.jdField_b_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_b_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      Yf(bool);
      this.d = new axga.a(this.mRootView.getContext());
      this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.d);
      biN();
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.mActivity.finish();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((AECaptureMode.NORMAL == this.h) && (this.jdField_c_of_type_Awtq != null)) {
      this.jdField_c_of_type_Awtq.XG(true);
    }
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof axbu))) {
        break;
      }
    } while (this.h != AECaptureMode.PLAY);
    b().b((axbu)paramVarArgs[0], true);
    if (this.jdField_c_of_type_Awtq != null) {
      this.jdField_c_of_type_Awtq.getActivity().getIntent().putExtra("widgetinfo", "camera^" + ((axbu)paramVarArgs[0]).id);
    }
    c(AECaptureMode.NORMAL);
  }
  
  class a
    extends PagerAdapter
  {
    private Context context;
    private SparseArray<axga.a.a> ef;
    
    a(Context paramContext)
    {
      this.context = paramContext;
      this.ef = new SparseArray();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if (axga.a(axga.this) == null) {
        return 0;
      }
      return axga.a(axga.this).length;
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    @SuppressLint({"ResourceType"})
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject2 = (axga.a.a)this.ef.get(paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = View.inflate(this.context, 2131558547, null);
        localObject1 = new axga.a.a();
        ((axga.a.a)localObject1).lj = ((View)localObject2);
        ((axga.a.a)localObject1).textView = ((TextView)((View)localObject2).findViewById(2131371876));
        this.ef.put(paramInt, localObject1);
      }
      localObject2 = axga.a(axga.this)[paramInt];
      TextView localTextView = ((axga.a.a)localObject1).textView;
      localTextView.setText(((AECaptureMode)localObject2).textId);
      if (axga.a(axga.this))
      {
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        localTextView.setTextColor(this.context.getResources().getColor(2131165381));
        if (axga.a(axga.this) != localObject2) {
          break label220;
        }
        localTextView.setAlpha(1.0F);
      }
      for (;;)
      {
        localTextView.setOnClickListener(new axge(this, (AECaptureMode)localObject2, paramInt));
        paramViewGroup.addView(((axga.a.a)localObject1).lj);
        return ((axga.a.a)localObject1).lj;
        localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165396));
        localTextView.setTextColor(this.context.getResources().getColor(2131167654));
        break;
        label220:
        localTextView.setAlpha(0.6F);
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final class a
    {
      public View lj;
      public TextView textView;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axga
 * JD-Core Version:    0.7.0.1
 */