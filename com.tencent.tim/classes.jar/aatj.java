import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class aatj
  extends amca
{
  aatj(aath paramaath) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onTranslate:  sessionid:" + paramLong + " startseq:" + paramInt1 + " endseq:" + paramInt2 + "[" + paramInt2 * 1.0F + "] status:" + paramInt3 + " CN:" + paramString1 + " EN:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramInt2 *= 2;
    aath.a locala = null;
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
    }
    if (aath.a(this.this$0).ME != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(aath.access$000(), 2, "onTranslate, session not match:" + paramLong + "-" + aath.a(this.this$0).ME);
      }
      return;
    }
    if (!this.this$0.isEnable()) {
      return;
    }
    if (aath.a(this.this$0).mListenerRef != null) {
      locala = (aath.a)aath.a(this.this$0).mListenerRef.get();
    }
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onTranslate, :  localtime:" + aath.a(this.this$0).MG);
    }
    aaum localaaum = (aaum)aath.a(this.this$0).hZ.get(Integer.valueOf(paramInt1));
    long l1;
    label460:
    long l2;
    if (localaaum == null)
    {
      l1 = (int)(paramInt2 * 1.0F) * 20 * aath.a(this.this$0).ckd - 500;
      paramLong = System.currentTimeMillis() - aath.a(this.this$0).MG - 500L;
      if (!QLog.isColorLevel()) {
        break label751;
      }
      QLog.d(aath.access$000(), 2, "onTranslate startiem: " + l1 + "-" + paramLong);
      break label751;
      localaaum = new aaum(paramLong, paramInt1, paramInt2);
      aath.a(this.this$0).hZ.put(Integer.valueOf(paramInt1), localaaum);
      l1 = paramLong;
      paramLong = (int)(paramInt2 * 1.0F) * 20 * aath.a(this.this$0).ckd;
      l2 = System.currentTimeMillis() - aath.a(this.this$0).MG - 500L;
      if (!QLog.isColorLevel()) {
        break label776;
      }
      QLog.d(aath.access$000(), 2, "onTranslate endtime: " + paramLong + "-" + l2);
      break label776;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(aath.access$000(), 2, "onTranslate, starttime-endtime: " + l1 + "-" + l2);
      }
      if (locala != null) {
        if (paramInt3 != 2) {
          break label739;
        }
      }
      label739:
      for (boolean bool = true;; bool = false)
      {
        locala.a(l1, l2, paramString1, paramString2, bool);
        if (!aath.a(this.this$0)) {
          break;
        }
        paramString1 = String.valueOf(System.currentTimeMillis() - aath.a(this.this$0));
        paramString2 = new HashMap();
        paramString2.put("startTranslateCost", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("PeakAudioTransHandler", 2, "startTranslateCost:" + paramString1);
        }
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubtitleTranslate", true, 0L, 0L, paramString2, null);
        aath.a(this.this$0, false);
        return;
        l1 = localaaum.mStartTime;
        break label460;
      }
      for (;;)
      {
        break label786;
        for (;;)
        {
          break;
          label751:
          if (l1 > paramLong) {
            l1 = paramLong;
          }
        }
        paramLong = l1;
        if (l1 >= 0L) {
          break;
        }
        paramLong = 0L;
        break;
        label776:
        if (paramLong > l2) {
          paramLong = l2;
        }
      }
      label786:
      l2 = paramLong;
      if (paramLong <= l1) {
        l2 = 1000L + l1;
      }
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, alyj paramalyj)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onSessionOpen sessionid:" + paramLong + " combineNum:" + paramInt1 + " heratbeat:" + paramInt2 + ",endPoint = " + paramalyj);
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(aath.access$000(), 2, "TransContext is null");
        }
        return;
      }
      if (aath.a(this.this$0).mState != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(aath.access$000(), 2, "onSessionOpen state error:" + aath.a(this.this$0).mState);
        }
        return;
      }
    }
    if ((aath.a(this.this$0).ME != -1L) && (QLog.isColorLevel())) {
      QLog.d(aath.access$000(), 2, "onSessionOpen, old session not closed " + aath.a(this.this$0).ME);
    }
    aath.a(this.this$0).ME = paramLong;
    aath.a(this.this$0).ckd = paramInt1;
    aath.a(this.this$0).mState = 3;
    aath.a(this.this$0).jdField_a_of_type_Alyj = paramalyj;
    if (aath.a(this.this$0).bzE) {
      aath.b(this.this$0);
    }
    if (aath.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
      aath.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.ap(paramLong, paramInt1);
    }
    for (;;)
    {
      aath.a(this.this$0, aath.a(this.this$0), true, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(aath.access$000(), 2, "onSessionOpen encoderunnable error" + paramLong);
      }
    }
  }
  
  protected void am(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onSessionClose sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).ME != paramLong) {
        return;
      }
    }
    aath.a(this.this$0, false);
    aath.a(this.this$0).mState = 0;
    aath.c(this.this$0);
  }
  
  protected void an(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onSessionChanged sessionid:" + paramLong + " combinenum:" + paramInt);
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if ((aath.a(this.this$0).ME == paramLong) && (aath.a(this.this$0).ckd != paramInt))
      {
        aath.a(this.this$0).ckd = paramInt;
        if (aath.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
          aath.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.ap(paramLong, paramInt);
        }
      }
      return;
    }
  }
  
  protected void ao(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onSessionError sessionid:" + paramLong + " result:" + paramInt);
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if ((aath.a(this.this$0).ME != -1L) && (aath.a(this.this$0).ME != paramLong)) {
        return;
      }
    }
    if ((aath.a(this.this$0).ME != paramLong) && (aath.a(this.this$0).mListenerRef == null)) {
      return;
    }
    aath.a(this.this$0).mState = 0;
    aath.c(this.this$0);
    aath.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatj
 * JD-Core Version:    0.7.0.1
 */