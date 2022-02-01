import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afie<T>
  extends BaseAdapter
{
  JSONArray K;
  private boolean aVU;
  private boolean bYi;
  public int cRa;
  private Drawable eB;
  Handler handler;
  private HashMap<EmoticonPackage, Boolean> kl = new HashMap();
  private LruCache<String, Drawable> mCache = new LruCache(30);
  protected Context mContext;
  protected List<T> mData;
  private Object mLock = new Object();
  
  public afie(Context paramContext, List<T> paramList)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.eB = this.mContext.getResources().getDrawable(2130839309);
    aqpi.a((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime(), aqpi.d);
    paramContext = aqpi.d.e(this.mContext);
    if (paramContext != null) {}
    try
    {
      this.K = paramContext.getJSONArray("wording");
      this.handler = new Handler();
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private Drawable a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.mCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.mCache.get(paramEmoticonPackage.epId);
    }
    Drawable localDrawable = afgc.c(2, paramEmoticonPackage.epId);
    if (localDrawable != null)
    {
      this.mCache.put(paramEmoticonPackage.epId, localDrawable);
      return localDrawable;
    }
    return this.eB;
  }
  
  public void cZI()
  {
    this.kl.clear();
  }
  
  public void clearCache()
  {
    this.mCache.evictAll();
  }
  
  public List<EmoticonPackage> eJ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public T getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new afie.a();
      localView = View.inflate(this.mContext, 2131559316, null);
      paramView.itemIcon = ((ImageView)localView.findViewById(2131366358));
      paramView.eL = ((ImageView)localView.findViewById(2131366363));
      paramView.yH = ((ImageView)localView.findViewById(2131366134));
      paramView.yI = ((ImageView)localView.findViewById(2131366135));
      paramView.Rw = ((TextView)localView.findViewById(2131366362));
      paramView.yJ = ((ImageView)localView.findViewById(2131366359));
      paramView.Rx = ((TextView)localView.findViewById(2131366364));
      paramView.jJ = localView.findViewById(2131378161);
      paramView.BK = localView.findViewById(2131381295);
      paramView.yK = ((ImageView)localView.findViewById(2131366360));
      paramView.BL = localView.findViewById(2131366357);
      localView.setTag(paramView);
      paramViewGroup.setTag(paramView);
      localView.setBackgroundResource(2130840170);
      localObject = (EmoticonPackage)this.mData.get(paramInt);
      paramView.Rw.setText(((EmoticonPackage)localObject).name);
      paramView.itemIcon.setImageDrawable(a((EmoticonPackage)localObject));
      paramView.jJ.setVisibility(8);
      if (!((EmoticonPackage)localObject).hasSound) {
        break label454;
      }
      paramView.yJ.setVisibility(0);
      if (!((EmoticonPackage)localObject).isNewVoiceType()) {
        break label441;
      }
      paramView.yJ.setImageResource(2130838382);
      label276:
      if (!this.aVU) {
        break label521;
      }
      if (ji(paramInt)) {
        break label466;
      }
      localView.setContentDescription(this.mContext.getString(2131693343) + " " + ((EmoticonPackage)localObject).name);
      paramView.eL.setImageResource(2130847987);
      label343:
      paramView.eL.setVisibility(0);
      paramView.yH.setVisibility(0);
      paramView.BL.setVisibility(8);
      label368:
      if (((EmoticonPackage)localObject).mobileFeetype != 4) {
        break label560;
      }
      paramView.yK.setVisibility(0);
      paramView.yK.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840178));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afie.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label441:
      paramView.yJ.setImageResource(2130840179);
      break label276;
      label454:
      paramView.yJ.setVisibility(8);
      break label276;
      label466:
      localView.setContentDescription(this.mContext.getString(2131693331) + " " + ((EmoticonPackage)localObject).name);
      paramView.eL.setImageResource(2130847988);
      break label343;
      label521:
      localView.setContentDescription(((EmoticonPackage)localObject).name);
      paramView.eL.setVisibility(8);
      paramView.yH.setVisibility(8);
      paramView.BL.setVisibility(0);
      break label368;
      label560:
      if (((EmoticonPackage)localObject).mobileFeetype == 5)
      {
        paramView.yK.setVisibility(0);
        paramView.yK.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130848302));
      }
      else
      {
        paramView.yK.setVisibility(8);
      }
    }
  }
  
  public void insert(T paramT, int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mData.add(paramInt, paramT);
      if (this.bYi) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public boolean ji(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.kl.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.kl.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.bYi = true;
  }
  
  public void remove(T paramT)
  {
    synchronized (this.mLock)
    {
      if ((paramT instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramT;
        this.kl.remove(localEmoticonPackage);
      }
      this.mData.remove(paramT);
      if (this.bYi) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.aVU = paramBoolean;
  }
  
  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.bYi = paramBoolean;
  }
  
  public void setSelected(int paramInt)
  {
    boolean bool = ji(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    HashMap localHashMap = this.kl;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
  }
  
  public class a
  {
    View BK;
    View BL;
    TextView Rw;
    TextView Rx;
    ImageView eL;
    ImageView itemIcon;
    View jJ;
    ImageView yH;
    ImageView yI;
    ImageView yJ;
    ImageView yK;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afie
 * JD-Core Version:    0.7.0.1
 */