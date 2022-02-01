import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abep
  extends BaseAdapter
{
  private HashSet<String> aK = new HashSet();
  ssj b;
  boolean bCe = false;
  boolean bCf = true;
  JSONObject bc = null;
  protected int cnZ;
  Context mContext;
  ArrayList<JSONObject> sE = new ArrayList();
  
  public abep(Context paramContext, JSONArray paramJSONArray, ssj paramssj)
  {
    this.mContext = paramContext;
    this.b = paramssj;
    if (this.b != null) {}
    for (;;)
    {
      this.bCe = bool;
      o(paramJSONArray);
      return;
      bool = false;
    }
  }
  
  public boolean XU()
  {
    try
    {
      boolean bool = this.bCf;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cBj()
  {
    try
    {
      this.bCf = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cBk()
  {
    try
    {
      this.bCf = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void destroy()
  {
    if (this.bCe)
    {
      if (this.b != null)
      {
        this.b.tB("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
        this.b = null;
      }
      return;
    }
    HotChatPostItemView.oI.clear();
    HotChatPostItemView.L.clear();
  }
  
  public int getCount()
  {
    if (this.sE == null) {
      return 0;
    }
    return this.sE.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.sE == null) {
      return null;
    }
    return (JSONObject)this.sE.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) && (this.bCe)) {
      paramView = this.b.a("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
    }
    Object localObject;
    for (;;)
    {
      localObject = paramView;
      if (paramView == null)
      {
        localObject = new HotChatPostItemView(this.mContext);
        if (QLog.isColorLevel()) {
          QLog.e("HotChatPostListAdapter", 2, "loadPluginView failed");
        }
        this.bCe = false;
      }
      paramView = (JSONObject)getItem(paramInt);
      if (paramView != null) {
        ((View)localObject).setOnClickListener(new aber(this, paramView.optString("bid"), paramView.optString("pid")));
      }
      try
      {
        if (this.bc == null)
        {
          this.bc = new JSONObject();
          int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
          this.bc.put("densityDpi", this.mContext.getResources().getDisplayMetrics().densityDpi);
          this.bc.put("screenWidth", i);
        }
        this.bc.put("currentTime", NetConnInfoCenter.getServerTime());
        paramView.put("extra_info_key", this.bc);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("HotChatPostListAdapter", 2, localJSONException.toString());
            continue;
            ((HotChatPostItemView)localObject).setData(paramView.toString());
          }
        }
      }
      if (this.bCe)
      {
        ssj.a((View)localObject, paramView.toString());
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
    }
  }
  
  public void n(JSONArray paramJSONArray)
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    int i;
    if (paramJSONArray != null)
    {
      localArrayList = new ArrayList();
      localStringBuilder = new StringBuilder("filterPids:");
      i = 0;
    }
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          if (!localJSONObject.has("pid")) {
            break label172;
          }
          String str = localJSONObject.optString("pid");
          if (!this.aK.add(str))
          {
            localStringBuilder.append(str).append(",");
            this.cnZ += 1;
          }
          else
          {
            localArrayList.add(localJSONObject);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label172;
          }
        }
        QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, "process array" + localJSONException.toString());
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          this.sE.addAll(localArrayList);
          notifyDataSetChanged();
        }
        return;
      }
      label172:
      i += 1;
    }
  }
  
  public void notifyDataSetChanged()
  {
    Collections.sort(this.sE, new abeq(this));
    super.notifyDataSetChanged();
  }
  
  public void o(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.sE.clear();
      this.aK.clear();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            String str = localJSONObject.optString("pid");
            this.aK.add(str);
            this.sE.add(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, "setListItemsAndNotify JSONException:" + localJSONException.toString());
              }
            }
          }
        }
      }
      notifyDataSetChanged();
    }
  }
  
  public int zw()
  {
    if (this.sE == null) {}
    for (int i = 0;; i = this.sE.size()) {
      return i + this.cnZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abep
 * JD-Core Version:    0.7.0.1
 */