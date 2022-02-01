import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class aypb
  extends ReportDialog
  implements View.OnClickListener, aypc.a
{
  private ayoy jdField_a_of_type_Ayoy;
  aypc jdField_a_of_type_Aypc;
  private TextView aib;
  private aypc.b jdField_b_of_type_Aypc$b;
  private FitSystemWindowsRelativeLayout jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private FrameLayout cI;
  protected Context mContext;
  protected EditText mEditText;
  private int mInteractType;
  private View mRootView;
  
  public aypb(@NonNull Context paramContext, @NonNull ayoy paramayoy, int paramInt)
  {
    super(paramContext, 2131755374);
    this.jdField_a_of_type_Ayoy = paramayoy;
    this.mInteractType = paramInt;
    this.mContext = paramContext;
  }
  
  private void bub()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = ayom.getWindowScreenHeight(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.mRootView.findViewById(2131377568));
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.cI = ((FrameLayout)this.mRootView.findViewById(2131382089));
    this.mRootView.findViewById(2131363243).setOnClickListener(this);
    this.mEditText = ((EditText)this.mRootView.findViewById(2131382081));
    this.aib = ((TextView)this.mRootView.findViewById(2131382090));
    this.jdField_a_of_type_Aypc = aypc.a(this.mInteractType);
    this.jdField_a_of_type_Aypc.a(getContext(), this.jdField_b_of_type_Aypc$b, this.mEditText, this.aib, this);
    View localView = this.jdField_a_of_type_Aypc.cO();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localView.setLayoutParams(localLayoutParams);
    this.cI.addView(localView);
  }
  
  public void a(aypc.b paramb)
  {
    this.jdField_b_of_type_Aypc$b = paramb;
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void eTg()
  {
    dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_Aypc.onDetachedFromWindow();
    if (this.jdField_a_of_type_Ayoy != null) {
      this.jdField_a_of_type_Ayoy.a(this.mInteractType, this.jdField_a_of_type_Aypc.b());
    }
    super.onDetachedFromWindow();
  }
  
  public void setContentView(int paramInt)
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131562043, null);
    bub();
    initView();
    super.setContentView(this.mRootView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypb
 * JD-Core Version:    0.7.0.1
 */