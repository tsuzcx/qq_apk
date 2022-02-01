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

public abstract class usp
  implements uei<uru>
{
  public Context a;
  public View a;
  public WSVerticalPageFragment a;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  public Map<String, ueh<uru>> a;
  private ueh<uru> jdField_a_of_type_Ueh;
  public utw a;
  private ueh<uru> b;
  
  public usp(Context paramContext, utw paramutw)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Utw = paramutw;
    if (paramutw != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramutw.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramutw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380822));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380830);
      this.jdField_a_of_type_Ueh = new utm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
      this.jdField_a_of_type_Ueh.a(localViewStub);
      a(this.jdField_a_of_type_Ueh);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380825);
      this.b = new uto(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.b.a(localViewStub);
      a(this.jdField_a_of_type_Ueh);
    }
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Ueh instanceof utm)) {
      return ((utm)this.jdField_a_of_type_Ueh).a();
    }
    return null;
  }
  
  public ueh a()
  {
    return this.jdField_a_of_type_Ueh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ueh)((Map.Entry)localIterator.next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ueh)((Map.Entry)localIterator.next()).getValue()).a(paramInt);
      }
    }
  }
  
  public void a(ueh<uru> paramueh)
  {
    if (paramueh != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramueh.getClass().getName(), paramueh);
    }
  }
  
  public void a(uru paramuru)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ueh)((Map.Entry)localIterator.next()).getValue()).a(paramuru);
      }
    }
  }
  
  public ueh b()
  {
    return this.b;
  }
  
  public void b(uru paramuru) {}
  
  public void c(uru paramuru)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), utm.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), uto.class.getName()))) {
          ((ueh)localEntry.getValue()).a(paramuru);
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
 * Qualified Name:     usp
 * JD-Core Version:    0.7.0.1
 */