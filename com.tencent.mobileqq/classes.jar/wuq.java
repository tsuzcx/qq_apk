import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class wuq
  extends Handler
{
  private final WeakReference a;
  
  public wuq(PhotoListActivity paramPhotoListActivity)
  {
    this.a = new WeakReference(paramPhotoListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    label300:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject = (PhotoListActivity)this.a.get();
          switch (paramMessage.what)
          {
          default: 
            return;
          case 0: 
            localObject = ((PhotoListActivity)localObject).a;
          }
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((wur)localObject).a);
        paramMessage = paramMessage.getData();
        i = paramMessage.getInt("ALBUMLIST_POSITION");
        long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
        paramMessage = (LocalMediaInfo)localArrayList.get(i);
        paramMessage.mDuration = l;
        localArrayList.set(i, paramMessage);
        ((wur)localObject).a(localArrayList);
        ((wur)localObject).notifyDataSetChanged();
        return;
        ((PhotoListActivity)localObject).d();
      } while (!(paramMessage.obj instanceof String));
      paramMessage = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (((PhotoListActivity)localObject).c == null) {
        ((PhotoListActivity)localObject).c = new ArrayList();
      }
      if (PhotoListActivity.e((PhotoListActivity)localObject))
      {
        i = AlbumUtil.b();
        if (((PhotoListActivity)localObject).c.size() < ((PhotoListActivity)localObject).i) {
          break label300;
        }
        QQToast.a((Context)localObject, String.format(((PhotoListActivity)localObject).getResources().getString(2131439145), new Object[] { Integer.valueOf(((PhotoListActivity)localObject).i) }), 0).a();
      }
      for (;;)
      {
        PhotoListActivity.a((PhotoListActivity)localObject, paramMessage);
        return;
        i = AlbumUtil.a();
        break;
        if (PhotoListActivity.a() >= i)
        {
          QQToast.a((Context)localObject, String.format(((PhotoListActivity)localObject).getResources().getString(2131439146), new Object[] { Integer.valueOf(i) }), 0).a();
        }
        else
        {
          ((PhotoListActivity)localObject).c.add(paramMessage);
          PhotoListActivity.f((PhotoListActivity)localObject);
        }
      }
      ((PhotoListActivity)localObject).d();
      QZLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
      QQToast.a((Context)localObject, ((PhotoListActivity)localObject).getResources().getString(2131439149), 0).a();
      return;
    } while (!(paramMessage.obj instanceof String));
    paramMessage = (String)paramMessage.obj;
    if (((PhotoListActivity)localObject).c == null) {
      ((PhotoListActivity)localObject).c = new ArrayList();
    }
    QZLog.d("PhotoListActivity", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", paramMessage });
    if (((PhotoListActivity)localObject).c.size() < ((PhotoListActivity)localObject).i)
    {
      ((PhotoListActivity)localObject).c.add(paramMessage);
      PhotoListActivity.f((PhotoListActivity)localObject);
    }
    for (;;)
    {
      PhotoListActivity.a((PhotoListActivity)localObject, paramMessage);
      return;
      QQToast.a((Context)localObject, String.format(((PhotoListActivity)localObject).getResources().getString(2131439145), new Object[] { Integer.valueOf(((PhotoListActivity)localObject).i) }), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */