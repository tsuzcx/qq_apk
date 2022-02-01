import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class msv
{
  private static msv jdField_a_of_type_Msv = new msv();
  private msu jdField_a_of_type_Msu;
  private msw jdField_a_of_type_Msw;
  private int aUk = -100;
  private boolean anR;
  private boolean anS;
  private boolean anT;
  private List<?> jB;
  private int mCurIndex = -100;
  private int mLastIndex = -100;
  private int mSceneType;
  private long wC = -1L;
  private long wD = -1L;
  private long wE = -1L;
  
  private int a(long paramLong, List<?> paramList)
  {
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (paramLong != Long.valueOf(((BaseArticleInfo)paramList.get(i)).mRecommendSeq).longValue()) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoBehaviorsReporter", 2, "findPositionInList(): seq = " + paramLong + ", posi=" + i);
      }
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static msv a()
  {
    return jdField_a_of_type_Msv;
  }
  
  private void aRO()
  {
    msu localmsu2 = this.jdField_a_of_type_Msu;
    msu localmsu1 = localmsu2;
    if (localmsu2 == null)
    {
      localmsu1 = new msu(this.mSceneType);
      this.jdField_a_of_type_Msu = localmsu1;
    }
    localmsu1.aUi = (this.mCurIndex - this.mLastIndex);
    localmsu1.aUj = (this.mLastIndex - this.aUk);
    localmsu1.eI = (this.wC - this.wD);
    localmsu1.anS = this.anS;
    localmsu1.anR = this.anR;
    this.anR = false;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviors(): " + localmsu1.toString());
    }
    kxm.f(BaseApplication.getContext(), kxm.getAccount(), true, localmsu1.u());
    this.jdField_a_of_type_Msu = null;
  }
  
  private void aRP()
  {
    msw localmsw = this.jdField_a_of_type_Msw;
    if ((localmsw == null) || (localmsw.isEmpty())) {
      return;
    }
    localmsw.mSceneType = this.mSceneType;
    localmsw.anS = this.anS;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviorsSeq(): " + localmsw.toString());
    }
    kxm.g(BaseApplication.getContext(), kxm.getAccount(), true, localmsw.u());
    this.jdField_a_of_type_Msw.clear();
  }
  
  public void a(ndi paramndi, List<?> paramList)
  {
    if (!this.anT) {}
    do
    {
      return;
      if (this.jB == null)
      {
        this.jB = paramList;
        if ((this.wE == -1L) && (this.jB != null) && (this.jB.size() > 0))
        {
          this.wE = ((BaseArticleInfo)this.jB.get(0)).mRecommendSeq;
          if (QLog.isColorLevel()) {
            QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 2,  mFirstVideoSeq = " + this.wE);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 1, mFirstVideoSeq = " + this.wE);
  }
  
  public void oe(boolean paramBoolean)
  {
    this.anT = paramBoolean;
  }
  
  public void of(boolean paramBoolean)
  {
    if (!this.anT) {
      return;
    }
    this.anR = paramBoolean;
  }
  
  public void reset()
  {
    aRP();
    this.anT = false;
    this.anS = false;
    this.mCurIndex = -100;
    this.mLastIndex = -100;
    this.aUk = -100;
    this.wE = -1L;
    this.jB = null;
    this.jdField_a_of_type_Msu = null;
    this.jdField_a_of_type_Msw = null;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    if (!this.anT) {}
    while (this.anS == paramBoolean) {
      return;
    }
    this.anS = paramBoolean;
  }
  
  public void setSceneType(int paramInt)
  {
    if (!this.anT) {
      return;
    }
    this.mSceneType = paramInt;
  }
  
  public void su(int paramInt)
  {
    if (!this.anT) {
      return;
    }
    long l1 = System.currentTimeMillis();
    label33:
    int i;
    if (this.mCurIndex == -100)
    {
      this.mCurIndex = paramInt;
      this.wC = SystemClock.uptimeMillis();
      if ((this.wD != -1L) && (this.wC - this.wD <= 500L)) {
        break label311;
      }
      if (this.aUk != -100) {
        aRO();
      }
      if (this.jdField_a_of_type_Msw == null) {
        this.jdField_a_of_type_Msw = new msw(this.mSceneType);
      }
      if (this.mSceneType != 0) {
        break label313;
      }
      if (this.wE == -1L) {
        break label326;
      }
      i = a(this.wE, this.jB);
      if (i == -1) {
        break label326;
      }
      i = paramInt - i;
    }
    for (;;)
    {
      if (i != -1000) {
        this.jdField_a_of_type_Msw.add(paramInt);
      }
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoBehaviorsReporter", 2, "onVideoPlay(): posi = " + paramInt + ", mCurIndex=" + this.mCurIndex + ", mLastIndex =" + this.mLastIndex + ", mBeforeLastIndex=" + this.aUk + ", seqIndexDiff = " + i + ", cost= " + (l2 - l1) + " ms");
      return;
      this.wD = this.wC;
      this.wC = SystemClock.uptimeMillis();
      if (this.mLastIndex == -100)
      {
        this.mLastIndex = this.mCurIndex;
        this.mCurIndex = paramInt;
        break label33;
      }
      this.aUk = this.mLastIndex;
      this.mLastIndex = this.mCurIndex;
      this.mCurIndex = paramInt;
      break label33;
      label311:
      break;
      label313:
      if (this.mSceneType == 2) {
        i = paramInt;
      } else {
        label326:
        i = -1000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msv
 * JD-Core Version:    0.7.0.1
 */