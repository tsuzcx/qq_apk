import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendBannerAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class vxa
  extends vwm
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private boolean jdField_a_of_type_Boolean;
  private List<vxm> b = new ArrayList();
  
  public vxa(@NotNull RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isComputingLayout()) {
        ThreadManager.getUIHandler().postDelayed(new TopRecommendBannerAdapter.1(this), 500L);
      }
    }
    else {
      return;
    }
    notifyDataSetChanged();
  }
  
  private void b()
  {
    this.b.clear();
    this.b.addAll(this.jdField_a_of_type_JavaUtilList.subList(0, 10));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(10, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public List<vxm> a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < this.b.size())
    {
      this.b.remove(paramInt);
      notifyItemRemoved(a() + paramInt);
      notifyItemRangeChanged(a() + paramInt, this.b.size() - paramInt);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<vxm> paramList)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() < 10) {
          break;
        }
        b();
        a();
      }
      return;
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.b.addAll(paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 10))
    {
      b();
      a();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() < 10);
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.b.add(this.jdField_a_of_type_JavaUtilList.remove(0));
        notifyItemInserted(this.b.size());
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (this.b != null) {
      return this.b.size() + a();
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */