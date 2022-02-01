import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.ad.AnimationDrawableProxyView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;

public class awks
  extends adud
{
  private AnimationDrawableProxyView a;
  private TianShuAccess.AdItem b;
  private QQAppInterface mApp;
  
  public awks(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.mApp = paramQQAppInterface;
  }
  
  public void cUo()
  {
    try
    {
      int j = this.mParentView.getWidth();
      int i = j;
      if (j == 0) {
        i = ankt.SCREEN_WIDTH;
      }
      j = wja.dp2px(375.0F, this.mParentView.getResources());
      a(i - j - 0, 0, j, wja.dp2px(30.0F, this.mParentView.getResources()), this.mParentView);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ConvActivePendantHolderBase", 1, localThrowable, new Object[0]);
    }
  }
  
  public void cUq()
  {
    super.cUq();
    if ((this.mApp != null) && (this.b != null))
    {
      awkm.d(this.mApp, 102, String.valueOf(this.b.iAdId.get()), this.b.traceinfo.get());
      if ((this.mParentView != null) && ((this.mParentView instanceof ARMapHongBaoListView))) {
        ((ARMapHongBaoListView)this.mParentView).ewD();
      }
    }
  }
  
  public void e(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      QLog.e("ConvActivePendantHolderBase", 2, "showLayer with null ");
    }
    label33:
    label203:
    label204:
    for (;;)
    {
      return;
      this.b = paramAdItem;
      Object localObject1 = paramAdItem.argList.get().iterator();
      paramAdItem = null;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        if (!((TianShuAccess.MapEntry)localObject2).key.get().equals("image")) {
          break label203;
        }
        paramAdItem = ((TianShuAccess.MapEntry)localObject2).value.get();
      }
      for (;;)
      {
        break label33;
        if (TextUtils.isEmpty(paramAdItem)) {
          break label204;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_loop", 1);
        localObject2 = aoop.TRANSPARENT;
        this.drawable = aqqx.a(paramAdItem, new int[] { 2 }, (Drawable)localObject2, (Bundle)localObject1, null);
        if (this.drawable == null) {
          break;
        }
        this.a = new AnimationDrawableProxyView(this.mContext, this.mParentView, this.drawable);
        cUo();
        if ((this.mApp == null) || (this.b == null)) {
          break;
        }
        awkm.d(this.mApp, 101, String.valueOf(this.b.iAdId.get()), this.b.traceinfo.get());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awks
 * JD-Core Version:    0.7.0.1
 */