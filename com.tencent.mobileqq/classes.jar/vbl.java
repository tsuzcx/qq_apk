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

public abstract class vbl
  implements ula<vaq>
{
  public Context a;
  public View a;
  public WSVerticalPageFragment a;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  public Map<String, ukz<vaq>> a;
  private ukz<vaq> jdField_a_of_type_Ukz;
  public vct a;
  private ukz<vaq> b;
  
  public vbl(Context paramContext, vct paramvct)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Vct = paramvct;
    if (paramvct != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramvct.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvct.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380725));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380734);
      this.jdField_a_of_type_Ukz = new vcj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
      this.jdField_a_of_type_Ukz.a(localViewStub);
      a(this.jdField_a_of_type_Ukz);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380728);
      this.b = new vcl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.b.a(localViewStub);
      a(this.jdField_a_of_type_Ukz);
    }
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Ukz instanceof vcj)) {
      return ((vcj)this.jdField_a_of_type_Ukz).a();
    }
    return null;
  }
  
  public ukz a()
  {
    return this.jdField_a_of_type_Ukz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ukz)((Map.Entry)localIterator.next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ukz)((Map.Entry)localIterator.next()).getValue()).b(paramInt);
      }
    }
  }
  
  public void a(ukz<vaq> paramukz)
  {
    if (paramukz != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramukz.getClass().getName(), paramukz);
    }
  }
  
  public void a(vaq paramvaq)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ukz)((Map.Entry)localIterator.next()).getValue()).a(paramvaq);
      }
    }
  }
  
  public ukz b()
  {
    return this.b;
  }
  
  public void b(vaq paramvaq) {}
  
  public void c(vaq paramvaq)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), vcj.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), vcl.class.getName()))) {
          ((ukz)localEntry.getValue()).a(paramvaq);
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
 * Qualified Name:     vbl
 * JD-Core Version:    0.7.0.1
 */