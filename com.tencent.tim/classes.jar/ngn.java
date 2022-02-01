import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ngn
  extends ndi
{
  private static lrj c = new lrj();
  private SparseArray<lfz> au;
  private Activity mActivity;
  private Context mContext;
  private VafContext mVafContext = new luh();
  
  public ngn(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<lfz> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.mActivity = paramActivity;
    this.mContext = paramContext;
    this.au = paramSparseArray;
    a(this.au);
    this.mVafContext.setContext(paramActivity);
    this.mVafContext.setCurActivity(paramActivity);
    kvx.a(this.mVafContext, "default_feeds");
    c.b(this.mVafContext);
  }
  
  private void a(SparseArray<lfz> paramSparseArray)
  {
    this.au = paramSparseArray;
    int i = 0;
    while (i < this.au.size())
    {
      ((lfz)this.au.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public boolean Fo()
  {
    return false;
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return null;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList) {}
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1) {}
  
  public void cY(List<View> paramList)
  {
    this.gO = new ArrayList();
    notifyDataSetChanged();
  }
  
  public BaseArticleInfo d(int paramInt)
  {
    return null;
  }
  
  public int dA(int paramInt)
  {
    return ndi.k((ArticleInfo)getItem(paramInt));
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public int getCount()
  {
    if (this.gO != null) {
      return this.gO.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.gO != null) && (paramInt < this.gO.size())) {
      return (BaseArticleInfo)this.gO.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return dA(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.gO == null) || (this.gO.size() == 0)) {}
    int i;
    for (Object localObject = null;; localObject = (View)lgd.a(this.au, new ngp(this, "onAdapterGetView", i, (BaseArticleInfo)localObject, paramInt, paramViewGroup)))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = c(paramInt);
      i = getItemViewType(paramInt);
      QLog.d("ReadInJoyProteusFamilyAdapter", 2, "getView | position : " + paramInt + " type : " + i + " article_title = " + ((BaseArticleInfo)localObject).mTitle);
    }
  }
  
  public boolean m(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean n(int paramInt, long paramLong)
  {
    return false;
  }
  
  public void setData(List<BaseArticleInfo> paramList)
  {
    if ((this.gO != null) && (paramList != null)) {
      this.gO.addAll(paramList);
    }
    lgd.a(this.au, new ngo(this, "onSetData", paramList));
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngn
 * JD-Core Version:    0.7.0.1
 */