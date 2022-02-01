import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ull
  extends PopupWindow
  implements View.OnClickListener, vdy
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  ListView jdField_a_of_type_AndroidWidgetListView;
  private WSDragLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
  
  private ull(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static ull a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ull localull = new ull(LayoutInflater.from(paramActivity).inflate(2131560000, null), paramInt1, paramInt2);
    localull.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localull.setAnimationStyle(2131755478);
    localull.c();
    localull.setFocusable(true);
    localull.setInputMethodMode(1);
    localull.setSoftInputMode(16);
    localull.setClippingEnabled(false);
    localull.getContentView().setOnKeyListener(new ulm(localull));
    localull.setOutsideTouchable(true);
    return localull;
  }
  
  private void b(float paramFloat)
  {
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = paramFloat;
    localWindow.addFlags(2);
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void c()
  {
    View localView = getContentView();
    localView.findViewById(2131376689).setOnClickListener(new uln(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)localView.findViewById(2131365073));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(false);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364834);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366415));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setListView(this.jdField_a_of_type_AndroidWidgetListView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setTouchListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setMode(1);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    uya.a("DraggablePopup", "progress = " + paramFloat);
    b((float)(0.7D + paramFloat * 0.3D));
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.a(0);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    b(1.0F);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379019) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    if (bjvx.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      i = paramInt3;
      if (ScreenUtil.isNavigationBarExist(this.jdField_a_of_type_AndroidAppActivity)) {
        i = paramInt3 + bjvx.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ull
 * JD-Core Version:    0.7.0.1
 */