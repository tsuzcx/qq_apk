import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.a;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import mqq.app.AppRuntime.Status;

public class akua
{
  private OnlineStatusPanel a;
  
  @SuppressLint({"UseSparseArrays"})
  public akua(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, OnlineStatusPagerAdapter.a parama, int paramInt)
  {
    this.a = ((OnlineStatusPanel)View.inflate(paramContext, 2131559031, null));
    this.a.init(paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(parama);
    paramViewGroup.addView(this.a);
  }
  
  public akto a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.c;
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, akua.a parama)
  {
    akto localakto = akti.a().a(paramStatus, paramLong);
    if (localakto != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.c = localakto;
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
      if (parama != null)
      {
        paramStatus = new akto(paramStatus);
        paramStatus.id = paramLong;
        parama.a(paramStatus);
      }
    }
  }
  
  public void d(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, null);
  }
  
  public void dDv()
  {
    boolean bool = true;
    QQViewPager localQQViewPager = this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.hy(bool);
      return;
      bool = false;
    }
  }
  
  void dDw()
  {
    this.a.dDt();
  }
  
  public static abstract interface a
  {
    public abstract void a(akto paramakto);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */