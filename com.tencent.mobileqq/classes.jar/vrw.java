import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public abstract class vrw
{
  protected int a;
  protected Context a;
  protected RecyclerView a;
  protected QCircleFakeAdapter a;
  protected ExtraTypeInfo a;
  protected vsg a;
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {}
  
  public void a(Context paramContext, RecyclerView paramRecyclerView, QCircleFakeAdapter paramQCircleFakeAdapter, vsg paramvsg)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = paramQCircleFakeAdapter;
    this.jdField_a_of_type_Vsg = paramvsg;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getAdapter() instanceof zxo))
    {
      paramRecyclerView = ((zxo)paramRecyclerView.getAdapter()).getDataList().iterator();
      while (paramRecyclerView.hasNext())
      {
        zxu localzxu = (zxu)paramRecyclerView.next();
        if ((localzxu instanceof QCircleFakeAdapter)) {
          this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = ((QCircleFakeAdapter)localzxu);
        }
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public boolean a()
  {
    if (((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getInteractor() instanceof uzb)) && (((uzb)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getInteractor()).a() == this.jdField_a_of_type_Int))
    {
      QLog.d(vsg.a, 4, hashCode() + ":isCurrentPage :" + true);
      return true;
    }
    QLog.d(vsg.a, 4, hashCode() + ":isCurrentPage :" + false);
    return false;
  }
  
  protected boolean a(View paramView)
  {
    Rect localRect;
    int j;
    if (paramView != null)
    {
      localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
      paramView.getGlobalVisibleRect(localRect);
      j = paramView.getHeight();
      if (localRect.bottom <= 0) {
        break label147;
      }
      if (localRect.bottom > bclx.b) {
        localRect.bottom = bclx.b;
      }
    }
    label147:
    for (int i = localRect.bottom - localRect.top;; i = 0)
    {
      float f = i / j;
      QLog.d(vsg.a, 4, f + "  " + localRect.bottom + "  " + localRect.top);
      return (f >= 0.5D) && (a());
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b(View paramView)
  {
    boolean bool2 = false;
    int i = ImmersiveUtils.b() / 2;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      Rect localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
      paramView.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (localRect.bottom > i)
      {
        bool1 = bool2;
        if (localRect.top < i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrw
 * JD-Core Version:    0.7.0.1
 */