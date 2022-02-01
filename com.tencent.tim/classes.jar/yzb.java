import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;

public abstract class yzb
  extends PinnedDividerListView.a
  implements aqdf.a, AbsListView.e
{
  protected XListView C;
  protected aqdf e;
  private final QQAppInterface e;
  protected Context mContext;
  private int mCurrentScrollState = 0;
  
  public yzb(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.C = paramXListView;
    if (this.C != null) {
      this.C.setOnScrollListener(this);
    }
    this.jdField_e_of_type_Aqdf = new aqdf(this.mContext, this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_e_of_type_Aqdf.a(this);
    aqhu.G();
  }
  
  protected void a(zap.a parama, Bitmap paramBitmap)
  {
    a(parama, paramBitmap, true);
  }
  
  protected void a(zap.a parama, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (parama.pQ == null) {
      return;
    }
    if (acbn.bkw.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845074);
      return;
    }
    if (acbn.bkx.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845071);
      return;
    }
    if (acbn.bky.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130845077);
      return;
    }
    if (acbn.bkv.equals(parama.uin))
    {
      parama.pQ.setBackgroundResource(2130840081);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if (acbn.bkX.equals(parama.uin))
      {
        Object localObject = (Friends)parama.item;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.getInstance().isLostQfindDevice(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              parama.pQ.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByDin(((Friends)localObject).name);
          }
        }
        paramBitmap = localBitmap;
      }
    }
    for (;;)
    {
      localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = aqhu.G();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_e_of_type_Aqdf.isPausing())
        {
          this.jdField_e_of_type_Aqdf.i(parama.uin, parama.type, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      parama.pQ.setImageDrawable(null);
      if ((parama.type == 1) && ((parama.pQ instanceof DynamicAvatarView)) && ((parama instanceof zap.a)))
      {
        if (!parama.bqo)
        {
          parama.pQ.setBackgroundDrawable(null);
          ((DynamicAvatarView)parama.pQ).setFaceDrawable(this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.mContext.getResources(), localBitmap), 1, parama.uin, 100, false, true, 1);
          return;
          paramBitmap = this.jdField_e_of_type_Aqdf.b(parama.type, parama.uin);
        }
        else
        {
          parama.pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
        }
      }
      else
      {
        parama.pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
        return;
      }
    }
  }
  
  public void destroy()
  {
    if (this.jdField_e_of_type_Aqdf != null) {
      this.jdField_e_of_type_Aqdf.destory();
    }
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
    if ((!this.jdField_e_of_type_Aqdf.isPausing()) && (paramBitmap != null)) {
      p(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mCurrentScrollState = paramInt;
    if (paramInt != 0)
    {
      this.jdField_e_of_type_Aqdf.edu();
      this.jdField_e_of_type_Aqdf.pause();
      aqcy.D(this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_e_of_type_Aqdf.isPausing())
    {
      this.jdField_e_of_type_Aqdf.edu();
      this.jdField_e_of_type_Aqdf.resume();
      p(null, null);
    }
    aqcy.E(this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void p(String paramString, Bitmap paramBitmap)
  {
    if (this.C == null) {}
    label19:
    Object localObject;
    label77:
    do
    {
      return;
      int j = this.C.getChildCount();
      int i = 0;
      if (i < j)
      {
        localObject = this.C.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof zap.a)))
        {
          localObject = (zap.a)localObject;
          if (paramString != null) {
            break label77;
          }
          a((zap.a)localObject, null, false);
        }
      }
      while (!paramString.equals(((zap.a)localObject).uin))
      {
        i += 1;
        break label19;
        break;
      }
    } while (paramBitmap == null);
    if ((((zap.a)localObject).type == 1) && ((((zap.a)localObject).pQ instanceof DynamicAvatarView)))
    {
      if (!((zap.a)localObject).bqo)
      {
        ((DynamicAvatarView)((zap.a)localObject).pQ).Q(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
        return;
      }
      ((zap.a)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
      return;
    }
    ((zap.a)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */