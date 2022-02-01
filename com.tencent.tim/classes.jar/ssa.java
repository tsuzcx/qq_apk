import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ssa
  extends RecyclerView.Adapter<ssa.a>
  implements Handler.Callback
{
  private srs.a a;
  private auru jdField_b_of_type_Auru;
  private SmartMusicRecyclerView jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
  private srq jdField_b_of_type_Srq;
  private HashMap<String, Integer> fU = new HashMap();
  private List<VsMusicItemInfo> mData = new ArrayList();
  
  private int er(int paramInt)
  {
    if (ut() == 0) {
      return 0;
    }
    return paramInt % ut();
  }
  
  private void fk(List<VsMusicItemInfo> paramList)
  {
    int i = 0;
    while (i < ut())
    {
      this.fU.put(((VsMusicItemInfo)paramList.get(i)).mSongMid, Integer.valueOf(i));
      i += 1;
    }
  }
  
  public auru a()
  {
    if (this.jdField_b_of_type_Auru == null) {
      this.jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
    }
    return this.jdField_b_of_type_Auru;
  }
  
  public VsMusicItemInfo a(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= ut()) {
      i = er(paramInt);
    }
    if ((this.mData == null) || (i < 0) || (i >= this.mData.size())) {
      return null;
    }
    return (VsMusicItemInfo)this.mData.get(i);
  }
  
  public ssa.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ssa.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563311, null));
  }
  
  public void a(ssa.a parama, int paramInt)
  {
    if (ut() == 0) {}
    int i;
    label31:
    VsMusicItemInfo localVsMusicItemInfo;
    do
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
      if (paramInt >= ut()) {
        break;
      }
      i = paramInt;
      localVsMusicItemInfo = (VsMusicItemInfo)this.mData.get(i);
    } while (localVsMusicItemInfo == null);
    if (localVsMusicItemInfo.isDownloading()) {
      parama.showProgressBar();
    }
    for (;;)
    {
      rpq.a(ssa.a.a(parama), localVsMusicItemInfo.mAlbumUrl, rpq.dip2px(parama.itemView.getContext(), 60.0F), rpq.dip2px(parama.itemView.getContext(), 60.0F), rpq.dip2px(parama.itemView.getContext(), 30.0F), parama.itemView.getContext().getResources().getDrawable(2130838936), null);
      parama.itemView.setOnClickListener(new ssb(this, paramInt, localVsMusicItemInfo));
      break;
      i = er(paramInt);
      break label31;
      parama.showProgressBar(false);
    }
  }
  
  public boolean a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (this.fU.get(paramVsMusicItemInfo.mSongMid) == null)
    {
      paramInt = er(paramInt);
      this.fU.put(paramVsMusicItemInfo.mSongMid, Integer.valueOf(paramInt));
      this.mData.add(paramInt, paramVsMusicItemInfo);
      fk(this.mData);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public int bp(String paramString)
  {
    return ((Integer)this.fU.get(paramString)).intValue();
  }
  
  public void cF(ArrayList<String> paramArrayList)
  {
    r(paramArrayList, false);
  }
  
  public List<VsMusicItemInfo> getData()
  {
    return this.mData;
  }
  
  public int getItemCount()
  {
    return 1000;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView = ((SmartMusicRecyclerView)paramRecyclerView);
    this.jdField_b_of_type_Srq = this.jdField_b_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.a();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    a().removeCallbacks(null);
  }
  
  public void r(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(paramArrayList), new ssc(this, paramBoolean));
  }
  
  public void setData(ArrayList<VsMusicItemInfo> paramArrayList)
  {
    this.mData = paramArrayList;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.fU.put(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid, Integer.valueOf(i));
      localArrayList.add(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid);
      i += 1;
    }
    cF(localArrayList);
    notifyDataSetChanged();
  }
  
  public void setData(List<META.StMusic> paramList)
  {
    Object localObject;
    int i;
    if (ut() == 0)
    {
      localObject = new ArrayList();
      this.mData = ((List)localObject);
      localObject = new ArrayList();
      int k = ut();
      i = 0;
      label39:
      if (i >= paramList.size()) {
        break label159;
      }
      if (k != 0) {
        break label149;
      }
    }
    label149:
    for (int j = i;; j = ut() + i)
    {
      this.fU.put(((META.StMusic)paramList.get(i)).strSongMid.get(), Integer.valueOf(j));
      this.mData.add(new VsMusicItemInfo((META.StMusic)paramList.get(i)));
      ((ArrayList)localObject).add(((META.StMusic)paramList.get(i)).strSongMid.get());
      i += 1;
      break label39;
      localObject = this.mData;
      break;
    }
    label159:
    cF((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public void setListener(srs.a parama)
  {
    this.a = parama;
  }
  
  public int ut()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    private boolean aMM;
    private ImageView oL;
    private final View qG;
    private View qH;
    
    public a(View paramView)
    {
      super();
      this.oL = ((ImageView)paramView.findViewById(2131369904));
      this.qH = paramView.findViewById(2131367198);
      this.qG = paramView.findViewById(2131372095);
    }
    
    private RotateAnimation a()
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(3000L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      localRotateAnimation.setRepeatCount(-1);
      return localRotateAnimation;
    }
    
    public void bAy()
    {
      this.oL.clearAnimation();
      this.aMM = false;
    }
    
    public void bAz()
    {
      if (!this.aMM)
      {
        this.oL.startAnimation(a());
        this.aMM = true;
      }
    }
    
    public void showCover()
    {
      vb(true);
    }
    
    public void showProgressBar()
    {
      showProgressBar(true);
    }
    
    public void showProgressBar(boolean paramBoolean)
    {
      if (paramBoolean) {
        if (this.qG.getVisibility() == 8) {
          this.qG.setVisibility(0);
        }
      }
      while (this.qG.getVisibility() != 0) {
        return;
      }
      this.qG.setVisibility(8);
    }
    
    public void vb(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (this.oL.getVisibility() == 8) {
          this.oL.setVisibility(0);
        }
        if (this.qH.getVisibility() == 8) {
          this.qH.setVisibility(0);
        }
      }
      while (this.qH.getVisibility() != 0) {
        return;
      }
      this.qH.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssa
 * JD-Core Version:    0.7.0.1
 */