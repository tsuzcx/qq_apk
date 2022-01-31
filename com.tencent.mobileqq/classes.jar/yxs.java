import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class yxs
  extends RecyclerView.Adapter<yxv>
  implements Handler.Callback
{
  private bhow jdField_a_of_type_Bhow;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<VsMusicItemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yxh jdField_a_of_type_Yxh;
  private yxr jdField_a_of_type_Yxr;
  
  private int a(int paramInt)
  {
    if (a() == 0) {
      return 0;
    }
    return paramInt % a();
  }
  
  private void b(List<VsMusicItemInfo> paramList)
  {
    int i = 0;
    while (i < a())
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(((VsMusicItemInfo)paramList.get(i)).mSongMid, Integer.valueOf(i));
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public bhow a()
  {
    if (this.jdField_a_of_type_Bhow == null) {
      this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_Bhow;
  }
  
  public VsMusicItemInfo a(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= a()) {
      i = a(paramInt);
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (VsMusicItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  public List<VsMusicItemInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public yxv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new yxv(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562796, null));
  }
  
  public void a(ArrayList<VsMusicItemInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid, Integer.valueOf(i));
      localArrayList.add(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid);
      i += 1;
    }
    b(localArrayList);
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(paramArrayList), new yxu(this, paramBoolean));
  }
  
  public void a(List<META.StMusic> paramList)
  {
    Object localObject;
    int i;
    if (a() == 0)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      localObject = new ArrayList();
      int k = a();
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
    for (int j = i;; j = a() + i)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(((META.StMusic)paramList.get(i)).strSongMid.get(), Integer.valueOf(j));
      this.jdField_a_of_type_JavaUtilList.add(new VsMusicItemInfo((META.StMusic)paramList.get(i)));
      ((ArrayList)localObject).add(((META.StMusic)paramList.get(i)).strSongMid.get());
      i += 1;
      break label39;
      localObject = this.jdField_a_of_type_JavaUtilList;
      break;
    }
    label159:
    b((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public void a(yxr paramyxr)
  {
    this.jdField_a_of_type_Yxr = paramyxr;
  }
  
  public void a(yxv paramyxv, int paramInt)
  {
    if (a() == 0) {}
    int i;
    VsMusicItemInfo localVsMusicItemInfo;
    do
    {
      return;
      if (paramInt >= a()) {
        break;
      }
      i = paramInt;
      localVsMusicItemInfo = (VsMusicItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    } while (localVsMusicItemInfo == null);
    if (localVsMusicItemInfo.isDownloading()) {
      paramyxv.c();
    }
    for (;;)
    {
      xod.a(yxv.a(paramyxv), localVsMusicItemInfo.mAlbumUrl, xod.a(paramyxv.itemView.getContext(), 60.0F), xod.a(paramyxv.itemView.getContext(), 60.0F), xod.a(paramyxv.itemView.getContext(), 30.0F), paramyxv.itemView.getContext().getResources().getDrawable(2130838626), null);
      paramyxv.itemView.setOnClickListener(new yxt(this, paramInt, localVsMusicItemInfo));
      return;
      i = a(paramInt);
      break;
      paramyxv.b(false);
    }
  }
  
  public boolean a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramVsMusicItemInfo.mSongMid) == null)
    {
      paramInt = a(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramVsMusicItemInfo.mSongMid, Integer.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramVsMusicItemInfo);
      b(this.jdField_a_of_type_JavaUtilList);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    a(paramArrayList, false);
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
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView = ((SmartMusicRecyclerView)paramRecyclerView);
    this.jdField_a_of_type_Yxh = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.a();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    a().removeCallbacks(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxs
 * JD-Core Version:    0.7.0.1
 */