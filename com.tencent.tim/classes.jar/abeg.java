import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Hashtable;

public abstract class abeg
  extends BaseAdapter
  implements aqdf.a, AbsListView.e
{
  protected aqdf a;
  private boolean bBY;
  private boolean bBZ;
  private int cnW;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private int mCurrentScrollState = 0;
  private AbsListView.e p;
  private ListView s;
  
  public abeg(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.s = paramListView;
    this.cnW = paramInt;
    this.bBZ = paramBoolean;
    this.s.setOnScrollListener(this);
    this.a = new aqdf(paramContext, paramQQAppInterface);
    this.a.a(this);
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (acbn.bkW.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130848300);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.a.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.bBY)
    {
      this.a.edu();
      this.bBY = false;
    }
    if (!this.a.isPausing()) {
      this.a.a(paramString, paramInt, true, paramByte);
    }
    return af();
  }
  
  protected void a(yzr.b paramb, Bitmap paramBitmap)
  {
    if (paramb.pQ == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (acbn.bkw.equals(paramb.uin))
          {
            paramb.pQ.setBackgroundResource(2130845074);
            return;
          }
          if (acbn.bkx.equals(paramb.uin))
          {
            paramb.pQ.setBackgroundResource(2130845071);
            return;
          }
          if (acbn.bky.equals(paramb.uin))
          {
            paramb.pQ.setBackgroundResource(2130845077);
            return;
          }
          if (acbn.bkv.equals(paramb.uin))
          {
            paramb.pQ.setBackgroundResource(2130840081);
            return;
          }
          if ((!acbn.bkX.equals(paramb.uin)) || (!(paramb instanceof zap.a))) {
            break;
          }
          paramBitmap = (zap.a)paramb;
        } while (!(paramBitmap.item instanceof Friends));
        paramBitmap = (Friends)paramBitmap.item;
      } while (paramBitmap == null);
      if (!DeviceHeadMgr.getInstance().isLostQfindDevice(paramBitmap.name)) {
        break;
      }
      paramBitmap = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramBitmap.name);
    } while (paramBitmap == null);
    paramb.pQ.setBackgroundDrawable(paramBitmap);
    return;
    paramb.pQ.setBackgroundDrawable(new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(paramBitmap.name)));
    return;
    if (paramBitmap != null)
    {
      paramb.pQ.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    paramb.pQ.setBackgroundDrawable(new BitmapDrawable(a(paramb.type, paramb.uin)));
  }
  
  protected Bitmap af()
  {
    return aqhu.G();
  }
  
  public void bT(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
    }
    if (this.a != null)
    {
      this.a.destory();
      this.a = new aqdf(null, paramQQAppInterface);
      this.a.a(this);
    }
  }
  
  public void destroy()
  {
    if ((this.s != null) && (this.s.getOnScrollListener() == this)) {
      this.s.setOnScrollListener(null);
    }
    if (this.a != null) {
      this.a.destory();
    }
    this.s = null;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.bBY) {
      if (paramInt1 == 0) {
        this.bBY = false;
      }
    }
    do
    {
      do
      {
        return;
      } while (this.a.isPausing());
      if (paramBitmap != null) {
        this.faceCache.put(paramString, paramBitmap);
      }
    } while (paramInt1 > 0);
    if ((this.mCurrentScrollState == 0) || (this.mCurrentScrollState == 1))
    {
      paramInt2 = this.s.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.s.getChildAt(paramInt1);
        paramBitmap = paramString.getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof abeg.a)))
        {
          paramString = (abeg.a)paramBitmap;
          if ((paramString != null) && (paramString.uin != null) && (paramString.uin.length() > 0))
          {
            paramBitmap = (Bitmap)this.faceCache.get(paramString.uin);
            if (paramBitmap != null) {
              paramString.pQ.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if ((paramString instanceof QzoneSearchResultView))
          {
            paramString = (QzoneSearchResultView)paramString;
            if ((paramString != null) && (!TextUtils.isEmpty(paramString.getUin())))
            {
              paramBitmap = (Bitmap)this.faceCache.get(paramString.getUin());
              if (paramBitmap != null) {
                paramString.setAvartaView(paramBitmap);
              }
            }
          }
          else if ((paramBitmap != null) && ((paramBitmap instanceof yzr.b)))
          {
            paramString = (yzr.b)paramBitmap;
            a(paramString, (Bitmap)this.faceCache.get(paramString.uin));
          }
        }
      }
    }
    this.faceCache.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.p != null) {
      this.p.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mCurrentScrollState = paramInt;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.a.isPausing()) {
        this.a.resume();
      }
      if (this.s != null)
      {
        int j = this.s.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject = this.s.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof abeg.a)))
          {
            localObject = (abeg.a)localObject;
            if ((localObject != null) && (((abeg.a)localObject).uin != null) && (((abeg.a)localObject).uin.length() > 0)) {
              ((abeg.a)localObject).pQ.setImageBitmap(a(((abeg.a)localObject).type, ((abeg.a)localObject).uin));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject != null) && ((localObject instanceof yzr.b)))
            {
              localObject = (yzr.b)localObject;
              a((yzr.b)localObject, (Bitmap)this.faceCache.get(((yzr.b)localObject).uin));
            }
          }
        }
      }
    }
    else
    {
      this.bBY = false;
      this.a.edu();
      this.a.pause();
    }
    if (this.p != null) {
      this.p.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected void r(String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if ((this.mCurrentScrollState == 0) && (this.s != null))
    {
      j = this.s.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        abeg.a locala = (abeg.a)this.s.getChildAt(i).getTag();
        if ((locala != null) && (locala.uin != null) && (locala.uin.length() > 0) && (locala.uin.equals(paramString))) {
          locala.pQ.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.p = parame;
  }
  
  public static class a
    extends auvd.a
  {
    public ImageView pQ;
    public int type = 1;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     abeg
 * JD-Core Version:    0.7.0.1
 */