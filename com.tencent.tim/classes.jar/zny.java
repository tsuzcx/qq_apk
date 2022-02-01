import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.a;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class zny
  extends BaseAdapter
  implements View.OnClickListener, aqdf.a
{
  MiniMsgTabFragment.a jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a;
  private znz jdField_a_of_type_Znz = new znz();
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> h = new Hashtable();
  private QQAppInterface mApp;
  private Context mContext;
  protected final ArrayList<RecentBaseData> mDataList = new ArrayList(99);
  protected aajx mFaceDecoder = new aajx(paramQQAppInterface, this, false);
  protected XListView mListView;
  
  public zny(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, MiniMsgTabFragment.a parama)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a = parama;
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localDrawable = paramDrawable;
        if (this.mFaceDecoder != null) {
          localDrawable = this.mFaceDecoder.a(paramRecentBaseData.ng(), paramRecentBaseData.qx());
        }
      }
    } while (this.jdField_a_of_type_Znz == null);
    this.jdField_a_of_type_Znz.a(paramView, paramRecentBaseData, this.mContext, localDrawable);
  }
  
  protected View aW()
  {
    return View.inflate(this.mContext, 2131559623, null);
  }
  
  public void cS(List<RecentBaseData> paramList)
  {
    this.mDataList.clear();
    int i;
    if (paramList != null) {
      i = -1;
    }
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if (localRecentBaseData != null)
          {
            i += 1;
            if ((localRecentBaseData instanceof RecentItemChatMsgData)) {
              localRecentBaseData.mPosition = i;
            }
            this.mDataList.add(localRecentBaseData);
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("MiniMsgTabAdapter", 2, "setDataList, [item is null]");
          }
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgTabAdapter", 2, paramList, new Object[0]);
        }
      }
      if (this.mDataList.size() > 0) {
        this.mListView.setVisibility(0);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabAdapter", 2, "setDataList, size = 0");
        }
      }
    }
  }
  
  public void destroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onDestory();
    }
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramInt < this.mDataList.size()) {
        localObject1 = this.mDataList.get(paramInt);
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.i("MiniMsgTabAdapter", 2, localException.toString());
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)getItem(paramInt);
    if ((localRecentBaseData != null) && (localRecentBaseData.qx().equals(Integer.valueOf(0)))) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject = getItem(paramInt);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        if (((RecentBaseData)localObject).qx().equals("0"))
        {
          if (paramView != null) {
            break label120;
          }
          paramView = aW();
          paramView.setTag(-1, Integer.valueOf(paramInt));
          paramView.setOnClickListener(this);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = this.jdField_a_of_type_Znz.a(paramInt, localObject, this.mFaceDecoder, paramView, paramViewGroup, this.mContext, this, null, null);
      }
    }
    catch (Throwable paramView)
    {
      aako.a(this.mContext, false, paramView);
      throw new RuntimeException(paramView);
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onAccountChanged(paramQQAppInterface);
    }
    if (this.mApp != paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
      cS(null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniMsgTabAdapter", 2, "onAccountChanged: invoked. Message: app: " + paramQQAppInterface);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(-1);
    if (!(localObject instanceof Integer)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "RecentAdpater onClick tag is not int");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = getItem(((Integer)localObject).intValue());
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        if (QLog.isDevelopLevel()) {
          QLog.i("MiniMsgTabAdapter", 2, "mTitleName" + ((RecentBaseData)localObject).mTitleName + ", msgSummary " + ((RecentBaseData)localObject).mLastMsg);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$a.b((RecentBaseData)localObject);
          ((RecentBaseData)localObject).cuQ();
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.mListView == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    boolean bool1;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.h.put(paramInt2 + ":" + paramString, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            bool1 = true;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
              if (paramBitmap != null) {
                break label265;
              }
              bool2 = true;
              QLog.d("MiniMsgTabAdapter", 2, bool2);
            }
            if ((paramInt1 > 0) && (!bool1)) {
              continue;
            }
            synchronized (this.h)
            {
              if (this.h.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            QLog.i("MiniMsgTabAdapter", 1, "onDecodeTaskCompleted error:" + localOutOfMemoryError.getMessage());
            continue;
            bool1 = false;
            continue;
            label265:
            boolean bool2 = false;
          }
        }
      }
    }
    if (paramInt1 == 0)
    {
      this.decodeFaceStartTime = 0L;
      bool1 = false;
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.mListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(localView);
        if (localRecentBaseData == null)
        {
          break label667;
          this.decodeFaceStartTime = l;
          break;
        }
        int i = localRecentBaseData.ng();
        paramString = localRecentBaseData.qx();
        i = ((Integer)aajx.a(this.mApp, i, paramString).first).intValue();
        if (i == -2147483648) {
          break label667;
        }
        paramString = i + ":" + paramString;
        paramString = (Bitmap)this.h.get(paramString);
        if (paramString == null) {
          break label667;
        }
        if (i == 103)
        {
          l = System.currentTimeMillis();
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130840893);
          if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
          }
          if ((paramBitmap instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramBitmap).setGravity(81);
          }
          paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
          paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
          paramString = paramBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.i("MiniMsgTabAdapter", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
          }
        }
        for (paramString = paramBitmap;; paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString))
        {
          a(localView, localRecentBaseData, paramString);
          bool1 = true;
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MiniMsgTabAdapter", 4, "decodecomplete|faceCache size = " + this.h.size() + ", isNeedUpdateAvatar=" + bool1);
      }
      this.h.clear();
      return;
      label667:
      paramInt1 += 1;
    }
  }
  
  public static class a
  {
    public RecentDynamicAvatarView a;
    public DragTextView g;
    public SingleLineTextView x;
    public SingleLineTextView y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zny
 * JD-Core Version:    0.7.0.1
 */