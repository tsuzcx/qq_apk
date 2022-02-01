import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.a;

public abstract class abgc
  extends PinnedHeaderExpandableListView.a
  implements aqdf.a, AbsListView.e
{
  protected ExpandableListView b;
  private aqdf jdField_e_of_type_Aqdf;
  private final QQAppInterface jdField_e_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Context mContext;
  
  public abgc(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.mContext = paramContext;
    this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramExpandableListView;
    this.jdField_e_of_type_Aqdf = new aqdf(this.mContext, this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_e_of_type_Aqdf.a(this);
    aqhu.G();
  }
  
  protected void a(abgc.a parama, Bitmap paramBitmap)
  {
    a(parama, paramBitmap, true);
  }
  
  protected void a(abgc.a parama, Bitmap paramBitmap, boolean paramBoolean)
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
      if ((acbn.bkX.equals(parama.uin)) && ((parama instanceof zap.a)))
      {
        Object localObject = (Friends)((zap.a)parama).item;
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
      label205:
      localBitmap = paramBitmap;
      if (paramBitmap == null) {
        if (paramBoolean) {
          if (!(parama instanceof zch.a)) {
            break label368;
          }
        }
      }
      label368:
      for (paramBitmap = aqhu.aN();; paramBitmap = aqhu.G())
      {
        localBitmap = paramBitmap;
        if (!this.jdField_e_of_type_Aqdf.isPausing())
        {
          this.jdField_e_of_type_Aqdf.i(parama.uin, parama.type, false);
          localBitmap = paramBitmap;
        }
        if (localBitmap == null) {
          break;
        }
        if ((parama.type != 1) || (!(parama.pQ instanceof DynamicAvatarView)) || (!(parama instanceof zap.a))) {
          break label399;
        }
        if (((zap.a)parama).bqo) {
          break label375;
        }
        parama.pQ.setBackgroundDrawable(null);
        ((DynamicAvatarView)parama.pQ).setFaceDrawable(this.jdField_e_of_type_ComTencentMobileqqAppQQAppInterface, new BitmapDrawable(this.mContext.getResources(), localBitmap), 1, parama.uin, 100, false, true, 1);
        return;
        paramBitmap = this.jdField_e_of_type_Aqdf.b(parama.type, parama.uin);
        break label205;
      }
      label375:
      parama.pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
      return;
      label399:
      parama.pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void destroy()
  {
    if (this.jdField_e_of_type_Aqdf != null) {
      this.jdField_e_of_type_Aqdf.destory();
    }
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
  
  public void p(String paramString, Bitmap paramBitmap)
  {
    int j = this.b.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.b.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof abgc.a)))
      {
        localObject = (abgc.a)localObject;
        if (paramString != null) {
          break label69;
        }
        a((abgc.a)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((abgc.a)localObject).uin))
      {
        i += 1;
        break;
      }
      if (paramBitmap != null)
      {
        if ((((abgc.a)localObject).type != 1) || (!(((abgc.a)localObject).pQ instanceof DynamicAvatarView)) || (!(localObject instanceof zap.a))) {
          break label175;
        }
        if (((zap.a)localObject).bqo) {
          break label151;
        }
        ((DynamicAvatarView)((abgc.a)localObject).pQ).Q(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
      }
    }
    return;
    label151:
    ((abgc.a)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
    return;
    label175:
    ((abgc.a)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
  }
  
  public static class a
    extends auvd.a
  {
    public ImageView pQ;
    public int type = 1;
    public String uin;
    public ImageView xp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgc
 * JD-Core Version:    0.7.0.1
 */