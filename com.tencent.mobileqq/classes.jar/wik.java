import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wik
  extends RecyclerView.Adapter<whs>
  implements IEventReceiver, why
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<wgg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wfv jdField_a_of_type_Wfv = (wfv)wth.a(30);
  private wil jdField_a_of_type_Wil;
  private wim jdField_a_of_type_Wim;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public wik(Activity paramActivity, wim paramwim, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Wim = paramwim;
    this.jdField_a_of_type_Wil = new wil(this);
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
    if (!this.jdField_a_of_type_Wfv.a()) {
      this.jdField_a_of_type_JavaUtilList.add(wgg.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    wjj.a().registerSubscriber(this.jdField_a_of_type_Wil);
  }
  
  private void a(List<wgg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    yup.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wgg localwgg = (wgg)paramList.next();
      if (localwgg.a() == 1) {
        localArrayList1.add(localwgg);
      } else {
        localArrayList2.add(localwgg);
      }
    }
    yup.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { wfv.a(localArrayList1) + "", localArrayList1.size() + "" });
    yup.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { wfv.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((wgg)localIterator.next()).a()) {
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
  
  public int a(wgg paramwgg)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramwgg);
  }
  
  public List<wgg> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public wgg a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (wgg)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public whs a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561686, paramViewGroup, false);
    return new whs(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Wil);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
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
  
  public void a(wgg paramwgg)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramwgg.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramwgg) >= 0) && (paramwgg == a()) && (this.jdField_a_of_type_Wim != null)) {
        this.jdField_a_of_type_Wim.a(paramwgg);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      yuk.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(whs paramwhs, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramwhs, paramInt, getItemId(paramInt));
      return;
      paramwhs.a((wgg)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (((this.e == -1) && (paramInt != 0)) || (this.e != paramInt)) {
        wia.a(paramwhs, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
      }
    }
  }
  
  public boolean a(@NonNull List<wgg> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((wgg)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Wim.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
      this.jdField_a_of_type_JavaUtilList.add(wgg.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wim.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (whs)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(wgg paramwgg)
  {
    int j = a(paramwgg);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramwgg);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((wgg)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        yuk.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
        this.jdField_a_of_type_JavaUtilList.add(wgg.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Wim != null) {
        this.jdField_a_of_type_Wim.a(paramwgg, j);
      }
      this.jdField_a_of_type_Wfv.a(paramwgg.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wim.e();
  }
  
  public void c(wgg paramwgg)
  {
    b(paramwgg);
    yup.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramwgg.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wgg.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wim.e();
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
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */