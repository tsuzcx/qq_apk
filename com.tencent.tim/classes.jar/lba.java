import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class lba
  extends lar<Long, BaseArticleInfo>
{
  public final String TAG = "ReadInJoyDynamicChannelAdapter";
  private lay a;
  private int aMR = -1;
  private View.OnClickListener cn = new lbb(this);
  
  public lba(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.jdField_a_of_type_Lay = new lay();
    this.jdField_a_of_type_Lay.a(this.mVafContext, 3);
  }
  
  private BaseArticleInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return (BaseArticleInfo)this.mData.get(paramInt);
    }
    return null;
  }
  
  private void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    try
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).getString("style_ID");
        if (!TextUtils.isEmpty(paramBaseArticleInfo))
        {
          QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "addViewTypeStyleMap, adapterViewType = ", Integer.valueOf(paramInt), ", styleID = ", paramBaseArticleInfo });
          this.ee.put(Integer.valueOf(paramInt), paramBaseArticleInfo);
          return;
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, styleID is null");
        return;
      }
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "addViewTypeStyleMap, e", paramBaseArticleInfo);
      return;
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, "addViewTypeStyleMap, proteusItemData is empty");
  }
  
  private void f(ArticleInfo paramArticleInfo)
  {
    lhu locallhu = lbz.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (kxm.B(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.amx) {
        localArticleInfo = ReadInJoyListViewGroup.b(paramArticleInfo);
      }
    }
    if (locallhu != null) {
      this.aMR = locallhu.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    g(localArticleInfo);
  }
  
  private void g(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "startWebFastActivity, articleInfo is null.");
      return;
    }
    kxm.a((Activity)this.mContext, paramArticleInfo);
  }
  
  public auwn a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Lay.dx(paramInt))
    {
      Object localObject = (String)this.ee.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = laq.a(this.mVafContext, getServiceId(), (String)localObject);
        if ((paramInt == lao.aMQ) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID =", localObject });
        localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          localObject = new ProteusItemView(this.mVafContext.getContext());
          QLog.d("ReadInJoyDynamicChannelAdapter", 2, "proteusItemView is null");
        }
        QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, proteusItemView = ", localObject, ", viewType = ", Integer.valueOf(paramInt) });
        return new lba.a((View)localObject);
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      if (laz.jdMethod_do(paramInt))
      {
        paramViewGroup = laz.a(this.mVafContext, paramInt, getServiceId());
        break;
      }
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onCreateViewHolder not the right type");
    }
  }
  
  public void a(auwn paramauwn, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramInt);
    int i = paramauwn.getItemViewType();
    ProteusItemView localProteusItemView = (ProteusItemView)paramauwn.itemView;
    if (localBaseArticleInfo != null)
    {
      if (!this.jdField_a_of_type_Lay.dx(i)) {
        break label160;
      }
      if (i != lao.aMQ) {
        break label140;
      }
      localProteusItemView.setVisibility(8);
    }
    for (;;)
    {
      c(Long.valueOf(localBaseArticleInfo.mArticleID), localBaseArticleInfo);
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, articleInfo = ", localBaseArticleInfo, ", proteusItemView = ", localProteusItemView, ", position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      EventCollector.getInstance().onRecyclerBindViewHolder(paramauwn, paramInt, getItemId(paramInt));
      return;
      label140:
      this.jdField_a_of_type_Lay.a(localProteusItemView, i, localBaseArticleInfo, this.mVafContext, paramInt);
      continue;
      label160:
      if (laz.jdMethod_do(i)) {
        laz.a(localProteusItemView, i, localBaseArticleInfo, this.mVafContext, paramInt, getServiceId());
      } else {
        QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(paramInt);
    int i = 0;
    paramInt = i;
    if (localBaseArticleInfo != null)
    {
      if (!this.jdField_a_of_type_Lay.N(localBaseArticleInfo)) {
        break label42;
      }
      paramInt = this.jdField_a_of_type_Lay.f(localBaseArticleInfo);
      a(paramInt, localBaseArticleInfo);
    }
    label42:
    do
    {
      return paramInt;
      if (localBaseArticleInfo.mShowBigPicture) {
        return 2;
      }
      paramInt = i;
    } while (TextUtils.isEmpty(localBaseArticleInfo.mFirstPagePicUrl));
    return 1;
  }
  
  public void j(int paramInt, View paramView)
  {
    paramView = (ArticleInfo)a(paramInt);
    if (paramView == null) {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick articleInfo is null.");
    }
    while (!kxm.a(paramView.mArticleContentUrl, paramView.mChannelID, paramView)) {
      return;
    }
    f(paramView);
  }
  
  public void onDestroy()
  {
    lhu locallhu = ((lcd)kxm.getAppRuntime().getManager(163)).b().a();
    if (locallhu != null) {
      locallhu.rm(this.aMR);
    }
    if (this.ee != null) {
      this.ee.clear();
    }
  }
  
  class a
    extends auwn
  {
    a(View paramView)
    {
      super();
      paramView.setTag(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lba
 * JD-Core Version:    0.7.0.1
 */