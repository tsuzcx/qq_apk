import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class nmn
  implements nln, nlp
{
  private lva a;
  private Context context;
  private HashMap<String, Integer> dZ;
  private HashMap<String, BaseData> dataMap;
  private List<String> ix;
  
  public nmn(Context paramContext)
  {
    this.context = paramContext;
    this.a = new lva(paramContext);
    this.dataMap = new HashMap();
    this.dZ = new HashMap();
    this.ix = new ArrayList();
    aZx();
  }
  
  private PTSItemData a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    this.dataMap.put(paramBaseData.ame, paramBaseData);
    return paramBaseData.ptsItemData;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.3(this, paramPTSItemData));
  }
  
  private void aZx()
  {
    this.a.setLiteEventListener(new nmo(this));
  }
  
  public int a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    Integer localInteger = (Integer)this.dZ.get(paramBaseData.ptsLitePageName);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    QLog.e("WebPtsLiteViewCreator", 1, "[getViewType] error, pageName = " + paramBaseData.ptsLitePageName);
    return -1;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = a(paramBaseData);
    paramContext = this.a.a(null, paramContext);
    if (paramContext.getLayoutParams() != null) {
      paramContext.setLayoutParams(new AbsListView.LayoutParams(paramContext.getLayoutParams()));
    }
    return new nmn.a(paramContext, paramBaseData, null);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while ((!(paramBaseData instanceof ProteusItemData)) || (TextUtils.isEmpty(((ProteusItemData)paramBaseData).ptsLitePageName))) {
      return false;
    }
    return true;
  }
  
  public void aEe()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void aZw()
  {
    Object localObject = lwe.a().E("native_article");
    if (localObject == null)
    {
      QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], pageNameList is null");
      return;
    }
    int i = nlm.ban;
    localObject = ((List)localObject).iterator();
    i += 1;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.dZ.containsKey(str))
      {
        this.dZ.put(str, Integer.valueOf(i));
        QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], pageName = " + str + ", viewType = " + i);
      }
      i += 1;
    }
    nlm.ban += this.dZ.size() + 1;
    QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], view type count = " + nlm.ban);
  }
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.1(this));
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  class a
    extends nlm
  {
    private boolean atx;
    
    private a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      paramBaseData1 = nmn.a(nmn.this, paramBaseData2);
      if (this.atx) {
        nmn.a(nmn.this).a(this.itemView, paramBaseData1);
      }
      this.atx = true;
      nmn.a(nmn.this, paramBaseData1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmn
 * JD-Core Version:    0.7.0.1
 */