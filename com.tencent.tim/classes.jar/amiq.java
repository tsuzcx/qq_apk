import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class amiq
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements aqdf.a
{
  private amiq.a a;
  private boolean aKL = true;
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private QQAppInterface mApp;
  private final Context mContext;
  private ArrayList<RecentBaseData> mDataList;
  protected aajx mFaceDecoder;
  private final LayoutInflater mLayoutInflater;
  private RecyclerView mRecyclerView;
  private int scene = -1;
  
  public amiq(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView, int paramInt)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mRecyclerView = paramRecyclerView;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mDataList = new ArrayList();
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
    this.scene = paramInt;
    if (paramInt == 1) {
      this.aKL = false;
    }
  }
  
  private void a(amiq.c paramc, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    boolean bool = true;
    RecentDynamicAvatarView localRecentDynamicAvatarView = null;
    if (paramDrawable == null)
    {
      paramDrawable = localRecentDynamicAvatarView;
      if (this.mFaceDecoder != null) {
        paramDrawable = this.mFaceDecoder.a(paramRecentBaseData);
      }
      if (!needDynamic(paramRecentBaseData)) {
        break label182;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotAdapter", 2, "bindview user:" + paramRecentBaseData.qx());
      }
      int j = ((Integer)aajx.a(this.mApp, paramRecentBaseData.ng(), paramRecentBaseData.qx()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      localRecentDynamicAvatarView = paramc.a;
      QQAppInterface localQQAppInterface = this.mApp;
      String str = paramRecentBaseData.qx();
      if (this.mApp.a.Bd() != 1) {
        break label176;
      }
      label143:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramc.mNickName.setText(paramRecentBaseData.getTitleName());
      return;
      break;
      label176:
      bool = false;
      break label143;
      label182:
      paramc.a.setImageDrawable(paramDrawable);
    }
  }
  
  @Nullable
  private RecentBaseData b(int paramInt)
  {
    if ((paramInt > 0) && (this.aKL)) {
      return (RecentBaseData)this.mDataList.get(paramInt - 1);
    }
    return (RecentBaseData)this.mDataList.get(paramInt);
  }
  
  private void b(amiq.c paramc, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramc == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.ng();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).WD())) {
        break label68;
      }
      i = 3002;
    }
    label68:
    for (;;)
    {
      localDrawable = this.mFaceDecoder.a(i, paramRecentBaseData.qx());
      a(paramc, paramRecentBaseData, localDrawable);
      return;
    }
  }
  
  public void a(amiq.a parama)
  {
    this.a = parama;
  }
  
  public void cS(List<RecentBaseData> paramList)
  {
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.aKL) {
      return this.mDataList.size() + 1;
    }
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.aKL)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof amiq.c))
    {
      RecentBaseData localRecentBaseData = b(paramInt);
      a((amiq.c)paramViewHolder, localRecentBaseData, null);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt == 0) && (this.aKL)) {
      return new amiq.b(this.mLayoutInflater.inflate(2131563004, paramViewGroup, false));
    }
    return new amiq.c(this.mLayoutInflater.inflate(2131561645, paramViewGroup, false), this.a);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.faceCache.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.faceCache)
            {
              if (this.faceCache.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("ScreenShotAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      this.decodeFaceStartTime = 0L;
      paramInt2 = this.mRecyclerView.getChildCount();
      paramInt1 = 0;
      bool = false;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.mRecyclerView.getChildAt(paramInt1);
        paramBitmap = this.mRecyclerView.getChildViewHolder(paramBitmap);
        if (!(paramBitmap instanceof amiq.c))
        {
          break label439;
          this.decodeFaceStartTime = l;
          break;
        }
        paramBitmap = (amiq.c)paramBitmap;
        RecentBaseData localRecentBaseData = b(paramBitmap.getAdapterPosition());
        if (localRecentBaseData == null) {
          break label439;
        }
        int i = localRecentBaseData.ng();
        i = ((Integer)aajx.a(this.mApp, i, localRecentBaseData.qx()).first).intValue();
        if (i == -2147483648) {
          break label439;
        }
        Object localObject = i + ":" + localRecentBaseData.qx();
        localObject = (Bitmap)this.faceCache.get(localObject);
        if (localObject == null) {
          break label439;
        }
        b(paramBitmap, localRecentBaseData, new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject));
        bool = true;
        break label439;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ScreenShotAdapter", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.faceCache.clear();
      return;
      label439:
      paramInt1 += 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onDestory();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    b(View paramView)
    {
      super();
    }
  }
  
  public class c
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public RecentDynamicAvatarView a;
    private amiq.a b;
    public final TextView mNickName;
    
    public c(View paramView, amiq.a parama)
    {
      super();
      this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368698));
      this.mNickName = ((TextView)paramView.findViewById(2131372384));
      this.b = parama;
      paramView.setOnClickListener(this);
      paramView.setTag(this);
    }
    
    public void onClick(View paramView)
    {
      if ((this.b != null) && (amiq.a(this.jdField_a_of_type_Amiq))) {
        this.b.onItemClick(paramView, getAdapterPosition() - 1);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.b != null) {
          this.b.onItemClick(paramView, getAdapterPosition());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiq
 * JD-Core Version:    0.7.0.1
 */