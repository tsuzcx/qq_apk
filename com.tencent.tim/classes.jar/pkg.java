import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class pkg
  implements ppv.b<pkh, pkh.a>
{
  private pkg.a a;
  private HashMap<String, pkc> fc;
  
  public void a(pkg.a parama)
  {
    this.a = parama;
  }
  
  public void a(@NonNull pkh parampkh, @Nullable pkh.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((parama == null) || (paramErrorMessage.isFail())) {
      if (this.a != null) {
        this.a.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      parampkh = new ArrayList();
      if ((parama.lY != null) && (parama.lY.size() > 0))
      {
        parama = parama.lY.iterator();
        for (;;)
        {
          if (!parama.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)parama.next();
          Iterator localIterator = this.fc.entrySet().iterator();
          if (localIterator.hasNext())
          {
            pkc localpkc = (pkc)((Map.Entry)localIterator.next()).getValue();
            if (localpkc.a == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localpkc.a.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            parampkh.add(localpkc.geohashString);
          }
        }
      }
    } while (this.a == null);
    this.a.a(paramErrorMessage, parampkh);
  }
  
  public void sendRequest()
  {
    if ((this.fc == null) || (this.fc.size() == 0)) {
      if (this.a != null) {
        this.a.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = pju.a(this.fc);
      if (localList.size() != 0) {
        break;
      }
    } while (this.a == null);
    this.a.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.fc.toString()), null);
    return;
    pkh localpkh = new pkh();
    localpkh.dO(localList);
    ppv.a().a(localpkh, this);
  }
  
  public void t(@NonNull HashMap<String, pkc> paramHashMap)
  {
    this.fc = paramHashMap;
  }
  
  public static abstract interface a
  {
    public abstract void a(ErrorMessage paramErrorMessage, List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkg
 * JD-Core Version:    0.7.0.1
 */