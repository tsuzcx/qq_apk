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

public class uzl
  extends PopupWindow
  implements View.OnClickListener, vsr
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  ListView jdField_a_of_type_AndroidWidgetListView;
  private WSDragLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout;
  
  private uzl(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static uzl a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    uzl localuzl = new uzl(LayoutInflater.from(paramActivity).inflate(2131560044, null), paramInt1, paramInt2);
    localuzl.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localuzl.setAnimationStyle(2131755481);
    localuzl.c();
    localuzl.setFocusable(true);
    localuzl.setInputMethodMode(1);
    localuzl.setSoftInputMode(16);
    localuzl.setClippingEnabled(false);
    localuzl.getContentView().setOnKeyListener(new uzm(localuzl));
    localuzl.setOutsideTouchable(true);
    return localuzl;
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
    localView.findViewById(2131376957).setOnClickListener(new uzn(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout = ((WSDragLayout)localView.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout.setControlLitTongue(false);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364921);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524));
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
    vmp.a("DraggablePopup", "progress = " + paramFloat);
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
    if (paramView.getId() == 2131379315) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    if (blhi.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      i = paramInt3;
      if (ScreenUtil.isNavigationBarExist(this.jdField_a_of_type_AndroidAppActivity)) {
        i = paramInt3 + blhi.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */