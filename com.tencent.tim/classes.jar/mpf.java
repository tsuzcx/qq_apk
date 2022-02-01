import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "mDataList", "", "bindViewHolder", "", "bean", "holder", "(Ljava/lang/Object;Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;)V", "createView", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "(Landroid/content/Context;Landroid/view/View;)Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "BaseSelectViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class mpf<BEAN, HOLDER extends mpf.a>
  extends BaseAdapter
{
  @NotNull
  private final Context context;
  private List<BEAN> mDataList;
  
  public mpf(@NotNull Context paramContext)
  {
    this.context = paramContext;
    this.mDataList = ((List)new ArrayList());
  }
  
  @NotNull
  public abstract View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup);
  
  @NotNull
  public abstract HOLDER a(@NotNull Context paramContext, @NotNull View paramView);
  
  public abstract void a(BEAN paramBEAN, @NotNull HOLDER paramHOLDER);
  
  @NotNull
  public final List<BEAN> be()
  {
    return this.mDataList;
  }
  
  public final void cS(@NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    this.mDataList.clear();
    this.mDataList.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  @NotNull
  public final Context getContext()
  {
    return this.context;
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  @NotNull
  public Object getItem(int paramInt)
  {
    Object localObject = this.mDataList.get(paramInt);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = a(this.context, paramViewGroup);
      localObject = this.context;
      if (localView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject = a((Context)localObject, (View)localView);
      localView.setTag(localObject);
    }
    for (;;)
    {
      a(this.mDataList.get(paramInt), (mpf.a)localObject);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = paramView.getTag();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type HOLDER");
      }
      localObject = (mpf.a)localObject;
      localView = paramView;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "", "()V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpf
 * JD-Core Version:    0.7.0.1
 */