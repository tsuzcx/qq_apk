import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class vqe
  implements uyx<vpj>
{
  public Context a;
  public View a;
  public WSVerticalPageFragment a;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  public Map<String, uyw<vpj>> a;
  private uyw<vpj> jdField_a_of_type_Uyw;
  public vrn a;
  private View jdField_b_of_type_AndroidViewView;
  private uyw<vpj> jdField_b_of_type_Uyw;
  
  public vqe(Context paramContext, vrn paramvrn)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Vrn = paramvrn;
    if (paramvrn != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramvrn.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381142);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381077));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381085);
      this.jdField_a_of_type_Uyw = new vrd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
      this.jdField_a_of_type_Uyw.a(localViewStub);
      a(this.jdField_a_of_type_Uyw);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381080);
      this.jdField_b_of_type_Uyw = new vrf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.jdField_b_of_type_Uyw.a(localViewStub);
      a(this.jdField_b_of_type_Uyw);
    }
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_Uyw instanceof vrd)) {
      return ((vrd)this.jdField_a_of_type_Uyw).a();
    }
    return null;
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Uyw instanceof vrd)) {
      return ((vrd)this.jdField_a_of_type_Uyw).a();
    }
    return null;
  }
  
  public uyw a()
  {
    return this.jdField_a_of_type_Uyw;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uyw)((Map.Entry)localIterator.next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uyw)((Map.Entry)localIterator.next()).getValue()).b(paramInt);
      }
    }
  }
  
  public void a(uyw<vpj> paramuyw)
  {
    if (paramuyw != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramuyw.getClass().getName(), paramuyw);
    }
  }
  
  public void a(vpj paramvpj)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uyw)((Map.Entry)localIterator.next()).getValue()).a(paramvpj);
      }
    }
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public uyw b()
  {
    return this.jdField_b_of_type_Uyw;
  }
  
  public void b(vpj paramvpj) {}
  
  public void c(vpj paramvpj)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), vrd.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), vrf.class.getName()))) {
          ((uyw)localEntry.getValue()).a(paramvpj);
        }
      }
    }
  }
  
  public void d()
  {
    e();
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqe
 * JD-Core Version:    0.7.0.1
 */