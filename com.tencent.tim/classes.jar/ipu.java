import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.model.SizeI;
import com.tencent.util.Pair;
import java.io.File;
import java.util.List;

public class ipu
{
  private final String TAG = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private ipw jdField_a_of_type_Ipw;
  private ipy jdField_a_of_type_Ipy;
  private ips jdField_b_of_type_Ips;
  private ipy jdField_b_of_type_Ipy;
  private Frame c;
  private final int height;
  private final int width;
  
  public ipu(int paramInt1, int paramInt2)
  {
    QLog.d(this.TAG, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
    this.jdField_a_of_type_Ipw = new ipw();
    this.jdField_a_of_type_Ipw.a(new ipv(this));
    this.jdField_a_of_type_Ipw.init();
    this.jdField_b_of_type_Ips = new ips(paramInt1, paramInt2);
    this.jdField_a_of_type_Ipw.a(this.jdField_b_of_type_Ips);
  }
  
  private ipy a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.TAG, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    ipx localipx = new ipx(this.width, this.height);
    QLog.d(this.TAG, 1, "createCompositeFilter: create filter#" + Integer.toHexString(localipx.hashCode()));
    localipx.jt(paramString);
    return localipx;
  }
  
  private ipy b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.TAG, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    ipr localipr = new ipr();
    QLog.d(this.TAG, 1, "createDecorateFilter: create filter#" + Integer.toHexString(localipr.hashCode()));
    localipr.jt(paramString);
    return localipr;
  }
  
  private void bA(List<ipw.a> paramList)
  {
    if ((this.jdField_a_of_type_Ipy == null) || (!(this.jdField_a_of_type_Ipy instanceof ipx))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((ipx)this.jdField_a_of_type_Ipy).a();
      f1 = this.width / ((SizeI)localObject).width;
      localObject = ((ipx)this.jdField_a_of_type_Ipy).ak();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    ipw.a locala;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      locala = (ipw.a)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + locala.width + ", " + locala.arQ + "), (" + locala.arR + ", " + locala.arS + ")");
      }
      if ((locala.fo != null) && (locala.arS != 0) && (locala.arR != 0)) {
        break label234;
      }
    }
    for (;;)
    {
      i += 1;
      break label74;
      break;
      label234:
      int j = 0;
      while (j < locala.fo.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / locala.arR, ((RectF)localPair.first).height() / locala.arS);
        locala.fo.set(j, ipt.a((TTFaceOriginDataModel)locala.fo.get(j), new RectF(0.0F, 0.0F, locala.arR, locala.arS), (RectF)localPair.first, (Matrix)localPair.second, f1, locala.Tt));
        locala.arR = ((int)(locala.arR * f2));
        locala.arS = ((int)(locala.arS * f2));
        j += 1;
      }
      if (locala.Tt)
      {
        j = 0;
        while (j < locala.fo.size())
        {
          ipt.a((TTFaceOriginDataModel)locala.fo.get(j));
          j += 1;
        }
      }
    }
  }
  
  public Frame b(List<ipw.a> paramList, long paramLong)
  {
    bA(paramList);
    this.jdField_a_of_type_Ipw.a(paramList, paramLong);
    paramList = this.c;
    this.c = null;
    return paramList;
  }
  
  public void destroy()
  {
    QLog.d(this.TAG, 1, "destroy: ");
    if (this.jdField_a_of_type_Ipw != null)
    {
      this.jdField_a_of_type_Ipw.destroy();
      QLog.d(this.TAG, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_Ipw.hashCode()));
      this.jdField_a_of_type_Ipw = null;
    }
    if (this.jdField_b_of_type_Ips != null)
    {
      this.jdField_b_of_type_Ips.destroy();
      QLog.d(this.TAG, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Ips.hashCode()));
      this.jdField_b_of_type_Ips = null;
    }
    if (this.jdField_a_of_type_Ipy != null)
    {
      this.jdField_a_of_type_Ipy.destroy();
      QLog.d(this.TAG, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_Ipy.hashCode()));
      this.jdField_a_of_type_Ipy = null;
    }
    if (this.jdField_b_of_type_Ipy != null)
    {
      this.jdField_b_of_type_Ipy.destroy();
      QLog.d(this.TAG, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_Ipy.hashCode()));
      this.jdField_b_of_type_Ipy = null;
    }
  }
  
  public void jt(String paramString)
  {
    QLog.d(this.TAG, 1, "applyMaterial: " + paramString);
    ipy localipy = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = localipy;
    if (localipy == null) {
      localObject = this.jdField_b_of_type_Ips;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_Ipw.apr();
    if ((this.jdField_a_of_type_Ipy != null) && (this.jdField_a_of_type_Ipy != this.jdField_b_of_type_Ips))
    {
      this.jdField_a_of_type_Ipy.a().destroy();
      QLog.d(this.TAG, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_Ipy.hashCode()));
    }
    this.jdField_a_of_type_Ipw.a((ipy)localObject);
    this.jdField_a_of_type_Ipy = ((ipy)localObject);
    if (this.jdField_b_of_type_Ipy != null)
    {
      this.jdField_b_of_type_Ipy.a().destroy();
      QLog.d(this.TAG, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_Ipy.hashCode()));
    }
    if (paramString != null) {
      ((ipy)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_Ipy = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipu
 * JD-Core Version:    0.7.0.1
 */