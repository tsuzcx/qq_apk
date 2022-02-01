import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ayrf
  extends BaseAdapter
  implements View.OnClickListener
{
  private ayrb a;
  private int aOw;
  private ayrm b;
  private aduk c;
  private aduk d;
  private aduk e;
  private Bitmap fd;
  private aduk h;
  private ConcurrentHashMap<Integer, URLDrawable> mActiveThumbDrawable = new ConcurrentHashMap();
  private Context mContext;
  private List<ayrk> xq;
  
  public ayrf(Context paramContext, ayrb paramayrb)
  {
    this.mContext = paramContext;
    this.a = paramayrb;
    this.fd = aqhu.G();
    this.aOw = wja.dp2px(40.0F, this.mContext.getResources());
    initHeader();
  }
  
  private ayrk a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.xq != null) && (this.xq.size() > 0))
    {
      Iterator localIterator = this.xq.iterator();
      while (localIterator.hasNext())
      {
        ayrk localayrk = (ayrk)localIterator.next();
        if ((!TextUtils.isEmpty(localayrk.uin)) && (paramString.equals(localayrk.uin)) && (paramInt1 == localayrk.messageType))
        {
          localayrk.operateStatus = paramInt2;
          if (localayrk.operateStatus == 1) {
            localayrk.isSend = true;
          }
          return localayrk;
        }
      }
    }
    return null;
  }
  
  private void a(ayrf.a parama)
  {
    if ((parama == null) || (parama.d == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      parama.operateView.setStatus(parama.d.operateStatus);
    } while (parama.d.operateStatus != 1);
    parama.operateView.setProgress(parama.d.progress);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.j(paramString);
      if (paramString == null) {
        break label57;
      }
      paramString = getIconDrawable(paramString.toString(), paramInt1, paramInt2);
      if ((paramString instanceof URLDrawable)) {
        this.mActiveThumbDrawable.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
      }
      paramRecentDynamicAvatarView.setImageDrawable(paramString);
    }
    label57:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SendPanelAdapter", 2, "url  is null ");
  }
  
  public static Drawable getIconDrawable(String paramString, int paramInt1, int paramInt2)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localafei, localafei);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localafei;
  }
  
  private void initHeader()
  {
    this.c = new aduk(this.mContext, 1);
    this.c.init();
    this.c.a(new ayrg(this));
    this.d = new aduk(this.mContext, 4);
    this.d.init();
    this.d.a(new ayrh(this));
    this.h = new aduk(this.mContext, 113);
    this.h.init();
    this.h.a(new ayri(this));
    this.e = new aduk(this.mContext, 101);
    this.e.init();
    this.e.a(new ayrj(this));
  }
  
  public void ZL(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onEditUpdate");
    }
    if ((this.xq != null) && (this.xq.size() > 0))
    {
      Object localObject = (ayrk)this.xq.get(0);
      if ((TextUtils.isEmpty(((ayrk)localObject).filePath)) && (TextUtils.isEmpty(((ayrk)localObject).fileMd5))) {
        return;
      }
      if ((paramBoolean) && (this.b != null)) {
        alwx.c(this.b.b);
      }
      localObject = this.xq.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ayrk)((Iterator)localObject).next()).eTl();
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(int paramInt, ayrf.a parama)
  {
    if ((parama == null) || (parama.d == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    ayrk localayrk = parama.d;
    if ((localayrk.iconBitmap != null) && (!localayrk.iconBitmap.isRecycled())) {
      parama.iconView.setImageBitmap(localayrk.iconBitmap);
    }
    label305:
    for (;;)
    {
      parama.nameText.setText(localayrk.displayName);
      parama.operateView.setTag(parama);
      parama.operateView.setOnClickListener(this);
      a(parama);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localayrk.iconUrl))
      {
        localObject = (URLDrawable)this.mActiveThumbDrawable.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          parama.iconView.setImageDrawable((Drawable)localObject);
        } else {
          a(localayrk.iconUrl, this.aOw, this.aOw, parama.iconView, paramInt);
        }
      }
      else
      {
        localObject = this.fd;
        if ((localayrk.messageType == 0) || (localayrk.messageType == 1000) || (localayrk.messageType == 1004)) {
          localObject = this.c.getFaceBitmap(localayrk.uin, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label305;
          }
          parama.iconView.setImageBitmap((Bitmap)localObject);
          break;
          if (localayrk.messageType == 1)
          {
            if (localayrk.isNewTroop) {
              localObject = this.h.getFaceBitmap(localayrk.uin, true);
            } else {
              localObject = this.d.getFaceBitmap(localayrk.uin, true);
            }
          }
          else if (localayrk.messageType == 3000) {
            localObject = this.e.getFaceBitmap(localayrk.uin, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ayrk paramayrk)
  {
    if ((paramInt < 0) || (this.xq == null) || (paramInt > this.xq.size()) || (paramayrk == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.xq.set(paramInt, paramayrk);
  }
  
  public void a(ayrm paramayrm)
  {
    this.b = paramayrm;
  }
  
  public boolean aQX()
  {
    if ((this.xq != null) && (this.xq.size() > 0)) {
      return !TextUtils.isEmpty(((ayrk)this.xq.get(0)).filePath);
    }
    return false;
  }
  
  public void destroy()
  {
    if (this.mActiveThumbDrawable != null) {
      this.mActiveThumbDrawable.clear();
    }
  }
  
  public int getCount()
  {
    if (this.xq != null) {
      return this.xq.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.xq != null) {
      return (ayrk)this.xq.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.xq != null) && (paramInt < this.xq.size())) {
      try
      {
        long l = Long.parseLong(((ayrk)this.xq.get(paramInt)).uin);
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "getItemId exception = " + localException.getMessage());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayrk localayrk = (ayrk)getItem(paramInt);
    ayrf.a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131563082, null);
      locala = new ayrf.a();
      locala.iconView = ((RecentDynamicAvatarView)paramView.findViewById(2131368698));
      locala.nameText = ((TextView)paramView.findViewById(2131372190));
      locala.operateView = ((QuickSendProgressView)paramView.findViewById(2131372706));
      locala.d = localayrk;
      a(paramInt, locala);
      paramView.setTag(locala);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (ayrf.a)paramView.getTag();
      locala.d = localayrk;
      a(paramInt, locala);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof ayrf.a))
    {
      localObject1 = (ayrf.a)paramView.getTag();
      if (((ayrf.a)localObject1).d != null) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((ayrf.a)localObject1).d.operateStatus);
      }
      ayrk localayrk;
      switch (((ayrf.a)localObject1).d.operateStatus)
      {
      default: 
        break;
      case 0: 
        if (!aqiw.isNetworkAvailable(this.mContext))
        {
          QQToast.a(this.mContext, this.mContext.getString(2131720470), 0).show();
        }
        else
        {
          if (!TextUtils.isEmpty(((ayrf.a)localObject1).d.fileMd5))
          {
            localayrk = a(((ayrf.a)localObject1).d.uin, ((ayrf.a)localObject1).d.messageType, 1);
            Object localObject2;
            int i;
            if (localayrk != null)
            {
              ((ayrf.a)localObject1).d = localayrk;
              a((ayrf.a)localObject1);
              if (localayrk.isVideo) {
                axyl.a(localayrk.filePath, localayrk.thumbPath, localayrk, ayrl.a().cTF, ayrl.a().IB());
              }
            }
            else
            {
              if (this.b != null) {
                alwx.c(this.b.b, localayrk);
              }
              localObject2 = axim.a();
              localObject1 = ((ayrf.a)localObject1).d.fileMd5;
              if (localayrk != null) {
                break label355;
              }
              i = -1;
              ((axim)localObject2).hg((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localayrk != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localayrk.messageType))
            {
              axiy.i("SendPanelAdapter", localObject1);
              break;
              axyl.a(localayrk.filePath, localayrk, ayrl.a().cTF, ayrl.a().IB());
              break label243;
              i = localayrk.messageType;
              break label282;
            }
          }
          this.b.b.r(49, ((ayrf.a)localObject1).d);
          this.b.b.bsX();
        }
        break;
      case 1: 
        localayrk = a(((ayrf.a)localObject1).d.uin, ((ayrf.a)localObject1).d.messageType, 0);
        if (localayrk != null)
        {
          ((ayrf.a)localObject1).d = localayrk;
          a((ayrf.a)localObject1);
          axyl.b(localayrk);
        }
        if (this.b != null) {
          alwx.b(this.b.b, localayrk);
        }
        break;
      case 2: 
        label243:
        if (!aqiw.isNetworkAvailable(this.mContext))
        {
          QQToast.a(this.mContext, this.mContext.getString(2131720470), 0).show();
        }
        else
        {
          localayrk = a(((ayrf.a)localObject1).d.uin, ((ayrf.a)localObject1).d.messageType, 1);
          if (localayrk != null)
          {
            ((ayrf.a)localObject1).d = localayrk;
            a((ayrf.a)localObject1);
            axyl.c(localayrk);
          }
          if (this.b != null) {
            alwx.a(this.b.b, localayrk);
          }
        }
        label282:
        label355:
        label364:
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.destroy();
    }
    if (this.d != null) {
      this.d.destroy();
    }
    if (this.e != null) {
      this.e.destroy();
    }
    ZL(false);
  }
  
  public void setData(List<ayrk> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.xq == null) || (!paramList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
    return;
    this.xq = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public ayrk d;
    public RecentDynamicAvatarView iconView;
    public TextView nameText;
    public QuickSendProgressView operateView;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrf
 * JD-Core Version:    0.7.0.1
 */