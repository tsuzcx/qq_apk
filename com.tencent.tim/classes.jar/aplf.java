import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class aplf
  extends SimpleObserver<apks>
{
  aplf(aple paramaple, apks paramapks) {}
  
  public void b(apks paramapks)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(paramapks.mPosition), ", old status=", Integer.valueOf(paramapks.mUploadStatus), ", result=", paramapks });
    }
    paramapks.mUploadStatus = 3;
    paramapks.mProgress = 100;
    this.this$0.nI.remove(paramapks);
    if (this.this$0.e != null)
    {
      Object localObject = this.this$0.e.findViewHolderForLayoutPosition(this.b.mPosition);
      if ((localObject instanceof aple.a))
      {
        localObject = (aple.a)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(paramapks.hashCode()), ", result hash=", Integer.valueOf(paramapks.hashCode()), ", info position=", Integer.valueOf(paramapks.mPosition), ", result position=", Integer.valueOf(paramapks.mPosition), ", vh position=", Integer.valueOf(((aple.a)localObject).a.mPosition), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramapks.cpR.equals(((aple.a)localObject).d.getTag()))
        {
          ((aple.a)localObject).d.setVisibility(0);
          ((aple.a)localObject).d.setDrawStatus(1);
          ((aple.a)localObject).d.setAnimProgress(paramapks.mProgress, paramapks.cpR);
        }
        this.this$0.a.c((RecyclerView.ViewHolder)localObject, true);
      }
    }
    apue.m("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - paramapks.arF), "");
    this.this$0.cb(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.b.mPosition), ", info hash=", Integer.valueOf(this.b.hashCode()), ", info old status=", Integer.valueOf(this.b.mUploadStatus) });
    }
    this.b.mUploadStatus = 2;
    this.this$0.nI.remove(this.b);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.this$0.e != null)
    {
      Object localObject = this.this$0.e.findViewHolderForLayoutPosition(this.b.mPosition);
      if ((localObject instanceof aple.a))
      {
        localObject = (aple.a)localObject;
        if (this.b.cpR.equals(((aple.a)localObject).d.getTag())) {
          ((aple)((apkk)this.this$0.e.getAdapter()).a.a(1)).a((aple.a)localObject, this.b, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      apue.m("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.b.arF), "");
    }
    if (this.b.cpR.equals(this.this$0.cpU)) {
      this.this$0.cb(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplf
 * JD-Core Version:    0.7.0.1
 */