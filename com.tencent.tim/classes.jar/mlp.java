import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class mlp
  implements mlt
{
  private static float jE = 0.8F;
  private mlh jdField_a_of_type_Mlh;
  private mls jdField_a_of_type_Mls;
  private mlw jdField_a_of_type_Mlw;
  private mlz jdField_a_of_type_Mlz;
  private Activity activity;
  private float jF;
  private List<mlu> jm = new ArrayList();
  private List<mlu> jn = new ArrayList();
  private String outputPath;
  private String path;
  private int previewHeight;
  private int previewWidth;
  
  public mlp(Activity paramActivity, Bundle paramBundle, mlh parammlh)
  {
    this.activity = paramActivity;
    this.jdField_a_of_type_Mlh = parammlh;
    aG(paramBundle);
    this.jdField_a_of_type_Mlw = new mmb();
    this.jdField_a_of_type_Mlw.a(this);
    this.jdField_a_of_type_Mls = new mls();
    this.jdField_a_of_type_Mlz = new mlz(this.jdField_a_of_type_Mlw);
    this.jdField_a_of_type_Mls.a(new mlq(this, parammlh));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<mlu> paramList)
  {
    mlu localmlu = new mlu(1, this.path, paramInt1, paramInt2, paramInt3, new mlp.a(paramList.size()));
    this.jdField_a_of_type_Mlz.d(localmlu);
    paramList.add(localmlu);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.outputPath = (aoop.aW + File.separator + aoiz.getFileName(new StringBuilder().append(this.path).append("-").append(paramInt).toString()));
    new mpv(paramBitmap, this.outputPath).startDownload();
  }
  
  private void aG(Bundle paramBundle)
  {
    this.path = paramBundle.getString("ARG_VIDEO_URL");
    this.jF = paramBundle.getFloat("ARG_INITIAL_PROGRESS");
  }
  
  private void aPW()
  {
    int j = this.jdField_a_of_type_Mlh.px();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_Mlw.getVideoDuration() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.previewWidth, this.previewHeight, this.jm);
      i += 1;
    }
    this.jdField_a_of_type_Mlh.cM(this.jm);
  }
  
  private void cT(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.previewWidth = ((int)(this.jdField_a_of_type_Mlh.py() * jE));
      this.previewHeight = (this.previewWidth * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_Mlh.py() * jE);
      this.previewHeight = paramInt1;
      this.previewWidth = paramInt1;
      return;
      this.previewHeight = ((int)(this.jdField_a_of_type_Mlh.py() * jE));
      this.previewWidth = (this.previewHeight * paramInt1 / paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    cT(paramInt1, paramInt2);
    aPW();
    this.jdField_a_of_type_Mlh.eF(this.jdField_a_of_type_Mlw.getVideoDuration());
  }
  
  public void a(mll parammll)
  {
    parammll.nG(this.outputPath);
  }
  
  public void aPU()
  {
    this.jdField_a_of_type_Mls.a(this.path, this.jdField_a_of_type_Mlh.l(), new mlr(this));
    this.jdField_a_of_type_Mlw.a(this.path, null);
  }
  
  public void aPV()
  {
    this.jdField_a_of_type_Mlh.cN(this.jm);
  }
  
  public void cS(int paramInt1, int paramInt2)
  {
    this.jn.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Mlh.px())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.aXG + paramInt1;
      a(j, this.previewWidth, this.previewHeight, this.jn);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_Mlh.cN(this.jn);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Mls.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Mls.onResume();
  }
  
  public void rY(int paramInt)
  {
    this.jdField_a_of_type_Mls.rY(paramInt);
  }
  
  public void release()
  {
    this.jdField_a_of_type_Mlz.stop();
    this.jdField_a_of_type_Mls.stop();
  }
  
  class a
    implements mlu.a
  {
    int aTF = -1;
    
    public a(int paramInt)
    {
      this.aTF = paramInt;
    }
    
    public void a(Bitmap paramBitmap, mlu parammlu)
    {
      mlp.a(mlp.this).rV(this.aTF);
    }
    
    public void aPX() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlp
 * JD-Core Version:    0.7.0.1
 */