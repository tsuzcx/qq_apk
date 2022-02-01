import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class aplr
  extends SimpleObserver<apks>
{
  aplr(aplq paramaplq, apks paramapks) {}
  
  public void b(apks paramapks)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(paramapks.mPosition), ", old status=", Integer.valueOf(paramapks.mUploadStatus), ", result=", paramapks });
    }
    paramapks.mUploadStatus = 3;
    paramapks.mProgress = 100;
    this.a.nI.remove(paramapks);
    if (this.a.e != null)
    {
      Object localObject = this.a.e.findViewHolderForLayoutPosition(paramapks.mPosition);
      if ((localObject instanceof aplq.a))
      {
        localObject = (aplq.a)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(paramapks.hashCode()), ", result hash=", Integer.valueOf(paramapks.hashCode()), ", info position=", Integer.valueOf(paramapks.mPosition), ", result position=", Integer.valueOf(paramapks.mPosition), ", vh position=", Integer.valueOf(((aplq.a)localObject).a.mPosition), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramapks.cpR.equals(((aplq.a)localObject).d.getTag()))
        {
          ((aplq.a)localObject).d.setVisibility(0);
          ((aplq.a)localObject).d.setDrawStatus(1);
          ((aplq.a)localObject).d.setAnimProgress(paramapks.mProgress, paramapks.cpR);
        }
        this.a.a.c((RecyclerView.ViewHolder)localObject, true);
      }
    }
    apue.m("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - paramapks.arF), "");
    this.a.cb(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.b.mPosition), ", info old status=", Integer.valueOf(this.b.mUploadStatus) });
    }
    this.b.mUploadStatus = 2;
    this.a.nI.remove(this.b);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.a.e != null)
    {
      Object localObject = this.a.e.findViewHolderForLayoutPosition(this.b.mPosition);
      if ((localObject instanceof aplq.a))
      {
        localObject = (aplq.a)localObject;
        if (this.b.cpR.equals(((aplq.a)localObject).d.getTag()))
        {
          ((aplq)((apkk)this.a.e.getAdapter()).a.a(2)).a((aple.a)localObject, this.b, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.a.e.getContext(), acfp.m(2131716406), 0).show();
            this.a.a.h((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      apue.m("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.b.arF), "");
    }
    if (this.b.cpR.equals(this.a.cpU)) {
      this.a.cb(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplr
 * JD-Core Version:    0.7.0.1
 */