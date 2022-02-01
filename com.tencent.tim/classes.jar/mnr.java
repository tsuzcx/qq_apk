import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class mnr
  implements ncf.b
{
  mnr(mnq parammnq, UgcVideo paramUgcVideo) {}
  
  public void O(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.CompressVideoTaskStep", 2, "onCompressProgress, progress=" + paramFloat);
    }
    if (!mnq.a(this.a))
    {
      if (paramFloat > this.b.compressProgress) {
        this.b.compressProgress = ((int)paramFloat);
      }
      if (mnq.a(this.a) != null) {
        mnq.a(this.a).a(1, true, false, null);
      }
    }
  }
  
  public void a(int paramInt, String paramString, nch paramnch)
  {
    ThreadManagerV2.excute(new CompressVideoTaskStep.1.1(this, paramInt, paramString, paramnch), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnr
 * JD-Core Version:    0.7.0.1
 */