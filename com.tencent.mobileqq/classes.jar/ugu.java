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

public class ugu
  extends RecyclerView.Adapter<ugc>
  implements IEventReceiver, ugi
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<ueq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uef jdField_a_of_type_Uef = (uef)urr.a(30);
  private ugv jdField_a_of_type_Ugv;
  private ugw jdField_a_of_type_Ugw;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public ugu(Activity paramActivity, ugw paramugw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ugw = paramugw;
    this.jdField_a_of_type_Ugv = new ugv(this);
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
    if (!this.jdField_a_of_type_Uef.a()) {
      this.jdField_a_of_type_JavaUtilList.add(ueq.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    uht.a().registerSubscriber(this.jdField_a_of_type_Ugv);
  }
  
  private void a(List<ueq> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    wta.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ueq localueq = (ueq)paramList.next();
      if (localueq.a() == 1) {
        localArrayList1.add(localueq);
      } else {
        localArrayList2.add(localueq);
      }
    }
    wta.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { uef.a(localArrayList1) + "", localArrayList1.size() + "" });
    wta.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { uef.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((ueq)localIterator.next()).a()) {
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
  
  public int a(ueq paramueq)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramueq);
  }
  
  public List<ueq> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public ueq a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (ueq)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public ugc a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561391, paramViewGroup, false);
    return new ugc(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Ugv);
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
  
  public void a(ueq paramueq)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramueq.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramueq) >= 0) && (paramueq == a()) && (this.jdField_a_of_type_Ugw != null)) {
        this.jdField_a_of_type_Ugw.a(paramueq);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      wsv.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(ugc paramugc, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      paramugc.a((ueq)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    } while (((this.e != -1) || (paramInt == 0)) && (this.e == paramInt));
    ugk.a(paramugc, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
  }
  
  public boolean a(@NonNull List<ueq> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((ueq)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ugw.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
      this.jdField_a_of_type_JavaUtilList.add(ueq.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ugw.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (ugc)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(ueq paramueq)
  {
    int j = a(paramueq);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramueq);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((ueq)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        wsv.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
        this.jdField_a_of_type_JavaUtilList.add(ueq.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Ugw != null) {
        this.jdField_a_of_type_Ugw.a(paramueq, j);
      }
      this.jdField_a_of_type_Uef.a(paramueq.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ugw.e();
  }
  
  public void c(ueq paramueq)
  {
    b(paramueq);
    wta.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramueq.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(1));
    this.jdField_a_of_type_JavaUtilList.add(ueq.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ugw.e();
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
 * Qualified Name:     ugu
 * JD-Core Version:    0.7.0.1
 */