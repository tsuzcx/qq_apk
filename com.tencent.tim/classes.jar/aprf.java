import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class aprf
  implements AbsListView.e
{
  protected ArrayList<String> Cj;
  protected aprf.a a;
  protected int dVw;
  protected Bitmap du;
  protected float mDensity;
  protected int mImgHeight;
  protected int mImgWidth;
  protected Handler mUIHandler;
  protected LruCache<String, Bitmap> p;
  protected LruCache<String, String> q;
  protected AbsListView.e s;
  protected ListView s;
  
  protected Bitmap B(Bitmap paramBitmap)
  {
    int j = this.mImgWidth;
    int i = this.mImgHeight;
    float f2 = this.mDensity;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return aqhu.b(paramBitmap, j, j, i);
  }
  
  protected void Sb(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "refreshListFace, add2Request:" + paramBoolean);
    }
    if (this.jdField_s_of_type_ComTencentWidgetListView == null) {
      return;
    }
    int j = this.jdField_s_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    label49:
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_s_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if (!(localObject instanceof abeg.a)) {
        break label131;
      }
      localObject = (abeg.a)localObject;
      if ((localObject != null) && (((abeg.a)localObject).uin != null) && (((abeg.a)localObject).uin.length() > 0)) {
        ((abeg.a)localObject).pQ.setImageBitmap(getFaceBitmap(((abeg.a)localObject).uin, paramBoolean));
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label131:
      if ((localObject instanceof mtg.l))
      {
        localObject = (mtg.l)localObject;
        if ((((mtg.l)localObject).a != null) && (((mtg.l)localObject).a.d != null) && ((((mtg.l)localObject).a.d.busiType == 1) || (((mtg.l)localObject).a.d.busiType == 6)) && (!TextUtils.isEmpty(((mtg.l)localObject).a.d.hH)) && (((mtg.l)localObject).c != null)) {
          ((mtg.l)localObject).c.setImageBitmap(getFaceBitmap(((mtg.l)localObject).a.d.hH, paramBoolean));
        }
      }
    }
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = (Bitmap)this.p.get(paramString);
        if (localObject != null)
        {
          if (!QLog.isColorLevel()) {
            return localObject;
          }
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in cache:" + paramString + ", add2Request=" + paramBoolean);
        }
        if (this.dVw == 0)
        {
          if (TextUtils.isEmpty((CharSequence)this.q.get(paramString))) {
            continue;
          }
          localObject = Message.obtain();
          ((Message)localObject).obj = paramString;
          ((Message)localObject).what = 1001;
          this.a.sendMessage((Message)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, in file cache:" + paramString + ", send decode msg ");
          }
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        continue;
      }
      return this.du;
      if ((paramBoolean) && (!this.Cj.contains(paramString)))
      {
        this.Cj.add(paramString);
        this.mUIHandler.removeMessages(1000);
        this.mUIHandler.sendEmptyMessageDelayed(1000, 350L);
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in file cache:" + paramString + ", send getQQHead msg ");
        }
      }
    }
    return localObject;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.dVw != 0)
    {
      this.Cj.clear();
      this.mUIHandler.removeMessages(1000);
    }
    if (this.jdField_s_of_type_ComTencentWidgetAbsListView$e != null) {
      this.jdField_s_of_type_ComTencentWidgetAbsListView$e.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_s_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "onScrollStateChanged, " + this.dVw + " => " + paramInt);
      }
      this.dVw = paramInt;
      if (paramInt == 0)
      {
        Sb(true);
        this.mUIHandler.removeMessages(1000);
        this.mUIHandler.sendEmptyMessageDelayed(1000, 350L);
      }
      while (this.jdField_s_of_type_ComTencentWidgetAbsListView$e != null)
      {
        this.jdField_s_of_type_ComTencentWidgetAbsListView$e.onScrollStateChanged(paramAbsListView, paramInt);
        return;
        this.Cj.clear();
        this.mUIHandler.removeMessages(1000);
      }
    }
  }
  
  public class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1001) {}
      try
      {
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "DecodeHandler handle MSG_DECODE_FACE_BITMAP uin:" + paramMessage);
        }
        Bitmap localBitmap1 = aqhu.d((String)this.b.q.get(paramMessage), null);
        if (localBitmap1 != null)
        {
          Bitmap localBitmap2 = this.b.B(localBitmap1);
          if (localBitmap2 != null)
          {
            Message localMessage = Message.obtain();
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("bmp", localBitmap2);
            localBundle.putString("uin", paramMessage);
            localMessage.obj = localBundle;
            localMessage.what = 1002;
            this.b.mUIHandler.sendMessage(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("NonMainAppListViewFaceLoader", 2, "decodeFile, uin:" + paramMessage);
            }
          }
          if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
            localBitmap1.recycle();
          }
        }
        return;
      }
      catch (OutOfMemoryError paramMessage)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NonMainAppListViewFaceLoader", 2, "decodeFile, OutOfMemoryError");
        return;
      }
      catch (Exception paramMessage)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NonMainAppListViewFaceLoader", 2, "decodeFile, exception:" + paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprf
 * JD-Core Version:    0.7.0.1
 */