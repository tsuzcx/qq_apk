import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vzf
  extends RecyclerView.Adapter<vys>
  implements IEventReceiver, vyy
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<vxg> jdField_a_of_type_JavaUtilList;
  private vwv jdField_a_of_type_Vwv;
  private vzg jdField_a_of_type_Vzg;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private void a(List<vxg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ykv.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vxg localvxg = (vxg)paramList.next();
      if (localvxg.a() == 1) {
        localArrayList1.add(localvxg);
      } else {
        localArrayList2.add(localvxg);
      }
    }
    ykv.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { vwv.a(localArrayList1) + "", localArrayList1.size() + "" });
    ykv.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { vwv.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((vxg)localIterator.next()).a()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int a(vxg paramvxg)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramvxg);
  }
  
  public List<vxg> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public vxg a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (vxg)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public vys a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561634, paramViewGroup, false);
    return new vys(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(vxg.a(1));
    this.jdField_a_of_type_JavaUtilList.add(vxg.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Vzg.b();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      int i = this.e;
      this.e = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", 2, "setSelectPos " + paramInt + " oldPos:" + i);
      }
      b(paramRecyclerView, i);
      b(paramRecyclerView, paramInt);
      b(paramRecyclerView, paramInt - 1);
      b(paramRecyclerView, paramInt + 1);
    }
  }
  
  public void a(vxg paramvxg)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramvxg.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramvxg) >= 0) && (paramvxg == a()) && (this.jdField_a_of_type_Vzg != null)) {
        this.jdField_a_of_type_Vzg.a(paramvxg);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(vys paramvys, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramvys, paramInt, getItemId(paramInt));
      return;
      paramvys.a((vxg)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (((this.e == -1) && (paramInt != 0)) || (this.e != paramInt)) {
        vza.a(paramvys, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
      }
    }
  }
  
  public boolean a(@NonNull List<vxg> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((vxg)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(vxg.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Vzg.b();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(vxg.a(1));
      this.jdField_a_of_type_JavaUtilList.add(vxg.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(vxg.a(1));
    this.jdField_a_of_type_JavaUtilList.add(vxg.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Vzg.b();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (vys)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(vxg paramvxg)
  {
    int j = a(paramvxg);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramvxg);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label187;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((vxg)localIterator.next()).a());
    }
    label187:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ykq.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(vxg.a(1));
        this.jdField_a_of_type_JavaUtilList.add(vxg.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Vzg != null) {
        this.jdField_a_of_type_Vzg.a(paramvxg, j);
      }
      this.jdField_a_of_type_Vwv.a(paramvxg.a());
      return;
    }
  }
  
  public void c(vxg paramvxg)
  {
    b(paramvxg);
    ykv.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramvxg.d()), "2" });
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzf
 * JD-Core Version:    0.7.0.1
 */