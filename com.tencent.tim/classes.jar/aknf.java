import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.5.1;
import com.tencent.mobileqq.ocr.OcrControl.5.2;
import com.tencent.mobileqq.ocr.OcrControl.5.3;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class aknf
  implements adgp.a
{
  aknf(akne paramakne) {}
  
  public void a(int paramInt, String paramString, adhr paramadhr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "retCode:" + paramInt + ",sessionId:" + paramString + ",recogResult:" + paramadhr);
    }
    paramString = akne.a(this.this$0, paramString);
    long l = 0L;
    if (paramString != null) {
      l = System.currentTimeMillis() - paramString.Tb;
    }
    int k = -1;
    int m = -1;
    int i = m;
    int j = k;
    if (paramString != null)
    {
      i = m;
      j = k;
      if (paramString.a != null)
      {
        if ((paramInt != 0) || (paramadhr == null) || (paramadhr.a == null)) {
          break label282;
        }
        paramadhr = paramadhr.a;
        OcrRecogResult localOcrRecogResult = paramadhr.a();
        if (akne.a(this.this$0) != null) {
          akne.a(this.this$0).a(0, localOcrRecogResult, paramString.a.bsZ, l);
        }
        if ((localOcrRecogResult != null) && ((this.this$0.mFrom == 1) || (this.this$0.mFrom == 2))) {
          ThreadManager.postImmediately(new OcrControl.5.1(this, localOcrRecogResult, paramString), null, false);
        }
        if (paramadhr.a == null) {
          break label334;
        }
        i = paramadhr.a.cGS;
        j = paramadhr.a.errCode;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      for (;;)
      {
        ThreadManager.postImmediately(new OcrControl.5.2(this, paramString), null, false);
        ThreadManager.post(new OcrControl.5.3(this, j, i, paramInt), 5, null, false);
        return;
        label282:
        i = m;
        j = k;
        if (akne.a(this.this$0) != null)
        {
          akne.a(this.this$0).a(3, null, paramString.a.bsZ, l);
          i = m;
          j = k;
        }
      }
      label334:
      j = -1;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknf
 * JD-Core Version:    0.7.0.1
 */