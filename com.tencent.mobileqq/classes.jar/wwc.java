import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wwc
  extends RecyclerView.Adapter
  implements baxz
{
  private ahnr jdField_a_of_type_Ahnr;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<sat> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public wwc(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ahnr = new ahnr(((BaseActivity)paramContext).app, this, false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_Ahnr != null) {
      this.jdField_a_of_type_Ahnr.a();
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<sat> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((wwd)paramViewHolder).a(this.jdField_a_of_type_Boolean);
    ((wwd)paramViewHolder).a((sat)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new wwd(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559454, paramViewGroup, false), this.jdField_a_of_type_Ahnr, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramBitmap = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      paramInt1 = 0;
      while (paramInt1 < getItemCount())
      {
        Object localObject = paramBitmap.findViewByPosition(paramInt1);
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
          if (((localObject instanceof wwd)) && (paramString.equals(((wwd)localObject).a.a)))
          {
            ((wwd)localObject).a(wwd.a((wwd)localObject), paramString);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwc
 * JD-Core Version:    0.7.0.1
 */