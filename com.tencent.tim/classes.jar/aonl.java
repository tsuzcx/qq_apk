import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class aonl
  implements aolm.a
{
  aonl(aonk paramaonk) {}
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    label8:
    aoll localaoll;
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(paramaomg instanceof aoll));
          localaoll = (aoll)paramaomg;
          if (aonk.a(this.this$0))
          {
            File localFile = new File(paramaomg.mTempPath);
            if (paramaomh.apW == localFile.length())
            {
              paramaomh.apW = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + paramaomg.apS);
              }
            }
          }
          localaoll.apS += paramaomh.apW;
          if (0L != localaoll.apT) {
            break;
          }
          paramaomh.apW = 0L;
          paramaomg = "bytes=" + localaoll.apS + "-";
          localaoll.u.put("Range", paramaomg);
          paramaomg = localaoll.bZ;
        } while (!paramaomg.contains("range="));
        paramaomg = paramaomg.substring(0, paramaomg.lastIndexOf("range="));
        localaoll.bZ = (paramaomg + "range=" + localaoll.apS);
        return;
      } while ((localaoll.apS <= 0L) || (localaoll.apT <= 0L) || (localaoll.apS >= localaoll.apT));
      paramaomh.apW = 0L;
      paramaomg = "bytes=" + localaoll.apS + "-" + localaoll.apT;
      localaoll.u.put("Range", paramaomg);
      paramaomg = localaoll.bZ;
    } while (!paramaomg.contains("range="));
    paramaomg = paramaomg.substring(0, paramaomg.lastIndexOf("range="));
    localaoll.bZ = (paramaomg + "range=" + localaoll.apS + "-" + localaoll.apT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonl
 * JD-Core Version:    0.7.0.1
 */