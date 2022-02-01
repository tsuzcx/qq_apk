import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class plq
  extends RecyclerView.Adapter<plc>
  implements IEventReceiver, plc.b
{
  private boolean Dr;
  private int UX;
  private int UY;
  private int UZ = -1;
  private plq.a jdField_a_of_type_Plq$a;
  private plq.b jdField_a_of_type_Plq$b;
  private pju b = (pju)psx.a(30);
  private long iu;
  private Activity mContext;
  private int mImageHeight;
  private int mImageWidth;
  private List<pkd> mf = new ArrayList();
  
  public plq(Activity paramActivity, plq.b paramb, int paramInt1, int paramInt2)
  {
    this.mContext = paramActivity;
    this.mImageHeight = paramInt2;
    this.mImageWidth = paramInt1;
    this.jdField_a_of_type_Plq$b = paramb;
    this.jdField_a_of_type_Plq$a = new plq.a(this);
    this.mf.add(pkd.a(1));
    if (!this.b.Ic()) {
      this.mf.add(pkd.a(3));
    }
    this.Dr = true;
    pmi.a().registerSubscriber(this.jdField_a_of_type_Plq$a);
  }
  
  private boolean Ii()
  {
    if (this.mf.size() > 0)
    {
      Iterator localIterator = this.mf.iterator();
      while (localIterator.hasNext()) {
        if (!((pkd)localIterator.next()).Id()) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void dQ(List<pkd> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    rar.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pkd localpkd = (pkd)paramList.next();
      if (localpkd.getState() == 1) {
        localArrayList1.add(localpkd);
      } else {
        localArrayList2.add(localpkd);
      }
    }
    rar.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { pju.r(localArrayList1) + "", localArrayList1.size() + "" });
    rar.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { pju.r(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  public boolean A(@NonNull List<pkd> paramList)
  {
    if (this.mf.size() > 0)
    {
      Iterator localIterator = this.mf.iterator();
      while (localIterator.hasNext()) {
        if (!((pkd)localIterator.next()).Id()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.mf = new ArrayList();
      this.mf.add(pkd.a(1));
      this.mf.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Plq$b.Aj();
      dQ(paramList);
      return true;
      this.mf = new ArrayList();
      this.mf.add(pkd.a(1));
      this.mf.add(pkd.a(4));
      notifyDataSetChanged();
    }
  }
  
  public int a(pkd parampkd)
  {
    return this.mf.indexOf(parampkd);
  }
  
  public pkd a()
  {
    if ((this.UZ >= 0) && (this.UZ < getItemCount())) {
      return (pkd)this.mf.get(this.UZ);
    }
    return null;
  }
  
  public plc a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561802, paramViewGroup, false);
    return new plc(this.mContext, paramViewGroup, this.mImageWidth, this.mImageHeight, this);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      int i = this.UZ;
      this.UZ = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", 2, "setSelectPos " + paramInt + " oldPos:" + i);
      }
      b(paramRecyclerView, i);
      b(paramRecyclerView, paramInt);
      b(paramRecyclerView, paramInt - 1);
      b(paramRecyclerView, paramInt + 1);
    }
  }
  
  public void a(plc paramplc, int paramInt)
  {
    if (paramInt >= this.mf.size()) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramplc, paramInt, getItemId(paramInt));
      return;
      paramplc.d((pkd)this.mf.get(paramInt));
      if (((this.UZ == -1) && (paramInt != 0)) || (this.UZ != paramInt)) {
        plh.a(paramplc, this.UX, this.mImageWidth, this.UY, this.mImageHeight, 0.0F, paramInt);
      }
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (plc)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.updateView();
      }
    }
  }
  
  public List<pkd> bH()
  {
    return Collections.unmodifiableList(this.mf);
  }
  
  public void blE()
  {
    if (Ii()) {
      return;
    }
    this.mf = new ArrayList();
    this.mf.add(pkd.a(1));
    this.mf.add(pkd.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Plq$b.Aj();
  }
  
  public void blF()
  {
    this.mf = new ArrayList();
    this.mf.add(pkd.a(1));
    this.mf.add(pkd.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Plq$b.Aj();
  }
  
  public void blG()
  {
    if (Ii()) {
      return;
    }
    this.mf = new ArrayList();
    this.mf.add(pkd.a(1));
    this.mf.add(pkd.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Plq$b.Aj();
  }
  
  public void e(pkd parampkd)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.iu > 500L) {
      if ((!parampkd.Ie()) && (this.mf.indexOf(parampkd) >= 0) && (parampkd == a()) && (this.jdField_a_of_type_Plq$b != null)) {
        this.jdField_a_of_type_Plq$b.h(parampkd);
      }
    }
    for (;;)
    {
      this.iu = l;
      return;
      ram.w("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void f(pkd parampkd)
  {
    int j = a(parampkd);
    if (j >= 0)
    {
      this.mf.remove(parampkd);
      if (this.mf.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.mf.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((pkd)localIterator.next()).Id());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ram.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.mf = new ArrayList();
        this.mf.add(pkd.a(1));
        this.mf.add(pkd.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.mf.size()) {
        notifyItemRangeChanged(j, this.mf.size() - j);
      }
      if (this.jdField_a_of_type_Plq$b != null) {
        this.jdField_a_of_type_Plq$b.a(parampkd, j);
      }
      this.b.aV(parampkd.getID());
      return;
    }
  }
  
  public int getItemCount()
  {
    return this.mf.size();
  }
  
  public int getSelectPosition()
  {
    return this.UZ;
  }
  
  public boolean isValidate()
  {
    return this.Dr;
  }
  
  public void k(pkd parampkd)
  {
    f(parampkd);
    rar.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(parampkd.getReportType()), "2" });
  }
  
  public void onDestroy()
  {
    this.Dr = false;
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Plq$a);
  }
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    this.UX = paramInt1;
    this.UY = paramInt2;
  }
  
  public static class a
    extends QQUIEventReceiver<plq, pju.a>
  {
    public a(@NonNull plq paramplq)
    {
      super();
    }
    
    public void a(@NonNull plq paramplq, @NonNull pju.a parama)
    {
      boolean bool2 = false;
      boolean bool1;
      if (parama.b.isFail())
      {
        ram.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(parama.b.errorCode));
        paramplq.blG();
        bool1 = bool2;
      }
      for (;;)
      {
        plq.a(paramplq).rG(bool1);
        return;
        ram.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(parama.lP.size()));
        bool1 = bool2;
        if (paramplq.A(parama.lP))
        {
          bool1 = bool2;
          if (parama.lP.size() > 0) {
            bool1 = true;
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pju.a.class;
    }
  }
  
  public static abstract interface b
  {
    public abstract void Aj();
    
    public abstract void a(pkd parampkd, int paramInt);
    
    public abstract void h(pkd parampkd);
    
    public abstract void rG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */