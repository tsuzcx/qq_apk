import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class apls
  extends SimpleObserver<apkv>
{
  apls(aplq paramaplq, apkv paramapkv) {}
  
  public void b(apkv paramapkv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(paramapkv.mPosition), ", old status=", Integer.valueOf(paramapkv.mUploadStatus) });
    }
    this.a.nJ.remove(paramapkv);
    this.a.cb(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.b.mPosition), ", old status=", Integer.valueOf(this.b.mUploadStatus) });
    }
    this.b.mUploadStatus = 2;
    this.a.nJ.remove(this.b);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.a.e != null)
    {
      Object localObject = this.a.e.findViewHolderForLayoutPosition(this.b.mPosition);
      if ((localObject instanceof aplq.a))
      {
        localObject = (aplq.a)localObject;
        if (this.b.cpR.equals(((aplq.a)localObject).d.getTag())) {
          ((aplq)((apkk)this.a.e.getAdapter()).a.a(2)).a((aple.a)localObject, this.b, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      apue.m("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.b.arF), "");
    }
    if (this.b.cpR.equals(this.a.cpU)) {
      this.a.cb(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apls
 * JD-Core Version:    0.7.0.1
 */