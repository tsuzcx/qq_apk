import android.content.Context;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.QavListItemBase.b;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jcs
  implements EffectConfigBase.a<PendantItem>, jcc.b
{
  private final String TAG;
  private final iki a;
  private final ArrayList<QavListItemBase.c> iS = new ArrayList(10);
  private jcc mAdapter;
  private final int mType;
  
  public jcs(int paramInt, iki paramiki)
  {
    this.TAG = ("QavListItemHelper" + paramInt);
    this.mType = paramInt;
    this.a = paramiki;
  }
  
  public static QavListItemBase.c a(int paramInt, PendantItem paramPendantItem)
  {
    QavListItemBase.c localc = new QavListItemBase.c();
    localc.type = paramInt;
    localc.id = paramPendantItem.getId();
    localc.name = paramPendantItem.getDesc();
    localc.iconurl = paramPendantItem.getIconurl();
    localc.desc = paramPendantItem.getDesc();
    localc.XB = false;
    localc.usable = paramPendantItem.isUsable();
    localc.ax = paramPendantItem;
    if (paramInt == 4) {
      localc.XC = true;
    }
    return localc;
  }
  
  public ArrayList<QavListItemBase.c> a(Context paramContext)
  {
    long l = AudioHelper.hG();
    this.iS.clear();
    if (this.mType == 5)
    {
      localObject = new QavListItemBase.c();
      ((QavListItemBase.c)localObject).XC = false;
      ((QavListItemBase.c)localObject).id = "-1";
      this.iS.add(localObject);
    }
    Object localObject = new QavListItemBase.c();
    ((QavListItemBase.c)localObject).id = "0";
    ((QavListItemBase.c)localObject).iconurl = String.valueOf(2130843045);
    ((QavListItemBase.c)localObject).XB = false;
    if (this.mType == 4)
    {
      ((QavListItemBase.c)localObject).XC = true;
      ((QavListItemBase.c)localObject).name = paramContext.getString(2131697585);
    }
    for (((QavListItemBase.c)localObject).desc = paramContext.getString(2131697586);; ((QavListItemBase.c)localObject).desc = paramContext.getString(2131697585))
    {
      this.iS.add(localObject);
      if (this.a == null) {
        break;
      }
      paramContext = this.a.y(null);
      localObject = (PendantItem)this.a.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.a.a(l, null);
      }
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        break;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (PendantItem)paramContext.next();
        if (localObject != null)
        {
          localObject = a(this.mType, (PendantItem)localObject);
          if (localObject != null) {
            this.iS.add(localObject);
          }
        }
      }
      ((QavListItemBase.c)localObject).XC = false;
      ((QavListItemBase.c)localObject).name = paramContext.getString(2131697585);
    }
    return this.iS;
  }
  
  public void a(jcc paramjcc)
  {
    this.mAdapter = paramjcc;
  }
  
  public void onDownloadFinish(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onDownloadFinish, seq[" + paramLong + "], isSuc[" + paramBoolean + "], info[" + paramPendantItem + "]");
    }
    if (this.mAdapter != null) {
      this.mAdapter.g(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramPendantItem + "]");
    }
  }
  
  public void onProgressUpdate(PendantItem paramPendantItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.ao(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.c paramc, QavListItemBase.b paramb)
  {
    paramAppInterface = null;
    if (this.a != null) {
      paramAppInterface = (PendantItem)this.a.a(paramc.id);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.a.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.TAG, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramb.g(paramLong, paramc.id, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcs
 * JD-Core Version:    0.7.0.1
 */