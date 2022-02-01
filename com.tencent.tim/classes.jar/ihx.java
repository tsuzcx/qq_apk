import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;

public final class ihx
  implements ihw.a
{
  public ihx(long paramLong1, int paramInt, ihw.a.a parama, igi.b paramb, VideoAppInterface paramVideoAppInterface, long paramLong2, ihw.a parama1) {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.val$begin;
    paramString2 = DeviceCapabilityExamination.a(this.amm, paramInt1, paramInt3, this.jdField_a_of_type_Ihw$a$a.MF, paramString1, paramInt2, l1 - l2);
    paramString2.amr = this.jdField_a_of_type_Igi$b.w;
    paramString2.ams = this.jdField_a_of_type_Igi$b.h;
    paramString2.amt = this.jdField_a_of_type_Igi$b.bitrate;
    paramString2.amu = this.jdField_a_of_type_Igi$b.fps;
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Ihw$a$a.sJ()) && (this.jdField_a_of_type_Igi$b.Ot)) {
      new jlt(this.b, this.kQ).a(this.jdField_a_of_type_Ihw$a$a.MI, new ihy(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    for (;;)
    {
      com.tencent.av.mediacodec.NativeCodec.printLog = false;
      return;
      paramString2.amv = -10000;
      DeviceCapabilityExamination.a(paramString2, this.amm, paramInt1);
      if (this.jdField_a_of_type_Ihw$a != null) {
        this.jdField_a_of_type_Ihw$a.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihx
 * JD-Core Version:    0.7.0.1
 */