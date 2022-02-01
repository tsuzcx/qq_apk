import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class apkk
  extends RecyclerView.Adapter
{
  int CP = 0;
  public aplc a = new aplc();
  private ArrayList<apkn> ed = new ArrayList();
  
  public apkk(SparseArray<aplb> paramSparseArray)
  {
    this.a.c(paramSparseArray);
  }
  
  public int Lt()
  {
    int i = 0;
    int j = 0;
    while (i < this.ed.size())
    {
      j += ((apkn)this.ed.get(i)).getSize();
      i += 1;
    }
    return j;
  }
  
  public void WP(int paramInt)
  {
    if (this.ed != null)
    {
      this.a.f((apkn)this.ed.get(paramInt));
      this.ed.remove(paramInt);
    }
  }
  
  public apkn a(int paramInt)
  {
    if (this.ed != null)
    {
      if ((paramInt >= 0) && (paramInt < this.ed.size())) {
        return (apkn)this.ed.get(paramInt);
      }
      QLog.e("XMediaEditor", 2, "getEditItemInfo index out of bound, index:" + paramInt + ", mItemList.size():" + this.ed.size());
    }
    return null;
  }
  
  public void a(int paramInt, apkn paramapkn)
  {
    if (this.ed != null)
    {
      this.a.d(paramapkn);
      this.ed.add(paramInt, paramapkn);
    }
  }
  
  public boolean aBh()
  {
    return (this.ed.size() > 0) && (((apkn)this.ed.get(0)).getType() == -1);
  }
  
  public boolean aBi()
  {
    int i = 0;
    while (i < this.ed.size())
    {
      if (!((apkn)this.ed.get(i)).aBi()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(apkn paramapkn)
  {
    if (this.ed != null)
    {
      this.a.d(paramapkn);
      this.ed.add(paramapkn);
    }
  }
  
  public void dR(int paramInt, String paramString)
  {
    apkn localapkn = a(paramInt);
    if (localapkn != null)
    {
      localapkn.SX(paramString);
      notifyItemChanged(paramInt);
      this.a.e(localapkn);
    }
  }
  
  public ArrayList<apku> dS()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ed.size())
    {
      apkn localapkn = (apkn)this.ed.get(i);
      if (((localapkn instanceof apku)) && (((apku)localapkn).mUploadStatus != 3)) {
        localArrayList.add((apku)localapkn);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<apkr> dT()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ed.size())
    {
      apkn localapkn = (apkn)this.ed.get(i);
      if ((localapkn instanceof apkr)) {
        localArrayList.add((apkr)localapkn);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void fb(ArrayList<apku> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      apku localapku = (apku)paramArrayList.get(i);
      this.a.a(localapku);
      i += 1;
    }
  }
  
  public String getData()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < this.ed.size())
    {
      apkn localapkn = (apkn)this.ed.get(i);
      if (localapkn.getType() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localapkn.af());
      }
    }
    return localJSONArray.toString();
  }
  
  public int getItemCount()
  {
    return this.ed.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((apkn)this.ed.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((apkn)this.ed.get(paramInt)).getType();
  }
  
  public int getShowType()
  {
    return this.CP;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    apkn localapkn = (apkn)this.ed.get(paramInt);
    localapkn.mPosition = paramInt;
    this.a.a(paramViewHolder, localapkn, this.CP);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.a.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.a.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.a.onViewDetachedFromWindow(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.a.onViewRecycled(paramViewHolder);
  }
  
  public void release()
  {
    this.a.release();
  }
  
  public void setShowType(int paramInt)
  {
    this.CP = paramInt;
  }
  
  public void w(JSONArray paramJSONArray)
  {
    int i = 0;
    int j;
    for (;;)
    {
      try
      {
        if (i < this.ed.size())
        {
          this.a.f((apkn)this.ed.get(i));
          i += 1;
          continue;
        }
        this.ed.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject = apko.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label253;
          }
          b((apkn)localObject);
          break label253;
        }
        j = this.ed.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label245;
        }
        Object localObject = (apkn)this.ed.get(j);
        if (!(localObject instanceof apkt)) {
          break label272;
        }
        if (paramJSONArray != null) {
          break label250;
        }
        paramJSONArray = (apkt)localObject;
        if (i == 0) {
          break label267;
        }
        apkt localapkt = (apkt)this.ed.get(j + 1);
        localObject = (apkt)localObject;
        if (TextUtils.isEmpty(localapkt.mText))
        {
          WP(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((apkt)localObject).mText))
        {
          ((apkt)localObject).mText = localapkt.mText;
          continue;
        }
        ((apkt)localObject).mText = (((apkt)localObject).mText + "\n" + localapkt.mText);
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      continue;
      label245:
      notifyDataSetChanged();
      return;
      label250:
      continue;
      label253:
      i += 1;
    }
    for (;;)
    {
      j -= 1;
      break;
      label267:
      i = 1;
      continue;
      label272:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkk
 * JD-Core Version:    0.7.0.1
 */