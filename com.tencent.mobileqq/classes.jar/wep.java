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

public class wep
  extends RecyclerView.Adapter<wdx>
  implements IEventReceiver, wed
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<wcl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wca jdField_a_of_type_Wca = (wca)wpm.a(30);
  private weq jdField_a_of_type_Weq;
  private wer jdField_a_of_type_Wer;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public wep(Activity paramActivity, wer paramwer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Wer = paramwer;
    this.jdField_a_of_type_Weq = new weq(this);
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
    if (!this.jdField_a_of_type_Wca.a()) {
      this.jdField_a_of_type_JavaUtilList.add(wcl.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    wfo.a().registerSubscriber(this.jdField_a_of_type_Weq);
  }
  
  private void a(List<wcl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    yqu.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wcl localwcl = (wcl)paramList.next();
      if (localwcl.a() == 1) {
        localArrayList1.add(localwcl);
      } else {
        localArrayList2.add(localwcl);
      }
    }
    yqu.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { wca.a(localArrayList1) + "", localArrayList1.size() + "" });
    yqu.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { wca.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((wcl)localIterator.next()).a()) {
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
  
  public int a(wcl paramwcl)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramwcl);
  }
  
  public List<wcl> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public wcl a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (wcl)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public wdx a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561645, paramViewGroup, false);
    return new wdx(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Weq);
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
  
  public void a(wcl paramwcl)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramwcl.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramwcl) >= 0) && (paramwcl == a()) && (this.jdField_a_of_type_Wer != null)) {
        this.jdField_a_of_type_Wer.a(paramwcl);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      yqp.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(wdx paramwdx, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramwdx, paramInt, getItemId(paramInt));
      return;
      paramwdx.a((wcl)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (((this.e == -1) && (paramInt != 0)) || (this.e != paramInt)) {
        wef.a(paramwdx, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
      }
    }
  }
  
  public boolean a(@NonNull List<wcl> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((wcl)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Wer.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
      this.jdField_a_of_type_JavaUtilList.add(wcl.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wer.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (wdx)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(wcl paramwcl)
  {
    int j = a(paramwcl);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramwcl);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((wcl)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        yqp.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
        this.jdField_a_of_type_JavaUtilList.add(wcl.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Wer != null) {
        this.jdField_a_of_type_Wer.a(paramwcl, j);
      }
      this.jdField_a_of_type_Wca.a(paramwcl.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wer.e();
  }
  
  public void c(wcl paramwcl)
  {
    b(paramwcl);
    yqu.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramwcl.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(1));
    this.jdField_a_of_type_JavaUtilList.add(wcl.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Wer.e();
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
 * Qualified Name:     wep
 * JD-Core Version:    0.7.0.1
 */