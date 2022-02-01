import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTips.1;
import com.tencent.av.business.manager.pendant.EffectPendantTips.2;
import com.tencent.av.business.manager.pendant.EffectPendantTips.3;
import com.tencent.av.business.manager.pendant.EffectPendantTips.4;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;

public class ikk
{
  public static int aoe = 100;
  Handler D;
  boolean RW;
  private VideoAppInterface mApp;
  private Context mContext;
  SparseIntArray z;
  
  public ikk(Context paramContext)
  {
    this.mContext = paramContext;
    this.D = new Handler(Looper.getMainLooper());
    this.RW = paramContext.getSharedPreferences("effects_face_file", 4).getBoolean("key_frist_use_Face" + VideoController.a().a().getCurrentAccountUin(), false);
    this.z = new SparseIntArray();
    this.z.put(PTFaceAttr.PTExpression.MOUTH_OPEN.value, 2131697660);
    this.z.put(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value, 2131697658);
    this.z.put(PTFaceAttr.PTExpression.BLINK.value, 2131697657);
    this.z.put(PTFaceAttr.PTExpression.HEAD_SHAKE.value, 2131697661);
    this.z.put(PTFaceAttr.PTExpression.KISS.value, 2131697659);
    this.z.put(aoe, 2131697648);
  }
  
  public String c(Context paramContext, int paramInt)
  {
    Integer localInteger = Integer.valueOf(this.z.get(paramInt));
    if (localInteger.intValue() > 0) {
      return paramContext.getResources().getString(localInteger.intValue());
    }
    return null;
  }
  
  public void d(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void e(Drawable paramDrawable, String paramString)
  {
    this.D.post(new EffectPendantTips.2(this, paramString, paramDrawable));
  }
  
  public void iY(String paramString)
  {
    this.D.post(new EffectPendantTips.1(this, paramString));
  }
  
  public void kN(int paramInt)
  {
    kO(paramInt);
  }
  
  public void kO(int paramInt)
  {
    this.D.post(new EffectPendantTips.3(this, paramInt));
  }
  
  public void kP(int paramInt)
  {
    this.D.postDelayed(new EffectPendantTips.4(this), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikk
 * JD-Core Version:    0.7.0.1
 */