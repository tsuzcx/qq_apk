import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ajfl
  extends RecyclerView.Adapter<ajfl.a>
  implements aqdf.a
{
  private ajfl.b a;
  private SparseArray<Boolean> cW;
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private QQAppInterface mApp;
  private Context mContext;
  private List<RecentBaseData> mDataList;
  protected aajx mFaceDecoder;
  private final LayoutInflater mLayoutInflater;
  private RecyclerView mRecyclerView;
  
  public ajfl(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mRecyclerView = paramRecyclerView;
    this.mDataList = new ArrayList();
    this.cW = new SparseArray();
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
  }
  
  private void a(ajfl.a parama, int paramInt, Drawable paramDrawable)
  {
    boolean bool = true;
    RecentBaseData localRecentBaseData = (RecentBaseData)this.mDataList.get(paramInt);
    MsgBackupMsgUserData localMsgBackupMsgUserData;
    if ((localRecentBaseData instanceof MsgBackupMsgUserData))
    {
      localMsgBackupMsgUserData = (MsgBackupMsgUserData)localRecentBaseData;
      QQAppInterface localQQAppInterface = null;
      if (paramDrawable != null) {
        break label224;
      }
      paramDrawable = localQQAppInterface;
      if (this.mFaceDecoder != null) {
        paramDrawable = this.mFaceDecoder.a(localRecentBaseData);
      }
      if (!needDynamic(localRecentBaseData)) {
        break label233;
      }
      localQQAppInterface = ((BaseActivity)this.mContext).app;
      int j = ((Integer)aajx.a(localQQAppInterface, localRecentBaseData.ng(), localRecentBaseData.qx()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      RecentDynamicAvatarView localRecentDynamicAvatarView = parama.b;
      String str = localRecentBaseData.qx();
      if (localQQAppInterface.a.Bd() != 1) {
        break label227;
      }
      label146:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      parama.b.setImageDrawable(paramDrawable);
      parama.g.setText(localRecentBaseData.mTitleName);
      ajfl.a.a(parama).setChecked(((Boolean)this.cW.valueAt(paramInt)).booleanValue());
      if (AppSetting.enableTalkBack) {
        parama.root.setContentDescription(localMsgBackupMsgUserData.name);
      }
      return;
      label224:
      break;
      label227:
      bool = false;
      break label146;
      label233:
      parama.b.setImageDrawable(paramDrawable);
    }
  }
  
  private void b(ajfl.a parama, int paramInt, Drawable paramDrawable)
  {
    if ((paramInt < 0) || (paramInt >= this.mDataList.size())) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = (RecentBaseData)this.mDataList.get(paramInt);
    } while ((parama == null) || (localRecentBaseData == null));
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null)
    {
      int i = localRecentBaseData.ng();
      localDrawable = this.mFaceDecoder.a(i, localRecentBaseData.qx());
    }
    a(parama, paramInt, localDrawable);
  }
  
  public ajfl.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ajfl.a(this.mLayoutInflater.inflate(2131562957, paramViewGroup, false), this.a);
  }
  
  public void a(ajfl.a parama, int paramInt)
  {
    a(parama, paramInt, null);
    EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
  }
  
  public void a(ajfl.b paramb)
  {
    this.a = paramb;
  }
  
  public void cBd()
  {
    int j = this.cW.size();
    int i = 0;
    while (i < j)
    {
      this.cW.setValueAt(i, Boolean.valueOf(false));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void cS(List<RecentBaseData> paramList)
  {
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
  }
  
  protected void fN(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new auvj();
      }
      paramView.a.setSupportMaskView(true);
    }
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public void initState()
  {
    int j = this.mDataList.size();
    int i = 0;
    while (i < j)
    {
      this.cW.put(i, Boolean.valueOf(false));
      i += 1;
    }
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
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
            QLog.i("MsgBackup.BackupAndMigrateListAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
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
        paramBitmap = (ajfl.a)this.mRecyclerView.getChildViewHolder(paramBitmap);
        int i = paramBitmap.getAdapterPosition();
        Object localObject = (RecentBaseData)this.mDataList.get(i);
        if (localObject == null)
        {
          break label438;
          this.decodeFaceStartTime = l;
          break;
        }
        int j = ((RecentBaseData)localObject).ng();
        j = ((Integer)aajx.a(this.mApp, j, ((RecentBaseData)localObject).qx()).first).intValue();
        if (j == -2147483648) {
          break label438;
        }
        localObject = j + ":" + ((RecentBaseData)localObject).qx();
        localObject = (Bitmap)this.faceCache.get(localObject);
        if (localObject == null) {
          break label438;
        }
        b(paramBitmap, i, new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject));
        bool = true;
        break label438;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.faceCache.clear();
      return;
      label438:
      paramInt1 += 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onDestory();
    }
  }
  
  public void selectAll()
  {
    int j = this.cW.size();
    int i = 0;
    while (i < j)
    {
      this.cW.setValueAt(i, Boolean.valueOf(true));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public class a
    extends RecyclerView.ViewHolder
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
  {
    private ajfl.b b;
    public RecentDynamicAvatarView b;
    private CheckBox checkBox;
    public SingleLineTextView g;
    public View root;
    
    public a(View paramView, ajfl.b paramb)
    {
      super();
      this.root = paramView;
      this.checkBox = ((CheckBox)paramView.findViewById(2131369523));
      this.checkBox.setButtonDrawable(2130839257);
      this.checkBox.setOnCheckedChangeListener(null);
      this.checkBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131369459));
      this.g = ((SingleLineTextView)paramView.findViewById(2131369532));
      this.g.setTextColor(ajfl.a(ajfl.this).getResources().getColor(2131167311));
      this.jdField_b_of_type_Ajfl$b = paramb;
      ajfl.this.fN(this.jdField_b_of_type_ComTencentWidgetRecentDynamicAvatarView);
      paramView.setOnClickListener(this);
      paramView.setTag(this);
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (this.jdField_b_of_type_Ajfl$b != null)
      {
        int i = getAdapterPosition();
        if (QLog.isColorLevel()) {
          QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + i + ", isChecked = " + paramBoolean);
        }
        this.checkBox.setChecked(paramBoolean);
        ajfl.a(ajfl.this).setValueAt(i, Boolean.valueOf(paramBoolean));
        this.jdField_b_of_type_Ajfl$b.a(this.checkBox.isChecked(), (RecentBaseData)ajfl.a(ajfl.this).get(i));
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
    }
    
    public void onClick(View paramView)
    {
      CheckBox localCheckBox;
      if (this.jdField_b_of_type_Ajfl$b != null)
      {
        bool = this.checkBox.isChecked();
        localCheckBox = this.checkBox;
        if (bool) {
          break label39;
        }
      }
      label39:
      for (boolean bool = true;; bool = false)
      {
        localCheckBox.setChecked(bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, RecentBaseData paramRecentBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfl
 * JD-Core Version:    0.7.0.1
 */