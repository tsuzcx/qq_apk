import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class ipj
{
  private String PN;
  private boolean TT;
  private boolean TU;
  public ikk a;
  private Map<String, Drawable> dc = new HashMap();
  
  public void a(iow paramiow, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (4 == paramiow.lp())
    {
      iF(false);
      return;
    }
    if ((paramInt > 0) || (!paramBoolean2))
    {
      apo();
      if (paramBoolean1)
      {
        paramiow = GestureMgrRecognize.getInstance().getGestureInfo();
        if ((!paramiow.vaild) || (!paramiow.type.equals(paramString2)))
        {
          aZ(paramString1, paramString2);
          return;
        }
        iF(true);
        return;
      }
      iF(false);
      return;
    }
    iF(false);
    apn();
  }
  
  public void aY(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsInfo", 1, "setGestureType[" + paramString1 + "], GestureTips[" + this.PN + "->" + paramString2 + "]");
    }
    this.PN = paramString2;
  }
  
  public void aZ(String paramString1, String paramString2)
  {
    if (!vd()) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.equals(this.PN, paramString2));
      igd.aJ("TipsInfo", "showGestureTips showGestureTips mHasGestureTipsShow[" + this.TT + "]");
      if (this.TT)
      {
        this.a.iY(paramString1);
        aY("showGestureTips1", paramString2);
        return;
      }
    } while (!this.dc.containsKey(paramString2));
    Drawable localDrawable = (Drawable)this.dc.get(paramString2);
    this.a.e(localDrawable, paramString1);
    aY("showGestureTips2", paramString2);
  }
  
  public void apm()
  {
    this.dc.clear();
  }
  
  public void apn()
  {
    if (!vd()) {}
    while (this.TU) {
      return;
    }
    igd.aJ("TipsInfo", "processTips showfaceTips");
    this.a.kO(ikk.aoe);
    this.TU = true;
  }
  
  public void apo()
  {
    if (!this.TU) {
      return;
    }
    igd.aJ("TipsInfo", "processTips hideFaceTips");
    this.a.kP(0);
    this.TU = false;
  }
  
  public void cp(long paramLong)
  {
    iF(false);
    apo();
    aY("clearState_" + paramLong, null);
    this.TT = false;
  }
  
  public void iF(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TipsInfo", 1, "hideGestureTips, bGettureShown[" + paramBoolean + "], mCurGestureType[" + this.PN + "]");
    }
    if (this.PN == null) {
      return;
    }
    aY("hideGestureTips", null);
    if (paramBoolean) {
      this.TT = true;
    }
    this.a.kP(0);
  }
  
  public void js(String paramString)
  {
    Object localObject;
    if (!this.dc.containsKey(paramString))
    {
      if (!GestureFilterManager.sGestureType.equals("fivea")) {
        break label79;
      }
      localObject = VideoController.a().getAppContext().getResources().getDrawable(2130842984);
    }
    for (;;)
    {
      this.dc.put(paramString, localObject);
      igd.aL("TipsInfo", "ProcessGestureSDK pandentInfo.gestureType drawable insert, drawable" + String.valueOf(localObject));
      return;
      label79:
      if (GestureFilterManager.sGestureType.equals("palmup")) {
        localObject = VideoController.a().getAppContext().getResources().getDrawable(2130842985);
      } else if (GestureFilterManager.sGestureType.equals("qheart")) {
        localObject = VideoController.a().getAppContext().getResources().getDrawable(2130842986);
      } else {
        localObject = new BitmapDrawable(ahbj.B(anhx.getModelPath() + paramString + ".png"));
      }
    }
  }
  
  public boolean vd()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipj
 * JD-Core Version:    0.7.0.1
 */