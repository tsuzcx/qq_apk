import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import java.util.List;

public class iqa
{
  private String TAG = "RefFrame-" + Integer.toHexString(hashCode());
  public List<iqa.a> fp;
  public Frame frame;
  private int ref;
  
  private iqa(Frame paramFrame)
  {
    this.frame = paramFrame;
  }
  
  private iqa(Frame paramFrame, List<iqa.a> paramList)
  {
    this.frame = paramFrame;
    this.fp = paramList;
  }
  
  public static iqa a(Frame paramFrame)
  {
    return new iqa(paramFrame);
  }
  
  public static iqa a(Frame paramFrame, List<iqa.a> paramList)
  {
    return new iqa(paramFrame, paramList);
  }
  
  private void clean()
  {
    this.frame.unlock();
  }
  
  public void lq(int paramInt)
  {
    this.ref += paramInt;
  }
  
  void unlock()
  {
    if (this.ref == 0)
    {
      clean();
      return;
    }
    unlock(1);
  }
  
  void unlock(int paramInt)
  {
    if (paramInt > this.ref) {
      Log.e(this.TAG, "unlock: count=" + paramInt + ", ref=" + this.ref);
    }
    do
    {
      return;
      this.ref -= paramInt;
    } while (this.ref != 0);
    clean();
  }
  
  public boolean ve()
  {
    return (this.fp != null) && (!this.fp.isEmpty());
  }
  
  public static class a
  {
    public List<TTFaceOriginDataModel> fo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqa
 * JD-Core Version:    0.7.0.1
 */