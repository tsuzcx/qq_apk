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

public abstract class utq
  implements uek<usv>
{
  public Context a;
  public View a;
  public WSVerticalPageFragment a;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  public Map<String, uej<usv>> a;
  private uej<usv> jdField_a_of_type_Uej;
  public uuy a;
  private uej<usv> b;
  
  public utq(Context paramContext, uuy paramuuy)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Uuy = paramuuy;
    if (paramuuy != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramuuy.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380999));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381008);
      this.jdField_a_of_type_Uej = new uuo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
      this.jdField_a_of_type_Uej.a(localViewStub);
      a(this.jdField_a_of_type_Uej);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381002);
      this.b = new uuq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.b.a(localViewStub);
      a(this.jdField_a_of_type_Uej);
    }
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Uej instanceof uuo)) {
      return ((uuo)this.jdField_a_of_type_Uej).a();
    }
    return null;
  }
  
  public uej a()
  {
    return this.jdField_a_of_type_Uej;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uej)((Map.Entry)localIterator.next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uej)((Map.Entry)localIterator.next()).getValue()).b(paramInt);
      }
    }
  }
  
  public void a(uej<usv> paramuej)
  {
    if (paramuej != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramuej.getClass().getName(), paramuej);
    }
  }
  
  public void a(usv paramusv)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uej)((Map.Entry)localIterator.next()).getValue()).a(paramusv);
      }
    }
  }
  
  public uej b()
  {
    return this.b;
  }
  
  public void b(usv paramusv) {}
  
  public void c(usv paramusv)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), uuo.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), uuq.class.getName()))) {
          ((uej)localEntry.getValue()).a(paramusv);
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
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */