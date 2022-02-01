import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class albh
  extends aook
{
  public static String TAG = "PLTransProcessorHandler";
  WeakReference<albi> aR;
  
  public albh(albi paramalbi, Looper paramLooper)
  {
    super(paramLooper);
    this.aR = new WeakReference(paramalbi);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if (localaoko.fileType != 56) {}
    label460:
    for (;;)
    {
      return;
      albi localalbi = (albi)this.aR.get();
      if (localalbi == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localaoko.fileKey;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localalbi.L.size()) {
          if (!((albi.a)localalbi.L.get(i)).f.AO().equals(localObject)) {}
        }
        for (localObject = (albi.a)localalbi.L.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "personality_label handlemsg find:" + ((albi.a)localObject).a.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "personality_label handlemsg. state:" + ((albi.a)localObject).state + " " + ((albi.a)localObject).a.uniseq);
            }
            if ((((albi.a)localObject).state == 4) && (QLog.isColorLevel())) {
              QLog.i(TAG, 2, "personality_label handlemsg url:" + ((albi.a)localObject).a.url);
            }
            if (localalbi.a == null) {
              break;
            }
            localalbi.a.a(((albi.a)localObject).XM, (albi.a)localObject);
            return;
            i += 1;
            break label93;
            ((albi.a)localObject).progress = 0;
            ((albi.a)localObject).state = 1;
            continue;
            ((albi.a)localObject).state = 4;
            ((albi.a)localObject).a.fileId = localaoko.apJ;
            ((albi.a)localObject).a.url = localaoko.fileUrl;
            if (((albi.a)localObject).progress < 100) {
              ((albi.a)localObject).progress = 100;
            }
            localalbi.L.remove(localObject);
            continue;
            ((albi.a)localObject).state = 3;
            continue;
            ((albi.a)localObject).state = 2;
            ((albi.a)localObject).progress = ((int)(localaoko.transferedSize * 100L / localaoko.fileSize));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albh
 * JD-Core Version:    0.7.0.1
 */