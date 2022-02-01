import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicView.b;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "bindViewHolder", "", "topicInfo", "holder", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mpm
  extends mpf<ColumnInfo, SelectTopicView.b>
{
  public mpm(Context paramContext)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(2131560402, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…  false\n                )");
    return paramContext;
  }
  
  @NotNull
  public SelectTopicView.b a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(2131379862);
    TextView localTextView = (TextView)paramView.findViewById(2131380068);
    paramView = (ImageView)paramView.findViewById(2131369717);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverView");
    return new SelectTopicView.b(paramContext, localTextView, paramView);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, @NotNull SelectTopicView.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramb, "holder");
    paramb.g().setImageDrawable((Drawable)URLDrawable.getDrawable(paramColumnInfo.coverUrl, URLDrawable.URLDrawableOptions.obtain()));
    Drawable localDrawable = getContext().getResources().getDrawable(2130843862);
    localDrawable.setBounds(0, 0, rpq.dip2px(getContext(), 15.0F), rpq.dip2px(getContext(), 15.0F));
    TextView localTextView = paramb.p();
    localTextView.setText((CharSequence)paramColumnInfo.title);
    localTextView.setCompoundDrawablePadding(rpq.dip2px(localTextView.getContext(), 3.0F));
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramColumnInfo = getContext().getResources().getString(0, new Object[] { Integer.valueOf(paramColumnInfo.videoCount), Integer.valueOf(paramColumnInfo.subscribeCount) });
    paramb.q().setText((CharSequence)paramColumnInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpm
 * JD-Core Version:    0.7.0.1
 */