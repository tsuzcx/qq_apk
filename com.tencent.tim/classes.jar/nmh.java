import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class nmh
  implements nln, nlp
{
  private VafContext a;
  private final Map<String, Integer> dJ = new ConcurrentHashMap();
  private BaseAdapter mAdapter;
  private Context mContext;
  
  private void f(Container paramContainer)
  {
    int i = 8;
    int j = 0;
    ViewBase localViewBase;
    if (paramContainer != null)
    {
      localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        if (!NetworkState.isWifiConn()) {
          break label64;
        }
      }
    }
    for (;;)
    {
      if (paramContainer != null) {
        paramContainer.setVisibility(j);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(i);
      }
      return;
      label64:
      j = 8;
      i = 0;
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData))
    {
      paramBaseData = (ProteusItemData)paramBaseData;
      if (paramBaseData.mTemplateBean != null)
      {
        paramBaseData = paramBaseData.mTemplateBean.getStyleName();
        Integer localInteger = (Integer)this.dJ.get(paramBaseData);
        if (localInteger != null) {
          return localInteger.intValue();
        }
        QLog.d("WebProteusViewCreator", 1, "getViewType error,styleName:" + paramBaseData);
      }
    }
    return -1;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      this.a = new luh();
      this.a.setContext(paramContext);
      kvx.a(this.a, "native_article");
    }
    if (this.mContext == null) {
      this.mContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramViewGroup = null;
    try
    {
      localObject = this.a.getViewFactory().inflate(this.a, localProteusItemData.mTemplateBean);
      paramViewGroup = (ViewGroup)localObject;
      kvx.a(((Container)localObject).getVirtualView(), localProteusItemData.mTemplateBean.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.aD.toString();
      paramViewGroup = (ViewGroup)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        boolean bool;
        String str = "error!! msg=" + localException.toString();
      }
    }
    bool = false;
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new View(paramContext);
      bool = true;
    }
    QLog.d("WebProteusViewCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    if ((paramBaseData instanceof ProteusAnimationItemData)) {
      ((ProteusAnimationItemData)paramBaseData).setView((View)localObject);
    }
    return new nmh.a((View)localObject, localProteusItemData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void aEe() {}
  
  public void cm(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          this.a = new luh();
          this.a.setContext(paramContext);
          kvx.a(this.a, "native_article");
          paramContext = this.a.getTemplateFactory().getNameTemplateMap().keySet();
          nlm.ban = 32;
          int i = nlm.ban + 1;
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            String str = (String)paramContext.next();
            if (!this.dJ.containsKey(str))
            {
              this.dJ.put(str, Integer.valueOf(i));
              i += 1;
            }
          }
          else
          {
            QLog.d("WebProteusViewCreator", 1, "VIEW_TYPE_COUNT=" + nlm.ban + ",NAME_VIEWTYPE_MAP size=" + this.dJ.size() + "type=" + i);
            nlm.ban += this.dJ.size() + 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("WebProteusViewCreator", 1, "initProteusTypeCount error,msg:" + paramContext.toString());
        return;
      }
    }
  }
  
  public void g(BaseAdapter paramBaseAdapter)
  {
    this.mAdapter = paramBaseAdapter;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  class a
    extends nlm
  {
    private Container b;
    private ArrayList<String> lM;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      if ((paramView instanceof Container)) {
        this.b = ((Container)paramView);
      }
    }
    
    private boolean FM()
    {
      return !aqiz.O(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
    }
    
    private void a(Context paramContext, ProteusItemData paramProteusItemData)
    {
      ViewFactory.findClickableViewListener(this.b.getVirtualView(), new nmi(this, paramProteusItemData, paramContext));
    }
    
    private void a(View paramView, BaseData paramBaseData)
    {
      if ((paramView == null) || (paramBaseData == null)) {}
      for (;;)
      {
        return;
        try
        {
          ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
          if (((ProteusItemData)paramBaseData).bad == 1)
          {
            paramView.setOnLongClickListener(new nmk(this, paramView, localProteusItemData));
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("WebProteusViewCreator", 1, "addLongClickListener error,msg:" + paramView.toString());
        }
      }
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      if ((this.b == null) || (paramBaseData2 == null)) {}
      for (;;)
      {
        return;
        if (!(paramBaseData2 instanceof ProteusItemData)) {
          continue;
        }
        paramBaseData1 = (ProteusItemData)paramBaseData2;
        TemplateBean localTemplateBean = paramBaseData1.mTemplateBean;
        if (localTemplateBean != null) {
          nmh.a(nmh.this, this.b);
        }
        try
        {
          localTemplateBean.bindData(paramBaseData1.aD);
          kvx.a(this.b.getVirtualView(), paramBaseData1.mTemplateBean.getViewBean());
          this.g = paramBaseData1;
          label77:
          a(nmh.a(nmh.this), paramBaseData1);
          a(this.b, paramBaseData2);
          if (!(paramBaseData2 instanceof ProteusAnimationItemData)) {
            continue;
          }
          ((ProteusAnimationItemData)paramBaseData2).setView(this.itemView);
          return;
        }
        catch (Exception localException)
        {
          break label77;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmh
 * JD-Core Version:    0.7.0.1
 */