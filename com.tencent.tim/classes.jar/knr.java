import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import org.json.JSONObject;

public class knr
{
  public static void a(VideoFeedsPlayManager.b paramb, Context paramContext, myi parammyi)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (parammyi.de() == 0L)
    {
      paramb.a.aSl = paramb.a.endPosition;
      paramb.a.endPosition = ((int)parammyi.getDuration());
      mht localmht = paramb.a;
      if (paramb.a.aSl != 0) {
        break label268;
      }
      bool1 = true;
      localmht.amz = bool1;
      paramb.a.amA = true;
      localmht = paramb.a;
      AdvertisementInfo localAdvertisementInfo = jzk.a(paramb.d.b);
      int k = localmht.aSl;
      int m = localmht.endPosition;
      if (!localmht.amz) {
        break label274;
      }
      i = 1;
      if (!localmht.amA) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = jzk.a(k, m, i, j, localmht.aSm, 1, 0, jzk.aGr, 0);
      jzk.a(new kku.a().a(paramContext).a(jzk.aEO).b(localmht.aSn).a(localAdvertisementInfo).a(paramb.d.b).a(localJSONObject).a());
      parammyi.aTT();
      paramb.a.aSl = 0;
      paramb.a.endPosition = 0;
      paramContext = paramb.a;
      if (paramb.a.aSl != 0) {
        break label285;
      }
    }
    label268:
    label274:
    label279:
    label285:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.amz = bool1;
      paramb.a.amA = false;
      return;
      paramb.a.aSl = ((int)parammyi.de());
      break;
      bool1 = false;
      break label57;
      i = 0;
      break label114;
      j = 0;
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knr
 * JD-Core Version:    0.7.0.1
 */