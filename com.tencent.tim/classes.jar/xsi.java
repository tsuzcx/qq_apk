import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.RichmediaService;
import java.util.ArrayList;
import java.util.Iterator;

public class xsi
{
  private static xsi a;
  private final ArrayList<xsi.a> qK = new ArrayList();
  
  public static void N(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryMsgRevokeMgr", 0, "sendMsgRevokeRequest:" + paramMessageRecord);
      }
      Object localObject2 = a();
      if (localObject2 != null) {
        synchronized (((xsi)localObject2).qK)
        {
          localObject2 = ((xsi)localObject2).qK.iterator();
          if (((Iterator)localObject2).hasNext()) {
            ((xsi.a)((Iterator)localObject2).next()).fG(paramMessageRecord.uniseq);
          }
        }
      }
      ??? = RichmediaService.a();
      if (??? != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("msg_revoke_uniseq", paramMessageRecord.uniseq);
        boolean bool = ((RichmediaService)???).b(300, -1, (Bundle)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryMsgRevokeMgr", 0, "sendMsgRevokeRequest result:" + bool);
        }
      }
    }
  }
  
  public static xsi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new xsi();
      }
      return a;
    }
    finally {}
  }
  
  public static void b(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null))
    {
      ImageView localImageView = new ImageView(paramActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localImageView.setImageResource(2130846147);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      bC(paramActivity);
      anot.a(null, "dc00898", "", "", "0X8009EB8", "0X8009EB8", 0, 0, "", "", "", "");
    }
  }
  
  public static void bC(Activity paramActivity)
  {
    if (paramActivity != null) {}
    try
    {
      aqju localaqju = aqha.a(paramActivity, 230).setMessage(acfp.m(2131702207)).setPositiveButton(paramActivity.getString(2131695681), new xsj(paramActivity));
      if ((localaqju != null) && (!paramActivity.isFinishing())) {
        localaqju.show();
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOGalleryMsgRevokeMgr", 0, "showDialog exception: " + paramActivity.getMessage());
    }
  }
  
  public void a(xsi.a parama)
  {
    synchronized (this.qK)
    {
      if (!this.qK.contains(parama)) {
        this.qK.add(parama);
      }
      return;
    }
  }
  
  public void b(xsi.a parama)
  {
    synchronized (this.qK)
    {
      this.qK.remove(parama);
      return;
    }
  }
  
  public void bA(Bundle arg1)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("notifyMsgRevoke, mScene:");
      if (??? == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject1 = ???.toString();; localObject1 = "")
    {
      QLog.i("AIOGalleryMsgRevokeMgr", 0, (String)localObject1);
      if (??? != null) {
        break;
      }
      return;
    }
    long l = ???.getLong("msg_revoke_uniseq", 0L);
    synchronized (this.qK)
    {
      localObject1 = this.qK.iterator();
      if (((Iterator)localObject1).hasNext()) {
        ((xsi.a)((Iterator)localObject1).next()).fG(l);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void fG(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsi
 * JD-Core Version:    0.7.0.1
 */