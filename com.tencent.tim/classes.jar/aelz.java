import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class aelz
  extends aehv<aely>
{
  @NonNull
  public aely a(int paramInt)
  {
    return new aely();
  }
  
  public void a(aely paramaely)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramaely.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramaely.bzy)) {
      akxo.Q("flowCombination", paramaely.bzy, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramaely.bzz)) {
      akxo.Q("troopCombination", paramaely.bzz, true);
    }
    if (paramaely.Ws > 0L) {
      akxo.m("maxRequest", paramaely.Ws, true);
    }
    if ((paramaely.Wm == 0L) || (paramaely.Wm == 1L)) {
      if (paramaely.Wm != 1L) {
        break label447;
      }
    }
    label447:
    for (boolean bool1 = true;; bool1 = false)
    {
      akxo.o("PicPreDownSwitch", bool1, true);
      if ((paramaely.Wn == 0L) || (paramaely.Wn == 1L) || (paramaely.Wn == 2L) || (paramaely.Wn == 3L)) {
        akxo.m("PicAuDownTimePoint", paramaely.Wn, true);
      }
      if (paramaely.Wo > 0L) {
        akxo.m("MaxWifiFlow", paramaely.Wo, true);
      }
      if (paramaely.Wp > 0L) {
        akxo.m("Max4GFlow", paramaely.Wp, true);
      }
      if (paramaely.Wq > 0L) {
        akxo.m("Max3GFlow", paramaely.Wq, true);
      }
      if (paramaely.Wr > 0L) {
        akxo.m("Max2GFlow", paramaely.Wr, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramaely.bzA)) {
        akxo.m("xGPreDownPolicy", Long.valueOf(paramaely.bzA, 16).longValue(), true);
      }
      if (paramaely.Wt > 0L) {
        akxo.m("AFBFlowHitXG", paramaely.Wt, true);
      }
      if (paramaely.Wu > 0L) {
        akxo.m("AFBFlowMissXG", paramaely.Wu, true);
      }
      if (paramaely.Wv > 0L) {
        akxo.m("APicAvgSize", paramaely.Wv, true);
      }
      if (paramaely.Ww > 0L) {
        akxo.m("APicMaxSize", paramaely.Ww, true);
      }
      if ((paramaely.Wx == 0L) || (paramaely.Wx == 1L))
      {
        bool1 = bool2;
        if (paramaely.Wx == 1L) {
          bool1 = true;
        }
        akxo.o("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramaely.bzB)) {
        akxo.Q("PeakFlowTimePeriod", paramaely.bzB, true);
      }
      if (paramaely.Wy > 0L) {
        akxo.m("PeakFlowMaxPicSize", paramaely.Wy, true);
      }
      return;
    }
  }
  
  @Nullable
  public aely b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0) {
        localObject1 = aely.a(paramArrayOfaeic);
      }
    }
    return localObject1;
  }
  
  public Class<aely> clazz()
  {
    return aely.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelz
 * JD-Core Version:    0.7.0.1
 */