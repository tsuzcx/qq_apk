import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class uld
  extends RecyclerView.Adapter<ukl>
  implements IEventReceiver, ukr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<uiz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uio jdField_a_of_type_Uio = (uio)uwa.a(30);
  private ule jdField_a_of_type_Ule;
  private ulf jdField_a_of_type_Ulf;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public uld(Activity paramActivity, ulf paramulf, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ulf = paramulf;
    this.jdField_a_of_type_Ule = new ule(this);
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
    if (!this.jdField_a_of_type_Uio.a()) {
      this.jdField_a_of_type_JavaUtilList.add(uiz.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    umc.a().registerSubscriber(this.jdField_a_of_type_Ule);
  }
  
  private void a(List<uiz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    wxj.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uiz localuiz = (uiz)paramList.next();
      if (localuiz.a() == 1) {
        localArrayList1.add(localuiz);
      } else {
        localArrayList2.add(localuiz);
      }
    }
    wxj.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { uio.a(localArrayList1) + "", localArrayList1.size() + "" });
    wxj.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { uio.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((uiz)localIterator.next()).a()) {
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
  
  public int a(uiz paramuiz)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramuiz);
  }
  
  public List<uiz> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public uiz a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (uiz)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public ukl a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561409, paramViewGroup, false);
    return new ukl(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Ule);
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
  
  public void a(uiz paramuiz)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramuiz.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramuiz) >= 0) && (paramuiz == a()) && (this.jdField_a_of_type_Ulf != null)) {
        this.jdField_a_of_type_Ulf.a(paramuiz);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      wxe.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(ukl paramukl, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      paramukl.a((uiz)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    } while (((this.e != -1) || (paramInt == 0)) && (this.e == paramInt));
    ukt.a(paramukl, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
  }
  
  public boolean a(@NonNull List<uiz> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((uiz)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ulf.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
      this.jdField_a_of_type_JavaUtilList.add(uiz.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ulf.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (ukl)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(uiz paramuiz)
  {
    int j = a(paramuiz);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramuiz);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((uiz)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        wxe.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
        this.jdField_a_of_type_JavaUtilList.add(uiz.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Ulf != null) {
        this.jdField_a_of_type_Ulf.a(paramuiz, j);
      }
      this.jdField_a_of_type_Uio.a(paramuiz.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ulf.e();
  }
  
  public void c(uiz paramuiz)
  {
    b(paramuiz);
    wxj.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramuiz.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(1));
    this.jdField_a_of_type_JavaUtilList.add(uiz.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ulf.e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uld
 * JD-Core Version:    0.7.0.1
 */